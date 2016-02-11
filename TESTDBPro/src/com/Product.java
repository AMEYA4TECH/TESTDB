package com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(Include.NON_NULL)
public class Product {

	@JsonProperty("ID")
	String ID;
	@JsonProperty("Name")
	String Name;
	@JsonProperty("Decr")
	String Decr;
	@JsonProperty("Catagory")
	String Catagory;
	@JsonProperty("Color")
	String Color;
	@JsonProperty("Material")
	String Material;
	@JsonProperty("Shape")
	String Shape;
	@JsonProperty("Origin")
	String Origin;
	
	@JsonProperty("ID")
	public String getID() {
		return ID;
	}
	@JsonProperty("ID")
	public void setID(String iD) {
		ID = iD;
	}

	@JsonProperty("Name")
	public String getName() {
		return Name;
	}
	@JsonProperty("Name")
	public void setName(String name) {
		Name = name;
	}
	@JsonProperty("Decr")
	public String getDecr() {
		return Decr;
	}
	@JsonProperty("Decr")
	public void setDecr(String decr) {
		Decr = decr;
	}
	@JsonProperty("Catagory")
	public String getCatagory() {
		return Catagory;
	}
	@JsonProperty("Catagory")
	public void setCatagory(String catagory) {
		Catagory = catagory;
	}
	@JsonProperty("Color")
	public String getColor() {
		return Color;
	}
	@JsonProperty("Color")
	public void setColor(String color) {
		Color = color;
	}
	@JsonProperty("Material")
	public String getMaterial() {
		return Material;
	}
	@JsonProperty("Material")
	public void setMaterial(String material) {
		Material = material;
	}
	@JsonProperty("Shape")
	public String getShape() {
		return Shape;
	}
	@JsonProperty("Shape")
	public void setShape(String shape) {
		Shape = shape;
	}
	@JsonProperty("Origin")
	public String getOrigin() {
		return Origin;
	}
	@JsonProperty("Origin")
	public void setOrigin(String origin) {
		Origin = origin;
	}

}
