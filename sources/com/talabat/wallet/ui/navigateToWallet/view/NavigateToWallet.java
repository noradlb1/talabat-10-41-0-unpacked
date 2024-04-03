package com.talabat.wallet.ui.navigateToWallet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.walletCardManagement.view.walletCardList.WalletCardManagementActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import my.a;
import my.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/ui/navigateToWallet/view/NavigateToWallet;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavigateToWallet extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m6011onCreate$lambda0(NavigateToWallet navigateToWallet, View view) {
        Intrinsics.checkNotNullParameter(navigateToWallet, "this$0");
        navigateToWallet.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m6012onCreate$lambda1(NavigateToWallet navigateToWallet, View view) {
        Intrinsics.checkNotNullParameter(navigateToWallet, "this$0");
        navigateToWallet.startActivity(new Intent(navigateToWallet, WalletCardManagementActivity.class));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("NavigateToWallet");
        try {
            TraceMachine.enterMethod(this._nr_trace, "NavigateToWallet#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NavigateToWallet#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_navigate_to_wallet);
        ((ImageButton) _$_findCachedViewById(R.id.back_icon)).setOnClickListener(new a(this));
        ((TalabatFillButton) _$_findCachedViewById(R.id.got_to_wallet_button)).setOnClickListener(new b(this));
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
