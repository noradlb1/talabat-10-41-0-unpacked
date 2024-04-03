package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    public interface StyleExtractor<T> {
        int getWeight(T t11);

        boolean isItalic(T t11);
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey != 0) {
            this.mFontFamilies.put(Long.valueOf(uniqueKey), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i11) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i11, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] tArr, int i11, StyleExtractor<T> styleExtractor) {
        return findBestFont(tArr, (i11 & 1) == 0 ? 400 : 700, (i11 & 2) != 0, styleExtractor);
    }

    private static long getUniqueKey(@Nullable Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e11) {
            Log.e(TAG, "Could not retrieve font from family.", e11);
            return 0;
        } catch (IllegalAccessException e12) {
            Log.e(TAG, "Could not retrieve font from family.", e12);
            return 0;
        }
    }

    @Nullable
    public Typeface a(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i11, boolean z11) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i11, z11);
        if (findBestEntry == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), 0, 0);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    public Typeface b(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    @NonNull
    public Typeface c(@NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi14.a(this, context, typeface, i11, z11);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        return typeface2 == null ? typeface : typeface2;
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i11) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i11);
        if (findBestEntry == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), 0, i11);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (fontInfoArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(d(fontInfoArr, i11).getUri());
            try {
                Typeface b11 = b(context, inputStream);
                TypefaceCompatUtil.closeQuietly(inputStream);
                return b11;
            } catch (IOException unused) {
                TypefaceCompatUtil.closeQuietly(inputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                inputStream2 = inputStream;
                TypefaceCompatUtil.closeQuietly(inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            TypefaceCompatUtil.closeQuietly(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            TypefaceCompatUtil.closeQuietly(inputStream2);
            throw th;
        }
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i11, String str, int i12) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (!TypefaceCompatUtil.copyToFile(tempFile, resources, i11)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(tempFile.getPath());
            tempFile.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public FontsContractCompat.FontInfo d(FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i11, new StyleExtractor<FontsContractCompat.FontInfo>() {
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    @Nullable
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry e(Typeface typeface) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey == 0) {
            return null;
        }
        return this.mFontFamilies.get(Long.valueOf(uniqueKey));
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i11, boolean z11) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i11, z11, new StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry>() {
            public int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.getWeight();
            }

            public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
                return fontFileResourceEntry.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] tArr, int i11, boolean z11, StyleExtractor<T> styleExtractor) {
        T t11 = null;
        int i12 = Integer.MAX_VALUE;
        for (T t12 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t12) - i11) * 2) + (styleExtractor.isItalic(t12) == z11 ? 0 : 1);
            if (t11 == null || i12 > abs) {
                t11 = t12;
                i12 = abs;
            }
        }
        return t11;
    }
}
