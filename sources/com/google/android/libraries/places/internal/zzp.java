package com.google.android.libraries.places.internal;

import android.location.Location;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public final class zzp {
    private static final long zza;
    private static final long zzb;
    private static final long zzc;
    private final zza zzd;
    private final FusedLocationProviderClient zze;
    private final zzcq zzf;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zza = timeUnit.toMillis(10);
        zzb = timeUnit.toNanos(24);
        zzc = timeUnit.toMillis(59);
    }

    public zzp(zza zza2, FusedLocationProviderClient fusedLocationProviderClient, zzcq zzcq) {
        this.zzd = zza2;
        this.zze = fusedLocationProviderClient;
        this.zzf = zzcq;
    }

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    public final Task<Location> zza(@Nullable CancellationToken cancellationToken) {
        TaskCompletionSource taskCompletionSource;
        zzcq zzcq = this.zzf;
        Task<Location> lastLocation = this.zze.getLastLocation();
        long j11 = zza;
        if (cancellationToken == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        }
        zzcq.zza(taskCompletionSource, j11, "Location timeout.");
        lastLocation.continueWithTask(new zzcn(zzcq, taskCompletionSource));
        taskCompletionSource.getTask().addOnCompleteListener(new zzco(zzcq, taskCompletionSource));
        return taskCompletionSource.getTask().continueWithTask(new zzl(this, cancellationToken));
    }

    public final /* synthetic */ Task zzb(CancellationToken cancellationToken, Task task) throws Exception {
        TaskCompletionSource taskCompletionSource;
        if (task.isSuccessful()) {
            zza zza2 = this.zzd;
            Location location = (Location) task.getResult();
            if (location != null && zza2.zzb() - location.getElapsedRealtimeNanos() <= zzb) {
                return task;
            }
        }
        if (cancellationToken != null) {
            taskCompletionSource = new TaskCompletionSource(cancellationToken);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        LocationRequest priority = LocationRequest.create().setPriority(100);
        long j11 = zza;
        LocationRequest numUpdates = priority.setExpirationDuration(j11).setInterval(zzc).setFastestInterval(10).setNumUpdates(1);
        zzo zzo = new zzo(this, taskCompletionSource);
        this.zze.requestLocationUpdates(numUpdates, (LocationCallback) zzo, Looper.getMainLooper()).continueWithTask(new zzm(this, taskCompletionSource));
        this.zzf.zza(taskCompletionSource, j11, "Location timeout.");
        taskCompletionSource.getTask().addOnCompleteListener(new zzn(this, zzo, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final /* synthetic */ void zzc(LocationCallback locationCallback, TaskCompletionSource taskCompletionSource, Task task) {
        this.zze.removeLocationUpdates(locationCallback);
        this.zzf.zzb(taskCompletionSource);
    }
}
