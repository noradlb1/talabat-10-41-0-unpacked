package org.tukaani.xz;

class RawCoder {
    public static void a(FilterCoder[] filterCoderArr) throws UnsupportedOptionsException {
        int i11 = 0;
        while (i11 < filterCoderArr.length - 1) {
            if (filterCoderArr[i11].nonLastOK()) {
                i11++;
            } else {
                throw new UnsupportedOptionsException("Unsupported XZ filter chain");
            }
        }
        if (filterCoderArr[filterCoderArr.length - 1].lastOK()) {
            int i12 = 0;
            for (FilterCoder changesSize : filterCoderArr) {
                if (changesSize.changesSize()) {
                    i12++;
                }
            }
            if (i12 > 3) {
                throw new UnsupportedOptionsException("Unsupported XZ filter chain");
            }
            return;
        }
        throw new UnsupportedOptionsException("Unsupported XZ filter chain");
    }
}
