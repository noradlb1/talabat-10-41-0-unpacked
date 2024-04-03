package com.talabat.secure_payment_redirection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import pu.a;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionWebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "initBackPressCallback", "", "initToolbar", "initWebView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"SetJavaScriptEnabled"})
public final class SecurePaymentRedirectionWebViewActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    private final void initBackPressCallback() {
        getOnBackPressedDispatcher().addCallback(this, new SecurePaymentRedirectionWebViewActivity$initBackPressCallback$1(this));
    }

    private final void initToolbar() {
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(R.id.toolbar);
        setSupportActionBar(materialToolbar);
        materialToolbar.setNavigationOnClickListener(new a(this));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) "");
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowHomeEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initToolbar$lambda-0  reason: not valid java name */
    public static final void m10895initToolbar$lambda0(SecurePaymentRedirectionWebViewActivity securePaymentRedirectionWebViewActivity, View view) {
        Intrinsics.checkNotNullParameter(securePaymentRedirectionWebViewActivity, "this$0");
        securePaymentRedirectionWebViewActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    private final void initWebView() {
        WebView webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new SecurePaymentRedirectionWebViewActivity$initWebView$1(this, (ProgressBar) findViewById(R.id.progress_bar)));
        String stringExtra = getIntent().getStringExtra("redirectUrl");
        if (stringExtra == null) {
            stringExtra = "";
        }
        webView.loadUrl(stringExtra);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SecurePaymentRedirectionWebViewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SecurePaymentRedirectionWebViewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SecurePaymentRedirectionWebViewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_secure_payment_redirection_web_view);
        initToolbar();
        initWebView();
        initBackPressCallback();
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
