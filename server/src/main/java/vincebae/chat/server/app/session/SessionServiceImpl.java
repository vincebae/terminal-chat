package vincebae.chat.server.app.session;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Optional;
import vincebae.chat.server.app.port.in.SessionService;
import vincebae.chat.shared.payload.chat.Result;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

/** SessionServiceImpl */
@ApplicationScoped
class SessionServiceImpl implements SessionService {

  private static final String DEFAULT_SESSION_NAME = "waitroom";

  @Override
  public SessionResponse connectSesion(SessionRequest request) {
    Log.info("Received session request: " + request);
    final var sessionId = request.sessionId().orElse(DEFAULT_SESSION_NAME);
    final var response = new SessionResponse(Result.OK, Optional.of("abcde"));
    Log.info("Sent session response: " + response);
    return response;
  }
}
