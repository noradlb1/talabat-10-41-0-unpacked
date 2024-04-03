package com.talabat.feature.ridertips.domain;

import com.talabat.core.di.Api;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/ridertips/domain/RiderTipFeatureApi;", "Lcom/talabat/core/di/Api;", "repository", "Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "getRepository", "()Lcom/talabat/feature/ridertips/domain/IRiderTipRepository;", "riderTipObservability", "Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;", "getRiderTipObservability", "()Lcom/talabat/feature/ridertips/domain/IRiderTipObservability;", "tracker", "Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "getTracker", "()Lcom/talabat/feature/ridertips/domain/IRiderTipTracker;", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RiderTipFeatureApi extends Api {
    @NotNull
    IRiderTipRepository getRepository();

    @NotNull
    IRiderTipObservability getRiderTipObservability();

    @NotNull
    IRiderTipTracker getTracker();
}
