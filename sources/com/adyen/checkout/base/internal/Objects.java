package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public final class Objects {
    private Objects() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static <T> T reflectiveInit(@NonNull Class<T> cls, @NonNull Object... objArr) throws InvocationTargetException {
        Class[] clsArr = new Class[objArr.length];
        for (int i11 = 0; i11 < objArr.length; i11++) {
            clsArr[i11] = objArr[i11].getClass();
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(objArr);
        } catch (NoSuchMethodException e11) {
            String arrays = Arrays.toString(clsArr);
            throw new RuntimeException("Class " + cls.getSimpleName() + " does not declare constructor with arguments " + arrays + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Constructor of " + cls.getSimpleName() + " could not be made accessible.", e12);
        } catch (InstantiationException e13) {
            throw new RuntimeException("Class " + cls.getSimpleName() + " could not be instantiated.", e13);
        }
    }

    @NonNull
    public static <T> T requireNonNull(@Nullable T t11, @NonNull String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }
}
