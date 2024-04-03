package androidx.compose.ui.graphics;

import android.graphics.BitmapShader;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Build;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aO\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aO\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u00020\u001f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0001ø\u0001\u0001\u001a!\u0010 \u001a\u00020!2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a3\u0010#\u001a\u0004\u0018\u00010$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\"\u001a\u00020\u001fH\u0001ø\u0001\u0001\u001a)\u0010&\u001a\u00020'2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fH\u0002ø\u0001\u0001*\n\u0010(\"\u00020\u00012\u00020\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006)"}, d2 = {"ActualImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ActualImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "ActualLinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "ActualLinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualRadialGradientShader", "center", "radius", "ActualRadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "ActualSweepGradientShader", "ActualSweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "countTransparentColors", "", "makeTransparentColors", "", "numTransparentColors", "makeTransparentStops", "", "stops", "validateColorStops", "", "Shader", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidShader_androidKt {
    @NotNull
    /* renamed from: ActualImageShader-F49vj9s  reason: not valid java name */
    public static final Shader m2815ActualImageShaderF49vj9s(@NotNull ImageBitmap imageBitmap, int i11, int i12) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return new BitmapShader(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i11), AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i12));
    }

    @NotNull
    /* renamed from: ActualLinearGradientShader-VjE6UOU  reason: not valid java name */
    public static final Shader m2816ActualLinearGradientShaderVjE6UOU(long j11, long j12, @NotNull List<Color> list, @Nullable List<Float> list2, int i11) {
        List<Color> list3 = list;
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new LinearGradient(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i11));
    }

    @NotNull
    /* renamed from: ActualRadialGradientShader-8uybcMk  reason: not valid java name */
    public static final Shader m2817ActualRadialGradientShader8uybcMk(long j11, float f11, @NotNull List<Color> list, @Nullable List<Float> list2, int i11) {
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new RadialGradient(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), f11, makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors), AndroidTileMode_androidKt.m2820toAndroidTileMode0vamqd0(i11));
    }

    @NotNull
    /* renamed from: ActualSweepGradientShader-9KIMszo  reason: not valid java name */
    public static final Shader m2818ActualSweepGradientShader9KIMszo(long j11, @NotNull List<Color> list, @Nullable List<Float> list2) {
        Intrinsics.checkNotNullParameter(list, "colors");
        validateColorStops(list, list2);
        int countTransparentColors = countTransparentColors(list);
        return new SweepGradient(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), makeTransparentColors(list, countTransparentColors), makeTransparentStops(list2, list, countTransparentColors));
    }

    @VisibleForTesting
    public static final int countTransparentColors(@NotNull List<Color> list) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            return 0;
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        int i11 = 0;
        for (int i12 = 1; i12 < lastIndex; i12++) {
            if (Color.m2921getAlphaimpl(list.get(i12).m2929unboximpl()) == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11++;
            }
        }
        return i11;
    }

    @NotNull
    @VisibleForTesting
    public static final int[] makeTransparentColors(@NotNull List<Color> list, int i11) {
        boolean z11;
        int i12;
        List<Color> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "colors");
        if (Build.VERSION.SDK_INT >= 26) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i13 = 0; i13 < size; i13++) {
                iArr[i13] = ColorKt.m2974toArgb8_81llA(list2.get(i13).m2929unboximpl());
            }
            return iArr;
        }
        int[] iArr2 = new int[(list.size() + i11)];
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        int size2 = list.size();
        int i14 = 0;
        for (int i15 = 0; i15 < size2; i15++) {
            long r72 = list2.get(i15).m2929unboximpl();
            if (Color.m2921getAlphaimpl(r72) == 0.0f) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i15 == 0) {
                    i12 = i14 + 1;
                    iArr2[i14] = ColorKt.m2974toArgb8_81llA(Color.m2918copywmQWz5c$default(list2.get(1).m2929unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                } else if (i15 == lastIndex) {
                    i12 = i14 + 1;
                    iArr2[i14] = ColorKt.m2974toArgb8_81llA(Color.m2918copywmQWz5c$default(list2.get(i15 - 1).m2929unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                } else {
                    int i16 = i14 + 1;
                    iArr2[i14] = ColorKt.m2974toArgb8_81llA(Color.m2918copywmQWz5c$default(list2.get(i15 - 1).m2929unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                    i14 = i16 + 1;
                    iArr2[i16] = ColorKt.m2974toArgb8_81llA(Color.m2918copywmQWz5c$default(list2.get(i15 + 1).m2929unboximpl(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null));
                }
                i14 = i12;
            } else {
                iArr2[i14] = ColorKt.m2974toArgb8_81llA(r72);
                i14++;
            }
        }
        return iArr2;
    }

    @VisibleForTesting
    @Nullable
    public static final float[] makeTransparentStops(@Nullable List<Float> list, @NotNull List<Color> list2, int i11) {
        float f11;
        float f12;
        float f13;
        boolean z11;
        Intrinsics.checkNotNullParameter(list2, "colors");
        if (i11 != 0) {
            float[] fArr = new float[(list2.size() + i11)];
            if (list != null) {
                f11 = list.get(0).floatValue();
            } else {
                f11 = 0.0f;
            }
            fArr[0] = f11;
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list2);
            int i12 = 1;
            for (int i13 = 1; i13 < lastIndex; i13++) {
                long r62 = list2.get(i13).m2929unboximpl();
                if (list != null) {
                    f13 = list.get(i13).floatValue();
                } else {
                    f13 = ((float) i13) / ((float) CollectionsKt__CollectionsKt.getLastIndex(list2));
                }
                int i14 = i12 + 1;
                fArr[i12] = f13;
                if (Color.m2921getAlphaimpl(r62) == 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i12 = i14 + 1;
                    fArr[i14] = f13;
                } else {
                    i12 = i14;
                }
            }
            if (list != null) {
                f12 = list.get(CollectionsKt__CollectionsKt.getLastIndex(list2)).floatValue();
            } else {
                f12 = 1.0f;
            }
            fArr[i12] = f12;
            return fArr;
        } else if (list != null) {
            return CollectionsKt___CollectionsKt.toFloatArray(list);
        } else {
            return null;
        }
    }

    private static final void validateColorStops(List<Color> list, List<Float> list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
