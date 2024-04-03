package com.talabat.feature.incentiveautoapplydiscounts.domain;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.rx2.RxSingleKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/domain/GetAutoApplyDiscountsUseCase;", "", "incentiveBookingRepository", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;", "(Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;)V", "invoke", "Lio/reactivex/Single;", "", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "autoApplyDiscountsRequest", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;", "com_talabat_feature_incentive-auto-apply-discounts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAutoApplyDiscountsUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final IncentiveAutoApplyDiscountsRepository incentiveBookingRepository;

    @Inject
    public GetAutoApplyDiscountsUseCase(@NotNull IncentiveAutoApplyDiscountsRepository incentiveAutoApplyDiscountsRepository) {
        Intrinsics.checkNotNullParameter(incentiveAutoApplyDiscountsRepository, "incentiveBookingRepository");
        this.incentiveBookingRepository = incentiveAutoApplyDiscountsRepository;
    }

    @NotNull
    public final Single<AutoApplyDiscount[]> invoke(@NotNull AutoApplyDiscountsRequest autoApplyDiscountsRequest) {
        Intrinsics.checkNotNullParameter(autoApplyDiscountsRequest, "autoApplyDiscountsRequest");
        return RxSingleKt.rxSingle$default((CoroutineContext) null, new GetAutoApplyDiscountsUseCase$invoke$1(this, autoApplyDiscountsRequest, (Continuation<? super GetAutoApplyDiscountsUseCase$invoke$1>) null), 1, (Object) null);
    }
}
