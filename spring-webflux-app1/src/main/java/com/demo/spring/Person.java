package com.demo.spring;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		this.name = name;
	}
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
