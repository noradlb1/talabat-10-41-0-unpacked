package com.huawei.location.callback;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.resp.LocationAvailabilityInfo;
import com.huawei.location.resp.ResponseInfo;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.Vw;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public abstract class d2 implements LocationListener {
    private long E5 = SystemClock.elapsedRealtimeNanos();
    public Location Vw;

    /* renamed from: b  reason: collision with root package name */
    public Handler f50010b;

    /* renamed from: c  reason: collision with root package name */
    public Vw.yn f50011c;

    /* renamed from: d  reason: collision with root package name */
    public RequestLocationUpdatesRequest f50012d;

    /* renamed from: d2  reason: collision with root package name */
    private boolean f50013d2 = false;

    /* renamed from: yn  reason: collision with root package name */
    public oc f50014yn;

    public class yn implements Handler.Callback {
        public yn() {
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 1001) {
                d2.this.yn(message.getData());
                return false;
            } else if (i11 == 1002) {
                d2.this.c(message);
                return false;
            } else {
                LogConsole.w("HwBaseCallback", "handleMessage error");
                return false;
            }
        }
    }

    public d2() {
        HandlerThread handlerThread = new HandlerThread("HwBaseCallback");
        handlerThread.start();
        this.f50010b = new Handler(handlerThread.getLooper(), new yn());
    }

    public void LW(HwLocationResult hwLocationResult) {
        Message obtainMessage = this.f50010b.obtainMessage(1001);
        Bundle bundle = new Bundle();
        bundle.putParcelable("hwLocationResult", hwLocationResult);
        obtainMessage.setData(bundle);
        this.f50010b.sendMessage(obtainMessage);
    }

    public void Vw(@NonNull HwLocationResult hwLocationResult) {
        ResponseInfo responseInfo = new ResponseInfo();
        StatusInfo statusInfo = new StatusInfo(0, 0, hwLocationResult.getMessage());
        com.huawei.location.resp.Vw vw2 = new com.huawei.location.resp.Vw();
        vw2.yn(this.Vw);
        responseInfo.setLocationResult(vw2);
        List<com.huawei.location.resp.yn> arrayList = new ArrayList<>();
        if (responseInfo.getLocationResult() != null) {
            arrayList = responseInfo.getLocationResult().yn();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (com.huawei.location.resp.yn yn2 : arrayList) {
                jSONArray.put((Object) com.huawei.location.activity.model.Vw.yn(yn2.yn()));
            }
            jSONObject2.put("locations", (Object) jSONArray);
            jSONObject.put("locationResult", (Object) jSONObject2);
        } catch (JSONException unused) {
            LogConsole.e("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        LogConsole.i("HwBaseCallback", "callJson to cp, tid is " + this.f50012d.getTid() + ", uuid is " + this.f50012d.getUuid() + ", provider is " + this.Vw.getProvider());
        this.f50014yn.yn(new RouterResponse(jSONObjectInstrumentation, statusInfo));
        com.huawei.location.cache.yn.Vw().FB(this.f50012d.getUuid());
        Vw.yn ynVar = this.f50011c;
        if (ynVar != null) {
            ynVar.yn(vw2);
            this.f50011c.yn().Vw(String.valueOf(0));
        }
    }

    public void Vw(boolean z11) {
        this.f50013d2 = z11;
    }

    public boolean a(HwLocationResult hwLocationResult) {
        String str;
        if (hwLocationResult == null || hwLocationResult.getCode() != 0) {
            str = "checkLocationResult fail, hwLocationResult is invalid";
        } else if (hwLocationResult.getLocation() == null) {
            str = "checkLocationResult fail, location is null";
        } else {
            RequestLocationUpdatesRequest requestLocationUpdatesRequest = this.f50012d;
            if (requestLocationUpdatesRequest != null && !TextUtils.isEmpty(requestLocationUpdatesRequest.getUuid())) {
                return false;
            }
            str = "checkLocationResult fail, request is invalid";
        }
        LogConsole.e("HwBaseCallback", str);
        return true;
    }

    public Location b(Location location, Location location2) {
        String str;
        String str2;
        if (location == null) {
            str = "gnssTempLocation is null";
        } else {
            if (location2 == null) {
                str2 = "nlpTempLocation is null";
            } else if (location.getElapsedRealtimeNanos() >= SystemClock.elapsedRealtimeNanos() - 20000000000L) {
                str2 = "gnssLocation is better";
            } else {
                str = "network location is better";
            }
            LogConsole.i("HwBaseCallback", str2);
            return location;
        }
        LogConsole.i("HwBaseCallback", str);
        return location2;
    }

    public void c(Message message) {
    }

    public boolean d(@NonNull Location location) {
        LocationRequest locationRequest = this.f50012d.getLocationRequest();
        if (locationRequest == null) {
            LogConsole.i("HwBaseCallback", "report location fail, locationRequest is null");
            return false;
        } else if (this.Vw == null) {
            return true;
        } else {
            long elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.E5) / 1000000;
            double min = (double) Math.min(locationRequest.getInterval(), locationRequest.getFastestInterval());
            double d11 = 0.9d * min;
            if (min >= 2000.0d) {
                d11 = min - 1000.0d;
            }
            if (((double) elapsedRealtimeNanos) < d11) {
                LogConsole.e("HwBaseCallback", "report location fail, timeDifference is " + elapsedRealtimeNanos + ", provider is " + location.getProvider());
                return false;
            } else if (locationRequest.getNumUpdates() < 1) {
                LogConsole.e("HwBaseCallback", "report location fail, numUpdate < 1");
                return false;
            } else {
                double smallestDisplacement = (double) locationRequest.getSmallestDisplacement();
                if (smallestDisplacement <= 0.0d || ((double) location.distanceTo(this.Vw)) > smallestDisplacement) {
                    if (locationRequest.getExpirationTime() >= SystemClock.elapsedRealtime()) {
                        return true;
                    }
                    LogConsole.i("HwBaseCallback", "report location fail, expirationTime is not met");
                    return false;
                }
                LogConsole.i("HwBaseCallback", "report location fail, minDistance is not met");
                return false;
            }
        }
    }

    public void onLocationChanged(Location location) {
        LogConsole.i("HwBaseCallback", "gnss location successful");
        HwLocationResult hwLocationResult = new HwLocationResult();
        hwLocationResult.setLocation(location);
        LW(hwLocationResult);
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i11, Bundle bundle) {
    }

    public void yn() {
        Handler handler = this.f50010b;
        if (handler != null && handler.getLooper() != null) {
            this.f50010b.getLooper().quitSafely();
            LogConsole.i("HwBaseCallback", "handler quitSafely");
        }
    }

    public abstract void yn(Bundle bundle);

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void yn(@androidx.annotation.NonNull com.huawei.hms.location.HwLocationResult r6) {
        /*
            r5 = this;
            boolean r0 = com.huawei.location.activity.model.Vw.yn()
            java.lang.String r1 = "HwBaseCallback"
            if (r0 == 0) goto L_0x000e
            java.lang.String r6 = "no precise location permission"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r6)
            return
        L_0x000e:
            android.location.Location r0 = r5.Vw
            boolean r2 = r5.f50013d2
            if (r2 == 0) goto L_0x0048
            if (r0 == 0) goto L_0x0048
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r2.add(r0)
            com.huawei.location.logic.d2 r3 = com.huawei.location.logic.d2.yn()
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r4 = r5.f50012d
            java.lang.String r4 = r4.getTid()
            boolean r2 = r3.yn(r4, r5, r2)
            if (r2 == 0) goto L_0x0048
            java.lang.String r2 = "this locationResult add maxWaitTimeQueue , not need callback"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r2)
            android.location.Location r1 = r5.Vw
            if (r1 == 0) goto L_0x003d
            long r1 = android.os.SystemClock.elapsedRealtimeNanos()
            r5.E5 = r1
        L_0x003d:
            r5.Vw = r0
            com.huawei.location.cache.yn r1 = com.huawei.location.cache.yn.Vw()
            r1.yn((android.location.Location) r0)
            r0 = 1
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            if (r0 == 0) goto L_0x004c
            return
        L_0x004c:
            android.location.Location r0 = r6.getLocation()
            android.location.Location r1 = r5.Vw
            if (r1 == 0) goto L_0x005a
            long r1 = android.os.SystemClock.elapsedRealtimeNanos()
            r5.E5 = r1
        L_0x005a:
            r5.Vw = r0
            com.huawei.location.cache.yn r1 = com.huawei.location.cache.yn.Vw()
            r1.yn((android.location.Location) r0)
            r5.Vw((com.huawei.hms.location.HwLocationResult) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.callback.d2.yn(com.huawei.hms.location.HwLocationResult):void");
    }

    public void yn(boolean z11) {
        ResponseInfo responseInfo = new ResponseInfo();
        LocationAvailabilityInfo locationAvailabilityInfo = new LocationAvailabilityInfo();
        locationAvailabilityInfo.setLocationStatus(z11 ? 0 : 1001);
        responseInfo.setLocationAvailability(locationAvailabilityInfo);
        Gson instance = GsonUtil.getInstance();
        this.f50014yn.yn(new RouterResponse(!(instance instanceof Gson) ? instance.toJson((Object) responseInfo) : GsonInstrumentation.toJson(instance, (Object) responseInfo), new StatusInfo(0, 0, "success")));
    }

    public void yn(boolean z11, boolean z12) {
    }
}
