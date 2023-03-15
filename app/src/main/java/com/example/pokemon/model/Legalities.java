package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class Legalities{

	@SerializedName("unlimited")
	private String unlimited;

	@SerializedName("expanded")
	private String expanded;

	@SerializedName("standard")
	private String standard;

	public String getUnlimited(){
		return unlimited;
	}

	public String getExpanded(){
		return expanded;
	}

	public String getStandard(){
		return standard;
	}
}