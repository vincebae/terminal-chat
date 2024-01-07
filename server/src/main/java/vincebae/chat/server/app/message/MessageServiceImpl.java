package vincebae.chat.server.app.message;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import vincebae.chat.server.app.port.in.MessageService;
import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.Result;

/** MessageServiceImpl */
@ApplicationScoped
public class MessageServiceImpl implements MessageService {

  @Override
  public MessageResponse handleMessage(MessageRequest request) {
    Log.info("Received message request: " + request);
    final var response = new MessageResponse(Result.OK);
    Log.info("Sent message response: " + response);
    return response;
  }
}
