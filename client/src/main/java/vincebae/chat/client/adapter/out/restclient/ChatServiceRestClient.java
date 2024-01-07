package vincebae.chat.client.adapter.out.restclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import vincebae.chat.shared.message.SendRequest;
import vincebae.chat.shared.message.SendResponse;

/** Micro Profile REST Client interface to Chat Server. */
@Path("/chat")
interface ChatServiceRestClient {

  @POST
  @Path("/send")
  @Consumes(MediaType.APPLICATION_JSON)
  SendResponse send(SendRequest request);
}
