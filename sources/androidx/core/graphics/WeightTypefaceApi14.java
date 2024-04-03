package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock = new Object();
    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = new LongSparseArray<>(3);

    static {
        Field field;
        try {
            field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
            field.setAccessible(true);
        } catch (Exception e11) {
            Log.e(TAG, e11.getClass().getName(), e11);
            field = null;
        }
        sNativeInstance = field;
    }

    private WeightTypefaceApi14() {
    }

    @Nullable
    public static Typeface a(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
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
                Typeface typeface2 = (Typeface) sparseArray.get(z12);
                if (typeface2 != null) {
                    return typeface2;
                }
            }
            Typeface bestFontFromFamily = getBestFontFromFamily(typefaceCompatBaseImpl, context, typeface, i11, z11);
            if (bestFontFromFamily == null) {
                bestFontFromFamily = platformTypefaceCreate(typeface, i11, z11);
            }
            sparseArray.put(z12 ? 1 : 0, bestFontFromFamily);
            return bestFontFromFamily;
        }
    }

    @Nullable
    private static Typeface getBestFontFromFamily(@NonNull TypefaceCompatBaseImpl typefaceCompatBaseImpl, @NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry e11 = typefaceCompatBaseImpl.e(typeface);
        if (e11 == null) {
            return null;
        }
        return typefaceCompatBaseImpl.a(context, e11, context.getResources(), i11, z11);
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return ((Number) sNativeInstance.get(typeface)).longValue();
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static boolean isPrivateApiAvailable() {
        return sNativeInstance != null;
    }

    private static Typeface platformTypefaceCreate(Typeface typeface, int i11, boolean z11) {
        int i12 = 1;
        boolean z12 = i11 >= 600;
        if (!z12 && !z11) {
            i12 = 0;
        } else if (!z12) {
            i12 = 2;
        } else if (z11) {
            i12 = 3;
        }
        return Typeface.create(typeface, i12);
    }
}
