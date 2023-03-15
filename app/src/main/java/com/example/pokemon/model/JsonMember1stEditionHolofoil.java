package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class JsonMember1stEditionHolofoil{

	@SerializedName("market")
	private double market;

	@SerializedName("high")
	private double high;

	@SerializedName("directLow")
	private double directLow;

	@SerializedName("low")
	private double low;

	@SerializedName("mid")
	private double mid;

	public double getMarket(){
		return market;
	}

	public double getHigh(){
		return high;
	}

	public double getDirectLow(){
		return directLow;
	}

	public double getLow(){
		return low;
	}

	public double getMid(){
		return mid;
	}
}