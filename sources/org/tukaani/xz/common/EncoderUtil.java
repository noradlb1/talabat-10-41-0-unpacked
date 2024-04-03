package org.tukaani.xz.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.CRC32;

public class EncoderUtil extends Util {
    public static void encodeVLI(OutputStream outputStream, long j11) throws IOException {
        while (j11 >= 128) {
            outputStream.write((byte) ((int) (128 | j11)));
            j11 >>>= 7;
        }
        outputStream.write((byte) ((int) j11));
    }

    public static void writeCRC32(OutputStream outputStream, byte[] bArr) throws IOException {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        for (int i11 = 0; i11 < 4; i11++) {
            outputStream.write((byte) ((int) (value >>> (i11 * 8))));
        }
    }
}
