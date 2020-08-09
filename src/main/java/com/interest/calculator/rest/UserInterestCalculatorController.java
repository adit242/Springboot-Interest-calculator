package com.interest.calculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interest.calculator.service.UserInterestService;
import com.interest.calculator.service.dto.InterestDTO;


@RestController
@RequestMapping("/api/v1")
public class UserInterestCalculatorController {
    private final Logger log = LoggerFactory.getLogger(UserInterestCalculatorController.class);

    @Autowired
    private  UserInterestService userService;
    
	 public UserInterestCalculatorController(UserInterestService userService) {
		   this.userService = userService;
	  }
    
    /**
     * {@code POST users} : save user.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with Txns ID.
     */
	
	  @PostMapping("/calculate/interest")
	  public InterestDTO saveInterest(@RequestBody InterestDTO interestDTO) {
	    return userService.calculateInterestAndSave(interestDTO);
	  }
    
    
    /**
     * Gets Interest info by txnid.
     * @param  txnid
     * @return Interest information
     * @throws Transcation ID Not FoundException the resource not found exception
     */
    @GetMapping("/interest/txnId/{txnId}")
    public ResponseEntity<InterestDTO> getInterestCalucaltionResultByTxnId(@PathVariable(name="txnId") String txnId) {
    	InterestDTO user = userService.getByTxnId(txnId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    
    @GetMapping("/up")
    public String up() {
    	
        return "Service Up and runnings";
    }
   
}
