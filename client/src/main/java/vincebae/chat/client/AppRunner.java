package vincebae.chat.client;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import vincebae.chat.client.adapter.in.ChatClient;

/** Entry point of the chat client application. */
@QuarkusMain
@Command(name = "terminal chat client", mixinStandardHelpOptions = true, version = "0.0.1")
public class AppRunner implements QuarkusApplication, Runnable {

  @Option(
      names = {"-n", "--name"},
      description = "Name")
  private String name;

  private final ChatClient chatClient;

  @Inject
  AppRunner(ChatClient chatClient) {
    this.chatClient = chatClient;
  }

  /** Entry point of Picocli. */
  @Override
  public void run() {
    System.out.println("Terminal chat client started.");
    chatClient.run();
    System.out.println("Terminal chat client stopping...");
  }

  /** Entry point of Quarkus Main. */
  @Override
  public int run(String... args) throws Exception {
    return new CommandLine(this).execute(args);
  }
}
