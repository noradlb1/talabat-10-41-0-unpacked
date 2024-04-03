package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.util.Arrays;
import net.bytebuddy.jar.asm.Opcodes;

public final class HighLevelEncoder {
    static final int ASCII_ENCODATION = 0;
    static final int BASE256_ENCODATION = 5;
    static final int C40_ENCODATION = 1;
    static final char C40_UNLATCH = 'þ';
    static final int EDIFACT_ENCODATION = 4;
    static final char LATCH_TO_ANSIX12 = 'î';
    static final char LATCH_TO_BASE256 = 'ç';
    static final char LATCH_TO_C40 = 'æ';
    static final char LATCH_TO_EDIFACT = 'ð';
    static final char LATCH_TO_TEXT = 'ï';
    private static final char MACRO_05 = 'ì';
    private static final String MACRO_05_HEADER = "[)>\u001e05\u001d";
    private static final char MACRO_06 = 'í';
    private static final String MACRO_06_HEADER = "[)>\u001e06\u001d";
    private static final String MACRO_TRAILER = "\u001e\u0004";
    private static final char PAD = '';
    static final int TEXT_ENCODATION = 2;
    static final char UPPER_SHIFT = 'ë';
    static final int X12_ENCODATION = 3;
    static final char X12_UNLATCH = 'þ';

    private HighLevelEncoder() {
    }

    public static int determineConsecutiveDigitCount(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        if (i11 < length) {
            char charAt = charSequence.charAt(i11);
            while (isDigit(charAt) && i11 < length) {
                i12++;
                i11++;
                if (i11 < length) {
                    charAt = charSequence.charAt(i11);
                }
            }
        }
        return i12;
    }

    public static String encodeHighLevel(String str) {
        return encodeHighLevel(str, SymbolShapeHint.FORCE_NONE, (Dimension) null, (Dimension) null);
    }

