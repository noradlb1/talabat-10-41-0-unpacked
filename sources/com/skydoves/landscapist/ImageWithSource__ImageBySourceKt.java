package com.skydoves.landscapist;

import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"ImageBySource", "", "source", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "contentDescription", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "alpha", "", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/String;Landroidx/compose/ui/graphics/ColorFilter;FLandroidx/compose/runtime/Composer;II)V", "landscapist_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/ImageWithSource")
final /* synthetic */ class ImageWithSource__ImageBySourceKt {
    @Composable
    public static final void ImageBySource(@NotNull Object obj, @NotNull Modifier modifier, @NotNull Alignment alignment, @Nullable ContentScale contentScale, @Nullable String str, @Nullable ColorFilter colorFilter, float f11, @Nullable Composer composer, int i11, int i12) {
        ContentScale contentScale2;
        int i13;
        String str2;
        ColorFilter colorFilter2;
        float f12;
        Object obj2 = obj;
        Intrinsics.checkNotNullParameter(obj2, "source");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Composer startRestartGroup = composer.startRestartGroup(-1847529278);
        if ((i12 & 8) != 0) {
            i13 = i11 & -7169;
            contentScale2 = ContentScale.Companion.getCrop();
        } else {
            contentScale2 = contentScale;
            i13 = i11;
        }
        if ((i12 & 16) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i12 & 32) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((i12 & 64) != 0) {
            f12 = 1.0f;
        } else {
            f12 = f11;
        }
        if (obj2 instanceof ImageBitmap) {
            startRestartGroup.startReplaceableGroup(-1847528999);
            int i14 = i13 << 3;
            ImageKt.Image((ImageBitmap) obj2, str2, modifier, alignment, contentScale2, f12, colorFilter2, startRestartGroup, ((i13 >> 3) & Opcodes.ASM7) | (57344 & i14) | ((i13 >> 9) & 112) | 8 | (i14 & 896) | (i14 & 7168) | (3670016 & i14), 0);
            startRestartGroup.endReplaceableGroup();
        } else if (obj2 instanceof ImageVector) {
            startRestartGroup.startReplaceableGroup(-1847528719);
            int i15 = i13 << 3;
            ImageKt.Image((ImageVector) obj2, str2, modifier, alignment, contentScale2, f12, colorFilter2, startRestartGroup, ((i13 >> 3) & Opcodes.ASM7) | (57344 & i15) | ((i13 >> 9) & 112) | (i15 & 896) | (i15 & 7168) | (3670016 & i15), 0);
            startRestartGroup.endReplaceableGroup();
        } else if (obj2 instanceof Painter) {
            startRestartGroup.startReplaceableGroup(-1847528438);
            int i16 = i13 << 3;
            ImageKt.Image((Painter) obj2, str2, modifier, alignment, contentScale2, f12, colorFilter2, startRestartGroup, ((i13 >> 3) & Opcodes.ASM7) | (57344 & i16) | ((i13 >> 9) & 112) | 8 | (i16 & 896) | (i16 & 7168) | (3670016 & i16), 0);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-1847528167);
            startRestartGroup.endReplaceableGroup();
            throw new IllegalArgumentException("Wrong source was used: " + obj2 + ", The source should be one of ImageBitmap, ImageVector, or Painter.");
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageWithSource__ImageBySourceKt$ImageBySource$1(obj, modifier, alignment, contentScale2, str2, colorFilter2, f12, i11, i12));
        }
    }
}
