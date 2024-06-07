package roomescape.infrastructure.jwt;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import roomescape.auth.MemberAuthorization;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void create_token() {
        String payload = "test";

        MemberAuthorization token = jwtProvider.createByPayload(payload);

        assertThat(token.authorization()).isNotNull();
    }
}