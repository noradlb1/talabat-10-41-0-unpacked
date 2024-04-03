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
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1", f = "PageFetcherSnapshot.kt", i = {}, l = {212}, m = "invokeSuspend", n = {}, s = {})
public final class PageFetcherSnapshot$startConsumingHints$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36820h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot f36821i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/ViewportHint;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$startConsumingHints$1$2", f = "PageFetcherSnapshot.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ViewportHint, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f36822h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ PageFetcherSnapshot$startConsumingHints$1 f36823i;

        {
            this.f36823i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(this.f36823i, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f36822h == 0) {
                ResultKt.throwOnFailure(obj);
                this.f36823i.f36821i.invalidate.invoke();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageFetcherSnapshot$startConsumingHints$1(PageFetcherSnapshot pageFetcherSnapshot, Continuation continuation) {
        super(2, continuation);
        this.f36821i = pageFetcherSnapshot;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new PageFetcherSnapshot$startConsumingHints$1(this.f36821i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((PageFetcherSnapshot$startConsumingHints$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36820h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 pageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 = new PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1(this.f36821i.hintSharedFlow, this);
            AnonymousClass2 r52 = new AnonymousClass2(this, (Continuation) null);
            this.f36820h = 1;
            if (FlowKt.collectLatest(pageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1, r52, this) == coroutine_suspended) {
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
