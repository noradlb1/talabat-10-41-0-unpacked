package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\f"}, d2 = {"BitmapPainter", "Landroidx/compose/ui/graphics/painter/BitmapPainter;", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "BitmapPainter-QZhYCtY", "(Landroidx/compose/ui/graphics/ImageBitmap;JJI)Landroidx/compose/ui/graphics/painter/BitmapPainter;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BitmapPainterKt {
    @NotNull
    /* renamed from: BitmapPainter-QZhYCtY  reason: not valid java name */
    public static final BitmapPainter m3509BitmapPainterQZhYCtY(@NotNull ImageBitmap imageBitmap, long j11, long j12, int i11) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, j11, j12, (DefaultConstructorMarker) null);
        bitmapPainter.m3508setFilterQualityvDHp3xo$ui_graphics_release(i11);
        return bitmapPainter;
    }

    /* renamed from: BitmapPainter-QZhYCtY$default  reason: not valid java name */
    public static /* synthetic */ BitmapPainter m3510BitmapPainterQZhYCtY$default(ImageBitmap imageBitmap, long j11, long j12, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            j11 = IntOffset.Companion.m5606getZeronOccac();
        }
        long j13 = j11;
        if ((i12 & 4) != 0) {
            j12 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        }
        long j14 = j12;
        if ((i12 & 8) != 0) {
            i11 = FilterQuality.Companion.m3005getLowfv9h1I();
        }
        return m3509BitmapPainterQZhYCtY(imageBitmap, j13, j14, i11);
    }
}
