package org.example.service_a;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
@AllArgsConstructor
public class UserClientController {
    private final RestTemplate restTemplate = new RestTemplate();

    private final String USER_B_URL = "http://localhost:8181/users";

    @PostMapping("/sendUser")
    public ResponseEntity<User> sendUserToServiceB(@RequestBody User user) {
        System.out.println("отправляем пользователя в сервис Б -> " + user);

        User userSaved = restTemplate.postForObject(USER_B_URL, user, User.class);

        System.out.println("получили пользователя в сервис Б -> " + userSaved);

        return ResponseEntity.ok(userSaved);
    }

}
