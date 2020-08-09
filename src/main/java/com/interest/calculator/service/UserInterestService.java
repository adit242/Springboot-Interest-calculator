package com.interest.calculator.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interest.calculator.entity.Interest;
import com.interest.calculator.respository.UserInterestRepository;
import com.interest.calculator.service.dto.InterestDTO;
import com.interest.calculator.service.errors.TXnIDNotFoundException;
import com.interest.calculator.util.ServiceUtil;


@Service
public class UserInterestService {

	@Autowired
    private UserInterestRepository userRepository;
	
	@Autowired
	private ServiceUtil serviceUtil;
	
	private ModelMapper modelMapper;
	 
	public UserInterestService( ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public InterestDTO calculateInterestAndSave(InterestDTO userDTO) {
		Interest userInt = modelMapper.map(userDTO, Interest.class);
		double interest = serviceUtil.calculateInterest(userInt.getAmount());
		userInt.setInterest(interest);
		userInt.setTxnId(serviceUtil.generateRandomString());
		userInt.setTotalAmount(userInt.getAmount()+interest);
		userInt.setPercentage(serviceUtil.getPercentage());
		userInt = userRepository.save(userInt);
		InterestDTO savedInt = modelMapper.map(userInt, InterestDTO.class);
		return savedInt; 
	}

	public InterestDTO getByTxnId(String txnId) {
		Interest entity = userRepository.findById(txnId).orElseThrow(()-> new TXnIDNotFoundException("Transaction ID Not found"));
	    InterestDTO user = modelMapper.map(entity, InterestDTO.class);
		return user;
	}
	
}
