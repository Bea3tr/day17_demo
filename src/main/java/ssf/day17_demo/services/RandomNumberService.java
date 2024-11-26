package ssf.day17_demo.services;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomNumberService {

    private Random rand = new SecureRandom();

    public int getRandom(int bound) {
        return rand.nextInt(bound);
    }

    public int getRandom() {
        return rand.nextInt(100);
    }
    
}
