package com.talabat.feature.mission.control.presentation.viewmodel;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.mission.control.domain.usecases.PrimaryMissionControlsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class PrimaryMissionViewModel_Factory implements Factory<PrimaryMissionViewModel> {
    private final Provider<ITalabatExperiment> talabatExperimentProvider;
    private final Provider<TalabatTracker> trackerProvider;
    private final Provider<PrimaryMissionControlsUseCase> useCaseProvider;

    public PrimaryMissionViewModel_Factory(Provider<PrimaryMissionControlsUseCase> provider, Provider<ITalabatExperiment> provider2, Provider<TalabatTracker> provider3) {
        this.useCaseProvider = provider;
        this.talabatExperimentProvider = provider2;
        this.trackerProvider = provider3;
    }

    public static PrimaryMissionViewModel_Factory create(Provider<PrimaryMissionControlsUseCase> provider, Provider<ITalabatExperiment> provider2, Provider<TalabatTracker> provider3) {
        return new PrimaryMissionViewModel_Factory(provider, provider2, provider3);
    }

    public static PrimaryMissionViewModel newInstance(PrimaryMissionControlsUseCase primaryMissionControlsUseCase, ITalabatExperiment iTalabatExperiment, TalabatTracker talabatTracker) {
        return new PrimaryMissionViewModel(primaryMissionControlsUseCase, iTalabatExperiment, talabatTracker);
    }

    public PrimaryMissionViewModel get() {
        return newInstance(this.useCaseProvider.get(), this.talabatExperimentProvider.get(), this.trackerProvider.get());
    }
}
