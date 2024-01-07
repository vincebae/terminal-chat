package vincebae.chat.shared.payload.chat;

import org.immutables.builder.Builder;

/** Request record for "/chat/send" endpoint. */
public record MessageRequest(String sender, String message) {

  @Builder.Constructor
  public MessageRequest {}
}
