package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.Margin;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/component/base/DividerStyle;", "", "thickness", "", "color", "", "margin", "Lcom/checkout/frames/model/Margin;", "(IJLcom/checkout/frames/model/Margin;)V", "getColor", "()J", "getMargin", "()Lcom/checkout/frames/model/Margin;", "getThickness", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DividerStyle {
    public static final int $stable = 0;
    private final long color;
    @Nullable
    private final Margin margin;
    private final int thickness;

    @JvmOverloads
    public DividerStyle(int i11, long j11) {
        this(i11, j11, (Margin) null, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public DividerStyle(int i11, long j11, @Nullable Margin margin2) {
        this.thickness = i11;
        this.color = j11;
        this.margin = margin2;
    }

    @JvmOverloads
    public DividerStyle(long j11) {
        this(0, j11, (Margin) null, 5, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DividerStyle copy$default(DividerStyle dividerStyle, int i11, long j11, Margin margin2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = dividerStyle.thickness;
        }
        if ((i12 & 2) != 0) {
            j11 = dividerStyle.color;
        }
        if ((i12 & 4) != 0) {
            margin2 = dividerStyle.margin;
        }
        return dividerStyle.copy(i11, j11, margin2);
    }

    public final int component1() {
        return this.thickness;
    }

    public final long component2() {
        return this.color;
    }

    @Nullable
    public final Margin component3() {
        return this.margin;
    }

    @NotNull
    public final DividerStyle copy(int i11, long j11, @Nullable Margin margin2) {
        return new DividerStyle(i11, j11, margin2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DividerStyle)) {
            return false;
        }
        DividerStyle dividerStyle = (DividerStyle) obj;
        return this.thickness == dividerStyle.thickness && this.color == dividerStyle.color && Intrinsics.areEqual((Object) this.margin, (Object) dividerStyle.margin);
    }

    public final long getColor() {
        return this.color;
    }

    @Nullable
    public final Margin getMargin() {
        return this.margin;
    }

    public final int getThickness() {
        return this.thickness;
    }

    public int hashCode() {
        int a11 = ((this.thickness * 31) + a.a(this.color)) * 31;
        Margin margin2 = this.margin;
        return a11 + (margin2 == null ? 0 : margin2.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.thickness;
        long j11 = this.color;
        Margin margin2 = this.margin;
        return "DividerStyle(thickness=" + i11 + ", color=" + j11 + ", margin=" + margin2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DividerStyle(int i11, long j11, Margin margin2, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 1 : i11, j11, (i12 & 4) != 0 ? null : margin2);
    }
}
