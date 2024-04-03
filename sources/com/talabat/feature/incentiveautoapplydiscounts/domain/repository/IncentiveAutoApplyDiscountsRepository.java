package com.talabat.feature.incentiveautoapplydiscounts.domain.repository;

import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscount;
import com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;", "", "getAutoApplyDiscounts", "", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscount;", "autoApplyDiscountsRequest", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;", "(Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_incentive-auto-apply-discounts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IncentiveAutoApplyDiscountsRepository {
    @Nullable
    Object getAutoApplyDiscounts(@NotNull AutoApplyDiscountsRequest autoApplyDiscountsRequest, @NotNull Continuation<? super AutoApplyDiscount[]> continuation);
}
