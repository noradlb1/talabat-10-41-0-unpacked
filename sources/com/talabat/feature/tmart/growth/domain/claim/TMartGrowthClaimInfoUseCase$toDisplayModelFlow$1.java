package com.talabat.feature.tmart.growth.domain.claim;

import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1", f = "TMartGrowthClaimInfoUseCase.kt", i = {}, l = {34, 34}, m = "invokeSuspend", n = {}, s = {})
public final class TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super TMartGrowthFilePath>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f59098h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfoUseCase f59099i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthClaimInfo.Success f59100j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1(TMartGrowthClaimInfoUseCase tMartGrowthClaimInfoUseCase, TMartGrowthClaimInfo.Success success, Continuation<? super TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1> continuation) {
        super(2, continuation);
        this.f59099i = tMartGrowthClaimInfoUseCase;
        this.f59100j = success;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1 tMartGrowthClaimInfoUseCase$toDisplayModelFlow$1 = new TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1(this.f59099i, this.f59100j, continuation);
        tMartGrowthClaimInfoUseCase$toDisplayModelFlow$1.L$0 = obj;
        return tMartGrowthClaimInfoUseCase$toDisplayModelFlow$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super TMartGrowthFilePath> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f59098h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0064
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = (com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath) r6
            java.lang.String r6 = r6.m10329unboximpl()
            goto L_0x0052
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.L$0
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase r6 = r5.f59099i
            com.talabat.feature.tmart.growth.domain.files.ITMartGrowthFileManager r6 = r6.imageFileManager
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo$Success r4 = r5.f59100j
            java.lang.String r4 = r4.getFinalImageUrl()
            if (r4 != 0) goto L_0x0047
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimInfo$Success r4 = r5.f59100j
            java.lang.String r4 = r4.getIconUrl()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
        L_0x0047:
            r5.L$0 = r1
            r5.f59098h = r3
            java.lang.Object r6 = r6.m10337getFilePathr0oKcjY(r4, r5)
            if (r6 != r0) goto L_0x0052
            return r0
        L_0x0052:
            java.lang.String r6 = (java.lang.String) r6
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath r6 = com.talabat.feature.tmart.growth.domain.dto.TMartGrowthFilePath.m10323boximpl(r6)
            r3 = 0
            r5.L$0 = r3
            r5.f59098h = r2
            java.lang.Object r6 = r1.emit(r6, r5)
            if (r6 != r0) goto L_0x0064
            return r0
        L_0x0064:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.domain.claim.TMartGrowthClaimInfoUseCase$toDisplayModelFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
