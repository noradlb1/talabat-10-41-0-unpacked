package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
public final class RemoteMediatorAccessImpl$launchBoundary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37060h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RemoteMediatorAccessImpl f37061i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Key", "", "Value", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {342}, m = "invokeSuspend", n = {"loadType"}, s = {"L$0"})
    /* renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public Object f37062h;

        /* renamed from: i  reason: collision with root package name */
        public int f37063i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ RemoteMediatorAccessImpl$launchBoundary$1 f37064j;

        {
            this.f37064j = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.f37064j, continuation);
        }

        public final Object invoke(Object obj) {
            return ((AnonymousClass1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.f37063i
                r2 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                java.lang.Object r1 = r7.f37062h
                androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                kotlin.ResultKt.throwOnFailure(r8)
                r3 = r1
                r1 = r0
                r0 = r7
                goto L_0x0057
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                kotlin.ResultKt.throwOnFailure(r8)
                r8 = r7
            L_0x0022:
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r1 = r8.f37064j
                androidx.paging.RemoteMediatorAccessImpl r1 = r1.f37061i
                androidx.paging.AccessorStateHolder r1 = r1.accessorState
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r3 = androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.AnonymousClass1.INSTANCE
                java.lang.Object r1 = r1.use(r3)
                kotlin.Pair r1 = (kotlin.Pair) r1
                if (r1 == 0) goto L_0x0085
                java.lang.Object r3 = r1.component1()
                androidx.paging.LoadType r3 = (androidx.paging.LoadType) r3
                java.lang.Object r1 = r1.component2()
                androidx.paging.PagingState r1 = (androidx.paging.PagingState) r1
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r4 = r8.f37064j
                androidx.paging.RemoteMediatorAccessImpl r4 = r4.f37061i
                androidx.paging.RemoteMediator r4 = r4.remoteMediator
                r8.f37062h = r3
                r8.f37063i = r2
                java.lang.Object r1 = r4.load(r3, r1, r8)
                if (r1 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r6 = r0
                r0 = r8
                r8 = r1
                r1 = r6
            L_0x0057:
                androidx.paging.RemoteMediator$MediatorResult r8 = (androidx.paging.RemoteMediator.MediatorResult) r8
                boolean r4 = r8 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                if (r4 == 0) goto L_0x006e
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r4 = r0.f37064j
                androidx.paging.RemoteMediatorAccessImpl r4 = r4.f37061i
                androidx.paging.AccessorStateHolder r4 = r4.accessorState
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r5 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                r5.<init>(r3, r8)
                r4.use(r5)
                goto L_0x0082
            L_0x006e:
                boolean r4 = r8 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                if (r4 == 0) goto L_0x0082
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r4 = r0.f37064j
                androidx.paging.RemoteMediatorAccessImpl r4 = r4.f37061i
                androidx.paging.AccessorStateHolder r4 = r4.accessorState
                androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r5 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                r5.<init>(r3, r8)
                r4.use(r5)
            L_0x0082:
                r8 = r0
                r0 = r1
                goto L_0x0022
            L_0x0085:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchBoundary$1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
        super(2, continuation);
        this.f37061i = remoteMediatorAccessImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RemoteMediatorAccessImpl$launchBoundary$1(this.f37061i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RemoteMediatorAccessImpl$launchBoundary$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37060h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SingleRunner access$getIsolationRunner$p = this.f37061i.isolationRunner;
            AnonymousClass1 r12 = new AnonymousClass1(this, (Continuation) null);
            this.f37060h = 1;
            if (access$getIsolationRunner$p.runInIsolation(1, r12, this) == coroutine_suspended) {
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
