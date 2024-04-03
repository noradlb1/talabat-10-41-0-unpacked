package org.apache.commons.compress.utils;

import java.io.InputStream;
import java.util.zip.CRC32;

public class CRC32VerifyingInputStream extends ChecksumVerifyingInputStream {
    public CRC32VerifyingInputStream(InputStream inputStream, long j11, int i11) {
        this(inputStream, j11, ((long) i11) & 4294967295L);
    }

    public CRC32VerifyingInputStream(InputStream inputStream, long j11, long j12) {
        super(new CRC32(), inputStream, j11, j12);
    }
}
