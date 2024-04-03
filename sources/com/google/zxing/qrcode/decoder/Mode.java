package com.google.zxing.qrcode.decoder;

public enum Mode {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;

    private Mode(int[] iArr, int i11) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i11;
    }

    public static Mode forBits(int i11) {
        if (i11 == 0) {
            return TERMINATOR;
        }
        if (i11 == 1) {
            return NUMERIC;
        }
        if (i11 == 2) {
            return ALPHANUMERIC;
        }
        if (i11 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i11 == 4) {
            return BYTE;
        }
        if (i11 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i11 == 7) {
            return ECI;
        }
        if (i11 == 8) {
            return KANJI;
        }
        if (i11 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i11 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.bits;
    }

    public int getCharacterCountBits(Version version) {
        char c11;
        int versionNumber = version.getVersionNumber();
        if (versionNumber <= 9) {
            c11 = 0;
        } else if (versionNumber <= 26) {
            c11 = 1;
        } else {
            c11 = 2;
        }
        return this.characterCountBitsForVersions[c11];
    }
}
