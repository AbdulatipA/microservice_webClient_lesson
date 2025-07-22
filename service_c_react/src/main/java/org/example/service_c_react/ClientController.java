package org.example.service_c_react;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final WebClient webClient;

    private final String USER_B_URL = "http://localhost:8181/users";

    @PostMapping("/sendUser")
    public Mono<ResponseEntity<User>> sendUserToServiceB(@RequestBody User user) {
        System.out.println("из сервиса C отправляем пользователя в сервис Б -> " + user);

        return webClient.post()
                .bodyValue(user)
                .retrieve()
                .bodyToMono(User.class)
                .map(returnUser -> {
                    System.out.println("получили пользователя в сервис Б -> " + returnUser);
                    return ResponseEntity.ok(returnUser);
                })
                .onErrorReturn(ResponseEntity.badRequest().build());
    }


    public ClientController(WebClient.Builder clientBuilder) {
        this.webClient = clientBuilder.baseUrl(USER_B_URL).build();
    }
}
