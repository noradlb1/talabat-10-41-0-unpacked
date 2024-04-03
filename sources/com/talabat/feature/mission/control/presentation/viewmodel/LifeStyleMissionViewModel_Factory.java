package com.talabat.feature.mission.control.presentation.viewmodel;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.mission.control.domain.usecases.LifeStyleMissionControlsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class LifeStyleMissionViewModel_Factory implements Factory<LifeStyleMissionViewModel> {
    private final Provider<TalabatTracker> trackerProvider;
    private final Provider<LifeStyleMissionControlsUseCase> useCaseProvider;

    public LifeStyleMissionViewModel_Factory(Provider<LifeStyleMissionControlsUseCase> provider, Provider<TalabatTracker> provider2) {
        this.useCaseProvider = provider;
        this.trackerProvider = provider2;
    }

    public static LifeStyleMissionViewModel_Factory create(Provider<LifeStyleMissionControlsUseCase> provider, Provider<TalabatTracker> provider2) {
        return new LifeStyleMissionViewModel_Factory(provider, provider2);
    }

    public static LifeStyleMissionViewModel newInstance(LifeStyleMissionControlsUseCase lifeStyleMissionControlsUseCase, TalabatTracker talabatTracker) {
        return new LifeStyleMissionViewModel(lifeStyleMissionControlsUseCase, talabatTracker);
    }

    public LifeStyleMissionViewModel get() {
        return newInstance(this.useCaseProvider.get(), this.trackerProvider.get());
    }
}
