

package com.interest.calculator.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.interest.calculator.entity.Interest;


public interface UserInterestRepository extends  MongoRepository<Interest, String> {


}


