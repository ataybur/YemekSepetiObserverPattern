package com.ataybur.observer.yemeksepeti.utils;

import com.ataybur.observer.yemeksepeti.constants.Constants;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.pojo.WeatherForecastDto;

public class WeatherForecastMessageSupplier implements MessageSupplier<WeatherForecastDto> {

	@Override
	public String supply(WeatherForecastDto iData, String observerName) {
		return String.format(Constants.WEATHER_FORECAST, observerName, iData.getCity(),iData.getDegree());
	}

}
