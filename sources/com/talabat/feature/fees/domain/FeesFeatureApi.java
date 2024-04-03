package com.talabat.feature.fees.domain;

import com.talabat.core.di.Api;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.feature.fees.domain.repository.IPricingRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/fees/domain/FeesFeatureApi;", "Lcom/talabat/core/di/Api;", "disclaimerRepository", "Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;", "getDisclaimerRepository", "()Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;", "pricingRepository", "Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "getPricingRepository", "()Lcom/talabat/feature/fees/domain/repository/IPricingRepository;", "tracker", "Lcom/talabat/feature/fees/domain/IFeesTracker;", "getTracker", "()Lcom/talabat/feature/fees/domain/IFeesTracker;", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FeesFeatureApi extends Api {
    @NotNull
    IDisclaimerRepository getDisclaimerRepository();

    @NotNull
    IPricingRepository getPricingRepository();

    @NotNull
    IFeesTracker getTracker();
}
