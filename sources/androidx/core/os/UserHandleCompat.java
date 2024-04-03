package androidx.core.os;

import android.os.Build;
import android.os.UserHandle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(17)
public class UserHandleCompat {
    @Nullable
    private static Method sGetUserIdMethod;
    @Nullable
    private static Constructor<UserHandle> sUserHandleConstructor;

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @NonNull
        public static UserHandle a(int i11) {
            return UserHandle.getUserHandleForUid(i11);
        }
    }

    private UserHandleCompat() {
    }

    private static Method getGetUserIdMethod() throws NoSuchMethodException {
        if (sGetUserIdMethod == null) {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("getUserId", new Class[]{Integer.TYPE});
            sGetUserIdMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        return sGetUserIdMethod;
    }

    private static Constructor<UserHandle> getUserHandleConstructor() throws NoSuchMethodException {
        if (sUserHandleConstructor == null) {
            Constructor<UserHandle> declaredConstructor = UserHandle.class.getDeclaredConstructor(new Class[]{Integer.TYPE});
            sUserHandleConstructor = declaredConstructor;
            declaredConstructor.setAccessible(true);
        }
        return sUserHandleConstructor;
    }

    @NonNull
    public static UserHandle getUserHandleForUid(int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.a(i11);
        }
        try {
            Method getUserIdMethod = getGetUserIdMethod();
            Object[] objArr = {Integer.valueOf(i11)};
            return getUserHandleConstructor().newInstance(new Object[]{(Integer) getUserIdMethod.invoke((Object) null, objArr)});
        } catch (NoSuchMethodException e11) {
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
            noSuchMethodError.initCause(e11);
            throw noSuchMethodError;
        } catch (IllegalAccessException e12) {
            IllegalAccessError illegalAccessError = new IllegalAccessError();
            illegalAccessError.initCause(e12);
            throw illegalAccessError;
        } catch (InstantiationException e13) {
            InstantiationError instantiationError = new InstantiationError();
            instantiationError.initCause(e13);
            throw instantiationError;
        } catch (InvocationTargetException e14) {
            throw new RuntimeException(e14);
        }
    }
}
