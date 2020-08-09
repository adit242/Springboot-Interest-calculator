package com.interest.calculator.service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO representing a user
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterestDTO {
		
	private String txnId;
    
    private String name;
    
    private double amount;
    
    private double interest;
    
    private double totalAmount;
    
    private float percentage;
    
    private LocalDateTime createdDate;


   }
