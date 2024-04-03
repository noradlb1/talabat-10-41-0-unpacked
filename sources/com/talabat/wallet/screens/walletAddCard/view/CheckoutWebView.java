package com.talabat.wallet.screens.walletAddCard.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/wallet/screens/walletAddCard/view/CheckoutWebView;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "EMPTY_STRING", "", "ERROR", "PAYMENT_ERROR", "RESULT_CODE", "", "SOURCE", "STATUS", "SUCCESS", "THANK_YOU", "TLIFE", "TOP_UP_SCREEN", "URL", "navigateToSubscriptionDetailScreen", "", "subscriptionMemberId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutWebView extends AppCompatActivity implements TraceFieldInterface {
    /* access modifiers changed from: private */
    @NotNull
    public final String EMPTY_STRING = "";
    /* access modifiers changed from: private */
    @NotNull
    public final String ERROR = "error";
    /* access modifiers changed from: private */
    @NotNull
    public final String PAYMENT_ERROR = "PaymentError";
    /* access modifiers changed from: private */
    public final int RESULT_CODE = 2;
    /* access modifiers changed from: private */
    @NotNull
    public final String SOURCE = "source";
    /* access modifiers changed from: private */
    @NotNull
    public final String STATUS = "status";
    /* access modifiers changed from: private */
    @NotNull
    public final String SUCCESS = "success";
    /* access modifiers changed from: private */
    @NotNull
    public final String THANK_YOU = "ThankYou";
    @NotNull
    private final String TLIFE = "tlife";
    /* access modifiers changed from: private */
    @NotNull
    public final String TOP_UP_SCREEN = "top up screen";
    @NotNull
    private final String URL = "url";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    /* access modifiers changed from: private */
    public final void navigateToSubscriptionDetailScreen(String str) {
        if (str != null) {
            Navigator.Companion.navigate((Context) this, WalletNavigatorActions.Companion.createSubscriptionDetailNavigation(str, WalletNavigatorActions.OPEN_WALLET_ADD_CARD_WEB_VIEW, "talabat.action.Wallet.SubscriptionDetailActivity", true));
            LogManager.debug("member id last " + str);
        }
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
        TraceMachine.startTracing("CheckoutWebView");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CheckoutWebView#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CheckoutWebView#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_checkout_web_view);
        String stringExtra = getIntent().getStringExtra(this.URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        int i11 = R.id.wallet_web_view;
        ((WebView) _$_findCachedViewById(i11)).getSettings().setJavaScriptEnabled(true);
        ((WebView) _$_findCachedViewById(i11)).loadUrl(stringExtra);
        ((WebView) _$_findCachedViewById(i11)).setWebViewClient(new CheckoutWebView$onCreate$1(this));
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
