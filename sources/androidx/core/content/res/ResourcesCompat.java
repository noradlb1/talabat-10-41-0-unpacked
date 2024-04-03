package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import d1.b;
import d1.c;
import d1.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ResourcesCompat {
    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = new Object();
    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();

    @RequiresApi(15)
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static Drawable a(Resources resources, int i11, int i12) {
            return resources.getDrawableForDensity(i11, i12);
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Drawable a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getDrawable(i11, theme);
        }

        @DoNotInline
        public static Drawable b(Resources resources, int i11, int i12, Resources.Theme theme) {
            return resources.getDrawableForDensity(i11, i12, theme);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int a(Resources resources, int i11, Resources.Theme theme) {
            return resources.getColor(i11, theme);
        }

        @DoNotInline
        @NonNull
        public static ColorStateList b(@NonNull Resources resources, @ColorRes int i11, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i11, theme);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static float a(@NonNull Resources resources, @DimenRes int i11) {
            return resources.getFloat(i11);
        }
    }

    public static class ColorStateListCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        public final ColorStateList f11273a;

        /* renamed from: b  reason: collision with root package name */
        public final Configuration f11274b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11275c;

        public ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            int i11;
            this.f11273a = colorStateList;
            this.f11274b = configuration;
            if (theme == null) {
                i11 = 0;
            } else {
                i11 = theme.hashCode();
            }
            this.f11275c = i11;
        }
    }

    public static final class ColorStateListCacheKey {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f11276a;

        /* renamed from: b  reason: collision with root package name */
        public final Resources.Theme f11277b;

        public ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.f11276a = resources;
            this.f11277b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (!this.f11276a.equals(colorStateListCacheKey.f11276a) || !ObjectsCompat.equals(this.f11277b, colorStateListCacheKey.f11277b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f11276a, this.f11277b);
        }
    }

    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int i11, @Nullable Handler handler) {
            getHandler(handler).post(new c(this, i11));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new b(this, typeface));
        }

        /* renamed from: onFontRetrievalFailed */
        public abstract void lambda$callbackFailAsync$1(int i11);

        /* renamed from: onFontRetrieved */
        public abstract void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        public static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            public static void a(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e11) {
                            Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e11);
                        }
                        sRebaseMethodFetched = true;
                    }
                    Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e12) {
                            Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e12);
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        public static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            public static void a(@NonNull Resources.Theme theme) {
                d.a(theme);
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.a(theme);
            } else {
                Api23Impl.a(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i11, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
            SparseArray sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i11, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f11276a.getConfiguration(), theme));
        }
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            Iterator<ColorStateListCacheKey> it = sColorStateCaches.keySet().iterator();
            while (it.hasNext()) {
                ColorStateListCacheKey next = it.next();
                if (next != null && theme.equals(next.f11277b)) {
                    it.remove();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList getCachedColorStateList(@androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, @androidx.annotation.ColorRes int r6) {
        /*
            java.lang.Object r0 = sColorStateCacheLock
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = sColorStateCaches     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0042
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0045 }
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0042
            android.content.res.Configuration r3 = r2.f11274b     // Catch:{ all -> 0x0045 }
            android.content.res.Resources r4 = r5.f11276a     // Catch:{ all -> 0x0045 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003f
            android.content.res.Resources$Theme r5 = r5.f11277b     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x0031
            int r3 = r2.f11275c     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003b
        L_0x0031:
            if (r5 == 0) goto L_0x003f
            int r3 = r2.f11275c     // Catch:{ all -> 0x0045 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0045 }
            if (r3 != r5) goto L_0x003f
        L_0x003b:
            android.content.res.ColorStateList r5 = r2.f11273a     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r5
        L_0x003f:
            r1.remove(r6)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r5 = 0
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.getCachedColorStateList(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i11, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api23Impl.a(resources, i11, theme);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i11);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(resources, i11, theme);
        if (inflateColorStateList == null) {
            return Api23Impl.b(resources, i11, theme);
        }
        addColorStateListToCache(colorStateListCacheKey, i11, inflateColorStateList, theme);
        return inflateColorStateList;
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i11, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.a(resources, i11, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i11, int i12, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.b(resources, i11, i12, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(resources, i11);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i11, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i11) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i11) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i11, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i11, @Nullable Resources.Theme theme) {
        if (isColorInt(resources, i11)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i11), theme);
        } catch (Exception e11) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e11);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i11) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i11, typedValue, true);
        int i12 = typedValue.type;
        if (i12 < 28 || i12 > 31) {
            return false;
        }
        return true;
    }

    private static Typeface loadFont(@NonNull Context context, int i11, @NonNull TypedValue typedValue, int i12, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z11, boolean z12) {
        Resources resources = context.getResources();
        int i13 = i11;
        resources.getValue(i11, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i11, i12, fontCallback, handler, z11, z12);
        if (loadFont != null || fontCallback != null || z12) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i11) + " could not be retrieved.");
    }

    public static void getFont(@NonNull Context context, @FontRes int i11, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
            return;
        }
        loadFont(context, i11, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface loadFont(@androidx.annotation.NonNull android.content.Context r17, android.content.res.Resources r18, @androidx.annotation.NonNull android.util.TypedValue r19, int r20, int r21, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r22, @androidx.annotation.Nullable android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00bb
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L_0x0025
            if (r11 == 0) goto L_0x0024
            r11.callbackFailAsync(r15, r12)
        L_0x0024:
            return r16
        L_0x0025:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.findFromCache(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0035
            if (r11 == 0) goto L_0x0034
            r11.callbackSuccessAsync(r2, r12)
        L_0x0034:
            return r2
        L_0x0035:
            if (r25 == 0) goto L_0x0038
            return r16
        L_0x0038:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 == 0) goto L_0x006f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.parse(r2, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 != 0) goto L_0x0059
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0058
            r11.callbackFailAsync(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0058:
            return r16
        L_0x0059:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            return r0
        L_0x006f:
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.createFromResourcesFontFile(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0086
            r11.callbackSuccessAsync(r0, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            goto L_0x0089
        L_0x0086:
            r11.callbackFailAsync(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto L_0x00b5
        L_0x00a0:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        L_0x00b5:
            if (r11 == 0) goto L_0x00ba
            r11.callbackFailAsync(r15, r12)
        L_0x00ba:
            return r16
        L_0x00bb:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.loadFont(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i11, @NonNull TypedValue typedValue, int i12, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i11, typedValue, i12, fontCallback, (Handler) null, true, false);
    }
}
