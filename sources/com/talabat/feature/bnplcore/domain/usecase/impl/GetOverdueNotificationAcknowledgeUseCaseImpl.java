package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.feature.bnplcore.domain.model.OverdueAcknowledgeState;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueNotificationAcknowledgeUseCase;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/GetOverdueNotificationAcknowledgeUseCaseImpl;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueNotificationAcknowledgeUseCase;", "bnplRepository", "Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "acknowledged", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/model/OverdueAcknowledgeState;", "invoke", "isFeatureEnabled", "", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOverdueNotificationAcknowledgeUseCaseImpl implements GetOverdueNotificationAcknowledgeUseCase {
    @NotNull
    private final BnplRepository bnplRepository;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public GetOverdueNotificationAcknowledgeUseCaseImpl(@NotNull BnplRepository bnplRepository2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(bnplRepository2, "bnplRepository");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.bnplRepository = bnplRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final Single<OverdueAcknowledgeState> acknowledged() {
        Single<OverdueAcknowledgeState> just = Single.just(OverdueAcknowledgeState.ACKNOWLEDGED);
        Intrinsics.checkNotNullExpressionValue(just, "just(ACKNOWLEDGED)");
        return just;
    }

    private final boolean isFeatureEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, OrderingFeatureFlagsKeys.LENDING_BNPL_OVERDUE_ENABLED, false, 2, (Object) null);
    }

    @NotNull
    public Single<OverdueAcknowledgeState> invoke() {
        return isFeatureEnabled() ? this.bnplRepository.getOverdueAcknowledgeState() : acknowledged();
    }
}
