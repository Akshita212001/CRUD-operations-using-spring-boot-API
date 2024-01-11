package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.madel.ProductModel;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){

        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProduct(products);
    }
    @GetMapping("/products")
    public List<ProductModel> findAllProducts(){
    return service.getProducts();
    }
    @GetMapping("/productById/{id}")
    public ProductModel findProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public ProductModel findProductByName(@PathVariable String name){
        return service.getProductByName(name);


    }
    @PutMapping("/update/{id}")
    public ProductModel updateProduct(@PathVariable int id, @RequestBody ProductModel productModel){
        return service.updateProduct(productModel, id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
