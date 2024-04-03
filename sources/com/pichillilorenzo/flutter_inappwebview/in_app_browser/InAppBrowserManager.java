package com.pichillilorenzo.flutter_inappwebview.in_app_browser;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InAppBrowserManager implements MethodChannel.MethodCallHandler {
    protected static final String LOG_TAG = "InAppBrowserManager";
    public static final Map<String, InAppBrowserManager> shared = new HashMap();
    public MethodChannel channel;

    /* renamed from: id  reason: collision with root package name */
    public String f52874id = UUID.randomUUID().toString();
    public InAppWebViewFlutterPlugin plugin;

    public InAppBrowserManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappbrowser");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        shared.put(this.f52874id, this);
    }

    public static String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        shared.remove(this.f52874id);
        this.plugin = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        Boolean bool;
        Activity activity;
        String str = methodCall.method;
        str.hashCode();
        if (str.equals("openWithSystemBrowser")) {
            InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin = this.plugin;
            if (!(inAppWebViewFlutterPlugin == null || inAppWebViewFlutterPlugin.activity == null)) {
                openWithSystemBrowser(this.plugin.activity, (String) methodCall.argument("url"), result);
                return;
            }
        } else if (!str.equals("open")) {
            result.notImplemented();
            return;
        } else {
            InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin2 = this.plugin;
            if (!(inAppWebViewFlutterPlugin2 == null || (activity = inAppWebViewFlutterPlugin2.activity) == null)) {
                open(activity, (Map) methodCall.arguments());
                bool = Boolean.TRUE;
                result.success(bool);
            }
        }
        bool = Boolean.FALSE;
        result.success(bool);
    }

    public void open(Activity activity, Map<String, Object> map) {
        Map<String, Object> map2 = map;
        Integer num = (Integer) map2.get("windowId");
        String str = "windowId";
        List list = (List) map2.get("initialUserScripts");
        String str2 = "initialUserScripts";
        Bundle bundle = new Bundle();
        Map map3 = (Map) map2.get("pullToRefreshOptions");
        bundle.putString("fromActivity", activity.getClass().getName());
        bundle.putSerializable("initialUrlRequest", (Serializable) ((Map) map2.get("urlRequest")));
        bundle.putString("initialFile", (String) map2.get("assetFilePath"));
        bundle.putString("initialData", (String) map2.get("data"));
        bundle.putString("initialMimeType", (String) map2.get("mimeType"));
        bundle.putString("initialEncoding", (String) map2.get("encoding"));
        bundle.putString("initialBaseUrl", (String) map2.get("baseUrl"));
        bundle.putString("initialHistoryUrl", (String) map2.get("historyUrl"));
        bundle.putString("id", (String) map2.get("id"));
        bundle.putString("managerId", this.f52874id);
        bundle.putSerializable("options", (Serializable) ((Map) map2.get("options")));
        bundle.putSerializable("contextMenu", (Serializable) ((Map) map2.get("contextMenu")));
        bundle.putInt(str, num != null ? num.intValue() : -1);
        bundle.putSerializable(str2, (Serializable) list);
        bundle.putSerializable("pullToRefreshInitialOptions", (Serializable) map3);
        startInAppBrowserActivity(activity, bundle);
    }

    public void openExternalExcludeCurrentApp(Activity activity, Intent intent) {
        String packageName = activity.getPackageName();
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (ResolveInfo next : queryIntentActivities) {
            if (!packageName.equals(next.activityInfo.packageName)) {
                Intent intent2 = (Intent) intent.clone();
                intent2.setPackage(next.activityInfo.packageName);
                arrayList.add(intent2);
            } else {
                z11 = true;
            }
        }
        if (z11 && arrayList.size() != 0) {
            if (arrayList.size() == 1) {
                intent = (Intent) arrayList.get(0);
            } else if (arrayList.size() > 0) {
                intent = Intent.createChooser((Intent) arrayList.remove(arrayList.size() - 1), (CharSequence) null);
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
            } else {
                return;
            }
        }
        activity.startActivity(intent);
    }

    public void openWithSystemBrowser(Activity activity, String str, MethodChannel.Result result) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri parse = Uri.parse(str);
            if ("file".equals(parse.getScheme())) {
                intent.setDataAndType(parse, getMimeType(str));
            } else {
                intent.setData(parse);
            }
            intent.putExtra("com.android.browser.application_id", activity.getPackageName());
            openExternalExcludeCurrentApp(activity, intent);
            result.success(Boolean.TRUE);
        } catch (RuntimeException e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" cannot be opened: ");
            sb2.append(e11.toString());
            result.error(LOG_TAG, str + " cannot be opened!", (Object) null);
        }
    }

    public void startInAppBrowserActivity(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, InAppBrowserActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
    }
}
