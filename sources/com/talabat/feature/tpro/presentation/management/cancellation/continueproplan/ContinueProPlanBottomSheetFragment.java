package com.talabat.feature.tpro.presentation.management.cancellation.continueproplan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import buisnessmodels.TalabatFormatter;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.databinding.FragmentContinueProPlanBinding;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import zo.a;
import zo.b;

@Instrumented
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/continueproplan/ContinueProPlanBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onStartExploringClick", "Lkotlin/Function0;", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lkotlin/jvm/functions/Function0;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentContinueProPlanBinding;", "addButtonsListeners", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContinueProPlanBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final Function0<Unit> onStartExploringClick;
    @NotNull
    private final Subscription subscription;
    private FragmentContinueProPlanBinding viewBinding;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/continueproplan/ContinueProPlanBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/continueproplan/ContinueProPlanBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onStartExploringClick", "Lkotlin/Function0;", "", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ContinueProPlanBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription, Function0<Unit> function0) {
            return new ContinueProPlanBottomSheetFragment(dSBottomSheet, subscription, function0);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            Intrinsics.checkNotNullParameter(function0, "onStartExploringClick");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(ContinueProPlanBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription, function0));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public ContinueProPlanBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onStartExploringClick");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
        this.onStartExploringClick = function0;
    }

    private final void addButtonsListeners() {
        FragmentContinueProPlanBinding fragmentContinueProPlanBinding = this.viewBinding;
        if (fragmentContinueProPlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentContinueProPlanBinding = null;
        }
        fragmentContinueProPlanBinding.cancelButton.setOnClickListener(new a(this));
        fragmentContinueProPlanBinding.startExploringLayout.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10380addButtonsListeners$lambda3$lambda1(ContinueProPlanBottomSheetFragment continueProPlanBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(continueProPlanBottomSheetFragment, "this$0");
        continueProPlanBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10381addButtonsListeners$lambda3$lambda2(ContinueProPlanBottomSheetFragment continueProPlanBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(continueProPlanBottomSheetFragment, "this$0");
        continueProPlanBottomSheetFragment.dismiss();
        continueProPlanBottomSheetFragment.onStartExploringClick.invoke();
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
        String str;
        LocalDateTime endDate = this.subscription.getEndDate();
        if (endDate != null) {
            DateUtils.Companion companion = DateUtils.Companion;
            String format = endDate.format(DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(format, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
            str = companion.getLocalizedFormattedDateString(format, "dd LLLL yyyy");
        } else {
            str = "";
        }
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.subscription.getPlan().getCurrencyAmount().getAmount());
        String string = getString(com.talabat.localization.R.string.tpro_month);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…tion.R.string.tpro_month)");
        String str2 = formattedCurrency + " / " + string;
        FragmentContinueProPlanBinding fragmentContinueProPlanBinding = this.viewBinding;
        if (fragmentContinueProPlanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentContinueProPlanBinding = null;
        }
        fragmentContinueProPlanBinding.continueProPlanSubtitle.setText(getString(com.talabat.localization.R.string.continue_pro_plan_description, str, str2));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentContinueProPlanBinding fragmentContinueProPlanBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ContinueProPlanBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ContinueProPlanBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentContinueProPlanBinding inflate = FragmentContinueProPlanBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentContinueProPlanBinding = inflate;
        }
        ConstraintLayout root = fragmentContinueProPlanBinding.getRoot();
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
