package com.interest.calculator.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ServiceUtil {
    
    
	 @Value("${percentage.min}")
	 float START_PERCENTAGE ;

	 @Value("${percentage.mid}")
      float MID_PERCENTAGE ;

	 @Value("${percentage.max}")
      float HIGH_PERCENTAGE ;
    
	 private static DecimalFormat df = new DecimalFormat("0.00");
	 
	 private float percentage= 0.0f;
    
    public  double calculateInterest(double amount) {
    	percentage= 0.0f;
    	
    	if(amount == 1000){
    		return calculate(amount, START_PERCENTAGE);
    		
    	}
    	if(amount>1000 && amount <=5000){
    		
    		return calculate(amount, MID_PERCENTAGE);
    	}
    	
    	if(amount >5000){
    		
    		return calculate(amount, HIGH_PERCENTAGE);
    	}
		return 0.0;
    	
    }
    
    private  double calculate(double amount, float eligiblePercentage)
    {
    	df.setRoundingMode(RoundingMode.DOWN);
    	percentage =eligiblePercentage;
    	return  Double.parseDouble(df.format(amount * (eligiblePercentage/100)));
    }
		
	    
	public  String generateRandomString(){
		
		  Random random = new Random();
		
		      String idToken =random.ints(48,122)
		            .filter(i-> (i<57 || i>65) && (i <90 || i>97))
		            .mapToObj(i -> (char) i)
		            .limit(9)
		            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		            .toString();
		      return idToken;
		            
	}

	public float getPercentage() {
		return percentage;
	}

	
 
}
