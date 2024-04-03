package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbv;

public final /* synthetic */ class zzehm implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzdyz zza;
    public final /* synthetic */ Activity zzb;
    public final /* synthetic */ zzfio zzc;
    public final /* synthetic */ zzehh zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ zzbv zzf;
    public final /* synthetic */ String zzg;
    public final /* synthetic */ Resources zzh;
    public final /* synthetic */ zzl zzi;

    public /* synthetic */ zzehm(zzdyz zzdyz, Activity activity, zzfio zzfio, zzehh zzehh, String str, zzbv zzbv, String str2, Resources resources, zzl zzl) {
        this.zza = zzdyz;
        this.zzb = activity;
        this.zzc = zzfio;
        this.zzd = zzehh;
        this.zze = str;
        this.zzf = zzbv;
        this.zzg = str2;
        this.zzh = resources;
        this.zzi = zzl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003d, code lost:
        if (r0.zzf(com.google.android.gms.dynamic.ObjectWrapper.wrap(r10), r14, r13) == false) goto L_0x0046;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.content.DialogInterface r19, int r20) {
        /*
            r18 = this;
            r1 = r18
            com.google.android.gms.internal.ads.zzdyz r9 = r1.zza
            android.app.Activity r10 = r1.zzb
            com.google.android.gms.internal.ads.zzfio r11 = r1.zzc
            com.google.android.gms.internal.ads.zzehh r12 = r1.zzd
            java.lang.String r13 = r1.zze
            com.google.android.gms.ads.internal.util.zzbv r0 = r1.zzf
            java.lang.String r14 = r1.zzg
            android.content.res.Resources r15 = r1.zzh
            com.google.android.gms.ads.internal.overlay.zzl r8 = r1.zzi
            if (r9 == 0) goto L_0x0034
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            java.lang.String r2 = "dialog_action"
            java.lang.String r3 = "confirm"
            r7.put(r2, r3)
            java.lang.String r16 = "dialog_click"
            r2 = r10
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            r17 = r7
            r7 = r16
            r1 = r8
            r8 = r17
            com.google.android.gms.internal.ads.zzehp.zzd(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0035
        L_0x0034:
            r1 = r8
        L_0x0035:
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0040 }
            boolean r0 = r0.zzf(r2, r14, r13)     // Catch:{ RemoteException -> 0x0040 }
            if (r0 != 0) goto L_0x0055
            goto L_0x0046
        L_0x0040:
            r0 = move-exception
            java.lang.String r2 = "Failed to schedule offline notification poster."
            com.google.android.gms.internal.ads.zzciz.zzh(r2, r0)
        L_0x0046:
            r12.zzc(r13)
            if (r9 == 0) goto L_0x0055
            java.lang.String r7 = "offline_notification_worker_not_scheduled"
            r2 = r10
            r3 = r9
            r4 = r11
            r5 = r12
            r6 = r13
            com.google.android.gms.internal.ads.zzehp.zzc(r2, r3, r4, r5, r6, r7)
        L_0x0055:
            com.google.android.gms.ads.internal.zzt.zzp()
            com.google.android.gms.ads.internal.util.zzae r0 = com.google.android.gms.ads.internal.zzt.zzq()
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            int r0 = r0.zzk()
            r2.<init>(r10, r0)
            if (r15 != 0) goto L_0x006a
            java.lang.String r0 = "You'll get a notification with the link when you're back online"
            goto L_0x0070
        L_0x006a:
            int r0 = com.google.android.gms.ads.impl.R.string.offline_opt_in_confirmation
            java.lang.String r0 = r15.getString(r0)
        L_0x0070:
            android.app.AlertDialog$Builder r0 = r2.setMessage(r0)
            com.google.android.gms.internal.ads.zzehk r3 = new com.google.android.gms.internal.ads.zzehk
            r3.<init>(r1)
            r0.setOnCancelListener(r3)
            android.app.AlertDialog r0 = r2.create()
            r0.show()
            java.util.Timer r2 = new java.util.Timer
            r2.<init>()
            com.google.android.gms.internal.ads.zzeho r3 = new com.google.android.gms.internal.ads.zzeho
            r3.<init>(r0, r2, r1)
            r0 = 3000(0xbb8, double:1.482E-320)
            r2.schedule(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehm.onClick(android.content.DialogInterface, int):void");
    }
}
