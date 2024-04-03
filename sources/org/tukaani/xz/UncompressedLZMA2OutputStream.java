package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;

class UncompressedLZMA2OutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private boolean dictResetNeeded = true;
    private IOException exception = null;
    private boolean finished = false;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private final byte[] tempBuf = new byte[1];
    private final byte[] uncompBuf;
    private int uncompPos = 0;

    public UncompressedLZMA2OutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache2) {
        finishableOutputStream.getClass();
        this.out = finishableOutputStream;
        this.outData = new DataOutputStream(finishableOutputStream);
        this.arrayCache = arrayCache2;
        this.uncompBuf = arrayCache2.getByteArray(65536, false);
    }

    public static int a() {
        return 70;
    }

    private void writeChunk() throws IOException {
        this.outData.writeByte(this.dictResetNeeded ? 1 : 2);
        this.outData.writeShort(this.uncompPos - 1);
        this.outData.write(this.uncompBuf, 0, this.uncompPos);
        this.uncompPos = 0;
        this.dictResetNeeded = false;
    }

    private void writeEndMarker() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            try {
                if (this.uncompPos > 0) {
                    writeChunk();
                }
                this.out.write(0);
                this.finished = true;
                this.arrayCache.putArray(this.uncompBuf);
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        } else {
            throw new XZIOException("Stream finished or closed");
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
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.UncompressedLZMA2OutputStream.close():void");
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
                if (this.uncompPos > 0) {
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
                    int min = Math.min(65536 - this.uncompPos, i12);
                    System.arraycopy(bArr, i11, this.uncompBuf, this.uncompPos, min);
                    i12 -= min;
                    int i14 = this.uncompPos + min;
                    this.uncompPos = i14;
                    if (i14 == 65536) {
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
