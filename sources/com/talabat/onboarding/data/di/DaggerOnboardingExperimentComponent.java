package com.talabat.onboarding.data.di;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.onboarding.data.di.OnboardingExperimentComponent;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl_Factory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;

@DaggerGenerated
public final class DaggerOnboardingExperimentComponent {

    public static final class Factory implements OnboardingExperimentComponent.Factory {
        private Factory() {
        }

        public OnboardingExperimentComponent create(ExperimentCoreLibApi experimentCoreLibApi, DispatcherCoreLibApi dispatcherCoreLibApi) {
            Preconditions.checkNotNull(experimentCoreLibApi);
            Preconditions.checkNotNull(dispatcherCoreLibApi);
            return new OnboardingExperimentComponentImpl(dispatcherCoreLibApi, experimentCoreLibApi);
        }
    }

    public static final class OnboardingExperimentComponentImpl implements OnboardingExperimentComponent {
        private Provider<IsOnboardingExperimentEnabledUseCase> bindIsOnboardingExperimentEnabledUseCaseProvider;
        private Provider<CoroutineDispatchersFactory> getCoroutineDispatchersFactoryProvider;
        private Provider<ITalabatExperiment> getExperimentProvider;
        private Provider<IsOnboardingExperimentEnabledUseCaseImpl> isOnboardingExperimentEnabledUseCaseImplProvider;
        private final OnboardingExperimentComponentImpl onboardingExperimentComponentImpl;

        public static final class GetCoroutineDispatchersFactoryProvider implements Provider<CoroutineDispatchersFactory> {
            private final DispatcherCoreLibApi dispatcherCoreLibApi;

            public GetCoroutineDispatchersFactoryProvider(DispatcherCoreLibApi dispatcherCoreLibApi2) {
                this.dispatcherCoreLibApi = dispatcherCoreLibApi2;
            }

            public CoroutineDispatchersFactory get() {
                return (CoroutineDispatchersFactory) Preconditions.checkNotNullFromComponent(this.dispatcherCoreLibApi.getCoroutineDispatchersFactory());
            }
        }

        public static final class GetExperimentProviderProvider implements Provider<ITalabatExperiment> {
            private final ExperimentCoreLibApi experimentCoreLibApi;

            public GetExperimentProviderProvider(ExperimentCoreLibApi experimentCoreLibApi2) {
                this.experimentCoreLibApi = experimentCoreLibApi2;
            }

            public ITalabatExperiment get() {
                return (ITalabatExperiment) Preconditions.checkNotNullFromComponent(this.experimentCoreLibApi.getExperimentProvider());
            }
        }

        private OnboardingExperimentComponentImpl(DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi) {
            this.onboardingExperimentComponentImpl = this;
            initialize(dispatcherCoreLibApi, experimentCoreLibApi);
        }

        private void initialize(DispatcherCoreLibApi dispatcherCoreLibApi, ExperimentCoreLibApi experimentCoreLibApi) {
            this.getExperimentProvider = new GetExperimentProviderProvider(experimentCoreLibApi);
            GetCoroutineDispatchersFactoryProvider getCoroutineDispatchersFactoryProvider2 = new GetCoroutineDispatchersFactoryProvider(dispatcherCoreLibApi);
            this.getCoroutineDispatchersFactoryProvider = getCoroutineDispatchersFactoryProvider2;
            IsOnboardingExperimentEnabledUseCaseImpl_Factory create = IsOnboardingExperimentEnabledUseCaseImpl_Factory.create(this.getExperimentProvider, getCoroutineDispatchersFactoryProvider2);
            this.isOnboardingExperimentEnabledUseCaseImplProvider = create;
            this.bindIsOnboardingExperimentEnabledUseCaseProvider = SingleCheck.provider(create);
        }

        public IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase() {
            return this.bindIsOnboardingExperimentEnabledUseCaseProvider.get();
        }
    }

    private DaggerOnboardingExperimentComponent() {
    }

    public static OnboardingExperimentComponent.Factory factory() {
        return new Factory();
    }
}
