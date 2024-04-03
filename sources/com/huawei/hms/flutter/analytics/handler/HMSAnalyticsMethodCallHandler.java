package com.huawei.hms.flutter.analytics.handler;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.huawei.hms.flutter.analytics.HMSAnalyticsModule;
import com.huawei.hms.flutter.analytics.logger.HMSLogger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;

public class HMSAnalyticsMethodCallHandler implements MethodChannel.MethodCallHandler {
    private static final String TAG = "HMSAnalyticsMethodCallHandler";
    private HMSAnalyticsModule analyticsModule;
    private final WeakReference<Context> weakContext;

    /* renamed from: com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods;

        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods[] r0 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods = r0
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.clearCachedData     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setAnalyticsEnabled     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.getAAID     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.getUserProfiles     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.pageStart     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.pageEnd     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setMinActivitySessions     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setPushToken     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setSessionDuration     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setUserId     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setUserProfile     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.onEvent     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x009c }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.enableLog     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.enableLogWithLevel     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.enableLogger     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.disableLogger     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.getReportPolicyThreshold     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setReportPolicies     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setRestrictionEnabled     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.isRestrictionEnabled     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setCollectAdsIdEnabled     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.addDefaultEventParams     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.deleteUserProfile     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.deleteUserId     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x012c }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setChannel     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setPropertyCollection     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.setCustomReferrer     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.getInstance     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods     // Catch:{ NoSuchFieldError -> 0x015c }
                com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler$Methods r1 = com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.Methods.getDataUploadSiteInfo     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.flutter.analytics.handler.HMSAnalyticsMethodCallHandler.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Methods {
        clearCachedData,
        setAnalyticsEnabled,
        getAAID,
        getUserProfiles,
        pageStart,
        pageEnd,
        setMinActivitySessions,
        setPushToken,
        setSessionDuration,
        setUserId,
        setUserProfile,
        onEvent,
        enableLog,
        enableLogWithLevel,
        enableLogger,
        disableLogger,
        getReportPolicyThreshold,
        setReportPolicies,
        setRestrictionEnabled,
        isRestrictionEnabled,
        setCollectAdsIdEnabled,
        addDefaultEventParams,
        deleteUserProfile,
        deleteUserId,
        setChannel,
        setPropertyCollection,
        setCustomReferrer,
        getInstance,
        getDataUploadSiteInfo
    }

    public HMSAnalyticsMethodCallHandler(HMSAnalyticsModule hMSAnalyticsModule, WeakReference<Context> weakReference) {
        this.analyticsModule = hMSAnalyticsModule;
        this.weakContext = weakReference;
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        String str = TAG;
        Log.i(str, " Running method : " + methodCall.method);
        HMSLogger.getInstance(this.weakContext.get()).startMethodExecutionTimer(methodCall.method);
        if (this.analyticsModule == null) {
            this.analyticsModule = new HMSAnalyticsModule(this.weakContext);
        }
        switch (AnonymousClass1.$SwitchMap$com$huawei$hms$flutter$analytics$handler$HMSAnalyticsMethodCallHandler$Methods[Methods.valueOf(methodCall.method).ordinal()]) {
            case 1:
                this.analyticsModule.clearCachedData(result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 2:
                this.analyticsModule.setAnalyticsEnabled(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 3:
                this.analyticsModule.getAAID(result);
                return;
            case 4:
                this.analyticsModule.getUserProfiles(methodCall, result);
                return;
            case 5:
                this.analyticsModule.pageStart(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 6:
                this.analyticsModule.pageEnd(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 7:
                this.analyticsModule.setMinActivitySessions(methodCall, result);
                return;
            case 8:
                this.analyticsModule.setPushToken(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 9:
                this.analyticsModule.setSessionDuration(methodCall, result);
                return;
            case 10:
                this.analyticsModule.setUserId(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 11:
                this.analyticsModule.setUserProfile(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 12:
                this.analyticsModule.onEvent(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 13:
                this.analyticsModule.enableLog(result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 14:
                this.analyticsModule.enableLogWithLevel(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 15:
                this.analyticsModule.enableLogger(result);
                return;
            case 16:
                this.analyticsModule.disableLogger(result);
                return;
            case 17:
                this.analyticsModule.getReportPolicyThreshold(methodCall, result);
                return;
            case 18:
                this.analyticsModule.setReportPolicies(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 19:
                this.analyticsModule.setRestrictionEnabled(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 20:
                this.analyticsModule.isRestrictionEnabled(result);
                return;
            case 21:
                this.analyticsModule.setCollectAdsIdEnabled(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 22:
                this.analyticsModule.addDefaultEventParams(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 23:
                this.analyticsModule.deleteUserProfile(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 24:
                this.analyticsModule.deleteUserId(result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 25:
                this.analyticsModule.setChannel(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 26:
                this.analyticsModule.setPropertyCollection(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 27:
                this.analyticsModule.setCustomReferrer(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 28:
                this.analyticsModule.getInstance(methodCall, result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            case 29:
                this.analyticsModule.getDataUploadSiteInfo(result);
                HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent(methodCall.method);
                return;
            default:
                result.error("platformError", "Not supported on Android platform", "");
                return;
        }
    }

    public HMSAnalyticsMethodCallHandler(WeakReference<Context> weakReference) {
        this.weakContext = weakReference;
    }
}
