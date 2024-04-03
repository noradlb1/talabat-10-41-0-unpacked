package com.talabat.feature.tpro.presentation.management.cancellation.confirm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.SubscriptionCancellationType;
import com.talabat.feature.tpro.presentation.databinding.FragmentConfirmCancellationBinding;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import yo.a;
import yo.b;
import yo.c;

@Instrumented
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!BF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\u000fJ\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/confirm/ConfirmCancellationBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onLeaveProClick", "Lkotlin/Function0;", "", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentConfirmCancellationBinding;", "addButtonsListeners", "addDismissListener", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ConfirmCancellationBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    /* access modifiers changed from: private */
    public boolean isAbortCancellation = true;
    /* access modifiers changed from: private */
    @NotNull
    public final Function1<Boolean, Unit> onDismissed;
    @NotNull
    private final Function0<Unit> onLeaveProClick;
    @NotNull
    private final Subscription subscription;
    private FragmentConfirmCancellationBinding viewBinding;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JI\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\rH\u0002JG\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u000b0\r¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/confirm/ConfirmCancellationBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/confirm/ConfirmCancellationBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "onLeaveProClick", "Lkotlin/Function0;", "", "onDismissed", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAbortCancellation", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ConfirmCancellationBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
            return new ConfirmCancellationBottomSheetFragment(dSBottomSheet, subscription, function0, function1);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription, @NotNull Function0<Unit> function0, @NotNull Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            Intrinsics.checkNotNullParameter(function0, "onLeaveProClick");
            Intrinsics.checkNotNullParameter(function1, "onDismissed");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(ConfirmCancellationBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription, function0, function1));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public ConfirmCancellationBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2, @NotNull Function0<Unit> function0, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        Intrinsics.checkNotNullParameter(function0, "onLeaveProClick");
        Intrinsics.checkNotNullParameter(function1, "onDismissed");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
        this.onLeaveProClick = function0;
        this.onDismissed = function1;
    }

    private final void addButtonsListeners() {
        FragmentConfirmCancellationBinding fragmentConfirmCancellationBinding = this.viewBinding;
        if (fragmentConfirmCancellationBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentConfirmCancellationBinding = null;
        }
        fragmentConfirmCancellationBinding.cancel.setOnClickListener(new a(this));
        fragmentConfirmCancellationBinding.cancelButton.setOnClickListener(new b(this));
        fragmentConfirmCancellationBinding.confirm.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10377addButtonsListeners$lambda3$lambda0(ConfirmCancellationBottomSheetFragment confirmCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(confirmCancellationBottomSheetFragment, "this$0");
        confirmCancellationBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10378addButtonsListeners$lambda3$lambda1(ConfirmCancellationBottomSheetFragment confirmCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(confirmCancellationBottomSheetFragment, "this$0");
        confirmCancellationBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10379addButtonsListeners$lambda3$lambda2(ConfirmCancellationBottomSheetFragment confirmCancellationBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(confirmCancellationBottomSheetFragment, "this$0");
        confirmCancellationBottomSheetFragment.isAbortCancellation = false;
        confirmCancellationBottomSheetFragment.dismiss();
        confirmCancellationBottomSheetFragment.onLeaveProClick.invoke();
    }

    private final void addDismissListener() {
        this.dsBottomSheet.setOnDismiss(new ConfirmCancellationBottomSheetFragment$addDismissListener$1(this));
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
        FragmentConfirmCancellationBinding fragmentConfirmCancellationBinding = null;
        if (this.subscription.getPlan().getCancellationType() == SubscriptionCancellationType.ImmediateCancel) {
            String string = getString(com.talabat.localization.R.string.immediate_cancel_message);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…immediate_cancel_message)");
            FragmentConfirmCancellationBinding fragmentConfirmCancellationBinding2 = this.viewBinding;
            if (fragmentConfirmCancellationBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            } else {
                fragmentConfirmCancellationBinding = fragmentConfirmCancellationBinding2;
            }
            fragmentConfirmCancellationBinding.cancelSubscriptionMessage.setText(string);
            return;
        }
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime nextBillingDate = this.subscription.getNextBillingDate();
        if (nextBillingDate != null) {
            str = nextBillingDate.format(ofPattern);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String formattedDateString = DateUtils.Companion.getFormattedDateString(str, "dd LLLL yyyy");
        String str2 = getString(com.talabat.localization.R.string.next_billing_date_with_cancel_message) + " <b>" + formattedDateString + "</b>";
        FragmentConfirmCancellationBinding fragmentConfirmCancellationBinding3 = this.viewBinding;
        if (fragmentConfirmCancellationBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentConfirmCancellationBinding = fragmentConfirmCancellationBinding3;
        }
        fragmentConfirmCancellationBinding.cancelSubscriptionMessage.setText(HtmlCompat.fromHtml(str2, 0));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentConfirmCancellationBinding fragmentConfirmCancellationBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ConfirmCancellationBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ConfirmCancellationBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentConfirmCancellationBinding inflate = FragmentConfirmCancellationBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentConfirmCancellationBinding = inflate;
        }
        ConstraintLayout root = fragmentConfirmCancellationBinding.getRoot();
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
