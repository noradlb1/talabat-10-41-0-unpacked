package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardSuccessInterface;", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardNavigationInterface;", "listener", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "(Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;)V", "attachFragment", "", "navigateToAddCardSuccess", "navigateToThreeDsScreen", "argument", "Landroid/os/Bundle;", "onBackPressed", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "WalletAddCardDialogFragmentInterface", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardDialogFragment extends DialogFragment implements WalletAddCardSuccessInterface, WalletAddCardNavigationInterface, TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final WalletAddCardDialogFragmentInterface listener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardDialogFragment$WalletAddCardDialogFragmentInterface;", "", "onAddCardSuccess", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface WalletAddCardDialogFragmentInterface {
        void onAddCardSuccess();
    }

    public WalletAddCardDialogFragment(@NotNull WalletAddCardDialogFragmentInterface walletAddCardDialogFragmentInterface) {
        Intrinsics.checkNotNullParameter(walletAddCardDialogFragmentInterface, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = walletAddCardDialogFragmentInterface;
    }

    private final void attachFragment() {
        WalletAddCardFragment walletAddCardFragment = new WalletAddCardFragment();
        walletAddCardFragment.setAddCardSuccessListener(this);
        walletAddCardFragment.setAddCardNavigationInterface(this);
        walletAddCardFragment.setArguments(getArguments());
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.fragmentContainer, (Fragment) walletAddCardFragment, "WalletAddCardDialogFragment").commit();
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

    public void navigateToAddCardSuccess() {
        dismiss();
        this.listener.onAddCardSuccess();
    }

    public void navigateToThreeDsScreen(@Nullable Bundle bundle) {
        WalletAddCardThreeDsSuccess walletAddCardThreeDsSuccess = new WalletAddCardThreeDsSuccess();
        walletAddCardThreeDsSuccess.setListener(this);
        walletAddCardThreeDsSuccess.setArguments(bundle);
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "childFragmentManager.beginTransaction()");
        beginTransaction.replace(R.id.fragmentContainer, walletAddCardThreeDsSuccess);
        beginTransaction.addToBackStack((String) null);
        beginTransaction.commit();
    }

    public void onBackPressed() {
        dismiss();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("WalletAddCardDialogFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletAddCardDialogFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletAddCardDialogFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setStyle(0, R.style.ResizeAddCardDialogFragment);
        TraceMachine.exitMethod();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletAddCardDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletAddCardDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_add_card_container, viewGroup, false);
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
}
