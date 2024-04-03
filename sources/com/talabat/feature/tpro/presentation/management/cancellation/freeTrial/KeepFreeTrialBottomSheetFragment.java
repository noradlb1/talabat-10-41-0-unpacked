package com.talabat.feature.tpro.presentation.management.cancellation.freeTrial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bp.d;
import bp.e;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.databinding.FragmentKeepFreeTrialBinding;
import com.talabat.feature.tpro.presentation.util.DateAndTimeUtill;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;

@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/KeepFreeTrialBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onStartExploringClick", "Lkotlin/Function0;", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lkotlin/jvm/functions/Function0;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentKeepFreeTrialBinding;", "addButtonsListeners", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KeepFreeTrialBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final Function0<Unit> onStartExploringClick;
    @NotNull
    private final Subscription subscription;
    private FragmentKeepFreeTrialBinding viewBinding;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/KeepFreeTrialBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/freeTrial/KeepFreeTrialBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onStartExploringClick", "Lkotlin/Function0;", "", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final KeepFreeTrialBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription, Function0<Unit> function0) {
            return new KeepFreeTrialBottomSheetFragment(dSBottomSheet, subscription, function0);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            Intrinsics.checkNotNullParameter(function0, "onStartExploringClick");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(KeepFreeTrialBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription, function0));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public KeepFreeTrialBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onStartExploringClick");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
        this.onStartExploringClick = function0;
    }

    private final void addButtonsListeners() {
        FragmentKeepFreeTrialBinding fragmentKeepFreeTrialBinding = this.viewBinding;
        if (fragmentKeepFreeTrialBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentKeepFreeTrialBinding = null;
        }
        fragmentKeepFreeTrialBinding.cancelButton.setOnClickListener(new d(this));
        fragmentKeepFreeTrialBinding.startExploringLayout.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10392addButtonsListeners$lambda2$lambda0(KeepFreeTrialBottomSheetFragment keepFreeTrialBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(keepFreeTrialBottomSheetFragment, "this$0");
        keepFreeTrialBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10393addButtonsListeners$lambda2$lambda1(KeepFreeTrialBottomSheetFragment keepFreeTrialBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(keepFreeTrialBottomSheetFragment, "this$0");
        keepFreeTrialBottomSheetFragment.dismiss();
        keepFreeTrialBottomSheetFragment.onStartExploringClick.invoke();
    }

    private final void dismiss() {
        this.dsBottomSheet.dismiss();
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setUpViews() {
        FragmentKeepFreeTrialBinding fragmentKeepFreeTrialBinding = this.viewBinding;
        LocalDateTime localDateTime = null;
        if (fragmentKeepFreeTrialBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentKeepFreeTrialBinding = null;
        }
        TextView textView = fragmentKeepFreeTrialBinding.keepTrialSubtitle;
        int i11 = com.talabat.localization.R.string.tpro_keep_trial_subtitle;
        Object[] objArr = new Object[1];
        DateAndTimeUtill dateAndTimeUtill = DateAndTimeUtill.INSTANCE;
        LocalDateTime nextBillingDate = this.subscription.getNextBillingDate();
        if (nextBillingDate != null) {
            localDateTime = nextBillingDate.minusDays(1);
        }
        objArr[0] = dateAndTimeUtill.getSubscriptionDisplayDate(localDateTime);
        textView.setText(getString(i11, objArr));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentKeepFreeTrialBinding fragmentKeepFreeTrialBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "KeepFreeTrialBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "KeepFreeTrialBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentKeepFreeTrialBinding inflate = FragmentKeepFreeTrialBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentKeepFreeTrialBinding = inflate;
        }
        ConstraintLayout root = fragmentKeepFreeTrialBinding.getRoot();
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
