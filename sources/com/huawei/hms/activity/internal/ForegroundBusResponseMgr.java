package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr {

    /* renamed from: b  reason: collision with root package name */
    private static final ForegroundBusResponseMgr f47755b = new ForegroundBusResponseMgr();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, BusResponseCallback> f47756a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return f47755b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f47756a) {
            busResponseCallback = this.f47756a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (!TextUtils.isEmpty(str) && busResponseCallback != null) {
            synchronized (this.f47756a) {
                if (!this.f47756a.containsKey(str)) {
                    this.f47756a.put(str, busResponseCallback);
                }
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f47756a) {
                this.f47756a.remove(str);
            }
        }
    }
}
