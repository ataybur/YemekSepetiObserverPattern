package com.ataybur.observer.yemeksepeti.pojo;

import com.ataybur.observer.yemeksepeti.interfaces.IData;

public class WeatherForecastDto implements IData {
	private String city;
	private Integer degree;

	public WeatherForecastDto(String city, Integer degree) {
		super();
		this.city = city;
		this.degree = degree;
	}

	public String getCity() {
		return city;
	}

	public Integer getDegree() {
		return degree;
	}

}
