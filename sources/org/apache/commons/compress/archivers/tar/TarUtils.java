package org.apache.commons.compress.archivers.tar;

import com.squareup.moshi.Json;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class TarUtils {
    private static final int BYTE_MASK = 255;
    static final ZipEncoding DEFAULT_ENCODING = ZipEncodingHelper.getZipEncoding((String) null);
    static final ZipEncoding FALLBACK_ENCODING = new ZipEncoding() {
        public boolean canEncode(String str) {
            return true;
        }

        public String decode(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder(bArr.length);
            for (byte b11 : bArr) {
                if (b11 == 0) {
                    break;
                }
                sb2.append((char) (b11 & 255));
            }
            return sb2.toString();
        }

        public ByteBuffer encode(String str) {
            int length = str.length();
            byte[] bArr = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                bArr[i11] = (byte) str.charAt(i11);
            }
            return ByteBuffer.wrap(bArr);
        }
    };

    private TarUtils() {
    }

    public static long computeCheckSum(byte[] bArr) {
        long j11 = 0;
        for (byte b11 : bArr) {
            j11 += (long) (b11 & 255);
        }
        return j11;
    }

    private static String exceptionMessage(byte[] bArr, int i11, int i12, int i13, byte b11) {
        String replace = new String(bArr, i11, i12).replace(Json.UNSET_NAME, "{NUL}");
        return "Invalid byte " + b11 + " at offset " + (i13 - i11) + " in '" + replace + "' len=" + i12;
    }

    private static void formatBigIntegerBinary(long j11, byte[] bArr, int i11, int i12, boolean z11) {
        byte[] byteArray = BigInteger.valueOf(j11).toByteArray();
        int length = byteArray.length;
        if (length <= i12 - 1) {
            int i13 = (i12 + i11) - length;
            int i14 = 0;
            System.arraycopy(byteArray, 0, bArr, i13, length);
            if (z11) {
                i14 = 255;
            }
            byte b11 = (byte) i14;
            while (true) {
                i11++;
                if (i11 < i13) {
                    bArr[i11] = b11;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Value " + j11 + " is too large for " + i12 + " byte field.");
        }
    }

    public static int formatCheckSumOctalBytes(long j11, byte[] bArr, int i11, int i12) {
        int i13 = i12 - 2;
        formatUnsignedOctalString(j11, bArr, i11, i13);
        bArr[i13 + i11] = 0;
        bArr[i13 + 1 + i11] = 32;
        return i11 + i12;
    }

    private static void formatLongBinary(long j11, byte[] bArr, int i11, int i12, boolean z11) {
        int i13 = (i12 - 1) * 8;
        long j12 = 1 << i13;
        long abs = Math.abs(j11);
        if (abs < 0 || abs >= j12) {
            throw new IllegalArgumentException("Value " + j11 + " is too large for " + i12 + " byte field.");
        }
        if (z11) {
            abs = ((abs ^ (j12 - 1)) + 1) | (255 << i13);
        }
        for (int i14 = (i12 + i11) - 1; i14 >= i11; i14--) {
            bArr[i14] = (byte) ((int) abs);
            abs >>= 8;
        }
    }

    public static int formatLongOctalBytes(long j11, byte[] bArr, int i11, int i12) {
        int i13 = i12 - 1;
        formatUnsignedOctalString(j11, bArr, i11, i13);
        bArr[i13 + i11] = 32;
        return i11 + i12;
    }

    public static int formatLongOctalOrBinaryBytes(long j11, byte[] bArr, int i11, int i12) {
        long j12;
        boolean z11;
        int i13;
        if (i12 == 8) {
            j12 = TarConstants.MAXID;
        } else {
            j12 = TarConstants.MAXSIZE;
        }
        if (j11 < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && j11 <= j12) {
            return formatLongOctalBytes(j11, bArr, i11, i12);
        }
        if (i12 < 9) {
            formatLongBinary(j11, bArr, i11, i12, z11);
        } else {
            formatBigIntegerBinary(j11, bArr, i11, i12, z11);
        }
        if (z11) {
            i13 = 255;
        } else {
            i13 = 128;
        }
        bArr[i11] = (byte) i13;
        return i11 + i12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return formatNameBytes(r1, r2, r3, r4, FALLBACK_ENCODING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int formatNameBytes(java.lang.String r1, byte[] r2, int r3, int r4) {
        /*
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            int r1 = formatNameBytes(r1, r2, r3, r4, r0)     // Catch:{ IOException -> 0x0007 }
            return r1
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = FALLBACK_ENCODING     // Catch:{ IOException -> 0x000e }
            int r1 = formatNameBytes(r1, r2, r3, r4, r0)     // Catch:{ IOException -> 0x000e }
            return r1
        L_0x000e:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarUtils.formatNameBytes(java.lang.String, byte[], int, int):int");
    }

    public static int formatOctalBytes(long j11, byte[] bArr, int i11, int i12) {
        int i13 = i12 - 2;
        formatUnsignedOctalString(j11, bArr, i11, i13);
        bArr[i13 + i11] = 32;
        bArr[i13 + 1 + i11] = 0;
        return i11 + i12;
    }

    public static void formatUnsignedOctalString(long j11, byte[] bArr, int i11, int i12) {
        int i13;
        int i14 = i12 - 1;
        if (j11 == 0) {
            i13 = i14 - 1;
            bArr[i14 + i11] = TarConstants.LF_NORMAL;
        } else {
            long j12 = j11;
            while (i14 >= 0 && j12 != 0) {
                bArr[i11 + i14] = (byte) (((byte) ((int) (7 & j12))) + TarConstants.LF_NORMAL);
                j12 >>>= 3;
                i14--;
            }
            if (j12 == 0) {
                i13 = i14;
            } else {
                throw new IllegalArgumentException(j11 + "=" + Long.toOctalString(j11) + " will not fit in octal number buffer of length " + i12);
            }
        }
        while (i13 >= 0) {
            bArr[i11 + i13] = TarConstants.LF_NORMAL;
            i13--;
        }
    }

    private static long parseBinaryBigInteger(byte[] bArr, int i11, int i12, boolean z11) {
        int i13 = i12 - 1;
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, i11 + 1, bArr2, 0, i13);
        BigInteger bigInteger = new BigInteger(bArr2);
        if (z11) {
            bigInteger = bigInteger.add(BigInteger.valueOf(-1)).not();
        }
        if (bigInteger.bitLength() <= 63) {
            long longValue = bigInteger.longValue();
            if (z11) {
                return -longValue;
            }
            return longValue;
        }
        throw new IllegalArgumentException("At offset " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + " byte binary number exceeds maximum signed long value");
    }

    private static long parseBinaryLong(byte[] bArr, int i11, int i12, boolean z11) {
        if (i12 < 9) {
            long j11 = 0;
            for (int i13 = 1; i13 < i12; i13++) {
                j11 = (j11 << 8) + ((long) (bArr[i11 + i13] & 255));
            }
            if (z11) {
                j11 = (j11 - 1) ^ (((long) Math.pow(2.0d, ((double) (i12 - 1)) * 8.0d)) - 1);
            }
            if (z11) {
                return -j11;
            }
            return j11;
        }
        throw new IllegalArgumentException("At offset " + i11 + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + i12 + " byte binary number exceeds maximum signed long value");
    }

    public static boolean parseBoolean(byte[] bArr, int i11) {
        return bArr[i11] == 1;
    }

    public static List<TarArchiveStructSparse> parseFromPAX01SparseHeaders(String str) throws IOException {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(",");
        if (split.length % 2 != 1) {
            int i11 = 0;
            while (i11 < split.length) {
                try {
                    long parseLong = Long.parseLong(split[i11]);
                    if (parseLong >= 0) {
                        try {
                            long parseLong2 = Long.parseLong(split[i11 + 1]);
                            if (parseLong2 >= 0) {
                                arrayList.add(new TarArchiveStructSparse(parseLong, parseLong2));
                                i11 += 2;
                            } else {
                                throw new IOException("Corrupted TAR archive. Sparse struct numbytes contains negative value");
                            }
                        } catch (NumberFormatException unused) {
                            throw new IOException("Corrupted TAR archive. Sparse struct numbytes contains a non-numeric value");
                        }
                    } else {
                        throw new IOException("Corrupted TAR archive. Sparse struct offset contains negative value");
                    }
                } catch (NumberFormatException unused2) {
                    throw new IOException("Corrupted TAR archive. Sparse struct offset contains a non-numeric value");
                }
            }
            return Collections.unmodifiableList(arrayList);
        }
        throw new IOException("Corrupted TAR archive. Bad format in GNU.sparse.map PAX Header");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        return parseName(r1, r2, r3, FALLBACK_ENCODING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0014, code lost:
        throw new java.lang.RuntimeException(r1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String parseName(byte[] r1, int r2, int r3) {
        /*
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = DEFAULT_ENCODING     // Catch:{ IOException -> 0x0007 }
            java.lang.String r1 = parseName(r1, r2, r3, r0)     // Catch:{ IOException -> 0x0007 }
            return r1
        L_0x0007:
            org.apache.commons.compress.archivers.zip.ZipEncoding r0 = FALLBACK_ENCODING     // Catch:{ IOException -> 0x000e }
            java.lang.String r1 = parseName(r1, r2, r3, r0)     // Catch:{ IOException -> 0x000e }
            return r1
        L_0x000e:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarUtils.parseName(byte[], int, int):java.lang.String");
    }

    public static long parseOctal(byte[] bArr, int i11, int i12) {
        int i13 = i11 + i12;
        if (i12 >= 2) {
            long j11 = 0;
            if (bArr[i11] == 0) {
                return 0;
            }
            int i14 = i11;
            while (i14 < i13 && bArr[i14] == 32) {
                i14++;
            }
            byte b11 = bArr[i13 - 1];
            while (i14 < i13 && (b11 == 0 || b11 == 32)) {
                i13--;
                b11 = bArr[i13 - 1];
            }
            while (i14 < i13) {
                byte b12 = bArr[i14];
                if (b12 < 48 || b12 > 55) {
                    throw new IllegalArgumentException(exceptionMessage(bArr, i11, i12, i14, b12));
                }
                j11 = (j11 << 3) + ((long) (b12 - 48));
                i14++;
            }
            return j11;
        }
        throw new IllegalArgumentException("Length " + i12 + " must be at least 2");
    }

    public static long parseOctalOrBinary(byte[] bArr, int i11, int i12) {
        boolean z11;
        byte b11 = bArr[i11];
        if ((b11 & 128) == 0) {
            return parseOctal(bArr, i11, i12);
        }
        if (b11 == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i12 < 9) {
            return parseBinaryLong(bArr, i11, i12, z11);
        }
        return parseBinaryBigInteger(bArr, i11, i12, z11);
    }

    public static List<TarArchiveStructSparse> parsePAX01SparseHeaders(String str) {
        try {
            return parseFromPAX01SparseHeaders(str);
        } catch (IOException e11) {
            throw new RuntimeException(e11.getMessage(), e11);
        }
    }

    public static List<TarArchiveStructSparse> parsePAX1XSparseHeaders(InputStream inputStream, int i11) throws IOException {
        ArrayList arrayList = new ArrayList();
        long[] readLineOfNumberForPax1X = readLineOfNumberForPax1X(inputStream);
        long j11 = readLineOfNumberForPax1X[0];
        if (j11 >= 0) {
            long j12 = readLineOfNumberForPax1X[1] + 0;
            while (true) {
                long j13 = j11 - 1;
                if (j11 > 0) {
                    long[] readLineOfNumberForPax1X2 = readLineOfNumberForPax1X(inputStream);
                    long j14 = readLineOfNumberForPax1X2[0];
                    if (j14 >= 0) {
                        long j15 = j12 + readLineOfNumberForPax1X2[1];
                        long[] readLineOfNumberForPax1X3 = readLineOfNumberForPax1X(inputStream);
                        long j16 = readLineOfNumberForPax1X3[0];
                        if (j16 >= 0) {
                            j12 = j15 + readLineOfNumberForPax1X3[1];
                            arrayList.add(new TarArchiveStructSparse(j14, j16));
                            j11 = j13;
                        } else {
                            throw new IOException("Corrupted TAR archive. Sparse header block numbytes contains negative value");
                        }
                    } else {
                        throw new IOException("Corrupted TAR archive. Sparse header block offset contains negative value");
                    }
                } else {
                    long j17 = (long) i11;
                    IOUtils.skip(inputStream, j17 - (j12 % j17));
                    return arrayList;
                }
            }
        } else {
            throw new IOException("Corrupted TAR archive. Negative value in sparse headers block");
        }
    }

    @Deprecated
    public static Map<String, String> parsePaxHeaders(InputStream inputStream, List<TarArchiveStructSparse> list, Map<String, String> map) throws IOException {
        return parsePaxHeaders(inputStream, list, map, -1);
    }

    public static TarArchiveStructSparse parseSparse(byte[] bArr, int i11) {
        return new TarArchiveStructSparse(parseOctalOrBinary(bArr, i11, 12), parseOctalOrBinary(bArr, i11 + 12, 12));
    }

    private static long[] readLineOfNumberForPax1X(InputStream inputStream) throws IOException {
        long j11 = 0;
        long j12 = 0;
        while (true) {
            int read = inputStream.read();
            if (read != 10) {
                j11++;
                if (read == -1) {
                    throw new IOException("Unexpected EOF when reading parse information of 1.X PAX format");
                } else if (read >= 48 && read <= 57) {
                    j12 = (j12 * 10) + ((long) (read - 48));
                }
            } else {
                return new long[]{j12, j11 + 1};
            }
        }
        throw new IOException("Corrupted TAR archive. Non-numeric value in sparse headers block");
    }

    public static List<TarArchiveStructSparse> readSparseStructs(byte[] bArr, int i11, int i12) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        while (i13 < i12) {
            try {
                TarArchiveStructSparse parseSparse = parseSparse(bArr, (i13 * 24) + i11);
                if (parseSparse.getOffset() < 0) {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative offset");
                } else if (parseSparse.getNumbytes() >= 0) {
                    arrayList.add(parseSparse);
                    i13++;
                } else {
                    throw new IOException("Corrupted TAR archive, sparse entry with negative numbytes");
                }
            } catch (IllegalArgumentException e11) {
                throw new IOException("Corrupted TAR archive, sparse entry is invalid", e11);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static boolean verifyCheckSum(byte[] bArr) {
        long parseOctal = parseOctal(bArr, 148, 8);
        long j11 = 0;
        long j12 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            byte b11 = bArr[i11];
            if (148 <= i11 && i11 < 156) {
                b11 = 32;
            }
            j11 += (long) (b11 & 255);
            j12 += (long) b11;
        }
        if (parseOctal == j11 || parseOctal == j12) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015b, code lost:
        r2 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> parsePaxHeaders(java.io.InputStream r16, java.util.List<org.apache.commons.compress.archivers.tar.TarArchiveStructSparse> r17, java.util.Map<java.lang.String, java.lang.String> r18, long r19) throws java.io.IOException {
        /*
            r0 = r17
            java.util.HashMap r1 = new java.util.HashMap
            r2 = r18
            r1.<init>(r2)
            r3 = 0
            r4 = r3
            r5 = 0
        L_0x000c:
            r6 = r3
            r7 = r6
        L_0x000e:
            int r8 = r16.read()
            r9 = -1
            r10 = 0
            if (r8 == r9) goto L_0x0159
            r12 = 1
            int r6 = r6 + r12
            int r4 = r4 + 1
            r13 = 10
            if (r8 != r13) goto L_0x0024
            r2 = r9
            r9 = r16
            goto L_0x015c
        L_0x0024:
            r14 = 32
            if (r8 != r14) goto L_0x013f
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream
            r8.<init>()
        L_0x002d:
            int r14 = r16.read()
            if (r14 == r9) goto L_0x013b
            int r6 = r6 + r12
            int r4 = r4 + 1
            if (r4 < 0) goto L_0x013b
            int r15 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r15 < 0) goto L_0x0043
            long r9 = (long) r4
            int r9 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r9 < 0) goto L_0x0043
            goto L_0x013b
        L_0x0043:
            r9 = 61
            if (r14 != r9) goto L_0x012f
            java.lang.String r9 = "UTF-8"
            java.lang.String r8 = r8.toString(r9)
            int r7 = r7 - r6
            if (r7 > r12) goto L_0x0055
            r1.remove(r8)
            goto L_0x013b
        L_0x0055:
            if (r15 < 0) goto L_0x007c
            long r9 = (long) r7
            long r11 = (long) r4
            long r11 = r19 - r11
            int r6 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x0060
            goto L_0x007c
        L_0x0060:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Paxheader value size "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " exceeds size of header record"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x007c:
            r9 = r16
            byte[] r6 = org.apache.commons.compress.utils.IOUtils.readRange((java.io.InputStream) r9, (int) r7)
            int r10 = r6.length
            if (r10 != r7) goto L_0x0110
            int r4 = r4 + r7
            int r7 = r7 + -1
            byte r10 = r6[r7]
            if (r10 != r13) goto L_0x0108
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r11 = java.nio.charset.StandardCharsets.UTF_8
            r10.<init>(r6, r3, r7, r11)
            r1.put(r8, r10)
            java.lang.String r6 = "GNU.sparse.offset"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x00ce
            if (r5 == 0) goto L_0x00af
            org.apache.commons.compress.archivers.tar.TarArchiveStructSparse r6 = new org.apache.commons.compress.archivers.tar.TarArchiveStructSparse
            long r11 = r5.longValue()
            r2 = 0
            r6.<init>(r11, r2)
            r0.add(r6)
            goto L_0x00b1
        L_0x00af:
            r2 = 0
        L_0x00b1:
            java.lang.Long r5 = java.lang.Long.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00c6 }
            long r6 = r5.longValue()
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 < 0) goto L_0x00be
            goto L_0x00ce
        L_0x00be:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.GNU.sparse.offset contains negative value"
            r0.<init>(r1)
            throw r0
        L_0x00c6:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.GNU.sparse.offset contains a non-numeric value"
            r0.<init>(r1)
            throw r0
        L_0x00ce:
            java.lang.String r2 = "GNU.sparse.numbytes"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x013d
            if (r5 == 0) goto L_0x0100
            long r2 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x00f8 }
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x00f0
            org.apache.commons.compress.archivers.tar.TarArchiveStructSparse r6 = new org.apache.commons.compress.archivers.tar.TarArchiveStructSparse
            long r7 = r5.longValue()
            r6.<init>(r7, r2)
            r0.add(r6)
            r5 = 0
            goto L_0x013d
        L_0x00f0:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.GNU.sparse.numbytes contains negative value"
            r0.<init>(r1)
            throw r0
        L_0x00f8:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.GNU.sparse.numbytes contains a non-numeric value."
            r0.<init>(r1)
            throw r0
        L_0x0100:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.GNU.sparse.offset is expected before GNU.sparse.numbytes shows up."
            r0.<init>(r1)
            throw r0
        L_0x0108:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader.Value should end with a newline"
            r0.<init>(r1)
            throw r0
        L_0x0110:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read Paxheader. Expected "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = " bytes, read "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x012f:
            r9 = r16
            byte r2 = (byte) r14
            r8.write(r2)
            r3 = 0
            r9 = -1
            r10 = 0
            goto L_0x002d
        L_0x013b:
            r9 = r16
        L_0x013d:
            r8 = r14
            goto L_0x015b
        L_0x013f:
            r9 = r16
            r2 = 48
            if (r8 < r2) goto L_0x0151
            r2 = 57
            if (r8 > r2) goto L_0x0151
            int r7 = r7 * 10
            int r8 = r8 + -48
            int r7 = r7 + r8
            r3 = 0
            goto L_0x000e
        L_0x0151:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to read Paxheader. Encountered a non-number while reading length"
            r0.<init>(r1)
            throw r0
        L_0x0159:
            r9 = r16
        L_0x015b:
            r2 = -1
        L_0x015c:
            if (r8 != r2) goto L_0x016f
            if (r5 == 0) goto L_0x016e
            org.apache.commons.compress.archivers.tar.TarArchiveStructSparse r2 = new org.apache.commons.compress.archivers.tar.TarArchiveStructSparse
            long r3 = r5.longValue()
            r5 = 0
            r2.<init>(r3, r5)
            r0.add(r2)
        L_0x016e:
            return r1
        L_0x016f:
            r3 = 0
            goto L_0x000c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.tar.TarUtils.parsePaxHeaders(java.io.InputStream, java.util.List, java.util.Map, long):java.util.Map");
    }

    public static int formatNameBytes(String str, byte[] bArr, int i11, int i12, ZipEncoding zipEncoding) throws IOException {
        int length = str.length();
        ByteBuffer encode = zipEncoding.encode(str);
        while (encode.limit() > i12 && length > 0) {
            length--;
            encode = zipEncoding.encode(str.substring(0, length));
        }
        int limit = encode.limit() - encode.position();
        System.arraycopy(encode.array(), encode.arrayOffset(), bArr, i11, limit);
        while (limit < i12) {
            bArr[i11 + limit] = 0;
            limit++;
        }
        return i11 + i12;
    }

    public static String parseName(byte[] bArr, int i11, int i12, ZipEncoding zipEncoding) throws IOException {
        int i13 = i11;
        int i14 = 0;
        while (i14 < i12 && bArr[i13] != 0) {
            i14++;
            i13++;
        }
        if (i14 <= 0) {
            return "";
        }
        byte[] bArr2 = new byte[i14];
        System.arraycopy(bArr, i11, bArr2, 0, i14);
        return zipEncoding.decode(bArr2);
    }
}
