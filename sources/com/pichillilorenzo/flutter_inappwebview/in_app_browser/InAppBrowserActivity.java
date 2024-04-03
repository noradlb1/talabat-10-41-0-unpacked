package com.pichillilorenzo.flutter_inappwebview.in_app_browser;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.SearchView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewMethodHandler;
import com.pichillilorenzo.flutter_inappwebview.R;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewChromeClient;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebViewOptions;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshLayout;
import com.pichillilorenzo.flutter_inappwebview.pull_to_refresh.PullToRefreshOptions;
import com.pichillilorenzo.flutter_inappwebview.types.URLRequest;
import com.pichillilorenzo.flutter_inappwebview.types.UserScript;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
public class InAppBrowserActivity extends AppCompatActivity implements InAppBrowserDelegate, TraceFieldInterface {
    static final String LOG_TAG = "InAppBrowserActivity";
    public Trace _nr_trace;
    public ActionBar actionBar;
    private List<ActivityResultListener> activityResultListeners = new ArrayList();
    public MethodChannel channel;
    public String fromActivity;

    /* renamed from: id  reason: collision with root package name */
    public String f52873id;
    public boolean isHidden = false;
    public InAppBrowserManager manager;
    public Menu menu;
    public InAppWebViewMethodHandler methodCallDelegate;
    public InAppBrowserOptions options = new InAppBrowserOptions();
    public ProgressBar progressBar;
    public PullToRefreshLayout pullToRefreshLayout;
    public SearchView searchView;
    public InAppWebView webView;
    public Integer windowId;

