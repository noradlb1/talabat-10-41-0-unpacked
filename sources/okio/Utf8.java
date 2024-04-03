package okio;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "Utf8")
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i11) {
        if (i11 >= 0 && i11 <= 31) {
            return true;
        }
        return 127 <= i11 && i11 <= 159;
    }

    public static final boolean isUtf8Continuation(byte b11) {
        return (b11 & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i11, int i12, @NotNull Function1<? super Integer, Unit> function1) {
        boolean z11;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i13 = i11 + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i13];
        if ((b12 & 192) == 128) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b13 = (b12 ^ 3968) ^ (b11 << 6);
        if (b13 < 128) {
            function1.invoke(valueOf);
            return 2;
        }
        function1.invoke(Integer.valueOf(b13));
        return 2;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i11, int i12, @NotNull Function1<? super Integer, Unit> function1) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i13 = i11 + 2;
        boolean z13 = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            function1.invoke(valueOf);
            int i14 = i11 + 1;
            if (i12 > i14) {
                if ((bArr[i14] & 192) == 128) {
                    z13 = true;
                }
                if (!z13) {
                    return 1;
                }
                return 2;
            }
            return 1;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        if ((b12 & 192) == 128) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b13 = bArr[i13];
        if ((b13 & 192) == 128) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b14 = ((b13 ^ -123008) ^ (b12 << 6)) ^ (b11 << 12);
        if (b14 < 2048) {
            function1.invoke(valueOf);
            return 3;
        }
        if (55296 <= b14 && b14 <= 57343) {
            z13 = true;
        }
        if (z13) {
            function1.invoke(valueOf);
            return 3;
        }
        function1.invoke(Integer.valueOf(b14));
        return 3;
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i11, int i12, @NotNull Function1<? super Integer, Unit> function1) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i13 = i11 + 3;
        boolean z15 = false;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i12 <= i13) {
            function1.invoke(valueOf);
            int i14 = i11 + 1;
            if (i12 > i14) {
                if ((bArr[i14] & 192) == 128) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                if (z14) {
                    int i15 = i11 + 2;
                    if (i12 > i15) {
                        if ((bArr[i15] & 192) == 128) {
                            z15 = true;
                        }
                        if (!z15) {
                            return 2;
                        }
                        return 3;
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        if ((b12 & 192) == 128) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b13 = bArr[i11 + 2];
        if ((b13 & 192) == 128) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            function1.invoke(valueOf);
            return 2;
        }
        byte b14 = bArr[i13];
        if ((b14 & 192) == 128) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            function1.invoke(valueOf);
            return 3;
        }
        byte b15 = (((b14 ^ 3678080) ^ (b13 << 6)) ^ (b12 << 12)) ^ (b11 << Ascii.DC2);
        if (b15 > 1114111) {
            function1.invoke(valueOf);
            return 4;
        }
        if (55296 <= b15 && b15 <= 57343) {
            z15 = true;
        }
        if (z15) {
            function1.invoke(valueOf);
            return 4;
        } else if (b15 < 65536) {
            function1.invoke(valueOf);
            return 4;
        } else {
            function1.invoke(Integer.valueOf(b15));
            return 4;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r9 == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0116, code lost:
        if (r9 == false) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0012:
            if (r3 >= r1) goto L_0x01b5
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0033
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0022:
            if (r3 >= r1) goto L_0x0012
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0012
            int r3 = r3 + 1
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0022
        L_0x0033:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 128(0x80, float:1.794E-43)
            r9 = 0
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x006f
            int r5 = r3 + 1
            if (r1 > r5) goto L_0x004f
        L_0x0043:
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x004d:
            r7 = r11
            goto L_0x006d
        L_0x004f:
            byte r5 = r0[r5]
            r6 = r5 & 192(0xc0, float:2.69E-43)
            if (r6 != r8) goto L_0x0056
            r9 = r11
        L_0x0056:
            if (r9 != 0) goto L_0x0059
            goto L_0x0043
        L_0x0059:
            r5 = r5 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r4 = r4 ^ r5
            if (r4 >= r8) goto L_0x0062
            char r4 = (char) r10
            goto L_0x0063
        L_0x0062:
            char r4 = (char) r4
        L_0x0063:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x006c:
            r7 = 2
        L_0x006d:
            int r3 = r3 + r7
            goto L_0x0012
        L_0x006f:
            int r5 = r4 >> 4
            r12 = 57343(0xdfff, float:8.0355E-41)
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00e9
            int r5 = r3 + 2
            if (r1 > r5) goto L_0x0096
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004d
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0093
            r9 = r11
        L_0x0093:
            if (r9 != 0) goto L_0x006c
            goto L_0x004d
        L_0x0096:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x00a0
            r15 = r11
            goto L_0x00a1
        L_0x00a0:
            r15 = r9
        L_0x00a1:
            if (r15 != 0) goto L_0x00ae
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x004d
        L_0x00ae:
            byte r5 = r0[r5]
            r15 = r5 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x00b6
            r8 = r11
            goto L_0x00b7
        L_0x00b6:
            r8 = r9
        L_0x00b7:
            if (r8 != 0) goto L_0x00c4
            char r4 = (char) r10
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x006c
        L_0x00c4:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r5 = r5 ^ r7
            int r6 = r6 << 6
            r5 = r5 ^ r6
            int r4 = r4 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00dd
        L_0x00d2:
            char r4 = (char) r10
        L_0x00d3:
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x00e7
        L_0x00dd:
            if (r13 > r4) goto L_0x00e2
            if (r4 > r12) goto L_0x00e2
            r9 = r11
        L_0x00e2:
            if (r9 == 0) goto L_0x00e5
            goto L_0x00d2
        L_0x00e5:
            char r4 = (char) r4
            goto L_0x00d3
        L_0x00e7:
            r7 = r14
            goto L_0x006d
        L_0x00e9:
            int r5 = r4 >> 3
            if (r5 != r6) goto L_0x01aa
            int r5 = r3 + 3
            if (r1 > r5) goto L_0x011a
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004d
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0106
            r4 = r11
            goto L_0x0107
        L_0x0106:
            r4 = r9
        L_0x0107:
            if (r4 != 0) goto L_0x010b
            goto L_0x004d
        L_0x010b:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006c
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0116
            r9 = r11
        L_0x0116:
            if (r9 != 0) goto L_0x00e7
            goto L_0x006c
        L_0x011a:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x0124
            r15 = r11
            goto L_0x0125
        L_0x0124:
            r15 = r9
        L_0x0125:
            if (r15 != 0) goto L_0x0132
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x004d
        L_0x0132:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x013c
            r7 = r11
            goto L_0x013d
        L_0x013c:
            r7 = r9
        L_0x013d:
            if (r7 != 0) goto L_0x014a
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x006c
        L_0x014a:
            byte r5 = r0[r5]
            r7 = r5 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x0152
            r7 = r11
            goto L_0x0153
        L_0x0152:
            r7 = r9
        L_0x0153:
            if (r7 != 0) goto L_0x015f
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x00e7
        L_0x015f:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r5 = r5 ^ r7
            int r7 = r15 << 6
            r5 = r5 ^ r7
            int r6 = r6 << 12
            r5 = r5 ^ r6
            int r4 = r4 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x017b
        L_0x0171:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
        L_0x0178:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x01a7
        L_0x017b:
            if (r13 > r4) goto L_0x0180
            if (r4 > r12) goto L_0x0180
            r9 = r11
        L_0x0180:
            if (r9 == 0) goto L_0x0183
            goto L_0x0171
        L_0x0183:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0188
            goto L_0x0171
        L_0x0188:
            if (r4 == r10) goto L_0x0171
            int r5 = r4 >>> 10
            r6 = 55232(0xd7c0, float:7.7397E-41)
            int r5 = r5 + r6
            char r5 = (char) r5
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r2.invoke(r5)
            r4 = r4 & 1023(0x3ff, float:1.434E-42)
            r5 = 56320(0xdc00, float:7.8921E-41)
            int r4 = r4 + r5
            char r4 = (char) r4
            java.lang.Character r4 = java.lang.Character.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0178
        L_0x01a7:
            r7 = 4
            goto L_0x006d
        L_0x01aa:
            java.lang.Character r4 = java.lang.Character.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0012
        L_0x01b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(@NotNull String str, int i11, int i12, @NotNull Function1<? super Byte, Unit> function1) {
        boolean z11;
        int i13;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        while (i11 < i12) {
            char charAt = str.charAt(i11);
            if (Intrinsics.compare((int) charAt, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt));
                i11++;
                while (i11 < i12 && Intrinsics.compare((int) str.charAt(i11), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i11)));
                    i11++;
                }
            } else {
                if (Intrinsics.compare((int) charAt, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                } else {
                    boolean z12 = false;
                    if (55296 > charAt || charAt > 57343) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (!z11) {
                        function1.invoke(Byte.valueOf((byte) ((charAt >> 12) | 224)));
                        function1.invoke(Byte.valueOf((byte) (((charAt >> 6) & 63) | 128)));
                        function1.invoke(Byte.valueOf((byte) ((charAt & '?') | 128)));
                    } else {
                        if (Intrinsics.compare((int) charAt, 56319) <= 0 && i12 > (i13 = i11 + 1)) {
                            char charAt2 = str.charAt(i13);
                            if (56320 <= charAt2 && charAt2 <= 57343) {
                                z12 = true;
                            }
                            if (z12) {
                                int charAt3 = ((charAt << 10) + str.charAt(i13)) - 56613888;
                                function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | PsExtractor.VIDEO_STREAM_MASK)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                                function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                                i11 += 2;
                            }
                        }
                        function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                    }
                }
                i11++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r9 == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0114, code lost:
        if (r9 == false) goto L_0x006b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            r3 = r17
        L_0x0012:
            if (r3 >= r1) goto L_0x0199
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0031
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            int r3 = r3 + 1
        L_0x0021:
            if (r3 >= r1) goto L_0x0012
            byte r4 = r0[r3]
            if (r4 < 0) goto L_0x0012
            int r3 = r3 + 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.invoke(r4)
            goto L_0x0021
        L_0x0031:
            int r5 = r4 >> 5
            r6 = -2
            r8 = 128(0x80, float:1.794E-43)
            r9 = 0
            r10 = 65533(0xfffd, float:9.1831E-41)
            r11 = 1
            if (r5 != r6) goto L_0x006e
            int r5 = r3 + 1
            if (r1 > r5) goto L_0x004c
        L_0x0041:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x004a:
            r7 = r11
            goto L_0x006c
        L_0x004c:
            byte r5 = r0[r5]
            r6 = r5 & 192(0xc0, float:2.69E-43)
            if (r6 != r8) goto L_0x0053
            r9 = r11
        L_0x0053:
            if (r9 != 0) goto L_0x0056
            goto L_0x0041
        L_0x0056:
            r5 = r5 ^ 3968(0xf80, float:5.56E-42)
            int r4 = r4 << 6
            r4 = r4 ^ r5
            if (r4 >= r8) goto L_0x0062
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            goto L_0x0066
        L_0x0062:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0066:
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x006b:
            r7 = 2
        L_0x006c:
            int r3 = r3 + r7
            goto L_0x0012
        L_0x006e:
            int r5 = r4 >> 4
            r12 = 57343(0xdfff, float:8.0355E-41)
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 3
            if (r5 != r6) goto L_0x00e7
            int r5 = r3 + 2
            if (r1 > r5) goto L_0x0094
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004a
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0091
            r9 = r11
        L_0x0091:
            if (r9 != 0) goto L_0x006b
            goto L_0x004a
        L_0x0094:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x009e
            r15 = r11
            goto L_0x009f
        L_0x009e:
            r15 = r9
        L_0x009f:
            if (r15 != 0) goto L_0x00ab
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x004a
        L_0x00ab:
            byte r5 = r0[r5]
            r15 = r5 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x00b3
            r8 = r11
            goto L_0x00b4
        L_0x00b3:
            r8 = r9
        L_0x00b4:
            if (r8 != 0) goto L_0x00c0
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x006b
        L_0x00c0:
            r7 = -123008(0xfffffffffffe1f80, float:NaN)
            r5 = r5 ^ r7
            int r6 = r6 << 6
            r5 = r5 ^ r6
            int r4 = r4 << 12
            r4 = r4 ^ r5
            r5 = 2048(0x800, float:2.87E-42)
            if (r4 >= r5) goto L_0x00d8
        L_0x00ce:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x00d2:
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x00e5
        L_0x00d8:
            if (r13 > r4) goto L_0x00dd
            if (r4 > r12) goto L_0x00dd
            r9 = r11
        L_0x00dd:
            if (r9 == 0) goto L_0x00e0
            goto L_0x00ce
        L_0x00e0:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00d2
        L_0x00e5:
            r7 = r14
            goto L_0x006c
        L_0x00e7:
            int r5 = r4 >> 3
            if (r5 != r6) goto L_0x018e
            int r5 = r3 + 3
            if (r1 > r5) goto L_0x0118
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            int r4 = r3 + 1
            if (r1 <= r4) goto L_0x004a
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0104
            r4 = r11
            goto L_0x0105
        L_0x0104:
            r4 = r9
        L_0x0105:
            if (r4 != 0) goto L_0x0109
            goto L_0x004a
        L_0x0109:
            int r4 = r3 + 2
            if (r1 <= r4) goto L_0x006b
            byte r4 = r0[r4]
            r4 = r4 & 192(0xc0, float:2.69E-43)
            if (r4 != r8) goto L_0x0114
            r9 = r11
        L_0x0114:
            if (r9 != 0) goto L_0x00e5
            goto L_0x006b
        L_0x0118:
            int r6 = r3 + 1
            byte r6 = r0[r6]
            r15 = r6 & 192(0xc0, float:2.69E-43)
            if (r15 != r8) goto L_0x0122
            r15 = r11
            goto L_0x0123
        L_0x0122:
            r15 = r9
        L_0x0123:
            if (r15 != 0) goto L_0x0130
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x004a
        L_0x0130:
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r7 = r15 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x013a
            r7 = r11
            goto L_0x013b
        L_0x013a:
            r7 = r9
        L_0x013b:
            if (r7 != 0) goto L_0x0148
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x006b
        L_0x0148:
            byte r5 = r0[r5]
            r7 = r5 & 192(0xc0, float:2.69E-43)
            if (r7 != r8) goto L_0x0150
            r7 = r11
            goto L_0x0151
        L_0x0150:
            r7 = r9
        L_0x0151:
            if (r7 != 0) goto L_0x015d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x00e5
        L_0x015d:
            r7 = 3678080(0x381f80, float:5.154088E-39)
            r5 = r5 ^ r7
            int r7 = r15 << 6
            r5 = r5 ^ r7
            int r6 = r6 << 12
            r5 = r5 ^ r6
            int r4 = r4 << 18
            r4 = r4 ^ r5
            r5 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r5) goto L_0x0179
        L_0x016f:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
        L_0x0173:
            r2.invoke(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x018b
        L_0x0179:
            if (r13 > r4) goto L_0x017e
            if (r4 > r12) goto L_0x017e
            r9 = r11
        L_0x017e:
            if (r9 == 0) goto L_0x0181
            goto L_0x016f
        L_0x0181:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r5) goto L_0x0186
            goto L_0x016f
        L_0x0186:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0173
        L_0x018b:
            r7 = 4
            goto L_0x006c
        L_0x018e:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r2.invoke(r4)
            int r3 = r3 + 1
            goto L_0x0012
        L_0x0199:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i11, 0, 2, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i11, int i12) {
        boolean z11;
        boolean z12;
        int i13;
        char c11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z13 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i12 >= i11) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (i12 > str.length()) {
                    z13 = false;
                }
                if (z13) {
                    long j11 = 0;
                    while (i11 < i12) {
                        char charAt = str.charAt(i11);
                        if (charAt < 128) {
                            j11++;
                        } else {
                            if (charAt < 2048) {
                                i13 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i13 = 3;
                            } else {
                                int i14 = i11 + 1;
                                if (i14 < i12) {
                                    c11 = str.charAt(i14);
                                } else {
                                    c11 = 0;
                                }
                                if (charAt > 56319 || c11 < 56320 || c11 > 57343) {
                                    j11++;
                                    i11 = i14;
                                } else {
                                    j11 += (long) 4;
                                    i11 += 2;
                                }
                            }
                            j11 += (long) i13;
                        }
                        i11++;
                    }
                    return j11;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i12 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i12 + " < " + i11).toString());
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("beginIndex < 0: ", Integer.valueOf(i11)).toString());
    }

    public static /* synthetic */ long size$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return size(str, i11, i12);
    }
}
