package com.ataybur.observer.yemeksepeti.utils;

import java.util.function.Function;

import com.ataybur.observer.yemeksepeti.constants.Constants;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;

public class YemekSepetiMessageSupplier implements MessageSupplier<YemekSepetiDto>{
	private Function<YemekSepetiDto, Double> lastPriceCalculator;
	
	public YemekSepetiMessageSupplier(Function<YemekSepetiDto, Double> lastPriceCalculator) {
		this.lastPriceCalculator = lastPriceCalculator;
	}

	public String supply(YemekSepetiDto yemekSepetiDto, String observerName) {
		String urun = yemekSepetiDto.getUrun();
		double sonFiyat = new LastPriceCalculator(yemekSepetiDto, lastPriceCalculator).calculate();
		return String.format(Constants.SPECIAL_PRICE, observerName, urun, sonFiyat);
	}
}
