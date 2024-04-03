package com.talabat.growth.features.loyalty.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "", "showBanner", "", "totalPoints", "", "rewardsText", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getRewardsText", "()Ljava/lang/String;", "getShowBanner", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTotalPoints", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsPointsBannerModel {
    @SerializedName("rewardsText")
    @Nullable
    private final String rewardsText;
    @SerializedName("showBanner")
    @Nullable
    private final Boolean showBanner;
    @SerializedName("totalPoints")
    @Nullable
    private final Integer totalPoints;

    public RewardsPointsBannerModel() {
        this((Boolean) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public RewardsPointsBannerModel(@Nullable Boolean bool, @Nullable Integer num, @Nullable String str) {
        this.showBanner = bool;
        this.totalPoints = num;
        this.rewardsText = str;
    }

    @Nullable
    public final String getRewardsText() {
        return this.rewardsText;
    }

    @Nullable
    public final Boolean getShowBanner() {
        return this.showBanner;
    }

    @Nullable
    public final Integer getTotalPoints() {
        return this.totalPoints;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardsPointsBannerModel(Boolean bool, Integer num, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : bool, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : str);
    }
}
