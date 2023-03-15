package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

public class Prices{

	@SerializedName("avg30")
	private double avg30;

	@SerializedName("reverseHoloSell")
	private double reverseHoloSell;

	@SerializedName("reverseHoloLow")
	private double reverseHoloLow;

	@SerializedName("averageSellPrice")
	private double averageSellPrice;

	@SerializedName("reverseHoloAvg7")
	private double reverseHoloAvg7;

	@SerializedName("germanProLow")
	private double germanProLow;

	@SerializedName("avg7")
	private double avg7;

	@SerializedName("trendPrice")
	private double trendPrice;

	@SerializedName("suggestedPrice")
	private double suggestedPrice;

	@SerializedName("avg1")
	private double avg1;

	@SerializedName("reverseHoloTrend")
	private double reverseHoloTrend;

	@SerializedName("lowPrice")
	private double lowPrice;

	@SerializedName("reverseHoloAvg30")
	private double reverseHoloAvg30;

	@SerializedName("lowPriceExPlus")
	private double lowPriceExPlus;

	@SerializedName("reverseHoloAvg1")
	private double reverseHoloAvg1;

	@SerializedName("normal")
	private Normal normal;

	@SerializedName("holofoil")
	private Holofoil holofoil;

	@SerializedName("reverseHolofoil")
	private ReverseHolofoil reverseHolofoil;

	@SerializedName("1stEditionHolofoil")
	private JsonMember1stEditionHolofoil jsonMember1stEditionHolofoil;

	@SerializedName("unlimitedHolofoil")
	private UnlimitedHolofoil unlimitedHolofoil;

	public double getAvg30(){
		return avg30;
	}

	public double getReverseHoloSell(){
		return reverseHoloSell;
	}

	public double getReverseHoloLow(){
		return reverseHoloLow;
	}

	public double getAverageSellPrice(){
		return averageSellPrice;
	}

	public double getReverseHoloAvg7(){
		return reverseHoloAvg7;
	}

	public double getGermanProLow(){
		return germanProLow;
	}

	public double getAvg7(){
		return avg7;
	}

	public double getTrendPrice(){
		return trendPrice;
	}

	public double getSuggestedPrice(){
		return suggestedPrice;
	}

	public double getAvg1(){
		return avg1;
	}

	public double getReverseHoloTrend(){
		return reverseHoloTrend;
	}

	public double getLowPrice(){
		return lowPrice;
	}

	public double getReverseHoloAvg30(){
		return reverseHoloAvg30;
	}

	public double getLowPriceExPlus(){
		return lowPriceExPlus;
	}

	public double getReverseHoloAvg1(){
		return reverseHoloAvg1;
	}

	public Normal getNormal(){
		return normal;
	}

	public Holofoil getHolofoil(){
		return holofoil;
	}

	public ReverseHolofoil getReverseHolofoil(){
		return reverseHolofoil;
	}

	public JsonMember1stEditionHolofoil getJsonMember1stEditionHolofoil(){
		return jsonMember1stEditionHolofoil;
	}

	public UnlimitedHolofoil getUnlimitedHolofoil(){
		return unlimitedHolofoil;
	}
}