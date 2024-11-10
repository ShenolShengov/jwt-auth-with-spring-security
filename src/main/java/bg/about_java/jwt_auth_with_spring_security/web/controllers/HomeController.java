package bg.about_java.jwt_auth_with_spring_security.web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<Void> handleHome() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("api/info"));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }


    @GetMapping("/api/info")
    public String apiInfo() {
        return "App info";
    }


}
