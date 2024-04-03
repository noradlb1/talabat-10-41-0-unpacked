package com.talabat.feature.walletcobrandedcc.presentation;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.walletcobrandedcc.domain.usecase.GetWalletStatusUseCase;
import com.talabat.feature.walletcobrandedcc.domain.usecase.ShowCobrandedNotificationUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CobrandedCcViewModel_Factory implements Factory<CobrandedCcViewModel> {
    private final Provider<GetWalletStatusUseCase> getWalletStatusUseCaseProvider;
    private final Provider<ShowCobrandedNotificationUseCase> showCobrandedNotificationUseCaseProvider;
    private final Provider<TalabatTracker> talabatTrackerProvider;

    public CobrandedCcViewModel_Factory(Provider<ShowCobrandedNotificationUseCase> provider, Provider<GetWalletStatusUseCase> provider2, Provider<TalabatTracker> provider3) {
        this.showCobrandedNotificationUseCaseProvider = provider;
        this.getWalletStatusUseCaseProvider = provider2;
        this.talabatTrackerProvider = provider3;
    }

    public static CobrandedCcViewModel_Factory create(Provider<ShowCobrandedNotificationUseCase> provider, Provider<GetWalletStatusUseCase> provider2, Provider<TalabatTracker> provider3) {
        return new CobrandedCcViewModel_Factory(provider, provider2, provider3);
    }

    public static CobrandedCcViewModel newInstance(ShowCobrandedNotificationUseCase showCobrandedNotificationUseCase, GetWalletStatusUseCase getWalletStatusUseCase, TalabatTracker talabatTracker) {
        return new CobrandedCcViewModel(showCobrandedNotificationUseCase, getWalletStatusUseCase, talabatTracker);
    }

    public CobrandedCcViewModel get() {
        return newInstance(this.showCobrandedNotificationUseCaseProvider.get(), this.getWalletStatusUseCaseProvider.get(), this.talabatTrackerProvider.get());
    }
}
