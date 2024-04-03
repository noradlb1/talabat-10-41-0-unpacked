package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a§\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a»\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\"\u001a\f\u0010#\u001a\u00020\u0001*\u00020\u0001H\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006$"}, d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class GraphicsLayerModifierKt {
    @NotNull
    @Stable
    public static final Modifier graphicsLayer(@NotNull Modifier modifier, @NotNull Function1<? super GraphicsLayerScope, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new BlockGraphicsLayerModifier(function1, function12));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    @Stable
    /* renamed from: graphicsLayer-2Xn7asI  reason: not valid java name */
    public static final /* synthetic */ Modifier m3053graphicsLayer2Xn7asI(Modifier modifier, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11, RenderEffect renderEffect) {
        float f22 = f11;
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m3055graphicsLayerpANQ8Wg(modifier, f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, shape, z11, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: graphicsLayer-2Xn7asI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3054graphicsLayer2Xn7asI$default(Modifier modifier, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11, RenderEffect renderEffect, int i11, Object obj) {
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        float f29;
        long j12;
        Shape shape2;
        boolean z12;
        RenderEffect renderEffect2;
        int i12 = i11;
        float f31 = 1.0f;
        if ((i12 & 1) != 0) {
            f22 = 1.0f;
        } else {
            f22 = f11;
        }
        if ((i12 & 2) != 0) {
            f23 = 1.0f;
        } else {
            f23 = f12;
        }
        if ((i12 & 4) == 0) {
            f31 = f13;
        }
        float f32 = 0.0f;
        if ((i12 & 8) != 0) {
            f24 = 0.0f;
        } else {
            f24 = f14;
        }
        if ((i12 & 16) != 0) {
            f25 = 0.0f;
        } else {
            f25 = f15;
        }
        if ((i12 & 32) != 0) {
            f26 = 0.0f;
        } else {
            f26 = f16;
        }
        if ((i12 & 64) != 0) {
            f27 = 0.0f;
        } else {
            f27 = f17;
        }
        if ((i12 & 128) != 0) {
            f28 = 0.0f;
        } else {
            f28 = f18;
        }
        if ((i12 & 256) == 0) {
            f32 = f19;
        }
        if ((i12 & 512) != 0) {
            f29 = 8.0f;
        } else {
            f29 = f21;
        }
        if ((i12 & 1024) != 0) {
            j12 = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        } else {
            j12 = j11;
        }
        if ((i12 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i12 & 4096) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        if ((i12 & 8192) != 0) {
            renderEffect2 = null;
        } else {
            renderEffect2 = renderEffect;
        }
        return m3053graphicsLayer2Xn7asI(modifier, f22, f23, f31, f24, f25, f26, f27, f28, f32, f29, j12, shape2, z12, renderEffect2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Stable
    /* renamed from: graphicsLayer-pANQ8Wg  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m3055graphicsLayerpANQ8Wg(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r24, float r25, float r26, float r27, float r28, float r29, float r30, float r31, float r32, float r33, float r34, long r35, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.Shape r37, boolean r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.RenderEffect r39, long r40, long r42) {
        /*
            r0 = r24
            java.lang.String r1 = "$this$graphicsLayer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "shape"
            r15 = r37
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x003b
            androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r20 = r42
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r20)
            goto L_0x003f
        L_0x003b:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x003f:
            r22 = r1
            androidx.compose.ui.graphics.SimpleGraphicsLayerModifier r1 = new androidx.compose.ui.graphics.SimpleGraphicsLayerModifier
            r2 = r1
            r23 = 0
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r15 = r37
            r16 = r38
            r17 = r39
            r18 = r40
            r20 = r42
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r20, r22, r23)
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.GraphicsLayerModifierKt.m3055graphicsLayerpANQ8Wg(androidx.compose.ui.Modifier, float, float, float, float, float, float, float, float, float, float, long, androidx.compose.ui.graphics.Shape, boolean, androidx.compose.ui.graphics.RenderEffect, long, long):androidx.compose.ui.Modifier");
    }

    /* renamed from: graphicsLayer-pANQ8Wg$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3056graphicsLayerpANQ8Wg$default(Modifier modifier, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11, RenderEffect renderEffect, long j12, long j13, int i11, Object obj) {
        int i12 = i11;
        float f22 = 1.0f;
        float f23 = (i12 & 1) != 0 ? 1.0f : f11;
        float f24 = (i12 & 2) != 0 ? 1.0f : f12;
        if ((i12 & 4) == 0) {
            f22 = f13;
        }
        float f25 = 0.0f;
        float f26 = (i12 & 8) != 0 ? 0.0f : f14;
        float f27 = (i12 & 16) != 0 ? 0.0f : f15;
        float f28 = (i12 & 32) != 0 ? 0.0f : f16;
        float f29 = (i12 & 64) != 0 ? 0.0f : f17;
        float f31 = (i12 & 128) != 0 ? 0.0f : f18;
        if ((i12 & 256) == 0) {
            f25 = f19;
        }
        return m3055graphicsLayerpANQ8Wg(modifier, f23, f24, f22, f26, f27, f28, f29, f31, f25, (i12 & 512) != 0 ? 8.0f : f21, (i12 & 1024) != 0 ? TransformOrigin.Companion.m3292getCenterSzJe1aQ() : j11, (i12 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i12 & 4096) != 0 ? false : z11, (i12 & 8192) != 0 ? null : renderEffect, (i12 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j12, (i12 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j13);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    @Stable
    /* renamed from: graphicsLayer-sKFY_QE  reason: not valid java name */
    public static final /* synthetic */ Modifier m3057graphicsLayersKFY_QE(Modifier modifier, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m3056graphicsLayerpANQ8Wg$default(modifier2, f11, f12, f13, f14, f15, f16, f17, f18, f19, f21, j11, shape, z11, (RenderEffect) null, 0, 0, CpioConstants.C_ISSOCK, (Object) null);
    }

    /* renamed from: graphicsLayer-sKFY_QE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3058graphicsLayersKFY_QE$default(Modifier modifier, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, long j11, Shape shape, boolean z11, int i11, Object obj) {
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        float f29;
        long j12;
        Shape shape2;
        boolean z12;
        int i12 = i11;
        float f31 = 1.0f;
        if ((i12 & 1) != 0) {
            f22 = 1.0f;
        } else {
            f22 = f11;
        }
        if ((i12 & 2) != 0) {
            f23 = 1.0f;
        } else {
            f23 = f12;
        }
        if ((i12 & 4) == 0) {
            f31 = f13;
        }
        float f32 = 0.0f;
        if ((i12 & 8) != 0) {
            f24 = 0.0f;
        } else {
            f24 = f14;
        }
        if ((i12 & 16) != 0) {
            f25 = 0.0f;
        } else {
            f25 = f15;
        }
        if ((i12 & 32) != 0) {
            f26 = 0.0f;
        } else {
            f26 = f16;
        }
        if ((i12 & 64) != 0) {
            f27 = 0.0f;
        } else {
            f27 = f17;
        }
        if ((i12 & 128) != 0) {
            f28 = 0.0f;
        } else {
            f28 = f18;
        }
        if ((i12 & 256) == 0) {
            f32 = f19;
        }
        if ((i12 & 512) != 0) {
            f29 = 8.0f;
        } else {
            f29 = f21;
        }
        if ((i12 & 1024) != 0) {
            j12 = TransformOrigin.Companion.m3292getCenterSzJe1aQ();
        } else {
            j12 = j11;
        }
        if ((i12 & 2048) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i12 & 4096) != 0) {
            z12 = false;
        } else {
            z12 = z11;
        }
        return m3057graphicsLayersKFY_QE(modifier, f22, f23, f31, f24, f25, f26, f27, f28, f32, f29, j12, shape2, z12);
    }

    @NotNull
    @Stable
    public static final Modifier toolingGraphicsLayer(@NotNull Modifier modifier) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            return modifier2.then(m3056graphicsLayerpANQ8Wg$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, (Shape) null, false, (RenderEffect) null, 0, 0, 65535, (Object) null));
        }
        return modifier2;
    }
}
