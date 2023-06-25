package com.coderhouse.clase11.ApiRest.PostmanII.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetails;

    private String created_at;

    private double total;

    //Resto de los métodos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // Getter y Setter para el campo client
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    // Getter y Setter para el campo created_at
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }


    // Getter y Setter para el campo total
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    // Getter y Setter para el campo invoiceDetails
    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }


    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client=" + client +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                '}';
    }
}
