package chaeyeon.login_lab.login_api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) ->
                        auth.anyRequest().authenticated() // 모든 요청은 인증 필요
                ) // formLogin 추가하면 클래스 만들지 않았을 때처럼 기본 로그인 화면 제공
                .formLogin((formLogin) ->
                        formLogin.usernameParameter("username") // 입력 폼 파라미터 지정
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 URL
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService() {
        // 사용자 정보를 메모리에 고정 저장하는 매니저 생성
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // 유저 등록: 로그인 시 조회할 대상
        manager.createUser(User
                .withUsername("user1")
                .password("1234")
                .build());

        // Spring Security가 내부적으로 사용하는 UserDetailsService 구현체 반환
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() { // 비밀번호를 암호화하지 않고 그대로 비교
        return NoOpPasswordEncoder.getInstance(); // 실무에서는 BCryptPasswordEncoder 등 안전한 인코더를 사용
    }
}
