package com.talabat.feature.ridertips.presentation.viewmodel;

import com.talabat.feature.ridertips.domain.IRiderTipTracker;
import com.talabat.feature.ridertips.domain.usecases.GetRiderTipUseCase;
import com.talabat.feature.ridertips.domain.usecases.SaveRiderTipUseCase;
import com.talabat.feature.ridertips.presentation.mapper.IRiderTipDisplayModelMapper;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class RiderTipViewModel_Factory implements Factory<RiderTipViewModel> {
    private final Provider<GetRiderTipUseCase> getRiderTipUseCaseProvider;
    private final Provider<IRiderTipDisplayModelMapper> mapperProvider;
    private final Provider<SaveRiderTipUseCase> saveRiderTipUseCaseProvider;
    private final Provider<IRiderTipTracker> trackerProvider;

    public RiderTipViewModel_Factory(Provider<GetRiderTipUseCase> provider, Provider<IRiderTipDisplayModelMapper> provider2, Provider<IRiderTipTracker> provider3, Provider<SaveRiderTipUseCase> provider4) {
        this.getRiderTipUseCaseProvider = provider;
        this.mapperProvider = provider2;
        this.trackerProvider = provider3;
        this.saveRiderTipUseCaseProvider = provider4;
    }

    public static RiderTipViewModel_Factory create(Provider<GetRiderTipUseCase> provider, Provider<IRiderTipDisplayModelMapper> provider2, Provider<IRiderTipTracker> provider3, Provider<SaveRiderTipUseCase> provider4) {
        return new RiderTipViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static RiderTipViewModel newInstance(GetRiderTipUseCase getRiderTipUseCase, IRiderTipDisplayModelMapper iRiderTipDisplayModelMapper, IRiderTipTracker iRiderTipTracker, SaveRiderTipUseCase saveRiderTipUseCase) {
        return new RiderTipViewModel(getRiderTipUseCase, iRiderTipDisplayModelMapper, iRiderTipTracker, saveRiderTipUseCase);
    }

    public RiderTipViewModel get() {
        return newInstance(this.getRiderTipUseCaseProvider.get(), this.mapperProvider.get(), this.trackerProvider.get(), this.saveRiderTipUseCaseProvider.get());
    }
}
