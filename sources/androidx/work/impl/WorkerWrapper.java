package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkerWrapper implements Runnable {

    /* renamed from: i  reason: collision with root package name */
    public static final String f38009i = Logger.tagWithPrefix("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    public Context f38010b;

    /* renamed from: c  reason: collision with root package name */
    public WorkSpec f38011c;

    /* renamed from: d  reason: collision with root package name */
    public ListenableWorker f38012d;

    /* renamed from: e  reason: collision with root package name */
    public TaskExecutor f38013e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public ListenableWorker.Result f38014f = ListenableWorker.Result.failure();
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public SettableFuture<Boolean> f38015g = SettableFuture.create();
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public ListenableFuture<ListenableWorker.Result> f38016h = null;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;
    private volatile boolean mInterrupted;
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    private WorkSpecDao mWorkSpecDao;
    private String mWorkSpecId;
    private WorkTagDao mWorkTagDao;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public Context f38023a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public ListenableWorker f38024b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public ForegroundProcessor f38025c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public TaskExecutor f38026d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public Configuration f38027e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public WorkDatabase f38028f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        public String f38029g;

        /* renamed from: h  reason: collision with root package name */
        public List<Scheduler> f38030h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public WorkerParameters.RuntimeExtras f38031i = new WorkerParameters.RuntimeExtras();

        public Builder(@NonNull Context context, @NonNull Configuration configuration, @NonNull TaskExecutor taskExecutor, @NonNull ForegroundProcessor foregroundProcessor, @NonNull WorkDatabase workDatabase, @NonNull String str) {
            this.f38023a = context.getApplicationContext();
            this.f38026d = taskExecutor;
            this.f38025c = foregroundProcessor;
            this.f38027e = configuration;
            this.f38028f = workDatabase;
            this.f38029g = str;
        }

        @NonNull
        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public Builder withRuntimeExtras(@Nullable WorkerParameters.RuntimeExtras runtimeExtras) {
            if (runtimeExtras != null) {
                this.f38031i = runtimeExtras;
            }
            return this;
        }

        @NonNull
        public Builder withSchedulers(@NonNull List<Scheduler> list) {
            this.f38030h = list;
            return this;
        }

        @VisibleForTesting
        @NonNull
        public Builder withWorker(@NonNull ListenableWorker listenableWorker) {
            this.f38024b = listenableWorker;
            return this;
        }
    }

    public WorkerWrapper(@NonNull Builder builder) {
        this.f38010b = builder.f38023a;
        this.f38013e = builder.f38026d;
        this.mForegroundProcessor = builder.f38025c;
        this.mWorkSpecId = builder.f38029g;
        this.mSchedulers = builder.f38030h;
        this.mRuntimeExtras = builder.f38031i;
        this.f38012d = builder.f38024b;
        this.mConfiguration = builder.f38027e;
        WorkDatabase workDatabase = builder.f38028f;
        this.mWorkDatabase = workDatabase;
        this.mWorkSpecDao = workDatabase.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mWorkTagDao = this.mWorkDatabase.workTagDao();
    }

    private String createWorkDescription(List<String> list) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.mWorkSpecId);
        sb2.append(", tags={ ");
        boolean z11 = true;
        for (String next : list) {
            if (z11) {
                z11 = false;
            } else {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    private void handleResult(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.Success) {
            Logger.get().info(f38009i, String.format("Worker result SUCCESS for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.f38011c.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                setSucceededAndResolve();
            }
        } else if (result instanceof ListenableWorker.Result.Retry) {
            Logger.get().info(f38009i, String.format("Worker result RETRY for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            rescheduleAndResolve();
        } else {
            Logger.get().info(f38009i, String.format("Worker result FAILURE for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
            if (this.f38011c.isPeriodic()) {
                resetPeriodicAndResolve();
            } else {
                b();
            }
        }
    }

    private void iterativelyFailWorkAndDependents(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.mWorkSpecDao.getState(str2) != WorkInfo.State.CANCELLED) {
                this.mWorkSpecDao.setState(WorkInfo.State.FAILED, str2);
            }
            linkedList.addAll(this.mDependencyDao.getDependentWorkIds(str2));
        }
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(true);
        }
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setPeriodStartTime(this.mWorkSpecId, System.currentTimeMillis());
            this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
            this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);
            this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    /* JADX INFO: finally extract failed */
    private void resolve(boolean z11) {
        ListenableWorker listenableWorker;
        this.mWorkDatabase.beginTransaction();
        try {
            if (!this.mWorkDatabase.workSpecDao().hasUnfinishedWork()) {
                PackageManagerHelper.setComponentEnabled(this.f38010b, RescheduleReceiver.class, false);
            }
            if (z11) {
                this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);
            }
            if (!(this.f38011c == null || (listenableWorker = this.f38012d) == null || !listenableWorker.isRunInForeground())) {
                this.mForegroundProcessor.stopForeground(this.mWorkSpecId);
            }
            this.mWorkDatabase.setTransactionSuccessful();
            this.mWorkDatabase.endTransaction();
            this.f38015g.set(Boolean.valueOf(z11));
        } catch (Throwable th2) {
            this.mWorkDatabase.endTransaction();
            throw th2;
        }
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == WorkInfo.State.RUNNING) {
            Logger.get().debug(f38009i, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            resolve(true);
            return;
        }
        Logger.get().debug(f38009i, String.format("Status for %s is %s; not doing any work", new Object[]{this.mWorkSpecId, state}), new Throwable[0]);
        resolve(false);
    }

    private void runWorker() {
        Data merge;
        boolean z11;
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkSpec workSpec = this.mWorkSpecDao.getWorkSpec(this.mWorkSpecId);
                this.f38011c = workSpec;
                if (workSpec == null) {
                    Logger.get().error(f38009i, String.format("Didn't find WorkSpec for id %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    resolve(false);
                    this.mWorkDatabase.setTransactionSuccessful();
                } else if (workSpec.state != WorkInfo.State.ENQUEUED) {
                    resolveIncorrectStatus();
                    this.mWorkDatabase.setTransactionSuccessful();
                    Logger.get().debug(f38009i, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f38011c.workerClassName}), new Throwable[0]);
                    this.mWorkDatabase.endTransaction();
                } else {
                    if (workSpec.isPeriodic() || this.f38011c.isBackedOff()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        WorkSpec workSpec2 = this.f38011c;
                        if (workSpec2.periodStartTime == 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11 && currentTimeMillis < workSpec2.calculateNextRunTime()) {
                            Logger.get().debug(f38009i, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f38011c.workerClassName}), new Throwable[0]);
                            resolve(true);
                            this.mWorkDatabase.setTransactionSuccessful();
                            this.mWorkDatabase.endTransaction();
                            return;
                        }
                    }
                    this.mWorkDatabase.setTransactionSuccessful();
                    this.mWorkDatabase.endTransaction();
                    if (this.f38011c.isPeriodic()) {
                        merge = this.f38011c.input;
                    } else {
                        InputMerger createInputMergerWithDefaultFallback = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.f38011c.inputMergerClassName);
                        if (createInputMergerWithDefaultFallback == null) {
                            Logger.get().error(f38009i, String.format("Could not create Input Merger %s", new Object[]{this.f38011c.inputMergerClassName}), new Throwable[0]);
                            b();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f38011c.input);
                        arrayList.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
                        merge = createInputMergerWithDefaultFallback.merge(arrayList);
                    }
                    WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.mWorkSpecId), merge, this.mTags, this.mRuntimeExtras, this.f38011c.runAttemptCount, this.mConfiguration.getExecutor(), this.f38013e, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.f38013e), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.f38013e));
                    if (this.f38012d == null) {
                        this.f38012d = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.f38010b, this.f38011c.workerClassName, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f38012d;
                    if (listenableWorker == null) {
                        Logger.get().error(f38009i, String.format("Could not create Worker %s", new Object[]{this.f38011c.workerClassName}), new Throwable[0]);
                        b();
                    } else if (listenableWorker.isUsed()) {
                        Logger.get().error(f38009i, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f38011c.workerClassName}), new Throwable[0]);
                        b();
                    } else {
                        this.f38012d.setUsed();
                        if (!trySetRunning()) {
                            resolveIncorrectStatus();
                        } else if (!tryCheckForInterruptionAndResolve()) {
                            final SettableFuture create = SettableFuture.create();
                            WorkForegroundRunnable workForegroundRunnable = new WorkForegroundRunnable(this.f38010b, this.f38011c, this.f38012d, workerParameters.getForegroundUpdater(), this.f38013e);
                            this.f38013e.getMainThreadExecutor().execute(workForegroundRunnable);
                            final ListenableFuture<Void> future = workForegroundRunnable.getFuture();
                            future.addListener(new Runnable() {
                                public void run() {
                                    try {
                                        future.get();
                                        Logger.get().debug(WorkerWrapper.f38009i, String.format("Starting work for %s", new Object[]{WorkerWrapper.this.f38011c.workerClassName}), new Throwable[0]);
                                        WorkerWrapper workerWrapper = WorkerWrapper.this;
                                        workerWrapper.f38016h = workerWrapper.f38012d.startWork();
                                        create.setFuture(WorkerWrapper.this.f38016h);
                                    } catch (Throwable th2) {
                                        create.setException(th2);
                                    }
                                }
                            }, this.f38013e.getMainThreadExecutor());
                            final String str = this.mWorkDescription;
                            create.addListener(new Runnable() {
                                @SuppressLint({"SyntheticAccessor"})
                                public void run() {
                                    try {
                                        ListenableWorker.Result result = (ListenableWorker.Result) create.get();
                                        if (result == null) {
                                            Logger.get().error(WorkerWrapper.f38009i, String.format("%s returned a null result. Treating it as a failure.", new Object[]{WorkerWrapper.this.f38011c.workerClassName}), new Throwable[0]);
                                        } else {
                                            Logger.get().debug(WorkerWrapper.f38009i, String.format("%s returned a %s result.", new Object[]{WorkerWrapper.this.f38011c.workerClassName, result}), new Throwable[0]);
                                            WorkerWrapper.this.f38014f = result;
                                        }
                                    } catch (CancellationException e11) {
                                        Logger.get().info(WorkerWrapper.f38009i, String.format("%s was cancelled", new Object[]{str}), e11);
                                    } catch (InterruptedException | ExecutionException e12) {
                                        Logger.get().error(WorkerWrapper.f38009i, String.format("%s failed because it threw an exception/error", new Object[]{str}), e12);
                                    } catch (Throwable th2) {
                                        WorkerWrapper.this.a();
                                        throw th2;
                                    }
                                    WorkerWrapper.this.a();
                                }
                            }, this.f38013e.getBackgroundExecutor());
                        }
                    }
                }
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        try {
            this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Success) this.f38014f).getOutputData());
            long currentTimeMillis = System.currentTimeMillis();
            for (String next : this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId)) {
                if (this.mWorkSpecDao.getState(next) == WorkInfo.State.BLOCKED && this.mDependencyDao.hasCompletedAllPrerequisites(next)) {
                    Logger.get().info(f38009i, String.format("Setting status to enqueued for %s", new Object[]{next}), new Throwable[0]);
                    this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, next);
                    this.mWorkSpecDao.setPeriodStartTime(next, currentTimeMillis);
                }
            }
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (!this.mInterrupted) {
            return false;
        }
        Logger.get().debug(f38009i, String.format("Work interrupted for %s", new Object[]{this.mWorkDescription}), new Throwable[0]);
        WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (state == null) {
            resolve(false);
        } else {
            resolve(!state.isFinished());
        }
        return true;
    }

    private boolean trySetRunning() {
        this.mWorkDatabase.beginTransaction();
        try {
            boolean z11 = false;
            if (this.mWorkSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.ENQUEUED) {
                this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);
                this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);
                z11 = true;
            }
            this.mWorkDatabase.setTransactionSuccessful();
            return z11;
        } finally {
            this.mWorkDatabase.endTransaction();
        }
    }

    public void a() {
        if (!tryCheckForInterruptionAndResolve()) {
            this.mWorkDatabase.beginTransaction();
            try {
                WorkInfo.State state = this.mWorkSpecDao.getState(this.mWorkSpecId);
                this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);
                if (state == null) {
                    resolve(false);
                } else if (state == WorkInfo.State.RUNNING) {
                    handleResult(this.f38014f);
                } else if (!state.isFinished()) {
                    rescheduleAndResolve();
                }
                this.mWorkDatabase.setTransactionSuccessful();
            } finally {
                this.mWorkDatabase.endTransaction();
            }
        }
        List<Scheduler> list = this.mSchedulers;
        if (list != null) {
            for (Scheduler cancel : list) {
                cancel.cancel(this.mWorkSpecId);
            }
            Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        }
    }

    @VisibleForTesting
    public void b() {
        this.mWorkDatabase.beginTransaction();
        try {
            iterativelyFailWorkAndDependents(this.mWorkSpecId);
            this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Failure) this.f38014f).getOutputData());
            this.mWorkDatabase.setTransactionSuccessful();
        } finally {
            this.mWorkDatabase.endTransaction();
            resolve(false);
        }
    }

    @NonNull
    public ListenableFuture<Boolean> getFuture() {
        return this.f38015g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void interrupt() {
        boolean z11;
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        ListenableFuture<ListenableWorker.Result> listenableFuture = this.f38016h;
        if (listenableFuture != null) {
            z11 = listenableFuture.isDone();
            this.f38016h.cancel(true);
        } else {
            z11 = false;
        }
        ListenableWorker listenableWorker = this.f38012d;
        if (listenableWorker == null || z11) {
            Logger.get().debug(f38009i, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f38011c}), new Throwable[0]);
            return;
        }
        listenableWorker.stop();
    }

    @WorkerThread
    public void run() {
        List<String> tagsForWorkSpecId = this.mWorkTagDao.getTagsForWorkSpecId(this.mWorkSpecId);
        this.mTags = tagsForWorkSpecId;
        this.mWorkDescription = createWorkDescription(tagsForWorkSpecId);
        runWorker();
    }
}
