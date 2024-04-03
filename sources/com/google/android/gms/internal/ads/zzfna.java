package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfna {
    private final Context zza;
    private final Executor zzb;
    private final zzfmh zzc;
    private final zzfmj zzd;
    private final zzfmz zze;
    private final zzfmz zzf;
    private Task<zzajp> zzg;
    private Task<zzajp> zzh;

    @VisibleForTesting
    public zzfna(Context context, Executor executor, zzfmh zzfmh, zzfmj zzfmj, zzfmx zzfmx, zzfmy zzfmy) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzfmh;
        this.zzd = zzfmj;
        this.zze = zzfmx;
        this.zzf = zzfmy;
    }

    public static zzfna zze(@NonNull Context context, @NonNull Executor executor, @NonNull zzfmh zzfmh, @NonNull zzfmj zzfmj) {
        zzfna zzfna = new zzfna(context, executor, zzfmh, zzfmj, new zzfmx(), new zzfmy());
        if (zzfna.zzd.zzd()) {
            zzfna.zzg = zzfna.zzh(new zzfmv(zzfna));
        } else {
            zzfna.zzg = Tasks.forResult(zzfna.zze.zza());
        }
        zzfna.zzh = zzfna.zzh(new zzfmw(zzfna));
        return zzfna;
    }

    private static zzajp zzg(@NonNull Task<zzajp> task, @NonNull zzajp zzajp) {
        if (!task.isSuccessful()) {
            return zzajp;
        }
        return task.getResult();
    }

    private final Task<zzajp> zzh(@NonNull Callable<zzajp> callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzfmu(this));
    }

    public final zzajp zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzajp zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    public final /* synthetic */ zzajp zzc() throws Exception {
        Context context = this.zza;
        zzaiz zza2 = zzajp.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id2 = advertisingIdInfo.getId();
        if (id2 != null && id2.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id2);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id2 = Base64.encodeToString(bArr, 11);
        }
        if (id2 != null) {
            zza2.zzq(id2);
            zza2.zzp(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzW(6);
        }
        return (zzajp) zza2.zzah();
    }

    public final /* synthetic */ zzajp zzd() throws Exception {
        Context context = this.zza;
        return zzfmp.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
