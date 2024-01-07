package vincebae.chat.client.adapter.out.chatservice.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import vincebae.chat.client.app.outport.ChatService;
import vincebae.chat.shared.message.SendRequest;
import vincebae.chat.shared.message.SendResponse;

/** Output adapter to Chat server using REST protocol. */
@ApplicationScoped
class ChatServiceRestAdapter implements ChatService {

  private final ChatServiceRestClient chatServerRestClient;

  @Inject
  ChatServiceRestAdapter(ChatServiceRestClient chatServerRestClient) {
    this.chatServerRestClient = chatServerRestClient;
  }

  @Override
  public SendResponse send(SendRequest request) {
    return chatServerRestClient.send(request);
  }
}
