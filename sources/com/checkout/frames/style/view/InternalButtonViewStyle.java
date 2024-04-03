package com.checkout.frames.style.view;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u00101\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010!J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00106\u001a\u00020\u0014HÆ\u0003J\t\u00107\u001a\u00020\u0016HÆ\u0003J\u0019\u00108\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010!J\u0019\u0010:\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010!J\u0019\u0010<\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010!J\u0019\u0010>\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010!J\u0019\u0010@\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010\u001bJ\u0019\u0010B\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010\u001bJ\u0019\u0010D\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010\u001bJ\u0019\u0010F\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010\u001bJ¤\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020QHÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u000b\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001c\u0010\n\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u001c\u0010\f\u001a\u00020\tø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR\u001c\u0010\u0007\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R\u001c\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u001c\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b'\u0010!R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b,\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u00100\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006R"}, d2 = {"Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "containerColor", "Landroidx/compose/ui/graphics/Color;", "disabledContainerColor", "contentColor", "disabledContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "textStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "(FFFFFJJJJLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Lcom/checkout/frames/style/view/TextLabelViewStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorder", "()Landroidx/compose/foundation/BorderStroke;", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getDefaultElevation-D9Ej5fM", "()F", "F", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getDisabledElevation-D9Ej5fM", "getFocusedElevation-D9Ej5fM", "getHoveredElevation-D9Ej5fM", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "getPressedElevation-D9Ej5fM", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "getTextStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "component1", "component1-D9Ej5fM", "component10", "component11", "component12", "component13", "component14", "component2", "component2-D9Ej5fM", "component3", "component3-D9Ej5fM", "component4", "component4-D9Ej5fM", "component5", "component5-D9Ej5fM", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", "component9", "component9-0d7_KjU", "copy", "copy-TIHjrxM", "(FFFFFJJJJLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Lcom/checkout/frames/style/view/TextLabelViewStyle;)Lcom/checkout/frames/style/view/InternalButtonViewStyle;", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InternalButtonViewStyle {
    @Nullable
    private final BorderStroke border;
    private final long containerColor;
    private final long contentColor;
    @NotNull
    private final PaddingValues contentPadding;
    private final float defaultElevation;
    private final long disabledContainerColor;
    private final long disabledContentColor;
    private final float disabledElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    @NotNull
    private Modifier modifier;
    private final float pressedElevation;
    @NotNull
    private final Shape shape;
    @NotNull
    private final TextLabelViewStyle textStyle;

    private InternalButtonViewStyle(float f11, float f12, float f13, float f14, float f15, long j11, long j12, long j13, long j14, Modifier modifier2, Shape shape2, BorderStroke borderStroke, PaddingValues paddingValues, TextLabelViewStyle textLabelViewStyle) {
        this.defaultElevation = f11;
        this.pressedElevation = f12;
        this.focusedElevation = f13;
        this.hoveredElevation = f14;
        this.disabledElevation = f15;
        this.containerColor = j11;
        this.disabledContainerColor = j12;
        this.contentColor = j13;
        this.disabledContentColor = j14;
        this.modifier = modifier2;
        this.shape = shape2;
        this.border = borderStroke;
        this.contentPadding = paddingValues;
        this.textStyle = textLabelViewStyle;
    }

    public /* synthetic */ InternalButtonViewStyle(float f11, float f12, float f13, float f14, float f15, long j11, long j12, long j13, long j14, Modifier modifier2, Shape shape2, BorderStroke borderStroke, PaddingValues paddingValues, TextLabelViewStyle textLabelViewStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14, f15, j11, j12, j13, j14, modifier2, shape2, borderStroke, paddingValues, textLabelViewStyle);
    }

    /* renamed from: copy-TIHjrxM$default  reason: not valid java name */
    public static /* synthetic */ InternalButtonViewStyle m9280copyTIHjrxM$default(InternalButtonViewStyle internalButtonViewStyle, float f11, float f12, float f13, float f14, float f15, long j11, long j12, long j13, long j14, Modifier modifier2, Shape shape2, BorderStroke borderStroke, PaddingValues paddingValues, TextLabelViewStyle textLabelViewStyle, int i11, Object obj) {
        InternalButtonViewStyle internalButtonViewStyle2 = internalButtonViewStyle;
        int i12 = i11;
        return internalButtonViewStyle.m9290copyTIHjrxM((i12 & 1) != 0 ? internalButtonViewStyle2.defaultElevation : f11, (i12 & 2) != 0 ? internalButtonViewStyle2.pressedElevation : f12, (i12 & 4) != 0 ? internalButtonViewStyle2.focusedElevation : f13, (i12 & 8) != 0 ? internalButtonViewStyle2.hoveredElevation : f14, (i12 & 16) != 0 ? internalButtonViewStyle2.disabledElevation : f15, (i12 & 32) != 0 ? internalButtonViewStyle2.containerColor : j11, (i12 & 64) != 0 ? internalButtonViewStyle2.disabledContainerColor : j12, (i12 & 128) != 0 ? internalButtonViewStyle2.contentColor : j13, (i12 & 256) != 0 ? internalButtonViewStyle2.disabledContentColor : j14, (i12 & 512) != 0 ? internalButtonViewStyle2.modifier : modifier2, (i12 & 1024) != 0 ? internalButtonViewStyle2.shape : shape2, (i12 & 2048) != 0 ? internalButtonViewStyle2.border : borderStroke, (i12 & 4096) != 0 ? internalButtonViewStyle2.contentPadding : paddingValues, (i12 & 8192) != 0 ? internalButtonViewStyle2.textStyle : textLabelViewStyle);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m9281component1D9Ej5fM() {
        return this.defaultElevation;
    }

    @NotNull
    public final Modifier component10() {
        return this.modifier;
    }

    @NotNull
    public final Shape component11() {
        return this.shape;
    }

    @Nullable
    public final BorderStroke component12() {
        return this.border;
    }

    @NotNull
    public final PaddingValues component13() {
        return this.contentPadding;
    }

    @NotNull
    public final TextLabelViewStyle component14() {
        return this.textStyle;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m9282component2D9Ej5fM() {
        return this.pressedElevation;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m9283component3D9Ej5fM() {
        return this.focusedElevation;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    public final float m9284component4D9Ej5fM() {
        return this.hoveredElevation;
    }

    /* renamed from: component5-D9Ej5fM  reason: not valid java name */
    public final float m9285component5D9Ej5fM() {
        return this.disabledElevation;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m9286component60d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m9287component70d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: component8-0d7_KjU  reason: not valid java name */
    public final long m9288component80d7_KjU() {
        return this.contentColor;
    }

    /* renamed from: component9-0d7_KjU  reason: not valid java name */
    public final long m9289component90d7_KjU() {
        return this.disabledContentColor;
    }

    @NotNull
    /* renamed from: copy-TIHjrxM  reason: not valid java name */
    public final InternalButtonViewStyle m9290copyTIHjrxM(float f11, float f12, float f13, float f14, float f15, long j11, long j12, long j13, long j14, @NotNull Modifier modifier2, @NotNull Shape shape2, @Nullable BorderStroke borderStroke, @NotNull PaddingValues paddingValues, @NotNull TextLabelViewStyle textLabelViewStyle) {
        float f16 = f11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(paddingValues, "contentPadding");
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "textStyle");
        return new InternalButtonViewStyle(f11, f12, f13, f14, f15, j11, j12, j13, j14, modifier2, shape2, borderStroke, paddingValues, textLabelViewStyle, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalButtonViewStyle)) {
            return false;
        }
        InternalButtonViewStyle internalButtonViewStyle = (InternalButtonViewStyle) obj;
        return Dp.m5483equalsimpl0(this.defaultElevation, internalButtonViewStyle.defaultElevation) && Dp.m5483equalsimpl0(this.pressedElevation, internalButtonViewStyle.pressedElevation) && Dp.m5483equalsimpl0(this.focusedElevation, internalButtonViewStyle.focusedElevation) && Dp.m5483equalsimpl0(this.hoveredElevation, internalButtonViewStyle.hoveredElevation) && Dp.m5483equalsimpl0(this.disabledElevation, internalButtonViewStyle.disabledElevation) && Color.m2920equalsimpl0(this.containerColor, internalButtonViewStyle.containerColor) && Color.m2920equalsimpl0(this.disabledContainerColor, internalButtonViewStyle.disabledContainerColor) && Color.m2920equalsimpl0(this.contentColor, internalButtonViewStyle.contentColor) && Color.m2920equalsimpl0(this.disabledContentColor, internalButtonViewStyle.disabledContentColor) && Intrinsics.areEqual((Object) this.modifier, (Object) internalButtonViewStyle.modifier) && Intrinsics.areEqual((Object) this.shape, (Object) internalButtonViewStyle.shape) && Intrinsics.areEqual((Object) this.border, (Object) internalButtonViewStyle.border) && Intrinsics.areEqual((Object) this.contentPadding, (Object) internalButtonViewStyle.contentPadding) && Intrinsics.areEqual((Object) this.textStyle, (Object) internalButtonViewStyle.textStyle);
    }

    @Nullable
    public final BorderStroke getBorder() {
        return this.border;
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m9291getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU  reason: not valid java name */
    public final long m9292getContentColor0d7_KjU() {
        return this.contentColor;
    }

    @NotNull
    public final PaddingValues getContentPadding() {
        return this.contentPadding;
    }

    /* renamed from: getDefaultElevation-D9Ej5fM  reason: not valid java name */
    public final float m9293getDefaultElevationD9Ej5fM() {
        return this.defaultElevation;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU  reason: not valid java name */
    public final long m9294getDisabledContainerColor0d7_KjU() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledContentColor-0d7_KjU  reason: not valid java name */
    public final long m9295getDisabledContentColor0d7_KjU() {
        return this.disabledContentColor;
    }

    /* renamed from: getDisabledElevation-D9Ej5fM  reason: not valid java name */
    public final float m9296getDisabledElevationD9Ej5fM() {
        return this.disabledElevation;
    }

    /* renamed from: getFocusedElevation-D9Ej5fM  reason: not valid java name */
    public final float m9297getFocusedElevationD9Ej5fM() {
        return this.focusedElevation;
    }

    /* renamed from: getHoveredElevation-D9Ej5fM  reason: not valid java name */
    public final float m9298getHoveredElevationD9Ej5fM() {
        return this.hoveredElevation;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    /* renamed from: getPressedElevation-D9Ej5fM  reason: not valid java name */
    public final float m9299getPressedElevationD9Ej5fM() {
        return this.pressedElevation;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    @NotNull
    public final TextLabelViewStyle getTextStyle() {
        return this.textStyle;
    }

    public int hashCode() {
        int r02 = ((((((((((((((((((((Dp.m5484hashCodeimpl(this.defaultElevation) * 31) + Dp.m5484hashCodeimpl(this.pressedElevation)) * 31) + Dp.m5484hashCodeimpl(this.focusedElevation)) * 31) + Dp.m5484hashCodeimpl(this.hoveredElevation)) * 31) + Dp.m5484hashCodeimpl(this.disabledElevation)) * 31) + Color.m2926hashCodeimpl(this.containerColor)) * 31) + Color.m2926hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m2926hashCodeimpl(this.contentColor)) * 31) + Color.m2926hashCodeimpl(this.disabledContentColor)) * 31) + this.modifier.hashCode()) * 31) + this.shape.hashCode()) * 31;
        BorderStroke borderStroke = this.border;
        return ((((r02 + (borderStroke == null ? 0 : borderStroke.hashCode())) * 31) + this.contentPadding.hashCode()) * 31) + this.textStyle.hashCode();
    }

    public final void setModifier(@NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "<set-?>");
        this.modifier = modifier2;
    }

    @NotNull
    public String toString() {
        String r12 = Dp.m5489toStringimpl(this.defaultElevation);
        String r22 = Dp.m5489toStringimpl(this.pressedElevation);
        String r32 = Dp.m5489toStringimpl(this.focusedElevation);
        String r42 = Dp.m5489toStringimpl(this.hoveredElevation);
        String r52 = Dp.m5489toStringimpl(this.disabledElevation);
        String r62 = Color.m2927toStringimpl(this.containerColor);
        String r72 = Color.m2927toStringimpl(this.disabledContainerColor);
        String r82 = Color.m2927toStringimpl(this.contentColor);
        String r92 = Color.m2927toStringimpl(this.disabledContentColor);
        Modifier modifier2 = this.modifier;
        Shape shape2 = this.shape;
        BorderStroke borderStroke = this.border;
        PaddingValues paddingValues = this.contentPadding;
        TextLabelViewStyle textLabelViewStyle = this.textStyle;
        return "InternalButtonViewStyle(defaultElevation=" + r12 + ", pressedElevation=" + r22 + ", focusedElevation=" + r32 + ", hoveredElevation=" + r42 + ", disabledElevation=" + r52 + ", containerColor=" + r62 + ", disabledContainerColor=" + r72 + ", contentColor=" + r82 + ", disabledContentColor=" + r92 + ", modifier=" + modifier2 + ", shape=" + shape2 + ", border=" + borderStroke + ", contentPadding=" + paddingValues + ", textStyle=" + textLabelViewStyle + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InternalButtonViewStyle(float r24, float r25, float r26, float r27, float r28, long r29, long r31, long r33, long r35, androidx.compose.ui.Modifier r37, androidx.compose.ui.graphics.Shape r38, androidx.compose.foundation.BorderStroke r39, androidx.compose.foundation.layout.PaddingValues r40, com.checkout.frames.style.view.TextLabelViewStyle r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r23 = this;
            r0 = r42
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000e
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r4 = r1
            goto L_0x0010
        L_0x000e:
            r4 = r24
        L_0x0010:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x001b
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r5 = r1
            goto L_0x001d
        L_0x001b:
            r5 = r25
        L_0x001d:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0028
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r6 = r1
            goto L_0x002a
        L_0x0028:
            r6 = r26
        L_0x002a:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0035
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r7 = r1
            goto L_0x0037
        L_0x0035:
            r7 = r27
        L_0x0037:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0042
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r8 = r1
            goto L_0x0044
        L_0x0042:
            r8 = r28
        L_0x0044:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0050
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2954getTransparent0d7_KjU()
            r9 = r1
            goto L_0x0052
        L_0x0050:
            r9 = r29
        L_0x0052:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x005e
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2954getTransparent0d7_KjU()
            r11 = r1
            goto L_0x0060
        L_0x005e:
            r11 = r31
        L_0x0060:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x006c
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2945getBlack0d7_KjU()
            r13 = r1
            goto L_0x006e
        L_0x006c:
            r13 = r33
        L_0x006e:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x007a
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2949getGray0d7_KjU()
            r15 = r1
            goto L_0x007c
        L_0x007a:
            r15 = r35
        L_0x007c:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0085
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r17 = r1
            goto L_0x0087
        L_0x0085:
            r17 = r37
        L_0x0087:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x008f
            r1 = 0
            r19 = r1
            goto L_0x0091
        L_0x008f:
            r19 = r39
        L_0x0091:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x009e
            androidx.compose.material3.ButtonDefaults r0 = androidx.compose.material3.ButtonDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r0 = r0.getContentPadding()
            r20 = r0
            goto L_0x00a0
        L_0x009e:
            r20 = r40
        L_0x00a0:
            r22 = 0
            r3 = r23
            r18 = r38
            r21 = r41
            r3.<init>(r4, r5, r6, r7, r8, r9, r11, r13, r15, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.view.InternalButtonViewStyle.<init>(float, float, float, float, float, long, long, long, long, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, com.checkout.frames.style.view.TextLabelViewStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
