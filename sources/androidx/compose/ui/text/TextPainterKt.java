package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import f0.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001aU\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aW\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a{\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u0014\b\u0002\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0$2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001ae\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020+2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006."}, d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawText-712uMfE", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-xIhfjkU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxSize", "Landroidx/compose/ui/unit/IntSize;", "drawText-i2ZdXms", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;J)V", "", "drawText-O6gbksU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJ)V", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TextPainterKt {
    private static final void clip(DrawTransform drawTransform, TextLayoutResult textLayoutResult) {
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.m5395equalsimpl0(textLayoutResult.getLayoutInput().m5010getOverflowgIe3tQ8(), TextOverflow.Companion.m5404getVisiblegIe3tQ8())) {
            c.d(drawTransform, 0.0f, 0.0f, (float) IntSize.m5638getWidthimpl(textLayoutResult.m5014getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(textLayoutResult.m5014getSizeYbymL2g()), 0, 16, (Object) null);
        }
    }

    @ExperimentalTextApi
    /* renamed from: drawText-712uMfE  reason: not valid java name */
    public static final void m5018drawText712uMfE(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, @NotNull Brush brush, long j11, float f11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        Intrinsics.checkNotNullParameter(brush, "brush");
        if (shadow == null) {
            shadow = textLayoutResult.getLayoutInput().getStyle().getShadow();
        }
        Shadow shadow2 = shadow;
        if (textDecoration == null) {
            textDecoration = textLayoutResult.getLayoutInput().getStyle().getTextDecoration();
        }
        TextDecoration textDecoration2 = textDecoration;
        DrawContext drawContext = drawScope.getDrawContext();
        long r62 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        clip(transform, textLayoutResult);
        MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
        Canvas canvas = drawScope.getDrawContext().getCanvas();
        if (Float.isNaN(f11)) {
            f11 = textLayoutResult.getLayoutInput().getStyle().getAlpha();
        }
        multiParagraph.paint(canvas, brush, f11, shadow2, textDecoration2);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r62);
    }

    /* renamed from: drawText-712uMfE$default  reason: not valid java name */
    public static /* synthetic */ void m5019drawText712uMfE$default(DrawScope drawScope, TextLayoutResult textLayoutResult, Brush brush, long j11, float f11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        long j12;
        float f12;
        Shadow shadow2;
        TextDecoration textDecoration2;
        if ((i11 & 4) != 0) {
            j12 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j12 = j11;
        }
        if ((i11 & 8) != 0) {
            f12 = Float.NaN;
        } else {
            f12 = f11;
        }
        if ((i11 & 16) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i11 & 32) != 0) {
            textDecoration2 = null;
        } else {
            textDecoration2 = textDecoration;
        }
        m5018drawText712uMfE(drawScope, textLayoutResult, brush, j12, f12, shadow2, textDecoration2);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-O6gbksU  reason: not valid java name */
    public static final void m5020drawTextO6gbksU(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull String str, long j11, @NotNull TextStyle textStyle, int i11, boolean z11, int i12, long j12) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        TextMeasurer textMeasurer2 = textMeasurer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        TextLayoutResult r02 = TextMeasurer.m5016measurexDpz5zY$default(textMeasurer2, new AnnotatedString(str2, (List) null, (List) null, 6, (DefaultConstructorMarker) null), textStyle, i11, z11, i12, (List) null, ConstraintsKt.Constraints$default(0, IntSize.m5638getWidthimpl(j12), 0, IntSize.m5637getHeightimpl(j12), 5, (Object) null), drawScope.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1568, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long r22 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        clip(transform, r02);
        MultiParagraph.m4941paintRPmYEkk$default(r02.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r22);
    }

    /* renamed from: drawText-O6gbksU$default  reason: not valid java name */
    public static /* synthetic */ void m5021drawTextO6gbksU$default(DrawScope drawScope, TextMeasurer textMeasurer, String str, long j11, TextStyle textStyle, int i11, boolean z11, int i12, long j12, int i13, Object obj) {
        long j13;
        TextStyle textStyle2;
        int i14;
        boolean z12;
        int i15;
        long j14;
        int i16 = i13;
        if ((i16 & 4) != 0) {
            j13 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j13 = j11;
        }
        if ((i16 & 8) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        if ((i16 & 16) != 0) {
            i14 = TextOverflow.Companion.m5402getClipgIe3tQ8();
        } else {
            i14 = i11;
        }
        if ((i16 & 32) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i16 & 64) != 0) {
            i15 = Integer.MAX_VALUE;
        } else {
            i15 = i12;
        }
        if ((i16 & 128) != 0) {
            j14 = IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt((float) Math.ceil((double) (Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - Offset.m2676getXimpl(j13)))), MathKt__MathJVMKt.roundToInt((float) Math.ceil((double) (Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) - Offset.m2677getYimpl(j13)))));
        } else {
            j14 = j12;
        }
        m5020drawTextO6gbksU(drawScope, textMeasurer, str, j13, textStyle2, i14, z12, i15, j14);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-i2ZdXms  reason: not valid java name */
    public static final void m5022drawTexti2ZdXms(@NotNull DrawScope drawScope, @NotNull TextMeasurer textMeasurer, @NotNull AnnotatedString annotatedString, long j11, @NotNull TextStyle textStyle, int i11, boolean z11, int i12, @NotNull List<AnnotatedString.Range<Placeholder>> list, long j12) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        TextMeasurer textMeasurer2 = textMeasurer;
        Intrinsics.checkNotNullParameter(textMeasurer2, "textMeasurer");
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "text");
        TextStyle textStyle2 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle2, "style");
        List<AnnotatedString.Range<Placeholder>> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "placeholders");
        TextLayoutResult r02 = TextMeasurer.m5016measurexDpz5zY$default(textMeasurer2, annotatedString2, textStyle2, i11, z11, i12, list2, ConstraintsKt.Constraints$default(0, IntSize.m5638getWidthimpl(j12), 0, IntSize.m5637getHeightimpl(j12), 5, (Object) null), drawScope.getLayoutDirection(), drawScope, (FontFamily.Resolver) null, false, 1536, (Object) null);
        DrawContext drawContext = drawScope.getDrawContext();
        long r22 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11));
        clip(transform, r02);
        MultiParagraph.m4941paintRPmYEkk$default(r02.getMultiParagraph(), drawScope.getDrawContext().getCanvas(), 0, (Shadow) null, (TextDecoration) null, 14, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r22);
    }

    /* renamed from: drawText-i2ZdXms$default  reason: not valid java name */
    public static /* synthetic */ void m5023drawTexti2ZdXms$default(DrawScope drawScope, TextMeasurer textMeasurer, AnnotatedString annotatedString, long j11, TextStyle textStyle, int i11, boolean z11, int i12, List list, long j12, int i13, Object obj) {
        long j13;
        TextStyle textStyle2;
        int i14;
        boolean z12;
        int i15;
        List list2;
        long j14;
        int i16 = i13;
        if ((i16 & 4) != 0) {
            j13 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j13 = j11;
        }
        if ((i16 & 8) != 0) {
            textStyle2 = TextStyle.Companion.getDefault();
        } else {
            textStyle2 = textStyle;
        }
        if ((i16 & 16) != 0) {
            i14 = TextOverflow.Companion.m5402getClipgIe3tQ8();
        } else {
            i14 = i11;
        }
        if ((i16 & 32) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i16 & 64) != 0) {
            i15 = Integer.MAX_VALUE;
        } else {
            i15 = i12;
        }
        if ((i16 & 128) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        if ((i16 & 256) != 0) {
            j14 = IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt((float) Math.ceil((double) (Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - Offset.m2676getXimpl(j13)))), MathKt__MathJVMKt.roundToInt((float) Math.ceil((double) (Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) - Offset.m2677getYimpl(j13)))));
        } else {
            j14 = j12;
        }
        m5022drawTexti2ZdXms(drawScope, textMeasurer, annotatedString, j13, textStyle2, i14, z12, i15, list2, j14);
    }

    @ExperimentalTextApi
    /* renamed from: drawText-xIhfjkU  reason: not valid java name */
    public static final void m5024drawTextxIhfjkU(@NotNull DrawScope drawScope, @NotNull TextLayoutResult textLayoutResult, long j11, long j12, float f11, @Nullable Shadow shadow, @Nullable TextDecoration textDecoration) {
        boolean z11;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawText");
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        if (shadow == null) {
            shadow = textLayoutResult.getLayoutInput().getStyle().getShadow();
        }
        if (textDecoration == null) {
            textDecoration = textLayoutResult.getLayoutInput().getStyle().getTextDecoration();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r12 = drawContext.m3403getSizeNHjbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        transform.translate(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12));
        clip(transform, textLayoutResult);
        Brush brush = textLayoutResult.getLayoutInput().getStyle().getBrush();
        boolean z12 = true;
        if (brush != null) {
            if (j11 == Color.Companion.m2955getUnspecified0d7_KjU()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                MultiParagraph multiParagraph = textLayoutResult.getMultiParagraph();
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                if (Float.isNaN(f11)) {
                    f11 = textLayoutResult.getLayoutInput().getStyle().getAlpha();
                }
                multiParagraph.paint(canvas, brush, f11, shadow, textDecoration);
                drawContext.getCanvas().restore();
                drawContext.m3404setSizeuvyYCjk(r12);
            }
        }
        MultiParagraph multiParagraph2 = textLayoutResult.getMultiParagraph();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        if (j11 == Color.Companion.m2955getUnspecified0d7_KjU()) {
            z12 = false;
        }
        if (!z12) {
            j11 = textLayoutResult.getLayoutInput().getStyle().m5056getColor0d7_KjU();
        }
        multiParagraph2.m4944paintRPmYEkk(canvas2, TextDrawStyleKt.m5384modulateDxMtmZc(j11, f11), shadow, textDecoration);
        drawContext.getCanvas().restore();
        drawContext.m3404setSizeuvyYCjk(r12);
    }

    /* renamed from: drawText-xIhfjkU$default  reason: not valid java name */
    public static /* synthetic */ void m5025drawTextxIhfjkU$default(DrawScope drawScope, TextLayoutResult textLayoutResult, long j11, long j12, float f11, Shadow shadow, TextDecoration textDecoration, int i11, Object obj) {
        long j13;
        long j14;
        float f12;
        Shadow shadow2;
        if ((i11 & 2) != 0) {
            j13 = Color.Companion.m2955getUnspecified0d7_KjU();
        } else {
            j13 = j11;
        }
        if ((i11 & 4) != 0) {
            j14 = Offset.Companion.m2692getZeroF1C5BW0();
        } else {
            j14 = j12;
        }
        if ((i11 & 8) != 0) {
            f12 = Float.NaN;
        } else {
            f12 = f11;
        }
        TextDecoration textDecoration2 = null;
        if ((i11 & 16) != 0) {
            shadow2 = null;
        } else {
            shadow2 = shadow;
        }
        if ((i11 & 32) == 0) {
            textDecoration2 = textDecoration;
        }
        m5024drawTextxIhfjkU(drawScope, textLayoutResult, j13, j14, f12, shadow2, textDecoration2);
    }
}
