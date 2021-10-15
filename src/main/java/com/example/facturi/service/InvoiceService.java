package com.example.facturi.service;

import com.example.facturi.model.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice saveInvoice(Invoice invoice);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(int id);

    Invoice updateInvoice(Invoice invoice, int id);

    void deleteInvoice(int id);
}
