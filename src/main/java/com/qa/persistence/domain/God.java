package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class God {	
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		
		private Long godID;
		private String name;
		
		public God() {
			
		}

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

