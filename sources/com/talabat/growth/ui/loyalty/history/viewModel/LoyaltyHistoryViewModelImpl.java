package com.talabat.growth.ui.loyalty.history.viewModel;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.growth.features.loyalty.GetLoyaltyPointsList;
import com.talabat.growth.features.loyalty.models.LoyaltyPointsHistoryRequestModel;
import com.talabat.growth.features.loyalty.network.PointsHistoryFilterType;
import com.talabat.growth.ui.loyalty.models.LoyaltyHistoryDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/growth/ui/loyalty/history/viewModel/LoyaltyHistoryViewModelImpl;", "Lcom/talabat/growth/ui/loyalty/history/viewModel/LoyaltyHistoryViewModel;", "getLoyaltyPointsList", "Lcom/talabat/growth/features/loyalty/GetLoyaltyPointsList;", "(Lcom/talabat/growth/features/loyalty/GetLoyaltyPointsList;)V", "getPointsList", "", "userId", "", "pageNumber", "", "pageSize", "filterId", "Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;", "languageCode", "handleLoyaltyHistoryDisplayModel", "model", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryViewModelImpl extends LoyaltyHistoryViewModel {
    @NotNull
    private final GetLoyaltyPointsList getLoyaltyPointsList;

    public LoyaltyHistoryViewModelImpl(@NotNull GetLoyaltyPointsList getLoyaltyPointsList2) {
        Intrinsics.checkNotNullParameter(getLoyaltyPointsList2, "getLoyaltyPointsList");
        this.getLoyaltyPointsList = getLoyaltyPointsList2;
    }

    /* access modifiers changed from: private */
    public final void handleLoyaltyHistoryDisplayModel(LoyaltyHistoryDisplayModel loyaltyHistoryDisplayModel) {
        getSuccessData().setValue(loyaltyHistoryDisplayModel);
    }

    public void getPointsList(@NotNull String str, int i11, int i12, @NotNull PointsHistoryFilterType pointsHistoryFilterType, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(pointsHistoryFilterType, "filterId");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.getLoyaltyPointsList.invoke(new LoyaltyPointsHistoryRequestModel(str, i11, i12, pointsHistoryFilterType, str2), new LoyaltyHistoryViewModelImpl$getPointsList$1(this));
    }
}
