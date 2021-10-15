package com.example.facturi.controller;

import com.example.facturi.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("/invoices")
    public String getInvoice(Model model) {
        model.addAttribute("invoice", invoiceRepository.findAll());
        return "invoices";
    }

    @GetMapping("/invoices/{id}")
    public String getInvoice(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "invoice";
    }
}
