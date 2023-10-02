package se.telenor.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.telenor.interview.dto.SwitchNumbersDto;
import se.telenor.interview.dto.UserDto;
import se.telenor.interview.service.Numbers;
import se.telenor.interview.service.Users;

import java.util.List;

@RestController
public class InterviewController {

    @Autowired
    private Numbers numbers;

    @Autowired
    private Users users;

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

    @PutMapping("/v1/switch/numbers")
    public ResponseEntity<SwitchNumbersDto> switchNumbers(@RequestBody SwitchNumbersDto switchNumbersDto) {
        return ResponseEntity.ok(numbers.switchNumbers(switchNumbersDto));
    }

    @PostMapping("/v1/user")
    public ResponseEntity<String> registerUser(@RequestBody UserDto dto) {
        return ResponseEntity.ok(users.registerUser(dto));
    }
}
