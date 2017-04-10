package com.ataybur.observer.yemeksepeti.observers;

import com.ataybur.observer.yemeksepeti.interfaces.IData;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.observers.abstracts.MobilCihazlarDisplay;

public class AndroidDisplay<T extends IData> extends MobilCihazlarDisplay<T> {

	public AndroidDisplay(Subject<T> subject, MessageSupplier<T> messageSupplier) {
		super(subject, messageSupplier);
	}

	@Override
	public String getName() {
		return "Android";
	}

}
