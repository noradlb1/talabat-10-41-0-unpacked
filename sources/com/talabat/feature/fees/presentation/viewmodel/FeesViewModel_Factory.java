package com.talabat.feature.fees.presentation.viewmodel;

import buisnessmodels.TalabatFormatter;
import com.talabat.feature.fees.domain.IFeesTracker;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.usecase.GetFeesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class FeesViewModel_Factory implements Factory<FeesViewModel> {
    private final Provider<TalabatFormatter> currencyFormatterProvider;
    private final Provider<IDisclaimerRepository> disclaimerRepositoryProvider;
    private final Provider<GetFeesUseCase> getFeesUseCaseProvider;
    private final Provider<IFeesTracker> trackerProvider;

    public FeesViewModel_Factory(Provider<GetFeesUseCase> provider, Provider<IDisclaimerRepository> provider2, Provider<IFeesTracker> provider3, Provider<TalabatFormatter> provider4) {
        this.getFeesUseCaseProvider = provider;
        this.disclaimerRepositoryProvider = provider2;
        this.trackerProvider = provider3;
        this.currencyFormatterProvider = provider4;
    }

    public static FeesViewModel_Factory create(Provider<GetFeesUseCase> provider, Provider<IDisclaimerRepository> provider2, Provider<IFeesTracker> provider3, Provider<TalabatFormatter> provider4) {
        return new FeesViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static FeesViewModel newInstance(GetFeesUseCase getFeesUseCase, IDisclaimerRepository iDisclaimerRepository, IFeesTracker iFeesTracker, TalabatFormatter talabatFormatter) {
        return new FeesViewModel(getFeesUseCase, iDisclaimerRepository, iFeesTracker, talabatFormatter);
    }

    public FeesViewModel get() {
        return newInstance(this.getFeesUseCaseProvider.get(), this.disclaimerRepositoryProvider.get(), this.trackerProvider.get(), this.currencyFormatterProvider.get());
    }
}
