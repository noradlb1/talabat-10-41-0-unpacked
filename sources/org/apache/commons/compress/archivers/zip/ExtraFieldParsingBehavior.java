package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;

public interface ExtraFieldParsingBehavior extends UnparseableExtraFieldBehavior {
    ZipExtraField createExtraField(ZipShort zipShort) throws ZipException, InstantiationException, IllegalAccessException;

    ZipExtraField fill(ZipExtraField zipExtraField, byte[] bArr, int i11, int i12, boolean z11) throws ZipException;
}
