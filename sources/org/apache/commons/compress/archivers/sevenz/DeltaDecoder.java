package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

class DeltaDecoder extends CoderBase {
    public DeltaDecoder() {
        super(Number.class);
    }

    private int getOptionsFromCoder(Coder coder) {
        byte[] bArr = coder.f27611d;
        if (bArr == null || bArr.length == 0) {
            return 1;
        }
        return (bArr[0] & 255) + 1;
    }

    public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
        return new DeltaOptions(getOptionsFromCoder(coder)).getInputStream(inputStream);
    }

    public OutputStream c(OutputStream outputStream, Object obj) throws IOException {
        try {
            return new DeltaOptions(CoderBase.f(obj, 1)).getOutputStream(new FinishableWrapperOutputStream(outputStream));
        } catch (UnsupportedOptionsException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    public byte[] d(Object obj) {
        return new byte[]{(byte) (CoderBase.f(obj, 1) - 1)};
    }

    public Object e(Coder coder, InputStream inputStream) {
        return Integer.valueOf(getOptionsFromCoder(coder));
    }
}
