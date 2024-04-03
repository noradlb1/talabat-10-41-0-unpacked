package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/FeaturedListData;", "", "channelName", "", "channelPosition", "", "burnCategoryDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "totalPoints", "(Ljava/lang/String;ILcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;I)V", "getBurnCategoryDisplayModel", "()Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "getChannelName", "()Ljava/lang/String;", "getChannelPosition", "()I", "getTotalPoints", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListData {
    @NotNull
    private final BurnItemCategoryDisplayModel burnCategoryDisplayModel;
    @NotNull
    private final String channelName;
    private final int channelPosition;
    private final int totalPoints;

    public FeaturedListData(@NotNull String str, int i11, @NotNull BurnItemCategoryDisplayModel burnItemCategoryDisplayModel, int i12) {
        Intrinsics.checkNotNullParameter(str, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, "burnCategoryDisplayModel");
        this.channelName = str;
        this.channelPosition = i11;
        this.burnCategoryDisplayModel = burnItemCategoryDisplayModel;
        this.totalPoints = i12;
    }

    @NotNull
    public final BurnItemCategoryDisplayModel getBurnCategoryDisplayModel() {
        return this.burnCategoryDisplayModel;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelPosition() {
        return this.channelPosition;
    }

    public final int getTotalPoints() {
        return this.totalPoints;
    }
}
