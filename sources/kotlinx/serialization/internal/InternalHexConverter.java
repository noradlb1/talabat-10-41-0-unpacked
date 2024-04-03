package kotlinx.serialization.internal;

import com.google.common.base.Ascii;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/internal/InternalHexConverter;", "", "()V", "hexCode", "", "hexToInt", "", "ch", "", "parseHexBinary", "", "s", "printHexBinary", "data", "lowerCase", "", "toHexString", "n", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InternalHexConverter {
    @NotNull
    public static final InternalHexConverter INSTANCE = new InternalHexConverter();
    @NotNull
    private static final String hexCode = "0123456789ABCDEF";

    private InternalHexConverter() {
    }

    private final int hexToInt(char c11) {
        boolean z11 = true;
        if ('0' <= c11 && c11 < ':') {
            return c11 - '0';
        }
        char c12 = 'A';
        if (!('A' <= c11 && c11 < 'G')) {
            c12 = 'a';
            if ('a' > c11 || c11 >= 'g') {
                z11 = false;
            }
            if (!z11) {
                return -1;
            }
        }
        return (c11 - c12) + 10;
    }

    public static /* synthetic */ String printHexBinary$default(InternalHexConverter internalHexConverter, byte[] bArr, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return internalHexConverter.printHexBinary(bArr, z11);
    }

    @NotNull
    public final byte[] parseHexBinary(@NotNull String str) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(str, "s");
        int length = str.length();
        if (length % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            byte[] bArr = new byte[(length / 2)];
            int i11 = 0;
            while (i11 < length) {
                int hexToInt = hexToInt(str.charAt(i11));
                int i12 = i11 + 1;
                int hexToInt2 = hexToInt(str.charAt(i12));
                if (hexToInt == -1 || hexToInt2 == -1) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (z12) {
                    bArr[i11 / 2] = (byte) ((hexToInt << 4) + hexToInt2);
                    i11 += 2;
                } else {
                    throw new IllegalArgumentException(("Invalid hex chars: " + str.charAt(i11) + str.charAt(i12)).toString());
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("HexBinary string must be even length".toString());
    }

    @NotNull
    public final String printHexBinary(@NotNull byte[] bArr, boolean z11) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(hexCode.charAt((b11 >> 4) & 15));
            sb2.append(hexCode.charAt(b11 & Ascii.SI));
        }
        if (z11) {
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "r.toString()");
            String lowerCase = sb3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        String sb4 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "r.toString()");
        return sb4;
    }

    @NotNull
    public final String toHexString(int i11) {
        byte[] bArr = new byte[4];
        boolean z11 = false;
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i12] = (byte) (i11 >> (24 - (i12 * 8)));
        }
        String trimStart = StringsKt__StringsKt.trimStart(printHexBinary(bArr, true), '0');
        if (trimStart.length() > 0) {
            z11 = true;
        }
        if (!z11) {
            trimStart = null;
        }
        if (trimStart == null) {
            return "0";
        }
        return trimStart;
    }
}
