package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Service> f47541a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, Object> f47542b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<Class<?>, Service> f47543c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<Class<?>, Object> f47544d = new HashMap();

    public d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service2) {
        StringBuilder sb2;
        Class<Context> cls = Context.class;
        if (service2.getInstance() != null) {
            return service2.getInstance();
        }
        Class<?> type = service2.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a11 = a((Class) type, cls, AGConnectInstance.class);
            if (a11 != null) {
                return a11.newInstance(new Object[]{aGConnectInstance.getContext(), aGConnectInstance});
            }
            Constructor a12 = a((Class) type, cls);
            if (a12 == null) {
                return type.newInstance();
            }
            return a12.newInstance(new Object[]{aGConnectInstance.getContext()});
        } catch (InstantiationException e11) {
            e = e11;
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            sb2.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        } catch (InvocationTargetException e12) {
            e = e12;
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            sb2.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        } catch (IllegalAccessException e13) {
            e = e13;
            sb2 = new StringBuilder();
            sb2.append("Instantiate service exception ");
            sb2.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb2.toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z11 = false;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i11 = 0; i11 < clsArr.length; i11++) {
                    z11 = parameterTypes[i11] == clsArr[i11];
                }
                if (z11) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cause message:");
        sb2.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb2.toString());
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t11;
        Service service2 = this.f47543c.get(cls);
        if (service2 == null && (service2 = f47541a.get(cls)) != null) {
            return f47542b.get(cls);
        }
        if (service2 == null) {
            return null;
        }
        if (service2.isSingleton() && (t11 = this.f47544d.get(cls)) != null) {
            return t11;
        }
        T a11 = a(aGConnectInstance, service2);
        if (a11 != null && service2.isSingleton()) {
            this.f47544d.put(cls, a11);
        }
        return a11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.huawei.agconnect.core.Service> r7, android.content.Context r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Iterator r7 = r7.iterator()
        L_0x0007:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r7.next()
            com.huawei.agconnect.core.Service r0 = (com.huawei.agconnect.core.Service) r0
            boolean r1 = r0.isSharedInstance()
            if (r1 == 0) goto L_0x0028
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = f47541a
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0031
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = f47541a
            goto L_0x002a
        L_0x0028:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = r6.f47543c
        L_0x002a:
            java.lang.Class r2 = r0.getInterface()
            r1.put(r2, r0)
        L_0x0031:
            boolean r1 = r0.isAutoCreated()
            if (r1 == 0) goto L_0x0007
            java.lang.Class r1 = r0.getType()
            if (r1 == 0) goto L_0x0007
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = f47542b
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0007
            java.lang.Class r1 = r0.getType()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Class<android.content.Context> r4 = android.content.Context.class
            r5 = 0
            r3[r5] = r4     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = a((java.lang.Class) r1, (java.lang.Class[]) r3)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            if (r1 == 0) goto L_0x0064
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            r2[r5] = r8     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            goto L_0x006c
        L_0x0064:
            java.lang.Class r1 = r0.getType()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
        L_0x006c:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = f47542b     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Class r0 = r0.getInterface()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            r2.put(r0, r1)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            goto L_0x0007
        L_0x0076:
            r0 = move-exception
            java.lang.String r1 = "TargetException"
            goto L_0x0081
        L_0x007a:
            r0 = move-exception
            java.lang.String r1 = "InstantiationException"
            goto L_0x0081
        L_0x007e:
            r0 = move-exception
            java.lang.String r1 = "AccessException"
        L_0x0081:
            r6.a((java.lang.String) r1, (java.lang.Exception) r0)
            goto L_0x0007
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.a(java.util.List, android.content.Context):void");
    }
}
