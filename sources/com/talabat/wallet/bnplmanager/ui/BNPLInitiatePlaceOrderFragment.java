package com.talabat.wallet.bnplmanager.ui;

import JsonModels.PlaceOrderResponse;
import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import com.designsystem.ds_button.DSPrimaryButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListFragment;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLInstallmentToggleStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentDetailsDisplayModel;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLPaymentDetailsState;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.mapper.BNPLManagerMapper;
import com.talabat.wallet.bnplmanager.ui.di.DaggerBNPLInitiatePlaceOrderFragmentComponent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import px.b;
import px.c;
import px.d;
import px.e;
import px.f;
import px.g;
import px.h;
import px.i;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

@Instrumented
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u000201H\u0002J\u0006\u00103\u001a\u000201J\b\u00104\u001a\u000201H\u0002J\u0010\u00105\u001a\u0002012\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u0002012\b\u00109\u001a\u0004\u0018\u00010:H\u0016J&\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010C\u001a\u0002012\b\u0010D\u001a\u0004\u0018\u00010EJ\u0018\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0002J\u001a\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020<2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u0010\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020\u0006H\u0002J\u0006\u0010M\u001a\u000201J\u0010\u0010N\u001a\u0002012\u0006\u0010O\u001a\u00020PH\u0002J\u0018\u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002J\b\u0010T\u001a\u000201H\u0002J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020WH\u0002J\u0006\u0010X\u001a\u000201J\u0010\u0010Y\u001a\u0002012\u0006\u0010Z\u001a\u00020[H\u0002J\u0012\u0010\\\u001a\u0002012\b\u0010]\u001a\u0004\u0018\u00010^H\u0002R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-¨\u0006_"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLInitiatePlaceOrderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewBottomScreenInterface;", "bnplPlaceOrderFragmentInterface", "Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderFragmentInterface;", "bnplPlan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "defaultPaymentMethod", "", "(Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderFragmentInterface;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;Ljava/lang/String;)V", "bnplInstallmentAdapter", "Lcom/talabat/wallet/bnplmanager/ui/BNPLInstallmentAdapter;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepository", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepository", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepository", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "termsAndConditionsConfigurationRepository", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "getTermsAndConditionsConfigurationRepository", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;", "setTermsAndConditionsConfigurationRepository", "(Lcom/talabat/configuration/tcs/TermsAndConditionsConfigurationRepository;)V", "viewModel", "Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "getViewModel", "()Lcom/talabat/wallet/bnplmanager/presentation/viewmodel/BNPLManagerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addListeners", "", "addObservers", "enablePaymentButton", "initializeRecyclerView", "onAttach", "context", "Landroid/content/Context;", "onChangeClickedInBottomSheet", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGetBNPLOrderSuccess", "response", "LJsonModels/PlaceOrderResponse;", "onSendTrackingEvent", "errorTitle", "errorDetail", "onViewCreated", "view", "setUpViews", "plan", "showErrorNotification", "showPaymentDetail", "bNPLPaymentDetailsDisplayModel", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;", "showPopUpErrorDialog", "title", "description", "showTermsAndConditions", "updateBNPLOrderPaymentView", "bnplOrderPaymentState", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "updateBNPLPaymentDetail", "updateInstallmentViews", "toggleStatus", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLInstallmentToggleStatus;", "updatePaymentDetails", "bNPLPaymentDetailsState", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLInitiatePlaceOrderFragment extends Fragment implements DefaultCardView.DefaultCardViewBottomScreenInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public Trace _nr_trace;
    private BNPLInstallmentAdapter bnplInstallmentAdapter;
    @NotNull
    private final BNPLPlaceOrderFragmentInterface bnplPlaceOrderFragmentInterface;
    @NotNull
    private final BNPLPlan bnplPlan;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Nullable
    private final String defaultPaymentMethod;
    @Inject
    public ITalabatFeatureFlag featureFlagRepository;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository;
    @NotNull
    private final Lazy viewModel$delegate;

    public BNPLInitiatePlaceOrderFragment(@NotNull BNPLPlaceOrderFragmentInterface bNPLPlaceOrderFragmentInterface, @NotNull BNPLPlan bNPLPlan, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bNPLPlaceOrderFragmentInterface, "bnplPlaceOrderFragmentInterface");
        Intrinsics.checkNotNullParameter(bNPLPlan, "bnplPlan");
        this._$_findViewCache = new LinkedHashMap();
        this.bnplPlaceOrderFragmentInterface = bNPLPlaceOrderFragmentInterface;
        this.bnplPlan = bNPLPlan;
        this.defaultPaymentMethod = str;
        this.viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new BNPLInitiatePlaceOrderFragment$viewModel$2(this));
    }

    private final void addListeners() {
        ((ImageView) _$_findCachedViewById(R.id.bnpl_installment_toggle_icon)).setOnClickListener(new b(this));
        ((ImageView) _$_findCachedViewById(R.id.close)).setOnClickListener(new c(this));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_fake_place_order)).setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-10  reason: not valid java name */
    public static final void m5944addListeners$lambda10(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, View view) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        bNPLInitiatePlaceOrderFragment.bnplPlaceOrderFragmentInterface.closeBottomSheet();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-11  reason: not valid java name */
    public static final void m5945addListeners$lambda11(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, View view) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        bNPLInitiatePlaceOrderFragment.bnplPlaceOrderFragmentInterface.placeOrderWithBNPL();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-9  reason: not valid java name */
    public static final void m5946addListeners$lambda9(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, View view) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        bNPLInitiatePlaceOrderFragment.getViewModel().onBnplToggleClicked();
    }

    private final void addObservers() {
        getViewModel().getBNPLPaymentDetailsStateData().observe(getViewLifecycleOwner(), new e(this));
        int i11 = R.id.card_container;
        ((DefaultCardView) _$_findCachedViewById(i11)).getCardLoadingStatus().observe(getViewLifecycleOwner(), new f(this));
        getViewModel().getBnplInstallmentToggleStatusData().observe(getViewLifecycleOwner(), new g(this));
        getViewModel().getBNPLOrderPaymentData().observe(getViewLifecycleOwner(), new h(this));
        ((DefaultCardView) _$_findCachedViewById(i11)).getSelectedCardUpdates().observe(getViewLifecycleOwner(), new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-1  reason: not valid java name */
    public static final void m5947addObservers$lambda1(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, BNPLPaymentDetailsState bNPLPaymentDetailsState) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        bNPLInitiatePlaceOrderFragment.updatePaymentDetails(bNPLPaymentDetailsState);
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-2  reason: not valid java name */
    public static final void m5948addObservers$lambda2(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, Boolean bool) {
        Float f11;
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            BNPLManagerViewModel viewModel = bNPLInitiatePlaceOrderFragment.getViewModel();
            Cart instance = Cart.getInstance();
            if (instance != null) {
                f11 = Float.valueOf(instance.getCartTotalPrice());
            } else {
                f11 = null;
            }
            viewModel.onFetchBNPLPaymentDetails(FloatKt.orZero(f11), bNPLInitiatePlaceOrderFragment.bnplPlan);
            ((DSPrimaryButton) bNPLInitiatePlaceOrderFragment._$_findCachedViewById(R.id.bnpl_fake_place_order)).setDsIsEnabled(((DefaultCardView) bNPLInitiatePlaceOrderFragment._$_findCachedViewById(R.id.card_container)).getCardAvailabilityStatus());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-4  reason: not valid java name */
    public static final void m5949addObservers$lambda4(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, BNPLInstallmentToggleStatus bNPLInstallmentToggleStatus) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        if (bNPLInstallmentToggleStatus != null) {
            bNPLInitiatePlaceOrderFragment.updateInstallmentViews(bNPLInstallmentToggleStatus);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-6  reason: not valid java name */
    public static final void m5950addObservers$lambda6(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, BNPLOrderPaymentState bNPLOrderPaymentState) {
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        if (bNPLOrderPaymentState != null) {
            bNPLInitiatePlaceOrderFragment.updateBNPLOrderPaymentView(bNPLOrderPaymentState);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addObservers$lambda-8  reason: not valid java name */
    public static final void m5951addObservers$lambda8(BNPLInitiatePlaceOrderFragment bNPLInitiatePlaceOrderFragment, WalletCardDisplayModel walletCardDisplayModel) {
        String str;
        Intrinsics.checkNotNullParameter(bNPLInitiatePlaceOrderFragment, "this$0");
        if (walletCardDisplayModel != null) {
            BNPLPlaceOrderFragmentInterface bNPLPlaceOrderFragmentInterface = bNPLInitiatePlaceOrderFragment.bnplPlaceOrderFragmentInterface;
            WalletCardDisplayModel selectedCard = ((DefaultCardView) bNPLInitiatePlaceOrderFragment._$_findCachedViewById(R.id.card_container)).getSelectedCard();
            if (selectedCard != null) {
                str = selectedCard.getBinNumber();
            } else {
                str = null;
            }
            bNPLPlaceOrderFragmentInterface.onGetBinVoucher(str);
        }
    }

    private final BNPLManagerViewModel getViewModel() {
        return (BNPLManagerViewModel) this.viewModel$delegate.getValue();
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.bnplInstallmentAdapter = new BNPLInstallmentAdapter(getLocationConfigurationRepository());
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.installments);
            recyclerView.setLayoutManager(linearLayoutManager);
            BNPLInstallmentAdapter bNPLInstallmentAdapter = this.bnplInstallmentAdapter;
            if (bNPLInstallmentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bnplInstallmentAdapter");
                bNPLInstallmentAdapter = null;
            }
            recyclerView.setAdapter(bNPLInstallmentAdapter);
        }
    }

    private final void onSendTrackingEvent(String str, String str2) {
        getViewModel().onBNPLOrderPaymentError(new BNPLOrderPaymentFailureTrackingModel(BNPLInitiatePlaceOrderFragmentKt.BNPL_TRACKING_NAME, str, Cart.getInstance().getRestaurant(), GlobalDataModel.CONTACTLESS.contactlessEnabled, this.defaultPaymentMethod, str2, (String) null, GlobalDataModel.POLYGON_TRACKING.polygonEvents, 64, (DefaultConstructorMarker) null));
    }

    private final void setUpViews(BNPLPlan bNPLPlan) {
        if (bNPLPlan.getPaymentCycles() > 1) {
            ((TextView) _$_findCachedViewById(R.id.bnpl_installment_text_view)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.bnpl_installment_icon)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R.id.bnpl_installment_toggle_icon)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.bnpl_installment_amount)).setVisibility(0);
            _$_findCachedViewById(R.id.installment_divider).setVisibility(0);
            ((TextView) _$_findCachedViewById(R.id.bnpl_pay_later_description_text_view)).setText(getString(com.talabat.localization.R.string.bnpl_installment_description, String.valueOf(bNPLPlan.getPaymentCycles())));
            ((TextView) _$_findCachedViewById(R.id.due_description_text_view)).setText(getString(com.talabat.localization.R.string.due_today));
            ((TextView) _$_findCachedViewById(R.id.due_today_value)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R.id.bnpl_pay_later_description_text_view)).setText(getString(com.talabat.localization.R.string.order_today_and_pay_in_30_days_interest_free, String.valueOf(bNPLPlan.getPaymentCycleInDays())));
            ((TextView) _$_findCachedViewById(R.id.due_description_text_view)).setText(getString(com.talabat.localization.R.string.due_date));
            ((TextView) _$_findCachedViewById(R.id.due_date_value)).setVisibility(0);
        }
        showTermsAndConditions();
    }

    private final void showPaymentDetail(BNPLPaymentDetailsDisplayModel bNPLPaymentDetailsDisplayModel) {
        ((TextView) _$_findCachedViewById(R.id.bnpl_your_order_amount)).setText(bNPLPaymentDetailsDisplayModel.getOrderAmount());
        ((TextView) _$_findCachedViewById(R.id.due_date_value)).setText(bNPLPaymentDetailsDisplayModel.getDueDate());
        ((TextView) _$_findCachedViewById(R.id.bnpl_installment_amount)).setText(bNPLPaymentDetailsDisplayModel.getInstallmentAmount());
        BNPLInstallmentAdapter bNPLInstallmentAdapter = this.bnplInstallmentAdapter;
        if (bNPLInstallmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bnplInstallmentAdapter");
            bNPLInstallmentAdapter = null;
        }
        bNPLInstallmentAdapter.addItems(bNPLPaymentDetailsDisplayModel.getInstallmentDetailList());
        ((TextView) _$_findCachedViewById(R.id.due_today_value)).setText(bNPLPaymentDetailsDisplayModel.getDueToday());
    }

    private final void showPopUpErrorDialog(String str, String str2) {
        onSendTrackingEvent(str, str2);
        this.bnplPlaceOrderFragmentInterface.cancelLoader();
        new BNPLEligibilityErrorDialog(new BNPLValidationError((String) null, str, str2, 1, (DefaultConstructorMarker) null)).show(getParentFragmentManager(), "BNPLEligibilityErrorDialog");
    }

    private final void showTermsAndConditions() {
        int i11 = R.id.bnpl_terms_and_condition;
        BNPLTermsAndConditionTextBuilder bNPLTermsAndConditionTextBuilder = BNPLTermsAndConditionTextBuilder.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        String bNPLTermsAndConditionUrl = getViewModel().getBNPLTermsAndConditionUrl(getTermsAndConditionsConfigurationRepository().config().checkoutPaymentTermsUrl());
        String string = getString(com.talabat.localization.R.string.pay_later);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ation.R.string.pay_later)");
        ((TextView) _$_findCachedViewById(i11)).setText(bNPLTermsAndConditionTextBuilder.createBNPLTermsAndConditionTextBuilder(requireContext, bNPLTermsAndConditionUrl, string));
        ((TextView) _$_findCachedViewById(i11)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void updateBNPLOrderPaymentView(BNPLOrderPaymentState bNPLOrderPaymentState) {
        ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_fake_place_order)).setDsIsEnabled(true);
        if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.ServerError) {
            showErrorNotification();
        } else if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.BNPLPaymentError) {
            BNPLOrderPaymentState.BNPLPaymentError bNPLPaymentError = (BNPLOrderPaymentState.BNPLPaymentError) bNPLOrderPaymentState;
            showPopUpErrorDialog(bNPLPaymentError.getBNPLOrderPaymentError().getTitle(), bNPLPaymentError.getBNPLOrderPaymentError().getDescription());
        } else if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.BNPLPaymentSuccess) {
            this.bnplPlaceOrderFragmentInterface.navigateToOrderSuccessScreen(getViewModel().getOrderResponse());
        }
    }

    private final void updateInstallmentViews(BNPLInstallmentToggleStatus bNPLInstallmentToggleStatus) {
        if (bNPLInstallmentToggleStatus == BNPLInstallmentToggleStatus.OPEN_INSTALLMENT) {
            ((ImageView) _$_findCachedViewById(R.id.bnpl_installment_toggle_icon)).animate().rotation(180.0f).start();
            ((RecyclerView) _$_findCachedViewById(R.id.installments)).setVisibility(0);
            return;
        }
        ((ImageView) _$_findCachedViewById(R.id.bnpl_installment_toggle_icon)).animate().rotation(0.0f).start();
        ((RecyclerView) _$_findCachedViewById(R.id.installments)).setVisibility(8);
    }

    private final void updatePaymentDetails(BNPLPaymentDetailsState bNPLPaymentDetailsState) {
        this.bnplPlaceOrderFragmentInterface.cancelLoader();
        int i11 = R.id.progress_bar;
        ((ProgressBar) _$_findCachedViewById(i11)).setVisibility(8);
        if (bNPLPaymentDetailsState instanceof BNPLPaymentDetailsState.ServerError) {
            ((ProgressBar) _$_findCachedViewById(i11)).setVisibility(8);
            ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_fake_place_order)).setDsIsEnabled(false);
        } else if (bNPLPaymentDetailsState instanceof BNPLPaymentDetailsState.BNPLPaymentDetailsSuccess) {
            showPaymentDetail(((BNPLPaymentDetailsState.BNPLPaymentDetailsSuccess) bNPLPaymentDetailsState).getBNPLPaymentDetailsDisplayModel());
            _$_findCachedViewById(R.id.bnpl_fake_place_order_layout).setVisibility(0);
            ((ProgressBar) _$_findCachedViewById(i11)).setVisibility(8);
        } else {
            getObservabilityManager().trackUnExpectedScenario("BNPLPaymentDetailsState unexpected state", MapsKt__MapsKt.mutableMapOf(TuplesKt.to("errorMessage", "BNPLPaymentDetailsState unexpected state")));
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

    public final void enablePaymentButton() {
        ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_fake_place_order)).setDsIsEnabled(true);
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
    public final ITalabatFeatureFlag getFeatureFlagRepository() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepository;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepository");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
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
    public final TermsAndConditionsConfigurationRepository getTermsAndConditionsConfigurationRepository() {
        TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2 = this.termsAndConditionsConfigurationRepository;
        if (termsAndConditionsConfigurationRepository2 != null) {
            return termsAndConditionsConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("termsAndConditionsConfigurationRepository");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerBNPLInitiatePlaceOrderFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public void onChangeClickedInBottomSheet(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        getViewModel().getBNPLOrderPaymentData().setValue(null);
        this.bnplPlaceOrderFragmentInterface.attachCardList(walletCardListDisplayModel, ((FrameLayout) _$_findCachedViewById(R.id.container)).getHeight());
        getViewModel().onPaymentMethodChanged("BNPL");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BNPLInitiatePlaceOrderFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BNPLInitiatePlaceOrderFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.view_bnpl_fake_door_test_layout, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void onGetBNPLOrderSuccess(@Nullable PlaceOrderResponse placeOrderResponse) {
        String str;
        getViewModel().setOrderResponse(placeOrderResponse);
        BNPLManagerViewModel viewModel = getViewModel();
        String id2 = this.bnplPlan.getId();
        if (placeOrderResponse != null) {
            str = placeOrderResponse.encryptedOrderId;
        } else {
            str = null;
        }
        viewModel.payOrderWithBNPL(new BNPLOrderPaymentRequestDto(id2, str, BNPLManagerMapper.INSTANCE.mapToBNPLCardDetail(((DefaultCardView) _$_findCachedViewById(R.id.card_container)).getSelectedCard())));
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        WalletCardListDisplayModel walletCardListDisplayModel;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeRecyclerView();
        setUpViews(this.bnplPlan);
        ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_fake_place_order)).setDsIsEnabled(false);
        int i11 = R.id.card_container;
        DefaultCardView defaultCardView = (DefaultCardView) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "card_container");
        DefaultCardView.setDefaultCardViewBottomScreenListener$default(defaultCardView, this, true, false, false, 12, (Object) null);
        addObservers();
        DefaultCardView defaultCardView2 = (DefaultCardView) _$_findCachedViewById(i11);
        Bundle arguments = getArguments();
        Unit unit = null;
        if (arguments != null) {
            walletCardListDisplayModel = (WalletCardListDisplayModel) arguments.getParcelable(WalletNavigatorActions.EXTRA_UPDATE_WALLET_CARD_LIST);
        } else {
            walletCardListDisplayModel = null;
        }
        defaultCardView2.updateWalletCardList(walletCardListDisplayModel);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            ((DefaultCardView) _$_findCachedViewById(i11)).updateClickedPositionData(arguments2.getInt(CardListFragment.SELECTED_POSITION));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ((DefaultCardView) _$_findCachedViewById(i11)).addDefaultCard();
        }
        addListeners();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlagRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepository = iTalabatFeatureFlag;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTermsAndConditionsConfigurationRepository(@NotNull TermsAndConditionsConfigurationRepository termsAndConditionsConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(termsAndConditionsConfigurationRepository2, "<set-?>");
        this.termsAndConditionsConfigurationRepository = termsAndConditionsConfigurationRepository2;
    }

    public final void showErrorNotification() {
        String empty = StringUtils.empty(StringCompanionObject.INSTANCE);
        int i11 = com.talabat.localization.R.string.sorry_something_went_wrong;
        String string = getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…rry_something_went_wrong)");
        onSendTrackingEvent(empty, string);
        this.bnplPlaceOrderFragmentInterface.cancelLoader();
        String string2 = getString(i11);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…rry_something_went_wrong)");
        Status.Companion.notify$default(Status.Companion, getActivity(), (FrameLayout) _$_findCachedViewById(R.id.errorNotifyLinearLayout), string2, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    public final void updateBNPLPaymentDetail() {
        Float f11;
        BNPLManagerViewModel viewModel = getViewModel();
        Cart instance = Cart.getInstance();
        if (instance != null) {
            f11 = Float.valueOf(instance.getCartTotalPrice());
        } else {
            f11 = null;
        }
        viewModel.onFetchBNPLPaymentDetails(FloatKt.orZero(f11), this.bnplPlan);
        this.bnplPlaceOrderFragmentInterface.showLoader();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLInitiatePlaceOrderFragment(BNPLPlaceOrderFragmentInterface bNPLPlaceOrderFragmentInterface, BNPLPlan bNPLPlan, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bNPLPlaceOrderFragmentInterface, bNPLPlan, (i11 & 4) != 0 ? null : str);
    }
}
