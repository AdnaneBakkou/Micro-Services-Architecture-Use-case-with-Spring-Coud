package org.sid.bilingservice.service;


import org.sid.bilingservice.entities.ProductItem;
import org.sid.bilingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {

    @GetMapping(path = "/products/{id}")
    ProductItem findProductById(@PathVariable Long id);
    @GetMapping(path = "/products")
    PagedModel<Product> allProducts();


}
