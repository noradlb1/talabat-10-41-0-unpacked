package org.apache.commons.compress.compressors.deflate64;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class Deflate64CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private long compressedBytesRead;
    private HuffmanDecoder decoder;
    private final byte[] oneByte;
    private InputStream originalStream;

    public Deflate64CompressorInputStream(InputStream inputStream) {
        this(new HuffmanDecoder(inputStream));
        this.originalStream = inputStream;
    }

    private void closeDecoder() {
        IOUtils.closeQuietly(this.decoder);
        this.decoder = null;
    }

    public int available() throws IOException {
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder != null) {
            return huffmanDecoder.available();
        }
        return 0;
    }

    public void close() throws IOException {
        try {
            closeDecoder();
            InputStream inputStream = this.originalStream;
            if (inputStream != null) {
                inputStream.close();
                this.originalStream = null;
            }
        } catch (Throwable th2) {
            if (this.originalStream != null) {
                this.originalStream.close();
                this.originalStream = null;
            }
            throw th2;
        }
    }

    public long getCompressedCount() {
        return this.compressedBytesRead;
    }

    public int read() throws IOException {
        int read;
        do {
            read = read(this.oneByte);
            if (read == -1) {
                return -1;
            }
        } while (read == 0);
        if (read == 1) {
            return this.oneByte[0] & 255;
        }
        throw new IllegalStateException("Invalid return value from read: " + read);
    }

    public Deflate64CompressorInputStream(HuffmanDecoder huffmanDecoder) {
        this.oneByte = new byte[1];
        this.decoder = huffmanDecoder;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 == 0) {
            return 0;
        }
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder == null) {
            return -1;
        }
        try {
            int decode = huffmanDecoder.decode(bArr, i11, i12);
            this.compressedBytesRead = this.decoder.i();
            count(decode);
            if (decode == -1) {
                closeDecoder();
            }
            return decode;
        } catch (RuntimeException e11) {
            throw new IOException("Invalid Deflate64 input", e11);
        }
    }
}
