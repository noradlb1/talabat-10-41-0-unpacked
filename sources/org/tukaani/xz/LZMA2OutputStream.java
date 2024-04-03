package org.tukaani.xz;

import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lzma.LZMAEncoder;
import org.tukaani.xz.rangecoder.RangeEncoderToBuffer;

class LZMA2OutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private final byte[] chunkHeader = new byte[6];
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = false;

    /* renamed from: lz  reason: collision with root package name */
    private LZEncoder f63407lz;
    private LZMAEncoder lzma;
    private FinishableOutputStream out;
    private int pendingSize = 0;
    private final int props;
    private boolean propsNeeded = true;

    /* renamed from: rc  reason: collision with root package name */
    private RangeEncoderToBuffer f63408rc;
    private boolean stateResetNeeded = true;
    private final byte[] tempBuf = new byte[1];

    public LZMA2OutputStream(FinishableOutputStream finishableOutputStream, LZMA2Options lZMA2Options, ArrayCache arrayCache2) {
        ArrayCache arrayCache3 = arrayCache2;
        finishableOutputStream.getClass();
        this.arrayCache = arrayCache3;
        this.out = finishableOutputStream;
        this.f63408rc = new RangeEncoderToBuffer(65536, arrayCache3);
        int dictSize = lZMA2Options.getDictSize();
        int i11 = dictSize;
        LZMAEncoder instance = LZMAEncoder.getInstance(this.f63408rc, lZMA2Options.getLc(), lZMA2Options.getLp(), lZMA2Options.getPb(), lZMA2Options.getMode(), i11, getExtraSizeBefore(dictSize), lZMA2Options.getNiceLen(), lZMA2Options.getMatchFinder(), lZMA2Options.getDepthLimit(), arrayCache2);
        this.lzma = instance;
        this.f63407lz = instance.getLZEncoder();
        byte[] presetDict = lZMA2Options.getPresetDict();
        if (presetDict != null && presetDict.length > 0) {
            this.f63407lz.setPresetDict(dictSize, presetDict);
            this.dictResetNeeded = false;
        }
        this.props = (((lZMA2Options.getPb() * 5) + lZMA2Options.getLp()) * 9) + lZMA2Options.getLc();
    }

    public static int a(LZMA2Options lZMA2Options) {
        int dictSize = lZMA2Options.getDictSize();
        return LZMAEncoder.getMemoryUsage(lZMA2Options.getMode(), dictSize, getExtraSizeBefore(dictSize), lZMA2Options.getMatchFinder()) + 70;
    }

    private static int getExtraSizeBefore(int i11) {
        if (65536 > i11) {
            return 65536 - i11;
        }
        return 0;
    }

    private void writeChunk() throws IOException {
        int finish = this.f63408rc.finish();
        int uncompressedSize = this.lzma.getUncompressedSize();
        if (finish + 2 < uncompressedSize) {
            writeLZMA(uncompressedSize, finish);
        } else {
            this.lzma.reset();
            uncompressedSize = this.lzma.getUncompressedSize();
            writeUncompressed(uncompressedSize);
        }
        this.pendingSize -= uncompressedSize;
        this.lzma.resetUncompressedSize();
        this.f63408rc.reset();
    }

    private void writeEndMarker() throws IOException {
        IOException iOException = this.exception;
        if (iOException == null) {
            this.f63407lz.setFinishing();
            while (this.pendingSize > 0) {
                try {
                    this.lzma.encodeForLZMA2();
                    writeChunk();
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            }
            this.out.write(0);
            this.finished = true;
            this.lzma.putArraysToCache(this.arrayCache);
            this.lzma = null;
            this.f63407lz = null;
            this.f63408rc.putArraysToCache(this.arrayCache);
            this.f63408rc = null;
            return;
        }
        throw iOException;
    }

    private void writeLZMA(int i11, int i12) throws IOException {
        boolean z11 = this.propsNeeded;
        int i13 = z11 ? this.dictResetNeeded ? 224 : 192 : this.stateResetNeeded ? Opcodes.IF_ICMPNE : 128;
        int i14 = i11 - 1;
        byte[] bArr = this.chunkHeader;
        bArr[0] = (byte) (i13 | (i14 >>> 16));
        bArr[1] = (byte) (i14 >>> 8);
        bArr[2] = (byte) i14;
        int i15 = i12 - 1;
        bArr[3] = (byte) (i15 >>> 8);
        bArr[4] = (byte) i15;
        if (z11) {
            bArr[5] = (byte) this.props;
            this.out.write(bArr, 0, 6);
        } else {
            this.out.write(bArr, 0, 5);
        }
        this.f63408rc.write(this.out);
        this.propsNeeded = false;
        this.stateResetNeeded = false;
        this.dictResetNeeded = false;
    }

    private void writeUncompressed(int i11) throws IOException {
        while (i11 > 0) {
            int min = Math.min(i11, 65536);
            byte[] bArr = this.chunkHeader;
            bArr[0] = (byte) (this.dictResetNeeded ? 1 : 2);
            int i12 = min - 1;
            bArr[1] = (byte) (i12 >>> 8);
            bArr[2] = (byte) i12;
            this.out.write(bArr, 0, 3);
            this.f63407lz.copyUncompressed(this.out, i11, min);
            i11 -= min;
            this.dictResetNeeded = false;
        }
        this.stateResetNeeded = true;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            org.tukaani.xz.FinishableOutputStream r0 = r2.out
            if (r0 == 0) goto L_0x001b
            boolean r0 = r2.finished
            if (r0 != 0) goto L_0x000b
            r2.writeEndMarker()     // Catch:{ IOException -> 0x000b }
        L_0x000b:
            org.tukaani.xz.FinishableOutputStream r0 = r2.out     // Catch:{ IOException -> 0x0011 }
            r0.close()     // Catch:{ IOException -> 0x0011 }
            goto L_0x0018
        L_0x0011:
            r0 = move-exception
            java.io.IOException r1 = r2.exception
            if (r1 != 0) goto L_0x0018
            r2.exception = r0
        L_0x0018:
            r0 = 0
            r2.out = r0
        L_0x001b:
            java.io.IOException r0 = r2.exception
            if (r0 != 0) goto L_0x0020
            return
        L_0x0020:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.LZMA2OutputStream.close():void");
    }

    public void finish() throws IOException {
        if (!this.finished) {
            writeEndMarker();
            try {
                this.out.finish();
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        }
    }

    public void flush() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            try {
                this.f63407lz.setFlushing();
                while (this.pendingSize > 0) {
                    this.lzma.encodeForLZMA2();
                    writeChunk();
                }
                this.out.flush();
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        } else {
            throw new XZIOException("Stream finished or closed");
        }
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
            while (i12 > 0) {
                try {
                    int fillWindow = this.f63407lz.fillWindow(bArr, i11, i12);
                    i11 += fillWindow;
                    i12 -= fillWindow;
                    this.pendingSize += fillWindow;
                    if (this.lzma.encodeForLZMA2()) {
                        writeChunk();
                    }
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            }
        } else {
            throw new XZIOException("Stream finished or closed");
        }
    }
}
