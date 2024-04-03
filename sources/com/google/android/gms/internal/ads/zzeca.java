package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public final class zzeca implements zzo, zzcqa {
    private final Context zza;
    private final zzcjf zzb;
    private zzebt zzc;
    private zzcop zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    @Nullable
    private zzbin zzh;
    private boolean zzi;

    public zzeca(Context context, zzcjf zzcjf) {
        this.zza = context;
        this.zzb = zzcjf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzj() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzfxb r0 = com.google.android.gms.internal.ads.zzcjm.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzebz r1 = new com.google.android.gms.internal.ads.zzebz     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeca.zzj():void");
    }

    private final synchronized boolean zzk(zzbin zzbin) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue()) {
            zzciz.zzj("Ad inspector had an internal error.");
            try {
                zzbin.zze(zzfey.zzd(16, (String) null, (zzbew) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzciz.zzj("Ad inspector had an internal error.");
            try {
                zzbin.zze(zzfey.zzd(16, (String) null, (zzbew) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzt.zzA().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzgD)).intValue())) {
                    return true;
                }
            }
            zzciz.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzbin.zze(zzfey.zzd(19, (String) null, (zzbew) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:8|9|10|11|12|(1:14)|15|16|17|18) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 1
            if (r4 == 0) goto L_0x0010
            java.lang.String r4 = "Ad inspector loaded."
            com.google.android.gms.ads.internal.util.zze.zza(r4)     // Catch:{ all -> 0x002c }
            r3.zze = r0     // Catch:{ all -> 0x002c }
            r3.zzj()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x0010:
            java.lang.String r4 = "Ad inspector failed to load."
            com.google.android.gms.internal.ads.zzciz.zzj(r4)     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzbin r4 = r3.zzh     // Catch:{ RemoteException -> 0x0023 }
            if (r4 == 0) goto L_0x0023
            r1 = 17
            r2 = 0
            com.google.android.gms.internal.ads.zzbew r1 = com.google.android.gms.internal.ads.zzfey.zzd(r1, r2, r2)     // Catch:{ RemoteException -> 0x0023 }
            r4.zze(r1)     // Catch:{ RemoteException -> 0x0023 }
        L_0x0023:
            r3.zzi = r0     // Catch:{ all -> 0x002c }
            com.google.android.gms.internal.ads.zzcop r4 = r3.zzd     // Catch:{ all -> 0x002c }
            r4.destroy()     // Catch:{ all -> 0x002c }
            monitor-exit(r3)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeca.zza(boolean):void");
    }

    public final synchronized void zzb() {
        this.zzf = true;
        zzj();
    }

    public final void zzbK() {
    }

    public final void zzbS() {
    }

    public final void zzbz() {
    }

    public final void zze() {
    }

    public final synchronized void zzf(int i11) {
        this.zzd.destroy();
        if (!this.zzi) {
            zze.zza("Inspector closed.");
            zzbin zzbin = this.zzh;
            if (zzbin != null) {
                try {
                    zzbin.zze((zzbew) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final void zzg(zzebt zzebt) {
        this.zzc = zzebt;
    }

    public final /* synthetic */ void zzh() {
        String str;
        zzcop zzcop = this.zzd;
        JSONObject zzd2 = this.zzc.zzd();
        if (!(zzd2 instanceof JSONObject)) {
            str = zzd2.toString();
        } else {
            str = JSONObjectInstrumentation.toString(zzd2);
        }
        zzcop.zzb("window.inspectorInfo", str);
    }

    public final synchronized void zzi(zzbin zzbin, zzbru zzbru) {
        zzbin zzbin2 = zzbin;
        synchronized (this) {
            if (zzk(zzbin)) {
                try {
                    zzt.zzz();
                    zzcop zza2 = zzcpb.zza(this.zza, zzcqe.zza(), "", false, false, (zzalt) null, (zzbmi) null, this.zzb, (zzbly) null, (zzl) null, (zza) null, zzbay.zza(), (zzfdn) null, (zzfdq) null);
                    this.zzd = zza2;
                    zzcqc zzP = zza2.zzP();
                    if (zzP == null) {
                        zzciz.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzbin2.zze(zzfey.zzd(17, "Failed to obtain a web view for the ad inspector", (zzbew) null));
                        } catch (RemoteException unused) {
                        }
                    } else {
                        this.zzh = zzbin2;
                        zzP.zzL((zzbes) null, (zzbqt) null, (zzo) null, (zzbqv) null, (zzw) null, false, (zzbrw) null, (zzb) null, (zzcar) null, (zzcgf) null, (zzehh) null, (zzfjs) null, (zzdyz) null, (zzfio) null, zzbru, (zzdmd) null);
                        zzP.zzz(this);
                        this.zzd.loadUrl((String) zzbgq.zzc().zzb(zzblj.zzgB));
                        zzt.zzj();
                        zzm.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzt.zzA().currentTimeMillis();
                    }
                } catch (zzcpa e11) {
                    zzciz.zzk("Failed to obtain a web view for the ad inspector", e11);
                    try {
                        zzbin2.zze(zzfey.zzd(17, "Failed to obtain a web view for the ad inspector", (zzbew) null));
                    } catch (RemoteException unused2) {
                    }
                }
            }
        }
    }
}
