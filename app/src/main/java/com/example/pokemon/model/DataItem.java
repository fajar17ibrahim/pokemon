package com.example.pokemon.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("supertype")
	private String supertype;

	@SerializedName("types")
	private List<String> types;

	@SerializedName("images")
	private Images images;

	@SerializedName("retreatCost")
	private List<String> retreatCost;

	@SerializedName("set")
	private Set set;

	@SerializedName("artist")
	private String artist;

	@SerializedName("hp")
	private String hp;

	@SerializedName("convertedRetreatCost")
	private int convertedRetreatCost;

	@SerializedName("legalities")
	private Legalities legalities;

	@SerializedName("tcgplayer")
	private Tcgplayer tcgplayer;

	@SerializedName("subtypes")
	private List<String> subtypes;

	@SerializedName("abilities")
	private List<AbilitiesItem> abilities;

	@SerializedName("number")
	private String number;

	@SerializedName("attacks")
	private List<AttacksItem> attacks;

	@SerializedName("nationalPokedexNumbers")
	private List<Integer> nationalPokedexNumbers;

	@SerializedName("weaknesses")
	private List<WeaknessesItem> weaknesses;

	@SerializedName("name")
	private String name;

	@SerializedName("cardmarket")
	private Cardmarket cardmarket;

	@SerializedName("id")
	private String id;

	@SerializedName("rarity")
	private String rarity;

	@SerializedName("flavorText")
	private String flavorText;

	@SerializedName("level")
	private String level;

	@SerializedName("resistances")
	private List<ResistancesItem> resistances;

	@SerializedName("evolvesFrom")
	private String evolvesFrom;

	@SerializedName("evolvesTo")
	private List<String> evolvesTo;

	@SerializedName("rules")
	private List<String> rules;

	@SerializedName("regulationMark")
	private String regulationMark;

	public String getSupertype(){
		return supertype;
	}

	public List<String> getTypes(){
		return types;
	}

	public Images getImages(){
		return images;
	}

	public List<String> getRetreatCost(){
		return retreatCost;
	}

	public Set getSet(){
		return set;
	}

	public String getArtist(){
		return artist;
	}

	public String getHp(){
		return hp;
	}

	public int getConvertedRetreatCost(){
		return convertedRetreatCost;
	}

	public Legalities getLegalities(){
		return legalities;
	}

	public Tcgplayer getTcgplayer(){
		return tcgplayer;
	}

	public List<String> getSubtypes(){
		return subtypes;
	}

	public List<AbilitiesItem> getAbilities(){
		return abilities;
	}

	public String getNumber(){
		return number;
	}

	public List<AttacksItem> getAttacks(){
		return attacks;
	}

	public List<Integer> getNationalPokedexNumbers(){
		return nationalPokedexNumbers;
	}

	public List<WeaknessesItem> getWeaknesses(){
		return weaknesses;
	}

	public String getName(){
		return name;
	}

	public Cardmarket getCardmarket(){
		return cardmarket;
	}

	public String getId(){
		return id;
	}

	public String getRarity(){
		return rarity;
	}

	public String getFlavorText(){
		return flavorText;
	}

	public String getLevel(){
		return level;
	}

	public List<ResistancesItem> getResistances(){
		return resistances;
	}

	public String getEvolvesFrom(){
		return evolvesFrom;
	}

	public List<String> getEvolvesTo(){
		return evolvesTo;
	}

	public List<String> getRules(){
		return rules;
	}

	public String getRegulationMark(){
		return regulationMark;
	}

	public void setSupertype(String supertype) {
		this.supertype = supertype;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public void setImages(Images images) {
		this.images = images;
	}

	public void setRetreatCost(List<String> retreatCost) {
		this.retreatCost = retreatCost;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public void setConvertedRetreatCost(int convertedRetreatCost) {
		this.convertedRetreatCost = convertedRetreatCost;
	}

	public void setLegalities(Legalities legalities) {
		this.legalities = legalities;
	}

	public void setTcgplayer(Tcgplayer tcgplayer) {
		this.tcgplayer = tcgplayer;
	}

	public void setSubtypes(List<String> subtypes) {
		this.subtypes = subtypes;
	}

	public void setAbilities(List<AbilitiesItem> abilities) {
		this.abilities = abilities;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setAttacks(List<AttacksItem> attacks) {
		this.attacks = attacks;
	}

	public void setNationalPokedexNumbers(List<Integer> nationalPokedexNumbers) {
		this.nationalPokedexNumbers = nationalPokedexNumbers;
	}

	public void setWeaknesses(List<WeaknessesItem> weaknesses) {
		this.weaknesses = weaknesses;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCardmarket(Cardmarket cardmarket) {
		this.cardmarket = cardmarket;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setResistances(List<ResistancesItem> resistances) {
		this.resistances = resistances;
	}

	public void setEvolvesFrom(String evolvesFrom) {
		this.evolvesFrom = evolvesFrom;
	}

	public void setEvolvesTo(List<String> evolvesTo) {
		this.evolvesTo = evolvesTo;
	}

	public void setRules(List<String> rules) {
		this.rules = rules;
	}

	public void setRegulationMark(String regulationMark) {
		this.regulationMark = regulationMark;
	}
}