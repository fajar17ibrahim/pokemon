package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class UnlimitedHolofoil{

	@SerializedName("market")
	private Object market;

	@SerializedName("high")
	private Object high;

	@SerializedName("directLow")
	private Object directLow;

	@SerializedName("low")
	private Object low;

	@SerializedName("mid")
	private Object mid;

	public Object getMarket(){
		return market;
	}

	public Object getHigh(){
		return high;
	}

	public Object getDirectLow(){
		return directLow;
	}

	public Object getLow(){
		return low;
	}

	public Object getMid(){
		return mid;
	}
}