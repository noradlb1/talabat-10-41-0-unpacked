package com.huawei.location.utils;

import android.location.Location;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.location.lite.common.agc.AGCManager;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.APKUtil;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Vw {

    /* renamed from: yn  reason: collision with root package name */
    private ReportBuilder f50269yn;

    @Instrumented
    public static class yn {

        /* renamed from: yn  reason: collision with root package name */
        private ReportBuilder f50270yn;

        public yn() {
            ReportBuilder reportBuilder = new ReportBuilder();
            this.f50270yn = reportBuilder;
            reportBuilder.setAppID(AGCManager.getInstance().getAppId());
        }

        public yn FB(String str) {
            this.f50270yn.setTransactionID(str);
            return this;
        }

        public yn Vw() {
            this.f50270yn.setWLANScan();
            return this;
        }

        public yn Vw(String str) {
            this.f50270yn.setExt(str);
            return this;
        }

        public yn yn(LocationRequest locationRequest, boolean z11) {
            HashMap hashMap = new HashMap();
            if (locationRequest != null) {
                hashMap.put("priority", Integer.valueOf(locationRequest.getPriority()));
                hashMap.put(SessionsConfigParameter.SYNC_INTERVAL, Long.valueOf(locationRequest.getInterval()));
                hashMap.put("fastestInterval", Long.valueOf(locationRequest.getFastestInterval()));
                hashMap.put("expirationTime", Long.valueOf(locationRequest.getExpirationTime()));
                hashMap.put("numUpdates", Integer.valueOf(locationRequest.getNumUpdates()));
                hashMap.put("smallestDisplacement", Float.valueOf(locationRequest.getSmallestDisplacement()));
                hashMap.put("needAddress", Boolean.valueOf(locationRequest.getNeedAddress()));
                hashMap.put("maxWaitTime", Long.valueOf(locationRequest.getMaxWaitTime()));
                if (z11) {
                    hashMap.put("isDuplicate", 1);
                }
                Map<String, String> extras = locationRequest.getExtras();
                if (extras != null && extras.containsKey("cpTransId")) {
                    hashMap.put("cpTransId", extras.get("cpTransId"));
                }
            }
            try {
                ReportBuilder reportBuilder = this.f50270yn;
                Gson instance = GsonUtil.getInstance();
                reportBuilder.setExt(!(instance instanceof Gson) ? instance.toJson((Object) hashMap) : GsonInstrumentation.toJson(instance, (Object) hashMap));
            } catch (Exception unused) {
                LogConsole.e("LocationClientReport", "GsonUtil.getInstance().toJson(map) exception");
            }
            return this;
        }

        public yn yn(LocationBaseRequest locationBaseRequest) {
            if (locationBaseRequest != null) {
                this.f50270yn.setTransactionID(locationBaseRequest.getTid());
                this.f50270yn.setLocationEnable(LocationUtil.isLocationEnabled(ContextUtil.getContext()));
                this.f50270yn.setPackage(locationBaseRequest.getPackageName());
                this.f50270yn.setCpAppVersion(String.valueOf(APKUtil.getThirdAppVersionCode(locationBaseRequest.getPackageName())));
            }
            return this;
        }

        public yn yn(@NonNull com.huawei.location.resp.Vw vw2) {
            String str;
            int i11;
            ArrayList arrayList = (ArrayList) vw2.Vw();
            if (arrayList.size() == 0) {
                this.f50270yn.setExt("");
                return this;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Location location = (Location) it.next();
                HashMap hashMap = new HashMap();
                hashMap.put("provider", location.getProvider());
                hashMap.put("accuracy", Float.valueOf(location.getAccuracy()));
                hashMap.put(LogWriteConstants.LOCATION_TIME, Long.valueOf(location.getTime()));
                if (location.getExtras() != null && (new SafeBundle(location.getExtras()).getInt("SourceType") & 8) == 8) {
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                hashMap.put("locationType", Integer.valueOf(i11));
                Bundle extras = location.getExtras();
                SafeBundle safeBundle = new SafeBundle(extras);
                if (extras != null) {
                    if (safeBundle.containsKey("session_id")) {
                        hashMap.put("session_id", safeBundle.getString("session_id"));
                    }
                    if (safeBundle.containsKey(LogWriteConstants.VENDOR_TYPE)) {
                        hashMap.put(LogWriteConstants.VENDOR_TYPE, Integer.valueOf(safeBundle.getInt(LogWriteConstants.VENDOR_TYPE)));
                    }
                    if (safeBundle.containsKey(LogWriteConstants.LOCATE_TYPE)) {
                        hashMap.put(LogWriteConstants.LOCATE_TYPE, safeBundle.getString(LogWriteConstants.LOCATE_TYPE));
                    }
                    if (safeBundle.containsKey("isCache")) {
                        hashMap.put("isCache", Boolean.valueOf(safeBundle.getBoolean("isCache")));
                    }
                }
                arrayList2.add(hashMap);
            }
            try {
                ReportBuilder reportBuilder = this.f50270yn;
                Gson instance = GsonUtil.getInstance();
                if (!(instance instanceof Gson)) {
                    str = instance.toJson((Object) arrayList2);
                } else {
                    str = GsonInstrumentation.toJson(instance, (Object) arrayList2);
                }
                reportBuilder.setExt(str);
            } catch (Exception unused) {
                LogConsole.e("LocationClientReport", "GsonUtil.getInstance().toJson(list) exception");
            }
            return this;
        }

        public yn yn(String str) {
            this.f50270yn.setApiName(str);
            return this;
        }

        public Vw yn() {
            return new Vw(this.f50270yn);
        }
    }

    public Vw(ReportBuilder reportBuilder) {
        this.f50269yn = reportBuilder;
    }

    public void Vw(String str) {
        this.f50269yn.setResult(str);
        this.f50269yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.f50269yn);
        Tracker.getInstance().onOperationEvent(this.f50269yn);
        this.f50269yn.setCallTime();
    }

    public void yn(String str) {
        this.f50269yn.setErrorCode(str);
        this.f50269yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.f50269yn);
        Tracker.getInstance().onOperationEvent(this.f50269yn);
    }
}
