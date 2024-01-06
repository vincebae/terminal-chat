package vincebae.chat.server.adapter.in;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import vincebae.chat.shared.message.SendRequest;
import vincebae.chat.shared.message.SendResponse;

@Path("/chat")
public class ChatResource {

  @GET
  @Path("/hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Hello from terminal chat server";
  }

  @POST
  @Path("/send")
  @Consumes(MediaType.APPLICATION_JSON)
  public SendResponse send(SendRequest request) {
    Log.info("Received send request: " + request);
    final var message = String.format("received: %s, from %s", request.message(), request.sender());
    final var response = new SendResponse(message);
    Log.info("Response: " + response);
    return response;
  }
}
