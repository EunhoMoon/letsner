package com.janek.letsner.common.utils;

import java.util.UUID;

public class TokenGenerator {

    private static final int TOKEN_LENGTH = 20;

    public static String randomCharacter() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String randomCharacterWithPrefix(String prefix) {
        return prefix + "_" + randomCharacter();
    }

}
