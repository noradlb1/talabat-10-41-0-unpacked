package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzfmh {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task<zzfoj> zzd;
    private final boolean zze;

    public zzfmh(@NonNull Context context, @NonNull Executor executor, @NonNull Task<zzfoj> task, boolean z11) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z11;
    }

    public static zzfmh zza(@NonNull Context context, @NonNull Executor executor, boolean z11) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z11) {
            executor.execute(new zzfmf(context, taskCompletionSource));
        } else {
            executor.execute(new zzfmg(taskCompletionSource));
        }
        return new zzfmh(context, executor, taskCompletionSource.getTask(), z11);
    }

    public static void zzg(int i11) {
        zzf = i11;
    }

    private final Task<Boolean> zzh(int i11, long j11, Exception exc, String str, Map<String, String> map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfme.zza);
        }
        zzail zza2 = zzaip.zza();
        zza2.zza(this.zzb.getPackageName());
        zza2.zze(j11);
        zza2.zzg(zzf);
        if (exc != null) {
            zza2.zzf(zzfqt.zza(exc));
            zza2.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zza2.zzb(str2);
        }
        if (str != null) {
            zza2.zzc(str);
        }
        return this.zzd.continueWith(this.zzc, new zzfmd(zza2, i11));
    }

    public final Task<Boolean> zzb(int i11, String str) {
        return zzh(i11, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzc(int i11, long j11, Exception exc) {
        return zzh(i11, j11, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzd(int i11, long j11) {
        return zzh(i11, j11, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zze(int i11, long j11, String str) {
        return zzh(i11, j11, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzf(int i11, long j11, String str, Map<String, String> map) {
        return zzh(i11, j11, (Exception) null, str, (Map<String, String>) null, (String) null);
    }
}
