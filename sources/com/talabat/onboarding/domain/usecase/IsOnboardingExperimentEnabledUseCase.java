package com.talabat.onboarding.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦Bø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_onboarding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IsOnboardingExperimentEnabledUseCase {
    @Nullable
    Object invoke(@NotNull Continuation<? super Boolean> continuation);
}
