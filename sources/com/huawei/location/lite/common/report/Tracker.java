package com.huawei.location.lite.common.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.grs.LocationNlpGrsServiceEnum;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class Tracker {
    private static final int CACHE_SIZE = 100;
    private static final long DELAY_TIME = 3600000;
    private static final String LOCATION_KIT = "Location-Full-";
    private static final int MESSAGE_DEFAULT = 1;
    private static final int MESSAGE_INIT = 2;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "LocationTracker";
    private static volatile Tracker instance;
    private AtomicBoolean isInitialized = new AtomicBoolean(false);
    private final Map<String, LinkedHashMap> maintenanceCacheEventId = new HashMap(16, 0.85f);
    private final Map<String, LinkedHashMap> operatjionCacheEventId = new HashMap(16, 0.85f);
    private LocationReportHandler reportHandler;
    /* access modifiers changed from: private */
    public volatile boolean reportTask = false;

    public class LocationReportHandler extends Handler {
        public LocationReportHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i11 = message.what;
            if (i11 == 1) {
                LogConsole.d(Tracker.TAG, "handleMessage case 1, begin to report");
                Tracker.this.onReport();
                boolean unused = Tracker.this.reportTask = false;
            } else if (i11 == 2) {
                Tracker.this.initHiAnalytics();
            }
        }
    }

    private Tracker() {
        HandlerThread handlerThread = new HandlerThread("Location-Full-LocationTracker");
        handlerThread.start();
        this.reportHandler = new LocationReportHandler(handlerThread.getLooper());
        LogConsole.i(TAG, "LocationTracker init");
    }

    private boolean checkUninitializedAnalytics(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.isInitialized.get()) {
            return false;
        }
        LogConsole.d(TAG, "checkUninitializedAnalytics not initialized");
        if (i11 == 0) {
            synchronized (this.operatjionCacheEventId) {
                if (this.operatjionCacheEventId.size() > 100) {
                    this.operatjionCacheEventId.clear();
                    LogConsole.d(TAG, "out of size clear cache");
                }
                this.operatjionCacheEventId.put(encodeKey(str, i11), linkedHashMap);
            }
        } else if (1 == i11) {
            synchronized (this.maintenanceCacheEventId) {
                if (this.maintenanceCacheEventId.size() > 100) {
                    this.maintenanceCacheEventId.clear();
                    LogConsole.d(TAG, "out of size clear cache");
                }
                this.maintenanceCacheEventId.put(encodeKey(str, i11), linkedHashMap);
            }
        } else {
            LogConsole.d(TAG, "onEvent type =" + i11);
        }
        init();
        return true;
    }

    private String decodeKeyForEventId(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[0];
    }

    private String decodeKeyForType(String str) {
        return TextUtils.isEmpty(str) ? str : str.split("\\|")[1];
    }

    private void doReport() {
        LocationReportHandler locationReportHandler;
        if (!this.reportTask && (locationReportHandler = this.reportHandler) != null) {
            locationReportHandler.sendEmptyMessageDelayed(1, 3600000);
            this.reportTask = true;
        }
    }

    private String encodeKey(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "|" + i11 + "|" + UUID.randomUUID().toString();
    }

    public static Tracker getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new Tracker();
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void initHiAnalytics() {
        if (!this.isInitialized.get()) {
            String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress(GrsApp.getInstance().getIssueCountryCode(ContextUtil.getContext()), LocationNlpGrsServiceEnum.HIANALYTICS);
            LogConsole.d(TAG, "hiAnalyticsUrl:" + grsHostAddress);
            if (TextUtils.isEmpty(grsHostAddress)) {
                LogConsole.i(TAG, "initHiAnalytics  hiAnalyticsUrl is empty.");
                this.isInitialized.set(false);
                return;
            }
            LogConsole.i(TAG, "initHiAnalytics begin.");
            HmsHiAnalyticsUtils.init(ContextUtil.getContext(), false, false, false, grsHostAddress, AGCManager.getInstance().getAppId());
            if (HmsHiAnalyticsUtils.getInitFlag()) {
                this.isInitialized.set(true);
            }
            processUnreportedData();
        }
    }

    private void processUnreportedData() {
        processUnreportedDataUtil(this.operatjionCacheEventId);
        processUnreportedDataUtil(this.maintenanceCacheEventId);
    }

    private void processUnreportedDataUtil(Map<String, LinkedHashMap> map) {
        synchronized (map) {
            if (!map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    if (!TextUtils.isEmpty((CharSequence) next.getKey())) {
                        onEvent(Integer.parseInt(decodeKeyForType((String) next.getKey())), decodeKeyForEventId((String) next.getKey()), (LinkedHashMap) next.getValue());
                    } else {
                        LogConsole.e(TAG, "mapEntry.getKey() == null");
                    }
                }
                map.clear();
            }
        }
    }

    public void init() {
        if (!this.isInitialized.get()) {
            this.reportHandler.sendEmptyMessage(2);
        }
    }

    public synchronized void onEvent(int i11, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (!checkUninitializedAnalytics(i11, str, linkedHashMap)) {
            if (!HmsHiAnalyticsUtils.getInitFlag()) {
                LogConsole.d(TAG, "onEvent HA init is false");
                return;
            }
            LogConsole.d(TAG, "analyticsInstance.onEvent");
            HmsHiAnalyticsUtils.onEvent(i11, str, linkedHashMap);
        }
    }

    public void onMaintEvent(ReportBuilder reportBuilder) {
        LogConsole.i(TAG, "onMaintEvent:" + reportBuilder.build().toString());
        onEvent(1, reportBuilder.getEventId(), reportBuilder.build());
        doReport();
    }

    public void onOperationEvent(ReportBuilder reportBuilder) {
        onEvent(0, reportBuilder.getEventId(), reportBuilder.build());
    }

    public void onReport() {
        if (HmsHiAnalyticsUtils.getInitFlag()) {
            LogConsole.d(TAG, "analyticsInstance.onReport");
            HmsHiAnalyticsUtils.onReport();
        }
    }
}
