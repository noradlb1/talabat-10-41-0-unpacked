package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzc;
import java.io.IOException;

public final class zzh extends zzuq<zzh> {
    public zzl[] zzpe = zzl.zzaa();
    public zzl[] zzpf = zzl.zzaa();
    public zzc.C0012zzc[] zzpg = new zzc.C0012zzc[0];

    public zzh() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzh = (zzh) obj;
        if (!zzuu.equals((Object[]) this.zzpe, (Object[]) zzh.zzpe) || !zzuu.equals((Object[]) this.zzpf, (Object[]) zzh.zzpf) || !zzuu.equals((Object[]) this.zzpg, (Object[]) zzh.zzpg)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzh.zzbhb);
        }
        zzus zzus2 = zzh.zzbhb;
        if (zzus2 == null || zzus2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (((((((zzh.class.getName().hashCode() + 527) * 31) + zzuu.hashCode((Object[]) this.zzpe)) * 31) + zzuu.hashCode((Object[]) this.zzpf)) * 31) + zzuu.hashCode((Object[]) this.zzpg)) * 31;
        zzus zzus = this.zzbhb;
        if (zzus == null || zzus.isEmpty()) {
            i11 = 0;
        } else {
            i11 = this.zzbhb.hashCode();
        }
        return hashCode + i11;
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzl[] zzlArr = this.zzpe;
        int i11 = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i12 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpe;
                if (i12 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i12];
                if (zzl != null) {
                    zzuo.zza(1, (zzuw) zzl);
                }
                i12++;
            }
        }
        zzl[] zzlArr3 = this.zzpf;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i13 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzpf;
                if (i13 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i13];
                if (zzl2 != null) {
                    zzuo.zza(2, (zzuw) zzl2);
                }
                i13++;
            }
        }
        zzc.C0012zzc[] zzcArr = this.zzpg;
        if (zzcArr != null && zzcArr.length > 0) {
            while (true) {
                zzc.C0012zzc[] zzcArr2 = this.zzpg;
                if (i11 >= zzcArr2.length) {
                    break;
                }
                zzc.C0012zzc zzc = zzcArr2[i11];
                if (zzc != null) {
                    zzuo.zze(3, (zzsk) zzc);
                }
                i11++;
            }
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int zzy = super.zzy();
        zzl[] zzlArr = this.zzpe;
        int i11 = 0;
        if (zzlArr != null && zzlArr.length > 0) {
            int i12 = 0;
            while (true) {
                zzl[] zzlArr2 = this.zzpe;
                if (i12 >= zzlArr2.length) {
                    break;
                }
                zzl zzl = zzlArr2[i12];
                if (zzl != null) {
                    zzy += zzuo.zzb(1, (zzuw) zzl);
                }
                i12++;
            }
        }
        zzl[] zzlArr3 = this.zzpf;
        if (zzlArr3 != null && zzlArr3.length > 0) {
            int i13 = 0;
            while (true) {
                zzl[] zzlArr4 = this.zzpf;
                if (i13 >= zzlArr4.length) {
                    break;
                }
                zzl zzl2 = zzlArr4[i13];
                if (zzl2 != null) {
                    zzy += zzuo.zzb(2, (zzuw) zzl2);
                }
                i13++;
            }
        }
        zzc.C0012zzc[] zzcArr = this.zzpg;
        if (zzcArr != null && zzcArr.length > 0) {
            while (true) {
                zzc.C0012zzc[] zzcArr2 = this.zzpg;
                if (i11 >= zzcArr2.length) {
                    break;
                }
                zzc.C0012zzc zzc = zzcArr2[i11];
                if (zzc != null) {
                    zzy += zzqj.zzc(3, (zzsk) zzc);
                }
                i11++;
            }
        }
        return zzy;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzun, 10);
                zzl[] zzlArr = this.zzpe;
                int length = zzlArr == null ? 0 : zzlArr.length;
                int i11 = zzb + length;
                zzl[] zzlArr2 = new zzl[i11];
                if (length != 0) {
                    System.arraycopy(zzlArr, 0, zzlArr2, 0, length);
                }
                while (length < i11 - 1) {
                    zzl zzl = new zzl();
                    zzlArr2[length] = zzl;
                    zzun.zza((zzuw) zzl);
                    zzun.zzni();
                    length++;
                }
                zzl zzl2 = new zzl();
                zzlArr2[length] = zzl2;
                zzun.zza((zzuw) zzl2);
                this.zzpe = zzlArr2;
            } else if (zzni == 18) {
                int zzb2 = zzuz.zzb(zzun, 18);
                zzl[] zzlArr3 = this.zzpf;
                int length2 = zzlArr3 == null ? 0 : zzlArr3.length;
                int i12 = zzb2 + length2;
                zzl[] zzlArr4 = new zzl[i12];
                if (length2 != 0) {
                    System.arraycopy(zzlArr3, 0, zzlArr4, 0, length2);
                }
                while (length2 < i12 - 1) {
                    zzl zzl3 = new zzl();
                    zzlArr4[length2] = zzl3;
                    zzun.zza((zzuw) zzl3);
                    zzun.zzni();
                    length2++;
                }
                zzl zzl4 = new zzl();
                zzlArr4[length2] = zzl4;
                zzun.zza((zzuw) zzl4);
                this.zzpf = zzlArr4;
            } else if (zzni == 26) {
                int zzb3 = zzuz.zzb(zzun, 26);
                zzc.C0012zzc[] zzcArr = this.zzpg;
                int length3 = zzcArr == null ? 0 : zzcArr.length;
                int i13 = zzb3 + length3;
                zzc.C0012zzc[] zzcArr2 = new zzc.C0012zzc[i13];
                if (length3 != 0) {
                    System.arraycopy(zzcArr, 0, zzcArr2, 0, length3);
                }
                while (length3 < i13 - 1) {
                    zzcArr2[length3] = (zzc.C0012zzc) zzun.zza(zzc.C0012zzc.zza());
                    zzun.zzni();
                    length3++;
                }
                zzcArr2[length3] = (zzc.C0012zzc) zzun.zza(zzc.C0012zzc.zza());
                this.zzpg = zzcArr2;
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }
}
