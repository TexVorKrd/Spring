package ru.veb.web.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-service")
public interface UserAPI {

        @GetMapping()
        String home ();

        @GetMapping("/test")
        String test ();

}
