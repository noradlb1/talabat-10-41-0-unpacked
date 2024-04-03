package com.talabat.gem.domain.entities;

import com.talabat.impressions.ImpressionsItem;
import datamodels.Restaurant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002BÛ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001cJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010B\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010/J\u000b\u0010G\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010'J\t\u0010J\u001a\u00020\u0004HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jä\u0001\u0010L\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010MJ\u0013\u0010N\u001a\u00020\t2\b\u0010O\u001a\u0004\u0018\u00010PHÖ\u0003J\t\u0010Q\u001a\u00020\u0004HÖ\u0001J\t\u0010R\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b-\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u00100\u001a\u0004\b\b\u0010/R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010+\u001a\u0004\b1\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b9\u0010\u001e¨\u0006S"}, d2 = {"Lcom/talabat/gem/domain/entities/GemRestaurant;", "Ljava/io/Serializable;", "Lcom/talabat/impressions/ImpressionsItem;", "id", "", "name", "", "imageUrl", "isNew", "", "cuisines", "rating", "Lcom/talabat/gem/domain/entities/Rating;", "ratingRaw", "", "reviews", "deliveryAverageTime", "deliveryAverageMinutes", "deliveryCost", "", "reservationCode", "data", "Ldatamodels/Restaurant;", "branchId", "minimumOrderAmount", "verticalType", "deliveryChargesOrigin", "deliveryCostFormatted", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/gem/domain/entities/Rating;Ljava/lang/Float;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ldatamodels/Restaurant;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;)V", "getBranchId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCuisines", "()Ljava/lang/String;", "getData", "()Ldatamodels/Restaurant;", "getDeliveryAverageMinutes", "getDeliveryAverageTime", "getDeliveryChargesOrigin", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDeliveryCost", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDeliveryCostFormatted", "getId", "getImageUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinimumOrderAmount", "getName", "getRating", "()Lcom/talabat/gem/domain/entities/Rating;", "getRatingRaw", "getReservationCode", "getReviews", "()I", "getVerticalType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/gem/domain/entities/Rating;Ljava/lang/Float;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ldatamodels/Restaurant;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/String;)Lcom/talabat/gem/domain/entities/GemRestaurant;", "equals", "other", "", "hashCode", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemRestaurant implements Serializable, ImpressionsItem {
    @Nullable
    private final Integer branchId;
    @Nullable
    private final String cuisines;
    @Nullable
    private final Restaurant data;
    @Nullable
    private final Integer deliveryAverageMinutes;
    @Nullable
    private final String deliveryAverageTime;
    @Nullable
    private final Float deliveryChargesOrigin;
    @Nullable
    private final Double deliveryCost;
    @Nullable
    private final String deliveryCostFormatted;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f60329id;
    @Nullable
    private final String imageUrl;
    @Nullable
    private final Boolean isNew;
    @Nullable
    private final Double minimumOrderAmount;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f60330name;
    @Nullable
    private final Rating rating;
    @Nullable
    private final Float ratingRaw;
    @Nullable
    private final String reservationCode;
    private final int reviews;
    @Nullable
    private final Integer verticalType;

    public GemRestaurant() {
        this((Integer) null, (String) null, (String) null, (Boolean) null, (String) null, (Rating) null, (Float) null, 0, (String) null, (Integer) null, (Double) null, (String) null, (Restaurant) null, (Integer) null, (Double) null, (Integer) null, (Float) null, (String) null, 262143, (DefaultConstructorMarker) null);
    }

    public GemRestaurant(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Rating rating2, @Nullable Float f11, int i11, @Nullable String str4, @Nullable Integer num2, @Nullable Double d11, @Nullable String str5, @Nullable Restaurant restaurant, @Nullable Integer num3, @Nullable Double d12, @Nullable Integer num4, @Nullable Float f12, @Nullable String str6) {
        this.f60329id = num;
        this.f60330name = str;
        this.imageUrl = str2;
        this.isNew = bool;
        this.cuisines = str3;
        this.rating = rating2;
        this.ratingRaw = f11;
        this.reviews = i11;
        this.deliveryAverageTime = str4;
        this.deliveryAverageMinutes = num2;
        this.deliveryCost = d11;
        this.reservationCode = str5;
        this.data = restaurant;
        this.branchId = num3;
        this.minimumOrderAmount = d12;
        this.verticalType = num4;
        this.deliveryChargesOrigin = f12;
        this.deliveryCostFormatted = str6;
    }

    public static /* synthetic */ GemRestaurant copy$default(GemRestaurant gemRestaurant, Integer num, String str, String str2, Boolean bool, String str3, Rating rating2, Float f11, int i11, String str4, Integer num2, Double d11, String str5, Restaurant restaurant, Integer num3, Double d12, Integer num4, Float f12, String str6, int i12, Object obj) {
        GemRestaurant gemRestaurant2 = gemRestaurant;
        int i13 = i12;
        return gemRestaurant.copy((i13 & 1) != 0 ? gemRestaurant.getId() : num, (i13 & 2) != 0 ? gemRestaurant2.f60330name : str, (i13 & 4) != 0 ? gemRestaurant2.imageUrl : str2, (i13 & 8) != 0 ? gemRestaurant2.isNew : bool, (i13 & 16) != 0 ? gemRestaurant2.cuisines : str3, (i13 & 32) != 0 ? gemRestaurant2.rating : rating2, (i13 & 64) != 0 ? gemRestaurant2.ratingRaw : f11, (i13 & 128) != 0 ? gemRestaurant2.reviews : i11, (i13 & 256) != 0 ? gemRestaurant2.deliveryAverageTime : str4, (i13 & 512) != 0 ? gemRestaurant2.deliveryAverageMinutes : num2, (i13 & 1024) != 0 ? gemRestaurant2.deliveryCost : d11, (i13 & 2048) != 0 ? gemRestaurant2.reservationCode : str5, (i13 & 4096) != 0 ? gemRestaurant2.data : restaurant, (i13 & 8192) != 0 ? gemRestaurant2.branchId : num3, (i13 & 16384) != 0 ? gemRestaurant2.minimumOrderAmount : d12, (i13 & 32768) != 0 ? gemRestaurant2.verticalType : num4, (i13 & 65536) != 0 ? gemRestaurant2.deliveryChargesOrigin : f12, (i13 & 131072) != 0 ? gemRestaurant2.deliveryCostFormatted : str6);
    }

    @Nullable
    public final Integer component1() {
        return getId();
    }

    @Nullable
    public final Integer component10() {
        return this.deliveryAverageMinutes;
    }

    @Nullable
    public final Double component11() {
        return this.deliveryCost;
    }

    @Nullable
    public final String component12() {
        return this.reservationCode;
    }

    @Nullable
    public final Restaurant component13() {
        return this.data;
    }

    @Nullable
    public final Integer component14() {
        return this.branchId;
    }

    @Nullable
    public final Double component15() {
        return this.minimumOrderAmount;
    }

    @Nullable
    public final Integer component16() {
        return this.verticalType;
    }

    @Nullable
    public final Float component17() {
        return this.deliveryChargesOrigin;
    }

    @Nullable
    public final String component18() {
        return this.deliveryCostFormatted;
    }

    @Nullable
    public final String component2() {
        return this.f60330name;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @Nullable
    public final Boolean component4() {
        return this.isNew;
    }

    @Nullable
    public final String component5() {
        return this.cuisines;
    }

    @Nullable
    public final Rating component6() {
        return this.rating;
    }

    @Nullable
    public final Float component7() {
        return this.ratingRaw;
    }

    public final int component8() {
        return this.reviews;
    }

    @Nullable
    public final String component9() {
        return this.deliveryAverageTime;
    }

    @NotNull
    public final GemRestaurant copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable Rating rating2, @Nullable Float f11, int i11, @Nullable String str4, @Nullable Integer num2, @Nullable Double d11, @Nullable String str5, @Nullable Restaurant restaurant, @Nullable Integer num3, @Nullable Double d12, @Nullable Integer num4, @Nullable Float f12, @Nullable String str6) {
        return new GemRestaurant(num, str, str2, bool, str3, rating2, f11, i11, str4, num2, d11, str5, restaurant, num3, d12, num4, f12, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemRestaurant)) {
            return false;
        }
        GemRestaurant gemRestaurant = (GemRestaurant) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) gemRestaurant.getId()) && Intrinsics.areEqual((Object) this.f60330name, (Object) gemRestaurant.f60330name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) gemRestaurant.imageUrl) && Intrinsics.areEqual((Object) this.isNew, (Object) gemRestaurant.isNew) && Intrinsics.areEqual((Object) this.cuisines, (Object) gemRestaurant.cuisines) && this.rating == gemRestaurant.rating && Intrinsics.areEqual((Object) this.ratingRaw, (Object) gemRestaurant.ratingRaw) && this.reviews == gemRestaurant.reviews && Intrinsics.areEqual((Object) this.deliveryAverageTime, (Object) gemRestaurant.deliveryAverageTime) && Intrinsics.areEqual((Object) this.deliveryAverageMinutes, (Object) gemRestaurant.deliveryAverageMinutes) && Intrinsics.areEqual((Object) this.deliveryCost, (Object) gemRestaurant.deliveryCost) && Intrinsics.areEqual((Object) this.reservationCode, (Object) gemRestaurant.reservationCode) && Intrinsics.areEqual((Object) this.data, (Object) gemRestaurant.data) && Intrinsics.areEqual((Object) this.branchId, (Object) gemRestaurant.branchId) && Intrinsics.areEqual((Object) this.minimumOrderAmount, (Object) gemRestaurant.minimumOrderAmount) && Intrinsics.areEqual((Object) this.verticalType, (Object) gemRestaurant.verticalType) && Intrinsics.areEqual((Object) this.deliveryChargesOrigin, (Object) gemRestaurant.deliveryChargesOrigin) && Intrinsics.areEqual((Object) this.deliveryCostFormatted, (Object) gemRestaurant.deliveryCostFormatted);
    }

    @Nullable
    public final Integer getBranchId() {
        return this.branchId;
    }

    @Nullable
    public final String getCuisines() {
        return this.cuisines;
    }

    @Nullable
    public final Restaurant getData() {
        return this.data;
    }

    @Nullable
    public final Integer getDeliveryAverageMinutes() {
        return this.deliveryAverageMinutes;
    }

    @Nullable
    public final String getDeliveryAverageTime() {
        return this.deliveryAverageTime;
    }

    @Nullable
    public final Float getDeliveryChargesOrigin() {
        return this.deliveryChargesOrigin;
    }

    @Nullable
    public final Double getDeliveryCost() {
        return this.deliveryCost;
    }

    @Nullable
    public final String getDeliveryCostFormatted() {
        return this.deliveryCostFormatted;
    }

    @Nullable
    public Integer getId() {
        return this.f60329id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final Double getMinimumOrderAmount() {
        return this.minimumOrderAmount;
    }

    @Nullable
    public final String getName() {
        return this.f60330name;
    }

    @Nullable
    public final Rating getRating() {
        return this.rating;
    }

    @Nullable
    public final Float getRatingRaw() {
        return this.ratingRaw;
    }

    @Nullable
    public final String getReservationCode() {
        return this.reservationCode;
    }

    public final int getReviews() {
        return this.reviews;
    }

    @Nullable
    public final Integer getVerticalType() {
        return this.verticalType;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = (getId() == null ? 0 : getId().hashCode()) * 31;
        String str = this.f60330name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isNew;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.cuisines;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Rating rating2 = this.rating;
        int hashCode6 = (hashCode5 + (rating2 == null ? 0 : rating2.hashCode())) * 31;
        Float f11 = this.ratingRaw;
        int hashCode7 = (((hashCode6 + (f11 == null ? 0 : f11.hashCode())) * 31) + this.reviews) * 31;
        String str4 = this.deliveryAverageTime;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.deliveryAverageMinutes;
        int hashCode9 = (hashCode8 + (num == null ? 0 : num.hashCode())) * 31;
        Double d11 = this.deliveryCost;
        int hashCode10 = (hashCode9 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str5 = this.reservationCode;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Restaurant restaurant = this.data;
        int hashCode12 = (hashCode11 + (restaurant == null ? 0 : restaurant.hashCode())) * 31;
        Integer num2 = this.branchId;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Double d12 = this.minimumOrderAmount;
        int hashCode14 = (hashCode13 + (d12 == null ? 0 : d12.hashCode())) * 31;
        Integer num3 = this.verticalType;
        int hashCode15 = (hashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Float f12 = this.deliveryChargesOrigin;
        int hashCode16 = (hashCode15 + (f12 == null ? 0 : f12.hashCode())) * 31;
        String str6 = this.deliveryCostFormatted;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode16 + i11;
    }

    @Nullable
    public final Boolean isNew() {
        return this.isNew;
    }

    @NotNull
    public String toString() {
        Integer id2 = getId();
        String str = this.f60330name;
        String str2 = this.imageUrl;
        Boolean bool = this.isNew;
        String str3 = this.cuisines;
        Rating rating2 = this.rating;
        Float f11 = this.ratingRaw;
        int i11 = this.reviews;
        String str4 = this.deliveryAverageTime;
        Integer num = this.deliveryAverageMinutes;
        Double d11 = this.deliveryCost;
        String str5 = this.reservationCode;
        Restaurant restaurant = this.data;
        Integer num2 = this.branchId;
        Double d12 = this.minimumOrderAmount;
        Integer num3 = this.verticalType;
        Float f12 = this.deliveryChargesOrigin;
        String str6 = this.deliveryCostFormatted;
        return "GemRestaurant(id=" + id2 + ", name=" + str + ", imageUrl=" + str2 + ", isNew=" + bool + ", cuisines=" + str3 + ", rating=" + rating2 + ", ratingRaw=" + f11 + ", reviews=" + i11 + ", deliveryAverageTime=" + str4 + ", deliveryAverageMinutes=" + num + ", deliveryCost=" + d11 + ", reservationCode=" + str5 + ", data=" + restaurant + ", branchId=" + num2 + ", minimumOrderAmount=" + d12 + ", verticalType=" + num3 + ", deliveryChargesOrigin=" + f12 + ", deliveryCostFormatted=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GemRestaurant(java.lang.Integer r20, java.lang.String r21, java.lang.String r22, java.lang.Boolean r23, java.lang.String r24, com.talabat.gem.domain.entities.Rating r25, java.lang.Float r26, int r27, java.lang.String r28, java.lang.Integer r29, java.lang.Double r30, java.lang.String r31, datamodels.Restaurant r32, java.lang.Integer r33, java.lang.Double r34, java.lang.Integer r35, java.lang.Float r36, java.lang.String r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r22
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r23
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r29
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r30
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r31
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r32
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r33
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r34
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r35
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r36
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x009b
        L_0x0099:
            r0 = r37
        L_0x009b:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.entities.GemRestaurant.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, com.talabat.gem.domain.entities.Rating, java.lang.Float, int, java.lang.String, java.lang.Integer, java.lang.Double, java.lang.String, datamodels.Restaurant, java.lang.Integer, java.lang.Double, java.lang.Integer, java.lang.Float, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
