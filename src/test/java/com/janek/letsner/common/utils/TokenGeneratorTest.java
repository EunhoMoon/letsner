package com.janek.letsner.common.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenGeneratorTest {

    @Test
    @DisplayName("succeed generate random token with prefix")
    void tokenGenerateTest() {
        var token = TokenGenerator.getTokenWithPrefix("test");

        assertTrue(token.startsWith("test_"));
    }

}