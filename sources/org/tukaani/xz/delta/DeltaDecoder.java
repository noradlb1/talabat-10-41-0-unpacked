package org.tukaani.xz.delta;

public class DeltaDecoder extends DeltaCoder {
    public DeltaDecoder(int i11) {
        super(i11);
    }

    public void decode(byte[] bArr, int i11, int i12) {
        int i13 = i12 + i11;
        while (i11 < i13) {
            byte b11 = bArr[i11];
            byte[] bArr2 = this.f63422b;
            int i14 = this.f63421a;
            int i15 = this.f63423c;
            byte b12 = (byte) (b11 + bArr2[(i14 + i15) & 255]);
            bArr[i11] = b12;
            this.f63423c = i15 - 1;
            bArr2[i15 & 255] = b12;
            i11++;
        }
    }
}
