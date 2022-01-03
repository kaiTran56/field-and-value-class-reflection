package com.tranquyet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	private String course;
	private List<String> listString = new ArrayList<>();

	@Getter
	@Setter
	class hello{
		private String hello;
	}

//	public String toString(){
//		StringBuilder sb = new StringBuilder();
//
//		Class<?> thisClass = null;
//		try {
//			thisClass = Class.forName(this.getClass().getName());
//
//			Field[] aClassFields = thisClass.getDeclaredFields();
//			sb.append(this.getClass().getSimpleName() + " [ ");
//			for(Field f : aClassFields){
//				String fName = f.getName();
//				sb.append("(" + f.getType() + ") " + fName + " = " + f.get(this) + ", ");
//			}
//			sb.append("]");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return sb.toString();
//	}
}
