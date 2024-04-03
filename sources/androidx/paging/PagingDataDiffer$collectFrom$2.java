package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PagingDataDiffer$collectFrom$2", f = "PagingDataDiffer.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
public final class PagingDataDiffer$collectFrom$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36889h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PagingDataDiffer f36890i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PagingData f36891j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagingDataDiffer$collectFrom$2(PagingDataDiffer pagingDataDiffer, PagingData pagingData, Continuation continuation) {
        super(1, continuation);
        this.f36890i = pagingDataDiffer;
        this.f36891j = pagingData;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PagingDataDiffer$collectFrom$2(this.f36890i, this.f36891j, continuation);
    }

    public final Object invoke(Object obj) {
        return ((PagingDataDiffer$collectFrom$2) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36889h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36890i.receiver = this.f36891j.getReceiver$paging_common();
            Flow flow$paging_common = this.f36891j.getFlow$paging_common();
            PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1 = new PagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1(this);
            this.f36889h = 1;
            if (flow$paging_common.collect(pagingDataDiffer$collectFrom$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
