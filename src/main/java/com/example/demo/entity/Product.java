package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_tbl")
public class Product {

    private int id;
    private String name;
    private int quantity;
    private double price;




    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setId(int id) {
        this.id = id;
    }


}
