package com.ataybur.observer.yemeksepeti.observers.abstracts;

import com.ataybur.observer.yemeksepeti.constants.Constants;
import com.ataybur.observer.yemeksepeti.interfaces.IData;
import com.ataybur.observer.yemeksepeti.interfaces.Observer;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;

public abstract class AbstractObserver<T extends IData> implements Observer<T> {
	
	protected Subject<T> subject;
	protected String message;

	public AbstractObserver(Subject<T> subject) {
		this.subject = subject;
	}
	
	@Override
	public void subscribe() {
//		System.out.println("Subscribing " + userInfo + " to " + subject.subjectDetails() + " ...");
		this.subject.registerObserver(this);
		System.out.printf(Constants.REGISTERETION_COMPLETE_MESSAGE, getName());
	}

	@Override
	public void unSubscribe() {
//		System.out.println("Unsubscribing " + userInfo + " to " + subject.subjectDetails() + " ...");
		this.subject.removeObserver(this);
		System.out.printf(Constants.UNREGISTERETION_COMPLETE_MESSAGE, getName());
	}
}
