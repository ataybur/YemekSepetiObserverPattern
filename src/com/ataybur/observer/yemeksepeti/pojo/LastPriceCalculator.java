package com.ataybur.observer.yemeksepeti.pojo;

import java.util.function.Function;

public class LastPriceCalculator {
	private YemekSepetiDto instance;
	private Function<YemekSepetiDto, Double> lastPriceCalculator;
	
	public LastPriceCalculator(YemekSepetiDto instance, Function<YemekSepetiDto, Double> lastPriceCalculator){
		this.instance = instance;
		this.lastPriceCalculator = lastPriceCalculator;
	}
	
	public Double calculate(){
		return lastPriceCalculator.apply(instance);
	}
}
