package com.talabat.growth.ui.loyalty;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.growth.features.loyalty.IsRewardsPointsBannerVisible;
import com.talabat.growth.features.loyalty.IsUserRewardsEnabled;
import com.talabat.growth.features.loyalty.models.responses.RewardsPointsBannerModel;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewards;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0006\u0010\u0019\u001a\u00020\u0017J\b\u0010\u001a\u001a\u00020\rH\u0002J\u0006\u0010\b\u001a\u00020\u0017J\u0010\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/talabat/growth/ui/loyalty/HomeScreenHeaderRewardsViewModel;", "Landroidx/lifecycle/ViewModel;", "isUserRewardsSharedPreferences", "Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;", "checkIfIsUserEnabled", "Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;", "funWithFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "isRewardsPointsBannerVisible", "Lcom/talabat/growth/features/loyalty/IsRewardsPointsBannerVisible;", "(Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/growth/features/loyalty/IsRewardsPointsBannerVisible;)V", "showRewardsBanner", "Landroidx/lifecycle/MutableLiveData;", "", "getShowRewardsBanner", "()Landroidx/lifecycle/MutableLiveData;", "showRewardsBannerPoints", "", "getShowRewardsBannerPoints", "showRewardsBannerText", "", "getShowRewardsBannerText", "applyIsUserEligibleForRewardsProgram", "", "isUserEligibleForRewardsProgram", "checkUserIsEnabled", "isFwFLoyaltyEnabled", "model", "Lcom/talabat/growth/features/loyalty/models/responses/RewardsPointsBannerModel;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenHeaderRewardsViewModel extends ViewModel {
    @NotNull
    private final IsUserRewardsEnabled checkIfIsUserEnabled;
    @NotNull
    private final ITalabatFeatureFlag funWithFlags;
    @NotNull
    private final IsRewardsPointsBannerVisible isRewardsPointsBannerVisible;
    @NotNull
    private final IsUserRewards isUserRewardsSharedPreferences;
    @NotNull
    private final MutableLiveData<Boolean> showRewardsBanner = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<Integer> showRewardsBannerPoints = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<String> showRewardsBannerText = new MutableLiveData<>();

    public HomeScreenHeaderRewardsViewModel(@NotNull IsUserRewards isUserRewards, @NotNull IsUserRewardsEnabled isUserRewardsEnabled, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IsRewardsPointsBannerVisible isRewardsPointsBannerVisible2) {
        Intrinsics.checkNotNullParameter(isUserRewards, "isUserRewardsSharedPreferences");
        Intrinsics.checkNotNullParameter(isUserRewardsEnabled, "checkIfIsUserEnabled");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "funWithFlags");
        Intrinsics.checkNotNullParameter(isRewardsPointsBannerVisible2, "isRewardsPointsBannerVisible");
        this.isUserRewardsSharedPreferences = isUserRewards;
        this.checkIfIsUserEnabled = isUserRewardsEnabled;
        this.funWithFlags = iTalabatFeatureFlag;
        this.isRewardsPointsBannerVisible = isRewardsPointsBannerVisible2;
    }

    /* access modifiers changed from: private */
    public final void applyIsUserEligibleForRewardsProgram(boolean z11) {
        this.isUserRewardsSharedPreferences.saveIsUserEligibleForRewardsProgram(z11);
    }

    /* access modifiers changed from: private */
    public final boolean isFwFLoyaltyEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.funWithFlags, EcosystemsFeatureFlagsKeys.IS_REWARDS_ENABLED, false, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showRewardsBanner(RewardsPointsBannerModel rewardsPointsBannerModel) {
        boolean z11;
        MutableLiveData<Boolean> mutableLiveData = this.showRewardsBanner;
        Boolean showBanner = rewardsPointsBannerModel.getShowBanner();
        int i11 = 0;
        if (showBanner != null) {
            z11 = showBanner.booleanValue();
        } else {
            z11 = false;
        }
        mutableLiveData.postValue(Boolean.valueOf(z11));
        if (rewardsPointsBannerModel.getRewardsText() != null) {
            this.showRewardsBannerText.postValue(rewardsPointsBannerModel.getRewardsText());
            return;
        }
        MutableLiveData<Integer> mutableLiveData2 = this.showRewardsBannerPoints;
        Integer totalPoints = rewardsPointsBannerModel.getTotalPoints();
        if (totalPoints != null) {
            i11 = totalPoints.intValue();
        }
        mutableLiveData2.postValue(Integer.valueOf(i11));
    }

    public final void checkUserIsEnabled() {
        this.checkIfIsUserEnabled.invoke(Unit.INSTANCE, new HomeScreenHeaderRewardsViewModel$checkUserIsEnabled$1(this));
    }

    @NotNull
    public final MutableLiveData<Boolean> getShowRewardsBanner() {
        return this.showRewardsBanner;
    }

    @NotNull
    public final MutableLiveData<Integer> getShowRewardsBannerPoints() {
        return this.showRewardsBannerPoints;
    }

    @NotNull
    public final MutableLiveData<String> getShowRewardsBannerText() {
        return this.showRewardsBannerText;
    }

    public final void isRewardsPointsBannerVisible() {
        this.isRewardsPointsBannerVisible.invoke(Unit.INSTANCE, new HomeScreenHeaderRewardsViewModel$isRewardsPointsBannerVisible$1(this));
    }
}
