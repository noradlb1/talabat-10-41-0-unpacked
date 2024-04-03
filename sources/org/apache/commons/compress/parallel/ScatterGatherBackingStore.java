package org.apache.commons.compress.parallel;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public interface ScatterGatherBackingStore extends Closeable {
    void closeForWriting() throws IOException;

    InputStream getInputStream() throws IOException;

    void writeOut(byte[] bArr, int i11, int i12) throws IOException;
}
