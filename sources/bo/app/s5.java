package bo.app;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class s5 implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    private final InputStream f39352b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Charset f39353c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f39354d;

    /* renamed from: e  reason: collision with root package name */
    private int f39355e;

    /* renamed from: f  reason: collision with root package name */
    private int f39356f;

    public class a extends ByteArrayOutputStream {
        public a(int i11) {
            super(i11);
        }

        public String toString() {
            int i11 = this.count;
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (this.buf[i12] == 13) {
                    i11 = i12;
                }
            }
            try {
                return new String(this.buf, 0, i11, s5.this.f39353c.name());
            } catch (UnsupportedEncodingException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    public s5(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public boolean b() {
        return this.f39356f == -1;
    }

    public String c() {
        int i11;
        byte[] bArr;
        int i12;
        synchronized (this.f39352b) {
            if (this.f39354d != null) {
                if (this.f39355e >= this.f39356f) {
                    a();
                }
                for (int i13 = this.f39355e; i13 != this.f39356f; i13++) {
                    byte[] bArr2 = this.f39354d;
                    if (bArr2[i13] == 10) {
                        int i14 = this.f39355e;
                        if (i13 != i14) {
                            i12 = i13 - 1;
                            if (bArr2[i12] == 13) {
                                String str = new String(bArr2, i14, i12 - i14, this.f39353c.name());
                                this.f39355e = i13 + 1;
                                return str;
                            }
                        }
                        i12 = i13;
                        String str2 = new String(bArr2, i14, i12 - i14, this.f39353c.name());
                        this.f39355e = i13 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f39356f - this.f39355e) + 80);
                loop1:
                while (true) {
                    byte[] bArr3 = this.f39354d;
                    int i15 = this.f39355e;
                    aVar.write(bArr3, i15, this.f39356f - i15);
                    this.f39356f = -1;
                    a();
                    i11 = this.f39355e;
                    while (true) {
                        if (i11 != this.f39356f) {
                            bArr = this.f39354d;
                            if (bArr[i11] == 10) {
                                break loop1;
                            }
                            i11++;
                        }
                    }
                }
                int i16 = this.f39355e;
                if (i11 != i16) {
                    aVar.write(bArr, i16, i11 - i16);
                }
                this.f39355e = i11 + 1;
                String byteArrayOutputStream = aVar.toString();
                return byteArrayOutputStream;
            }
            throw new IOException("LineReader is closed");
        }
    }

    public void close() {
        synchronized (this.f39352b) {
            if (this.f39354d != null) {
                this.f39354d = null;
                this.f39352b.close();
            }
        }
    }

    public s5(InputStream inputStream, int i11, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i11 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(v6.f39511a)) {
            this.f39352b = inputStream;
            this.f39353c = charset;
            this.f39354d = new byte[i11];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    private void a() {
        InputStream inputStream = this.f39352b;
        byte[] bArr = this.f39354d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f39355e = 0;
            this.f39356f = read;
            return;
        }
        throw new EOFException();
    }
}
