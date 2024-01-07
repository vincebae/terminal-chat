package vincebae.chat.client.app.port.out;

import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

/** Interface to define interactions with Chat server. */
public interface ChatService {

  SessionResponse session(SessionRequest request);

  MessageResponse message(MessageRequest request);
}
