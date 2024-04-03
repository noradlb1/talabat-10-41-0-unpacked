package com.talabat.feature.tpro.presentation.management.cancellation.reason;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.materialedittext.MaterialEditText;
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
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationReason;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproCancellationReasonBottomSheetBinding;
import com.talabat.feature.tpro.presentation.di.DaggerTproPresentationComponent;
import com.talabat.feature.tpro.presentation.di.TproPresentationComponent;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModel;
import com.talabat.feature.tpro.presentation.management.cancellation.reason.viewModel.SubscriptionCancellationReasonsViewModelFactory;
import com.talabat.feature.tpro.presentation.management.details.TProSubscriptionDetailsFragment;
import com.talabat.feature.tpro.presentation.util.CancellationReasonScrollHeightHelper;
import com.talabat.talabatlife.features.UrlConstantsKt;
import cp.a;
import cp.b;
import cp.c;
import cp.d;
import cp.e;
import cp.f;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0018\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\b\u0010)\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0016J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u001a\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0016\u00107\u001a\u00020\u001e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020%09H\u0002J\b\u0010:\u001a\u00020\u001eH\u0002J\b\u0010;\u001a\u00020\u001eH\u0002J\u0017\u0010<\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u001eH\u0002J\u0010\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020 H\u0002J\u0010\u0010B\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020 H\u0002J\u0010\u0010C\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020 H\u0002R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006F"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "membershipId", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Ljava/lang/String;)V", "currentSelection", "", "Ljava/lang/Integer;", "mSubscriptionCancellationReasonBottomSheetInterface", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment$SubscriptionCancellationReasonBottomSheetInterface;", "reasonItemViews", "", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/CancellationReasonItemView;", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproCancellationReasonBottomSheetBinding;", "viewModel", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModel;", "getViewModel", "()Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModelFactory;", "getViewModelFactory", "()Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModelFactory;", "setViewModelFactory", "(Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/viewModel/SubscriptionCancellationReasonsViewModelFactory;)V", "activateSubmit", "", "isEnabled", "", "addButtonsListeners", "addCancellationReasonItemView", "index", "item", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionCancellationReason;", "adjustScrollViewHeightIfRequired", "dismiss", "loadReasons", "observeDataUpdates", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "populate", "reasons", "", "removeAllViews", "removePadding", "selectedReasonChanged", "selectedIndex", "(Ljava/lang/Integer;)V", "setHeaderText", "showOtherInput", "shouldShow", "showProgressBar", "showSubmitProgressBar", "Companion", "SubscriptionCancellationReasonBottomSheetInterface", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionCancellationReasonBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @Nullable
    private Integer currentSelection;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    @Nullable
    public SubscriptionCancellationReasonBottomSheetInterface mSubscriptionCancellationReasonBottomSheetInterface;
    @NotNull
    private final String membershipId;
    @NotNull
    private final List<CancellationReasonItemView> reasonItemViews = new ArrayList();
    private FragmentTproCancellationReasonBottomSheetBinding viewBinding;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(SubscriptionCancellationReasonsViewModel.class), new SubscriptionCancellationReasonBottomSheetFragment$special$$inlined$viewModels$default$2(new SubscriptionCancellationReasonBottomSheetFragment$special$$inlined$viewModels$default$1(this)), new SubscriptionCancellationReasonBottomSheetFragment$viewModel$2(this));
    @Inject
    public SubscriptionCancellationReasonsViewModelFactory viewModelFactory;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "membershipId", "", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SubscriptionCancellationReasonBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, String str) {
            return new SubscriptionCancellationReasonBottomSheetFragment(dSBottomSheet, str);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull String str) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(SubscriptionCancellationReasonBottomSheetFragment.Companion.getInstance(dSBottomSheet, str));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/reason/SubscriptionCancellationReasonBottomSheetFragment$SubscriptionCancellationReasonBottomSheetInterface;", "", "onReasonSubmitSuccess", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface SubscriptionCancellationReasonBottomSheetInterface {
        void onReasonSubmitSuccess();
    }

    public SubscriptionCancellationReasonBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull String str) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        this.dsBottomSheet = dSBottomSheet;
        this.membershipId = str;
    }

    private final void activateSubmit(boolean z11) {
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.btnReasonSubmit.setEnabled(z11);
    }

    private final void addButtonsListeners() {
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.btnReasonSubmit.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-6$lambda-5  reason: not valid java name */
    public static final void m10394addButtonsListeners$lambda6$lambda5(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonBottomSheetFragment, "this$0");
        subscriptionCancellationReasonBottomSheetFragment.showSubmitProgressBar(true);
        SubscriptionCancellationReasonsViewModel viewModel = subscriptionCancellationReasonBottomSheetFragment.getViewModel();
        String str = subscriptionCancellationReasonBottomSheetFragment.membershipId;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = subscriptionCancellationReasonBottomSheetFragment.viewBinding;
        String str2 = null;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        Editable text = fragmentTproCancellationReasonBottomSheetBinding.etCancellationReasonOther.getText();
        if (text != null) {
            str2 = text.toString();
        }
        if (str2 == null) {
            str2 = "";
        }
        viewModel.sendCancellationReason(str, str2, new SubscriptionCancellationReasonBottomSheetFragment$addButtonsListeners$1$1$1(subscriptionCancellationReasonBottomSheetFragment));
    }

    private final void addCancellationReasonItemView(int i11, SubscriptionCancellationReason subscriptionCancellationReason) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "layoutInflater");
        CancellationReasonItemView cancellationReasonItemView = new CancellationReasonItemView(requireContext, layoutInflater, subscriptionCancellationReason);
        cancellationReasonItemView.setOnClickListener(new d(this, i11));
        this.reasonItemViews.add(cancellationReasonItemView);
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.reasonsContainer.addView(cancellationReasonItemView);
    }

    /* access modifiers changed from: private */
    /* renamed from: addCancellationReasonItemView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10395addCancellationReasonItemView$lambda4$lambda3(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment, int i11, View view) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonBottomSheetFragment, "this$0");
        subscriptionCancellationReasonBottomSheetFragment.getViewModel().setSelectedIndex(i11);
    }

    private final void adjustScrollViewHeightIfRequired() {
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.container.post(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: adjustScrollViewHeightIfRequired$lambda-10  reason: not valid java name */
    public static final void m10396adjustScrollViewHeightIfRequired$lambda10(SubscriptionCancellationReasonBottomSheetFragment subscriptionCancellationReasonBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonBottomSheetFragment, "this$0");
        int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = subscriptionCancellationReasonBottomSheetFragment.viewBinding;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding2 = null;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        int measuredHeight = fragmentTproCancellationReasonBottomSheetBinding.container.getMeasuredHeight();
        CancellationReasonScrollHeightHelper cancellationReasonScrollHeightHelper = CancellationReasonScrollHeightHelper.INSTANCE;
        if (cancellationReasonScrollHeightHelper.isFullScreenContent(i11, measuredHeight)) {
            FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding3 = subscriptionCancellationReasonBottomSheetFragment.viewBinding;
            if (fragmentTproCancellationReasonBottomSheetBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproCancellationReasonBottomSheetBinding3 = null;
            }
            ViewGroup.LayoutParams layoutParams = fragmentTproCancellationReasonBottomSheetBinding3.reasonsScrollContainer.getLayoutParams();
            layoutParams.height = cancellationReasonScrollHeightHelper.getAdjustedScrollHeight(i11);
            FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding4 = subscriptionCancellationReasonBottomSheetFragment.viewBinding;
            if (fragmentTproCancellationReasonBottomSheetBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
                fragmentTproCancellationReasonBottomSheetBinding4 = null;
            }
            fragmentTproCancellationReasonBottomSheetBinding4.reasonsScrollContainer.setLayoutParams(layoutParams);
        }
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding5 = subscriptionCancellationReasonBottomSheetFragment.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproCancellationReasonBottomSheetBinding2 = fragmentTproCancellationReasonBottomSheetBinding5;
        }
        fragmentTproCancellationReasonBottomSheetBinding2.reasonsScrollContainer.fullScroll(130);
    }

    /* access modifiers changed from: private */
    public final void dismiss() {
        this.dsBottomSheet.dismiss();
    }

    private final SubscriptionCancellationReasonsViewModel getViewModel() {
        return (SubscriptionCancellationReasonsViewModel) this.viewModel$delegate.getValue();
    }

    private final void loadReasons() {
        showProgressBar(true);
        getViewModel().loadReasons();
    }

    private final void observeDataUpdates() {
        getViewModel().getReasonsData().observe(getViewLifecycleOwner(), new a(this));
        getViewModel().getSelectedItem().observe(getViewLifecycleOwner(), new b(this));
        getViewModel().getShowOtherInput().observe(getViewLifecycleOwner(), new c(this));
    }

    /* access modifiers changed from: private */
    public final void populate(List<SubscriptionCancellationReason> list) {
        int i11 = 0;
        showProgressBar(false);
        removeAllViews();
        for (Object next : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            addCancellationReasonItemView(i11, (SubscriptionCancellationReason) next);
            i11 = i12;
        }
    }

    private final void removeAllViews() {
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.reasonsContainer.removeAllViews();
        this.reasonItemViews.clear();
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public final void selectedReasonChanged(Integer num) {
        boolean z11;
        if (num != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        activateSubmit(z11);
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = this.currentSelection;
            if (num2 != null) {
                this.reasonItemViews.get(num2.intValue()).setSelected(false);
            }
            this.reasonItemViews.get(intValue).setSelected(true);
            this.currentSelection = Integer.valueOf(intValue);
        }
    }

    private final void setHeaderText() {
        String string = getResources().getString(com.talabat.localization.R.string.tpro_sad_to_see_you_go, new Object[]{Customer.getInstance().getCustomerInfo().getFistName()});
        Intrinsics.checkNotNullExpressionValue(string, "resources\n            .g…fo.fistName\n            )");
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        fragmentTproCancellationReasonBottomSheetBinding.tvReasonHeader.setText(string);
    }

    /* access modifiers changed from: private */
    public final void showOtherInput(boolean z11) {
        int i11;
        Editable text;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        MaterialEditText materialEditText = fragmentTproCancellationReasonBottomSheetBinding.etCancellationReasonOther;
        Intrinsics.checkNotNullExpressionValue(materialEditText, "");
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        materialEditText.setVisibility(i11);
        if (!z11 && (text = materialEditText.getText()) != null) {
            text.clear();
        }
        adjustScrollViewHeightIfRequired();
    }

    private final void showProgressBar(boolean z11) {
        int i11;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        ProgressBar progressBar = fragmentTproCancellationReasonBottomSheetBinding.pbReasons;
        Intrinsics.checkNotNullExpressionValue(progressBar, "pbReasons");
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        NestedScrollView nestedScrollView = fragmentTproCancellationReasonBottomSheetBinding.reasonsScrollContainer;
        if (z11) {
            i12 = 4;
        }
        nestedScrollView.setVisibility(i12);
    }

    private final void showSubmitProgressBar(boolean z11) {
        int i11;
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = this.viewBinding;
        if (fragmentTproCancellationReasonBottomSheetBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproCancellationReasonBottomSheetBinding = null;
        }
        ProgressBar progressBar = fragmentTproCancellationReasonBottomSheetBinding.pbSendingFeedback;
        Intrinsics.checkNotNullExpressionValue(progressBar, "pbSendingFeedback");
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        LinearLayout linearLayout = fragmentTproCancellationReasonBottomSheetBinding.btnReasonSubmit;
        if (z11) {
            i12 = 4;
        }
        linearLayout.setVisibility(i12);
    }

    @NotNull
    public final SubscriptionCancellationReasonsViewModelFactory getViewModelFactory() {
        SubscriptionCancellationReasonsViewModelFactory subscriptionCancellationReasonsViewModelFactory = this.viewModelFactory;
        if (subscriptionCancellationReasonsViewModelFactory != null) {
            return subscriptionCancellationReasonsViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        SubscriptionCancellationReasonBottomSheetInterface subscriptionCancellationReasonBottomSheetInterface;
        Intrinsics.checkNotNullParameter(context, "context");
        TproPresentationComponent.Factory factory = DaggerTproPresentationComponent.factory();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        factory.create(requireActivity, (ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ObservabilityCoreLibApi.class)).inject(this);
        super.onAttach(context);
        if (context instanceof AppCompatActivity) {
            Fragment findFragmentByTag = ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(TProSubscriptionDetailsFragment.TAG);
            if (findFragmentByTag instanceof SubscriptionCancellationReasonBottomSheetInterface) {
                subscriptionCancellationReasonBottomSheetInterface = (SubscriptionCancellationReasonBottomSheetInterface) findFragmentByTag;
            } else {
                subscriptionCancellationReasonBottomSheetInterface = null;
            }
            this.mSubscriptionCancellationReasonBottomSheetInterface = subscriptionCancellationReasonBottomSheetInterface;
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproCancellationReasonBottomSheetBinding fragmentTproCancellationReasonBottomSheetBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "SubscriptionCancellationReasonBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SubscriptionCancellationReasonBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproCancellationReasonBottomSheetBinding inflate = FragmentTproCancellationReasonBottomSheetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproCancellationReasonBottomSheetBinding = inflate;
        }
        ConstraintLayout root = fragmentTproCancellationReasonBottomSheetBinding.getRoot();
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
        loadReasons();
        removePadding();
        addButtonsListeners();
        observeDataUpdates();
        setHeaderText();
    }

    public final void setViewModelFactory(@NotNull SubscriptionCancellationReasonsViewModelFactory subscriptionCancellationReasonsViewModelFactory) {
        Intrinsics.checkNotNullParameter(subscriptionCancellationReasonsViewModelFactory, "<set-?>");
        this.viewModelFactory = subscriptionCancellationReasonsViewModelFactory;
    }
}
