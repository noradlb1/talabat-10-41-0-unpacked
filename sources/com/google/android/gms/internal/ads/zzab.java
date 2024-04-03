package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzab {
    private static final zzab zzG = new zzab(new zzz());
    public static final zzj<zzab> zza = zzx.zza;
    public final int zzA;
    public final int zzB;
    public final int zzC;
    public final int zzD;
    public final int zzE;
    public final int zzF;
    private int zzH;
    @Nullable
    public final String zzb;
    @Nullable
    public final String zzc;
    @Nullable
    public final String zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    @Nullable
    public final String zzj;
    @Nullable
    public final zzdd zzk;
    @Nullable
    public final String zzl;
    @Nullable
    public final String zzm;
    public final int zzn;
    public final List<byte[]> zzo;
    @Nullable
    public final zzs zzp;
    public final long zzq;
    public final int zzr;
    public final int zzs;
    public final float zzt;
    public final int zzu;
    public final float zzv;
    @Nullable
    public final byte[] zzw;
    public final int zzx;
    @Nullable
    public final zzm zzy;
    public final int zzz;

    private zzab(zzz zzz2) {
        List<byte[]> list;
        int i11;
        float f11;
        int i12;
        int zzf2;
        this.zzb = zzz2.zza;
        this.zzc = zzz2.zzb;
        this.zzd = zzfn.zzK(zzz2.zzc);
        this.zze = zzz2.zzd;
        int i13 = 0;
        this.zzf = 0;
        int zzd2 = zzz2.zze;
        this.zzg = zzd2;
        int zzl2 = zzz2.zzf;
        this.zzh = zzl2;
        this.zzi = zzl2 != -1 ? zzl2 : zzd2;
        this.zzj = zzz2.zzg;
        this.zzk = zzz2.zzh;
        this.zzl = zzz2.zzi;
        this.zzm = zzz2.zzj;
        this.zzn = zzz2.zzk;
        if (zzz2.zzl == null) {
            list = Collections.emptyList();
        } else {
            list = zzz2.zzl;
        }
        this.zzo = list;
        zzs zzt2 = zzz2.zzm;
        this.zzp = zzt2;
        this.zzq = zzz2.zzn;
        this.zzr = zzz2.zzo;
        this.zzs = zzz2.zzp;
        this.zzt = zzz2.zzq;
        if (zzz2.zzr == -1) {
            i11 = 0;
        } else {
            i11 = zzz2.zzr;
        }
        this.zzu = i11;
        if (zzz2.zzs == -1.0f) {
            f11 = 1.0f;
        } else {
            f11 = zzz2.zzs;
        }
        this.zzv = f11;
        this.zzw = zzz2.zzt;
        this.zzx = zzz2.zzu;
        this.zzy = zzz2.zzv;
        this.zzz = zzz2.zzw;
        this.zzA = zzz2.zzx;
        this.zzB = zzz2.zzy;
        if (zzz2.zzz == -1) {
            i12 = 0;
        } else {
            i12 = zzz2.zzz;
        }
        this.zzC = i12;
        this.zzD = zzz2.zzA != -1 ? zzz2.zzA : i13;
        this.zzE = zzz2.zzB;
        if (zzz2.zzC != 0 || zzt2 == null) {
            zzf2 = zzz2.zzC;
        } else {
            zzf2 = 1;
        }
        this.zzF = zzf2;
    }

    public final boolean equals(@Nullable Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj != null && zzab.class == obj.getClass()) {
            zzab zzab = (zzab) obj;
            int i12 = this.zzH;
            if ((i12 == 0 || (i11 = zzab.zzH) == 0 || i12 == i11) && this.zze == zzab.zze && this.zzg == zzab.zzg && this.zzh == zzab.zzh && this.zzn == zzab.zzn && this.zzq == zzab.zzq && this.zzr == zzab.zzr && this.zzs == zzab.zzs && this.zzu == zzab.zzu && this.zzx == zzab.zzx && this.zzz == zzab.zzz && this.zzA == zzab.zzA && this.zzB == zzab.zzB && this.zzC == zzab.zzC && this.zzD == zzab.zzD && this.zzE == zzab.zzE && this.zzF == zzab.zzF && Float.compare(this.zzt, zzab.zzt) == 0 && Float.compare(this.zzv, zzab.zzv) == 0 && zzfn.zzP(this.zzb, zzab.zzb) && zzfn.zzP(this.zzc, zzab.zzc) && zzfn.zzP(this.zzj, zzab.zzj) && zzfn.zzP(this.zzl, zzab.zzl) && zzfn.zzP(this.zzm, zzab.zzm) && zzfn.zzP(this.zzd, zzab.zzd) && Arrays.equals(this.zzw, zzab.zzw) && zzfn.zzP(this.zzk, zzab.zzk) && zzfn.zzP(this.zzy, zzab.zzy) && zzfn.zzP(this.zzp, zzab.zzp) && zzd(zzab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = this.zzH;
        if (i17 != 0) {
            return i17;
        }
        String str = this.zzb;
        int i18 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i19 = (i11 + 527) * 31;
        String str2 = this.zzc;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i21 = (i19 + i12) * 31;
        String str3 = this.zzd;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        int i22 = (((((((i21 + i13) * 31) + this.zze) * 961) + this.zzg) * 31) + this.zzh) * 31;
        String str4 = this.zzj;
        if (str4 == null) {
            i14 = 0;
        } else {
            i14 = str4.hashCode();
        }
        int i23 = (i22 + i14) * 31;
        zzdd zzdd = this.zzk;
        if (zzdd == null) {
            i15 = 0;
        } else {
            i15 = zzdd.hashCode();
        }
        int i24 = (i23 + i15) * 31;
        String str5 = this.zzl;
        if (str5 == null) {
            i16 = 0;
        } else {
            i16 = str5.hashCode();
        }
        int i25 = (i24 + i16) * 31;
        String str6 = this.zzm;
        if (str6 != null) {
            i18 = str6.hashCode();
        }
        int floatToIntBits = ((((((((((((((((((((((((((((((i25 + i18) * 31) + this.zzn) * 31) + ((int) this.zzq)) * 31) + this.zzr) * 31) + this.zzs) * 31) + Float.floatToIntBits(this.zzt)) * 31) + this.zzu) * 31) + Float.floatToIntBits(this.zzv)) * 31) + this.zzx) * 31) + this.zzz) * 31) + this.zzA) * 31) + this.zzB) * 31) + this.zzC) * 31) + this.zzD) * 31) + this.zzE) * 31) + this.zzF;
        this.zzH = floatToIntBits;
        return floatToIntBits;
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = this.zzl;
        String str4 = this.zzm;
        String str5 = this.zzj;
        int i11 = this.zzi;
        String str6 = this.zzd;
        int i12 = this.zzr;
        int i13 = this.zzs;
        float f11 = this.zzt;
        int i14 = this.zzz;
        int i15 = this.zzA;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        int length4 = String.valueOf(str4).length();
        StringBuilder sb2 = new StringBuilder(length + 104 + length2 + length3 + length4 + String.valueOf(str5).length() + String.valueOf(str6).length());
        sb2.append("Format(");
        sb2.append(str);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str3);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str4);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str5);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i11);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str6);
        sb2.append(", [");
        sb2.append(i12);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i13);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(f11);
        sb2.append("], [");
        sb2.append(i14);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(i15);
        sb2.append("])");
        return sb2.toString();
    }

    public final int zza() {
        int i11;
        int i12 = this.zzr;
        if (i12 == -1 || (i11 = this.zzs) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public final zzz zzb() {
        return new zzz(this, (zzy) null);
    }

    public final zzab zzc(int i11) {
        zzz zzz2 = new zzz(this, (zzy) null);
        zzz2.zzA(i11);
        return new zzab(zzz2);
    }

    public final boolean zzd(zzab zzab) {
        if (this.zzo.size() != zzab.zzo.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.zzo.size(); i11++) {
            if (!Arrays.equals(this.zzo.get(i11), zzab.zzo.get(i11))) {
                return false;
            }
        }
        return true;
    }
}
