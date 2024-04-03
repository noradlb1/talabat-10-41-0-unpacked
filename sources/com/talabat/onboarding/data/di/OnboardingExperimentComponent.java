package com.talabat.onboarding.data.di;

import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.onboarding.domain.di.OnBoardingExperimentApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/onboarding/data/di/OnboardingExperimentComponent;", "Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "Factory", "com_talabat_core_onboarding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {DispatcherCoreLibApi.class, ExperimentCoreLibApi.class}, modules = {OnboardingExperimentEnabledUseCaseDomainModule.class})
public interface OnboardingExperimentComponent extends OnBoardingExperimentApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/onboarding/data/di/OnboardingExperimentComponent$Factory;", "", "create", "Lcom/talabat/onboarding/data/di/OnboardingExperimentComponent;", "talabatExperimentApi", "Lcom/talabat/core/experiment/domain/ExperimentCoreLibApi;", "dispatcherCoreLibApi", "Lcom/talabat/core/dispatcher/domain/DispatcherCoreLibApi;", "com_talabat_core_onboarding_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        OnboardingExperimentComponent create(@NotNull ExperimentCoreLibApi experimentCoreLibApi, @NotNull DispatcherCoreLibApi dispatcherCoreLibApi);
    }
}
