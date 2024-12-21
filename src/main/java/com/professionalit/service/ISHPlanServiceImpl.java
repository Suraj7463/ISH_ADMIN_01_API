package com.professionalit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professionalit.domain.ISHPlan;
import com.professionalit.entity.ISHPlanEntity;
import com.professionalit.repository.ISHPlanRepository;


@Service
public class ISHPlanServiceImpl implements ISHPlanService {

	@Autowired
	ISHPlanRepository ishPlanRepository;
	
	@Override
	public String addIshPlan(ISHPlan ishPlan) {
		
		ISHPlanEntity ishPlan1=new ISHPlanEntity();
		BeanUtils.copyProperties(ishPlan, ishPlan1);
		ISHPlanEntity savedplan=ishPlanRepository.save(ishPlan1);
		
		return ishPlan1.getPlanId()+"Registered Succesfully";
		
	}

	@Override
	public List<ISHPlanEntity> getAllPlan() {
		// TODO Auto-generated method stub
		return ishPlanRepository.findAll();
	}

	/*
	 * @Override public String updateIshPlan(long planId, ISHPlan ishPlan) {
	 * ISHPlanEntity ishPlan1=new ISHPlanEntity(); BeanUtils.copyProperties(ishPlan,
	 * ishPlan1); Optional<ISHPlan> existingPlanOpt =
	 * ishPlanRepository.findById(planId); if (existingPlanOpt.isPresent()) {
	 * 
	 * ISHPlanEntity existingPlan = existingPlanOpt.get();
	 * 
	 * //Update fields from the input object
	 * existingPlan.setPlanName(ishPlan.getPlanName());
	 * existingPlan.setPlanDescription(ishPlan.getPlanDescription());
	 * existingPlan.setPlanCategoryId(ishPlan.getPlanCategoryId());
	 * existingPlan.setActiveSW(ishPlan.getActiveSW());
	 * 
	 * // Save the updated plan ishPlanRepository.save(existingPlan);
	 * 
	 * return "Plan ID " + planId + " updated successfully"; } else { return
	 * "Plan ID " + planId + " not found"; }
	 */
	@Override
	public String updateIshPlan(long planId, ISHPlan ishPlan) {
	    Optional<ISHPlanEntity> existingPlanOpt = ishPlanRepository.findById(planId);

	    if (existingPlanOpt.isPresent()) {
	        ISHPlanEntity existingPlan = existingPlanOpt.get();
	        
	        // Update fields from the input object
	        existingPlan.setPlanName(ishPlan.getPlanName());
	        existingPlan.setPlanDescription(ishPlan.getPlanDescription());
	        existingPlan.setPlanCategoryId(ishPlan.getPlanCategoryId());
	        existingPlan.setActiveSW(ishPlan.getActiveSW());
	        
	        // Save the updated plan
	        ishPlanRepository.save(existingPlan);
	        return "Plan ID " + planId + " updated successfully";
	    } else {
	        return "Plan ID " + planId + " not found";
	    }
	}
	

	@Override
	public String deleteIshPlan(long planId) {
		ishPlanRepository.deleteById(planId);
		return "record deleted";
	}

	
}
