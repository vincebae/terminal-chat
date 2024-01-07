package vincebae.chat.server.app.port.in;

import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;

/** MessageService */
public interface MessageService {

  public MessageResponse handleMessage(MessageRequest request);
}
