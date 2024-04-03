package com.talabat.growth.ui.loyalty.burn.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryMetaDisplayModel;", "", "viewMode", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;)V", "getViewMode", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryViewType;", "setViewMode", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnItemCategoryMetaDisplayModel {
    @NotNull
    private BurnItemCategoryViewType viewMode;

    public BurnItemCategoryMetaDisplayModel() {
        this((BurnItemCategoryViewType) null, 1, (DefaultConstructorMarker) null);
    }

    public BurnItemCategoryMetaDisplayModel(@NotNull BurnItemCategoryViewType burnItemCategoryViewType) {
        Intrinsics.checkNotNullParameter(burnItemCategoryViewType, "viewMode");
        this.viewMode = burnItemCategoryViewType;
    }

    @NotNull
    public final BurnItemCategoryViewType getViewMode() {
        return this.viewMode;
    }

    public final void setViewMode(@NotNull BurnItemCategoryViewType burnItemCategoryViewType) {
        Intrinsics.checkNotNullParameter(burnItemCategoryViewType, "<set-?>");
        this.viewMode = burnItemCategoryViewType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BurnItemCategoryMetaDisplayModel(BurnItemCategoryViewType burnItemCategoryViewType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? BurnItemCategoryViewType.SWIM_LANE_HALF_WIDTH_CARDS : burnItemCategoryViewType);
    }
}
