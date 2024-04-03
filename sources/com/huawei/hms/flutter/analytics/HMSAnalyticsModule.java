package com.huawei.hms.flutter.analytics;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.type.ReportPolicy;
import com.huawei.hms.flutter.analytics.logger.HMSLogger;
import com.huawei.hms.flutter.analytics.presenter.HMSAnalyticsContract;
import com.huawei.hms.flutter.analytics.utils.MapUtils;
import com.huawei.hms.flutter.analytics.viewmodel.HMSAnalyticsViewModel;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.wallet.features.UrlConstantsKt;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HMSAnalyticsModule {
    private HMSAnalyticsContract.Presenter viewModel;
    private final WeakReference<Context> weakContext;

    public static final class HMSAnalyticsResultHandler<Object> implements HMSAnalyticsContract.ResultListener<Object> {
        private final String mMethodName;
        private final MethodChannel.Result mResult;
        private final WeakReference<Context> mWeakContext;

        public HMSAnalyticsResultHandler(MethodChannel.Result result, String str, WeakReference<Context> weakReference) {
            this.mResult = result;
            this.mMethodName = str;
            this.mWeakContext = weakReference;
        }

        public void onFail(Exception exc) {
            HMSLogger.getInstance(this.mWeakContext.get()).sendSingleEvent(this.mMethodName, exc.getMessage());
            this.mResult.error("", exc.getMessage(), exc.getLocalizedMessage());
        }

        public void onSuccess(Object object) {
            HMSLogger.getInstance(this.mWeakContext.get()).sendSingleEvent(this.mMethodName);
            this.mResult.success(object);
        }
    }

    public enum LogLevel {
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        int intValue;

        private LogLevel(int i11) {
            this.intValue = i11;
        }
    }

    public HMSAnalyticsModule(WeakReference<Context> weakReference) {
        this.weakContext = weakReference;
    }

    private Context getContext() {
        return this.weakContext.get();
    }

    private ReportPolicy getReportPolicyType(String str) {
        if ("ON_SCHEDULED_TIME_POLICY".equals(str)) {
            return ReportPolicy.ON_SCHEDULED_TIME_POLICY;
        }
        if ("ON_APP_LAUNCH_POLICY".equals(str)) {
            return ReportPolicy.ON_APP_LAUNCH_POLICY;
        }
        if ("ON_MOVE_BACKGROUND_POLICY".equals(str)) {
            return ReportPolicy.ON_MOVE_BACKGROUND_POLICY;
        }
        if ("ON_CACHE_THRESHOLD_POLICY".equals(str)) {
            return ReportPolicy.ON_CACHE_THRESHOLD_POLICY;
        }
        return null;
    }

    private Set<ReportPolicy> mapToSetReportPolicy(Map<String, Object> map) {
        HashSet hashSet = new HashSet();
        for (String next : map.keySet()) {
            next.hashCode();
            char c11 = 65535;
            switch (next.hashCode()) {
                case -1420581111:
                    if (next.equals("cacheThreshold")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 130391007:
                    if (next.equals("moveBackground")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1281994036:
                    if (next.equals("appLaunch")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1681484058:
                    if (next.equals("scheduledTime")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    Long l11 = MapUtils.toLong(next, map.get("cacheThreshold"));
                    ReportPolicy reportPolicy = ReportPolicy.ON_CACHE_THRESHOLD_POLICY;
                    reportPolicy.setThreshold(l11.longValue());
                    hashSet.add(reportPolicy);
                    break;
                case 1:
                    hashSet.add(ReportPolicy.ON_MOVE_BACKGROUND_POLICY);
                    break;
                case 2:
                    hashSet.add(ReportPolicy.ON_APP_LAUNCH_POLICY);
                    break;
                case 3:
                    Long l12 = MapUtils.toLong(next, map.get("scheduledTime"));
                    ReportPolicy reportPolicy2 = ReportPolicy.ON_SCHEDULED_TIME_POLICY;
                    reportPolicy2.setThreshold(l12.longValue());
                    hashSet.add(reportPolicy2);
                    break;
            }
        }
        return hashSet;
    }

    public void addDefaultEventParams(MethodCall methodCall, MethodChannel.Result result) {
        Bundle mapToBundle = MapUtils.mapToBundle(MapUtils.objectToMap(methodCall.argument(NativeProtocol.WEB_DIALOG_PARAMS)), false);
        if (mapToBundle.isEmpty()) {
            mapToBundle = null;
        }
        this.viewModel.addDefaultEventParams(mapToBundle);
        result.success((Object) null);
    }

    public void clearCachedData(MethodChannel.Result result) {
        this.viewModel.clearCachedData();
        result.success((Object) null);
    }

    public void deleteUserId(MethodChannel.Result result) {
        this.viewModel.setUserId((String) null);
        result.success((Object) null);
    }

    public void deleteUserProfile(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setUserProfile(MapUtils.getString("key", methodCall.argument("key")), (String) null);
        result.success((Object) null);
    }

    public void disableLogger(MethodChannel.Result result) {
        HMSLogger.getInstance(this.weakContext.get()).disableLogger();
        result.success((Object) null);
    }

    public void enableLog(MethodChannel.Result result) {
        this.viewModel.enableLog();
        result.success((Object) null);
    }

    public void enableLogWithLevel(MethodCall methodCall, MethodChannel.Result result) {
        String string = MapUtils.getString("logLevel", methodCall.argument("logLevel"));
        try {
            this.viewModel.enableLogWithLevel(Integer.valueOf(LogLevel.valueOf(string).intValue).intValue());
            result.success((Object) null);
        } catch (IllegalArgumentException unused) {
            HMSLogger instance = HMSLogger.getInstance(this.weakContext.get());
            instance.sendSingleEvent("enableLogWithLevel", "Invalid log level. level = " + string);
            result.error("INVALID_PARAM", "Invalid log level. level = " + string, (Object) null);
        }
    }

    public void enableLogger(MethodChannel.Result result) {
        HMSLogger.getInstance(this.weakContext.get()).enableLogger();
        result.success((Object) null);
    }

    public void getAAID(MethodChannel.Result result) {
        this.viewModel.getAAID(new HMSAnalyticsResultHandler(result, "getAAID", this.weakContext));
    }

    public void getDataUploadSiteInfo(MethodChannel.Result result) {
        this.viewModel.getDataUploadSiteInfo(new HMSAnalyticsResultHandler(result, "getDataUploadSiteInfo", this.weakContext));
    }

    public void getInstance(MethodCall methodCall, MethodChannel.Result result) {
        HiAnalyticsInstance hiAnalyticsInstance;
        String string = MapUtils.getString("routePolicy", methodCall.argument("routePolicy"));
        if (!string.equals("")) {
            hiAnalyticsInstance = HiAnalytics.getInstance(getContext(), string);
        } else {
            hiAnalyticsInstance = HiAnalytics.getInstance(getContext());
        }
        this.viewModel = new HMSAnalyticsViewModel(getContext(), hiAnalyticsInstance);
        result.success((Object) null);
    }

    public void getReportPolicyThreshold(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.getReportPolicyThreshold(new HMSAnalyticsResultHandler(result, "getReportPolicyThreshold", this.weakContext), getReportPolicyType(MapUtils.getString("reportPolicyType", methodCall.argument("reportPolicyType"))));
    }

    public void getUserProfiles(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.getUserProfiles(new HMSAnalyticsResultHandler(result, "predefined", this.weakContext), MapUtils.toBoolean("predefined", methodCall.argument("predefined")).booleanValue());
    }

    public void isRestrictionEnabled(MethodChannel.Result result) {
        this.viewModel.isRestrictionEnabled(new HMSAnalyticsResultHandler(result, "isRestrictionEnabled", this.weakContext));
    }

    public void onEvent(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.onEvent(MapUtils.getString(UrlConstantsKt.WALLET_EVENT_ID, methodCall.argument(UrlConstantsKt.WALLET_EVENT_ID)), MapUtils.mapToBundle(MapUtils.objectToMap(methodCall.argument(NativeProtocol.WEB_DIALOG_PARAMS)), false));
        result.success((Object) null);
    }

    public void pageEnd(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.pageEnd(MapUtils.getString("pageName", methodCall.argument("pageName")));
        result.success((Object) null);
    }

    public void pageStart(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.pageStart(MapUtils.getString("pageName", methodCall.argument("pageName")), MapUtils.getString("pageClassOverride", methodCall.argument("pageClassOverride")));
        result.success((Object) null);
    }

    public void setAnalyticsEnabled(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setAnalyticsEnabled(MapUtils.toBoolean("enabled", methodCall.argument("enabled")).booleanValue());
        result.success((Object) null);
    }

    public void setChannel(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setChannel(MapUtils.getString("channel", methodCall.argument("channel")));
        result.success((Object) null);
    }

    public void setCollectAdsIdEnabled(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setCollectAdsIdEnabled(MapUtils.toBoolean("enabled", methodCall.argument("enabled")).booleanValue());
        result.success((Object) null);
    }

    public void setCustomReferrer(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setCustomReferrer(MapUtils.getString("customReferrer", methodCall.argument("customReferrer")));
        result.success((Object) null);
    }

    public void setMinActivitySessions(MethodCall methodCall, MethodChannel.Result result) {
        Long l11 = MapUtils.toLong(SessionsConfigParameter.SYNC_INTERVAL, methodCall.argument(SessionsConfigParameter.SYNC_INTERVAL));
        if (l11 != null) {
            this.viewModel.setMinActivitySessions(l11.longValue());
            HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent("setMinActivitySessions");
            result.success((Object) null);
            return;
        }
        HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent("setMinActivitySessions", "NULL_PARAM");
        result.error("NULL_PARAM", "interval was null.", (Object) null);
    }

    public void setPropertyCollection(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setPropertyCollection(MapUtils.getString("property", methodCall.argument("property")), MapUtils.toBoolean("enabled", methodCall.argument("enabled")).booleanValue());
        result.success((Object) null);
    }

    public void setPushToken(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setPushToken(MapUtils.getString(LegacyTokenLocalDataSourceImpl.KEY, methodCall.argument(LegacyTokenLocalDataSourceImpl.KEY)));
        result.success((Object) null);
    }

    public void setReportPolicies(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setReportPolicies(mapToSetReportPolicy(MapUtils.objectToMap(methodCall.argument("policyType"))));
        result.success((Object) null);
    }

    public void setRestrictionEnabled(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setRestrictionEnabled(MapUtils.toBoolean("enabled", methodCall.argument("enabled")).booleanValue());
        result.success((Object) null);
    }

    public void setSessionDuration(MethodCall methodCall, MethodChannel.Result result) {
        Long l11 = MapUtils.toLong("duration", methodCall.argument("duration"));
        if (l11 != null) {
            this.viewModel.setSessionDuration(l11.longValue());
            HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent("setSessionDuration");
            result.success((Object) null);
            return;
        }
        HMSLogger.getInstance(this.weakContext.get()).sendSingleEvent("setSessionDuration", "NULL_PARAM");
        result.error("NULL_PARAM", "duration was null.", (Object) null);
    }

    public void setUserId(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setUserId(MapUtils.getString("userId", methodCall.argument("userId")));
        result.success((Object) null);
    }

    public void setUserProfile(MethodCall methodCall, MethodChannel.Result result) {
        this.viewModel.setUserProfile(MapUtils.getString("key", methodCall.argument("key")), MapUtils.getString("value", methodCall.argument("value")));
        result.success((Object) null);
    }
}
