package com.talabat.onboarding.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl", f = "IsOnboardingExperiementEnabledUseCase.kt", i = {}, l = {29}, m = "invoke", n = {}, s = {})
public final class IsOnboardingExperimentEnabledUseCaseImpl$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61173h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IsOnboardingExperimentEnabledUseCaseImpl f61174i;

    /* renamed from: j  reason: collision with root package name */
    public int f61175j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsOnboardingExperimentEnabledUseCaseImpl$invoke$1(IsOnboardingExperimentEnabledUseCaseImpl isOnboardingExperimentEnabledUseCaseImpl, Continuation<? super IsOnboardingExperimentEnabledUseCaseImpl$invoke$1> continuation) {
        super(continuation);
        this.f61174i = isOnboardingExperimentEnabledUseCaseImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61173h = obj;
        this.f61175j |= Integer.MIN_VALUE;
        return this.f61174i.invoke(this);
    }
}
