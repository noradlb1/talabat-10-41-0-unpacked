package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzaau extends zzaat {
    protected final byte[] zza;

    public zzaau(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaax) || zzd() != ((zzaax) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzaau)) {
            return obj.equals(this);
        }
        zzaau zzaau = (zzaau) obj;
        int zzk = zzk();
        int zzk2 = zzaau.zzk();
        if (zzk != 0 && zzk2 != 0 && zzk != zzk2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzaau.zzd()) {
            int zzd2 = zzd();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(zzd);
            sb2.append(zzd2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (zzd <= zzaau.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzaau.zza;
            zzaau.zzc();
            int i11 = 0;
            int i12 = 0;
            while (i11 < zzd) {
                if (bArr[i11] != bArr2[i12]) {
                    return false;
                }
                i11++;
                i12++;
            }
            return true;
        } else {
            int zzd3 = zzaau.zzd();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(zzd);
            sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb3.append(zzd3);
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
        return 0;
    }

    public int zzd() {
        return this.zza.length;
    }

    public final int zze(int i11, int i12, int i13) {
        return zzaca.zzd(i11, this.zza, 0, i13);
    }

    public final zzaax zzf(int i11, int i12) {
        zzaax.zzj(0, i12, zzd());
        if (i12 == 0) {
            return zzaax.zzb;
        }
        return new zzaar(this.zza, 0, i12);
    }

    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzh(zzaam zzaam) throws IOException {
        ((zzabc) zzaam).zzc(this.zza, 0, zzd());
    }

    public final boolean zzi() {
        return zzaep.zze(this.zza, 0, zzd());
    }
}
