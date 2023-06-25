package com.coderhouse.clase11.ApiRest.PostmanII.service;

import com.coderhouse.clase11.ApiRest.PostmanII.model.Product;
import com.coderhouse.clase11.ApiRest.PostmanII.model.RequestProductDetail;
import com.coderhouse.clase11.ApiRest.PostmanII.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(Math.toIntExact(id));
        return productOptional.orElse(null);
    }

    public Product updateProduct(Product updatedProduct) throws Exception {
        Long id = (long) updatedProduct.getId();
        Optional<Product> existingProductOptional = productRepository.findById(Math.toIntExact(id));
        if (existingProductOptional.isEmpty()) {
            throw new Exception("No se encontró el producto con el ID proporcionado");
        }

        Product existingProduct = existingProductOptional.get();
        existingProduct.setTittle(updatedProduct.getTittle());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setCode(updatedProduct.getCode());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());

        return productRepository.save(existingProduct);
    }
    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct:
             productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()){
                throw new Exception("Producto con id: " + requestProduct.getProductId() + " no existe");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public boolean deleteProduct(Long id) {
        // Eliminar el producto según su ID
        // Utiliza el parámetro 'id' para identificar el producto que se eliminará
        Optional<Product> product = productRepository.findById(Math.toIntExact(id));
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return true;
        } else {
            return false;
        }
    }


    }
