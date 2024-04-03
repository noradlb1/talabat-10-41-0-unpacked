package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "K", "", "V", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.ContiguousPagedList$tryDispatchBoundaryCallbacks$1", f = "ContiguousPagedList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContiguousPagedList$tryDispatchBoundaryCallbacks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36538h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ContiguousPagedList f36539i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f36540j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f36541k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContiguousPagedList$tryDispatchBoundaryCallbacks$1(ContiguousPagedList contiguousPagedList, boolean z11, boolean z12, Continuation continuation) {
        super(2, continuation);
        this.f36539i = contiguousPagedList;
        this.f36540j = z11;
        this.f36541k = z12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ContiguousPagedList$tryDispatchBoundaryCallbacks$1(this.f36539i, this.f36540j, this.f36541k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ContiguousPagedList$tryDispatchBoundaryCallbacks$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36538h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36539i.dispatchBoundaryCallbacks(this.f36540j, this.f36541k);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
