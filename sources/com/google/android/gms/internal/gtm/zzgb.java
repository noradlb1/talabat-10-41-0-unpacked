package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.RemoteException;

final class zzgb implements Runnable {
    private boolean zzaqc = false;
    private final /* synthetic */ String zzaqd;
    private final /* synthetic */ Bundle zzaqe;
    private final /* synthetic */ String zzaqf;
    private final /* synthetic */ long zzaqg;
    private final /* synthetic */ String zzaqh;
    private final /* synthetic */ zzga zzaqi;

    public zzgb(zzga zzga, String str, Bundle bundle, String str2, long j11, String str3) {
        this.zzaqi = zzga;
        this.zzaqd = str;
        this.zzaqe = bundle;
        this.zzaqf = str2;
        this.zzaqg = j11;
        this.zzaqh = str3;
    }

    public final void run() {
        if (this.zzaqi.zzaqb.zzapx == 3) {
            this.zzaqi.zzaqb.zzaps.zza(this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, true);
        } else if (this.zzaqi.zzaqb.zzapx == 4) {
            zzev.zzab(String.format("Container failed to load: skipping  event interceptor by logging event back to Firebase directly: name = %s, origin = %s, params = %s.", new Object[]{this.zzaqd, this.zzaqf, this.zzaqe}));
            try {
                this.zzaqi.zzaqb.zzamx.logEventInternalNoInterceptor(this.zzaqf, this.zzaqd, this.zzaqe, this.zzaqg);
            } catch (RemoteException e11) {
                zzea.zza("Error logging event on measurement proxy: ", e11, this.zzaqi.zzaqb.zzrm);
            }
        } else if (this.zzaqi.zzaqb.zzapx != 1 && this.zzaqi.zzaqb.zzapx != 2) {
            int zza = this.zzaqi.zzaqb.zzapx;
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Unexpected state:");
            sb2.append(zza);
            zzea.zzb(sb2.toString(), this.zzaqi.zzaqb.zzrm);
        } else if (!this.zzaqc) {
            zzev.zzab(String.format("Container not loaded yet: deferring event interceptor by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.zzaqd, this.zzaqh, this.zzaqe}));
            this.zzaqc = true;
            this.zzaqi.zzaqb.zzapy.add(this);
        } else {
            zzea.zzb("Invalid state - not expecting to see a deferredevent during container loading.", this.zzaqi.zzaqb.zzrm);
        }
    }
}
