package chaeyeon.login_lab.login_api.dto.request;

import chaeyeon.login_lab.login_api.domain.Roles;
import chaeyeon.login_lab.login_api.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserJoinRequestDTO {
    private final String name;
    private final String loginId;

    @Getter // 암호화 전 서비스 계층에서 get할 수 있도록
    private final String password;

    // 암호화 된 비밀번호를 db에 저장
    public User toEntity(String encryptedPassword) {
        return User.builder()
                .name(name)
                .loginId(loginId)
                .password(encryptedPassword)
                .role(Roles.USER)
                .build();
    }
}
