package com.huawei.hms.dtm.core.debug;

import android.text.TextUtils;
import com.huawei.hms.dtm.core.V;
import com.huawei.hms.dtm.core.util.Logger;
import java.lang.reflect.InvocationTargetException;

public final class PropertyUtil {
    private PropertyUtil() {
        throw new UnsupportedOperationException("Util");
    }

    private static Object a(Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws V {
        String str2;
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new V("paramsType is null, but params is not null");
                }
            } else if (objArr == null) {
                throw new V("paramsType or params should be same");
            } else if (clsArr.length != objArr.length) {
                throw new V("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke((Object) null, objArr);
                } catch (IllegalAccessException unused) {
                    str2 = "invokeStaticFun(): method invoke Exception!";
                    Logger.info("HMS-DTM", str2);
                    return null;
                } catch (IllegalArgumentException unused2) {
                    str2 = "invokeStaticFun(): Illegal Argument!";
                    Logger.info("HMS-DTM", str2);
                    return null;
                } catch (InvocationTargetException unused3) {
                    str2 = "invokeStaticFun(): Invocation Target Exception!";
                    Logger.info("HMS-DTM", str2);
                    return null;
                }
            } catch (NoSuchMethodException unused4) {
                Logger.info("HMS-DTM", "invokeStaticFun(): cls.getMethod(),No Such Method !");
            }
        } else {
            throw new V("class is null in invokeStaticFun");
        }
    }

    private static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException unused) {
            str3 = "invokeStaticFun() Not found class!";
            Logger.error("HMS-DTM", str3);
            return null;
        } catch (V unused2) {
            str3 = "invokeStaticFun(): Static function call Exception ";
            Logger.error("HMS-DTM", str3);
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        Class<String> cls = String.class;
        Object a11 = a(str, "get", new Class[]{cls, cls}, new Object[]{str2, str3});
        return a11 != null ? (String) a11 : str3;
    }

    public static String getSystemProperty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        String a11 = a("android.os.SystemProperties", str, str2);
        return TextUtils.isEmpty(a11) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a11;
    }
}
