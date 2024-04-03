package com.talabat.growth.features.matketPlace.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategory;", "", "()V", "burnItemsResponse", "", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "getBurnItemsResponse", "()[Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "[Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnItemResponse;", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "categoryName", "getCategoryName", "categoryType", "getCategoryType", "imageURL", "getImageURL", "meta", "Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategoryMeta;", "getMeta", "()Lcom/talabat/growth/features/matketPlace/model/response/MarketPlaceBurnOptionCategoryMeta;", "subtitle", "getSubtitle", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceBurnOptionCategory {
    @SerializedName("burnOptions")
    @Nullable
    private final MarketPlaceBurnItemResponse[] burnItemsResponse;
    @Nullable
    private final String categoryId;
    @Nullable
    private final String categoryName;
    @Nullable
    private final String categoryType;
    @Nullable
    private final String imageURL;
    @SerializedName("meta")
    @Nullable
    private final MarketPlaceBurnOptionCategoryMeta meta;
    @Nullable
    private final String subtitle;

    @Nullable
    public final MarketPlaceBurnItemResponse[] getBurnItemsResponse() {
        return this.burnItemsResponse;
    }

    @Nullable
    public final String getCategoryId() {
        return this.categoryId;
    }

    @Nullable
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    public final String getCategoryType() {
        return this.categoryType;
    }

    @Nullable
    public final String getImageURL() {
        return this.imageURL;
    }

    @Nullable
    public final MarketPlaceBurnOptionCategoryMeta getMeta() {
        return this.meta;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }
}
