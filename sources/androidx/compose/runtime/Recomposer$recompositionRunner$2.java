package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.ObserverHandle;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", i = {0, 0}, l = {882}, m = "invokeSuspend", n = {"callingJob", "unregisterApplyObserver"}, s = {"L$0", "L$1"})
public final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f9166h;

    /* renamed from: i  reason: collision with root package name */
    public int f9167i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9168j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> f9169k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MonotonicFrameClock f9170l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$2", f = "Recomposer.kt", i = {}, l = {883}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f9171h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 r02 = new AnonymousClass2(function3, monotonicFrameClock, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f9171h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = function3;
                MonotonicFrameClock monotonicFrameClock = monotonicFrameClock;
                this.f9171h = 1;
                if (function3.invoke((CoroutineScope) this.L$0, monotonicFrameClock, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, MonotonicFrameClock monotonicFrameClock, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.f9168j = recomposer;
        this.f9169k = function3;
        this.f9170l = monotonicFrameClock;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.f9168j, this.f9169k, this.f9170l, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th2;
        Job job;
        ObserverHandle observerHandle;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9167i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            job = JobKt.getJob(((CoroutineScope) this.L$0).getCoroutineContext());
            this.f9168j.registerRunnerJob(job);
            ObserverHandle registerApplyObserver = Snapshot.Companion.registerApplyObserver(new Recomposer$recompositionRunner$2$unregisterApplyObserver$1(this.f9168j));
            Recomposer.Companion.addRunning(this.f9168j.recomposerInfo);
            try {
                Object access$getStateLock$p = this.f9168j.stateLock;
                Recomposer recomposer = this.f9168j;
                synchronized (access$getStateLock$p) {
                    List access$getKnownCompositions$p = recomposer.knownCompositions;
                    int size = access$getKnownCompositions$p.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        ((ControlledComposition) access$getKnownCompositions$p.get(i12)).invalidateAll();
                    }
                    Unit unit = Unit.INSTANCE;
                }
                final Function3<CoroutineScope, MonotonicFrameClock, Continuation<? super Unit>, Object> function3 = this.f9169k;
                final MonotonicFrameClock monotonicFrameClock = this.f9170l;
                AnonymousClass2 r42 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
                this.L$0 = job;
                this.f9166h = registerApplyObserver;
                this.f9167i = 1;
                if (CoroutineScopeKt.coroutineScope(r42, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                observerHandle = registerApplyObserver;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                observerHandle = registerApplyObserver;
                th2 = th4;
                observerHandle.dispose();
                Object access$getStateLock$p2 = this.f9168j.stateLock;
                Recomposer recomposer2 = this.f9168j;
                synchronized (access$getStateLock$p2) {
                    if (recomposer2.runnerJob == job) {
                        recomposer2.runnerJob = null;
                    }
                    CancellableContinuation unused = recomposer2.deriveStateLocked();
                }
                Recomposer.Companion.removeRunning(this.f9168j.recomposerInfo);
                throw th2;
            }
        } else if (i11 == 1) {
            observerHandle = (ObserverHandle) this.f9166h;
            job = (Job) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th2 = th5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        observerHandle.dispose();
        Object access$getStateLock$p3 = this.f9168j.stateLock;
        Recomposer recomposer3 = this.f9168j;
        synchronized (access$getStateLock$p3) {
            if (recomposer3.runnerJob == job) {
                recomposer3.runnerJob = null;
            }
            CancellableContinuation unused2 = recomposer3.deriveStateLocked();
        }
        Recomposer.Companion.removeRunning(this.f9168j.recomposerInfo);
        return Unit.INSTANCE;
    }
}
