package com.talabat.sidemenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModelBuilder;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qu.m;
import qu.n;
import qu.o;

@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u000e\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/sidemenu/SideMenuRewardViewPresenter;", "", "context", "Landroid/content/Context;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Landroid/content/Context;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getContext", "()Landroid/content/Context;", "coroutineScope", "com/talabat/sidemenu/SideMenuRewardViewPresenter$coroutineScope$1", "Lcom/talabat/sidemenu/SideMenuRewardViewPresenter$coroutineScope$1;", "viewHolder", "Lcom/talabat/sidemenu/SideMenuRewardViewHolder;", "getViewHolder", "()Lcom/talabat/sidemenu/SideMenuRewardViewHolder;", "setViewHolder", "(Lcom/talabat/sidemenu/SideMenuRewardViewHolder;)V", "viewModel", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "enableRewards", "", "isEnabled", "", "failed", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "onDetachedFromRecyclerView", "setView", "updateUI", "displayModel", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuRewardViewPresenter {
    @NotNull
    private final Context context;
    @NotNull
    private SideMenuRewardViewPresenter$coroutineScope$1 coroutineScope;
    @Nullable
    private SideMenuRewardViewHolder viewHolder;
    @NotNull
    private LoyaltyDashboardViewModel viewModel;

    public SideMenuRewardViewPresenter(@NotNull Context context2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        this.context = context2;
        SideMenuRewardViewPresenter$coroutineScope$1 sideMenuRewardViewPresenter$coroutineScope$1 = new SideMenuRewardViewPresenter$coroutineScope$1();
        this.coroutineScope = sideMenuRewardViewPresenter$coroutineScope$1;
        this.viewModel = LoyaltyDashboardViewModelBuilder.Companion.getLoyaltyDashboardViewModel(context2, sideMenuRewardViewPresenter$coroutineScope$1, iTalabatFeatureFlag, locationConfigurationRepository, configurationLocalRepository);
    }

    /* access modifiers changed from: private */
    public final void enableRewards(boolean z11) {
        ViewGroup.LayoutParams layoutParams;
        int i11;
        View view;
        SideMenuRewardViewHolder sideMenuRewardViewHolder = this.viewHolder;
        View view2 = null;
        if (sideMenuRewardViewHolder == null || (view = sideMenuRewardViewHolder.itemView) == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (layoutParams != null) {
            if (z11) {
                i11 = -2;
            } else {
                i11 = 0;
            }
            layoutParams.height = i11;
        }
        SideMenuRewardViewHolder sideMenuRewardViewHolder2 = this.viewHolder;
        if (sideMenuRewardViewHolder2 != null) {
            view2 = sideMenuRewardViewHolder2.itemView;
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public final void failed(Failure failure) {
        SideMenuRewardViewHolder sideMenuRewardViewHolder = this.viewHolder;
        if (sideMenuRewardViewHolder != null) {
            sideMenuRewardViewHolder.failed(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
        }
    }

    /* access modifiers changed from: private */
    public final void updateUI(LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        SideMenuRewardViewHolder sideMenuRewardViewHolder = this.viewHolder;
        if (sideMenuRewardViewHolder != null) {
            sideMenuRewardViewHolder.populate(loyaltyPointsDisplayModel);
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final SideMenuRewardViewHolder getViewHolder() {
        return this.viewHolder;
    }

    public final void onDetachedFromRecyclerView() {
        this.viewModel.getUserEligibleForRewardsProgram().removeObserver(new m(this));
        this.viewModel.getPointsData().removeObserver(new n(this));
        this.viewModel.getFailureData().removeObserver(new o(this));
    }

    public final void setView(@NotNull SideMenuRewardViewHolder sideMenuRewardViewHolder) {
        Intrinsics.checkNotNullParameter(sideMenuRewardViewHolder, "viewHolder");
        this.viewHolder = sideMenuRewardViewHolder;
        this.viewModel.getUserEligibleForRewardsProgram().observeForever(new m(this));
        this.viewModel.getPointsData().observeForever(new n(this));
        this.viewModel.getFailureData().observeForever(new o(this));
        enableRewards(false);
        Integer num = null;
        if (Customer.getInstance().isLoggedIn()) {
            LoyaltyDashboardViewModel loyaltyDashboardViewModel = this.viewModel;
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            if (customerInfo != null) {
                num = Integer.valueOf(customerInfo.f13850id);
            }
            loyaltyDashboardViewModel.checkUserIsEnabled(String.valueOf(num));
            return;
        }
        SideMenuRewardViewHolder.failed$default(sideMenuRewardViewHolder, (String) null, 1, (Object) null);
    }

    public final void setViewHolder(@Nullable SideMenuRewardViewHolder sideMenuRewardViewHolder) {
        this.viewHolder = sideMenuRewardViewHolder;
    }
}
