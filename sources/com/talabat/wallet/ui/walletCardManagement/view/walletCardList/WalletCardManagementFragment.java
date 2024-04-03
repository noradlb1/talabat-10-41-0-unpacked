package com.talabat.wallet.ui.walletCardManagement.view.walletCardList;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_dialog.DSDialog;
import com.designsystem.ds_dialog.DSDialogPrimaryAction;
import com.designsystem.ds_dialog.DSDialogPrimaryActionType;
import com.designsystem.ds_dialog.DSDialogSecondaryAction;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.feature.tokenization.domain.usecase.GenerateCardTokenUseCase;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardError;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardErrorResult;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import com.talabat.talabatcommon.feature.walletPayment.utils.PaymentProviderHelper;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.AnimationHelper;
import com.talabat.talabatcommon.utils.AnimationSpeed;
import com.talabat.talabatcommon.utils.ProgressBarLoading;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.IconStateDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletDeleteCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletSetDefaultCardDisplayModelState;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModelBuilder;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatcore.testframework.ViewModelInjectorKt;
import com.talabat.talabatcore.viewmodel.BaseViewModelFactory;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletCardManagement.model.WalletAdapterCardListMapper;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.adapter.WalletCardListAdapter;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.di.DaggerWalletCardManagementFragmentComponent;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uy.a;
import uy.b;
import uy.c;
import uy.d;
import uy.e;
import uy.f;
import uy.g;

