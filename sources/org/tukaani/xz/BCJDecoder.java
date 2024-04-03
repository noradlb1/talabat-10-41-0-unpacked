package org.tukaani.xz;

import java.io.InputStream;
import org.tukaani.xz.simple.ARM;
import org.tukaani.xz.simple.ARMThumb;
import org.tukaani.xz.simple.IA64;
import org.tukaani.xz.simple.PowerPC;
import org.tukaani.xz.simple.SPARC;
import org.tukaani.xz.simple.X86;

class BCJDecoder extends BCJCoder implements FilterDecoder {
    private final long filterID;
    private final int startOffset;

    public BCJDecoder(long j11, byte[] bArr) throws UnsupportedOptionsException {
        this.filterID = j11;
        if (bArr.length == 0) {
            this.startOffset = 0;
        } else if (bArr.length == 4) {
            int i11 = 0;
            for (int i12 = 0; i12 < 4; i12++) {
                i11 |= (bArr[i12] & 255) << (i12 * 8);
            }
            this.startOffset = i11;
        } else {
            throw new UnsupportedOptionsException("Unsupported BCJ filter properties");
        }
    }

    public InputStream getInputStream(InputStream inputStream, ArrayCache arrayCache) {
        long j11 = this.filterID;
        return new SimpleInputStream(inputStream, j11 == 4 ? new X86(false, this.startOffset) : j11 == 5 ? new PowerPC(false, this.startOffset) : j11 == 6 ? new IA64(false, this.startOffset) : j11 == 7 ? new ARM(false, this.startOffset) : j11 == 8 ? new ARMThumb(false, this.startOffset) : j11 == 9 ? new SPARC(false, this.startOffset) : null);
    }

    public int getMemoryUsage() {
        return SimpleInputStream.a();
    }
}
