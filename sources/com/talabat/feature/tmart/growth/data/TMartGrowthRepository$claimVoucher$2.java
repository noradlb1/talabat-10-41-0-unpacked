package com.talabat.feature.tmart.growth.data;

import com.talabat.feature.tmart.growth.data.TMartGrowthRepository;
import com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/TMartGrowthRepository$RequestType$GrowthWidget;", "requestType", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthClaimConfirmation;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.feature.tmart.growth.data.TMartGrowthRepository$claimVoucher$2", f = "TMartGrowthRepository.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"requestType"}, s = {"L$0"})
public final class TMartGrowthRepository$claimVoucher$2 extends SuspendLambda implements Function2<TMartGrowthRepository.RequestType.GrowthWidget, Continuation<? super TMartGrowthClaimConfirmation>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59051h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59052i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TMartGrowthRepository f59053j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TMartGrowthRepository$claimVoucher$2(TMartGrowthRepository tMartGrowthRepository, Continuation<? super TMartGrowthRepository$claimVoucher$2> continuation) {
        super(2, continuation);
        this.f59053j = tMartGrowthRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TMartGrowthRepository$claimVoucher$2 tMartGrowthRepository$claimVoucher$2 = new TMartGrowthRepository$claimVoucher$2(this.f59053j, continuation);
        tMartGrowthRepository$claimVoucher$2.f59052i = obj;
        return tMartGrowthRepository$claimVoucher$2;
    }

    @Nullable
    public final Object invoke(@NotNull TMartGrowthRepository.RequestType.GrowthWidget growthWidget, @Nullable Continuation<? super TMartGrowthClaimConfirmation> continuation) {
        return ((TMartGrowthRepository$claimVoucher$2) create(growthWidget, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f59051h
            r2 = 1
            if (r1 == 0) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            java.lang.Object r0 = r9.f59052i
            com.talabat.feature.tmart.growth.data.TMartGrowthRepository$RequestType$GrowthWidget r0 = (com.talabat.feature.tmart.growth.data.TMartGrowthRepository.RequestType.GrowthWidget) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0013 }
            goto L_0x0048
        L_0x0013:
            r10 = move-exception
            goto L_0x0053
        L_0x0015:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001d:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.f59052i
            com.talabat.feature.tmart.growth.data.TMartGrowthRepository$RequestType$GrowthWidget r10 = (com.talabat.feature.tmart.growth.data.TMartGrowthRepository.RequestType.GrowthWidget) r10
            com.talabat.feature.tmart.growth.data.TMartGrowthRepository r1 = r9.f59053j
            com.talabat.feature.tmart.growth.data.remote.TMartGrowthApi r1 = r1.growthApi
            com.talabat.feature.tmart.growth.data.TMartGrowthRepository r3 = r9.f59053j
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x004f }
            java.lang.String r3 = r3.countryCode     // Catch:{ all -> 0x004f }
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimRequest r4 = new com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimRequest     // Catch:{ all -> 0x004f }
            java.lang.String r5 = r10.getVoucherId()     // Catch:{ all -> 0x004f }
            r4.<init>(r5)     // Catch:{ all -> 0x004f }
            r9.f59052i = r10     // Catch:{ all -> 0x004f }
            r9.f59051h = r2     // Catch:{ all -> 0x004f }
            java.lang.Object r1 = r1.claimVoucher(r3, r4, r9)     // Catch:{ all -> 0x004f }
            if (r1 != r0) goto L_0x0046
            return r0
        L_0x0046:
            r0 = r10
            r10 = r1
        L_0x0048:
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse r10 = (com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse) r10     // Catch:{ all -> 0x0013 }
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)     // Catch:{ all -> 0x0013 }
            goto L_0x005d
        L_0x004f:
            r0 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L_0x0053:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x005d:
            boolean r1 = kotlin.Result.m6336isSuccessimpl(r10)
            if (r1 == 0) goto L_0x0069
            com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse r10 = (com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse) r10
            com.talabat.feature.tmart.growth.domain.dto.TMartGrowthClaimConfirmation r10 = com.talabat.feature.tmart.growth.data.convert.TMartGrowthResponseMappersKt.toClaimConfirmation(r10)
        L_0x0069:
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r10)
            if (r1 == 0) goto L_0x0088
            com.integration.nfv.observability.NfvObservabilityHandler r2 = com.integration.nfv.observability.NfvObservabilityHandler.INSTANCE
            r3 = 0
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L_0x007e
            java.lang.String r1 = ""
        L_0x007e:
            r4 = r1
            java.lang.String r5 = r0.getVoucherId()
            r6 = 1
            r7 = 0
            com.integration.nfv.observability.NfvObservabilityHandler.onTMartGrowthPostFailed$default(r2, r3, r4, r5, r6, r7)
        L_0x0088:
            kotlin.ResultKt.throwOnFailure(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tmart.growth.data.TMartGrowthRepository$claimVoucher$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
