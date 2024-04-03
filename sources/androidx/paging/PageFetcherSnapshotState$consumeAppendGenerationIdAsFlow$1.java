package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00060\u0005H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1", f = "PageFetcherSnapshotState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36840h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshotState f36841i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(PageFetcherSnapshotState pageFetcherSnapshotState, Continuation continuation) {
        super(2, continuation);
        this.f36841i = pageFetcherSnapshotState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this.f36841i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f36840h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36841i.appendGenerationIdCh.offer(Boxing.boxInt(this.f36841i.appendGenerationId));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
