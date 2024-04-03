package org.tukaani.xz.common;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZFormatException;

public class DecoderUtil extends Util {
    public static boolean areStreamFlagsEqual(StreamFlags streamFlags, StreamFlags streamFlags2) {
        return streamFlags.checkType == streamFlags2.checkType;
    }

    private static StreamFlags decodeStreamFlags(byte[] bArr, int i11) throws UnsupportedOptionsException {
        if (bArr[i11] == 0) {
            int i12 = i11 + 1;
            if ((bArr[i12] & 255) < 16) {
                StreamFlags streamFlags = new StreamFlags();
                streamFlags.checkType = bArr[i12];
                return streamFlags;
            }
        }
        throw new UnsupportedOptionsException();
    }

    public static StreamFlags decodeStreamFooter(byte[] bArr) throws IOException {
        byte b11 = bArr[10];
        byte[] bArr2 = XZ.FOOTER_MAGIC;
        if (b11 != bArr2[0] || bArr[11] != bArr2[1]) {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        } else if (isCRC32Valid(bArr, 4, 6, 0)) {
            try {
                StreamFlags decodeStreamFlags = decodeStreamFlags(bArr, 8);
                decodeStreamFlags.backwardSize = 0;
                for (int i11 = 0; i11 < 4; i11++) {
                    decodeStreamFlags.backwardSize |= (long) ((bArr[i11 + 4] & 255) << (i11 * 8));
                }
                decodeStreamFlags.backwardSize = (decodeStreamFlags.backwardSize + 1) * 4;
                return decodeStreamFlags;
            } catch (UnsupportedOptionsException unused) {
                throw new UnsupportedOptionsException("Unsupported options in XZ Stream Footer");
            }
        } else {
            throw new CorruptedInputException("XZ Stream Footer is corrupt");
        }
    }

    public static StreamFlags decodeStreamHeader(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = XZ.HEADER_MAGIC;
            if (i11 < bArr2.length) {
                if (bArr[i11] == bArr2[i11]) {
                    i11++;
                } else {
                    throw new XZFormatException();
                }
            } else if (isCRC32Valid(bArr, bArr2.length, 2, bArr2.length + 2)) {
                try {
                    return decodeStreamFlags(bArr, bArr2.length);
                } catch (UnsupportedOptionsException unused) {
                    throw new UnsupportedOptionsException("Unsupported options in XZ Stream Header");
                }
            } else {
                throw new CorruptedInputException("XZ Stream Header is corrupt");
            }
        }
    }

    public static long decodeVLI(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            long j11 = (long) (read & 127);
            int i11 = 0;
            while ((read & 128) != 0) {
                i11++;
                if (i11 < 9) {
                    read = inputStream.read();
                    if (read == -1) {
                        throw new EOFException();
                    } else if (read != 0) {
                        j11 |= ((long) (read & 127)) << (i11 * 7);
                    } else {
                        throw new CorruptedInputException();
                    }
                } else {
                    throw new CorruptedInputException();
                }
            }
            return j11;
        }
        throw new EOFException();
    }

    public static boolean isCRC32Valid(byte[] bArr, int i11, int i12, int i13) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i11, i12);
        long value = crc32.getValue();
        for (int i14 = 0; i14 < 4; i14++) {
            if (((byte) ((int) (value >>> (i14 * 8)))) != bArr[i13 + i14]) {
                return false;
            }
        }
        return true;
    }
}
