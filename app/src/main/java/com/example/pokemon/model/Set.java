package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class Set{

	@SerializedName("total")
	private double total;

	@SerializedName("images")
	private Images images;

	@SerializedName("prdoubleedTotal")
	private double prdoubleedTotal;

	@SerializedName("releaseDate")
	private String releaseDate;

	@SerializedName("series")
	private String series;

	@SerializedName("name")
	private String name;

	@SerializedName("legalities")
	private Legalities legalities;

	@SerializedName("id")
	private String id;

	@SerializedName("updatedAt")
	private String updatedAt;

	@SerializedName("ptcgoCode")
	private String ptcgoCode;

	public double getTotal(){
		return total;
	}

	public Images getImages(){
		return images;
	}

	public double getPrdoubleedTotal(){
		return prdoubleedTotal;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getSeries(){
		return series;
	}

	public String getName(){
		return name;
	}

	public Legalities getLegalities(){
		return legalities;
	}

	public String getId(){
		return id;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getPtcgoCode(){
		return ptcgoCode;
	}
}