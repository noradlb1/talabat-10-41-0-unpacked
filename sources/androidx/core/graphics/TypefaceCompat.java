package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public class TypefaceCompat {
    private static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final TypefaceCompatBaseImpl sTypefaceCompatImpl;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class ResourcesCallbackAdapter extends FontsContractCompat.FontRequestCallback {
        @Nullable
        private ResourcesCompat.FontCallback mFontCallback;

        public ResourcesCallbackAdapter(@Nullable ResourcesCompat.FontCallback fontCallback) {
            this.mFontCallback = fontCallback;
        }

        public void onTypefaceRequestFailed(int i11) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.lambda$callbackFailAsync$1(i11);
            }
        }

        public void onTypefaceRetrieved(@NonNull Typeface typeface) {
            ResourcesCompat.FontCallback fontCallback = this.mFontCallback;
            if (fontCallback != null) {
                fontCallback.lambda$callbackSuccessAsync$0(typeface);
            }
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            sTypefaceCompatImpl = new TypefaceCompatApi29Impl();
        } else if (i11 >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi28Impl();
        } else if (i11 >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i11 < 24 || !TypefaceCompatApi24Impl.isUsable()) {
            sTypefaceCompatImpl = new TypefaceCompatApi21Impl();
        } else {
            sTypefaceCompatImpl = new TypefaceCompatApi24Impl();
        }
    }

    private TypefaceCompat() {
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void clearCache() {
        sTypefaceCache.evictAll();
    }

    @NonNull
    public static Typeface create(@NonNull Context context, @Nullable Typeface typeface, int i11) {
        if (context != null) {
            return Typeface.create(typeface, i11);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromFontInfo(@NonNull Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        return sTypefaceCompatImpl.createFromFontInfo(context, cancellationSignal, fontInfoArr, i11);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i11, @Nullable String str, int i12, int i13, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z11) {
        Typeface typeface;
        FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry2 = familyResourceEntry;
        ResourcesCompat.FontCallback fontCallback2 = fontCallback;
        Handler handler2 = handler;
        if (familyResourceEntry2 instanceof FontResourcesParserCompat.ProviderResourceEntry) {
            FontResourcesParserCompat.ProviderResourceEntry providerResourceEntry = (FontResourcesParserCompat.ProviderResourceEntry) familyResourceEntry2;
            Typeface systemFontFamily = getSystemFontFamily(providerResourceEntry.getSystemFontFamilyName());
            if (systemFontFamily != null) {
                if (fontCallback2 != null) {
                    fontCallback2.callbackSuccessAsync(systemFontFamily, handler2);
                }
                return systemFontFamily;
            }
            typeface = FontsContractCompat.requestFont(context, providerResourceEntry.getRequest(), i13, !z11 ? fontCallback2 == null : providerResourceEntry.getFetchStrategy() == 0, z11 ? providerResourceEntry.getTimeout() : -1, ResourcesCompat.FontCallback.getHandler(handler), new ResourcesCallbackAdapter(fontCallback2));
            Resources resources2 = resources;
            int i14 = i13;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat.FontFamilyFilesResourceEntry) familyResourceEntry2, resources, i13);
            if (fontCallback2 != null) {
                if (typeface != null) {
                    fontCallback2.callbackSuccessAsync(typeface, handler2);
                } else {
                    fontCallback2.callbackFailAsync(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            sTypefaceCache.put(createResourceUid(resources, i11, str, i12, i13), typeface);
        }
        return typeface;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i11, String str, int i12, int i13) {
        Typeface createFromResourcesFontFile = sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i11, str, i13);
        if (createFromResourcesFontFile != null) {
            sTypefaceCache.put(createResourceUid(resources, i11, str, i12, i13), createFromResourcesFontFile);
        }
        return createFromResourcesFontFile;
    }

    private static String createResourceUid(Resources resources, int i11, String str, int i12, int i13) {
        return resources.getResourcePackageName(i11) + SignatureVisitor.SUPER + str + SignatureVisitor.SUPER + i12 + SignatureVisitor.SUPER + i11 + SignatureVisitor.SUPER + i13;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Typeface findFromCache(@NonNull Resources resources, int i11, @Nullable String str, int i12, int i13) {
        return sTypefaceCache.get(createResourceUid(resources, i11, str, i12, i13));
    }

    @Nullable
    private static Typeface getBestFontFromFamily(Context context, Typeface typeface, int i11) {
        TypefaceCompatBaseImpl typefaceCompatBaseImpl = sTypefaceCompatImpl;
        FontResourcesParserCompat.FontFamilyFilesResourceEntry e11 = typefaceCompatBaseImpl.e(typeface);
        if (e11 == null) {
            return null;
        }
        return typefaceCompatBaseImpl.createFromFontFamilyFilesResourceEntry(context, e11, context.getResources(), i11);
    }

    private static Typeface getSystemFontFamily(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface findFromCache(@NonNull Resources resources, int i11, int i12) {
        return findFromCache(resources, i11, (String) null, 0, i12);
    }

    @NonNull
    public static Typeface create(@NonNull Context context, @Nullable Typeface typeface, @IntRange(from = 1, to = 1000) int i11, boolean z11) {
        if (context != null) {
            Preconditions.checkArgumentInRange(i11, 1, 1000, "weight");
            if (typeface == null) {
                typeface = Typeface.DEFAULT;
            }
            return sTypefaceCompatImpl.c(context, typeface, i11, z11);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFontFile(@NonNull Context context, @NonNull Resources resources, int i11, String str, int i12) {
        return createFromResourcesFontFile(context, resources, i11, str, 0, i12);
    }

    @Deprecated
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface createFromResourcesFamilyXml(@NonNull Context context, @NonNull FontResourcesParserCompat.FamilyResourceEntry familyResourceEntry, @NonNull Resources resources, int i11, int i12, @Nullable ResourcesCompat.FontCallback fontCallback, @Nullable Handler handler, boolean z11) {
        return createFromResourcesFamilyXml(context, familyResourceEntry, resources, i11, (String) null, 0, i12, fontCallback, handler, z11);
    }
}
