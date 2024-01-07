package vincebae.chat.client.adapter.out.chatservice.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import vincebae.chat.client.app.port.out.ChatService;
import vincebae.chat.shared.payload.chat.MessageRequest;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.SessionRequest;
import vincebae.chat.shared.payload.chat.SessionResponse;

/** Output adapter to Chat server using REST protocol. */
@ApplicationScoped
class ChatServiceRestAdapter implements ChatService {

  private final ChatServiceRestClient chatServerRestClient;

  @Inject
  ChatServiceRestAdapter(ChatServiceRestClient chatServerRestClient) {
    this.chatServerRestClient = chatServerRestClient;
  }

  @Override
  public SessionResponse session(SessionRequest request) {
    return chatServerRestClient.session(request);
  }

  @Override
  public MessageResponse message(MessageRequest request) {
    return chatServerRestClient.message(request);
  }
}
