package vincebae.chat.client.adapter.out.chatservice.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

/** Micro Profile REST Client interface to Chat Server. */
@Path("/chat")
interface ChatServiceRestClient {

  @POST
  @Path("/session")
  @Consumes(MediaType.APPLICATION_JSON)
  SessionResponse session(SessionRequest request);

  @POST
  @Path("/message")
  @Consumes(MediaType.APPLICATION_JSON)
  MessageResponse message(MessageRequest request);
}
