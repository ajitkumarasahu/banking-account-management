package com.bank.management.util;

import java.security.SecureRandom;

/**
 * Utility class responsible for generating
 * secure and unique 16-digit account numbers.
 */
public class AccountNumberGenerator {

    /** SecureRandom provides better randomness than Random */
    private static final SecureRandom random = new SecureRandom();

    /**
     * Generates a 16-digit account number.
     * The first digit is always non-zero.
     *
     * @return 16-digit account number as String
     */
    public static String generate16Digit() {

        StringBuilder sb = new StringBuilder();

        // Ensure first digit is between 1 and 9 (cannot be 0)
        sb.append(random.nextInt(9) + 1);

        // Generate remaining 15 digits
        for (int i = 1; i < 16; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
