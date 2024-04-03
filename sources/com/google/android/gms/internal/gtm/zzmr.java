package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Status;

final class zzmr<T> {
    private T data;
    private Status zzaen;
    private long zzasv;

    public zzmr(Status status, T t11, long j11) {
        this.zzaen = status;
        this.data = t11;
        this.zzasv = j11;
    }

    public final void zzb(Status status) {
        this.zzaen = status;
    }

    public final long zzlj() {
        return this.zzasv;
    }

    public final void zzo(long j11) {
        this.zzasv = j11;
    }

    public final void zzp(T t11) {
        this.data = t11;
    }
}
