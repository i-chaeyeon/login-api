package chaeyeon.login_lab.login_api;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor // Lombok이 final 필드를 가진 생성자를 자동 생성해줌
@EnableWebSecurity // Spring Security 보안을 웹 애플리케이션에 활성화함
@Configuration // 이 클래스가 스프링 설정 클래스임을 나타냄
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests( (auth) ->
                auth.anyRequest().permitAll() // 로그인 페이지가 나오지 않게 설정
            );
        return http.build(); // 위를 바탕으로 SecurityFilterChain 객체 생성, Spring Security에 적용
    }
}