    private static int findMinimums(float[] fArr, int[] iArr, int i11, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i12 = 0; i12 < 6; i12++) {
            int ceil = (int) Math.ceil((double) fArr[i12]);
            iArr[i12] = ceil;
            if (i11 > ceil) {
                Arrays.fill(bArr, (byte) 0);
                i11 = ceil;
            }
            if (i11 == ceil) {
                bArr[i12] = (byte) (bArr[i12] + 1);
            }
        }
        return i11;
    }

    private static int getMinimumCount(byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 += bArr[i12];
        }
        return i11;
    }

    public static void illegalCharacter(char c11) {
        String hexString = Integer.toHexString(c11);
        throw new IllegalArgumentException("Illegal character: " + c11 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean isDigit(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    public static boolean isExtendedASCII(char c11) {
        return c11 >= 128 && c11 <= 255;
    }

    private static boolean isNativeC40(char c11) {
        if (c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'A' && c11 <= 'Z';
        }
        return true;
    }

    private static boolean isNativeEDIFACT(char c11) {
        return c11 >= ' ' && c11 <= '^';
    }

    private static boolean isNativeText(char c11) {
        if (c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'a' && c11 <= 'z';
        }
        return true;
    }

    private static boolean isNativeX12(char c11) {
        if (isX12TermSep(c11) || c11 == ' ') {
            return true;
        }
        if (c11 < '0' || c11 > '9') {
            return c11 >= 'A' && c11 <= 'Z';
        }
        return true;
    }

    private static boolean isSpecialB256(char c11) {
        return false;
    }

    private static boolean isX12TermSep(char c11) {
        return c11 == 13 || c11 == '*' || c11 == '>';
    }

    public static int lookAheadTest(CharSequence charSequence, int i11, int i12) {
        float[] fArr;
        char c11;
        CharSequence charSequence2 = charSequence;
        int i13 = i11;
        if (i13 >= charSequence.length()) {
            return i12;
        }
        int i14 = 6;
        if (i12 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i12] = 0.0f;
        }
        int i15 = 0;
        while (true) {
            int i16 = i13 + i15;
            if (i16 == charSequence.length()) {
                byte[] bArr = new byte[i14];
                int[] iArr = new int[i14];
                int findMinimums = findMinimums(fArr, iArr, Integer.MAX_VALUE, bArr);
                int minimumCount = getMinimumCount(bArr);
                if (iArr[0] == findMinimums) {
                    return 0;
                }
                if (minimumCount == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (minimumCount == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (minimumCount == 1 && bArr[2] > 0) {
                    return 2;
                }
                if (minimumCount != 1 || bArr[3] <= 0) {
                    return 1;
                }
                return 3;
            }
            char charAt = charSequence2.charAt(i16);
            i15++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (isExtendedASCII(charAt)) {
                float ceil = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil;
                fArr[0] = ceil + 2.0f;
            } else {
                float ceil2 = (float) Math.ceil((double) fArr[0]);
                fArr[0] = ceil2;
                fArr[0] = ceil2 + 1.0f;
            }
            if (isNativeC40(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (isNativeText(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (isNativeX12(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (isExtendedASCII(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (isNativeEDIFACT(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (isExtendedASCII(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (isSpecialB256(charAt)) {
                c11 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c11 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i15 >= 4) {
                int[] iArr2 = new int[i14];
                byte[] bArr2 = new byte[i14];
                findMinimums(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int minimumCount2 = getMinimumCount(bArr2);
                int i17 = iArr2[0];
                int i18 = iArr2[c11];
                if (i17 < i18 && i17 < iArr2[1] && i17 < iArr2[2] && i17 < iArr2[3] && i17 < iArr2[4]) {
                    return 0;
                }
                if (i18 < i17) {
                    return 5;
                }
                byte b11 = bArr2[1];
                byte b12 = bArr2[2];
                byte b13 = bArr2[3];
                byte b14 = bArr2[4];
                if (b11 + b12 + b13 + b14 == 0) {
                    return 5;
                }
                if (minimumCount2 == 1 && b14 > 0) {
                    return 4;
                }
                if (minimumCount2 == 1 && b12 > 0) {
                    return 2;
                }
                if (minimumCount2 == 1 && b13 > 0) {
                    return 3;
                }
                int i19 = iArr2[1];
                if (i19 + 1 < i17 && i19 + 1 < i18 && i19 + 1 < iArr2[4] && i19 + 1 < iArr2[2]) {
                    int i21 = iArr2[3];
                    if (i19 < i21) {
                        return 1;
                    }
                    if (i19 == i21) {
                        int i22 = i13 + i15 + 1;
                        while (i22 < charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i22);
                            if (!isX12TermSep(charAt2)) {
                                if (!isNativeX12(charAt2)) {
                                    break;
                                }
                                i22++;
                            } else {
                                return 3;
                            }
                        }
                        return 1;
                    }
                }
            }
            i14 = 6;
        }
    }

    private static char randomize253State(char c11, int i11) {
        int i12 = c11 + ((i11 * Opcodes.FCMPL) % 253) + 1;
        if (i12 > 254) {
            i12 -= 254;
        }
        return (char) i12;
    }

    public static String encodeHighLevel(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i11 = 0;
        Encoder[] encoderArr = {new ASCIIEncoder(), new C40Encoder(), new TextEncoder(), new X12Encoder(), new EdifactEncoder(), new Base256Encoder()};
        EncoderContext encoderContext = new EncoderContext(str);
        encoderContext.setSymbolShape(symbolShapeHint);
        encoderContext.setSizeConstraints(dimension, dimension2);
        if (str.startsWith(MACRO_05_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_05);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        } else if (str.startsWith(MACRO_06_HEADER) && str.endsWith(MACRO_TRAILER)) {
            encoderContext.writeCodeword(MACRO_06);
            encoderContext.setSkipAtEnd(2);
            encoderContext.pos += 7;
        }
        while (encoderContext.hasMoreCharacters()) {
            encoderArr[i11].encode(encoderContext);
            if (encoderContext.getNewEncoding() >= 0) {
                i11 = encoderContext.getNewEncoding();
                encoderContext.resetEncoderSignal();
            }
        }
        int codewordCount = encoderContext.getCodewordCount();
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity();
        if (!(codewordCount >= dataCapacity || i11 == 0 || i11 == 5 || i11 == 4)) {
            encoderContext.writeCodeword(254);
        }
        StringBuilder codewords = encoderContext.getCodewords();
        if (codewords.length() < dataCapacity) {
            codewords.append(PAD);
        }
        while (codewords.length() < dataCapacity) {
            codewords.append(randomize253State(PAD, codewords.length() + 1));
        }
        return encoderContext.getCodewords().toString();
    }
}
