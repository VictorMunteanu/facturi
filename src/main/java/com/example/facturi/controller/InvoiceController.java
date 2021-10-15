package com.example.facturi.controller;

import com.example.facturi.repository.InvoiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InvoiceController {

    @GetMapping("/invoices")
    public String getInvoice(Model model) {
        return "invoices";
    }

    @GetMapping("/invoices/{id}")
    public String getInvoice(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "invoice";
    }
}
