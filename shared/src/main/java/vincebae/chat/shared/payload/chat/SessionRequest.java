package vincebae.chat.shared.payload.chat;

import java.util.Optional;

/** Request payload to estabilish a session from clients. */
public record SessionRequest(String username, Optional<String> sessionId) {}
