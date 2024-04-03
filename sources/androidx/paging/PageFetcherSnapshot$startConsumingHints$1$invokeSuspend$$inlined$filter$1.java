package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 implements Flow<ViewportHint> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f36764b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PageFetcherSnapshot$startConsumingHints$1 f36765c;

    public PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1(Flow flow, PageFetcherSnapshot$startConsumingHints$1 pageFetcherSnapshot$startConsumingHints$1) {
        this.f36764b = flow;
        this.f36765c = pageFetcherSnapshot$startConsumingHints$1;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f36764b.collect(new FlowCollector<ViewportHint>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2$1 r0 = (androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f36769i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f36769i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2$1 r0 = new androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f36768h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f36769i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x0078
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r3
                    r2 = r7
                    androidx.paging.ViewportHint r2 = (androidx.paging.ViewportHint) r2
                    int r4 = r2.getPresentedItemsBefore()
                    int r4 = r4 * -1
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 r5 = r2
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1 r5 = r5.f36765c
                    androidx.paging.PageFetcherSnapshot r5 = r5.f36821i
                    androidx.paging.PagingConfig r5 = r5.config
                    int r5 = r5.jumpThreshold
                    if (r4 > r5) goto L_0x0064
                    int r2 = r2.getPresentedItemsAfter()
                    int r2 = r2 * -1
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1 r4 = r2
                    androidx.paging.PageFetcherSnapshot$startConsumingHints$1 r4 = r4.f36765c
                    androidx.paging.PageFetcherSnapshot r4 = r4.f36821i
                    androidx.paging.PagingConfig r4 = r4.config
                    int r4 = r4.jumpThreshold
                    if (r2 <= r4) goto L_0x0062
                    goto L_0x0064
                L_0x0062:
                    r2 = 0
                    goto L_0x0065
                L_0x0064:
                    r2 = r3
                L_0x0065:
                    java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
                    boolean r2 = r2.booleanValue()
                    if (r2 == 0) goto L_0x007b
                    r0.f36769i = r3
                    java.lang.Object r7 = r8.emit(r7, r0)
                    if (r7 != r1) goto L_0x0078
                    return r1
                L_0x0078:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    goto L_0x007d
                L_0x007b:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                L_0x007d:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$startConsumingHints$1$invokeSuspend$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
