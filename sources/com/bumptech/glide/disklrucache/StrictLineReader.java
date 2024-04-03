package com.bumptech.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    /* access modifiers changed from: private */
    public final Charset charset;
    private int end;

    /* renamed from: in  reason: collision with root package name */
    private final InputStream f44180in;
    private int pos;

    public StrictLineReader(InputStream inputStream, Charset charset2) {
        this(inputStream, 8192, charset2);
    }

    private void fillBuf() throws IOException {
        InputStream inputStream = this.f44180in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.pos = 0;
            this.end = read;
            return;
        }
        throw new EOFException();
    }

    public void close() throws IOException {
        synchronized (this.f44180in) {
            if (this.buf != null) {
                this.buf = null;
                this.f44180in.close();
            }
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    public String readLine() throws IOException {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f44180in) {
            if (this.buf != null) {
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i13 = this.pos; i13 != this.end; i13++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i13] == 10) {
                        int i14 = this.pos;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.charset.name());
                                this.pos = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.charset.name());
                        this.pos = i13 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 r12 = new ByteArrayOutputStream((this.end - this.pos) + 80) {
                    public String toString() {
                        int i11 = this.count;
                        if (i11 > 0 && this.buf[i11 - 1] == 13) {
                            i11--;
                        }
                        try {
                            return new String(this.buf, 0, i11, StrictLineReader.this.charset.name());
                        } catch (UnsupportedEncodingException e11) {
                            throw new AssertionError(e11);
                        }
                    }
                };
                loop1:
                while (true) {
                    byte[] bArr3 = this.buf;
                    int i15 = this.pos;
                    r12.write(bArr3, i15, this.end - i15);
                    this.end = -1;
                    fillBuf();
                    i11 = this.pos;
                    while (true) {
                        if (i11 != this.end) {
                            bArr = this.buf;
                            if (bArr[i11] == 10) {
                                break loop1;
                            }
                            i11++;
                        }
                    }
                }
                int i16 = this.pos;
                if (i11 != i16) {
                    r12.write(bArr, i16, i11 - i16);
                }
                this.pos = i11 + 1;
                String byteArrayOutputStream = r12.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public StrictLineReader(InputStream inputStream, int i11, Charset charset2) {
        if (inputStream == null || charset2 == null) {
            throw null;
        } else if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset2.equals(Util.US_ASCII)) {
            this.f44180in = inputStream;
            this.charset = charset2;
            this.buf = new byte[i11];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
