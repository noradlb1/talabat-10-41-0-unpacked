package com.talabat.feature.incentiveautoapplydiscounts.domain.di;

import com.talabat.core.di.Api;
import com.talabat.feature.incentiveautoapplydiscounts.domain.repository.IncentiveAutoApplyDiscountsRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/domain/di/IncentiveAutoApplyDiscountsFeatureApi;", "Lcom/talabat/core/di/Api;", "repository", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;", "getRepository", "()Lcom/talabat/feature/incentiveautoapplydiscounts/domain/repository/IncentiveAutoApplyDiscountsRepository;", "com_talabat_feature_incentive-auto-apply-discounts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IncentiveAutoApplyDiscountsFeatureApi extends Api {
    @NotNull
    IncentiveAutoApplyDiscountsRepository getRepository();
}
