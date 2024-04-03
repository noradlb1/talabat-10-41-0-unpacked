package com.google.android.gms.tagmanager;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzbw {
    private final long zzabb;
    private final long zzagy;
    private final long zzagz;
    private String zzaha;

    public zzbw(long j11, long j12, long j13) {
        this.zzagy = j11;
        this.zzabb = j12;
        this.zzagz = j13;
    }

    public final void zzbc(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzaha = str;
        }
    }

    public final long zzih() {
        return this.zzagy;
    }

    public final long zzii() {
        return this.zzagz;
    }

    public final String zzij() {
        return this.zzaha;
    }
}
