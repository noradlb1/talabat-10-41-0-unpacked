package androidx.compose.foundation;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0017\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Image", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "Image-5h-nEew", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ILandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ImageKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Consider usage of the Image composable that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "Image(bitmap, contentDescription, modifier, alignment, contentScale, alpha, colorFilter, DefaultFilterQuality)", imports = {"androidx.compose.foundation", "androidx.compose.ui.graphics.DefaultAlpha", "androidx.compose.ui.Alignment", "androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultFilterQuality", "androidx.compose.ui.layout.ContentScale.Fit"}))
    @Composable
    public static final /* synthetic */ void Image(ImageBitmap imageBitmap, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, float f11, ColorFilter colorFilter, Composer composer, int i11, int i12) {
        int i13 = i11;
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap, "bitmap");
        composer.startReplaceableGroup(-2123228673);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i12 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i12 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f12 = (i12 & 32) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i12 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2123228673, i13, -1, "androidx.compose.foundation.Image (Image.kt:87)");
        }
        m226Image5hnEew(imageBitmap, str, companion, center, fit, f12, colorFilter2, FilterQuality.Companion.m3005getLowfv9h1I(), composer, (i13 & 112) | 8 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: androidx.compose.ui.graphics.painter.BitmapPainter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: androidx.compose.ui.Modifier$Companion} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: Image-5h-nEew  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m226Image5hnEew(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.ImageBitmap r16, @org.jetbrains.annotations.Nullable java.lang.String r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.layout.ContentScale r20, float r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.ColorFilter r22, int r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r0 = r16
            r10 = r24
            r8 = r25
            r1 = r26
            java.lang.String r2 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
            r2 = -1396260732(0xffffffffacc6c084, float:-5.648872E-12)
            r10.startReplaceableGroup(r2)
            r3 = r1 & 4
            if (r3 == 0) goto L_0x001b
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            r9 = r3
            goto L_0x001d
        L_0x001b:
            r9 = r18
        L_0x001d:
            r3 = r1 & 8
            if (r3 == 0) goto L_0x0029
            androidx.compose.ui.Alignment$Companion r3 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r3 = r3.getCenter()
            r11 = r3
            goto L_0x002b
        L_0x0029:
            r11 = r19
        L_0x002b:
            r3 = r1 & 16
            if (r3 == 0) goto L_0x0037
            androidx.compose.ui.layout.ContentScale$Companion r3 = androidx.compose.ui.layout.ContentScale.Companion
            androidx.compose.ui.layout.ContentScale r3 = r3.getFit()
            r12 = r3
            goto L_0x0039
        L_0x0037:
            r12 = r20
        L_0x0039:
            r3 = r1 & 32
            if (r3 == 0) goto L_0x0041
            r3 = 1065353216(0x3f800000, float:1.0)
            r13 = r3
            goto L_0x0043
        L_0x0041:
            r13 = r21
        L_0x0043:
            r3 = r1 & 64
            if (r3 == 0) goto L_0x004a
            r3 = 0
            r14 = r3
            goto L_0x004c
        L_0x004a:
            r14 = r22
        L_0x004c:
            r1 = r1 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0058
            androidx.compose.ui.graphics.drawscope.DrawScope$Companion r1 = androidx.compose.ui.graphics.drawscope.DrawScope.Companion
            int r1 = r1.m3427getDefaultFilterQualityfv9h1I()
            r5 = r1
            goto L_0x005a
        L_0x0058:
            r5 = r23
        L_0x005a:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0066
            r1 = -1
            java.lang.String r3 = "androidx.compose.foundation.Image (Image.kt:143)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r8, r1, r3)
        L_0x0066:
            r1 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r1)
            boolean r1 = r10.changed((java.lang.Object) r0)
            java.lang.Object r2 = r24.rememberedValue()
            if (r1 != 0) goto L_0x007e
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x008d
        L_0x007e:
            r1 = 0
            r3 = 0
            r6 = 6
            r7 = 0
            r0 = r16
            androidx.compose.ui.graphics.painter.BitmapPainter r2 = androidx.compose.ui.graphics.painter.BitmapPainterKt.m3510BitmapPainterQZhYCtY$default(r0, r1, r3, r5, r6, r7)
            r10.updateRememberedValue(r2)
        L_0x008d:
            r24.endReplaceableGroup()
            r0 = r2
            androidx.compose.ui.graphics.painter.BitmapPainter r0 = (androidx.compose.ui.graphics.painter.BitmapPainter) r0
            r1 = r8 & 112(0x70, float:1.57E-43)
            r1 = r1 | 8
            r2 = r8 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r8 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = 57344(0xe000, float:8.0356E-41)
            r2 = r2 & r8
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r8
            r1 = r1 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r8
            r8 = r1 | r2
            r15 = 0
            r1 = r17
            r2 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r24
            r9 = r15
            Image((androidx.compose.ui.graphics.painter.Painter) r0, (java.lang.String) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.ui.Alignment) r3, (androidx.compose.ui.layout.ContentScale) r4, (float) r5, (androidx.compose.ui.graphics.ColorFilter) r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00c2
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00c2:
            r24.endReplaceableGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ImageKt.m226Image5hnEew(androidx.compose.ui.graphics.ImageBitmap, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, int, androidx.compose.runtime.Composer, int, int):void");
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Image(@NotNull ImageVector imageVector, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f11, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i11, int i12) {
        ImageVector imageVector2 = imageVector;
        Composer composer2 = composer;
        int i13 = i11;
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        composer2.startReplaceableGroup(1595907091);
        Modifier modifier2 = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i12 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i12 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f12 = (i12 & 32) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i12 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1595907091, i13, -1, "androidx.compose.foundation.Image (Image.kt:189)");
        }
        Image((Painter) VectorPainterKt.rememberVectorPainter(imageVector, composer2, i13 & 14), str, modifier2, center, fit, f12, colorFilter2, composer, VectorPainter.$stable | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void Image(@NotNull Painter painter, @Nullable String str, @Nullable Modifier modifier, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f11, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i11, int i12) {
        Modifier modifier2;
        String str2 = str;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer startRestartGroup = composer.startRestartGroup(1142754848);
        Modifier.Companion companion = (i12 & 4) != 0 ? Modifier.Companion : modifier;
        Alignment center = (i12 & 8) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i12 & 16) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f12 = (i12 & 32) != 0 ? 1.0f : f11;
        ColorFilter colorFilter2 = (i12 & 64) != 0 ? null : colorFilter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1142754848, i11, -1, "androidx.compose.foundation.Image (Image.kt:235)");
        } else {
            int i13 = i11;
        }
        startRestartGroup.startReplaceableGroup(-816794123);
        if (str2 != null) {
            Modifier.Companion companion2 = Modifier.Companion;
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed = startRestartGroup.changed((Object) str2);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ImageKt$Image$semantics$1$1(str2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            modifier2 = SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        startRestartGroup.endReplaceableGroup();
        Modifier paint$default = PainterModifierKt.paint$default(ClipKt.clipToBounds(companion.then(modifier2)), painter, false, center, fit, f12, colorFilter2, 2, (Object) null);
        ImageKt$Image$2 imageKt$Image$2 = ImageKt$Image$2.INSTANCE;
        startRestartGroup.startReplaceableGroup(-1323940314);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(paint$default);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(constructor);
        } else {
            startRestartGroup.useNode();
        }
        startRestartGroup.disableReusing();
        Composer r92 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r92, imageKt$Image$2, companion3.getSetMeasurePolicy());
        Updater.m2543setimpl(r92, density, companion3.getSetDensity());
        Updater.m2543setimpl(r92, layoutDirection, companion3.getSetLayoutDirection());
        Updater.m2543setimpl(r92, viewConfiguration, companion3.getSetViewConfiguration());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-2077995625);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ImageKt$Image$3(painter, str, companion, center, fit, f12, colorFilter2, i11, i12));
        }
    }
}
