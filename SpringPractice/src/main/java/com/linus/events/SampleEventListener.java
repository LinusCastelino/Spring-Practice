package com.linus.events;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class SampleEventListener implements ApplicationListener {
	
	private static final Log logger = LogFactory.getLog(SampleEventListener.class);
	
	public void onApplicationEvent(ApplicationEvent ae) {
		logger.info("Event occurred : "+ae.getSource() +" :: "+ ae.getTimestamp() 
			+" :: "+ ae.hashCode() + 
			((ae.getSource() instanceof String)?" :: "+ae.getSource().toString():""));
	}

}
