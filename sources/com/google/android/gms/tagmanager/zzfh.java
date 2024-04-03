package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;

final class zzfh {
    private zzdz<zzl> zzakf;
    private zzl zzakg;

    public zzfh(zzdz<zzl> zzdz, zzl zzl) {
        this.zzakf = zzdz;
        this.zzakg = zzl;
    }

    public final int getSize() {
        int i11;
        int zzse = this.zzakf.getObject().zzse();
        zzl zzl = this.zzakg;
        if (zzl == null) {
            i11 = 0;
        } else {
            i11 = zzl.zzse();
        }
        return zzse + i11;
    }

    public final zzdz<zzl> zzjh() {
        return this.zzakf;
    }

    public final zzl zzji() {
        return this.zzakg;
    }
}
