package com.checkout.frames.style.theme.colors;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/theme/colors/TextColors;", "", "titleColor", "", "subTitleColor", "infoColor", "errorColor", "(JJJJ)V", "getErrorColor", "()J", "getInfoColor", "getSubTitleColor", "getTitleColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextColors {
    public static final int $stable = 0;
    private final long errorColor;
    private final long infoColor;
    private final long subTitleColor;
    private final long titleColor;

    @JvmOverloads
    public TextColors() {
        this(0, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextColors(long j11) {
        this(j11, 0, 0, 0, 14, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextColors(long j11, long j12) {
        this(j11, j12, 0, 0, 12, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextColors(long j11, long j12, long j13) {
        this(j11, j12, j13, 0, 8, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public TextColors(long j11, long j12, long j13, long j14) {
        this.titleColor = j11;
        this.subTitleColor = j12;
        this.infoColor = j13;
        this.errorColor = j14;
    }

    public static /* synthetic */ TextColors copy$default(TextColors textColors, long j11, long j12, long j13, long j14, int i11, Object obj) {
        TextColors textColors2 = textColors;
        return textColors.copy((i11 & 1) != 0 ? textColors2.titleColor : j11, (i11 & 2) != 0 ? textColors2.subTitleColor : j12, (i11 & 4) != 0 ? textColors2.infoColor : j13, (i11 & 8) != 0 ? textColors2.errorColor : j14);
    }

    public final long component1() {
        return this.titleColor;
    }

    public final long component2() {
        return this.subTitleColor;
    }

    public final long component3() {
        return this.infoColor;
    }

    public final long component4() {
        return this.errorColor;
    }

    @NotNull
    public final TextColors copy(long j11, long j12, long j13, long j14) {
        return new TextColors(j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextColors)) {
            return false;
        }
        TextColors textColors = (TextColors) obj;
        return this.titleColor == textColors.titleColor && this.subTitleColor == textColors.subTitleColor && this.infoColor == textColors.infoColor && this.errorColor == textColors.errorColor;
    }

    public final long getErrorColor() {
        return this.errorColor;
    }

    public final long getInfoColor() {
        return this.infoColor;
    }

    public final long getSubTitleColor() {
        return this.subTitleColor;
    }

    public final long getTitleColor() {
        return this.titleColor;
    }

    public int hashCode() {
        return (((((a.a(this.titleColor) * 31) + a.a(this.subTitleColor)) * 31) + a.a(this.infoColor)) * 31) + a.a(this.errorColor);
    }

    @NotNull
    public String toString() {
        long j11 = this.titleColor;
        long j12 = this.subTitleColor;
        long j13 = this.infoColor;
        long j14 = this.errorColor;
        return "TextColors(titleColor=" + j11 + ", subTitleColor=" + j12 + ", infoColor=" + j13 + ", errorColor=" + j14 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextColors(long r10, long r12, long r14, long r16, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18 & 1
            r1 = 4278190080(0xff000000, double:2.113706745E-314)
            if (r0 == 0) goto L_0x000b
            r3 = r1
            goto L_0x000c
        L_0x000b:
            r3 = r10
        L_0x000c:
            r0 = r18 & 2
            if (r0 == 0) goto L_0x0012
            r5 = r1
            goto L_0x0013
        L_0x0012:
            r5 = r12
        L_0x0013:
            r0 = r18 & 4
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r1 = r14
        L_0x0019:
            r0 = r18 & 8
            if (r0 == 0) goto L_0x0023
            r7 = 4294901760(0xffff0000, double:2.121963412E-314)
            goto L_0x0025
        L_0x0023:
            r7 = r16
        L_0x0025:
            r10 = r9
            r11 = r3
            r13 = r5
            r15 = r1
            r17 = r7
            r10.<init>(r11, r13, r15, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.theme.colors.TextColors.<init>(long, long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
