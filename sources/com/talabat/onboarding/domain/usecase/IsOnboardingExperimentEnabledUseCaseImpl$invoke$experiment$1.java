package com.talabat.onboarding.domain.usecase;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1", f = "IsOnboardingExperiementEnabledUseCase.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f61176h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IsOnboardingExperimentEnabledUseCaseImpl f61177i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1(IsOnboardingExperimentEnabledUseCaseImpl isOnboardingExperimentEnabledUseCaseImpl, Continuation<? super IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1> continuation) {
        super(2, continuation);
        this.f61177i = isOnboardingExperimentEnabledUseCaseImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1 isOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1 = new IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1(this.f61177i, continuation);
        isOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1.L$0 = obj;
        return isOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return ((IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f61176h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IsOnboardingExperimentEnabledUseCaseImpl isOnboardingExperimentEnabledUseCaseImpl = this.f61177i;
            Result.Companion companion = Result.Companion;
            ITalabatExperiment access$getTalabatExperiment$p = isOnboardingExperimentEnabledUseCaseImpl.talabatExperiment;
            HomePageExperimentsKeys homePageExperimentsKeys = HomePageExperimentsKeys.HOMEPAGE_NEW_ONBOARDING;
            TalabatExperimentDataSourceStrategy talabatExperimentDataSourceStrategy = TalabatExperimentDataSourceStrategy.FWF;
            this.f61176h = 1;
            obj = access$getTalabatExperiment$p.getStringVariant((FWFKey) homePageExperimentsKeys, "Control", true, talabatExperimentDataSourceStrategy, (Continuation<? super String>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m6329constructorimpl((String) obj);
        if (Result.m6332exceptionOrNullimpl(obj2) == null) {
            return obj2;
        }
        return "Control";
    }
}
