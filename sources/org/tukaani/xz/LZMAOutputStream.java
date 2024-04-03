package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoderToStream;

public class LZMAOutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private long currentUncompressedSize;
    private IOException exception;
    private final long expectedUncompressedSize;
    private boolean finished;

    /* renamed from: lz  reason: collision with root package name */
    private LZEncoder f63412lz;
    private LZMAEncoder lzma;
    private OutputStream out;
    private final int props;

    /* renamed from: rc  reason: collision with root package name */
    private final RangeEncoderToStream f63413rc;
    private final byte[] tempBuf;
    private final boolean useEndMarker;

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, long j11) throws IOException {
        this(outputStream, lZMA2Options, j11, ArrayCache.getDefaultCache());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, long j11, ArrayCache arrayCache2) throws IOException {
        this(outputStream, lZMA2Options, true, j11 == -1, j11, arrayCache2);
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z11) throws IOException {
        this(outputStream, lZMA2Options, z11, ArrayCache.getDefaultCache());
    }

    public LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z11, ArrayCache arrayCache2) throws IOException {
        this(outputStream, lZMA2Options, false, z11, -1, arrayCache2);
    }

    private LZMAOutputStream(OutputStream outputStream, LZMA2Options lZMA2Options, boolean z11, boolean z12, long j11, ArrayCache arrayCache2) throws IOException {
        OutputStream outputStream2 = outputStream;
        long j12 = j11;
        this.currentUncompressedSize = 0;
        this.finished = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        outputStream.getClass();
        if (j12 >= -1) {
            this.useEndMarker = z12;
            this.expectedUncompressedSize = j12;
            ArrayCache arrayCache3 = arrayCache2;
            this.arrayCache = arrayCache3;
            this.out = outputStream2;
            RangeEncoderToStream rangeEncoderToStream = new RangeEncoderToStream(outputStream2);
            this.f63413rc = rangeEncoderToStream;
            int dictSize = lZMA2Options.getDictSize();
            int i11 = dictSize;
            LZMAEncoder instance = LZMAEncoder.getInstance(rangeEncoderToStream, lZMA2Options.getLc(), lZMA2Options.getLp(), lZMA2Options.getPb(), lZMA2Options.getMode(), dictSize, 0, lZMA2Options.getNiceLen(), lZMA2Options.getMatchFinder(), lZMA2Options.getDepthLimit(), arrayCache3);
            this.lzma = instance;
            this.f63412lz = instance.getLZEncoder();
            byte[] presetDict = lZMA2Options.getPresetDict();
            if (presetDict != null && presetDict.length > 0) {
                if (!z11) {
                    this.f63412lz.setPresetDict(i11, presetDict);
                } else {
                    throw new UnsupportedOptionsException("Preset dictionary cannot be used in .lzma files (try a raw LZMA stream instead)");
                }
            }
            int pb2 = (((lZMA2Options.getPb() * 5) + lZMA2Options.getLp()) * 9) + lZMA2Options.getLc();
            this.props = pb2;
            if (z11) {
                outputStream2.write(pb2);
                int i12 = i11;
                for (int i13 = 0; i13 < 4; i13++) {
                    outputStream2.write(i12 & 255);
                    i12 >>>= 8;
                }
                for (int i14 = 0; i14 < 8; i14++) {
                    outputStream2.write(((int) (j12 >>> (i14 * 8))) & 255);
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid expected input size (less than -1)");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0007 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            java.io.OutputStream r0 = r2.out
            if (r0 == 0) goto L_0x0017
            r2.finish()     // Catch:{ IOException -> 0x0007 }
        L_0x0007:
            java.io.OutputStream r0 = r2.out     // Catch:{ IOException -> 0x000d }
            r0.close()     // Catch:{ IOException -> 0x000d }
            goto L_0x0014
        L_0x000d:
            r0 = move-exception
            java.io.IOException r1 = r2.exception
            if (r1 != 0) goto L_0x0014
            r2.exception = r0
        L_0x0014:
            r0 = 0
            r2.out = r0
        L_0x0017:
            java.io.IOException r0 = r2.exception
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.LZMAOutputStream.close():void");
    }

    public void finish() throws IOException {
        if (!this.finished) {
            IOException iOException = this.exception;
            if (iOException == null) {
                try {
                    long j11 = this.expectedUncompressedSize;
                    if (j11 != -1) {
                        if (j11 != this.currentUncompressedSize) {
                            throw new XZIOException("Expected uncompressed size (" + this.expectedUncompressedSize + ") doesn't equal the number of bytes written to the stream (" + this.currentUncompressedSize + ")");
                        }
                    }
                    this.f63412lz.setFinishing();
                    this.lzma.encodeForLZMA1();
                    if (this.useEndMarker) {
                        this.lzma.encodeLZMA1EndMarker();
                    }
                    this.f63413rc.finish();
                    this.finished = true;
                    this.lzma.putArraysToCache(this.arrayCache);
                    this.lzma = null;
                    this.f63412lz = null;
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            } else {
                throw iOException;
            }
        }
    }

    public void flush() throws IOException {
        throw new XZIOException("LZMAOutputStream does not support flushing");
    }

    public int getProps() {
        return this.props;
    }

    public long getUncompressedSize() {
        return this.currentUncompressedSize;
    }

    public void write(int i11) throws IOException {
        byte[] bArr = this.tempBuf;
        bArr[0] = (byte) i11;
        write(bArr, 0, 1);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        if (i11 < 0 || i12 < 0 || (i13 = i11 + i12) < 0 || i13 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            long j11 = this.expectedUncompressedSize;
            if (j11 == -1 || j11 - this.currentUncompressedSize >= ((long) i12)) {
                this.currentUncompressedSize += (long) i12;
                while (i12 > 0) {
                    try {
                        int fillWindow = this.f63412lz.fillWindow(bArr, i11, i12);
                        i11 += fillWindow;
                        i12 -= fillWindow;
                        this.lzma.encodeForLZMA1();
                    } catch (IOException e11) {
                        this.exception = e11;
                        throw e11;
                    }
                }
                return;
            }
            throw new XZIOException("Expected uncompressed input size (" + this.expectedUncompressedSize + " bytes) was exceeded");
        } else {
            throw new XZIOException("Stream finished or closed");
        }
    }
}
