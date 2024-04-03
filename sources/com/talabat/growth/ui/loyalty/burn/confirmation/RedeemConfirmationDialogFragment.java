package com.talabat.growth.ui.loyalty.burn.confirmation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import buisnessmodels.Customer;
import com.designsystem.ds_alert.DSAlert;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.growth.databinding.FragmentBurnOptionsConfirmationBinding;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel.RedeemConfirmationViewModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.growth.ui.util.UnexpectedBehaviorObservability;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.CustomerInfo;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010/\u001a\u00020\u001dH\u0002J\b\u00100\u001a\u00020\u001dH\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u001d2\u0006\u00102\u001a\u000203H\u0002J\b\u00105\u001a\u00020\u001dH\u0002J\b\u00106\u001a\u00020\u001dH\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u00102\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u00102\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006;"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/confirmation/RedeemConfirmationDialogFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/growth/databinding/FragmentBurnOptionsConfirmationBinding;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "getRewardsTracker", "()Lcom/talabat/feature/rewards/domain/RewardsTracker;", "setRewardsTracker", "(Lcom/talabat/feature/rewards/domain/RewardsTracker;)V", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "getViewModel", "()Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel;", "viewModel$delegate", "closeBottomSheet", "", "navigateToMultipleRestaurants", "navigateToRestaurantDetails", "restaurant", "Ldatamodels/Restaurant;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupImage", "setupObservers", "setupRaffle", "burnType", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Raffle;", "setupRaffleImage", "setupRaffleTitle", "setupTitle", "setupUi", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType;", "setupVoucher", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/RedeemConfirmationViewModel$BurnType$Voucher;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemConfirmationDialogFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private FragmentBurnOptionsConfirmationBinding binding;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public RewardsTracker rewardsTracker;
    @NotNull
    private final Lazy talabatTracker$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    public RedeemConfirmationDialogFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RedeemConfirmationDialogFragment$talabatTracker$2(this));
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RedeemConfirmationDialogFragment$viewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final void closeBottomSheet() {
        Fragment parentFragment = getParentFragment();
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding = parentFragment instanceof DSBottomSheetFragmentWithoutPadding ? (DSBottomSheetFragmentWithoutPadding) parentFragment : null;
        if (dSBottomSheetFragmentWithoutPadding != null) {
            dSBottomSheetFragmentWithoutPadding.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RedeemConfirmationViewModel getViewModel() {
        return (RedeemConfirmationViewModel) this.viewModel$delegate.getValue();
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

    private final void setupImage() {
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding2 = null;
        if (fragmentBurnOptionsConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding = null;
        }
        TalabatImageView talabatImageView = fragmentBurnOptionsConfirmationBinding.burnDetailsStaticImageView;
        Intrinsics.checkNotNullExpressionValue(talabatImageView, "binding.burnDetailsStaticImageView");
        talabatImageView.setVisibility(0);
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding3 = this.binding;
        if (fragmentBurnOptionsConfirmationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsConfirmationBinding2 = fragmentBurnOptionsConfirmationBinding3;
        }
        TalabatImageView talabatImageView2 = fragmentBurnOptionsConfirmationBinding2.burnDetailsImageView;
        Intrinsics.checkNotNullExpressionValue(talabatImageView2, "binding.burnDetailsImageView");
        talabatImageView2.setVisibility(8);
    }

    private final void setupObservers() {
        LifecycleKt.observe(this, getViewModel().getEventOpenOneRestaurant(), new RedeemConfirmationDialogFragment$setupObservers$1(this));
        LifecycleKt.observe(this, getViewModel().getEventOpenMultipleRestaurants(), new RedeemConfirmationDialogFragment$setupObservers$2(this));
        LifecycleKt.observe(this, getViewModel().getBurnType(), new RedeemConfirmationDialogFragment$setupObservers$3(this));
    }

    private final void setupRaffle(RedeemConfirmationViewModel.BurnType.Raffle raffle) {
        String imageURL;
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
        String str = null;
        if (fragmentBurnOptionsConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding = null;
        }
        BurnItemDisplayModel burnItemData = raffle.getBurnItemData();
        if (!(burnItemData == null || (imageURL = burnItemData.getImageURL()) == null)) {
            int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
            TalabatImageView talabatImageView = fragmentBurnOptionsConfirmationBinding.burnDetailsImageView;
            Intrinsics.checkNotNullExpressionValue(talabatImageView, "burnDetailsImageView");
            TalabatImageView.setImageResizeUrl$default(talabatImageView, imageURL, i11, 0, false, 12, (Object) null);
        }
        fragmentBurnOptionsConfirmationBinding.redeemOptionCongratsMessage.setGravity(17);
        TextView textView = fragmentBurnOptionsConfirmationBinding.redeemOptionCongratsMessage;
        ConfirmationDisplayModel conformationViewModel = raffle.getConformationViewModel();
        if (conformationViewModel != null) {
            str = conformationViewModel.getDescription();
        }
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        String decimalFormat = ExtentionsKt.decimalFormat(getViewModel().getRemainingPoints());
        TextView textView2 = fragmentBurnOptionsConfirmationBinding.redeemOptionRemainingPoints;
        Intrinsics.checkNotNullExpressionValue(textView2, "redeemOptionRemainingPoints");
        textView2.setVisibility(0);
        fragmentBurnOptionsConfirmationBinding.redeemOptionRemainingPoints.setText(getResources().getString(R.string.remaining_points, new Object[]{decimalFormat}));
    }

    private final void setupRaffleImage(RedeemConfirmationViewModel.BurnType.Raffle raffle) {
        String imageURL;
        BurnItemDisplayModel burnItemData = raffle.getBurnItemData();
        if (burnItemData != null && (imageURL = burnItemData.getImageURL()) != null) {
            FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
            if (fragmentBurnOptionsConfirmationBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBurnOptionsConfirmationBinding = null;
            }
            TalabatImageView talabatImageView = fragmentBurnOptionsConfirmationBinding.burnDetailsStaticImageView;
            Intrinsics.checkNotNullExpressionValue(talabatImageView, "burnDetailsStaticImageView");
            talabatImageView.setVisibility(8);
            TalabatImageView talabatImageView2 = fragmentBurnOptionsConfirmationBinding.burnDetailsImageView;
            Intrinsics.checkNotNullExpressionValue(talabatImageView2, "burnDetailsImageView");
            talabatImageView2.setVisibility(0);
            int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
            TalabatImageView talabatImageView3 = fragmentBurnOptionsConfirmationBinding.burnDetailsImageView;
            Intrinsics.checkNotNullExpressionValue(talabatImageView3, "burnDetailsImageView");
            TalabatImageView.setImageResizeUrl$default(talabatImageView3, imageURL, i11, 0, false, 12, (Object) null);
        }
    }

    private final void setupRaffleTitle() {
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding2 = null;
        if (fragmentBurnOptionsConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding = null;
        }
        fragmentBurnOptionsConfirmationBinding.confirmationTitleTextView.setGravity(17);
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding3 = this.binding;
        if (fragmentBurnOptionsConfirmationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsConfirmationBinding2 = fragmentBurnOptionsConfirmationBinding3;
        }
        fragmentBurnOptionsConfirmationBinding2.confirmationTitleTextView.setText(getResources().getString(R.string.you_have_entered_the_raffle));
    }

    private final void setupTitle() {
        CustomerInfo customerInfo;
        String str;
        Customer instance = Customer.getInstance();
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = null;
        if (instance != null) {
            customerInfo = instance.getCustomerInfo();
        } else {
            customerInfo = null;
        }
        if (customerInfo != null) {
            str = customerInfo.firstName;
            if (str == null) {
                str = customerInfo.lastName;
            }
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding2 = this.binding;
        if (fragmentBurnOptionsConfirmationBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsConfirmationBinding = fragmentBurnOptionsConfirmationBinding2;
        }
        fragmentBurnOptionsConfirmationBinding.confirmationTitleTextView.setText(getResources().getString(R.string.nice_one, new Object[]{str}));
    }

    /* access modifiers changed from: private */
    public final void setupUi(RedeemConfirmationViewModel.BurnType burnType) {
        if (burnType instanceof RedeemConfirmationViewModel.BurnType.Voucher) {
            setupTitle();
            setupImage();
            setupVoucher((RedeemConfirmationViewModel.BurnType.Voucher) burnType);
        } else if (burnType instanceof RedeemConfirmationViewModel.BurnType.Raffle) {
            setupRaffleTitle();
            RedeemConfirmationViewModel.BurnType.Raffle raffle = (RedeemConfirmationViewModel.BurnType.Raffle) burnType;
            setupRaffleImage(raffle);
            setupRaffle(raffle);
        }
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
        if (fragmentBurnOptionsConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding = null;
        }
        fragmentBurnOptionsConfirmationBinding.dsIconButtonClose.setOnTap(new RedeemConfirmationDialogFragment$setupUi$1(this));
    }

    private final void setupVoucher(RedeemConfirmationViewModel.BurnType.Voucher voucher) {
        String str;
        boolean z11;
        boolean z12;
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = this.binding;
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding2 = null;
        if (fragmentBurnOptionsConfirmationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding = null;
        }
        DSAlert dSAlert = fragmentBurnOptionsConfirmationBinding.dsAlert;
        Intrinsics.checkNotNullExpressionValue(dSAlert, "binding.dsAlert");
        dSAlert.setVisibility(0);
        BurnItemDisplayModel burnItemData = voucher.getBurnItemData();
        if (burnItemData != null) {
            str = burnItemData.getTitle();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Character orNull = StringsKt___StringsKt.getOrNull(str, 1);
        if (orNull != null) {
            z11 = Character.isLowerCase(orNull.charValue());
        } else {
            z11 = false;
        }
        if (z11) {
            if (str.length() > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                StringBuilder sb2 = new StringBuilder();
                String valueOf = String.valueOf(str.charAt(0));
                Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = valueOf.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                sb2.append(lowerCase);
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                sb2.append(substring);
                str = sb2.toString();
            }
        }
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding3 = this.binding;
        if (fragmentBurnOptionsConfirmationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsConfirmationBinding3 = null;
        }
        fragmentBurnOptionsConfirmationBinding3.redeemOptionCongratsMessage.setText(getResources().getString(R.string.you_have_just_redeemed, new Object[]{str}));
        if (voucher instanceof RedeemConfirmationViewModel.BurnType.Voucher.LinkRedemption) {
            FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding4 = this.binding;
            if (fragmentBurnOptionsConfirmationBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBurnOptionsConfirmationBinding4 = null;
            }
            fragmentBurnOptionsConfirmationBinding4.dsPrimaryButtonOrderNow.setVisibility(0);
            FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding5 = this.binding;
            if (fragmentBurnOptionsConfirmationBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBurnOptionsConfirmationBinding2 = fragmentBurnOptionsConfirmationBinding5;
            }
            fragmentBurnOptionsConfirmationBinding2.dsPrimaryButtonOrderNow.setOnTap(new RedeemConfirmationDialogFragment$setupVoucher$1(this));
        }
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerRedeemConfirmationDialogFragmentComponent.factory().create((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (RewardsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(RewardsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentBurnOptionsConfirmationBinding fragmentBurnOptionsConfirmationBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "RedeemConfirmationDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "RedeemConfirmationDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentBurnOptionsConfirmationBinding inflate = FragmentBurnOptionsConfirmationBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsConfirmationBinding = inflate;
        }
        ConstraintLayout root = fragmentBurnOptionsConfirmationBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            getViewModel().setup((BurnItemDisplayModel) arguments.getParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_Burn_OPTION_DATA), IntKt.orZero(Integer.valueOf(arguments.getInt(GrowthNavigatorActions.EXTRA_LOYALTY_REMAINING_POINTS))), (ConfirmationDisplayModel) arguments.getParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA));
            setupObservers();
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
}
