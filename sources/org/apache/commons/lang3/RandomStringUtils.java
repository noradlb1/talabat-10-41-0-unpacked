package org.apache.commons.lang3;

import java.util.Random;
import okio.Utf8;

public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i11) {
        return random(i11, false, false);
    }

    public static String randomAlphabetic(int i11) {
        return random(i11, true, false);
    }

    public static String randomAlphanumeric(int i11) {
        return random(i11, true, true);
    }

    public static String randomAscii(int i11) {
        return random(i11, 32, 127, false, false);
    }

    public static String randomNumeric(int i11) {
        return random(i11, false, true);
    }

    public static String random(int i11, boolean z11, boolean z12) {
        return random(i11, 0, 0, z11, z12);
    }

    public static String random(int i11, int i12, int i13, boolean z11, boolean z12) {
        return random(i11, i12, i13, z11, z12, (char[]) null, RANDOM);
    }

    public static String random(int i11, int i12, int i13, boolean z11, boolean z12, char... cArr) {
        return random(i11, i12, i13, z11, z12, cArr, RANDOM);
    }

    public static String random(int i11, int i12, int i13, boolean z11, boolean z12, char[] cArr, Random random) {
        char c11;
        if (i11 == 0) {
            return "";
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Requested random string length " + i11 + " is less than 0.");
        } else if (cArr == null || cArr.length != 0) {
            if (i12 == 0 && i13 == 0) {
                if (cArr != null) {
                    i13 = cArr.length;
                } else if (z11 || z12) {
                    i13 = 123;
                    i12 = 32;
                } else {
                    i13 = Integer.MAX_VALUE;
                }
            } else if (i13 <= i12) {
                throw new IllegalArgumentException("Parameter end (" + i13 + ") must be greater than start (" + i12 + ")");
            }
            char[] cArr2 = new char[i11];
            int i14 = i13 - i12;
            while (true) {
                int i15 = i11 - 1;
                if (i11 == 0) {
                    return new String(cArr2);
                }
                if (cArr == null) {
                    c11 = (char) (random.nextInt(i14) + i12);
                } else {
                    c11 = cArr[random.nextInt(i14) + i12];
                }
                if ((z11 && Character.isLetter(c11)) || ((z12 && Character.isDigit(c11)) || (!z11 && !z12))) {
                    if (c11 < 56320 || c11 > 57343) {
                        if (c11 < 55296 || c11 > 56191) {
                            if (c11 < 56192 || c11 > 56319) {
                                cArr2[i15] = c11;
                                i11 = i15;
                            }
                        } else if (i15 != 0) {
                            cArr2[i15] = (char) (random.nextInt(128) + Utf8.LOG_SURROGATE_HEADER);
                            i15--;
                            cArr2[i15] = c11;
                            i11 = i15;
                        }
                    } else if (i15 != 0) {
                        cArr2[i15] = c11;
                        i15--;
                        cArr2[i15] = (char) (random.nextInt(128) + 55296);
                        i11 = i15;
                    }
                }
                i15++;
                i11 = i15;
            }
        } else {
            throw new IllegalArgumentException("The chars array must not be empty");
        }
    }

    public static String random(int i11, String str) {
        if (str != null) {
            return random(i11, str.toCharArray());
        }
        return random(i11, 0, 0, false, false, (char[]) null, RANDOM);
    }

    public static String random(int i11, char... cArr) {
        if (cArr == null) {
            return random(i11, 0, 0, false, false, (char[]) null, RANDOM);
        }
        return random(i11, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
