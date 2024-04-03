package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;
import com.huawei.hms.support.log.HMSLog;
import java.util.Collection;
import java.util.List;

public class g extends AbstractClientBuilder<s, w> {

    public static class a implements BaseHmsClient.ConnectionCallbacks {

        /* renamed from: d  reason: collision with root package name */
        private static final byte[] f49173d = new byte[0];

        /* renamed from: a  reason: collision with root package name */
        private Context f49174a;

        /* renamed from: b  reason: collision with root package name */
        private BaseHmsClient.ConnectionCallbacks f49175b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Handler f49176c;

        /* renamed from: com.huawei.hms.locationSdk.g$a$a  reason: collision with other inner class name */
        public class C0069a implements Handler.Callback {
            public C0069a() {
            }

            public boolean handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 1001) {
                    a.this.f49176c.removeMessages(1002);
                    a.this.f49176c.sendEmptyMessageDelayed(1002, 12000);
                    a.this.d();
                    return false;
                } else if (i11 != 1002) {
                    return false;
                } else {
                    a.this.b();
                    return false;
                }
            }
        }

        public class b implements OnFailureListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ LocationCallback f49178a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PendingIntent f49179b;

            public b(LocationCallback locationCallback, PendingIntent pendingIntent) {
                this.f49178a = locationCallback;
                this.f49179b = pendingIntent;
            }

            public void onFailure(Exception exc) {
                HMSLog.e("LocationClientBuilder", "task request onFailure");
                a.this.f49176c.removeMessages(1002);
                a.this.a(exc, this.f49178a, this.f49179b);
                LocationClientStateManager.getInstance().setResendState(2);
            }
        }

        public class c implements OnSuccessListener<Void> {
            public c() {
            }

            /* renamed from: a */
            public void onSuccess(Void voidR) {
                HMSLog.i("LocationClientBuilder", "task request onSuccess");
                a.this.f49176c.removeMessages(1002);
                LocationClientStateManager.getInstance().setResendState(0);
            }
        }

        public a(Context context, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
            this.f49174a = context;
            this.f49175b = connectionCallbacks;
        }

        private void a() {
            boolean checkCanResendRequest = LocationClientStateManager.getInstance().checkCanResendRequest();
            if (checkCanResendRequest) {
                e();
            }
            HMSLog.i("LocationClientBuilder", "checkCanResend:" + checkCanResendRequest + ",reStartHmsLocation restartState：" + LocationClientStateManager.getInstance().getResendState());
        }

        private void a(Task<Void> task, LocationCallback locationCallback, PendingIntent pendingIntent) {
            task.addOnSuccessListener(new c()).addOnFailureListener(new b(locationCallback, pendingIntent));
        }

        private void a(FusedLocationProviderClient fusedLocationProviderClient, e0 e0Var) {
            Task<Void> task;
            LocationCallback c11 = e0Var.c();
            LocationRequest d11 = e0Var.d();
            PendingIntent b11 = e0Var.b();
            if (d11 == null) {
                LocationClientStateManager.getInstance().setResendState(0);
                HMSLocationLog.w("LocationClientBuilder", e0Var.a(), "onConnected, requests cache list param is error");
                return;
            }
            d11.putExtras("isReRequest", "1");
            if (c11 != null) {
                if (TextUtils.equals(e0Var.f(), "ExCallback")) {
                    HMSLocationLog.i("LocationClientBuilder", e0Var.a(), "send ex location request");
                    task = fusedLocationProviderClient.requestLocationUpdatesEx(d11, c11, e0Var.e());
                } else {
                    HMSLocationLog.i("LocationClientBuilder", e0Var.a(), "send location request");
                    task = fusedLocationProviderClient.requestLocationUpdates(d11, c11, e0Var.e());
                }
                a(task, c11, (PendingIntent) null);
            } else if (b11 != null) {
                a(fusedLocationProviderClient.requestLocationUpdates(d11, b11), (LocationCallback) null, b11);
            } else {
                LocationClientStateManager.getInstance().setResendState(0);
                HMSLocationLog.w("LocationClientBuilder", e0Var.a(), "onConnected, requests cache list param is error");
            }
        }

        /* access modifiers changed from: private */
        public void a(Exception exc, LocationCallback locationCallback, PendingIntent pendingIntent) {
            String str;
            try {
                if (exc instanceof ApiException) {
                    ApiException apiException = (ApiException) exc;
                    int statusCode = apiException.getStatusCode();
                    if (statusCode == 10000 || statusCode == 10102 || statusCode == 10803) {
                        if (locationCallback != null) {
                            LocationAvailability locationAvailability = new LocationAvailability();
                            locationAvailability.setLocationStatus(1001);
                            locationCallback.onLocationAvailability(locationAvailability);
                            HMSLog.e("LocationClientBuilder", "task request onFailure from Location and callback to cp ,errorCode " + apiException.getStatusCode());
                        }
                        if (pendingIntent != null) {
                            Intent intent = new Intent();
                            LocationAvailability locationAvailability2 = new LocationAvailability();
                            locationAvailability2.setLocationStatus(1001);
                            intent.putExtra("com.huawei.hms.location.EXTRA_LOCATION_AVAILABILITY", locationAvailability2);
                            pendingIntent.send(this.f49174a, 0, intent);
                            str = "task request onFailure from Location and pendingIntent to cp ,errorCode " + apiException.getStatusCode();
                        } else {
                            return;
                        }
                    } else if (statusCode == 907135004) {
                        HMSLog.e("LocationClientBuilder", "task request onFailure from HMS and checkRestart");
                        a();
                        return;
                    } else {
                        return;
                    }
                } else {
                    str = "handlerOnFailureMsg failed by instanceof failed";
                }
                HMSLog.e("LocationClientBuilder", str);
            } catch (Exception unused) {
                HMSLog.e("LocationClientBuilder", "handlerOnFailureMsg failed by exception");
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            if (LocationClientStateManager.getInstance().getResendState() == 1) {
                LocationClientStateManager.getInstance().setResendState(2);
                HMSLog.e("LocationClientBuilder", "reSend request time out ,reset state to RE_START_STATE_FAILED");
            }
        }

        private void c() {
            if (this.f49176c == null) {
                HandlerThread handlerThread = new HandlerThread("LocationClientBuilder");
                handlerThread.start();
                this.f49176c = new Handler(handlerThread.getLooper(), new C0069a());
            }
        }

        /* access modifiers changed from: private */
        public void d() {
            try {
                List<e0> a11 = d0.b().a();
                if (CollectionsUtil.isEmpty((Collection<?>) a11)) {
                    HMSLog.i("LocationClientBuilder", "onConnected, requests cache list is empty remove delay check msg");
                    this.f49176c.removeMessages(1002);
                    LocationClientStateManager.getInstance().setResendState(0);
                    return;
                }
                HMSLog.i("LocationClientBuilder", "request cache list size:" + a11.size());
                FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.f49174a);
                for (e0 e0Var : a11) {
                    HMSLocationLog.i("LocationClientBuilder", e0Var.a(), "onConnected, request in cache list prepare to send");
                    a(fusedLocationProviderClient, e0Var);
                }
            } catch (Exception unused) {
                LocationClientStateManager.getInstance().setResendState(2);
                HMSLog.e("LocationClientBuilder", "onConnected exception");
            }
        }

        private void e() {
            synchronized (f49173d) {
                HMSLog.i("LocationClientBuilder", "reStartHmsLocation restartState：" + LocationClientStateManager.getInstance().getResendState());
                LocationClientStateManager.getInstance().setResendState(1);
                c();
                this.f49176c.sendEmptyMessageDelayed(1001, 300);
            }
        }

        public void onConnected() {
            HMSLog.i("LocationClientBuilder", "onConnected, send suspended requests,reStartState:" + LocationClientStateManager.getInstance().getResendState());
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.f49175b;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnected();
            }
            if (LocationClientStateManager.getInstance().getResendState() == 2) {
                e();
            }
        }

        public void onConnectionSuspended(int i11) {
            HMSLog.i("LocationClientBuilder", "onConnectionSuspended reason:" + i11);
            BaseHmsClient.ConnectionCallbacks connectionCallbacks = this.f49175b;
            if (connectionCallbacks != null) {
                connectionCallbacks.onConnectionSuspended(i11);
            }
            a();
        }
    }

    public s buildClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        return new s(context, clientSettings, onConnectionFailedListener, new a(context, connectionCallbacks));
    }
}
