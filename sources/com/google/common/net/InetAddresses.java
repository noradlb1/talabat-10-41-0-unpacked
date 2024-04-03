package com.google.common.net;

import com.facebook.internal.security.CertificateUtil;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class InetAddresses {
    /* access modifiers changed from: private */
    public static final Inet4Address ANY4 = ((Inet4Address) forString("0.0.0.0"));
    private static final char IPV4_DELIMITER = '.';
    private static final CharMatcher IPV4_DELIMITER_MATCHER = CharMatcher.is('.');
    private static final int IPV4_PART_COUNT = 4;
    private static final char IPV6_DELIMITER = ':';
    private static final CharMatcher IPV6_DELIMITER_MATCHER = CharMatcher.is(':');
    private static final int IPV6_PART_COUNT = 8;
    private static final Inet4Address LOOPBACK4 = ((Inet4Address) forString("127.0.0.1"));

    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@CheckForNull Inet4Address inet4Address, @CheckForNull Inet4Address inet4Address2, int i11, int i12) {
            boolean z11;
            boolean z12 = true;
            if (i11 < 0 || i11 > 65535) {
                z11 = false;
            } else {
                z11 = true;
            }
            Preconditions.checkArgument(z11, "port '%s' is out of range (0 <= port <= 0xffff)", i11);
            Preconditions.checkArgument((i12 < 0 || i12 > 65535) ? false : z12, "flags '%s' is out of range (0 <= flags <= 0xffff)", i12);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i11;
            this.flags = i12;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getPort() {
            return this.port;
        }

        public Inet4Address getServer() {
            return this.server;
        }
    }

    private InetAddresses() {
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e11) {
            throw new AssertionError(e11);
        }
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < iArr.length + 1; i14++) {
            if (i14 >= iArr.length || iArr[i14] != 0) {
                if (i13 >= 0) {
                    int i15 = i14 - i13;
                    if (i15 > i11) {
                        i12 = i13;
                        i11 = i15;
                    }
                    i13 = -1;
                }
            } else if (i13 < 0) {
                i13 = i14;
            }
        }
        if (i11 >= 2) {
            Arrays.fill(iArr, i12, i11 + i12, -1);
        }
    }

    @CheckForNull
    private static String convertDottedQuadToHex(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] textToNumericFormatV4 = textToNumericFormatV4(str.substring(lastIndexOf));
        if (textToNumericFormatV4 == null) {
            return null;
        }
        String hexString = Integer.toHexString(((textToNumericFormatV4[0] & 255) << 8) | (textToNumericFormatV4[1] & 255));
        String hexString2 = Integer.toHexString((textToNumericFormatV4[3] & 255) | ((textToNumericFormatV4[2] & 255) << 8));
        return substring + hexString + CertificateUtil.DELIMITER + hexString2;
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        boolean z11;
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        if (length >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Decrementing %s would wrap.", (Object) inetAddress);
        address[length] = (byte) (address[length] - 1);
        return bytesToInetAddress(address);
    }

    @CanIgnoreReturnValue
    public static InetAddress forString(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes != null) {
            return bytesToInetAddress(ipStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static InetAddress forUriString(String str) {
        InetAddress forUriStringNoThrow = forUriStringNoThrow(str);
        if (forUriStringNoThrow != null) {
            return forUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    @CheckForNull
    private static InetAddress forUriStringNoThrow(String str) {
        int i11;
        Preconditions.checkNotNull(str);
        if (!str.startsWith("[") || !str.endsWith("]")) {
            i11 = 4;
        } else {
            str = str.substring(1, str.length() - 1);
            i11 = 16;
        }
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != i11) {
            return null;
        }
        return bytesToInetAddress(ipStringToBytes);
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }

    private static InetAddress fromBigInteger(BigInteger bigInteger, boolean z11) {
        boolean z12;
        int i11;
        if (bigInteger.signum() >= 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "BigInteger must be greater than or equal to 0");
        if (z11) {
            i11 = 16;
        } else {
            i11 = 4;
        }
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i11];
        int max = Math.max(0, byteArray.length - i11);
        int length = byteArray.length - max;
        int i12 = i11 - length;
        int i13 = 0;
        while (i13 < max) {
            if (byteArray[i13] == 0) {
                i13++;
            } else {
                throw formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i11), bigInteger);
            }
        }
        System.arraycopy(byteArray, max, bArr, i12, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e11) {
            throw new AssertionError(e11);
        }
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) fromBigInteger(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) fromBigInteger(bigInteger, true);
    }

    public static Inet4Address fromInteger(int i11) {
        return getInet4Address(Ints.toByteArray(i11));
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr2[i11] = bArr[(bArr.length - i11) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z11;
        long j11;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i11 = 0;
        while (true) {
            if (i11 >= 15) {
                z11 = true;
                break;
            } else if (address[i11] != 0) {
                z11 = false;
                break;
            } else {
                i11++;
            }
        }
        if (z11 && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z11 && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            j11 = (long) getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        } else {
            j11 = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int asInt = Hashing.murmur3_32_fixed().hashLong(j11).asInt() | -536870912;
        if (asInt == -1) {
            asInt = -2;
        }
        return getInet4Address(Ints.toByteArray(asInt));
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        boolean z11;
        if (bArr.length == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", (Object) toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        short readShort = ByteStreams.newDataInput(address, 8).readShort() & UShort.MAX_VALUE;
        int i11 = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i12 = 0; i12 < copyOfRange.length; i12++) {
            copyOfRange[i12] = (byte) (~copyOfRange[i12]);
        }
        return new TeredoInfo(inet4Address, getInet4Address(copyOfRange), i11, readShort);
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    private static String hextetsToIPv6String(int[] iArr) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder(39);
        int i11 = 0;
        boolean z12 = false;
        while (i11 < iArr.length) {
            if (iArr[i11] >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (z12) {
                    sb2.append(':');
                }
                sb2.append(Integer.toHexString(iArr[i11]));
            } else if (i11 == 0 || z12) {
                sb2.append("::");
            }
            i11++;
            z12 = z11;
        }
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.InetAddress increment(java.net.InetAddress r6) {
        /*
            byte[] r0 = r6.getAddress()
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
        L_0x0007:
            r3 = 0
            if (r1 < 0) goto L_0x0014
            byte r4 = r0[r1]
            r5 = -1
            if (r4 != r5) goto L_0x0014
            r0[r1] = r3
            int r1 = r1 + -1
            goto L_0x0007
        L_0x0014:
            if (r1 < 0) goto L_0x0017
            r3 = r2
        L_0x0017:
            java.lang.String r4 = "Incrementing %s would wrap."
            com.google.common.base.Preconditions.checkArgument((boolean) r3, (java.lang.String) r4, (java.lang.Object) r6)
            byte r6 = r0[r1]
            int r6 = r6 + r2
            byte r6 = (byte) r6
            r0[r1] = r6
            java.net.InetAddress r6 = bytesToInetAddress(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.increment(java.net.InetAddress):java.net.InetAddress");
    }

    @CheckForNull
    private static byte[] ipStringToBytes(String str) {
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (true) {
            if (i11 >= str.length()) {
                i11 = -1;
                break;
            }
            char charAt = str.charAt(i11);
            if (charAt == '.') {
                z11 = true;
            } else if (charAt == ':') {
                if (z11) {
                    return null;
                }
                z12 = true;
            } else if (charAt == '%') {
                break;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
            i11++;
        }
        if (z12) {
            if (z11 && (str = convertDottedQuadToHex(str)) == null) {
                return null;
            }
            if (i11 != -1) {
                str = str.substring(0, i11);
            }
            return textToNumericFormatV6(str);
        } else if (!z11 || i11 != -1) {
            return null;
        } else {
            return textToNumericFormatV4(str);
        }
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 2) {
            return true;
        }
        return false;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        byte b11;
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && ((b11 = address[15]) == 0 || b11 == 1)) {
            return false;
        }
        return true;
    }

    public static boolean isInetAddress(String str) {
        return ipStringToBytes(str) != null;
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2) {
            return true;
        }
        return false;
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != 16) {
            return false;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= 10) {
                for (int i12 = 10; i12 < 12; i12++) {
                    if (ipStringToBytes[i12] != -1) {
                        return false;
                    }
                }
                return true;
            } else if (ipStringToBytes[i11] != 0) {
                return false;
            } else {
                i11++;
            }
        }
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        for (byte b11 : inetAddress.getAddress()) {
            if (b11 != -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0) {
            return true;
        }
        return false;
    }

    public static boolean isUriInetAddress(String str) {
        return forUriStringNoThrow(str) != null;
    }

    private static short parseHextet(String str, int i11, int i12) {
        int i13 = i12 - i11;
        if (i13 <= 0 || i13 > 4) {
            throw new NumberFormatException();
        }
        int i14 = 0;
        while (i11 < i12) {
            i14 = (i14 << 4) | Character.digit(str.charAt(i11), 16);
            i11++;
        }
        return (short) i14;
    }

    private static byte parseOctet(String str, int i11, int i12) {
        int i13 = i12 - i11;
        if (i13 <= 0 || i13 > 3) {
            throw new NumberFormatException();
        } else if (i13 <= 1 || str.charAt(i11) != '0') {
            int i14 = 0;
            while (i11 < i12) {
                int i15 = i14 * 10;
                int digit = Character.digit(str.charAt(i11), 10);
                if (digit >= 0) {
                    i14 = i15 + digit;
                    i11++;
                } else {
                    throw new NumberFormatException();
                }
            }
            if (i14 <= 255) {
                return (byte) i14;
            }
            throw new NumberFormatException();
        } else {
            throw new NumberFormatException();
        }
    }

    @CheckForNull
    private static byte[] textToNumericFormatV4(String str) {
        if (IPV4_DELIMITER_MATCHER.countIn(str) + 1 != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        int i11 = 0;
        int i12 = 0;
        while (i11 < 4) {
            int indexOf = str.indexOf(46, i12);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                bArr[i11] = parseOctet(str, i12, indexOf);
                i12 = indexOf + 1;
                i11++;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return bArr;
    }

    @CheckForNull
    private static byte[] textToNumericFormatV6(String str) {
        int countIn = IPV6_DELIMITER_MATCHER.countIn(str);
        if (countIn >= 2 && countIn <= 8) {
            int i11 = 1;
            int i12 = countIn + 1;
            int i13 = 8 - i12;
            boolean z11 = false;
            for (int i14 = 0; i14 < str.length() - 1; i14++) {
                if (str.charAt(i14) == ':' && str.charAt(i14 + 1) == ':') {
                    if (z11) {
                        return null;
                    }
                    i13++;
                    if (i14 == 0) {
                        i13++;
                    }
                    if (i14 == str.length() - 2) {
                        i13++;
                    }
                    z11 = true;
                }
            }
            if (str.charAt(0) == ':' && str.charAt(1) != ':') {
                return null;
            }
            if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) != ':') {
                return null;
            }
            if (z11 && i13 <= 0) {
                return null;
            }
            if (!z11 && i12 != 8) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(16);
            try {
                if (str.charAt(0) != ':') {
                    i11 = 0;
                }
                while (i11 < str.length()) {
                    int indexOf = str.indexOf(58, i11);
                    if (indexOf == -1) {
                        indexOf = str.length();
                    }
                    if (str.charAt(i11) == ':') {
                        for (int i15 = 0; i15 < i13; i15++) {
                            allocate.putShort(0);
                        }
                    } else {
                        allocate.putShort(parseHextet(str, i11, indexOf));
                    }
                    i11 = indexOf + 1;
                }
                return allocate.array();
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = i11 * 2;
            iArr[i11] = Ints.fromBytes((byte) 0, (byte) 0, address[i12], address[i12 + 1]);
        }
        compressLongestRunOfZeroes(iArr);
        return hextetsToIPv6String(iArr);
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        return "[" + toAddrString(inetAddress) + "]";
    }
}
