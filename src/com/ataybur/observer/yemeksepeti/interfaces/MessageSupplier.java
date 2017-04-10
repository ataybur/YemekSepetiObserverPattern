package com.ataybur.observer.yemeksepeti.interfaces;

public interface MessageSupplier<T extends IData> {
	public String supply(T iData, String observerName);
}
