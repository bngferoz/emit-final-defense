package com.feroz.apigateway.Fallback;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @Value("${fallbackResponse}")
    public String fallbackResponse;

    @GetMapping("/fallback")
    public ResponseEntity<String> fallback() {
        return new ResponseEntity<>(fallbackResponse, HttpStatus.REQUEST_TIMEOUT);
    }
}
