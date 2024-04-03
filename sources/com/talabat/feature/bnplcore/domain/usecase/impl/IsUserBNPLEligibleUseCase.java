package com.talabat.feature.bnplcore.domain.usecase.impl;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/IsUserBNPLEligibleUseCase;", "", "bNPLCoreFlutterChannel", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/BNPLCoreFlutterChannel;", "(Lcom/talabat/feature/bnplcore/domain/usecase/impl/BNPLCoreFlutterChannel;)V", "invoke", "Lcom/talabat/feature/bnplcore/domain/usecase/impl/UserBNPLEligibility;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserBNPLEligibleUseCase {
    @NotNull
    private final BNPLCoreFlutterChannel bNPLCoreFlutterChannel;

    @Inject
    public IsUserBNPLEligibleUseCase(@NotNull BNPLCoreFlutterChannel bNPLCoreFlutterChannel2) {
        Intrinsics.checkNotNullParameter(bNPLCoreFlutterChannel2, "bNPLCoreFlutterChannel");
        this.bNPLCoreFlutterChannel = bNPLCoreFlutterChannel2;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super UserBNPLEligibility> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.bNPLCoreFlutterChannel.isUserBNPLEligible(new IsUserBNPLEligibleUseCase$invoke$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
