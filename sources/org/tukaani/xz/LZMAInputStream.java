package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

public class LZMAInputStream extends InputStream {
    public static final int DICT_SIZE_MAX = 2147483632;
    private ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;

    /* renamed from: in  reason: collision with root package name */
    private InputStream f63409in;

    /* renamed from: lz  reason: collision with root package name */
    private LZDecoder f63410lz;
    private LZMADecoder lzma;

    /* renamed from: rc  reason: collision with root package name */
    private RangeDecoderFromStream f63411rc;
    private boolean relaxedEndCondition;
    private long remainingSize;
    private final byte[] tempBuf;

    public LZMAInputStream(InputStream inputStream) throws IOException {
        this(inputStream, -1);
    }

    public LZMAInputStream(InputStream inputStream, int i11) throws IOException {
        this(inputStream, i11, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, int i11, ArrayCache arrayCache2) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte readByte = dataInputStream.readByte();
        int i12 = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            i12 |= dataInputStream.readUnsignedByte() << (i13 * 8);
        }
        long j11 = 0;
        for (int i14 = 0; i14 < 8; i14++) {
            j11 |= ((long) dataInputStream.readUnsignedByte()) << (i14 * 8);
        }
        int memoryUsage = getMemoryUsage(i12, readByte);
        if (i11 == -1 || memoryUsage <= i11) {
            initialize(inputStream, j11, readByte, i12, (byte[]) null, arrayCache2);
            return;
        }
        throw new MemoryLimitException(memoryUsage, i11);
    }

    public LZMAInputStream(InputStream inputStream, long j11, byte b11, int i11) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j11, b11, i11, (byte[]) null, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j11, byte b11, int i11, byte[] bArr) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j11, b11, i11, bArr, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j11, byte b11, int i11, byte[] bArr, ArrayCache arrayCache2) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j11, b11, i11, bArr, arrayCache2);
    }

    public LZMAInputStream(InputStream inputStream, long j11, int i11, int i12, int i13, int i14, byte[] bArr) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j11, i11, i12, i13, i14, bArr, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j11, int i11, int i12, int i13, int i14, byte[] bArr, ArrayCache arrayCache2) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j11, i11, i12, i13, i14, bArr, arrayCache2);
    }

    public LZMAInputStream(InputStream inputStream, ArrayCache arrayCache2) throws IOException {
        this(inputStream, -1, arrayCache2);
    }

    private static int getDictSize(int i11) {
        if (i11 < 0 || i11 > 2147483632) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (i11 < 4096) {
            i11 = 4096;
        }
        return (i11 + 15) & -16;
    }

    public static int getMemoryUsage(int i11, byte b11) throws UnsupportedOptionsException, CorruptedInputException {
        if (i11 < 0 || i11 > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        byte b12 = b11 & 255;
        if (b12 <= 224) {
            int i12 = b12 % 45;
            int i13 = i12 / 9;
            return getMemoryUsage(i11, i12 - (i13 * 9), i13);
        }
        throw new CorruptedInputException("Invalid LZMA properties byte");
    }

    public static int getMemoryUsage(int i11, int i12, int i13) {
        if (i12 >= 0 && i12 <= 8 && i13 >= 0 && i13 <= 4) {
            return (getDictSize(i11) / 1024) + 10 + ((1536 << (i12 + i13)) / 1024);
        }
        throw new IllegalArgumentException("Invalid lc or lp");
    }

    private void initialize(InputStream inputStream, long j11, byte b11, int i11, byte[] bArr, ArrayCache arrayCache2) throws IOException {
        int i12 = i11;
        if (j11 >= -1) {
            byte b12 = b11 & 255;
            if (b12 <= 224) {
                int i13 = b12 / 45;
                int i14 = b12 - ((i13 * 9) * 5);
                int i15 = i14 / 9;
                int i16 = i14 - (i15 * 9);
                if (i12 < 0 || i12 > 2147483632) {
                    throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
                }
                initialize(inputStream, j11, i16, i15, i13, i11, bArr, arrayCache2);
                return;
            }
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        throw new UnsupportedOptionsException("Uncompressed size is too big");
    }

    private void initialize(InputStream inputStream, long j11, int i11, int i12, int i13, int i14, byte[] bArr, ArrayCache arrayCache2) throws IOException {
        InputStream inputStream2 = inputStream;
        long j12 = j11;
        int i15 = i11;
        int i16 = i12;
        int i17 = i13;
        ArrayCache arrayCache3 = arrayCache2;
        if (j12 < -1 || i15 < 0 || i15 > 8 || i16 < 0 || i16 > 4 || i17 < 0 || i17 > 4) {
            throw new IllegalArgumentException();
        }
        this.f63409in = inputStream2;
        this.arrayCache = arrayCache3;
        int dictSize = getDictSize(i14);
        if (j12 >= 0 && ((long) dictSize) > j12) {
            dictSize = getDictSize((int) j12);
        }
        this.f63410lz = new LZDecoder(getDictSize(dictSize), bArr, arrayCache3);
        RangeDecoderFromStream rangeDecoderFromStream = new RangeDecoderFromStream(inputStream);
        this.f63411rc = rangeDecoderFromStream;
        this.lzma = new LZMADecoder(this.f63410lz, rangeDecoderFromStream, i11, i12, i13);
        this.remainingSize = j12;
    }

    private void putArraysToCache() {
        LZDecoder lZDecoder = this.f63410lz;
        if (lZDecoder != null) {
            lZDecoder.putArraysToCache(this.arrayCache);
            this.f63410lz = null;
        }
    }

    public void close() throws IOException {
        if (this.f63409in != null) {
            putArraysToCache();
            try {
                this.f63409in.close();
            } finally {
                this.f63409in = null;
            }
        }
    }

    public void enableRelaxedEndCondition() {
        this.relaxedEndCondition = true;
    }

    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read(byte[] r12, int r13, int r14) throws java.io.IOException {
        /*
            r11 = this;
            if (r13 < 0) goto L_0x00a1
            if (r14 < 0) goto L_0x00a1
            int r0 = r13 + r14
            if (r0 < 0) goto L_0x00a1
            int r1 = r12.length
            if (r0 > r1) goto L_0x00a1
            r0 = 0
            if (r14 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.InputStream r1 = r11.f63409in
            if (r1 == 0) goto L_0x0099
            java.io.IOException r1 = r11.exception
            if (r1 != 0) goto L_0x0098
            boolean r1 = r11.endReached
            r2 = -1
            if (r1 == 0) goto L_0x001d
            return r2
        L_0x001d:
            if (r14 <= 0) goto L_0x0097
            long r3 = r11.remainingSize     // Catch:{ IOException -> 0x0093 }
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x002e
            long r7 = (long) r14     // Catch:{ IOException -> 0x0093 }
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x002e
            int r1 = (int) r3     // Catch:{ IOException -> 0x0093 }
            goto L_0x002f
        L_0x002e:
            r1 = r14
        L_0x002f:
            org.tukaani.xz.lz.LZDecoder r3 = r11.f63410lz     // Catch:{ IOException -> 0x0093 }
            r3.setLimit(r1)     // Catch:{ IOException -> 0x0093 }
            r1 = 1
            org.tukaani.xz.lzma.LZMADecoder r3 = r11.lzma     // Catch:{ CorruptedInputException -> 0x003b }
            r3.decode()     // Catch:{ CorruptedInputException -> 0x003b }
            goto L_0x0053
        L_0x003b:
            r3 = move-exception
            long r7 = r11.remainingSize     // Catch:{ IOException -> 0x0093 }
            r9 = -1
            int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r4 != 0) goto L_0x0092
            org.tukaani.xz.lzma.LZMADecoder r4 = r11.lzma     // Catch:{ IOException -> 0x0093 }
            boolean r4 = r4.endMarkerDetected()     // Catch:{ IOException -> 0x0093 }
            if (r4 == 0) goto L_0x0092
            r11.endReached = r1     // Catch:{ IOException -> 0x0093 }
            org.tukaani.xz.rangecoder.RangeDecoderFromStream r3 = r11.f63411rc     // Catch:{ IOException -> 0x0093 }
            r3.normalize()     // Catch:{ IOException -> 0x0093 }
        L_0x0053:
            org.tukaani.xz.lz.LZDecoder r3 = r11.f63410lz     // Catch:{ IOException -> 0x0093 }
            int r3 = r3.flush(r12, r13)     // Catch:{ IOException -> 0x0093 }
            int r13 = r13 + r3
            int r14 = r14 - r3
            int r0 = r0 + r3
            long r7 = r11.remainingSize     // Catch:{ IOException -> 0x0093 }
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x006c
            long r3 = (long) r3     // Catch:{ IOException -> 0x0093 }
            long r7 = r7 - r3
            r11.remainingSize = r7     // Catch:{ IOException -> 0x0093 }
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x006c
            r11.endReached = r1     // Catch:{ IOException -> 0x0093 }
        L_0x006c:
            boolean r1 = r11.endReached     // Catch:{ IOException -> 0x0093 }
            if (r1 == 0) goto L_0x001d
            org.tukaani.xz.lz.LZDecoder r12 = r11.f63410lz     // Catch:{ IOException -> 0x0093 }
            boolean r12 = r12.hasPending()     // Catch:{ IOException -> 0x0093 }
            if (r12 != 0) goto L_0x008c
            boolean r12 = r11.relaxedEndCondition     // Catch:{ IOException -> 0x0093 }
            if (r12 != 0) goto L_0x0084
            org.tukaani.xz.rangecoder.RangeDecoderFromStream r12 = r11.f63411rc     // Catch:{ IOException -> 0x0093 }
            boolean r12 = r12.isFinished()     // Catch:{ IOException -> 0x0093 }
            if (r12 == 0) goto L_0x008c
        L_0x0084:
            r11.putArraysToCache()     // Catch:{ IOException -> 0x0093 }
            if (r0 != 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r2 = r0
        L_0x008b:
            return r2
        L_0x008c:
            org.tukaani.xz.CorruptedInputException r12 = new org.tukaani.xz.CorruptedInputException     // Catch:{ IOException -> 0x0093 }
            r12.<init>()     // Catch:{ IOException -> 0x0093 }
            throw r12     // Catch:{ IOException -> 0x0093 }
        L_0x0092:
            throw r3     // Catch:{ IOException -> 0x0093 }
        L_0x0093:
            r12 = move-exception
            r11.exception = r12
            throw r12
        L_0x0097:
            return r0
        L_0x0098:
            throw r1
        L_0x0099:
            org.tukaani.xz.XZIOException r12 = new org.tukaani.xz.XZIOException
            java.lang.String r13 = "Stream closed"
            r12.<init>(r13)
            throw r12
        L_0x00a1:
            java.lang.IndexOutOfBoundsException r12 = new java.lang.IndexOutOfBoundsException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.LZMAInputStream.read(byte[], int, int):int");
    }
}
