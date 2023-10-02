package se.telenor.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.telenor.interview.service.Numbers;

import java.util.List;

@RestController
public class InterviewController {

    @Autowired
    private Numbers numbers;

    @GetMapping("/v1/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("abc");
    }

    @GetMapping("/v1/numbers")
    public ResponseEntity<List<String>> getNumbers(@RequestParam(name = "amount") int amount) {
        if (amount < 0) {
            return ResponseEntity.ok(numbers.getNumbers(1));
        }
        if (amount > 10) {
            return ResponseEntity.ok(numbers.getNumbers(10));
        }
        return ResponseEntity.ok(numbers.getNumbers(amount));
    }
}
