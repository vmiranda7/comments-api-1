package edu.upc.eetac.ea.eaqp1415g1.comments.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;

import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.Message;
import edu.upc.eetac.ea.eaqp1415g1.comments.api.model.MessageCollection;

@Path("/comments")
public class MessageResource {
	Manager man = new ManagerImpl();

	@POST
	@Path("/{username}")
	@Consumes(MediaType.COMMENTS_API_COMMENT)
	@Produces(MediaType.COMMENTS_API_COMMENT)
	public Message addMessage(@PathParam("username") String username, Message message) {
		man.addMessage(username, message);

		return message;
	}

	@PUT
	@Path("/{username}/{commentid}")
	@Consumes(MediaType.COMMENTS_API_COMMENT)
	@Produces(MediaType.COMMENTS_API_COMMENT)
	public Message updateMessage(@PathParam("username") String username, @PathParam("commentid") int commentid, Message message) {
		Message m = man.updateMessage(username, commentid, message);

		return m;
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.COMMENTS_API_COMMENT_COLLECTION)
	public MessageCollection getMessages(@PathParam("username") String username) {
		MessageCollection messages = man.getMessagesByUser(username);

		return messages;
	}

	@DELETE
	@Path("/{username}/{commentid}")
	public void deleteMessage(@PathParam("username") String username, @PathParam("commentid") int commentid) {
		man.deleteMessage(username, commentid);
	}

