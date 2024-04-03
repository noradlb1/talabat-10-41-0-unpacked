package com.talabat.onboarding.domain.di;

import com.talabat.core.di.Api;
import com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/onboarding/domain/di/OnBoardingExperimentApi;", "Lcom/talabat/core/di/Api;", "isOnboardingExperimentEnabledUseCase", "Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "()Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "com_talabat_core_onboarding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnBoardingExperimentApi extends Api {
    @NotNull
    IsOnboardingExperimentEnabledUseCase isOnboardingExperimentEnabledUseCase();
}
