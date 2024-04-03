package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import org.jetbrains.annotations.NotNull;

public class BitEncoding {
    private static final boolean FORCE_8TO7_ENCODING;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        int i12 = i11;
        String str = (i12 == 1 || i12 == 3 || i12 == 6 || i12 == 8 || i12 == 10 || i12 == 12 || i12 == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i12 == 1 || i12 == 3 || i12 == 6 || i12 == 8 || i12 == 10 || i12 == 12 || i12 == 14) ? 2 : 3)];
        if (i12 == 1 || i12 == 3 || i12 == 6 || i12 == 8 || i12 == 10 || i12 == 12 || i12 == 14) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[0] = "data";
        }
        if (i12 == 1) {
            objArr[1] = "encodeBytes";
        } else if (i12 == 3) {
            objArr[1] = "encode8to7";
        } else if (i12 == 6) {
            objArr[1] = "splitBytesToStringArray";
        } else if (i12 == 8) {
            objArr[1] = "decodeBytes";
        } else if (i12 == 10) {
            objArr[1] = "dropMarker";
        } else if (i12 == 12) {
            objArr[1] = "combineStringArrayIntoBytes";
        } else if (i12 != 14) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
        } else {
            objArr[1] = "decode7to8";
        }
        switch (i12) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i12 == 1 || i12 == 3 || i12 == 6 || i12 == 8 || i12 == 10 || i12 == 12 || i12 == 14) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    static {
        String str;
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException unused) {
            str = null;
        }
        FORCE_8TO7_ENCODING = "true".equals(str);
    }

    private BitEncoding() {
    }

    private static void addModuloByte(@NotNull byte[] bArr, int i11) {
        if (bArr == null) {
            $$$reportNull$$$0(4);
        }
        int length = bArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            bArr[i12] = (byte) ((bArr[i12] + i11) & 127);
        }
    }

    @NotNull
    private static byte[] combineStringArrayIntoBytes(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(11);
        }
        int i11 = 0;
        for (String length : strArr) {
            i11 += length.length();
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        for (String str : strArr) {
            int length2 = str.length();
            int i13 = 0;
            while (i13 < length2) {
                bArr[i12] = (byte) str.charAt(i13);
                i13++;
                i12++;
            }
        }
        return bArr;
    }

    @NotNull
    private static byte[] decode7to8(@NotNull byte[] bArr) {
        if (bArr == null) {
            $$$reportNull$$$0(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i11 = 0;
        byte b11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i11++;
            int i13 = b11 + 1;
            bArr2[i12] = (byte) (((bArr[i11] & 255) >>> b11) + ((bArr[i11] & ((1 << i13) - 1)) << (7 - b11)));
            if (b11 == 6) {
                i11++;
                b11 = 0;
            } else {
                b11 = i13;
            }
        }
        return bArr2;
    }

    @NotNull
    public static byte[] decodeBytes(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                byte[] stringsToBytes = UtfEncodingKt.stringsToBytes(dropMarker(strArr));
                if (stringsToBytes == null) {
                    $$$reportNull$$$0(8);
                }
                return stringsToBytes;
            } else if (charAt == 65535) {
                strArr = dropMarker(strArr);
            }
        }
        byte[] combineStringArrayIntoBytes = combineStringArrayIntoBytes(strArr);
        addModuloByte(combineStringArrayIntoBytes, 127);
        return decode7to8(combineStringArrayIntoBytes);
    }

    @NotNull
    private static String[] dropMarker(@NotNull String[] strArr) {
        if (strArr == null) {
            $$$reportNull$$$0(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        return strArr2;
    }
}
