package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;

public abstract class zzuq<M extends zzuq<M>> extends zzuw {
    protected zzus zzbhb;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzuq zzuq = (zzuq) super.clone();
        zzuu.zza(this, zzuq);
        return zzuq;
    }

    public void zza(zzuo zzuo) throws IOException {
        if (this.zzbhb != null) {
            for (int i11 = 0; i11 < this.zzbhb.size(); i11++) {
                this.zzbhb.zzce(i11).zza(zzuo);
            }
        }
    }

    public final /* synthetic */ zzuw zzry() throws CloneNotSupportedException {
        return (zzuq) clone();
    }

    public int zzy() {
        if (this.zzbhb == null) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzbhb.size(); i12++) {
            i11 += this.zzbhb.zzce(i12).zzy();
        }
        return i11;
    }

    public final <T> T zza(zzur<M, T> zzur) {
        zzut zzcd;
        zzus zzus = this.zzbhb;
        if (zzus == null || (zzcd = zzus.zzcd(zzur.tag >>> 3)) == null) {
            return null;
        }
        return zzcd.zzb(zzur);
    }

    public final boolean zza(zzun zzun, int i11) throws IOException {
        zzut zzut;
        int position = zzun.getPosition();
        if (!zzun.zzao(i11)) {
            return false;
        }
        int i12 = i11 >>> 3;
        zzuy zzuy = new zzuy(i11, zzun.zzt(position, zzun.getPosition() - position));
        zzus zzus = this.zzbhb;
        if (zzus == null) {
            this.zzbhb = new zzus();
            zzut = null;
        } else {
            zzut = zzus.zzcd(i12);
        }
        if (zzut == null) {
            zzut = new zzut();
            this.zzbhb.zza(i12, zzut);
        }
        zzut.zza(zzuy);
        return true;
    }
}
