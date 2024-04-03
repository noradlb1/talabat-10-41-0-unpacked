package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdzw implements zzdhm, zzbes, zzder, zzdfl, zzdfm, zzdgf, zzdeu, zzaop, zzfif {
    private final List<Object> zza;
    private final zzdzk zzb;
    private long zzc;

    public zzdzw(zzdzk zzdzk, zzcqm zzcqm) {
        this.zzb = zzdzk;
        this.zza = Collections.singletonList(zzcqm);
    }

    private final void zzf(Class<?> cls, String str, Object... objArr) {
        zzdzk zzdzk = this.zzb;
        List<Object> list = this.zza;
        String simpleName = cls.getSimpleName();
        zzdzk.zza(list, simpleName.length() != 0 ? "Event-".concat(simpleName) : new String("Event-"), str, objArr);
    }

    public final void onAdClicked() {
        zzf(zzbes.class, "onAdClicked", new Object[0]);
    }

    public final void zza(zzbew zzbew) {
        zzf(zzdeu.class, "onAdFailedToLoad", Integer.valueOf(zzbew.zza), zzbew.zzb, zzbew.zzc);
    }

    public final void zzb(zzfhy zzfhy, String str, Throwable th2) {
        zzf(zzfhx.class, "onTaskFailed", str, th2.getClass().getSimpleName());
    }

    public final void zzbA(Context context) {
        zzf(zzdfm.class, "onPause", context);
    }

    public final void zzbB(Context context) {
        zzf(zzdfm.class, "onResume", context);
    }

    public final void zzbC(String str, String str2) {
        zzf(zzaop.class, "onAppEvent", str, str2);
    }

    public final void zzbD() {
        zzf(zzder.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzbN(zzfhy zzfhy, String str) {
        zzf(zzfhx.class, "onTaskCreated", str);
    }

    public final void zzbO(zzfhy zzfhy, String str) {
        zzf(zzfhx.class, "onTaskSucceeded", str);
    }

    public final void zzby(Context context) {
        zzf(zzdfm.class, "onDestroy", context);
    }

    public final void zzc(zzfhy zzfhy, String str) {
        zzf(zzfhx.class, "onTaskStarted", str);
    }

    public final void zzd(zzcdq zzcdq) {
        this.zzc = zzt.zzA().elapsedRealtime();
        zzf(zzdhm.class, "onAdRequest", new Object[0]);
    }

    public final void zze(zzfdz zzfdz) {
    }

    public final void zzj() {
        zzf(zzder.class, "onAdClosed", new Object[0]);
    }

    public final void zzl() {
        zzf(zzdfl.class, "onAdImpression", new Object[0]);
    }

    public final void zzm() {
        zzf(zzder.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzn() {
        long elapsedRealtime = zzt.zzA().elapsedRealtime();
        long j11 = this.zzc;
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("Ad Request Latency : ");
        sb2.append(elapsedRealtime - j11);
        zze.zza(sb2.toString());
        zzf(zzdgf.class, "onAdLoaded", new Object[0]);
    }

    public final void zzo() {
        zzf(zzder.class, "onAdOpened", new Object[0]);
    }

    @ParametersAreNonnullByDefault
    public final void zzp(zzceg zzceg, String str, String str2) {
        zzf(zzder.class, "onRewarded", zzceg, str, str2);
    }

    public final void zzr() {
        zzf(zzder.class, "onRewardedVideoStarted", new Object[0]);
    }
}
