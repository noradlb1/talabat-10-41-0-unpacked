package com.talabat.wallet.features.walletonboarding.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/features/walletonboarding/repository/GetWasWalletOnboardingShownUseCase;", "", "userPreferencesRepository", "Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository;", "(Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetWasWalletOnboardingShownUseCase {
    @NotNull
    private final UserPreferencesRepository userPreferencesRepository;

    public GetWasWalletOnboardingShownUseCase(@NotNull UserPreferencesRepository userPreferencesRepository2) {
        Intrinsics.checkNotNullParameter(userPreferencesRepository2, "userPreferencesRepository");
        this.userPreferencesRepository = userPreferencesRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase$invoke$1 r0 = (com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase$invoke$1) r0
            int r1 = r0.f12606j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12606j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase$invoke$1 r0 = new com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase$invoke$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f12604h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12606j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0043
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.wallet.features.walletonboarding.repository.UserPreferencesRepository r5 = r4.userPreferencesRepository
            kotlinx.coroutines.flow.Flow r5 = r5.getUserPreferencesFlow()
            r0.f12606j = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.first(r5, r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            com.talabat.wallet.features.walletonboarding.repository.UserPreferences r5 = (com.talabat.wallet.features.walletonboarding.repository.UserPreferences) r5
            boolean r5 = r5.getWasWalletOnboardingShown()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.walletonboarding.repository.GetWasWalletOnboardingShownUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
