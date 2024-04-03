package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Continuation;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.TaskExecutors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class j {

    public static class a<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {

        /* renamed from: a  reason: collision with root package name */
        public final CountDownLatch f47725a = new CountDownLatch(1);

        public final void onCanceled() {
            this.f47725a.countDown();
        }

        public final void onFailure(Exception exc) {
            this.f47725a.countDown();
        }

        public final void onSuccess(TResult tresult) {
            this.f47725a.countDown();
        }
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(tresult);
        return taskCompletionSource.getTask();
    }

    public static Task<List<Task<?>>> a(final Collection<? extends Task<?>> collection) {
        return c(collection).continueWith(new Continuation<Void, List<Task<?>>>() {
            public final /* synthetic */ Object then(Task task) throws Exception {
                ArrayList arrayList = new ArrayList(collection.size());
                arrayList.addAll(collection);
                return arrayList;
            }
        });
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    public static void a(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <TResult> Task<List<TResult>> b(final Collection<? extends Task<?>> collection) {
        return c(collection).continueWith(new Continuation<Void, List<TResult>>() {
            public final /* synthetic */ Object then(Task task) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (Task result : collection) {
                    arrayList.add(result.getResult());
                }
                return arrayList;
            }
        });
    }

    public static Task<Void> c(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("task can not is null");
            }
        }
        i iVar = new i();
        e eVar = new e(collection.size(), iVar);
        for (Task task2 : collection) {
            task2.addOnSuccessListener(TaskExecutors.immediate(), eVar);
            task2.addOnFailureListener(TaskExecutors.immediate(), (OnFailureListener) eVar);
            task2.addOnCanceledListener(TaskExecutors.immediate(), (OnCanceledListener) eVar);
        }
        return iVar;
    }

    public final <TResult> Task<TResult> a(Executor executor, final Callable<TResult> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() {
                public final void run() {
                    try {
                        taskCompletionSource.setResult(callable.call());
                    } catch (Exception e11) {
                        taskCompletionSource.setException(e11);
                    }
                }
            });
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
        return taskCompletionSource.getTask();
    }
}
