package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;

public class ForegroundIntentBuilder {

    /* renamed from: a  reason: collision with root package name */
    private Activity f47747a;

    /* renamed from: b  reason: collision with root package name */
    private RequestHeader f47748b;

    /* renamed from: c  reason: collision with root package name */
    private String f47749c;

    /* renamed from: d  reason: collision with root package name */
    private ForegroundInnerHeader f47750d;

    /* renamed from: e  reason: collision with root package name */
    private String f47751e;

    /* renamed from: f  reason: collision with root package name */
    private Context f47752f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.f47747a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.f47748b = requestHeader;
            requestHeader.setSdkVersion(61100302);
            this.f47749c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.f47750d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String str;
        String str2;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f47747a, ForegroundBusDelegate.class.getName());
        Context context = this.f47752f;
        if (context != null) {
            str2 = context.getPackageName();
            str = Util.getAppId(this.f47752f);
        } else {
            str2 = this.f47747a.getPackageName();
            str = Util.getAppId(this.f47747a);
        }
        if (this.f47748b.getAppID() == null) {
            RequestHeader requestHeader = this.f47748b;
            requestHeader.setAppID(str + "|");
        } else {
            RequestHeader requestHeader2 = this.f47748b;
            requestHeader2.setAppID(str + "|" + this.f47748b.getAppID());
        }
        if (TextUtils.isEmpty(this.f47748b.getTransactionId())) {
            RequestHeader requestHeader3 = this.f47748b;
            requestHeader3.setTransactionId(TransactionIdCreater.getId(requestHeader3.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f47748b.setPkgName(str2);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f47748b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f47749c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f47750d.toJson());
        if (!TextUtils.isEmpty(this.f47751e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f47751e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f47748b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i11) {
        this.f47748b.setApiLevel(i11);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f47752f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f47751e = this.f47747a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i11) {
        this.f47748b.setKitSdkVersion(i11);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i11) {
        this.f47750d.setApkVersion(i11);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f47749c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f47750d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f47748b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f47748b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f47748b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f47750d.setResponseCallbackKey(str);
        return this;
    }
}
