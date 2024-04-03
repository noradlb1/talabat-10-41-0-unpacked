package com.google.android.gms.internal.gtm;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;

public abstract class zzmn {
    private int zzasj;
    protected final zzmw zzask;
    private final zzms zzasl;
    private final Clock zzasm;
    @Nullable
    protected final zzdz zzasn;

    public zzmn(int i11, zzmw zzmw, zzms zzms, @Nullable zzdz zzdz) {
        this(i11, zzmw, zzms, zzdz, DefaultClock.getInstance());
    }

    private final zzmx zzd(byte[] bArr) {
        zzmx zzmx;
        try {
            zzmx = this.zzasl.zze(bArr);
            if (zzmx == null) {
                try {
                    zzev.zzaw("Parsed resource from is null");
                } catch (zzml unused) {
                }
            }
        } catch (zzml unused2) {
            zzmx = null;
            zzev.zzaw("Resource data is corrupted");
            return zzmx;
        }
        return zzmx;
    }

    public abstract void zza(zzmx zzmx);

    public final void zzb(int i11, int i12) {
        String str;
        zzdz zzdz = this.zzasn;
        if (zzdz != null && i12 == 0 && i11 == 3) {
            zzdz.zzhn();
        }
        String containerId = this.zzask.zzlk().getContainerId();
        if (i11 == 0) {
            str = "Resource not available";
        } else if (i11 == 1) {
            str = "IOError";
        } else if (i11 != 2) {
            str = "Unknown reason";
        } else {
            str = "Server error";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(containerId).length() + 61 + str.length());
        sb2.append("Failed to fetch the container resource for the container \"");
        sb2.append(containerId);
        sb2.append("\": ");
        sb2.append(str);
        zzev.zzab(sb2.toString());
        zza(new zzmx(Status.RESULT_INTERNAL_ERROR, i12));
    }

    public final void zzc(byte[] bArr) {
        zzmx zzmx;
        Status status;
        zzmx zzd = zzd(bArr);
        zzdz zzdz = this.zzasn;
        if (zzdz != null && this.zzasj == 0) {
            zzdz.zzho();
        }
        if (zzd == null || zzd.getStatus() != (status = Status.RESULT_SUCCESS)) {
            zzmx = new zzmx(Status.RESULT_INTERNAL_ERROR, this.zzasj);
        } else {
            byte[] bArr2 = bArr;
            zzmx = new zzmx(status, this.zzasj, new zzmy(this.zzask.zzlk(), bArr2, zzd.zzll().zzlq(), this.zzasm.currentTimeMillis()), zzd.zzlm());
        }
        zza(zzmx);
    }

    @VisibleForTesting
    private zzmn(int i11, zzmw zzmw, zzms zzms, @Nullable zzdz zzdz, Clock clock) {
        this.zzask = (zzmw) Preconditions.checkNotNull(zzmw);
        Preconditions.checkNotNull(zzmw.zzlk());
        this.zzasj = i11;
        this.zzasl = (zzms) Preconditions.checkNotNull(zzms);
        this.zzasm = (Clock) Preconditions.checkNotNull(clock);
        this.zzasn = zzdz;
    }
}
