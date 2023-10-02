package se.telenor.interview.service;

import org.springframework.stereotype.Component;
import se.telenor.interview.dto.SwitchNumbersDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Numbers {

    private final static Random RANDOM = new Random();

    public List<String> getNumbers(int amount) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            result.add(generateNumber());
        }
        return result;
    }

    private String generateNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("+47072");
        for (int i = 0; i < 8; i++) {
            stringBuffer.append(RANDOM.nextInt(9));
        }
        return stringBuffer.toString();
    }

    public SwitchNumbersDto switchNumbers(SwitchNumbersDto switchNumbersDto) {
        validateNumber(switchNumbersDto.getNewNumber());
        validateNumber(switchNumbersDto.getOldNumber());
        return SwitchNumbersDto.builder().newNumber(switchNumbersDto.getNewNumber()).build();
    }

    private void validateNumber(String number) {
        if (number.startsWith("+")) {
            if (!number.startsWith("+47072") || !(number.length() == 13)) {
                throw new RuntimeException("Bad number formatting!");
            }
        } else {
            if (!number.startsWith("47072") || !(number.length() == 12)) {
                throw new RuntimeException("Bad number formatting!");
            }
        }
    }
}
