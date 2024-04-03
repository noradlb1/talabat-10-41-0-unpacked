package com.instabug.library.networkv2.service.userattributes;

import com.instabug.library.model.UserAttributes;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.TimeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f51699a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f51700b;

    public d(e eVar, Request.Callbacks callbacks) {
        this.f51700b = eVar;
        this.f51699a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        UserAttributes userAttributes;
        if (requestResponse != null && requestResponse.getResponseCode() < 400) {
            this.f51700b.f(TimeUtils.currentTimeMillis());
            if (requestResponse.getResponseCode() == 200) {
                this.f51700b.g(requestResponse.getHeaders().get("If-Match"));
                try {
                    userAttributes = a.a(a.b(requestResponse));
                } catch (JSONException e11) {
                    this.f51699a.onFailed(e11);
                    userAttributes = null;
                }
                if (userAttributes != null) {
                    this.f51700b.i(TimeUnit.SECONDS.toMillis(userAttributes.getTtl()));
                    HashMap<String, String> map = userAttributes.getMap();
                    if (map != null) {
                        this.f51699a.onSucceeded(a.c(map));
                        return;
                    }
                    this.f51699a.onSucceeded(new ArrayList());
                }
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        this.f51699a.onFailed(th2);
    }
}
