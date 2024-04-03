package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1 implements Flow<TMartGrowthClaimDisplayModel> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f59081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfo.Success f59082c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfoUseCase f59083d;

    public TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1(Flow flow, TMartGrowthClaimInfo.Success success, TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase) {
        this.f59081b = flow;
        this.f59082c = success;
        this.f59083d = tMartGrowthClaimInfoUseCase;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f59081b;
        final TMartGrowthClaimInfo.Success success = this.f59082c;
        final TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase = this.f59083d;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0093 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r10
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1$2$1 r0 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f59088i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f59088i = r1
                    goto L_0x0018
                L_0x0013:
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1$2$1 r0 = new com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1$2$1
                    r0.<init>(r8, r10)
                L_0x0018:
                    java.lang.Object r10 = r0.f59087h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f59088i
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x004e
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x0094
                L_0x002c:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x0034:
                    java.lang.Object r9 = r0.f59093n
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo$Success r9 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo.Success) r9
                    java.lang.Object r2 = r0.f59092m
                    java.lang.String r2 = (java.lang.String) r2
                    java.lang.Object r4 = r0.f59091l
                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                    java.lang.Object r5 = r0.f59089j
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1$2 r5 = (com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1.AnonymousClass2) r5
                    kotlin.ResultKt.throwOnFailure(r10)
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r10 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r10
                    java.lang.String r10 = r10.m10329unboximpl()
                    goto L_0x0076
                L_0x004e:
                    kotlin.ResultKt.throwOnFailure(r10)
                    kotlinx.coroutines.flow.FlowCollector r10 = r5
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r9 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r9
                    java.lang.String r2 = r9.m10329unboximpl()
                    com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo$Success r9 = r2
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase r5 = r3
                    java.lang.String r6 = r9.getBackgroundUrl()
                    r0.f59089j = r8
                    r0.f59091l = r10
                    r0.f59092m = r2
                    r0.f59093n = r9
                    r0.f59088i = r4
                    java.lang.Object r4 = r5.m10320backgroundPathr0oKcjY(r6, r0)
                    if (r4 != r1) goto L_0x0072
                    return r1
                L_0x0072:
                    r5 = r8
                    r7 = r4
                    r4 = r10
                    r10 = r7
                L_0x0076:
                    java.lang.String r10 = (java.lang.String) r10
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase r5 = r3
                    com.talabat.feature.tmart.growth.domain.TMartGrowthScreenType r5 = r5.screenType
                    com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimDisplayModel r9 = com.talabat.feature.tmart.growth.domain.claim.TMartGrowthDisplayModelMapperKt.m10322toDisplayModel6MBmTN8(r9, r2, r10, r5)
                    r10 = 0
                    r0.f59089j = r10
                    r0.f59091l = r10
                    r0.f59092m = r10
                    r0.f59093n = r10
                    r0.f59088i = r3
                    java.lang.Object r9 = r4.emit(r9, r0)
                    if (r9 != r1) goto L_0x0094
                    return r1
                L_0x0094:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
