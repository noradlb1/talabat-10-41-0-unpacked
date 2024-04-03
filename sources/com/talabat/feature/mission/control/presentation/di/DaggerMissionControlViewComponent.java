package com.talabat.feature.mission.control.presentation.di;

import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.mission.control.domain.MissionControlFeatureApi;
import com.talabat.feature.mission.control.domain.MissionControlRepository;
import com.talabat.feature.mission.control.domain.usecases.LifeStyleMissionControlsUseCase;
import com.talabat.feature.mission.control.domain.usecases.LifeStyleMissionControlsUseCase_Factory;
import com.talabat.feature.mission.control.domain.usecases.PrimaryMissionControlsUseCase;
import com.talabat.feature.mission.control.domain.usecases.PrimaryMissionControlsUseCase_Factory;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View_MembersInjector;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView_MembersInjector;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;
import com.talabat.feature.mission.control.presentation.PrimaryMissionView_MembersInjector;
import com.talabat.feature.mission.control.presentation.di.MissionControlViewComponent;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModel;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModelFactory;
import com.talabat.feature.mission.control.presentation.viewmodel.LifeStyleMissionViewModel_Factory;
import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModel;
import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModelFactory;
import com.talabat.feature.mission.control.presentation.viewmodel.PrimaryMissionViewModel_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerMissionControlViewComponent {

    public static final class Factory implements MissionControlViewComponent.Factory {
        private Factory() {
        }

        public MissionControlViewComponent create(ExperimentCoreLibApi experimentCoreLibApi, MissionControlFeatureApi missionControlFeatureApi, TrackingCoreLibApi trackingCoreLibApi) {
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(missionControlFeatureApi);
            Preconditions.checkNotNull(trackingCoreLibApi);
            return new MissionControlViewComponentImpl(experimentCoreLibApi, missionControlFeatureApi, trackingCoreLibApi);
        }
    }

    public static final class MissionControlViewComponentImpl implements MissionControlViewComponent {
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<MissionControlRepository> getRepositoryProvider;
        private Provider<TalabatTracker> getTalabatTrackerProvider;
        private Provider<LifeStyleMissionControlsUseCase> lifeStyleMissionControlsUseCaseProvider;
        private Provider<LifeStyleMissionViewModel> lifeStyleMissionViewModelProvider;
        private final MissionControlViewComponentImpl missionControlViewComponentImpl;
        private Provider<PrimaryMissionControlsUseCase> primaryMissionControlsUseCaseProvider;
        private Provider<PrimaryMissionViewModel> primaryMissionViewModelProvider;

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        public static final class GetRepositoryProvider implements Provider<MissionControlRepository> {
            private final MissionControlFeatureApi missionControlFeatureApi;

            public GetRepositoryProvider(MissionControlFeatureApi missionControlFeatureApi2) {
                this.missionControlFeatureApi = missionControlFeatureApi2;
            }

            public MissionControlRepository get() {
                return (MissionControlRepository) Preconditions.checkNotNullFromComponent(this.missionControlFeatureApi.getRepository());
            }
        }

        public static final class GetTalabatTrackerProvider implements Provider<TalabatTracker> {
            private final TrackingCoreLibApi trackingCoreLibApi;

            public GetTalabatTrackerProvider(TrackingCoreLibApi trackingCoreLibApi2) {
                this.trackingCoreLibApi = trackingCoreLibApi2;
            }

            public TalabatTracker get() {
                return (TalabatTracker) Preconditions.checkNotNullFromComponent(this.trackingCoreLibApi.getTalabatTracker());
            }
        }

        private MissionControlViewComponentImpl(ExperimentCoreLibApi experimentCoreLibApi, MissionControlFeatureApi missionControlFeatureApi, TrackingCoreLibApi trackingCoreLibApi) {
            this.missionControlViewComponentImpl = this;
            initialize(experimentCoreLibApi, missionControlFeatureApi, trackingCoreLibApi);
        }

        private void initialize(ExperimentCoreLibApi experimentCoreLibApi, MissionControlFeatureApi missionControlFeatureApi, TrackingCoreLibApi trackingCoreLibApi) {
            GetRepositoryProvider getRepositoryProvider2 = new GetRepositoryProvider(missionControlFeatureApi);
            this.getRepositoryProvider = getRepositoryProvider2;
            this.lifeStyleMissionControlsUseCaseProvider = LifeStyleMissionControlsUseCase_Factory.create(getRepositoryProvider2);
            GetTalabatTrackerProvider getTalabatTrackerProvider2 = new GetTalabatTrackerProvider(trackingCoreLibApi);
            this.getTalabatTrackerProvider = getTalabatTrackerProvider2;
            this.lifeStyleMissionViewModelProvider = LifeStyleMissionViewModel_Factory.create(this.lifeStyleMissionControlsUseCaseProvider, getTalabatTrackerProvider2);
            this.primaryMissionControlsUseCaseProvider = PrimaryMissionControlsUseCase_Factory.create(this.getRepositoryProvider);
            GetExperimentProviderProvider getExperimentProviderProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            this.getExperimentProvider = getExperimentProviderProvider;
            this.primaryMissionViewModelProvider = PrimaryMissionViewModel_Factory.create(this.primaryMissionControlsUseCaseProvider, getExperimentProviderProvider, this.getTalabatTrackerProvider);
        }

        private LifeStyleMissionV2View injectLifeStyleMissionV2View(LifeStyleMissionV2View lifeStyleMissionV2View) {
            LifeStyleMissionV2View_MembersInjector.injectFactory(lifeStyleMissionV2View, lifeStyleMissionViewModelFactory());
            return lifeStyleMissionV2View;
        }

        private LifeStyleMissionView injectLifeStyleMissionView(LifeStyleMissionView lifeStyleMissionView) {
            LifeStyleMissionView_MembersInjector.injectFactory(lifeStyleMissionView, lifeStyleMissionViewModelFactory());
            return lifeStyleMissionView;
        }

        private PrimaryMissionView injectPrimaryMissionView(PrimaryMissionView primaryMissionView) {
            PrimaryMissionView_MembersInjector.injectFactory(primaryMissionView, primaryMissionViewModelFactory());
            return primaryMissionView;
        }

        private LifeStyleMissionViewModelFactory lifeStyleMissionViewModelFactory() {
            return new LifeStyleMissionViewModelFactory(this.lifeStyleMissionViewModelProvider);
        }

        private PrimaryMissionViewModelFactory primaryMissionViewModelFactory() {
            return new PrimaryMissionViewModelFactory(this.primaryMissionViewModelProvider);
        }

        public void inject(LifeStyleMissionView lifeStyleMissionView) {
            injectLifeStyleMissionView(lifeStyleMissionView);
        }

        public void inject(PrimaryMissionView primaryMissionView) {
            injectPrimaryMissionView(primaryMissionView);
        }

        public void inject(LifeStyleMissionV2View lifeStyleMissionV2View) {
            injectLifeStyleMissionV2View(lifeStyleMissionV2View);
        }
    }

    private DaggerMissionControlViewComponent() {
    }

    public static MissionControlViewComponent.Factory factory() {
        return new Factory();
    }
}
