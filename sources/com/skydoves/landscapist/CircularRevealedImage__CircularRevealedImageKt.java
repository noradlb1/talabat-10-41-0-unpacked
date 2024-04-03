package com.skydoves.landscapist;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ai\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"DefaultCircularRevealedDuration", "", "CircularRevealedImage", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "modifier", "Landroidx/compose/ui/Modifier;", "bitmapPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "contentDescription", "", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "circularReveal", "Lcom/skydoves/landscapist/CircularReveal;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;FLandroidx/compose/ui/graphics/ColorFilter;Lcom/skydoves/landscapist/CircularReveal;Landroidx/compose/runtime/Composer;II)V", "landscapist_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/CircularRevealedImage")
final /* synthetic */ class CircularRevealedImage__CircularRevealedImageKt {
    @Composable
    public static final void CircularRevealedImage(@NotNull ImageBitmap imageBitmap, @Nullable Modifier modifier, @Nullable Painter painter, @Nullable Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, float f11, @Nullable ColorFilter colorFilter, @Nullable CircularReveal circularReveal, @Nullable Composer composer, int i11, int i12) {
        Modifier.Companion companion;
        BitmapPainter bitmapPainter;
        int i13;
        Alignment alignment2;
        ContentScale contentScale2;
        int i14;
        float f12;
        ColorFilter colorFilter2;
        CircularReveal circularReveal2;
        Painter painter2;
        int i15 = i12;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        Composer startRestartGroup = composer.startRestartGroup(-1751172567);
        if ((i15 & 2) != 0) {
            companion = Modifier.Companion;
        } else {
            companion = modifier;
        }
        if ((i15 & 4) != 0) {
            i13 = i11 & -897;
            bitmapPainter = new BitmapPainter(imageBitmap, 0, 0, 6, (DefaultConstructorMarker) null);
        } else {
            bitmapPainter = painter;
            i13 = i11;
        }
        if ((i15 & 8) != 0) {
            i13 &= -7169;
            alignment2 = Alignment.Companion.getCenter();
        } else {
            alignment2 = alignment;
        }
        if ((i15 & 16) != 0) {
            i14 = i13 & -57345;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
            i14 = i13;
        }
        if ((i15 & 64) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f11;
        }
        if ((i15 & 128) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((i15 & 256) != 0) {
            circularReveal2 = null;
        } else {
            circularReveal2 = circularReveal;
        }
        if (circularReveal2 != null) {
            startRestartGroup.startReplaceableGroup(-1751172146);
            painter2 = CircularRevealedAnimationKt.circularReveal(bitmapPainter, imageBitmap, circularReveal2.getDuration(), circularReveal2.getOnFinishListener(), startRestartGroup, 72, 0);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1751172000);
            startRestartGroup.endReplaceableGroup();
            painter2 = bitmapPainter;
        }
        int i16 = i14 >> 3;
        ImageKt.Image(painter2, str, companion, alignment2, contentScale2, f12, colorFilter2, startRestartGroup, ((i14 >> 12) & 112) | 8 | ((i14 << 3) & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i16) | (i16 & 3670016), 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CircularRevealedImage__CircularRevealedImageKt$CircularRevealedImage$1(imageBitmap, companion, bitmapPainter, alignment2, contentScale2, str, f12, colorFilter2, circularReveal2, i11, i12));
        }
    }
}
