package com.apptimize;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import okio.Utf8;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.lang3.StringUtils;

public class ew {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f42355a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f42356b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 43, 47};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f42357c = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, Utf8.REPLACEMENT_BYTE, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, -9, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f42358d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 45, 95};

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f42359e = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -9, -9, -9, -9, Utf8.REPLACEMENT_BYTE, -9, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f42360f = {45, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, TarConstants.LF_GNUTYPE_LONGLINK, TarConstants.LF_GNUTYPE_LONGNAME, 77, 78, 79, 80, 81, 82, TarConstants.LF_GNUTYPE_SPARSE, 84, 85, 86, 87, TarConstants.LF_PAX_EXTENDED_HEADER_UC, 89, 90, 95, 97, 98, 99, 100, 101, 102, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, TarConstants.LF_PAX_EXTENDED_HEADER_LC, 121, 122};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f42361g = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_SYMLINK, TarConstants.LF_CHR, TarConstants.LF_BLK, TarConstants.LF_DIR, TarConstants.LF_FIFO, TarConstants.LF_CONTIG, 56, 57, 58, 59, 60, 61, 62, Utf8.REPLACEMENT_BYTE, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};

    private ew() {
    }

    private static byte[] b(int i11) {
        if ((i11 & 16) == 16) {
            return f42358d;
        }
        if ((i11 & 32) == 32) {
            return f42360f;
        }
        return f42356b;
    }

    /* access modifiers changed from: private */
    public static byte[] c(int i11) {
        if ((i11 & 16) == 16) {
            return f42359e;
        }
        if ((i11 & 32) == 32) {
            return f42361g;
        }
        return f42357c;
    }

    private static byte[] a(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        byte[] b11 = b(i14);
        int i15 = 0;
        int i16 = (i12 > 0 ? (bArr[i11] << Ascii.CAN) >>> 8 : 0) | (i12 > 1 ? (bArr[i11 + 1] << Ascii.CAN) >>> 16 : 0);
        if (i12 > 2) {
            i15 = (bArr[i11 + 2] << Ascii.CAN) >>> 24;
        }
        int i17 = i16 | i15;
        if (i12 == 1) {
            bArr2[i13] = b11[i17 >>> 18];
            bArr2[i13 + 1] = b11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = 61;
            bArr2[i13 + 3] = 61;
            return bArr2;
        } else if (i12 == 2) {
            bArr2[i13] = b11[i17 >>> 18];
            bArr2[i13 + 1] = b11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = b11[(i17 >>> 6) & 63];
            bArr2[i13 + 3] = 61;
            return bArr2;
        } else if (i12 != 3) {
            return bArr2;
        } else {
            bArr2[i13] = b11[i17 >>> 18];
            bArr2[i13 + 1] = b11[(i17 >>> 12) & 63];
            bArr2[i13 + 2] = b11[(i17 >>> 6) & 63];
            bArr2[i13 + 3] = b11[i17 & 63];
            return bArr2;
        }
    }

    /* access modifiers changed from: private */
    public static byte[] b(byte[] bArr, byte[] bArr2, int i11, int i12) {
        a(bArr2, 0, i11, bArr, 0, i12);
        return bArr;
    }

    public static byte[] c(byte[] bArr, int i11, int i12, int i13) throws IOException {
        int i14;
        if (bArr == null) {
            throw new NullPointerException("Cannot decode null source array.");
        } else if (i11 < 0 || (i14 = i11 + i12) > bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
        } else if (i12 == 0) {
            return new byte[0];
        } else {
            if (i12 >= 4) {
                byte[] c11 = c(i13);
                byte[] bArr2 = new byte[((i12 * 3) / 4)];
                byte[] bArr3 = new byte[4];
                int i15 = 0;
                int i16 = 0;
                while (i11 < i14) {
                    byte b11 = bArr[i11];
                    byte b12 = c11[b11 & 255];
                    if (b12 >= -5) {
                        if (b12 >= -1) {
                            int i17 = i15 + 1;
                            bArr3[i15] = b11;
                            if (i17 > 3) {
                                i16 += b(bArr3, 0, bArr2, i16, i13);
                                if (bArr[i11] == 61) {
                                    break;
                                }
                                i15 = 0;
                            } else {
                                i15 = i17;
                            }
                        }
                        i11++;
                    } else {
                        throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[]{Integer.valueOf(bArr[i11] & 255), Integer.valueOf(i11)}));
                    }
                }
                byte[] bArr4 = new byte[i16];
                System.arraycopy(bArr2, 0, bArr4, 0, i16);
                return bArr4;
            }
            throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + i12);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(17:8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:31|32|45|46|47|48|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0034 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x005b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x005e */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r18, int r19, int r20, int r21) throws java.io.IOException {
        /*
            r0 = r18
            r7 = r19
            r8 = r20
            if (r0 == 0) goto L_0x0120
            if (r7 < 0) goto L_0x0109
            if (r8 < 0) goto L_0x00f2
            int r1 = r7 + r8
            int r2 = r0.length
            r9 = 1
            if (r1 > r2) goto L_0x00ce
            r1 = r21 & 2
            if (r1 == 0) goto L_0x0062
            r1 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            r2.<init>()     // Catch:{ IOException -> 0x0051, all -> 0x004d }
            com.apptimize.ew$a r3 = new com.apptimize.ew$a     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            r4 = r21 | 1
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x0048, all -> 0x0045 }
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0042, all -> 0x0040 }
            r4.write(r0, r7, r8)     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ IOException -> 0x003e, all -> 0x003c }
            r4.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            r3.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            byte[] r0 = r2.toByteArray()
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0057
        L_0x003e:
            r0 = move-exception
            goto L_0x004b
        L_0x0040:
            r0 = move-exception
            goto L_0x0058
        L_0x0042:
            r0 = move-exception
            r4 = r1
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            r3 = r1
            goto L_0x0058
        L_0x0048:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x004b:
            r1 = r2
            goto L_0x0054
        L_0x004d:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            r3 = r1
            r4 = r3
        L_0x0054:
            throw r0     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r0 = move-exception
            r2 = r1
        L_0x0057:
            r1 = r4
        L_0x0058:
            r1.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            r3.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            r2.close()     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            throw r0
        L_0x0062:
            r1 = r21 & 8
            if (r1 == 0) goto L_0x0068
            r11 = r9
            goto L_0x0069
        L_0x0068:
            r11 = 0
        L_0x0069:
            int r1 = r8 / 3
            r12 = 4
            int r1 = r1 * r12
            int r2 = r8 % 3
            if (r2 <= 0) goto L_0x0073
            r2 = r12
            goto L_0x0074
        L_0x0073:
            r2 = 0
        L_0x0074:
            int r1 = r1 + r2
            if (r11 == 0) goto L_0x007a
            int r2 = r1 / 76
            int r1 = r1 + r2
        L_0x007a:
            r13 = r1
            byte[] r14 = new byte[r13]
            int r15 = r8 + -2
            r6 = 0
            r16 = 0
            r17 = 0
        L_0x0084:
            if (r6 >= r15) goto L_0x00ae
            int r2 = r6 + r7
            r3 = 3
            r1 = r18
            r4 = r14
            r5 = r16
            r10 = r6
            r6 = r21
            a(r1, r2, r3, r4, r5, r6)
            int r1 = r17 + 4
            if (r11 == 0) goto L_0x00a7
            r2 = 76
            if (r1 < r2) goto L_0x00a7
            int r1 = r16 + 4
            r2 = 10
            r14[r1] = r2
            int r16 = r16 + 1
            r17 = 0
            goto L_0x00a9
        L_0x00a7:
            r17 = r1
        L_0x00a9:
            int r6 = r10 + 3
            int r16 = r16 + 4
            goto L_0x0084
        L_0x00ae:
            r10 = r6
            if (r10 >= r8) goto L_0x00c1
            int r2 = r10 + r7
            int r3 = r8 - r10
            r1 = r18
            r4 = r14
            r5 = r16
            r6 = r21
            a(r1, r2, r3, r4, r5, r6)
            int r16 = r16 + 4
        L_0x00c1:
            r0 = r16
            int r13 = r13 - r9
            if (r0 > r13) goto L_0x00cd
            byte[] r1 = new byte[r0]
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r1, r2, r0)
            return r1
        L_0x00cd:
            return r14
        L_0x00ce:
            r2 = 0
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r3[r2] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r3[r9] = r2
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 2
            r3[r2] = r0
            java.lang.String r0 = "Cannot have offset of %d and length of %d with array of length %d"
            java.lang.String r0 = java.lang.String.format(r0, r3)
            r1.<init>(r0)
            throw r1
        L_0x00f2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have length offset: "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0109:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot have negative offset: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0120:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Cannot serialize a null array."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ew.b(byte[], int, int, int):byte[]");
    }

    public static class a extends FilterOutputStream {

        /* renamed from: a  reason: collision with root package name */
        private boolean f42362a;

        /* renamed from: b  reason: collision with root package name */
        private int f42363b;

        /* renamed from: c  reason: collision with root package name */
        private byte[] f42364c;

        /* renamed from: d  reason: collision with root package name */
        private int f42365d;

        /* renamed from: e  reason: collision with root package name */
        private int f42366e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f42367f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f42368g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f42369h;

        /* renamed from: i  reason: collision with root package name */
        private int f42370i;

        /* renamed from: j  reason: collision with root package name */
        private byte[] f42371j;

        public a(OutputStream outputStream, int i11) {
            super(outputStream);
            boolean z11;
            int i12;
            boolean z12 = true;
            if ((i11 & 8) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f42367f = z11;
            z12 = (i11 & 1) == 0 ? false : z12;
            this.f42362a = z12;
            if (z12) {
                i12 = 3;
            } else {
                i12 = 4;
            }
            this.f42365d = i12;
            this.f42364c = new byte[i12];
            this.f42363b = 0;
            this.f42366e = 0;
            this.f42369h = false;
            this.f42368g = new byte[4];
            this.f42370i = i11;
            this.f42371j = ew.c(i11);
        }

        public void a() throws IOException {
            int i11 = this.f42363b;
            if (i11 <= 0) {
                return;
            }
            if (this.f42362a) {
                this.out.write(ew.b(this.f42368g, this.f42364c, i11, this.f42370i));
                this.f42363b = 0;
                return;
            }
            throw new IOException("Base64 input not properly padded.");
        }

        public void close() throws IOException {
            a();
            super.close();
            this.f42364c = null;
            this.out = null;
        }

        public void write(int i11) throws IOException {
            if (this.f42369h) {
                this.out.write(i11);
            } else if (this.f42362a) {
                byte[] bArr = this.f42364c;
                int i12 = this.f42363b;
                int i13 = i12 + 1;
                this.f42363b = i13;
                bArr[i12] = (byte) i11;
                int i14 = this.f42365d;
                if (i13 >= i14) {
                    this.out.write(ew.b(this.f42368g, bArr, i14, this.f42370i));
                    int i15 = this.f42366e + 4;
                    this.f42366e = i15;
                    if (this.f42367f && i15 >= 76) {
                        this.out.write(10);
                        this.f42366e = 0;
                    }
                    this.f42363b = 0;
                }
            } else {
                byte b11 = this.f42371j[i11 & 127];
                if (b11 > -5) {
                    byte[] bArr2 = this.f42364c;
                    int i16 = this.f42363b;
                    int i17 = i16 + 1;
                    this.f42363b = i17;
                    bArr2[i16] = (byte) i11;
                    if (i17 >= this.f42365d) {
                        this.out.write(this.f42368g, 0, ew.b(bArr2, 0, this.f42368g, 0, this.f42370i));
                        this.f42363b = 0;
                    }
                } else if (b11 != -5) {
                    throw new IOException("Invalid character in Base64 data.");
                }
            }
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            if (this.f42369h) {
                this.out.write(bArr, i11, i12);
                return;
            }
            for (int i13 = 0; i13 < i12; i13++) {
                write(bArr[i11 + i13]);
            }
        }
    }

    public static String a(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length, 0);
        } catch (IOException e11) {
            if (f42355a) {
                str = null;
            } else {
                throw new AssertionError(e11.getMessage());
            }
        }
        if (f42355a || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static String a(byte[] bArr, int i11) throws IOException {
        return a(bArr, 0, bArr.length, i11) + StringUtils.LF;
    }

    public static String a(byte[] bArr, int i11, int i12, int i13) throws IOException {
        byte[] b11 = b(bArr, i11, i12, i13);
        try {
            return new String(b11, "US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new String(b11);
        }
    }

    public static byte[] a(String str) throws IOException {
        return a(str, 0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:16|17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:68))|27|28|29)|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|(5:17|18|19|20|(6:21|22|(3:23|24|(1:26)(1:68))|27|28|29))|30|31|32|33) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:55|56|57|58|59|60|61|62) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x005c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:58:0x008a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x008d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r5, int r6) throws java.io.IOException {
        /*
            if (r5 == 0) goto L_0x0092
            java.lang.String r0 = "US-ASCII"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x0009 }
            goto L_0x000d
        L_0x0009:
            byte[] r5 = r5.getBytes()
        L_0x000d:
            int r0 = r5.length
            r1 = 0
            byte[] r5 = c(r5, r1, r0, r6)
            r0 = 4
            r6 = r6 & r0
            r2 = 1
            if (r6 == 0) goto L_0x001a
            r6 = r2
            goto L_0x001b
        L_0x001a:
            r6 = r1
        L_0x001b:
            if (r5 == 0) goto L_0x0091
            int r3 = r5.length
            if (r3 < r0) goto L_0x0091
            if (r6 != 0) goto L_0x0091
            byte r6 = r5[r1]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r0 = r5[r2]
            int r0 = r0 << 8
            r2 = 65280(0xff00, float:9.1477E-41)
            r0 = r0 & r2
            r6 = r6 | r0
            r0 = 35615(0x8b1f, float:4.9907E-41)
            if (r0 != r6) goto L_0x0091
            r6 = 2048(0x800, float:2.87E-42)
            byte[] r6 = new byte[r6]
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            r2.<init>()     // Catch:{ IOException -> 0x0078, all -> 0x0074 }
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            r3.<init>(r5)     // Catch:{ IOException -> 0x006f, all -> 0x006a }
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0067, all -> 0x0064 }
        L_0x0048:
            int r0 = r4.read(r6)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            if (r0 < 0) goto L_0x0052
            r2.write(r6, r1, r0)     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            goto L_0x0048
        L_0x0052:
            byte[] r5 = r2.toByteArray()     // Catch:{ IOException -> 0x0062, all -> 0x0060 }
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            r4.close()     // Catch:{ Exception -> 0x005c }
        L_0x005c:
            r3.close()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0091
        L_0x0060:
            r5 = move-exception
            goto L_0x006d
        L_0x0062:
            r6 = move-exception
            goto L_0x0072
        L_0x0064:
            r5 = move-exception
            r4 = r0
            goto L_0x006d
        L_0x0067:
            r6 = move-exception
            r4 = r0
            goto L_0x0072
        L_0x006a:
            r5 = move-exception
            r3 = r0
            r4 = r3
        L_0x006d:
            r0 = r2
            goto L_0x0087
        L_0x006f:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x0072:
            r0 = r2
            goto L_0x007b
        L_0x0074:
            r5 = move-exception
            r3 = r0
            r4 = r3
            goto L_0x0087
        L_0x0078:
            r6 = move-exception
            r3 = r0
            r4 = r3
        L_0x007b:
            java.lang.String r1 = "Base64"
            java.lang.String r2 = "Unexpected io exception."
            com.apptimize.bo.h(r1, r2, r6)     // Catch:{ all -> 0x0086 }
            r0.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x0059
        L_0x0086:
            r5 = move-exception
        L_0x0087:
            r0.close()     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            r4.close()     // Catch:{ Exception -> 0x008d }
        L_0x008d:
            r3.close()     // Catch:{ Exception -> 0x0090 }
        L_0x0090:
            throw r5
        L_0x0091:
            return r5
        L_0x0092:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "Input string was null."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ew.a(java.lang.String, int):byte[]");
    }

    /* access modifiers changed from: private */
    public static int b(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        int i14;
        int i15;
        if (bArr == null) {
            throw new NullPointerException("Source array was null.");
        } else if (bArr2 == null) {
            throw new NullPointerException("Destination array was null.");
        } else if (i11 < 0 || (i14 = i11 + 3) >= bArr.length) {
            throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11)}));
        } else if (i12 < 0 || (i15 = i12 + 2) >= bArr2.length) {
            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(bArr2.length), Integer.valueOf(i12)}));
        } else {
            byte[] c11 = c(i13);
            byte b11 = bArr[i11 + 2];
            if (b11 == 61) {
                bArr2[i12] = (byte) ((((c11[bArr[i11 + 1]] & 255) << 12) | ((c11[bArr[i11]] & 255) << Ascii.DC2)) >>> 16);
                return 1;
            }
            byte b12 = bArr[i14];
            if (b12 == 61) {
                int i16 = ((c11[bArr[i11 + 1]] & 255) << 12) | ((c11[bArr[i11]] & 255) << Ascii.DC2) | ((c11[b11] & 255) << 6);
                bArr2[i12] = (byte) (i16 >>> 16);
                bArr2[i12 + 1] = (byte) (i16 >>> 8);
                return 2;
            }
            byte b13 = ((c11[bArr[i11 + 1]] & 255) << 12) | ((c11[bArr[i11]] & 255) << Ascii.DC2) | ((c11[b11] & 255) << 6) | (c11[b12] & 255);
            bArr2[i12] = (byte) (b13 >> Ascii.DLE);
            bArr2[i12 + 1] = (byte) (b13 >> 8);
            bArr2[i15] = (byte) b13;
            return 3;
        }
    }
}
