package com.professionalit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="JRTP03_PLAN_CATEGORY")
@Data
public class ISHPlanCategoryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long categoryId;
	
	@Column(length=20,nullable=false)
	private String planName;
	
	@Column(nullable=false)
	private String planDescription;
	
	@Column
	private Long planCategoryId;
	
	@Column
	private char activeSW='a';
	
	@CreationTimestamp
	@Column(updatable=false,nullable=false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(nullable=false)
	private LocalDate updatedDate;

}
