package androidx.paging;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\n"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$5", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1", "androidx/paging/PagingDataTransforms$transform$$inlined$map$3"}, k = 1, mv = {1, 4, 2})
public final class PagingDataTransforms$map$$inlined$transform$2 implements Flow<PageEvent<R>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f36945b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Executor f36946c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Function1 f36947d;

    public PagingDataTransforms$map$$inlined$transform$2(Flow flow, Executor executor, Function1 function1) {
        this.f36945b = flow;
        this.f36946c = executor;
        this.f36947d = function1;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f36945b.collect(new FlowCollector<PageEvent<T>>() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0069 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r10
                    androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1 r0 = (androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f36951i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f36951i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1 r0 = new androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$1
                    r0.<init>(r8, r10)
                L_0x0018:
                    java.lang.Object r10 = r0.f36950h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f36951i
                    r3 = 0
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L_0x003d
                    if (r2 == r5) goto L_0x0035
                    if (r2 != r4) goto L_0x002d
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x006a
                L_0x002d:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x0035:
                    java.lang.Object r9 = r0.f36952j
                    kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x005f
                L_0x003d:
                    kotlin.ResultKt.throwOnFailure(r10)
                    kotlinx.coroutines.flow.FlowCollector r10 = r3
                    androidx.paging.PageEvent r9 = (androidx.paging.PageEvent) r9
                    androidx.paging.PagingDataTransforms$map$$inlined$transform$2 r2 = r2
                    java.util.concurrent.Executor r2 = r2.f36946c
                    kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.ExecutorsKt.from((java.util.concurrent.Executor) r2)
                    androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$lambda$1 r6 = new androidx.paging.PagingDataTransforms$map$$inlined$transform$2$2$lambda$1
                    r6.<init>(r9, r3, r8)
                    r0.f36952j = r10
                    r0.f36951i = r5
                    java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r2, r6, r0)
                    if (r9 != r1) goto L_0x005c
                    return r1
                L_0x005c:
                    r7 = r10
                    r10 = r9
                    r9 = r7
                L_0x005f:
                    r0.f36952j = r3
                    r0.f36951i = r4
                    java.lang.Object r9 = r9.emit(r10, r0)
                    if (r9 != r1) goto L_0x006a
                    return r1
                L_0x006a:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PagingDataTransforms$map$$inlined$transform$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
