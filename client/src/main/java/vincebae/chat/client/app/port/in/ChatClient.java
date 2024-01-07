package vincebae.chat.client.app.port.in;

import java.util.Optional;

public interface ChatClient {
  void start(Optional<String> name, Optional<String> session);
}
