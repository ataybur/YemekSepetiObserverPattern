package com.ataybur.observer.yemeksepeti.pojo;

import com.ataybur.observer.yemeksepeti.interfaces.IData;

public class YemekSepetiDto implements IData {
	private String urun;
	private double fiyat;
	private double maksIndirimOrani;
	
	public YemekSepetiDto(String urun, double fiyat, double maksIndirimOrani) {
		super();
		this.urun = urun;
		this.fiyat = fiyat;
		this.maksIndirimOrani = maksIndirimOrani;
	}

	public String getUrun() {
		return urun;
	}

	public double getFiyat() {
		return fiyat;
	}

	public double getMaksIndirimOrani() {
		return maksIndirimOrani;
	}
	
	
}
