package com.rpc.pdfinvoicespringboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Table("invoice")
public class Invoice {

    @Column("userid")
    private String userId;

    @Column("pdfurl")
    private String pdfUrl;

    @Column("amount")
    private Integer amount;

    @Id
    private Integer id;
}
