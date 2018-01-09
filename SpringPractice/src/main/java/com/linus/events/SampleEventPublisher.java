package com.linus.events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class SampleEventPublisher implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher applnEventPublisher;
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		applnEventPublisher= publisher;
	}
	
	public ApplicationEventPublisher getApplicationEventPublisher() {
		return applnEventPublisher;
	}
	
	public void publishEvent(String message) {
		getApplicationEventPublisher().publishEvent(new SampleCustomEvent(message));
	}
	
	public void publishEvent() {
		getApplicationEventPublisher().publishEvent(new SampleCustomEvent(this));
	}

}
