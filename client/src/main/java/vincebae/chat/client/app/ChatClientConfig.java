package vincebae.chat.client.app;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Qualifier;
import jakarta.inject.Singleton;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class to config dependencies of ChatClient.
 *
 * <p>Note that Quarkus / Arc cannot inject {@code PrintStream} properly when it is declared as
 * {@code ApplicationScoped}, so it needs to be {@code Singleton}.
 */
@Singleton
class ChatClientConfig {

  @Qualifier
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
  @interface ChatClientParams {}

  @Singleton
  @Produces
  @ChatClientParams
  InputStream inputStream() {
    return System.in;
  }

  @Singleton
  @Produces
  @ChatClientParams
  PrintStream printStream() {
    return System.out;
  }
}
