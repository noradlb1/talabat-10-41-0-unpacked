package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcm;
import java.util.Date;
import java.util.Map;

public final class zzee implements Clock {
    private final zzcm zzamx;
    private final Bundle zzann;
    private final String zzano;
    private final Date zzanp;
    private final String zzanq;
    private Map<String, Object> zzanr;
    private boolean zzans;

    @VisibleForTesting
    public zzee(@Nullable String str, @Nullable Bundle bundle, String str2, Date date, boolean z11, zzcm zzcm) {
        this.zzano = str;
        this.zzann = bundle == null ? new Bundle() : bundle;
        this.zzanp = date;
        this.zzanq = str2;
        this.zzans = z11;
        this.zzamx = zzcm;
    }

    public final long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public final long currentTimeMillis() {
        return this.zzanp.getTime();
    }

    public final long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime() {
        return System.nanoTime();
    }

    public final void zzg(boolean z11) {
        this.zzans = false;
    }

    @WorkerThread
    public final Map<String, Object> zzib() {
        String str;
        if (this.zzanr == null) {
            try {
                this.zzanr = this.zzamx.zzib();
            } catch (RemoteException e11) {
                String valueOf = String.valueOf(e11.getMessage());
                if (valueOf.length() != 0) {
                    str = "Error calling measurement proxy:".concat(valueOf);
                } else {
                    str = new String("Error calling measurement proxy:");
                }
                zzev.zzav(str);
            }
        }
        return this.zzanr;
    }

    public final String zzkf() {
        return this.zzano;
    }

    public final Bundle zzkg() {
        return this.zzann;
    }

    public final String zzkh() {
        return this.zzanq;
    }

    public final boolean zzki() {
        return this.zzans;
    }
}
