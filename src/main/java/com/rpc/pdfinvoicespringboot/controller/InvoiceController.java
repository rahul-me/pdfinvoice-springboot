package com.rpc.pdfinvoicespringboot.controller;

import com.rpc.pdfinvoicespringboot.dto.InvoiceDto;
import com.rpc.pdfinvoicespringboot.model.Invoice;
import com.rpc.pdfinvoicespringboot.service.InvoiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public Iterable<Invoice> getAll() {
        return invoiceService.findAll();
    }

    @PostMapping
    public Invoice add( @RequestBody InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
