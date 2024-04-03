package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(29)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private Font findBaseFont(@NonNull FontFamily fontFamily, int i11) {
        int i12;
        int i13;
        if ((i11 & 1) != 0) {
            i12 = 700;
        } else {
            i12 = 400;
        }
        if ((i11 & 2) != 0) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        FontStyle fontStyle = new FontStyle(i12, i13);
        Font a11 = fontFamily.getFont(0);
        int matchScore = getMatchScore(fontStyle, a11.getStyle());
        for (int i14 = 1; i14 < fontFamily.getSize(); i14++) {
            Font a12 = fontFamily.getFont(i14);
            int matchScore2 = getMatchScore(fontStyle, a12.getStyle());
            if (matchScore2 < matchScore) {
                a11 = a12;
                matchScore = matchScore2;
            }
        }
        return a11;
    }

    private static int getMatchScore(@NonNull FontStyle fontStyle, @NonNull FontStyle fontStyle2) {
        int i11;
        int abs = Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100;
        if (fontStyle.getSlant() == fontStyle2.getSlant()) {
            i11 = 0;
        } else {
            i11 = 2;
        }
        return abs + i11;
    }

    public Typeface b(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @NonNull
    public Typeface c(@NonNull Context context, @NonNull Typeface typeface, int i11, boolean z11) {
        return Typeface.create(typeface, i11, z11);
    }

    @Nullable
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i11) {
        int i12;
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                try {
                    Font.Builder a11 = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                    if (fontFileResourceEntry.isItalic()) {
                        i12 = 1;
                    } else {
                        i12 = 0;
                    }
                    Font a12 = a11.setSlant(i12).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(a12);
                    } else {
                        FontFamily.Builder unused = builder.addFont(a12);
                    }
                } catch (IOException unused2) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily a13 = builder.build();
            return new Typeface.CustomFallbackBuilder(a13).setStyle(findBaseFont(a13, i11).getStyle()).build();
        } catch (Exception unused3) {
            return null;
        }
    }

    @Nullable
    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        ParcelFileDescriptor openFileDescriptor;
        int i12;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(fontInfo.getUri(), "r", cancellationSignal);
                    if (openFileDescriptor != null) {
                        Font.Builder a11 = new Font.Builder(openFileDescriptor).setWeight(fontInfo.getWeight());
                        if (fontInfo.isItalic()) {
                            i12 = 1;
                        } else {
                            i12 = 0;
                        }
                        Font a12 = a11.setSlant(i12).setTtcIndex(fontInfo.getTtcIndex()).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(a12);
                        } else {
                            FontFamily.Builder unused = builder.addFont(a12);
                        }
                    } else if (openFileDescriptor == null) {
                    }
                    openFileDescriptor.close();
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily a13 = builder.build();
            return new Typeface.CustomFallbackBuilder(a13).setStyle(findBaseFont(a13, i11).getStyle()).build();
            throw th;
        } catch (Exception unused3) {
            return null;
        }
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i11, String str, int i12) {
        try {
            Font a11 = new Font.Builder(resources, i11).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(a11).build()).setStyle(a11.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    public FontsContractCompat.FontInfo d(FontsContractCompat.FontInfo[] fontInfoArr, int i11) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
