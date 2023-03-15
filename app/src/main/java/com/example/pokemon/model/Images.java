package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class Images{

	@SerializedName("symbol")
	private String symbol;

	@SerializedName("logo")
	private String logo;

	@SerializedName("small")
	private String small;

	@SerializedName("large")
	private String large;

	public String getSymbol(){
		return symbol;
	}

	public String getLogo(){
		return logo;
	}

	public String getSmall(){
		return small;
	}

	public String getLarge(){
		return large;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public void setLarge(String large) {
		this.large = large;
	}
}