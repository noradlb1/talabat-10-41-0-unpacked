package io.flutter.plugins.webviewflutter;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e00.a0;
import e00.e0;
import e00.h1;
import e00.i;
import e00.k1;
import e00.l;
import e00.m4;
import e00.n4;
import e00.p;
import e00.r0;
import e00.s;
import e00.u;
import e00.u1;
import e00.x;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugins.webviewflutter.DownloadListenerHostApiImpl;
import io.flutter.plugins.webviewflutter.FlutterAssetManager;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.JavaScriptChannelHostApiImpl;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebSettingsHostApiImpl;
import io.flutter.plugins.webviewflutter.WebStorageHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewClientHostApiImpl;
import io.flutter.plugins.webviewflutter.WebViewHostApiImpl;

public class WebViewFlutterPlugin implements FlutterPlugin, ActivityAware {
    @Nullable
    private InstanceManager instanceManager;
    private JavaScriptChannelHostApiImpl javaScriptChannelHostApi;
    private FlutterPlugin.FlutterPluginBinding pluginBinding;
    private WebViewHostApiImpl webViewHostApi;

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUp$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUp$2() {
        this.instanceManager.clear();
    }

    public static void registerWith(@NonNull PluginRegistry.Registrar registrar) {
        new WebViewFlutterPlugin().setUp(registrar.messenger(), registrar.platformViewRegistry(), registrar.activity(), new FlutterAssetManager.RegistrarFlutterAssetManager(registrar.context().getAssets(), registrar));
    }

    private void setUp(BinaryMessenger binaryMessenger, PlatformViewRegistry platformViewRegistry, Context context, FlutterAssetManager flutterAssetManager) {
        this.instanceManager = InstanceManager.create(new m4(binaryMessenger));
        u.c(binaryMessenger, new n4(this));
        platformViewRegistry.registerViewFactory("plugins.flutter.io/webview", new FlutterViewFactory(this.instanceManager));
        this.webViewHostApi = new WebViewHostApiImpl(this.instanceManager, binaryMessenger, new WebViewHostApiImpl.WebViewProxy(), context);
        this.javaScriptChannelHostApi = new JavaScriptChannelHostApiImpl(this.instanceManager, new JavaScriptChannelHostApiImpl.JavaScriptChannelCreator(), new JavaScriptChannelFlutterApiImpl(binaryMessenger, this.instanceManager), new Handler(context.getMainLooper()));
        x.c(binaryMessenger, new JavaObjectHostApiImpl(this.instanceManager));
        GeneratedAndroidWebView.WebViewHostApi.CC.B(binaryMessenger, this.webViewHostApi);
        a0.c(binaryMessenger, this.javaScriptChannelHostApi);
        u1.d(binaryMessenger, new WebViewClientHostApiImpl(this.instanceManager, new WebViewClientHostApiImpl.WebViewClientCreator(), new WebViewClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        r0.e(binaryMessenger, new WebChromeClientHostApiImpl(this.instanceManager, new WebChromeClientHostApiImpl.WebChromeClientCreator(), new WebChromeClientFlutterApiImpl(binaryMessenger, this.instanceManager)));
        l.c(binaryMessenger, new DownloadListenerHostApiImpl(this.instanceManager, new DownloadListenerHostApiImpl.DownloadListenerCreator(), new DownloadListenerFlutterApiImpl(binaryMessenger, this.instanceManager)));
        h1.q(binaryMessenger, new WebSettingsHostApiImpl(this.instanceManager, new WebSettingsHostApiImpl.WebSettingsCreator()));
        p.d(binaryMessenger, new FlutterAssetManagerHostApiImpl(flutterAssetManager));
        GeneratedAndroidWebView.CookieManagerHostApi.CC.f(binaryMessenger, new CookieManagerHostApiImpl(binaryMessenger, this.instanceManager));
        k1.d(binaryMessenger, new WebStorageHostApiImpl(this.instanceManager, new WebStorageHostApiImpl.WebStorageCreator()));
        e0.d(binaryMessenger, new PermissionRequestHostApiImpl(binaryMessenger, this.instanceManager));
        s.c(binaryMessenger, new GeolocationPermissionsCallbackHostApiImpl(binaryMessenger, this.instanceManager));
        i.c(binaryMessenger, new CustomViewCallbackHostApiImpl(binaryMessenger, this.instanceManager));
    }

    private void updateContext(Context context) {
        this.webViewHostApi.setContext(context);
        this.javaScriptChannelHostApi.setPlatformThreadHandler(new Handler(context.getMainLooper()));
    }

    @Nullable
    public InstanceManager getInstanceManager() {
        return this.instanceManager;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.pluginBinding = flutterPluginBinding;
        setUp(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getPlatformViewRegistry(), flutterPluginBinding.getApplicationContext(), new FlutterAssetManager.PluginBindingFlutterAssetManager(flutterPluginBinding.getApplicationContext().getAssets(), flutterPluginBinding.getFlutterAssets()));
    }

    public void onDetachedFromActivity() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromActivityForConfigChanges() {
        updateContext(this.pluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        InstanceManager instanceManager2 = this.instanceManager;
        if (instanceManager2 != null) {
            instanceManager2.stopFinalizationListener();
            this.instanceManager = null;
        }
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {
        updateContext(activityPluginBinding.getActivity());
    }
}
