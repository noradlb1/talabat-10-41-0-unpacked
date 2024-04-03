package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;
import com.huawei.hmf.tasks.a.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tasks {
    private static j IMPL = new j();

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> collection) {
        return j.a(collection);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... taskArr) {
        return j.a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        j.a("await must not be called on the UI thread");
        if (task.isComplete()) {
            return j.a(task);
        }
        j.a aVar = new j.a();
        task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
        aVar.f47725a.await();
        return j.a(task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j11, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        j.a("await must not be called on the UI thread");
        if (!task.isComplete()) {
            j.a aVar = new j.a();
            task.addOnSuccessListener(aVar).addOnFailureListener(aVar);
            if (!aVar.f47725a.await(j11, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return j.a(task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return IMPL.a(TaskExecutors.immediate(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return IMPL.a(TaskExecutors.a(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Executor executor, Callable<TResult> callable) {
        return IMPL.a(executor, callable);
    }

    public static <TResult> Task<TResult> fromCanceled() {
        i iVar = new i();
        iVar.a();
        return iVar;
    }

    public static <TResult> Task<TResult> fromException(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult tresult) {
        return j.a(tresult);
    }

    public static Task<Void> join(Collection<? extends Task<?>> collection) {
        return j.c(collection);
    }

    public static Task<Void> join(Task<?>... taskArr) {
        return j.c(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> collection) {
        return j.b(collection);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... taskArr) {
        return j.b(Arrays.asList(taskArr));
    }
}
