package net.bytebuddy.utility;

import java.util.Random;

public class RandomString {
    public static final int DEFAULT_LENGTH = 8;
    private static final int KEY_BITS;
    private static final char[] SYMBOL;
    private final int length;
    private final Random random;

    static {
        int i11;
        StringBuilder sb2 = new StringBuilder();
        for (char c11 = '0'; c11 <= '9'; c11 = (char) (c11 + 1)) {
            sb2.append(c11);
        }
        for (char c12 = 'a'; c12 <= 'z'; c12 = (char) (c12 + 1)) {
            sb2.append(c12);
        }
        for (char c13 = 'A'; c13 <= 'Z'; c13 = (char) (c13 + 1)) {
            sb2.append(c13);
        }
        char[] charArray = sb2.toString().toCharArray();
        SYMBOL = charArray;
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(charArray.length);
        if (Integer.bitCount(charArray.length) == numberOfLeadingZeros) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        KEY_BITS = numberOfLeadingZeros - i11;
    }

    public RandomString() {
        this(8);
    }

    public static String hashOf(int i11) {
        int i12;
        int i13 = KEY_BITS;
        int i14 = 32 / i13;
        if (32 % i13 == 0) {
            i12 = 0;
        } else {
            i12 = 1;
        }
        int i15 = i14 + i12;
        char[] cArr = new char[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            char[] cArr2 = SYMBOL;
            int i17 = KEY_BITS;
            cArr[i16] = cArr2[(-1 >>> (32 - i17)) & (i11 >>> (i16 * i17))];
        }
        return new String(cArr);
    }

    public static String make() {
        return make(8);
    }

    public String nextString() {
        char[] cArr = new char[this.length];
        for (int i11 = 0; i11 < this.length; i11++) {
            char[] cArr2 = SYMBOL;
            cArr[i11] = cArr2[this.random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public RandomString(int i11) {
        this(i11, new Random());
    }

    public static String make(int i11) {
        return new RandomString(i11).nextString();
    }

    public RandomString(int i11, Random random2) {
        if (i11 > 0) {
            this.length = i11;
            this.random = random2;
            return;
        }
        throw new IllegalArgumentException("A random string's length cannot be zero or negative");
    }
}
