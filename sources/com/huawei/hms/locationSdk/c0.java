package com.huawei.hms.locationSdk;

import com.huawei.hms.locationSdk.b0;
import com.huawei.hms.support.api.location.common.CollectionsUtil;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class c0<T extends b0> {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f49159a = new ArrayList(10);

    public List<T> a() {
        return this.f49159a;
    }

    public void a(T t11) {
        if (t11 != null) {
            if (this.f49159a == null) {
                this.f49159a = new ArrayList();
            }
            String a11 = t11.a();
            HMSLocationLog.i("TidCacheManager", a11, "list to add size is:" + this.f49159a.size());
            if (b(t11) != null) {
                HMSLocationLog.i("TidCacheManager", t11.a(), "this request is included");
                return;
            }
            HMSLocationLog.i("TidCacheManager", t11.a(), "add request");
            this.f49159a.add(t11);
        }
    }

    public T b(T t11) {
        if (t11 != null && !CollectionsUtil.isEmpty((Collection<?>) this.f49159a)) {
            String a11 = t11.a();
            HMSLocationLog.i("TidCacheManager", a11, "list to find size is:" + this.f49159a.size());
            int i11 = 0;
            while (i11 < this.f49159a.size()) {
                T t12 = (b0) this.f49159a.get(i11);
                if (t12 == null || !t12.equals(t11)) {
                    i11++;
                } else {
                    String a12 = t11.a();
                    HMSLocationLog.i("TidCacheManager", a12, "find tid in list, tid:" + t12.a());
                    return t12;
                }
            }
        }
        return null;
    }

    public boolean c(T t11) {
        if (t11 != null && !CollectionsUtil.isEmpty((Collection<?>) this.f49159a)) {
            for (T t12 : this.f49159a) {
                if (t12.equals(t11)) {
                    HMSLocationLog.i("TidCacheManager", t11.a(), "remove request from list");
                    this.f49159a.remove(t12);
                    return true;
                }
            }
        }
        return false;
    }

    public void d(T t11) {
        if (t11 != null) {
            if (this.f49159a.isEmpty()) {
                HMSLocationLog.i("TidCacheManager", t11.a(), "replaceRequestCache add Request");
                this.f49159a.add(t11);
                return;
            }
            String a11 = t11.a();
            HMSLocationLog.i("TidCacheManager", a11, "list to replace size is:" + this.f49159a.size());
            int i11 = 0;
            while (i11 < this.f49159a.size()) {
                b0 b0Var = (b0) this.f49159a.get(i11);
                if (b0Var == null || !b0Var.equals(t11)) {
                    i11++;
                } else {
                    String a12 = t11.a();
                    HMSLocationLog.i("TidCacheManager", a12, "replace old tid is " + b0Var.a() + ". new tid is " + t11.a());
                    this.f49159a.set(i11, t11);
                    return;
                }
            }
            this.f49159a.add(t11);
            HMSLocationLog.i("TidCacheManager", t11.a(), "replaceRequestCache add Request.");
        }
    }
}
