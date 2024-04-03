package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.utils.ByteUtils;

abstract class CoderBase {
    private final Class<?>[] acceptableOptions;

    public CoderBase(Class<?>... clsArr) {
        this.acceptableOptions = clsArr;
    }

    public static int f(Object obj, int i11) {
        return obj instanceof Number ? ((Number) obj).intValue() : i11;
    }

    public boolean a(Object obj) {
        for (Class<?> isInstance : this.acceptableOptions) {
            if (isInstance.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException;

    public OutputStream c(OutputStream outputStream, Object obj) throws IOException {
        throw new UnsupportedOperationException("Method doesn't support writing");
    }

    public byte[] d(Object obj) throws IOException {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public Object e(Coder coder, InputStream inputStream) throws IOException {
        return null;
    }
}
