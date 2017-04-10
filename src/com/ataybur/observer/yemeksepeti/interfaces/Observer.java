package com.ataybur.observer.yemeksepeti.interfaces;

public interface Observer<T extends IData> {
	public void update(T iData);
	public void subscribe();
	public void unSubscribe();
	public String getName();
}
