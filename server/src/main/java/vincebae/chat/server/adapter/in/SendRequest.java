package vincebae.chat.server.adapter.in;

import org.immutables.builder.Builder;

/**
 * Request record for "/chat/send" endpoint.
 */
public record SendRequest(String sender, String message) {

  @Builder.Constructor
  public SendRequest {}
}
