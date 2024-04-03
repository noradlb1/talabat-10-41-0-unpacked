package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import com.talabat.feature.bnplcore.domain.usecase.UpdateOverdueAcknowledgeStateUseCase;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pl.c;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/UpdateOverdueAcknowledgeStateUseCaseImpl;", "Lcom/talabat/feature/bnplcore/domain/usecase/UpdateOverdueAcknowledgeStateUseCase;", "bnplRepository", "Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "invoke", "Lio/reactivex/Completable;", "overdue", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "isFeatureEnabled", "", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdateOverdueAcknowledgeStateUseCaseImpl implements UpdateOverdueAcknowledgeStateUseCase {
    @NotNull
    private final BnplRepository bnplRepository;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    @Inject
    public UpdateOverdueAcknowledgeStateUseCaseImpl(@NotNull BnplRepository bnplRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(bnplRepository2, "bnplRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.bnplRepository = bnplRepository2;
        this.featureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m10145invoke$lambda0(UpdateOverdueAcknowledgeStateUseCaseImpl updateOverdueAcknowledgeStateUseCaseImpl, OverdueAcknowledgeState overdueAcknowledgeState) {
        Intrinsics.checkNotNullParameter(updateOverdueAcknowledgeStateUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(overdueAcknowledgeState, "$overdue");
        updateOverdueAcknowledgeStateUseCaseImpl.bnplRepository.updateOverdueAcknowledgedState(overdueAcknowledgeState);
    }

    private final boolean isFeatureEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, OrderingFeatureFlagsKeys.LENDING_BNPL_OVERDUE_ENABLED, false, 2, (Object) null);
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlag() {
        return this.featureFlag;
    }

    @NotNull
    public Completable invoke(@NotNull OverdueAcknowledgeState overdueAcknowledgeState) {
        Intrinsics.checkNotNullParameter(overdueAcknowledgeState, "overdue");
        if (isFeatureEnabled()) {
            Completable fromAction = Completable.fromAction(new c(this, overdueAcknowledgeState));
            Intrinsics.checkNotNullExpressionValue(fromAction, "{\n            Completabl…)\n            }\n        }");
            return fromAction;
        }
        Completable never = Completable.never();
        Intrinsics.checkNotNullExpressionValue(never, "{\n            Completable.never()\n        }");
        return never;
    }
}
