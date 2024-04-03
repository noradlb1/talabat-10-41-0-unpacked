package com.instabug.library;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;

class d0 implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f50551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e0 f50552b;

    public d0(e0 e0Var, Context context) {
        this.f50552b = e0Var;
        this.f50551a = context;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        if (str == null) {
            try {
                InstabugSDKLogger.e("IBG-Core", "Features response is null");
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while parsing fetching features request's response", e11);
            }
        } else {
            this.f50552b.b(System.currentTimeMillis(), this.f50551a);
            InstabugSDKLogger.d("IBG-Core", "Features fetched successfully");
            this.f50552b.h(str);
            SDKCoreEventPublisher.post(new SDKCoreEvent(SDKCoreEvent.Feature.TYPE_FEATURES_FETCHED, str));
            SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_FETCHED));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Something went wrong while do fetching features request", th2);
    }
}
