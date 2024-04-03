package com.huawei.hms.dtm.core;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.dtm.core.qa  reason: case insensitive filesystem */
public class C0423qa extends Y {
    public C0435sc<?> a(X x11, List<C0435sc<?>> list) throws V {
        if (list == null || list.size() != 1 || !(list.get(0) instanceof C0455wc)) {
            throw new V("customVariable#wrong param");
        }
        List value = ((C0455wc) list.get(0)).value();
        if (value.size() == 2) {
            String obj = ((C0435sc) value.get(0)).value().toString();
            if (!TextUtils.isEmpty(obj)) {
                try {
                    Class<?> cls = Class.forName(obj);
                    try {
                        Method declaredMethod = cls.getDeclaredMethod("getValue", new Class[]{Map.class});
                        if (value.get(1) instanceof C0465yc) {
                            Map value2 = ((C0465yc) value.get(1)).value();
                            HashMap hashMap = new HashMap();
                            for (Map.Entry entry : value2.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue() instanceof C0435sc ? ((C0435sc) entry.getValue()).d() : entry.getValue());
                            }
                            try {
                                Object invoke = declaredMethod.invoke(cls.newInstance(), new Object[]{hashMap});
                                return invoke instanceof String ? new Cc((String) invoke) : Cc.f48270b;
                            } catch (IllegalAccessException unused) {
                                throw new V("customVariable#IllegalAccessException occurs");
                            } catch (InvocationTargetException unused2) {
                                throw new V("customVariable#InvocationTargetException occurs");
                            } catch (InstantiationException unused3) {
                                throw new V("customVariable#InstantiationException occurs");
                            }
                        } else {
                            throw new V("customVariable#getValue param error");
                        }
                    } catch (NoSuchMethodException unused4) {
                        throw new V("customVariable#no getValue method");
                    }
                } catch (ClassNotFoundException unused5) {
                    throw new V("customVariable#ClassNotFoundException occurs");
                }
            } else {
                throw new V("customVariable#classPath is null");
            }
        } else {
            throw new V("customVariable#wrong param size");
        }
    }

    public String a() {
        return "customVariable";
    }
}
