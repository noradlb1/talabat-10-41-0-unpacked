package okhttp3.internal;

import com.facebook.internal.security.CertificateUtil;
import com.visa.checkout.Profile;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            char charAt = str.charAt(i11);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt__StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
            i11 = i12;
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i11, int i12, byte[] bArr, int i13) {
        int i14 = i13;
        while (i11 < i12) {
            if (i14 == bArr.length) {
                return false;
            }
            if (i14 != i13) {
                if (str.charAt(i11) != '.') {
                    return false;
                }
                i11++;
            }
            int i15 = i11;
            int i16 = 0;
            while (i15 < i12) {
                char charAt = str.charAt(i15);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                } else if ((i16 == 0 && i11 != i15) || (i16 = ((i16 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i15++;
                }
            }
            if (i15 - i11 == 0) {
                return false;
            }
            bArr[i14] = (byte) i16;
            i14++;
            i11 = i15;
        }
        if (i14 == i13 + 4) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0097, code lost:
        if (r13 == 16) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r14 != -1) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ad, code lost:
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[LOOP:0: B:1:0x000e->B:36:0x0084, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096 A[EDGE_INSN: B:44:0x0096->B:37:0x0096 ?: BREAK  
    EDGE_INSN: B:50:0x0096->B:37:0x0096 ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r14 = r11
            r15 = r14
            r13 = 0
        L_0x000e:
            r16 = 0
            if (r12 >= r7) goto L_0x0097
            if (r13 != r8) goto L_0x0015
            return r16
        L_0x0015:
            int r5 = r12 + 2
            if (r5 > r7) goto L_0x0038
            java.lang.String r1 = "::"
            r3 = 0
            r4 = 4
            r17 = 0
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0038
            if (r14 == r11) goto L_0x002e
            return r16
        L_0x002e:
            int r13 = r13 + 2
            if (r10 != r7) goto L_0x0035
            r14 = r13
            goto L_0x0097
        L_0x0035:
            r15 = r10
            r14 = r13
            goto L_0x0067
        L_0x0038:
            if (r13 == 0) goto L_0x0066
            java.lang.String r1 = ":"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x004b
            int r12 = r12 + 1
            goto L_0x0066
        L_0x004b:
            java.lang.String r1 = "."
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0065
            int r0 = r13 + -2
            boolean r0 = decodeIpv4Suffix(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L_0x0062
            return r16
        L_0x0062:
            int r13 = r13 + 2
            goto L_0x0097
        L_0x0065:
            return r16
        L_0x0066:
            r15 = r12
        L_0x0067:
            r12 = r15
            r0 = 0
        L_0x0069:
            if (r12 >= r7) goto L_0x007c
            char r1 = r6.charAt(r12)
            int r1 = okhttp3.internal.Util.parseHexDigit(r1)
            if (r1 != r11) goto L_0x0076
            goto L_0x007c
        L_0x0076:
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L_0x0069
        L_0x007c:
            int r1 = r12 - r15
            if (r1 == 0) goto L_0x0096
            r2 = 4
            if (r1 <= r2) goto L_0x0084
            goto L_0x0096
        L_0x0084:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L_0x000e
        L_0x0096:
            return r16
        L_0x0097:
            if (r13 == r8) goto L_0x00a9
            if (r14 != r11) goto L_0x009c
            return r16
        L_0x009c:
            int r0 = r13 - r14
            int r1 = 16 - r0
            java.lang.System.arraycopy(r9, r14, r9, r1, r0)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            java.util.Arrays.fill(r9, r14, r8, r0)
        L_0x00a9:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < bArr.length) {
            int i15 = i13;
            while (i15 < 16 && bArr[i15] == 0 && bArr[i15 + 1] == 0) {
                i15 += 2;
            }
            int i16 = i15 - i13;
            if (i16 > i14 && i16 >= 4) {
                i11 = i13;
                i14 = i16;
            }
            i13 = i15 + 2;
        }
        Buffer buffer = new Buffer();
        while (i12 < bArr.length) {
            if (i12 == i11) {
                buffer.writeByte(58);
                i12 += i14;
                if (i12 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i12 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) ((Util.and(bArr[i12], 255) << 8) | Util.and(bArr[i12 + 1], 255)));
                i12 += 2;
            }
        }
        return buffer.readUtf8();
    }

    @Nullable
    public static final String toCanonicalHost(@NotNull String str) {
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z11 = false;
        if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) CertificateUtil.DELIMITER, false, 2, (Object) null)) {
            if (!StringsKt__StringsJVMKt.startsWith$default(str, "[", false, 2, (Object) null) || !StringsKt__StringsJVMKt.endsWith$default(str, "]", false, 2, (Object) null)) {
                inetAddress = decodeIpv6(str, 0, str.length());
            } else {
                inetAddress = decodeIpv6(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return inetAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    z11 = true;
                }
                if (!z11 && !containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
