package com.huawei.hms.framework.network.grs.local.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f48952a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, d> f48953b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private List<b> f48954c = new ArrayList(16);

    public d a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f48953b.get(str);
        }
        Logger.w("Service", "In servings.getServing(String groupId), the groupId is Empty or null");
        return null;
    }

    public List<b> a() {
        return this.f48954c;
    }

    public void a(String str, d dVar) {
        if (!TextUtils.isEmpty(str) && dVar != null) {
            this.f48953b.put(str, dVar);
        }
    }

    public void a(List<b> list) {
        this.f48954c = list;
    }

    public String b() {
        return this.f48952a;
    }

    public void b(String str) {
    }

    public void c(String str) {
        this.f48952a = str;
    }
}
