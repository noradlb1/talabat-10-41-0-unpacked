package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a£\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\"2@\u0010\u001a\u001a<\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001c\u0012\b\b\u0015\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00030\u001b¢\u0006\u0002\b\u001d¢\u0006\u0002\b\u001eH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a&\u0010%\u001a\u00020\u0003*\u00020&2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0002\b)H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006*"}, d2 = {"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "configs", "", "Landroidx/compose/ui/graphics/vector/VectorConfig;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "autoMirror", "", "rememberVectorPainter-vIP8VLU", "(FFFFLjava/lang/String;JIZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "mirror", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class VectorPainterKt {
    @NotNull
    public static final String RootGroupName = "VectorRootGroup";

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0279  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void RenderVectorGroup(@org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.vector.VectorGroup r22, @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, ? extends androidx.compose.ui.graphics.vector.VectorConfig> r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r0 = r22
            r1 = r25
            r2 = r26
            java.lang.String r3 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = -446179233(0xffffffffe567d85f, float:-6.8428625E22)
            r4 = r24
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            r5 = 2
            if (r4 == 0) goto L_0x001c
            r4 = r1 | 6
            goto L_0x002c
        L_0x001c:
            r4 = r1 & 14
            if (r4 != 0) goto L_0x002b
            boolean r4 = r15.changed((java.lang.Object) r0)
            if (r4 == 0) goto L_0x0028
            r4 = 4
            goto L_0x0029
        L_0x0028:
            r4 = r5
        L_0x0029:
            r4 = r4 | r1
            goto L_0x002c
        L_0x002b:
            r4 = r1
        L_0x002c:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x0032
            r4 = r4 | 16
        L_0x0032:
            if (r6 != r5) goto L_0x0049
            r4 = r4 & 91
            r5 = 18
            if (r4 != r5) goto L_0x0049
            boolean r4 = r15.getSkipping()
            if (r4 != 0) goto L_0x0041
            goto L_0x0049
        L_0x0041:
            r15.skipToGroupEnd()
            r3 = r23
            r1 = r15
            goto L_0x027c
        L_0x0049:
            r15.startDefaults()
            r4 = r1 & 1
            if (r4 == 0) goto L_0x005b
            boolean r4 = r15.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            r15.skipToGroupEnd()
            goto L_0x0063
        L_0x005b:
            if (r6 == 0) goto L_0x0063
            java.util.Map r4 = kotlin.collections.MapsKt__MapsKt.emptyMap()
            r14 = r4
            goto L_0x0065
        L_0x0063:
            r14 = r23
        L_0x0065:
            r15.endDefaults()
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L_0x0074
            r4 = -1
            java.lang.String r5 = "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:326)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r1, r4, r5)
        L_0x0074:
            java.util.Iterator r3 = r22.iterator()
        L_0x0078:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0271
            java.lang.Object r4 = r3.next()
            androidx.compose.ui.graphics.vector.VectorNode r4 = (androidx.compose.ui.graphics.vector.VectorNode) r4
            boolean r5 = r4 instanceof androidx.compose.ui.graphics.vector.VectorPath
            if (r5 == 0) goto L_0x017b
            r5 = -326285817(0xffffffffec8d4607, float:-1.3663139E27)
            r15.startReplaceableGroup(r5)
            r17 = r4
            androidx.compose.ui.graphics.vector.VectorPath r17 = (androidx.compose.ui.graphics.vector.VectorPath) r17
            java.lang.String r4 = r17.getName()
            java.lang.Object r4 = r14.get(r4)
            androidx.compose.ui.graphics.vector.VectorConfig r4 = (androidx.compose.ui.graphics.vector.VectorConfig) r4
            if (r4 != 0) goto L_0x00a3
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1 r4 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
            r4.<init>()
        L_0x00a3:
            r13 = r4
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r4 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            java.util.List r5 = r17.getPathData()
            java.lang.Object r4 = r13.getOrDefault(r4, r5)
            java.util.List r4 = (java.util.List) r4
            int r5 = r17.m3553getPathFillTypeRgk1Os()
            java.lang.String r6 = r17.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Fill r7 = androidx.compose.ui.graphics.vector.VectorProperty.Fill.INSTANCE
            androidx.compose.ui.graphics.Brush r8 = r17.getFill()
            java.lang.Object r7 = r13.getOrDefault(r7, r8)
            androidx.compose.ui.graphics.Brush r7 = (androidx.compose.ui.graphics.Brush) r7
            androidx.compose.ui.graphics.vector.VectorProperty$FillAlpha r8 = androidx.compose.ui.graphics.vector.VectorProperty.FillAlpha.INSTANCE
            float r9 = r17.getFillAlpha()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r8 = r13.getOrDefault(r8, r9)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$Stroke r9 = androidx.compose.ui.graphics.vector.VectorProperty.Stroke.INSTANCE
            androidx.compose.ui.graphics.Brush r10 = r17.getStroke()
            java.lang.Object r9 = r13.getOrDefault(r9, r10)
            androidx.compose.ui.graphics.Brush r9 = (androidx.compose.ui.graphics.Brush) r9
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeAlpha r10 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeAlpha.INSTANCE
            float r11 = r17.getStrokeAlpha()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r10 = r13.getOrDefault(r10, r11)
            java.lang.Number r10 = (java.lang.Number) r10
            float r10 = r10.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$StrokeLineWidth r11 = androidx.compose.ui.graphics.vector.VectorProperty.StrokeLineWidth.INSTANCE
            float r12 = r17.getStrokeLineWidth()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r11 = r13.getOrDefault(r11, r12)
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            int r12 = r17.m3554getStrokeLineCapKaPHkGw()
            int r16 = r17.m3555getStrokeLineJoinLxFBmk8()
            r23 = r3
            r3 = r13
            r13 = r16
            float r16 = r17.getStrokeLineMiter()
            r0 = r14
            r14 = r16
            r24 = r15
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathStart r15 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathStart.INSTANCE
            float r16 = r17.getTrimPathStart()
            java.lang.Float r1 = java.lang.Float.valueOf(r16)
            java.lang.Object r1 = r3.getOrDefault(r15, r1)
            java.lang.Number r1 = (java.lang.Number) r1
            float r15 = r1.floatValue()
            r1 = r24
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathEnd r2 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathEnd.INSTANCE
            float r16 = r17.getTrimPathEnd()
            r24 = r0
            java.lang.Float r0 = java.lang.Float.valueOf(r16)
            java.lang.Object r0 = r3.getOrDefault(r2, r0)
            java.lang.Number r0 = (java.lang.Number) r0
            float r16 = r0.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TrimPathOffset r0 = androidx.compose.ui.graphics.vector.VectorProperty.TrimPathOffset.INSTANCE
            float r2 = r17.getTrimPathOffset()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object r0 = r3.getOrDefault(r0, r2)
            java.lang.Number r0 = (java.lang.Number) r0
            float r17 = r0.floatValue()
            r19 = 8
            r20 = 0
            r21 = 0
            r18 = r1
            androidx.compose.ui.graphics.vector.VectorComposeKt.m3544Path9cdaXJ4(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r1.endReplaceableGroup()
            r0 = r22
            r3 = r23
            r14 = r24
            r2 = r26
            r15 = r1
            goto L_0x026d
        L_0x017b:
            r23 = r3
            r24 = r14
            r1 = r15
            boolean r0 = r4 instanceof androidx.compose.ui.graphics.vector.VectorGroup
            if (r0 == 0) goto L_0x025a
            r0 = -326283959(0xffffffffec8d4d49, float:-1.3665881E27)
            r1.startReplaceableGroup(r0)
            r0 = r4
            androidx.compose.ui.graphics.vector.VectorGroup r0 = (androidx.compose.ui.graphics.vector.VectorGroup) r0
            java.lang.String r2 = r0.getName()
            r3 = r24
            java.lang.Object r2 = r3.get(r2)
            androidx.compose.ui.graphics.vector.VectorConfig r2 = (androidx.compose.ui.graphics.vector.VectorConfig) r2
            if (r2 != 0) goto L_0x01a0
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2 r2 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
            r2.<init>()
        L_0x01a0:
            java.lang.String r5 = r0.getName()
            androidx.compose.ui.graphics.vector.VectorProperty$Rotation r6 = androidx.compose.ui.graphics.vector.VectorProperty.Rotation.INSTANCE
            float r7 = r0.getRotation()
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.lang.Object r6 = r2.getOrDefault(r6, r7)
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleX r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleX.INSTANCE
            float r8 = r0.getScaleX()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            java.lang.Object r7 = r2.getOrDefault(r7, r8)
            java.lang.Number r7 = (java.lang.Number) r7
            float r8 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$ScaleY r7 = androidx.compose.ui.graphics.vector.VectorProperty.ScaleY.INSTANCE
            float r9 = r0.getScaleY()
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.lang.Object r7 = r2.getOrDefault(r7, r9)
            java.lang.Number r7 = (java.lang.Number) r7
            float r9 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateX r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateX.INSTANCE
            float r10 = r0.getTranslationX()
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            java.lang.Object r7 = r2.getOrDefault(r7, r10)
            java.lang.Number r7 = (java.lang.Number) r7
            float r10 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$TranslateY r7 = androidx.compose.ui.graphics.vector.VectorProperty.TranslateY.INSTANCE
            float r11 = r0.getTranslationY()
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            java.lang.Object r7 = r2.getOrDefault(r7, r11)
            java.lang.Number r7 = (java.lang.Number) r7
            float r11 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotX r7 = androidx.compose.ui.graphics.vector.VectorProperty.PivotX.INSTANCE
            float r12 = r0.getPivotX()
            java.lang.Float r12 = java.lang.Float.valueOf(r12)
            java.lang.Object r7 = r2.getOrDefault(r7, r12)
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PivotY r12 = androidx.compose.ui.graphics.vector.VectorProperty.PivotY.INSTANCE
            float r13 = r0.getPivotY()
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r12 = r2.getOrDefault(r12, r13)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.ui.graphics.vector.VectorProperty$PathData r13 = androidx.compose.ui.graphics.vector.VectorProperty.PathData.INSTANCE
            java.util.List r0 = r0.getClipPathData()
            java.lang.Object r0 = r2.getOrDefault(r13, r0)
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1 r2 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$1
            r2.<init>(r4, r3)
            r4 = 1450046638(0x566df4ae, float:6.5408787E13)
            r13 = 1
            androidx.compose.runtime.internal.ComposableLambda r13 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r4, r13, r2)
            r15 = 939524096(0x38000000, float:3.0517578E-5)
            r16 = 0
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r12
            r12 = r0
            r14 = r1
            androidx.compose.ui.graphics.vector.VectorComposeKt.Group(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r1.endReplaceableGroup()
            goto L_0x0265
        L_0x025a:
            r3 = r24
            r0 = -326282489(0xffffffffec8d5307, float:-1.366805E27)
            r1.startReplaceableGroup(r0)
            r1.endReplaceableGroup()
        L_0x0265:
            r0 = r22
            r2 = r26
            r15 = r1
            r14 = r3
            r3 = r23
        L_0x026d:
            r1 = r25
            goto L_0x0078
        L_0x0271:
            r3 = r14
            r1 = r15
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x027c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x027c:
            androidx.compose.runtime.ScopeUpdateScope r0 = r1.endRestartGroup()
            if (r0 != 0) goto L_0x0283
            goto L_0x0291
        L_0x0283:
            androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2 r1 = new androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$2
            r2 = r22
            r4 = r25
            r5 = r26
            r1.<init>(r2, r3, r4, r5)
            r0.updateScope(r1)
        L_0x0291:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorPainterKt.RenderVectorGroup(androidx.compose.ui.graphics.vector.VectorGroup, java.util.Map, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long r02 = drawScope.m3424getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r32 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3479scale0AR0LA0(-1.0f, 1.0f, r02);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r32);
    }

    @NotNull
    @Composable
    public static final VectorPainter rememberVectorPainter(@NotNull ImageVector imageVector, @Nullable Composer composer, int i11) {
        ImageVector imageVector2 = imageVector;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(imageVector, "image");
        composer.startReplaceableGroup(1413834416);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i11, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:156)");
        }
        VectorPainter r02 = m3552rememberVectorPaintervIP8VLU(imageVector.m3519getDefaultWidthD9Ej5fM(), imageVector.m3518getDefaultHeightD9Ej5fM(), imageVector.getViewportWidth(), imageVector.getViewportHeight(), imageVector.getName(), imageVector.m3521getTintColor0d7_KjU(), imageVector.m3520getTintBlendMode0nO6VwU(), imageVector.getAutoMirror(), ComposableLambdaKt.composableLambda(composer, 1873274766, true, new VectorPainterKt$rememberVectorPainter$3(imageVector)), composer, 100663296, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }

    @ComposableOpenTarget(index = -1)
    @NotNull
    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    @Composable
    /* renamed from: rememberVectorPainter-mlNsNFs  reason: not valid java name */
    public static final VectorPainter m3551rememberVectorPaintermlNsNFs(float f11, float f12, float f13, float f14, @Nullable String str, long j11, int i11, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i12, int i13) {
        float f15;
        float f16;
        long j12;
        int i14;
        int i15 = i12;
        Intrinsics.checkNotNullParameter(function4, "content");
        composer.startReplaceableGroup(-964365210);
        if ((i13 & 4) != 0) {
            f15 = Float.NaN;
        } else {
            f15 = f13;
        }
        if ((i13 & 8) != 0) {
            f16 = Float.NaN;
        } else {
            f16 = f14;
        }
        String str2 = (i13 & 16) != 0 ? RootGroupName : str;
        if ((i13 & 32) != 0) {
            j12 = Color.Companion.m2955getUnspecified0d7_KjU();
        } else {
            j12 = j11;
        }
        if ((i13 & 64) != 0) {
            i14 = BlendMode.Companion.m2855getSrcIn0nO6VwU();
        } else {
            i14 = i11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i15, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:73)");
        }
        VectorPainter r02 = m3552rememberVectorPaintervIP8VLU(f11, f12, f15, f16, str2, j12, i14, false, function4, composer, (i15 & 14) | 12582912 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (3670016 & i15) | ((i15 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return r02;
    }

    @ComposableOpenTarget(index = -1)
    @NotNull
    @Composable
    /* renamed from: rememberVectorPainter-vIP8VLU  reason: not valid java name */
    public static final VectorPainter m3552rememberVectorPaintervIP8VLU(float f11, float f12, float f13, float f14, @Nullable String str, long j11, int i11, boolean z11, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i12, int i13) {
        float f15;
        String str2;
        long j12;
        int i14;
        boolean z12;
        ColorFilter colorFilter;
        Composer composer2 = composer;
        int i15 = i12;
        int i16 = i13;
        Intrinsics.checkNotNullParameter(function4, "content");
        composer2.startReplaceableGroup(1068590786);
        float f16 = Float.NaN;
        if ((i16 & 4) != 0) {
            f15 = Float.NaN;
        } else {
            f15 = f13;
        }
        if ((i16 & 8) == 0) {
            f16 = f14;
        }
        if ((i16 & 16) != 0) {
            str2 = RootGroupName;
        } else {
            str2 = str;
        }
        if ((i16 & 32) != 0) {
            j12 = Color.Companion.m2955getUnspecified0d7_KjU();
        } else {
            j12 = j11;
        }
        if ((i16 & 64) != 0) {
            i14 = BlendMode.Companion.m2855getSrcIn0nO6VwU();
        } else {
            i14 = i11;
        }
        if ((i16 & 128) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i15, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:114)");
        }
        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
        float r11 = density.m5447toPx0680j_4(f11);
        float r32 = density.m5447toPx0680j_4(f12);
        if (Float.isNaN(f15)) {
            f15 = r11;
        }
        if (Float.isNaN(f16)) {
            f16 = r32;
        }
        Color r12 = Color.m2909boximpl(j12);
        BlendMode r13 = BlendMode.m2823boximpl(i14);
        int i17 = i15 >> 15;
        composer2.startReplaceableGroup(511388516);
        boolean changed = composer2.changed((Object) r12) | composer2.changed((Object) r13);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (!Color.m2920equalsimpl0(j12, Color.Companion.m2955getUnspecified0d7_KjU())) {
                colorFilter = ColorFilter.Companion.m2963tintxETnrds(j12, i14);
            } else {
                colorFilter = null;
            }
            rememberedValue = colorFilter;
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ColorFilter colorFilter2 = (ColorFilter) rememberedValue;
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new VectorPainter();
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue2;
        vectorPainter.m3550setSizeuvyYCjk$ui_release(SizeKt.Size(r11, r32));
        vectorPainter.setAutoMirror$ui_release(z12);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter2);
        vectorPainter.RenderVector$ui_release(str2, f15, f16, function4, composer, ((i15 >> 12) & 14) | 32768 | (i17 & 7168));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return vectorPainter;
    }
}
