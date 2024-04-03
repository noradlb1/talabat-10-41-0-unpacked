package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzi extends zzuq<zzi> {
    public String version = "";
    private String[] zzph;
    public String[] zzpi;
    public zzl[] zzpj = zzl.zzaa();
    public zzc.zzd[] zzpk = new zzc.zzd[0];
    public zzc.zzb[] zzpl = new zzc.zzb[0];
    public zzc.zzb[] zzpm = new zzc.zzb[0];
    public zzc.zzb[] zzpn = new zzc.zzb[0];
    public zzc.zze[] zzpo = new zzc.zze[0];
    private String zzpp = "";
    private String zzpq = "";
    private String zzpr = "0";
    private zzc.zza zzps = null;
    private float zzpt = 0.0f;
    private boolean zzpu = false;
    private String[] zzpv;
    public int zzpw;

    public zzi() {
        String[] strArr = zzuz.zzbhu;
        this.zzph = strArr;
        this.zzpi = strArr;
        this.zzpv = strArr;
        this.zzpw = 0;
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzi)) {
            return false;
        }
        zzi zzi = (zzi) obj;
        if (!zzuu.equals((Object[]) this.zzph, (Object[]) zzi.zzph) || !zzuu.equals((Object[]) this.zzpi, (Object[]) zzi.zzpi) || !zzuu.equals((Object[]) this.zzpj, (Object[]) zzi.zzpj) || !zzuu.equals((Object[]) this.zzpk, (Object[]) zzi.zzpk) || !zzuu.equals((Object[]) this.zzpl, (Object[]) zzi.zzpl) || !zzuu.equals((Object[]) this.zzpm, (Object[]) zzi.zzpm) || !zzuu.equals((Object[]) this.zzpn, (Object[]) zzi.zzpn) || !zzuu.equals((Object[]) this.zzpo, (Object[]) zzi.zzpo)) {
            return false;
        }
        String str = this.zzpp;
        if (str == null) {
            if (zzi.zzpp != null) {
                return false;
            }
        } else if (!str.equals(zzi.zzpp)) {
            return false;
        }
        String str2 = this.zzpq;
        if (str2 == null) {
            if (zzi.zzpq != null) {
                return false;
            }
        } else if (!str2.equals(zzi.zzpq)) {
            return false;
        }
        String str3 = this.zzpr;
        if (str3 == null) {
            if (zzi.zzpr != null) {
                return false;
            }
        } else if (!str3.equals(zzi.zzpr)) {
            return false;
        }
        String str4 = this.version;
        if (str4 == null) {
            if (zzi.version != null) {
                return false;
            }
        } else if (!str4.equals(zzi.version)) {
            return false;
        }
        zzc.zza zza = this.zzps;
        if (zza == null) {
            if (zzi.zzps != null) {
                return false;
            }
        } else if (!zza.equals(zzi.zzps)) {
            return false;
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(zzi.zzpt) || this.zzpu != zzi.zzpu || !zzuu.equals((Object[]) this.zzpv, (Object[]) zzi.zzpv) || this.zzpw != zzi.zzpw) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzi.zzbhb);
        }
        zzus zzus2 = zzi.zzbhb;
        if (zzus2 == null || zzus2.isEmpty()) {
            return true;
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
        int hashCode = (((((((((((((((((zzi.class.getName().hashCode() + 527) * 31) + zzuu.hashCode((Object[]) this.zzph)) * 31) + zzuu.hashCode((Object[]) this.zzpi)) * 31) + zzuu.hashCode((Object[]) this.zzpj)) * 31) + zzuu.hashCode((Object[]) this.zzpk)) * 31) + zzuu.hashCode((Object[]) this.zzpl)) * 31) + zzuu.hashCode((Object[]) this.zzpm)) * 31) + zzuu.hashCode((Object[]) this.zzpn)) * 31) + zzuu.hashCode((Object[]) this.zzpo)) * 31;
        String str = this.zzpp;
        int i17 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i18 = (hashCode + i11) * 31;
        String str2 = this.zzpq;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i19 = (i18 + i12) * 31;
        String str3 = this.zzpr;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        int i21 = (i19 + i13) * 31;
        String str4 = this.version;
        if (str4 == null) {
            i14 = 0;
        } else {
            i14 = str4.hashCode();
        }
        int i22 = i21 + i14;
        zzc.zza zza = this.zzps;
        int i23 = i22 * 31;
        if (zza == null) {
            i15 = 0;
        } else {
            i15 = zza.hashCode();
        }
        int floatToIntBits = (((i23 + i15) * 31) + Float.floatToIntBits(this.zzpt)) * 31;
        if (this.zzpu) {
            i16 = 1231;
        } else {
            i16 = 1237;
        }
        int hashCode2 = (((((floatToIntBits + i16) * 31) + zzuu.hashCode((Object[]) this.zzpv)) * 31) + this.zzpw) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i17 = this.zzbhb.hashCode();
        }
        return hashCode2 + i17;
    }

    public final void zza(zzuo zzuo) throws IOException {
        String[] strArr = this.zzpi;
        int i11 = 0;
        if (strArr != null && strArr.length > 0) {
            int i12 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i12 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i12];
                if (str != null) {
                    zzuo.zza(1, str);
                }
                i12++;
            }
        }
        zzl[] zzlArr = this.zzpj;
        if (zzlArr != null && zzlArr.length > 0) {
            int i13 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpj;
                if (i13 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i13];
                if (zzl != null) {
                    zzuo.zza(2, (zzuw) zzl);
                }
                i13++;
            }
        }
        zzc.zzd[] zzdArr = this.zzpk;
        if (zzdArr != null && zzdArr.length > 0) {
            int i14 = 0;
            while (true) {
                zzc.zzd[] zzdArr2 = this.zzpk;
                if (i14 >= zzdArr2.length) {
                    break;
                }
                zzc.zzd zzd = zzdArr2[i14];
                if (zzd != null) {
                    zzuo.zze(3, (zzsk) zzd);
                }
                i14++;
            }
        }
        zzc.zzb[] zzbArr = this.zzpl;
        if (zzbArr != null && zzbArr.length > 0) {
            int i15 = 0;
            while (true) {
                zzc.zzb[] zzbArr2 = this.zzpl;
                if (i15 >= zzbArr2.length) {
                    break;
                }
                zzc.zzb zzb = zzbArr2[i15];
                if (zzb != null) {
                    zzuo.zze(4, (zzsk) zzb);
                }
                i15++;
            }
        }
        zzc.zzb[] zzbArr3 = this.zzpm;
        if (zzbArr3 != null && zzbArr3.length > 0) {
            int i16 = 0;
            while (true) {
                zzc.zzb[] zzbArr4 = this.zzpm;
                if (i16 >= zzbArr4.length) {
                    break;
                }
                zzc.zzb zzb2 = zzbArr4[i16];
                if (zzb2 != null) {
                    zzuo.zze(5, (zzsk) zzb2);
                }
                i16++;
            }
        }
        zzc.zzb[] zzbArr5 = this.zzpn;
        if (zzbArr5 != null && zzbArr5.length > 0) {
            int i17 = 0;
            while (true) {
                zzc.zzb[] zzbArr6 = this.zzpn;
                if (i17 >= zzbArr6.length) {
                    break;
                }
                zzc.zzb zzb3 = zzbArr6[i17];
                if (zzb3 != null) {
                    zzuo.zze(6, (zzsk) zzb3);
                }
                i17++;
            }
        }
        zzc.zze[] zzeArr = this.zzpo;
        if (zzeArr != null && zzeArr.length > 0) {
            int i18 = 0;
            while (true) {
                zzc.zze[] zzeArr2 = this.zzpo;
                if (i18 >= zzeArr2.length) {
                    break;
                }
                zzc.zze zze = zzeArr2[i18];
                if (zze != null) {
                    zzuo.zze(7, (zzsk) zze);
                }
                i18++;
            }
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzuo.zza(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzuo.zza(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals("0")) {
            zzuo.zza(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzuo.zza(13, this.version);
        }
        zzc.zza zza = this.zzps;
        if (zza != null) {
            zzuo.zze(14, (zzsk) zza);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            float f11 = this.zzpt;
            zzuo.zzd(15, 5);
            zzuo.zzcc(Float.floatToIntBits(f11));
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i19 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i19 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i19];
                if (str6 != null) {
                    zzuo.zza(16, str6);
                }
                i19++;
            }
        }
        int i21 = this.zzpw;
        if (i21 != 0) {
            zzuo.zze(17, i21);
        }
        boolean z11 = this.zzpu;
        if (z11) {
            zzuo.zzb(18, z11);
        }
        String[] strArr5 = this.zzph;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.zzph;
                if (i11 >= strArr6.length) {
                    break;
                }
                String str7 = strArr6[i11];
                if (str7 != null) {
                    zzuo.zza(19, str7);
                }
                i11++;
            }
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int zzy = super.zzy();
        String[] strArr = this.zzpi;
        int i11 = 0;
        if (strArr != null && strArr.length > 0) {
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (true) {
                String[] strArr2 = this.zzpi;
                if (i12 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i12];
                if (str != null) {
                    i14++;
                    i13 += zzuo.zzda(str);
                }
                i12++;
            }
            zzy = zzy + i13 + (i14 * 1);
        }
        zzl[] zzlArr = this.zzpj;
        if (zzlArr != null && zzlArr.length > 0) {
            int i15 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpj;
                if (i15 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i15];
                if (zzl != null) {
                    zzy += zzuo.zzb(2, (zzuw) zzl);
                }
                i15++;
            }
        }
        zzc.zzd[] zzdArr = this.zzpk;
        if (zzdArr != null && zzdArr.length > 0) {
            int i16 = 0;
            while (true) {
                zzc.zzd[] zzdArr2 = this.zzpk;
                if (i16 >= zzdArr2.length) {
                    break;
                }
                zzc.zzd zzd = zzdArr2[i16];
                if (zzd != null) {
                    zzy += zzqj.zzc(3, (zzsk) zzd);
                }
                i16++;
            }
        }
        zzc.zzb[] zzbArr = this.zzpl;
        if (zzbArr != null && zzbArr.length > 0) {
            int i17 = 0;
            while (true) {
                zzc.zzb[] zzbArr2 = this.zzpl;
                if (i17 >= zzbArr2.length) {
                    break;
                }
                zzc.zzb zzb = zzbArr2[i17];
                if (zzb != null) {
                    zzy += zzqj.zzc(4, (zzsk) zzb);
                }
                i17++;
            }
        }
        zzc.zzb[] zzbArr3 = this.zzpm;
        if (zzbArr3 != null && zzbArr3.length > 0) {
            int i18 = 0;
            while (true) {
                zzc.zzb[] zzbArr4 = this.zzpm;
                if (i18 >= zzbArr4.length) {
                    break;
                }
                zzc.zzb zzb2 = zzbArr4[i18];
                if (zzb2 != null) {
                    zzy += zzqj.zzc(5, (zzsk) zzb2);
                }
                i18++;
            }
        }
        zzc.zzb[] zzbArr5 = this.zzpn;
        if (zzbArr5 != null && zzbArr5.length > 0) {
            int i19 = 0;
            while (true) {
                zzc.zzb[] zzbArr6 = this.zzpn;
                if (i19 >= zzbArr6.length) {
                    break;
                }
                zzc.zzb zzb3 = zzbArr6[i19];
                if (zzb3 != null) {
                    zzy += zzqj.zzc(6, (zzsk) zzb3);
                }
                i19++;
            }
        }
        zzc.zze[] zzeArr = this.zzpo;
        if (zzeArr != null && zzeArr.length > 0) {
            int i21 = 0;
            while (true) {
                zzc.zze[] zzeArr2 = this.zzpo;
                if (i21 >= zzeArr2.length) {
                    break;
                }
                zzc.zze zze = zzeArr2[i21];
                if (zze != null) {
                    zzy += zzqj.zzc(7, (zzsk) zze);
                }
                i21++;
            }
        }
        String str2 = this.zzpp;
        if (str2 != null && !str2.equals("")) {
            zzy += zzuo.zzb(9, this.zzpp);
        }
        String str3 = this.zzpq;
        if (str3 != null && !str3.equals("")) {
            zzy += zzuo.zzb(10, this.zzpq);
        }
        String str4 = this.zzpr;
        if (str4 != null && !str4.equals("0")) {
            zzy += zzuo.zzb(12, this.zzpr);
        }
        String str5 = this.version;
        if (str5 != null && !str5.equals("")) {
            zzy += zzuo.zzb(13, this.version);
        }
        zzc.zza zza = this.zzps;
        if (zza != null) {
            zzy += zzqj.zzc(14, (zzsk) zza);
        }
        if (Float.floatToIntBits(this.zzpt) != Float.floatToIntBits(0.0f)) {
            zzy += zzuo.zzbb(15) + 4;
        }
        String[] strArr3 = this.zzpv;
        if (strArr3 != null && strArr3.length > 0) {
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (true) {
                String[] strArr4 = this.zzpv;
                if (i22 >= strArr4.length) {
                    break;
                }
                String str6 = strArr4[i22];
                if (str6 != null) {
                    i24++;
                    i23 += zzuo.zzda(str6);
                }
                i22++;
            }
            zzy = zzy + i23 + (i24 * 2);
        }
        int i25 = this.zzpw;
        if (i25 != 0) {
            zzy += zzuo.zzi(17, i25);
        }
        if (this.zzpu) {
            zzy += zzuo.zzbb(18) + 1;
        }
        String[] strArr5 = this.zzph;
        if (strArr5 == null || strArr5.length <= 0) {
            return zzy;
        }
        int i26 = 0;
        int i27 = 0;
        while (true) {
            String[] strArr6 = this.zzph;
            if (i11 >= strArr6.length) {
                return zzy + i26 + (i27 * 2);
            }
            String str7 = strArr6[i11];
            if (str7 != null) {
                i27++;
                i26 += zzuo.zzda(str7);
            }
            i11++;
        }
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 10:
                    int zzb = zzuz.zzb(zzun, 10);
                    String[] strArr = this.zzpi;
                    int length = strArr == null ? 0 : strArr.length;
                    int i11 = zzb + length;
                    String[] strArr2 = new String[i11];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i11 - 1) {
                        strArr2[length] = zzun.readString();
                        zzun.zzni();
                        length++;
                    }
                    strArr2[length] = zzun.readString();
                    this.zzpi = strArr2;
                    break;
                case 18:
                    int zzb2 = zzuz.zzb(zzun, 18);
                    zzl[] zzlArr = this.zzpj;
                    int length2 = zzlArr == null ? 0 : zzlArr.length;
                    int i12 = zzb2 + length2;
                    zzl[] zzlArr2 = new zzl[i12];
                    if (length2 != 0) {
                        System.arraycopy(zzlArr, 0, zzlArr2, 0, length2);
                    }
                    while (length2 < i12 - 1) {
                        zzl zzl = new zzl();
                        zzlArr2[length2] = zzl;
                        zzun.zza((zzuw) zzl);
                        zzun.zzni();
                        length2++;
                    }
                    zzl zzl2 = new zzl();
                    zzlArr2[length2] = zzl2;
                    zzun.zza((zzuw) zzl2);
                    this.zzpj = zzlArr2;
                    break;
                case 26:
                    int zzb3 = zzuz.zzb(zzun, 26);
                    zzc.zzd[] zzdArr = this.zzpk;
                    int length3 = zzdArr == null ? 0 : zzdArr.length;
                    int i13 = zzb3 + length3;
                    zzc.zzd[] zzdArr2 = new zzc.zzd[i13];
                    if (length3 != 0) {
                        System.arraycopy(zzdArr, 0, zzdArr2, 0, length3);
                    }
                    while (length3 < i13 - 1) {
                        zzdArr2[length3] = (zzc.zzd) zzun.zza(zzc.zzd.zza());
                        zzun.zzni();
                        length3++;
                    }
                    zzdArr2[length3] = (zzc.zzd) zzun.zza(zzc.zzd.zza());
                    this.zzpk = zzdArr2;
                    break;
                case 34:
                    int zzb4 = zzuz.zzb(zzun, 34);
                    zzc.zzb[] zzbArr = this.zzpl;
                    int length4 = zzbArr == null ? 0 : zzbArr.length;
                    int i14 = zzb4 + length4;
                    zzc.zzb[] zzbArr2 = new zzc.zzb[i14];
                    if (length4 != 0) {
                        System.arraycopy(zzbArr, 0, zzbArr2, 0, length4);
                    }
                    while (length4 < i14 - 1) {
                        zzbArr2[length4] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length4++;
                    }
                    zzbArr2[length4] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpl = zzbArr2;
                    break;
                case 42:
                    int zzb5 = zzuz.zzb(zzun, 42);
                    zzc.zzb[] zzbArr3 = this.zzpm;
                    int length5 = zzbArr3 == null ? 0 : zzbArr3.length;
                    int i15 = zzb5 + length5;
                    zzc.zzb[] zzbArr4 = new zzc.zzb[i15];
                    if (length5 != 0) {
                        System.arraycopy(zzbArr3, 0, zzbArr4, 0, length5);
                    }
                    while (length5 < i15 - 1) {
                        zzbArr4[length5] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length5++;
                    }
                    zzbArr4[length5] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpm = zzbArr4;
                    break;
                case 50:
                    int zzb6 = zzuz.zzb(zzun, 50);
                    zzc.zzb[] zzbArr5 = this.zzpn;
                    int length6 = zzbArr5 == null ? 0 : zzbArr5.length;
                    int i16 = zzb6 + length6;
                    zzc.zzb[] zzbArr6 = new zzc.zzb[i16];
                    if (length6 != 0) {
                        System.arraycopy(zzbArr5, 0, zzbArr6, 0, length6);
                    }
                    while (length6 < i16 - 1) {
                        zzbArr6[length6] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                        zzun.zzni();
                        length6++;
                    }
                    zzbArr6[length6] = (zzc.zzb) zzun.zza(zzc.zzb.zza());
                    this.zzpn = zzbArr6;
                    break;
                case 58:
                    int zzb7 = zzuz.zzb(zzun, 58);
                    zzc.zze[] zzeArr = this.zzpo;
                    int length7 = zzeArr == null ? 0 : zzeArr.length;
                    int i17 = zzb7 + length7;
                    zzc.zze[] zzeArr2 = new zzc.zze[i17];
                    if (length7 != 0) {
                        System.arraycopy(zzeArr, 0, zzeArr2, 0, length7);
                    }
                    while (length7 < i17 - 1) {
                        zzeArr2[length7] = (zzc.zze) zzun.zza(zzc.zze.zza());
                        zzun.zzni();
                        length7++;
                    }
                    zzeArr2[length7] = (zzc.zze) zzun.zza(zzc.zze.zza());
                    this.zzpo = zzeArr2;
                    break;
                case 74:
                    this.zzpp = zzun.readString();
                    break;
                case 82:
                    this.zzpq = zzun.readString();
                    break;
                case 98:
                    this.zzpr = zzun.readString();
                    break;
                case 106:
                    this.version = zzun.readString();
                    break;
                case 114:
                    zzc.zza zza = (zzc.zza) zzun.zza(zzc.zza.zza());
                    zzc.zza zza2 = this.zzps;
                    if (zza2 != null) {
                        zza = (zzc.zza) ((zzrc) ((zzc.zza.C0011zza) ((zzc.zza.C0011zza) zza2.zzpd()).zza(zza)).zzpm());
                    }
                    this.zzps = zza;
                    break;
                case 125:
                    this.zzpt = Float.intBitsToFloat(zzun.zzoc());
                    break;
                case 130:
                    int zzb8 = zzuz.zzb(zzun, 130);
                    String[] strArr3 = this.zzpv;
                    int length8 = strArr3 == null ? 0 : strArr3.length;
                    int i18 = zzb8 + length8;
                    String[] strArr4 = new String[i18];
                    if (length8 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length8);
                    }
                    while (length8 < i18 - 1) {
                        strArr4[length8] = zzun.readString();
                        zzun.zzni();
                        length8++;
                    }
                    strArr4[length8] = zzun.readString();
                    this.zzpv = strArr4;
                    break;
                case Opcodes.L2I:
                    this.zzpw = zzun.zzoa();
                    break;
                case Opcodes.D2F:
                    this.zzpu = zzun.zzno();
                    break;
                case Opcodes.IFNE:
                    int zzb9 = zzuz.zzb(zzun, Opcodes.IFNE);
                    String[] strArr5 = this.zzph;
                    int length9 = strArr5 == null ? 0 : strArr5.length;
                    int i19 = zzb9 + length9;
                    String[] strArr6 = new String[i19];
                    if (length9 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length9);
                    }
                    while (length9 < i19 - 1) {
                        strArr6[length9] = zzun.readString();
                        zzun.zzni();
                        length9++;
                    }
                    strArr6[length9] = zzun.readString();
                    this.zzph = strArr6;
                    break;
                default:
                    if (super.zza(zzun, zzni)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }
}
