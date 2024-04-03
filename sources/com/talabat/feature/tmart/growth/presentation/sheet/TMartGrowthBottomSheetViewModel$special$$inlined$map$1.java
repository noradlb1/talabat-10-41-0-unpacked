package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthBottomSheetViewModel$special$$inlined$map$1 implements Flow<BottomSheetState.ShowImage> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f59158b;

    public TMartGrowthBottomSheetViewModel$special$$inlined$map$1(Flow flow) {
        this.f59158b = flow;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f59158b.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1$2$1 r0 = (com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f59161i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f59161i = r1
                    goto L_0x0018
                L_0x0013:
                    com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1$2$1 r0 = new com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f59160h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f59161i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x004b
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r6
                    java.lang.String r6 = r6.m10329unboximpl()
                    com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetState$ShowImage r2 = new com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetState$ShowImage
                    r4 = 0
                    r2.<init>(r6, r4)
                    r0.f59161i = r3
                    java.lang.Object r6 = r7.emit(r2, r0)
                    if (r6 != r1) goto L_0x004b
                    return r1
                L_0x004b:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
