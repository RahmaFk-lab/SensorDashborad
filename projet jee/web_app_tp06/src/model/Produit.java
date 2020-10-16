package model;

import java.util.Date;

public class Produit {

	private int id;
	private String code;
	private String designation; 
	private double prix;
	private String categorie;
	private java.util.Date validite;

	public Produit(int id, String code, String designation, double prix, String categorie, Date validite) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
		this.validite = validite;
	}

	public java.util.Date getValidite() {
		return validite;
	}

	public void setValidite(java.util.Date validite) {
		this.validite = validite;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", code=" + code + ", designation=" + designation + ", prix=" + prix
				+ ", categorie=" + categorie + ", validite=" + validite + "]";
	}

	public Produit(int id, String code, String designation, double prix, String categorie) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
		this.categorie = categorie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produit(int id, String code, String designation, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.designation = designation;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
}
