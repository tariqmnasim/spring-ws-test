package com.test.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.test.ws.wsmodels.*;
import com.test.ws.services.AddService;

@Endpoint
public class AdditionEndpoint {
   //To calculate sum of two input.
   @Autowired
   private AddService addService;
   
   //This is similar to @RequestMapping of Spring MVC
   @PayloadRoot(localPart="AddServiceRequest", namespace="http://develop-for-fun.blogspot.com/spring-ws")
   @ResponsePayload
   public AddServiceResponse generateRandomNumber(@RequestPayload AddServiceRequest request) {
       
	   AddServiceResponse response = new ObjectFactory().createAddServiceResponse();
       
	   response.setSum(addService.addNumbers(request.getFirstNumber(), request.getSecondNumber()) );
       
	   return response;
	   
   }
}