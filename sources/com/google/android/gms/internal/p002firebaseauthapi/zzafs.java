package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafs  reason: invalid package */
class zzafs extends zzafr {
    protected final byte[] zza;

    public zzafs(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzafv) || zzd() != ((zzafv) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzafs)) {
            return obj.equals(this);
        }
        zzafs zzafs = (zzafs) obj;
        int zzm = zzm();
        int zzm2 = zzafs.zzm();
        if (zzm != 0 && zzm2 != 0 && zzm != zzm2) {
            return false;
        }
        int zzd = zzd();
        if (zzd > zzafs.zzd()) {
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        } else if (zzd <= zzafs.zzd()) {
            byte[] bArr = this.zza;
            byte[] bArr2 = zzafs.zza;
            zzafs.zzc();
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
            throw new IllegalArgumentException("Ran off end of other: 0, " + zzd + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + zzafs.zzd());
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

    public void zze(byte[] bArr, int i11, int i12, int i13) {
        System.arraycopy(this.zza, 0, bArr, 0, i13);
    }

    public final int zzf(int i11, int i12, int i13) {
        return zzahg.zzb(i11, this.zza, 0, i13);
    }

    public final zzafv zzg(int i11, int i12) {
        int zzl = zzafv.zzl(0, i12, zzd());
        if (zzl == 0) {
            return zzafv.zzb;
        }
        return new zzafp(this.zza, 0, zzl);
    }

    public final zzagb zzh() {
        return zzagb.zzH(this.zza, 0, zzd(), true);
    }

    public final String zzi(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    public final void zzj(zzafl zzafl) throws IOException {
        zzafl.zza(this.zza, 0, zzd());
    }

    public final boolean zzk() {
        return zzaka.zzf(this.zza, 0, zzd());
    }
}
