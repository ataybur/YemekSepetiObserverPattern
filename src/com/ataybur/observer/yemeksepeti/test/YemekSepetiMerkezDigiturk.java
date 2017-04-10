package com.ataybur.observer.yemeksepeti.test;

import com.ataybur.observer.yemeksepeti.observers.DigiturkDisplay;
import com.ataybur.observer.yemeksepeti.observers.IPhoneDisplay;
import com.ataybur.observer.yemeksepeti.observers.WebPageDisplay;
import com.ataybur.observer.yemeksepeti.observers.abstracts.MobilCihazlarDisplay;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;
import com.ataybur.observer.yemeksepeti.subject.YemekSepetiData;
import com.ataybur.observer.yemeksepeti.utils.YemekSepetiMessageSupplier;

public class YemekSepetiMerkezDigiturk {

	public static void main(String[] args) {
		YemekSepetiData yemekSepetiData = new YemekSepetiData();
		WebPageDisplay<YemekSepetiDto> webPageDisplay = new WebPageDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
			double fiyat = iData.getFiyat();
			double maksIndirimOrani = iData.getMaksIndirimOrani();
			return fiyat - (fiyat * ((maksIndirimOrani * 0.01)) * 0.30);
		}));
		webPageDisplay.subscribe();
		MobilCihazlarDisplay<YemekSepetiDto> mobilCihazlarDisplay = new IPhoneDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
			double indirim = 0.5;
			double fiyat = iData.getFiyat();
			double maksIndirimOrani = iData.getMaksIndirimOrani();
			return fiyat - (fiyat * ((maksIndirimOrani * 0.01)) * indirim);
		}));
		mobilCihazlarDisplay.subscribe();
		DigiturkDisplay<YemekSepetiDto> digiturkDisplay = new DigiturkDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
			double fiyat = iData.getFiyat();
			double maksIndirimOrani = iData.getMaksIndirimOrani();
			return fiyat - (fiyat * ((maksIndirimOrani * 0.01)) * 0);
		}));
		digiturkDisplay.subscribe();

		yemekSepetiData.setProduct("Hamburger menu", 21, 5);
		System.out.println("-----------------------");
		yemekSepetiData.setProduct("Fasulyeli Pilav", 18, 10);
		System.out.println("-----------------------");
		yemekSepetiData.setProduct("Kofteci Ramizz", 25, 7);
	}
}
