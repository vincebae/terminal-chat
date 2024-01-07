package vincebae.chat.shared.payload.chat;

import java.util.Optional;

/** Response payload to estabilish a session from clients. */
public record SessionResponse(Result result, Optional<String> sessionId) {}
