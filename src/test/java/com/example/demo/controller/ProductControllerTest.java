package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

        @InjectMocks
        private ProductController controller;

       @Mock
       private ProductService service;


        @Test
        public void addProductTest(){
            Product product = getProduct();

            when(service.saveProduct(product)).thenReturn(product);
            Product product1 = controller.addProduct(product);
            Assertions.assertEquals(product.getId(), product1.getId());
        }

        @Test
        public void addProductsTest(){
            List<Product> products = getProducts();
            when(service.saveProduct(products)).thenReturn(products);
            List<Product> product1 = controller.addProducts(products);
            Assertions.assertEquals(products.get(0).getId(),product1.get(0).getId());
        }

        @Test
        public void findAllProducts(){
            List<Product> products = getAllProducts();
            when(service.getProducts()).thenReturn(products);
            List<Product>product1=controller.findAllProducts(products);
            Assertions.assertEquals(
                    products.get(0).getId(),product1.get(0).getId()
            );
            Assertions.assertEquals(products.get(1).getName(),product1.get(1).getName());
            Assertions.assertEquals(products.get(2).getQuantity(),product1.get(2).getQuantity());
            Assertions.assertEquals(products.get(3).getPrice(),product1.get(3).getPrice());
        }

        @Test
        public void findProductById(){
            Product products = getProductById();
            when(service.getProductById(products.getId())).thenReturn(products);
            Product product1=controller.findProductById(products.getId());
            Assertions.assertEquals(products.getId(),product1.getId());
        }

        @Test
        public void findProductByName(){
            Product products = getProductByName1();
            when(service.getProductByName(products.getName())).thenReturn(products);
            Product product1 =  controller.findProductByName(products.getName());
            Assertions.assertEquals(products.getName(),product1.getName());
        }

        @Test
         public void updateProduct(){
            Product product = getUpdatedProduct();
            when(service.updateProduct(product,product.getId())).thenReturn(product);
            Product product1 = controller.updateProduct(product.getId(),product);
            Assertions.assertEquals(product.getId(),product1.getId());
            Assertions.assertEquals(product.getName(),product1.getName());
            Assertions.assertEquals(product.getQuantity(),product1.getQuantity());
            Assertions.assertEquals(product.getPrice(),product1.getPrice());
        }

        @Test
        public void deleteProduct(){
            String product = getDeletedProduct();
            when(service.deleteProduct(getProductById().getId())).thenReturn("Product Removed" + getProductById().getId());
            String product1 = controller.deleteProduct(getProductById().getId());
            Assertions.assertEquals(product, product1);


        }




    public static Product getProduct(){
        Product product = new Product();
        product.setId(11);
        product.setName("Yash");
        product.setQuantity(50);
        product.setPrice(258.25);
        return product;
    }
      public static List<Product> getProducts() {
          List<Product> productList = new ArrayList<>();
          productList.add(getProduct());
          productList.add(getProduct());
          return productList;
      }
      public static List<Product>getAllProducts(){
            List<Product>productList = new ArrayList<>();
            productList.add(getProduct());
            productList.add(getProduct());
          productList.add(getProduct());
          productList.add(getProduct());
            return productList;
      }
      public static Product getProductById(){
            return getProduct();
      }
      public static Product getProductByName1(){

            return getProduct();
      }
      public static  Product getUpdatedProduct(){
            return getProduct();
      }

      public static String getDeletedProduct(){
           return "Product Removed11";
      }
}


