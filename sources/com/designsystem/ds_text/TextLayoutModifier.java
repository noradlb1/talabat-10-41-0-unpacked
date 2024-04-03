package com.designsystem.ds_text;

import android.content.Context;
import android.graphics.Paint;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0014\u0010\u0013\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u001c\u0010\u001b\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$J\u001c\u0010%\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u001c\u0010&\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Lcom/designsystem/ds_text/TextLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "context", "Landroid/content/Context;", "style", "Landroidx/compose/ui/text/TextStyle;", "offset", "", "(Landroid/content/Context;Landroidx/compose/ui/text/TextStyle;F)V", "getContext", "()Landroid/content/Context;", "getOffset", "()F", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "ceilToLineHeight", "", "Landroidx/compose/ui/unit/Density;", "value", "lineCount", "placeable", "Landroidx/compose/ui/layout/Placeable;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class TextLayoutModifier implements LayoutModifier {
    @NotNull
    private final Context context;
    private final float offset;
    @NotNull
    private final TextStyle style;

    public TextLayoutModifier(@NotNull Context context2, @NotNull TextStyle textStyle, float f11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(textStyle, "style");
        this.context = context2;
        this.style = textStyle;
        this.offset = f11;
    }

    private final int ceilToLineHeight(Density density, int i11) {
        float r32 = density.m5446toPxR2X_6o(this.style.m5061getLineHeightXSAIIZE());
        return MathKt__MathJVMKt.roundToInt(((float) Math.ceil((double) (((float) i11) / r32))) * r32);
    }

    private final int lineCount(Density density, Placeable placeable) {
        return MathKt__MathJVMKt.roundToInt(((float) (placeable.get(AlignmentLineKt.getLastBaseline()) - placeable.get(AlignmentLineKt.getFirstBaseline()))) / density.m5446toPxR2X_6o(this.style.m5061getLineHeightXSAIIZE())) + 1;
    }

    public boolean all(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(@NotNull Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r11, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldIn(this, r11, function2);
    }

    public <R> R foldOut(R r11, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldOut(this, r11, function2);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final float getOffset() {
        return this.offset;
    }

    @NotNull
    public final TextStyle getStyle() {
        return this.style;
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return ceilToLineHeight(intrinsicMeasureScope, intrinsicMeasurable.maxIntrinsicHeight(i11));
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.maxIntrinsicWidth(i11);
    }

    @NotNull
    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m8636measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long r02 = this.style.m5061getLineHeightXSAIIZE();
        Placeable r11 = measurable.m4508measureBRTryo0(j11);
        int roundToInt = MathKt__MathJVMKt.roundToInt(measureScope.m5446toPxR2X_6o(r02) * ((float) lineCount(measureScope, r11)));
        Paint.FontMetrics access$fontMetrics = DSTextKt.fontMetrics(measureScope, this.context, this.style);
        float f11 = access$fontMetrics.descent;
        return MeasureScope.CC.p(measureScope, r11.getWidth(), roundToInt, (Map) null, new TextLayoutModifier$measure$1(r11, (int) measureScope.m5447toPx0680j_4(Dp.m5478constructorimpl((float) Math.floor((double) (measureScope.m5443toDpu2uoSUM((measureScope.m5446toPxR2X_6o(r02) - f11) + access$fontMetrics.ascent) / 2.0f)))), access$fontMetrics.ascent - access$fontMetrics.top), 4, (Object) null);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return ceilToLineHeight(intrinsicMeasureScope, intrinsicMeasurable.minIntrinsicHeight(i11));
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.minIntrinsicWidth(i11);
    }

    @NotNull
    public Modifier then(@NotNull Modifier modifier) {
        return LayoutModifier.DefaultImpls.then(this, modifier);
    }
}
