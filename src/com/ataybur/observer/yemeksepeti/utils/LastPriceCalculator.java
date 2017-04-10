package com.ataybur.observer.yemeksepeti.utils;

import java.util.function.Function;

import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;

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
