package com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase;

import com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/domain/entity/BenefitBinsDetail;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase$invoke$2", f = "GetBenefitBinDetailUseCase.kt", i = {}, l = {25, 26}, m = "invokeSuspend", n = {}, s = {})
public final class GetBenefitBinDetailUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BenefitBinsDetail>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f11892h;

    /* renamed from: i  reason: collision with root package name */
    public int f11893i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetBenefitBinDetailUseCase f11894j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f11895k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetBenefitBinDetailUseCase$invoke$2(GetBenefitBinDetailUseCase getBenefitBinDetailUseCase, String str, Continuation<? super GetBenefitBinDetailUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f11894j = getBenefitBinDetailUseCase;
        this.f11895k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GetBenefitBinDetailUseCase$invoke$2 getBenefitBinDetailUseCase$invoke$2 = new GetBenefitBinDetailUseCase$invoke$2(this.f11894j, this.f11895k, continuation);
        getBenefitBinDetailUseCase$invoke$2.L$0 = obj;
        return getBenefitBinDetailUseCase$invoke$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BenefitBinsDetail> continuation) {
        return ((GetBenefitBinDetailUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f11893i
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L_0x002b
            if (r1 == r2) goto L_0x001f
            if (r1 != r3) goto L_0x0017
            java.lang.Object r0 = r7.L$0
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r0 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x00a3 }
            goto L_0x0076
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001f:
            java.lang.Object r1 = r7.f11892h
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r7.L$0
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r5 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase) r5
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x00a3 }
            goto L_0x004c
        L_0x002b:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase r8 = r7.f11894j
            java.lang.String r1 = r7.f11895k
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x00a3 }
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.application.usecase.GetBenefitBinDetailFeatureFlagUseCase r5 = r8.getBenefitBinDetailFeatureFlagUseCase     // Catch:{ all -> 0x00a3 }
            r7.L$0 = r8     // Catch:{ all -> 0x00a3 }
            r7.f11892h = r1     // Catch:{ all -> 0x00a3 }
            r7.f11893i = r2     // Catch:{ all -> 0x00a3 }
            java.lang.Object r5 = r5.invoke(r7)     // Catch:{ all -> 0x00a3 }
            if (r5 != r0) goto L_0x0049
            return r0
        L_0x0049:
            r6 = r5
            r5 = r8
            r8 = r6
        L_0x004c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ all -> 0x00a3 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00a3 }
            if (r8 == 0) goto L_0x0095
            if (r1 == 0) goto L_0x005e
            int r8 = r1.length()     // Catch:{ all -> 0x00a3 }
            if (r8 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r2 = 0
        L_0x005e:
            if (r2 != 0) goto L_0x0095
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.repository.BenefitManagerRepository r8 = r5.benefitManagerRepository     // Catch:{ all -> 0x00a3 }
            if (r1 != 0) goto L_0x0068
            java.lang.String r1 = ""
        L_0x0068:
            r7.L$0 = r5     // Catch:{ all -> 0x00a3 }
            r7.f11892h = r4     // Catch:{ all -> 0x00a3 }
            r7.f11893i = r3     // Catch:{ all -> 0x00a3 }
            java.lang.Object r8 = r8.getBinsDetails(r1, r7)     // Catch:{ all -> 0x00a3 }
            if (r8 != r0) goto L_0x0075
            return r0
        L_0x0075:
            r0 = r5
        L_0x0076:
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r8 = (com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail) r8     // Catch:{ all -> 0x00a3 }
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r1 = r0.checkoutPaymentManagerRepository     // Catch:{ all -> 0x00a3 }
            java.util.List r1 = r1.getSavedCardList()     // Catch:{ all -> 0x00a3 }
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r0 = r0.checkoutPaymentManagerRepository     // Catch:{ all -> 0x00a3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00a3 }
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper r5 = com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.mapper.BenefitBinMapper.INSTANCE     // Catch:{ all -> 0x00a3 }
            java.util.List r1 = r5.filterBenefitBins(r8, r1)     // Catch:{ all -> 0x00a3 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00a3 }
            r2.<init>(r1)     // Catch:{ all -> 0x00a3 }
            r0.setSavedCardList(r2)     // Catch:{ all -> 0x00a3 }
            goto L_0x009e
        L_0x0095:
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r8 = new com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail     // Catch:{ all -> 0x00a3 }
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()     // Catch:{ all -> 0x00a3 }
            r8.<init>(r0, r4, r3, r4)     // Catch:{ all -> 0x00a3 }
        L_0x009e:
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x00a3 }
            goto L_0x00ae
        L_0x00a3:
            r8 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x00ae:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r8)
            if (r0 != 0) goto L_0x00b5
            goto L_0x00cc
        L_0x00b5:
            com.talabat.observability.ObservabilityManager r8 = com.talabat.observability.ObservabilityManager.INSTANCE
            com.talabat.observability.common.ApiStatus r8 = com.talabat.observability.common.ApiStatus.FAILURE
            java.lang.String r8 = r8.getValue()
            java.lang.String r0 = "get benefit bins"
            r1 = 4
            com.talabat.observability.ObservabilityManager.trackEvent$default((java.lang.String) r0, (java.lang.String) r8, (java.util.Map) r4, (int) r1, (java.lang.Object) r4)
            com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail r8 = new com.talabat.talabatcommon.views.wallet.benefitmanager.domain.entity.BenefitBinsDetail
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r8.<init>(r0, r4, r3, r4)
        L_0x00cc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.benefitmanager.domain.business.usecase.GetBenefitBinDetailUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
