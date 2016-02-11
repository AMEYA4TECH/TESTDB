package com;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class PRoductDTO {

	
	
	
	
	  String ID; 
	  String  Name ;
	  String  Decr ;
	  String  Catagory;
	  String Color;
	  String Material;
	  String  Shape;
	  String  Origin ;
	  
	  @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	@Column(name="Name")
	public String getName() {
		return Name;
	}
	
	
	public void setName(String name) {
		Name = name;
	}
	
	@Column(name="Decr")
	public String getDecr() {
		return Decr;
	}
	public void setDecr(String decr) {
		Decr = decr;
	}
	
	@Column(name="Catagory")
	public String getCatagory() {
		return Catagory;
	}
	public void setCatagory(String catagory) {
		Catagory = catagory;
	}
	
	@Column(name="Color")
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	
	@Column(name="Material")
	public String getMaterial() {
		return Material;
	}
	public void setMaterial(String material) {
		Material = material;
	}
	
	@Column(name="Shape")
	public String getShape() {
		return Shape;
	}
	public void setShape(String shape) {
		Shape = shape;
	}
	
	@Column(name="Origin")
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	
	

}
