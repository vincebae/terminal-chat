package vincebae.chat.client.adapter.out.chatservice.restclient;

import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import java.net.URI;

/** Class to config {@code ChatServerRestClient}. */
@ApplicationScoped
class ChatServiceRestClientConfig {

  private static final URI BASE_URI = URI.create("http://localhost:8080");

  @ApplicationScoped
  @Produces
  ChatServiceRestClient produceChatServerRestClient() {
    return QuarkusRestClientBuilder.newBuilder()
        .baseUri(BASE_URI)
        .build(ChatServiceRestClient.class);
  }
}
