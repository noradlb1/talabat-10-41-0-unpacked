package com.google.android.gms.internal.places;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzag extends zzad {
    protected final byte[] zzen;

    public zzag(byte[] bArr) {
        bArr.getClass();
        this.zzen = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzw) || size() != ((zzw) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return obj.equals(this);
        }
        zzag zzag = (zzag) obj;
        int zzaf = zzaf();
        int zzaf2 = zzag.zzaf();
        if (zzaf == 0 || zzaf2 == 0 || zzaf == zzaf2) {
            return zzb(zzag, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzen.length;
    }

    public final boolean zzae() {
        int zzag = zzag();
        return zzea.zzf(this.zzen, zzag, size() + zzag);
    }

    public int zzag() {
        return 0;
    }

    public final zzw zzb(int i11, int i12) {
        int zzc = zzw.zzc(0, i12, size());
        if (zzc == 0) {
            return zzw.zzeg;
        }
        return new zzz(this.zzen, zzag(), zzc);
    }

    public byte zzi(int i11) {
        return this.zzen[i11];
    }

    public byte zzj(int i11) {
        return this.zzen[i11];
    }

    public void zzb(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zzen, 0, bArr, 0, i13);
    }

    public final void zzb(zzt zzt) throws IOException {
        zzt.zzb(this.zzen, zzag(), size());
    }

    public final String zzb(Charset charset) {
        return new String(this.zzen, zzag(), size(), charset);
    }

    public final boolean zzb(zzw zzw, int i11, int i12) {
        if (i12 > zzw.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i12);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i12 > zzw.size()) {
            int size2 = zzw.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i12);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (!(zzw instanceof zzag)) {
            return zzw.zzb(0, i12).equals(zzb(0, i12));
        } else {
            zzag zzag = (zzag) zzw;
            byte[] bArr = this.zzen;
            byte[] bArr2 = zzag.zzen;
            int zzag2 = zzag() + i12;
            int zzag3 = zzag();
            int zzag4 = zzag.zzag();
            while (zzag3 < zzag2) {
                if (bArr[zzag3] != bArr2[zzag4]) {
                    return false;
                }
                zzag3++;
                zzag4++;
            }
            return true;
        }
    }

    public final int zzb(int i11, int i12, int i13) {
        return zzbd.zzb(i11, this.zzen, zzag(), i13);
    }
}
