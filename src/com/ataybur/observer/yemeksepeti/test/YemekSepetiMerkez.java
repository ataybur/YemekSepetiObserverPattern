package com.ataybur.observer.yemeksepeti.test;

import com.ataybur.observer.yemeksepeti.observers.AndroidDisplay;
import com.ataybur.observer.yemeksepeti.observers.DigiturkDisplay;
import com.ataybur.observer.yemeksepeti.observers.GoogleGlassDisplay;
import com.ataybur.observer.yemeksepeti.observers.WebPageDisplay;
import com.ataybur.observer.yemeksepeti.observers.abstracts.MobilCihazlarDisplay;
import com.ataybur.observer.yemeksepeti.pojo.WeatherForecastDto;
import com.ataybur.observer.yemeksepeti.pojo.WeatherForecastMessageSupplier;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiDto;
import com.ataybur.observer.yemeksepeti.pojo.YemekSepetiMessageSupplier;
import com.ataybur.observer.yemeksepeti.subject.WeatherForecastData;
import com.ataybur.observer.yemeksepeti.subject.YemekSepetiData;

public class YemekSepetiMerkez {

    public static void main(String[] args) {
	YemekSepetiData yemekSepetiData = new YemekSepetiData();
	WeatherForecastData weatherForecastData = new WeatherForecastData();
	WebPageDisplay<YemekSepetiDto> webPageDisplay = new WebPageDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
	    double fiyat = iData.getFiyat();
	    double maksIndirimOrani = iData.getMaksIndirimOrani();
	    return fiyat - (fiyat * ((maksIndirimOrani * 0.01)) * 0.30);
	}));
	webPageDisplay.subscribe();

	WebPageDisplay<WeatherForecastDto> webPageDisplay2 = new WebPageDisplay<WeatherForecastDto>(weatherForecastData, new WeatherForecastMessageSupplier());
	webPageDisplay2.subscribe();

	MobilCihazlarDisplay<WeatherForecastDto> mobilCihazlarDisplay2 = new AndroidDisplay<WeatherForecastDto>(weatherForecastData, new WeatherForecastMessageSupplier());
	mobilCihazlarDisplay2.subscribe();

	MobilCihazlarDisplay<YemekSepetiDto> mobilCihazlarDisplay = new AndroidDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
	    double indirim = 0.6;
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

	GoogleGlassDisplay<YemekSepetiDto> googleGlassDisplay = new GoogleGlassDisplay<YemekSepetiDto>(yemekSepetiData, new YemekSepetiMessageSupplier((iData) -> {
	    double indirim = 0.7;
	    double fiyat = iData.getFiyat();
	    double maksIndirimOrani = iData.getMaksIndirimOrani();
	    return fiyat - (fiyat * ((maksIndirimOrani * 0.01) * indirim));
	}));
	googleGlassDisplay.subscribe();

	yemekSepetiData.setProduct("Hamburger menu", 21, 50); // %50 ye kadar
							      // indirim
							      // olabilir.
	System.out.println("-----------------------");
	yemekSepetiData.setProduct("Fasulyeli Pilav", 18, 10); // %10 ye kadar
							       // indirim
							       // olabilir.
	System.out.println("-----------------------");
	yemekSepetiData.setProduct("Kofteci Ramiz", 25, 7);// %7 ye kadar
							   // indirim
							   // olabilir.
	System.out.println("-----------------------");
	weatherForecastData.setForecast("Istanbul", 23);
	System.out.println("-----------------------");
	weatherForecastData.setForecast("Aydin", 45);
    }
}
