package vincebae.chat.server.adapter.in;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Optional;
import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.Result;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

@Path("/chat")
public class ChatResource {

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
    Log.info("Received session request: " + request);
    final var response = new SessionResponse(Result.OK, Optional.of("abcde"));
    Log.info("Sent session response: " + response);
    return response;
  }

  @POST
  @Path("/message")
  @Consumes(MediaType.APPLICATION_JSON)
  public MessageResponse message(MessageRequest request) {
    Log.info("Received message request: " + request);
    final var response = new MessageResponse(Result.OK);
    Log.info("Sent message response: " + response);
    return response;
  }
}
