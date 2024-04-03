package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzccj {
    @GuardedBy("InternalQueryInfoGenerator.class")
    private static zzcht zza;
    private final Context zzb;
    private final AdFormat zzc;
    @Nullable
    private final zzbjg zzd;

    public zzccj(Context context, AdFormat adFormat, @Nullable zzbjg zzbjg) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzbjg;
    }

    @Nullable
    public static zzcht zza(Context context) {
        zzcht zzcht;
        synchronized (zzccj.class) {
            if (zza == null) {
                zza = zzbgo.zza().zzq(context, new zzbxe());
            }
            zzcht = zza;
        }
        return zzcht;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzbfd zzbfd;
        zzcht zza2 = zza(this.zzb);
        if (zza2 == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzb);
        zzbjg zzbjg = this.zzd;
        if (zzbjg == null) {
            zzbfd = new zzbfe().zza();
        } else {
            zzbfd = zzbfh.zza.zza(this.zzb, zzbjg);
        }
        try {
            zza2.zze(wrap, new zzchx((String) null, this.zzc.name(), (zzbfi) null, zzbfd), new zzcci(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
