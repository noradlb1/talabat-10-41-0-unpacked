package com.talabat.feature.rating.data.model;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.feature.rating.data.RatingEventTrackerKt;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/rating/data/model/RatingScreenEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "eventName", "", "rateOrderEventModel", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "(Ljava/lang/String;Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "featureName", "name", "platforms", "", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingScreenEvent extends TalabatEvent {
    @NotNull
    private final String eventName;
    @NotNull
    private final RateOrderEventModel rateOrderEventModel;

    public RatingScreenEvent(@NotNull String str, @NotNull RateOrderEventModel rateOrderEventModel2) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(rateOrderEventModel2, "rateOrderEventModel");
        this.eventName = str;
        this.rateOrderEventModel = rateOrderEventModel2;
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("screenType", this.rateOrderEventModel.getScreenType()), TuplesKt.to("screenName", this.rateOrderEventModel.getScreenName()), TuplesKt.to("transactionId", this.rateOrderEventModel.getTransactionId()), TuplesKt.to("shopName", this.rateOrderEventModel.getVendorName()), TuplesKt.to("chainId", this.rateOrderEventModel.getBranchId()), TuplesKt.to("shopId", this.rateOrderEventModel.getVendorId()), TuplesKt.to("eventOrigin", this.rateOrderEventModel.getEventOrigin()));
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return RatingEventTrackerKt.FEATURE_NEW_RATING_FLOW;
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return this.eventName;
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.NEW_RELIC);
    }
}
