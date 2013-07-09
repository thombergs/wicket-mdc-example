package org.wickedsource.wicket_mdc_example;

import org.apache.log4j.Logger;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {

	private static Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new AjaxLink<Void>("logLink") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				// log output with a session Id
				logger.info("This is a logging test");
			}
		});

		// Wicket only creates a sessionId if a stateful page is rendered
		setStatelessHint(false);

	}
}
