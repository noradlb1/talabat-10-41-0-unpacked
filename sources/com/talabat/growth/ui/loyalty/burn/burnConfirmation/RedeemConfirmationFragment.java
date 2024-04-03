package com.talabat.growth.ui.loyalty.burn.burnConfirmation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_button_v2.DSTertiaryButton;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.growth.R;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel.RedeemConfirmationViewModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.views.CouponCodeView;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.growth.ui.util.UnexpectedBehaviorObservability;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.Restaurant;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0017H\u0016J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020\u00172\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u00172\u0006\u00105\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u0002H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006<"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/RedeemConfirmationFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "()V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "getRewardsTracker", "()Lcom/talabat/feature/rewards/domain/RewardsTracker;", "setRewardsTracker", "(Lcom/talabat/feature/rewards/domain/RewardsTracker;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "Lkotlin/Lazy;", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "handleVoucherRedirectionLink", "redirectionLink", "", "buttonLabel", "layoutId", "", "navigateToDashboard", "navigateToMultipleRestaurants", "navigateToRestaurantDetails", "restaurant", "Ldatamodels/Restaurant;", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateUi", "setupBackToRewardsButton", "setupCharity", "setupOutlinedBackToRewardsButton", "setupUi", "burnType", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "setupVoucher", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "showCouponCodeView", "couponCode", "viewModelBuilder", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public RewardsTracker rewardsTracker;
    @NotNull
    private final Lazy talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new RedeemConfirmationFragment$talabatTracker$2(this));

    public static final /* synthetic */ RedeemConfirmationViewModel access$getViewModel(RedeemConfirmationFragment redeemConfirmationFragment) {
        return (RedeemConfirmationViewModel) redeemConfirmationFragment.getViewModel();
    }

    private final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    private final void handleVoucherRedirectionLink(String str, String str2) {
        int i11 = R.id.redeemUseVoucherButton;
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setVisibility(0);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setTitle(str2);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setOnTap(new RedeemConfirmationFragment$handleVoucherRedirectionLink$1(this, str));
    }

    /* access modifiers changed from: private */
    public final void navigateToDashboard() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GrowthNavigatorActions.Companion.startLoyaltyDashboardActivity(activity, LoyaltyDashboardScreen.RewardsCatalogueOrigin.REDEEM_VOUCHER, RedeemConfirmationFragment$navigateToDashboard$1$1.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToMultipleRestaurants() {
    }

    /* access modifiers changed from: private */
    public final void navigateToRestaurantDetails(Restaurant restaurant) {
        Context context = getContext();
        if (context != null) {
            GlobalDataModel.ShopClickOrigin = RedeemEventParams.ScreenType.REWARD.getType();
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            new UnexpectedBehaviorObservability(getObservabilityManager()).checkIsPickupInGlobalDataModel();
            Navigator.Companion.navigate(context, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity$default(OPNavigatorActions.Companion, restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated, false, (String) null, (Bundle) null, 224, (Object) null));
        }
    }

    private final void populateUi() {
        String str;
        ((TextView) _$_findCachedViewById(R.id.redeemOptionRemainingPoints)).setText(ExtentionsKt.decimalFormat(((RedeemConfirmationViewModel) getViewModel()).getRemainingPoints()));
        TextView textView = (TextView) _$_findCachedViewById(R.id.redeemOptionTitle);
        BurnItemDisplayModel burnItemData = ((RedeemConfirmationViewModel) getViewModel()).getBurnItemData();
        if (burnItemData != null) {
            str = burnItemData.getTitle();
        } else {
            str = null;
        }
        textView.setText(str);
    }

    private final void setupBackToRewardsButton() {
        int i11 = R.id.dsPrimaryButtonBackToRewards;
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setVisibility(0);
        ((DSPrimaryButton) _$_findCachedViewById(i11)).setOnTap(new RedeemConfirmationFragment$setupBackToRewardsButton$1(this));
    }

    private final void setupCharity() {
        ((TextView) _$_findCachedViewById(R.id.redeemOptionCongrats)).setText(getResources().getString(com.talabat.localization.R.string.loyalty_redeem_congratulation_charity));
        ((TextView) _$_findCachedViewById(R.id.redeemOptionCongratsMessage)).setText(getResources().getString(com.talabat.localization.R.string.loyalty_redeem_congratulation_charity_msg));
        ((TextView) _$_findCachedViewById(R.id.redeemOptionTitle)).setVisibility(8);
        ((AppCompatImageView) _$_findCachedViewById(R.id.redeemOptionCongratsIcon)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R.id.redeemOptionCongratsCharityIcon)).setVisibility(0);
        setupBackToRewardsButton();
    }

    private final void setupOutlinedBackToRewardsButton() {
        int i11 = R.id.dsTertiaryButtonBackToRewards;
        ((DSTertiaryButton) _$_findCachedViewById(i11)).setVisibility(0);
        ((DSTertiaryButton) _$_findCachedViewById(i11)).setOnTap(new RedeemConfirmationFragment$setupOutlinedBackToRewardsButton$1(this));
    }

    /* access modifiers changed from: private */
    public final void setupUi(RedeemConfirmationViewModel.BurnType burnType) {
        boolean z11;
        if (Intrinsics.areEqual((Object) burnType, (Object) RedeemConfirmationViewModel.BurnType.Charity.INSTANCE)) {
            setupCharity();
        } else if (burnType instanceof RedeemConfirmationViewModel.BurnType.Voucher) {
            setupVoucher((RedeemConfirmationViewModel.BurnType.Voucher) burnType);
        } else {
            if (burnType instanceof RedeemConfirmationViewModel.BurnType.Raffle) {
                z11 = true;
            } else {
                z11 = Intrinsics.areEqual((Object) burnType, (Object) RedeemConfirmationViewModel.BurnType.Other.INSTANCE);
            }
            if (z11) {
                setupBackToRewardsButton();
            }
        }
    }

    private final void setupVoucher(RedeemConfirmationViewModel.BurnType.Voucher voucher) {
        boolean z11;
        ((TextView) _$_findCachedViewById(R.id.redeemOptionVoucherAdded)).setVisibility(0);
        if (voucher instanceof RedeemConfirmationViewModel.BurnType.Voucher.Nfp) {
            ConfirmationDisplayModel confirmationDisplayModel = ((RedeemConfirmationViewModel.BurnType.Voucher.Nfp) voucher).getConfirmationDisplayModel();
            if (confirmationDisplayModel != null) {
                String couponCode = confirmationDisplayModel.getCouponCode();
                if (couponCode.length() > 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!z11) {
                    couponCode = null;
                }
                if (couponCode != null) {
                    showCouponCodeView(couponCode);
                }
                if (!(!StringsKt__StringsJVMKt.isBlank(confirmationDisplayModel.getPartnerLink())) || !(!StringsKt__StringsJVMKt.isBlank(confirmationDisplayModel.getPartnerButtonLink()))) {
                    ((TextView) _$_findCachedViewById(R.id.showVoucherCodeHintTextView)).setVisibility(0);
                } else {
                    handleVoucherRedirectionLink(confirmationDisplayModel.getPartnerLink(), confirmationDisplayModel.getPartnerButtonLink());
                }
                setupOutlinedBackToRewardsButton();
            }
        } else if (voucher instanceof RedeemConfirmationViewModel.BurnType.Voucher.LinkRedemption) {
            int i11 = R.id.dsPrimaryButtonOrderNow;
            ((DSPrimaryButton) _$_findCachedViewById(i11)).setVisibility(0);
            ((DSPrimaryButton) _$_findCachedViewById(i11)).setOnTap(new RedeemConfirmationFragment$setupVoucher$2(this));
            setupOutlinedBackToRewardsButton();
        } else if (voucher instanceof RedeemConfirmationViewModel.BurnType.Voucher.Other) {
            setupBackToRewardsButton();
        }
    }

    private final void showCouponCodeView(String str) {
        int i11 = R.id.couponCodeView;
        ((CouponCodeView) _$_findCachedViewById(i11)).setVisibility(0);
        ((CouponCodeView) _$_findCachedViewById(i11)).updateUi(getString(com.talabat.localization.R.string.save_the_code_by_copying_it_or_taking_a_screenshot), str);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final RewardsTracker getRewardsTracker() {
        RewardsTracker rewardsTracker2 = this.rewardsTracker;
        if (rewardsTracker2 != null) {
            return rewardsTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rewardsTracker");
        return null;
    }

    @NotNull
    public Class<RedeemConfirmationViewModel> getViewModelClass() {
        return RedeemConfirmationViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_redeem_confirmation;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((RedeemConfirmationViewModel) getViewModel()).getEventOpenOneRestaurant(), new RedeemConfirmationFragment$observatory$1(this));
        LifecycleKt.observe(this, ((RedeemConfirmationViewModel) getViewModel()).getEventOpenMultipleRestaurants(), new RedeemConfirmationFragment$observatory$2(this));
        LifecycleKt.observe(this, ((RedeemConfirmationViewModel) getViewModel()).getBurnType(), new RedeemConfirmationFragment$observatory$3(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerRedeemConfirmationFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (RewardsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(RewardsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ((RedeemConfirmationViewModel) getViewModel()).setup((BurnItemDisplayModel) arguments.getParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_Burn_OPTION_DATA), IntKt.orZero(Integer.valueOf(arguments.getInt(GrowthNavigatorActions.EXTRA_LOYALTY_REMAINING_POINTS))), (ConfirmationDisplayModel) arguments.getParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA));
            populateUi();
        }
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setRewardsTracker(@NotNull RewardsTracker rewardsTracker2) {
        Intrinsics.checkNotNullParameter(rewardsTracker2, "<set-?>");
        this.rewardsTracker = rewardsTracker2;
    }

    @NotNull
    public RedeemConfirmationViewModel viewModelBuilder() {
        return RedeemConfirmationViewModel.Companion.getInstance(getTalabatTracker(), getRewardsTracker());
    }
}
