package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    public static class AsldcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e11);
                return null;
            }
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                return null;
            }
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i11) {
            super(i11);
        }

        private static int generateCacheKey(int i11, PorterDuff.Mode mode) {
            return ((i11 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter a(int i11, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i11, mode)));
        }

        public PorterDuffColorFilter b(int i11, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i11, mode)), porterDuffColorFilter);
        }
    }

    public static class DrawableDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Compatibility.Api21Impl.inflate(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e11) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e11);
                }
            }
            return null;
        }
    }

    public interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i11);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context context, @DrawableRes int i11);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int i11);

        boolean tintDrawable(@NonNull Context context, @DrawableRes int i11, @NonNull Drawable drawable);

        boolean tintDrawableUsingColorFilter(@NonNull Context context, @DrawableRes int i11, @NonNull Drawable drawable);
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        public Drawable createFromXmlInner(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e11);
                return null;
            }
        }
    }

    private void addDelegate(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap<>();
        }
        this.mDelegates.put(str, inflateDelegate);
    }

    private synchronized boolean addDrawableToCache(@NonNull Context context, long j11, @NonNull Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray();
            this.mDrawableCaches.put(context, longSparseArray);
        }
        longSparseArray.put(j11, new WeakReference(constantState));
        return true;
    }

    private void addTintListToCache(@NonNull Context context, @DrawableRes int i11, @NonNull ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i11, colorStateList);
    }

    private void checkVectorDrawableSetup(@NonNull Context context) {
        if (!this.mHasCheckedVectorDrawableSetup) {
            this.mHasCheckedVectorDrawableSetup = true;
            Drawable drawable = getDrawable(context, R.drawable.abc_vector_test);
            if (drawable == null || !isVectorDrawable(drawable)) {
                this.mHasCheckedVectorDrawableSetup = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context context, @DrawableRes int i11) {
        Drawable drawable;
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i11, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            drawable = null;
        } else {
            drawable = resourceManagerHooks.createDrawableFor(this, context, i11);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, createCacheKey, drawable);
        }
        return drawable;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static void e(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        boolean z11;
        int[] state = drawable.getState();
        if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
            if (drawable.mutate() == drawable) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z12 = tintInfo.mHasTintList;
        if (z12 || tintInfo.mHasTintMode) {
            if (z12) {
                colorStateList = tintInfo.mTintList;
            } else {
                colorStateList = null;
            }
            if (tintInfo.mHasTintMode) {
                mode = tintInfo.mTintMode;
            } else {
                mode = DEFAULT_MODE;
            }
            drawable.setColorFilter(createTintFilter(colorStateList, mode, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (INSTANCE == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                INSTANCE = resourceManagerInternal2;
                installDefaultInflateDelegates(resourceManagerInternal2);
            }
            resourceManagerInternal = INSTANCE;
        }
        return resourceManagerInternal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable getCachedDrawable(@androidx.annotation.NonNull android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.mDrawableCaches     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.get(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.remove(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.getCachedDrawable(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter a11;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            a11 = colorFilterLruCache.a(i11, mode);
            if (a11 == null) {
                a11 = new PorterDuffColorFilter(i11, mode);
                colorFilterLruCache.b(i11, mode, a11);
            }
        }
        return a11;
    }

    private ColorStateList getTintListFromCache(@NonNull Context context, @DrawableRes int i11) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.get(i11);
    }

    private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new VdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.addDelegate("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.addDelegate("drawable", new DrawableDelegate());
        }
    }

    private static boolean isVectorDrawable(@NonNull Drawable drawable) {
        if ((drawable instanceof VectorDrawableCompat) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable loadDrawableFromDelegates(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.DrawableRes int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r0 = r10.mDelegates
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.mKnownDrawableIdTags
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.get(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r3 = r10.mDelegates
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.mKnownDrawableIdTags = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.mTypedValue
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.mTypedValue = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.mTypedValue
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = createCacheKey(r0)
            android.graphics.drawable.Drawable r6 = r10.getCachedDrawable(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.mKnownDrawableIdTags     // Catch:{ Exception -> 0x00a2 }
            r8.append(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r8 = r10.mDelegates     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate r3 = (androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.createFromXmlInner(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.addDrawableToCache(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.mKnownDrawableIdTags
            r11.append(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.loadDrawableFromDelegates(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable tintDrawable(@NonNull Context context, @DrawableRes int i11, boolean z11, @NonNull Drawable drawable) {
        ColorStateList b11 = b(context, i11);
        if (b11 != null) {
            if (DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable wrap = DrawableCompat.wrap(drawable);
            DrawableCompat.setTintList(wrap, b11);
            PorterDuff.Mode c11 = c(i11);
            if (c11 == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, c11);
            return wrap;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i11, drawable)) && !f(context, i11, drawable) && z11) {
            return null;
        }
        return drawable;
    }

    public synchronized Drawable a(@NonNull Context context, @DrawableRes int i11, boolean z11) {
        Drawable loadDrawableFromDelegates;
        checkVectorDrawableSetup(context);
        loadDrawableFromDelegates = loadDrawableFromDelegates(context, i11);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = createDrawableIfNeeded(context, i11);
        }
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = ContextCompat.getDrawable(context, i11);
        }
        if (loadDrawableFromDelegates != null) {
            loadDrawableFromDelegates = tintDrawable(context, i11, z11, loadDrawableFromDelegates);
        }
        if (loadDrawableFromDelegates != null) {
            DrawableUtils.a(loadDrawableFromDelegates);
        }
        return loadDrawableFromDelegates;
    }

    public synchronized ColorStateList b(@NonNull Context context, @DrawableRes int i11) {
        ColorStateList tintListFromCache;
        tintListFromCache = getTintListFromCache(context, i11);
        if (tintListFromCache == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            if (resourceManagerHooks == null) {
                tintListFromCache = null;
            } else {
                tintListFromCache = resourceManagerHooks.getTintListForDrawableRes(context, i11);
            }
            if (tintListFromCache != null) {
                addTintListToCache(context, i11, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    public PorterDuff.Mode c(int i11) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i11);
    }

    public synchronized Drawable d(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i11) {
        Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i11);
        if (loadDrawableFromDelegates == null) {
            loadDrawableFromDelegates = vectorEnabledTintResources.a(i11);
        }
        if (loadDrawableFromDelegates == null) {
            return null;
        }
        return tintDrawable(context, i11, false, loadDrawableFromDelegates);
    }

    public boolean f(@NonNull Context context, @DrawableRes int i11, @NonNull Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i11, drawable);
    }

    public synchronized Drawable getDrawable(@NonNull Context context, @DrawableRes int i11) {
        return a(context, i11, false);
    }

    public synchronized void onConfigurationChanged(@NonNull Context context) {
        LongSparseArray longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        this.mHooks = resourceManagerHooks;
    }
}
