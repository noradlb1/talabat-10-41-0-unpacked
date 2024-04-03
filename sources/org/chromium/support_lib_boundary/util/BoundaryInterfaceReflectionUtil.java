package org.chromium.support_lib_boundary.util;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;

public class BoundaryInterfaceReflectionUtil {

    @RequiresApi(19)
    public static class InvocationHandlerWithDelegateGetter implements InvocationHandler {
        private final Object mDelegate;

        public InvocationHandlerWithDelegateGetter(@NonNull Object obj) {
            this.mDelegate = obj;
        }

        @NonNull
        public Object getDelegate() {
            return this.mDelegate;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return BoundaryInterfaceReflectionUtil.dupeMethod(method, this.mDelegate.getClass().getClassLoader()).invoke(this.mDelegate, objArr);
            } catch (InvocationTargetException e11) {
                throw e11.getTargetException();
            } catch (ReflectiveOperationException e12) {
                throw new RuntimeException("Reflection failed for method " + method, e12);
            }
        }
    }

    @Nullable
    public static <T> T castToSuppLibClass(@NonNull Class<T> cls, @Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (isDebuggable()) {
                if (collection.contains(str + Features.DEV_SUFFIX)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    @RequiresApi(19)
    @Nullable
    public static InvocationHandler createInvocationHandlerFor(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    @RequiresApi(19)
    @Nullable
    public static InvocationHandler[] createInvocationHandlersForArray(@Nullable Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[length];
        for (int i11 = 0; i11 < length; i11++) {
            invocationHandlerArr[i11] = createInvocationHandlerFor(objArr[i11]);
        }
        return invocationHandlerArr;
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    @RequiresApi(19)
    @Nullable
    public static Object getDelegateFromInvocationHandler(@Nullable InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return ((InvocationHandlerWithDelegateGetter) invocationHandler).getDelegate();
    }

    public static boolean instanceOfInOwnClassLoader(Object obj, String str) {
        try {
            return Class.forName(str, false, obj.getClass().getClassLoader()).isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean isDebuggable() {
        String str = Build.TYPE;
        return "eng".equals(str) || "userdebug".equals(str);
    }

    public static boolean containsFeature(String[] strArr, String str) {
        return containsFeature((Collection<String>) Arrays.asList(strArr), str);
    }
}
