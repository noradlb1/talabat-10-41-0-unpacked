package com.designsystem.ds_stepper;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0011J\u0019\u0010\u001b\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u000eJ\u0019\u0010\u001d\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u000eJ\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u0019\u0010 \u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b!\u0010\u000eJ\u0019\u0010\"\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b#\u0010\u000eJ\u0019\u0010$\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b%\u0010\u000eJ\\\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001c\u0010\u000b\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u001c\u0010\u0006\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u001c\u0010\t\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u001c\u0010\n\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Lcom/designsystem/ds_stepper/DSStepperStyle;", "", "cornerRadius", "Landroidx/compose/ui/unit/Dp;", "interactiveColor", "Landroidx/compose/ui/graphics/Color;", "interactiveDisabledColor", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "textColor", "textColorAlternative", "backgroundColor", "(FJJLandroidx/compose/ui/text/TextStyle;JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getCornerRadius-D9Ej5fM", "()F", "F", "getInteractiveColor-0d7_KjU", "getInteractiveDisabledColor-0d7_KjU", "getTextColor-0d7_KjU", "getTextColorAlternative-0d7_KjU", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "component1", "component1-D9Ej5fM", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "copy", "copy-O4i-S_M", "(FJJLandroidx/compose/ui/text/TextStyle;JJJ)Lcom/designsystem/ds_stepper/DSStepperStyle;", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSStepperStyle {
    private final long backgroundColor;
    private final float cornerRadius;
    private final long interactiveColor;
    private final long interactiveDisabledColor;
    private final long textColor;
    private final long textColorAlternative;
    @NotNull
    private final TextStyle textStyle;

    private DSStepperStyle(float f11, long j11, long j12, TextStyle textStyle2, long j13, long j14, long j15) {
        this.cornerRadius = f11;
        this.interactiveColor = j11;
        this.interactiveDisabledColor = j12;
        this.textStyle = textStyle2;
        this.textColor = j13;
        this.textColorAlternative = j14;
        this.backgroundColor = j15;
    }

    public /* synthetic */ DSStepperStyle(float f11, long j11, long j12, TextStyle textStyle2, long j13, long j14, long j15, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, j11, j12, textStyle2, j13, j14, j15);
    }

    /* renamed from: copy-O4i-S_M$default  reason: not valid java name */
    public static /* synthetic */ DSStepperStyle m8579copyO4iS_M$default(DSStepperStyle dSStepperStyle, float f11, long j11, long j12, TextStyle textStyle2, long j13, long j14, long j15, int i11, Object obj) {
        DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        return dSStepperStyle.m8586copyO4iS_M((i11 & 1) != 0 ? dSStepperStyle2.cornerRadius : f11, (i11 & 2) != 0 ? dSStepperStyle2.interactiveColor : j11, (i11 & 4) != 0 ? dSStepperStyle2.interactiveDisabledColor : j12, (i11 & 8) != 0 ? dSStepperStyle2.textStyle : textStyle2, (i11 & 16) != 0 ? dSStepperStyle2.textColor : j13, (i11 & 32) != 0 ? dSStepperStyle2.textColorAlternative : j14, (i11 & 64) != 0 ? dSStepperStyle2.backgroundColor : j15);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m8580component1D9Ej5fM() {
        return this.cornerRadius;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m8581component20d7_KjU() {
        return this.interactiveColor;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m8582component30d7_KjU() {
        return this.interactiveDisabledColor;
    }

    @NotNull
    public final TextStyle component4() {
        return this.textStyle;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m8583component50d7_KjU() {
        return this.textColor;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m8584component60d7_KjU() {
        return this.textColorAlternative;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m8585component70d7_KjU() {
        return this.backgroundColor;
    }

    @NotNull
    /* renamed from: copy-O4i-S_M  reason: not valid java name */
    public final DSStepperStyle m8586copyO4iS_M(float f11, long j11, long j12, @NotNull TextStyle textStyle2, long j13, long j14, long j15) {
        TextStyle textStyle3 = textStyle2;
        Intrinsics.checkNotNullParameter(textStyle3, "textStyle");
        return new DSStepperStyle(f11, j11, j12, textStyle3, j13, j14, j15, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSStepperStyle)) {
            return false;
        }
        DSStepperStyle dSStepperStyle = (DSStepperStyle) obj;
        return Dp.m5483equalsimpl0(this.cornerRadius, dSStepperStyle.cornerRadius) && Color.m2920equalsimpl0(this.interactiveColor, dSStepperStyle.interactiveColor) && Color.m2920equalsimpl0(this.interactiveDisabledColor, dSStepperStyle.interactiveDisabledColor) && Intrinsics.areEqual((Object) this.textStyle, (Object) dSStepperStyle.textStyle) && Color.m2920equalsimpl0(this.textColor, dSStepperStyle.textColor) && Color.m2920equalsimpl0(this.textColorAlternative, dSStepperStyle.textColorAlternative) && Color.m2920equalsimpl0(this.backgroundColor, dSStepperStyle.backgroundColor);
    }

    /* renamed from: getBackgroundColor-0d7_KjU  reason: not valid java name */
    public final long m8587getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* renamed from: getCornerRadius-D9Ej5fM  reason: not valid java name */
    public final float m8588getCornerRadiusD9Ej5fM() {
        return this.cornerRadius;
    }

    /* renamed from: getInteractiveColor-0d7_KjU  reason: not valid java name */
    public final long m8589getInteractiveColor0d7_KjU() {
        return this.interactiveColor;
    }

    /* renamed from: getInteractiveDisabledColor-0d7_KjU  reason: not valid java name */
    public final long m8590getInteractiveDisabledColor0d7_KjU() {
        return this.interactiveDisabledColor;
    }

    /* renamed from: getTextColor-0d7_KjU  reason: not valid java name */
    public final long m8591getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* renamed from: getTextColorAlternative-0d7_KjU  reason: not valid java name */
    public final long m8592getTextColorAlternative0d7_KjU() {
        return this.textColorAlternative;
    }

    @NotNull
    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    public int hashCode() {
        return (((((((((((Dp.m5484hashCodeimpl(this.cornerRadius) * 31) + Color.m2926hashCodeimpl(this.interactiveColor)) * 31) + Color.m2926hashCodeimpl(this.interactiveDisabledColor)) * 31) + this.textStyle.hashCode()) * 31) + Color.m2926hashCodeimpl(this.textColor)) * 31) + Color.m2926hashCodeimpl(this.textColorAlternative)) * 31) + Color.m2926hashCodeimpl(this.backgroundColor);
    }

    @NotNull
    public String toString() {
        return "DSStepperStyle(cornerRadius=" + Dp.m5489toStringimpl(this.cornerRadius) + ", interactiveColor=" + Color.m2927toStringimpl(this.interactiveColor) + ", interactiveDisabledColor=" + Color.m2927toStringimpl(this.interactiveDisabledColor) + ", textStyle=" + this.textStyle + ", textColor=" + Color.m2927toStringimpl(this.textColor) + ", textColorAlternative=" + Color.m2927toStringimpl(this.textColorAlternative) + ", backgroundColor=" + Color.m2927toStringimpl(this.backgroundColor) + ')';
    }
}
