package com.talabat.feature.tpro.presentation.benefits;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import buisnessmodels.Customer;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.core.navigation.domain.screen.tpro.TproBenefitsScreen;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel;
import com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModelFactory;
import com.talabat.feature.tpro.presentation.constants.GAConstants;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding;
import com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.management.cancellation.deactivate.UnlockProBenefitsBottomSheetFragment;
import com.talabat.feature.tpro.presentation.model.SubscriptionsErrorDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.payment.SubscriptionPaymentDeeplinkBuilder;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragmentKt;
import com.talabat.feature.tpro.presentation.util.SubscriptionSharedPrefManager;
import com.talabat.feature.tpro.presentation.util.SubscriptionsErrorMapper;
import com.talabat.feature.tpro.presentation.welcome.TProWelcomeBottomSheetFragment;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.tracking.Tracker;
import com.tracking.TrackerKt;
import com.tracking.impl.FirebaseTracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import po.a;
import po.c;
import po.d;
import po.e;
import po.f;
import po.g;
import po.h;
import po.i;
import po.j;
import po.k;
import tracking.ScreenNames;

@Instrumented
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\b\u0010L\u001a\u00020GH\u0002J\u0012\u0010M\u001a\u00020G2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u000f\u0010N\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010OJ\u001a\u0010P\u001a\u00020G2\u0006\u0010Q\u001a\u00020R2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\b\u0010S\u001a\u00020GH\u0002J\b\u0010T\u001a\u00020\"H\u0002J\u0010\u0010U\u001a\u00020\u00122\u0006\u0010V\u001a\u00020IH\u0002J\b\u0010W\u001a\u00020\u0012H\u0002J\b\u0010X\u001a\u00020\u0012H\u0002J\b\u0010Y\u001a\u00020\u0012H\u0002J\b\u0010Z\u001a\u00020\u0012H\u0002J\b\u0010[\u001a\u00020\u0012H\u0002J$\u0010\\\u001a\u00020G2\u0006\u0010]\u001a\u00020\"2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0_H\u0002J\b\u0010`\u001a\u00020GH\u0002J\u0010\u0010a\u001a\u00020G2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010b\u001a\u00020G2\u0006\u0010c\u001a\u00020dH\u0016J\u0010\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020gH\u0002J$\u0010h\u001a\u00020g2\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\b\u0010o\u001a\u00020GH\u0002J\b\u0010p\u001a\u00020GH\u0016J\u001a\u0010q\u001a\u00020G2\u0006\u0010f\u001a\u00020g2\b\u0010m\u001a\u0004\u0018\u00010nH\u0016J\u0010\u0010r\u001a\u00020G2\u0006\u0010V\u001a\u00020RH\u0002J\b\u0010s\u001a\u00020\u0012H\u0002J\u0017\u0010t\u001a\u0004\u0018\u00010G2\u0006\u0010u\u001a\u00020\"H\u0002¢\u0006\u0002\u0010vJ\u0010\u0010w\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010x\u001a\u00020G2\u0006\u0010y\u001a\u00020\u0012H\u0002J\u0010\u0010z\u001a\u00020G2\u0006\u0010z\u001a\u00020\u0012H\u0002J\u0010\u0010{\u001a\u00020G2\u0006\u0010|\u001a\u00020\u0012H\u0002J\n\u0010}\u001a\u0004\u0018\u00010RH\u0002J\u001b\u0010~\u001a\u00020G2\u0006\u0010\u001a\u00020\"2\t\u0010\u0001\u001a\u0004\u0018\u00010RH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\"8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b1\u00102R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8BX\u0002¢\u0006\f\n\u0004\b?\u00104\u001a\u0004\b=\u0010>R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006\u0001"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/TproBenefitsFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproBenefitsBinding;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "deeplinkData", "Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;", "getDeeplinkData", "()Lcom/talabat/core/navigation/domain/screen/tpro/TproBenefitsScreen$TproBenefitsData;", "firebaseTracker", "Lcom/tracking/impl/FirebaseTracker;", "isNewBenefitsEnabled", "", "()Z", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "parameters", "", "", "", "subcriptionStatusRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "getSubcriptionStatusRepository", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;", "setSubcriptionStatusRepository", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionStatusRepository;)V", "subscriptionCode", "getSubscriptionCode", "()Ljava/lang/String;", "subscriptionPaymentDeeplinkBuilder", "Lcom/talabat/feature/tpro/presentation/payment/SubscriptionPaymentDeeplinkBuilder;", "subscriptionSharedPrefManager", "Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "getSubscriptionSharedPrefManager", "()Lcom/talabat/feature/tpro/presentation/util/SubscriptionSharedPrefManager;", "subscriptionSharedPrefManager$delegate", "Lkotlin/Lazy;", "subscriptionsFlags", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFlags", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFlags", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "viewModel", "Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModel;", "viewModel$delegate", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/TproBenefitsViewModelFactory;)V", "bindContent", "", "plan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "tProOnBoardingPlanModel", "Lcom/talabat/feature/tpro/presentation/model/TProOnBoardingDisplayModel;", "bindViews", "changeStatusBarColorIfRequired", "closeActivity", "()Lkotlin/Unit;", "displayPlanBenefitsForMultiplan", "tproMultiplan", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "enableContinueButton", "getConfirmButtonText", "getShahidPlanActive", "tproPlan", "hasErrors", "isB2B", "isFlutterPaymentWidgetExperimentEnabled", "isLoggedIn", "isTPro", "logEventToGA", "name", "it", "Lkotlin/Pair;", "observeDataUpdates", "observeOnBoardingCardGaEvent", "onAttach", "context", "Landroid/content/Context;", "onBackClick", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onLearnMoreClick", "onResume", "onViewCreated", "setupViewsForCategory", "shouldActivateContinueBtn", "showError", "errorCode", "(Ljava/lang/String;)Lkotlin/Unit;", "showPaymentScreen", "showProgressBar", "shouldShow", "showShimmer", "subscribedWithB2BVoucher", "isSuccessful", "tProPlan", "updateAmountText", "text", "tProMultiPlan", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproBenefitsFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final String APPLIED_VOUCHER_CODE = "subscriptionCode";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SUBSCRIPTION_BENEFITS_LOADED = "subscription_benefit_loaded";
    @NotNull
    private static final String SUBSCRIPTION_BENEFITS_STARTED_CLICKED = "subscription_started_clicked";
    @NotNull
    public static final String VARIATION_TPRO_FLUTTER_PAYMENT_WIDGET_ENABLED = "Variation1";
    public Trace _nr_trace;
    private FragmentTproBenefitsBinding binding;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    /* access modifiers changed from: private */
    @NotNull
    public final FirebaseTracker firebaseTracker;
    @Inject
    public Navigator navigator;
    @Inject
    public IObservabilityManager observabilityManager;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<String, Object> parameters;
    @Inject
    public ISubscriptionStatusRepository subcriptionStatusRepository;
    /* access modifiers changed from: private */
    @NotNull
    public SubscriptionPaymentDeeplinkBuilder subscriptionPaymentDeeplinkBuilder = new SubscriptionPaymentDeeplinkBuilder();
    @NotNull
    private final Lazy subscriptionSharedPrefManager$delegate;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFlags;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TproBenefitsViewModel.class), new TproBenefitsFragment$special$$inlined$viewModels$default$2(new TproBenefitsFragment$special$$inlined$viewModels$default$1(this)), new TproBenefitsFragment$viewModel$2(this));
    @Inject
    public TproBenefitsViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/TproBenefitsFragment$Companion;", "", "()V", "APPLIED_VOUCHER_CODE", "", "SUBSCRIPTION_BENEFITS_LOADED", "SUBSCRIPTION_BENEFITS_STARTED_CLICKED", "VARIATION_TPRO_FLUTTER_PAYMENT_WIDGET_ENABLED", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TproBenefitsFragment() {
        FirebaseTracker firebaseTracker2 = new FirebaseTracker();
        this.firebaseTracker = firebaseTracker2;
        this.parameters = Tracker.DefaultImpls.createParameters$default(firebaseTracker2, ScreenNames.SUBSCRIPTION_BENEFITS, (String) null, 2, (Object) null);
        this.subscriptionSharedPrefManager$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TproBenefitsFragment$subscriptionSharedPrefManager$2(this));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TProOnBoardingAdapter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bindContent(com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel r14, com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel r15) {
        /*
            r13 = this;
            boolean r0 = r13.isNewBenefitsEnabled()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0027
            if (r15 == 0) goto L_0x0022
            com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TProOnBoardingAdapter r0 = new com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TProOnBoardingAdapter
            com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel r3 = r13.getViewModel()
            com.bumptech.glide.request.RequestListener r3 = r3.getPreloaderCallback()
            com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$1$1 r4 = new com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$1$1
            r4.<init>(r13)
            com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$1$2 r5 = new com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$1$2
            r5.<init>(r13)
            r0.<init>(r15, r3, r4, r5)
            goto L_0x004f
        L_0x0022:
            r13.closeActivity()
            r0 = r2
            goto L_0x004f
        L_0x0027:
            com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TproBenefitsContentAdapter r0 = new com.talabat.feature.tpro.presentation.benefits.adapter.onboarding.TproBenefitsContentAdapter
            int r7 = com.designsystem.marshmallow.R.drawable.ds_delivery_bike_filled
            int r8 = com.designsystem.marshmallow.R.drawable.ds_reward_filled
            androidx.recyclerview.widget.LinearLayoutManager r9 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r15 = r13.requireContext()
            r9.<init>(r15, r1, r1)
            com.talabat.feature.tpro.presentation.benefits.viewmodel.TproBenefitsViewModel r15 = r13.getViewModel()
            com.bumptech.glide.request.RequestListener r10 = r15.getPreloaderCallback()
            com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$3 r11 = new com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$3
            r11.<init>(r13)
            com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$4 r12 = new com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment$bindContent$4
            r12.<init>(r13)
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r0.setTProPlan(r14)
        L_0x004f:
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r15 = r13.binding
            java.lang.String r3 = "binding"
            if (r15 != 0) goto L_0x0059
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r15 = r2
        L_0x0059:
            androidx.recyclerview.widget.RecyclerView r15 = r15.rvOnBoardingContent
            r4 = 1
            r15.setHasFixedSize(r4)
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r15 = r13.binding
            if (r15 != 0) goto L_0x0067
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r15 = r2
        L_0x0067:
            androidx.recyclerview.widget.RecyclerView r15 = r15.rvOnBoardingContent
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r15 = r15.getItemAnimator()
            if (r15 == 0) goto L_0x00b9
            androidx.recyclerview.widget.SimpleItemAnimator r15 = (androidx.recyclerview.widget.SimpleItemAnimator) r15
            r15.setSupportsChangeAnimations(r1)
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r15 = r13.binding
            if (r15 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r15 = r2
        L_0x007c:
            androidx.recyclerview.widget.RecyclerView r15 = r15.rvOnBoardingContent
            r15.setAdapter(r0)
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r5 = r13.requireContext()
            r0.<init>(r5, r4, r1)
            r15.setLayoutManager(r0)
            r13.enableContinueButton()
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r15 = r13.binding
            if (r15 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r15 = r2
        L_0x0098:
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r15 = r15.includePaymentSection
            android.widget.TextView r15 = r15.tvTnc
            po.b r0 = new po.b
            r0.<init>(r13, r14)
            r15.setOnClickListener(r0)
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r14 = r13.binding
            if (r14 != 0) goto L_0x00ac
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x00ad
        L_0x00ac:
            r2 = r14
        L_0x00ad:
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r14 = r2.includePaymentSection
            com.designsystem.ds_button_v2.DSPrimaryButton r14 = r14.actionButton
            java.lang.String r15 = r13.getConfirmButtonText()
            r14.setTitle(r15)
            return
        L_0x00b9:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r15 = "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.bindContent(com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel, com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: bindContent$lambda-26  reason: not valid java name */
    public static final void m10351bindContent$lambda26(TproBenefitsFragment tproBenefitsFragment, TProPlanDisplayModel tProPlanDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "$plan");
        String string = tproBenefitsFragment.getResources().getString(R.string.tpro_tnc);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…zation.R.string.tpro_tnc)");
        Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
        Context requireContext = tproBenefitsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(companion, requireContext, string, tProPlanDisplayModel.getTermsUrl());
    }

    private final void bindViews() {
        showShimmer(true);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [androidx.fragment.app.FragmentActivity] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void changeStatusBarColorIfRequired(com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel r5) {
        /*
            r4 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            boolean r1 = r4.isNewBenefitsEnabled()
            r2 = 0
            if (r1 == 0) goto L_0x003a
            if (r5 == 0) goto L_0x0046
            colorprovider.DSColorProvider r1 = colorprovider.DSColorProvider.INSTANCE
            java.util.Map r1 = r1.getMarshmallowColorMap()
            com.talabat.feature.subscriptions.domain.model.TProOnBoardingBannerModel r5 = r5.getHeroBanner()
            java.lang.String r5 = r5.getHeroBackgroundColor()
            java.lang.Object r5 = r1.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0036
            int r5 = r5.intValue()
            android.content.Context r1 = r4.requireContext()
            java.lang.String r3 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.graphics.drawable.GradientDrawable r5 = com.talabat.feature.tpro.presentation.util.CreateGradientDrawableKt.createGradientDrawable(r1, r5)
            goto L_0x0037
        L_0x0036:
            r5 = r2
        L_0x0037:
            r0.element = r5
            goto L_0x0046
        L_0x003a:
            android.content.Context r5 = r4.requireContext()
            int r1 = com.talabat.feature.tpro.presentation.R.drawable.bg_activity_blue_gradient
            android.graphics.drawable.Drawable r5 = androidx.core.content.ContextCompat.getDrawable(r5, r1)
            r0.element = r5
        L_0x0046:
            T r5 = r0.element
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            if (r5 == 0) goto L_0x005c
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            boolean r1 = r0 instanceof com.talabat.feature.tpro.presentation.benefits.inferface.IChangeStatusBarColor
            if (r1 == 0) goto L_0x0057
            r2 = r0
            com.talabat.feature.tpro.presentation.benefits.inferface.IChangeStatusBarColor r2 = (com.talabat.feature.tpro.presentation.benefits.inferface.IChangeStatusBarColor) r2
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.changeStatusBarColor(r5)
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.changeStatusBarColorIfRequired(com.talabat.feature.tpro.presentation.model.TProOnBoardingDisplayModel):void");
    }

    private final Unit closeActivity() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return null;
        }
        activity.finish();
        return Unit.INSTANCE;
    }

    private final void displayPlanBenefitsForMultiplan(TProMultiPlanDisplayModel tProMultiPlanDisplayModel, TProOnBoardingDisplayModel tProOnBoardingDisplayModel) {
        changeStatusBarColorIfRequired(tProOnBoardingDisplayModel);
        bindContent(tProMultiPlanDisplayModel.getPlans().get(0), tProOnBoardingDisplayModel);
        if (tProOnBoardingDisplayModel != null) {
            observeOnBoardingCardGaEvent(tProOnBoardingDisplayModel);
        }
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = this.binding;
        if (fragmentTproBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproBenefitsBinding = null;
        }
        fragmentTproBenefitsBinding.includePaymentSection.actionButton.setOnTap(new TproBenefitsFragment$displayPlanBenefitsForMultiplan$2(this, tProMultiPlanDisplayModel));
    }

    private final void enableContinueButton() {
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = this.binding;
        if (fragmentTproBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproBenefitsBinding = null;
        }
        fragmentTproBenefitsBinding.includePaymentSection.actionButton.setButtonEnabled(shouldActivateContinueBtn());
    }

    private final String getConfirmButtonText() {
        SubscriptionRenewType subscriptionRenewType;
        boolean z11;
        int i11;
        List<TProPlanDisplayModel> plans;
        TProPlanDisplayModel tProPlanDisplayModel;
        TProMultiPlanDisplayModel value = getViewModel().getTProMultiPlan().getValue();
        if (value == null || (plans = value.getPlans()) == null || (tProPlanDisplayModel = (TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(plans)) == null) {
            subscriptionRenewType = null;
        } else {
            subscriptionRenewType = tProPlanDisplayModel.getRenewType();
        }
        if (subscriptionRenewType == SubscriptionRenewType.Renewable) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!isB2B() || z11) {
            i11 = R.string.tpro_continue;
        } else {
            i11 = R.string.tpro_activate_your_subscription;
        }
        String string = getResources().getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …g.tpro_continue\n        )");
        return string;
    }

    /* access modifiers changed from: private */
    public final TproBenefitsScreen.TproBenefitsData getDeeplinkData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (TproBenefitsScreen.TproBenefitsData) arguments.getParcelable("navigatorData");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final boolean getShahidPlanActive(TProPlanDisplayModel tProPlanDisplayModel) {
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

    /* access modifiers changed from: private */
    public final String getSubscriptionCode() {
        TproBenefitsScreen.TproBenefitsData deeplinkData;
        Bundle deeplinkBundle;
        if (!getSubscriptionsFlags().isOnboardingDeeplingEnabled() || (deeplinkData = getDeeplinkData()) == null || (deeplinkBundle = deeplinkData.getDeeplinkBundle()) == null) {
            return null;
        }
        return deeplinkBundle.getString("sc");
    }

    private final SubscriptionSharedPrefManager getSubscriptionSharedPrefManager() {
        return (SubscriptionSharedPrefManager) this.subscriptionSharedPrefManager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TproBenefitsViewModel getViewModel() {
        return (TproBenefitsViewModel) this.viewModel$delegate.getValue();
    }

    private final boolean hasErrors() {
        return getViewModel().getDisplayError().getValue() != null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel) kotlin.collections.CollectionsKt___CollectionsKt.first((r0 = r0.getPlans()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isB2B() {
        /*
            r2 = this;
            com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel r0 = r2.tProPlan()
            if (r0 == 0) goto L_0x0019
            java.util.List r0 = r0.getPlans()
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.first(r0)
            com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel r0 = (com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel) r0
            if (r0 == 0) goto L_0x0019
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r0 = r0.getCategory()
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory r1 = com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory.B2B
            if (r0 != r1) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.isB2B():boolean");
    }

    private final boolean isFlutterPaymentWidgetExperimentEnabled() {
        return Intrinsics.areEqual((Object) TalabatExperiment.INSTANCE.getStringVariant(EcosystemsExperimentsKeys.TPRO_FLUTTER_PAYMENT_WIDGET, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    private final boolean isLoggedIn() {
        return Customer.getInstance().isLoggedIn();
    }

    private final boolean isNewBenefitsEnabled() {
        if (!getSubscriptionsFlags().isNewHeroBannerEnabled()) {
            return false;
        }
        String subscriptionCode = getSubscriptionCode();
        return subscriptionCode == null || subscriptionCode.length() == 0;
    }

    private final boolean isTPro() {
        return getSubcriptionStatusRepository().isTProUser();
    }

    /* access modifiers changed from: private */
    public final void logEventToGA(String str, Pair<String, String> pair) {
        Map<String, Object> createParameters = this.firebaseTracker.createParameters(GAConstants.SUBSCRIPTION_BENEFITS_SCREEN_NAME, "subscription");
        createParameters.put(pair.getFirst(), pair.getSecond());
        this.firebaseTracker.sendEvent(str, createParameters);
    }

    private final void observeDataUpdates() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TproBenefitsViewModel viewModel = getViewModel();
        viewModel.getFailure().observe(getViewLifecycleOwner(), new a(this));
        viewModel.getDisplayError().observe(getViewLifecycleOwner(), new c(this));
        viewModel.getTProMultiPlan().observe(getViewLifecycleOwner(), new d(objectRef, this));
        viewModel.getTProOnBoardingPlan().observe(getViewLifecycleOwner(), new e(objectRef, this));
        viewModel.isDataReady().observe(getViewLifecycleOwner(), new f(this));
        viewModel.getAmountText().observe(getViewLifecycleOwner(), new g(this, objectRef));
        viewModel.getAmountTextNewHero().observe(getViewLifecycleOwner(), new h(this, objectRef));
        viewModel.getSendFirebaseEvent().observe(getViewLifecycleOwner(), new i(this));
        viewModel.isSubscribedWithB2BVoucher().observe(getViewLifecycleOwner(), new j(this));
        viewModel.getPostUpdatingStatus().observe(getViewLifecycleOwner(), new k(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-10  reason: not valid java name */
    public static final void m10352observeDataUpdates$lambda14$lambda10(TproBenefitsFragment tproBenefitsFragment, Ref.ObjectRef objectRef, String str) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$tproMultiplan");
        Intrinsics.checkNotNullExpressionValue(str, "it");
        tproBenefitsFragment.updateAmountText(str, (TProMultiPlanDisplayModel) objectRef.element);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-11  reason: not valid java name */
    public static final void m10353observeDataUpdates$lambda14$lambda11(TproBenefitsFragment tproBenefitsFragment, String str) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        Map<String, Object> map = tproBenefitsFragment.parameters;
        String subscriptionCode = tproBenefitsFragment.getSubscriptionCode();
        if (subscriptionCode == null) {
            subscriptionCode = "";
        }
        TrackerKt.addParameter(map, APPLIED_VOUCHER_CODE, subscriptionCode);
        FirebaseTracker firebaseTracker2 = tproBenefitsFragment.firebaseTracker;
        Intrinsics.checkNotNullExpressionValue(str, "it");
        firebaseTracker2.sendEvent(str, tproBenefitsFragment.parameters);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-13  reason: not valid java name */
    public static final void m10354observeDataUpdates$lambda14$lambda13(TproBenefitsFragment tproBenefitsFragment, Screen screen) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        if (screen != null) {
            tproBenefitsFragment.requireActivity().finish();
            com.talabat.core.navigation.domain.Navigator navigator2 = tproBenefitsFragment.getNavigator();
            FragmentActivity requireActivity = tproBenefitsFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Navigator.DefaultImpls.navigateTo$default(navigator2, requireActivity, screen, (Function1) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-3  reason: not valid java name */
    public static final void m10355observeDataUpdates$lambda14$lambda3(TproBenefitsFragment tproBenefitsFragment, Throwable th2) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        tproBenefitsFragment.closeActivity();
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-5  reason: not valid java name */
    public static final void m10356observeDataUpdates$lambda14$lambda5(TproBenefitsFragment tproBenefitsFragment, SubscriptionsErrorDisplayModel subscriptionsErrorDisplayModel) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        tproBenefitsFragment.enableContinueButton();
        tproBenefitsFragment.showProgressBar(false);
        String errorCode = subscriptionsErrorDisplayModel.getErrorMessage().getErrorCode();
        if (errorCode != null) {
            tproBenefitsFragment.showError(errorCode);
        }
        if (subscriptionsErrorDisplayModel.getShouldClose()) {
            tproBenefitsFragment.closeActivity();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-6  reason: not valid java name */
    public static final void m10357observeDataUpdates$lambda14$lambda6(Ref.ObjectRef objectRef, TproBenefitsFragment tproBenefitsFragment, TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        Intrinsics.checkNotNullParameter(objectRef, "$tproMultiplan");
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        objectRef.element = tProMultiPlanDisplayModel;
        Intrinsics.checkNotNullExpressionValue(tProMultiPlanDisplayModel, "tproMultiPlan");
        tproBenefitsFragment.setupViewsForCategory(tProMultiPlanDisplayModel);
        tproBenefitsFragment.displayPlanBenefitsForMultiplan(tProMultiPlanDisplayModel, (TProOnBoardingDisplayModel) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-7  reason: not valid java name */
    public static final void m10358observeDataUpdates$lambda14$lambda7(Ref.ObjectRef objectRef, TproBenefitsFragment tproBenefitsFragment, TProOnBoardingDisplayModel tProOnBoardingDisplayModel) {
        Intrinsics.checkNotNullParameter(objectRef, "$tproMultiplan");
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        objectRef.element = tProOnBoardingDisplayModel.getSubscriptionMultiPlan();
        tproBenefitsFragment.setupViewsForCategory(tProOnBoardingDisplayModel.getSubscriptionMultiPlan());
        tproBenefitsFragment.displayPlanBenefitsForMultiplan(tProOnBoardingDisplayModel.getSubscriptionMultiPlan(), tProOnBoardingDisplayModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-8  reason: not valid java name */
    public static final void m10359observeDataUpdates$lambda14$lambda8(TproBenefitsFragment tproBenefitsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        tproBenefitsFragment.showShimmer(!bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-14$lambda-9  reason: not valid java name */
    public static final void m10360observeDataUpdates$lambda14$lambda9(TproBenefitsFragment tproBenefitsFragment, Ref.ObjectRef objectRef, String str) {
        Intrinsics.checkNotNullParameter(tproBenefitsFragment, "this$0");
        Intrinsics.checkNotNullParameter(objectRef, "$tproMultiplan");
        Intrinsics.checkNotNullExpressionValue(str, "it");
        tproBenefitsFragment.updateAmountText(str, (TProMultiPlanDisplayModel) objectRef.element);
    }

    private final void observeOnBoardingCardGaEvent(TProOnBoardingDisplayModel tProOnBoardingDisplayModel) {
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(tProOnBoardingDisplayModel.getHeroBanner().getHeroWidget(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, TproBenefitsFragment$observeOnBoardingCardGaEvent$heroBannerTrackingIds$1.INSTANCE, 30, (Object) null);
        String joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(tProOnBoardingDisplayModel.getCards(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, TproBenefitsFragment$observeOnBoardingCardGaEvent$cardTrackingIds$1.INSTANCE, 30, (Object) null);
        Map<String, Object> createParameters = this.firebaseTracker.createParameters(GAConstants.SUBSCRIPTION_BENEFITS_SCREEN_NAME, "subscription");
        createParameters.put(GAConstants.CARD_CONTENT, joinToString$default + joinToString$default2);
        this.firebaseTracker.sendEvent(GAConstants.SUBSCRIPTION_BENEFIT_CARD_LOADED, createParameters);
    }

    /* access modifiers changed from: private */
    public final void onBackClick(View view) {
        getViewModel().sendPageLoadedBrazeEvent();
        requireActivity().finish();
    }

    /* access modifiers changed from: private */
    public final void onLearnMoreClick() {
        UnlockProBenefitsBottomSheetFragment.Companion companion = UnlockProBenefitsBottomSheetFragment.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        companion.show(requireActivity, TproBenefitsFragment$onLearnMoreClick$1.INSTANCE, Boolean.TRUE);
    }

    private final void setupViewsForCategory(TProMultiPlanDisplayModel tProMultiPlanDisplayModel) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i11;
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = this.binding;
        if (fragmentTproBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproBenefitsBinding = null;
        }
        int i12 = 0;
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        if (((TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(tProMultiPlanDisplayModel.getPlans())).getCategory() == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (((TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(tProMultiPlanDisplayModel.getPlans())).getRenewType() == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            z13 = false;
        } else {
            z13 = true;
        }
        TextView textView = fragmentTproBenefitsBinding.includePaymentSection.cancelTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "includePaymentSection.cancelTextView");
        if (!isB2B() || z13) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        TextView textView2 = fragmentTproBenefitsBinding.includePaymentSection.tvPrice;
        Intrinsics.checkNotNullExpressionValue(textView2, "includePaymentSection.tvPrice");
        if (!(!isB2B())) {
            i12 = 8;
        }
        textView2.setVisibility(i12);
    }

    private final boolean shouldActivateContinueBtn() {
        return !isTPro() && !hasErrors();
    }

    private final Unit showError(String str) {
        Integer resId = SubscriptionsErrorMapper.INSTANCE.toResId(str);
        if (resId == null) {
            return null;
        }
        Toast.makeText(requireContext(), resId.intValue(), 1).show();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void showPaymentScreen(TProPlanDisplayModel tProPlanDisplayModel) {
        boolean z11;
        if (isFlutterPaymentWidgetExperimentEnabled()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new TproBenefitsFragment$showPaymentScreen$1(this, this.subscriptionPaymentDeeplinkBuilder.build(tProPlanDisplayModel.getPlanId(), getSubscriptionCode(), TproBenefitsFragmentKt.BENEFIT_STRATEGY), tProPlanDisplayModel, (Continuation<? super TproBenefitsFragment$showPaymentScreen$1>) null), 3, (Object) null);
            return;
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        TproBenefitsScreen.TproBenefitsData deeplinkData = getDeeplinkData();
        if (deeplinkData != null) {
            z11 = deeplinkData.isReactivate();
        } else {
            z11 = false;
        }
        TProPaymentBottomSheetFragmentKt.showPaymentBottomSheet(requireActivity, tProPlanDisplayModel, z11, getSubscriptionCode());
    }

    /* access modifiers changed from: private */
    public final void showProgressBar(boolean z11) {
        int i11;
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = this.binding;
        if (fragmentTproBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproBenefitsBinding = null;
        }
        IncludePaymentSectionBinding includePaymentSectionBinding = fragmentTproBenefitsBinding.includePaymentSection;
        ProgressBar progressBar = includePaymentSectionBinding.pbSubscribing;
        Intrinsics.checkNotNullExpressionValue(progressBar, "pbSubscribing");
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        DSPrimaryButton dSPrimaryButton = includePaymentSectionBinding.actionButton;
        if (z11) {
            i12 = 4;
        }
        dSPrimaryButton.setVisibility(i12);
    }

    private final void showShimmer(boolean z11) {
        boolean z12;
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = this.binding;
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding2 = null;
        if (fragmentTproBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentTproBenefitsBinding = null;
        }
        ConstraintLayout root = fragmentTproBenefitsBinding.shimmer.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.shimmer.root");
        int i11 = 0;
        if (root.getVisibility() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12 != z11) {
            FragmentTproBenefitsBinding fragmentTproBenefitsBinding3 = this.binding;
            if (fragmentTproBenefitsBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentTproBenefitsBinding2 = fragmentTproBenefitsBinding3;
            }
            ConstraintLayout root2 = fragmentTproBenefitsBinding2.shimmer.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.shimmer.root");
            if (!z11) {
                i11 = 8;
            }
            root2.setVisibility(i11);
        }
    }

    /* access modifiers changed from: private */
    public final void subscribedWithB2BVoucher(boolean z11) {
        if (z11) {
            showProgressBar(false);
            TProMultiPlanDisplayModel tProPlan = tProPlan();
            if (tProPlan != null) {
                TProWelcomeBottomSheetFragment.Companion companion = TProWelcomeBottomSheetFragment.Companion;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                companion.show(requireActivity, (TProPlanDisplayModel) CollectionsKt___CollectionsKt.first(tProPlan.getPlans()), "");
            }
        }
    }

    private final TProMultiPlanDisplayModel tProPlan() {
        TProMultiPlanDisplayModel value = getViewModel().getTProMultiPlan().getValue();
        if (value != null) {
            return value;
        }
        TProOnBoardingDisplayModel value2 = getViewModel().getTProOnBoardingPlan().getValue();
        if (value2 != null) {
            return value2.getSubscriptionMultiPlan();
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateAmountText(java.lang.String r4, com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel r5) {
        /*
            r3 = this;
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r0 = r3.binding
            java.lang.String r1 = "binding"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r0 = r0.includePaymentSection
            android.widget.TextView r0 = r0.tvPrice
            r0.setText(r4)
            int r4 = r4.length()
            r0 = 0
            if (r4 != 0) goto L_0x001b
            r4 = 1
            goto L_0x001c
        L_0x001b:
            r4 = r0
        L_0x001c:
            if (r4 == 0) goto L_0x004d
            com.talabat.feature.tpro.presentation.databinding.FragmentTproBenefitsBinding r4 = r3.binding
            if (r4 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r4 = r2
        L_0x0026:
            com.talabat.feature.tpro.presentation.databinding.IncludePaymentSectionBinding r4 = r4.includePaymentSection
            android.widget.TextView r4 = r4.cancelTextView
            java.lang.String r1 = "binding.includePaymentSection.cancelTextView"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            if (r5 == 0) goto L_0x003e
            java.util.List r5 = r5.getPlans()
            if (r5 == 0) goto L_0x003e
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.first(r5)
            r2 = r5
            com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel r2 = (com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel) r2
        L_0x003e:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r5 = r3.getShahidPlanActive(r2)
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r0 = 8
        L_0x004a:
            r4.setVisibility(r0)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.benefits.TproBenefitsFragment.updateAmountText(java.lang.String, com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel):void");
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
    public final com.talabat.core.navigation.domain.Navigator getNavigator() {
        com.talabat.core.navigation.domain.Navigator navigator2 = this.navigator;
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
    public final ISubscriptionStatusRepository getSubcriptionStatusRepository() {
        ISubscriptionStatusRepository iSubscriptionStatusRepository = this.subcriptionStatusRepository;
        if (iSubscriptionStatusRepository != null) {
            return iSubscriptionStatusRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subcriptionStatusRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFlags() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFlags;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFlags");
        return null;
    }

    @NotNull
    public final TproBenefitsViewModelFactory getViewModelFactory() {
        TproBenefitsViewModelFactory tproBenefitsViewModelFactory = this.viewModelFactory;
        if (tproBenefitsViewModelFactory != null) {
            return tproBenefitsViewModelFactory;
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
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TproBenefitsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TproBenefitsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproBenefitsBinding inflate = FragmentTproBenefitsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        Map<String, Object> map = this.parameters;
        String subscriptionCode = getSubscriptionCode();
        if (subscriptionCode == null) {
            subscriptionCode = "";
        }
        TrackerKt.addParameter(map, APPLIED_VOUCHER_CODE, subscriptionCode);
        this.firebaseTracker.sendEvent(SUBSCRIPTION_BENEFITS_LOADED, this.parameters);
        bindViews();
        if (getSubscriptionCode() == null || isLoggedIn()) {
            getViewModel().loadData(getSubscriptionCode(), isNewBenefitsEnabled());
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString(APPLIED_VOUCHER_CODE, getSubscriptionCode());
            NavigatorModel navigatorModel = new NavigatorModel(LegacyTalabatActions.OPEN_LOGIN_SCREEN_ACTIVITY, bundle2, (Function1) null, 4, (DefaultConstructorMarker) null);
            Toast.makeText(requireContext(), R.string.tpro_subscription_deeplink_nonloged_in_message, 1).show();
            Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            companion.navigate(requireContext, navigatorModel);
        }
        FragmentTproBenefitsBinding fragmentTproBenefitsBinding2 = this.binding;
        if (fragmentTproBenefitsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentTproBenefitsBinding = fragmentTproBenefitsBinding2;
        }
        ConstraintLayout root = fragmentTproBenefitsBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
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
            getSubscriptionSharedPrefManager().saveSubscriptionStatus();
            getViewModel().updateUserStatus(userStatus);
        }
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
        observeDataUpdates();
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setNavigator(@NotNull com.talabat.core.navigation.domain.Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setSubcriptionStatusRepository(@NotNull ISubscriptionStatusRepository iSubscriptionStatusRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionStatusRepository, "<set-?>");
        this.subcriptionStatusRepository = iSubscriptionStatusRepository;
    }

    public final void setSubscriptionsFlags(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFlags = iSubscriptionsFeatureFlagsRepository;
    }

    public final void setViewModelFactory(@NotNull TproBenefitsViewModelFactory tproBenefitsViewModelFactory) {
        Intrinsics.checkNotNullParameter(tproBenefitsViewModelFactory, "<set-?>");
        this.viewModelFactory = tproBenefitsViewModelFactory;
    }
}
