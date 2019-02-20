package com.mulesoft.training;

import org.apache.log4j.*;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Callable;
import org.mule.api.lifecycle.Startable;

public class MuleLifecycleComponent implements Startable, Callable {

	private static final Logger logger = LogManager.getLogger("com.mulesoft.training.Logger");
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		logger.info("************** component executed **************");
		String correlationID = eventContext.getMessage().getUniqueId();
		logger.info(correlationID);
		return eventContext.getMessage(); // have to return the message otherwise mule crash
	}

	@Override
	public void start() throws MuleException {
		logger.info("************** component initiated startup **************");
	}

}
