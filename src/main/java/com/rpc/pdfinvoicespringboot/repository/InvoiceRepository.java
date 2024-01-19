package com.rpc.pdfinvoicespringboot.repository;

import com.rpc.pdfinvoicespringboot.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, String> {


}
