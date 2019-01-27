package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class God {	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		
		//Values within the Entity
		private Long godID;
		private String name;
		private String godOf;
		private String children;
		private String powers;
		
		public God() {
			
		}
		
		public String getGodOf() {
			return godOf;
		}

		public void setGodOf(String godOf) {
			this.godOf = godOf;
		}

		public String getChildren() {
			return children;
		}

		public void setChildren(String children) {
			this.children = children;
		}

		public String getPowers() {
			return powers;
		}

		public void setPowers(String powers) {
			this.powers = powers;
		}

		
		//Getters and Setters
		public Long getGodID() {
			return godID;
		}

		public void setGodID(Long godID) {
			this.godID = godID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

