package vincebae.chat.client.app.chatclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;
import vincebae.chat.client.app.chatclient.ChatClientConfig.ChatClientParams;
import vincebae.chat.client.app.port.in.ChatClient;
import vincebae.chat.client.app.port.out.ChatService;
import vincebae.chat.shared.payload.chat.MessageRequestBuilder;
import vincebae.chat.shared.payload.chat.SessionRequest;

@ApplicationScoped
public final class ChatClientImpl implements ChatClient {

  private static final String USER_PROMPT = "> ";
  private static final String EXIT_COMMAND = "/q";

  private final InputStream inputStream;
  private final PrintStream printStream;
  private final ChatService chatService;

  @Inject
  ChatClientImpl(
      @ChatClientParams InputStream inputStream,
      @ChatClientParams PrintStream printStream,
      ChatService chatService) {
    this.inputStream = inputStream;
    this.printStream = printStream;
    this.chatService = chatService;
  }

  @Override
  public void start(Optional<String> name, Optional<String> session) {
    final var nameString = name.orElseGet(this::randomName);
    connectToSession(nameString, session);
    chatLoop(nameString);
  }

  private void connectToSession(String nameString, Optional<String> session) {
    final var sessionRequest = new SessionRequest(nameString, session);
    final var sessionResponse = chatService.session(sessionRequest);
    printStream.println("Session response: " + sessionResponse);
  }

  private void chatLoop(String name) {
    try (final var scanner = new Scanner(inputStream)) {
      printPrompt(name);
      while (scanner.hasNextLine()) {
        printStream.flush();
        final var line = scanner.nextLine();
        if (line.equals(EXIT_COMMAND)) {
          break;
        }
        final var reply = message(name, line);
        printStream.println(reply);
        printPrompt(name);
      }
    }
    printStream.println("Exit chat");
  }

  private String randomName() {
    return "random-name";
  }

  private String message(String name, String line) {
    final var messageRequest = new MessageRequestBuilder().sender(name).message(line).build();
    final var messageResponse = chatService.message(messageRequest);
    return messageResponse.result().toString();
  }

  private void printPrompt(String name) {
    printStream.print(USER_PROMPT);
  }
}
