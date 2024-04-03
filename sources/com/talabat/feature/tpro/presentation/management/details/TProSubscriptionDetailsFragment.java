package com.talabat.feature.tpro.presentation.management.details;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.marshmallow.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.home.HomeScreen;
import com.talabat.core.navigation.domain.screen.restaurant.RestaurantsListScreen;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionSavingsInfo;
import com.talabat.feature.subscriptions.domain.model.SubscriptionType;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproSubscriptionDetailsBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.management.cancellation.confirm.ConfirmCancellationBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.continueproplan.ContinueProPlanBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.deactivate.AutoUpgradeTurnedOffBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.deactivate.DeactivateAutoUpgradeBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.deactivate.UnlockProBenefitsBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.freeTrial.CancelFreeTrialBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.freeTrial.KeepFreeTrialBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.SubscriptionCancellationReasonBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel;
import com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModelFactory;
import com.talabat.feature.tpro.presentation.payment.SubscriptionPaymentDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.savings.TProSavingsCancellationBottomSheetFragment;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import com.talabat.feature.tpro.presentation.util.ToastExtensionsKt;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatlife.features.UrlConstantsKt;
import dp.a;
import dp.b;
import dp.c;
import dp.d;
import dp.e;
import dp.f;
import dp.g;
import dp.h;
import dp.i;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

