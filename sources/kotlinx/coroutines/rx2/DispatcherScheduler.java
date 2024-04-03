package kotlinx.coroutines.rx2;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00020!:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "Lio/reactivex/Scheduler$Worker;", "createWorker", "()Lio/reactivex/Scheduler$Worker;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "Lio/reactivex/disposables/Disposable;", "scheduleDirect", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lio/reactivex/disposables/Disposable;", "", "shutdown", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "DispatcherWorker", "kotlinx-coroutines-rx2", "Lio/reactivex/Scheduler;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DispatcherScheduler extends Scheduler {
    private static final /* synthetic */ AtomicLongFieldUpdater workerCounter$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter");
    @NotNull
    @JvmField
    public final CoroutineDispatcher dispatcher;
    @NotNull
    private final CompletableJob schedulerJob;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineScope scope;
    @NotNull
    private volatile /* synthetic */ long workerCounter = 1;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R-\u0010\t\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b0\nX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lkotlinx/coroutines/rx2/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/Scheduler$Worker;", "counter", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "parentJob", "Lkotlinx/coroutines/Job;", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "isDisposed", "", "schedule", "Lio/reactivex/disposables/Disposable;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "delay", "unit", "Ljava/util/concurrent/TimeUnit;", "toString", "", "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DispatcherWorker extends Scheduler.Worker {
        /* access modifiers changed from: private */
        @NotNull
        public final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        private final long counter;
        @NotNull
        private final CoroutineDispatcher dispatcher;
        @NotNull
        private final CompletableJob workerJob;
        @NotNull
        private final CoroutineScope workerScope;

        public DispatcherWorker(long j11, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Job job) {
            this.counter = j11;
            this.dispatcher = coroutineDispatcher;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(job);
            this.workerJob = SupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob.plus(coroutineDispatcher));
            this.workerScope = CoroutineScope;
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>(this, (Continuation<? super AnonymousClass1>) null) {

                /* renamed from: h  reason: collision with root package name */
                public Object f26268h;

                /* renamed from: i  reason: collision with root package name */
                public Object f26269i;

                /* renamed from: j  reason: collision with root package name */
                public int f26270j;

                /* renamed from: k  reason: collision with root package name */
                public final /* synthetic */ DispatcherWorker f26271k;

                {
                    this.f26271k = r1;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return 

                    public DispatcherScheduler(@NotNull CoroutineDispatcher coroutineDispatcher) {
                        this.dispatcher = coroutineDispatcher;
                        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
                        this.schedulerJob = SupervisorJob$default;
                        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(coroutineDispatcher));
                    }

                    @NotNull
                    public Scheduler.Worker createWorker() {
                        return new DispatcherWorker(workerCounter$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
                    }

                    @NotNull
                    public Disposable scheduleDirect(@NotNull Runnable runnable, long j11, @NotNull TimeUnit timeUnit) {
                        return RxSchedulerKt.scheduleTask(this.scope, runnable, timeUnit.toMillis(j11), new DispatcherScheduler$scheduleDirect$1(this));
                    }

                    public void shutdown() {
                        Job.DefaultImpls.cancel$default((Job) this.schedulerJob, (CancellationException) null, 1, (Object) null);
                    }

                    @NotNull
                    public String toString() {
                        return this.dispatcher.toString();
                    }
                }
