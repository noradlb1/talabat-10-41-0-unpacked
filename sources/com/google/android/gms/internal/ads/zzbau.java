package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Future;
import javax.annotation.concurrent.GuardedBy;

public final class zzbau {
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzbaj zza;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Object zzd = new Object();

    public zzbau(Context context) {
        this.zzc = context;
    }

    public static /* bridge */ /* synthetic */ void zze(zzbau zzbau) {
        synchronized (zzbau.zzd) {
            zzbaj zzbaj = zzbau.zza;
            if (zzbaj != null) {
                zzbaj.disconnect();
                zzbau.zza = null;
                Binder.flushPendingCommands();
            }
        }
    }

    public final Future<zzbaw> zzc(zzbak zzbak) {
        zzbao zzbao = new zzbao(this);
        zzbas zzbas = new zzbas(this, zzbak, zzbao);
        zzbat zzbat = new zzbat(this, zzbao);
        synchronized (this.zzd) {
            zzbaj zzbaj = new zzbaj(this.zzc, zzt.zzt().zzb(), zzbas, zzbat);
            this.zza = zzbaj;
            zzbaj.checkAvailabilityAndConnect();
        }
        return zzbao;
    }
}
