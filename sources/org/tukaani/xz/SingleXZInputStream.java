package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexHash;

public class SingleXZInputStream extends InputStream {
    private final ArrayCache arrayCache;
    private BlockInputStream blockDecoder;
    private final Check check;
    private boolean endReached;
    private IOException exception;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f63417in;
    private final IndexHash indexHash;
    private final int memoryLimit;
    private final StreamFlags streamHeaderFlags;
    private final byte[] tempBuf;
    private final boolean verifyCheck;

    public SingleXZInputStream(InputStream inputStream) throws IOException {
        this(inputStream, -1);
    }

    public SingleXZInputStream(InputStream inputStream, int i11) throws IOException {
        this(inputStream, i11, true);
    }

    public SingleXZInputStream(InputStream inputStream, int i11, ArrayCache arrayCache2) throws IOException {
        this(inputStream, i11, true, arrayCache2);
    }

    public SingleXZInputStream(InputStream inputStream, int i11, boolean z11) throws IOException {
        this(inputStream, i11, z11, ArrayCache.getDefaultCache());
    }

    public SingleXZInputStream(InputStream inputStream, int i11, boolean z11, ArrayCache arrayCache2) throws IOException {
        this(inputStream, i11, z11, readStreamHeader(inputStream), arrayCache2);
    }

