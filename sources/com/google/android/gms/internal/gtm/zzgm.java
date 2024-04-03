package com.google.android.gms.internal.gtm;

import android.os.RemoteException;

final class zzgm implements Runnable {
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ String zzaql;
    private final /* synthetic */ String zzaqm;
    private final /* synthetic */ zzeo zzaqu;
    private final /* synthetic */ zzgl zzaqv;

    public zzgm(zzgl zzgl, String str, String str2, String str3, zzeo zzeo) {
        this.zzaqv = zzgl;
        this.zzaqk = str;
        this.zzaql = str2;
        this.zzaqm = str3;
        this.zzaqu = zzeo;
    }

    public final void run() {
        boolean z11;
        try {
            z11 = true;
            if (!this.zzaqv.zzaqs.containsKey(this.zzaqk)) {
                this.zzaqv.zzaqs.put(this.zzaqk, this.zzaqv.zzaqt.zzb(this.zzaqk, this.zzaql, this.zzaqm));
            }
        } catch (Exception e11) {
            zzea.zza("Fail to load container: ", e11, this.zzaqv.zzrm);
            z11 = false;
        }
        try {
            zzeo zzeo = this.zzaqu;
            if (zzeo != null) {
                zzeo.zza(z11, this.zzaqk);
            }
        } catch (RemoteException e12) {
            zzea.zza("Error relaying callback: ", e12, this.zzaqv.zzrm);
        }
    }
}
