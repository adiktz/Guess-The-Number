package ravi.gaurav;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(getMaxNumber());
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }
}
