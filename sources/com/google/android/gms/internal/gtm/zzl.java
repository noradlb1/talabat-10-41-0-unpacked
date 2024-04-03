package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzl extends zzuq<zzl> {
    private static volatile zzl[] zzqm;
    public String string = "";
    public int type = 1;
    public zzl[] zzqn = zzaa();
    public zzl[] zzqo = zzaa();
    public zzl[] zzqp = zzaa();
    public String zzqq = "";
    public String zzqr = "";
    public long zzqs = 0;
    public boolean zzqt = false;
    public zzl[] zzqu = zzaa();
    public int[] zzqv = zzuz.zzbcw;
    public boolean zzqw = false;

    public zzl() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public static zzl[] zzaa() {
        if (zzqm == null) {
            synchronized (zzuu.zzbhk) {
                if (zzqm == null) {
                    zzqm = new zzl[0];
                }
            }
        }
        return zzqm;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzl zza(zzun zzun) throws IOException {
        int zzoa;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        while (true) {
            int zzni = zzun.zzni();
            switch (zzni) {
                case 0:
                    return this;
                case 8:
                    try {
                        zzoa = zzun.zzoa();
                        if (zzoa > 0 && zzoa <= 8) {
                            this.type = zzoa;
                            break;
                        } else {
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append(zzoa);
                            sb2.append(" is not a valid enum Type");
                            break;
                        }
                    } catch (IllegalArgumentException unused) {
                        zzun.zzbz(zzun.getPosition());
                        zza(zzun, zzni);
                        break;
                    }
                    break;
                case 18:
                    this.string = zzun.readString();
                    break;
                case 26:
                    int zzb = zzuz.zzb(zzun, 26);
                    zzl[] zzlArr = this.zzqn;
                    if (zzlArr == null) {
                        i11 = 0;
                    } else {
                        i11 = zzlArr.length;
                    }
                    int i17 = zzb + i11;
                    zzl[] zzlArr2 = new zzl[i17];
                    if (i11 != 0) {
                        System.arraycopy(zzlArr, 0, zzlArr2, 0, i11);
                    }
                    while (i11 < i17 - 1) {
                        zzl zzl = new zzl();
                        zzlArr2[i11] = zzl;
                        zzun.zza((zzuw) zzl);
                        zzun.zzni();
                        i11++;
                    }
                    zzl zzl2 = new zzl();
                    zzlArr2[i11] = zzl2;
                    zzun.zza((zzuw) zzl2);
                    this.zzqn = zzlArr2;
                    break;
                case 34:
                    int zzb2 = zzuz.zzb(zzun, 34);
                    zzl[] zzlArr3 = this.zzqo;
                    if (zzlArr3 == null) {
                        i12 = 0;
                    } else {
                        i12 = zzlArr3.length;
                    }
                    int i18 = zzb2 + i12;
                    zzl[] zzlArr4 = new zzl[i18];
                    if (i12 != 0) {
                        System.arraycopy(zzlArr3, 0, zzlArr4, 0, i12);
                    }
                    while (i12 < i18 - 1) {
                        zzl zzl3 = new zzl();
                        zzlArr4[i12] = zzl3;
                        zzun.zza((zzuw) zzl3);
                        zzun.zzni();
                        i12++;
                    }
                    zzl zzl4 = new zzl();
                    zzlArr4[i12] = zzl4;
                    zzun.zza((zzuw) zzl4);
                    this.zzqo = zzlArr4;
                    break;
                case 42:
                    int zzb3 = zzuz.zzb(zzun, 42);
                    zzl[] zzlArr5 = this.zzqp;
                    if (zzlArr5 == null) {
                        i13 = 0;
                    } else {
                        i13 = zzlArr5.length;
                    }
                    int i19 = zzb3 + i13;
                    zzl[] zzlArr6 = new zzl[i19];
                    if (i13 != 0) {
                        System.arraycopy(zzlArr5, 0, zzlArr6, 0, i13);
                    }
                    while (i13 < i19 - 1) {
                        zzl zzl5 = new zzl();
                        zzlArr6[i13] = zzl5;
                        zzun.zza((zzuw) zzl5);
                        zzun.zzni();
                        i13++;
                    }
                    zzl zzl6 = new zzl();
                    zzlArr6[i13] = zzl6;
                    zzun.zza((zzuw) zzl6);
                    this.zzqp = zzlArr6;
                    break;
                case 50:
                    this.zzqq = zzun.readString();
                    break;
                case 58:
                    this.zzqr = zzun.readString();
                    break;
                case 64:
                    this.zzqs = zzun.zzob();
                    break;
                case 72:
                    this.zzqw = zzun.zzno();
                    break;
                case 80:
                    int zzb4 = zzuz.zzb(zzun, 80);
                    int[] iArr = new int[zzb4];
                    int i21 = 0;
                    for (int i22 = 0; i22 < zzb4; i22++) {
                        if (i22 != 0) {
                            zzun.zzni();
                        }
                        int position = zzun.getPosition();
                        try {
                            iArr[i21] = zzc(zzun.zzoa());
                            i21++;
                        } catch (IllegalArgumentException unused2) {
                            zzun.zzbz(position);
                            zza(zzun, zzni);
                        }
                    }
                    if (i21 != 0) {
                        int[] iArr2 = this.zzqv;
                        if (iArr2 == null) {
                            i14 = 0;
                        } else {
                            i14 = iArr2.length;
                        }
                        if (i14 != 0 || i21 != zzb4) {
                            int[] iArr3 = new int[(i14 + i21)];
                            if (i14 != 0) {
                                System.arraycopy(iArr2, 0, iArr3, 0, i14);
                            }
                            System.arraycopy(iArr, 0, iArr3, i14, i21);
                            this.zzqv = iArr3;
                            break;
                        } else {
                            this.zzqv = iArr;
                            break;
                        }
                    } else {
                        break;
                    }
                case 82:
                    int zzaq = zzun.zzaq(zzun.zzoa());
                    int position2 = zzun.getPosition();
                    int i23 = 0;
                    while (zzun.zzrv() > 0) {
                        try {
                            zzc(zzun.zzoa());
                            i23++;
                        } catch (IllegalArgumentException unused3) {
                        }
                    }
                    if (i23 != 0) {
                        zzun.zzbz(position2);
                        int[] iArr4 = this.zzqv;
                        if (iArr4 == null) {
                            i15 = 0;
                        } else {
                            i15 = iArr4.length;
                        }
                        int[] iArr5 = new int[(i23 + i15)];
                        if (i15 != 0) {
                            System.arraycopy(iArr4, 0, iArr5, 0, i15);
                        }
                        while (zzun.zzrv() > 0) {
                            int position3 = zzun.getPosition();
                            try {
                                iArr5[i15] = zzc(zzun.zzoa());
                                i15++;
                            } catch (IllegalArgumentException unused4) {
                                zzun.zzbz(position3);
                                zza(zzun, 80);
                            }
                        }
                        this.zzqv = iArr5;
                    }
                    zzun.zzar(zzaq);
                    break;
                case 90:
                    int zzb5 = zzuz.zzb(zzun, 90);
                    zzl[] zzlArr7 = this.zzqu;
                    if (zzlArr7 == null) {
                        i16 = 0;
                    } else {
                        i16 = zzlArr7.length;
                    }
                    int i24 = zzb5 + i16;
                    zzl[] zzlArr8 = new zzl[i24];
                    if (i16 != 0) {
                        System.arraycopy(zzlArr7, 0, zzlArr8, 0, i16);
                    }
                    while (i16 < i24 - 1) {
                        zzl zzl7 = new zzl();
                        zzlArr8[i16] = zzl7;
                        zzun.zza((zzuw) zzl7);
                        zzun.zzni();
                        i16++;
                    }
                    zzl zzl8 = new zzl();
                    zzlArr8[i16] = zzl8;
                    zzun.zza((zzuw) zzl8);
                    this.zzqu = zzlArr8;
                    break;
                case 96:
                    this.zzqt = zzun.zzno();
                    break;
                default:
                    if (super.zza(zzun, zzni)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
        StringBuilder sb22 = new StringBuilder(36);
        sb22.append(zzoa);
        sb22.append(" is not a valid enum Type");
        throw new IllegalArgumentException(sb22.toString());
    }

    private static int zzc(int i11) {
        if (i11 > 0 && i11 <= 17) {
            return i11;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append(i11);
        sb2.append(" is not a valid enum Escaping");
        throw new IllegalArgumentException(sb2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzl)) {
            return false;
        }
        zzl zzl = (zzl) obj;
        if (this.type != zzl.type) {
            return false;
        }
        String str = this.string;
        if (str == null) {
            if (zzl.string != null) {
                return false;
            }
        } else if (!str.equals(zzl.string)) {
            return false;
        }
        if (!zzuu.equals((Object[]) this.zzqn, (Object[]) zzl.zzqn) || !zzuu.equals((Object[]) this.zzqo, (Object[]) zzl.zzqo) || !zzuu.equals((Object[]) this.zzqp, (Object[]) zzl.zzqp)) {
            return false;
        }
        String str2 = this.zzqq;
        if (str2 == null) {
            if (zzl.zzqq != null) {
                return false;
            }
        } else if (!str2.equals(zzl.zzqq)) {
            return false;
        }
        String str3 = this.zzqr;
        if (str3 == null) {
            if (zzl.zzqr != null) {
                return false;
            }
        } else if (!str3.equals(zzl.zzqr)) {
            return false;
        }
        if (this.zzqs != zzl.zzqs || this.zzqt != zzl.zzqt || !zzuu.equals((Object[]) this.zzqu, (Object[]) zzl.zzqu) || !zzuu.equals(this.zzqv, zzl.zzqv) || this.zzqw != zzl.zzqw) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzl.zzbhb);
        }
        zzus zzus2 = zzl.zzbhb;
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
        int hashCode = (((zzl.class.getName().hashCode() + 527) * 31) + this.type) * 31;
        String str = this.string;
        int i15 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int hashCode2 = (((((((hashCode + i11) * 31) + zzuu.hashCode((Object[]) this.zzqn)) * 31) + zzuu.hashCode((Object[]) this.zzqo)) * 31) + zzuu.hashCode((Object[]) this.zzqp)) * 31;
        String str2 = this.zzqq;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i16 = (hashCode2 + i12) * 31;
        String str3 = this.zzqr;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        long j11 = this.zzqs;
        int i17 = (((i16 + i13) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        int i18 = 1231;
        if (this.zzqt) {
            i14 = 1231;
        } else {
            i14 = 1237;
        }
        int hashCode3 = (((((i17 + i14) * 31) + zzuu.hashCode((Object[]) this.zzqu)) * 31) + zzuu.hashCode(this.zzqv)) * 31;
        if (!this.zzqw) {
            i18 = 1237;
        }
        int i19 = (hashCode3 + i18) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i15 = this.zzbhb.hashCode();
        }
        return i19 + i15;
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzuo.zze(1, this.type);
        String str = this.string;
        if (str != null && !str.equals("")) {
            zzuo.zza(2, this.string);
        }
        zzl[] zzlArr = this.zzqn;
        int i11 = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i12 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzqn;
                if (i12 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i12];
                if (zzl != null) {
                    zzuo.zza(3, (zzuw) zzl);
                }
                i12++;
            }
        }
        zzl[] zzlArr3 = this.zzqo;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i13 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzqo;
                if (i13 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i13];
                if (zzl2 != null) {
                    zzuo.zza(4, (zzuw) zzl2);
                }
                i13++;
            }
        }
        zzl[] zzlArr5 = this.zzqp;
        if (zzlArr5 != null && zzlArr5.length > 0) {
            int i14 = 0;
            while (true) {
                zzl[] zzlArr6 = this.zzqp;
                if (i14 >= zzlArr6.length) {
                    break;
                }
                zzl zzl3 = zzlArr6[i14];
                if (zzl3 != null) {
                    zzuo.zza(5, (zzuw) zzl3);
                }
                i14++;
            }
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            zzuo.zza(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            zzuo.zza(7, this.zzqr);
        }
        long j11 = this.zzqs;
        if (j11 != 0) {
            zzuo.zzi(8, j11);
        }
        boolean z11 = this.zzqw;
        if (z11) {
            zzuo.zzb(9, z11);
        }
        int[] iArr = this.zzqv;
        if (iArr != null && iArr.length > 0) {
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.zzqv;
                if (i15 >= iArr2.length) {
                    break;
                }
                zzuo.zze(10, iArr2[i15]);
                i15++;
            }
        }
        zzl[] zzlArr7 = this.zzqu;
        if (zzlArr7 != null && zzlArr7.length > 0) {
            while (true) {
                zzl[] zzlArr8 = this.zzqu;
                if (i11 >= zzlArr8.length) {
                    break;
                }
                zzl zzl4 = zzlArr8[i11];
                if (zzl4 != null) {
                    zzuo.zza(11, (zzuw) zzl4);
                }
                i11++;
            }
        }
        boolean z12 = this.zzqt;
        if (z12) {
            zzuo.zzb(12, z12);
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int[] iArr;
        int zzy = super.zzy() + zzuo.zzi(1, this.type);
        String str = this.string;
        if (str != null && !str.equals("")) {
            zzy += zzuo.zzb(2, this.string);
        }
        zzl[] zzlArr = this.zzqn;
        int i11 = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i12 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzqn;
                if (i12 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i12];
                if (zzl != null) {
                    zzy += zzuo.zzb(3, (zzuw) zzl);
                }
                i12++;
            }
        }
        zzl[] zzlArr3 = this.zzqo;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i13 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzqo;
                if (i13 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i13];
                if (zzl2 != null) {
                    zzy += zzuo.zzb(4, (zzuw) zzl2);
                }
                i13++;
            }
        }
        zzl[] zzlArr5 = this.zzqp;
        if (zzlArr5 != null && zzlArr5.length > 0) {
            int i14 = 0;
            while (true) {
                zzl[] zzlArr6 = this.zzqp;
                if (i14 >= zzlArr6.length) {
                    break;
                }
                zzl zzl3 = zzlArr6[i14];
                if (zzl3 != null) {
                    zzy += zzuo.zzb(5, (zzuw) zzl3);
                }
                i14++;
            }
        }
        String str2 = this.zzqq;
        if (str2 != null && !str2.equals("")) {
            zzy += zzuo.zzb(6, this.zzqq);
        }
        String str3 = this.zzqr;
        if (str3 != null && !str3.equals("")) {
            zzy += zzuo.zzb(7, this.zzqr);
        }
        long j11 = this.zzqs;
        if (j11 != 0) {
            zzy += zzuo.zzd(8, j11);
        }
        if (this.zzqw) {
            zzy += zzuo.zzbb(9) + 1;
        }
        int[] iArr2 = this.zzqv;
        if (iArr2 != null && iArr2.length > 0) {
            int i15 = 0;
            int i16 = 0;
            while (true) {
                iArr = this.zzqv;
                if (i15 >= iArr.length) {
                    break;
                }
                i16 += zzuo.zzbc(iArr[i15]);
                i15++;
            }
            zzy = zzy + i16 + (iArr.length * 1);
        }
        zzl[] zzlArr7 = this.zzqu;
        if (zzlArr7 != null && zzlArr7.length > 0) {
            while (true) {
                zzl[] zzlArr8 = this.zzqu;
                if (i11 >= zzlArr8.length) {
                    break;
                }
                zzl zzl4 = zzlArr8[i11];
                if (zzl4 != null) {
                    zzy += zzuo.zzb(11, (zzuw) zzl4);
                }
                i11++;
            }
        }
        if (this.zzqt) {
            return zzy + zzuo.zzbb(12) + 1;
        }
        return zzy;
    }
}
