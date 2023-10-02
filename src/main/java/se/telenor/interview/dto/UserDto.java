package se.telenor.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private String personalNumber;
    private String phoneNumber;
}
