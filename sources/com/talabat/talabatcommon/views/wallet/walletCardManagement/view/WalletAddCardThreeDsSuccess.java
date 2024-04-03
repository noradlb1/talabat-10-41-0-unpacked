package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0002J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardThreeDsSuccess;", "Landroidx/fragment/app/Fragment;", "()V", "addCardSuccessListener", "Lcom/talabat/talabatcommon/views/wallet/walletCardManagement/view/WalletAddCardSuccessInterface;", "addWebViewListener", "", "loadUrl", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "redirectToErrorScreen", "redirectToSuccessScreen", "setListener", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardThreeDsSuccess extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private WalletAddCardSuccessInterface addCardSuccessListener;

    private final void addWebViewListener() {
        ((WebView) _$_findCachedViewById(R.id.wallet_add_card_web_view)).setWebViewClient(new WalletAddCardThreeDsSuccess$addWebViewListener$1(this));
    }

    private final void loadUrl() {
        String str;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString(WalletNavigatorActions.WALLET_THREE_DS_URL_KEY);
        } else {
            str = null;
        }
        if (str != null) {
            ((WebView) _$_findCachedViewById(R.id.wallet_add_card_web_view)).loadUrl(str);
        }
    }

    /* access modifiers changed from: private */
    public final void redirectToErrorScreen() {
        Boolean bool;
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.putBoolean(WalletNavigatorActions.EXTRA_WALLET_ADD_CARD_ERROR, true);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (supportFragmentManager2 = activity2.getSupportFragmentManager()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(supportFragmentManager2.isStateSaved());
        }
        if (!BooleanKt.orTrue(bool) && (activity = getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
    }

    /* access modifiers changed from: private */
    public final void redirectToSuccessScreen() {
        AddCardNavigationUtility.INSTANCE.navigateToAddCardSuccessScreen(getArguments(), getContext(), this.addCardSuccessListener);
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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletAddCardThreeDsSuccess#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletAddCardThreeDsSuccess#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_add_card_web_view, viewGroup, false);
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
        ((WebView) _$_findCachedViewById(R.id.wallet_add_card_web_view)).getSettings().setJavaScriptEnabled(true);
        loadUrl();
        addWebViewListener();
    }

    public final void setListener(@NotNull WalletAddCardSuccessInterface walletAddCardSuccessInterface) {
        Intrinsics.checkNotNullParameter(walletAddCardSuccessInterface, "addCardSuccessListener");
        this.addCardSuccessListener = walletAddCardSuccessInterface;
    }
}
