package com.example.demo.service;


import com.example.demo.entity.Product;
import com.example.demo.madel.ProductModel;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import jdk.internal.module.ModulePath;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    private int variable;
    private SingularAttribute<AbstractPersistable, Serializable> id;

    //
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    //
    public List<Product> saveProduct(List<Product> products) {
        return repository.saveAll(products);
    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }

    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public int getVariable() {
        return variable;
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }
    public List<Product> findProductsWithSorting(String field){
        return  repository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<Product> findProductsWithPagination(int offset,int pageSize){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize));
        return  products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<Product> products = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  products;
    }


    public List<ProductModel> getProducts() {

        List<ProductModel> list = new ArrayList<>();
        List<Product> productList = repository.findAll();
        for (Product product : productList) {
            ProductModel productModel = new ProductModel();
            productModel.setId(product.getId());
            productModel.setName(product.getName());
            productModel.setPrice(product.getPrice());
            productModel.setQuantity(product.getQuantity());
            list.add(productModel);

        }

         list.stream().filter(s->s!=null).map(m->m.getName()+m.getName()).forEach(s->System.out.println(s));
        return list;


    }


    public ProductModel getProductById(int id) {


        ProductRepository repository = null;
        Product product = repository.findById(id).orElse(null);
//        productModel.setId(product.getId());
//        productModel.setName(product.getName());
//        productModel.setPrice(product.getPrice());
//        productModel.setQuantity(product.getQuantity());
        ProductModel productModel = this.modelMapper.map(product, ProductModel.class);
        return productModel;
    }

    public ProductModel getProductByName(String name) {
//        return repository.findByName(name);
        Product product = repository.findByName(name);
//        productModel.setName(product.getName());
//        productModel.setId(product.getId());
//        productModel.setPrice(product.getPrice());
//        productModel.setQuantity(product.getQuantity());
        ProductModel productModel = this.modelMapper.map(product, ProductModel.class);
        return productModel;
    }

    //    public String deleteProduct(int id) {
////        repository.deleteById(id);
////        return "product removed!! "+id;
//        ProductModel productModel = new ProductModel();
//        repository.deleteById(id);
//
//
//        return "delete successfully";
//    }
    public String deleteProduct(int id) {

        repository.deleteById(id);

        return "product removed" + id;
    }

    public ProductModel updateProduct(ProductModel productModel, int id) {


        Product product = repository.findById(id).orElse(null);
        productModel.setId(product.getId());
        product = this.modelMapper.map(productModel, Product.class);
        repository.save(product);
        return productModel;
    }

}

//product.setName(productModel.getName());
//        product.setPrice(productModel.getPrice()) ;
//        product.setQuantity(productModel.getQuantity());