package com.example.demo.service;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Test
    public void saveProduct(){
        Product product = saveAllProduct();
        when(service.saveProduct(product)).thenReturn(product);
        Product product1 = service.saveProduct(product);
        Assertions.assertEquals(product.getId(), product1.getId());
    }

     public static Product saveAllProduct(){
         Product product = new Product();
         product.setId(12);
         product.setName("Akshita");
         product.setQuantity(50);
         product.setPrice(258.25);
         return product;
     }
}