    public SingleXZInputStream(InputStream inputStream, int i11, boolean z11, byte[] bArr, ArrayCache arrayCache2) throws IOException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache2;
        this.f63417in = inputStream;
        this.memoryLimit = i11;
        this.verifyCheck = z11;
        StreamFlags decodeStreamHeader = DecoderUtil.decodeStreamHeader(bArr);
        this.streamHeaderFlags = decodeStreamHeader;
        this.check = Check.getInstance(decodeStreamHeader.checkType);
    }

    public SingleXZInputStream(InputStream inputStream, ArrayCache arrayCache2) throws IOException {
        this(inputStream, -1, arrayCache2);
    }

    private static byte[] readStreamHeader(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        new DataInputStream(inputStream).readFully(bArr);
        return bArr;
    }

    private void validateStreamFooter() throws IOException {
        byte[] bArr = new byte[12];
        new DataInputStream(this.f63417in).readFully(bArr);
        StreamFlags decodeStreamFooter = DecoderUtil.decodeStreamFooter(bArr);
        if (!DecoderUtil.areStreamFlagsEqual(this.streamHeaderFlags, decodeStreamFooter) || this.indexHash.getIndexSize() != decodeStreamFooter.backwardSize) {
            throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
        }
    }

    public int available() throws IOException {
        if (this.f63417in != null) {
            IOException iOException = this.exception;
            if (iOException == null) {
                BlockInputStream blockInputStream = this.blockDecoder;
                if (blockInputStream == null) {
                    return 0;
                }
                return blockInputStream.available();
            }
            throw iOException;
        }
        throw new XZIOException("Stream closed");
    }

    public void close() throws IOException {
        close(true);
    }

    public void close(boolean z11) throws IOException {
        if (this.f63417in != null) {
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            if (z11) {
                try {
                    this.f63417in.close();
                } catch (Throwable th2) {
                    this.f63417in = null;
                    throw th2;
                }
            }
            this.f63417in = null;
        }
    }

    public String getCheckName() {
        return this.check.getName();
    }

    public int getCheckType() {
        return this.streamHeaderFlags.checkType;
    }

    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:22|23|24|25|(2:27|48)(1:49)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0045 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[Catch:{ IOException -> 0x0079 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[Catch:{ IOException -> 0x0079 }, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r18, int r19, int r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            if (r19 < 0) goto L_0x008a
            if (r20 < 0) goto L_0x008a
            int r2 = r19 + r20
            if (r2 < 0) goto L_0x008a
            int r3 = r0.length
            if (r2 > r3) goto L_0x008a
            r2 = 0
            if (r20 != 0) goto L_0x0013
            return r2
        L_0x0013:
            java.io.InputStream r3 = r1.f63417in
            if (r3 == 0) goto L_0x0082
            java.io.IOException r3 = r1.exception
            if (r3 != 0) goto L_0x0081
            boolean r3 = r1.endReached
            r4 = -1
            if (r3 == 0) goto L_0x0021
            return r4
        L_0x0021:
            r3 = r20
            r5 = r2
            r2 = r19
        L_0x0026:
            if (r3 <= 0) goto L_0x0080
            org.tukaani.xz.BlockInputStream r6 = r1.blockDecoder     // Catch:{ IOException -> 0x0079 }
            if (r6 != 0) goto L_0x0056
            org.tukaani.xz.BlockInputStream r6 = new org.tukaani.xz.BlockInputStream     // Catch:{ IndexIndicatorException -> 0x0045 }
            java.io.InputStream r8 = r1.f63417in     // Catch:{ IndexIndicatorException -> 0x0045 }
            org.tukaani.xz.check.Check r9 = r1.check     // Catch:{ IndexIndicatorException -> 0x0045 }
            boolean r10 = r1.verifyCheck     // Catch:{ IndexIndicatorException -> 0x0045 }
            int r11 = r1.memoryLimit     // Catch:{ IndexIndicatorException -> 0x0045 }
            r12 = -1
            r14 = -1
            org.tukaani.xz.ArrayCache r7 = r1.arrayCache     // Catch:{ IndexIndicatorException -> 0x0045 }
            r16 = r7
            r7 = r6
            r7.<init>(r8, r9, r10, r11, r12, r14, r16)     // Catch:{ IndexIndicatorException -> 0x0045 }
            r1.blockDecoder = r6     // Catch:{ IndexIndicatorException -> 0x0045 }
            goto L_0x0056
        L_0x0045:
            org.tukaani.xz.index.IndexHash r0 = r1.indexHash     // Catch:{ IOException -> 0x0079 }
            java.io.InputStream r2 = r1.f63417in     // Catch:{ IOException -> 0x0079 }
            r0.validate(r2)     // Catch:{ IOException -> 0x0079 }
            r17.validateStreamFooter()     // Catch:{ IOException -> 0x0079 }
            r0 = 1
            r1.endReached = r0     // Catch:{ IOException -> 0x0079 }
            if (r5 <= 0) goto L_0x0055
            r4 = r5
        L_0x0055:
            return r4
        L_0x0056:
            org.tukaani.xz.BlockInputStream r6 = r1.blockDecoder     // Catch:{ IOException -> 0x0079 }
            int r6 = r6.read(r0, r2, r3)     // Catch:{ IOException -> 0x0079 }
            if (r6 <= 0) goto L_0x0062
            int r5 = r5 + r6
            int r2 = r2 + r6
            int r3 = r3 - r6
            goto L_0x0026
        L_0x0062:
            if (r6 != r4) goto L_0x0026
            org.tukaani.xz.index.IndexHash r6 = r1.indexHash     // Catch:{ IOException -> 0x0079 }
            org.tukaani.xz.BlockInputStream r7 = r1.blockDecoder     // Catch:{ IOException -> 0x0079 }
            long r7 = r7.getUnpaddedSize()     // Catch:{ IOException -> 0x0079 }
            org.tukaani.xz.BlockInputStream r9 = r1.blockDecoder     // Catch:{ IOException -> 0x0079 }
            long r9 = r9.getUncompressedSize()     // Catch:{ IOException -> 0x0079 }
            r6.add(r7, r9)     // Catch:{ IOException -> 0x0079 }
            r6 = 0
            r1.blockDecoder = r6     // Catch:{ IOException -> 0x0079 }
            goto L_0x0026
        L_0x0079:
            r0 = move-exception
            r1.exception = r0
            if (r5 == 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            throw r0
        L_0x0080:
            return r5
        L_0x0081:
            throw r3
        L_0x0082:
            org.tukaani.xz.XZIOException r0 = new org.tukaani.xz.XZIOException
            java.lang.String r2 = "Stream closed"
            r0.<init>(r2)
            throw r0
        L_0x008a:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.SingleXZInputStream.read(byte[], int, int):int");
    }
}
