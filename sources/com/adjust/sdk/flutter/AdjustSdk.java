package com.adjust.sdk.flutter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAdRevenue;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustTestOptions;
import com.adjust.sdk.AdjustThirdPartySharing;
import com.adjust.sdk.OnDeviceIdsRead;
import com.google.firebase.perf.util.Constants;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdjustSdk implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {
    private static String TAG = "AdjustBridge";
    /* access modifiers changed from: private */
    public static boolean launchDeferredDeeplink = true;
    private Context applicationContext;
    /* access modifiers changed from: private */
    public MethodChannel channel;

    private void addSessionCallbackParameter(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        if (!methodCall.hasArgument("key") || !methodCall.hasArgument("value")) {
            str = null;
            str2 = null;
        } else {
            str2 = (String) methodCall.argument("key");
            str = (String) methodCall.argument("value");
        }
        Adjust.addSessionCallbackParameter(str2, str);
        result.success((Object) null);
    }

    private void addSessionPartnerParameter(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        String str2;
        if (!methodCall.hasArgument("key") || !methodCall.hasArgument("value")) {
            str = null;
            str2 = null;
        } else {
            str2 = (String) methodCall.argument("key");
            str = (String) methodCall.argument("value");
        }
        Adjust.addSessionPartnerParameter(str2, str);
        result.success((Object) null);
    }

    private void appWillOpenUrl(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        Adjust.appWillOpenUrl(Uri.parse(map.containsKey("url") ? map.get("url").toString() : null), this.applicationContext);
        result.success((Object) null);
    }

    private void checkForNewAttStatus(MethodCall methodCall, MethodChannel.Result result) {
        result.success("Error. No checkForNewAttStatus for Android platform!");
    }

    private void disableThirdPartySharing(MethodChannel.Result result) {
        Adjust.disableThirdPartySharing(this.applicationContext);
        result.success((Object) null);
    }

    private void gdprForgetMe(MethodChannel.Result result) {
        Adjust.gdprForgetMe(this.applicationContext);
        result.success((Object) null);
    }

    private void getAdid(MethodChannel.Result result) {
        result.success(Adjust.getAdid());
    }

    private void getAmazonAdId(MethodChannel.Result result) {
        result.success(Adjust.getAmazonAdId(this.applicationContext));
    }

    private void getAppTrackingAuthorizationStatus(MethodCall methodCall, MethodChannel.Result result) {
        result.success("Error. No getAppTrackingAuthorizationStatus for Android platform!");
    }

    private void getAttribution(MethodChannel.Result result) {
        String str;
        AdjustAttribution attribution = Adjust.getAttribution();
        if (attribution == null) {
            attribution = new AdjustAttribution();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("trackerToken", attribution.trackerToken);
        hashMap.put("trackerName", attribution.trackerName);
        hashMap.put(SDKCoreEvent.Network.TYPE_NETWORK, attribution.network);
        hashMap.put("campaign", attribution.campaign);
        hashMap.put("adgroup", attribution.adgroup);
        hashMap.put("creative", attribution.creative);
        hashMap.put("clickLabel", attribution.clickLabel);
        hashMap.put("adid", attribution.adid);
        hashMap.put("costType", attribution.costType);
        Double d11 = attribution.costAmount;
        if (d11 != null) {
            str = d11.toString();
        } else {
            str = "";
        }
        hashMap.put("costAmount", str);
        hashMap.put("costCurrency", attribution.costCurrency);
        hashMap.put("fbInstallReferrer", attribution.fbInstallReferrer);
        result.success(hashMap);
    }

    private void getGoogleAdId(final MethodChannel.Result result) {
        Adjust.getGoogleAdId(this.applicationContext, new OnDeviceIdsRead() {
            public void onGoogleAdIdRead(String str) {
                result.success(str);
            }
        });
    }

    private void getIdfa(MethodChannel.Result result) {
        result.success("Error. No IDFA on Android platform!");
    }

    private void getLastDeeplink(MethodCall methodCall, MethodChannel.Result result) {
        result.success("Error. No getLastDeeplink for Android platform!");
    }

    private void getSdkVersion(MethodChannel.Result result) {
        result.success(Adjust.getSdkVersion());
    }

    private void isEnabled(MethodChannel.Result result) {
        result.success(Boolean.valueOf(Adjust.isEnabled()));
    }

    private void onPause(MethodChannel.Result result) {
        Adjust.onPause();
        result.success((Object) null);
    }

    private void onResume(MethodChannel.Result result) {
        Adjust.onResume();
        result.success((Object) null);
    }

    private void removeSessionCallbackParameter(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.hasArgument("key")) {
            str = (String) methodCall.argument("key");
        } else {
            str = null;
        }
        Adjust.removeSessionCallbackParameter(str);
        result.success((Object) null);
    }

    private void removeSessionPartnerParameter(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.hasArgument("key")) {
            str = (String) methodCall.argument("key");
        } else {
            str = null;
        }
        Adjust.removeSessionPartnerParameter(str);
        result.success((Object) null);
    }

    private void requestTrackingAuthorizationWithCompletionHandler(MethodChannel.Result result) {
        result.success("Error. No requestTrackingAuthorizationWithCompletionHandler on Android platform!");
    }

    private void resetSessionCallbackParameters(MethodChannel.Result result) {
        Adjust.resetSessionCallbackParameters();
        result.success((Object) null);
    }

    private void resetSessionPartnerParameters(MethodChannel.Result result) {
        Adjust.resetSessionPartnerParameters();
        result.success((Object) null);
    }

    private void sendFirstPackages(MethodChannel.Result result) {
        Adjust.sendFirstPackages();
        result.success((Object) null);
    }

    private void setEnabled(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        if (!map.containsKey(Constants.ENABLE_DISABLE)) {
            result.error("0", "Arguments null or wrong (missing argument of 'isEnabled' method.", (Object) null);
            return;
        }
        Adjust.setEnabled(((Boolean) map.get(Constants.ENABLE_DISABLE)).booleanValue());
        result.success((Object) null);
    }

    private void setOfflineMode(MethodCall methodCall, MethodChannel.Result result) {
        Adjust.setOfflineMode(((Boolean) ((Map) methodCall.arguments).get("isOffline")).booleanValue());
        result.success((Object) null);
    }

    private void setPushToken(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        Map map = (Map) methodCall.arguments;
        if (map.containsKey("pushToken")) {
            str = map.get("pushToken").toString();
        } else {
            str = null;
        }
        Adjust.setPushToken(str, this.applicationContext);
        result.success((Object) null);
    }

    private void setReferrer(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        if (methodCall.hasArgument(com.adjust.sdk.Constants.REFERRER)) {
            str = (String) methodCall.argument(com.adjust.sdk.Constants.REFERRER);
        } else {
            str = null;
        }
        Adjust.setReferrer(str, this.applicationContext);
        result.success((Object) null);
    }

    private void setTestOptions(MethodCall methodCall, MethodChannel.Result result) {
        AdjustTestOptions adjustTestOptions = new AdjustTestOptions();
        Map map = (Map) methodCall.arguments;
        if (map.containsKey("baseUrl")) {
            adjustTestOptions.baseUrl = (String) map.get("baseUrl");
        }
        if (map.containsKey("gdprUrl")) {
            adjustTestOptions.gdprUrl = (String) map.get("gdprUrl");
        }
        if (map.containsKey("subscriptionUrl")) {
            adjustTestOptions.subscriptionUrl = (String) map.get("subscriptionUrl");
        }
        if (map.containsKey("basePath")) {
            adjustTestOptions.basePath = (String) map.get("basePath");
        }
        if (map.containsKey("gdprPath")) {
            adjustTestOptions.gdprPath = (String) map.get("gdprPath");
        }
        if (map.containsKey("subscriptionPath")) {
            adjustTestOptions.subscriptionPath = (String) map.get("subscriptionPath");
        }
        if (map.containsKey("noBackoffWait")) {
            adjustTestOptions.noBackoffWait = Boolean.valueOf(map.get("noBackoffWait").toString().equals("true"));
        }
        if (map.containsKey("teardown")) {
            adjustTestOptions.teardown = Boolean.valueOf(map.get("teardown").toString().equals("true"));
        }
        if (map.containsKey("tryInstallReferrer")) {
            adjustTestOptions.tryInstallReferrer = Boolean.valueOf(map.get("tryInstallReferrer").toString().equals("true"));
        }
        if (map.containsKey("timerIntervalInMilliseconds")) {
            adjustTestOptions.timerIntervalInMilliseconds = Long.valueOf(Long.parseLong(map.get("timerIntervalInMilliseconds").toString()));
        }
        if (map.containsKey("timerStartInMilliseconds")) {
            adjustTestOptions.timerStartInMilliseconds = Long.valueOf(Long.parseLong(map.get("timerStartInMilliseconds").toString()));
        }
        if (map.containsKey("sessionIntervalInMilliseconds")) {
            adjustTestOptions.sessionIntervalInMilliseconds = Long.valueOf(Long.parseLong(map.get("sessionIntervalInMilliseconds").toString()));
        }
        if (map.containsKey("subsessionIntervalInMilliseconds")) {
            adjustTestOptions.subsessionIntervalInMilliseconds = Long.valueOf(Long.parseLong(map.get("subsessionIntervalInMilliseconds").toString()));
        }
        if (map.containsKey("deleteState")) {
            adjustTestOptions.context = this.applicationContext;
        }
        Adjust.setTestOptions(adjustTestOptions);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (r2.equals("verbose") != false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void start(io.flutter.plugin.common.MethodCall r22, io.flutter.plugin.common.MethodChannel.Result r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.Object r1 = r1.arguments
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r2 = "appToken"
            boolean r3 = r1.containsKey(r2)
            r4 = 0
            if (r3 == 0) goto L_0x001b
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x001c
        L_0x001b:
            r2 = r4
        L_0x001c:
            java.lang.String r3 = "environment"
            boolean r5 = r1.containsKey(r3)
            if (r5 == 0) goto L_0x002b
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            java.lang.String r5 = "logLevel"
            boolean r6 = r1.containsKey(r5)
            java.lang.String r7 = "suppress"
            r8 = 0
            r9 = 1
            if (r6 == 0) goto L_0x0048
            java.lang.Object r6 = r1.get(r5)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0048
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0048
            r6 = r9
            goto L_0x0049
        L_0x0048:
            r6 = r8
        L_0x0049:
            com.adjust.sdk.AdjustConfig r15 = new com.adjust.sdk.AdjustConfig
            android.content.Context r10 = r0.applicationContext
            r15.<init>(r10, r2, r3, r6)
            java.lang.String r2 = "sdkPrefix"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x0061
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setSdkPrefix(r2)
        L_0x0061:
            boolean r2 = r1.containsKey(r5)
            if (r2 == 0) goto L_0x00f6
            java.lang.Object r2 = r1.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00f6
            int r3 = r2.hashCode()
            r5 = 5
            r6 = 4
            r10 = 3
            r11 = 2
            switch(r3) {
                case -1663129931: goto L_0x00b8;
                case -1408208058: goto L_0x00ae;
                case 3237038: goto L_0x00a4;
                case 3641990: goto L_0x0099;
                case 95458899: goto L_0x008f;
                case 96784904: goto L_0x0085;
                case 351107458: goto L_0x007b;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x00c0
        L_0x007b:
            java.lang.String r3 = "verbose"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            goto L_0x00c1
        L_0x0085:
            java.lang.String r3 = "error"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            r8 = r10
            goto L_0x00c1
        L_0x008f:
            java.lang.String r3 = "debug"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            r8 = r9
            goto L_0x00c1
        L_0x0099:
            java.lang.String r3 = "warn"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            r8 = r11
            goto L_0x00c1
        L_0x00a4:
            java.lang.String r3 = "info"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            r8 = 6
            goto L_0x00c1
        L_0x00ae:
            java.lang.String r3 = "assert"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c0
            r8 = r6
            goto L_0x00c1
        L_0x00b8:
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x00c0
            r8 = r5
            goto L_0x00c1
        L_0x00c0:
            r8 = -1
        L_0x00c1:
            if (r8 == 0) goto L_0x00f1
            if (r8 == r9) goto L_0x00eb
            if (r8 == r11) goto L_0x00e5
            if (r8 == r10) goto L_0x00df
            if (r8 == r6) goto L_0x00d9
            if (r8 == r5) goto L_0x00d3
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.INFO
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00d3:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.SUPRESS
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00d9:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.ASSERT
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00df:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.ERROR
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00e5:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.WARN
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00eb:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.DEBUG
            r15.setLogLevel(r2)
            goto L_0x00f6
        L_0x00f1:
            com.adjust.sdk.LogLevel r2 = com.adjust.sdk.LogLevel.VERBOSE
            r15.setLogLevel(r2)
        L_0x00f6:
            java.lang.String r2 = "eventBufferingEnabled"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x010f
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r15.setEventBufferingEnabled(r2)
        L_0x010f:
            java.lang.String r2 = "coppaCompliantEnabled"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x0124
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setCoppaCompliantEnabled(r2)
        L_0x0124:
            java.lang.String r2 = "playStoreKidsAppEnabled"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x0139
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setPlayStoreKidsAppEnabled(r2)
        L_0x0139:
            java.lang.String r2 = "processName"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x014a
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setProcessName(r2)
        L_0x014a:
            java.lang.String r2 = "defaultTracker"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x015b
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setDefaultTracker(r2)
        L_0x015b:
            java.lang.String r2 = "externalDeviceId"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x016c
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setExternalDeviceId(r2)
        L_0x016c:
            java.lang.String r2 = "preinstallFilePath"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x017d
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setPreinstallFilePath(r2)
        L_0x017d:
            java.lang.String r2 = "urlStrategy"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x01de
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "china"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0199
            java.lang.String r2 = "url_strategy_china"
            r15.setUrlStrategy(r2)
            goto L_0x01de
        L_0x0199:
            java.lang.String r3 = "india"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01a7
            java.lang.String r2 = "url_strategy_india"
            r15.setUrlStrategy(r2)
            goto L_0x01de
        L_0x01a7:
            java.lang.String r3 = "cn"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01b5
            java.lang.String r2 = "url_strategy_cn"
            r15.setUrlStrategy(r2)
            goto L_0x01de
        L_0x01b5:
            java.lang.String r3 = "data-residency-eu"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01c3
            java.lang.String r2 = "data_residency_eu"
            r15.setUrlStrategy(r2)
            goto L_0x01de
        L_0x01c3:
            java.lang.String r3 = "data-residency-tr"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x01d1
            java.lang.String r2 = "data_residency_tr"
            r15.setUrlStrategy(r2)
            goto L_0x01de
        L_0x01d1:
            java.lang.String r3 = "data-residency-us"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x01de
            java.lang.String r2 = "data_residency_us"
            r15.setUrlStrategy(r2)
        L_0x01de:
            java.lang.String r2 = "userAgent"
            boolean r3 = r1.containsKey(r2)
            if (r3 == 0) goto L_0x01ef
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r15.setUserAgent(r2)
        L_0x01ef:
            java.lang.String r2 = "sendInBackground"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0206
            java.lang.String r2 = "sendInBackground"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setSendInBackground(r2)
        L_0x0206:
            java.lang.String r2 = "isDeviceKnown"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x021d
            java.lang.String r2 = "isDeviceKnown"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setDeviceKnown(r2)
        L_0x021d:
            java.lang.String r2 = "needsCost"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0234
            java.lang.String r2 = "needsCost"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setNeedsCost(r2)
        L_0x0234:
            java.lang.String r2 = "preinstallTrackingEnabled"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x024b
            java.lang.String r2 = "preinstallTrackingEnabled"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r15.setPreinstallTrackingEnabled(r2)
        L_0x024b:
            java.lang.String r2 = "delayStart"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0268
            java.lang.String r2 = "delayStart"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = com.adjust.sdk.flutter.AdjustUtils.isNumber(r2)
            if (r3 == 0) goto L_0x0268
            double r2 = java.lang.Double.parseDouble(r2)
            r15.setDelayStart(r2)
        L_0x0268:
            java.lang.String r2 = "secretId"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = "info1"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = "info2"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = "info3"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = "info4"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02d5
            java.lang.String r2 = "secretId"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r3 = "info1"
            java.lang.Object r3 = r1.get(r3)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r5 = "info2"
            java.lang.Object r5 = r1.get(r5)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r6 = "info3"
            java.lang.Object r6 = r1.get(r6)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r7 = "info4"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ NumberFormatException -> 0x02d5 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x02d5 }
            r8 = 10
            long r11 = java.lang.Long.parseLong(r2, r8)     // Catch:{ NumberFormatException -> 0x02d5 }
            long r13 = java.lang.Long.parseLong(r3, r8)     // Catch:{ NumberFormatException -> 0x02d5 }
            long r2 = java.lang.Long.parseLong(r5, r8)     // Catch:{ NumberFormatException -> 0x02d5 }
            long r17 = java.lang.Long.parseLong(r6, r8)     // Catch:{ NumberFormatException -> 0x02d5 }
            long r19 = java.lang.Long.parseLong(r7, r8)     // Catch:{ NumberFormatException -> 0x02d5 }
            r10 = r15
            r5 = r15
            r15 = r2
            r10.setAppSecret(r11, r13, r15, r17, r19)     // Catch:{ NumberFormatException -> 0x02d6 }
            goto L_0x02d6
        L_0x02d5:
            r5 = r15
        L_0x02d6:
            java.lang.String r2 = "launchDeferredDeeplink"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x02ee
            java.lang.String r2 = "launchDeferredDeeplink"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "true"
            boolean r2 = r2.equals(r3)
            launchDeferredDeeplink = r2
        L_0x02ee:
            java.lang.String r2 = "attributionCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0308
            java.lang.String r2 = "attributionCallback"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0308
            com.adjust.sdk.flutter.AdjustSdk$1 r3 = new com.adjust.sdk.flutter.AdjustSdk$1
            r3.<init>(r2)
            r5.setOnAttributionChangedListener(r3)
        L_0x0308:
            java.lang.String r2 = "sessionSuccessCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0322
            java.lang.String r2 = "sessionSuccessCallback"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0322
            com.adjust.sdk.flutter.AdjustSdk$2 r3 = new com.adjust.sdk.flutter.AdjustSdk$2
            r3.<init>(r2)
            r5.setOnSessionTrackingSucceededListener(r3)
        L_0x0322:
            java.lang.String r2 = "sessionFailureCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x033c
            java.lang.String r2 = "sessionFailureCallback"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x033c
            com.adjust.sdk.flutter.AdjustSdk$3 r3 = new com.adjust.sdk.flutter.AdjustSdk$3
            r3.<init>(r2)
            r5.setOnSessionTrackingFailedListener(r3)
        L_0x033c:
            java.lang.String r2 = "eventSuccessCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0356
            java.lang.String r2 = "eventSuccessCallback"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0356
            com.adjust.sdk.flutter.AdjustSdk$4 r3 = new com.adjust.sdk.flutter.AdjustSdk$4
            r3.<init>(r2)
            r5.setOnEventTrackingSucceededListener(r3)
        L_0x0356:
            java.lang.String r2 = "eventFailureCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x0370
            java.lang.String r2 = "eventFailureCallback"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0370
            com.adjust.sdk.flutter.AdjustSdk$5 r3 = new com.adjust.sdk.flutter.AdjustSdk$5
            r3.<init>(r2)
            r5.setOnEventTrackingFailedListener(r3)
        L_0x0370:
            java.lang.String r2 = "deferredDeeplinkCallback"
            boolean r2 = r1.containsKey(r2)
            if (r2 == 0) goto L_0x038a
            java.lang.String r2 = "deferredDeeplinkCallback"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x038a
            com.adjust.sdk.flutter.AdjustSdk$6 r2 = new com.adjust.sdk.flutter.AdjustSdk$6
            r2.<init>(r1)
            r5.setOnDeeplinkResponseListener(r2)
        L_0x038a:
            com.adjust.sdk.Adjust.onCreate(r5)
            com.adjust.sdk.Adjust.onResume()
            r1 = r23
            r1.success(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.flutter.AdjustSdk.start(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private void trackAdRevenue(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.hasArgument("source") && methodCall.hasArgument("payload")) {
            try {
                Adjust.trackAdRevenue((String) methodCall.argument("source"), new JSONObject((String) methodCall.argument("payload")));
            } catch (JSONException unused) {
                Log.e(TAG, "Given ad revenue payload is not a valid JSON string");
            }
        }
        result.success((Object) null);
    }

    private void trackAdRevenueNew(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        double d11;
        Map map = (Map) methodCall.arguments;
        if (map != null) {
            if (map.containsKey("source")) {
                str = (String) map.get("source");
            } else {
                str = null;
            }
            AdjustAdRevenue adjustAdRevenue = new AdjustAdRevenue(str);
            if (map.containsKey("revenue") || map.containsKey("currency")) {
                try {
                    d11 = Double.parseDouble((String) map.get("revenue"));
                } catch (NumberFormatException unused) {
                    d11 = -1.0d;
                }
                adjustAdRevenue.setRevenue(Double.valueOf(d11), (String) map.get("currency"));
            }
            if (map.containsKey("adImpressionsCount")) {
                adjustAdRevenue.setAdImpressionsCount(Integer.valueOf(Integer.parseInt((String) map.get("adImpressionsCount"))));
            }
            if (map.containsKey("adRevenueNetwork")) {
                adjustAdRevenue.setAdRevenueNetwork((String) map.get("adRevenueNetwork"));
            }
            if (map.containsKey("adRevenueUnit")) {
                adjustAdRevenue.setAdRevenueUnit((String) map.get("adRevenueUnit"));
            }
            if (map.containsKey("adRevenuePlacement")) {
                adjustAdRevenue.setAdRevenuePlacement((String) map.get("adRevenuePlacement"));
            }
            if (map.containsKey("callbackParameters")) {
                try {
                    JSONObject jSONObject = new JSONObject((String) map.get("callbackParameters"));
                    JSONArray names = jSONObject.names();
                    for (int i11 = 0; i11 < names.length(); i11++) {
                        String string = names.getString(i11);
                        adjustAdRevenue.addCallbackParameter(string, jSONObject.getString(string));
                    }
                } catch (JSONException e11) {
                    Log.e(TAG, "Failed to parse ad revenue callback parameter! Details: " + e11);
                }
            }
            if (map.containsKey("partnerParameters")) {
                try {
                    JSONObject jSONObject2 = new JSONObject((String) map.get("partnerParameters"));
                    JSONArray names2 = jSONObject2.names();
                    for (int i12 = 0; i12 < names2.length(); i12++) {
                        String string2 = names2.getString(i12);
                        adjustAdRevenue.addPartnerParameter(string2, jSONObject2.getString(string2));
                    }
                } catch (JSONException e12) {
                    Log.e(TAG, "Failed to parse ad revenue partner parameter! Details: " + e12);
                }
            }
            Adjust.trackAdRevenue(adjustAdRevenue);
            result.success((Object) null);
        }
    }

    private void trackAppStoreSubscription(MethodChannel.Result result) {
        result.success("Error. No App Store subscription tracking on Android platform!");
    }

    private void trackEvent(MethodCall methodCall, MethodChannel.Result result) {
        String str;
        double d11;
        Map map = (Map) methodCall.arguments;
        if (map != null) {
            if (map.containsKey("eventToken")) {
                str = (String) map.get("eventToken");
            } else {
                str = null;
            }
            AdjustEvent adjustEvent = new AdjustEvent(str);
            if (map.containsKey("revenue") || map.containsKey("currency")) {
                try {
                    d11 = Double.parseDouble((String) map.get("revenue"));
                } catch (NumberFormatException unused) {
                    d11 = -1.0d;
                }
                adjustEvent.setRevenue(d11, (String) map.get("currency"));
            }
            if (map.containsKey("transactionId")) {
                adjustEvent.setOrderId((String) map.get("transactionId"));
            }
            if (map.containsKey("callbackId")) {
                adjustEvent.setCallbackId((String) map.get("callbackId"));
            }
            if (map.containsKey("callbackParameters")) {
                try {
                    JSONObject jSONObject = new JSONObject((String) map.get("callbackParameters"));
                    JSONArray names = jSONObject.names();
                    for (int i11 = 0; i11 < names.length(); i11++) {
                        String string = names.getString(i11);
                        adjustEvent.addCallbackParameter(string, jSONObject.getString(string));
                    }
                } catch (JSONException e11) {
                    Log.e(TAG, "Failed to parse event callback parameter! Details: " + e11);
                }
            }
            if (map.containsKey("partnerParameters")) {
                try {
                    JSONObject jSONObject2 = new JSONObject((String) map.get("partnerParameters"));
                    JSONArray names2 = jSONObject2.names();
                    for (int i12 = 0; i12 < names2.length(); i12++) {
                        String string2 = names2.getString(i12);
                        adjustEvent.addPartnerParameter(string2, jSONObject2.getString(string2));
                    }
                } catch (JSONException e12) {
                    Log.e(TAG, "Failed to parse event partner parameter! Details: " + e12);
                }
            }
            Adjust.trackEvent(adjustEvent);
            result.success((Object) null);
        }
    }

    private void trackMeasurementConsent(MethodCall methodCall, MethodChannel.Result result) {
        Map map = (Map) methodCall.arguments;
        if (!map.containsKey("measurementConsent")) {
            result.error("0", "Arguments null or wrong (missing argument of 'trackMeasurementConsent' method.", (Object) null);
            return;
        }
        Adjust.trackMeasurementConsent(((Boolean) map.get("measurementConsent")).booleanValue());
        result.success((Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083 A[SYNTHETIC, Splitter:B:31:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void trackPlayStoreSubscription(io.flutter.plugin.common.MethodCall r12, io.flutter.plugin.common.MethodChannel.Result r13) {
        /*
            r11 = this;
            java.lang.Object r12 = r12.arguments
            java.util.Map r12 = (java.util.Map) r12
            if (r12 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.String r0 = "price"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x001c
            java.lang.Object r0 = r12.get(r0)     // Catch:{ NumberFormatException -> 0x001c }
            java.lang.String r0 = r0.toString()     // Catch:{ NumberFormatException -> 0x001c }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x001c }
            goto L_0x001e
        L_0x001c:
            r0 = -1
        L_0x001e:
            r3 = r0
            java.lang.String r0 = "currency"
            boolean r1 = r12.containsKey(r0)
            r10 = 0
            if (r1 == 0) goto L_0x0030
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r5 = r0
            goto L_0x0031
        L_0x0030:
            r5 = r10
        L_0x0031:
            java.lang.String r0 = "sku"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0041
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r6 = r0
            goto L_0x0042
        L_0x0041:
            r6 = r10
        L_0x0042:
            java.lang.String r0 = "orderId"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0052
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r7 = r0
            goto L_0x0053
        L_0x0052:
            r7 = r10
        L_0x0053:
            java.lang.String r0 = "signature"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0063
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r8 = r0
            goto L_0x0064
        L_0x0063:
            r8 = r10
        L_0x0064:
            java.lang.String r0 = "purchaseToken"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x0074
            java.lang.Object r0 = r12.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r9 = r0
            goto L_0x0075
        L_0x0074:
            r9 = r10
        L_0x0075:
            com.adjust.sdk.AdjustPlayStoreSubscription r0 = new com.adjust.sdk.AdjustPlayStoreSubscription
            r2 = r0
            r2.<init>(r3, r5, r6, r7, r8, r9)
            java.lang.String r1 = "purchaseTime"
            boolean r2 = r12.containsKey(r1)
            if (r2 == 0) goto L_0x0092
            java.lang.Object r1 = r12.get(r1)     // Catch:{ NumberFormatException -> 0x0092 }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x0092 }
            long r1 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x0092 }
            r0.setPurchaseTime(r1)     // Catch:{ NumberFormatException -> 0x0092 }
        L_0x0092:
            java.lang.String r1 = "callbackParameters"
            boolean r2 = r12.containsKey(r1)
            r3 = 0
            if (r2 == 0) goto L_0x00d6
            java.lang.Object r1 = r12.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00bf }
            r2.<init>((java.lang.String) r1)     // Catch:{ JSONException -> 0x00bf }
            org.json.JSONArray r1 = r2.names()     // Catch:{ JSONException -> 0x00bf }
            r4 = r3
        L_0x00ab:
            int r5 = r1.length()     // Catch:{ JSONException -> 0x00bf }
            if (r4 >= r5) goto L_0x00d6
            java.lang.String r5 = r1.getString(r4)     // Catch:{ JSONException -> 0x00bf }
            java.lang.String r6 = r2.getString(r5)     // Catch:{ JSONException -> 0x00bf }
            r0.addCallbackParameter(r5, r6)     // Catch:{ JSONException -> 0x00bf }
            int r4 = r4 + 1
            goto L_0x00ab
        L_0x00bf:
            r1 = move-exception
            java.lang.String r2 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to parse subscription callback parameter! Details: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r2, r1)
        L_0x00d6:
            java.lang.String r1 = "partnerParameters"
            boolean r2 = r12.containsKey(r1)
            if (r2 == 0) goto L_0x0118
            java.lang.Object r12 = r12.get(r1)
            java.lang.String r12 = (java.lang.String) r12
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0101 }
            r1.<init>((java.lang.String) r12)     // Catch:{ JSONException -> 0x0101 }
            org.json.JSONArray r12 = r1.names()     // Catch:{ JSONException -> 0x0101 }
        L_0x00ed:
            int r2 = r12.length()     // Catch:{ JSONException -> 0x0101 }
            if (r3 >= r2) goto L_0x0118
            java.lang.String r2 = r12.getString(r3)     // Catch:{ JSONException -> 0x0101 }
            java.lang.String r4 = r1.getString(r2)     // Catch:{ JSONException -> 0x0101 }
            r0.addPartnerParameter(r2, r4)     // Catch:{ JSONException -> 0x0101 }
            int r3 = r3 + 1
            goto L_0x00ed
        L_0x0101:
            r12 = move-exception
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Failed to parse subscription partner parameter! Details: "
            r2.append(r3)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            android.util.Log.e(r1, r12)
        L_0x0118:
            com.adjust.sdk.Adjust.trackPlayStoreSubscription(r0)
            r13.success(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adjust.sdk.flutter.AdjustSdk.trackPlayStoreSubscription(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private void trackThirdPartySharing(MethodCall methodCall, MethodChannel.Result result) {
        Boolean bool;
        Map map = (Map) methodCall.arguments;
        if (map != null) {
            if (map.containsKey(Constants.ENABLE_DISABLE)) {
                bool = (Boolean) map.get(Constants.ENABLE_DISABLE);
            } else {
                bool = null;
            }
            AdjustThirdPartySharing adjustThirdPartySharing = new AdjustThirdPartySharing(bool);
            if (map.containsKey("granularOptions")) {
                String[] split = ((String) map.get("granularOptions")).split("__ADJ__", -1);
                for (int i11 = 0; i11 < split.length; i11 += 3) {
                    adjustThirdPartySharing.addGranularOption(split[i11], split[i11 + 1], split[i11 + 2]);
                }
            }
            if (map.containsKey("partnerSharingSettings")) {
                String[] split2 = ((String) map.get("partnerSharingSettings")).split("__ADJ__", -1);
                for (int i12 = 0; i12 < split2.length; i12 += 3) {
                    adjustThirdPartySharing.addPartnerSharingSetting(split2[i12], split2[i12 + 1], Boolean.parseBoolean(split2[i12 + 2]));
                }
            }
            Adjust.trackThirdPartySharing(adjustThirdPartySharing);
            result.success((Object) null);
        }
    }

    private void updateConversionValue(MethodChannel.Result result) {
        result.success("Error. No updateConversionValue on Android platform!");
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Adjust.onResume();
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.adjust.sdk/api");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        Adjust.onPause();
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = null;
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2025275371:
                if (str.equals("disableThirdPartySharing")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1883758158:
                if (str.equals("appWillOpenUrl")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1833476499:
                if (str.equals("getGoogleAdId")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1747636811:
                if (str.equals("requestTrackingAuthorizationWithCompletionHandler")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1362965404:
                if (str.equals("setOfflineMode")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1340212393:
                if (str.equals("onPause")) {
                    c11 = 5;
                    break;
                }
                break;
            case -1172174017:
                if (str.equals("trackPlayStoreSubscription")) {
                    c11 = 6;
                    break;
                }
                break;
            case -950151351:
                if (str.equals("getAttribution")) {
                    c11 = 7;
                    break;
                }
                break;
            case -940351116:
                if (str.equals("checkForNewAttStatus")) {
                    c11 = 8;
                    break;
                }
                break;
            case -800854890:
                if (str.equals("addSessionPartnerParameter")) {
                    c11 = 9;
                    break;
                }
                break;
            case -605439723:
                if (str.equals("sendFirstPackages")) {
                    c11 = 10;
                    break;
                }
                break;
            case -321478325:
                if (str.equals("resetSessionPartnerParameters")) {
                    c11 = 11;
                    break;
                }
                break;
            case -248874314:
                if (str.equals("resetSessionCallbackParameters")) {
                    c11 = 12;
                    break;
                }
                break;
            case -187094856:
                if (str.equals("getAmazonAdId")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case -159578199:
                if (str.equals("getAppTrackingAuthorizationStatus")) {
                    c11 = 14;
                    break;
                }
                break;
            case -75692812:
                if (str.equals("getAdid")) {
                    c11 = 15;
                    break;
                }
                break;
            case -75454580:
                if (str.equals("getIdfa")) {
                    c11 = 16;
                    break;
                }
                break;
            case 18693459:
                if (str.equals("removeSessionPartnerParameter")) {
                    c11 = 17;
                    break;
                }
                break;
            case 107472238:
                if (str.equals("trackAdRevenue")) {
                    c11 = 18;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c11 = 19;
                    break;
                }
                break;
            case 240888810:
                if (str.equals("setTestOptions")) {
                    c11 = 20;
                    break;
                }
                break;
            case 535292434:
                if (str.equals("getLastDeeplink")) {
                    c11 = 21;
                    break;
                }
                break;
            case 760458429:
                if (str.equals("setPushToken")) {
                    c11 = 22;
                    break;
                }
                break;
            case 1107894633:
                if (str.equals("trackMeasurementConsent")) {
                    c11 = 23;
                    break;
                }
                break;
            case 1135978511:
                if (str.equals(AnalyticsMethodChannel.TRACK_METHOD_CALL_FLUTTER_EVENT)) {
                    c11 = 24;
                    break;
                }
                break;
            case 1211355428:
                if (str.equals("gdprForgetMe")) {
                    c11 = 25;
                    break;
                }
                break;
            case 1266752161:
                if (str.equals("setReferrer")) {
                    c11 = 26;
                    break;
                }
                break;
            case 1308589458:
                if (str.equals("removeSessionCallbackParameter")) {
                    c11 = 27;
                    break;
                }
                break;
            case 1364071551:
                if (str.equals("setEnabled")) {
                    c11 = 28;
                    break;
                }
                break;
            case 1463983852:
                if (str.equals("onResume")) {
                    c11 = 29;
                    break;
                }
                break;
            case 1599131122:
                if (str.equals("updateConversionValue")) {
                    c11 = 30;
                    break;
                }
                break;
            case 1672394415:
                if (str.equals("addSessionCallbackParameter")) {
                    c11 = 31;
                    break;
                }
                break;
            case 1868569192:
                if (str.equals("trackAppStoreSubscription")) {
                    c11 = ' ';
                    break;
                }
                break;
            case 1954884946:
                if (str.equals("trackAdRevenueNew")) {
                    c11 = '!';
                    break;
                }
                break;
            case 2034588468:
                if (str.equals("getSdkVersion")) {
                    c11 = '\"';
                    break;
                }
                break;
            case 2105594551:
                if (str.equals(Constants.ENABLE_DISABLE)) {
                    c11 = '#';
                    break;
                }
                break;
            case 2110727186:
                if (str.equals("trackThirdPartySharing")) {
                    c11 = '$';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                disableThirdPartySharing(result);
                return;
            case 1:
                appWillOpenUrl(methodCall, result);
                return;
            case 2:
                getGoogleAdId(result);
                return;
            case 3:
                requestTrackingAuthorizationWithCompletionHandler(result);
                return;
            case 4:
                setOfflineMode(methodCall, result);
                return;
            case 5:
                onPause(result);
                return;
            case 6:
                trackPlayStoreSubscription(methodCall, result);
                return;
            case 7:
                getAttribution(result);
                return;
            case 8:
                checkForNewAttStatus(methodCall, result);
                return;
            case 9:
                addSessionPartnerParameter(methodCall, result);
                return;
            case 10:
                sendFirstPackages(result);
                return;
            case 11:
                resetSessionPartnerParameters(result);
                return;
            case 12:
                resetSessionCallbackParameters(result);
                return;
            case 13:
                getAmazonAdId(result);
                return;
            case 14:
                getAppTrackingAuthorizationStatus(methodCall, result);
                return;
            case 15:
                getAdid(result);
                return;
            case 16:
                getIdfa(result);
                return;
            case 17:
                removeSessionPartnerParameter(methodCall, result);
                return;
            case 18:
                trackAdRevenue(methodCall, result);
                return;
            case 19:
                start(methodCall, result);
                return;
            case 20:
                setTestOptions(methodCall, result);
                return;
            case 21:
                getLastDeeplink(methodCall, result);
                return;
            case 22:
                setPushToken(methodCall, result);
                return;
            case 23:
                trackMeasurementConsent(methodCall, result);
                return;
            case 24:
                trackEvent(methodCall, result);
                return;
            case 25:
                gdprForgetMe(result);
                return;
            case 26:
                setReferrer(methodCall, result);
                return;
            case 27:
                removeSessionCallbackParameter(methodCall, result);
                return;
            case 28:
                setEnabled(methodCall, result);
                return;
            case 29:
                onResume(result);
                return;
            case 30:
                updateConversionValue(result);
                return;
            case 31:
                addSessionCallbackParameter(methodCall, result);
                return;
            case ' ':
                trackAppStoreSubscription(result);
                return;
            case '!':
                trackAdRevenueNew(methodCall, result);
                return;
            case '\"':
                getSdkVersion(result);
                return;
            case '#':
                isEnabled(result);
                return;
            case '$':
                trackThirdPartySharing(methodCall, result);
                return;
            default:
                String str2 = TAG;
                Log.e(str2, "Not implemented method: " + methodCall.method);
                result.notImplemented();
                return;
        }
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    }

    public static void appWillOpenUrl(Uri uri, Context context) {
        Adjust.appWillOpenUrl(uri, context);
    }
}
