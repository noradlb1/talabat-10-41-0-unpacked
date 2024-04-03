package org.tukaani.xz;

import java.io.IOException;
import java.io.OutputStream;

public class FinishableWrapperOutputStream extends FinishableOutputStream {

    /* renamed from: b  reason: collision with root package name */
    public OutputStream f63399b;

    public FinishableWrapperOutputStream(OutputStream outputStream) {
        this.f63399b = outputStream;
    }

    public void close() throws IOException {
        this.f63399b.close();
    }

    public void flush() throws IOException {
        this.f63399b.flush();
    }

    public void write(int i11) throws IOException {
        this.f63399b.write(i11);
    }

    public void write(byte[] bArr) throws IOException {
        this.f63399b.write(bArr);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.f63399b.write(bArr, i11, i12);
    }
}
