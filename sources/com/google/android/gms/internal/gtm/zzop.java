package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzop extends zzuq<zzop> {
    public long zzaux = 0;
    public zzk zzauy = null;
    public zzi zzqk = null;

    public zzop() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzop)) {
            return false;
        }
        zzop zzop = (zzop) obj;
        if (this.zzaux != zzop.zzaux) {
            return false;
        }
        zzi zzi = this.zzqk;
        if (zzi == null) {
            if (zzop.zzqk != null) {
                return false;
            }
        } else if (!zzi.equals(zzop.zzqk)) {
            return false;
        }
        zzk zzk = this.zzauy;
        if (zzk == null) {
            if (zzop.zzauy != null) {
                return false;
            }
        } else if (!zzk.equals(zzop.zzauy)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzop.zzbhb);
        }
        zzus zzus2 = zzop.zzbhb;
        if (zzus2 == null || zzus2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        long j11 = this.zzaux;
        int hashCode = ((zzop.class.getName().hashCode() + 527) * 31) + ((int) (j11 ^ (j11 >>> 32)));
        zzi zzi = this.zzqk;
        int i13 = hashCode * 31;
        int i14 = 0;
        if (zzi == null) {
            i11 = 0;
        } else {
            i11 = zzi.hashCode();
        }
        int i15 = i13 + i11;
        zzk zzk = this.zzauy;
        int i16 = i15 * 31;
        if (zzk == null) {
            i12 = 0;
        } else {
            i12 = zzk.hashCode();
        }
        int i17 = (i16 + i12) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i14 = this.zzbhb.hashCode();
        }
        return i17 + i14;
    }

    public final void zza(zzuo zzuo) throws IOException {
        zzuo.zzi(1, this.zzaux);
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzuo.zza(2, (zzuw) zzi);
        }
        zzk zzk = this.zzauy;
        if (zzk != null) {
            zzuo.zza(3, (zzuw) zzk);
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int zzy = super.zzy() + zzuo.zzd(1, this.zzaux);
        zzi zzi = this.zzqk;
        if (zzi != null) {
            zzy += zzuo.zzb(2, (zzuw) zzi);
        }
        zzk zzk = this.zzauy;
        if (zzk != null) {
            return zzy + zzuo.zzb(3, (zzuw) zzk);
        }
        return zzy;
    }

    public final /* synthetic */ zzuw zza(zzun zzun) throws IOException {
        while (true) {
            int zzni = zzun.zzni();
            if (zzni == 0) {
                return this;
            }
            if (zzni == 8) {
                this.zzaux = zzun.zzob();
            } else if (zzni == 18) {
                if (this.zzqk == null) {
                    this.zzqk = new zzi();
                }
                zzun.zza((zzuw) this.zzqk);
            } else if (zzni == 26) {
                if (this.zzauy == null) {
                    this.zzauy = new zzk();
                }
                zzun.zza((zzuw) this.zzauy);
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }
}
