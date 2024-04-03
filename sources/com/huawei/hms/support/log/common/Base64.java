package com.huawei.hms.support.log.common;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f49883a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/', SignatureVisitor.INSTANCEOF};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f49884b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private Base64() {
    }

    private static int a(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt > 255 || f49884b[charAt] < 0) {
                length--;
            }
        }
        return length;
    }

    public static byte[] decode(String str) {
        byte b11;
        if (str == null) {
            return new byte[0];
        }
        int a11 = a(str);
        int i11 = (a11 / 4) * 3;
        int i12 = a11 % 4;
        if (i12 == 3) {
            i11 += 2;
        }
        if (i12 == 2) {
            i11++;
        }
        byte[] bArr = new byte[i11];
        int i13 = 0;
        byte b12 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < str.length(); i15++) {
            char charAt = str.charAt(i15);
            if (charAt > 255) {
                b11 = -1;
            } else {
                b11 = f49884b[charAt];
            }
            if (b11 >= 0) {
                i14 += 6;
                b12 = (b12 << 6) | b11;
                if (i14 >= 8) {
                    i14 -= 8;
                    bArr[i13] = (byte) (255 & (b12 >> i14));
                    i13++;
                }
            }
        }
        if (i13 != i11) {
            return new byte[0];
        }
        return bArr;
    }

    public static String encode(byte[] bArr) {
        return bArr == null ? "" : encode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr, int i11) {
        boolean z11;
        if (bArr == null) {
            return "";
        }
        char[] cArr = new char[(((i11 + 2) / 3) * 4)];
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11) {
            int i14 = (bArr[i12] & 255) << 8;
            int i15 = i12 + 1;
            boolean z12 = true;
            if (i15 < i11) {
                i14 |= bArr[i15] & 255;
                z11 = true;
            } else {
                z11 = false;
            }
            int i16 = i14 << 8;
            int i17 = i12 + 2;
            if (i17 < i11) {
                i16 |= bArr[i17] & 255;
            } else {
                z12 = false;
            }
            int i18 = i13 + 3;
            char[] cArr2 = f49883a;
            int i19 = 64;
            cArr[i18] = cArr2[z12 ? i16 & 63 : 64];
            int i21 = i16 >> 6;
            int i22 = i13 + 2;
            if (z11) {
                i19 = i21 & 63;
            }
            cArr[i22] = cArr2[i19];
            int i23 = i21 >> 6;
            cArr[i13 + 1] = cArr2[i23 & 63];
            cArr[i13 + 0] = cArr2[(i23 >> 6) & 63];
            i12 += 3;
            i13 += 4;
        }
        return new String(cArr);
    }
}
