package com.talabat.talabatlife.ui.onBoarding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationGlobalDataModel;
import com.integration.tLife.IntegrationAppTrackerTLifeSubscriptions;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheet;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.onBoarding.di.DaggerTLifeOnBoardingFragmentComponent;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingWaitListDisplayModel;
import com.talabat.talabatlife.ui.onBoarding.viewModel.TLifeOnBoardingViewModel;
import com.talabat.talabatlife.ui.onBoarding.viewModel.TLifeOnBoardingViewModelBuilder;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorListDisplayModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.tracking.TrackerKt;
import com.tracking.impl.FirebaseTracker;
import gw.c;
import gw.d;
import gw.e;
import gw.f;
import gw.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0016J\u001a\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0016\u0010/\u001a\u00020\u00162\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002J:\u00103\u001a\u00020\u001620\u00104\u001a,\u0012\u0004\u0012\u00020\u001e\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e06j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e`7\u0018\u000105H\u0002J\b\u00108\u001a\u00020\u0016H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\u0010\u0010:\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020=H\u0002J\u0012\u0010>\u001a\u00020\u00162\b\u0010?\u001a\u0004\u0018\u00010@H\u0002J\u0012\u0010A\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010BH\u0002J\u0012\u0010C\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0012\u0010F\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010G\u001a\u00020\u00162\b\u0010H\u001a\u0004\u0018\u00010=H\u0002J\b\u0010I\u001a\u00020\u0002H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006J"}, d2 = {"Lcom/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatlife/ui/onBoarding/viewModel/TLifeOnBoardingViewModel;", "()V", "bottomSheet", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheet;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "getConfigurationLocalCoreLibApi", "()Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "setConfigurationLocalCoreLibApi", "(Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "paymentBottomSheetInterface", "com/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingFragment$paymentBottomSheetInterface$1", "Lcom/talabat/talabatlife/ui/onBoarding/TLifeOnBoardingFragment$paymentBottomSheetInterface$1;", "addTermsAndConditionsLinkListener", "", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "failureVendorList", "fireTackingEventSubscriptionCompleted", "fireTackingEventSubscriptionFailed", "error", "", "getViewModelClass", "Ljava/lang/Class;", "goToTermsAndConditions", "layoutId", "", "navigateToRestaurantList", "navigateToSuccessScreen", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateRestaurantList", "vendorList", "", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "sendFireBaseEvent", "pair", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "setupUi", "showPaymentBottomSheet", "showSubscriptionFailed", "showUserInWaitList", "displayModel", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingWaitListDisplayModel;", "updateNavigationAction", "subscriptionPaymentDisplayModel", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "updatePlans", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "updateRestaurants", "vendorListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorListDisplayModel;", "updateWaitList", "updateWaitListJoined", "model", "viewModelBuilder", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TLifeOnBoardingFragment extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private PaymentWidgetBottomSheet bottomSheet;
    @Inject
    public ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private final TLifeOnBoardingFragment$paymentBottomSheetInterface$1 paymentBottomSheetInterface = new TLifeOnBoardingFragment$paymentBottomSheetInterface$1(this);

    public static final /* synthetic */ TLifeOnBoardingViewModel access$getViewModel(TLifeOnBoardingFragment tLifeOnBoardingFragment) {
        return (TLifeOnBoardingViewModel) tLifeOnBoardingFragment.getViewModel();
    }

    private final void addTermsAndConditionsLinkListener() {
        ((TextView) _$_findCachedViewById(R.id.tLife_terms_and_conditions_link)).setOnClickListener(new e(this));
        ((TextView) _$_findCachedViewById(R.id.onBoardingTLifeWaitListTAndC)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addTermsAndConditionsLinkListener$lambda-6  reason: not valid java name */
    public static final void m5833addTermsAndConditionsLinkListener$lambda6(TLifeOnBoardingFragment tLifeOnBoardingFragment, View view) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingFragment, "this$0");
        tLifeOnBoardingFragment.goToTermsAndConditions();
    }

    /* access modifiers changed from: private */
    /* renamed from: addTermsAndConditionsLinkListener$lambda-7  reason: not valid java name */
    public static final void m5834addTermsAndConditionsLinkListener$lambda7(TLifeOnBoardingFragment tLifeOnBoardingFragment, View view) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingFragment, "this$0");
        tLifeOnBoardingFragment.goToTermsAndConditions();
    }

    /* access modifiers changed from: private */
    public final void failureVendorList(Failure failure) {
        ((ProgressBar) _$_findCachedViewById(R.id.onBoardingRestaurantsProgressBar)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void fireTackingEventSubscriptionCompleted() {
        String str;
        if (getContext() != null) {
            IntegrationAppTrackerTLifeSubscriptions integrationAppTrackerTLifeSubscriptions = IntegrationAppTrackerTLifeSubscriptions.INSTANCE;
            TLifeOnBoardingPlanDisplayModel value = ((TLifeOnBoardingViewModel) getViewModel()).getPlansData().getValue();
            if (value != null) {
                str = value.getPlanTitle();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            integrationAppTrackerTLifeSubscriptions.onTLifeSubscriptionCompleted(str, "NA", "NA");
        }
    }

    private final void fireTackingEventSubscriptionFailed(String str) {
        ((TLifeOnBoardingViewModel) getViewModel()).sendSubscriptionFailed(str);
    }

    private final void goToTermsAndConditions() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, TLifeNavigationActions.Companion.createNavigationToTLifeTermsAndConditions());
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToRestaurantList() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel(TLifeNavigationActions.OPEN_TALABAT_LIFE_VENDORS_ACTIVITY, (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void navigateToSuccessScreen() {
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(WalletPaymentStatus.SUCCESS, (String) null, (String) null, (String) null, (String) null, 30, (DefaultConstructorMarker) null));
        }
    }

    private final void populateRestaurantList(List<VendorDisplayModel> list) {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.onBoardingRestaurantsViewPager);
        if (IntegrationGlobalDataModel.Companion.isArabic()) {
            CollectionsKt___CollectionsJvmKt.reverse(list);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                ((TLifeOnBoardingPageAdapter) adapter).setRestaurants(list);
                viewPager.setCurrentItem(list.size() - 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingPageAdapter");
        }
        PagerAdapter adapter2 = viewPager.getAdapter();
        if (adapter2 != null) {
            ((TLifeOnBoardingPageAdapter) adapter2).setRestaurants(list);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatlife.ui.onBoarding.TLifeOnBoardingPageAdapter");
    }

    /* access modifiers changed from: private */
    public final void sendFireBaseEvent(Pair<String, ? extends HashMap<String, String>> pair) {
        if (pair != null) {
            FirebaseTracker firebaseTracker = new FirebaseTracker();
            Map<String, Object> createParameters = firebaseTracker.createParameters("life_onboarding", "life");
            for (Map.Entry entry : ((Map) pair.getSecond()).entrySet()) {
                TrackerKt.addParameter(createParameters, (String) entry.getKey(), (String) entry.getValue());
            }
            firebaseTracker.sendEvent(pair.getFirst(), createParameters);
        }
    }

    private final void setupUi() {
        Context context = getContext();
        if (context != null) {
            ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
            String logoUrl = ((TLifeOnBoardingViewModel) getViewModel()).getLogoUrl();
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.offersLifeIconImageView);
            Intrinsics.checkNotNullExpressionValue(imageView, "offersLifeIconImageView");
            Context context2 = context;
            ImageDownloadHelper.Companion.downloadImage$default(companion, context2, logoUrl, imageView, 0, 0, false, 56, (Object) null);
            String bannerUrl = ((TLifeOnBoardingViewModel) getViewModel()).getBannerUrl();
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.tLifeOnBoardingBannerImageView);
            Intrinsics.checkNotNullExpressionValue(imageView2, "tLifeOnBoardingBannerImageView");
            ImageDownloadHelper.Companion.downloadImage$default(companion, context2, bannerUrl, imageView2, 0, 0, false, 56, (Object) null);
            ((ViewPager) _$_findCachedViewById(R.id.onBoardingRestaurantsViewPager)).setAdapter(new TLifeOnBoardingPageAdapter(context));
        }
        ((ImageButton) _$_findCachedViewById(R.id.backButton)).setOnClickListener(new c(this));
        int i11 = R.id.onBoardingOldPriceTextView;
        ((TextView) _$_findCachedViewById(i11)).setPaintFlags(((TextView) _$_findCachedViewById(i11)).getPaintFlags() | 16);
        ((LinearLayout) _$_findCachedViewById(R.id.onBoardingStartButtonLinearLayout)).setOnClickListener(new d(this));
        addTermsAndConditionsLinkListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-4  reason: not valid java name */
    public static final void m5835setupUi$lambda4(TLifeOnBoardingFragment tLifeOnBoardingFragment, View view) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingFragment, "this$0");
        FragmentActivity activity = tLifeOnBoardingFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupUi$lambda-5  reason: not valid java name */
    public static final void m5836setupUi$lambda5(TLifeOnBoardingFragment tLifeOnBoardingFragment, View view) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingFragment, "this$0");
        tLifeOnBoardingFragment.showPaymentBottomSheet();
    }

    private final void showPaymentBottomSheet() {
        FragmentActivity activity;
        ((TLifeOnBoardingViewModel) getViewModel()).sendSubscriptionClickedEvent();
        TLifeOnBoardingPlanDisplayModel value = ((TLifeOnBoardingViewModel) getViewModel()).getPlansData().getValue();
        if (value != null && (activity = getActivity()) != null) {
            PaymentWidgetBottomSheet paymentWidgetBottomSheet = new PaymentWidgetBottomSheet(((TLifeOnBoardingViewModel) getViewModel()).getPaymentInfoDisplayModel(value), this.paymentBottomSheetInterface);
            this.bottomSheet = paymentWidgetBottomSheet;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "NonNullActivity.supportFragmentManager");
            paymentWidgetBottomSheet.openBottomSheet(supportFragmentManager);
        }
    }

    /* access modifiers changed from: private */
    public final void showSubscriptionFailed(String str) {
        Status.Companion.notify$default(Status.Companion, getActivity(), (LinearLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout), str, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
        fireTackingEventSubscriptionFailed(str);
    }

    private final void showUserInWaitList(TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        ((LinearLayout) _$_findCachedViewById(R.id.onBoardingButtonRootLayout)).setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(R.id.onBoardingTLifeWaitListTextLinearLayout)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R.id.onBoardingTLifeWaitListTitleTextView)).setText(tLifeOnBoardingWaitListDisplayModel.getTitle());
        ((TextView) _$_findCachedViewById(R.id.onBoardingTLifeWaitListSubTitleTextView)).setText(tLifeOnBoardingWaitListDisplayModel.getDescription());
    }

    /* access modifiers changed from: private */
    public final void updateNavigationAction(SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        boolean z11;
        hideProgress();
        if (subscriptionPaymentDisplayModel != null) {
            Boolean isSubscribed = subscriptionPaymentDisplayModel.getResult().isSubscribed();
            Boolean bool = Boolean.FALSE;
            if (Intrinsics.areEqual((Object) isSubscribed, (Object) bool)) {
                String redirectURL = subscriptionPaymentDisplayModel.getResult().getRedirectURL();
                boolean z12 = false;
                if (redirectURL != null) {
                    if (redirectURL.length() > 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        z12 = true;
                    }
                }
                if (z12) {
                    PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
                    if (paymentWidgetBottomSheet != null) {
                        WalletPaymentStatus walletPaymentStatus = WalletPaymentStatus.THREE_DS;
                        String redirectURL2 = subscriptionPaymentDisplayModel.getResult().getRedirectURL();
                        Intrinsics.checkNotNull(redirectURL2);
                        paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(walletPaymentStatus, (String) null, (String) null, redirectURL2, (String) null, 22, (DefaultConstructorMarker) null));
                        return;
                    }
                    return;
                }
            }
            Boolean isSubscribed2 = subscriptionPaymentDisplayModel.getResult().isSubscribed();
            if (Intrinsics.areEqual((Object) isSubscribed2, (Object) Boolean.TRUE)) {
                navigateToSuccessScreen();
            } else if (Intrinsics.areEqual((Object) isSubscribed2, (Object) bool)) {
                showSubscriptionFailed(subscriptionPaymentDisplayModel.getError());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updatePlans(TLifeOnBoardingPlanDisplayModel tLifeOnBoardingPlanDisplayModel) {
        hideProgress();
        if (tLifeOnBoardingPlanDisplayModel != null) {
            ((TextView) _$_findCachedViewById(R.id.tLifeOnBoardingTitleTextView)).setText(tLifeOnBoardingPlanDisplayModel.getOnBoardingTitle());
            ((TextView) _$_findCachedViewById(R.id.tLifeOnBoardingSubTitleTextView)).setText(tLifeOnBoardingPlanDisplayModel.getOnBoardingSubTitle());
            ((TextView) _$_findCachedViewById(R.id.onBoardingPriceTextView)).setText(tLifeOnBoardingPlanDisplayModel.getPlanTitle());
            ((TextView) _$_findCachedViewById(R.id.onBoardingStartButtonTextView)).setText(tLifeOnBoardingPlanDisplayModel.getActionText());
            ((TextView) _$_findCachedViewById(R.id.onBoardingNextBillingTextTextView)).setText(tLifeOnBoardingPlanDisplayModel.getNextBillingText());
            ((TextView) _$_findCachedViewById(R.id.onBoardingNextBillingSubText)).setText(tLifeOnBoardingPlanDisplayModel.getNextBillingSubText());
        }
    }

    /* access modifiers changed from: private */
    public final void updateRestaurants(VendorListDisplayModel vendorListDisplayModel) {
        ((ProgressBar) _$_findCachedViewById(R.id.onBoardingRestaurantsProgressBar)).setVisibility(8);
        if (vendorListDisplayModel != null) {
            populateRestaurantList(vendorListDisplayModel.getVendors());
        }
    }

    /* access modifiers changed from: private */
    public final void updateWaitList(TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        hideProgress();
        if (tLifeOnBoardingWaitListDisplayModel != null) {
            ((TextView) _$_findCachedViewById(R.id.tLifeOnBoardingTitleTextView)).setText(tLifeOnBoardingWaitListDisplayModel.getOnBoardingTitle());
            ((TextView) _$_findCachedViewById(R.id.tLifeOnBoardingSubTitleTextView)).setText(tLifeOnBoardingWaitListDisplayModel.getOnBoardingSubTitle());
            if (tLifeOnBoardingWaitListDisplayModel.isUserInWaitList()) {
                showUserInWaitList(tLifeOnBoardingWaitListDisplayModel);
                return;
            }
            ((LinearLayout) _$_findCachedViewById(R.id.onBoardingStartButtonLinearLayout)).setOnClickListener(new g(this));
            int i11 = R.id.onBoardingWaitListTextView;
            ((TextView) _$_findCachedViewById(i11)).setText(tLifeOnBoardingWaitListDisplayModel.getDescription());
            ((TextView) _$_findCachedViewById(R.id.onBoardingStartButtonTextView)).setText(tLifeOnBoardingWaitListDisplayModel.getAction());
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.onBoardingPriceTextView)).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.onBoardingTLifeWaitListTextLinearLayout)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateWaitList$lambda-17$lambda-16  reason: not valid java name */
    public static final void m5837updateWaitList$lambda17$lambda16(TLifeOnBoardingFragment tLifeOnBoardingFragment, View view) {
        Intrinsics.checkNotNullParameter(tLifeOnBoardingFragment, "this$0");
        tLifeOnBoardingFragment.showProgress();
        TLifeOnBoardingViewModel.joinWaitList$default((TLifeOnBoardingViewModel) tLifeOnBoardingFragment.getViewModel(), 0, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateWaitListJoined(TLifeOnBoardingWaitListDisplayModel tLifeOnBoardingWaitListDisplayModel) {
        hideProgress();
        if (tLifeOnBoardingWaitListDisplayModel != null) {
            showUserInWaitList(tLifeOnBoardingWaitListDisplayModel);
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

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(WalletPaymentStatus.FAILURE, (String) null, (String) null, (String) null, (String) null, 30, (DefaultConstructorMarker) null));
        }
    }

    @NotNull
    public final ConfigurationLocalCoreLibApi getConfigurationLocalCoreLibApi() {
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2 = this.configurationLocalCoreLibApi;
        if (configurationLocalCoreLibApi2 != null) {
            return configurationLocalCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalCoreLibApi");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public Class<TLifeOnBoardingViewModel> getViewModelClass() {
        return TLifeOnBoardingViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_on_boarding;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getVendorList(), new TLifeOnBoardingFragment$observatory$1(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getVendorListFailure(), new TLifeOnBoardingFragment$observatory$2(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getPlansData(), new TLifeOnBoardingFragment$observatory$3(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getWaitListData(), new TLifeOnBoardingFragment$observatory$4(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getJoinWaitListData(), new TLifeOnBoardingFragment$observatory$5(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getSubscriptionPaymentData(), new TLifeOnBoardingFragment$observatory$6(this));
        LifecycleKt.observe(this, ((TLifeOnBoardingViewModel) getViewModel()).getSendFireBaseEventData(), new TLifeOnBoardingFragment$observatory$7(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerTLifeOnBoardingFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupUi();
        showProgress();
        TLifeOnBoardingViewModel.getTLifeOnBoardingPlans$default((TLifeOnBoardingViewModel) getViewModel(), 0, 1, (Object) null);
        ((ProgressBar) _$_findCachedViewById(R.id.onBoardingRestaurantsProgressBar)).setVisibility(0);
        TLifeOnBoardingViewModel.getVendorsList$default((TLifeOnBoardingViewModel) getViewModel(), 0, (String) null, (String) null, 0, 0, (String) null, 63, (Object) null);
    }

    public final void setConfigurationLocalCoreLibApi(@NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2) {
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "<set-?>");
        this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    @NotNull
    public TLifeOnBoardingViewModel viewModelBuilder() {
        TLifeOnBoardingViewModelBuilder.Companion companion = TLifeOnBoardingViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getTLifeOnBoardingViewModel(requireContext, getCoroutineScope());
    }
}
