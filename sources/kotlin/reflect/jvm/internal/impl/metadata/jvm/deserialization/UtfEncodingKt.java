package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class UtfEncodingKt {
    @NotNull
    public static final byte[] stringsToBytes(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "strings");
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
}
