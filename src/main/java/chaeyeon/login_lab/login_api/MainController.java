package chaeyeon.login_lab.login_api;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @GetMapping("/api1")
    public ResponseEntity api1() {

        return new ResponseEntity<>("api1 입니다.", HttpStatus.OK);
    }

    @GetMapping("/api2")
    public ResponseEntity api2() {

        return new ResponseEntity<>("api2 입니다.", HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity user(@AuthenticationPrincipal UserDetails userDetails) {

        return new ResponseEntity<>(userDetails.getUsername(), HttpStatus.OK);
    }
}
