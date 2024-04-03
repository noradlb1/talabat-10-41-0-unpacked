package com.huawei.location.router.entity;

import android.os.Parcelable;
import com.huawei.location.router.interfaces.IRouterCallback;

public class RouterRequest {
    private boolean agcFail;
    private final String apiName;
    private Parcelable parcelable;
    private final String requestJson;
    private final IRouterCallback routerCallback;
    private final String transactionId;

    public RouterRequest(String str, String str2, String str3, IRouterCallback iRouterCallback) {
        this(str, str2, str3, iRouterCallback, (Parcelable) null);
    }

    public RouterRequest(String str, String str2, String str3, IRouterCallback iRouterCallback, Parcelable parcelable2) {
        this.apiName = str;
        this.requestJson = str2;
        this.parcelable = parcelable2;
        this.transactionId = str3;
        this.routerCallback = iRouterCallback;
    }

    public String getApiName() {
        return this.apiName;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getRequestJson() {
        return this.requestJson;
    }

    public IRouterCallback getRouterCallback() {
        return this.routerCallback;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public boolean isAgcFail() {
        return this.agcFail;
    }

    public void setAgcFail(boolean z11) {
        this.agcFail = z11;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }
}
