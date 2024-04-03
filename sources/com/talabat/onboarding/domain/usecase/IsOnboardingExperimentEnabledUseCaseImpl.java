package com.talabat.onboarding.domain.usecase;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCaseImpl;", "Lcom/talabat/onboarding/domain/usecase/IsOnboardingExperimentEnabledUseCase;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_core_onboarding_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsOnboardingExperimentEnabledUseCaseImpl implements IsOnboardingExperimentEnabledUseCase {
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatExperiment talabatExperiment;

    @Inject
    public IsOnboardingExperimentEnabledUseCaseImpl(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        this.talabatExperiment = iTalabatExperiment;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$1 r0 = (com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$1) r0
            int r1 = r0.f61175j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61175j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$1 r0 = new com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f61173h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61175j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0061
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.core.experiment.domain.ITalabatExperiment r7 = r6.talabatExperiment
            com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys r2 = com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageExperimentsKeys.HOMEPAGE_NEW_ONBOARDING
            java.lang.String r4 = ""
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r5 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            java.lang.String r7 = r7.getStringVariant(r2, r4, r5)
            int r2 = r7.length()
            if (r2 != 0) goto L_0x0048
            r2 = r3
            goto L_0x0049
        L_0x0048:
            r2 = 0
        L_0x0049:
            if (r2 != 0) goto L_0x004c
            goto L_0x0063
        L_0x004c:
            com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r7 = r6.coroutineDispatchersFactory
            kotlinx.coroutines.CoroutineDispatcher r7 = r7.io()
            com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1 r2 = new com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl$invoke$experiment$1
            r4 = 0
            r2.<init>(r6, r4)
            r0.f61175j = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)
            if (r7 != r1) goto L_0x0061
            return r1
        L_0x0061:
            java.lang.String r7 = (java.lang.String) r7
        L_0x0063:
            java.lang.String r0 = "Control"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            r7 = r7 ^ r3
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.onboarding.domain.usecase.IsOnboardingExperimentEnabledUseCaseImpl.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
