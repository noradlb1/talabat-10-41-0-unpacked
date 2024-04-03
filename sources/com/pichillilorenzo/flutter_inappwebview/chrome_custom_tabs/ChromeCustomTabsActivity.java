package com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.exoplayer2.C;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.R;
import com.pichillilorenzo.flutter_inappwebview.chrome_custom_tabs.CustomTabActivityHelper;
import com.pichillilorenzo.flutter_inappwebview.types.CustomTabsActionButton;
import com.pichillilorenzo.flutter_inappwebview.types.CustomTabsMenuItem;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Instrumented
public class ChromeCustomTabsActivity extends Activity implements MethodChannel.MethodCallHandler, TraceFieldInterface {
    protected static final String LOG_TAG = "CustomTabsActivity";
    protected final int CHROME_CUSTOM_TAB_REQUEST_CODE = 100;
    public Trace _nr_trace;
    public CustomTabsActionButton actionButton;
    public CustomTabsIntent.Builder builder;
    public MethodChannel channel;
    public CustomTabActivityHelper customTabActivityHelper = new CustomTabActivityHelper();
    public CustomTabsSession customTabsSession;

    /* renamed from: id  reason: collision with root package name */
    public String f52869id;
    public String initialUrl;
    public ChromeSafariBrowserManager manager;
    public List<CustomTabsMenuItem> menuItems = new ArrayList();
    protected boolean onChromeSafariBrowserCompletedInitialLoad = false;
    protected boolean onChromeSafariBrowserOpened = false;
    public ChromeCustomTabsOptions options;

    private PendingIntent createPendingIntent(int i11) {
        if (this.manager == null) {
            return null;
        }
        Intent intent = new Intent(this, ActionBroadcastReceiver.class);
        Bundle bundle = new Bundle();
        bundle.putInt(ActionBroadcastReceiver.KEY_ACTION_ID, i11);
        bundle.putString(ActionBroadcastReceiver.KEY_ACTION_VIEW_ID, this.f52869id);
        bundle.putString(ActionBroadcastReceiver.CHROME_MANAGER_ID, this.manager.f52870id);
        intent.putExtras(bundle);
        return PendingIntent.getBroadcast(this, i11, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : C.BUFFER_FLAG_FIRST_SAMPLE);
    }

    private void prepareCustomTabs() {
        ChromeCustomTabsOptions chromeCustomTabsOptions = this.options;
        Boolean bool = chromeCustomTabsOptions.addDefaultShareMenuItem;
        if (bool != null) {
            this.builder.setShareState(bool.booleanValue() ? 1 : 2);
        } else {
            this.builder.setShareState(chromeCustomTabsOptions.shareState.intValue());
        }
        String str = this.options.toolbarBackgroundColor;
        if (str != null && !str.isEmpty()) {
            this.builder.setDefaultColorSchemeParams(new CustomTabColorSchemeParams.Builder().setToolbarColor(Color.parseColor(this.options.toolbarBackgroundColor)).build());
        }
        this.builder.setShowTitle(this.options.showTitle.booleanValue());
        this.builder.setUrlBarHidingEnabled(this.options.enableUrlBarHiding.booleanValue());
        this.builder.setInstantAppsEnabled(this.options.instantAppsEnabled.booleanValue());
        for (CustomTabsMenuItem next : this.menuItems) {
            PendingIntent createPendingIntent = createPendingIntent(next.getId());
            if (createPendingIntent != null) {
                this.builder.addMenuItem(next.getLabel(), createPendingIntent);
            }
        }
        CustomTabsActionButton customTabsActionButton = this.actionButton;
        if (customTabsActionButton != null) {
            byte[] icon = customTabsActionButton.getIcon();
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inMutable = true;
            Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(icon, 0, icon.length, options2);
            PendingIntent createPendingIntent2 = createPendingIntent(this.actionButton.getId());
            if (createPendingIntent2 != null) {
                this.builder.setActionButton(decodeByteArray, this.actionButton.getDescription(), createPendingIntent2, this.actionButton.isShouldTint());
            }
        }
    }

