package com.ataybur.observer.yemeksepeti.observers.abstracts;

import com.ataybur.observer.yemeksepeti.interfaces.DisplayElement;
import com.ataybur.observer.yemeksepeti.interfaces.IData;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;

public abstract class MobilCihazlarDisplay<T extends IData> extends AbstractObserver<T> implements DisplayElement {
	private MessageSupplier<T> messageSupplier;

	public MobilCihazlarDisplay(Subject<T> subject, MessageSupplier<T> messageSupplier) {
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
}
