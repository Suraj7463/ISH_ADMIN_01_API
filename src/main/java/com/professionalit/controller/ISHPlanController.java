package com.professionalit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.professionalit.domain.ISHPlan;
import com.professionalit.entity.ISHPlanEntity;
import com.professionalit.service.ISHPlanServiceImpl;



@RestController
public class ISHPlanController {
	
	@Autowired
	ISHPlanServiceImpl ishPlanService;
	
	
	
	@PostMapping(value ="/addplan" ,consumes={"application/json"},produces= {"application/json"})
	 public ResponseEntity<String> addIshPlan(@RequestBody ISHPlan ishPlan)
	{
		String msg=ishPlanService.addIshPlan(ishPlan);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/showplan")
	 public ResponseEntity<List<ISHPlanEntity>> getAllPlan(){
		 List<ISHPlanEntity> list=ishPlanService.getAllPlan();
		 return new ResponseEntity<>(list,HttpStatus.OK);
	 }
	 
	 
	 @DeleteMapping("/deleteplan/{planId}")
	 public ResponseEntity<String> deleteBook(@PathVariable long planId) {
		 
		 String msg=ishPlanService.deleteIshPlan(planId);
		 return new ResponseEntity<>(msg,HttpStatus.OK);
	 }
	 
	 
	 @PutMapping(value ="/updateplan/{planId}" ,consumes={"application/json"},produces= {"application/json"})
	 
	 public ResponseEntity<String> updateIshPlan(@PathVariable long planId,@RequestBody ISHPlan ishPlan)
	{
		String msg=ishPlanService.updateIshPlan(planId,ishPlan);
		
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}

}