@Instrumented
@Metadata(d1 = {"\u0000ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020RH\u0002J\b\u0010T\u001a\u00020RH\u0002J\u0006\u0010U\u001a\u00020RJ\b\u0010V\u001a\u00020RH\u0002J\b\u0010W\u001a\u00020RH\u0002J\u0010\u0010X\u001a\u00020R2\u0006\u0010Y\u001a\u00020ZH\u0016J&\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u00020R2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020RH\u0002J\u0010\u0010g\u001a\u00020R2\u0006\u0010d\u001a\u00020eH\u0016J\u001a\u0010h\u001a\u00020R2\u0006\u0010i\u001a\u00020\\2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010j\u001a\u00020RH\u0002J\b\u0010k\u001a\u00020RH\u0002J\b\u0010l\u001a\u00020RH\u0002J\b\u0010m\u001a\u00020RH\u0002J,\u0010n\u001a\u00020R2\u0006\u0010o\u001a\u00020e2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020R0q2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020R0qH\u0002J\u0012\u0010s\u001a\u00020R2\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\b\u0010v\u001a\u00020RH\u0002J\u0012\u0010w\u001a\u00020R2\b\u0010x\u001a\u0004\u0018\u00010yH\u0002J\u0012\u0010z\u001a\u00020R2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\u0012\u0010}\u001a\u00020R2\b\u0010~\u001a\u0004\u0018\u00010H\u0002J\u001b\u0010\u0001\u001a\u00020R2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0001J\u0013\u0010\u0001\u001a\u00020R2\b\u0010~\u001a\u0004\u0018\u00010H\u0002J\u0015\u0010\u0001\u001a\u00020R2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\t\u0010\u0001\u001a\u00020\u001cH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X.¢\u0006\u0002\n\u0000R\u001e\u0010B\u001a\u00020C8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u00020L8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006\u0001"}, d2 = {"Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/WalletCardManagementFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter$WalletCardListAdapterInterface;", "Lcom/talabat/talabatcommon/utils/AnimationHelper;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "com/talabat/wallet/ui/walletCardManagement/view/walletCardList/WalletCardManagementFragment$coroutineScope$1", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/WalletCardManagementFragment$coroutineScope$1;", "deeplinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeeplinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeeplinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "factory", "Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/viewModel/WalletCardManagementViewModel;", "getFactory", "()Lcom/talabat/talabatcore/viewmodel/BaseViewModelFactory;", "factory$delegate", "Lkotlin/Lazy;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "generateCardTokenUseCase", "Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "getGenerateCardTokenUseCase", "()Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;", "setGenerateCardTokenUseCase", "(Lcom/talabat/feature/tokenization/domain/usecase/GenerateCardTokenUseCase;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "paymentConfigurationRepository", "Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "getPaymentConfigurationRepository", "()Lcom/talabat/configuration/payment/PaymentConfigurationRepository;", "setPaymentConfigurationRepository", "(Lcom/talabat/configuration/payment/PaymentConfigurationRepository;)V", "sheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/LinearLayout;", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "viewModel", "walletCardListAdapter", "Lcom/talabat/wallet/ui/walletCardManagement/view/walletCardList/adapter/WalletCardListAdapter;", "walletCardManagementApi", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "getWalletCardManagementApi", "()Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "setWalletCardManagementApi", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;)V", "addListeners", "", "deleteCard", "initializeRecyclerView", "navigateToAddCard", "navigateToBNPLDashboard", "navigateToDashBoard", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteCardSelected", "tokenId", "", "onEditTextClick", "onSetDefaultCardClicked", "onViewCreated", "view", "resetListView", "setBottomSheetListener", "setDeleteOnClickListener", "showAddCardSuccessfulNotification", "showAlertDialog", "body", "yesAction", "Lkotlin/Function0;", "noAction", "showCardDeleteErrorNotification", "errorResult", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardErrorResult;", "showOnSetDefaultCardErrorNotification", "updateAdapterOnDelete", "walletDeleteCardDisplayModelState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletDeleteCardDisplayModelState;", "updateAdapterOnSetDefaultCard", "walletSetDefaultCardDisplayModelState", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/WalletSetDefaultCardDisplayModelState;", "updateAddCardIcon", "iconStateDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/model/IconStateDisplayModel;", "updateFailureNotification", "isFailure", "", "(Ljava/lang/Boolean;)V", "updateShowEditActionText", "updateWalletCardListAdapter", "WalletCardListDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WalletCardManagementFragment extends Fragment implements WalletCardListAdapter.WalletCardListAdapterInterface, AnimationHelper, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private WalletCardManagementFragment$coroutineScope$1 coroutineScope = new WalletCardManagementFragment$coroutineScope$1();
    @Inject
    public DeepLinkNavigator deeplinkNavigator;
    @NotNull
    private final Lazy factory$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new WalletCardManagementFragment$factory$2(this));
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GenerateCardTokenUseCase generateCardTokenUseCase;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public PaymentConfigurationRepository paymentConfigurationRepository;
    /* access modifiers changed from: private */
    public BottomSheetBehavior<LinearLayout> sheetBehavior;
    @Inject
    public TalabatTracker tracker;
    /* access modifiers changed from: private */
    public WalletCardManagementViewModel viewModel;
    @Nullable
    private WalletCardListAdapter walletCardListAdapter;
    @Inject
    public WalletCardManagementApi walletCardManagementApi;

    private final void addListeners() {
        setBottomSheetListener();
        ((ImageButton) _$_findCachedViewById(R.id.delete_icon)).setOnClickListener(new c(this));
        ((TextView) _$_findCachedViewById(R.id.delete_text)).setOnClickListener(new d(this));
        ((ImageButton) _$_findCachedViewById(R.id.back)).setOnClickListener(new e(this));
        ((TextView) _$_findCachedViewById(R.id.add_new_card_button)).setOnClickListener(new f(this));
        ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-0  reason: not valid java name */
    public static final void m6039addListeners$lambda0(WalletCardManagementFragment walletCardManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(walletCardManagementFragment, "this$0");
        walletCardManagementFragment.setDeleteOnClickListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-1  reason: not valid java name */
    public static final void m6040addListeners$lambda1(WalletCardManagementFragment walletCardManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(walletCardManagementFragment, "this$0");
        walletCardManagementFragment.setDeleteOnClickListener();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-2  reason: not valid java name */
    public static final void m6041addListeners$lambda2(WalletCardManagementFragment walletCardManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(walletCardManagementFragment, "this$0");
        walletCardManagementFragment.navigateToDashBoard();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-3  reason: not valid java name */
    public static final void m6042addListeners$lambda3(WalletCardManagementFragment walletCardManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(walletCardManagementFragment, "this$0");
        walletCardManagementFragment.navigateToAddCard();
    }

    /* access modifiers changed from: private */
    /* renamed from: addListeners$lambda-4  reason: not valid java name */
    public static final void m6043addListeners$lambda4(WalletCardManagementFragment walletCardManagementFragment, View view) {
        Intrinsics.checkNotNullParameter(walletCardManagementFragment, "this$0");
        walletCardManagementFragment.onEditTextClick();
    }

    /* access modifiers changed from: private */
    public final void deleteCard() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        WalletCardManagementViewModel walletCardManagementViewModel = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(5);
        WalletCardManagementViewModel walletCardManagementViewModel2 = this.viewModel;
        if (walletCardManagementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel2 = null;
        }
        WalletCardManagementViewModel walletCardManagementViewModel3 = this.viewModel;
        if (walletCardManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            walletCardManagementViewModel = walletCardManagementViewModel3;
        }
        walletCardManagementViewModel2.onLoadDeleteCard(new WalletDeleteCardRequestModel(walletCardManagementViewModel.getTokenId(), PaymentProviderHelper.Companion.getPaymentProvider(getConfigurationLocalRepository().selectedCountry().getCountryId())));
    }

    private final BaseViewModelFactory<WalletCardManagementViewModel> getFactory() {
        return (BaseViewModelFactory) this.factory$delegate.getValue();
    }

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
            WalletCardManagementViewModel walletCardManagementViewModel2 = null;
            if (walletCardManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel = null;
            }
            boolean isAddCardEnabled = walletCardManagementViewModel.isAddCardEnabled();
            WalletCardManagementViewModel walletCardManagementViewModel3 = this.viewModel;
            if (walletCardManagementViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel3 = null;
            }
            boolean isSetDefaultCardEnabled = walletCardManagementViewModel3.isSetDefaultCardEnabled();
            WalletCardManagementViewModel walletCardManagementViewModel4 = this.viewModel;
            if (walletCardManagementViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel4 = null;
            }
            boolean isDeleteCardEnabled = walletCardManagementViewModel4.isDeleteCardEnabled();
            WalletCardManagementViewModel walletCardManagementViewModel5 = this.viewModel;
            if (walletCardManagementViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                walletCardManagementViewModel2 = walletCardManagementViewModel5;
            }
            this.walletCardListAdapter = new WalletCardListAdapter(context, this, isSetDefaultCardEnabled, isDeleteCardEnabled, isAddCardEnabled, walletCardManagementViewModel2.isWalletAddCardFlutterScreenEnabled());
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.credit_card_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.walletCardListAdapter);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToBNPLDashboard() {
        DeepLinkNavigator deeplinkNavigator2 = getDeeplinkNavigator();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deeplinkNavigator2, requireContext, "talabat://?s=bnpl-dashboard/manage_cards", (Function0) null, 4, (Object) null);
    }

    private final void navigateToDashBoard() {
        Context context = getContext();
        if (context != null) {
            com.talabat.talabatnavigation.Navigator.Companion.navigate(context, WalletNavigatorActions.Companion.createNavigationToWalletDashBoard());
        }
    }

    private final void onEditTextClick() {
        WalletCardListAdapter walletCardListAdapter2 = this.walletCardListAdapter;
        if (walletCardListAdapter2 != null) {
            walletCardListAdapter2.changeMode();
        }
        WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
        WalletCardManagementViewModel walletCardManagementViewModel2 = null;
        if (walletCardManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel = null;
        }
        WalletCardManagementViewModel walletCardManagementViewModel3 = this.viewModel;
        if (walletCardManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel3 = null;
        }
        walletCardManagementViewModel.setEditMode(!walletCardManagementViewModel3.isEditMode());
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(5);
        WalletCardListAdapter walletCardListAdapter3 = this.walletCardListAdapter;
        if (walletCardListAdapter3 != null) {
            walletCardListAdapter3.resetChosenCard();
        }
        WalletCardManagementViewModel walletCardManagementViewModel4 = this.viewModel;
        if (walletCardManagementViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            walletCardManagementViewModel2 = walletCardManagementViewModel4;
        }
        if (walletCardManagementViewModel2.isEditMode()) {
            ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setText(getString(com.talabat.localization.R.string.done_string));
        } else {
            ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setText(getString(com.talabat.localization.R.string.wallet_manage_card_edit));
        }
    }

    /* access modifiers changed from: private */
    public final void resetListView() {
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(5);
        WalletCardListAdapter walletCardListAdapter2 = this.walletCardListAdapter;
        if (walletCardListAdapter2 != null) {
            walletCardListAdapter2.resetChosenCard();
        }
    }

    private final void setBottomSheetListener() {
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior2 = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setBottomSheetCallback(new WalletCardManagementFragment$setBottomSheetListener$1(this));
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior3 = this.sheetBehavior;
        if (bottomSheetBehavior3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
        } else {
            bottomSheetBehavior2 = bottomSheetBehavior3;
        }
        bottomSheetBehavior2.setState(5);
    }

    private final void setDeleteOnClickListener() {
        WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
        if (walletCardManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel = null;
        }
        walletCardManagementViewModel.onDeleteButtonClicked();
        String string = getString(com.talabat.localization.R.string.want_to_delete_card);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ring.want_to_delete_card)");
        showAlertDialog(string, new WalletCardManagementFragment$setDeleteOnClickListener$1(this), new WalletCardManagementFragment$setDeleteOnClickListener$2(this));
    }

    private final void showAddCardSuccessfulNotification() {
        delay(AnimationSpeed.SLOW.getValue(), new WalletCardManagementFragment$showAddCardSuccessfulNotification$1(this));
    }

    private final void showAlertDialog(String str, Function0<Unit> function0, Function0<Unit> function02) {
        Context context = getContext();
        if (context != null) {
            new AlertDialog.Builder(context, com.talabat.talabatcommon.R.style.GreenAlertDialog).setMessage((CharSequence) str).setPositiveButton(com.talabat.localization.R.string.wallet_delete_card, (DialogInterface.OnClickListener) new a(function0)).setNegativeButton(com.talabat.localization.R.string.cancel_small_letter, (DialogInterface.OnClickListener) new b(function02)).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-11$lambda-10  reason: not valid java name */
    public static final void m6044showAlertDialog$lambda11$lambda10(Function0 function0, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function0, "$noAction");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: showAlertDialog$lambda-11$lambda-9  reason: not valid java name */
    public static final void m6045showAlertDialog$lambda11$lambda9(Function0 function0, DialogInterface dialogInterface, int i11) {
        Intrinsics.checkNotNullParameter(function0, "$yesAction");
        function0.invoke();
    }

    private final void showCardDeleteErrorNotification(WalletDeleteCardErrorResult walletDeleteCardErrorResult) {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        WalletDeleteCardError walletDeleteCardError = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        if (walletDeleteCardErrorResult != null) {
            walletDeleteCardError = walletDeleteCardErrorResult.getCode();
        }
        if (walletDeleteCardError == WalletDeleteCardError.PAY_BNPL_CARD_DELETION_ERROR) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            DSDialog dSDialog = new DSDialog(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            dSDialog.setContent(walletDeleteCardErrorResult.getBody());
            dSDialog.setTitle(walletDeleteCardErrorResult.getTitle());
            String string = getString(com.talabat.localization.R.string.bnpl_pay_now);
            Intrinsics.checkNotNullExpressionValue(string, "getString(LocalizationR.string.bnpl_pay_now)");
            dSDialog.setPrimaryAction(new DSDialogPrimaryAction(string, new WalletCardManagementFragment$showCardDeleteErrorNotification$1$1(dSDialog, this), (DSDialogPrimaryActionType) null, 4, (DefaultConstructorMarker) null));
            String string2 = getString(com.talabat.localization.R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(LocalizationR.string.cancel)");
            dSDialog.setSecondaryAction(new DSDialogSecondaryAction(string2, new WalletCardManagementFragment$showCardDeleteErrorNotification$1$2(dSDialog)));
            View view = getView();
            if (view != null) {
                dSDialog.show((ViewGroup) view);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string3 = getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(com.talabat.lo…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string3, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    private final void showOnSetDefaultCardErrorNotification() {
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.hideProgress(_$_findCachedViewById);
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getString(com.talabat.localization.R.string.primary_card_not_set);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.primary_card_not_set)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateAdapterOnDelete(WalletDeleteCardDisplayModelState walletDeleteCardDisplayModelState) {
        if (walletDeleteCardDisplayModelState instanceof WalletDeleteCardDisplayModelState.SuccessDeleteCard) {
            WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
            if (walletCardManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel = null;
            }
            walletCardManagementViewModel.onLoadWalletCardList(getConfigurationLocalRepository().selectedCountry().getCountryId());
        } else if (walletDeleteCardDisplayModelState instanceof WalletDeleteCardDisplayModelState.ErrorDeleteCard) {
            showCardDeleteErrorNotification(((WalletDeleteCardDisplayModelState.ErrorDeleteCard) walletDeleteCardDisplayModelState).getErrorResult());
        } else if (walletDeleteCardDisplayModelState instanceof WalletDeleteCardDisplayModelState.Loading) {
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.showProgress(_$_findCachedViewById);
        }
    }

    /* access modifiers changed from: private */
    public final void updateAdapterOnSetDefaultCard(WalletSetDefaultCardDisplayModelState walletSetDefaultCardDisplayModelState) {
        if (walletSetDefaultCardDisplayModelState instanceof WalletSetDefaultCardDisplayModelState.SuccessSetDefaultCard) {
            WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
            if (walletCardManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel = null;
            }
            walletCardManagementViewModel.onLoadWalletCardList(getConfigurationLocalRepository().selectedCountry().getCountryId());
        } else if (walletSetDefaultCardDisplayModelState instanceof WalletSetDefaultCardDisplayModelState.ErrorSetDefaultCard) {
            showOnSetDefaultCardErrorNotification();
        } else if (walletSetDefaultCardDisplayModelState instanceof WalletSetDefaultCardDisplayModelState.Loading) {
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.showProgress(_$_findCachedViewById);
        }
    }

    /* access modifiers changed from: private */
    public final void updateAddCardIcon(IconStateDisplayModel iconStateDisplayModel) {
        if (iconStateDisplayModel instanceof IconStateDisplayModel.ShowIcon) {
            ((TextView) _$_findCachedViewById(R.id.add_new_card_button)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R.id.add_new_card_button)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void updateFailureNotification(Boolean bool) {
        if (BooleanKt.orFalse(bool)) {
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.hideProgress(_$_findCachedViewById);
            Status.Companion companion = Status.Companion;
            FragmentActivity activity = getActivity();
            String string = getString(com.talabat.localization.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.something_went_wrong)");
            Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateShowEditActionText(IconStateDisplayModel iconStateDisplayModel) {
        if (iconStateDisplayModel instanceof IconStateDisplayModel.ShowIcon) {
            ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void updateWalletCardListAdapter(WalletCardListDisplayModel walletCardListDisplayModel) {
        WalletCardListAdapter walletCardListAdapter2;
        if (walletCardListDisplayModel != null) {
            ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
            View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
            Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
            progressBarLoading.hideProgress(_$_findCachedViewById);
            List<WalletCreditCardListDataItemDisplayModel> mapWalletCardListToCardManagementList = WalletAdapterCardListMapper.INSTANCE.mapWalletCardListToCardManagementList(walletCardListDisplayModel);
            if (!mapWalletCardListToCardManagementList.isEmpty()) {
                WalletCardListAdapter walletCardListAdapter3 = this.walletCardListAdapter;
                if (walletCardListAdapter3 != null) {
                    walletCardListAdapter3.addItems(mapWalletCardListToCardManagementList);
                }
                WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
                WalletCardManagementViewModel walletCardManagementViewModel2 = null;
                if (walletCardManagementViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    walletCardManagementViewModel = null;
                }
                if (!walletCardManagementViewModel.isEditMode()) {
                    WalletCardManagementViewModel walletCardManagementViewModel3 = this.viewModel;
                    if (walletCardManagementViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        walletCardManagementViewModel3 = null;
                    }
                    if (walletCardManagementViewModel3.isAddCardEnabled() && (walletCardListAdapter2 = this.walletCardListAdapter) != null) {
                        walletCardListAdapter2.addAddCardActionView();
                    }
                }
                WalletCardManagementViewModel walletCardManagementViewModel4 = this.viewModel;
                if (walletCardManagementViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    walletCardManagementViewModel2 = walletCardManagementViewModel4;
                }
                walletCardManagementViewModel2.toggleEditCardsListActionButton();
                return;
            }
            _$_findCachedViewById(R.id.wallet_card_empty_view).setVisibility(0);
            ((RecyclerView) _$_findCachedViewById(R.id.credit_card_list)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R.id.edit_text_view)).setVisibility(8);
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

    public void adjustViewHeight(@NotNull View view, int i11, int i12, @NotNull AnimationSpeed animationSpeed) {
        AnimationHelper.DefaultImpls.adjustViewHeight(this, view, i11, i12, animationSpeed);
    }

    public void delay(long j11, @NotNull Function0<Unit> function0) {
        AnimationHelper.DefaultImpls.delay(this, j11, function0);
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
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final DeepLinkNavigator getDeeplinkNavigator() {
        DeepLinkNavigator deepLinkNavigator = this.deeplinkNavigator;
        if (deepLinkNavigator != null) {
            return deepLinkNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deeplinkNavigator");
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
    public final GenerateCardTokenUseCase getGenerateCardTokenUseCase() {
        GenerateCardTokenUseCase generateCardTokenUseCase2 = this.generateCardTokenUseCase;
        if (generateCardTokenUseCase2 != null) {
            return generateCardTokenUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("generateCardTokenUseCase");
        return null;
    }

    @NotNull
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
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
    public final PaymentConfigurationRepository getPaymentConfigurationRepository() {
        PaymentConfigurationRepository paymentConfigurationRepository2 = this.paymentConfigurationRepository;
        if (paymentConfigurationRepository2 != null) {
            return paymentConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentConfigurationRepository");
        return null;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        TalabatTracker talabatTracker = this.tracker;
        if (talabatTracker != null) {
            return talabatTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    @NotNull
    public final WalletCardManagementApi getWalletCardManagementApi() {
        WalletCardManagementApi walletCardManagementApi2 = this.walletCardManagementApi;
        if (walletCardManagementApi2 != null) {
            return walletCardManagementApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("walletCardManagementApi");
        return null;
    }

    public final void navigateToAddCard() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            WalletNavigatorActions.Companion companion2 = WalletNavigatorActions.Companion;
            WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
            if (walletCardManagementViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                walletCardManagementViewModel = null;
            }
            companion.navigate(context, companion2.createNavigationToAddCardFromSource(WalletNavigatorActions.OPEN_MIGRATED_CARD_MANAGEMENT_SCREEN, walletCardManagementViewModel.isWalletAddCardFlutterScreenEnabled()));
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerWalletCardManagementFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DispatcherCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class), (NetworkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NetworkCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TrackingCoreLibApi.class), (TokenizationFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TokenizationFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletCardManagementFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletCardManagementFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_card_management, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDeleteCardSelected(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, WalletNavigatorActions.EXTRA_TOKEN_ID);
        BottomSheetBehavior<LinearLayout> bottomSheetBehavior = this.sheetBehavior;
        WalletCardManagementViewModel walletCardManagementViewModel = null;
        if (bottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            bottomSheetBehavior = null;
        }
        bottomSheetBehavior.setState(3);
        WalletCardManagementViewModel walletCardManagementViewModel2 = this.viewModel;
        if (walletCardManagementViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            walletCardManagementViewModel = walletCardManagementViewModel2;
        }
        walletCardManagementViewModel.setTokenId(str);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onSetDefaultCardClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, WalletNavigatorActions.EXTRA_TOKEN_ID);
        delay(AnimationSpeed.SLOW.getValue(), new WalletCardManagementFragment$onSetDefaultCardClicked$1(this, str));
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Boolean bool;
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        this.viewModel = (WalletCardManagementViewModel) ViewModelInjectorKt.injectViewModel((Fragment) this, WalletCardManagementViewModel.class, (ViewModelProvider.Factory) getFactory());
        ProgressBarLoading progressBarLoading = ProgressBarLoading.INSTANCE;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "progress_bar");
        progressBarLoading.showProgress(_$_findCachedViewById);
        WalletCardManagementViewModel walletCardManagementViewModel = this.viewModel;
        WalletCardManagementViewModel walletCardManagementViewModel2 = null;
        if (walletCardManagementViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel = null;
        }
        walletCardManagementViewModel.onLoadFeatureFlags();
        BottomSheetBehavior<LinearLayout> from = BottomSheetBehavior.from((LinearLayout) _$_findCachedViewById(R.id.wallet_card_management_delete_bottom_sheet));
        Intrinsics.checkNotNullExpressionValue(from, "from(wallet_card_management_delete_bottom_sheet)");
        this.sheetBehavior = from;
        if (from == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetBehavior");
            from = null;
        }
        from.setState(5);
        initializeRecyclerView();
        WalletCardManagementViewModel walletCardManagementViewModel3 = this.viewModel;
        if (walletCardManagementViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel3 = null;
        }
        walletCardManagementViewModel3.onLoadWalletCardList(getConfigurationLocalRepository().selectedCountry().getCountryId());
        addListeners();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (extras = intent.getExtras()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(extras.getBoolean(WalletNavigatorActions.EXTRA_IS_CARD_SUCCESSFULLY_ADDED));
        }
        if (BooleanKt.orFalse(bool)) {
            showAddCardSuccessfulNotification();
        }
        WalletCardManagementViewModel walletCardManagementViewModel4 = this.viewModel;
        if (walletCardManagementViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel4 = null;
        }
        walletCardManagementViewModel4.onShowAddCardButton();
        WalletCardManagementViewModel walletCardManagementViewModel5 = this.viewModel;
        if (walletCardManagementViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel5 = null;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel5.getWalletCardListData(), new WalletCardManagementFragment$onViewCreated$1(this));
        WalletCardManagementViewModel walletCardManagementViewModel6 = this.viewModel;
        if (walletCardManagementViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel6 = null;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel6.getWalletCardListErrorData(), new WalletCardManagementFragment$onViewCreated$2(this));
        WalletCardManagementViewModel walletCardManagementViewModel7 = this.viewModel;
        if (walletCardManagementViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel7 = null;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel7.getDeleteCardData(), new WalletCardManagementFragment$onViewCreated$3(this));
        WalletCardManagementViewModel walletCardManagementViewModel8 = this.viewModel;
        if (walletCardManagementViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel8 = null;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel8.getSetDefaultCardData(), new WalletCardManagementFragment$onViewCreated$4(this));
        WalletCardManagementViewModel walletCardManagementViewModel9 = this.viewModel;
        if (walletCardManagementViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            walletCardManagementViewModel9 = null;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel9.getAddCardIconData(), new WalletCardManagementFragment$onViewCreated$5(this));
        WalletCardManagementViewModel walletCardManagementViewModel10 = this.viewModel;
        if (walletCardManagementViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            walletCardManagementViewModel2 = walletCardManagementViewModel10;
        }
        LifecycleKt.observe(this, walletCardManagementViewModel2.getEditCardListIconData(), new WalletCardManagementFragment$onViewCreated$6(this));
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setDeeplinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator, "<set-?>");
        this.deeplinkNavigator = deepLinkNavigator;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGenerateCardTokenUseCase(@NotNull GenerateCardTokenUseCase generateCardTokenUseCase2) {
        Intrinsics.checkNotNullParameter(generateCardTokenUseCase2, "<set-?>");
        this.generateCardTokenUseCase = generateCardTokenUseCase2;
    }

    public final void setNavigator(@NotNull com.talabat.core.navigation.domain.Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setPaymentConfigurationRepository(@NotNull PaymentConfigurationRepository paymentConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(paymentConfigurationRepository2, "<set-?>");
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
    }

    public final void setTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<set-?>");
        this.tracker = talabatTracker;
    }

    public final void setWalletCardManagementApi(@NotNull WalletCardManagementApi walletCardManagementApi2) {
        Intrinsics.checkNotNullParameter(walletCardManagementApi2, "<set-?>");
        this.walletCardManagementApi = walletCardManagementApi2;
    }

    @NotNull
    public WalletCardManagementViewModel viewModelBuilder() {
        WalletCardManagementViewModelBuilder.Companion companion = WalletCardManagementViewModelBuilder.Companion;
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "requireContext().applicationContext");
        return companion.getWalletCardManagementViewModel(applicationContext, this.coroutineScope, getFeatureFlagRepo(), getGenerateCardTokenUseCase(), getPaymentConfigurationRepository(), getObservabilityManager(), getWalletCardManagementApi(), getTracker(), getCoroutineDispatchersFactory());
    }
}
