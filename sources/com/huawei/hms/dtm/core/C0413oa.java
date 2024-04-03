package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.oa  reason: case insensitive filesystem */
public class C0413oa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1 || !(list.get(0) instanceof C0455wc)) {
            throw new V("customTag#wrong param");
        }
        List value = ((C0455wc) list.get(0)).value();
        if (value.size() == 2) {
            String obj = ((C0435sc) value.get(0)).value().toString();
            if (!TextUtils.isEmpty(obj)) {
                try {
                    Class<?> cls = Class.forName(obj);
                    try {
                        Method declaredMethod = cls.getDeclaredMethod(NotificationCompat.CATEGORY_CALL, new Class[]{Map.class});
                        if (value.get(1) instanceof C0465yc) {
                            Map value2 = ((C0465yc) value.get(1)).value();
                            HashMap hashMap = new HashMap();
                            for (Map.Entry entry : value2.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue() instanceof C0435sc ? ((C0435sc) entry.getValue()).d() : entry.getValue());
                            }
                            try {
                                declaredMethod.invoke(cls.newInstance(), new Object[]{hashMap});
                                return Ec.f48288a;
                            } catch (IllegalAccessException unused) {
                                throw new V("customTag#IllegalAccessException occurs");
                            } catch (InvocationTargetException unused2) {
                                throw new V("customTag#InvocationTargetException occurs");
                            } catch (InstantiationException unused3) {
                                throw new V("customTag#InstantiationException occurs");
                            }
                        } else {
                            throw new V("customTag#call param error");
                        }
                    } catch (NoSuchMethodException unused4) {
                        throw new V("customTag#no call method");
                    }
                } catch (ClassNotFoundException unused5) {
                    throw new V("customTag#ClassNotFoundException occurs");
                }
            } else {
                throw new V("customTag#classPath is null");
            }
        } else {
            throw new V("customTag#wrong param size");
        }
    }

    public String a() {
        return "customTag";
    }
}
