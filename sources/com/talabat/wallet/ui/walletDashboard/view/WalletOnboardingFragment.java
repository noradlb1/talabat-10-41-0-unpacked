package com.talabat.wallet.ui.walletDashboard.view;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.designsystem.ds_bottom_sheet_v2.BottomSheet;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.wallet.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xy.k;

@Instrumented
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletOnboardingFragment;", "Landroidx/fragment/app/Fragment;", "withTopUp", "", "bottomSheet", "Lcom/designsystem/ds_bottom_sheet_v2/BottomSheet;", "(ZLcom/designsystem/ds_bottom_sheet_v2/BottomSheet;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletOnboardingFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TAG = "WalletOnboardingFragment";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final BottomSheet bottomSheet;
    private final boolean withTopUp;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/ui/walletDashboard/view/WalletOnboardingFragment$Companion;", "", "()V", "TAG", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WalletOnboardingFragment(boolean z11, @NotNull BottomSheet bottomSheet2) {
        Intrinsics.checkNotNullParameter(bottomSheet2, "bottomSheet");
        this.withTopUp = z11;
        this.bottomSheet = bottomSheet2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m6060onViewCreated$lambda0(WalletOnboardingFragment walletOnboardingFragment, View view) {
        Intrinsics.checkNotNullParameter(walletOnboardingFragment, "this$0");
        walletOnboardingFragment.bottomSheet.dismiss();
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
        int i11;
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletOnboardingFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletOnboardingFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (this.withTopUp) {
            i11 = R.layout.fragment_wallet_onboarding_with_top_up;
        } else {
            i11 = R.layout.fragment_wallet_onboarding_without_top_up;
        }
        View inflate = layoutInflater.inflate(i11, viewGroup, false);
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
        KeyEvent.Callback callback;
        Sequence<View> children;
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Fragment parentFragment = getParentFragment();
        ViewGroup viewGroup = null;
        if (parentFragment != null) {
            callback = parentFragment.getView();
        } else {
            callback = null;
        }
        if (callback instanceof ViewGroup) {
            viewGroup = (ViewGroup) callback;
        }
        if (!(viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null || (view2 = (View) SequencesKt___SequencesKt.firstOrNull(children)) == null)) {
            view2.setPadding(0, 0, 0, 0);
        }
        ((ImageView) view.findViewById(R.id.close_button)).setOnClickListener(new k(this));
    }
}
