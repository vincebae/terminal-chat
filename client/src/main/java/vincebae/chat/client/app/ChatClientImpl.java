package vincebae.chat.client.app;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import vincebae.chat.client.app.ChatClientConfig.ChatClientParams;
import vincebae.chat.client.app.port.in.ChatClient;
import vincebae.chat.client.app.port.out.ChatService;
import vincebae.chat.shared.message.SendRequestBuilder;

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
  public void start(String name, String session) {
    try (final var scanner = new Scanner(inputStream)) {
      printPrompt();
      while (scanner.hasNextLine()) {
        printStream.flush();
        final var line = scanner.nextLine();
        if (line.equals(EXIT_COMMAND)) {
          break;
        }
        final var reply = sendMessage(line);
        printStream.println(reply);
        printPrompt();
      }
    }
    printStream.println("Exit chat");
  }

  private String sendMessage(String line) {
    final var sendRequest = new SendRequestBuilder().sender("mock sender").message(line).build();
    final var sendResponse = chatService.send(sendRequest);
    return sendResponse.message();
  }

  private void printPrompt() {
    printStream.print(USER_PROMPT);
  }
}
