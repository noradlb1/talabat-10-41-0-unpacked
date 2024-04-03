package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"shadow", "Landroidx/compose/ui/Modifier;", "elevation", "Landroidx/compose/ui/unit/Dp;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "shadow-ziNgDLE", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "ambientColor", "Landroidx/compose/ui/graphics/Color;", "spotColor", "shadow-s4CzXII", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;ZJJ)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ShadowKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: kotlin.jvm.functions.Function1<androidx.compose.ui.platform.InspectorInfo, kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1} */
    /* JADX WARNING: type inference failed for: r1v7, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Stable
    /* renamed from: shadow-s4CzXII  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier m2592shadows4CzXII(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r14, float r15, @org.jetbrains.annotations.NotNull androidx.compose.ui.graphics.Shape r16, boolean r17, long r18, long r20) {
        /*
            r0 = r14
            java.lang.String r1 = "$this$shadow"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "shape"
            r10 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            r1 = 0
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r11 = r15
            int r1 = androidx.compose.ui.unit.Dp.m5477compareTo0680j_4(r15, r1)
            if (r1 > 0) goto L_0x001c
            if (r17 == 0) goto L_0x004f
        L_0x001c:
            boolean r1 = androidx.compose.ui.platform.InspectableValueKt.isDebugInspectorInfoEnabled()
            if (r1 == 0) goto L_0x0032
            androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1 r1 = new androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1
            r2 = r1
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r2.<init>(r3, r4, r5, r6, r8)
            goto L_0x0036
        L_0x0032:
            kotlin.jvm.functions.Function1 r1 = androidx.compose.ui.platform.InspectableValueKt.getNoInspectorInfo()
        L_0x0036:
            androidx.compose.ui.Modifier$Companion r12 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.draw.ShadowKt$shadow$2$1 r13 = new androidx.compose.ui.draw.ShadowKt$shadow$2$1
            r2 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            r8 = r20
            r2.<init>(r3, r4, r5, r6, r8)
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r12, r13)
            androidx.compose.ui.Modifier r0 = androidx.compose.ui.platform.InspectableValueKt.inspectableWrapper(r14, r1, r2)
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.draw.ShadowKt.m2592shadows4CzXII(androidx.compose.ui.Modifier, float, androidx.compose.ui.graphics.Shape, boolean, long, long):androidx.compose.ui.Modifier");
    }

    /* renamed from: shadow-s4CzXII$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2593shadows4CzXII$default(Modifier modifier, float f11, Shape shape, boolean z11, long j11, long j12, int i11, Object obj) {
        Shape shape2;
        boolean z12;
        long j13;
        long j14;
        if ((i11 & 2) != 0) {
            shape2 = RectangleShapeKt.getRectangleShape();
        } else {
            shape2 = shape;
        }
        if ((i11 & 4) != 0) {
            z12 = false;
            float f12 = f11;
            if (Dp.m5477compareTo0680j_4(f11, Dp.m5478constructorimpl((float) 0)) > 0) {
                z12 = true;
            }
        } else {
            float f13 = f11;
            z12 = z11;
        }
        if ((i11 & 8) != 0) {
            j13 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j13 = j11;
        }
        if ((i11 & 16) != 0) {
            j14 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            j14 = j12;
        }
        return m2592shadows4CzXII(modifier, f11, shape2, z12, j13, j14);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with shadow which accepts ambientColor and spotColor parameters", replaceWith = @ReplaceWith(expression = "Modifier.shadow(elevation, shape, clip, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.draw"}))
    @Stable
    /* renamed from: shadow-ziNgDLE  reason: not valid java name */
    public static final /* synthetic */ Modifier m2594shadowziNgDLE(Modifier modifier, float f11, Shape shape, boolean z11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m2592shadows4CzXII(modifier, f11, shape, z11, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: shadow-ziNgDLE$default  reason: not valid java name */
    public static /* synthetic */ Modifier m2595shadowziNgDLE$default(Modifier modifier, float f11, Shape shape, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i11 & 4) != 0) {
            z11 = false;
            if (Dp.m5477compareTo0680j_4(f11, Dp.m5478constructorimpl((float) 0)) > 0) {
                z11 = true;
            }
        }
        return m2594shadowziNgDLE(modifier, f11, shape, z11);
    }
}
