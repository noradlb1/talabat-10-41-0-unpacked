package com.talabat.userandlocation.compliance.blocked.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.compose.DialogNavigator;
import bx.a;
import bx.b;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatTextView;
import com.talabat.talabatcore.TalabatBaseBottomSheetDialogFragment;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.userandlocation.compliance.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.helpcenter.DeeplinkInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/userandlocation/compliance/blocked/ui/fragment/CannotProceedDialogFragment;", "Lcom/talabat/talabatcore/TalabatBaseBottomSheetDialogFragment;", "()V", "onDismiss", "Lkotlin/Function0;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", "view", "Companion", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CannotProceedDialogFragment extends TalabatBaseBottomSheetDialogFragment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EXTRA_TITLE = "title";
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    private Function0<Unit> onDismiss;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/userandlocation/compliance/blocked/ui/fragment/CannotProceedDialogFragment$Companion;", "", "()V", "EXTRA_TITLE", "", "newInstance", "Lcom/talabat/userandlocation/compliance/blocked/ui/fragment/CannotProceedDialogFragment;", "title", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final CannotProceedDialogFragment newInstance(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            CannotProceedDialogFragment cannotProceedDialogFragment = new CannotProceedDialogFragment((DefaultConstructorMarker) null);
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            cannotProceedDialogFragment.setArguments(bundle);
            return cannotProceedDialogFragment;
        }
    }

    private CannotProceedDialogFragment() {
        this._$_findViewCache = new LinkedHashMap();
        this.onDismiss = CannotProceedDialogFragment$onDismiss$1.INSTANCE;
    }

    public /* synthetic */ CannotProceedDialogFragment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final CannotProceedDialogFragment newInstance(@NotNull String str) {
        return Companion.newInstance(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m5892onViewCreated$lambda0(CannotProceedDialogFragment cannotProceedDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(cannotProceedDialogFragment, "this$0");
        cannotProceedDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m5893onViewCreated$lambda2(CannotProceedDialogFragment cannotProceedDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(cannotProceedDialogFragment, "this$0");
        Navigator.Companion companion = Navigator.Companion;
        FragmentActivity requireActivity = cannotProceedDialogFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Bundle bundle = new Bundle();
        bundle.putSerializable("deeplink_info", new DeeplinkInfo(8, 45));
        Unit unit = Unit.INSTANCE;
        companion.navigate((Context) requireActivity, new NavigatorModel(LegacyTalabatActions.OPEN_HELP_CENTER_SCREEN, bundle, (Function1) null, 4, (DefaultConstructorMarker) null));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.BottomSheetDialogTheme);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_cannot_proceed_bottom_sheet_dialog, viewGroup);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        super.onDismiss(dialogInterface);
        this.onDismiss.invoke();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        TalabatTextView talabatTextView = (TalabatTextView) _$_findCachedViewById(R.id.title);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("title");
        } else {
            str = null;
        }
        talabatTextView.setText(str);
        ((TalabatTextView) _$_findCachedViewById(R.id.txtDismiss)).setOnClickListener(new a(this));
        ((TalabatFillButton) _$_findCachedViewById(R.id.btnContactCustomerSupport)).setOnClickListener(new b(this));
    }

    public final void setOnDismiss(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onDismiss = function0;
    }
}
