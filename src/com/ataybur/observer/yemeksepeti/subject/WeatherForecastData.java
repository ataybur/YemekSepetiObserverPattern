package com.ataybur.observer.yemeksepeti.subject;

import java.util.ArrayList;

import com.ataybur.observer.yemeksepeti.interfaces.Observer;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.pojo.WeatherForecastDto;

public class WeatherForecastData implements Subject<WeatherForecastDto> {
	private ArrayList<Observer<WeatherForecastDto>> observers;
	private WeatherForecastDto weatherForecastDto;
	
	public WeatherForecastData() {
		observers = new ArrayList<Observer<WeatherForecastDto>>();
	}
	
	@Override
	public void registerObserver(Observer<WeatherForecastDto> o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer<WeatherForecastDto> o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (Observer<WeatherForecastDto> observer : observers) {
			observer.update(weatherForecastDto);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}

	public void setForecast(String city, Integer degree) {
		this.weatherForecastDto = new WeatherForecastDto(city, degree);
		measurementsChanged();
	}

}
