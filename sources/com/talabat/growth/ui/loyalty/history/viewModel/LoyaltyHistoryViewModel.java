package com.talabat.growth.ui.loyalty.history.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.growth.features.loyalty.network.PointsHistoryFilterType;
import com.talabat.growth.ui.loyalty.models.LoyaltyHistoryDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\rH&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/talabat/growth/ui/loyalty/history/viewModel/LoyaltyHistoryViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "successData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;", "getSuccessData", "()Landroidx/lifecycle/MutableLiveData;", "setSuccessData", "(Landroidx/lifecycle/MutableLiveData;)V", "getPointsList", "", "userId", "", "pageNumber", "", "pageSize", "filterId", "Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;", "languageCode", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LoyaltyHistoryViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<LoyaltyHistoryDisplayModel> successData = new MutableLiveData<>();

    public static /* synthetic */ void getPointsList$default(LoyaltyHistoryViewModel loyaltyHistoryViewModel, String str, int i11, int i12, PointsHistoryFilterType pointsHistoryFilterType, String str2, int i13, Object obj) {
        IntegrationGlobalDataModel.Companion companion;
        if (obj == null) {
            if ((i13 & 1) != 0 && ((companion = IntegrationGlobalDataModel.Companion) == null || (str = companion.customerID()) == null)) {
                str = null;
            }
            String str3 = str;
            if ((i13 & 8) != 0) {
                pointsHistoryFilterType = PointsHistoryFilterType.ALL;
            }
            PointsHistoryFilterType pointsHistoryFilterType2 = pointsHistoryFilterType;
            if ((i13 & 16) != 0) {
                str2 = IntegrationGlobalDataModel.Companion.selectedLanguage();
            }
            loyaltyHistoryViewModel.getPointsList(str3, i11, i12, pointsHistoryFilterType2, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPointsList");
    }

    public abstract void getPointsList(@NotNull String str, int i11, int i12, @NotNull PointsHistoryFilterType pointsHistoryFilterType, @NotNull String str2);

    @NotNull
    public final MutableLiveData<LoyaltyHistoryDisplayModel> getSuccessData() {
        return this.successData;
    }

    public final void setSuccessData(@NotNull MutableLiveData<LoyaltyHistoryDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.successData = mutableLiveData;
    }
}
