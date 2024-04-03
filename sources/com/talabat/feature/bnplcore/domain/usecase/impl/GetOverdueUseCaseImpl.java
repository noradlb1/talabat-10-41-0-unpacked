package com.talabat.feature.bnplcore.domain.usecase.impl;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.feature.bnplcore.domain.model.Overdues;
import com.talabat.feature.bnplcore.domain.repository.BnplRepository;
import com.talabat.feature.bnplcore.domain.usecase.GetOverdueUseCase;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pl.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\t0\t0\bH\u0002J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/bnplcore/domain/usecase/impl/GetOverdueUseCaseImpl;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase;", "bnplRepo", "Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/feature/bnplcore/domain/repository/BnplRepository;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "featureOff", "Lio/reactivex/Single;", "Lcom/talabat/feature/bnplcore/domain/usecase/GetOverdueUseCase$OverdueResult;", "getOverdues", "kotlin.jvm.PlatformType", "invoke", "isFeatureEnabled", "", "com_talabat_feature_bnpl-core_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOverdueUseCaseImpl implements GetOverdueUseCase {
    @NotNull
    private final BnplRepository bnplRepo;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    @Inject
    public GetOverdueUseCaseImpl(@NotNull BnplRepository bnplRepository, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(bnplRepository, "bnplRepo");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.bnplRepo = bnplRepository;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final Single<GetOverdueUseCase.OverdueResult> featureOff() {
        Single<GetOverdueUseCase.OverdueResult> just = Single.just(GetOverdueUseCase.OverdueResult.Off.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "just(Off)");
        return just;
    }

    private final Single<GetOverdueUseCase.OverdueResult> getOverdues() {
        Single<R> map = this.bnplRepo.getOverdues().map(new a());
        Intrinsics.checkNotNullExpressionValue(map, "bnplRepo.getOverdues()\n …e\n            }\n        }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getOverdues$lambda-0  reason: not valid java name */
    public static final GetOverdueUseCase.OverdueResult m10143getOverdues$lambda0(Overdues overdues) {
        Intrinsics.checkNotNullParameter(overdues, "overdue");
        if (overdues.hasOverdues()) {
            return new GetOverdueUseCase.OverdueResult.Overdue(overdues.getTotalAmount());
        }
        return GetOverdueUseCase.OverdueResult.NoOverdue.INSTANCE;
    }

    private final boolean isFeatureEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.talabatFeatureFlag, OrderingFeatureFlagsKeys.LENDING_BNPL_OVERDUE_ENABLED, false, 2, (Object) null);
    }

    @NotNull
    public Single<GetOverdueUseCase.OverdueResult> invoke() {
        if (isFeatureEnabled()) {
            return getOverdues();
        }
        return featureOff();
    }
}