	// // @POST
	// // @Consumes(MediaType.COMMENTS_API_COMMENT)
	// // @Produces(MediaType.COMMENTS_API_COMMENT)
	// // public Message createComment(Message comment) {
	// // try {
	// // checkUserExists(comment.getUsername());
	// //
	// // String file = "/home/yandrak/ea-projects/comments-api/comments.txt";
	// // FileWriter fw = new FileWriter(file, true);
	// // fw.write(comment.getUsername() + "-" + comment.getCommentid() + "-"
	// // + comment.getContent() + "\n");
	// // fw.close();
	// // } catch (IOException ioe) {
	// // System.err.println("IOException: " + ioe.getMessage());
	// // }
	// //
	// // return comment;
	// // }
	// //
	// // @GET
	// // @Produces(MediaType.COMMENTS_API_COMMENT_COLLECTION)
	// // public MessageCollection getComments() {
	// // MessageCollection comments = getCommentsFromFile();
	// //
	// // return comments;
	// // }
	// //
	// // @DELETE
	// // @Path("/{commentid}")
	// // public void deleteUser(@PathParam("commentid") int commentid) {
	// // MessageCollection comments = getCommentsFromFile();
	// //
	// // if (!comments.getComments().containsKey(commentid)) {
	// // throw new WebApplicationException("Este comentario no existe",
	// // Status.CONFLICT);
	// // }
	// //
	// // comments.getComments().remove(commentid);
	// //
	// // try {
	// // String file = "/home/yandrak/ea-projects/comments-api/comments.txt";
	// // FileWriter fw = new FileWriter(file, false);
	// //
	// // Iterator<Integer> keySetIterator = comments.getComments().keySet()
	// // .iterator();
	// //
	// // while (keySetIterator.hasNext()) {
	// // Integer key = keySetIterator.next();
	// // Message comment = comments.getComments().get(key);
	// // fw.write(comment.getUsername() + "-" + comment.getCommentid()
	// // + "-" + comment.getContent() + "\n");
	// // }
	// //
	// // fw.close();
	// // } catch (IOException ioe) {
	// // System.err.println("IOException: " + ioe.getMessage());
	// // }
	// // }
	// //
	// // @PUT
	// // @Path("/{commentid}")
	// // @Consumes(MediaType.COMMENTS_API_COMMENT)
	// // @Produces(MediaType.COMMENTS_API_COMMENT)
	// // public Message updateComment(@PathParam("commentid") int commentid,
	// Message comment) {
	// // MessageCollection comments = getCommentsFromFile();
	// //
	// // if (!comments.getComments().containsKey(commentid)) {
	// // throw new WebApplicationException("Este comentario no existe",
	// // Status.CONFLICT);
	// // }
	// //
	// // comments.getComments().remove(commentid);
	// // comments.getComments().put(commentid, comment);
	// //
	// // try {
	// // String file = "/home/yandrak/ea-projects/comments-api/comments.txt";
	// // FileWriter fw = new FileWriter(file, false);
	// //
	// // Iterator<Integer> keySetIterator = comments.getComments().keySet()
	// // .iterator();
	// //
	// // while (keySetIterator.hasNext()) {
	// // Integer key = keySetIterator.next();
	// // Message c = comments.getComments().get(key);
	// // fw.write(c.getUsername() + "-" + c.getCommentid()
	// // + "-" + c.getContent() + "\n");
	// // }
	// //
	// // fw.close();
	// // } catch (IOException ioe) {
	// // System.err.println("IOException: " + ioe.getMessage());
	// // }
	// //
	// // return comment;
	// // }
	// //
	// // private void checkUserExists(String username) {
	// // List<String> usernameList = getUsernamesFromFile();
	// //
	// // if (!usernameList.contains(username)) {
	// // throw new WebApplicationException("No existe este usuario",
	// // Status.CONFLICT);
	// // }
	// // }
	// //
	// // private List<String> getUsernamesFromFile() {
	// // List<String> usernameList = new LinkedList<>();
	// //
	// // try {
	// // String file = "/home/yandrak/ea-projects/comments-api/users.txt";
	// // BufferedReader br = new BufferedReader(new FileReader(file));
	// // String line;
	// // while ((line = br.readLine()) != null) {
	// // usernameList.add(line);
	// // }
	// // br.close();
	// // } catch (IOException ioe) {
	// // System.err.println("IOException: " + ioe.getMessage());
	// // }
	// //
	// // return usernameList;
	// // }
	// //
	// // private MessageCollection getCommentsFromFile() {
	// // MessageCollection comments = new MessageCollection();
	// //
	// // try {
	// // String file = "/home/yandrak/ea-projects/comments-api/comments.txt";
	// // BufferedReader br = new BufferedReader(new FileReader(file));
	// // String line;
	// // while ((line = br.readLine()) != null) {
	// // String[] trozos = line.split("-");
	// // Message comment = new Message();
	// // comment.setUsername(trozos[0]);
	// // comment.setCommentid(Integer.parseInt(trozos[1]));
	// // comment.setContent(trozos[2]);
	// //
	// // comments.getComments().put(comment.getCommentid(), comment);
	// // }
	// // br.close();
	// // } catch (IOException ioe) {
	// // System.err.println("IOException: " + ioe.getMessage());
	// // }
	// //
	// // return comments;
	// // }
	//
	// // @GET
	// // @Produces(MediaType.BEETER_API_STING_COLLECTION)
	// // public StingCollection getStings(@QueryParam("length") int length,
	// // @QueryParam("before") long before, @QueryParam("after") long after) {
	// // StingCollection stings = new StingCollection();
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // boolean updateFromLast = after > 0;
	// // stmt = updateFromLast ? conn
	// // .prepareStatement(GET_STINGS_QUERY_FROM_LAST) : conn
	// // .prepareStatement(GET_STINGS_QUERY);
	// // if (updateFromLast) {
	// // stmt.setTimestamp(1, new Timestamp(after));
	// // } else {
	// // if (before > 0)
	// // stmt.setTimestamp(1, new Timestamp(before));
	// // else
	// // stmt.setTimestamp(1, null);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(2, length);
	// // }
	// // ResultSet rs = stmt.executeQuery();
	// // boolean first = true;
	// // long oldestTimestamp = 0;
	// // while (rs.next()) {
	// // Sting sting = new Sting();
	// // sting.setStingid(rs.getInt("stingid"));
	// // sting.setUsername(rs.getString("username"));
	// // //sting.setAuthor(rs.getString("name"));
	// // sting.setSubject(rs.getString("subject"));
	// // sting.setContent(rs.getString("content"));
	// // oldestTimestamp = rs.getTimestamp("last_modified").getTime();
	// // sting.setLastModified(oldestTimestamp);
	// // if (first) {
	// // first = false;
	// // stings.setNewestTimestamp(sting.getLastModified());
	// // }
	// // stings.addSting(sting);
	// // }
	// // stings.setOldestTimestamp(oldestTimestamp);
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return stings;
	// // }
	// //
	// // // Obtener colección de libros por subject y content
	// // @GET
	// // @Path("/search")
	// // @Produces(MediaType.BEETER_API_STING_COLLECTION)
	// // public StingCollection getStings(@QueryParam("length") int length,
	// // @QueryParam("subject") String subject,
	// // @QueryParam("content") String content) {
	// // StingCollection stings = new StingCollection();
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // if (subject == null && content == null) {
	// // stmt = conn.prepareStatement(GET_STINGS_QUERY);
	// // stmt.setTimestamp(1, null);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(2, length);
	// // } else if (subject != null && content == null) {
	// // stmt = conn.prepareStatement(GET_STINGS_QUERY_BY_SUBJECT);
	// // // Coger resultados que contengan el patrón "%subject%"
	// // String t = "%" + subject + "%";
	// // stmt.setString(1, t);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(2, length);
	// // } else if (subject == null && content != null) {
	// // stmt = conn.prepareStatement(GET_STINGS_QUERY_BY_CONTENT);
	// // // Coger resultados que contengan el patrón "%content%"
	// // String t = "%" + content + "%";
	// // stmt.setString(1, t);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(2, length);
	// // } else if (subject != null && content != null) {
	// // stmt = conn
	// // .prepareStatement(GET_STINGS_QUERY_BY_SUBJECT_AND_CONTENT);
	// // // Coger resultados que contengan el patrón de subject y content
	// // String t = "%" + subject + "%";
	// // stmt.setString(1, t);
	// // String t1 = "%" + content + "%";
	// // stmt.setString(2, t1);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(3, length);
	// // }
	// //
	// // ResultSet rs = stmt.executeQuery();
	// // boolean first = true;
	// // long oldestTimestamp = 0;
	// // while (rs.next()) {
	// // Sting sting = new Sting();
	// // sting.setStingid(rs.getInt("stingid"));
	// // sting.setUsername(rs.getString("username"));
	// // sting.setAuthor(rs.getString("name"));
	// // sting.setSubject(rs.getString("subject"));
	// // sting.setContent(rs.getString("content"));
	// // oldestTimestamp = rs.getTimestamp("last_modified").getTime();
	// // sting.setLastModified(oldestTimestamp);
	// // if (first) {
	// // first = false;
	// // stings.setNewestTimestamp(sting.getLastModified());
	// // }
	// // stings.addSting(sting);
	// // }
	// // stings.setOldestTimestamp(oldestTimestamp);
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return stings;
	// // }
	// //
	// // // Obtener stings de un usuario sin QueryParams
	// // @GET
	// // @Path("/{username}")
	// // @Produces(MediaType.BEETER_API_STING_COLLECTION)
	// // public StingCollection getStingsFromUser(
	// // @PathParam("username") String username,
	// // @QueryParam("length") int length,
	// // @QueryParam("before") long before, @QueryParam("after") long after) {
	// // StingCollection stings = new StingCollection();
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // stmt = conn.prepareStatement(GET_STINGS_FROM_USER_QUERY);
	// //
	// // boolean updateFromLast = after > 0;
	// // if (updateFromLast) {
	// // stmt.setTimestamp(1, new Timestamp(after));
	// // } else {
	// // if (before > 0)
	// // stmt.setTimestamp(1, new Timestamp(before));
	// // else
	// // stmt.setTimestamp(1, null);
	// //
	// // stmt.setString(2, username);
	// // length = (length <= 0) ? 5 : length;
	// // stmt.setInt(3, length);
	// // }
	// //
	// // ResultSet rs = stmt.executeQuery();
	// // boolean first = true;
	// // long oldestTimestamp = 0;
	// // while (rs.next()) {
	// // Sting sting = new Sting();
	// // sting.setStingid(rs.getInt("stingid"));
	// // sting.setUsername(rs.getString("username"));
	// // sting.setAuthor(rs.getString("name"));
	// // sting.setSubject(rs.getString("subject"));
	// // oldestTimestamp = rs.getTimestamp("last_modified").getTime();
	// // sting.setLastModified(oldestTimestamp);
	// // if (first) {
	// // first = false;
	// // stings.setNewestTimestamp(sting.getLastModified());
	// // }
	// // stings.addSting(sting);
	// // }
	// // stings.setOldestTimestamp(oldestTimestamp);
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return stings;
	// // }
	// //
	// // @GET
	// // @Path("/{stingid}")
	// // @Produces(MediaType.BEETER_API_STING)
	// // public Response getSting(@PathParam("stingid") String stingid,
	// // @Context Request request) {
	// // // En este caso, como se devuelve un Response, tenemos que construir
	// // // nosotros la respueta
	// //
	// // // Create CacheControl
	// // CacheControl cc = new CacheControl();
	// //
	// // Sting sting = getStingFromDatabase(stingid); // Recuperar recurso de
	// BD
	// //
	// // // Calculate the ETag on last modified date of user resource
	// // EntityTag eTag = new
	// EntityTag(Long.toString(sting.getLastModified()));
	// //
	// // // Verify if it matched with etag available in http request
	// // Response.ResponseBuilder rb = request.evaluatePreconditions(eTag);
	// //
	// // // If ETag matches the rb will be non-null;
	// // // Use the rb to return the response without any further processing
	// // if (rb != null) {
	// // return rb.cacheControl(cc).tag(eTag).build();
	// // }
	// //
	// // // If rb is null then either it is first time request; or resource is
	// // // modified
	// // // Get the updated representation and return with Etag attached to it
	// // rb = Response.ok(sting).cacheControl(cc).tag(eTag); // ok = status
	// 200OK
	// //
	// // return rb.build();
	// // }
	// //
	// // // Crear un sting
	// // // Consumes/Produces = tipo de datos que consume/produce
	// // @POST
	// // @Consumes(MediaType.BEETER_API_STING)
	// // @Produces(MediaType.BEETER_API_STING)
	// // public Sting createSting(Sting sting) {
	// //
	// // validateSting(sting); // Comprobamos que es un Sting válido antes de
	// // // añadir
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // stmt = conn.prepareStatement(INSERT_STING_QUERY,
	// // Statement.RETURN_GENERATED_KEYS); // Este return pide que le
	// // // devuelvan la Primary
	// // // Key autogenerada (en
	// // // la BD es un
	// // // autoincrement)
	// // // Damos valor a los datos
	// // // stmt.setString(1, sting.getUsername());
	// // // Ahora no se consigue el nombre desde JSON, sino que se coje del
	// // // propio usuario autorizado
	// // stmt.setString(1, security.getUserPrincipal().getName());
	// // stmt.setString(2, sting.getSubject());
	// // stmt.setString(3, sting.getContent());
	// // // stmt.setString(2, sting.getSubject());
	// // // stmt.setString(3, sting.getContent());
	// // stmt.executeUpdate(); // Metemos en la BD
	// // ResultSet rs = stmt.getGeneratedKeys();
	// // if (rs.next()) {
	// // int stingid = rs.getInt(1);
	// //
	// // sting = getStingFromDatabase(Integer.toString(stingid)); //
	// Recuperamos
	// // // el
	// // // sting creado
	// // } else {
	// // // Something has failed...
	// // }
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return sting;
	// // }
	// //
	// // private void validateSting(Sting sting) {
	// // if (sting.getSubject() == null)
	// // throw new BadRequestException("Subject can't be null.");
	// // if (sting.getContent() == null)
	// // throw new BadRequestException("Content can't be null.");
	// // if (sting.getSubject().length() > 100)
	// // throw new BadRequestException(
	// // "Subject can't be greater than 100 characters.");
	// // if (sting.getContent().length() > 500)
	// // throw new BadRequestException(
	// // "Content can't be greater than 500 characters.");
	// // }
	// //
	// // @DELETE
	// // @Path("/{stingid}")
	// // public void deleteSting(@PathParam("stingid") String stingid) {
	// // validateUser(stingid);
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // stmt = conn.prepareStatement(DELETE_STING_QUERY);
	// // stmt.setInt(1, Integer.valueOf(stingid));
	// //
	// // int rows = stmt.executeUpdate();
	// // if (rows == 0)
	// // throw new NotFoundException("There's no sting with stingid="
	// // + stingid);
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// // }
	// //
	// // @PUT
	// // @Path("/{stingid}")
	// // @Consumes(MediaType.BEETER_API_STING)
	// // @Produces(MediaType.BEETER_API_STING)
	// // public Sting updateSting(@PathParam("stingid") String stingid, Sting
	// // sting) {
	// // validateUser(stingid);
	// //
	// // validateUpdateSting(sting);
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // stmt = conn.prepareStatement(UPDATE_STING_QUERY);
	// // stmt.setString(1, sting.getSubject());
	// // stmt.setString(2, sting.getContent());
	// // stmt.setInt(3, Integer.valueOf(stingid));
	// //
	// // int rows = stmt.executeUpdate();
	// // if (rows == 1)
	// // sting = getStingFromDatabase(stingid);
	// // else {
	// // throw new NotFoundException("There's no sting with stingid="
	// // + stingid);
	// // }
	// //
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return sting;
	// // }
	// //
	// // // Método recuperar sting de la BD
	// // private Sting getStingFromDatabase(String stingid) {
	// // Sting sting = new Sting();
	// //
	// // Connection conn = null;
	// // try {
	// // conn = ds.getConnection();
	// // } catch (SQLException e) {
	// // throw new ServerErrorException("Could not connect to the database",
	// // Response.Status.SERVICE_UNAVAILABLE);
	// // }
	// //
	// // PreparedStatement stmt = null;
	// // try {
	// // stmt = conn.prepareStatement(GET_STING_BY_ID);
	// // stmt.setInt(1, Integer.valueOf(stingid));
	// //
	// // ResultSet rs = stmt.executeQuery();
	// // if (rs.next()) {
	// //
	// // sting.setStingid(rs.getInt("stingid"));
	// // sting.setUsername(rs.getString("username"));
	// // //sting.setAuthor(rs.getString("name"));
	// // sting.setSubject(rs.getString("subject"));
	// // sting.setContent(rs.getString("content"));
	// // sting.setLastModified(rs.getTimestamp("last_modified")
	// // .getTime());
	// // sting.setCreationTimestamp(rs
	// // .getTimestamp("creation_timestamp").getTime());
	// // } else {
	// // throw new NotFoundException("There's no sting with stingid="
	// // + stingid);
	// // }
	// // } catch (SQLException e) {
	// // throw new ServerErrorException(e.getMessage(),
	// // Response.Status.INTERNAL_SERVER_ERROR);
	// // } finally {
	// // try {
	// // if (stmt != null)
	// // stmt.close();
	// // conn.close();
	// // } catch (SQLException e) {
	// // }
	// // }
	// //
	// // return sting;
	// // }
	// //
	// // // Método de validación de Update
	// // private void validateUpdateSting(Sting sting) {
	// // if (sting.getSubject() != null && sting.getSubject().length() > 100)
	// // throw new BadRequestException(
	// // "Subject can't be greater than 100 characters.");
	// // if (sting.getContent() != null && sting.getContent().length() > 500)
	// // throw new BadRequestException(
	// // "Content can't be greater than 500 characters.");
	// // }
	// //
	// // // Método de validación de usuario
	// // private void validateUser(String stingid) {
	// // Sting sting = getStingFromDatabase(stingid);
	// // String username = sting.getUsername();
	// // if (!security.getUserPrincipal().getName().equals(username))
	// // throw new ForbiddenException(
	// // "You are not allowed to modify this sting.");
	// // }
	// //
	// // // Esto sirve para poder trabajar con cualquier parámetro de seguridad
	// // @Context
	// // private SecurityContext security;
}