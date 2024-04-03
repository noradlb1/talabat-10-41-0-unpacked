package io.flutter.plugins.urllauncher;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Instrumented
public class WebViewActivity extends Activity implements TraceFieldInterface {
    public static String ACTION_CLOSE = "close action";
    private static String ENABLE_DOM_EXTRA = "enableDomStorage";
    private static String ENABLE_JS_EXTRA = "enableJavaScript";
    private static String URL_EXTRA = "url";
    public Trace _nr_trace;
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (WebViewActivity.ACTION_CLOSE.equals(intent.getAction())) {
                WebViewActivity.this.finish();
            }
        }
    };
    private IntentFilter closeIntentFilter = new IntentFilter(ACTION_CLOSE);
    private final WebViewClient webViewClient = new WebViewClient() {
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @RequiresApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            webView.loadUrl(webResourceRequest.getUrl().toString());
            return false;
        }
    };
    /* access modifiers changed from: private */
    public WebView webview;

    public class FlutterWebChromeClient extends WebChromeClient {
        private FlutterWebChromeClient() {
        }

        public boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
            AnonymousClass1 r12 = new WebViewClient() {
                @TargetApi(21)
                public boolean shouldOverrideUrlLoading(@NonNull WebView webView, @NonNull WebResourceRequest webResourceRequest) {
                    WebViewActivity.this.webview.loadUrl(webResourceRequest.getUrl().toString());
                    return true;
                }

                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    WebViewActivity.this.webview.loadUrl(str);
                    return true;
                }
            };
            WebView webView2 = new WebView(WebViewActivity.this.webview.getContext());
            webView2.setWebViewClient(r12);
            ((WebView.WebViewTransport) message.obj).setWebView(webView2);
            message.sendToTarget();
            return true;
        }
    }

    public static Intent createIntent(Context context, String str, boolean z11, boolean z12, Bundle bundle) {
        return new Intent(context, WebViewActivity.class).putExtra(URL_EXTRA, str).putExtra(ENABLE_JS_EXTRA, z11).putExtra(ENABLE_DOM_EXTRA, z12).putExtra("com.android.browser.headers", bundle);
    }

    private Map<String, String> extractHeaders(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            hashMap.put(next, bundle.getString(next));
        }
        return hashMap;
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("WebViewActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "WebViewActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WebViewActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.webview = webView;
        setContentView(webView);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(URL_EXTRA);
        boolean booleanExtra = intent.getBooleanExtra(ENABLE_JS_EXTRA, false);
        boolean booleanExtra2 = intent.getBooleanExtra(ENABLE_DOM_EXTRA, false);
        this.webview.loadUrl(stringExtra, extractHeaders(intent.getBundleExtra("com.android.browser.headers")));
        this.webview.getSettings().setJavaScriptEnabled(booleanExtra);
        this.webview.getSettings().setDomStorageEnabled(booleanExtra2);
        this.webview.setWebViewClient(this.webViewClient);
        this.webview.getSettings().setSupportMultipleWindows(true);
        this.webview.setWebChromeClient(new FlutterWebChromeClient());
        registerReceiver(this.broadcastReceiver, this.closeIntentFilter);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.broadcastReceiver);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4 || !this.webview.canGoBack()) {
            return super.onKeyDown(i11, keyEvent);
        }
        this.webview.goBack();
        return true;
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
