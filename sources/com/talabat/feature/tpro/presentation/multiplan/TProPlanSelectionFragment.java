package com.talabat.feature.tpro.presentation.multiplan;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
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
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsExperimentsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproPlanSelectionBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.model.TProMultiPlanDisplayModel;
import com.talabat.feature.tpro.presentation.model.TProPlanDisplayModel;
import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModel;
import com.talabat.feature.tpro.presentation.multiplan.viewmodel.TProPlanSelectionViewModelFactory;
import com.talabat.feature.tpro.presentation.payment.TProPaymentBottomSheetFragmentKt;
import com.talabat.feature.tpro.presentation.util.PlanSelectionScrollHeightHelper;
import ip.a;
import ip.b;
import ip.c;
import ip.d;
import ip.e;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u0001:\u00016B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0016J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\u000bH\u0002R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Lcom/talabat/feature/tpro/presentation/multiplan/TProPlanSelectionFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "multiPlan", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "isReactivate", "", "callback", "Lkotlin/Function1;", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;ZLkotlin/jvm/functions/Function1;)V", "currentSelection", "", "Ljava/lang/Integer;", "planItemViews", "", "Lcom/talabat/feature/tpro/presentation/multiplan/PlanSelectionItemView;", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproPlanSelectionBinding;", "viewModel", "Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/multiplan/viewmodel/TProPlanSelectionViewModelFactory;)V", "addPlanItemView", "itemView", "adjustPlanScrollContainerHeightIfRequired", "enableContinue", "isEnabled", "isFlutterPaymentWidgetExperimentEnabled", "observeDataUpdates", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "populateUI", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProPlanSelectionFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final Function1<TProPlanDisplayModel, Unit> callback;
    @Nullable
    private Integer currentSelection;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    private final boolean isReactivate;
    @NotNull
    private final TProMultiPlanDisplayModel multiPlan;
    @NotNull
    private final List<PlanSelectionItemView> planItemViews = new ArrayList();
    private FragmentTproPlanSelectionBinding viewBinding;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TProPlanSelectionViewModel.class), new TProPlanSelectionFragment$special$$inlined$viewModels$default$2(new TProPlanSelectionFragment$special$$inlined$viewModels$default$1(this)), new TProPlanSelectionFragment$viewModel$2(this));
    @Inject
    public TProPlanSelectionViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ2\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tpro/presentation/multiplan/TProPlanSelectionFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/multiplan/TProPlanSelectionFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "tProMultiPlan", "Lcom/talabat/feature/tpro/presentation/model/TProMultiPlanDisplayModel;", "isReactivate", "", "callback", "Lkotlin/Function1;", "Lcom/talabat/feature/tpro/presentation/model/TProPlanDisplayModel;", "", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TProPlanSelectionFragment getInstance(@NotNull DSBottomSheet dSBottomSheet, @NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, boolean z11, @NotNull Function1<? super TProPlanDisplayModel, Unit> function1) {
            Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
            Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "tProMultiPlan");
            Intrinsics.checkNotNullParameter(function1, "callback");
            return new TProPlanSelectionFragment(dSBottomSheet, tProMultiPlanDisplayModel, z11, function1);
        }

        @NotNull
        public final DSBottomSheet show(@NotNull FragmentActivity fragmentActivity, @NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, boolean z11, @NotNull Function1<? super TProPlanDisplayModel, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "tProMultiPlan");
            Intrinsics.checkNotNullParameter(function1, "callback");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TProPlanSelectionFragment.Companion.getInstance(dSBottomSheet, tProMultiPlanDisplayModel, z11, function1));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
            return dSBottomSheet;
        }
    }

    public TProPlanSelectionFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull TProMultiPlanDisplayModel tProMultiPlanDisplayModel, boolean z11, @NotNull Function1<? super TProPlanDisplayModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModel, "multiPlan");
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.dsBottomSheet = dSBottomSheet;
        this.multiPlan = tProMultiPlanDisplayModel;
        this.isReactivate = z11;
        this.callback = function1;
    }

    private final void addPlanItemView(PlanSelectionItemView planSelectionItemView) {
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = this.viewBinding;
        if (fragmentTproPlanSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding = null;
        }
        fragmentTproPlanSelectionBinding.plansContainer.addView(planSelectionItemView);
        this.planItemViews.add(planSelectionItemView);
    }

    private final void adjustPlanScrollContainerHeightIfRequired() {
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = this.viewBinding;
        if (fragmentTproPlanSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding = null;
        }
        fragmentTproPlanSelectionBinding.container.post(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: adjustPlanScrollContainerHeightIfRequired$lambda-8  reason: not valid java name */
    public static final void m10412adjustPlanScrollContainerHeightIfRequired$lambda8(TProPlanSelectionFragment tProPlanSelectionFragment) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tProPlanSelectionFragment, "this$0");
        int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = tProPlanSelectionFragment.viewBinding;
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding2 = null;
        if (fragmentTproPlanSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding = null;
        }
        int measuredHeight = fragmentTproPlanSelectionBinding.container.getMeasuredHeight();
        PlanSelectionScrollHeightHelper planSelectionScrollHeightHelper = PlanSelectionScrollHeightHelper.INSTANCE;
        if (planSelectionScrollHeightHelper.isFullScreenContent(i11, measuredHeight)) {
            FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding3 = tProPlanSelectionFragment.viewBinding;
            if (fragmentTproPlanSelectionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPlanSelectionBinding3 = null;
            }
            ViewGroup.LayoutParams layoutParams = fragmentTproPlanSelectionBinding3.plansScrollContainer.getLayoutParams();
            FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding4 = tProPlanSelectionFragment.viewBinding;
            if (fragmentTproPlanSelectionBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPlanSelectionBinding4 = null;
            }
            LinearLayout linearLayout = fragmentTproPlanSelectionBinding4.multiplanFreeTrialInfo;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.multiplanFreeTrialInfo");
            if (linearLayout.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            layoutParams.height = planSelectionScrollHeightHelper.getAdjustedScrollHeight(i11, z11);
            FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding5 = tProPlanSelectionFragment.viewBinding;
            if (fragmentTproPlanSelectionBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentTproPlanSelectionBinding2 = fragmentTproPlanSelectionBinding5;
            }
            fragmentTproPlanSelectionBinding2.plansScrollContainer.setLayoutParams(layoutParams);
        }
    }

    private final void enableContinue(boolean z11) {
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = this.viewBinding;
        if (fragmentTproPlanSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding = null;
        }
        fragmentTproPlanSelectionBinding.btnContinue.setEnabled(z11);
    }

    private final TProPlanSelectionViewModel getViewModel() {
        return (TProPlanSelectionViewModel) this.viewModel$delegate.getValue();
    }

    private final boolean isFlutterPaymentWidgetExperimentEnabled() {
        return Intrinsics.areEqual((Object) TalabatExperiment.INSTANCE.getStringVariant(EcosystemsExperimentsKeys.TPRO_FLUTTER_PAYMENT_WIDGET, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Variation1");
    }

    private final void observeDataUpdates() {
        getViewModel().getSelectedItem().observe(getViewLifecycleOwner(), new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observeDataUpdates$lambda-7  reason: not valid java name */
    public static final void m10413observeDataUpdates$lambda7(TProPlanSelectionFragment tProPlanSelectionFragment, Integer num) {
        boolean z11;
        Intrinsics.checkNotNullParameter(tProPlanSelectionFragment, "this$0");
        if (num != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        tProPlanSelectionFragment.enableContinue(z11);
        Integer num2 = tProPlanSelectionFragment.currentSelection;
        if (num2 != null) {
            tProPlanSelectionFragment.planItemViews.get(num2.intValue()).setSelected(false);
        }
        if (num != null) {
            tProPlanSelectionFragment.planItemViews.get(num.intValue()).setSelected(true);
            if (!Intrinsics.areEqual((Object) tProPlanSelectionFragment.currentSelection, (Object) num)) {
                tProPlanSelectionFragment.getViewModel().tProPlanChanged();
            }
        }
        tProPlanSelectionFragment.currentSelection = num;
    }

    private final void populateUI() {
        boolean z11;
        this.planItemViews.clear();
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = this.viewBinding;
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding2 = null;
        if (fragmentTproPlanSelectionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding = null;
        }
        fragmentTproPlanSelectionBinding.plansContainer.removeAllViews();
        int i11 = 0;
        int i12 = 0;
        for (Object next : this.multiPlan.getPlans()) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            LayoutInflater layoutInflater = getLayoutInflater();
            Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
            PlanSelectionItemView planSelectionItemView = new PlanSelectionItemView(requireContext, layoutInflater, (TProPlanDisplayModel) next);
            planSelectionItemView.setOnClickListener(new b(this, i12));
            addPlanItemView(planSelectionItemView);
            i12 = i13;
        }
        if (this.multiPlan.getFreeTrialTitle().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding3 = this.viewBinding;
            if (fragmentTproPlanSelectionBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproPlanSelectionBinding3 = null;
            }
            fragmentTproPlanSelectionBinding3.txtFreeTrial.setText(this.multiPlan.getFreeTrialTitle());
        }
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding4 = this.viewBinding;
        if (fragmentTproPlanSelectionBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding4 = null;
        }
        LinearLayout linearLayout = fragmentTproPlanSelectionBinding4.multiplanFreeTrialInfo;
        if (!this.multiPlan.getFreeTrialEligible()) {
            i11 = 8;
        }
        linearLayout.setVisibility(i11);
        adjustPlanScrollContainerHeightIfRequired();
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding5 = this.viewBinding;
        if (fragmentTproPlanSelectionBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproPlanSelectionBinding5 = null;
        }
        fragmentTproPlanSelectionBinding5.btnContinue.setOnClickListener(new c(this));
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding6 = this.viewBinding;
        if (fragmentTproPlanSelectionBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPlanSelectionBinding2 = fragmentTproPlanSelectionBinding6;
        }
        fragmentTproPlanSelectionBinding2.cancelButton.setOnClickListener(new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: populateUI$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10414populateUI$lambda1$lambda0(TProPlanSelectionFragment tProPlanSelectionFragment, int i11, View view) {
        Intrinsics.checkNotNullParameter(tProPlanSelectionFragment, "this$0");
        tProPlanSelectionFragment.getViewModel().setSelectedIndex(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: populateUI$lambda-3  reason: not valid java name */
    public static final void m10415populateUI$lambda3(TProPlanSelectionFragment tProPlanSelectionFragment, View view) {
        Intrinsics.checkNotNullParameter(tProPlanSelectionFragment, "this$0");
        TProPlanDisplayModel selectedPlan = tProPlanSelectionFragment.getViewModel().getSelectedPlan();
        if (selectedPlan != null) {
            tProPlanSelectionFragment.dsBottomSheet.dismiss();
            if (tProPlanSelectionFragment.isFlutterPaymentWidgetExperimentEnabled()) {
                tProPlanSelectionFragment.callback.invoke(selectedPlan);
                return;
            }
            FragmentActivity requireActivity = tProPlanSelectionFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            TProPaymentBottomSheetFragmentKt.showPaymentBottomSheet$default(requireActivity, selectedPlan, tProPlanSelectionFragment.isReactivate, (String) null, 8, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: populateUI$lambda-4  reason: not valid java name */
    public static final void m10416populateUI$lambda4(TProPlanSelectionFragment tProPlanSelectionFragment, View view) {
        Intrinsics.checkNotNullParameter(tProPlanSelectionFragment, "this$0");
        tProPlanSelectionFragment.dsBottomSheet.dismiss();
    }

    @NotNull
    public final TProPlanSelectionViewModelFactory getViewModelFactory() {
        TProPlanSelectionViewModelFactory tProPlanSelectionViewModelFactory = this.viewModelFactory;
        if (tProPlanSelectionViewModelFactory != null) {
            return tProPlanSelectionViewModelFactory;
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
        FragmentTproPlanSelectionBinding fragmentTproPlanSelectionBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TProPlanSelectionFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TProPlanSelectionFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproPlanSelectionBinding inflate = FragmentTproPlanSelectionBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproPlanSelectionBinding = inflate;
        }
        ConstraintLayout root = fragmentTproPlanSelectionBinding.getRoot();
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
        getViewModel().setTProPlans(this.multiPlan.getPlans());
        populateUI();
        observeDataUpdates();
    }

    public final void setViewModelFactory(@NotNull TProPlanSelectionViewModelFactory tProPlanSelectionViewModelFactory) {
        Intrinsics.checkNotNullParameter(tProPlanSelectionViewModelFactory, "<set-?>");
        this.viewModelFactory = tProPlanSelectionViewModelFactory;
    }
}
