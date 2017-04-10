package com.ataybur.observer.yemeksepeti.subject;

import java.util.ArrayList;

import com.ataybur.observer.yemeksepeti.interfaces.Observer;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;

public class YemekSepetiData implements Subject<YemekSepetiDto> {
	private ArrayList<Observer<YemekSepetiDto>> observers;
	private YemekSepetiDto yemekSepetiDto;

	public YemekSepetiData() {
		observers = new ArrayList<Observer<YemekSepetiDto>>();
	}

	public void registerObserver(Observer<YemekSepetiDto> o) {
		observers.add(o);
	}

	public void removeObserver(Observer<YemekSepetiDto> o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (Observer<YemekSepetiDto> observer : observers) {
			observer.update(yemekSepetiDto);
		}
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setProduct(String urun, double fiyat, double maksIndirimOrani) {
		this.yemekSepetiDto = new YemekSepetiDto(urun, fiyat, maksIndirimOrani);
		measurementsChanged();
	}

}
