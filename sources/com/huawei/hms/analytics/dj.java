package com.huawei.hms.analytics;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import java.nio.charset.Charset;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class dj {
    private static final byte[] klm = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final char[] lmn = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', Advice.OffsetMapping.ForOrigin.Renderer.ForPropertyName.SYMBOL, 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, AbstractJsonLexerKt.UNICODE_ESC, 'v', 'w', 'x', 'y', 'z', '0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/', SignatureVisitor.INSTANCEOF};

    public static String klm(String str) {
        try {
            byte[] lmn2 = lmn(str);
            return lmn2.length == 0 ? "" : new String(lmn2, Charset.forName("UTF-8"));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static byte[] lmn(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt > 255 || klm[charAt] < 0) {
                length--;
            }
        }
        int i12 = (length / 4) * 3;
        int i13 = length % 4;
        if (i13 == 3) {
            i12 += 2;
        }
        if (i13 == 2) {
            i12++;
        }
        byte[] bArr = new byte[i12];
        int i14 = 0;
        byte b11 = 0;
        int i15 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            char charAt2 = str.charAt(i16);
            byte b12 = charAt2 > 255 ? -1 : klm[charAt2];
            if (b12 >= 0) {
                i15 += 6;
                b11 = (b11 << 6) | b12;
                if (i15 >= 8) {
                    i15 -= 8;
                    bArr[i14] = (byte) ((b11 >> i15) & 255);
                    i14++;
                }
            }
        }
        return i14 != i12 ? new byte[0] : bArr;
    }
}
