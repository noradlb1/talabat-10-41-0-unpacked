package com.talabat.talabatlife.ui.vendorOffers;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.integration.tLife.IntegrationAppTrackerTLifeSubscriptions;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.utils.DisplayUtils;
import com.talabat.talabatcommon.views.wallet.dsalert.DSAlertView;
import com.talabat.talabatcommon.views.wallet.subscription.model.PaymentInfoDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.BottomSheetPaymentStatusModel;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.WalletPaymentStatus;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentBottomSheetInterface;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheet;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatlife.R;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.vendorList.model.VendorDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorBranchListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.model.VendorOfferListDisplayModel;
import com.talabat.talabatlife.ui.vendorOffers.viewModel.VendorOffersViewModel;
import com.talabat.talabatlife.ui.vendorOffers.viewModel.VendorOffersViewModelBuilder;
import com.talabat.talabatlife.ui.vendorOffers.viewModel.VendorOffersViewModelImpl;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchView;
import com.talabat.talabatlife.ui.vendorOffers.views.branch.VendorBranchesBottomSheetDialogFragment;
import com.talabat.talabatlife.ui.vendorOffers.views.offers.VendorsOfferListAdaptor;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ow.a;
import ow.b;
import ow.c;
import ow.d;
import ow.e;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0012\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\b\u00102\u001a\u00020\u001eH\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\b\u00107\u001a\u00020\u001eH\u0016J\u001a\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u0017J\b\u0010=\u001a\u00020\u001eH\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\u0012\u0010?\u001a\u00020\u001e2\b\u0010@\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\u001eH\u0002J\u0018\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020!H\u0016J\b\u0010K\u001a\u00020\u001eH\u0002J\u0016\u0010L\u001a\u00020\u001e2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NH\u0002J\u0010\u0010P\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020!H\u0002J\u0012\u0010Q\u001a\u00020\u001e2\b\u0010R\u001a\u0004\u0018\u00010SH\u0002J\u0012\u0010T\u001a\u00020\u001e2\b\u0010U\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010V\u001a\u00020\u001e2\b\u0010U\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010W\u001a\u00020XH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/VendorOffersFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatlife/ui/vendorOffers/viewModel/VendorOffersViewModel;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentBottomSheetInterface;", "()V", "bottomSheet", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/PaymentWidgetBottomSheet;", "branchListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchListDisplayModel;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "isCoffeeMode", "", "offerListDisplayModel", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferListDisplayModel;", "plan", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "getPlan", "()Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;", "setPlan", "(Lcom/talabat/talabatcommon/views/wallet/subscription/model/PaymentInfoDisplayModel;)V", "selectedOfferIndex", "", "getSelectedOfferIndex", "()I", "setSelectedOfferIndex", "(I)V", "vendorDisplayModel", "Lcom/talabat/talabatlife/ui/vendorList/model/VendorDisplayModel;", "disableScroll", "", "displayFreeCoffeeWarning", "message", "", "enableOrDisabledScroll", "enableScroll", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fireTackingEventSubscriptionCompleted", "fireTackingEventSubscriptionFailed", "error", "getExtras", "getViewModelClass", "Ljava/lang/Class;", "handleOfferLimitsWarning", "offer", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorOfferDisplayModel;", "layoutId", "loadVendorBranches", "loadVendorOffers", "navigateToQRScanner", "ctx", "Landroid/content/Context;", "navigateToSuccessScreen", "observatory", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openPaymentWidget", "populateUi", "populateVendorInfo", "vendorData", "sendCardDetailsToParentScreen", "card", "Lcom/talabat/talabatcommon/model/wallet/WalletCardDisplayModel;", "paymentMethod", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/PaymentMethod;", "sendLifeDetailsLoadedEvent", "sendPaymentWidgetClosedEvent", "paymentStatus", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/model/WalletPaymentStatus;", "transactionId", "setup", "showBranchesBottomSheet", "branches", "", "Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "showSubscriptionFailed", "subscriptionPayment", "subscriptionPaymentDisplayModel", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "updateBranches", "displayModel", "updateOffers", "viewModelBuilder", "Lcom/talabat/talabatlife/ui/vendorOffers/viewModel/VendorOffersViewModelImpl;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorOffersFragment extends BaseFragment implements PaymentBottomSheetInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private PaymentWidgetBottomSheet bottomSheet;
    @Nullable
    private VendorBranchListDisplayModel branchListDisplayModel;
    private FusedLocationProviderClient fusedLocationClient;
    private boolean isCoffeeMode;
    @Nullable
    private VendorOfferListDisplayModel offerListDisplayModel;
    @Nullable
    private PaymentInfoDisplayModel plan;
    private int selectedOfferIndex = -1;
    @Nullable
    private VendorDisplayModel vendorDisplayModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VendorOfferDisplayModel.LimitType.values().length];
            iArr[VendorOfferDisplayModel.LimitType.Daily.ordinal()] = 1;
            iArr[VendorOfferDisplayModel.LimitType.Monthly.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[WalletPaymentStatus.values().length];
            iArr2[WalletPaymentStatus.SUCCESS.ordinal()] = 1;
            iArr2[WalletPaymentStatus.FAILURE.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final /* synthetic */ VendorOffersViewModel access$getViewModel(VendorOffersFragment vendorOffersFragment) {
        return (VendorOffersViewModel) vendorOffersFragment.getViewModel();
    }

    private final void disableScroll() {
        int i11 = R.id.collapsing_toolbar;
        ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
            layoutParams2.setScrollFlags(0);
            ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    private final void displayFreeCoffeeWarning(String str) {
        if (str != null) {
            ((TextView) _$_findCachedViewById(R.id.infoDineInOffer)).setVisibility(8);
            int i11 = R.id.limitWarning;
            ((DSAlertView) _$_findCachedViewById(i11)).setDescriptor(str);
            ((DSAlertView) _$_findCachedViewById(i11)).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.vendorOffersRecyclerView)).setVisibility(8);
            int i12 = R.id.tLifeVendorOfferRedeemLayout;
            ((LinearLayout) _$_findCachedViewById(i12)).getLayoutParams().height = (int) FloatKt.convertDpToPixels(90.0f);
            ((LinearLayout) _$_findCachedViewById(i12)).requestLayout();
        }
    }

    private final boolean enableOrDisabledScroll() {
        return new Handler().postDelayed(new b(this), 100);
    }

    /* access modifiers changed from: private */
    /* renamed from: enableOrDisabledScroll$lambda-22  reason: not valid java name */
    public static final void m5862enableOrDisabledScroll$lambda22(VendorOffersFragment vendorOffersFragment) {
        Intrinsics.checkNotNullParameter(vendorOffersFragment, "this$0");
        int i11 = R.id.tLifeVendorOffersScrollView;
        if (((NestedScrollView) vendorOffersFragment._$_findCachedViewById(i11)).canScrollVertically(1) || ((NestedScrollView) vendorOffersFragment._$_findCachedViewById(i11)).canScrollVertically(0)) {
            vendorOffersFragment.enableScroll();
        } else {
            vendorOffersFragment.disableScroll();
        }
    }

    private final void enableScroll() {
        int i11 = R.id.collapsing_toolbar;
        ViewGroup.LayoutParams layoutParams = ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).getLayoutParams();
        if (layoutParams != null) {
            AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
            layoutParams2.setScrollFlags(3);
            ((CollapsingToolbarLayout) _$_findCachedViewById(i11)).setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    private final void fireTackingEventSubscriptionCompleted() {
        String str;
        IntegrationAppTrackerTLifeSubscriptions integrationAppTrackerTLifeSubscriptions = IntegrationAppTrackerTLifeSubscriptions.INSTANCE;
        PaymentInfoDisplayModel paymentInfoDisplayModel = this.plan;
        if (paymentInfoDisplayModel == null || (str = paymentInfoDisplayModel.getPlanTitle()) == null) {
            str = "";
        }
        integrationAppTrackerTLifeSubscriptions.onTLifeSubscriptionCompleted(str, "NA", "NA");
    }

    private final void fireTackingEventSubscriptionFailed(String str) {
        ((VendorOffersViewModel) getViewModel()).sendSubscriptionFailed(str);
    }

    private final void getExtras() {
        VendorDisplayModel vendorDisplayModel2;
        Integer intOrNull;
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey(TLifeNavigationActions.EXTRA_PLAN)) {
                PaymentInfoDisplayModel paymentInfoDisplayModel = (PaymentInfoDisplayModel) arguments.getParcelable(TLifeNavigationActions.EXTRA_PLAN);
                this.plan = paymentInfoDisplayModel;
                if (paymentInfoDisplayModel != null) {
                    ((ImageView) _$_findCachedViewById(R.id.tLifeVendorOfferQRCodeImageView)).setVisibility(8);
                    TextView textView = (TextView) _$_findCachedViewById(R.id.tLifeVendorOfferQRCodeText);
                    PaymentInfoDisplayModel paymentInfoDisplayModel2 = this.plan;
                    if (paymentInfoDisplayModel2 != null) {
                        str = paymentInfoDisplayModel2.getActionText();
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                    ((VendorOffersViewModel) getViewModel()).setPaymentPlan(this.plan);
                }
            }
            this.isCoffeeMode = arguments.getBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE);
            if (arguments.containsKey(TLifeNavigationActions.EXTRA_VENDOR_OFFER_MODEL)) {
                this.vendorDisplayModel = (VendorDisplayModel) arguments.getParcelable(TLifeNavigationActions.EXTRA_VENDOR_OFFER_MODEL);
                return;
            }
            VendorDisplayModel vendorDisplayModel3 = r2;
            VendorDisplayModel vendorDisplayModel4 = new VendorDisplayModel(0, (String) null, (String) null, (String) null, (String) null, 0, 0.0d, (String) null, (String) null, 0.0f, (List) null, false, false, (String) null, 16383, (DefaultConstructorMarker) null);
            String string = arguments.getString("vendorID");
            if (string == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(string)) == null) {
                vendorDisplayModel2 = vendorDisplayModel3;
            } else {
                vendorDisplayModel2 = vendorDisplayModel3;
                vendorDisplayModel2.setRestaurantId(intOrNull.intValue());
                ((VendorOffersViewModel) getViewModel()).getVendorInfo(vendorDisplayModel2.getRestaurantId());
            }
            this.vendorDisplayModel = vendorDisplayModel2;
        }
    }

    /* access modifiers changed from: private */
    public final void handleOfferLimitsWarning(VendorOfferDisplayModel vendorOfferDisplayModel) {
        String str;
        VendorOfferDisplayModel.LimitType reachedLimit = ((VendorOffersViewModel) getViewModel()).getReachedLimit(vendorOfferDisplayModel);
        if (!this.isCoffeeMode || reachedLimit == VendorOfferDisplayModel.LimitType.None) {
            ((LinearLayout) _$_findCachedViewById(R.id.tLifeVendorOfferRedeemButton)).setEnabled(true);
            return;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[reachedLimit.ordinal()];
        if (i11 == 1) {
            str = getString(com.talabat.localization.R.string.tpro_free_coffee_daily_limit_message);
        } else if (i11 != 2) {
            str = null;
        } else {
            str = getString(com.talabat.localization.R.string.tpro_free_coffee_monthly_limit_message);
        }
        displayFreeCoffeeWarning(str);
    }

    private final void loadVendorBranches() {
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        if (vendorDisplayModel2 != null) {
            ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersBranchesProgressBar)).setVisibility(0);
            ((RelativeLayout) _$_findCachedViewById(R.id.vendorOffersBranchViews)).setVisibility(4);
            FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
            if (fusedLocationProviderClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
                fusedLocationProviderClient = null;
            }
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new a(this, vendorDisplayModel2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loadVendorBranches$lambda-17$lambda-16  reason: not valid java name */
    public static final void m5863loadVendorBranches$lambda17$lambda16(VendorOffersFragment vendorOffersFragment, VendorDisplayModel vendorDisplayModel2, Location location) {
        Intrinsics.checkNotNullParameter(vendorOffersFragment, "this$0");
        Intrinsics.checkNotNullParameter(vendorDisplayModel2, "$it");
        if (location != null) {
            SafeLetKt.safeLet(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), new VendorOffersFragment$loadVendorBranches$1$1$1$1(vendorOffersFragment, vendorDisplayModel2));
        }
    }

    private final void loadVendorOffers() {
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        if (vendorDisplayModel2 != null) {
            ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersProgressBar)).setVisibility(0);
            VendorOffersViewModel.getVendorOffers$default((VendorOffersViewModel) getViewModel(), vendorDisplayModel2.getRestaurantId(), 0, 2, (Object) null);
        }
    }

    private final void navigateToQRScanner(Context context) {
        Navigator.Companion companion = Navigator.Companion;
        Bundle bundle = new Bundle();
        bundle.putInt(WalletNavigatorActions.EXTRA_QR_SCANNER_SELECTED_OFFER, this.selectedOfferIndex);
        bundle.putBoolean(TLifeNavigationActions.EXTRA_IS_FREE_COFFEE_MODE, this.isCoffeeMode);
        Unit unit = Unit.INSTANCE;
        companion.navigate(context, new NavigatorModel(WalletNavigatorActions.OPEN_WALLET_QR_CODE_SCANNER_ACTIVITY, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
    }

    private final void navigateToSuccessScreen() {
        PaymentWidgetBottomSheet paymentWidgetBottomSheet = this.bottomSheet;
        if (paymentWidgetBottomSheet != null) {
            paymentWidgetBottomSheet.updatePaymentStatus(new BottomSheetPaymentStatusModel(WalletPaymentStatus.SUCCESS, (String) null, (String) null, (String) null, (String) null, 30, (DefaultConstructorMarker) null));
        }
    }

    private final void openPaymentWidget() {
        PaymentWidgetBottomSheet paymentWidgetBottomSheet;
        PaymentWidgetBottomSheet paymentWidgetBottomSheet2;
        PaymentInfoDisplayModel paymentInfoDisplayModel = this.plan;
        if (paymentInfoDisplayModel != null) {
            paymentWidgetBottomSheet = new PaymentWidgetBottomSheet(paymentInfoDisplayModel, this);
        } else {
            paymentWidgetBottomSheet = null;
        }
        this.bottomSheet = paymentWidgetBottomSheet;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && (paymentWidgetBottomSheet2 = this.bottomSheet) != null) {
            paymentWidgetBottomSheet2.openBottomSheet(fragmentManager);
        }
    }

    private final void populateUi() {
        getExtras();
        ((LinearLayout) _$_findCachedViewById(R.id.tLifeVendorOfferRedeemButton)).setEnabled(false);
        VendorDisplayModel vendorDisplayModel2 = this.vendorDisplayModel;
        if (vendorDisplayModel2 != null) {
            populateVendorInfo(vendorDisplayModel2);
            loadVendorBranches();
            loadVendorOffers();
        }
    }

    /* access modifiers changed from: private */
    public final void populateVendorInfo(VendorDisplayModel vendorDisplayModel2) {
        this.vendorDisplayModel = vendorDisplayModel2;
        if (vendorDisplayModel2 != null) {
            ImageView imageView = (ImageView) _$_findCachedViewById(R.id.vendorOffersImageView);
            String imageUrl = vendorDisplayModel2.getImageUrl();
            int roundToInt = MathKt__MathJVMKt.roundToInt(((float) 200) * getResources().getDisplayMetrics().density);
            int i11 = getResources().getDisplayMetrics().widthPixels;
            Intrinsics.checkNotNullExpressionValue(imageView, "vendorOffersImageView");
            ImageViewForTalabatKt.setImageResizeUrl$default(imageView, imageUrl, i11, roundToInt, false, 8, (Object) null);
            ((TextView) _$_findCachedViewById(R.id.tLifeVendorListTitleTextView)).setText(vendorDisplayModel2.getName());
            ((TextView) _$_findCachedViewById(R.id.tLifeVendorListCousinTextView)).setText(vendorDisplayModel2.getCuisines());
        }
    }

    private final void sendLifeDetailsLoadedEvent() {
        VendorOffersAnalytics.Companion.fireOfferTrackingEvent(getContext(), this.vendorDisplayModel, ((VendorOffersViewModel) getViewModel()).getVendorOffersData().getValue(), ((VendorOffersViewModel) getViewModel()).getVendorBranchData().getValue());
    }

    private final void setup() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DisplayUtils.Companion.transparentStatus(activity);
            FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) activity);
            Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(it)");
            this.fusedLocationClient = fusedLocationProviderClient;
        }
        ((ImageButton) _$_findCachedViewById(R.id.vendorOffersBackButton)).setOnClickListener(new c(this));
        Context context = getContext();
        if (context != null) {
            ((RecyclerView) _$_findCachedViewById(R.id.vendorOffersRecyclerView)).setLayoutManager(new LinearLayoutManager(context));
            ((LinearLayout) _$_findCachedViewById(R.id.tLifeVendorOfferRedeemButton)).setOnClickListener(new d(this, context));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-19  reason: not valid java name */
    public static final void m5864setup$lambda19(VendorOffersFragment vendorOffersFragment, View view) {
        Intrinsics.checkNotNullParameter(vendorOffersFragment, "this$0");
        FragmentActivity activity = vendorOffersFragment.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setup$lambda-21$lambda-20  reason: not valid java name */
    public static final void m5865setup$lambda21$lambda20(VendorOffersFragment vendorOffersFragment, Context context, View view) {
        Intrinsics.checkNotNullParameter(vendorOffersFragment, "this$0");
        Intrinsics.checkNotNullParameter(context, "$ctx");
        if (vendorOffersFragment.plan != null) {
            vendorOffersFragment.openPaymentWidget();
            return;
        }
        vendorOffersFragment.navigateToQRScanner(context);
        VendorOffersAnalytics.Companion.fireQRTrackingEvent(context, vendorOffersFragment.vendorDisplayModel, ((VendorOffersViewModel) vendorOffersFragment.getViewModel()).getVendorOffersData().getValue(), ((VendorOffersViewModel) vendorOffersFragment.getViewModel()).getVendorBranchData().getValue());
    }

    private final void showBranchesBottomSheet(List<VendorBranchDisplayModel> list) {
        FragmentTransaction beginTransaction;
        VendorBranchesBottomSheetDialogFragment vendorBranchesBottomSheetDialogFragment = new VendorBranchesBottomSheetDialogFragment(list);
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null && (beginTransaction = fragmentManager.beginTransaction()) != null) {
            vendorBranchesBottomSheetDialogFragment.show(beginTransaction, "");
        }
    }

    private final void showSubscriptionFailed(String str) {
        fireTackingEventSubscriptionFailed(str);
    }

    /* access modifiers changed from: private */
    public final void subscriptionPayment(SubscriptionPaymentDisplayModel subscriptionPaymentDisplayModel) {
        boolean z11;
        Boolean bool;
        SubscriptionPaymentDisplayModel.SubscriptionPaymentResult result;
        boolean z12;
        SubscriptionPaymentDisplayModel.SubscriptionPaymentResult result2;
        boolean z13 = false;
        if (subscriptionPaymentDisplayModel == null || (result2 = subscriptionPaymentDisplayModel.getResult()) == null) {
            z11 = false;
        } else {
            z11 = Intrinsics.areEqual((Object) result2.isSubscribed(), (Object) Boolean.FALSE);
        }
        if (z11) {
            String redirectURL = subscriptionPaymentDisplayModel.getResult().getRedirectURL();
            if (redirectURL != null) {
                if (redirectURL.length() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    z13 = true;
                }
            }
            if (z13) {
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
        if (subscriptionPaymentDisplayModel == null || (result = subscriptionPaymentDisplayModel.getResult()) == null) {
            bool = null;
        } else {
            bool = result.isSubscribed();
        }
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            navigateToSuccessScreen();
        } else if (Intrinsics.areEqual((Object) bool, (Object) Boolean.FALSE)) {
            showSubscriptionFailed(subscriptionPaymentDisplayModel.getError());
        }
    }

    /* access modifiers changed from: private */
    public final void updateBranches(VendorBranchListDisplayModel vendorBranchListDisplayModel) {
        ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersBranchesProgressBar)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(R.id.vendorOffersBranchViews)).setVisibility(0);
        if (vendorBranchListDisplayModel != null) {
            this.branchListDisplayModel = vendorBranchListDisplayModel;
            if (vendorBranchListDisplayModel.getBranches().size() > 0) {
                ((VendorBranchView) _$_findCachedViewById(R.id.vendorOffersVendorBranchView)).populate((VendorBranchDisplayModel) CollectionsKt___CollectionsKt.first(vendorBranchListDisplayModel.getBranches()));
                if (vendorBranchListDisplayModel.getBranches().size() > 1) {
                    String string = getString(com.talabat.localization.R.string.vendorBranchMore);
                    ((TextView) _$_findCachedViewById(R.id.vendorOffersBranchCount)).setText((vendorBranchListDisplayModel.getBranches().size() - 1) + " " + string);
                    ((LinearLayout) _$_findCachedViewById(R.id.vendorOffersBranchCountLinearLayout)).setOnClickListener(new e(this, vendorBranchListDisplayModel));
                } else {
                    ((LinearLayout) _$_findCachedViewById(R.id.vendorOffersBranchCountLinearLayout)).setVisibility(8);
                }
            }
        }
        sendLifeDetailsLoadedEvent();
    }

    /* access modifiers changed from: private */
    /* renamed from: updateBranches$lambda-6$lambda-5  reason: not valid java name */
    public static final void m5866updateBranches$lambda6$lambda5(VendorOffersFragment vendorOffersFragment, VendorBranchListDisplayModel vendorBranchListDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(vendorOffersFragment, "this$0");
        Intrinsics.checkNotNullParameter(vendorBranchListDisplayModel, "$model");
        vendorOffersFragment.showBranchesBottomSheet(vendorBranchListDisplayModel.getBranches().subList(1, vendorBranchListDisplayModel.getBranches().size()));
    }

    /* access modifiers changed from: private */
    public final void updateOffers(VendorOfferListDisplayModel vendorOfferListDisplayModel) {
        List<VendorOfferDisplayModel> offerList;
        Object obj;
        boolean z11;
        ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersProgressBar)).setVisibility(8);
        if (vendorOfferListDisplayModel != null) {
            this.offerListDisplayModel = vendorOfferListDisplayModel;
            VendorsOfferListAdaptor vendorsOfferListAdaptor = new VendorsOfferListAdaptor(vendorOfferListDisplayModel.getOfferList());
            vendorsOfferListAdaptor.setVendorClickListener(new VendorOffersFragment$updateOffers$1$1$1(this));
            ((RecyclerView) _$_findCachedViewById(R.id.vendorOffersRecyclerView)).setAdapter(vendorsOfferListAdaptor);
        }
        enableOrDisabledScroll();
        sendLifeDetailsLoadedEvent();
        if (vendorOfferListDisplayModel != null && (offerList = vendorOfferListDisplayModel.getOfferList()) != null) {
            Iterator it = offerList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((VendorOfferDisplayModel) obj).isEnabled()) {
                    break;
                }
            }
            if (obj == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && offerList.size() > 0) {
                handleOfferLimitsWarning(offerList.get(0));
            }
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
        ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersBranchesProgressBar)).setVisibility(8);
        ((ProgressBar) _$_findCachedViewById(R.id.vendorOffersProgressBar)).setVisibility(8);
    }

    public void getCardClicked() {
        PaymentBottomSheetInterface.DefaultImpls.getCardClicked(this);
    }

    @Nullable
    public final PaymentInfoDisplayModel getPlan() {
        return this.plan;
    }

    public final int getSelectedOfferIndex() {
        return this.selectedOfferIndex;
    }

    @NotNull
    public Class<VendorOffersViewModel> getViewModelClass() {
        return VendorOffersViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_vendor_offers;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((VendorOffersViewModel) getViewModel()).getVendorData(), new VendorOffersFragment$observatory$1(this));
        LifecycleKt.observe(this, ((VendorOffersViewModel) getViewModel()).getVendorBranchData(), new VendorOffersFragment$observatory$2(this));
        LifecycleKt.observe(this, ((VendorOffersViewModel) getViewModel()).getVendorOffersData(), new VendorOffersFragment$observatory$3(this));
        LifecycleKt.observe(this, ((VendorOffersViewModel) getViewModel()).getSubscriptionPaymentData(), new VendorOffersFragment$observatory$4(this));
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @RequiresApi(20)
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DisplayUtils.Companion companion = DisplayUtils.Companion;
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(R.id.anim_toolbar);
        Intrinsics.checkNotNullExpressionValue(toolbar, "anim_toolbar");
        companion.setStatusBarHeight(view, toolbar);
        setup();
        populateUi();
    }

    public void sendCardDetailsToParentScreen(@NotNull WalletCardDisplayModel walletCardDisplayModel, @NotNull PaymentMethod paymentMethod) {
        String str;
        Intrinsics.checkNotNullParameter(walletCardDisplayModel, "card");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        VendorOffersViewModel vendorOffersViewModel = (VendorOffersViewModel) getViewModel();
        VendorOffersViewModel vendorOffersViewModel2 = (VendorOffersViewModel) getViewModel();
        PaymentInfoDisplayModel paymentInfoDisplayModel = this.plan;
        if (paymentInfoDisplayModel != null) {
            str = paymentInfoDisplayModel.getPlanId();
        } else {
            str = null;
        }
        vendorOffersViewModel.payForSubscription(vendorOffersViewModel2.getSubscriptionPaymentRequestModel(walletCardDisplayModel, str));
    }

    public void sendPaymentWidgetClosedEvent(@NotNull WalletPaymentStatus walletPaymentStatus, @NotNull String str) {
        Intrinsics.checkNotNullParameter(walletPaymentStatus, "paymentStatus");
        Intrinsics.checkNotNullParameter(str, "transactionId");
        int i11 = WhenMappings.$EnumSwitchMapping$1[walletPaymentStatus.ordinal()];
        if (i11 == 1) {
            Context context = getContext();
            if (context != null) {
                navigateToQRScanner(context);
                VendorOffersAnalytics.Companion.fireQRTrackingEvent(context, this.vendorDisplayModel, ((VendorOffersViewModel) getViewModel()).getVendorOffersData().getValue(), ((VendorOffersViewModel) getViewModel()).getVendorBranchData().getValue());
            }
            fireTackingEventSubscriptionCompleted();
        } else if (i11 != 2) {
            LogManager.debug("unexpected payment status");
        } else {
            showSubscriptionFailed("Authentication failed");
        }
    }

    public final void setPlan(@Nullable PaymentInfoDisplayModel paymentInfoDisplayModel) {
        this.plan = paymentInfoDisplayModel;
    }

    public final void setSelectedOfferIndex(int i11) {
        this.selectedOfferIndex = i11;
    }

    @NotNull
    public VendorOffersViewModelImpl viewModelBuilder() {
        VendorOffersViewModelBuilder.Companion companion = VendorOffersViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getVendorOffersViewModel(requireContext, getCoroutineScope());
    }
}
