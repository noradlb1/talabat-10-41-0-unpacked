package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.delta.DeltaEncoder;

class DeltaOutputStream extends FinishableOutputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private final DeltaEncoder delta;
    private IOException exception = null;
    private final byte[] filterBuf = new byte[4096];
    private boolean finished = false;
    private FinishableOutputStream out;
    private final byte[] tempBuf = new byte[1];

    public DeltaOutputStream(FinishableOutputStream finishableOutputStream, DeltaOptions deltaOptions) {
        this.out = finishableOutputStream;
        this.delta = new DeltaEncoder(deltaOptions.getDistance());
    }

    public static int a() {
        return 5;
    }

    public void close() throws IOException {
        FinishableOutputStream finishableOutputStream = this.out;
        if (finishableOutputStream != null) {
            try {
                finishableOutputStream.close();
            } catch (IOException e11) {
                if (this.exception == null) {
                    this.exception = e11;
                }
            }
            this.out = null;
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            IOException iOException = this.exception;
            if (iOException == null) {
                try {
                    this.out.finish();
                    this.finished = true;
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
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        } else if (!this.finished) {
            try {
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
            while (i12 > 4096) {
                try {
                    this.delta.encode(bArr, i11, 4096, this.filterBuf);
                    this.out.write(this.filterBuf);
                    i11 += 4096;
                    i12 -= 4096;
                } catch (IOException e11) {
                    this.exception = e11;
                    throw e11;
                }
            }
            this.delta.encode(bArr, i11, i12, this.filterBuf);
            this.out.write(this.filterBuf, 0, i12);
        } else {
            throw new XZIOException("Stream finished");
        }
    }
}
