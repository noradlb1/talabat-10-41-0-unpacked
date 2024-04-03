package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\n"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1", "androidx/paging/PagingDataTransforms$transform$$inlined$map$4"}, k = 1, mv = {1, 4, 2})
public final class PagingDataTransforms$flatMap$$inlined$transform$1 implements Flow<PageEvent<R>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f36915b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f36916c;

    public PagingDataTransforms$flatMap$$inlined$transform$1(Flow flow, Function2 function2) {
        this.f36915b = flow;
        this.f36916c = function2;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f36915b.collect(new FlowCollector<PageEvent<T>>() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2$1 r0 = (androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f36920i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f36920i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2$1 r0 = new androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.f36919h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f36920i
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x0061
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.f36921j
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x0055
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r3
                    androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
                    androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1 r2 = r2
                    kotlin.jvm.functions.Function2 r2 = r2.f36916c
                    r0.f36921j = r8
                    r0.f36920i = r4
                    java.lang.Object r7 = r7.flatMap(r2, r0)
                    if (r7 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0055:
                    r2 = 0
                    r0.f36921j = r2
                    r0.f36920i = r3
                    java.lang.Object r7 = r7.emit(r8, r0)
                    if (r7 != r1) goto L_0x0061
                    return r1
                L_0x0061:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms$flatMap$$inlined$transform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
