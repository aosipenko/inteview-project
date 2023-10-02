package se.telenor.interview.service;

import org.springframework.stereotype.Component;
import se.telenor.interview.dto.UserDto;

@Component
public class Users {

    public String registerUser(UserDto dto) {
        validateName(dto.getFirstName());
        validateName(dto.getLastName());
        if (dto.getPersonalNumber().length() != 12) {
            throw new RuntimeException("Personal Number must be 12 digits only!");
        }
        if (dto.getPhoneNumber().startsWith("+")) {
            if (!dto.getPhoneNumber().startsWith("+46072") || dto.getPhoneNumber().length() != 13) {
                throw new RuntimeException("Bad phone number format!");
            }
        } else {
            if (!dto.getPhoneNumber().startsWith("46072") && dto.getPhoneNumber().length() != 12) {
                throw new RuntimeException("Bad phone number format!");
            }
        }
        return "OK";
    }

    private void validateName(String value) {
        if (value.isEmpty()) {
            throw new RuntimeException("Field is empty!");
        }
    }
}
