package com.coderhouse.clase11.ApiRest.PostmanII.model;

public class InvoiceDetailDTE {
    private double price;
    private int quantity;

    // Constructor por defecto
    public InvoiceDetailDTE() {
    }

    // Constructor con parámetros
    public InvoiceDetailDTE(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    // Métodos getters y setters

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}