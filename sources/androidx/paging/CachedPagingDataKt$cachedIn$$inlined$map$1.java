package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 4, 2})
public final class CachedPagingDataKt$cachedIn$$inlined$map$1 implements Flow<MulticastedPagingData<T>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f36504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f36505c;

    public CachedPagingDataKt$cachedIn$$inlined$map$1(Flow flow, CoroutineScope coroutineScope) {
        this.f36504b = flow;
        this.f36505c = coroutineScope;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f36504b.collect(new FlowCollector<PagingData<T>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2$1 r0 = (androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f36509i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f36509i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2$1 r0 = new androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1$2$1
                    r0.<init>(r10, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.f36508h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f36509i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x004f
                L_0x0029:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r3
                    r6 = r11
                    androidx.paging.PagingData r6 = (androidx.paging.PagingData) r6
                    androidx.paging.MulticastedPagingData r11 = new androidx.paging.MulticastedPagingData
                    androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1 r2 = r2
                    kotlinx.coroutines.CoroutineScope r5 = r2.f36505c
                    r7 = 0
                    r8 = 4
                    r9 = 0
                    r4 = r11
                    r4.<init>(r5, r6, r7, r8, r9)
                    r0.f36509i = r3
                    java.lang.Object r11 = r12.emit(r11, r0)
                    if (r11 != r1) goto L_0x004f
                    return r1
                L_0x004f:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
