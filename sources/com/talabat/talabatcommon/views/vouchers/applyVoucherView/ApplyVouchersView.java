package com.talabat.talabatcommon.views.vouchers.applyVoucherView;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import androidx.core.text.HtmlCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.customMvvmView.MvvmLinearLayout;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.di.DaggerApplyVouchersViewComponent;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelBuilder;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVoucherViewModelImpl;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersActions;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.views.AddVoucherCodeView;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.logger.LogManager;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sv.a;
import sv.b;

@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001(\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020+2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010-\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020\n2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\nH\u0007J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020:H\u0016J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020&H\u0007J\b\u0010?\u001a\u00020+H\u0002J\u0016\u0010@\u001a\u00020+2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010A\u001a\u00020+H\u0002J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020+H\u0016J\u0010\u0010F\u001a\u00020+2\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020+H\u0016J\u0010\u0010H\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0002J\u000e\u0010I\u001a\u00020+2\u0006\u0010J\u001a\u00020KJ\u0010\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u000205H\u0002J\u0006\u0010N\u001a\u00020+J\u0012\u0010O\u001a\u00020+2\b\u0010<\u001a\u0004\u0018\u00010PH\u0002J\b\u0010Q\u001a\u00020+H\u0002J\b\u0010R\u001a\u00020+H\u0002J\u0010\u0010S\u001a\u00020+2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010V\u001a\u00020+2\u0006\u0010W\u001a\u00020KH\u0002J\b\u0010X\u001a\u00020+H\u0002J\u0017\u0010Y\u001a\u00020+2\b\u0010Z\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\u00020+2\u0006\u0010]\u001a\u00020^H\u0007J\u0010\u0010_\u001a\u00020+2\u0006\u0010`\u001a\u00020&H\u0002J\u0010\u0010a\u001a\u00020+2\u0006\u0010b\u001a\u00020&H\u0002J\b\u0010c\u001a\u00020dH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006e"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersView;", "Lcom/talabat/talabatcommon/views/customMvvmView/MvvmLinearLayout;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyVoucherOwner", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "callback", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersViewCallback;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "growthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "getGrowthTracker$annotations", "()V", "getGrowthTracker", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "setGrowthTracker", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;)V", "unApplyAllVouchersObserver", "Landroidx/lifecycle/Observer;", "", "vouchersViewCallback", "com/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersView$vouchersViewCallback$1", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVouchersView$vouchersViewCallback$1;", "addVoucherCodeViewClickAction", "", "checkApplyVoucherViewVisibility", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getLayoutId", "attrs", "getRedeemConfirmationMessage", "", "model", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "getTalabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getVerticalId", "getViewModelClass", "Ljava/lang/Class;", "handleEnableVouchersFeatures", "applyVouchersViewState", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates$EnableVouchersFeature;", "canShowVouchersInCheckout", "hideAddVoucherCode", "init", "initDagger", "observatory", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onLifecycleOwnerAttached", "onResume", "redeemOption", "redeemVoucherCode", "voucherCode", "", "redeemVoucherDone", "updatedVoucherDisplayModel", "refreshAllVoucher", "render", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "setupAddCodeClickListener", "showAddVoucherCode", "showAllMyPossibleVouchers", "displayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "showError", "errorMessage", "showGuestUserPopup", "unApplyVoucher", "triggerUnApplyLoyaltyVoucherAction", "(Ljava/lang/Boolean;)V", "updateFailureState", "voucherFailure", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/VoucherFailures;", "updateLoadingBarState", "isLoading", "updateUnApplyAllVouchers", "shouldUpdateApplyVoucherOwner", "viewModelBuilder", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModelImpl;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVouchersView extends MvvmLinearLayout<ApplyVoucherViewModel> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @Nullable
    public ApplyVoucherOwner applyVoucherOwner;
    /* access modifiers changed from: private */
    public ApplyVouchersViewCallback callback;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @NotNull
    private GrowthTracker growthTracker;
    @NotNull
    private final Observer<Boolean> unApplyAllVouchersObserver;
    /* access modifiers changed from: private */
    @NotNull
    public final ApplyVouchersView$vouchersViewCallback$1 vouchersViewCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView(@NotNull Context context) {
        super(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.growthTracker = GrowthTracker.INSTANCE;
        this.unApplyAllVouchersObserver = new a(this);
        initDagger();
        this.vouchersViewCallback = new ApplyVouchersView$vouchersViewCallback$1(this);
    }

    private final void addVoucherCodeViewClickAction() {
        if (Customer.getInstance().isLoggedIn()) {
            int i11 = R.id.addVoucherCodeView;
            AddVoucherCodeView addVoucherCodeView = (AddVoucherCodeView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(addVoucherCodeView, "addVoucherCodeView");
            if (ViewKt.isVisible(addVoucherCodeView)) {
                hideAddVoucherCode();
                ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.applyVoucherViewViewPager);
                Intrinsics.checkNotNullExpressionValue(viewPager, "applyVoucherViewViewPager");
                AddVoucherCodeView addVoucherCodeView2 = (AddVoucherCodeView) _$_findCachedViewById(i11);
                Intrinsics.checkNotNullExpressionValue(addVoucherCodeView2, "addVoucherCodeView");
                ViewKt.crossFade(viewPager, addVoucherCodeView2);
                return;
            }
            showAddVoucherCode();
            AddVoucherCodeView addVoucherCodeView3 = (AddVoucherCodeView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(addVoucherCodeView3, "addVoucherCodeView");
            ViewPager viewPager2 = (ViewPager) _$_findCachedViewById(R.id.applyVoucherViewViewPager);
            Intrinsics.checkNotNullExpressionValue(viewPager2, "applyVoucherViewViewPager");
            ViewKt.crossFade(addVoucherCodeView3, viewPager2);
            return;
        }
        showGuestUserPopup();
    }

    private final void checkApplyVoucherViewVisibility(ApplyVoucherOwner applyVoucherOwner2) {
        setVisibility(8);
        ((ApplyVoucherViewModel) getViewModel()).dispatchAction(new ApplyVouchersActions.CheckApplyVouchersFeaturesEnabled(applyVoucherOwner2));
    }

    @VisibleForTesting
    public static /* synthetic */ void getGrowthTracker$annotations() {
    }

    /* access modifiers changed from: private */
    public final CharSequence getRedeemConfirmationMessage(VoucherDisplayModel voucherDisplayModel) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(ViewKt.getString(this, com.talabat.localization.R.string.apply_voucher_redeem_x_points), Arrays.copyOf(new Object[]{Integer.valueOf(voucherDisplayModel.getVoucherData().getPointsCost()), voucherDisplayModel.getTitle()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return HtmlCompat.fromHtml(format, 63);
    }

    private final TalabatTracker getTalabatTracker() {
        Context applicationContext = getContext().getApplicationContext();
        if (applicationContext != null) {
            return ((TrackingCoreLibApi) ((ApiContainer) applicationContext).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    /* access modifiers changed from: private */
    public final void hideAddVoucherCode() {
        int i11 = R.id.applyVoucherViewAddCodeTextView;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setText(ViewKt.getString(this, com.talabat.localization.R.string.apply_voucher_add_code));
        ((AddVoucherCodeView) _$_findCachedViewById(R.id.addVoucherCodeView)).clearCode$com_talabat_NewArchi_TalabatCommon_TalabatCommon();
    }

    private final void initDagger() {
        DaggerApplyVouchersViewComponent.factory().create((FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(FeatureFlagCoreLibApi.class), (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((View) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public final void redeemOption(VoucherDisplayModel voucherDisplayModel) {
        int i11 = Customer.getInstance().getCustomerInfo().f13850id;
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
        ApplyVoucherOwner applyVoucherOwner2 = this.applyVoucherOwner;
        if (applyVoucherOwner2 == null) {
            applyVoucherOwner2 = ApplyVoucherOwner.Basket;
        }
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.RedeemVoucherAction(applyVoucherOwner2, voucherDisplayModel, applyVouchersViewCallback.getBranchId(), i11));
    }

    private final void redeemVoucherDone(VoucherDisplayModel voucherDisplayModel) {
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        ApplyVouchersViewCallback applyVouchersViewCallback2 = null;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        String restaurantId = applyVouchersViewCallback.getRestaurantId();
        ApplyVouchersViewCallback applyVouchersViewCallback3 = this.callback;
        if (applyVouchersViewCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback3 = null;
        }
        String branchId = applyVouchersViewCallback3.getBranchId();
        ApplyVouchersViewCallback applyVouchersViewCallback4 = this.callback;
        if (applyVouchersViewCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback4 = null;
        }
        String groceryVendorId = applyVouchersViewCallback4.getGroceryVendorId();
        if (groceryVendorId == null) {
            groceryVendorId = "";
        }
        String str = groceryVendorId;
        ApplyVouchersViewCallback applyVouchersViewCallback5 = this.callback;
        if (applyVouchersViewCallback5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback5 = null;
        }
        float cartSubtotalForVoucherMov = applyVouchersViewCallback5.getCartSubtotalForVoucherMov();
        ApplyVouchersViewCallback applyVouchersViewCallback6 = this.callback;
        if (applyVouchersViewCallback6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        } else {
            applyVouchersViewCallback2 = applyVouchersViewCallback6;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.ApplyVoucherAction(voucherDisplayModel, branchId, cartSubtotalForVoucherMov, restaurantId, str, applyVouchersViewCallback2.getCartItem(), getVerticalId()));
    }

    /* access modifiers changed from: private */
    public final void render(ApplyVouchersViewStates applyVouchersViewStates) {
        String str;
        boolean z11;
        Unit unit;
        VoucherFailures voucherFailure;
        ApplyVouchersViewCallback applyVouchersViewCallback = null;
        if (applyVouchersViewStates != null) {
            str = applyVouchersViewStates.getClass().getSimpleName();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        LogManager.debug("ApplyVouchersViewState >> " + str);
        if (applyVouchersViewStates != null) {
            z11 = applyVouchersViewStates.isLoading();
        } else {
            z11 = false;
        }
        updateLoadingBarState(z11);
        if (!(applyVouchersViewStates == null || (voucherFailure = applyVouchersViewStates.getVoucherFailure()) == null)) {
            updateFailureState(voucherFailure);
        }
        ((AddVoucherCodeView) _$_findCachedViewById(R.id.addVoucherCodeView)).setupAddVoucherCodeView$com_talabat_NewArchi_TalabatCommon_TalabatCommon(new ApplyVouchersView$render$2(this));
        if (applyVouchersViewStates == null) {
            return;
        }
        if (applyVouchersViewStates instanceof ApplyVouchersViewStates.ShowAllMyPossibleVouchers) {
            showAllMyPossibleVouchers(((ApplyVouchersViewStates.ShowAllMyPossibleVouchers) applyVouchersViewStates).getApplyVoucherViewHolderDisplayModel());
        } else if (applyVouchersViewStates instanceof ApplyVouchersViewStates.EmptyMyPossibleVouchers) {
            ((ViewPager) _$_findCachedViewById(R.id.applyVoucherViewViewPager)).setVisibility(8);
        } else if (applyVouchersViewStates instanceof ApplyVouchersViewStates.ApplyVoucher) {
            ApplyVouchersViewStates.ApplyVoucher applyVoucher = (ApplyVouchersViewStates.ApplyVoucher) applyVouchersViewStates;
            if (applyVoucher.getVoucherResult().getSecond() != null) {
                ApplyVouchersViewCallback applyVouchersViewCallback2 = this.callback;
                if (applyVouchersViewCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    applyVouchersViewCallback2 = null;
                }
                applyVouchersViewCallback2.successApplyFreeItemVoucher(applyVoucher.getVoucherResult());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ApplyVouchersViewCallback applyVouchersViewCallback3 = this.callback;
                if (applyVouchersViewCallback3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                } else {
                    applyVouchersViewCallback = applyVouchersViewCallback3;
                }
                applyVouchersViewCallback.successApplyVoucher(applyVoucher.getVoucherResult().getFirst());
            }
            refreshAllVoucher();
        } else if (applyVouchersViewStates instanceof ApplyVouchersViewStates.UnAppliedVouchersDone) {
            updateUnApplyAllVouchers(((ApplyVouchersViewStates.UnAppliedVouchersDone) applyVouchersViewStates).getShouldUpdateApplyVoucherOwner());
        } else if (applyVouchersViewStates instanceof ApplyVouchersViewStates.RedeemVoucherDone) {
            redeemVoucherDone(((ApplyVouchersViewStates.RedeemVoucherDone) applyVouchersViewStates).getUpdatedVoucherDisplayModel());
        } else if (applyVouchersViewStates instanceof ApplyVouchersViewStates.EnableVouchersFeature) {
            handleEnableVouchersFeatures((ApplyVouchersViewStates.EnableVouchersFeature) applyVouchersViewStates, Cart.getInstance().canShowLoyallyVoucherInCheckOut());
        }
    }

    private final void setupAddCodeClickListener() {
        if (Customer.getInstance().isLoggedIn()) {
            ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.applyVoucherViewViewPager);
            Intrinsics.checkNotNullExpressionValue(viewPager, "applyVoucherViewViewPager");
            if (!ViewKt.isVisible(viewPager)) {
                ((TextView) _$_findCachedViewById(R.id.applyVoucherViewAddCodeTextView)).setVisibility(8);
                ((AddVoucherCodeView) _$_findCachedViewById(R.id.addVoucherCodeView)).setVisibility(0);
            }
        } else {
            hideAddVoucherCode();
            ((AddVoucherCodeView) _$_findCachedViewById(R.id.addVoucherCodeView)).setVisibility(8);
        }
        ((TextView) _$_findCachedViewById(R.id.applyVoucherViewAddCodeTextView)).setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupAddCodeClickListener$lambda-7  reason: not valid java name */
    public static final void m5777setupAddCodeClickListener$lambda7(ApplyVouchersView applyVouchersView, View view) {
        Intrinsics.checkNotNullParameter(applyVouchersView, "this$0");
        applyVouchersView.addVoucherCodeViewClickAction();
    }

    private final void showAddVoucherCode() {
        int i11 = R.id.applyVoucherViewAddCodeTextView;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i11)).setText(ViewKt.getString(this, com.talabat.localization.R.string.cancel));
    }

    private final void showAllMyPossibleVouchers(ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel) {
        SafeLetKt.safeLet(getContext(), applyVoucherViewHolderDisplayModel, new ApplyVouchersView$showAllMyPossibleVouchers$1(this, applyVoucherViewHolderDisplayModel));
    }

    private final void showError(String str) {
        Activity activity;
        LogManager.debug(str);
        Status.Companion companion = Status.Companion;
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, str, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    private final void showGuestUserPopup() {
        Context context = getContext();
        if (context != null) {
            DialogUtilKt.showAlertDialog$default(context, 0, (String) null, ViewKt.getString(this, com.talabat.localization.R.string.asking_to_register), com.talabat.localization.R.string.create_account, new ApplyVouchersView$showGuestUserPopup$1$1(this), com.talabat.localization.R.string.dismiss, (Function0) null, 134, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: unApplyAllVouchersObserver$lambda-0  reason: not valid java name */
    public static final void m5778unApplyAllVouchersObserver$lambda0(ApplyVouchersView applyVouchersView, Boolean bool) {
        Intrinsics.checkNotNullParameter(applyVouchersView, "this$0");
        applyVouchersView.unApplyVoucher(bool);
    }

    private final void unApplyVoucher(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            LogManager.debug("dispatchAction(UnApplyVoucherAction)");
            ApplyVouchersViewCallback applyVouchersViewCallback = null;
            Cart.getInstance().getUnApplyLoyaltyVoucherTriggerLiveData().setValue(null);
            ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
            ApplyVouchersViewCallback applyVouchersViewCallback2 = this.callback;
            if (applyVouchersViewCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                applyVouchersViewCallback2 = null;
            }
            float cartSubtotalForVoucherMov = applyVouchersViewCallback2.getCartSubtotalForVoucherMov();
            ApplyVouchersViewCallback applyVouchersViewCallback3 = this.callback;
            if (applyVouchersViewCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
            } else {
                applyVouchersViewCallback = applyVouchersViewCallback3;
            }
            applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.UnApplyVoucherAction(false, cartSubtotalForVoucherMov, applyVouchersViewCallback.getCartItem()));
        }
    }

    private final void updateLoadingBarState(boolean z11) {
        if (z11) {
            showProgress();
        } else {
            hideProgress();
        }
    }

    private final void updateUnApplyAllVouchers(boolean z11) {
        if (z11) {
            ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
            if (applyVouchersViewCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callback");
                applyVouchersViewCallback = null;
            }
            applyVouchersViewCallback.unAppliedAllVouchers();
        }
        refreshAllVoucher();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, com.talabat.localization.R.string.apply_voucher_item_error, 1).show();
        }
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
    public final GrowthTracker getGrowthTracker() {
        return this.growthTracker;
    }

    public int getLayoutId(@Nullable AttributeSet attributeSet) {
        return R.layout.view_apply_voucher;
    }

    @VisibleForTesting
    public final int getVerticalId() {
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        Integer verticalId = applyVouchersViewCallback.getVerticalId();
        if (verticalId != null) {
            return verticalId.intValue();
        }
        return -1;
    }

    @NotNull
    public Class<ApplyVoucherViewModel> getViewModelClass() {
        return ApplyVoucherViewModel.class;
    }

    @VisibleForTesting
    public final void handleEnableVouchersFeatures(@NotNull ApplyVouchersViewStates.EnableVouchersFeature enableVouchersFeature, boolean z11) {
        int i11;
        Intrinsics.checkNotNullParameter(enableVouchersFeature, "applyVouchersViewState");
        ApplyVoucherOwner applyVoucherOwner2 = this.applyVoucherOwner;
        ApplyVoucherOwner applyVoucherOwner3 = ApplyVoucherOwner.Checkout;
        if (applyVoucherOwner2 != applyVoucherOwner3 || z11 || enableVouchersFeature.isDarkStore()) {
            ((TextView) _$_findCachedViewById(R.id.applyVoucherViewTitleTextView)).setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(R.id.applyVoucherViewAddCodeTextView);
            if (enableVouchersFeature.getVoucherCodesEnabled()) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            textView.setVisibility(i11);
            if (!enableVouchersFeature.getLoyaltyVoucherEnabled() && !enableVouchersFeature.getVoucherCodesEnabled()) {
                setVisibility(8);
            } else if (enableVouchersFeature.getLoyaltyVoucherEnabled() || !enableVouchersFeature.getVoucherCodesEnabled()) {
                ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
                ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
                if (applyVouchersViewCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callback");
                    applyVouchersViewCallback = null;
                }
                applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.LoadPossibleVouchersAction(applyVouchersViewCallback.getRestaurantId(), getVerticalId()));
                setVisibility(0);
            } else {
                setVisibility(0);
                ((ViewPager) _$_findCachedViewById(R.id.applyVoucherViewViewPager)).setVisibility(8);
            }
            if (this.applyVoucherOwner == applyVoucherOwner3 && getVisibility() == 0) {
                Cart.getInstance().setCanShowLoyallyVoucherInCheckOut(false);
            }
        } else {
            setVisibility(8);
        }
        if (enableVouchersFeature.isPickup()) {
            setVisibility(8);
        }
        setupAddCodeClickListener();
    }

    public final void init(@NotNull ApplyVoucherOwner applyVoucherOwner2, @NotNull ApplyVouchersViewCallback applyVouchersViewCallback) {
        Intrinsics.checkNotNullParameter(applyVoucherOwner2, "applyVoucherOwner");
        Intrinsics.checkNotNullParameter(applyVouchersViewCallback, "callback");
        this.callback = applyVouchersViewCallback;
        this.applyVoucherOwner = applyVoucherOwner2;
    }

    public void observatory(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleKt.failure(lifecycleOwner, ((ApplyVoucherViewModel) getViewModel()).getFailureData(), new ApplyVouchersView$observatory$1$1(this));
        LifecycleKt.observe(lifecycleOwner, ((ApplyVoucherViewModel) getViewModel()).getViewStateLiveData(), new ApplyVouchersView$observatory$1$2(this));
        Cart.getInstance().getUnApplyLoyaltyVoucherTriggerLiveData().observe(lifecycleOwner, this.unApplyAllVouchersObserver);
    }

    public void onDestroy() {
        Cart.getInstance().getUnApplyLoyaltyVoucherTriggerLiveData().removeObserver(this.unApplyAllVouchersObserver);
    }

    public void onLifecycleOwnerAttached(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
    }

    public void onResume() {
        ApplyVoucherOwner applyVoucherOwner2 = this.applyVoucherOwner;
        if (applyVoucherOwner2 != null) {
            checkApplyVoucherViewVisibility(applyVoucherOwner2);
        }
        super.onResume();
    }

    public final void redeemVoucherCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        ApplyVouchersViewCallback applyVouchersViewCallback2 = null;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        float cartSubtotalForVoucherMov = applyVouchersViewCallback.getCartSubtotalForVoucherMov();
        ApplyVouchersViewCallback applyVouchersViewCallback3 = this.callback;
        if (applyVouchersViewCallback3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback3 = null;
        }
        String restaurantId = applyVouchersViewCallback3.getRestaurantId();
        ApplyVouchersViewCallback applyVouchersViewCallback4 = this.callback;
        if (applyVouchersViewCallback4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback4 = null;
        }
        String branchId = applyVouchersViewCallback4.getBranchId();
        ApplyVouchersViewCallback applyVouchersViewCallback5 = this.callback;
        if (applyVouchersViewCallback5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback5 = null;
        }
        String groceryVendorId = applyVouchersViewCallback5.getGroceryVendorId();
        if (groceryVendorId == null) {
            groceryVendorId = "";
        }
        String str2 = groceryVendorId;
        ApplyVouchersViewCallback applyVouchersViewCallback6 = this.callback;
        if (applyVouchersViewCallback6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
        } else {
            applyVouchersViewCallback2 = applyVouchersViewCallback6;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.AddVoucherCodeAction(cartSubtotalForVoucherMov, str, restaurantId, branchId, str2, applyVouchersViewCallback2.getCartItem(), getVerticalId()));
    }

    public final void refreshAllVoucher() {
        ApplyVoucherViewModel applyVoucherViewModel = (ApplyVoucherViewModel) getViewModel();
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        applyVoucherViewModel.dispatchAction(new ApplyVouchersActions.LoadPossibleVouchersAction(applyVouchersViewCallback.getRestaurantId(), getVerticalId()));
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGrowthTracker(@NotNull GrowthTracker growthTracker2) {
        Intrinsics.checkNotNullParameter(growthTracker2, "<set-?>");
        this.growthTracker = growthTracker2;
    }

    @VisibleForTesting
    public final void updateFailureState(@NotNull VoucherFailures voucherFailures) {
        Intrinsics.checkNotNullParameter(voucherFailures, "voucherFailure");
        String simpleName = voucherFailures.getClass().getSimpleName();
        LogManager.debug("ApplyVouchersFailure >> " + simpleName);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String userErrorMessage = ApplyVouchersViewUserErrorMapperKt.getUserErrorMessage(voucherFailures, context);
        if (userErrorMessage != null) {
            showError(userErrorMessage);
        }
        ApplyVouchersViewCallback applyVouchersViewCallback = this.callback;
        if (applyVouchersViewCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callback");
            applyVouchersViewCallback = null;
        }
        applyVouchersViewCallback.applyVouchersViewFailure(voucherFailures);
    }

    @NotNull
    public ApplyVoucherViewModelImpl viewModelBuilder() {
        ApplyVoucherViewModelBuilder applyVoucherViewModelBuilder = ApplyVoucherViewModelBuilder.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return applyVoucherViewModelBuilder.getApplyVoucherViewModel(context, getTalabatTracker(), getFeatureFlagRepo(), getConfigurationLocalRepository());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.growthTracker = GrowthTracker.INSTANCE;
        this.unApplyAllVouchersObserver = new a(this);
        initDagger();
        this.vouchersViewCallback = new ApplyVouchersView$vouchersViewCallback$1(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVouchersView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.growthTracker = GrowthTracker.INSTANCE;
        this.unApplyAllVouchersObserver = new a(this);
        initDagger();
        this.vouchersViewCallback = new ApplyVouchersView$vouchersViewCallback$1(this);
    }
}
