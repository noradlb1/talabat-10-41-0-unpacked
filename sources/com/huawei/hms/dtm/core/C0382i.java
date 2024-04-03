package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.dtm.core.i  reason: case insensitive filesystem */
public class C0382i {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, C0367f> f48492a;

    /* renamed from: com.huawei.hms.dtm.core.i$a */
    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final C0382i f48493a = new C0382i();
    }

    private C0382i() {
        this.f48492a = new ConcurrentHashMap<>();
    }

    public static C0382i a() {
        return a.f48493a;
    }

    public C0367f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f48492a.get(str);
    }

    public void a(String str, C0367f fVar) {
        if (!TextUtils.isEmpty(str) && fVar != null) {
            this.f48492a.put(str, fVar);
        }
    }

    public C0367f b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f48492a.remove(str);
    }
}
