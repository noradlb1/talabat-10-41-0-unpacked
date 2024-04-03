package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkForegroundRunnable implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public static final String f38147h = Logger.tagWithPrefix("WorkForegroundRunnable");

    /* renamed from: b  reason: collision with root package name */
    public final SettableFuture<Void> f38148b = SettableFuture.create();

    /* renamed from: c  reason: collision with root package name */
    public final Context f38149c;

    /* renamed from: d  reason: collision with root package name */
    public final WorkSpec f38150d;

    /* renamed from: e  reason: collision with root package name */
    public final ListenableWorker f38151e;

    /* renamed from: f  reason: collision with root package name */
    public final ForegroundUpdater f38152f;

    /* renamed from: g  reason: collision with root package name */
    public final TaskExecutor f38153g;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(@NonNull Context context, @NonNull WorkSpec workSpec, @NonNull ListenableWorker listenableWorker, @NonNull ForegroundUpdater foregroundUpdater, @NonNull TaskExecutor taskExecutor) {
        this.f38149c = context;
        this.f38150d = workSpec;
        this.f38151e = listenableWorker;
        this.f38152f = foregroundUpdater;
        this.f38153g = taskExecutor;
    }

    @NonNull
    public ListenableFuture<Void> getFuture() {
        return this.f38148b;
    }

    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f38150d.expedited || BuildCompat.isAtLeastS()) {
            this.f38148b.set(null);
            return;
        }
        final SettableFuture create = SettableFuture.create();
        this.f38153g.getMainThreadExecutor().execute(new Runnable() {
            public void run() {
                create.setFuture(WorkForegroundRunnable.this.f38151e.getForegroundInfoAsync());
            }
        });
        create.addListener(new Runnable() {
            public void run() {
                try {
                    ForegroundInfo foregroundInfo = (ForegroundInfo) create.get();
                    if (foregroundInfo != null) {
                        Logger.get().debug(WorkForegroundRunnable.f38147h, String.format("Updating notification for %s", new Object[]{WorkForegroundRunnable.this.f38150d.workerClassName}), new Throwable[0]);
                        WorkForegroundRunnable.this.f38151e.setRunInForeground(true);
                        WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                        workForegroundRunnable.f38148b.setFuture(workForegroundRunnable.f38152f.setForegroundAsync(workForegroundRunnable.f38149c, workForegroundRunnable.f38151e.getId(), foregroundInfo));
                        return;
                    }
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{WorkForegroundRunnable.this.f38150d.workerClassName}));
                } catch (Throwable th2) {
                    WorkForegroundRunnable.this.f38148b.setException(th2);
                }
            }
        }, this.f38153g.getMainThreadExecutor());
    }
}