@Instrumented
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010E\u001a\u00020F2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010G\u001a\u00020FH\u0002J\b\u0010H\u001a\u00020FH\u0002J\b\u0010I\u001a\u00020FH\u0002J\b\u0010J\u001a\u00020FH\u0002J\b\u0010K\u001a\u00020\u0010H\u0002J\b\u0010L\u001a\u00020\u0010H\u0002J\b\u0010M\u001a\u00020\u0010H\u0002J\u0010\u0010N\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010O\u001a\u00020FH\u0002J\u0010\u0010P\u001a\u00020F2\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020F2\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0012\u0010U\u001a\u00020F2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020FH\u0002J\u0010\u0010Y\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0010H\u0002J\b\u0010[\u001a\u00020FH\u0002J$\u0010\\\u001a\u00020W2\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010d\u001a\u00020F2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010e\u001a\u00020FH\u0002J\b\u0010f\u001a\u00020FH\u0002J\b\u0010g\u001a\u00020FH\u0002J\b\u0010h\u001a\u00020FH\u0016J\u0010\u0010i\u001a\u00020F2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010j\u001a\u00020F2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010k\u001a\u00020FH\u0016J\u0010\u0010l\u001a\u00020F2\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0010\u0010m\u001a\u00020F2\u0006\u0010T\u001a\u00020\u0010H\u0002J\u0010\u0010n\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u0010H\u0016J\u001a\u0010o\u001a\u00020F2\u0006\u0010V\u001a\u00020W2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010p\u001a\u00020FH\u0002J\u0010\u0010q\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010r\u001a\u00020FH\u0002J\b\u0010s\u001a\u00020FH\u0002J\b\u0010t\u001a\u00020FH\u0002J\b\u0010u\u001a\u00020FH\u0002J\b\u0010v\u001a\u00020FH\u0002J\b\u0010w\u001a\u00020FH\u0002J\b\u0010x\u001a\u00020FH\u0002J\b\u0010y\u001a\u00020FH\u0002J\u0010\u0010z\u001a\u00020F2\u0006\u0010{\u001a\u00020\u0010H\u0002J\b\u0010|\u001a\u00020FH\u0002J\b\u0010}\u001a\u00020FH\u0002J\u0010\u0010~\u001a\u00020F2\u0006\u0010\u001a\u00020\u0010H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010 \u001a\u00020!H\u0002J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010 \u001a\u00020!H\u0002J\t\u0010\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001b\u0010:\u001a\u00020;8BX\u0002¢\u0006\f\n\u0004\b>\u0010'\u001a\u0004\b<\u0010=R\u001e\u0010?\u001a\u00020@8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006\u0001"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/TProSubscriptionDetailsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment$SubscriptionCancellationReasonBottomSheetInterface;", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment$ResultHandler;", "()V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproSubscriptionDetailsBinding;", "changePaymentDeeplink", "", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "hasDefaultCard", "", "isCancelFreeTrial", "isTproSubscriptionUpgradeEnabled", "locationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "membershipId", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "subscriptionSharedPrefManager", "Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "getSubscriptionSharedPrefManager", "()Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "subscriptionSharedPrefManager$delegate", "Lkotlin/Lazy;", "subscriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubscriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "setSubscriptionStatusRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlag", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlag", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "getSubscriptionsTracker", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "setSubscriptionsTracker", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "viewModel", "Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/management/details/viewmodel/TproSubscriptionDetailsViewModelFactory;)V", "bindContent", "", "cancelFreeTrial", "cancelSubscription", "dismissShimmer", "displayUpgradeError", "getIsPlanShahidActive", "isCancelFreeTrialExperimentEnabled", "isSavingsEnabled", "isUpgradeButtonVisible", "observe", "onAttach", "context", "Landroid/content/Context;", "onAutoRenewalCanceledFromBanner", "success", "onBackPressed", "view", "Landroid/view/View;", "onCancelAutoRenewalClicked", "onCancelFreeTrial", "isSuccess", "onChangePaymentClick", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreditCardsLoaded", "onDataLoaded", "onEndMemberShipClick", "onInitiateUpgradeClicked", "onLearnMoreClick", "onReasonSubmitSuccess", "onRenewalCanceled", "onRenewalEnabled", "onResume", "onSubscriptionAutoRenewTurnedOff", "onSubscriptionAutoRenewTurnedOn", "onUpgradeResult", "onViewCreated", "renewSubscription", "shouldDisplayRenew", "showAddCardNotification", "showAutoRenewalSuccessNotification", "showCancelFreeTrialBottomSheet", "showCancellationReason", "showConfirmCancellation", "showConfirmDeactivateAutoUpgrade", "showContinueProPlanBottomSheet", "showKeepBenefitsBottomSheet", "showProgressBar", "shouldShow", "showSavingsBottomSheet", "showStartExploring", "showToast", "isSuccessToast", "showUpdateSuccessfully", "trackCancellationAbortedEvent", "screeName", "trackCancellationLoadedEvent", "trackIfUpgradeLoadedEvent", "trackUpgradeStartedEvent", "updateSubscriptionAutoRenew", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProSubscriptionDetailsFragment extends Fragment implements SubscriptionCancellationReasonBottomSheetFragment.SubscriptionCancellationReasonBottomSheetInterface, TproUpgradeDetailsBottomSheetFragment.ResultHandler, TraceFieldInterface {
    @NotNull
    public static final String CANCELLATION_DAY_ZERO_CHURN_SCREEN_NAME = "Subscription Cancellation - Day Zero Churn";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String SUBSCRIPTION_CANCELLATION_NORMAL_SCREEN_NAME = "Subscription Cancellation - Normal";
    @NotNull
    public static final String SUBSCRIPTION_CANCELLATION_SAVINGS_SCREEN_NAME = "Subscription Cancellation - Savings";
    @NotNull
    public static final String SUBSCRIPTION_SCREEN_NAME = "Manage Subscriptions";
    @NotNull
    public static final String SUBSCRIPTION_SCREEN_TYPE = "subscription";
    @NotNull
    public static final String TAG = "TProSubscriptionDetailsFragment";
    @NotNull
    public static final String VARIATION_CANCEL_FREE_TRIAL_ENABLED = "Variation1";
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public FragmentTproSubscriptionDetailsBinding binding;
    /* access modifiers changed from: private */
    @NotNull
    public String changePaymentDeeplink = "";
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    /* access modifiers changed from: private */
    public boolean hasDefaultCard;
    private boolean isCancelFreeTrial;
    /* access modifiers changed from: private */
    public boolean isTproSubscriptionUpgradeEnabled;
    @Inject
    public LocationConfigurationRepository locationRepository;
    private String membershipId;
    @Inject
    public Navigator navigator;
    @Nullable
    private Subscription subscription;
    @NotNull
    private final Lazy subscriptionSharedPrefManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TProSubscriptionDetailsFragment$subscriptionSharedPrefManager$2(this));
    @Inject
    public ISubscriptionStatusRepository subscriptionStatusRepository;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;
    @Inject
    public ISubscriptionsTracker subscriptionsTracker;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TproSubscriptionDetailsViewModel.class), new TProSubscriptionDetailsFragment$special$$inlined$viewModels$default$2(new TProSubscriptionDetailsFragment$special$$inlined$viewModels$default$1(this)), new TProSubscriptionDetailsFragment$viewModel$2(this));
    @Inject
    public TproSubscriptionDetailsViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/TProSubscriptionDetailsFragment$Companion;", "", "()V", "CANCELLATION_DAY_ZERO_CHURN_SCREEN_NAME", "", "SUBSCRIPTION_CANCELLATION_NORMAL_SCREEN_NAME", "SUBSCRIPTION_CANCELLATION_SAVINGS_SCREEN_NAME", "SUBSCRIPTION_SCREEN_NAME", "SUBSCRIPTION_SCREEN_TYPE", "TAG", "VARIATION_CANCEL_FREE_TRIAL_ENABLED", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void bindContent(Subscription subscription2) {
        this.changePaymentDeeplink = new SubscriptionPaymentDeeplinkBuilder().build(subscription2.getPlan().getPlanId(), (String) null, TProSubscriptionDetailsFragmentKt.CHANGE_PAYMENT_STRATEGY);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProSubscriptionDetailsFragment$bindContent$1(this, subscription2, (Continuation<? super TProSubscriptionDetailsFragment$bindContent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void cancelFreeTrial() {
        showProgressBar(true);
        getViewModel().cancelFreeTrial();
    }

    /* access modifiers changed from: private */
    public final void cancelSubscription() {
        showProgressBar(true);
        getViewModel().updateAutoRenewalStatus(false, false, false);
    }

    private final void dismissShimmer() {
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = this.binding;
        if (fragmentTproSubscriptionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproSubscriptionDetailsBinding = null;
        }
        ConstraintLayout root = fragmentTproSubscriptionDetailsBinding.shimmer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.shimmer.root");
        root.setVisibility(8);
    }

    private final void displayUpgradeError() {
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = this.binding;
        if (fragmentTproSubscriptionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproSubscriptionDetailsBinding = null;
        }
        DSAlert dSAlert = fragmentTproSubscriptionDetailsBinding.alertUpgradeError;
        dSAlert.setIconButton(new DSIconButtonModel(R.drawable.ds_close, new TProSubscriptionDetailsFragment$displayUpgradeError$1$1(dSAlert)));
        Intrinsics.checkNotNullExpressionValue(dSAlert, "");
        dSAlert.setVisibility(0);
    }

    private final boolean getIsPlanShahidActive() {
        boolean z11;
        boolean z12;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        Subscription subscription2 = this.subscription;
        Intrinsics.checkNotNull(subscription2);
        if (subscription2.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        Subscription subscription3 = this.subscription;
        Intrinsics.checkNotNull(subscription3);
        if (subscription3.getPlan().getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            return false;
        }
        return true;
    }

    private final SubscriptionSharedPrefManager getSubscriptionSharedPrefManager() {
        return (SubscriptionSharedPrefManager) this.subscriptionSharedPrefManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TproSubscriptionDetailsViewModel getViewModel() {
        return (TproSubscriptionDetailsViewModel) this.viewModel$delegate.getValue();
    }

    private final boolean isCancelFreeTrialExperimentEnabled() {
        return Intrinsics.areEqual((Object) TalabatExperiment.INSTANCE.getStringVariant(EcosystemsExperimentsKeys.TPRO_CANCEL_FREE_TRIAL, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    /* access modifiers changed from: private */
    public final boolean isSavingsEnabled() {
        boolean isSavingsFlowEnabled = getSubscriptionsFeatureFlag().isSavingsFlowEnabled();
        SubscriptionSavingsInfo value = getViewModel().getSubscriptionsSaving().getValue();
        if (!isSavingsFlowEnabled || value == null || value.getOverallSavings() <= 0.0f) {
            return false;
        }
        return true;
    }

    private final boolean isUpgradeButtonVisible(Subscription subscription2) {
        boolean z11;
        if (subscription2.getPlan().getCategory() != SubscriptionPlanCategory.B2C || !this.isTproSubscriptionUpgradeEnabled || !subscription2.isUpgradeable()) {
            return false;
        }
        Collection upgradeablePlanInfos = subscription2.getUpgradeablePlanInfos();
        if (upgradeablePlanInfos == null || upgradeablePlanInfos.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return true;
        }
        return false;
    }

    private final void observe() {
        TproSubscriptionDetailsViewModel viewModel = getViewModel();
        viewModel.getSubscription().observe(getViewLifecycleOwner(), new a(this));
        viewModel.getRenewalCanceled().observe(getViewLifecycleOwner(), new b(this));
        viewModel.getRenewalEnabled().observe(getViewLifecycleOwner(), new c(this));
        viewModel.getCancelFreeTrial().observe(getViewLifecycleOwner(), new d(this));
        viewModel.isDataReady().observe(getViewLifecycleOwner(), new e(viewModel, this));
        viewModel.getAutoRenewalCanceledFromBanner().observe(getViewLifecycleOwner(), new f(this));
        viewModel.getSubscriptionAutoRenewTurnedOff().observe(getViewLifecycleOwner(), new g(this));
        viewModel.getSubscriptionAutoRenewTurnedOn().observe(getViewLifecycleOwner(), new h(this));
        viewModel.getPostUpdatingStatus().observe(getViewLifecycleOwner(), new i(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observe$lambda-5$lambda-3  reason: not valid java name */
    public static final void m10397observe$lambda5$lambda3(TproSubscriptionDetailsViewModel tproSubscriptionDetailsViewModel, TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, Boolean bool) {
        Subscription value;
        Intrinsics.checkNotNullParameter(tproSubscriptionDetailsViewModel, "$this_with");
        Intrinsics.checkNotNullParameter(tProSubscriptionDetailsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isDataReady");
        if (bool.booleanValue() && (value = tproSubscriptionDetailsViewModel.getSubscription().getValue()) != null) {
            tProSubscriptionDetailsFragment.onDataLoaded(value);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observe$lambda-5$lambda-4  reason: not valid java name */
    public static final void m10398observe$lambda5$lambda4(TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(tProSubscriptionDetailsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "shouldRefresh");
        if (bool.booleanValue()) {
            tProSubscriptionDetailsFragment.showUpdateSuccessfully();
            TproSubscriptionDetailsViewModel viewModel = tProSubscriptionDetailsFragment.getViewModel();
            String str = tProSubscriptionDetailsFragment.membershipId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
                str = null;
            }
            viewModel.loadData(str);
        }
    }

    /* access modifiers changed from: private */
    public final void onAutoRenewalCanceledFromBanner(boolean z11) {
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = this.binding;
        String str = null;
        if (fragmentTproSubscriptionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproSubscriptionDetailsBinding = null;
        }
        fragmentTproSubscriptionDetailsBinding.progressLayout.setVisibility(8);
        if (z11) {
            TproSubscriptionDetailsViewModel viewModel = getViewModel();
            String str2 = this.membershipId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
            } else {
                str = str2;
            }
            viewModel.loadData(str);
        }
        showToast(z11);
    }

    /* access modifiers changed from: private */
    public final void onBackPressed(View view) {
        requireActivity().finish();
    }

    /* access modifiers changed from: private */
    public final void onCancelAutoRenewalClicked() {
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = this.binding;
        if (fragmentTproSubscriptionDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproSubscriptionDetailsBinding = null;
        }
        fragmentTproSubscriptionDetailsBinding.progressLayout.setVisibility(0);
        getViewModel().updateAutoRenewalStatus(false, true, false);
    }

    /* access modifiers changed from: private */
    public final void onCancelFreeTrial(boolean z11) {
        showProgressBar(false);
        if (z11) {
            this.isCancelFreeTrial = true;
            getViewModel().clearActiveSubscription();
            showCancellationReason();
            return;
        }
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onChangePaymentClick() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TProSubscriptionDetailsFragment$onChangePaymentClick$1(this, (Continuation<? super TProSubscriptionDetailsFragment$onChangePaymentClick$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onCreditCardsLoaded(boolean z11) {
        this.hasDefaultCard = z11;
    }

    /* access modifiers changed from: private */
    public final void onDataLoaded(Subscription subscription2) {
        showProgressBar(false);
        this.subscription = subscription2;
        bindContent(subscription2);
        dismissShimmer();
    }

    /* access modifiers changed from: private */
    public final void onEndMemberShipClick() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value == null) {
            return;
        }
        if ((value.getType() == SubscriptionType.FreeTrial && isCancelFreeTrialExperimentEnabled()) || getIsPlanShahidActive()) {
            showCancelFreeTrialBottomSheet();
        } else if (isSavingsEnabled()) {
            showSavingsBottomSheet();
        } else {
            showConfirmCancellation();
        }
    }

    /* access modifiers changed from: private */
    public final void onInitiateUpgradeClicked() {
        Subscription subscription2 = this.subscription;
        if (subscription2 == null) {
            return;
        }
        if (!subscription2.getUpgradeablePlanInfos().isEmpty()) {
            trackUpgradeStartedEvent(subscription2);
            TproUpgradeDetailsBottomSheetFragment.Companion companion = TproUpgradeDetailsBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            SubscriptionUpgradePlan subscriptionUpgradePlan = subscription2.getUpgradeablePlanInfos().get(0);
            String str = this.membershipId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
                str = null;
            }
            String planId = subscription2.getPlan().getPlanId();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, str, planId, subscriptionUpgradePlan);
            return;
        }
        displayUpgradeError();
    }

    /* access modifiers changed from: private */
    public final void onLearnMoreClick() {
        UnlockProBenefitsBottomSheetFragment.Companion companion = UnlockProBenefitsBottomSheetFragment.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.show(requireActivity, TProSubscriptionDetailsFragment$onLearnMoreClick$1.INSTANCE, Boolean.TRUE);
    }

    /* access modifiers changed from: private */
    public final void onRenewalCanceled(String str) {
        showCancellationReason();
    }

    /* access modifiers changed from: private */
    public final void onRenewalEnabled(String str) {
        showAutoRenewalSuccessNotification();
    }

    /* access modifiers changed from: private */
    public final void onSubscriptionAutoRenewTurnedOff(boolean z11) {
        Subscription value;
        if (z11 && (value = getViewModel().getSubscription().getValue()) != null) {
            AutoUpgradeTurnedOffBottomSheetFragment.Companion companion = AutoUpgradeTurnedOffBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value);
        }
    }

    /* access modifiers changed from: private */
    public final void onSubscriptionAutoRenewTurnedOn(boolean z11) {
        Subscription value;
        if (z11 && (value = getViewModel().getSubscription().getValue()) != null) {
            TProWelcomeBottomSheetFragment.Companion companion = TProWelcomeBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.showForShahid(requireActivity, value, false);
        }
    }

    /* access modifiers changed from: private */
    public final void renewSubscription() {
        showProgressBar(true);
        getViewModel().updateAutoRenewalStatus(true, false, false);
    }

    /* access modifiers changed from: private */
    public final boolean shouldDisplayRenew(Subscription subscription2) {
        boolean z11;
        if (subscription2.getPlan().getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && !subscription2.isActive() && subscription2.getPlan().getRenewType() != SubscriptionRenewType.Renewable) {
            return subscription2.isAutorenewable();
        }
        if (!subscription2.isActive() || subscription2.isAutorenewable() || z11) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void showAddCardNotification() {
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getString(com.talabat.localization.R.string.add_a_card_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …ard_message\n            )");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.FAILURE, 26, (Object) null);
    }

    private final void showAutoRenewalSuccessNotification() {
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getString(com.talabat.localization.R.string.auto_renew_enabled_success_message);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …ess_message\n            )");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, ActionStatus.SUCCESS, 26, (Object) null);
    }

    private final void showCancelFreeTrialBottomSheet() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            trackCancellationLoadedEvent(CANCELLATION_DAY_ZERO_CHURN_SCREEN_NAME);
            CancelFreeTrialBottomSheetFragment.Companion companion = CancelFreeTrialBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value, new TProSubscriptionDetailsFragment$showCancelFreeTrialBottomSheet$1$1(this), new TProSubscriptionDetailsFragment$showCancelFreeTrialBottomSheet$1$2(this), new TProSubscriptionDetailsFragment$showCancelFreeTrialBottomSheet$1$3(this));
        }
    }

    private final void showCancellationReason() {
        SubscriptionCancellationReasonBottomSheetFragment.Companion companion = SubscriptionCancellationReasonBottomSheetFragment.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String str = this.membershipId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
            str = null;
        }
        companion.show(requireActivity, str);
    }

    private final void showConfirmCancellation() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            trackCancellationLoadedEvent(SUBSCRIPTION_CANCELLATION_NORMAL_SCREEN_NAME);
            ConfirmCancellationBottomSheetFragment.Companion companion = ConfirmCancellationBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value, new TProSubscriptionDetailsFragment$showConfirmCancellation$1$1(this), new TProSubscriptionDetailsFragment$showConfirmCancellation$1$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showConfirmDeactivateAutoUpgrade() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value == null) {
            return;
        }
        if (value.isAutorenewable()) {
            DeactivateAutoUpgradeBottomSheetFragment.Companion companion = DeactivateAutoUpgradeBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value, new TProSubscriptionDetailsFragment$showConfirmDeactivateAutoUpgrade$1$1(this), new TProSubscriptionDetailsFragment$showConfirmDeactivateAutoUpgrade$1$2(this));
            return;
        }
        UnlockProBenefitsBottomSheetFragment.Companion companion2 = UnlockProBenefitsBottomSheetFragment.Companion;
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        companion2.show(requireActivity2, new TProSubscriptionDetailsFragment$showConfirmDeactivateAutoUpgrade$1$3(this), Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    public final void showContinueProPlanBottomSheet() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            ContinueProPlanBottomSheetFragment.Companion companion = ContinueProPlanBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value, new TProSubscriptionDetailsFragment$showContinueProPlanBottomSheet$1$1(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showKeepBenefitsBottomSheet() {
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            KeepFreeTrialBottomSheetFragment.Companion companion = KeepFreeTrialBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            companion.show(requireActivity, value, new TProSubscriptionDetailsFragment$showKeepBenefitsBottomSheet$1$1(this));
        }
    }

    private final void showProgressBar(boolean z11) {
        int i11 = 0;
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = null;
        if (z11) {
            FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding2 = this.binding;
            if (fragmentTproSubscriptionDetailsBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentTproSubscriptionDetailsBinding2 = null;
            }
            ProgressBar progressBar = fragmentTproSubscriptionDetailsBinding2.pbDetails;
            Intrinsics.checkNotNullExpressionValue(progressBar, "binding.pbDetails");
            progressBar.setVisibility(0);
            FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding3 = this.binding;
            if (fragmentTproSubscriptionDetailsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTproSubscriptionDetailsBinding = fragmentTproSubscriptionDetailsBinding3;
            }
            DSPrimaryButton dSPrimaryButton = fragmentTproSubscriptionDetailsBinding.btnRenew;
            Intrinsics.checkNotNullExpressionValue(dSPrimaryButton, "binding.btnRenew");
            dSPrimaryButton.setVisibility(8);
            return;
        }
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding4 = this.binding;
        if (fragmentTproSubscriptionDetailsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproSubscriptionDetailsBinding4 = null;
        }
        ProgressBar progressBar2 = fragmentTproSubscriptionDetailsBinding4.pbDetails;
        Intrinsics.checkNotNullExpressionValue(progressBar2, "binding.pbDetails");
        progressBar2.setVisibility(8);
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding5 = this.binding;
            if (fragmentTproSubscriptionDetailsBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTproSubscriptionDetailsBinding = fragmentTproSubscriptionDetailsBinding5;
            }
            DSPrimaryButton dSPrimaryButton2 = fragmentTproSubscriptionDetailsBinding.btnRenew;
            Intrinsics.checkNotNullExpressionValue(dSPrimaryButton2, "binding.btnRenew");
            if (!shouldDisplayRenew(value)) {
                i11 = 8;
            }
            dSPrimaryButton2.setVisibility(i11);
        }
    }

    private final void showSavingsBottomSheet() {
        String str;
        LocalDateTime nextBillingDate;
        SubscriptionSavingsInfo value = getViewModel().getSubscriptionsSaving().getValue();
        if (value != null) {
            Subscription value2 = getViewModel().getSubscription().getValue();
            if (value2 == null || (nextBillingDate = value2.getNextBillingDate()) == null) {
                str = null;
            } else {
                str = nextBillingDate.format(DateTimeFormatter.ISO_DATE_TIME);
            }
            trackCancellationLoadedEvent(SUBSCRIPTION_CANCELLATION_SAVINGS_SCREEN_NAME);
            TProSavingsCancellationBottomSheetFragment.Companion companion = TProSavingsCancellationBottomSheetFragment.Companion;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            if (str == null) {
                str = "";
            }
            companion.show(requireActivity, value, str, new TProSubscriptionDetailsFragment$showSavingsBottomSheet$1$1(this), new TProSubscriptionDetailsFragment$showSavingsBottomSheet$1$2(this));
        }
    }

    /* access modifiers changed from: private */
    public final void showStartExploring() {
        Navigator navigator2 = getNavigator();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Navigator.DefaultImpls.navigateTo$default(navigator2, requireActivity, new RestaurantsListScreen((Void) null, 1, (DefaultConstructorMarker) null), (Function1) null, 4, (Object) null);
        requireActivity().finish();
    }

    private final void showToast(boolean z11) {
        if (z11) {
            Toast toast = new Toast(getContext());
            String string = getString(com.talabat.localization.R.string.auto_renewal_turned_off);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….auto_renewal_turned_off)");
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ToastExtensionsKt.showSuccessToast(toast, string, requireActivity);
            return;
        }
        Toast toast2 = new Toast(getContext());
        String string2 = getString(com.talabat.localization.R.string.auto_renewal_turned_off_fail);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…_renewal_turned_off_fail)");
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        ToastExtensionsKt.showErrorToast(toast2, string2, requireActivity2);
    }

    private final void showUpdateSuccessfully() {
        Toast toast = new Toast(getContext());
        String string = getString(com.talabat.localization.R.string.renew_payment_method);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ing.renew_payment_method)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        ToastExtensionsKt.showSuccessToast(toast, string, requireActivity);
    }

    /* access modifiers changed from: private */
    public final void trackCancellationAbortedEvent(String str) {
        float f11;
        LocalDateTime localDateTime;
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            ISubscriptionsTracker subscriptionsTracker2 = getSubscriptionsTracker();
            String planId = value.getPlan().getPlanId();
            SubscriptionSavingsInfo value2 = getViewModel().getSubscriptionsSaving().getValue();
            if (value2 != null) {
                f11 = value2.getOverallSavings();
            } else {
                f11 = 0.0f;
            }
            float f12 = f11;
            DateAndTimeUtill dateAndTimeUtill = DateAndTimeUtill.INSTANCE;
            LocalDateTime nextBillingDate = value.getNextBillingDate();
            if (nextBillingDate != null) {
                localDateTime = nextBillingDate.minusDays((long) (value.getPlan().getFreeTrialInfo().getFreeTrialDays() - 1));
            } else {
                localDateTime = null;
            }
            subscriptionsTracker2.subscriptionCancellationAborted("subscription", str, planId, dateAndTimeUtill.getPassedDaysFromDate(localDateTime), f12);
        }
    }

    private final void trackCancellationLoadedEvent(String str) {
        float f11;
        LocalDateTime localDateTime;
        Subscription value = getViewModel().getSubscription().getValue();
        if (value != null) {
            ISubscriptionsTracker subscriptionsTracker2 = getSubscriptionsTracker();
            String planId = value.getPlan().getPlanId();
            SubscriptionSavingsInfo value2 = getViewModel().getSubscriptionsSaving().getValue();
            if (value2 != null) {
                f11 = value2.getOverallSavings();
            } else {
                f11 = 0.0f;
            }
            float f12 = f11;
            DateAndTimeUtill dateAndTimeUtill = DateAndTimeUtill.INSTANCE;
            LocalDateTime nextBillingDate = value.getNextBillingDate();
            if (nextBillingDate != null) {
                localDateTime = nextBillingDate.minusDays((long) (value.getPlan().getFreeTrialInfo().getFreeTrialDays() - 1));
            } else {
                localDateTime = null;
            }
            subscriptionsTracker2.subscriptionCancellationLoaded("subscription", str, planId, dateAndTimeUtill.getPassedDaysFromDate(localDateTime), f12);
        }
    }

    /* access modifiers changed from: private */
    public final void trackIfUpgradeLoadedEvent(Subscription subscription2) {
        if (isUpgradeButtonVisible(subscription2)) {
            getSubscriptionsTracker().tProSubscriptionUpgradeLoaded("subscription", SUBSCRIPTION_SCREEN_NAME, subscription2.getUpgradeablePlanInfos().get(0).getPlanId());
        }
    }

    private final void trackUpgradeStartedEvent(Subscription subscription2) {
        getSubscriptionsTracker().tProSubscriptionUpgradeStarted("subscription", SUBSCRIPTION_SCREEN_NAME, subscription2.getUpgradeablePlanInfos().get(0).getPlanId());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (r1.isAutorenewable() == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSubscriptionAutoRenew() {
        /*
            r4 = this;
            r0 = 1
            r4.showProgressBar(r0)
            boolean r1 = r4.getIsPlanShahidActive()
            r2 = 0
            if (r1 == 0) goto L_0x0017
            com.talabat.feature.subscriptions.domain.model.Subscription r1 = r4.subscription
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            boolean r1 = r1.isAutorenewable()
            if (r1 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            com.talabat.feature.tpro.presentation.management.details.viewmodel.TproSubscriptionDetailsViewModel r1 = r4.getViewModel()
            com.talabat.feature.subscriptions.domain.model.Subscription r3 = r4.subscription
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            boolean r3 = r3.isAutorenewable()
            r1.updateAutoRenewalStatus(r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment.updateSubscriptionAutoRenew():void");
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationRepository() {
        LocationConfigurationRepository locationConfigurationRepository = this.locationRepository;
        if (locationConfigurationRepository != null) {
            return locationConfigurationRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationRepository");
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
    public final ISubscriptionStatusRepository getSubscriptionStatusRepository() {
        ISubscriptionStatusRepository iSubscriptionStatusRepository = this.subscriptionStatusRepository;
        if (iSubscriptionStatusRepository != null) {
            return iSubscriptionStatusRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionStatusRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlag() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlag;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureFlag");
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
    public final TproSubscriptionDetailsViewModelFactory getViewModelFactory() {
        TproSubscriptionDetailsViewModelFactory tproSubscriptionDetailsViewModelFactory = this.viewModelFactory;
        if (tproSubscriptionDetailsViewModelFactory != null) {
            return tproSubscriptionDetailsViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        factory.create(requireActivity, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproSubscriptionDetailsBinding fragmentTproSubscriptionDetailsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProSubscriptionDetailsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProSubscriptionDetailsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproSubscriptionDetailsBinding inflate = FragmentTproSubscriptionDetailsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTproSubscriptionDetailsBinding = inflate;
        }
        ConstraintLayout root = fragmentTproSubscriptionDetailsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public void onReasonSubmitSuccess() {
        if (this.isCancelFreeTrial) {
            this.isCancelFreeTrial = false;
            getViewModel().clearActiveSubscription();
            Navigator navigator2 = getNavigator();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Navigator.DefaultImpls.navigateTo$default(navigator2, requireActivity, new HomeScreen(new HomeScreen.HomeScreenData(HomeScreen.NavigationTab.ACCOUNT, false, 2, (DefaultConstructorMarker) null)), (Function1) null, 4, (Object) null);
            onBackPressed((View) null);
        }
    }

    public void onResume() {
        boolean z11;
        super.onResume();
        String userStatus = getSubscriptionSharedPrefManager().getUserStatus();
        if (userStatus.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            userStatus = null;
        }
        if (userStatus != null) {
            getSubscriptionSharedPrefManager().resetUserStatus();
            getViewModel().updateUserStatus(userStatus);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onUpgradeResult(boolean z11) {
        String membershipId2;
        if (z11) {
            Subscription tProSubscriptionInfo = getSubscriptionStatusRepository().getTProSubscriptionInfo();
            if (tProSubscriptionInfo != null && (membershipId2 = tProSubscriptionInfo.getMembershipId()) != null) {
                this.membershipId = membershipId2;
                showProgressBar(true);
                TproSubscriptionDetailsViewModel viewModel = getViewModel();
                String str = this.membershipId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
                    str = null;
                }
                viewModel.loadData(str);
                return;
            }
            return;
        }
        displayUpgradeError();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Subscription tProSubscriptionInfo = getSubscriptionStatusRepository().getTProSubscriptionInfo();
        if (tProSubscriptionInfo == null || (str = tProSubscriptionInfo.getMembershipId()) == null) {
            str = "";
        }
        this.membershipId = str;
        this.isTproSubscriptionUpgradeEnabled = getSubscriptionsFeatureFlag().isTproSubscriptionUpgradeEnabled();
        TproSubscriptionDetailsViewModel viewModel = getViewModel();
        String str2 = this.membershipId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
            str2 = null;
        }
        viewModel.loadData(str2);
        getViewModel().getSavingsInfo();
        observe();
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setLocationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "<set-?>");
        this.locationRepository = locationConfigurationRepository;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setSubscriptionStatusRepository(@NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "<set-?>");
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }

    public final void setSubscriptionsFeatureFlag(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    public final void setSubscriptionsTracker(@NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "<set-?>");
        this.subscriptionsTracker = iSubscriptionsTracker;
    }

    public final void setViewModelFactory(@NotNull TproSubscriptionDetailsViewModelFactory tproSubscriptionDetailsViewModelFactory) {
        Intrinsics.checkNotNullParameter(tproSubscriptionDetailsViewModelFactory, "<set-?>");
        this.viewModelFactory = tproSubscriptionDetailsViewModelFactory;
    }
}
