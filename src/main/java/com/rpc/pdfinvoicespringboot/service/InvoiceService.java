package com.rpc.pdfinvoicespringboot.service;

import com.rpc.pdfinvoicespringboot.model.Invoice;
import com.rpc.pdfinvoicespringboot.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class InvoiceService {

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService;
    private final String cdnUrl;

    private final RowMapper<Invoice> invoiceRowMapper = (rs, no) -> {
        return Invoice.builder()
                .id(rs.getInt("id"))
                .userId(rs.getString("userid"))
                .pdfUrl(rs.getString("pdfurl"))
                .amount(rs.getInt("amount"))
                .build();
    };

    public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl, JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.cdnUrl = cdnUrl;
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void init() {
        System.out.println("Fetching PDF Template from S3...");
        // TODO download from s3 and save locally
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Deleting downloaded templates...");
        // TODO actual deletion of PDFs
    }

    @Transactional
    public List<Invoice> findAll() {

        List<Invoice> invoices = jdbcTemplate.query("select * from invoice", invoiceRowMapper);
        return invoices;
    }

    @Transactional
    public Invoice create(String userId, int amount) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update( con -> {
            PreparedStatement ps = con.prepareStatement("insert into invoice (pdfurl, userid, amount) values (?,?,?)", new String[] {"id"});
            ps.setString(1, "http://www.africau.edu/images/default/sample.pdf");
            ps.setString(2, userId);
            ps.setInt(3, amount);
            return ps;
        }, keyHolder);

        var invoice = Invoice.builder()
                .id(Objects.requireNonNull(keyHolder.getKey()).intValue())
                .userId(userId)
                .amount(amount)
                .pdfUrl("http://www.africau.edu/images/default/sample.pdf")
                .build();

        return invoice;
    }
}
