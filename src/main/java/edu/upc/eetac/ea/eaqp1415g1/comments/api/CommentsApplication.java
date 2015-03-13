package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class CommentsApplication extends ResourceConfig {
	public CommentsApplication() {
		super();
		register(DeclarativeLinkingFeature.class);
	}
}
