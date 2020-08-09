package com.interest.calculator.config;


import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;




@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "test";
	}
	
	
	 @Override
	    public MongoClient mongoClient() {
	        return MongoClients.create("mongodb://localhost:27017/test");
	    }
	
 
	  @Bean
	    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory,
	                                       MongoMappingContext context) {

	        MappingMongoConverter converter =
	                new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory), context);
	        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory, converter);

	        return mongoTemplate;

	    }
  
}