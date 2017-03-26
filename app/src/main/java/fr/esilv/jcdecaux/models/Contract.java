package fr.esilv.jcdecaux.models;

import java.util.List;

public class Contract {
	private String name;
	private String commercial_name;
	private String country_code;
	private List<String> cities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommercial_name() {
		return commercial_name;
	}

	public void setCommercial_name(String commercial_name) {
		this.commercial_name = commercial_name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}
}
