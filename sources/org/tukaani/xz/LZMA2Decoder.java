package org.tukaani.xz;

import java.io.InputStream;

class LZMA2Decoder extends LZMA2Coder implements FilterDecoder {
    private int dictSize;

    public LZMA2Decoder(byte[] bArr) throws UnsupportedOptionsException {
        if (bArr.length == 1) {
            byte b11 = bArr[0];
            if ((b11 & 255) <= 37) {
                this.dictSize = ((b11 & 1) | 2) << ((b11 >>> 1) + 11);
                return;
            }
        }
        throw new UnsupportedOptionsException("Unsupported LZMA2 properties");
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        return new LZMA2InputStream(inputStream, this.dictSize, (byte[]) null, arrayCache);
    }

    public int getMemoryUsage() {
        return LZMA2InputStream.getMemoryUsage(this.dictSize);
    }
}
