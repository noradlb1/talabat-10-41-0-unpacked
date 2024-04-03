package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final String f48191a;

    /* renamed from: b  reason: collision with root package name */
    private final String f48192b;

    /* renamed from: c  reason: collision with root package name */
    private Parcelable f48193c;

    /* renamed from: d  reason: collision with root package name */
    private String f48194d;

    /* renamed from: e  reason: collision with root package name */
    private CancellationToken f48195e;

    /* renamed from: f  reason: collision with root package name */
    private int f48196f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f48196f = 1;
        this.f48191a = str;
        this.f48192b = str2;
        this.f48193c = null;
        this.f48194d = null;
    }

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f48196f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f48193c;
    }

    public String getRequestJson() {
        return this.f48192b;
    }

    public CancellationToken getToken() {
        return this.f48195e;
    }

    public String getTransactionId() {
        return this.f48194d;
    }

    public String getUri() {
        return this.f48191a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f48195e;
        if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f48191a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f48194d);
            doExecute(clientt, responseErrorCode, str, taskCompletionSource);
            return;
        }
        HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f48191a + ", transactionId:" + this.f48194d);
    }

    public void setApiLevel(int i11) {
        this.f48196f = i11;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f48193c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f48195e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f48194d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f48196f = 1;
        this.f48191a = str;
        this.f48192b = str2;
        this.f48193c = null;
        this.f48194d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i11) {
        this.f48191a = str;
        this.f48192b = str2;
        this.f48193c = null;
        this.f48194d = str3;
        this.f48196f = i11;
    }
}
