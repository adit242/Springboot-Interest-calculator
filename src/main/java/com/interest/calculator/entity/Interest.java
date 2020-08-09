package com.interest.calculator.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "INTEREST")
@Data
public class Interest{
	
	@Id 
	private String txnId;
    
    private String name;
    
    private double amount;
    
    private double interest;
    
    private double totalAmount;
    
    private float percentage;
    
    private LocalDateTime createdDate = LocalDateTime.now();


   }
