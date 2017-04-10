package com.ataybur.observer.yemeksepeti.observers;

import com.ataybur.observer.yemeksepeti.interfaces.IData;
import com.ataybur.observer.yemeksepeti.interfaces.MessageSupplier;
import com.ataybur.observer.yemeksepeti.interfaces.Subject;
import com.ataybur.observer.yemeksepeti.observers.abstracts.MobilCihazlarDisplay;

public class IPhoneDisplay<T extends IData> extends MobilCihazlarDisplay<T> {

	public IPhoneDisplay(Subject<T> subject, MessageSupplier<T> messageSupplier) {
		super(subject, messageSupplier);
	}

	@Override
	public String getName() {
		return "IPhone";
	}
}
