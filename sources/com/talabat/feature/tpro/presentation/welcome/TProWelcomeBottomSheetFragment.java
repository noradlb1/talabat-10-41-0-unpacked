package com.talabat.feature.tpro.presentation.welcome;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
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
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.restaurant.RestaurantsListScreen;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPlanCategory;
import com.talabat.feature.subscriptions.domain.model.SubscriptionRenewType;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproWelcomeBottomSheetBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import np.a;
import np.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001'B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010%\u001a\u00020\u0016H\u0002J\b\u0010&\u001a\u00020\u0016H\u0002R\u000e\u0010\u000b\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/talabat/feature/tpro/presentation/welcome/TProWelcomeBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "freeCoffeeText", "", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "comingFromBenefits", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Ljava/lang/String;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Ljava/lang/Boolean;)V", "TPRO_PLAN_MODEL_KEY", "Ljava/lang/Boolean;", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproWelcomeBottomSheetBinding;", "addButtonsListener", "", "applyBrand", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "showButtons", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProWelcomeBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXTRA_IS_COFFEE_MODE = "isCoffeeMode";
    @NotNull
    public static final String TAG = "TProWelcomeBottomSheetFragment";
    /* access modifiers changed from: private */
    @NotNull
    public final String TPRO_PLAN_MODEL_KEY;
    public Trace _nr_trace;
    @Nullable
    private final Boolean comingFromBenefits;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final String freeCoffeeText;
    @Inject
    public Navigator navigator;
    @Nullable
    private final Subscription subscription;
    private FragmentTproWelcomeBottomSheetBinding viewBinding;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J \u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/tpro/presentation/welcome/TProWelcomeBottomSheetFragment$Companion;", "", "()V", "EXTRA_IS_COFFEE_MODE", "", "TAG", "getInstance", "Lcom/talabat/feature/tpro/presentation/welcome/TProWelcomeBottomSheetFragment;", "tproPlan", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "freeCoffeeText", "getInstanceForShahid", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "comingFromBenefits", "", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "showForShahid", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TProWelcomeBottomSheetFragment getInstanceForShahid(DSBottomSheet dSBottomSheet, Subscription subscription, boolean z11) {
            return new TProWelcomeBottomSheetFragment(dSBottomSheet, "", subscription, Boolean.valueOf(z11));
        }

        @NotNull
        public final TProWelcomeBottomSheetFragment getInstance(@NotNull TProPlanDisplayModel tProPlanDisplayModel, @NotNull DSBottomSheet dSBottomSheet, @NotNull String str) {
            Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "tproPlan");
            Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
            Intrinsics.checkNotNullParameter(str, "freeCoffeeText");
            TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment = new TProWelcomeBottomSheetFragment(dSBottomSheet, str, (Subscription) null, (Boolean) null, 12, (DefaultConstructorMarker) null);
            Bundle bundle = new Bundle();
            bundle.putParcelable(tProWelcomeBottomSheetFragment.TPRO_PLAN_MODEL_KEY, tProPlanDisplayModel);
            tProWelcomeBottomSheetFragment.setArguments(bundle);
            return tProWelcomeBottomSheetFragment;
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull TProPlanDisplayModel tProPlanDisplayModel, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(tProPlanDisplayModel, "tproPlan");
            Intrinsics.checkNotNullParameter(str, "freeCoffeeText");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TProWelcomeBottomSheetFragment.Companion.getInstance(tProPlanDisplayModel, dSBottomSheet, str));
            dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TProWelcomeBottomSheetFragment.TAG);
        }

        public final void showForShahid(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, boolean z11) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TProWelcomeBottomSheetFragment.Companion.getInstanceForShahid(dSBottomSheet, subscription, z11));
            dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TProWelcomeBottomSheetFragment.TAG);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProWelcomeBottomSheetFragment(DSBottomSheet dSBottomSheet, String str, Subscription subscription2, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(dSBottomSheet, str, (i11 & 4) != 0 ? null : subscription2, (i11 & 8) != 0 ? null : bool);
    }

    private final void addButtonsListener() {
        FragmentTproWelcomeBottomSheetBinding fragmentTproWelcomeBottomSheetBinding = this.viewBinding;
        if (fragmentTproWelcomeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproWelcomeBottomSheetBinding = null;
        }
        fragmentTproWelcomeBottomSheetBinding.seeRestaurantsLayout.setOnClickListener(new a(this));
        fragmentTproWelcomeBottomSheetBinding.cancelButton.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListener$lambda-5$lambda-3  reason: not valid java name */
    public static final void m10429addButtonsListener$lambda5$lambda3(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProWelcomeBottomSheetFragment, "this$0");
        tProWelcomeBottomSheetFragment.dsBottomSheet.dismiss();
        Navigator navigator2 = tProWelcomeBottomSheetFragment.getNavigator();
        FragmentActivity requireActivity = tProWelcomeBottomSheetFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Navigator.DefaultImpls.navigateTo$default(navigator2, requireActivity, new RestaurantsListScreen((Void) null, 1, (DefaultConstructorMarker) null), (Function1) null, 4, (Object) null);
        tProWelcomeBottomSheetFragment.requireActivity().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListener$lambda-5$lambda-4  reason: not valid java name */
    public static final void m10430addButtonsListener$lambda5$lambda4(TProWelcomeBottomSheetFragment tProWelcomeBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tProWelcomeBottomSheetFragment, "this$0");
        tProWelcomeBottomSheetFragment.dsBottomSheet.dismiss();
    }

    private final void applyBrand() {
        FragmentTproWelcomeBottomSheetBinding fragmentTproWelcomeBottomSheetBinding = this.viewBinding;
        if (fragmentTproWelcomeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproWelcomeBottomSheetBinding = null;
        }
        fragmentTproWelcomeBottomSheetBinding.ibProRestaurants.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_talabat_pro_eye_blue, 0, 0, 0);
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(com.designsystem.marshmallow.R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void showButtons() {
        FragmentTproWelcomeBottomSheetBinding fragmentTproWelcomeBottomSheetBinding = this.viewBinding;
        if (fragmentTproWelcomeBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproWelcomeBottomSheetBinding = null;
        }
        fragmentTproWelcomeBottomSheetBinding.seeRestaurantsLayout.setVisibility(0);
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
        FragmentTproWelcomeBottomSheetBinding fragmentTproWelcomeBottomSheetBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProWelcomeBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProWelcomeBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproWelcomeBottomSheetBinding inflate = FragmentTproWelcomeBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproWelcomeBottomSheetBinding = inflate;
        }
        ConstraintLayout root = fragmentTproWelcomeBottomSheetBinding.getRoot();
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
        SubscriptionPlanCategory subscriptionPlanCategory;
        boolean z11;
        SubscriptionRenewType subscriptionRenewType;
        boolean z12;
        boolean z13;
        String str;
        LocalDateTime endDate;
        SubscriptionPlan plan;
        SubscriptionPlan plan2;
        SubscriptionPlan plan3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(EcosystemsFeatureFlagsKeys.IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED, false, TalabatExperimentDataSourceStrategy.FWF);
        Subscription subscription2 = this.subscription;
        Integer num = null;
        if (subscription2 == null || (plan3 = subscription2.getPlan()) == null) {
            subscriptionPlanCategory = null;
        } else {
            subscriptionPlanCategory = plan3.getCategory();
        }
        if (subscriptionPlanCategory == SubscriptionPlanCategory.B2B) {
            z11 = true;
        } else {
            z11 = false;
        }
        Subscription subscription3 = this.subscription;
        if (subscription3 == null || (plan2 = subscription3.getPlan()) == null) {
            subscriptionRenewType = null;
        } else {
            subscriptionRenewType = plan2.getRenewType();
        }
        if (subscriptionRenewType == SubscriptionRenewType.Renewable) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 || !z12 || !booleanVariant) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z13) {
            FragmentTproWelcomeBottomSheetBinding fragmentTproWelcomeBottomSheetBinding = this.viewBinding;
            if (fragmentTproWelcomeBottomSheetBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproWelcomeBottomSheetBinding = null;
            }
            Boolean bool = this.comingFromBenefits;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual((Object) bool, (Object) bool2)) {
                fragmentTproWelcomeBottomSheetBinding.tvWelcomeHeader.setText(getString(com.talabat.localization.R.string.joined_pro_lite_title, Customer.getInstance().getCustomerInfo().getFistName()));
                TextView textView = fragmentTproWelcomeBottomSheetBinding.tvWelcomeDescription;
                int i11 = com.talabat.localization.R.string.joined_pro_lite_description;
                Object[] objArr = new Object[1];
                DateUtils.Companion companion = DateUtils.Companion;
                Subscription subscription4 = this.subscription;
                if (!(subscription4 == null || (plan = subscription4.getPlan()) == null)) {
                    num = Integer.valueOf(plan.getDurationDays());
                }
                Intrinsics.checkNotNull(num);
                objArr[0] = companion.getLocalizedFormattedDateAfterDurationDays(num.intValue());
                textView.setText(getString(i11, objArr));
            } else {
                fragmentTproWelcomeBottomSheetBinding.tvWelcomeHeader.setText(getString(com.talabat.localization.R.string.you_are_pro_text, Customer.getInstance().getCustomerInfo().getFistName()));
                Subscription subscription5 = this.subscription;
                if (!(subscription5 == null || (endDate = subscription5.getEndDate()) == null)) {
                    DateUtils.Companion companion2 = DateUtils.Companion;
                    String format = endDate.format(DateTimeFormatter.ISO_DATE_TIME);
                    Intrinsics.checkNotNullExpressionValue(format, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
                    fragmentTproWelcomeBottomSheetBinding.tvWelcomeDescription.setText(getString(com.talabat.localization.R.string.full_pro_benefits_description_text, companion2.getLocalizedFormattedDateString(format, "dd LLLL yyyy")));
                }
            }
            fragmentTproWelcomeBottomSheetBinding.ibProRestaurants.setText(getString(com.talabat.localization.R.string.full_pro_benefits_pro_label_text));
            TextView textView2 = fragmentTproWelcomeBottomSheetBinding.actionButtonText;
            if (Intrinsics.areEqual((Object) this.comingFromBenefits, (Object) bool2)) {
                str = getString(com.talabat.localization.R.string.tpro_explore_benefits);
            } else {
                str = getString(com.talabat.localization.R.string.got_it_text);
            }
            textView2.setText(str);
        }
        addButtonsListener();
        showButtons();
        applyBrand();
        removePadding();
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public TProWelcomeBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull String str, @Nullable Subscription subscription2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(str, "freeCoffeeText");
        this.dsBottomSheet = dSBottomSheet;
        this.freeCoffeeText = str;
        this.subscription = subscription2;
        this.comingFromBenefits = bool;
        this.TPRO_PLAN_MODEL_KEY = "TPRO_PLAN";
    }
}
