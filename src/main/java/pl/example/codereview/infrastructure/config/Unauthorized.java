package pl.example.codereview.infrastructure.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.UNAUTHORIZED, reason = "You need to log in")
public class Unauthorized extends RuntimeException {
}
