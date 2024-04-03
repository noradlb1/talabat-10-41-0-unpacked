package com.pichillilorenzo.flutter_inappwebview.headless_in_app_webview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.Util;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.FlutterWebView;
import com.pichillilorenzo.flutter_inappwebview.types.Size2D;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;

public class HeadlessInAppWebView implements MethodChannel.MethodCallHandler {
    protected static final String LOG_TAG = "HeadlessInAppWebView";
    public final MethodChannel channel;
    public FlutterWebView flutterWebView;

    /* renamed from: id  reason: collision with root package name */
    public final String f52872id;
    public InAppWebViewFlutterPlugin plugin;

    public HeadlessInAppWebView(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin, String str, FlutterWebView flutterWebView2) {
        this.f52872id = str;
        this.plugin = inAppWebViewFlutterPlugin;
        this.flutterWebView = flutterWebView2;
        BinaryMessenger binaryMessenger = inAppWebViewFlutterPlugin.messenger;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_headless_inappwebview_" + str);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void dispose() {
        Activity activity;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        FlutterWebView flutterWebView2;
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        Map<String, HeadlessInAppWebView> map = HeadlessInAppWebViewManager.webViews;
        if (map.containsKey(this.f52872id)) {
            map.put(this.f52872id, (Object) null);
        }
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (!(inAppWebViewFlutterPlugin == null || (activity = inAppWebViewFlutterPlugin.activity) == null || (viewGroup = (ViewGroup) activity.findViewById(16908290)) == null || (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) == null || (flutterWebView2 = this.flutterWebView) == null)) {
            viewGroup2.removeView(flutterWebView2.getView());
        }
        FlutterWebView flutterWebView3 = this.flutterWebView;
        if (flutterWebView3 != null) {
            flutterWebView3.dispose();
        }
        this.flutterWebView = null;
        this.plugin = null;
    }

    public Size2D getSize() {
        View view;
        FlutterWebView flutterWebView2 = this.flutterWebView;
        if (flutterWebView2 == null || flutterWebView2.webView == null || (view = flutterWebView2.getView()) == null) {
            return null;
        }
        float pixelDensity = Util.getPixelDensity(view.getContext());
        Size2D fullscreenSize = Util.getFullscreenSize(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        double width = fullscreenSize.getWidth();
        int i11 = layoutParams.width;
        double d11 = (double) i11;
        if (width != d11) {
            d11 = (double) (((float) i11) / pixelDensity);
        }
        double height = fullscreenSize.getHeight();
        int i12 = layoutParams.height;
        double d12 = (double) i12;
        if (height != d12) {
            d12 = (double) (((float) i12) / pixelDensity);
        }
        return new Size2D(d11, d12);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Object obj;
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -75151241:
                if (str.equals("getSize")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1671767583:
                if (str.equals("dispose")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1984958339:
                if (str.equals("setSize")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                Size2D size = getSize();
                if (size == null) {
                    obj = null;
                    break;
                } else {
                    obj = size.toMap();
                    break;
                }
            case 1:
                dispose();
                break;
            case 2:
                Size2D fromMap = Size2D.fromMap((Map) methodCall.argument(BindingAdaptersKt.QUERY_SIZE));
                if (fromMap != null) {
                    setSize(fromMap);
                    break;
                }
                break;
            default:
                result.notImplemented();
                return;
        }
        obj = Boolean.TRUE;
        result.success(obj);
    }

    public void onWebViewCreated() {
        this.channel.invokeMethod("onWebViewCreated", new HashMap());
    }

    public void prepare(Map<String, Object> map) {
        Activity activity;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        FlutterWebView flutterWebView2;
        View view;
        View view2;
        FlutterWebView flutterWebView3 = this.flutterWebView;
        if (!(flutterWebView3 == null || (view2 = flutterWebView3.getView()) == null)) {
            Size2D fromMap = Size2D.fromMap((Map) map.get("initialSize"));
            if (fromMap == null) {
                fromMap = new Size2D(-1.0d, -1.0d);
            }
            setSize(fromMap);
            view2.setVisibility(4);
        }
        InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
        if (inAppWebViewFlutterPlugin != null && (activity = inAppWebViewFlutterPlugin.activity) != null && (viewGroup = (ViewGroup) activity.findViewById(16908290)) != null && (viewGroup2 = (ViewGroup) viewGroup.getChildAt(0)) != null && (flutterWebView2 = this.flutterWebView) != null && (view = flutterWebView2.getView()) != null) {
            viewGroup2.addView(view, 0);
        }
    }

    public void setSize(Size2D size2D) {
        View view;
        FlutterWebView flutterWebView2 = this.flutterWebView;
        if (flutterWebView2 != null && flutterWebView2.webView != null && (view = flutterWebView2.getView()) != null) {
            float pixelDensity = Util.getPixelDensity(view.getContext());
            Size2D fullscreenSize = Util.getFullscreenSize(view.getContext());
            view.setLayoutParams(new FrameLayout.LayoutParams((int) (size2D.getWidth() == -1.0d ? fullscreenSize.getWidth() : size2D.getWidth() * ((double) pixelDensity)), (int) (size2D.getWidth() == -1.0d ? fullscreenSize.getHeight() : ((double) pixelDensity) * size2D.getHeight())));
        }
    }
}
