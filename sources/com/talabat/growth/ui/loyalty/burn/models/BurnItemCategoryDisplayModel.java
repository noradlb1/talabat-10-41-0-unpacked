package com.talabat.growth.ui.loyalty.burn.models;

import com.talabat.talabatcommon.extentions.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "", "()V", "burnItemsDisplayModel", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "getBurnItemsDisplayModel", "()Ljava/util/List;", "setBurnItemsDisplayModel", "(Ljava/util/List;)V", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "categoryName", "getCategoryName", "setCategoryName", "categoryType", "getCategoryType", "setCategoryType", "imageURL", "getImageURL", "setImageURL", "meta", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryMetaDisplayModel;", "getMeta", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryMetaDisplayModel;", "setMeta", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryMetaDisplayModel;)V", "subtitle", "getSubtitle", "setSubtitle", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnItemCategoryDisplayModel {
    @NotNull
    private List<BurnItemDisplayModel> burnItemsDisplayModel = new ArrayList();
    @NotNull
    private String categoryId;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryType;
    @NotNull
    private String imageURL;
    @NotNull
    private BurnItemCategoryMetaDisplayModel meta = new BurnItemCategoryMetaDisplayModel((BurnItemCategoryViewType) null, 1, (DefaultConstructorMarker) null);
    @NotNull
    private String subtitle;

    public BurnItemCategoryDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.categoryId = StringUtils.empty(stringCompanionObject);
        this.categoryName = StringUtils.empty(stringCompanionObject);
        this.categoryType = StringUtils.empty(stringCompanionObject);
        this.subtitle = StringUtils.empty(stringCompanionObject);
        this.imageURL = StringUtils.empty(stringCompanionObject);
    }

    @NotNull
    public final List<BurnItemDisplayModel> getBurnItemsDisplayModel() {
        return this.burnItemsDisplayModel;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    @NotNull
    public final String getCategoryName() {
        return this.categoryName;
    }

    @NotNull
    public final String getCategoryType() {
        return this.categoryType;
    }

    @NotNull
    public final String getImageURL() {
        return this.imageURL;
    }

    @NotNull
    public final BurnItemCategoryMetaDisplayModel getMeta() {
        return this.meta;
    }

    @NotNull
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setBurnItemsDisplayModel(@NotNull List<BurnItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.burnItemsDisplayModel = list;
    }

    public final void setCategoryId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryId = str;
    }

    public final void setCategoryName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
    }

    public final void setCategoryType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryType = str;
    }

    public final void setImageURL(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageURL = str;
    }

    public final void setMeta(@NotNull BurnItemCategoryMetaDisplayModel burnItemCategoryMetaDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemCategoryMetaDisplayModel, "<set-?>");
        this.meta = burnItemCategoryMetaDisplayModel;
    }

    public final void setSubtitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }
}
