package com.talabat.wallet.qPayManager.domain.business.usecase;

import com.talabat.wallet.qPayManager.domain.application.usecase.GetQPayFeatureFlagUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/qPayManager/domain/business/usecase/GetQPayEnabledUseCase;", "", "isQPayFeatureFlagFlagEnabled", "Lcom/talabat/wallet/qPayManager/domain/application/usecase/GetQPayFeatureFlagUseCase;", "(Lcom/talabat/wallet/qPayManager/domain/application/usecase/GetQPayFeatureFlagUseCase;)V", "invoke", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "isDebitCardAccepted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQPayEnabledUseCase {
    @NotNull
    private final GetQPayFeatureFlagUseCase isQPayFeatureFlagFlagEnabled;

    public GetQPayEnabledUseCase(@NotNull GetQPayFeatureFlagUseCase getQPayFeatureFlagUseCase) {
        Intrinsics.checkNotNullParameter(getQPayFeatureFlagUseCase, "isQPayFeatureFlagFlagEnabled");
        this.isQPayFeatureFlagFlagEnabled = getQPayFeatureFlagUseCase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(boolean r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.qPayManager.domain.entity.QPayStatus> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase$invoke$1 r0 = (com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase$invoke$1) r0
            int r1 = r0.f12659k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12659k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase$invoke$1 r0 = new com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase$invoke$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f12657i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12659k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            boolean r5 = r0.f12656h
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.wallet.qPayManager.domain.application.usecase.GetQPayFeatureFlagUseCase r6 = r4.isQPayFeatureFlagFlagEnabled
            r0.f12656h = r5
            r0.f12659k = r3
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0050
            if (r5 == 0) goto L_0x0050
            com.talabat.wallet.qPayManager.domain.entity.QPayStatus$QPayIsAvailable r5 = com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsAvailable.INSTANCE
            return r5
        L_0x0050:
            com.talabat.wallet.qPayManager.domain.entity.QPayStatus$QPayIsUnAvailable r5 = com.talabat.wallet.qPayManager.domain.entity.QPayStatus.QPayIsUnAvailable.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.qPayManager.domain.business.usecase.GetQPayEnabledUseCase.invoke(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
