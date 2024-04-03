package org.apache.commons.compress.utils;

import java.lang.Character;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArchiveUtils {
    private static final int MAX_SANITIZED_NAME_LENGTH = 255;

    private ArchiveUtils() {
    }

    public static boolean isArrayZero(byte[] bArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (bArr[i12] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEqual(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14, boolean z11) {
        int i15 = i12 < i14 ? i12 : i14;
        for (int i16 = 0; i16 < i15; i16++) {
            if (bArr[i11 + i16] != bArr2[i13 + i16]) {
                return false;
            }
        }
        if (i12 == i14) {
            return true;
        }
        if (!z11) {
            return false;
        }
        if (i12 > i14) {
            while (i14 < i12) {
                if (bArr[i11 + i14] != 0) {
                    return false;
                }
                i14++;
            }
        } else {
            while (i12 < i14) {
                if (bArr2[i13 + i12] != 0) {
                    return false;
                }
                i12++;
            }
        }
        return true;
    }

    public static boolean isEqualWithNull(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        return isEqual(bArr, i11, i12, bArr2, i13, i14, true);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr, int i11, int i12) {
        byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
        return isEqual(bytes, 0, bytes.length, bArr, i11, i12, false);
    }

    public static String sanitize(String str) {
        char[] cArr;
        Character.UnicodeBlock of2;
        char[] charArray = str.toCharArray();
        if (charArray.length <= 255) {
            cArr = charArray;
        } else {
            cArr = Arrays.copyOf(charArray, 255);
        }
        if (charArray.length > 255) {
            for (int i11 = 252; i11 < 255; i11++) {
                cArr[i11] = '.';
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c11 : cArr) {
            if (Character.isISOControl(c11) || (of2 = Character.UnicodeBlock.of(c11)) == null || of2 == Character.UnicodeBlock.SPECIALS) {
                sb2.append('?');
            } else {
                sb2.append(c11);
            }
        }
        return sb2.toString();
    }

    public static byte[] toAsciiBytes(String str) {
        return str.getBytes(StandardCharsets.US_ASCII);
    }

    public static String toAsciiString(byte[] bArr) {
        return new String(bArr, StandardCharsets.US_ASCII);
    }

    public static String toString(ArchiveEntry archiveEntry) {
        char c11;
        StringBuilder sb2 = new StringBuilder();
        if (archiveEntry.isDirectory()) {
            c11 = Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL;
        } else {
            c11 = SignatureVisitor.SUPER;
        }
        sb2.append(c11);
        String l11 = Long.toString(archiveEntry.getSize());
        sb2.append(' ');
        for (int i11 = 7; i11 > l11.length(); i11--) {
            sb2.append(' ');
        }
        sb2.append(l11);
        sb2.append(' ');
        sb2.append(archiveEntry.getName());
        return sb2.toString();
    }

    public static String toAsciiString(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, StandardCharsets.US_ASCII);
    }

    public static boolean matchAsciiBuffer(String str, byte[] bArr) {
        return matchAsciiBuffer(str, bArr, 0, bArr.length);
    }

    public static boolean isEqual(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        return isEqual(bArr, i11, i12, bArr2, i13, i14, false);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, false);
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2, boolean z11) {
        return isEqual(bArr, 0, bArr.length, bArr2, 0, bArr2.length, z11);
    }
}
