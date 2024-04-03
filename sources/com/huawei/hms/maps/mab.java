package com.huawei.hms.maps;

import com.huawei.hms.maps.provider.inhuawei.IHuaweiMapDelegate;
import com.huawei.hms.maps.utils.LogM;
import java.lang.reflect.Constructor;

public abstract class mab {
    public HuaweiMap a(IHuaweiMapDelegate iHuaweiMapDelegate) {
        try {
            Constructor<?> declaredConstructor = Class.forName("com.huawei.hms.maps.HuaweiMapEx").getDeclaredConstructor(new Class[]{IHuaweiMapDelegate.class});
            declaredConstructor.setAccessible(true);
            return (HuaweiMap) declaredConstructor.newInstance(new Object[]{iHuaweiMapDelegate});
        } catch (Throwable unused) {
            LogM.w("BaseLifecycleDelegate", "load mapEx failed.");
            return new HuaweiMap(iHuaweiMapDelegate);
        }
    }
}
