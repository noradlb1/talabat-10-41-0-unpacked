package com.talabat.growth.ui.loyalty.burn.details;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.marshmallow.TalabatTag;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.tracking.data.events.rewards.RedeemEventParams;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsAttributes;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsCompletedTrackingEvent;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsFailedTrackingEvent;
import com.talabat.core.tracking.data.events.rewards.RedeemPointsLoadedTrackingEvent;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.growth.databinding.FragmentBurnOptionsDetailsBinding;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsActivity;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModel;
import com.talabat.growth.ui.loyalty.burn.confirmation.RedeemConfirmationDialogFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.SubscriptionRestriction;
import com.talabat.growth.ui.util.ExtentionsKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import com.talabat.talabatnavigation.tpro.TproNavigatorActionsKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\f\u0018\u0000 W2\u00020\u0001:\u0001WB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J\b\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0016J$\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u001a\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u00104\u001a\u00020\u001fH\u0002J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020\u001fH\u0002J\b\u0010:\u001a\u00020\u001fH\u0002J \u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u000208H\u0002J\b\u0010>\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020\u001f2\u0006\u00106\u001a\u00020!H\u0002J\b\u0010@\u001a\u00020\u001fH\u0002J\u0010\u0010A\u001a\u00020\u001f2\u0006\u00107\u001a\u000208H\u0002J\b\u0010B\u001a\u00020\u001fH\u0002J\u0010\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020!H\u0002J\u0010\u0010E\u001a\u00020\u001f2\u0006\u00106\u001a\u00020!H\u0002J\u0010\u0010F\u001a\u00020\u001f2\u0006\u00107\u001a\u000208H\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\u0012\u0010H\u001a\u00020\u001f2\b\u0010I\u001a\u0004\u0018\u00010JH\u0002J \u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020M2\u0006\u0010I\u001a\u00020J2\u0006\u0010N\u001a\u000208H\u0002J\b\u0010O\u001a\u00020\u001fH\u0002J\u0010\u0010P\u001a\u00020\u001f2\u0006\u0010I\u001a\u00020JH\u0002J\u001a\u0010Q\u001a\u00020\u001f2\b\u0010R\u001a\u0004\u0018\u00010M2\u0006\u0010S\u001a\u00020!H\u0002J\u0018\u0010T\u001a\u00020\u001f2\u0006\u0010U\u001a\u0002082\u0006\u0010R\u001a\u00020MH\u0002J\u0018\u0010V\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020M2\u0006\u0010U\u001a\u000208H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001c¨\u0006X"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/details/BurnOptionsDetailsDialogFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/growth/databinding/FragmentBurnOptionsDetailsBinding;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineScope", "com/talabat/growth/ui/loyalty/burn/details/BurnOptionsDetailsDialogFragment$coroutineScope$1", "Lcom/talabat/growth/ui/loyalty/burn/details/BurnOptionsDetailsDialogFragment$coroutineScope$1;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "subscriptionStatusRepository$delegate", "Lkotlin/Lazy;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatTracker$delegate", "viewModel", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "getViewModel", "()Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "viewModel$delegate", "closeBottomSheet", "", "getVoucherName", "", "handleFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "hideProgress", "navigateToProBenefitPage", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "redeemOption", "setup", "voucherName", "pointsCost", "", "setupBottomPoints", "setupObservers", "setupRaffle", "isProRaffle", "", "setupRaffleBottomPoints", "setupRaffleTitle", "setupRaffleTopPoints", "setupRedeemButton", "setupTProButton", "setupTag", "tag", "setupTitle", "setupTopPoints", "setupView", "showConfirmation", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "showConfirmationBottomSheet", "displayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "remainingPoints", "showProgress", "trackRedeemCompleted", "trackRedeemFailed", "burnItemDisplayModel", "reason", "trackRedeemPointsLoaded", "totalPoints", "updateUi", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsDialogFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String GA_REASON_API_FAILED = "Api";
    @NotNull
    @Deprecated
    public static final String GA_SCREEN_NAME = "Burn_option_Details";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    private FragmentBurnOptionsDetailsBinding binding;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public BurnOptionsDetailsDialogFragment$coroutineScope$1 coroutineScope = new BurnOptionsDetailsDialogFragment$coroutineScope$1();
    @NotNull
    private final Lazy subscriptionStatusRepository$delegate;
    @NotNull
    private final Lazy talabatTracker$delegate;
    @NotNull
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/details/BurnOptionsDetailsDialogFragment$Companion;", "", "()V", "GA_REASON_API_FAILED", "", "GA_SCREEN_NAME", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BurnOptionsDetailsDialogFragment() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.talabatTracker$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new BurnOptionsDetailsDialogFragment$talabatTracker$2(this));
        this.subscriptionStatusRepository$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new BurnOptionsDetailsDialogFragment$subscriptionStatusRepository$2(this));
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new BurnOptionsDetailsDialogFragment$viewModel$2(this));
    }

    private final void closeBottomSheet() {
        Fragment parentFragment = getParentFragment();
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding = parentFragment instanceof DSBottomSheetFragmentWithoutPadding ? (DSBottomSheetFragmentWithoutPadding) parentFragment : null;
        if (dSBottomSheetFragmentWithoutPadding != null) {
            dSBottomSheetFragmentWithoutPadding.dismiss();
        }
    }

    private final ISubscriptionStatusRepository getSubscriptionStatusRepository() {
        return (ISubscriptionStatusRepository) this.subscriptionStatusRepository$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TalabatTracker getTalabatTracker() {
        return (TalabatTracker) this.talabatTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final BurnOptionsDetailsViewModel getViewModel() {
        return (BurnOptionsDetailsViewModel) this.viewModel$delegate.getValue();
    }

    private final String getVoucherName() {
        boolean z11;
        boolean z12;
        String redeemOptionTitle = getViewModel().getRedeemOptionTitle();
        Character orNull = StringsKt___StringsKt.getOrNull(redeemOptionTitle, 1);
        if (orNull != null) {
            z11 = Character.isLowerCase(orNull.charValue());
        } else {
            z11 = false;
        }
        if (!z11) {
            return redeemOptionTitle;
        }
        if (redeemOptionTitle.length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return redeemOptionTitle;
        }
        StringBuilder sb2 = new StringBuilder();
        String valueOf = String.valueOf(redeemOptionTitle.charAt(0));
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        sb2.append(lowerCase);
        String substring = redeemOptionTitle.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public final void handleFailure(Failure failure) {
        trackRedeemFailed(getViewModel().getBurnItemDisplayModelLiveData().getValue(), GA_REASON_API_FAILED);
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        LinearLayout linearLayout = fragmentBurnOptionsDetailsBinding.burnDetailsCurrentPointsLinearLayout;
        String string = getResources().getString(R.string.sorry_something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…rry_something_went_wrong)");
        Status.Companion.notify$default(companion, activity, linearLayout, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    private final void hideProgress() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        fragmentBurnOptionsDetailsBinding.burnDetailsRedeemButton.setLoading(false);
    }

    /* access modifiers changed from: private */
    public final void navigateToProBenefitPage() {
        FragmentActivity activity;
        if (!getSubscriptionStatusRepository().isTProUser() && (activity = getActivity()) != null) {
            TproNavigatorActionsKt.navigateToBenefitsActivity(activity);
        }
        closeBottomSheet();
    }

    /* access modifiers changed from: private */
    public final void redeemOption() {
        BurnItemDisplayModel value = getViewModel().getBurnItemDisplayModelLiveData().getValue();
        if (value != null) {
            showProgress();
            getViewModel().redeemBurnOption(value.getId(), value.getBurnOptionType(), RedeemSourceType.MARKET_PLACE, value.getVoucherOptionType(), new RedeemTrackData(value.getId(), Customer.getInstance().getCustomerInfo().f13850id));
        }
    }

    private final void setup(String str, int i11) {
        setupTitle(str);
        setupTopPoints(i11);
        setupBottomPoints();
        setupRedeemButton(i11);
    }

    private final void setupBottomPoints() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        View view = fragmentBurnOptionsDetailsBinding.separatorV;
        Intrinsics.checkNotNullExpressionValue(view, "binding.separatorV");
        view.setVisibility(8);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding3;
        }
        TextView textView = fragmentBurnOptionsDetailsBinding2.burnDetailsAvailablePointsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.burnDetailsAvailablePointsTextView");
        textView.setVisibility(8);
    }

    private final void setupObservers() {
        LifecycleKt.failure(this, getViewModel().getFailureData(), new BurnOptionsDetailsDialogFragment$setupObservers$1(this));
        LifecycleKt.observe(this, getViewModel().getRedeemData(), new BurnOptionsDetailsDialogFragment$setupObservers$2(this));
        LifecycleKt.observe(this, getViewModel().getBurnItemDisplayModelLiveData(), new BurnOptionsDetailsDialogFragment$setupObservers$3(this));
    }

    private final void setupRaffle(boolean z11, String str, int i11) {
        setupRaffleTitle(str);
        setupRaffleTopPoints();
        boolean isTProUser = getSubscriptionStatusRepository().isTProUser();
        if (!z11 || isTProUser) {
            setupRaffleBottomPoints();
            setupRedeemButton(i11);
            return;
        }
        setupBottomPoints();
        setupTProButton();
    }

    private final void setupRaffleBottomPoints() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        View view = fragmentBurnOptionsDetailsBinding.separatorV;
        Intrinsics.checkNotNullExpressionValue(view, "binding.separatorV");
        view.setVisibility(0);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding3 = null;
        }
        TextView textView = fragmentBurnOptionsDetailsBinding3.burnDetailsAvailablePointsTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.burnDetailsAvailablePointsTextView");
        textView.setVisibility(0);
        String decimalFormat = ExtentionsKt.decimalFormat(getViewModel().getTotalPoints());
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding4 = this.binding;
        if (fragmentBurnOptionsDetailsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding4;
        }
        fragmentBurnOptionsDetailsBinding2.burnDetailsAvailablePointsTextView.setText(getString(R.string.loyalty_current_points, decimalFormat));
    }

    private final void setupRaffleTitle(String str) {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        fragmentBurnOptionsDetailsBinding.burnDetailsTitleTextView.setText(getResources().getString(R.string.enter_the_raffle, new Object[]{str}));
    }

    private final void setupRaffleTopPoints() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        TextView textView = fragmentBurnOptionsDetailsBinding.pointsTv;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pointsTv");
        textView.setVisibility(8);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding3;
        }
        TextView textView2 = fragmentBurnOptionsDetailsBinding2.burnDetailsItemPointsTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.burnDetailsItemPointsTextView");
        textView2.setVisibility(8);
    }

    private final void setupRedeemButton(int i11) {
        String decimalFormat = ExtentionsKt.decimalFormat(i11);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        DSPrimaryButton dSPrimaryButton = fragmentBurnOptionsDetailsBinding.burnDetailsRedeemButton;
        String string = getString(R.string.loyalty_redeem_for_points, decimalFormat);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n            c…attedPointsCost\n        )");
        dSPrimaryButton.setTitle(string);
    }

    private final void setupTProButton() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        DSPrimaryButton dSPrimaryButton = fragmentBurnOptionsDetailsBinding.burnDetailsRedeemButton;
        Intrinsics.checkNotNullExpressionValue(dSPrimaryButton, "binding.burnDetailsRedeemButton");
        dSPrimaryButton.setVisibility(8);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding3;
        }
        DSPrimaryButton dSPrimaryButton2 = fragmentBurnOptionsDetailsBinding2.burnDetailsTProButton;
        Intrinsics.checkNotNullExpressionValue(dSPrimaryButton2, "binding.burnDetailsTProButton");
        dSPrimaryButton2.setVisibility(0);
    }

    private final void setupTag(String str) {
        boolean z11;
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = null;
        if (!z11) {
            str = null;
        }
        if (str != null) {
            FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = this.binding;
            if (fragmentBurnOptionsDetailsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentBurnOptionsDetailsBinding2 = null;
            }
            fragmentBurnOptionsDetailsBinding2.ttTag.setTagText(str);
            FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
            if (fragmentBurnOptionsDetailsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentBurnOptionsDetailsBinding = fragmentBurnOptionsDetailsBinding3;
            }
            TalabatTag talabatTag = fragmentBurnOptionsDetailsBinding.ttTag;
            Intrinsics.checkNotNullExpressionValue(talabatTag, "binding.ttTag");
            talabatTag.setVisibility(0);
        }
    }

    private final void setupTitle(String str) {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        fragmentBurnOptionsDetailsBinding.burnDetailsTitleTextView.setText(getResources().getString(R.string.want_to_redeem, new Object[]{str}));
    }

    private final void setupTopPoints(int i11) {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        TextView textView = fragmentBurnOptionsDetailsBinding.pointsTv;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.pointsTv");
        textView.setVisibility(0);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding3 = null;
        }
        TextView textView2 = fragmentBurnOptionsDetailsBinding3.burnDetailsItemPointsTextView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.burnDetailsItemPointsTextView");
        textView2.setVisibility(0);
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding4 = this.binding;
        if (fragmentBurnOptionsDetailsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding4;
        }
        fragmentBurnOptionsDetailsBinding2.burnDetailsItemPointsTextView.setText(getViewModel().formattedPoints(Integer.valueOf(i11)));
    }

    private final void setupView() {
        showProgress();
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        fragmentBurnOptionsDetailsBinding.burnDetailsRedeemButton.setOnTap(new BurnOptionsDetailsDialogFragment$setupView$1(this));
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding3 = null;
        }
        fragmentBurnOptionsDetailsBinding3.burnDetailsTProButton.setOnTap(new BurnOptionsDetailsDialogFragment$setupView$2(this));
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding4 = this.binding;
        if (fragmentBurnOptionsDetailsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding4;
        }
        fragmentBurnOptionsDetailsBinding2.dsIconButtonClose.setOnTap(new BurnOptionsDetailsDialogFragment$setupView$3(this));
    }

    /* access modifiers changed from: private */
    public final void showConfirmation(ConfirmationDisplayModel confirmationDisplayModel) {
        hideProgress();
        if (confirmationDisplayModel != null) {
            trackRedeemCompleted(confirmationDisplayModel);
            BurnItemDisplayModel value = getViewModel().getBurnItemDisplayModelLiveData().getValue();
            if (value != null) {
                showConfirmationBottomSheet(value, confirmationDisplayModel, getViewModel().getRemainingPoints(value.getPointsCost()));
            }
        }
    }

    private final void showConfirmationBottomSheet(BurnItemDisplayModel burnItemDisplayModel, ConfirmationDisplayModel confirmationDisplayModel, int i11) {
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding;
        Bundle bundle = new Bundle();
        bundle.putParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_Burn_OPTION_DATA, burnItemDisplayModel);
        bundle.putParcelable(GrowthNavigatorActions.EXTRA_LOYALTY_CONFIRMATION_REDEMPTION_DATA, confirmationDisplayModel);
        bundle.putInt(GrowthNavigatorActions.EXTRA_LOYALTY_REMAINING_POINTS, i11);
        RedeemConfirmationDialogFragment redeemConfirmationDialogFragment = new RedeemConfirmationDialogFragment();
        redeemConfirmationDialogFragment.setArguments(bundle);
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof DSBottomSheetFragmentWithoutPadding) {
            dSBottomSheetFragmentWithoutPadding = (DSBottomSheetFragmentWithoutPadding) parentFragment;
        } else {
            dSBottomSheetFragmentWithoutPadding = null;
        }
        if (dSBottomSheetFragmentWithoutPadding != null) {
            dSBottomSheetFragmentWithoutPadding.changeContentFragmentWithoutBackStack(redeemConfirmationDialogFragment);
        }
    }

    private final void showProgress() {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        fragmentBurnOptionsDetailsBinding.burnDetailsRedeemButton.setLoading(true);
    }

    private final void trackRedeemCompleted(ConfirmationDisplayModel confirmationDisplayModel) {
        getTalabatTracker().track(new RedeemPointsCompletedTrackingEvent(new RedeemEventParams(GA_SCREEN_NAME, String.valueOf(getViewModel().getTotalPoints()), getViewModel().getRedeemOptionTitle(), RedeemEventParams.ScreenType.REWARD, confirmationDisplayModel.getCustomerVoucherId()), Float.valueOf(0.0f), (RedeemPointsAttributes) null, 4, (DefaultConstructorMarker) null));
    }

    private final void trackRedeemFailed(BurnItemDisplayModel burnItemDisplayModel, String str) {
        String str2;
        String valueOf = String.valueOf(getViewModel().getTotalPoints());
        String redeemOptionTitle = getViewModel().getRedeemOptionTitle();
        RedeemEventParams.ScreenType screenType = RedeemEventParams.ScreenType.REWARD;
        if (burnItemDisplayModel != null) {
            str2 = burnItemDisplayModel.getId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        getTalabatTracker().track(new RedeemPointsFailedTrackingEvent(new RedeemEventParams(GA_SCREEN_NAME, valueOf, redeemOptionTitle, screenType, str2), Float.valueOf(0.0f), str, (RedeemPointsAttributes) null, 8, (DefaultConstructorMarker) null));
    }

    private final void trackRedeemPointsLoaded(int i11, BurnItemDisplayModel burnItemDisplayModel) {
        BurnOptionsDetailsFragment.VoucherPosition voucherPosition;
        String str;
        Integer num;
        Integer num2;
        RedeemEventParams redeemEventParams = new RedeemEventParams(GA_SCREEN_NAME, String.valueOf(i11), getViewModel().getRedeemOptionTitle(), RedeemEventParams.ScreenType.REWARD, burnItemDisplayModel.getId());
        Bundle arguments = getArguments();
        if (arguments != null) {
            voucherPosition = (BurnOptionsDetailsFragment.VoucherPosition) arguments.getParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_VOUCHER_POSITION);
        } else {
            voucherPosition = null;
        }
        String id2 = burnItemDisplayModel.getId();
        if (voucherPosition != null) {
            str = voucherPosition.getChannelName();
        } else {
            str = null;
        }
        if (voucherPosition != null) {
            num = voucherPosition.getChannelPosition();
        } else {
            num = null;
        }
        if (voucherPosition != null) {
            num2 = Integer.valueOf(voucherPosition.getVoucherPosition());
        } else {
            num2 = null;
        }
        getTalabatTracker().track(new RedeemPointsLoadedTrackingEvent(redeemEventParams, id2, str, num, num2, (RedeemPointsAttributes) null, 32, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    public final void updateUi(BurnItemDisplayModel burnItemDisplayModel, int i11) {
        boolean z11;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = this.binding;
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding2 = null;
        if (fragmentBurnOptionsDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentBurnOptionsDetailsBinding = null;
        }
        TalabatImageView talabatImageView = fragmentBurnOptionsDetailsBinding.burnDetailsImageView;
        Intrinsics.checkNotNullExpressionValue(talabatImageView, "binding.burnDetailsImageView");
        TalabatImageView.setImageResizeUrl$default(talabatImageView, burnItemDisplayModel.getImageURL(), Resources.getSystem().getDisplayMetrics().widthPixels, 0, false, 12, (Object) null);
        getViewModel().setRedeemOptionTitle(burnItemDisplayModel.getTitle());
        String voucherName = getVoucherName();
        boolean z12 = true;
        if (burnItemDisplayModel.getBurnOptionType() == LoyaltyBurnOptionType.RAFFLE) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (burnItemDisplayModel.getSubscriptionRestriction() != SubscriptionRestriction.NON_T_PRO) {
                z12 = false;
            }
            setupRaffle(z12, voucherName, burnItemDisplayModel.getPointsCost());
        } else {
            setup(voucherName, burnItemDisplayModel.getPointsCost());
        }
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding3 = this.binding;
        if (fragmentBurnOptionsDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding2 = fragmentBurnOptionsDetailsBinding3;
        }
        TextView textView = fragmentBurnOptionsDetailsBinding2.burnDetailsDetailTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.burnDetailsDetailTextView");
        ExtentionsKt.renderContentAsHtml(textView, burnItemDisplayModel.getDescription());
        setupTag(burnItemDisplayModel.getTag());
        hideProgress();
        trackRedeemPointsLoaded(i11, burnItemDisplayModel);
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
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerBurnOptionsDetailsDialogFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentBurnOptionsDetailsBinding fragmentBurnOptionsDetailsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "BurnOptionsDetailsDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BurnOptionsDetailsDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentBurnOptionsDetailsBinding inflate = FragmentBurnOptionsDetailsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentBurnOptionsDetailsBinding = inflate;
        }
        ConstraintLayout root = fragmentBurnOptionsDetailsBinding.getRoot();
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
        BurnItemDisplayModel burnItemDisplayModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            burnItemDisplayModel = (BurnItemDisplayModel) arguments.getParcelable(BurnOptionsDetailsActivity.EXTRA_LOYALTY_BURN_DETAILS_ITEM);
        } else {
            burnItemDisplayModel = null;
        }
        setupView();
        if (burnItemDisplayModel != null) {
            getViewModel().setTotalPoints(requireArguments().getInt("BurnDetailsTotalPoints"));
            getViewModel().setBurnOptionItemDetails(burnItemDisplayModel);
        }
        setupObservers();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }
}
