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
import ap.f;
import ap.g;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.tpro.presentation.databinding.FragmentUnlockProBenefitsBinding;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0002R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/UnlockProBenefitsBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "onTurnOnAutoUpgrade", "Lkotlin/Function0;", "", "comingFromBenefits", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentUnlockProBenefitsBinding;", "addButtonsListeners", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnlockProBenefitsBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @Nullable
    private final Boolean comingFromBenefits;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final Function0<Unit> onTurnOnAutoUpgrade;
    private FragmentUnlockProBenefitsBinding viewBinding;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ+\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/UnlockProBenefitsBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/UnlockProBenefitsBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "onTurnOnAutoUpgrade", "Lkotlin/Function0;", "", "comingFromBenefits", "", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;)Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/UnlockProBenefitsBottomSheetFragment;", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;)V", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final UnlockProBenefitsBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Function0<Unit> function0, Boolean bool) {
            return new UnlockProBenefitsBottomSheetFragment(dSBottomSheet, function0, bool);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Function0<Unit> function0, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(function0, "onTurnOnAutoUpgrade");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(UnlockProBenefitsBottomSheetFragment.Companion.getInstance(dSBottomSheet, function0, bool));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnlockProBenefitsBottomSheetFragment(DSBottomSheet dSBottomSheet, Function0 function0, Boolean bool, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(dSBottomSheet, function0, (i11 & 4) != 0 ? null : bool);
    }

    private final void addButtonsListeners() {
        FragmentUnlockProBenefitsBinding fragmentUnlockProBenefitsBinding = this.viewBinding;
        if (fragmentUnlockProBenefitsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentUnlockProBenefitsBinding = null;
        }
        fragmentUnlockProBenefitsBinding.cancelButton.setOnClickListener(new f(this));
        fragmentUnlockProBenefitsBinding.startExploringLayout.setOnClickListener(new g(this));
        if (Intrinsics.areEqual((Object) this.comingFromBenefits, (Object) Boolean.TRUE)) {
            fragmentUnlockProBenefitsBinding.actionButtonText.setText(getString(R.string.got_it_text));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-2$lambda-0  reason: not valid java name */
    public static final void m10387addButtonsListeners$lambda2$lambda0(UnlockProBenefitsBottomSheetFragment unlockProBenefitsBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(unlockProBenefitsBottomSheetFragment, "this$0");
        unlockProBenefitsBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10388addButtonsListeners$lambda2$lambda1(UnlockProBenefitsBottomSheetFragment unlockProBenefitsBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(unlockProBenefitsBottomSheetFragment, "this$0");
        unlockProBenefitsBottomSheetFragment.onTurnOnAutoUpgrade.invoke();
        unlockProBenefitsBottomSheetFragment.dismiss();
    }

    private final void dismiss() {
        this.dsBottomSheet.dismiss();
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(com.designsystem.marshmallow.R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentUnlockProBenefitsBinding fragmentUnlockProBenefitsBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "UnlockProBenefitsBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "UnlockProBenefitsBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentUnlockProBenefitsBinding inflate = FragmentUnlockProBenefitsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentUnlockProBenefitsBinding = inflate;
        }
        ConstraintLayout root = fragmentUnlockProBenefitsBinding.getRoot();
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
        addButtonsListeners();
    }

    public UnlockProBenefitsBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Function0<Unit> function0, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(function0, "onTurnOnAutoUpgrade");
        this.dsBottomSheet = dSBottomSheet;
        this.onTurnOnAutoUpgrade = function0;
        this.comingFromBenefits = bool;
    }
}
