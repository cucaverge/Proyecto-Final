package com.coderhouse.clase11.ApiRest.PostmanII.controller;

import com.coderhouse.clase11.ApiRest.PostmanII.middleware.ResponseHandler;
import com.coderhouse.clase11.ApiRest.PostmanII.model.InvoiceDetail;
import com.coderhouse.clase11.ApiRest.PostmanII.model.Product;
import com.coderhouse.clase11.ApiRest.PostmanII.service.InvoiceDetailService;
import com.coderhouse.clase11.ApiRest.PostmanII.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;


    // Método auxiliar para verificar si una cadena es numérica
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9\\.]+");
    }


    // Endpoint para obtener un producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable("id") Long id) {
        try {
            Product product = productService.getProductById(id);
            if (product == null) {
                return ResponseHandler.generateResponse(
                        "No se encontró el producto con el ID proporcionado",
                        HttpStatus.NOT_FOUND,
                        null
                );
            }
            return ResponseHandler.generateResponse(
                    "Producto obtenido exitosamente",
                    HttpStatus.OK,
                    product
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


    // Endpoint para crear un producto
    @PostMapping
    public ResponseEntity<Object> postProduct(@RequestBody Product product) {
        try {
            System.out.println(product);
            // Validaciones de los campos del producto
            if (product.getTittle() == null || product.getTittle().isEmpty()) {
                return ResponseHandler.generateResponse(
                        "El título no puede estar vacío",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(product.getTittle())) {
                return ResponseHandler.generateResponse(
                        "El título debe ser una cadena de texto",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (product.getDescription() == null || product.getDescription() == "") {
                return ResponseHandler.generateResponse(
                        "La descripción no puede estar vacia",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(product.getDescription())) {
                return ResponseHandler.generateResponse(
                        "La descripción debe ser una cadena de texto",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (product.getCode() == null || product.getCode() == "") {
                return ResponseHandler.generateResponse(
                        "El código no puede estar vacio",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (product.getPrice() == 0) {
                return ResponseHandler.generateResponse(
                        "El precio no puede estar vacio",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(Double.toString(product.getPrice()))) {
                double price = Double.parseDouble(Double.toString(product.getPrice()));
                if (price < 0) {
                    return ResponseHandler.generateResponse(
                            "El precio debe ser un número válido mayor o igual a cero",
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null
                    );
                }
            } else {
                return ResponseHandler.generateResponse(
                        "El precio debe ser un número válido",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null
                );
            }

            if (product.getStock() == 0) {
                return ResponseHandler.generateResponse(
                        "El stock no puede estar vacio",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null);
            }
            if (isNumeric(Integer.toString(product.getStock()))) {
                int stock = Integer.parseInt(Integer.toString(product.getStock()));
                if (stock < 0) {
                    return ResponseHandler.generateResponse(
                            "El stock debe ser un número válido mayor o igual a cero",
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            null
                    );
                }
            } else {
                return ResponseHandler.generateResponse(
                        "El stock debe ser un número válido",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null
                );
            }

            // Guardar el producto en la base de datos
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Data retrieved successfully",
                    HttpStatus.OK,
                    productSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }


    // Endpoint para actualizar un producto por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Object> putProduct(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        try {
            // Actualizar el producto según su ID
            // Utiliza el parámetro 'id' para identificar el producto que se actualizará

            Product existingProduct = productService.getProductById(id);
            if (existingProduct == null) {
                return ResponseHandler.generateResponse(
                        "No se encontró el producto con el ID proporcionado",
                        HttpStatus.NOT_FOUND,
                        null
                );
            }
            existingProduct.setTittle(updatedProduct.getTittle());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCode(updatedProduct.getCode());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setStock(updatedProduct.getStock());

            // Guardar los cambios actualizados en la base de datos
            Product updatedExistingProduct = productService.updateProduct(existingProduct);
            return ResponseHandler.generateResponse(
                    "Producto actualizado exitosamente",
                    HttpStatus.OK,
                    updatedExistingProduct
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }



    // Endpoint para eliminar un producto por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        try {
            // Verificar si el producto existe
            Product existingProduct = productService.getProductById(id);
            if (existingProduct == null) {
                return ResponseHandler.generateResponse(
                        "No se encontró el producto con el ID proporcionado",
                        HttpStatus.NOT_FOUND,
                        null
                );
            }

            // Verificar si hay referencias en invoice_detail
            List<InvoiceDetail> invoiceDetails = invoiceDetailService.getInvoiceDetailsByProduct(existingProduct);
            if (!invoiceDetails.isEmpty()) {
                // Si hay referencias en invoice_detail, eliminarlos primero
                for (InvoiceDetail invoiceDetail : invoiceDetails) {
                    invoiceDetailService.deleteInvoiceDetail(invoiceDetail);
                }
            }

            // Eliminar el producto
            boolean deleted = productService.deleteProduct(id);
            if (deleted) {
                return ResponseHandler.generateResponse(
                        "Producto eliminado exitosamente",
                        HttpStatus.OK,
                        null
                );
            } else {
                return ResponseHandler.generateResponse(
                        "No se pudo eliminar el producto",
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        null
                );
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}