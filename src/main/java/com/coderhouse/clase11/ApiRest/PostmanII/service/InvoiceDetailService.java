package com.coderhouse.clase11.ApiRest.PostmanII.service;

import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetail;
import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetailDTO;
import com.coderhouse.clase11.ApiRest.PostmanII.model.Product;
import com.coderhouse.clase11.ApiRest.PostmanII.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public void deleteInvoiceDetail(InvoiceDetail invoiceDetail) {
        // Eliminar el detalle de la factura
        invoiceDetailRepository.delete(invoiceDetail);
    }

    public void saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        // Guardar el detalle de la factura
        invoiceDetailRepository.save(invoiceDetail);
    }

    public List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(int invoiceId) {
        // Obtener los detalles de la factura por ID de factura
        return invoiceDetailRepository.getInvoiceDetailsByInvoiceId(invoiceId);
    }

    public List<InvoiceDetail> getInvoiceDetailsByProduct(Product product) {
        // Obtener los detalles de la factura por producto
        return invoiceDetailRepository.findByProduct(product);
    }
}