package com.talabat.feature.tpro.presentation.management.details.upgrade.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeDetailsBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;
import com.talabat.feature.tpro.presentation.management.details.upgrade.TproUpgradeSuccessBottomSheetFragment;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.adapter.UpgradeBenefitsAdapter;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModel;
import com.talabat.feature.tpro.presentation.management.details.upgrade.details.viewModel.TproUpgradeDetailsViewModelFactory;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import com.talabat.feature.walletaddcard.presentation.Wallet3DsActivity;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatlife.features.UrlConstantsKt;
import gp.a;
import gp.b;
import gp.c;
import java.util.ArrayList;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\b\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020%H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0016J$\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u001a\u0010:\u001a\u00020%2\u0006\u0010;\u001a\u0002032\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010<\u001a\u00020%H\u0002J\b\u0010=\u001a\u00020%H\u0002J\b\u0010>\u001a\u00020%H\u0002J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020%H\u0002J\b\u0010C\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006F"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "currentPlanId", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "membershipId", "resultHandler", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment$ResultHandler;", "subscriptionUpgradePlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "subscriptionsTracker", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "getSubscriptionsTracker", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;", "setSubscriptionsTracker", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsTracker;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproUpgradeDetailsBinding;", "viewModel", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/viewModel/TproUpgradeDetailsViewModelFactory;)V", "addButtonsListeners", "", "attemptUpgrade", "dismiss", "handle3DSVerification", "redirectUrl", "handleArguments", "handleUpgradeFailure", "handleUpgradeSuccess", "upgradedSubscriptionEndDate", "Lorg/threeten/bp/LocalDateTime;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpObservers", "setUpViews", "showProgresses", "showProgress", "", "trackUpgradeAttempted", "trackUpgradeCompleted", "Companion", "ResultHandler", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproUpgradeDetailsBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String KEY_CURRENT_PLAN_ID = "current_plan_id";
    @NotNull
    public static final String KEY_MEMBERSHIP_ID = "membership_id";
    @NotNull
    public static final String KEY_SUBSCRIPTION_UPGRADE_PLAN = "subscription_upgrade_plan";
    @NotNull
    public static final String TAG = "TproUpgradeDetailsBottomSheetFragment";
    public Trace _nr_trace;
    private String currentPlanId;
    @NotNull
    private final ActivityResultLauncher<Intent> launcher;
    private String membershipId;
    @Nullable
    private ResultHandler resultHandler;
    private SubscriptionUpgradePlan subscriptionUpgradePlan;
    @Inject
    public ISubscriptionsTracker subscriptionsTracker;
    private FragmentTproUpgradeDetailsBinding viewBinding;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TproUpgradeDetailsViewModel.class), new TproUpgradeDetailsBottomSheetFragment$special$$inlined$viewModels$default$2(new TproUpgradeDetailsBottomSheetFragment$special$$inlined$viewModels$default$1(this)), new TproUpgradeDetailsBottomSheetFragment$viewModel$2(this));
    @Inject
    public TproUpgradeDetailsViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment$Companion;", "", "()V", "KEY_CURRENT_PLAN_ID", "", "KEY_MEMBERSHIP_ID", "KEY_SUBSCRIPTION_UPGRADE_PLAN", "TAG", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment;", "membershipId", "currentPlanId", "subscriptionUpgradePlan", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionUpgradePlan;", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TproUpgradeDetailsBottomSheetFragment getInstance(String str, String str2, SubscriptionUpgradePlan subscriptionUpgradePlan) {
            TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment = new TproUpgradeDetailsBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TproUpgradeDetailsBottomSheetFragment.KEY_MEMBERSHIP_ID, str);
            bundle.putString(TproUpgradeDetailsBottomSheetFragment.KEY_CURRENT_PLAN_ID, str2);
            bundle.putParcelable(TproUpgradeDetailsBottomSheetFragment.KEY_SUBSCRIPTION_UPGRADE_PLAN, subscriptionUpgradePlan);
            tproUpgradeDetailsBottomSheetFragment.setArguments(bundle);
            return tproUpgradeDetailsBottomSheetFragment;
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull String str2, @NotNull SubscriptionUpgradePlan subscriptionUpgradePlan) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            Intrinsics.checkNotNullParameter(str2, "currentPlanId");
            Intrinsics.checkNotNullParameter(subscriptionUpgradePlan, "subscriptionUpgradePlan");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TproUpgradeDetailsBottomSheetFragment.Companion.getInstance(str, str2, subscriptionUpgradePlan));
            dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TproUpgradeDetailsBottomSheetFragment.TAG);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/details/TproUpgradeDetailsBottomSheetFragment$ResultHandler;", "", "onUpgradeResult", "", "isSuccess", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ResultHandler {
        void onUpgradeResult(boolean z11);
    }

    public TproUpgradeDetailsBottomSheetFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…Failure()\n        }\n    }");
        this.launcher = registerForActivityResult;
    }

    private final void addButtonsListeners() {
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding = this.viewBinding;
        if (fragmentTproUpgradeDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeDetailsBinding = null;
        }
        fragmentTproUpgradeDetailsBinding.cancelButton.setOnClickListener(new b(this));
        fragmentTproUpgradeDetailsBinding.confirmUpgradeProLayout.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10407addButtonsListeners$lambda3$lambda1(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tproUpgradeDetailsBottomSheetFragment, "this$0");
        tproUpgradeDetailsBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10408addButtonsListeners$lambda3$lambda2(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tproUpgradeDetailsBottomSheetFragment, "this$0");
        tproUpgradeDetailsBottomSheetFragment.attemptUpgrade();
    }

    private final void attemptUpgrade() {
        showProgresses(true);
        trackUpgradeAttempted();
        TproUpgradeDetailsViewModel viewModel = getViewModel();
        String str = this.membershipId;
        SubscriptionUpgradePlan subscriptionUpgradePlan2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException(UrlConstantsKt.PATH_MEMBERSHIP_ID);
            str = null;
        }
        String str2 = this.currentPlanId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPlanId");
            str2 = null;
        }
        SubscriptionUpgradePlan subscriptionUpgradePlan3 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
        } else {
            subscriptionUpgradePlan2 = subscriptionUpgradePlan3;
        }
        viewModel.upgradePlan(str, str2, subscriptionUpgradePlan2.getPlanId());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dismiss() {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x0013
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = "TproUpgradeDetailsBottomSheetFragment"
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x001c
            androidx.fragment.app.DialogFragment r0 = (androidx.fragment.app.DialogFragment) r0
            r0.dismiss()
            return
        L_0x001c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.DialogFragment"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment.dismiss():void");
    }

    private final TproUpgradeDetailsViewModel getViewModel() {
        return (TproUpgradeDetailsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handle3DSVerification(String str) {
        Intent intent = new Intent(requireActivity(), Wallet3DsActivity.class);
        intent.putExtra(Wallet3DsActivity.WALLET_THREE_DS_URL_KEY, str);
        this.launcher.launch(intent);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleArguments() {
        /*
            r7 = this;
            android.os.Bundle r0 = r7.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r2 = "membership_id"
            java.lang.String r0 = r0.getString(r2)
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            android.os.Bundle r2 = r7.getArguments()
            if (r2 == 0) goto L_0x001c
            java.lang.String r3 = "current_plan_id"
            java.lang.String r2 = r2.getString(r3)
            goto L_0x001d
        L_0x001c:
            r2 = r1
        L_0x001d:
            android.os.Bundle r3 = r7.getArguments()
            if (r3 == 0) goto L_0x0042
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 33
            java.lang.String r6 = "subscription_upgrade_plan"
            if (r4 < r5) goto L_0x0034
            java.lang.Class<com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan> r1 = com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan.class
            java.lang.Object r1 = r3.getParcelable(r6, r1)
            android.os.Parcelable r1 = (android.os.Parcelable) r1
            goto L_0x0040
        L_0x0034:
            android.os.Parcelable r3 = r3.getParcelable(r6)
            boolean r4 = r3 instanceof com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan
            if (r4 != 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r1 = r3
        L_0x003e:
            com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan r1 = (com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan) r1
        L_0x0040:
            com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan r1 = (com.talabat.feature.subscriptions.domain.model.SubscriptionUpgradePlan) r1
        L_0x0042:
            if (r0 == 0) goto L_0x004f
            if (r2 == 0) goto L_0x004f
            if (r1 == 0) goto L_0x004f
            r7.membershipId = r0
            r7.currentPlanId = r2
            r7.subscriptionUpgradePlan = r1
            goto L_0x0052
        L_0x004f:
            r7.dismiss()
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.upgrade.details.TproUpgradeDetailsBottomSheetFragment.handleArguments():void");
    }

    /* access modifiers changed from: private */
    public final void handleUpgradeFailure() {
        ResultHandler resultHandler2 = this.resultHandler;
        if (resultHandler2 != null) {
            resultHandler2.onUpgradeResult(false);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    public final void handleUpgradeSuccess(LocalDateTime localDateTime) {
        trackUpgradeCompleted();
        TproUpgradeSuccessBottomSheetFragment.Companion companion = TproUpgradeSuccessBottomSheetFragment.Companion;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        SubscriptionUpgradePlan subscriptionUpgradePlan2 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
            subscriptionUpgradePlan2 = null;
        }
        companion.show(requireActivity, subscriptionUpgradePlan2.getPlanPeriod(), DateAndTimeUtill.INSTANCE.getSubscriptionDisplayDate(localDateTime));
        ResultHandler resultHandler2 = this.resultHandler;
        if (resultHandler2 != null) {
            resultHandler2.onUpgradeResult(true);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: launcher$lambda-4  reason: not valid java name */
    public static final void m10409launcher$lambda4(TproUpgradeDetailsBottomSheetFragment tproUpgradeDetailsBottomSheetFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(tproUpgradeDetailsBottomSheetFragment, "this$0");
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            tproUpgradeDetailsBottomSheetFragment.getViewModel().updateCustomerInfo();
        } else if (resultCode != 201) {
            tproUpgradeDetailsBottomSheetFragment.handleUpgradeFailure();
        } else {
            tproUpgradeDetailsBottomSheetFragment.handleUpgradeFailure();
        }
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setUpObservers() {
        LifecycleKt.observe(this, getViewModel().getUpgradeResult(), new TproUpgradeDetailsBottomSheetFragment$setUpObservers$1(this));
        LifecycleKt.observe(this, getViewModel().getVerification3ds(), new TproUpgradeDetailsBottomSheetFragment$setUpObservers$2(this));
    }

    private final void setUpViews() {
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding = this.viewBinding;
        SubscriptionUpgradePlan subscriptionUpgradePlan2 = null;
        if (fragmentTproUpgradeDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeDetailsBinding = null;
        }
        TextView textView = fragmentTproUpgradeDetailsBinding.tvUpgradeHeader;
        int i11 = com.talabat.localization.R.string.tpro_upgrate_details_title;
        Object[] objArr = new Object[2];
        objArr[0] = Customer.getInstance().getCustomerInfo().getFistName();
        SubscriptionUpgradePlan subscriptionUpgradePlan3 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
            subscriptionUpgradePlan3 = null;
        }
        String planPeriod = subscriptionUpgradePlan3.getPlanPeriod();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = planPeriod.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        objArr[1] = lowerCase;
        textView.setText(getString(i11, objArr));
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding2 = this.viewBinding;
        if (fragmentTproUpgradeDetailsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeDetailsBinding2 = null;
        }
        TextView textView2 = fragmentTproUpgradeDetailsBinding2.tvUpgradeInfo;
        int i12 = com.talabat.localization.R.string.tpro_upgrate_details_info;
        Object[] objArr2 = new Object[1];
        SubscriptionUpgradePlan subscriptionUpgradePlan4 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
            subscriptionUpgradePlan4 = null;
        }
        String planPeriod2 = subscriptionUpgradePlan4.getPlanPeriod();
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        String lowerCase2 = planPeriod2.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        objArr2[0] = lowerCase2;
        textView2.setText(getString(i12, objArr2));
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding3 = this.viewBinding;
        if (fragmentTproUpgradeDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeDetailsBinding3 = null;
        }
        RecyclerView recyclerView = fragmentTproUpgradeDetailsBinding3.rvUpgradeBenefits;
        SubscriptionUpgradePlan subscriptionUpgradePlan5 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
        } else {
            subscriptionUpgradePlan2 = subscriptionUpgradePlan5;
        }
        recyclerView.setAdapter(new UpgradeBenefitsAdapter(subscriptionUpgradePlan2.getBenefits()));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
    }

    /* access modifiers changed from: private */
    public final void showProgresses(boolean z11) {
        int i11;
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding = this.viewBinding;
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding2 = null;
        if (fragmentTproUpgradeDetailsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeDetailsBinding = null;
        }
        ProgressBar progressBar = fragmentTproUpgradeDetailsBinding.genericProgressBar;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding3 = this.viewBinding;
        if (fragmentTproUpgradeDetailsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproUpgradeDetailsBinding2 = fragmentTproUpgradeDetailsBinding3;
        }
        fragmentTproUpgradeDetailsBinding2.confirmUpgradeProLayout.setEnabled(!z11);
    }

    private final void trackUpgradeAttempted() {
        ISubscriptionsTracker subscriptionsTracker2 = getSubscriptionsTracker();
        SubscriptionUpgradePlan subscriptionUpgradePlan2 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
            subscriptionUpgradePlan2 = null;
        }
        subscriptionsTracker2.tProSubscriptionUpgradeAttempted("subscription", TProSubscriptionDetailsFragment.SUBSCRIPTION_SCREEN_NAME, subscriptionUpgradePlan2.getPlanId());
    }

    private final void trackUpgradeCompleted() {
        ISubscriptionsTracker subscriptionsTracker2 = getSubscriptionsTracker();
        SubscriptionUpgradePlan subscriptionUpgradePlan2 = this.subscriptionUpgradePlan;
        if (subscriptionUpgradePlan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscriptionUpgradePlan");
            subscriptionUpgradePlan2 = null;
        }
        subscriptionsTracker2.tProSubscriptionUpgradeCompleted("subscription", TProSubscriptionDetailsFragment.SUBSCRIPTION_SCREEN_NAME, subscriptionUpgradePlan2.getPlanId());
    }

    @NotNull
    public final ActivityResultLauncher<Intent> getLauncher() {
        return this.launcher;
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
    public final TproUpgradeDetailsViewModelFactory getViewModelFactory() {
        TproUpgradeDetailsViewModelFactory tproUpgradeDetailsViewModelFactory = this.viewModelFactory;
        if (tproUpgradeDetailsViewModelFactory != null) {
            return tproUpgradeDetailsViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        ResultHandler resultHandler2;
        Intrinsics.checkNotNullParameter(context, "context");
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        factory.create(requireActivity, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        if (context instanceof AppCompatActivity) {
            Fragment findFragmentByTag = ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(TProSubscriptionDetailsFragment.TAG);
            if (findFragmentByTag instanceof ResultHandler) {
                resultHandler2 = (ResultHandler) findFragmentByTag;
            } else {
                resultHandler2 = null;
            }
            this.resultHandler = resultHandler2;
        }
        super.onAttach(context);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproUpgradeDetailsBinding fragmentTproUpgradeDetailsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TproUpgradeDetailsBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TproUpgradeDetailsBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproUpgradeDetailsBinding inflate = FragmentTproUpgradeDetailsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproUpgradeDetailsBinding = inflate;
        }
        ConstraintLayout root = fragmentTproUpgradeDetailsBinding.getRoot();
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
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        removePadding();
        handleArguments();
        setUpObservers();
        setUpViews();
        addButtonsListeners();
    }

    public final void setSubscriptionsTracker(@NotNull ISubscriptionsTracker iSubscriptionsTracker) {
        Intrinsics.checkNotNullParameter(iSubscriptionsTracker, "<set-?>");
        this.subscriptionsTracker = iSubscriptionsTracker;
    }

    public final void setViewModelFactory(@NotNull TproUpgradeDetailsViewModelFactory tproUpgradeDetailsViewModelFactory) {
        Intrinsics.checkNotNullParameter(tproUpgradeDetailsViewModelFactory, "<set-?>");
        this.viewModelFactory = tproUpgradeDetailsViewModelFactory;
    }
}
