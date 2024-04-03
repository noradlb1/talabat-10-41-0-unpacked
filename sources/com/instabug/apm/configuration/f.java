package com.instabug.apm.configuration;

import androidx.collection.ArrayMap;
import java.util.Map;

public class f implements e {

    /* renamed from: a  reason: collision with root package name */
    private Map f45271a = new ArrayMap();

    public void a(String str, Object obj) {
        this.f45271a.put(str, obj);
    }

    public Object b(String str, Object obj) {
        Object obj2 = this.f45271a.get(str);
        return (obj2 == null || !obj2.getClass().isInstance(obj)) ? obj : obj2;
    }
}
