package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class IconKt {
    @NotNull
    private static final Modifier DefaultIconSizeModifier = SizeKt.m558size3ABfNKs(Modifier.Companion, IconButtonTokens.INSTANCE.m2251getIconSizeD9Ej5fM());

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1718Iconww6aTOc(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.vector.ImageVector r17, @org.jetbrains.annotations.Nullable java.lang.String r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r19, long r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r1 = r17
            r6 = r23
            java.lang.String r0 = "imageVector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -126890956(0xfffffffff86fcc34, float:-1.9454698E34)
            r2 = r22
            androidx.compose.runtime.Composer r2 = r2.startRestartGroup(r0)
            r3 = r24 & 1
            if (r3 == 0) goto L_0x0019
            r3 = r6 | 6
            goto L_0x0029
        L_0x0019:
            r3 = r6 & 14
            if (r3 != 0) goto L_0x0028
            boolean r3 = r2.changed((java.lang.Object) r1)
            if (r3 == 0) goto L_0x0025
            r3 = 4
            goto L_0x0026
        L_0x0025:
            r3 = 2
        L_0x0026:
            r3 = r3 | r6
            goto L_0x0029
        L_0x0028:
            r3 = r6
        L_0x0029:
            r4 = r24 & 2
            if (r4 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r6 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r18
            boolean r5 = r2.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x003f
            r5 = 32
            goto L_0x0041
        L_0x003f:
            r5 = 16
        L_0x0041:
            r3 = r3 | r5
            goto L_0x0045
        L_0x0043:
            r4 = r18
        L_0x0045:
            r5 = r24 & 4
            if (r5 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r7 = r6 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005f
            r7 = r19
            boolean r8 = r2.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x005b
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r8
            goto L_0x0061
        L_0x005f:
            r7 = r19
        L_0x0061:
            r8 = r6 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007a
            r8 = r24 & 8
            if (r8 != 0) goto L_0x0074
            r8 = r20
            boolean r10 = r2.changed((long) r8)
            if (r10 == 0) goto L_0x0076
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0074:
            r8 = r20
        L_0x0076:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r3 = r3 | r10
            goto L_0x007c
        L_0x007a:
            r8 = r20
        L_0x007c:
            r10 = r3 & 5851(0x16db, float:8.199E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r10 != r11) goto L_0x008f
            boolean r10 = r2.getSkipping()
            if (r10 != 0) goto L_0x0089
            goto L_0x008f
        L_0x0089:
            r2.skipToGroupEnd()
            r3 = r7
            goto L_0x00fa
        L_0x008f:
            r2.startDefaults()
            r10 = r6 & 1
            if (r10 == 0) goto L_0x00a8
            boolean r10 = r2.getDefaultsInvalid()
            if (r10 == 0) goto L_0x009d
            goto L_0x00a8
        L_0x009d:
            r2.skipToGroupEnd()
            r5 = r24 & 8
            if (r5 == 0) goto L_0x00a6
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a6:
            r5 = r7
            goto L_0x00c4
        L_0x00a8:
            if (r5 == 0) goto L_0x00ad
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            goto L_0x00ae
        L_0x00ad:
            r5 = r7
        L_0x00ae:
            r7 = r24 & 8
            if (r7 == 0) goto L_0x00c4
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.material3.ContentColorKt.getLocalContentColor()
            java.lang.Object r7 = r2.consume(r7)
            androidx.compose.ui.graphics.Color r7 = (androidx.compose.ui.graphics.Color) r7
            long r7 = r7.m2929unboximpl()
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r15 = r7
            goto L_0x00c5
        L_0x00c4:
            r15 = r8
        L_0x00c5:
            r2.endDefaults()
            boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r7 == 0) goto L_0x00d4
            r7 = -1
            java.lang.String r8 = "androidx.compose.material3.Icon (Icon.kt:55)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r7, r8)
        L_0x00d4:
            r0 = r3 & 14
            androidx.compose.ui.graphics.vector.VectorPainter r7 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r1, r2, r0)
            int r0 = androidx.compose.ui.graphics.vector.VectorPainter.$stable
            r8 = r3 & 112(0x70, float:1.57E-43)
            r0 = r0 | r8
            r8 = r3 & 896(0x380, float:1.256E-42)
            r0 = r0 | r8
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r13 = r0 | r3
            r14 = 0
            r8 = r18
            r9 = r5
            r10 = r15
            r12 = r2
            m1717Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r7, (java.lang.String) r8, (androidx.compose.ui.Modifier) r9, (long) r10, (androidx.compose.runtime.Composer) r12, (int) r13, (int) r14)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00f8
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00f8:
            r3 = r5
            r8 = r15
        L_0x00fa:
            androidx.compose.runtime.ScopeUpdateScope r10 = r2.endRestartGroup()
            if (r10 != 0) goto L_0x0101
            goto L_0x0113
        L_0x0101:
            androidx.compose.material3.IconKt$Icon$1 r11 = new androidx.compose.material3.IconKt$Icon$1
            r0 = r11
            r1 = r17
            r2 = r18
            r4 = r8
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r6, r7)
            r10.updateScope(r11)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.IconKt.m1718Iconww6aTOc(androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Modifier defaultSizeFor(Modifier modifier, Painter painter) {
        Modifier modifier2;
        if (Size.m2741equalsimpl0(painter.m3516getIntrinsicSizeNHjbRc(), Size.Companion.m2753getUnspecifiedNHjbRc()) || m1719isInfiniteuvyYCjk(painter.m3516getIntrinsicSizeNHjbRc())) {
            modifier2 = DefaultIconSizeModifier;
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    /* renamed from: isInfinite-uvyYCjk  reason: not valid java name */
    private static final boolean m1719isInfiniteuvyYCjk(long j11) {
        return Float.isInfinite(Size.m2745getWidthimpl(j11)) && Float.isInfinite(Size.m2742getHeightimpl(j11));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1716Iconww6aTOc(@NotNull ImageBitmap imageBitmap, @Nullable String str, @Nullable Modifier modifier, long j11, @Nullable Composer composer, int i11, int i12) {
        long j12;
        int i13;
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "bitmap");
        Composer startRestartGroup = composer.startRestartGroup(-1092052280);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i12 & 8) != 0) {
            j12 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
            i13 = i11 & -7169;
        } else {
            j12 = j11;
            i13 = i11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1092052280, i13, -1, "androidx.compose.material3.Icon (Icon.kt:85)");
        }
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) imageBitmap2);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            BitmapPainter bitmapPainter = new BitmapPainter(imageBitmap, 0, 0, 6, (DefaultConstructorMarker) null);
            startRestartGroup.updateRememberedValue(bitmapPainter);
            rememberedValue = bitmapPainter;
        }
        startRestartGroup.endReplaceableGroup();
        Composer composer2 = startRestartGroup;
        m1717Iconww6aTOc((Painter) (BitmapPainter) rememberedValue, str, companion, j12, startRestartGroup, (i13 & 112) | 8 | (i13 & 896) | (i13 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$2(imageBitmap, str, companion, j12, i11, i12));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Icon-ww6aTOc  reason: not valid java name */
    public static final void m1717Iconww6aTOc(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, long j11, @Nullable Composer composer, int i11, int i12) {
        long j12;
        int i13;
        Modifier modifier2;
        Painter painter2 = painter;
        String str2 = str;
        Intrinsics.checkNotNullParameter(painter2, "painter");
        Composer startRestartGroup = composer.startRestartGroup(-2142239481);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i12 & 8) != 0) {
            i13 = i11 & -7169;
            j12 = ((Color) startRestartGroup.consume(ContentColorKt.getLocalContentColor())).m2929unboximpl();
        } else {
            j12 = j11;
            i13 = i11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2142239481, i13, -1, "androidx.compose.material3.Icon (Icon.kt:116)");
        }
        ColorFilter r62 = Color.m2920equalsimpl0(j12, Color.Companion.m2955getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m2960tintxETnrds$default(ColorFilter.Companion, j12, 0, 2, (Object) null);
        startRestartGroup.startReplaceableGroup(69355216);
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
        long j13 = j12;
        BoxKt.Box(PainterModifierKt.paint$default(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(companion), painter2), painter, false, (Alignment) null, ContentScale.Companion.getFit(), 0.0f, r62, 22, (Object) null).then(modifier2), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new IconKt$Icon$3(painter, str, companion, j13, i11, i12));
        }
    }
}
