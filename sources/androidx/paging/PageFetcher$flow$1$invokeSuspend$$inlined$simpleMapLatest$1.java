package androidx.paging;

import androidx.paging.PageFetcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$simpleMapLatest$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1", f = "PageFetcher.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super PagingData<Value>>, PageFetcher.GenerationInfo<Key, Value>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;

    /* renamed from: h  reason: collision with root package name */
    public int f36693h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageFetcher$flow$1 f36694i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RemoteMediatorAccessor f36695j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(Continuation continuation, PageFetcher$flow$1 pageFetcher$flow$1, RemoteMediatorAccessor remoteMediatorAccessor) {
        super(3, continuation);
        this.f36694i = pageFetcher$flow$1;
        this.f36695j = remoteMediatorAccessor;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super PagingData<Value>> flowCollector, PageFetcher.GenerationInfo<Key, Value> generationInfo, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(flowCollector, "$this$create");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 = new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(continuation, this.f36694i, this.f36695j);
        pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1.L$0 = flowCollector;
        pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1.L$1 = generationInfo;
        return pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1) create((FlowCollector) obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36693h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PageFetcher.GenerationInfo generationInfo = (PageFetcher.GenerationInfo) this.L$1;
            PagingData pagingData = new PagingData(this.f36694i.f36711i.injectRemoteEvents(generationInfo.getSnapshot(), this.f36695j), new PageFetcher.PagerUiReceiver(this.f36694i.f36711i, generationInfo.getSnapshot(), this.f36694i.f36711i.retryEvents));
            this.f36693h = 1;
            if (((FlowCollector) this.L$0).emit(pagingData, this) == coroutine_suspended) {
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
