package edu.upc.eetac.ea.eaqp1415g1.comments.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.CommentsRootAPIResource;

//Es un POJO (no hereda de nada, atributos privados, getters y setters)
public class CommentsRootAPI {
	@InjectLinks({ @InjectLink(resource = CommentsRootAPIResource.class, style = Style.ABSOLUTE, rel = "self bookmark home", title = "Beeter Root API", method = "getRootAPI") })
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}