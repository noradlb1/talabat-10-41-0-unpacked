package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

class zzgjb extends zzgja {
    protected final byte[] zza;

    public zzgjb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgjf) || zzd() != ((zzgjf) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgjb)) {
            return obj.equals(this);
        }
        zzgjb zzgjb = (zzgjb) obj;
        int zzr = zzr();
        int zzr2 = zzgjb.zzr();
        if (zzr == 0 || zzr2 == 0 || zzr == zzr2) {
            return zzg(zzgjb, 0, zzd());
        }
        return false;
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
        System.arraycopy(this.zza, i11, bArr, i12, i13);
    }

    public final boolean zzg(zzgjf zzgjf, int i11, int i12) {
        if (i12 <= zzgjf.zzd()) {
            int i13 = i11 + i12;
            if (i13 > zzgjf.zzd()) {
                int zzd = zzgjf.zzd();
                StringBuilder sb2 = new StringBuilder(59);
                sb2.append("Ran off end of other: ");
                sb2.append(i11);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(i12);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(zzd);
                throw new IllegalArgumentException(sb2.toString());
            } else if (!(zzgjf instanceof zzgjb)) {
                return zzgjf.zzk(i11, i13).equals(zzk(0, i12));
            } else {
                zzgjb zzgjb = (zzgjb) zzgjf;
                byte[] bArr = this.zza;
                byte[] bArr2 = zzgjb.zza;
                int zzc = zzc() + i12;
                int zzc2 = zzc();
                int zzc3 = zzgjb.zzc() + i11;
                while (zzc2 < zzc) {
                    if (bArr[zzc2] != bArr2[zzc3]) {
                        return false;
                    }
                    zzc2++;
                    zzc3++;
                }
                return true;
            }
        } else {
            int zzd2 = zzd();
            StringBuilder sb3 = new StringBuilder(40);
            sb3.append("Length too large: ");
            sb3.append(i12);
            sb3.append(zzd2);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public final int zzi(int i11, int i12, int i13) {
        return zzgkv.zzd(i11, this.zza, zzc() + i12, i13);
    }

    public final int zzj(int i11, int i12, int i13) {
        int zzc = zzc() + i12;
        return zzgnu.zzf(i11, this.zza, zzc, i13 + zzc);
    }

    public final zzgjf zzk(int i11, int i12) {
        int zzq = zzgjf.zzq(i11, i12, zzd());
        if (zzq == 0) {
            return zzgjf.zzb;
        }
        return new zzgiy(this.zza, zzc() + i11, zzq);
    }

    public final zzgjn zzl() {
        return zzgjn.zzH(this.zza, zzc(), zzd(), true);
    }

    public final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    public final void zzo(zzgit zzgit) throws IOException {
        ((zzgjp) zzgit).zzc(this.zza, zzc(), zzd());
    }

    public final boolean zzp() {
        int zzc = zzc();
        return zzgnu.zzj(this.zza, zzc, zzd() + zzc);
    }
}
