package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzfr extends zzfs {
    protected final byte[] zzse;

    public zzfr(byte[] bArr) {
        bArr.getClass();
        this.zzse = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfh) || size() != ((zzfh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzfr)) {
            return obj.equals(this);
        }
        zzfr zzfr = (zzfr) obj;
        int zzet = zzet();
        int zzet2 = zzfr.zzet();
        if (zzet == 0 || zzet2 == 0 || zzet == zzet2) {
            return zza(zzfr, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzse.length;
    }

    public void zza(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zzse, 0, bArr, 0, i13);
    }

    public byte zzan(int i11) {
        return this.zzse[i11];
    }

    public byte zzao(int i11) {
        return this.zzse[i11];
    }

    public final int zzb(int i11, int i12, int i13) {
        return zzgt.zza(i11, this.zzse, zzeu(), i13);
    }

    public final boolean zzes() {
        int zzeu = zzeu();
        return zzjs.zzf(this.zzse, zzeu, size() + zzeu);
    }

    public int zzeu() {
        return 0;
    }

    public final zzfh zzf(int i11, int i12) {
        int zzc = zzfh.zzc(0, i12, size());
        if (zzc == 0) {
            return zzfh.zzrx;
        }
        return new zzfo(this.zzse, zzeu(), zzc);
    }

    public final void zza(zzfi zzfi) throws IOException {
        zzfi.zzc(this.zzse, zzeu(), size());
    }

    public final String zza(Charset charset) {
        return new String(this.zzse, zzeu(), size(), charset);
    }

    public final boolean zza(zzfh zzfh, int i11, int i12) {
        if (i12 > zzfh.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i12);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i12 > zzfh.size()) {
            int size2 = zzfh.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i12);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (!(zzfh instanceof zzfr)) {
            return zzfh.zzf(0, i12).equals(zzf(0, i12));
        } else {
            zzfr zzfr = (zzfr) zzfh;
            byte[] bArr = this.zzse;
            byte[] bArr2 = zzfr.zzse;
            int zzeu = zzeu() + i12;
            int zzeu2 = zzeu();
            int zzeu3 = zzfr.zzeu();
            while (zzeu2 < zzeu) {
                if (bArr[zzeu2] != bArr2[zzeu3]) {
                    return false;
                }
                zzeu2++;
                zzeu3++;
            }
            return true;
        }
    }
}
