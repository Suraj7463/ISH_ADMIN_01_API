package com.professionalit.service;

import java.util.List;

import com.professionalit.domain.ISHPlan;
import com.professionalit.entity.ISHPlanEntity;



public interface ISHPlanService {
	
    public String addIshPlan(ISHPlan ishPlan);
	
	public List<ISHPlanEntity> getAllPlan();
	
    public String updateIshPlan(long planId,ISHPlan ishPlan);
	
	public String deleteIshPlan(long planId);
	

}
