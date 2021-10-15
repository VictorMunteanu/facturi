package com.example.facturi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "produse")
    private String produse;

    @Column(name = "pretUnitate")
    private Integer pretUnitate;

    @Column(name = "nrUnitatiProcurate")
    private Integer nrUnitatiProcurate;

    @Column(name = "pretTotal")
    private Integer pretTotal;

}
