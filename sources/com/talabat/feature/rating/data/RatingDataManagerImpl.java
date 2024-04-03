package com.talabat.feature.rating.data;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.NewRateActivity;
import com.talabat.feature.rating.domain.RatingDataManager;
import com.talabat.feature.rating.domain.RatingDataManagerKt;
import com.talabat.feature.rating.domain.model.RateOrderEventModel;
import com.talabat.feature.rating.domain.model.RateOrderRequest;
import com.talabat.feature.rating.domain.model.RateReason;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\b\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010#\u001a\u00020\u00162\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0004H\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000eH\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u000eH\u0016J\u001c\u0010+\u001a\u00020\u00162\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040-H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J \u00100\u001a\u00020\u00162\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/talabat/feature/rating/data/RatingDataManagerImpl;", "Lcom/talabat/feature/rating/domain/RatingDataManager;", "()V", "commentRating", "", "deliveryExperienceRatingTitle", "deliveryRateReasons", "Ljava/util/ArrayList;", "Lcom/talabat/feature/rating/domain/model/RateReason;", "Lkotlin/collections/ArrayList;", "encryptedOrderId", "rateOrderRequest", "Lcom/talabat/feature/rating/domain/model/RateOrderRequest;", "selectedDeliveryRating", "", "selectedFoodRating", "trackingData", "Lcom/talabat/feature/rating/domain/model/RateOrderEventModel;", "vendorExperienceRatingTitle", "vendorLogoUrl", "vendorRateReasons", "clear", "", "getDeliveryExperienceRatingTitle", "getDeliveryRateReasons", "getEncryptedOrderId", "getRateOrderRequest", "getRatingComment", "getSelectedDeliveryRating", "getSelectedFoodRating", "getTrackingData", "getVendorExperienceRatingTitle", "getVendorLogoUrl", "getVendorRateReasons", "setDeliveryExperienceRatingTitle", "setDeliveryRateReasons", "setEncryptedOrderId", "setRateOrderRequest", "setRatingComment", "comment", "setSelectedDeliveryRating", "rating", "setSelectedFoodRating", "setTrackingData", "map", "", "setVendorExperienceRatingTitle", "setVendorLogoUrl", "setVendorRateReasons", "com_talabat_feature_rating_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RatingDataManagerImpl implements RatingDataManager {
    @NotNull
    private String commentRating = "";
    @NotNull
    private String deliveryExperienceRatingTitle = "";
    @NotNull
    private ArrayList<RateReason> deliveryRateReasons = new ArrayList<>();
    @NotNull
    private String encryptedOrderId = "";
    @NotNull
    private RateOrderRequest rateOrderRequest = new RateOrderRequest((String) null, (String) null, (String) null, (String) null, (ArrayList) null, (ArrayList) null, 63, (DefaultConstructorMarker) null);
    private int selectedDeliveryRating;
    private int selectedFoodRating;
    @NotNull
    private RateOrderEventModel trackingData = new RateOrderEventModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    @NotNull
    private String vendorExperienceRatingTitle = "";
    @Nullable
    private String vendorLogoUrl = "";
    @NotNull
    private ArrayList<RateReason> vendorRateReasons = new ArrayList<>();

    public void clear() {
        this.commentRating = "";
        this.selectedFoodRating = 0;
        this.rateOrderRequest.setReview("");
        this.rateOrderRequest.setDeliveryRating("0");
        this.rateOrderRequest.setVendorRating("0");
        this.rateOrderRequest.getVendorReasons().clear();
        this.rateOrderRequest.getDeliveryReasons().clear();
    }

    @NotNull
    public String getDeliveryExperienceRatingTitle() {
        return this.deliveryExperienceRatingTitle;
    }

    @NotNull
    public ArrayList<RateReason> getDeliveryRateReasons() {
        return this.deliveryRateReasons;
    }

    @NotNull
    public String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @NotNull
    public RateOrderRequest getRateOrderRequest() {
        return this.rateOrderRequest;
    }

    @NotNull
    public String getRatingComment() {
        return this.commentRating;
    }

    public int getSelectedDeliveryRating() {
        return this.selectedDeliveryRating;
    }

    public int getSelectedFoodRating() {
        return this.selectedFoodRating;
    }

    @NotNull
    public RateOrderEventModel getTrackingData() {
        return this.trackingData;
    }

    @NotNull
    public String getVendorExperienceRatingTitle() {
        return this.vendorExperienceRatingTitle;
    }

    @Nullable
    public String getVendorLogoUrl() {
        return this.vendorLogoUrl;
    }

    @NotNull
    public ArrayList<RateReason> getVendorRateReasons() {
        return this.vendorRateReasons;
    }

    public void setDeliveryExperienceRatingTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NewRateActivity.DELIVERY_EXPERIENCE_RATING_TITLE);
        this.deliveryExperienceRatingTitle = str;
    }

    public void setDeliveryRateReasons(@NotNull ArrayList<RateReason> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "deliveryRateReasons");
        this.deliveryRateReasons = arrayList;
    }

    public void setEncryptedOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.rateOrderRequest.setOrderId(str);
        this.encryptedOrderId = str;
    }

    public void setRateOrderRequest(@NotNull RateOrderRequest rateOrderRequest2) {
        Intrinsics.checkNotNullParameter(rateOrderRequest2, "rateOrderRequest");
        this.rateOrderRequest = rateOrderRequest2;
    }

    public void setRatingComment(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "comment");
        this.commentRating = str;
    }

    public void setSelectedDeliveryRating(int i11) {
        this.selectedDeliveryRating = i11;
    }

    public void setSelectedFoodRating(int i11) {
        this.selectedFoodRating = i11;
    }

    public void setTrackingData(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, Param.MAP);
        RateOrderEventModel rateOrderEventModel = this.trackingData;
        String str2 = map.get(RatingDataManagerKt.RATING_ORDER_ID);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = map.get(RatingDataManagerKt.RATING_VENDOR_ID);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = map.get(RatingDataManagerKt.RATING_VENDOR_NAME);
        if (str4 == null) {
            str4 = "";
        }
        String str5 = map.get(RatingDataManagerKt.RATING_BRANCH_ID);
        if (str5 == null) {
            str5 = "";
        }
        String str6 = map.get(RatingDataManagerKt.RATING_EVENT_ORIGIN);
        if (str6 == null) {
            str = "";
        } else {
            str = str6;
        }
        this.trackingData = RateOrderEventModel.copy$default(rateOrderEventModel, str2, str3, str4, str5, (String) null, (String) null, str, 48, (Object) null);
    }

    public void setVendorExperienceRatingTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, NewRateActivity.VENDOR_EXPERIENCE_RATING_TITLE);
        this.vendorExperienceRatingTitle = str;
    }

    public void setVendorLogoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorLogoUrl");
        this.vendorLogoUrl = str;
    }

    public void setVendorRateReasons(@NotNull ArrayList<RateReason> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "vendorRateReasons");
        this.vendorRateReasons = arrayList;
    }
}
