package org.wickedsource.wicket_mdc_example;

import org.apache.log4j.MDC;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.cycle.AbstractRequestCycleListener;
import org.apache.wicket.request.cycle.RequestCycle;

public class AddSessionIdToMdcListener extends AbstractRequestCycleListener {

	@Override
	public void onBeginRequest(RequestCycle cycle) {
		super.onBeginRequest(cycle);
		WebSession session = WebSession.get();

		// the check on isTemporary() is necessary, since temporary sessions
		// have a NULL sessionId
		if (!session.isTemporary()) {
			MDC.put("sessionId", session.getId());
		}
	}

}
