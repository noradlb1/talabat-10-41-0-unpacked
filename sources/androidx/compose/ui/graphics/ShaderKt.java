package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u001a3\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aQ\u0010\n\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a?\u0010\u001b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0017\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"ImageShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "tileModeX", "Landroidx/compose/ui/graphics/TileMode;", "tileModeY", "ImageShader-F49vj9s", "(Landroidx/compose/ui/graphics/ImageBitmap;II)Landroid/graphics/Shader;", "LinearGradientShader", "from", "Landroidx/compose/ui/geometry/Offset;", "to", "colors", "", "Landroidx/compose/ui/graphics/Color;", "colorStops", "", "tileMode", "LinearGradientShader-VjE6UOU", "(JJLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "RadialGradientShader", "center", "radius", "RadialGradientShader-8uybcMk", "(JFLjava/util/List;Ljava/util/List;I)Landroid/graphics/Shader;", "SweepGradientShader", "SweepGradientShader-9KIMszo", "(JLjava/util/List;Ljava/util/List;)Landroid/graphics/Shader;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShaderKt {
    @NotNull
    /* renamed from: ImageShader-F49vj9s  reason: not valid java name */
    public static final Shader m3218ImageShaderF49vj9s(@NotNull ImageBitmap imageBitmap, int i11, int i12) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        return AndroidShader_androidKt.m2815ActualImageShaderF49vj9s(imageBitmap, i11, i12);
    }

    /* renamed from: ImageShader-F49vj9s$default  reason: not valid java name */
    public static /* synthetic */ Shader m3219ImageShaderF49vj9s$default(ImageBitmap imageBitmap, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = TileMode.Companion.m3274getClamp3opZhB0();
        }
        if ((i13 & 4) != 0) {
            i12 = TileMode.Companion.m3274getClamp3opZhB0();
        }
        return m3218ImageShaderF49vj9s(imageBitmap, i11, i12);
    }

    @NotNull
    /* renamed from: LinearGradientShader-VjE6UOU  reason: not valid java name */
    public static final Shader m3220LinearGradientShaderVjE6UOU(long j11, long j12, @NotNull List<Color> list, @Nullable List<Float> list2, int i11) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2816ActualLinearGradientShaderVjE6UOU(j11, j12, list, list2, i11);
    }

    /* renamed from: LinearGradientShader-VjE6UOU$default  reason: not valid java name */
    public static /* synthetic */ Shader m3221LinearGradientShaderVjE6UOU$default(long j11, long j12, List list, List list2, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i12 & 16) != 0) {
            i11 = TileMode.Companion.m3274getClamp3opZhB0();
        }
        return m3220LinearGradientShaderVjE6UOU(j11, j12, list, list3, i11);
    }

    @NotNull
    /* renamed from: RadialGradientShader-8uybcMk  reason: not valid java name */
    public static final Shader m3222RadialGradientShader8uybcMk(long j11, float f11, @NotNull List<Color> list, @Nullable List<Float> list2, int i11) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2817ActualRadialGradientShader8uybcMk(j11, f11, list, list2, i11);
    }

    /* renamed from: RadialGradientShader-8uybcMk$default  reason: not valid java name */
    public static /* synthetic */ Shader m3223RadialGradientShader8uybcMk$default(long j11, float f11, List list, List list2, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            list2 = null;
        }
        List list3 = list2;
        if ((i12 & 16) != 0) {
            i11 = TileMode.Companion.m3274getClamp3opZhB0();
        }
        return m3222RadialGradientShader8uybcMk(j11, f11, list, list3, i11);
    }

    @NotNull
    /* renamed from: SweepGradientShader-9KIMszo  reason: not valid java name */
    public static final Shader m3224SweepGradientShader9KIMszo(long j11, @NotNull List<Color> list, @Nullable List<Float> list2) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return AndroidShader_androidKt.m2818ActualSweepGradientShader9KIMszo(j11, list, list2);
    }

    /* renamed from: SweepGradientShader-9KIMszo$default  reason: not valid java name */
    public static /* synthetic */ Shader m3225SweepGradientShader9KIMszo$default(long j11, List list, List list2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            list2 = null;
        }
        return m3224SweepGradientShader9KIMszo(j11, list, list2);
    }
}
