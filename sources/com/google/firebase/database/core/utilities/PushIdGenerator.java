package com.google.firebase.database.core.utilities;

import com.google.firebase.database.snapshot.ChildKey;
import com.squareup.moshi.Json;
import java.util.Random;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

public class PushIdGenerator {
    private static final int MAX_KEY_LEN = 786;
    private static final char MAX_PUSH_CHAR = 'z';
    private static final char MIN_PUSH_CHAR = '-';
    private static final String PUSH_CHARS = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz";
    private static long lastPushTime = 0;
    private static final int[] lastRandChars = new int[12];
    private static final Random randGen = new Random();

    public static synchronized String generatePushChildName(long j11) {
        boolean z11;
        boolean z12;
        String sb2;
        synchronized (PushIdGenerator.class) {
            boolean z13 = true;
            if (j11 == lastPushTime) {
                z11 = true;
            } else {
                z11 = false;
            }
            lastPushTime = j11;
            char[] cArr = new char[8];
            StringBuilder sb3 = new StringBuilder(20);
            for (int i11 = 7; i11 >= 0; i11--) {
                cArr[i11] = PUSH_CHARS.charAt((int) (j11 % 64));
                j11 /= 64;
            }
            if (j11 == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            Utilities.hardAssert(z12);
            sb3.append(cArr);
            if (!z11) {
                for (int i12 = 0; i12 < 12; i12++) {
                    lastRandChars[i12] = randGen.nextInt(64);
                }
            } else {
                incrementArray();
            }
            for (int i13 = 0; i13 < 12; i13++) {
                sb3.append(PUSH_CHARS.charAt(lastRandChars[i13]));
            }
            if (sb3.length() != 20) {
                z13 = false;
            }
            Utilities.hardAssert(z13);
            sb2 = sb3.toString();
        }
        return sb2;
    }

    private static void incrementArray() {
        int i11 = 11;
        while (i11 >= 0) {
            int[] iArr = lastRandChars;
            int i12 = iArr[i11];
            if (i12 != 63) {
                iArr[i11] = i12 + 1;
                return;
            } else {
                iArr[i11] = 0;
                i11--;
            }
        }
    }

    public static final String predecessor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb2 = new StringBuilder(str);
            if (sb2.charAt(sb2.length() - 1) != '-') {
                sb2.setCharAt(sb2.length() - 1, PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb2.charAt(sb2.length() - 1)) - 1));
                sb2.append(new String(new char[(786 - sb2.length())]).replace(Json.UNSET_NAME, CompressorStreamFactory.Z));
                return sb2.toString();
            } else if (sb2.length() == 1) {
                return String.valueOf(Integer.MAX_VALUE);
            } else {
                return sb2.substring(0, sb2.length() - 1);
            }
        } else if (tryParseInt.intValue() == Integer.MIN_VALUE) {
            return ChildKey.MIN_KEY_NAME;
        } else {
            return String.valueOf(tryParseInt.intValue() - 1);
        }
    }

    public static final String successor(String str) {
        Validation.validateNullableKey(str);
        Integer tryParseInt = Utilities.tryParseInt(str);
        if (tryParseInt == null) {
            StringBuilder sb2 = new StringBuilder(str);
            if (sb2.length() < MAX_KEY_LEN) {
                sb2.append('-');
                return sb2.toString();
            }
            int length = sb2.length() - 1;
            while (length >= 0 && sb2.charAt(length) == 'z') {
                length--;
            }
            if (length == -1) {
                return ChildKey.MAX_KEY_NAME;
            }
            int i11 = length + 1;
            sb2.replace(length, i11, String.valueOf(PUSH_CHARS.charAt(PUSH_CHARS.indexOf(sb2.charAt(length)) + 1)));
            return sb2.substring(0, i11);
        } else if (tryParseInt.intValue() == Integer.MAX_VALUE) {
            return String.valueOf('-');
        } else {
            return String.valueOf(tryParseInt.intValue() + 1);
        }
    }
}
