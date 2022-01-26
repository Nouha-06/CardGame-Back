package com.univ.cardgame.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomInt {
    public static int rand(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
