package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TypefaceCompatApi21Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle = null;
    private static Method sCreateFromFamiliesWithDefault = null;
    private static Class<?> sFontFamily = null;
    private static Constructor<?> sFontFamilyCtor = null;
    private static boolean sHasInitBeenCalled = false;

    private static boolean addFontWeightStyle(Object obj, String str, int i11, boolean z11) {
        init();
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, new Object[]{str, Integer.valueOf(i11), Boolean.valueOf(z11)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        init();
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private File getFile(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void init() {
        Method method;
        Constructor<?> constructor;
        Class<?> cls;
        Method method2;
        if (!sHasInitBeenCalled) {
            sHasInitBeenCalled = true;
            try {
                cls = Class.forName(FONT_FAMILY_CLASS);
                constructor = cls.getConstructor(new Class[0]);
                method = cls.getMethod(ADD_FONT_WEIGHT_STYLE_METHOD, new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{Array.newInstance(cls, 1).getClass()});
            } catch (ClassNotFoundException | NoSuchMethodException e11) {
                Log.e(TAG, e11.getClass().getName(), e11);
                cls = null;
                method2 = null;
                constructor = null;
                method = null;
            }
            sFontFamilyCtor = constructor;
            sFontFamily = cls;
            sAddFontWeightStyle = method;
            sCreateFromFamiliesWithDefault = method2;
        }
    }

    private static Object newFamily() {
        init();
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    @NonNull
    public Typeface c(@NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
        Typeface typeface2;
        try {
            typeface2 = WeightTypefaceApi21.a(typeface, i11, z11);
        } catch (RuntimeException unused) {
            typeface2 = null;
        }
        if (typeface2 == null) {
            return super.c(context, typeface, i11, z11);
        }
        return typeface2;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i11) {
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i12 = 0;
        while (i12 < length) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i12];
            File tempFile = TypefaceCompatUtil.getTempFile(context);
            if (tempFile == null) {
                return null;
            }
            try {
                if (!TypefaceCompatUtil.copyToFile(tempFile, resources, fontFileResourceEntry.getResourceId())) {
                    tempFile.delete();
                    return null;
                } else if (!addFontWeightStyle(newFamily, tempFile.getPath(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                    return null;
                } else {
                    tempFile.delete();
                    i12++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                tempFile.delete();
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        FileInputStream fileInputStream;
        if (fontInfoArr.length < 1) {
            return null;
        }
        FontsContractCompat.FontInfo d11 = d(fontInfoArr, i11);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(d11.getUri(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File file = getFile(openFileDescriptor);
                if (file != null) {
                    if (file.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface b11 = super.b(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return b11;
            } catch (Throwable th2) {
                openFileDescriptor.close();
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
        throw th;
    }
}
