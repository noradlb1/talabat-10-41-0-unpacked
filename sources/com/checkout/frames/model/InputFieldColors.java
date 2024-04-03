package com.checkout.frames.model;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001eJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b J\u0019\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\"J\u0019\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b$J\u0019\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&J\u0019\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b(J\u0019\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b*J\u0019\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b,J\u0019\u0010-\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010\u0010J\u0019\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b0J\u0019\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b2J\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u001c\u0010\t\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Lcom/checkout/frames/model/InputFieldColors;", "", "textColor", "Landroidx/compose/ui/graphics/Color;", "placeholderColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "containerColor", "cursorColor", "errorCursorColor", "cursorHandleColor", "cursorHighlightColor", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;JLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getCursorColor-QN2ZGVo", "()Landroidx/compose/ui/graphics/Color;", "getCursorHandleColor-QN2ZGVo", "getCursorHighlightColor-QN2ZGVo", "getDisabledIndicatorColor-QN2ZGVo", "getErrorCursorColor-QN2ZGVo", "getErrorIndicatorColor-QN2ZGVo", "getFocusedIndicatorColor-QN2ZGVo", "getPlaceholderColor-QN2ZGVo", "getTextColor-QN2ZGVo", "getUnfocusedIndicatorColor-QN2ZGVo", "component1", "component1-QN2ZGVo", "component10", "component10-QN2ZGVo", "component11", "component11-QN2ZGVo", "component2", "component2-QN2ZGVo", "component3", "component3-QN2ZGVo", "component4", "component4-QN2ZGVo", "component5", "component5-QN2ZGVo", "component6", "component6-QN2ZGVo", "component7", "component7-0d7_KjU", "component8", "component8-QN2ZGVo", "component9", "component9-QN2ZGVo", "copy", "copy-A0lRS-U", "(Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;JLandroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;Landroidx/compose/ui/graphics/Color;)Lcom/checkout/frames/model/InputFieldColors;", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputFieldColors {
    private final long containerColor;
    @Nullable
    private final Color cursorColor;
    @Nullable
    private final Color cursorHandleColor;
    @Nullable
    private final Color cursorHighlightColor;
    @Nullable
    private final Color disabledIndicatorColor;
    @Nullable
    private final Color errorCursorColor;
    @Nullable
    private final Color errorIndicatorColor;
    @Nullable
    private final Color focusedIndicatorColor;
    @Nullable
    private final Color placeholderColor;
    @Nullable
    private final Color textColor;
    @Nullable
    private final Color unfocusedIndicatorColor;

    private InputFieldColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, long j11, Color color7, Color color8, Color color9, Color color10) {
        this.textColor = color;
        this.placeholderColor = color2;
        this.focusedIndicatorColor = color3;
        this.unfocusedIndicatorColor = color4;
        this.disabledIndicatorColor = color5;
        this.errorIndicatorColor = color6;
        this.containerColor = j11;
        this.cursorColor = color7;
        this.errorCursorColor = color8;
        this.cursorHandleColor = color9;
        this.cursorHighlightColor = color10;
    }

    public /* synthetic */ InputFieldColors(Color color, Color color2, Color color3, Color color4, Color color5, Color color6, long j11, Color color7, Color color8, Color color9, Color color10, DefaultConstructorMarker defaultConstructorMarker) {
        this(color, color2, color3, color4, color5, color6, j11, color7, color8, color9, color10);
    }

    /* renamed from: copy-A0lRS-U$default  reason: not valid java name */
    public static /* synthetic */ InputFieldColors m9238copyA0lRSU$default(InputFieldColors inputFieldColors, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, long j11, Color color7, Color color8, Color color9, Color color10, int i11, Object obj) {
        InputFieldColors inputFieldColors2 = inputFieldColors;
        int i12 = i11;
        return inputFieldColors.m9250copyA0lRSU((i12 & 1) != 0 ? inputFieldColors2.textColor : color, (i12 & 2) != 0 ? inputFieldColors2.placeholderColor : color2, (i12 & 4) != 0 ? inputFieldColors2.focusedIndicatorColor : color3, (i12 & 8) != 0 ? inputFieldColors2.unfocusedIndicatorColor : color4, (i12 & 16) != 0 ? inputFieldColors2.disabledIndicatorColor : color5, (i12 & 32) != 0 ? inputFieldColors2.errorIndicatorColor : color6, (i12 & 64) != 0 ? inputFieldColors2.containerColor : j11, (i12 & 128) != 0 ? inputFieldColors2.cursorColor : color7, (i12 & 256) != 0 ? inputFieldColors2.errorCursorColor : color8, (i12 & 512) != 0 ? inputFieldColors2.cursorHandleColor : color9, (i12 & 1024) != 0 ? inputFieldColors2.cursorHighlightColor : color10);
    }

    @Nullable
    /* renamed from: component1-QN2ZGVo  reason: not valid java name */
    public final Color m9239component1QN2ZGVo() {
        return this.textColor;
    }

    @Nullable
    /* renamed from: component10-QN2ZGVo  reason: not valid java name */
    public final Color m9240component10QN2ZGVo() {
        return this.cursorHandleColor;
    }

    @Nullable
    /* renamed from: component11-QN2ZGVo  reason: not valid java name */
    public final Color m9241component11QN2ZGVo() {
        return this.cursorHighlightColor;
    }

    @Nullable
    /* renamed from: component2-QN2ZGVo  reason: not valid java name */
    public final Color m9242component2QN2ZGVo() {
        return this.placeholderColor;
    }

    @Nullable
    /* renamed from: component3-QN2ZGVo  reason: not valid java name */
    public final Color m9243component3QN2ZGVo() {
        return this.focusedIndicatorColor;
    }

    @Nullable
    /* renamed from: component4-QN2ZGVo  reason: not valid java name */
    public final Color m9244component4QN2ZGVo() {
        return this.unfocusedIndicatorColor;
    }

    @Nullable
    /* renamed from: component5-QN2ZGVo  reason: not valid java name */
    public final Color m9245component5QN2ZGVo() {
        return this.disabledIndicatorColor;
    }

    @Nullable
    /* renamed from: component6-QN2ZGVo  reason: not valid java name */
    public final Color m9246component6QN2ZGVo() {
        return this.errorIndicatorColor;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m9247component70d7_KjU() {
        return this.containerColor;
    }

    @Nullable
    /* renamed from: component8-QN2ZGVo  reason: not valid java name */
    public final Color m9248component8QN2ZGVo() {
        return this.cursorColor;
    }

    @Nullable
    /* renamed from: component9-QN2ZGVo  reason: not valid java name */
    public final Color m9249component9QN2ZGVo() {
        return this.errorCursorColor;
    }

    @NotNull
    /* renamed from: copy-A0lRS-U  reason: not valid java name */
    public final InputFieldColors m9250copyA0lRSU(@Nullable Color color, @Nullable Color color2, @Nullable Color color3, @Nullable Color color4, @Nullable Color color5, @Nullable Color color6, long j11, @Nullable Color color7, @Nullable Color color8, @Nullable Color color9, @Nullable Color color10) {
        return new InputFieldColors(color, color2, color3, color4, color5, color6, j11, color7, color8, color9, color10, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputFieldColors)) {
            return false;
        }
        InputFieldColors inputFieldColors = (InputFieldColors) obj;
        return Intrinsics.areEqual((Object) this.textColor, (Object) inputFieldColors.textColor) && Intrinsics.areEqual((Object) this.placeholderColor, (Object) inputFieldColors.placeholderColor) && Intrinsics.areEqual((Object) this.focusedIndicatorColor, (Object) inputFieldColors.focusedIndicatorColor) && Intrinsics.areEqual((Object) this.unfocusedIndicatorColor, (Object) inputFieldColors.unfocusedIndicatorColor) && Intrinsics.areEqual((Object) this.disabledIndicatorColor, (Object) inputFieldColors.disabledIndicatorColor) && Intrinsics.areEqual((Object) this.errorIndicatorColor, (Object) inputFieldColors.errorIndicatorColor) && Color.m2920equalsimpl0(this.containerColor, inputFieldColors.containerColor) && Intrinsics.areEqual((Object) this.cursorColor, (Object) inputFieldColors.cursorColor) && Intrinsics.areEqual((Object) this.errorCursorColor, (Object) inputFieldColors.errorCursorColor) && Intrinsics.areEqual((Object) this.cursorHandleColor, (Object) inputFieldColors.cursorHandleColor) && Intrinsics.areEqual((Object) this.cursorHighlightColor, (Object) inputFieldColors.cursorHighlightColor);
    }

    /* renamed from: getContainerColor-0d7_KjU  reason: not valid java name */
    public final long m9251getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    @Nullable
    /* renamed from: getCursorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9252getCursorColorQN2ZGVo() {
        return this.cursorColor;
    }

    @Nullable
    /* renamed from: getCursorHandleColor-QN2ZGVo  reason: not valid java name */
    public final Color m9253getCursorHandleColorQN2ZGVo() {
        return this.cursorHandleColor;
    }

    @Nullable
    /* renamed from: getCursorHighlightColor-QN2ZGVo  reason: not valid java name */
    public final Color m9254getCursorHighlightColorQN2ZGVo() {
        return this.cursorHighlightColor;
    }

    @Nullable
    /* renamed from: getDisabledIndicatorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9255getDisabledIndicatorColorQN2ZGVo() {
        return this.disabledIndicatorColor;
    }

    @Nullable
    /* renamed from: getErrorCursorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9256getErrorCursorColorQN2ZGVo() {
        return this.errorCursorColor;
    }

    @Nullable
    /* renamed from: getErrorIndicatorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9257getErrorIndicatorColorQN2ZGVo() {
        return this.errorIndicatorColor;
    }

    @Nullable
    /* renamed from: getFocusedIndicatorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9258getFocusedIndicatorColorQN2ZGVo() {
        return this.focusedIndicatorColor;
    }

    @Nullable
    /* renamed from: getPlaceholderColor-QN2ZGVo  reason: not valid java name */
    public final Color m9259getPlaceholderColorQN2ZGVo() {
        return this.placeholderColor;
    }

    @Nullable
    /* renamed from: getTextColor-QN2ZGVo  reason: not valid java name */
    public final Color m9260getTextColorQN2ZGVo() {
        return this.textColor;
    }

    @Nullable
    /* renamed from: getUnfocusedIndicatorColor-QN2ZGVo  reason: not valid java name */
    public final Color m9261getUnfocusedIndicatorColorQN2ZGVo() {
        return this.unfocusedIndicatorColor;
    }

    public int hashCode() {
        Color color = this.textColor;
        int i11 = 0;
        int r02 = (color == null ? 0 : Color.m2926hashCodeimpl(color.m2929unboximpl())) * 31;
        Color color2 = this.placeholderColor;
        int r03 = (r02 + (color2 == null ? 0 : Color.m2926hashCodeimpl(color2.m2929unboximpl()))) * 31;
        Color color3 = this.focusedIndicatorColor;
        int r04 = (r03 + (color3 == null ? 0 : Color.m2926hashCodeimpl(color3.m2929unboximpl()))) * 31;
        Color color4 = this.unfocusedIndicatorColor;
        int r05 = (r04 + (color4 == null ? 0 : Color.m2926hashCodeimpl(color4.m2929unboximpl()))) * 31;
        Color color5 = this.disabledIndicatorColor;
        int r06 = (r05 + (color5 == null ? 0 : Color.m2926hashCodeimpl(color5.m2929unboximpl()))) * 31;
        Color color6 = this.errorIndicatorColor;
        int r07 = (((r06 + (color6 == null ? 0 : Color.m2926hashCodeimpl(color6.m2929unboximpl()))) * 31) + Color.m2926hashCodeimpl(this.containerColor)) * 31;
        Color color7 = this.cursorColor;
        int r08 = (r07 + (color7 == null ? 0 : Color.m2926hashCodeimpl(color7.m2929unboximpl()))) * 31;
        Color color8 = this.errorCursorColor;
        int r09 = (r08 + (color8 == null ? 0 : Color.m2926hashCodeimpl(color8.m2929unboximpl()))) * 31;
        Color color9 = this.cursorHandleColor;
        int r010 = (r09 + (color9 == null ? 0 : Color.m2926hashCodeimpl(color9.m2929unboximpl()))) * 31;
        Color color10 = this.cursorHighlightColor;
        if (color10 != null) {
            i11 = Color.m2926hashCodeimpl(color10.m2929unboximpl());
        }
        return r010 + i11;
    }

    @NotNull
    public String toString() {
        Color color = this.textColor;
        Color color2 = this.placeholderColor;
        Color color3 = this.focusedIndicatorColor;
        Color color4 = this.unfocusedIndicatorColor;
        Color color5 = this.disabledIndicatorColor;
        Color color6 = this.errorIndicatorColor;
        String r62 = Color.m2927toStringimpl(this.containerColor);
        Color color7 = this.cursorColor;
        Color color8 = this.errorCursorColor;
        Color color9 = this.cursorHandleColor;
        Color color10 = this.cursorHighlightColor;
        return "InputFieldColors(textColor=" + color + ", placeholderColor=" + color2 + ", focusedIndicatorColor=" + color3 + ", unfocusedIndicatorColor=" + color4 + ", disabledIndicatorColor=" + color5 + ", errorIndicatorColor=" + color6 + ", containerColor=" + r62 + ", cursorColor=" + color7 + ", errorCursorColor=" + color8 + ", cursorHandleColor=" + color9 + ", cursorHighlightColor=" + color10 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputFieldColors(androidx.compose.ui.graphics.Color r14, androidx.compose.ui.graphics.Color r15, androidx.compose.ui.graphics.Color r16, androidx.compose.ui.graphics.Color r17, androidx.compose.ui.graphics.Color r18, androidx.compose.ui.graphics.Color r19, long r20, androidx.compose.ui.graphics.Color r22, androidx.compose.ui.graphics.Color r23, androidx.compose.ui.graphics.Color r24, androidx.compose.ui.graphics.Color r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003c
            androidx.compose.ui.graphics.Color$Companion r8 = androidx.compose.ui.graphics.Color.Companion
            long r8 = r8.m2954getTransparent0d7_KjU()
            goto L_0x003e
        L_0x003c:
            r8 = r20
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0044
            r10 = r2
            goto L_0x0046
        L_0x0044:
            r10 = r22
        L_0x0046:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004c
            r11 = r2
            goto L_0x004e
        L_0x004c:
            r11 = r23
        L_0x004e:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0054
            r12 = r2
            goto L_0x0056
        L_0x0054:
            r12 = r24
        L_0x0056:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r25
        L_0x005d:
            r0 = 0
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r27 = r0
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.model.InputFieldColors.<init>(androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, long, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, androidx.compose.ui.graphics.Color, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
