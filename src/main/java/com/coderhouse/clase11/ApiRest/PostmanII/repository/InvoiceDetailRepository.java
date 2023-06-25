package com.coderhouse.clase11.ApiRest.PostmanII.repository;

import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetail;
import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetailDTO;
import com.coderhouse.clase11.ApiRest.PostmanII.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {

    // Consulta utilizando JPQL para obtener detalles de factura por ID de factura
    @Query("SELECT new com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetailDTO(" +
            "p.tittle, " +
            "p.description, " +
            "p.code, " +
            "d.price, " +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetails d JOIN d.product p WHERE i.id = :id")
    List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoice_id);

    // Consulta utilizando JPQL para encontrar detalles de factura por producto
    @Query("SELECT id FROM InvoiceDetail id WHERE id.product = :product")
    List<InvoiceDetail> findByProduct(@Param("product") Product product);
}