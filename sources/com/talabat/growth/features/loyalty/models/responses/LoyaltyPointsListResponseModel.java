package com.talabat.growth.features.loyalty.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR(\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyPointsListResponseModel;", "", "()V", "pageNumber", "", "getPageNumber", "()Ljava/lang/Integer;", "setPageNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageSize", "getPageSize", "setPageSize", "pointsList", "", "Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "getPointsList", "()[Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "setPointsList", "([Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;)V", "[Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "totalCount", "getTotalCount", "setTotalCount", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsListResponseModel {
    @Nullable
    private Integer pageNumber;
    @Nullable
    private Integer pageSize;
    @SerializedName("data")
    @Nullable
    private LoyaltyOrderResponseModel[] pointsList;
    @Nullable
    private Integer totalCount;

    @Nullable
    public final Integer getPageNumber() {
        return this.pageNumber;
    }

    @Nullable
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @Nullable
    public final LoyaltyOrderResponseModel[] getPointsList() {
        return this.pointsList;
    }

    @Nullable
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setPageNumber(@Nullable Integer num) {
        this.pageNumber = num;
    }

    public final void setPageSize(@Nullable Integer num) {
        this.pageSize = num;
    }

    public final void setPointsList(@Nullable LoyaltyOrderResponseModel[] loyaltyOrderResponseModelArr) {
        this.pointsList = loyaltyOrderResponseModelArr;
    }

    public final void setTotalCount(@Nullable Integer num) {
        this.totalCount = num;
    }
}
