package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzcgg implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private final zzchh zzd;
    private String zze = "-1";
    private int zzf = -1;

    public zzcgg(Context context, zzg zzg, zzchh zzchh) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
        this.zzd = zzchh;
    }

    private final void zzb(String str, int i11) {
        Context context;
        boolean z11 = false;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaq)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i11 == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1"))) {
            z11 = true;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzao)).booleanValue()) {
            this.zzc.zzD(z11);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue() && z11 && (context = this.zza) != null) {
                context.deleteDatabase("OfflineUpload.db");
            }
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaj)).booleanValue()) {
            this.zzd.zzt();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "IABTCF_PurposeConsents"
            java.lang.String r1 = "-1"
            java.lang.String r2 = r9.getString(r0, r1)
            java.lang.String r3 = "gad_has_consent_for_cookies"
            r4 = -1
            int r9 = r9.getInt(r3, r4)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r5 = r10.hashCode()
            r6 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            r7 = 1
            if (r5 == r6) goto L_0x002b
            r0 = -527267622(0xffffffffe09288da, float:-8.447143E19)
            if (r5 == r0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x0033
            r10 = r7
            goto L_0x0034
        L_0x002b:
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0033
            r10 = 0
            goto L_0x0034
        L_0x0033:
            r10 = r4
        L_0x0034:
            if (r10 == 0) goto L_0x0057
            if (r10 == r7) goto L_0x0039
            return
        L_0x0039:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r10 = com.google.android.gms.internal.ads.zzblj.zzaq
            com.google.android.gms.internal.ads.zzblh r0 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r10 = r0.zzb(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x006a
            if (r9 == r4) goto L_0x006a
            int r10 = r8.zzf
            if (r10 == r9) goto L_0x006a
            r8.zzf = r9
            r8.zzb(r2, r9)
            return
        L_0x0057:
            boolean r10 = r2.equals(r1)
            if (r10 != 0) goto L_0x006a
            java.lang.String r10 = r8.zze
            boolean r10 = r10.equals(r2)
            if (r10 != 0) goto L_0x006a
            r8.zze = r2
            r8.zzb(r2, r9)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgg.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
    }
}
