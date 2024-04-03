package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String ARGUMENT_CLASS_NAME = "androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME";
    private static final String TAG = Logger.tagWithPrefix("ConstraintTrkngWrkr");

    /* renamed from: b  reason: collision with root package name */
    public final Object f38202b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f38203c = false;

    /* renamed from: d  reason: collision with root package name */
    public SettableFuture<ListenableWorker.Result> f38204d = SettableFuture.create();
    @Nullable
    private ListenableWorker mDelegate;
    private WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.mWorkerParameters = workerParameters;
    }

    public void a() {
        this.f38204d.set(ListenableWorker.Result.failure());
    }

    public void b() {
        this.f38204d.set(ListenableWorker.Result.retry());
    }

    public void c() {
        String string = getInputData().getString(ARGUMENT_CLASS_NAME);
        if (TextUtils.isEmpty(string)) {
            Logger.get().error(TAG, "No worker to delegate to.", new Throwable[0]);
            a();
            return;
        }
        ListenableWorker createWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.mWorkerParameters);
        this.mDelegate = createWorkerWithDefaultFallback;
        if (createWorkerWithDefaultFallback == null) {
            Logger.get().debug(TAG, "No worker to delegate to.", new Throwable[0]);
            a();
            return;
        }
        WorkSpec workSpec = getWorkDatabase().workSpecDao().getWorkSpec(getId().toString());
        if (workSpec == null) {
            a();
            return;
        }
        WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(getApplicationContext(), getTaskExecutor(), this);
        workConstraintsTracker.replace(Collections.singletonList(workSpec));
        if (workConstraintsTracker.areAllConstraintsMet(getId().toString())) {
            Logger.get().debug(TAG, String.format("Constraints met for delegate %s", new Object[]{string}), new Throwable[0]);
            try {
                final ListenableFuture<ListenableWorker.Result> startWork = this.mDelegate.startWork();
                startWork.addListener(new Runnable() {
                    public void run() {
                        synchronized (ConstraintTrackingWorker.this.f38202b) {
                            if (ConstraintTrackingWorker.this.f38203c) {
                                ConstraintTrackingWorker.this.b();
                            } else {
                                ConstraintTrackingWorker.this.f38204d.setFuture(startWork);
                            }
                        }
                    }
                }, getBackgroundExecutor());
            } catch (Throwable th2) {
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{string}), th2);
                synchronized (this.f38202b) {
                    if (this.f38203c) {
                        Logger.get().debug(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                        b();
                    } else {
                        a();
                    }
                }
            }
        } else {
            Logger.get().debug(TAG, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{string}), new Throwable[0]);
            b();
        }
    }

    @VisibleForTesting
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableWorker getDelegate() {
        return this.mDelegate;
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkTaskExecutor();
    }

    @VisibleForTesting
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return WorkManagerImpl.getInstance(getApplicationContext()).getWorkDatabase();
    }

    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.f38202b) {
            this.f38203c = true;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.mDelegate.stop();
        }
    }

    @NonNull
    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() {
            public void run() {
                ConstraintTrackingWorker.this.c();
            }
        });
        return this.f38204d;
    }
}
