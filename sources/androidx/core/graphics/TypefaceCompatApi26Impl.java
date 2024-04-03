package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f11284a;

    /* renamed from: b  reason: collision with root package name */
    public final Constructor<?> f11285b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f11286c;

    /* renamed from: d  reason: collision with root package name */
    public final Method f11287d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f11288e;

    /* renamed from: f  reason: collision with root package name */
    public final Method f11289f;

    /* renamed from: g  reason: collision with root package name */
    public final Method f11290g;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = j();
            constructor = k(cls);
            method5 = g(cls);
            method4 = h(cls);
            method3 = l(cls);
            method2 = f(cls);
            method = i(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e11) {
            Log.e(TAG, "Unable to collect necessary methods for class " + e11.getClass().getName(), e11);
            cls = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f11284a = cls;
        this.f11285b = constructor;
        this.f11286c = method5;
        this.f11287d = method4;
        this.f11288e = method3;
        this.f11289f = method2;
        this.f11290g = method;
    }

    private void abortCreation(Object obj) {
        try {
            this.f11289f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i11, int i12, int i13, @Nullable FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f11286c.invoke(obj, new Object[]{context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i11, int i12, int i13) {
        try {
            return ((Boolean) this.f11287d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i11), null, Integer.valueOf(i12), Integer.valueOf(i13)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean freeze(Object obj) {
        try {
            return ((Boolean) this.f11288e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.f11286c == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (this.f11286c != null) {
            return true;
        }
        return false;
    }

    @Nullable
    private Object newFamily() {
        try {
            return this.f11285b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @NonNull
    public Typeface c(@NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi26.a(typeface, i11, z11);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return super.c(context, typeface, i11, z11);
        }
        return typeface2;
    }

    @Nullable
    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f11284a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f11290g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i11) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i11);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        Typeface createFromFamiliesWithDefault;
        ParcelFileDescriptor openFileDescriptor;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (!isFontFamilyPrivateAPIAvailable()) {
            FontsContractCompat.FontInfo d11 = d(fontInfoArr, i11);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(d11.getUri(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface a11 = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(d11.getWeight()).setItalic(d11.isItalic()).build();
                openFileDescriptor.close();
                return a11;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            Map<Uri, ByteBuffer> readFontInfoIntoByteBuffer = TypefaceCompatUtil.readFontInfoIntoByteBuffer(context, fontInfoArr, cancellationSignal);
            Object newFamily = newFamily();
            if (newFamily == null) {
                return null;
            }
            boolean z11 = false;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = readFontInfoIntoByteBuffer.get(fontInfo.getUri());
                if (byteBuffer != null) {
                    if (!addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic() ? 1 : 0)) {
                        abortCreation(newFamily);
                        return null;
                    }
                    z11 = true;
                }
            }
            if (!z11) {
                abortCreation(newFamily);
                return null;
            } else if (freeze(newFamily) && (createFromFamiliesWithDefault = createFromFamiliesWithDefault(newFamily)) != null) {
                return Typeface.create(createFromFamiliesWithDefault, i11);
            } else {
                return null;
            }
        }
        throw th;
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i11, String str, int i12) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i11, str, i12);
        }
        Object newFamily = newFamily();
        if (newFamily == null) {
            return null;
        }
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }

    public Method f(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    public Method g(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, new Class[]{AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    public Method h(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    public Method i(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> j() throws ClassNotFoundException {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    public Constructor<?> k(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    public Method l(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(FREEZE_METHOD, new Class[0]);
    }
}
