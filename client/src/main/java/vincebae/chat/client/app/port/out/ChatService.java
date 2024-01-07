package vincebae.chat.client.app.port.out;

import vincebae.chat.shared.message.SendRequest;
import vincebae.chat.shared.message.SendResponse;

/** Interface to define interactions with Chat server. */
public interface ChatService {
  SendResponse send(SendRequest request);
}