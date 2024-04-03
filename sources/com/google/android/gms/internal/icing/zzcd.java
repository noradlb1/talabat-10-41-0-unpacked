package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzcd extends zzcc {
    protected final byte[] zza;

    public zzcd(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcf) || zzc() != ((zzcf) obj).zzc()) {
            return false;
        }
        if (zzc() == 0) {
            return true;
        }
        if (!(obj instanceof zzcd)) {
            return obj.equals(this);
        }
        zzcd zzcd = (zzcd) obj;
        int zzl = zzl();
        int zzl2 = zzcd.zzl();
        if (zzl != 0 && zzl2 != 0 && zzl != zzl2) {
            return false;
        }
        int zzc = zzc();
        if (zzc > zzcd.zzc()) {
            int zzc2 = zzc();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(zzc);
            sb2.append(zzc2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzc <= zzcd.zzc()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzcd.zza;
            zzcd.zzd();
            int i11 = 0;
            int i12 = 0;
            while (i11 < zzc) {
                if (bArr[i11] != bArr2[i12]) {
                    return false;
                }
                i11++;
                i12++;
            }
            return true;
        } else {
            int zzc3 = zzcd.zzc();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(zzc);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(zzc3);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public byte zza(int i11) {
        return this.zza[i11];
    }

    public byte zzb(int i11) {
        return this.zza[i11];
    }

    public int zzc() {
        return this.zza.length;
    }

    public int zzd() {
        return 0;
    }

    public final zzcf zze(int i11, int i12) {
        zzcf.zzm(0, i12, zzc());
        if (i12 == 0) {
            return zzcf.zzb;
        }
        return new zzca(this.zza, 0, i12);
    }

    public final void zzf(zzbw zzbw) throws IOException {
        ((zzck) zzbw).zzp(this.zza, 0, zzc());
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzc(), charset);
    }

    public final boolean zzh() {
        return zzfr.zzb(this.zza, 0, zzc());
    }

    public final int zzi(int i11, int i12, int i13) {
        return zzdh.zzh(i11, this.zza, 0, i13);
    }
}
