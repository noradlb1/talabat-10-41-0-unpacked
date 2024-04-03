package com.talabat.growth.ui.loyalty.burn.list.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u001eH&J \u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H&J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\u0005H&R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00061"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "categoryData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "getCategoryData", "()Landroidx/lifecycle/MutableLiveData;", "setCategoryData", "(Landroidx/lifecycle/MutableLiveData;)V", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "categoryName", "getCategoryName", "setCategoryName", "categoryType", "getCategoryType", "setCategoryType", "showBurnOptionDetailsEvent", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "getShowBurnOptionDetailsEvent", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "setShowBurnOptionDetailsEvent", "(Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;)V", "totalPoints", "", "getTotalPoints", "()I", "setTotalPoints", "(I)V", "getCategoryDetails", "", "optionId", "burnCategoryType", "country", "areaId", "onBurnOptionClicked", "voucherPosition", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "position", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "setCategoryDetails", "burnItemCategoryDisplayModel", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FeaturedListViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<BurnItemCategoryDisplayModel> categoryData = new MutableLiveData<>();
    @NotNull
    private String categoryId;
    @NotNull
    private String categoryName;
    @NotNull
    private String categoryType;
    @NotNull
    private SingleLiveEvent<BurnOptionDetailsNavigator.BurnOptionDetailsTarget> showBurnOptionDetailsEvent = new SingleLiveEvent<>();
    private int totalPoints;

    public FeaturedListViewModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.categoryId = StringUtils.empty(stringCompanionObject);
        this.categoryName = StringUtils.empty(stringCompanionObject);
        this.categoryType = StringUtils.empty(stringCompanionObject);
    }

    public static /* synthetic */ void getCategoryDetails$default(FeaturedListViewModel featuredListViewModel, String str, String str2, String str3, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 8) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedAreaId();
            }
            featuredListViewModel.getCategoryDetails(str, str2, str3, i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryDetails");
    }

    @NotNull
    public final MutableLiveData<BurnItemCategoryDisplayModel> getCategoryData() {
        return this.categoryData;
    }

    public abstract void getCategoryDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11);

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
    public final SingleLiveEvent<BurnOptionDetailsNavigator.BurnOptionDetailsTarget> getShowBurnOptionDetailsEvent() {
        return this.showBurnOptionDetailsEvent;
    }

    public final int getTotalPoints() {
        return this.totalPoints;
    }

    public abstract void onBurnOptionClicked(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition);

    public final void setCategoryData(@NotNull MutableLiveData<BurnItemCategoryDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.categoryData = mutableLiveData;
    }

    public abstract void setCategoryDetails(@NotNull BurnItemCategoryDisplayModel burnItemCategoryDisplayModel);

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

    public final void setShowBurnOptionDetailsEvent(@NotNull SingleLiveEvent<BurnOptionDetailsNavigator.BurnOptionDetailsTarget> singleLiveEvent) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "<set-?>");
        this.showBurnOptionDetailsEvent = singleLiveEvent;
    }

    public final void setTotalPoints(int i11) {
        this.totalPoints = i11;
    }
}
