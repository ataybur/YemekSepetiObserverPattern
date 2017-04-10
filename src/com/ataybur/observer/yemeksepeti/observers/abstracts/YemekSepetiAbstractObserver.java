package com.ataybur.observer.yemeksepeti.observers.abstracts;

import java.util.function.Function;

import com.ataybur.observer.yemeksepeti.constants.Constants;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.pojo.LastPriceCalculator;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;

public abstract class YemekSepetiAbstractObserver extends AbstractObserver<YemekSepetiDto> {
	private Function<YemekSepetiDto, Double> lastPriceCalculator;
	
	public YemekSepetiAbstractObserver(Subject<YemekSepetiDto> subject) {
		super(subject);
	}

	public void setLastPriceCalculator(Function<YemekSepetiDto, Double> lastPriceCalculator) {
		this.lastPriceCalculator = lastPriceCalculator;
	}

	@Override
	public void update(YemekSepetiDto yemekSepetiDto) {
		String urun = yemekSepetiDto.getUrun();
		double sonFiyat = new LastPriceCalculator(yemekSepetiDto, lastPriceCalculator).calculate();
		this.message = String.format(Constants.SPECIAL_PRICE, getName(), urun, sonFiyat);
	}

}
