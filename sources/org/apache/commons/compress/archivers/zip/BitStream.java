package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.utils.BitInputStream;

class BitStream extends BitInputStream {
    public BitStream(InputStream inputStream) {
        super(inputStream, ByteOrder.LITTLE_ENDIAN);
    }

    public int a() throws IOException {
        return (int) readBits(1);
    }

    public long b(int i11) throws IOException {
        if (i11 >= 0 && i11 <= 8) {
            return readBits(i11);
        }
        throw new IOException("Trying to read " + i11 + " bits, at most 8 are allowed");
    }

    public int c() throws IOException {
        return (int) readBits(8);
    }
}
