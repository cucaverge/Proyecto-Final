package com.coderhouse.clase11.ApiRest.PostmanII.repository;

import com.coderhouse.clase11.ApiRest.PostmanII.model.Invoice;
import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    // Consulta utilizando JPQL para obtener facturas por ID de cliente
    @Query("SELECT new com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDTO(" +
            "i.id as invoice_id, " +
            "i.created_at, " +
            "i.total" +
            ") FROM Invoice i INNER JOIN i.client c WHERE c.id = :id")
    List<InvoiceDTO> getInvoicesByClientById(@Param("id") int id);

}