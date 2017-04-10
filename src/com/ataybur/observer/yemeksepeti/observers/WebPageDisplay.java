package com.ataybur.observer.yemeksepeti.observers;

import com.ataybur.observer.yemeksepeti.interfaces.DisplayElement;
import com.ataybur.observer.yemeksepeti.interfaces.IData;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.observers.abstracts.AbstractObserver;

public class WebPageDisplay<T extends IData> extends AbstractObserver<T> implements DisplayElement {
	private MessageSupplier<T> messageSupplier;
	public WebPageDisplay(Subject<T> subject,MessageSupplier<T> messageSupplier) {
		super(subject);
		this.messageSupplier = messageSupplier;
	}

	@Override
	public void update(T iData) {
		this.message = messageSupplier.supply(iData, getName());
		display();
	}

	@Override
	public void display() {
		System.out.println(this.message);
	}

	@Override
	public String getName() {
		return "WebPage";
	}
}
