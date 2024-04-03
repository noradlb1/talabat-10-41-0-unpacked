package com.talabat.growth.features.matketPlace.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnListResponse;", "", "()V", "data", "", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;", "getData", "()[Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;", "setData", "([Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;)V", "[Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;", "pageNumber", "", "getPageNumber", "()Ljava/lang/Integer;", "setPageNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "pageSize", "getPageSize", "setPageSize", "totalCount", "getTotalCount", "setTotalCount", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceBurnListResponse {
    @SerializedName("burnOptionCategories")
    @Nullable
    private MarketPlaceBurnOptionCategory[] data;
    @Nullable
    private Integer pageNumber;
    @Nullable
    private Integer pageSize;
    @Nullable
    private Integer totalCount;

    @Nullable
    public final MarketPlaceBurnOptionCategory[] getData() {
        return this.data;
    }

    @Nullable
    public final Integer getPageNumber() {
        return this.pageNumber;
    }

    @Nullable
    public final Integer getPageSize() {
        return this.pageSize;
    }

    @Nullable
    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final void setData(@Nullable MarketPlaceBurnOptionCategory[] marketPlaceBurnOptionCategoryArr) {
        this.data = marketPlaceBurnOptionCategoryArr;
    }

    public final void setPageNumber(@Nullable Integer num) {
        this.pageNumber = num;
    }

    public final void setPageSize(@Nullable Integer num) {
        this.pageSize = num;
    }

    public final void setTotalCount(@Nullable Integer num) {
        this.totalCount = num;
    }
}
