package com.talabat.feature.rating.domain;

import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RateReason;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\b\u0010\n\u001a\u00020\u0005H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0005H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005H&J \u0010\u0018\u001a\u00020\u00032\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000fH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000fH&J\u001c\u0010#\u001a\u00020\u00032\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050%H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0005H&J \u0010*\u001a\u00020\u00032\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH&¨\u0006,"}, d2 = {"Lcom/talabat/feature/rating/domain/RatingDataManager;", "", "clear", "", "getDeliveryExperienceRatingTitle", "", "getDeliveryRateReasons", "Ljava/util/ArrayList;", "Lcom/talabat/feature/rating/domain/model/RateReason;", "Lkotlin/collections/ArrayList;", "getEncryptedOrderId", "getRateOrderRequest", "Lcom/talabat/feature/rating/domain/model/RateOrderRequest;", "getRatingComment", "getSelectedDeliveryRating", "", "getSelectedFoodRating", "getTrackingData", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "getVendorExperienceRatingTitle", "getVendorLogoUrl", "getVendorRateReasons", "setDeliveryExperienceRatingTitle", "deliveryExperienceRatingTitle", "setDeliveryRateReasons", "deliveryRateReasons", "setEncryptedOrderId", "encryptedOrderId", "setRateOrderRequest", "rateOrderRequest", "setRatingComment", "comment", "setSelectedDeliveryRating", "rating", "setSelectedFoodRating", "setTrackingData", "map", "", "setVendorExperienceRatingTitle", "vendorExperienceRatingTitle", "setVendorLogoUrl", "vendorLogoUrl", "setVendorRateReasons", "vendorRateReasons", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RatingDataManager {
    void clear();

    @NotNull
    String getDeliveryExperienceRatingTitle();

    @NotNull
    ArrayList<RateReason> getDeliveryRateReasons();

    @NotNull
    String getEncryptedOrderId();

    @Nullable
    RateOrderRequest getRateOrderRequest();

    @NotNull
    String getRatingComment();

    int getSelectedDeliveryRating();

    int getSelectedFoodRating();

    @NotNull
    RateOrderEventModel getTrackingData();

    @NotNull
    String getVendorExperienceRatingTitle();

    @Nullable
    String getVendorLogoUrl();

    @NotNull
    ArrayList<RateReason> getVendorRateReasons();

    void setDeliveryExperienceRatingTitle(@NotNull String str);

    void setDeliveryRateReasons(@NotNull ArrayList<RateReason> arrayList);

    void setEncryptedOrderId(@NotNull String str);

    void setRateOrderRequest(@NotNull RateOrderRequest rateOrderRequest);

    void setRatingComment(@NotNull String str);

    void setSelectedDeliveryRating(int i11);

    void setSelectedFoodRating(int i11);

    void setTrackingData(@NotNull Map<String, String> map);

    void setVendorExperienceRatingTitle(@NotNull String str);

    void setVendorLogoUrl(@NotNull String str);

    void setVendorRateReasons(@NotNull ArrayList<RateReason> arrayList);
}
