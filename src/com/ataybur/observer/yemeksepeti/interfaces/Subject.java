package com.ataybur.observer.yemeksepeti.interfaces;

public interface Subject<T extends IData> {
	public void registerObserver(Observer<T> o);

	public void removeObserver(Observer<T> o);

	public void notifyObservers();
}
