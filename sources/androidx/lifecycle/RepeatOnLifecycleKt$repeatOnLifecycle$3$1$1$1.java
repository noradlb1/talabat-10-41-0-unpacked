package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f36093b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Job> f36094c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f36095d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f36096e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f36097f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Mutex f36098g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f36099h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {171, 110}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public Object f36100h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36101i;

        /* renamed from: j  reason: collision with root package name */
        public int f36102j;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(mutex, function2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Throwable th2;
            Mutex mutex;
            Mutex mutex2;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f36102j;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex2 = mutex;
                function2 = function2;
                this.f36100h = mutex2;
                this.f36101i = function2;
                this.f36102j = 1;
                if (mutex2.lock((Object) null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i11 == 1) {
                function2 = (Function2) this.f36101i;
                ResultKt.throwOnFailure(obj);
                mutex2 = (Mutex) this.f36100h;
            } else if (i11 == 2) {
                mutex = (Mutex) this.f36100h;
                try {
                    ResultKt.throwOnFailure(obj);
                    Unit unit = Unit.INSTANCE;
                    mutex.unlock((Object) null);
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, (Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1>) null);
                this.f36100h = mutex2;
                this.f36101i = null;
                this.f36102j = 2;
                if (CoroutineScopeKt.coroutineScope(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                Unit unit2 = Unit.INSTANCE;
                mutex.unlock((Object) null);
                return Unit.INSTANCE;
            } catch (Throwable th4) {
                Throwable th5 = th4;
                mutex = mutex2;
                th2 = th5;
                mutex.unlock((Object) null);
                throw th2;
            }
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(Lifecycle.Event event, Ref.ObjectRef<Job> objectRef, CoroutineScope coroutineScope, Lifecycle.Event event2, CancellableContinuation<? super Unit> cancellableContinuation, Mutex mutex, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f36093b = event;
        this.f36094c = objectRef;
        this.f36095d = coroutineScope;
        this.f36096e = event2;
        this.f36097f = cancellableContinuation;
        this.f36098g = mutex;
        this.f36099h = function2;
    }

    public final void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == this.f36093b) {
            Ref.ObjectRef<Job> objectRef = this.f36094c;
            CoroutineScope coroutineScope = this.f36095d;
            final Mutex mutex = this.f36098g;
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f36099h;
            objectRef.element = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        if (event == this.f36096e) {
            Job job = (Job) this.f36094c.element;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.f36094c.element = null;
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            CancellableContinuation<Unit> cancellableContinuation = this.f36097f;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
    }
}
