package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IconKt {
    @NotNull
    private static final Modifier DefaultIconSizeModifier = SizeKt.m558size3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 24));

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1279Iconww6aTOc(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, long j11, @Nullable Composer composer, int i11, int i12) {
        ImageVector imageVector2 = imageVector;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
        composer2.startReplaceableGroup(-800853103);
        m1278Iconww6aTOc((Painter) VectorPainterKt.rememberVectorPainter(imageVector2, composer2, i13 & 14), str, (i12 & 4) != 0 ? Modifier.Companion : modifier, (i12 & 8) != 0 ? Color.m2918copywmQWz5c$default(((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11, composer, VectorPainter.$stable | (i13 & 112) | (i13 & 896) | (i13 & 7168), 0);
        composer.endReplaceableGroup();
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.m2741equalsimpl0(painter.m3516getIntrinsicSizeNHjbRc(), Size.Companion.m2753getUnspecifiedNHjbRc()) || m1280isInfiniteuvyYCjk(painter.m3516getIntrinsicSizeNHjbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m1280isInfiniteuvyYCjk(long j11) {
        return Float.isInfinite(Size.m2745getWidthimpl(j11)) && Float.isInfinite(Size.m2742getHeightimpl(j11));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1277Iconww6aTOc(@NotNull ImageBitmap imageBitmap, @Nullable String str, @Nullable Modifier modifier, long j11, @Nullable Composer composer, int i11, int i12) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(imageBitmap2, "bitmap");
        composer2.startReplaceableGroup(-554892675);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        long r11 = (i12 & 8) != 0 ? Color.m2918copywmQWz5c$default(((Color) composer2.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), ((Number) composer2.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        composer2.startReplaceableGroup(1157296644);
        boolean changed = composer2.changed((Object) imageBitmap2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0, 0, 6, (DefaultConstructorMarker) null);
            composer2.updateRememberedValue(bitmapPainter);
            rememberedValue = bitmapPainter;
        }
        composer.endReplaceableGroup();
        m1278Iconww6aTOc((Painter) (BitmapPainter) rememberedValue, str, companion, r11, composer, (i13 & 112) | 8 | (i13 & 896) | (i13 & 7168), 0);
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1278Iconww6aTOc(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, long j11, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        Painter painter2 = painter;
        String str2 = str;
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Composer startRestartGroup = composer.startRestartGroup(-1142959010);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        long r13 = (i12 & 8) != 0 ? Color.m2918copywmQWz5c$default(((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl(), ((Number) startRestartGroup.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null) : j11;
        ColorFilter r62 = Color.m2920equalsimpl0(r13, Color.Companion.m2955getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, r13, 0, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(1547385429);
        if (str2 != null) {
            Modifier.Companion companion2 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new IconKt$Icon$semantics$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(companion), painter2), painter, false, (Alignment) null, ContentScale.Companion.getFit(), 0.0f, r62, 22, (Object) null).then(modifier2), startRestartGroup, 0);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$1(painter, str, companion, r13, i11, i12));
        }
    }
}
