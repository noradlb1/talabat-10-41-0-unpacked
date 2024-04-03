package com.talabat.feature.rating.domain;

import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/talabat/feature/rating/domain/EventTracker;", "", "orderRateClicked", "", "rateOrderEventModel", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "orderRateClosed", "orderRateLoaded", "orderRateSubmitError", "orderRateSubmitted", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface EventTracker {
    void orderRateClicked(@NotNull RateOrderEventModel rateOrderEventModel);

    void orderRateClosed(@NotNull RateOrderEventModel rateOrderEventModel);

    void orderRateLoaded(@NotNull RateOrderEventModel rateOrderEventModel);

    void orderRateSubmitError(@NotNull RateOrderEventModel rateOrderEventModel);

    void orderRateSubmitted(@NotNull RateOrderEventModel rateOrderEventModel);
}
