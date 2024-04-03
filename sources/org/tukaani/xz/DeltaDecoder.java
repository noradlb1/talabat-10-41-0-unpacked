package org.tukaani.xz;

import java.io.InputStream;

class DeltaDecoder extends DeltaCoder implements FilterDecoder {
    private final int distance;

    public DeltaDecoder(byte[] bArr) throws UnsupportedOptionsException {
        if (bArr.length == 1) {
            this.distance = (bArr[0] & 255) + 1;
            return;
        }
        throw new UnsupportedOptionsException("Unsupported Delta filter properties");
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new DeltaInputStream(inputStream, this.distance);
    }

    public int getMemoryUsage() {
        return 1;
    }
}
