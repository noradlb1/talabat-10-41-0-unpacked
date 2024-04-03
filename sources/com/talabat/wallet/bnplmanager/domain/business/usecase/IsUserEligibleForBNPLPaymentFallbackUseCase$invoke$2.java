package com.talabat.wallet.bnplmanager.domain.business.usecase;

import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentFallbackEligibleStatus;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2", f = "IsUserEligibleForBNPLPaymentFallbackUseCase.kt", i = {0}, l = {31, 40}, m = "invokeSuspend", n = {"isBnplPaymentFallbackFeatureEnabled"}, s = {"Z$0"})
public final class IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BNPLPaymentFallbackEligibleStatus>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public boolean f12485h;

    /* renamed from: i  reason: collision with root package name */
    public int f12486i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ IsUserEligibleForBNPLPaymentFallbackUseCase f12487j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f12488k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2(IsUserEligibleForBNPLPaymentFallbackUseCase isUserEligibleForBNPLPaymentFallbackUseCase, int i11, Continuation<? super IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.f12487j = isUserEligibleForBNPLPaymentFallbackUseCase;
        this.f12488k = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2(this.f12487j, this.f12488k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super BNPLPaymentFallbackEligibleStatus> continuation) {
        return ((IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f12486i
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 == r4) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0061
        L_0x0013:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001b:
            boolean r1 = r5.f12485h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0041
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase r6 = r5.f12487j
            com.talabat.core.featureflag.domain.ITalabatFeatureFlag r6 = r6.talabatFeatureFlag
            com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys r1 = com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys.LENDING_BNPL_PAYMENT_FALLBACK_ENABLED
            boolean r1 = r6.getFeatureFlag(r1, r3)
            com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase r6 = r5.f12487j
            com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository r6 = r6.bNPLManagerRepository
            r5.f12485h = r1
            r5.f12486i = r4
            java.lang.Object r6 = r6.getIsUserSeenBnplPaymentFallbackOption(r5)
            if (r6 != r0) goto L_0x0041
            return r0
        L_0x0041:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r1 == 0) goto L_0x009a
            if (r6 != 0) goto L_0x009a
            int r6 = r5.f12488k
            r1 = 11
            if (r6 != r1) goto L_0x0052
            goto L_0x009a
        L_0x0052:
            com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase r6 = r5.f12487j
            com.talabat.wallet.bnplmanager.domain.repository.BNPLManagerRepository r6 = r6.bNPLManagerRepository
            r5.f12486i = r2
            java.lang.Object r6 = r6.getBNPLEligibilityStatusFromLocal(r5)
            if (r6 != r0) goto L_0x0061
            return r0
        L_0x0061:
            com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto r6 = (com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteDto) r6
            com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRemoteResultDto r6 = r6.getBNPLEligibilityRemoteResultDto()
            if (r6 == 0) goto L_0x008a
            java.lang.Boolean r0 = r6.isHideBNPLPaymentMethod()
            if (r0 == 0) goto L_0x0078
            boolean r0 = r0.booleanValue()
            r0 = r0 ^ r4
            if (r0 != r4) goto L_0x0078
            r0 = r4
            goto L_0x0079
        L_0x0078:
            r0 = r3
        L_0x0079:
            if (r0 == 0) goto L_0x008a
            java.lang.Boolean r6 = r6.isBNPLEligible()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x008a
            r3 = r4
        L_0x008a:
            if (r3 == 0) goto L_0x0097
            com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase r6 = r5.f12487j
            boolean r6 = r6.isBnplPaymentFallbackExperimentEnabled()
            if (r6 == 0) goto L_0x0097
            com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus$IsEligibleForBnplPaymentFallback r6 = com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus.IsEligibleForBnplPaymentFallback.INSTANCE
            goto L_0x0099
        L_0x0097:
            com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus$NotEligibleForBnplPaymentFallback r6 = com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus.NotEligibleForBnplPaymentFallback.INSTANCE
        L_0x0099:
            return r6
        L_0x009a:
            com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus$NotEligibleForBnplPaymentFallback r6 = com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus.NotEligibleForBnplPaymentFallback.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.bnplmanager.domain.business.usecase.IsUserEligibleForBNPLPaymentFallbackUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
