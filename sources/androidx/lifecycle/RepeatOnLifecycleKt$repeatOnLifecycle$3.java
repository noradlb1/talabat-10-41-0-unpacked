package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36078h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f36079i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f36080j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f36081k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public Object f36082h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36083i;

        /* renamed from: j  reason: collision with root package name */
        public Object f36084j;

        /* renamed from: k  reason: collision with root package name */
        public Object f36085k;

        /* renamed from: l  reason: collision with root package name */
        public Object f36086l;

        /* renamed from: m  reason: collision with root package name */
        public Object f36087m;

        /* renamed from: n  reason: collision with root package name */
        public int f36088n;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(lifecycle, state, coroutineScope, function2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.f36088n
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0038
                if (r2 != r4) goto L_0x0030
                java.lang.Object r0 = r1.f36087m
                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                java.lang.Object r0 = r1.f36086l
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                java.lang.Object r0 = r1.f36085k
                androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                java.lang.Object r0 = r1.f36084j
                androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                java.lang.Object r0 = r1.f36083i
                r2 = r0
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r0 = r1.f36082h
                r5 = r0
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
                kotlin.ResultKt.throwOnFailure(r17)     // Catch:{ all -> 0x002d }
                goto L_0x00a4
            L_0x002d:
                r0 = move-exception
                goto L_0x00bf
            L_0x0030:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0038:
                kotlin.ResultKt.throwOnFailure(r17)
                androidx.lifecycle.Lifecycle r2 = r4
                androidx.lifecycle.Lifecycle$State r2 = r2.getCurrentState()
                androidx.lifecycle.Lifecycle$State r5 = androidx.lifecycle.Lifecycle.State.DESTROYED
                if (r2 != r5) goto L_0x0048
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x0048:
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
                r13.<init>()
                androidx.lifecycle.Lifecycle$State r5 = r5     // Catch:{ all -> 0x00bc }
                androidx.lifecycle.Lifecycle r14 = r4     // Catch:{ all -> 0x00bc }
                kotlinx.coroutines.CoroutineScope r8 = r6     // Catch:{ all -> 0x00bc }
                kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r12 = r7     // Catch:{ all -> 0x00bc }
                r1.f36082h = r2     // Catch:{ all -> 0x00bc }
                r1.f36083i = r13     // Catch:{ all -> 0x00bc }
                r1.f36084j = r5     // Catch:{ all -> 0x00bc }
                r1.f36085k = r14     // Catch:{ all -> 0x00bc }
                r1.f36086l = r8     // Catch:{ all -> 0x00bc }
                r1.f36087m = r12     // Catch:{ all -> 0x00bc }
                r1.f36088n = r4     // Catch:{ all -> 0x00bc }
                kotlinx.coroutines.CancellableContinuationImpl r15 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x00bc }
                kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r16)     // Catch:{ all -> 0x00bc }
                r15.<init>(r6, r4)     // Catch:{ all -> 0x00bc }
                r15.initCancellability()     // Catch:{ all -> 0x00bc }
                androidx.lifecycle.Lifecycle$Event r6 = androidx.lifecycle.Lifecycle.Event.upTo(r5)     // Catch:{ all -> 0x00bc }
                androidx.lifecycle.Lifecycle$Event r9 = androidx.lifecycle.Lifecycle.Event.downFrom(r5)     // Catch:{ all -> 0x00bc }
                r5 = 0
                kotlinx.coroutines.sync.Mutex r11 = kotlinx.coroutines.sync.MutexKt.Mutex$default(r5, r4, r3)     // Catch:{ all -> 0x00bc }
                androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r10 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch:{ all -> 0x00bc }
                r5 = r10
                r7 = r2
                r3 = r10
                r10 = r15
                r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00bc }
                r13.element = r3     // Catch:{ all -> 0x00bc }
                r10 = r3
                androidx.lifecycle.LifecycleEventObserver r10 = (androidx.lifecycle.LifecycleEventObserver) r10     // Catch:{ all -> 0x00bc }
                r14.addObserver(r10)     // Catch:{ all -> 0x00bc }
                java.lang.Object r3 = r15.getResult()     // Catch:{ all -> 0x00bc }
                java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00bc }
                if (r3 != r5) goto L_0x009f
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r16)     // Catch:{ all -> 0x00bc }
            L_0x009f:
                if (r3 != r0) goto L_0x00a2
                return r0
            L_0x00a2:
                r5 = r2
                r2 = r13
            L_0x00a4:
                T r0 = r5.element
                kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
                if (r0 == 0) goto L_0x00ae
                r3 = 0
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r0, (java.util.concurrent.CancellationException) r3, (int) r4, (java.lang.Object) r3)
            L_0x00ae:
                T r0 = r2.element
                androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                if (r0 == 0) goto L_0x00b9
                androidx.lifecycle.Lifecycle r2 = r4
                r2.removeObserver(r0)
            L_0x00b9:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x00bc:
                r0 = move-exception
                r5 = r2
                r2 = r13
            L_0x00bf:
                T r3 = r5.element
                kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
                if (r3 == 0) goto L_0x00c9
                r5 = 0
                kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r3, (java.util.concurrent.CancellationException) r5, (int) r4, (java.lang.Object) r5)
            L_0x00c9:
                T r2 = r2.element
                androidx.lifecycle.LifecycleEventObserver r2 = (androidx.lifecycle.LifecycleEventObserver) r2
                if (r2 == 0) goto L_0x00d4
                androidx.lifecycle.Lifecycle r3 = r4
                r3.removeObserver(r2)
            L_0x00d4:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.f36079i = lifecycle;
        this.f36080j = state;
        this.f36081k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f36079i, this.f36080j, this.f36081k, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36078h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            MainCoroutineDispatcher immediate = Dispatchers.getMain().getImmediate();
            final Lifecycle lifecycle = this.f36079i;
            final Lifecycle.State state = this.f36080j;
            final Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f36081k;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f36078h = 1;
            if (BuildersKt.withContext(immediate, r32, this) == coroutine_suspended) {
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
