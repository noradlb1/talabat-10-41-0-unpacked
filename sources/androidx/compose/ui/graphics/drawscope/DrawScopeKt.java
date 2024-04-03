package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000b\u001ah\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a$\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\bH\bø\u0001\u0000\u001a1\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001a=\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aI\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001e\u001aH\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b!\u0010\u001e\u001aH\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b#\u0010\u001e\u001aP\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'\u001a=\u0010(\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u001aB\u0010)\u001a\u00020\u0001*\u00020\u00022\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "Landroidx/compose/ui/graphics/Canvas;", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DrawScopeKt {
    /* renamed from: clipPath-KD09W0M  reason: not valid java name */
    public static final void m3462clipPathKD09W0M(@NotNull DrawScope drawScope, @NotNull Path path, int i11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3474clipPathmtrdDE(path, i11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: clipPath-KD09W0M$default  reason: not valid java name */
    public static /* synthetic */ void m3463clipPathKD09W0M$default(DrawScope drawScope, Path path, int i11, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipPath");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r02 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3474clipPathmtrdDE(path, i11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r02);
    }

    /* renamed from: clipRect-rOu3jXo  reason: not valid java name */
    public static final void m3464clipRectrOu3jXo(@NotNull DrawScope drawScope, float f11, float f12, float f13, float f14, int i11, @NotNull Function1<? super DrawScope, Unit> function1) {
        DrawScope drawScope2 = drawScope;
        Function1<? super DrawScope, Unit> function12 = function1;
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function12, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r32 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3475clipRectN_I0leg(f11, f12, f13, f14, i11);
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r32);
    }

    /* renamed from: clipRect-rOu3jXo$default  reason: not valid java name */
    public static /* synthetic */ void m3465clipRectrOu3jXo$default(DrawScope drawScope, float f11, float f12, float f13, float f14, int i11, Function1 function1, int i12, Object obj) {
        float f15;
        float f16;
        if ((i12 & 1) != 0) {
            f15 = 0.0f;
        } else {
            f15 = f11;
        }
        if ((i12 & 2) != 0) {
            f16 = 0.0f;
        } else {
            f16 = f12;
        }
        if ((i12 & 4) != 0) {
            f13 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
        }
        float f17 = f13;
        if ((i12 & 8) != 0) {
            f14 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc());
        }
        float f18 = f14;
        if ((i12 & 16) != 0) {
            i11 = ClipOp.Companion.m2908getIntersectrtfAjoo();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$clipRect");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r92 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3475clipRectN_I0leg(f15, f16, f17, f18, i11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r92);
    }

    public static final void drawIntoCanvas(@NotNull DrawScope drawScope, @NotNull Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void inset(@NotNull DrawScope drawScope, float f11, float f12, float f13, float f14, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f11, f12, f13, f14);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f11, -f12, -f13, -f14);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f11, float f12, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f11, f12, f11, f12);
        function1.invoke(drawScope);
        float f13 = -f11;
        float f14 = -f12;
        drawScope.getDrawContext().getTransform().inset(f13, f14, f13, f14);
    }

    /* renamed from: rotate-Rg1IO4c  reason: not valid java name */
    public static final void m3466rotateRg1IO4c(@NotNull DrawScope drawScope, float f11, long j11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3478rotateUv8p0NA(f11, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: rotate-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3467rotateRg1IO4c$default(DrawScope drawScope, float f11, long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = drawScope.m3424getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotate");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r02 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3478rotateUv8p0NA(f11, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r02);
    }

    /* renamed from: rotateRad-Rg1IO4c  reason: not valid java name */
    public static final void m3468rotateRadRg1IO4c(@NotNull DrawScope drawScope, float f11, long j11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3478rotateUv8p0NA(DegreesKt.degrees(f11), j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: rotateRad-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3469rotateRadRg1IO4c$default(DrawScope drawScope, float f11, long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = drawScope.m3424getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$rotateRad");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r02 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3478rotateUv8p0NA(DegreesKt.degrees(f11), j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r02);
    }

    /* renamed from: scale-Fgt4K4Q  reason: not valid java name */
    public static final void m3470scaleFgt4K4Q(@NotNull DrawScope drawScope, float f11, float f12, long j11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3479scale0AR0LA0(f11, f12, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: scale-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ void m3471scaleFgt4K4Q$default(DrawScope drawScope, float f11, float f12, long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = drawScope.m3424getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r02 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3479scale0AR0LA0(f11, f12, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r02);
    }

    /* renamed from: scale-Rg1IO4c  reason: not valid java name */
    public static final void m3472scaleRg1IO4c(@NotNull DrawScope drawScope, float f11, long j11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3479scale0AR0LA0(f11, f11, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: scale-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m3473scaleRg1IO4c$default(DrawScope drawScope, float f11, long j11, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = drawScope.m3424getCenterF1C5BW0();
        }
        Intrinsics.checkNotNullParameter(drawScope, "$this$scale");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawContext drawContext = drawScope.getDrawContext();
        long r02 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m3479scale0AR0LA0(f11, f11, j11);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r02);
    }

    public static final void translate(@NotNull DrawScope drawScope, float f11, float f12, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f11, f12);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f11, -f12);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f11, float f12, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = 0.0f;
        }
        if ((i11 & 2) != 0) {
            f12 = 0.0f;
        }
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().translate(f11, f12);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f11, -f12);
    }

    public static final void withTransform(@NotNull DrawScope drawScope, @NotNull Function1<? super DrawTransform, Unit> function1, @NotNull Function1<? super DrawScope, Unit> function12) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transformBlock");
        Intrinsics.checkNotNullParameter(function12, "drawBlock");
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        function1.invoke(drawContext.getTransform());
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f11, f11, f11, f11);
        function1.invoke(drawScope);
        float f12 = -f11;
        drawScope.getDrawContext().getTransform().inset(f12, f12, f12, f12);
    }

    public static final void inset(@NotNull DrawScope drawScope, float f11, float f12, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        drawScope.getDrawContext().getTransform().inset(f11, f12, f11, f12);
        function1.invoke(drawScope);
        float f13 = -f11;
        float f14 = -f12;
        drawScope.getDrawContext().getTransform().inset(f13, f14, f13, f14);
    }
}
