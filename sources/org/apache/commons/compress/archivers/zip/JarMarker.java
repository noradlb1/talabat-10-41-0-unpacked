package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

public final class JarMarker implements ZipExtraField {
    private static final JarMarker DEFAULT = new JarMarker();
    private static final ZipShort ID = new ZipShort(51966);
    private static final ZipShort NULL = new ZipShort(0);

    public static JarMarker getInstance() {
        return DEFAULT;
    }

    public byte[] getCentralDirectoryData() {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    public ZipShort getHeaderId() {
        return ID;
    }

    public byte[] getLocalFileDataData() {
        return ByteUtils.EMPTY_BYTE_ARRAY;
    }

    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i11, int i12) throws ZipException {
        parseFromLocalFileData(bArr, i11, i12);
    }

    public void parseFromLocalFileData(byte[] bArr, int i11, int i12) throws ZipException {
        if (i12 != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
