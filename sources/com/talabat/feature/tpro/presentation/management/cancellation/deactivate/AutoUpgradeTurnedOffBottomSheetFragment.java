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
import ap.a;
import ap.b;
import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.tpro.presentation.databinding.FragmentAutoUpgradeTurnedOffBinding;
import com.talabat.talabatcommon.utils.DateUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

@Instrumented
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/AutoUpgradeTurnedOffBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "(Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;Lcom/talabat/feature/subscriptions/domain/model/Subscription;)V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentAutoUpgradeTurnedOffBinding;", "addButtonsListeners", "", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoUpgradeTurnedOffBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Trace _nr_trace;
    @NotNull
    private final DSBottomSheet dsBottomSheet;
    @NotNull
    private final Subscription subscription;
    private FragmentAutoUpgradeTurnedOffBinding viewBinding;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/AutoUpgradeTurnedOffBottomSheetFragment$Companion;", "", "()V", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/cancellation/deactivate/AutoUpgradeTurnedOffBottomSheetFragment;", "dsBottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/DSBottomSheet;", "subscription", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AutoUpgradeTurnedOffBottomSheetFragment getInstance(DSBottomSheet dSBottomSheet, Subscription subscription) {
            return new AutoUpgradeTurnedOffBottomSheetFragment(dSBottomSheet, subscription);
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull Subscription subscription) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(subscription, "subscription");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(AutoUpgradeTurnedOffBottomSheetFragment.Companion.getInstance(dSBottomSheet, subscription));
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            dSBottomSheet.show(supportFragmentManager);
        }
    }

    public AutoUpgradeTurnedOffBottomSheetFragment(@NotNull DSBottomSheet dSBottomSheet, @NotNull Subscription subscription2) {
        Intrinsics.checkNotNullParameter(dSBottomSheet, "dsBottomSheet");
        Intrinsics.checkNotNullParameter(subscription2, "subscription");
        this.dsBottomSheet = dSBottomSheet;
        this.subscription = subscription2;
    }

    private final void addButtonsListeners() {
        FragmentAutoUpgradeTurnedOffBinding fragmentAutoUpgradeTurnedOffBinding = this.viewBinding;
        if (fragmentAutoUpgradeTurnedOffBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentAutoUpgradeTurnedOffBinding = null;
        }
        fragmentAutoUpgradeTurnedOffBinding.cancelButton.setOnClickListener(new a(this));
        fragmentAutoUpgradeTurnedOffBinding.gotItLayout.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10382addButtonsListeners$lambda3$lambda1(AutoUpgradeTurnedOffBottomSheetFragment autoUpgradeTurnedOffBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(autoUpgradeTurnedOffBottomSheetFragment, "this$0");
        autoUpgradeTurnedOffBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10383addButtonsListeners$lambda3$lambda2(AutoUpgradeTurnedOffBottomSheetFragment autoUpgradeTurnedOffBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(autoUpgradeTurnedOffBottomSheetFragment, "this$0");
        autoUpgradeTurnedOffBottomSheetFragment.dismiss();
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
        FragmentAutoUpgradeTurnedOffBinding fragmentAutoUpgradeTurnedOffBinding = null;
        if (endDate != null) {
            DateUtils.Companion companion = DateUtils.Companion;
            String format = endDate.format(DateTimeFormatter.ISO_DATE_TIME);
            Intrinsics.checkNotNullExpressionValue(format, "it.format(DateTimeFormatter.ISO_DATE_TIME)");
            str = companion.getLocalizedFormattedDateString(format, "dd LLLL yyyy");
        } else {
            str = null;
        }
        FragmentAutoUpgradeTurnedOffBinding fragmentAutoUpgradeTurnedOffBinding2 = this.viewBinding;
        if (fragmentAutoUpgradeTurnedOffBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentAutoUpgradeTurnedOffBinding = fragmentAutoUpgradeTurnedOffBinding2;
        }
        fragmentAutoUpgradeTurnedOffBinding.autoUpgradeDeactivatedSubtitle.setText(getString(com.talabat.localization.R.string.shahid_expire_date_info, str));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentAutoUpgradeTurnedOffBinding fragmentAutoUpgradeTurnedOffBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutoUpgradeTurnedOffBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AutoUpgradeTurnedOffBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAutoUpgradeTurnedOffBinding inflate = FragmentAutoUpgradeTurnedOffBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentAutoUpgradeTurnedOffBinding = inflate;
        }
        ConstraintLayout root = fragmentAutoUpgradeTurnedOffBinding.getRoot();
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
