package com.talabat.wallet.bnplmanager.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import com.designsystem.ds_button.DSPrimaryButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.wallet.R;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import px.a;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLEligibilityErrorDialog;", "Landroidx/fragment/app/DialogFragment;", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "", "onViewCreated", "view", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEligibilityErrorDialog extends DialogFragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final BNPLValidationError bNPLValidationError;

    public BNPLEligibilityErrorDialog(@NotNull BNPLValidationError bNPLValidationError2) {
        Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
        this.bNPLValidationError = bNPLValidationError2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m5943onViewCreated$lambda0(BNPLEligibilityErrorDialog bNPLEligibilityErrorDialog, View view) {
        Intrinsics.checkNotNullParameter(bNPLEligibilityErrorDialog, "this$0");
        Dialog dialog = bNPLEligibilityErrorDialog.getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
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
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.requestWindowFeature(1);
        return onCreateDialog;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "BNPLEligibilityErrorDialog#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BNPLEligibilityErrorDialog#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        super.onCreate(bundle);
        View inflate = layoutInflater.inflate(R.layout.view_bnpl_eligibility_error, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      …          false\n        )");
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(R.id.bnpl_eligibility_error_title)).setText(this.bNPLValidationError.getTitle());
        ((TextView) _$_findCachedViewById(R.id.bnpl_eligibility_error_description)).setText(HtmlCompat.fromHtml(this.bNPLValidationError.getDescription(), 0));
        ((DSPrimaryButton) _$_findCachedViewById(R.id.bnpl_eligibility_error_cancel_button)).setOnClickListener(new a(this));
    }
}
