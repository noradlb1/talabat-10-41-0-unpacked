package com.talabat.feature.tmart.growth.presentation.sheet;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda-2$$inlined$map$1  reason: invalid class name */
public final class TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1 implements Flow<BottomSheetState> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f59145b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthBottomSheetViewModel f59146c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimConfirmation f59147d;

    public TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1(Flow flow, TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel, TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation) {
        this.f59145b = flow;
        this.f59146c = tMartGrowthBottomSheetViewModel;
        this.f59147d = tMartGrowthClaimConfirmation;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f59145b;
        final TMartGrowthBottomSheetViewModel tMartGrowthBottomSheetViewModel = this.f59146c;
        final TMartGrowthClaimConfirmation tMartGrowthClaimConfirmation = this.f59147d;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda-2$$inlined$map$1$2$1 r0 = (com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f59152i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f59152i = r1
                    goto L_0x0018
                L_0x0013:
                    com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda-2$$inlined$map$1$2$1 r0 = new com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda-2$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.f59151h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f59152i
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0061
                L_0x002c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0034:
                    java.lang.Object r8 = r0.f59153j
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0055
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r5
                    com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetAction r8 = (com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetAction) r8
                    com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel r2 = r2
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation r5 = r3
                    r0.f59153j = r9
                    r0.f59152i = r4
                    java.lang.Object r8 = r2.toState(r8, r5, r0)
                    if (r8 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L_0x0055:
                    r2 = 0
                    r0.f59153j = r2
                    r0.f59152i = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0061
                    return r1
                L_0x0061:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.presentation.sheet.TMartGrowthBottomSheetViewModel$_init_$lambda2$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
