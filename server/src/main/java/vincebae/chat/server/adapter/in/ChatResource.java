package vincebae.chat.server.adapter.in;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import vincebae.chat.server.app.port.in.MessageService;
import vincebae.chat.server.app.port.in.SessionService;
import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

@ApplicationScoped
@Path("/chat")
public class ChatResource {

  private final MessageService messageService;
  private final SessionService sessionService;

  @Inject
  ChatResource(MessageService messageService, SessionService sessionService) {
    this.messageService = messageService;
    this.sessionService = sessionService;
  }

  @GET
  @Path("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from terminal chat server";
  }

  @POST
  @Path("/session")
  @Consumes(MediaType.APPLICATION_JSON)
  public SessionResponse session(SessionRequest request) {
    return sessionService.connectSesion(request);
  }

  @POST
  @Path("/message")
  @Consumes(MediaType.APPLICATION_JSON)
  public MessageResponse message(MessageRequest request) {
    return messageService.handleMessage(request);
  }
}
