package okio.internal;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.asm.Advice;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class _ByteStringKt {
    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0217 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0047 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x016c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0081 A[EDGE_INSN: B:263:0x0081->B:51:0x0081 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x00da A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x022b
            byte r7 = r0[r4]
            r8 = 159(0x9f, float:2.23E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 31
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x008a
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0045
            if (r7 == r11) goto L_0x0045
            if (r7 < 0) goto L_0x0031
            if (r7 > r10) goto L_0x0031
            r6 = r17
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            if (r6 != 0) goto L_0x0041
            if (r9 > r7) goto L_0x003b
            if (r7 > r8) goto L_0x003b
            r6 = r17
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            if (r6 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r6 = 0
            goto L_0x0043
        L_0x0041:
            r6 = r17
        L_0x0043:
            if (r6 != 0) goto L_0x0047
        L_0x0045:
            if (r7 != r12) goto L_0x0048
        L_0x0047:
            return r16
        L_0x0048:
            if (r7 >= r14) goto L_0x004d
            r6 = r17
            goto L_0x004e
        L_0x004d:
            r6 = 2
        L_0x004e:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x0051:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r4 = r4 + 1
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0060
            return r5
        L_0x0060:
            if (r7 == r13) goto L_0x007f
            if (r7 == r11) goto L_0x007f
            if (r7 < 0) goto L_0x006b
            if (r7 > r10) goto L_0x006b
            r6 = r17
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 != 0) goto L_0x007b
            if (r9 > r7) goto L_0x0075
            if (r7 > r8) goto L_0x0075
            r6 = r17
            goto L_0x0076
        L_0x0075:
            r6 = 0
        L_0x0076:
            if (r6 == 0) goto L_0x0079
            goto L_0x007b
        L_0x0079:
            r6 = 0
            goto L_0x007d
        L_0x007b:
            r6 = r17
        L_0x007d:
            if (r6 != 0) goto L_0x0081
        L_0x007f:
            if (r7 != r12) goto L_0x0082
        L_0x0081:
            return r16
        L_0x0082:
            if (r7 >= r14) goto L_0x0087
            r6 = r17
            goto L_0x0088
        L_0x0087:
            r6 = 2
        L_0x0088:
            int r5 = r5 + r6
            goto L_0x0051
        L_0x008a:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00eb
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0099
            if (r6 != r1) goto L_0x0098
            return r5
        L_0x0098:
            return r16
        L_0x0099:
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x00a2
            r15 = r17
            goto L_0x00a3
        L_0x00a2:
            r15 = 0
        L_0x00a3:
            if (r15 != 0) goto L_0x00a9
            if (r6 != r1) goto L_0x00a8
            return r5
        L_0x00a8:
            return r16
        L_0x00a9:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00b4
            if (r6 != r1) goto L_0x00b3
            return r5
        L_0x00b3:
            return r16
        L_0x00b4:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00b9
            return r5
        L_0x00b9:
            if (r3 == r13) goto L_0x00d8
            if (r3 == r11) goto L_0x00d8
            if (r3 < 0) goto L_0x00c4
            if (r3 > r10) goto L_0x00c4
            r6 = r17
            goto L_0x00c5
        L_0x00c4:
            r6 = 0
        L_0x00c5:
            if (r6 != 0) goto L_0x00d4
            if (r9 > r3) goto L_0x00ce
            if (r3 > r8) goto L_0x00ce
            r6 = r17
            goto L_0x00cf
        L_0x00ce:
            r6 = 0
        L_0x00cf:
            if (r6 == 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            r6 = 0
            goto L_0x00d6
        L_0x00d4:
            r6 = r17
        L_0x00d6:
            if (r6 != 0) goto L_0x00da
        L_0x00d8:
            if (r3 != r12) goto L_0x00db
        L_0x00da:
            return r16
        L_0x00db:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00e2
            r15 = r17
            goto L_0x00e3
        L_0x00e2:
            r15 = 2
        L_0x00e3:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            int r4 = r4 + 2
        L_0x00e8:
            r6 = r7
            goto L_0x0008
        L_0x00eb:
            int r3 = r7 >> 4
            r12 = 57343(0xdfff, float:8.0355E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 != r15) goto L_0x017c
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00fd
            if (r6 != r1) goto L_0x00fc
            return r5
        L_0x00fc:
            return r16
        L_0x00fd:
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x0108
            r9 = r17
            goto L_0x0109
        L_0x0108:
            r9 = 0
        L_0x0109:
            if (r9 != 0) goto L_0x010f
            if (r6 != r1) goto L_0x010e
            return r5
        L_0x010e:
            return r16
        L_0x010f:
            byte r3 = r0[r3]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x0118
            r9 = r17
            goto L_0x0119
        L_0x0118:
            r9 = 0
        L_0x0119:
            if (r9 != 0) goto L_0x011f
            if (r6 != r1) goto L_0x011e
            return r5
        L_0x011e:
            return r16
        L_0x011f:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0131
            if (r6 != r1) goto L_0x0130
            return r5
        L_0x0130:
            return r16
        L_0x0131:
            if (r8 > r3) goto L_0x0138
            if (r3 > r12) goto L_0x0138
            r7 = r17
            goto L_0x0139
        L_0x0138:
            r7 = 0
        L_0x0139:
            if (r7 == 0) goto L_0x013f
            if (r6 != r1) goto L_0x013e
            return r5
        L_0x013e:
            return r16
        L_0x013f:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0144
            return r5
        L_0x0144:
            if (r3 == r13) goto L_0x0167
            if (r3 == r11) goto L_0x0167
            if (r3 < 0) goto L_0x014f
            if (r3 > r10) goto L_0x014f
            r6 = r17
            goto L_0x0150
        L_0x014f:
            r6 = 0
        L_0x0150:
            if (r6 != 0) goto L_0x0163
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x015d
            r6 = 159(0x9f, float:2.23E-43)
            if (r3 > r6) goto L_0x015d
            r6 = r17
            goto L_0x015e
        L_0x015d:
            r6 = 0
        L_0x015e:
            if (r6 == 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r6 = 0
            goto L_0x0165
        L_0x0163:
            r6 = r17
        L_0x0165:
            if (r6 != 0) goto L_0x016c
        L_0x0167:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x016d
        L_0x016c:
            return r16
        L_0x016d:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0174
            r15 = r17
            goto L_0x0175
        L_0x0174:
            r15 = 2
        L_0x0175:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            int r4 = r4 + 3
            goto L_0x00e8
        L_0x017c:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x0227
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x0188
            if (r6 != r1) goto L_0x0187
            return r5
        L_0x0187:
            return r16
        L_0x0188:
            int r9 = r4 + 1
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x0193
            r15 = r17
            goto L_0x0194
        L_0x0193:
            r15 = 0
        L_0x0194:
            if (r15 != 0) goto L_0x019a
            if (r6 != r1) goto L_0x0199
            return r5
        L_0x0199:
            return r16
        L_0x019a:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01a5
            r10 = r17
            goto L_0x01a6
        L_0x01a5:
            r10 = 0
        L_0x01a6:
            if (r10 != 0) goto L_0x01ac
            if (r6 != r1) goto L_0x01ab
            return r5
        L_0x01ab:
            return r16
        L_0x01ac:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01b5
            r10 = r17
            goto L_0x01b6
        L_0x01b5:
            r10 = 0
        L_0x01b6:
            if (r10 != 0) goto L_0x01bc
            if (r6 != r1) goto L_0x01bb
            return r5
        L_0x01bb:
            return r16
        L_0x01bc:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r9 = r9 << 12
            r3 = r3 ^ r9
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01d2
            if (r6 != r1) goto L_0x01d1
            return r5
        L_0x01d1:
            return r16
        L_0x01d2:
            if (r8 > r3) goto L_0x01d9
            if (r3 > r12) goto L_0x01d9
            r7 = r17
            goto L_0x01da
        L_0x01d9:
            r7 = 0
        L_0x01da:
            if (r7 == 0) goto L_0x01e0
            if (r6 != r1) goto L_0x01df
            return r5
        L_0x01df:
            return r16
        L_0x01e0:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01e8
            if (r6 != r1) goto L_0x01e7
            return r5
        L_0x01e7:
            return r16
        L_0x01e8:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01ed
            return r5
        L_0x01ed:
            if (r3 == r13) goto L_0x0212
            if (r3 == r11) goto L_0x0212
            if (r3 < 0) goto L_0x01fa
            r6 = 31
            if (r3 > r6) goto L_0x01fa
            r6 = r17
            goto L_0x01fb
        L_0x01fa:
            r6 = 0
        L_0x01fb:
            if (r6 != 0) goto L_0x020e
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x0208
            r6 = 159(0x9f, float:2.23E-43)
            if (r3 > r6) goto L_0x0208
            r6 = r17
            goto L_0x0209
        L_0x0208:
            r6 = 0
        L_0x0209:
            if (r6 == 0) goto L_0x020c
            goto L_0x020e
        L_0x020c:
            r6 = 0
            goto L_0x0210
        L_0x020e:
            r6 = r17
        L_0x0210:
            if (r6 != 0) goto L_0x0217
        L_0x0212:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0218
        L_0x0217:
            return r16
        L_0x0218:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x021f
            r15 = r17
            goto L_0x0220
        L_0x021f:
            r15 = 2
        L_0x0220:
            int r5 = r5 + r15
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            int r4 = r4 + 4
            goto L_0x00e8
        L_0x0227:
            if (r6 != r1) goto L_0x022a
            return r5
        L_0x022a:
            return r16
        L_0x022b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        int i11 = 0;
        while (i11 < min) {
            byte b11 = byteString.getByte(i11) & 255;
            byte b12 = byteString2.getByte(i11) & 255;
            if (b11 == b12) {
                i11++;
            } else if (b11 < b12) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final void commonCopyInto(@NotNull ByteString byteString, int i11, @NotNull byte[] bArr, int i12, int i13) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "target");
        byte[] unused = ArraysKt___ArraysJvmKt.copyInto(byteString.getData$okio(), bArr, i12, i11, i13 + i11);
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i11 = 0;
        if (str.length() % 2 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i12 = length - 1;
            if (i12 >= 0) {
                while (true) {
                    int i13 = i11 + 1;
                    int i14 = i11 * 2;
                    bArr[i11] = (byte) ((decodeHexDigit(str.charAt(i14)) << 4) + decodeHexDigit(str.charAt(i14 + 1)));
                    if (i13 > i12) {
                        break;
                    }
                    i11 = i13;
                }
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex string: ", str).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(@NotNull ByteString byteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString byteString, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio()[i11];
    }

    public static final int commonGetSize(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        byte[] data$okio = byteString.getData$okio();
        int length = data$okio.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            byte b11 = data$okio[i11];
            i11++;
            int i13 = i12 + 1;
            cArr[i12] = getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i12 = i13 + 1;
            cArr[i13] = getHEX_DIGIT_CHARS()[b11 & Ascii.SI];
        }
        return StringsKt__StringsJVMKt.concatToString(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i11, 0);
        if (max > length) {
            return -1;
        }
        while (true) {
            int i12 = max + 1;
            if (_UtilKt.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
                return max;
            }
            if (max == length) {
                return -1;
            }
            max = i12;
        }
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull ByteString byteString2, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i11);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i11, @NotNull ByteString byteString2, int i12, int i13) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(i12, byteString.getData$okio(), i11, i13);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString byteString, int i11, int i12) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i12);
        boolean z13 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (resolveDefaultParameter - i11 < 0) {
                    z13 = false;
                }
                if (!z13) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i11 == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), i11, resolveDefaultParameter));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString byteString) {
        byte b11;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i11 = 0;
        while (i11 < byteString.getData$okio().length) {
            byte b12 = byteString.getData$okio()[i11];
            byte b13 = (byte) 65;
            if (b12 < b13 || b12 > (b11 = (byte) 90)) {
                i11++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i11] = (byte) (b12 + 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b14 = copyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        copyOf[i12] = (byte) (b14 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString byteString) {
        byte b11;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i11 = 0;
        while (i11 < byteString.getData$okio().length) {
            byte b12 = byteString.getData$okio()[i11];
            byte b13 = (byte) 97;
            if (b12 < b13 || b12 > (b11 = (byte) 122)) {
                i11++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i11] = (byte) (b12 - 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b14 = copyOf[i12];
                    if (b14 >= b13 && b14 <= b11) {
                        copyOf[i12] = (byte) (b14 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] bArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i11, (long) i12);
        return new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i11, i12 + i11));
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        boolean z11;
        boolean z12;
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        boolean z13 = true;
        if (byteString.getData$okio().length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 != null) {
                String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String replace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
                if (access$codePointIndexToCharIndex < utf8.length()) {
                    return "[size=" + byteString.getData$okio().length + " text=" + replace$default + "…]";
                }
                return "[text=" + replace$default + AbstractJsonLexerKt.END_LIST;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + AbstractJsonLexerKt.END_LIST;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(byteString.getData$okio().length);
            sb2.append(" hex=");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                if (resolveDefaultParameter + 0 < 0) {
                    z13 = false;
                }
                if (z13) {
                    if (resolveDefaultParameter != byteString.getData$okio().length) {
                        byteString2 = new ByteString(ArraysKt___ArraysJvmKt.copyOfRange(byteString.getData$okio(), 0, resolveDefaultParameter));
                    }
                    sb2.append(byteString2.hex());
                    sb2.append("…]");
                    return sb2.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(@NotNull ByteString byteString, @NotNull Buffer buffer, int i11, int i12) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i11, i12);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c11) {
        boolean z11 = true;
        if ('0' <= c11 && c11 <= '9') {
            return c11 - '0';
        }
        char c12 = 'a';
        if (!('a' <= c11 && c11 <= 'f')) {
            c12 = 'A';
            if ('A' > c11 || c11 > 'F') {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex digit: ", Character.valueOf(c11)));
            }
        }
        return (c11 - c12) + 10;
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final boolean commonEndsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString byteString, @NotNull byte[] bArr, int i11) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i11), byteString.getData$okio().length - bArr.length);
        if (min < 0) {
            return -1;
        }
        while (true) {
            int i12 = min - 1;
            if (_UtilKt.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
            if (i12 < 0) {
                return -1;
            }
            min = i12;
        }
    }

    public static final boolean commonRangeEquals(@NotNull ByteString byteString, int i11, @NotNull byte[] bArr, int i12, int i13) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i11 >= 0 && i11 <= byteString.getData$okio().length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && _UtilKt.arrayRangeEquals(byteString.getData$okio(), i11, bArr, i12, i13);
    }

    public static final boolean commonStartsWith(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
