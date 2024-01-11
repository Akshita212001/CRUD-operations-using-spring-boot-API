package com.example.demo.madel;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class APIResponse <T> {
    int recordCount;
    T response;

    public APIResponse(int recordCount, T response) {
        this.recordCount = recordCount;
        this.response = response;
    }
}





    

