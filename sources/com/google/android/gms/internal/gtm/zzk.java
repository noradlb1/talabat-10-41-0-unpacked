package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzk extends zzuq<zzk> {
    public zzj[] zzqj = zzj.zzz();
    public zzi zzqk = null;
    public String zzql = "";

    public zzk() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzk)) {
            return false;
        }
        zzk zzk = (zzk) obj;
        if (!zzuu.equals((Object[]) this.zzqj, (Object[]) zzk.zzqj)) {
            return false;
        }
        zzi zzi = this.zzqk;
        if (zzi == null) {
            if (zzk.zzqk != null) {
                return false;
            }
        } else if (!zzi.equals(zzk.zzqk)) {
            return false;
        }
        String str = this.zzql;
        if (str == null) {
            if (zzk.zzql != null) {
                return false;
            }
        } else if (!str.equals(zzk.zzql)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzk.zzbhb);
        }
        zzus zzus2 = zzk.zzbhb;
        if (zzus2 == null || zzus2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int hashCode = ((zzk.class.getName().hashCode() + 527) * 31) + zzuu.hashCode((Object[]) this.zzqj);
        zzi zzi = this.zzqk;
        int i13 = hashCode * 31;
        int i14 = 0;
        if (zzi == null) {
            i11 = 0;
        } else {
            i11 = zzi.hashCode();
        }
        int i15 = (i13 + i11) * 31;
        String str = this.zzql;
        if (str == null) {
            i12 = 0;
        } else {
            i12 = str.hashCode();
        }
        int i16 = (i15 + i12) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i14 = this.zzbhb.hashCode();
        }
        return i16 + i14;
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzj[] zzjArr = this.zzqj;
        if (zzjArr != null && zzjArr.length > 0) {
            int i11 = 0;
            while (true) {
                zzj[] zzjArr2 = this.zzqj;
                if (i11 >= zzjArr2.length) {
                    break;
                }
                zzj zzj = zzjArr2[i11];
                if (zzj != null) {
                    zzuo.zza(1, (zzuw) zzj);
                }
                i11++;
            }
        }
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzuo.zza(2, (zzuw) zzi);
        }
        String str = this.zzql;
        if (str != null && !str.equals("")) {
            zzuo.zza(3, this.zzql);
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int zzy = super.zzy();
        zzj[] zzjArr = this.zzqj;
        if (zzjArr != null && zzjArr.length > 0) {
            int i11 = 0;
            while (true) {
                zzj[] zzjArr2 = this.zzqj;
                if (i11 >= zzjArr2.length) {
                    break;
                }
                zzj zzj = zzjArr2[i11];
                if (zzj != null) {
                    zzy += zzuo.zzb(1, (zzuw) zzj);
                }
                i11++;
            }
        }
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzy += zzuo.zzb(2, (zzuw) zzi);
        }
        String str = this.zzql;
        if (str == null || str.equals("")) {
            return zzy;
        }
        return zzy + zzuo.zzb(3, this.zzql);
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 10) {
                int zzb = zzuz.zzb(zzun, 10);
                zzj[] zzjArr = this.zzqj;
                int length = zzjArr == null ? 0 : zzjArr.length;
                int i11 = zzb + length;
                zzj[] zzjArr2 = new zzj[i11];
                if (length != 0) {
                    System.arraycopy(zzjArr, 0, zzjArr2, 0, length);
                }
                while (length < i11 - 1) {
                    zzj zzj = new zzj();
                    zzjArr2[length] = zzj;
                    zzun.zza((zzuw) zzj);
                    zzun.zzni();
                    length++;
                }
                zzj zzj2 = new zzj();
                zzjArr2[length] = zzj2;
                zzun.zza((zzuw) zzj2);
                this.zzqj = zzjArr2;
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzun.zza((zzuw) this.zzqk);
            } else if (zzni == 26) {
                this.zzql = zzun.readString();
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }
}
