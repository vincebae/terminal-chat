package vincebae.chat.server.adapter.in;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import vincebae.chat.shared.payload.chat.MessageRequestBuilder;
import vincebae.chat.shared.payload.chat.MessageResponse;
import vincebae.chat.shared.payload.chat.Result;

/** Tests for {@code ChatResource}. */
@QuarkusTest
class ChatResourceTest {

  @Test
  void helloEndpointTest() {
    final var body =
        given().when().get("/chat/hello").then().statusCode(200).extract().body().asString();
    assertThat(body).isEqualTo("Hello from terminal chat server");
  }

  @Test
  void sendMessageEndpointTest() {
    final var sendRequest =
        new MessageRequestBuilder().sender("sender name").message("some message").build();

    final var body =
        given()
            .header("Content-type", "application/json")
            .and()
            .body(sendRequest)
            .when()
            .post("/chat/message")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .as(MessageResponse.class);

    final var expected = new MessageResponse(Result.OK);
    assertThat(body).isEqualTo(expected);
  }
}
