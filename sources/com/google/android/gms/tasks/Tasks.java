package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad((zzac) null);
        zzb(task, zzad);
        zzad.zza();
        return zza(task);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        zzw zzw = new zzw();
        zzw.zzc();
        return zzw;
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzw zzw = new zzw();
        zzw.zza(exc);
        return zzw;
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzw zzw = new zzw();
        zzw.zzb(tresult);
        return zzw;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzw = new zzw();
        zzaf zzaf = new zzaf(collection.size(), zzw);
        for (Task zzb : collection) {
            zzb(zzb, zzaf);
        }
        return zzw;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(TaskExecutors.MAIN_THREAD, new zzab(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll((Collection<? extends Task<?>>) collection).continueWith(TaskExecutors.MAIN_THREAD, new zzaa(collection));
    }

    @NonNull
    public static <T> Task<T> withTimeout(@NonNull Task<T> task, long j11, @NonNull TimeUnit timeUnit) {
        boolean z11;
        Preconditions.checkNotNull(task, "Task must not be null");
        if (j11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "Timeout must be positive");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        zzb zzb = new zzb();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(zzb);
        zza zza = new zza(Looper.getMainLooper());
        zza.postDelayed(new zzx(taskCompletionSource), timeUnit.toMillis(j11));
        task.addOnCompleteListener(new zzy(zza, taskCompletionSource, zzb));
        return taskCompletionSource.getTask();
    }

    private static Object zza(@NonNull Task task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void zzb(Task task, zzae zzae) {
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, zzae);
        task.addOnFailureListener(executor, (OnFailureListener) zzae);
        task.addOnCanceledListener(executor, (OnCanceledListener) zzae);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzw zzw = new zzw();
        executor.execute(new zzz(zzw, callable));
        return zzw;
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j11, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zzad zzad = new zzad((zzac) null);
        zzb(task, zzad);
        if (zzad.zzb(j11, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }
}
