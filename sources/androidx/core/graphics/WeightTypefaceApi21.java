package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock = new Object();
    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = new LongSparseArray<>(3);

    static {
        Method method;
        Method method2;
        Field field;
        Constructor<Typeface> constructor;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField(NATIVE_INSTANCE_FIELD);
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            method2 = cls.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{cls2, cls3});
            method2.setAccessible(true);
            method = cls.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{cls2, cls3});
            method.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e11) {
            Log.e(TAG, e11.getClass().getName(), e11);
            field = null;
            constructor = null;
            method2 = null;
            method = null;
        }
        sNativeInstance = field;
        sNativeCreateFromTypeface = method2;
        sNativeCreateWeightAlias = method;
        sConstructor = constructor;
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    public static Typeface a(@NonNull Typeface typeface, int i11, boolean z11) {
        Typeface typeface2;
        if (!isPrivateApiAvailable()) {
            return null;
        }
        boolean z12 = (i11 << 1) | z11;
        synchronized (sWeightCacheLock) {
            long nativeInstance = getNativeInstance(typeface);
            LongSparseArray<SparseArray<Typeface>> longSparseArray = sWeightTypefaceCache;
            SparseArray sparseArray = longSparseArray.get(nativeInstance);
            if (sparseArray == null) {
                sparseArray = new SparseArray(4);
                longSparseArray.put(nativeInstance, sparseArray);
            } else {
                Typeface typeface3 = (Typeface) sparseArray.get(z12);
                if (typeface3 != null) {
                    return typeface3;
                }
            }
            if (z11 == typeface.isItalic()) {
                typeface2 = create(nativeCreateWeightAlias(nativeInstance, i11));
            } else {
                typeface2 = create(nativeCreateFromTypefaceWithExactStyle(nativeInstance, i11, z11));
            }
            sparseArray.put(z12 ? 1 : 0, typeface2);
            return typeface2;
        }
    }

    @Nullable
    private static Typeface create(long j11) {
        try {
            return sConstructor.newInstance(new Object[]{Long.valueOf(j11)});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return sNativeInstance.getLong(typeface);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static boolean isPrivateApiAvailable() {
        return sNativeInstance != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long j11, int i11, boolean z11) {
        int i12;
        if (z11) {
            i12 = 2;
        } else {
            i12 = 0;
        }
        try {
            return ((Long) sNativeCreateWeightAlias.invoke((Object) null, new Object[]{Long.valueOf(((Long) sNativeCreateFromTypeface.invoke((Object) null, new Object[]{Long.valueOf(j11), Integer.valueOf(i12)})).longValue()), Integer.valueOf(i11)})).longValue();
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long j11, int i11) {
        try {
            return ((Long) sNativeCreateWeightAlias.invoke((Object) null, new Object[]{Long.valueOf(j11), Integer.valueOf(i11)})).longValue();
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }
}
