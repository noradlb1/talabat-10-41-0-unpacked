package com.talabat.feature.tpro.presentation.management.cancellation.deactivate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import ap.c;
import ap.d;
import ap.e;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.databinding.FragmentDeactivateAutoUpgradeBinding;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import com.talabat.localization.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/DeactivateAutoUpgradeBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onTurnOffAutoUpgrade", "Lkotlin/Function0;", "", "continueWithProPlan", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentDeactivateAutoUpgradeBinding;", "addButtonsListeners", "dismiss", "getRemainingDaysLabel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeactivateAutoUpgradeBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final Function0<Unit> continueWithProPlan;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final Function0<Unit> onTurnOffAutoUpgrade;
    @NotNull
    private final Subscription subscription;
    private FragmentDeactivateAutoUpgradeBinding viewBinding;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J2\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/DeactivateAutoUpgradeBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/DeactivateAutoUpgradeBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onTurnOffAutoUpgrade", "Lkotlin/Function0;", "", "continueWithProPlan", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final DeactivateAutoUpgradeBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription, Function0<Unit> function0, Function0<Unit> function02) {
            return new DeactivateAutoUpgradeBottomSheetFragment(dSBottomSheet, subscription, function0, function02);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            Intrinsics.checkNotNullParameter(function0, "onTurnOffAutoUpgrade");
            Intrinsics.checkNotNullParameter(function02, "continueWithProPlan");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(DeactivateAutoUpgradeBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription, function0, function02));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public DeactivateAutoUpgradeBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onTurnOffAutoUpgrade");
        Intrinsics.checkNotNullParameter(function02, "continueWithProPlan");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
        this.onTurnOffAutoUpgrade = function0;
        this.continueWithProPlan = function02;
    }

    private final void addButtonsListeners() {
        FragmentDeactivateAutoUpgradeBinding fragmentDeactivateAutoUpgradeBinding = this.viewBinding;
        if (fragmentDeactivateAutoUpgradeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentDeactivateAutoUpgradeBinding = null;
        }
        fragmentDeactivateAutoUpgradeBinding.cancelButton.setOnClickListener(new c(this));
        fragmentDeactivateAutoUpgradeBinding.deactivateAutoUpgradeLayout.setOnClickListener(new d(this));
        fragmentDeactivateAutoUpgradeBinding.keepProLayout.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-4$lambda-1  reason: not valid java name */
    public static final void m10384addButtonsListeners$lambda4$lambda1(DeactivateAutoUpgradeBottomSheetFragment deactivateAutoUpgradeBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(deactivateAutoUpgradeBottomSheetFragment, "this$0");
        deactivateAutoUpgradeBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-4$lambda-2  reason: not valid java name */
    public static final void m10385addButtonsListeners$lambda4$lambda2(DeactivateAutoUpgradeBottomSheetFragment deactivateAutoUpgradeBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(deactivateAutoUpgradeBottomSheetFragment, "this$0");
        deactivateAutoUpgradeBottomSheetFragment.dismiss();
        deactivateAutoUpgradeBottomSheetFragment.onTurnOffAutoUpgrade.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-4$lambda-3  reason: not valid java name */
    public static final void m10386addButtonsListeners$lambda4$lambda3(DeactivateAutoUpgradeBottomSheetFragment deactivateAutoUpgradeBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(deactivateAutoUpgradeBottomSheetFragment, "this$0");
        deactivateAutoUpgradeBottomSheetFragment.continueWithProPlan.invoke();
    }

    private final void dismiss() {
        this.dsBottomSheet.dismiss();
    }

    private final String getRemainingDaysLabel() {
        int i11;
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(DateAndTimeUtill.INSTANCE.getRemainingDaysForDate(this.subscription.getNextBillingDate()), 1);
        if (coerceAtLeast > 1) {
            i11 = R.string.tpro_days;
        } else {
            i11 = R.string.tpro_day;
        }
        String string = getString(i11);
        return coerceAtLeast + " " + string;
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(com.designsystem.marshmallow.R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setUpViews() {
        FragmentDeactivateAutoUpgradeBinding fragmentDeactivateAutoUpgradeBinding = this.viewBinding;
        if (fragmentDeactivateAutoUpgradeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentDeactivateAutoUpgradeBinding = null;
        }
        fragmentDeactivateAutoUpgradeBinding.cancelTrialSubtitle.setText(getString(R.string.deactivate_auto_upgrade_subtitle, Customer.getInstance().getCustomerInfo().getFistName(), getRemainingDaysLabel()));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentDeactivateAutoUpgradeBinding fragmentDeactivateAutoUpgradeBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "DeactivateAutoUpgradeBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "DeactivateAutoUpgradeBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentDeactivateAutoUpgradeBinding inflate = FragmentDeactivateAutoUpgradeBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentDeactivateAutoUpgradeBinding = inflate;
        }
        ConstraintLayout root = fragmentDeactivateAutoUpgradeBinding.getRoot();
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
        setUpViews();
        addButtonsListeners();
    }
}
