package org.apache.commons.lang3;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import java.util.UUID;
import kotlin.UShort;
import net.bytebuddy.asm.Advice;
import okhttp3.internal.ws.WebSocketProtocol;

public class Conversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i11, byte b11, int i12, int i13) {
        if ((zArr.length == 0 && i11 == 0) || i13 == 0) {
            return b11;
        }
        if ((i13 - 1) + i12 < 8) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 1) + i12;
                b11 = (byte) ((b11 & (~(1 << i15))) | ((zArr[i14 + i11] ? 1 : 0) << i15));
            }
            return b11;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 8");
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i11, int i12, int i13, int i14) {
        if ((zArr.length == 0 && i11 == 0) || i14 == 0) {
            return i12;
        }
        if ((i14 - 1) + i13 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = (i15 * 1) + i13;
                i12 = (i12 & (~(1 << i16))) | ((zArr[i15 + i11] ? 1 : 0) << i16);
            }
            return i12;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 32");
    }

    public static long binaryToLong(boolean[] zArr, int i11, long j11, int i12, int i13) {
        long j12;
        if ((zArr.length == 0 && i11 == 0) || i13 == 0) {
            return j11;
        }
        if ((i13 - 1) + i12 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 1) + i12;
                if (zArr[i14 + i11]) {
                    j12 = 1;
                } else {
                    j12 = 0;
                }
                j11 = (j11 & (~(1 << i15))) | (j12 << i15);
            }
            return j11;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 64");
    }

    public static short binaryToShort(boolean[] zArr, int i11, short s11, int i12, int i13) {
        if ((zArr.length == 0 && i11 == 0) || i13 == 0) {
            return s11;
        }
        if ((i13 - 1) + i12 < 16) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 1) + i12;
                s11 = (short) ((s11 & (~(1 << i15))) | ((zArr[i14 + i11] ? 1 : 0) << i15));
            }
            return s11;
        }
        throw new IllegalArgumentException("nBools-1+dstPos is greather or equal to than 16");
    }

    public static int byteArrayToInt(byte[] bArr, int i11, int i12, int i13, int i14) {
        if ((bArr.length == 0 && i11 == 0) || i14 == 0) {
            return i12;
        }
        if (((i14 - 1) * 8) + i13 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = (i15 * 8) + i13;
                i12 = (i12 & (~(255 << i16))) | ((bArr[i15 + i11] & 255) << i16);
            }
            return i12;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 32");
    }

    public static long byteArrayToLong(byte[] bArr, int i11, long j11, int i12, int i13) {
        if ((bArr.length == 0 && i11 == 0) || i13 == 0) {
            return j11;
        }
        if (((i13 - 1) * 8) + i12 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 8) + i12;
                j11 = (j11 & (~(255 << i15))) | ((((long) bArr[i14 + i11]) & 255) << i15);
            }
            return j11;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 64");
    }

    public static short byteArrayToShort(byte[] bArr, int i11, short s11, int i12, int i13) {
        if ((bArr.length == 0 && i11 == 0) || i13 == 0) {
            return s11;
        }
        if (((i13 - 1) * 8) + i12 < 16) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 8) + i12;
                s11 = (short) ((s11 & (~(255 << i15))) | ((bArr[i14 + i11] & 255) << i15));
            }
            return s11;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greather or equal to than 16");
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i11) {
        if (bArr.length - i11 >= 16) {
            return new UUID(byteArrayToLong(bArr, i11, 0, 0, 8), byteArrayToLong(bArr, i11 + 8, 0, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b11, int i11, boolean[] zArr, int i12, int i13) {
        if (i13 == 0) {
            return zArr;
        }
        if ((i13 - 1) + i11 < 8) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = i12 + i14;
                boolean z11 = true;
                if (((b11 >> ((i14 * 1) + i11)) & 1) == 0) {
                    z11 = false;
                }
                zArr[i15] = z11;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 8");
    }

    public static String byteToHex(byte b11, int i11, String str, int i12, int i13) {
        if (i13 == 0) {
            return str;
        }
        if (((i13 - 1) * 4) + i11 < 8) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (b11 >> ((i14 * 4) + i11)) & 15;
                int i16 = i12 + i14;
                if (i16 == length) {
                    length++;
                    sb2.append(intToHexDigit(i15));
                } else {
                    sb2.setCharAt(i16, intToHexDigit(i15));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 8");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return new boolean[]{true, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return new boolean[]{true, true, false, false};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return new boolean[]{true, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return new boolean[]{true, false, true, false};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        return new boolean[]{true, true, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        return new boolean[]{true, true, true, false};
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[] hexDigitMsb0ToBinary(char r3) {
        /*
            r0 = 4
            switch(r3) {
                case 48: goto L_0x0080;
                case 49: goto L_0x007a;
                case 50: goto L_0x0074;
                case 51: goto L_0x006e;
                case 52: goto L_0x0068;
                case 53: goto L_0x0062;
                case 54: goto L_0x005c;
                case 55: goto L_0x0056;
                case 56: goto L_0x0050;
                case 57: goto L_0x004a;
                default: goto L_0x0004;
            }
        L_0x0004:
            switch(r3) {
                case 65: goto L_0x0044;
                case 66: goto L_0x003e;
                case 67: goto L_0x0038;
                case 68: goto L_0x0032;
                case 69: goto L_0x002c;
                case 70: goto L_0x0026;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r3) {
                case 97: goto L_0x0044;
                case 98: goto L_0x003e;
                case 99: goto L_0x0038;
                case 100: goto L_0x0032;
                case 101: goto L_0x002c;
                case 102: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0026:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 1} // fill-array
            return r3
        L_0x002c:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 0} // fill-array
            return r3
        L_0x0032:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 1} // fill-array
            return r3
        L_0x0038:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 0} // fill-array
            return r3
        L_0x003e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 1} // fill-array
            return r3
        L_0x0044:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 0} // fill-array
            return r3
        L_0x004a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 1} // fill-array
            return r3
        L_0x0050:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 0} // fill-array
            return r3
        L_0x0056:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 1} // fill-array
            return r3
        L_0x005c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 0} // fill-array
            return r3
        L_0x0062:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 1} // fill-array
            return r3
        L_0x0068:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 0} // fill-array
            return r3
        L_0x006e:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 1} // fill-array
            return r3
        L_0x0074:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 0} // fill-array
            return r3
        L_0x007a:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 1} // fill-array
            return r3
        L_0x0080:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 0} // fill-array
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitMsb0ToBinary(char):boolean[]");
    }

    public static int hexDigitMsb0ToInt(char c11) {
        switch (c11) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c11) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c11) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c11 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        return new boolean[]{true, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return new boolean[]{false, false, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        return new boolean[]{true, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return new boolean[]{false, true, false, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        return new boolean[]{true, true, true, true};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
        return new boolean[]{false, true, true, true};
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean[] hexDigitToBinary(char r3) {
        /*
            r0 = 4
            switch(r3) {
                case 48: goto L_0x0080;
                case 49: goto L_0x007a;
                case 50: goto L_0x0074;
                case 51: goto L_0x006e;
                case 52: goto L_0x0068;
                case 53: goto L_0x0062;
                case 54: goto L_0x005c;
                case 55: goto L_0x0056;
                case 56: goto L_0x0050;
                case 57: goto L_0x004a;
                default: goto L_0x0004;
            }
        L_0x0004:
            switch(r3) {
                case 65: goto L_0x0044;
                case 66: goto L_0x003e;
                case 67: goto L_0x0038;
                case 68: goto L_0x0032;
                case 69: goto L_0x002c;
                case 70: goto L_0x0026;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r3) {
                case 97: goto L_0x0044;
                case 98: goto L_0x003e;
                case 99: goto L_0x0038;
                case 100: goto L_0x0032;
                case 101: goto L_0x002c;
                case 102: goto L_0x0026;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot interpret '"
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0026:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 1} // fill-array
            return r3
        L_0x002c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 1} // fill-array
            return r3
        L_0x0032:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 1} // fill-array
            return r3
        L_0x0038:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 1} // fill-array
            return r3
        L_0x003e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 1} // fill-array
            return r3
        L_0x0044:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 1} // fill-array
            return r3
        L_0x004a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 1} // fill-array
            return r3
        L_0x0050:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 1} // fill-array
            return r3
        L_0x0056:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 1, 0} // fill-array
            return r3
        L_0x005c:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 1, 0} // fill-array
            return r3
        L_0x0062:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 1, 0} // fill-array
            return r3
        L_0x0068:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 1, 0} // fill-array
            return r3
        L_0x006e:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 1, 0, 0} // fill-array
            return r3
        L_0x0074:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 1, 0, 0} // fill-array
            return r3
        L_0x007a:
            boolean[] r3 = new boolean[r0]
            r3 = {1, 0, 0, 0} // fill-array
            return r3
        L_0x0080:
            boolean[] r3 = new boolean[r0]
            r3 = {0, 0, 0, 0} // fill-array
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitToBinary(char):boolean[]");
    }

    public static int hexDigitToInt(char c11) {
        int digit = Character.digit(c11, 16);
        if (digit >= 0) {
            return digit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c11 + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i11, byte b11, int i12, int i13) {
        if (i13 == 0) {
            return b11;
        }
        if (((i13 - 1) * 4) + i12 < 8) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 4) + i12;
                b11 = (byte) ((b11 & (~(15 << i15))) | ((hexDigitToInt(str.charAt(i14 + i11)) & 15) << i15));
            }
            return b11;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 8");
    }

    public static int hexToInt(String str, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return i12;
        }
        if (((i14 - 1) * 4) + i13 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = (i15 * 4) + i13;
                i12 = (i12 & (~(15 << i16))) | ((hexDigitToInt(str.charAt(i15 + i11)) & 15) << i16);
            }
            return i12;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 32");
    }

    public static long hexToLong(String str, int i11, long j11, int i12, int i13) {
        if (i13 == 0) {
            return j11;
        }
        if (((i13 - 1) * 4) + i12 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 4) + i12;
                j11 = (j11 & (~(15 << i15))) | ((((long) hexDigitToInt(str.charAt(i14 + i11))) & 15) << i15);
            }
            return j11;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 64");
    }

    public static short hexToShort(String str, int i11, short s11, int i12, int i13) {
        if (i13 == 0) {
            return s11;
        }
        if (((i13 - 1) * 4) + i12 < 16) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 4) + i12;
                s11 = (short) ((s11 & (~(15 << i15))) | ((hexDigitToInt(str.charAt(i14 + i11)) & 15) << i15));
            }
            return s11;
        }
        throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greather or equal to than 16");
    }

    public static long intArrayToLong(int[] iArr, int i11, long j11, int i12, int i13) {
        if ((iArr.length == 0 && i11 == 0) || i13 == 0) {
            return j11;
        }
        if (((i13 - 1) * 32) + i12 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 32) + i12;
                j11 = (j11 & (~(4294967295 << i15))) | ((((long) iArr[i14 + i11]) & 4294967295L) << i15);
            }
            return j11;
        }
        throw new IllegalArgumentException("(nInts-1)*32+dstPos is greather or equal to than 64");
    }

    public static boolean[] intToBinary(int i11, int i12, boolean[] zArr, int i13, int i14) {
        if (i14 == 0) {
            return zArr;
        }
        if ((i14 - 1) + i12 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = i13 + i15;
                boolean z11 = true;
                if (((i11 >> ((i15 * 1) + i12)) & 1) == 0) {
                    z11 = false;
                }
                zArr[i16] = z11;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 32");
    }

    public static byte[] intToByteArray(int i11, int i12, byte[] bArr, int i13, int i14) {
        if (i14 == 0) {
            return bArr;
        }
        if (((i14 - 1) * 8) + i12 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                bArr[i13 + i15] = (byte) ((i11 >> ((i15 * 8) + i12)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 32");
    }

    public static String intToHex(int i11, int i12, String str, int i13, int i14) {
        if (i14 == 0) {
            return str;
        }
        if (((i14 - 1) * 4) + i12 < 32) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = (i11 >> ((i15 * 4) + i12)) & 15;
                int i17 = i13 + i15;
                if (i17 == length) {
                    length++;
                    sb2.append(intToHexDigit(i16));
                } else {
                    sb2.setCharAt(i17, intToHexDigit(i16));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 32");
    }

    public static char intToHexDigit(int i11) {
        char forDigit = Character.forDigit(i11, 16);
        if (forDigit != 0) {
            return forDigit;
        }
        throw new IllegalArgumentException("nibble value not between 0 and 15: " + i11);
    }

    public static char intToHexDigitMsb0(int i11) {
        switch (i11) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK;
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException("nibble value not between 0 and 15: " + i11);
        }
    }

    public static short[] intToShortArray(int i11, int i12, short[] sArr, int i13, int i14) {
        if (i14 == 0) {
            return sArr;
        }
        if (((i14 - 1) * 16) + i12 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                sArr[i13 + i15] = (short) ((i11 >> ((i15 * 16) + i12)) & 65535);
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 32");
    }

    public static boolean[] longToBinary(long j11, int i11, boolean[] zArr, int i12, int i13) {
        boolean z11;
        if (i13 == 0) {
            return zArr;
        }
        if ((i13 - 1) + i11 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = i12 + i14;
                if ((1 & (j11 >> ((i14 * 1) + i11))) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zArr[i15] = z11;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 64");
    }

    public static byte[] longToByteArray(long j11, int i11, byte[] bArr, int i12, int i13) {
        if (i13 == 0) {
            return bArr;
        }
        if (((i13 - 1) * 8) + i11 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                bArr[i12 + i14] = (byte) ((int) (255 & (j11 >> ((i14 * 8) + i11))));
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 64");
    }

    public static String longToHex(long j11, int i11, String str, int i12, int i13) {
        if (i13 == 0) {
            return str;
        }
        if (((i13 - 1) * 4) + i11 < 64) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (int) ((j11 >> ((i14 * 4) + i11)) & 15);
                int i16 = i12 + i14;
                if (i16 == length) {
                    length++;
                    sb2.append(intToHexDigit(i15));
                } else {
                    sb2.setCharAt(i16, intToHexDigit(i15));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 64");
    }

    public static int[] longToIntArray(long j11, int i11, int[] iArr, int i12, int i13) {
        if (i13 == 0) {
            return iArr;
        }
        if (((i13 - 1) * 32) + i11 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                iArr[i12 + i14] = (int) (-1 & (j11 >> ((i14 * 32) + i11)));
            }
            return iArr;
        }
        throw new IllegalArgumentException("(nInts-1)*32+srcPos is greather or equal to than 64");
    }

    public static short[] longToShortArray(long j11, int i11, short[] sArr, int i12, int i13) {
        if (i13 == 0) {
            return sArr;
        }
        if (((i13 - 1) * 16) + i11 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                sArr[i12 + i14] = (short) ((int) (WebSocketProtocol.PAYLOAD_SHORT_MAX & (j11 >> ((i14 * 16) + i11))));
            }
            return sArr;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greather or equal to than 64");
    }

    public static int shortArrayToInt(short[] sArr, int i11, int i12, int i13, int i14) {
        if ((sArr.length == 0 && i11 == 0) || i14 == 0) {
            return i12;
        }
        if (((i14 - 1) * 16) + i13 < 32) {
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = (i15 * 16) + i13;
                i12 = (i12 & (~(65535 << i16))) | ((sArr[i15 + i11] & UShort.MAX_VALUE) << i16);
            }
            return i12;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 32");
    }

    public static long shortArrayToLong(short[] sArr, int i11, long j11, int i12, int i13) {
        if ((sArr.length == 0 && i11 == 0) || i13 == 0) {
            return j11;
        }
        if (((i13 - 1) * 16) + i12 < 64) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (i14 * 16) + i12;
                j11 = (j11 & (~(WebSocketProtocol.PAYLOAD_SHORT_MAX << i15))) | ((((long) sArr[i14 + i11]) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << i15);
            }
            return j11;
        }
        throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greather or equal to than 64");
    }

    public static boolean[] shortToBinary(short s11, int i11, boolean[] zArr, int i12, int i13) {
        if (i13 == 0) {
            return zArr;
        }
        if ((i13 - 1) + i11 < 16) {
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = i12 + i14;
                boolean z11 = true;
                if (((s11 >> ((i14 * 1) + i11)) & 1) == 0) {
                    z11 = false;
                }
                zArr[i15] = z11;
            }
            return zArr;
        }
        throw new IllegalArgumentException("nBools-1+srcPos is greather or equal to than 16");
    }

    public static byte[] shortToByteArray(short s11, int i11, byte[] bArr, int i12, int i13) {
        if (i13 == 0) {
            return bArr;
        }
        if (((i13 - 1) * 8) + i11 < 16) {
            for (int i14 = 0; i14 < i13; i14++) {
                bArr[i12 + i14] = (byte) ((s11 >> ((i14 * 8) + i11)) & 255);
            }
            return bArr;
        }
        throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greather or equal to than 16");
    }

    public static String shortToHex(short s11, int i11, String str, int i12, int i13) {
        if (i13 == 0) {
            return str;
        }
        if (((i13 - 1) * 4) + i11 < 16) {
            StringBuilder sb2 = new StringBuilder(str);
            int length = sb2.length();
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = (s11 >> ((i14 * 4) + i11)) & 15;
                int i16 = i12 + i14;
                if (i16 == length) {
                    length++;
                    sb2.append(intToHexDigit(i15));
                } else {
                    sb2.setCharAt(i16, intToHexDigit(i15));
                }
            }
            return sb2.toString();
        }
        throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greather or equal to than 16");
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i11, int i12) {
        int i13;
        if (i12 == 0) {
            return bArr;
        }
        if (i12 <= 16) {
            long mostSignificantBits = uuid.getMostSignificantBits();
            if (i12 > 8) {
                i13 = 8;
            } else {
                i13 = i12;
            }
            longToByteArray(mostSignificantBits, 0, bArr, i11, i13);
            if (i12 >= 8) {
                longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i11 + 8, i12 - 8);
            }
            return bArr;
        }
        throw new IllegalArgumentException("nBytes is greather than 16");
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i11) {
        if (zArr.length != 0) {
            int length = ((zArr.length - 1) - i11) + 1;
            int min = Math.min(4, length);
            boolean[] zArr2 = new boolean[4];
            System.arraycopy(zArr, length - min, zArr2, 4 - min, min);
            if (zArr2[0]) {
                if (!zArr2[1]) {
                    return zArr2[2] ? zArr2[3] ? 'b' : 'a' : zArr2[3] ? '9' : '8';
                }
                if (zArr2[2]) {
                    return zArr2[3] ? 'f' : 'e';
                }
                if (zArr2[3]) {
                    return Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
                }
                return 'c';
            } else if (zArr2[1]) {
                return zArr2[2] ? zArr2[3] ? '7' : '6' : zArr2[3] ? '5' : '4';
            } else {
                if (zArr2[2]) {
                    return zArr2[3] ? '3' : '2';
                }
                if (zArr2[3]) {
                    return ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK;
                }
                return '0';
            }
        } else {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
    }

    public static char binaryToHexDigit(boolean[] zArr, int i11) {
        if (zArr.length != 0) {
            int i12 = i11 + 3;
            if (zArr.length <= i12 || !zArr[i12]) {
                int i13 = i11 + 2;
                if (zArr.length <= i13 || !zArr[i13]) {
                    int i14 = i11 + 1;
                    if (zArr.length > i14 && zArr[i14]) {
                        return zArr[i11] ? '3' : '2';
                    }
                    if (zArr[i11]) {
                        return ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK;
                    }
                    return '0';
                }
                int i15 = i11 + 1;
                return (zArr.length <= i15 || !zArr[i15]) ? zArr[i11] ? '5' : '4' : zArr[i11] ? '7' : '6';
            }
            int i16 = i11 + 2;
            if (zArr.length <= i16 || !zArr[i16]) {
                int i17 = i11 + 1;
                return (zArr.length <= i17 || !zArr[i17]) ? zArr[i11] ? '9' : '8' : zArr[i11] ? 'b' : 'a';
            }
            int i18 = i11 + 1;
            if (zArr.length > i18 && zArr[i18]) {
                return zArr[i11] ? 'f' : 'e';
            }
            if (zArr[i11]) {
                return Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
            }
            return 'c';
        }
        throw new IllegalArgumentException("Cannot convert an empty array.");
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i11) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        } else if (zArr.length - i11 < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i11);
        } else if (!zArr[i11 + 3]) {
            return zArr[i11 + 2] ? zArr[i11 + 1] ? zArr[i11] ? 'e' : '6' : zArr[i11] ? 'a' : '2' : zArr[i11 + 1] ? zArr[i11] ? 'c' : '4' : zArr[i11] ? '8' : '0';
        } else {
            if (zArr[i11 + 2]) {
                return zArr[i11 + 1] ? zArr[i11] ? 'f' : '7' : zArr[i11] ? 'b' : '3';
            }
            if (zArr[i11 + 1]) {
                if (zArr[i11]) {
                    return Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
                }
                return '5';
            } else if (zArr[i11]) {
                return '9';
            } else {
                return ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK;
            }
        }
    }
}
