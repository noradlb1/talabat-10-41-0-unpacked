package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzj extends zzuq<zzj> {
    private static volatile zzj[] zzqg;

    /* renamed from: name  reason: collision with root package name */
    public String f35099name = "";
    private zzl zzqh = null;
    public zzh zzqi = null;

    public zzj() {
        this.zzbhb = null;
        this.zzbhl = -1;
    }

    public static zzj[] zzz() {
        if (zzqg == null) {
            synchronized (zzuu.zzbhk) {
                if (zzqg == null) {
                    zzqg = new zzj[0];
                }
            }
        }
        return zzqg;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzj)) {
            return false;
        }
        zzj zzj = (zzj) obj;
        String str = this.f35099name;
        if (str == null) {
            if (zzj.f35099name != null) {
                return false;
            }
        } else if (!str.equals(zzj.f35099name)) {
            return false;
        }
        zzl zzl = this.zzqh;
        if (zzl == null) {
            if (zzj.zzqh != null) {
                return false;
            }
        } else if (!zzl.equals(zzj.zzqh)) {
            return false;
        }
        zzh zzh = this.zzqi;
        if (zzh == null) {
            if (zzj.zzqi != null) {
                return false;
            }
        } else if (!zzh.equals(zzj.zzqi)) {
            return false;
        }
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            return this.zzbhb.equals(zzj.zzbhb);
        }
        zzus zzus2 = zzj.zzbhb;
        if (zzus2 == null || zzus2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12;
        int i13;
        int hashCode = (zzj.class.getName().hashCode() + 527) * 31;
        String str = this.f35099name;
        int i14 = 0;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i15 = hashCode + i11;
        zzl zzl = this.zzqh;
        int i16 = i15 * 31;
        if (zzl == null) {
            i12 = 0;
        } else {
            i12 = zzl.hashCode();
        }
        int i17 = i16 + i12;
        zzh zzh = this.zzqi;
        int i18 = i17 * 31;
        if (zzh == null) {
            i13 = 0;
        } else {
            i13 = zzh.hashCode();
        }
        int i19 = (i18 + i13) * 31;
        zzus zzus = this.zzbhb;
        if (zzus != null && !zzus.isEmpty()) {
            i14 = this.zzbhb.hashCode();
        }
        return i19 + i14;
    }

    public final void zza(zzuo zzuo) throws IOException {
        String str = this.f35099name;
        if (str != null && !str.equals("")) {
            zzuo.zza(1, this.f35099name);
        }
        zzl zzl = this.zzqh;
        if (zzl != null) {
            zzuo.zza(2, (zzuw) zzl);
        }
        zzh zzh = this.zzqi;
        if (zzh != null) {
            zzuo.zza(3, (zzuw) zzh);
        }
        super.zza(zzuo);
    }

    public final int zzy() {
        int zzy = super.zzy();
        String str = this.f35099name;
        if (str != null && !str.equals("")) {
            zzy += zzuo.zzb(1, this.f35099name);
        }
        zzl zzl = this.zzqh;
        if (zzl != null) {
            zzy += zzuo.zzb(2, (zzuw) zzl);
        }
        zzh zzh = this.zzqi;
        if (zzh != null) {
            return zzy + zzuo.zzb(3, (zzuw) zzh);
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
                this.f35099name = zzun.readString();
            } else if (zzni == 18) {
                if (this.zzqh == null) {
                    this.zzqh = new zzl();
                }
                zzun.zza((zzuw) this.zzqh);
            } else if (zzni == 26) {
                if (this.zzqi == null) {
                    this.zzqi = new zzh();
                }
                zzun.zza((zzuw) this.zzqi);
            } else if (!super.zza(zzun, zzni)) {
                return this;
            }
        }
    }
}
