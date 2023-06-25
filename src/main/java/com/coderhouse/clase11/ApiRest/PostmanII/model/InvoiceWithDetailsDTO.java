package com.coderhouse.clase11.ApiRest.PostmanII.model;

import java.util.List;

public class InvoiceWithDetailsDTO {
    private int invoiceId;
    private int clientId;
    private String createdAt;
    private double total;
    private List<InvoiceDetailDTO> details;

    // Constructor con parámetros
    public InvoiceWithDetailsDTO(int invoiceId, int clientId, String createdAt, double total, List<InvoiceDetailDTO> details) {
        this.invoiceId = invoiceId;
        this.clientId = clientId;
        this.createdAt = createdAt;
        this.total = total;
        this.details = details;
    }

    // Métodos getters y setters

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailDTO> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "InvoiceWithDetailsDTO{" +
                "invoiceId=" + invoiceId +
                ", clientId=" + clientId +
                ", createdAt='" + createdAt + '\'' +
                ", total=" + total +
                ", details=" + details +
                '}';
    }
}