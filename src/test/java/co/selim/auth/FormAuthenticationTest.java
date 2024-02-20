package co.selim.auth;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.Map;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class FormAuthenticationTest {

    @TestHTTPResource("j_security_check")
    private URL url;

    @Test
    void returnsOkOnValidCredentials() {
        given()
                .formParams(
                        Map.of(
                                "j_username", "email@domain.com",
                                "j_password", "password"
                        )
                )
                .when()
                .post(url)
                .then()
                .statusCode(200);
    }

    @Test
    void returnsUnauthorizedOnInvalidCredentials() {
        given()
                .formParams(
                        Map.of(
                                "j_username", "email@domain.com",
                                "j_password", "123456"
                        )
                )
                .when()
                .post(url)
                .then()
                .statusCode(401);
    }
}
