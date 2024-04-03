package org.tukaani.xz.delta;

public class DeltaEncoder extends DeltaCoder {
    public DeltaEncoder(int i11) {
        super(i11);
    }

    public void encode(byte[] bArr, int i11, int i12, byte[] bArr2) {
        for (int i13 = 0; i13 < i12; i13++) {
            byte[] bArr3 = this.f63422b;
            int i14 = this.f63421a;
            int i15 = this.f63423c;
            byte b11 = bArr3[(i14 + i15) & 255];
            this.f63423c = i15 - 1;
            int i16 = i11 + i13;
            bArr3[i15 & 255] = bArr[i16];
            bArr2[i13] = (byte) (bArr[i16] - b11);
        }
    }
}
