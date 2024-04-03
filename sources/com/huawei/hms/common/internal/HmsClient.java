package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@Instrumented
public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        BaseAdapter baseAdapter;
        if (callBack == null) {
            HMSLog.e("HmsClient", "callback is invalid, discard.");
            return;
        }
        boolean z11 = true;
        if (!(iMessageEntity instanceof RequestHeader) || str == null) {
            HMSLog.e("HmsClient", "arguments is invalid.");
            callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), JSONObjectInstrumentation.toString(new JSONObject()));
            return;
        }
        if (!isConnected()) {
            HMSLog.i("HmsClient", "No connection now, the connection status:" + getConnectionStatus());
            if (getConnectionStatus() != 6) {
                HMSLog.e("HmsClient", "post failed for not connected.");
                callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), JSONObjectInstrumentation.toString(new JSONObject()));
                return;
            }
            HMSLog.i("HmsClient", "in timeout-disconnect status, need to bind again.");
            a();
        }
        RequestHeader requestHeader = (RequestHeader) iMessageEntity;
        HMSLog.i("HmsClient", "post msg " + requestHeader);
        Activity cpActivity = getClientSettings().getCpActivity();
        if (cpActivity != null) {
            z11 = false;
        }
        if (z11) {
            HMSLog.i("HmsClient", "Activity is null for " + getClientSettings().getAppID());
        }
        if (z11) {
            baseAdapter = new BaseAdapter(this);
        } else {
            baseAdapter = new BaseAdapter(this, cpActivity);
        }
        baseAdapter.baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new a(this, callBack));
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    @Instrumented
    public static class a implements BaseAdapter.BaseCallBack {

        /* renamed from: a  reason: collision with root package name */
        private final AnyClient.CallBack f48174a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<HmsClient> f48175b;

        public a(HmsClient hmsClient, AnyClient.CallBack callBack) {
            this.f48174a = callBack;
            this.f48175b = new WeakReference<>(hmsClient);
        }

        private void a(String str) {
            HmsClient hmsClient = this.f48175b.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                a(str, str2);
            } else {
                a(str, str2, parcelable);
            }
        }

        public void onError(String str) {
            if (this.f48174a != null) {
                ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
                if (responseWrap.fromJson(str)) {
                    HMSLog.i("HmsClient", "receive msg " + responseWrap);
                    ResponseHeader responseHeader = responseWrap.getResponseHeader();
                    a(responseHeader.getSessionId());
                    this.f48174a.onCallback(responseHeader, responseWrap.getBody());
                    return;
                }
                this.f48174a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), JSONObjectInstrumentation.toString(new JSONObject()));
            }
        }

        private void a(String str, String str2) {
            if (this.f48174a != null) {
                ResponseHeader responseHeader = new ResponseHeader();
                if (responseHeader.fromJson(str)) {
                    HMSLog.i("HmsClient", "receive msg " + responseHeader);
                    a(responseHeader.getSessionId());
                    this.f48174a.onCallback(responseHeader, str2);
                    return;
                }
                this.f48174a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), JSONObjectInstrumentation.toString(new JSONObject()));
            }
        }

        private void a(String str, String str2, Parcelable parcelable) {
            if (this.f48174a != null) {
                ResponseHeader responseHeader = new ResponseHeader();
                if (responseHeader.fromJson(str)) {
                    responseHeader.setParcelable(parcelable);
                    HMSLog.i("HmsClient", "receive msg " + responseHeader);
                    a(responseHeader.getSessionId());
                    this.f48174a.onCallback(responseHeader, str2);
                    return;
                }
                this.f48174a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), JSONObjectInstrumentation.toString(new JSONObject()));
            }
        }
    }
}
