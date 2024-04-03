package com.talabat.feature.tpro.presentation.management.cancellation.freeTrial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bp.a;
import bp.b;
import bp.c;
import buisnessmodels.Customer;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.databinding.FragmentCancelFreeTrialBinding;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import com.talabat.localization.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/CancelFreeTrialBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onCancelTrialClick", "Lkotlin/Function0;", "", "onKeepBenefitsClick", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentCancelFreeTrialBinding;", "addButtonsListeners", "addDismissListener", "dismiss", "getRemainingDaysLabel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancelFreeTrialBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    public boolean isAbortCancellation = true;
    @NotNull
    private final Function0<Unit> onCancelTrialClick;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Boolean, Unit> onDismissed;
    @NotNull
    private final Function0<Unit> onKeepBenefitsClick;
    @NotNull
    private final Subscription subscription;
    private FragmentCancelFreeTrialBinding viewBinding;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JW\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002JU\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000e¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/CancelFreeTrialBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/CancelFreeTrialBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onCancelTrialClick", "Lkotlin/Function0;", "", "onKeepBenefitsClick", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final CancelFreeTrialBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1) {
            return new CancelFreeTrialBottomSheetFragment(dSBottomSheet, subscription, function0, function02, function1);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            Intrinsics.checkNotNullParameter(function0, "onCancelTrialClick");
            Intrinsics.checkNotNullParameter(function02, "onKeepBenefitsClick");
            Intrinsics.checkNotNullParameter(function1, "onDismissed");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(CancelFreeTrialBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription, function0, function02, function1));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public CancelFreeTrialBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onCancelTrialClick");
        Intrinsics.checkNotNullParameter(function02, "onKeepBenefitsClick");
        Intrinsics.checkNotNullParameter(function1, "onDismissed");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
        this.onCancelTrialClick = function0;
        this.onKeepBenefitsClick = function02;
        this.onDismissed = function1;
    }

    private final void addButtonsListeners() {
        FragmentCancelFreeTrialBinding fragmentCancelFreeTrialBinding = this.viewBinding;
        if (fragmentCancelFreeTrialBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentCancelFreeTrialBinding = null;
        }
        fragmentCancelFreeTrialBinding.cancelButton.setOnClickListener(new a(this));
        fragmentCancelFreeTrialBinding.confirmCancelTrialLayout.setOnClickListener(new b(this));
        fragmentCancelFreeTrialBinding.keepProLayout.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10389addButtonsListeners$lambda3$lambda0(CancelFreeTrialBottomSheetFragment cancelFreeTrialBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(cancelFreeTrialBottomSheetFragment, "this$0");
        cancelFreeTrialBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10390addButtonsListeners$lambda3$lambda1(CancelFreeTrialBottomSheetFragment cancelFreeTrialBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(cancelFreeTrialBottomSheetFragment, "this$0");
        cancelFreeTrialBottomSheetFragment.isAbortCancellation = false;
        cancelFreeTrialBottomSheetFragment.dismiss();
        cancelFreeTrialBottomSheetFragment.onCancelTrialClick.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10391addButtonsListeners$lambda3$lambda2(CancelFreeTrialBottomSheetFragment cancelFreeTrialBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(cancelFreeTrialBottomSheetFragment, "this$0");
        cancelFreeTrialBottomSheetFragment.dismiss();
        cancelFreeTrialBottomSheetFragment.onKeepBenefitsClick.invoke();
    }

    private final void addDismissListener() {
        this.dsBottomSheet.setOnDismiss(new CancelFreeTrialBottomSheetFragment$addDismissListener$1(this));
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
        FragmentCancelFreeTrialBinding fragmentCancelFreeTrialBinding = this.viewBinding;
        if (fragmentCancelFreeTrialBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentCancelFreeTrialBinding = null;
        }
        fragmentCancelFreeTrialBinding.cancelTrialSubtitle.setText(getString(R.string.tpro_cancel_trial_subtitle, Customer.getInstance().getCustomerInfo().getFistName(), getRemainingDaysLabel()));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentCancelFreeTrialBinding fragmentCancelFreeTrialBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "CancelFreeTrialBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CancelFreeTrialBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentCancelFreeTrialBinding inflate = FragmentCancelFreeTrialBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentCancelFreeTrialBinding = inflate;
        }
        ConstraintLayout root = fragmentCancelFreeTrialBinding.getRoot();
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
        addDismissListener();
    }
}
