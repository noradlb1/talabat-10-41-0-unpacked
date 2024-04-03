package com.braze.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.appboy.ui.R;
import com.braze.ui.support.ViewUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/BrazeWebViewActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "createWebChromeClient", "Landroid/webkit/WebChromeClient;", "createWebViewClient", "Landroid/webkit/WebViewClient;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"SetJavaScriptEnabled"})
public class BrazeWebViewActivity extends FragmentActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    @NotNull
    public WebChromeClient createWebChromeClient() {
        return new BrazeWebViewActivity$createWebChromeClient$1();
    }

    @NotNull
    public WebViewClient createWebViewClient() {
        return new BrazeWebViewActivity$createWebViewClient$1(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        String string;
        TraceMachine.startTracing("BrazeWebViewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "BrazeWebViewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BrazeWebViewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(R.layout.com_braze_webview_activity);
        WebView webView = (WebView) findViewById(R.id.com_braze_webview_activity_webview);
        webView.setLayerType(2, (Paint) null);
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setAllowFileAccess(false);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "this.applicationContext");
        if (ViewUtils.isDeviceInNightMode(applicationContext)) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 33) {
                settings.setAlgorithmicDarkeningAllowed(true);
            } else if (i11 >= 29) {
                settings.setForceDark(2);
            }
        }
        webView.setWebChromeClient(createWebChromeClient());
        webView.setWebViewClient(createWebViewClient());
        Bundle extras = getIntent().getExtras();
        if (!(extras == null || (string = extras.getString("url")) == null)) {
            webView.loadUrl(string);
        }
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
