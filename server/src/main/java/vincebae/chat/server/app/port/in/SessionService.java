package vincebae.chat.server.app.port.in;

import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

/** SessionService */
public interface SessionService {

  SessionResponse connectSesion(SessionRequest request);
}
