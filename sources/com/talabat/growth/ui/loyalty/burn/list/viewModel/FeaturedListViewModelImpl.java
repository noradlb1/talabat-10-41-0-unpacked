package com.talabat.growth.ui.loyalty.burn.list.viewModel;

import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.features.matketPlace.FilterBurnItems;
import com.talabat.growth.features.matketPlace.GetBurnCategoryDetails;
import com.talabat.growth.features.matketPlace.model.requestModel.BurnCategoryRequestModel;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModelImpl;", "Lcom/talabat/growth/ui/loyalty/burn/list/viewModel/FeaturedListViewModel;", "getBurnCategoryDetails", "Lcom/talabat/growth/features/matketPlace/GetBurnCategoryDetails;", "filterItems", "Lcom/talabat/growth/features/matketPlace/FilterBurnItems;", "burnOptionDetailsNavigator", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator;", "(Lcom/talabat/growth/features/matketPlace/GetBurnCategoryDetails;Lcom/talabat/growth/features/matketPlace/FilterBurnItems;Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator;)V", "getCategoryDetails", "", "optionId", "", "burnCategoryType", "country", "areaId", "", "handleBurnItemCategoryDisplayModel", "displayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "handleShouldShowBottomSheet", "burnOptionDetailsTarget", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "onBurnOptionClicked", "voucherPosition", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "position", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "setCategoryDetails", "burnItemCategoryDisplayModel", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListViewModelImpl extends FeaturedListViewModel {
    @NotNull
    private final BurnOptionDetailsNavigator burnOptionDetailsNavigator;
    @NotNull
    private final FilterBurnItems filterItems;
    @NotNull
    private final GetBurnCategoryDetails getBurnCategoryDetails;

    public FeaturedListViewModelImpl(@NotNull GetBurnCategoryDetails getBurnCategoryDetails2, @NotNull FilterBurnItems filterBurnItems, @NotNull BurnOptionDetailsNavigator burnOptionDetailsNavigator2) {
        Intrinsics.checkNotNullParameter(getBurnCategoryDetails2, "getBurnCategoryDetails");
        Intrinsics.checkNotNullParameter(filterBurnItems, "filterItems");
        Intrinsics.checkNotNullParameter(burnOptionDetailsNavigator2, "burnOptionDetailsNavigator");
        this.getBurnCategoryDetails = getBurnCategoryDetails2;
        this.filterItems = filterBurnItems;
        this.burnOptionDetailsNavigator = burnOptionDetailsNavigator2;
    }

    /* access modifiers changed from: private */
    public final void handleBurnItemCategoryDisplayModel(BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        this.filterItems.invoke(burnItemCategoryDisplayModel.getBurnItemsDisplayModel(), new FeaturedListViewModelImpl$handleBurnItemCategoryDisplayModel$1(this, burnItemCategoryDisplayModel));
    }

    /* access modifiers changed from: private */
    public final void handleShouldShowBottomSheet(BurnOptionDetailsNavigator.BurnOptionDetailsTarget burnOptionDetailsTarget) {
        getShowBurnOptionDetailsEvent().postValue(burnOptionDetailsTarget);
    }

    public void getCategoryDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11) {
        Intrinsics.checkNotNullParameter(str, "optionId");
        Intrinsics.checkNotNullParameter(str2, "burnCategoryType");
        Intrinsics.checkNotNullParameter(str3, "country");
        this.getBurnCategoryDetails.invoke(new BurnCategoryRequestModel(str, str2, str3, i11), new FeaturedListViewModelImpl$getCategoryDetails$1(this));
    }

    public void onBurnOptionClicked(int i11, @NotNull BurnItemDisplayModel burnItemDisplayModel, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
        Intrinsics.checkNotNullParameter(voucherPosition, "position");
        this.burnOptionDetailsNavigator.invoke(new BurnOptionDetailsNavigator.BurnOptionDetails(getTotalPoints(), burnItemDisplayModel, voucherPosition), new FeaturedListViewModelImpl$onBurnOptionClicked$1(this));
    }

    public void setCategoryDetails(@NotNull BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, "burnItemCategoryDisplayModel");
        handleBurnItemCategoryDisplayModel(burnItemCategoryDisplayModel);
    }
}
