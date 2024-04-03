package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.simple.SimpleFilter;

class SimpleOutputStream extends FinishableOutputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[4096];
    private boolean finished = false;
    private FinishableOutputStream out;
    private int pos = 0;
    private final SimpleFilter simpleFilter;
    private final byte[] tempBuf = new byte[1];
    private int unfiltered = 0;

    public SimpleOutputStream(FinishableOutputStream finishableOutputStream, SimpleFilter simpleFilter2) {
        finishableOutputStream.getClass();
        this.out = finishableOutputStream;
        this.simpleFilter = simpleFilter2;
    }

    public static int a() {
        return 5;
    }

    private void writePending() throws IOException {
        IOException iOException = this.exception;
        if (iOException == null) {
            try {
                this.out.write(this.filterBuf, this.pos, this.unfiltered);
                this.finished = true;
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        } else {
            throw iOException;
        }
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
            r2.writePending()     // Catch:{ IOException -> 0x000b }
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
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.SimpleOutputStream.close():void");
    }

    public void finish() throws IOException {
        if (!this.finished) {
            writePending();
            try {
                this.out.finish();
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        }
    }

    public void flush() throws IOException {
        throw new UnsupportedOptionsException("Flushing is not supported");
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
                int min = Math.min(i12, 4096 - (this.pos + this.unfiltered));
                System.arraycopy(bArr, i11, this.filterBuf, this.pos + this.unfiltered, min);
                i11 += min;
                i12 -= min;
                int i14 = this.unfiltered + min;
                this.unfiltered = i14;
                int code = this.simpleFilter.code(this.filterBuf, this.pos, i14);
                this.unfiltered -= code;
                try {
                    this.out.write(this.filterBuf, this.pos, code);
                    int i15 = this.pos + code;
                    this.pos = i15;
                    int i16 = this.unfiltered;
                    if (i15 + i16 == 4096) {
                        byte[] bArr2 = this.filterBuf;
                        System.arraycopy(bArr2, i15, bArr2, 0, i16);
                        this.pos = 0;
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
