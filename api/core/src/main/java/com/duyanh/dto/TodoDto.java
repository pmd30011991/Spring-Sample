package com.duyanh.dto;

import java.io.Serializable;

/**
 * Created by huynh.truong on 12/24/2014.
 */
public class TodoDto implements Serializable {

	private String name;
	private Long id;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	

}