    private void prepareView() {
        int i11;
        ProgressBar progressBar2;
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.prepare();
        }
        if (this.options.hidden.booleanValue()) {
            hide();
        } else {
            show();
        }
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        if (this.options.hideProgressBar.booleanValue()) {
            progressBar2 = this.progressBar;
            i11 = 0;
        } else {
            progressBar2 = this.progressBar;
            i11 = 100;
        }
        progressBar2.setMax(i11);
        ActionBar actionBar2 = this.actionBar;
        if (actionBar2 != null) {
            actionBar2.setDisplayShowTitleEnabled(!this.options.hideTitleBar.booleanValue());
            if (this.options.hideToolbarTop.booleanValue()) {
                this.actionBar.hide();
            }
            String str = this.options.toolbarTopBackgroundColor;
            if (str != null && !str.isEmpty()) {
                this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.options.toolbarTopBackgroundColor)));
            }
            String str2 = this.options.toolbarTopFixedTitle;
            if (str2 != null && !str2.isEmpty()) {
                this.actionBar.setTitle((CharSequence) this.options.toolbarTopFixedTitle);
            }
        }
    }

    public boolean canGoBack() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoBack();
        }
        return false;
    }

    public boolean canGoForward() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            return inAppWebView.canGoForward();
        }
        return false;
    }

    public void close(MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("onExit", hashMap);
        }
        dispose();
        if (result != null) {
            result.success(Boolean.TRUE);
        }
    }

    public void closeButtonClicked(MenuItem menuItem) {
        close((MethodChannel.Result) null);
    }

    public void didChangeProgress(int i11) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 24) {
                this.progressBar.setProgress(i11, true);
            } else {
                this.progressBar.setProgress(i11);
            }
            if (i11 == 100) {
                this.progressBar.setVisibility(8);
            }
        }
    }

    public void didChangeTitle(String str) {
        if (this.actionBar != null) {
            String str2 = this.options.toolbarTopFixedTitle;
            if (str2 == null || str2.isEmpty()) {
                this.actionBar.setTitle((CharSequence) str);
            }
        }
    }

    public void didFailNavigation(String str, int i11, String str2) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
    }

    public void didFinishNavigation(String str) {
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
    }

    public void didStartNavigation(String str) {
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(0);
        }
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
    }

    public void didUpdateVisitedHistory(String str) {
        SearchView searchView2 = this.searchView;
        if (searchView2 != null) {
            searchView2.setQuery(str, false);
        }
    }

    public void dispose() {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        ActivityPluginBinding activityPluginBinding;
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
            this.channel = null;
        }
        this.activityResultListeners.clear();
        InAppWebViewMethodHandler inAppWebViewMethodHandler = this.methodCallDelegate;
        if (inAppWebViewMethodHandler != null) {
            inAppWebViewMethodHandler.dispose();
            this.methodCallDelegate = null;
        }
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            InAppBrowserManager inAppBrowserManager = this.manager;
            if (!(inAppBrowserManager == null || (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) == null || (activityPluginBinding = inAppWebViewFlutterPlugin.activityPluginBinding) == null)) {
                activityPluginBinding.removeActivityResultListener(inAppWebView.inAppWebViewChromeClient);
            }
            ViewGroup viewGroup = (ViewGroup) this.webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.webView);
            }
            this.webView.setWebChromeClient(new WebChromeClient());
            this.webView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView webView, String str) {
                    InAppBrowserActivity.this.webView.dispose();
                    InAppBrowserActivity.this.webView.destroy();
                    InAppBrowserActivity inAppBrowserActivity = InAppBrowserActivity.this;
                    inAppBrowserActivity.webView = null;
                    inAppBrowserActivity.manager = null;
                }
            });
            this.webView.loadUrl("about:blank");
            finish();
        }
    }

    public Activity getActivity() {
        return this;
    }

    public List<ActivityResultListener> getActivityResultListeners() {
        return this.activityResultListeners;
    }

    public Map<String, Object> getOptions() {
        InAppWebView inAppWebView = this.webView;
        Map<String, Object> options2 = inAppWebView != null ? inAppWebView.getOptions() : null;
        InAppBrowserOptions inAppBrowserOptions = this.options;
        if (inAppBrowserOptions == null || options2 == null) {
            return null;
        }
        Map<String, Object> realOptions = inAppBrowserOptions.getRealOptions(this);
        realOptions.putAll(options2);
        return realOptions;
    }

    public void goBack() {
        if (this.webView != null && canGoBack()) {
            this.webView.goBack();
        }
    }

    public void goBackButtonClicked(MenuItem menuItem) {
        goBack();
    }

    public void goForward() {
        if (this.webView != null && canGoForward()) {
            this.webView.goForward();
        }
    }

    public void goForwardButtonClicked(MenuItem menuItem) {
        goForward();
    }

    public void hide() {
        if (this.fromActivity != null) {
            try {
                this.isHidden = true;
                Intent intent = new Intent(this, Class.forName(this.fromActivity));
                intent.setFlags(131072);
                startActivityIfNeeded(intent, 0);
            } catch (ClassNotFoundException e11) {
                e11.printStackTrace();
                e11.getMessage();
            }
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        for (ActivityResultListener onActivityResult : this.activityResultListeners) {
            if (onActivityResult.onActivityResult(i11, i12, intent)) {
                return;
            }
        }
        super.onActivityResult(i11, i12, intent);
    }

    public void onBrowserCreated() {
        HashMap hashMap = new HashMap();
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod("onBrowserCreated", hashMap);
        }
    }

    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        TraceMachine.startTracing(LOG_TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "InAppBrowserActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "InAppBrowserActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            TraceMachine.exitMethod();
            return;
        }
        this.f52873id = extras.getString("id");
        InAppBrowserManager inAppBrowserManager = InAppBrowserManager.shared.get(extras.getString("managerId"));
        this.manager = inAppBrowserManager;
        if (inAppBrowserManager == null || (inAppWebViewFlutterPlugin = inAppBrowserManager.plugin) == null || inAppWebViewFlutterPlugin.messenger == null) {
            TraceMachine.exitMethod();
            return;
        }
        Map map = (Map) extras.getSerializable("options");
        this.options.parse(map);
        this.windowId = Integer.valueOf(extras.getInt("windowId"));
        BinaryMessenger binaryMessenger = this.manager.plugin.messenger;
        this.channel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappbrowser_" + this.f52873id);
        setContentView(R.layout.activity_web_view);
        BinaryMessenger binaryMessenger2 = this.manager.plugin.messenger;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger2, "com.pichillilorenzo/flutter_inappwebview_pull_to_refresh_" + this.f52873id);
        PullToRefreshOptions pullToRefreshOptions = new PullToRefreshOptions();
        pullToRefreshOptions.parse((Map) extras.getSerializable("pullToRefreshInitialOptions"));
        PullToRefreshLayout pullToRefreshLayout2 = (PullToRefreshLayout) findViewById(R.id.pullToRefresh);
        this.pullToRefreshLayout = pullToRefreshLayout2;
        pullToRefreshLayout2.channel = methodChannel;
        pullToRefreshLayout2.options = pullToRefreshOptions;
        pullToRefreshLayout2.prepare();
        InAppWebView inAppWebView = (InAppWebView) findViewById(R.id.webView);
        this.webView = inAppWebView;
        inAppWebView.windowId = this.windowId;
        inAppWebView.inAppBrowserDelegate = this;
        inAppWebView.channel = this.channel;
        inAppWebView.plugin = this.manager.plugin;
        InAppWebViewMethodHandler inAppWebViewMethodHandler = new InAppWebViewMethodHandler(inAppWebView);
        this.methodCallDelegate = inAppWebViewMethodHandler;
        this.channel.setMethodCallHandler(inAppWebViewMethodHandler);
        this.fromActivity = extras.getString("fromActivity");
        List<Map> list = (List) extras.getSerializable("initialUserScripts");
        InAppWebViewOptions inAppWebViewOptions = new InAppWebViewOptions();
        inAppWebViewOptions.parse(map);
        InAppWebView inAppWebView2 = this.webView;
        inAppWebView2.options = inAppWebViewOptions;
        inAppWebView2.contextMenu = (Map) extras.getSerializable("contextMenu");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Map fromMap : list) {
                arrayList.add(UserScript.fromMap(fromMap));
            }
        }
        this.webView.userContentController.addUserOnlyScripts(arrayList);
        this.actionBar = getSupportActionBar();
        prepareView();
        if (this.windowId.intValue() != -1) {
            Message message = InAppWebViewChromeClient.windowWebViewMessages.get(this.windowId);
            if (message != null) {
                ((WebView.WebViewTransport) message.obj).setWebView(this.webView);
                message.sendToTarget();
            }
            onBrowserCreated();
        } else {
            String string = extras.getString("initialFile");
            Map map2 = (Map) extras.getSerializable("initialUrlRequest");
            String string2 = extras.getString("initialData");
            if (string != null) {
                try {
                    this.webView.loadFile(string);
                } catch (IOException e11) {
                    e11.printStackTrace();
                    Log.e(LOG_TAG, string + " asset file cannot be found!", e11);
                }
            } else if (string2 != null) {
                String string3 = extras.getString("initialMimeType");
                String string4 = extras.getString("initialEncoding");
                this.webView.loadDataWithBaseURL(extras.getString("initialBaseUrl"), string2, string3, string4, extras.getString("initialHistoryUrl"));
            } else if (map2 != null) {
                this.webView.loadUrl(URLRequest.fromMap(map2));
            }
            onBrowserCreated();
        }
        TraceMachine.exitMethod();
    }

    public boolean onCreateOptionsMenu(Menu menu2) {
        String str;
        this.menu = menu2;
        String str2 = "";
        if (this.actionBar != null && ((str = this.options.toolbarTopFixedTitle) == null || str.isEmpty())) {
            ActionBar actionBar2 = this.actionBar;
            InAppWebView inAppWebView = this.webView;
            actionBar2.setTitle((CharSequence) inAppWebView != null ? inAppWebView.getTitle() : str2);
        }
        if (this.menu == null) {
            return super.onCreateOptionsMenu(menu2);
        }
        getMenuInflater().inflate(R.menu.menu_main, this.menu);
        MenuItem findItem = this.menu.findItem(R.id.menu_search);
        if (findItem != null) {
            if (this.options.hideUrlBar.booleanValue()) {
                findItem.setVisible(false);
            }
            SearchView searchView2 = (SearchView) findItem.getActionView();
            this.searchView = searchView2;
            if (searchView2 != null) {
                searchView2.setFocusable(true);
                SearchView searchView3 = this.searchView;
                InAppWebView inAppWebView2 = this.webView;
                if (inAppWebView2 != null) {
                    str2 = inAppWebView2.getUrl();
                }
                searchView3.setQuery(str2, false);
                this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    public boolean onQueryTextChange(String str) {
                        return false;
                    }

                    public boolean onQueryTextSubmit(String str) {
                        if (str.isEmpty()) {
                            return false;
                        }
                        InAppWebView inAppWebView = InAppBrowserActivity.this.webView;
                        if (inAppWebView != null) {
                            inAppWebView.loadUrl(str);
                        }
                        SearchView searchView = InAppBrowserActivity.this.searchView;
                        if (searchView != null) {
                            searchView.setQuery("", false);
                            InAppBrowserActivity.this.searchView.setIconified(true);
                        }
                        return true;
                    }
                });
                this.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                    public boolean onClose() {
                        SearchView searchView = InAppBrowserActivity.this.searchView;
                        if (searchView != null && searchView.getQuery().toString().isEmpty()) {
                            InAppBrowserActivity inAppBrowserActivity = InAppBrowserActivity.this;
                            SearchView searchView2 = inAppBrowserActivity.searchView;
                            InAppWebView inAppWebView = inAppBrowserActivity.webView;
                            searchView2.setQuery(inAppWebView != null ? inAppWebView.getUrl() : "", false);
                        }
                        return false;
                    }
                });
                this.searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View view, boolean z11) {
                        SearchView searchView;
                        if (!z11 && (searchView = InAppBrowserActivity.this.searchView) != null) {
                            searchView.setQuery("", false);
                            InAppBrowserActivity.this.searchView.setIconified(true);
                        }
                    }
                });
            }
        }
        return true;
    }

    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 4) {
            if (this.options.shouldCloseOnBackButtonPressed.booleanValue()) {
                close((MethodChannel.Result) null);
                return true;
            } else if (this.options.allowGoBackWithBackButton.booleanValue()) {
                if (canGoBack()) {
                    goBack();
                } else if (this.options.closeOnCannotGoBack.booleanValue()) {
                    close((MethodChannel.Result) null);
                }
                return true;
            } else if (!this.options.shouldCloseOnBackButtonPressed.booleanValue()) {
                return true;
            }
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void reload() {
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.reload();
        }
    }

    public void reloadButtonClicked(MenuItem menuItem) {
        reload();
    }

    public void setOptions(InAppBrowserOptions inAppBrowserOptions, HashMap<String, Object> hashMap) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        InAppWebViewOptions inAppWebViewOptions = new InAppWebViewOptions();
        inAppWebViewOptions.parse((Map) hashMap);
        InAppWebView inAppWebView = this.webView;
        if (inAppWebView != null) {
            inAppWebView.setOptions(inAppWebViewOptions, hashMap);
        }
        if (!(hashMap.get("hidden") == null || this.options.hidden == (bool5 = inAppBrowserOptions.hidden))) {
            if (bool5.booleanValue()) {
                hide();
            } else {
                show();
            }
        }
        if (!(hashMap.get("hideProgressBar") == null || this.options.hideProgressBar == (bool4 = inAppBrowserOptions.hideProgressBar) || this.progressBar == null)) {
            if (bool4.booleanValue()) {
                this.progressBar.setMax(0);
            } else {
                this.progressBar.setMax(100);
            }
        }
        if (!(this.actionBar == null || hashMap.get("hideTitleBar") == null || this.options.hideTitleBar == (bool3 = inAppBrowserOptions.hideTitleBar))) {
            this.actionBar.setDisplayShowTitleEnabled(!bool3.booleanValue());
        }
        if (!(this.actionBar == null || hashMap.get("hideToolbarTop") == null || this.options.hideToolbarTop == (bool2 = inAppBrowserOptions.hideToolbarTop))) {
            if (bool2.booleanValue()) {
                this.actionBar.hide();
            } else {
                this.actionBar.show();
            }
        }
        if (this.actionBar != null && hashMap.get("toolbarTopBackgroundColor") != null && !Util.objEquals(this.options.toolbarTopBackgroundColor, inAppBrowserOptions.toolbarTopBackgroundColor) && !inAppBrowserOptions.toolbarTopBackgroundColor.isEmpty()) {
            this.actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(inAppBrowserOptions.toolbarTopBackgroundColor)));
        }
        if (this.actionBar != null && hashMap.get("toolbarTopFixedTitle") != null && !Util.objEquals(this.options.toolbarTopFixedTitle, inAppBrowserOptions.toolbarTopFixedTitle) && !inAppBrowserOptions.toolbarTopFixedTitle.isEmpty()) {
            this.actionBar.setTitle((CharSequence) inAppBrowserOptions.toolbarTopFixedTitle);
        }
        if (!(this.menu == null || hashMap.get("hideUrlBar") == null || this.options.hideUrlBar == (bool = inAppBrowserOptions.hideUrlBar))) {
            if (bool.booleanValue()) {
                this.menu.findItem(R.id.menu_search).setVisible(false);
            } else {
                this.menu.findItem(R.id.menu_search).setVisible(true);
            }
        }
        this.options = inAppBrowserOptions;
    }

    public void shareButtonClicked(MenuItem menuItem) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        InAppWebView inAppWebView = this.webView;
        intent.putExtra("android.intent.extra.TEXT", inAppWebView != null ? inAppWebView.getUrl() : "");
        startActivity(Intent.createChooser(intent, "Share"));
    }

    public void show() {
        this.isHidden = false;
        Intent intent = new Intent(this, InAppBrowserActivity.class);
        intent.setFlags(131072);
        startActivityIfNeeded(intent, 0);
    }
}
