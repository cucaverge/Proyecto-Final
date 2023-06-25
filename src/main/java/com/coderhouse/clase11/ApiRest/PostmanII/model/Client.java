package com.coderhouse.clase11.ApiRest.PostmanII.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true)
    private String docnumber;

    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices;

    // RESTO DE LOS MÉTODOS

    /**
     * Obtiene la lista de facturas asociadas al cliente.
     *
     * @return Lista de facturas.
     */
    public List<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Establece la lista de facturas asociadas al cliente.
     *
     * @param invoices Lista de facturas.
     */
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    /**
     * Obtiene el ID del cliente.
     *
     * @return ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     *
     * @param id ID del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param name Nombre del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el apellido del cliente.
     *
     * @return Apellido del cliente.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param lastname Apellido del cliente.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Obtiene el número de documento del cliente.
     *
     * @return Número de documento del cliente.
     */
    public String getDocnumber() {
        return docnumber;
    }

    /**
     * Establece el número de documento del cliente.
     *
     * @param docnumber Número de documento del cliente.
     */
    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                '}';
    }
}