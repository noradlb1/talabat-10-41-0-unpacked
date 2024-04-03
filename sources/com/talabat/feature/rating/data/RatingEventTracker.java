package com.talabat.feature.rating.data;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.feature.rating.data.model.RatingScreenEvent;
import com.talabat.feature.rating.domain.EventTracker;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/rating/data/RatingEventTracker;", "Lcom/talabat/feature/rating/domain/EventTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "orderRateClicked", "", "rateOrderEventModel", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "orderRateClosed", "orderRateLoaded", "orderRateSubmitError", "orderRateSubmitted", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingEventTracker implements EventTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public RatingEventTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public void orderRateClicked(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.talabatTracker.track(new RatingScreenEvent(RatingEventTrackerKt.ORDER_RATE_CLICKED, rateOrderEventModel));
    }

    public void orderRateClosed(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.talabatTracker.track(new RatingScreenEvent(RatingEventTrackerKt.ORDER_RATE_CLOSE, rateOrderEventModel));
    }

    public void orderRateLoaded(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.talabatTracker.track(new RatingScreenEvent(RatingEventTrackerKt.ORDER_RATE_LOADED, rateOrderEventModel));
    }

    public void orderRateSubmitError(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.talabatTracker.track(new RatingScreenEvent(RatingEventTrackerKt.ORDER_RATE_SUBMIT_ERROR, rateOrderEventModel));
    }

    public void orderRateSubmitted(@NotNull RateOrderEventModel rateOrderEventModel) {
        Intrinsics.checkNotNullParameter(rateOrderEventModel, "rateOrderEventModel");
        this.talabatTracker.track(new RatingScreenEvent(RatingEventTrackerKt.ORDER_RATE_SUBMITTED, rateOrderEventModel));
    }
}
