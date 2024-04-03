package org.apache.commons.compress.compressors.deflate;

public class DeflateParameters {
    private int compressionLevel = -1;
    private boolean zlibHeader = true;

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i11) {
        if (i11 < -1 || i11 > 9) {
            throw new IllegalArgumentException("Invalid Deflate compression level: " + i11);
        }
        this.compressionLevel = i11;
    }

    public void setWithZlibHeader(boolean z11) {
        this.zlibHeader = z11;
    }

    public boolean withZlibHeader() {
        return this.zlibHeader;
    }
}