    private void prepareCustomTabsIntent(CustomTabsIntent customTabsIntent) {
        String str = this.options.packageName;
        if (str != null) {
            customTabsIntent.intent.setPackage(str);
        } else {
            customTabsIntent.intent.setPackage(CustomTabsHelper.getPackageNameToUse(this));
        }
        if (this.options.keepAliveEnabled.booleanValue()) {
            CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent);
        }
    }

    public void close() {
        onStop();
        onDestroy();
        this.customTabsSession = null;
        finish();
        this.channel.invokeMethod("onChromeSafariBrowserClosed", new HashMap());
    }

    public void customTabsConnected() {
        this.customTabsSession = this.customTabActivityHelper.getSession();
        Uri parse = Uri.parse(this.initialUrl);
        this.customTabActivityHelper.mayLaunchUrl(parse, (Bundle) null, (List<Bundle>) null);
        this.builder = new CustomTabsIntent.Builder(this.customTabsSession);
        prepareCustomTabs();
        CustomTabsIntent build = this.builder.build();
        prepareCustomTabsIntent(build);
        CustomTabActivityHelper.openCustomTab((Activity) this, build, parse, 100);
    }

    public void dispose() {
        onStop();
        onDestroy();
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.manager = null;
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == 100) {
            close();
            dispose();
        }
    }

    public void onCreate(Bundle bundle) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        BinaryMessenger binaryMessenger;
        TraceMachine.startTracing("ChromeCustomTabsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ChromeCustomTabsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ChromeCustomTabsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.chrome_custom_tabs_layout);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            TraceMachine.exitMethod();
            return;
        }
        this.f52869id = extras.getString("id");
        ChromeSafariBrowserManager chromeSafariBrowserManager = ChromeSafariBrowserManager.shared.get(extras.getString("managerId"));
        this.manager = chromeSafariBrowserManager;
        if (chromeSafariBrowserManager == null || (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) == null || (binaryMessenger = inAppWebViewFlutterPlugin.messenger) == null) {
            TraceMachine.exitMethod();
            return;
        }
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_chromesafaribrowser_" + this.f52869id);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.initialUrl = extras.getString("url");
        ChromeCustomTabsOptions chromeCustomTabsOptions = new ChromeCustomTabsOptions();
        this.options = chromeCustomTabsOptions;
        chromeCustomTabsOptions.parse((Map) extras.getSerializable("options"));
        this.actionButton = CustomTabsActionButton.fromMap((Map) extras.getSerializable("actionButton"));
        for (Map fromMap : (List) extras.getSerializable("menuItemList")) {
            this.menuItems.add(CustomTabsMenuItem.fromMap(fromMap));
        }
        this.customTabActivityHelper.setConnectionCallback(new CustomTabActivityHelper.ConnectionCallback() {
            public void onCustomTabsConnected() {
                ChromeCustomTabsActivity.this.customTabsConnected();
            }

            public void onCustomTabsDisconnected() {
                this.close();
                ChromeCustomTabsActivity.this.dispose();
            }
        });
        this.customTabActivityHelper.setCustomTabsCallback(new CustomTabsCallback() {
            public void extraCallback(String str, Bundle bundle) {
            }

            public void onMessageChannelReady(Bundle bundle) {
            }

            public void onNavigationEvent(int i11, Bundle bundle) {
                if (i11 == 5) {
                    ChromeCustomTabsActivity chromeCustomTabsActivity = ChromeCustomTabsActivity.this;
                    if (!chromeCustomTabsActivity.onChromeSafariBrowserOpened) {
                        chromeCustomTabsActivity.onChromeSafariBrowserOpened = true;
                        ChromeCustomTabsActivity.this.channel.invokeMethod("onChromeSafariBrowserOpened", new HashMap());
                    }
                }
                if (i11 == 2) {
                    ChromeCustomTabsActivity chromeCustomTabsActivity2 = ChromeCustomTabsActivity.this;
                    if (!chromeCustomTabsActivity2.onChromeSafariBrowserCompletedInitialLoad) {
                        chromeCustomTabsActivity2.onChromeSafariBrowserCompletedInitialLoad = true;
                        ChromeCustomTabsActivity.this.channel.invokeMethod("onChromeSafariBrowserCompletedInitialLoad", new HashMap());
                    }
                }
            }

            public void onPostMessage(String str, Bundle bundle) {
            }

            public void onRelationshipValidationResult(int i11, Uri uri, boolean z11, Bundle bundle) {
            }
        });
        TraceMachine.exitMethod();
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin;
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("close")) {
            result.notImplemented();
            return;
        }
        onStop();
        onDestroy();
        close();
        ChromeSafariBrowserManager chromeSafariBrowserManager = this.manager;
        if (!(chromeSafariBrowserManager == null || (inAppWebViewFlutterPlugin = chromeSafariBrowserManager.plugin) == null || inAppWebViewFlutterPlugin.activity == null)) {
            Activity activity = this.manager.plugin.activity;
            Intent intent = new Intent(activity, activity.getClass());
            intent.addFlags(67108864);
            intent.addFlags(536870912);
            this.manager.plugin.activity.startActivity(intent);
        }
        dispose();
        result.success(Boolean.TRUE);
    }

    public void onStart() {
        ApplicationStateMonitor.getInstance().activityStarted();
        super.onStart();
        this.customTabActivityHelper.bindCustomTabsService(this);
    }

    public void onStop() {
        ApplicationStateMonitor.getInstance().activityStopped();
        super.onStop();
        this.customTabActivityHelper.unbindCustomTabsService(this);
    }
}
