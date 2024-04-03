package com.talabat.feature.tpro.presentation.management.details.upgrade;

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
import com.designsystem.marshmallow.R;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.tpro.presentation.databinding.FragmentTproUpgradeSuccessBinding;
import fp.a;
import fp.b;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/TproUpgradeSuccessBottomSheetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "viewBinding", "Lcom/talabat/feature/tpro/presentation/databinding/FragmentTproUpgradeSuccessBinding;", "addButtonsListeners", "", "dismiss", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "removePadding", "setUpViews", "planPeriod", "", "endDate", "Companion", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproUpgradeSuccessBottomSheetFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String KEY_END_DATE = "end_date";
    @NotNull
    public static final String KEY_PLAN_PERIOD = "plan_period";
    @NotNull
    public static final String TAG = "TproUpgradeSuccessBottomSheetFragment";
    public Trace _nr_trace;
    private FragmentTproUpgradeSuccessBinding viewBinding;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/upgrade/TproUpgradeSuccessBottomSheetFragment$Companion;", "", "()V", "KEY_END_DATE", "", "KEY_PLAN_PERIOD", "TAG", "getInstance", "Lcom/talabat/feature/tpro/presentation/management/details/upgrade/TproUpgradeSuccessBottomSheetFragment;", "planPeriod", "endDate", "show", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TproUpgradeSuccessBottomSheetFragment getInstance(String str, String str2) {
            TproUpgradeSuccessBottomSheetFragment tproUpgradeSuccessBottomSheetFragment = new TproUpgradeSuccessBottomSheetFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TproUpgradeSuccessBottomSheetFragment.KEY_PLAN_PERIOD, str);
            bundle.putString("end_date", str2);
            tproUpgradeSuccessBottomSheetFragment.setArguments(bundle);
            return tproUpgradeSuccessBottomSheetFragment;
        }

        public final void show(@NotNull FragmentActivity fragmentActivity, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            Intrinsics.checkNotNullParameter(str, "planPeriod");
            Intrinsics.checkNotNullParameter(str2, "endDate");
            DSBottomSheet dSBottomSheet = new DSBottomSheet();
            dSBottomSheet.setBody(TproUpgradeSuccessBottomSheetFragment.Companion.getInstance(str, str2));
            dSBottomSheet.show(fragmentActivity.getSupportFragmentManager(), TproUpgradeSuccessBottomSheetFragment.TAG);
        }
    }

    private final void addButtonsListeners() {
        FragmentTproUpgradeSuccessBinding fragmentTproUpgradeSuccessBinding = this.viewBinding;
        if (fragmentTproUpgradeSuccessBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeSuccessBinding = null;
        }
        fragmentTproUpgradeSuccessBinding.cancelButton.setOnClickListener(new a(this));
        fragmentTproUpgradeSuccessBinding.dimissUpgradeSuccess.setOnClickListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10405addButtonsListeners$lambda3$lambda1(TproUpgradeSuccessBottomSheetFragment tproUpgradeSuccessBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tproUpgradeSuccessBottomSheetFragment, "this$0");
        tproUpgradeSuccessBottomSheetFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: addButtonsListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10406addButtonsListeners$lambda3$lambda2(TproUpgradeSuccessBottomSheetFragment tproUpgradeSuccessBottomSheetFragment, View view) {
        Intrinsics.checkNotNullParameter(tproUpgradeSuccessBottomSheetFragment, "this$0");
        tproUpgradeSuccessBottomSheetFragment.dismiss();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dismiss() {
        /*
            r2 = this;
            androidx.fragment.app.FragmentActivity r0 = r2.getActivity()
            if (r0 == 0) goto L_0x0013
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = "TproUpgradeSuccessBottomSheetFragment"
            androidx.fragment.app.Fragment r0 = r0.findFragmentByTag(r1)
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x001c
            androidx.fragment.app.DialogFragment r0 = (androidx.fragment.app.DialogFragment) r0
            r0.dismiss()
            return
        L_0x001c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.DialogFragment"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.tpro.presentation.management.details.upgrade.TproUpgradeSuccessBottomSheetFragment.dismiss():void");
    }

    private final void removePadding() {
        View view;
        FrameLayout frameLayout;
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (view = parentFragment.getView()) != null && (frameLayout = (FrameLayout) view.findViewById(R.id.dsBottomSheetContentContainer)) != null) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
    }

    private final void setUpViews(String str, String str2) {
        FragmentTproUpgradeSuccessBinding fragmentTproUpgradeSuccessBinding = this.viewBinding;
        if (fragmentTproUpgradeSuccessBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            fragmentTproUpgradeSuccessBinding = null;
        }
        TextView textView = fragmentTproUpgradeSuccessBinding.tvUpgradeSuccessHeader;
        int i11 = com.talabat.localization.R.string.tpro_upgrate_success_title;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        textView.setText(getString(i11, Customer.getInstance().getCustomerInfo().getFistName(), lowerCase));
        fragmentTproUpgradeSuccessBinding.tvUpgradeSuccessDescription.setText(getString(com.talabat.localization.R.string.tpro_upgrate_success_info, str2));
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentTproUpgradeSuccessBinding fragmentTproUpgradeSuccessBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "TproUpgradeSuccessBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TproUpgradeSuccessBottomSheetFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTproUpgradeSuccessBinding inflate = FragmentTproUpgradeSuccessBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.viewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            fragmentTproUpgradeSuccessBinding = inflate;
        }
        ConstraintLayout root = fragmentTproUpgradeSuccessBinding.getRoot();
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
        String str;
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString(KEY_PLAN_PERIOD)) == null) {
            str = str2;
        }
        Bundle arguments2 = getArguments();
        if (!(arguments2 == null || (string = arguments2.getString("end_date")) == null)) {
            str2 = string;
        }
        removePadding();
        setUpViews(str, str2);
        addButtonsListeners();
    }
}
