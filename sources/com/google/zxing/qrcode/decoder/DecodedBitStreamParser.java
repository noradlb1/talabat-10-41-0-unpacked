package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int GB2312_SUBSET = 1;

    /* renamed from: com.google.zxing.qrcode.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode = r0
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_SECOND_POSITION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.STRUCTURED_APPEND     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.ECI     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$zxing$qrcode$decoder$Mode     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.zxing.qrcode.decoder.Mode r1 = com.google.zxing.qrcode.decoder.Mode.HANZI     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.AnonymousClass1.<clinit>():void");
        }
    }

    private DecodedBitStreamParser() {
    }

    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        ArrayList arrayList;
        String str;
        Version version2 = version;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb2 = new StringBuilder(50);
        boolean z11 = true;
        ArrayList arrayList2 = new ArrayList(1);
        int i11 = -1;
        int i12 = -1;
        boolean z12 = false;
        CharacterSetECI characterSetECI = null;
        while (true) {
            try {
                if (bitSource.available() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bitSource.readBits(4));
                }
                Mode mode2 = forBits;
                int[] iArr = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode;
                switch (iArr[mode2.ordinal()]) {
                    case 5:
                        break;
                    case 6:
                    case 7:
                        z12 = z11;
                        break;
                    case 8:
                        if (bitSource.available() >= 16) {
                            int readBits = bitSource.readBits(8);
                            i12 = bitSource.readBits(8);
                            i11 = readBits;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 9:
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                        if (characterSetECI != null) {
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 10:
                        int readBits2 = bitSource.readBits(4);
                        int readBits3 = bitSource.readBits(mode2.getCharacterCountBits(version2));
                        if (readBits2 == z11) {
                            decodeHanziSegment(bitSource, sb2, readBits3);
                            break;
                        }
                        break;
                    default:
                        int readBits4 = bitSource.readBits(mode2.getCharacterCountBits(version2));
                        int i13 = iArr[mode2.ordinal()];
                        if (i13 != z11) {
                            if (i13 != 2) {
                                if (i13 == 3) {
                                    mode = mode2;
                                    decodeByteSegment(bitSource, sb2, readBits4, characterSetECI, arrayList2, map);
                                    break;
                                } else if (i13 == 4) {
                                    decodeKanjiSegment(bitSource, sb2, readBits4);
                                    break;
                                } else {
                                    throw FormatException.getFormatInstance();
                                }
                            } else {
                                mode = mode2;
                                decodeAlphanumericSegment(bitSource, sb2, readBits4, z12);
                                break;
                            }
                        } else {
                            mode = mode2;
                            decodeNumericSegment(bitSource, sb2, readBits4);
                            break;
                        }
                }
                mode = mode2;
                if (mode == Mode.TERMINATOR) {
                    String sb3 = sb2.toString();
                    if (arrayList2.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = arrayList2;
                    }
                    if (errorCorrectionLevel == null) {
                        str = null;
                    } else {
                        str = errorCorrectionLevel.toString();
                    }
                    return new DecoderResult(bArr, sb3, arrayList, str, i11, i12);
                }
                z11 = true;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder sb2, int i11, boolean z11) throws FormatException {
        while (i11 > 1) {
            if (bitSource.available() >= 11) {
                int readBits = bitSource.readBits(11);
                sb2.append(toAlphaNumericChar(readBits / 45));
                sb2.append(toAlphaNumericChar(readBits % 45));
                i11 -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i11 == 1) {
            if (bitSource.available() >= 6) {
                sb2.append(toAlphaNumericChar(bitSource.readBits(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z11) {
            for (int length = sb2.length(); length < sb2.length(); length++) {
                if (sb2.charAt(length) == '%') {
                    if (length < sb2.length() - 1) {
                        int i12 = length + 1;
                        if (sb2.charAt(i12) == '%') {
                            sb2.deleteCharAt(i12);
                        }
                    }
                    sb2.setCharAt(length, 29);
                }
            }
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb2, int i11, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if ((i11 << 3) <= bitSource.available()) {
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                bArr[i12] = (byte) bitSource.readBits(8);
            }
            if (characterSetECI == null) {
                str = StringUtils.guessEncoding(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb2.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb2, int i11) throws FormatException {
        int i12;
        if (i11 * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i11 * 2)];
            int i13 = 0;
            while (i11 > 0) {
                int readBits = bitSource.readBits(13);
                int i14 = (readBits % 96) | ((readBits / 96) << 8);
                if (i14 < 959) {
                    i12 = 41377;
                } else {
                    i12 = 42657;
                }
                int i15 = i14 + i12;
                bArr[i13] = (byte) (i15 >> 8);
                bArr[i13 + 1] = (byte) i15;
                i13 += 2;
                i11--;
            }
            try {
                sb2.append(new String(bArr, StringUtils.GB2312));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb2, int i11) throws FormatException {
        int i12;
        if (i11 * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i11 * 2)];
            int i13 = 0;
            while (i11 > 0) {
                int readBits = bitSource.readBits(13);
                int i14 = (readBits % 192) | ((readBits / 192) << 8);
                if (i14 < 7936) {
                    i12 = 33088;
                } else {
                    i12 = 49472;
                }
                int i15 = i14 + i12;
                bArr[i13] = (byte) (i15 >> 8);
                bArr[i13 + 1] = (byte) i15;
                i13 += 2;
                i11--;
            }
            try {
                sb2.append(new String(bArr, StringUtils.SHIFT_JIS));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb2, int i11) throws FormatException {
        while (i11 >= 3) {
            if (bitSource.available() >= 10) {
                int readBits = bitSource.readBits(10);
                if (readBits < 1000) {
                    sb2.append(toAlphaNumericChar(readBits / 100));
                    sb2.append(toAlphaNumericChar((readBits / 10) % 10));
                    sb2.append(toAlphaNumericChar(readBits % 10));
                    i11 -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i11 == 2) {
            if (bitSource.available() >= 7) {
                int readBits2 = bitSource.readBits(7);
                if (readBits2 < 100) {
                    sb2.append(toAlphaNumericChar(readBits2 / 10));
                    sb2.append(toAlphaNumericChar(readBits2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i11 != 1) {
        } else {
            if (bitSource.available() >= 4) {
                int readBits3 = bitSource.readBits(4);
                if (readBits3 < 10) {
                    sb2.append(toAlphaNumericChar(readBits3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int i11) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i11 < cArr.length) {
            return cArr[i11];
        }
        throw FormatException.getFormatInstance();
    }
}
