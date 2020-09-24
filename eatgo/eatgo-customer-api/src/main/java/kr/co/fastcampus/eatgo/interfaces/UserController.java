package kr.co.fastcampus.eatgo.interfaces;

import jdk.internal.net.http.common.ImmutableExtendedSSLSession;
import kr.co.fastcampus.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User resource) throws URISyntaxException {
//
        @NotEmpty String email = resource.getEmail();
        @NotEmpty String name = resource.getName();
        String password = resource.getPassword();

//        User user = User.builder()
//                .id(1004L)
//                .email(email)
//                .name(name)
//                .password(password)
//                .build();


        User user = userService.registerUser(email, name, password);
        String url = "/users/" + user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
