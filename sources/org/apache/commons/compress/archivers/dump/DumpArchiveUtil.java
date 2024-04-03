package org.apache.commons.compress.archivers.dump;

import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ByteUtils;

class DumpArchiveUtil {
    private DumpArchiveUtil() {
    }

    public static String a(ZipEncoding zipEncoding, byte[] bArr, int i11, int i12) throws IOException {
        return zipEncoding.decode(Arrays.copyOfRange(bArr, i11, i12 + i11));
    }

    public static int calculateChecksum(byte[] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            i11 += convert32(bArr, i12 * 4);
        }
        return DumpArchiveConstants.CHECKSUM - (i11 - convert32(bArr, 28));
    }

    public static final int convert16(byte[] bArr, int i11) {
        return (int) ByteUtils.fromLittleEndian(bArr, i11, 2);
    }

    public static final int convert32(byte[] bArr, int i11) {
        return (int) ByteUtils.fromLittleEndian(bArr, i11, 4);
    }

    public static final long convert64(byte[] bArr, int i11) {
        return ByteUtils.fromLittleEndian(bArr, i11, 8);
    }

    public static final int getIno(byte[] bArr) {
        return convert32(bArr, 20);
    }

    public static final boolean verify(byte[] bArr) {
        if (convert32(bArr, 24) == 60012 && convert32(bArr, 28) == calculateChecksum(bArr)) {
            return true;
        }
        return false;
    }
}
