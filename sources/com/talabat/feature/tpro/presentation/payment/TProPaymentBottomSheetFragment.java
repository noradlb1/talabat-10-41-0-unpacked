package com.talabat.feature.tpro.presentation.payment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.payment.callback.ITProPaymentOtpCallback;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel;
import com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModelFactory;
import com.talabat.feature.walletaddcard.presentation.Wallet3DsActivity;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.utils.DateUtils;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListBottomSheet;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.tracking.Tracker;
import com.tracking.TrackerKt;
import com.tracking.impl.FirebaseTracker;
import java.util.ArrayList;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import jp.a;
import jp.b;
import jp.c;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ScreenNames;

@Instrumented
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001uB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020DH\u0002J\b\u0010F\u001a\u00020\u000eH\u0002J\u0010\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020D2\u0006\u0010K\u001a\u00020\u001cH\u0002J\b\u0010L\u001a\u00020DH\u0002J\u0012\u0010M\u001a\u00020D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u0017\u0010P\u001a\u00020D2\b\u0010Q\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020DH\u0002J\b\u0010T\u001a\u00020DH\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010V\u001a\u00020D2\u0006\u0010W\u001a\u00020XH\u0016J\u0012\u0010Y\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010[H\u0016J$\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u001a\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020]2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0010\u0010f\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010g\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020OH\u0002J\u0010\u0010j\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010k\u001a\u00020D2\u0006\u0010l\u001a\u00020\u000eH\u0002J\b\u0010m\u001a\u00020DH\u0002J\u0010\u0010n\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010o\u001a\u00020D2\u0006\u0010p\u001a\u00020qH\u0016J\u0010\u0010r\u001a\u00020D2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010s\u001a\u00020D2\u0006\u0010t\u001a\u00020[H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010 R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u000206X.¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b9\u0010:R\u001e\u0010=\u001a\u00020>8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006v"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/TProPaymentBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/DefaultCardView$DefaultCardViewFullScreenInterface;", "Lcom/talabat/talabatcommon/views/wallet/cardViewWidgets/view/CardListBottomSheet$CardListBottomSheetInterface;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;)V", "activityResultContract", "Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "getActivityResultContract", "()Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "firebaseTracker", "Lcom/tracking/impl/FirebaseTracker;", "isCoffeeEnabled", "", "isCoffeeEnabled$annotations", "()V", "isReactivate", "()Z", "isSubscribeToProAtOTP", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "parameters", "", "", "", "planId", "getPlanId", "()Ljava/lang/String;", "setPlanId", "(Ljava/lang/String;)V", "proPaymentOTPCallback", "Lcom/talabat/feature/tpro/presentation/payment/callback/ITProPaymentOtpCallback;", "subscribeToProAtOTPDeliveryFee", "getSubscribeToProAtOTPDeliveryFee", "subscribeToProAtOTPOrderID", "getSubscribeToProAtOTPOrderID", "subscriptionsFeatureFlagsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlagsRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlagsRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "getSubscriptionsTracker", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "setSubscriptionsTracker", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproPaymentWidgetBottomSheetBinding;", "viewModel", "Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/payment/viewmodel/TProPaymentBottomSheetViewModelFactory;)V", "addWalletPaymentWidgetObservers", "", "bindPaymentWidget", "getFlagValueForShowDisclaimerText", "getShahidPlanActive", "tproPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "handle3DSVerification", "redirectUrl", "handleFailure", "handleOtpResponse", "it", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "hideThePaymentWidgetLoading", "isPaymentViewReady", "(Ljava/lang/Boolean;)V", "initialiseFirebaseTracker", "observeMultiPlanSubscription", "onActionButtonTapped", "onAttach", "context", "Landroid/content/Context;", "onChangeClicked", "cardListData", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupObservers", "showFreeTrialText", "showOtpSubscriptionStatusBottomSheet", "subscriptionOTPPaymentStatus", "showPaymentText", "showProgresses", "showProgress", "trackIfReactivateSuccess", "trackSubscriptionSuccess", "updatePositionClicked", "position", "", "updateUi", "updateWalletCardList", "walletCardListDisplayModel", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProPaymentBottomSheetFragment extends Fragment implements DefaultCardView.DefaultCardViewFullScreenInterface, CardListBottomSheet.CardListBottomSheetInterface, TraceFieldInterface {
    @NotNull
    private static final String BANNER_NAME = "bannerName";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String IS_REACTIVATE_KEY = "IS_REACTIVATE";
    @NotNull
    private static final String SUBSCRIBE_PRO_OTP = "SUBSCRIBE_PRO_OTP";
    @NotNull
    private static final String SUBSCRIBE_PRO_OTP_DELIVERY_FEE = "SUBSCRIBE_PRO_OTP_DELIVERY_FEE";
    @NotNull
    private static final String SUBSCRIBE_PRO_OTP_ORDER_ID = "SUBSCRIBE_PRO_OTP_ORDER_ID";
    @NotNull
    private static final String SUBSCRIPTION_ATTEMPTED = "subscription_attempted";
    @NotNull
    private static final String SUBSCRIPTION_COMPLETED = "subscription_completed";
    @NotNull
    private static final String SUBSCRIPTION_FAILED = "subscription_failed";
    @NotNull
    private static final String SUBSCRIPTION_STARTED = "subscription_started";
    @NotNull
    public static final String TAG = "TProPaymentBottomSheetFragment";
    @NotNull
    private static final String TPRO_PLAN_MODLE_KEY = "TPRO_PLAN";
    @NotNull
    private static final String VOUCHER_CODE = "VOUCHER_CODE";
    @NotNull
    private static final String screenNameReactivate = "Navigation Screen";
    @NotNull
    private static final String screenTypeReactivate = "bottom_navigation_menu";
    public Trace _nr_trace;
    @NotNull
    private final ActivityResultContracts.StartActivityForResult activityResultContract;
    /* access modifiers changed from: private */
    @NotNull
    public final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    @NotNull
    public final FirebaseTracker firebaseTracker = new FirebaseTracker();
    @Inject
    @JvmField
    public boolean isCoffeeEnabled;
    @NotNull
    private final ActivityResultLauncher<Intent> launcher;
    /* access modifiers changed from: private */
    @Nullable
    public Map<String, Object> parameters;
    @NotNull
    private String planId = "";
    /* access modifiers changed from: private */
    @Nullable
    public ITProPaymentOtpCallback proPaymentOTPCallback;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlagsRepository;
    @Inject
    public ISubscriptionsTracker subscriptionsTracker;
    private FragmentTproPaymentWidgetBottomSheetBinding viewBinding;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TProPaymentBottomSheetViewModel.class), new TProPaymentBottomSheetFragment$special$$inlined$viewModels$default$2(new TProPaymentBottomSheetFragment$special$$inlined$viewModels$default$1(this)), new TProPaymentBottomSheetFragment$viewModel$2(this));
    @Inject
    public TProPaymentBottomSheetViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JR\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u00172\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/tpro/presentation/payment/TProPaymentBottomSheetFragment$Companion;", "", "()V", "BANNER_NAME", "", "IS_REACTIVATE_KEY", "SUBSCRIBE_PRO_OTP", "SUBSCRIBE_PRO_OTP_DELIVERY_FEE", "SUBSCRIBE_PRO_OTP_ORDER_ID", "SUBSCRIPTION_ATTEMPTED", "SUBSCRIPTION_COMPLETED", "SUBSCRIPTION_FAILED", "SUBSCRIPTION_STARTED", "TAG", "TPRO_PLAN_MODLE_KEY", "VOUCHER_CODE", "screenNameReactivate", "screenTypeReactivate", "getInstance", "Lcom/talabat/feature/tpro/presentation/payment/TProPaymentBottomSheetFragment;", "tproPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "isReactivate", "", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "voucherCode", "subscribeToProOTP", "orderId", "deliveryFee", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ TProPaymentBottomSheetFragment getInstance$default(Companion companion, TProPlanDisplayModel tProPlanDisplayModel, boolean z11, DSBottomSheet dSBottomSheet, String str, boolean z12, String str2, String str3, int i11, Object obj) {
            TProPlanDisplayModel tProPlanDisplayModel2;
            boolean z13;
            String str4;
            boolean z14;
            String str5;
            String str6;
            if ((i11 & 1) != 0) {
                tProPlanDisplayModel2 = null;
            } else {
                tProPlanDisplayModel2 = tProPlanDisplayModel;
            }
            if ((i11 & 2) != 0) {
                z13 = false;
            } else {
                z13 = z11;
            }
            if ((i11 & 8) != 0) {
                str4 = "";
            } else {
                str4 = str;
            }
            if ((i11 & 16) != 0) {
                z14 = false;
            } else {
                z14 = z12;
            }
            if ((i11 & 32) != 0) {
                str5 = null;
            } else {
                str5 = str2;
            }
            if ((i11 & 64) != 0) {
                str6 = null;
            } else {
                str6 = str3;
            }
            return companion.getInstance(tProPlanDisplayModel2, z13, dSBottomSheet, str4, z14, str5, str6);
        }

        @NotNull
        public final TProPaymentBottomSheetFragment getInstance(@Nullable TProPlanDisplayModel tProPlanDisplayModel, boolean z11, @NotNull DSBottomSheet dSBottomSheet, @Nullable String str, boolean z12, @Nullable String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
            TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment = new TProPaymentBottomSheetFragment(dSBottomSheet);
            Bundle bundle = new Bundle();
            bundle.putParcelable(TProPaymentBottomSheetFragment.TPRO_PLAN_MODLE_KEY, tProPlanDisplayModel);
            bundle.putBoolean(TProPaymentBottomSheetFragment.IS_REACTIVATE_KEY, z11);
            bundle.putString(TProPaymentBottomSheetFragment.VOUCHER_CODE, str);
            bundle.putBoolean(TProPaymentBottomSheetFragment.SUBSCRIBE_PRO_OTP, z12);
            bundle.putString(TProPaymentBottomSheetFragment.SUBSCRIBE_PRO_OTP_DELIVERY_FEE, str3);
            bundle.putString(TProPaymentBottomSheetFragment.SUBSCRIBE_PRO_OTP_ORDER_ID, str2);
            tProPaymentBottomSheetFragment.setArguments(bundle);
            return tProPaymentBottomSheetFragment;
        }
    }

    public TProPaymentBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        this.dsBottomSheet = dSBottomSheet;
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        this.activityResultContract = startActivityForResult;
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(startActivityForResult, new a(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…Failure()\n        }\n    }");
        this.launcher = registerForActivityResult;
    }

    private final void addWalletPaymentWidgetObservers() {
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding2 = null;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        LifecycleKt.observe(this, fragmentTproPaymentWidgetBottomSheetBinding.walletPaymentWidget.getCardLoadingStatus(), new TProPaymentBottomSheetFragment$addWalletPaymentWidgetObservers$1(this));
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding3 = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPaymentWidgetBottomSheetBinding2 = fragmentTproPaymentWidgetBottomSheetBinding3;
        }
        LifecycleKt.observe(this, fragmentTproPaymentWidgetBottomSheetBinding2.walletPaymentWidget.getCardLoadingStatus(), new TProPaymentBottomSheetFragment$addWalletPaymentWidgetObservers$2(this));
    }

    private final void bindPaymentWidget() {
        addWalletPaymentWidgetObservers();
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        DefaultCardView defaultCardView = fragmentTproPaymentWidgetBottomSheetBinding.walletPaymentWidget;
        Intrinsics.checkNotNullExpressionValue(defaultCardView, "");
        DefaultCardView.setDefaultCardViewFullScreenListener$default(defaultCardView, this, true, false, false, 8, (Object) null);
        defaultCardView.addDefaultCard();
    }

    private final boolean getFlagValueForShowDisclaimerText() {
        return getSubscriptionsFeatureFlagsRepository().isTProDisclaimerTextEnabled();
    }

    private final boolean getShahidPlanActive(TProPlanDisplayModel tProPlanDisplayModel) {
        boolean z11;
        boolean z12;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        if (tProPlanDisplayModel.getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (tProPlanDisplayModel.getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            return false;
        }
        return true;
    }

    private final String getSubscribeToProAtOTPDeliveryFee() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(SUBSCRIBE_PRO_OTP_DELIVERY_FEE) : null;
        return string == null ? "" : string;
    }

    private final String getSubscribeToProAtOTPOrderID() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(SUBSCRIBE_PRO_OTP_ORDER_ID) : null;
        return string == null ? "" : string;
    }

    /* access modifiers changed from: private */
    public final TProPaymentBottomSheetViewModel getViewModel() {
        return (TProPaymentBottomSheetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handle3DSVerification(String str) {
        Intent intent = new Intent(requireActivity(), Wallet3DsActivity.class);
        intent.putExtra(Wallet3DsActivity.WALLET_THREE_DS_URL_KEY, str);
        this.launcher.launch(intent);
    }

    /* access modifiers changed from: private */
    public final void handleFailure() {
        Map<String, Object> map = this.parameters;
        if (map != null) {
            this.firebaseTracker.sendEvent("subscription_failed", map);
        }
        showProgresses(false);
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        LinearLayout linearLayout = fragmentTproPaymentWidgetBottomSheetBinding.errorNotifyLinearLayout;
        String string = getString(R.string.failure_server_error);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.failure_server_error)");
        Status.Companion.notify$default(companion, activity, linearLayout, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleOtpResponse(SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus) {
        Unit unit;
        if (subscriptionOTPPaymentStatus != null) {
            showOtpSubscriptionStatusBottomSheet(subscriptionOTPPaymentStatus);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            handleFailure();
            this.dsBottomSheet.dismiss();
        }
        ITProPaymentOtpCallback iTProPaymentOtpCallback = this.proPaymentOTPCallback;
        if (iTProPaymentOtpCallback != null) {
            iTProPaymentOtpCallback.subscriptionStatusChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void hideThePaymentWidgetLoading(Boolean bool) {
        if (bool != null) {
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = null;
            if (!bool.booleanValue()) {
                bool = null;
            }
            if (bool != null) {
                bool.booleanValue();
                FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding2 = this.viewBinding;
                if (fragmentTproPaymentWidgetBottomSheetBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    fragmentTproPaymentWidgetBottomSheetBinding2 = null;
                }
                fragmentTproPaymentWidgetBottomSheetBinding2.walletPaymentLoading.setVisibility(8);
                FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding3 = this.viewBinding;
                if (fragmentTproPaymentWidgetBottomSheetBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    fragmentTproPaymentWidgetBottomSheetBinding3 = null;
                }
                fragmentTproPaymentWidgetBottomSheetBinding3.walletPaymentWidget.setVisibility(0);
                FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding4 = this.viewBinding;
                if (fragmentTproPaymentWidgetBottomSheetBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    fragmentTproPaymentWidgetBottomSheetBinding4 = null;
                }
                if (fragmentTproPaymentWidgetBottomSheetBinding4.walletPaymentWidget.getSelectedCard() != null) {
                    FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding5 = this.viewBinding;
                    if (fragmentTproPaymentWidgetBottomSheetBinding5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    } else {
                        fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding5;
                    }
                    fragmentTproPaymentWidgetBottomSheetBinding.actionButton.setButtonEnabled(true);
                }
            }
        }
    }

    private final void initialiseFirebaseTracker() {
        if (isSubscribeToProAtOTP()) {
            Map<String, Object> createParameters = this.firebaseTracker.createParameters(ScreenNames.SCREEN_NAME_ORDER_CONFIRM, ScreenNames.SCREEN_TYPE_ORDERCONFIRM);
            this.parameters = createParameters;
            if (createParameters != null) {
                TrackerKt.addParameter(createParameters, "bannerName", "tpro");
                return;
            }
            return;
        }
        this.parameters = Tracker.DefaultImpls.createParameters$default(this.firebaseTracker, ScreenNames.SUBSCRIPTION_PAYMENT_DIALOG, (String) null, 2, (Object) null);
    }

    @Named("isTproCoffeeEnabled")
    public static /* synthetic */ void isCoffeeEnabled$annotations() {
    }

    private final boolean isReactivate() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(IS_REACTIVATE_KEY);
        }
        return false;
    }

    private final boolean isSubscribeToProAtOTP() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(SUBSCRIBE_PRO_OTP);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: launcher$lambda-0  reason: not valid java name */
    public static final void m10417launcher$lambda0(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(tProPaymentBottomSheetFragment, "this$0");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            tProPaymentBottomSheetFragment.getViewModel().updateCustomerInfo();
        } else if (resultCode != 201) {
            tProPaymentBottomSheetFragment.handleFailure();
        } else {
            tProPaymentBottomSheetFragment.handleFailure();
        }
    }

    private final void observeMultiPlanSubscription() {
        LifecycleKt.observe(this, getViewModel().getSubscriptionMultiPlan$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$observeMultiPlanSubscription$1(this));
        LifecycleKt.observe(this, getViewModel().getSubscriptionMultiPlanFailure$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$observeMultiPlanSubscription$2(this));
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [kotlin.Unit] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActionButtonTapped(com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel r10) {
        /*
            r9 = this;
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.parameters
            if (r0 == 0) goto L_0x000b
            com.tracking.impl.FirebaseTracker r1 = r9.firebaseTracker
            java.lang.String r2 = "subscription_attempted"
            r1.sendEvent(r2, r0)
        L_0x000b:
            r0 = 1
            r9.showProgresses(r0)
            boolean r0 = r9.isSubscribeToProAtOTP()
            java.lang.String r1 = "viewBinding"
            r2 = 0
            if (r0 == 0) goto L_0x0050
            com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding r0 = r9.viewBinding
            if (r0 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0021:
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r0 = r0.walletPaymentWidget
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r0 = r0.getSelectedCard()
            if (r0 == 0) goto L_0x004a
            java.lang.String r5 = r0.getTokenId()
            if (r5 == 0) goto L_0x004a
            com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel r3 = r9.getViewModel()
            java.lang.String r4 = r10.getPlanId()
            java.lang.String r6 = r9.getSubscribeToProAtOTPOrderID()
            java.lang.String r7 = r9.getSubscribeToProAtOTPDeliveryFee()
            com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod r10 = com.talabat.talabatcommon.views.wallet.walletPaymentOption.model.PaymentMethod.CARD
            int r8 = r10.getValue()
            r3.subscribeToProOTP(r4, r5, r6, r7, r8)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x004a:
            if (r2 != 0) goto L_0x00a1
            r9.handleFailure()
            goto L_0x00a1
        L_0x0050:
            boolean r0 = r9.getShahidPlanActive(r10)
            if (r0 == 0) goto L_0x0087
            android.os.Bundle r0 = r9.getArguments()
            if (r0 == 0) goto L_0x0063
            java.lang.String r3 = "VOUCHER_CODE"
            java.lang.String r0 = r0.getString(r3)
            goto L_0x0064
        L_0x0063:
            r0 = r2
        L_0x0064:
            com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding r3 = r9.viewBinding
            if (r3 != 0) goto L_0x006c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x006d
        L_0x006c:
            r2 = r3
        L_0x006d:
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r1 = r2.walletPaymentWidget
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r1 = r1.getSelectedCard()
            if (r1 == 0) goto L_0x00a1
            java.lang.String r1 = r1.getTokenId()
            if (r1 == 0) goto L_0x00a1
            com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel r2 = r9.getViewModel()
            if (r0 != 0) goto L_0x0083
            java.lang.String r0 = ""
        L_0x0083:
            r2.subscribeWithB2BVoucher(r0, r10, r1)
            goto L_0x00a1
        L_0x0087:
            com.talabat.feature.tpro.presentation.payment.viewmodel.TProPaymentBottomSheetViewModel r0 = r9.getViewModel()
            java.lang.String r10 = r10.getPlanId()
            com.talabat.feature.tpro.presentation.databinding.FragmentTproPaymentWidgetBottomSheetBinding r3 = r9.viewBinding
            if (r3 != 0) goto L_0x0097
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0098
        L_0x0097:
            r2 = r3
        L_0x0098:
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView r1 = r2.walletPaymentWidget
            com.talabat.talabatcommon.model.wallet.WalletCardDisplayModel r1 = r1.getSelectedCard()
            r0.subscribeInTpro(r10, r1)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragment.onActionButtonTapped(com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel):void");
    }

    private final void setupObservers(TProPlanDisplayModel tProPlanDisplayModel) {
        LifecycleKt.observe(this, getViewModel().getSuccessSubscription$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$1(this, tProPlanDisplayModel));
        LifecycleKt.observe(this, getViewModel().getSubscribedToB2b$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$2(this, tProPlanDisplayModel));
        LifecycleKt.observe(this, getViewModel().getFailedSubscription$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$3(this));
        LifecycleKt.observe(this, getViewModel().getVerification3ds$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$4(this));
        LifecycleKt.observe(this, getViewModel().getOtpFailureSubscription$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$5(this));
        LifecycleKt.observe(this, getViewModel().getOtpSuccessSubscription$com_talabat_feature_tpro_presentation_presentation(), new TProPaymentBottomSheetFragment$setupObservers$6(this, tProPlanDisplayModel));
    }

    private final void showFreeTrialText(TProPlanDisplayModel tProPlanDisplayModel) {
        boolean z11;
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = null;
        if (getShahidPlanActive(tProPlanDisplayModel)) {
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding2 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPaymentWidgetBottomSheetBinding2 = null;
            }
            fragmentTproPaymentWidgetBottomSheetBinding2.multiplanFreeTrialPaymentInfo.setVisibility(8);
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding3 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPaymentWidgetBottomSheetBinding3 = null;
            }
            fragmentTproPaymentWidgetBottomSheetBinding3.shahidPlanPaymentInfo.setVisibility(0);
            String localizedFormattedDateAfterDurationDays = DateUtils.Companion.getLocalizedFormattedDateAfterDurationDays(tProPlanDisplayModel.getDurationDays());
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding4 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding4;
            }
            fragmentTproPaymentWidgetBottomSheetBinding.autoUpgradeInfoText.setText(getString(R.string.auto_upgrade_info_text, localizedFormattedDateAfterDurationDays));
        } else if (tProPlanDisplayModel.getFreeTrialEligible()) {
            if (tProPlanDisplayModel.getFreeTrialTitle().length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding5 = this.viewBinding;
                if (fragmentTproPaymentWidgetBottomSheetBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                    fragmentTproPaymentWidgetBottomSheetBinding5 = null;
                }
                fragmentTproPaymentWidgetBottomSheetBinding5.txtFreeTrial.setText(tProPlanDisplayModel.getFreeTrialTitle());
            }
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding6 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPaymentWidgetBottomSheetBinding6 = null;
            }
            fragmentTproPaymentWidgetBottomSheetBinding6.multiplanFreeTrialPaymentInfo.setVisibility(0);
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding7 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding7;
            }
            TextView textView = fragmentTproPaymentWidgetBottomSheetBinding.tvFirstPayment;
            if (true ^ StringsKt__StringsJVMKt.isBlank(tProPlanDisplayModel.getFreeTrialText())) {
                textView.setText(tProPlanDisplayModel.getFreeTrialText());
                textView.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        } else {
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding8 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding8;
            }
            fragmentTproPaymentWidgetBottomSheetBinding.multiplanFreeTrialPaymentInfo.setVisibility(8);
        }
    }

    private final void showOtpSubscriptionStatusBottomSheet(SubscriptionOTPPaymentStatus subscriptionOTPPaymentStatus) {
        this.dsBottomSheet.dismiss();
        DSBottomSheet dSBottomSheet = new DSBottomSheet();
        dSBottomSheet.setBody(TProOTPPaymentBottomSheetFragment.Companion.create(subscriptionOTPPaymentStatus, dSBottomSheet));
        FragmentActivity activity = this.dsBottomSheet.getActivity();
        if (activity != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    private final void showPaymentText(TProPlanDisplayModel tProPlanDisplayModel) {
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = null;
        if (getShahidPlanActive(tProPlanDisplayModel)) {
            FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding2 = this.viewBinding;
            if (fragmentTproPaymentWidgetBottomSheetBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding2;
            }
            fragmentTproPaymentWidgetBottomSheetBinding.tvPrice.setText(getResources().getString(R.string.tpro_cancel_anytime));
            return;
        }
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding3 = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPaymentWidgetBottomSheetBinding = fragmentTproPaymentWidgetBottomSheetBinding3;
        }
        TextView textView = fragmentTproPaymentWidgetBottomSheetBinding.tvPrice;
        Resources resources = getResources();
        int i11 = R.string.tpro_payment_text;
        Object[] objArr = new Object[1];
        String paymentText = tProPlanDisplayModel.getPaymentText();
        if (StringsKt__StringsJVMKt.isBlank(paymentText)) {
            paymentText = getResources().getString(R.string.tpro_price, new Object[]{tProPlanDisplayModel.getDisplayAmount()});
            Intrinsics.checkNotNullExpressionValue(paymentText, "resources.getString(\n   …unt\n                    )");
        }
        objArr[0] = paymentText;
        textView.setText(resources.getString(i11, objArr));
    }

    /* access modifiers changed from: private */
    public final void showProgresses(boolean z11) {
        int i11;
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding2 = null;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        ProgressBar progressBar = fragmentTproPaymentWidgetBottomSheetBinding.genericProgressBar;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding3 = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPaymentWidgetBottomSheetBinding2 = fragmentTproPaymentWidgetBottomSheetBinding3;
        }
        fragmentTproPaymentWidgetBottomSheetBinding2.actionButton.setButtonEnabled(!z11);
    }

    /* access modifiers changed from: private */
    public final void trackIfReactivateSuccess() {
        if (isReactivate()) {
            getSubscriptionsTracker().tProSubscriptionReactivateSuccess("bottom_navigation_menu", "Navigation Screen", this.planId);
        }
    }

    /* access modifiers changed from: private */
    public final void trackSubscriptionSuccess(TProPlanDisplayModel tProPlanDisplayModel) {
        Map<String, Object> map = this.parameters;
        if (map != null) {
            this.firebaseTracker.sendEvent("subscription_completed", map);
        }
        getSubscriptionsTracker().tProSubscribe(tProPlanDisplayModel.getPrice());
    }

    /* access modifiers changed from: private */
    public final void updateUi(TProPlanDisplayModel tProPlanDisplayModel) {
        int i11;
        String planId2 = tProPlanDisplayModel.getPlanId();
        this.planId = planId2;
        Map<String, Object> map = this.parameters;
        if (map != null) {
            TrackerKt.addParameter(map, "plan_id", planId2);
        }
        Map<String, Object> map2 = this.parameters;
        if (map2 != null) {
            this.firebaseTracker.sendEvent(SUBSCRIPTION_STARTED, map2);
        }
        setupObservers(tProPlanDisplayModel);
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        showFreeTrialText(tProPlanDisplayModel);
        showPaymentText(tProPlanDisplayModel);
        if (getShahidPlanActive(tProPlanDisplayModel)) {
            DSPrimaryButton dSPrimaryButton = fragmentTproPaymentWidgetBottomSheetBinding.actionButton;
            String string = getResources().getString(R.string.tpro_start_free_trial);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …e_trial\n                )");
            dSPrimaryButton.setTitle(string);
        } else {
            DSPrimaryButton dSPrimaryButton2 = fragmentTproPaymentWidgetBottomSheetBinding.actionButton;
            String string2 = getResources().getString(R.string.tpro_join_pro);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(\n   …oin_pro\n                )");
            dSPrimaryButton2.setTitle(string2);
        }
        fragmentTproPaymentWidgetBottomSheetBinding.closeBottomSheet.setOnClickListener(new b(this));
        fragmentTproPaymentWidgetBottomSheetBinding.actionButton.setOnTap(new TProPaymentBottomSheetFragment$updateUi$2$2(this, tProPlanDisplayModel));
        boolean flagValueForShowDisclaimerText = getFlagValueForShowDisclaimerText();
        AppCompatTextView appCompatTextView = fragmentTproPaymentWidgetBottomSheetBinding.debitCardDisclaimerText;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "debitCardDisclaimerText");
        if (flagValueForShowDisclaimerText) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        appCompatTextView.setVisibility(i11);
        fragmentTproPaymentWidgetBottomSheetBinding.tvTnc.setOnClickListener(new c(this, tProPlanDisplayModel));
        bindPaymentWidget();
    }

    /* access modifiers changed from: private */
    /* renamed from: updateUi$lambda-8$lambda-6  reason: not valid java name */
    public static final void m10418updateUi$lambda8$lambda6(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProPaymentBottomSheetFragment, "this$0");
        tProPaymentBottomSheetFragment.dsBottomSheet.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: updateUi$lambda-8$lambda-7  reason: not valid java name */
    public static final void m10419updateUi$lambda8$lambda7(TProPaymentBottomSheetFragment tProPaymentBottomSheetFragment, TProPlanDisplayModel tProPlanDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(tProPaymentBottomSheetFragment, "this$0");
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "$tproPlan");
        String string = tProPaymentBottomSheetFragment.getResources().getString(R.string.tpro_tnc);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…zation.R.string.tpro_tnc)");
        Navigator.Companion companion = Navigator.Companion;
        Context requireContext = tProPaymentBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(companion, requireContext, string, tProPlanDisplayModel.getTermsUrl());
    }

    @NotNull
    public final ActivityResultContracts.StartActivityForResult getActivityResultContract() {
        return this.activityResultContract;
    }

    @NotNull
    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
    }

    @NotNull
    public final String getPlanId() {
        return this.planId;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlagsRepository() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlagsRepository;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureFlagsRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsTracker getSubscriptionsTracker() {
        ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
        if (iSubscriptionsTracker != null) {
            return iSubscriptionsTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsTracker");
        return null;
    }

    @NotNull
    public final TProPaymentBottomSheetViewModelFactory getViewModelFactory() {
        TProPaymentBottomSheetViewModelFactory tProPaymentBottomSheetViewModelFactory = this.viewModelFactory;
        if (tProPaymentBottomSheetViewModelFactory != null) {
            return tProPaymentBottomSheetViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        ITProPaymentOtpCallback iTProPaymentOtpCallback;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        FragmentActivity requireActivity = requireActivity();
        ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi = (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class);
        ConfigurationLocalCoreLibApi configurationLocalCoreLibApi = (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class);
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        factory.create(requireActivity, configurationLocalCoreLibApi, configurationRemoteCoreLibApi, (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        FragmentActivity activity = getActivity();
        if (activity instanceof ITProPaymentOtpCallback) {
            iTProPaymentOtpCallback = (ITProPaymentOtpCallback) activity;
        } else {
            iTProPaymentOtpCallback = null;
        }
        this.proPaymentOTPCallback = iTProPaymentOtpCallback;
    }

    public void onChangeClicked(@Nullable WalletCardListDisplayModel walletCardListDisplayModel) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        DefaultCardView.Companion companion = DefaultCardView.Companion;
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "it");
        companion.showCardListBottomSheet(childFragmentManager, walletCardListDisplayModel, this, "tpro");
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProPaymentBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProPaymentBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproPaymentWidgetBottomSheetBinding inflate = FragmentTproPaymentWidgetBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPaymentWidgetBottomSheetBinding = inflate;
        }
        ConstraintLayout root = fragmentTproPaymentWidgetBottomSheetBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        TProPlanDisplayModel tProPlanDisplayModel;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        observeMultiPlanSubscription();
        initialiseFirebaseTracker();
        Bundle arguments = getArguments();
        Unit unit = null;
        if (arguments != null) {
            if (Build.VERSION.SDK_INT < 33) {
                parcelable = arguments.getParcelable(TPRO_PLAN_MODLE_KEY);
            } else {
                parcelable = (Parcelable) arguments.getParcelable(TPRO_PLAN_MODLE_KEY, TProPlanDisplayModel.class);
            }
            tProPlanDisplayModel = (TProPlanDisplayModel) parcelable;
        } else {
            tProPlanDisplayModel = null;
        }
        if (tProPlanDisplayModel != null) {
            updateUi(tProPlanDisplayModel);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            showProgresses(true);
            getViewModel().getSubscriptionMultiPlan();
        }
    }

    public final void setPlanId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.planId = str;
    }

    public final void setSubscriptionsFeatureFlagsRepository(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlagsRepository = iSubscriptionsFeatureFlagsRepository;
    }

    public final void setSubscriptionsTracker(@NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "<set-?>");
        this.subscriptionsTracker = iSubscriptionsTracker;
    }

    public final void setViewModelFactory(@NotNull TProPaymentBottomSheetViewModelFactory tProPaymentBottomSheetViewModelFactory) {
        Intrinsics.checkNotNullParameter(tProPaymentBottomSheetViewModelFactory, "<set-?>");
        this.viewModelFactory = tProPaymentBottomSheetViewModelFactory;
    }

    public void updatePositionClicked(int i11) {
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        fragmentTproPaymentWidgetBottomSheetBinding.walletPaymentWidget.updateClickedPositionData(i11);
    }

    public void updateWalletCardList(@NotNull WalletCardListDisplayModel walletCardListDisplayModel) {
        Intrinsics.checkNotNullParameter(walletCardListDisplayModel, "walletCardListDisplayModel");
        FragmentTproPaymentWidgetBottomSheetBinding fragmentTproPaymentWidgetBottomSheetBinding = this.viewBinding;
        if (fragmentTproPaymentWidgetBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPaymentWidgetBottomSheetBinding = null;
        }
        fragmentTproPaymentWidgetBottomSheetBinding.walletPaymentWidget.updateWalletCardList(walletCardListDisplayModel);
    }
}
