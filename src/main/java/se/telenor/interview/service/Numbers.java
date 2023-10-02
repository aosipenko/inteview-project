package se.telenor.interview.service;

import org.springframework.stereotype.Component;

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
}
