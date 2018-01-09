package com.linus.events;

import org.springframework.context.ApplicationEvent;

public class SampleCustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	SampleCustomEvent(Object source){
		super(source);
	}

}
