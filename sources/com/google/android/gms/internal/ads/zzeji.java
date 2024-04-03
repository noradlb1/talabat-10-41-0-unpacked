package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Executor;

public final class zzeji implements zzeht<zzdmw> {
    private final Context zza;
    private final zzdnt zzb;
    private final Executor zzc;
    private final zzfdm zzd;

    public zzeji(Context context, Executor executor, zzdnt zzdnt, zzfdm zzfdm) {
        this.zza = context;
        this.zzb = zzdnt;
        this.zzc = executor;
        this.zzd = zzfdm;
    }

    private static String zzd(zzfdn zzfdn) {
        try {
            return zzfdn.zzw.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final zzfxa<zzdmw> zza(zzfdz zzfdz, zzfdn zzfdn) {
        Uri uri;
        String zzd2 = zzd(zzfdn);
        if (zzd2 != null) {
            uri = Uri.parse(zzd2);
        } else {
            uri = null;
        }
        return zzfwq.zzn(zzfwq.zzi(null), new zzejh(this, uri, zzfdz, zzfdn), this.zzc);
    }

    public final boolean zzb(zzfdz zzfdz, zzfdn zzfdn) {
        if (!(this.zza instanceof Activity) || !PlatformVersion.isAtLeastIceCreamSandwichMR1() || !zzbmh.zzg(this.zza) || TextUtils.isEmpty(zzd(zzfdn))) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ zzfxa zzc(Uri uri, zzfdz zzfdz, zzfdn zzfdn, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzu) null);
            zzcjr zzcjr = new zzcjr();
            zzdmx zze = this.zzb.zze(new zzdbk(zzfdz, zzfdn, (String) null), new zzdna(new zzejg(zzcjr), (zzcop) null));
            zzcjr.zzd(new AdOverlayInfoParcel(zzc2, (zzbes) null, zze.zza(), (zzw) null, new zzcjf(0, 0, false, false, false), (zzcop) null, (zzdmd) null));
            this.zzd.zza();
            return zzfwq.zzi(zze.zzg());
        } catch (Throwable th2) {
            zzciz.zzh("Error in CustomTabsAdRenderer", th2);
            throw th2;
        }
    }
}
