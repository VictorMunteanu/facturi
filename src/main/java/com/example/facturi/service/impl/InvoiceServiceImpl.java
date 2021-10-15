package com.example.facturi.service.impl;

import com.example.facturi.exception.ResourceNotFoundException;
import com.example.facturi.model.Invoice;
import com.example.facturi.repository.InvoiceRepository;
import com.example.facturi.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Optional<Invoice> question = invoiceRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new ResourceNotFoundException("Id", "Invoice", id);
        }
    }

    @Override
    public Invoice updateInvoice(Invoice invoice, int id) {
        Invoice existingInvoice = invoiceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Invoice", "ID", id)
        );
        existingInvoice.setProduse(existingInvoice.getProduse());
        existingInvoice.setPretUnitate(existingInvoice.getPretUnitate());
        existingInvoice.setNrUnitatiProcurate(existingInvoice.getNrUnitatiProcurate());
        existingInvoice.setPretTotal(existingInvoice.getPretTotal());
        invoiceRepository.save(existingInvoice);
        return existingInvoice;
    }

    @Override
    public void deleteInvoice(int id) {
        invoiceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice", "ID", id));
        invoiceRepository.deleteById(id);
    }
}
