package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/component/base/CursorStyle;", "", "cursorColor", "", "(J)V", "errorCursorColor", "cursorHandleColor", "cursorHighlightColor", "(JJJJ)V", "getCursorColor", "()J", "getCursorHandleColor", "getCursorHighlightColor", "getErrorCursorColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CursorStyle {
    public static final int $stable = 0;
    private final long cursorColor;
    private final long cursorHandleColor;
    private final long cursorHighlightColor;
    private final long errorCursorColor;

    public CursorStyle(long j11, long j12, long j13, long j14) {
        this.cursorColor = j11;
        this.errorCursorColor = j12;
        this.cursorHandleColor = j13;
        this.cursorHighlightColor = j14;
    }

    public static /* synthetic */ CursorStyle copy$default(CursorStyle cursorStyle, long j11, long j12, long j13, long j14, int i11, Object obj) {
        CursorStyle cursorStyle2 = cursorStyle;
        return cursorStyle.copy((i11 & 1) != 0 ? cursorStyle2.cursorColor : j11, (i11 & 2) != 0 ? cursorStyle2.errorCursorColor : j12, (i11 & 4) != 0 ? cursorStyle2.cursorHandleColor : j13, (i11 & 8) != 0 ? cursorStyle2.cursorHighlightColor : j14);
    }

    public final long component1() {
        return this.cursorColor;
    }

    public final long component2() {
        return this.errorCursorColor;
    }

    public final long component3() {
        return this.cursorHandleColor;
    }

    public final long component4() {
        return this.cursorHighlightColor;
    }

    @NotNull
    public final CursorStyle copy(long j11, long j12, long j13, long j14) {
        return new CursorStyle(j11, j12, j13, j14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CursorStyle)) {
            return false;
        }
        CursorStyle cursorStyle = (CursorStyle) obj;
        return this.cursorColor == cursorStyle.cursorColor && this.errorCursorColor == cursorStyle.errorCursorColor && this.cursorHandleColor == cursorStyle.cursorHandleColor && this.cursorHighlightColor == cursorStyle.cursorHighlightColor;
    }

    public final long getCursorColor() {
        return this.cursorColor;
    }

    public final long getCursorHandleColor() {
        return this.cursorHandleColor;
    }

    public final long getCursorHighlightColor() {
        return this.cursorHighlightColor;
    }

    public final long getErrorCursorColor() {
        return this.errorCursorColor;
    }

    public int hashCode() {
        return (((((a.a(this.cursorColor) * 31) + a.a(this.errorCursorColor)) * 31) + a.a(this.cursorHandleColor)) * 31) + a.a(this.cursorHighlightColor);
    }

    @NotNull
    public String toString() {
        long j11 = this.cursorColor;
        long j12 = this.errorCursorColor;
        long j13 = this.cursorHandleColor;
        long j14 = this.cursorHighlightColor;
        return "CursorStyle(cursorColor=" + j11 + ", errorCursorColor=" + j12 + ", cursorHandleColor=" + j13 + ", cursorHighlightColor=" + j14 + ")";
    }

    public CursorStyle(long j11) {
        this(j11, j11, j11, j11);
    }
}
