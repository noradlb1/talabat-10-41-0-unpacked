package com.talabat.talabatlife.features.vendors.vendorList.models.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR&\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010(\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\"\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR\"\u00105\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001d¨\u00068"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorList/models/response/Vendor;", "", "()V", "cuisines", "", "getCuisines", "()Ljava/lang/String;", "setCuisines", "(Ljava/lang/String;)V", "imageUrl", "getImageUrl", "setImageUrl", "insideSelectedArea", "", "getInsideSelectedArea", "()Ljava/lang/Boolean;", "setInsideSelectedArea", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isNew", "setNew", "logoUrl", "getLogoUrl", "setLogoUrl", "minimumDistanceFromCustomer", "", "getMinimumDistanceFromCustomer", "()Ljava/lang/Integer;", "setMinimumDistanceFromCustomer", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "name", "getName", "setName", "offers", "", "getOffers", "()Ljava/util/List;", "setOffers", "(Ljava/util/List;)V", "outletsCount", "getOutletsCount", "setOutletsCount", "rating", "", "getRating", "()Ljava/lang/Double;", "setRating", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "restaurantId", "getRestaurantId", "setRestaurantId", "reviewsCount", "getReviewsCount", "setReviewsCount", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Vendor {
    @SerializedName("cuisines")
    @Nullable
    private String cuisines;
    @SerializedName("imageUrl")
    @Nullable
    private String imageUrl;
    @SerializedName("insideSelectedArea")
    @Nullable
    private Boolean insideSelectedArea;
    @SerializedName("isNew")
    @Nullable
    private Boolean isNew = Boolean.FALSE;
    @SerializedName("logoUrl")
    @Nullable
    private String logoUrl;
    @SerializedName("minimumDistanceFromCustomer")
    @Nullable
    private Integer minimumDistanceFromCustomer;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f12056name;
    @SerializedName("offers")
    @Nullable
    private List<String> offers;
    @SerializedName("vendorsCount")
    @Nullable
    private Integer outletsCount;
    @SerializedName("rating")
    @Nullable
    private Double rating;
    @SerializedName("id")
    @Nullable
    private Integer restaurantId;
    @SerializedName("reviewsCount")
    @Nullable
    private Integer reviewsCount;

    @Nullable
    public final String getCuisines() {
        return this.cuisines;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final Boolean getInsideSelectedArea() {
        return this.insideSelectedArea;
    }

    @Nullable
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    @Nullable
    public final Integer getMinimumDistanceFromCustomer() {
        return this.minimumDistanceFromCustomer;
    }

    @Nullable
    public final String getName() {
        return this.f12056name;
    }

    @Nullable
    public final List<String> getOffers() {
        return this.offers;
    }

    @Nullable
    public final Integer getOutletsCount() {
        return this.outletsCount;
    }

    @Nullable
    public final Double getRating() {
        return this.rating;
    }

    @Nullable
    public final Integer getRestaurantId() {
        return this.restaurantId;
    }

    @Nullable
    public final Integer getReviewsCount() {
        return this.reviewsCount;
    }

    @Nullable
    public final Boolean isNew() {
        return this.isNew;
    }

    public final void setCuisines(@Nullable String str) {
        this.cuisines = str;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setInsideSelectedArea(@Nullable Boolean bool) {
        this.insideSelectedArea = bool;
    }

    public final void setLogoUrl(@Nullable String str) {
        this.logoUrl = str;
    }

    public final void setMinimumDistanceFromCustomer(@Nullable Integer num) {
        this.minimumDistanceFromCustomer = num;
    }

    public final void setName(@Nullable String str) {
        this.f12056name = str;
    }

    public final void setNew(@Nullable Boolean bool) {
        this.isNew = bool;
    }

    public final void setOffers(@Nullable List<String> list) {
        this.offers = list;
    }

    public final void setOutletsCount(@Nullable Integer num) {
        this.outletsCount = num;
    }

    public final void setRating(@Nullable Double d11) {
        this.rating = d11;
    }

    public final void setRestaurantId(@Nullable Integer num) {
        this.restaurantId = num;
    }

    public final void setReviewsCount(@Nullable Integer num) {
        this.reviewsCount = num;
    }
}
