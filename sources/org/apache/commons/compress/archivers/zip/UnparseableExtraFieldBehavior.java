package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public interface UnparseableExtraFieldBehavior {
    ZipExtraField onUnparseableExtraField(byte[] bArr, int i11, int i12, boolean z11, int i13) throws ZipException;
}
