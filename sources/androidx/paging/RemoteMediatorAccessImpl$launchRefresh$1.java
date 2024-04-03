package androidx.paging;

import androidx.paging.RemoteMediator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {265}, m = "invokeSuspend", n = {"launchAppendPrepend"}, s = {"L$0"})
public final class RemoteMediatorAccessImpl$launchRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f37069h;

    /* renamed from: i  reason: collision with root package name */
    public int f37070i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RemoteMediatorAccessImpl f37071j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Key", "", "Value", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f37072h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ RemoteMediatorAccessImpl$launchRefresh$1 f37073i;

        {
            this.f37073i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.f37073i, booleanRef2, continuation);
        }

        public final Object invoke(Object obj) {
            return ((AnonymousClass1) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z11;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f37072h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                PagingState pagingState = (PagingState) this.f37073i.f37071j.accessorState.use(RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1.INSTANCE);
                if (pagingState != null) {
                    RemoteMediator access$getRemoteMediator$p = this.f37073i.f37071j.remoteMediator;
                    LoadType loadType = LoadType.REFRESH;
                    this.f37072h = 1;
                    obj = access$getRemoteMediator$p.load(loadType, pagingState, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            RemoteMediator.MediatorResult mediatorResult = (RemoteMediator.MediatorResult) obj;
            Ref.BooleanRef booleanRef = booleanRef2;
            if (mediatorResult instanceof RemoteMediator.MediatorResult.Success) {
                z11 = ((Boolean) this.f37073i.f37071j.accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(mediatorResult))).booleanValue();
            } else if (mediatorResult instanceof RemoteMediator.MediatorResult.Error) {
                z11 = ((Boolean) this.f37073i.f37071j.accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$2(mediatorResult))).booleanValue();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            booleanRef.element = z11;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteMediatorAccessImpl$launchRefresh$1(RemoteMediatorAccessImpl remoteMediatorAccessImpl, Continuation continuation) {
        super(2, continuation);
        this.f37071j = remoteMediatorAccessImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new RemoteMediatorAccessImpl$launchRefresh$1(this.f37071j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RemoteMediatorAccessImpl$launchRefresh$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37070i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            booleanRef2.element = false;
            SingleRunner access$getIsolationRunner$p = this.f37071j.isolationRunner;
            AnonymousClass1 r32 = new AnonymousClass1(this, (Continuation) null);
            this.f37069h = booleanRef2;
            this.f37070i = 1;
            if (access$getIsolationRunner$p.runInIsolation(2, r32, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i11 == 1) {
            booleanRef = (Ref.BooleanRef) this.f37069h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (booleanRef.element) {
            this.f37071j.launchBoundary();
        }
        return Unit.INSTANCE;
    }
}
