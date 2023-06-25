package com.coderhouse.clase11.ApiRest.PostmanII.model;

public class InvoiceDTO {
    private int invoiceId;
    private String createdAt;
    private double total;

    // Constructor con parámetros
    public InvoiceDTO(int invoiceId, String createdAt, double total) {
        this.invoiceId = invoiceId;
        this.createdAt = createdAt;
        this.total = total;
    }

    // Métodos getters y setters

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "invoiceId=" + invoiceId +
                ", createdAt='" + createdAt + '\'' +
                ", total=" + total +
                '}';
    }
}