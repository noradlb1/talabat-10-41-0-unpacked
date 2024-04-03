package com.talabat.talabatcommon.views.wallet.walletPaymentOption.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import bw.n;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.WalletPaymentThreeDsFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\b\u0010#\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment$WalletPaymentThreeDsFragmentInterface;", "walletPaymentThreeDsDialogFragmentInterface", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsDialogFragment$WalletPaymentThreeDsDialogFragmentInterface;", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsDialogFragment$WalletPaymentThreeDsDialogFragmentInterface;)V", "fragment", "Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment;", "getFragment", "()Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment;", "setFragment", "(Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsFragment;)V", "attachFragment", "", "bottomSheetTopUpFailure", "bottomSheetTopUpSuccessful", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "topUpFailure", "topUpSuccessful", "WalletPaymentThreeDsDialogFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentThreeDsDialogFragment extends DialogFragment implements WalletPaymentThreeDsFragment.WalletPaymentThreeDsFragmentInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private WalletPaymentThreeDsFragment fragment;
    @NotNull
    private final WalletPaymentThreeDsDialogFragmentInterface walletPaymentThreeDsDialogFragmentInterface;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletPaymentOption/view/WalletPaymentThreeDsDialogFragment$WalletPaymentThreeDsDialogFragmentInterface;", "", "onBottomSheetTopUpFailure", "", "onBottomSheetTopUpSuccessful", "onDialogBackPressed", "onTopUpFailure", "onTopUpSuccessful", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletPaymentThreeDsDialogFragmentInterface {
        void onBottomSheetTopUpFailure();

        void onBottomSheetTopUpSuccessful();

        void onDialogBackPressed();

        void onTopUpFailure();

        void onTopUpSuccessful();
    }

    public WalletPaymentThreeDsDialogFragment(@NotNull WalletPaymentThreeDsDialogFragmentInterface walletPaymentThreeDsDialogFragmentInterface2) {
        Intrinsics.checkNotNullParameter(walletPaymentThreeDsDialogFragmentInterface2, "walletPaymentThreeDsDialogFragmentInterface");
        this.walletPaymentThreeDsDialogFragmentInterface = walletPaymentThreeDsDialogFragmentInterface2;
    }

    private final void attachFragment() {
        WalletPaymentThreeDsFragment walletPaymentThreeDsFragment = new WalletPaymentThreeDsFragment(this);
        this.fragment = walletPaymentThreeDsFragment;
        walletPaymentThreeDsFragment.setArguments(getArguments());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        WalletPaymentThreeDsFragment walletPaymentThreeDsFragment2 = this.fragment;
        if (walletPaymentThreeDsFragment2 != null) {
            beginTransaction.replace(R.id.child_fragment_container_three_ds, (Fragment) walletPaymentThreeDsFragment2, "WalletPaymentThreeDsDialogFragment").commit();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateDialog$lambda-1  reason: not valid java name */
    public static final boolean m5821onCreateDialog$lambda1(WalletPaymentThreeDsDialogFragment walletPaymentThreeDsDialogFragment, DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(walletPaymentThreeDsDialogFragment, "this$0");
        if (i11 != 4) {
            return false;
        }
        walletPaymentThreeDsDialogFragment.dismiss();
        walletPaymentThreeDsDialogFragment.walletPaymentThreeDsDialogFragmentInterface.onDialogBackPressed();
        return true;
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

    public void bottomSheetTopUpFailure() {
        dismiss();
        this.walletPaymentThreeDsDialogFragmentInterface.onBottomSheetTopUpFailure();
    }

    public void bottomSheetTopUpSuccessful() {
        dismiss();
        this.walletPaymentThreeDsDialogFragmentInterface.onBottomSheetTopUpSuccessful();
    }

    @Nullable
    public final WalletPaymentThreeDsFragment getFragment() {
        return this.fragment;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("WalletPaymentThreeDsDialogFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletPaymentThreeDsDialogFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletPaymentThreeDsDialogFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setStyle(0, 16973841);
        TraceMachine.exitMethod();
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setOnKeyListener(new n(this));
        return onCreateDialog;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletPaymentThreeDsDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletPaymentThreeDsDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_dialog_wallet_payment_three_ds, viewGroup, false);
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
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
        attachFragment();
    }

    public final void setFragment(@Nullable WalletPaymentThreeDsFragment walletPaymentThreeDsFragment) {
        this.fragment = walletPaymentThreeDsFragment;
    }

    public void show(@NotNull FragmentManager fragmentManager, @Nullable String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "manager");
        try {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException unused) {
        }
    }

    public void topUpFailure() {
        dismiss();
        this.walletPaymentThreeDsDialogFragmentInterface.onTopUpFailure();
    }

    public void topUpSuccessful() {
        dismiss();
        this.walletPaymentThreeDsDialogFragmentInterface.onTopUpSuccessful();
    }
}
