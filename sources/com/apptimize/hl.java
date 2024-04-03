package com.apptimize;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.apptimize.gn;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hl {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42949a = "hl";

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Map<String, hj<?, ?, ?>>> f42950b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private hg f42951c;

    private void b(hj<?, ?, ?> hjVar, Method method) {
        if (method == null) {
            String str = f42949a;
            bo.k(str, "null setter for " + hjVar);
        } else if (this.f42951c != null) {
            gn.a(method, (gk) new hd(this.f42951c, hjVar, method), gn.b.f42666d);
            hjVar.a(method);
        } else {
            bo.b(f42949a, "ViewNodeFactory not initialized");
        }
    }

    private static void c(hj<?, ?, ?> hjVar) {
        Class<? extends Object> b11 = hjVar.b().b();
        if ((Drawable.class.isAssignableFrom(b11) || io.class.isAssignableFrom(b11)) && !ii.a(hjVar.a())) {
            String str = f42949a;
            bo.b(str, "Image property " + hjVar.a() + " not registered with ImageCachingManager. May lead to images not being fetched");
        }
    }

    public hj a(hj<?, ?, ?> hjVar) {
        String name2 = hjVar.c().b().getName();
        c(hjVar);
        if (!this.f42950b.containsKey(name2)) {
            this.f42950b.put(name2, new HashMap());
        }
        this.f42950b.get(name2).put(hjVar.a(), hjVar);
        return hjVar;
    }

    public void a(hj<?, ?, ?> hjVar, Method method) {
        b(hjVar, method);
    }

    public <S, T, V> hj<S, T, V> b(hj<S, T, V> hjVar) {
        a((hj<?, ?, ?>) hjVar);
        try {
            b(hjVar, hjVar.c().a());
        } catch (NoSuchMethodException e11) {
            String str = f42949a;
            bo.d(str, "Error adding property " + hjVar.a(), e11);
        }
        return hjVar;
    }

    public hj<?, ?, ?> a(Object obj, String str) {
        return a(obj.getClass(), str);
    }

    private hj<?, ?, ?> a(Class<?> cls, String str) {
        if (cls == null) {
            return null;
        }
        Map map = this.f42950b.get(cls.getName());
        if (map == null || !map.containsKey(str)) {
            return a((Class<?>) cls.getSuperclass(), str);
        }
        return (hj) map.get(str);
    }

    public JSONArray a(View view) {
        JSONArray jSONArray = new JSONArray();
        for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
            Map map = this.f42950b.get(cls.getName());
            if (map != null) {
                for (hj hjVar : map.values()) {
                    try {
                        JSONObject b11 = hjVar.b(view);
                        if (b11 == null) {
                            bo.c(f42949a, String.format("Error when extracting property %s from object %s", new Object[]{hjVar.a(), view}));
                        } else {
                            jSONArray.put((Object) b11);
                        }
                    } catch (JSONException e11) {
                        bo.c(f42949a, String.format("Error retrieving property %s from object %s", new Object[]{hjVar.a(), view}), e11);
                    } catch (hk e12) {
                        if (!(e12 instanceof il) || av.f41257t) {
                            bo.a(f42949a, String.format("Error retrieving property %s from object %s", new Object[]{hjVar.a(), view}), e12);
                        }
                    }
                }
            }
        }
        return jSONArray;
    }

    public void a(hg hgVar) {
        this.f42951c = hgVar;
    }
}
