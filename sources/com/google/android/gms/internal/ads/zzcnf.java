package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class zzcnf implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference<zzclh> zzc;

    public zzcnf(zzclh zzclh) {
        Context context = zzclh.getContext();
        this.zza = context;
        this.zzb = zzt.zzp().zzd(context, zzclh.zzp().zza);
        this.zzc = new WeakReference<>(zzclh);
    }

    public static /* bridge */ /* synthetic */ void zza(zzcnf zzcnf, String str, Map map) {
        zzclh zzclh = zzcnf.zzc.get();
        if (zzclh != null) {
            zzclh.zzd("onPrecacheEvent", map);
        }
    }

    public void release() {
    }

    public abstract void zzb();

    @VisibleForTesting
    public final void zzc(String str, @Nullable String str2, String str3, @Nullable String str4) {
        zzcis.zza.post(new zzcne(this, str, str2, str3, str4));
    }

    public final void zzd(String str, String str2, int i11) {
        zzcis.zza.post(new zzcnc(this, str, str2, i11));
    }

    @VisibleForTesting
    public final void zze(String str, String str2, long j11) {
        zzcis.zza.post(new zzcnd(this, str, str2, j11));
    }

    @VisibleForTesting
    public final void zzf(String str, String str2, int i11, int i12, long j11, long j12, boolean z11, int i13, int i14) {
        zzcis.zza.post(new zzcnb(this, str, str2, i11, i12, j11, j12, z11, i13, i14));
    }

    @VisibleForTesting
    public final void zzg(String str, String str2, long j11, long j12, boolean z11, long j13, long j14, long j15, int i11, int i12) {
        Handler handler = zzcis.zza;
        zzcna zzcna = r0;
        zzcna zzcna2 = new zzcna(this, str, str2, j11, j12, j13, j14, j15, z11, i11, i12);
        handler.post(zzcna);
    }

    public void zzh(int i11) {
    }

    public void zzn(int i11) {
    }

    public void zzo(int i11) {
    }

    public void zzp(int i11) {
    }

    public abstract boolean zzq(String str);

    public boolean zzr(String str, String[] strArr) {
        return zzq(str);
    }

    public boolean zzs(String str, String[] strArr, zzcmx zzcmx) {
        return zzq(str);
    }
}
