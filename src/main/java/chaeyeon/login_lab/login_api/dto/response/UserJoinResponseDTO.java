package chaeyeon.login_lab.login_api.dto.response;

import chaeyeon.login_lab.login_api.domain.Roles;
import chaeyeon.login_lab.login_api.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class UserJoinResponseDTO {
    private final Long id;
    private final String name;
    private final String loginId;
    private final Roles role;
    private final LocalDateTime createdAt;

    public static UserJoinResponseDTO fromEntity(User user) {
        return new UserJoinResponseDTO(user.getId(), user.getName(), user.getLoginId(), user.getRole(), user.getCreatedAt());
    }
}
