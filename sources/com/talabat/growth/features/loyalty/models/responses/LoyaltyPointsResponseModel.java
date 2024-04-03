package com.talabat.growth.features.loyalty.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsResponseModel;", "", "totalPoints", "", "lastOrder", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "expirationText", "", "(Ljava/lang/Integer;Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;Ljava/lang/String;)V", "getExpirationText", "()Ljava/lang/String;", "setExpirationText", "(Ljava/lang/String;)V", "getLastOrder", "()Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "setLastOrder", "(Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;)V", "getTotalPoints", "()Ljava/lang/Integer;", "setTotalPoints", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsResponseModel {
    @SerializedName("expirationText")
    @Nullable
    private String expirationText;
    @SerializedName("lastOrder")
    @Nullable
    private LoyaltyOrderResponseModel lastOrder;
    @SerializedName(alternate = {"points"}, value = "totalPoints")
    @Nullable
    private Integer totalPoints;

    public LoyaltyPointsResponseModel() {
        this((Integer) null, (LoyaltyOrderResponseModel) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public LoyaltyPointsResponseModel(@Nullable Integer num, @Nullable LoyaltyOrderResponseModel loyaltyOrderResponseModel, @Nullable String str) {
        this.totalPoints = num;
        this.lastOrder = loyaltyOrderResponseModel;
        this.expirationText = str;
    }

    @Nullable
    public final String getExpirationText() {
        return this.expirationText;
    }

    @Nullable
    public final LoyaltyOrderResponseModel getLastOrder() {
        return this.lastOrder;
    }

    @Nullable
    public final Integer getTotalPoints() {
        return this.totalPoints;
    }

    public final void setExpirationText(@Nullable String str) {
        this.expirationText = str;
    }

    public final void setLastOrder(@Nullable LoyaltyOrderResponseModel loyaltyOrderResponseModel) {
        this.lastOrder = loyaltyOrderResponseModel;
    }

    public final void setTotalPoints(@Nullable Integer num) {
        this.totalPoints = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoyaltyPointsResponseModel(Integer num, LoyaltyOrderResponseModel loyaltyOrderResponseModel, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : loyaltyOrderResponseModel, (i11 & 4) != 0 ? null : str);
    }
}
