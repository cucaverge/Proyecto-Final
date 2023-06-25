package com.coderhouse.clase11.ApiRest.PostmanII.model;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_detail")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private double price;
    private int quantity;

    // Resto de los métodos

    /**
     * Obtiene el ID del detalle de la factura.
     *
     * @return ID del detalle de la factura.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del detalle de la factura.
     *
     * @param id ID del detalle de la factura.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la factura asociada al detalle.
     *
     * @return Factura asociada al detalle.
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * Establece la factura asociada al detalle.
     *
     * @param invoice Factura asociada al detalle.
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Obtiene el producto asociado al detalle.
     *
     * @return Producto asociado al detalle.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto asociado al detalle.
     *
     * @param product Producto asociado al detalle.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtiene el precio del detalle.
     *
     * @return Precio del detalle.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Establece el precio del detalle.
     *
     * @param price Precio del detalle.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Obtiene la cantidad del detalle.
     *
     * @return Cantidad del detalle.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Establece la cantidad del detalle.
     *
     * @param quantity Cantidad del detalle.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}