package com.talabat.wallet.features.walletonboarding.repository;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/features/walletonboarding/repository/UpdateWasWalletOnboardingShownUseCase;", "", "userPreferencesRepository", "Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository;", "(Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferencesRepository;)V", "invoke", "", "value", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateWasWalletOnboardingShownUseCase {
    @NotNull
    private final UserPreferencesRepository userPreferencesRepository;

    public UpdateWasWalletOnboardingShownUseCase(@NotNull UserPreferencesRepository userPreferencesRepository2) {
        Intrinsics.checkNotNullParameter(userPreferencesRepository2, "userPreferencesRepository");
        this.userPreferencesRepository = userPreferencesRepository2;
    }

    @Nullable
    public final Object invoke(boolean z11, @NotNull Continuation<? super Unit> continuation) {
        Object updateWasWalletOnboardingShown = this.userPreferencesRepository.updateWasWalletOnboardingShown(z11, continuation);
        return updateWasWalletOnboardingShown == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateWasWalletOnboardingShown : Unit.INSTANCE;
    }
}
