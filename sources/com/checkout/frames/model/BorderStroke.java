package com.checkout.frames.model;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/checkout/frames/model/BorderStroke;", "", "width", "", "color", "", "(IJ)V", "getColor", "()J", "getWidth", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BorderStroke {
    public static final int $stable = 0;
    private final long color;
    private final int width;

    public BorderStroke(int i11, long j11) {
        this.width = i11;
        this.color = j11;
    }

    public static /* synthetic */ BorderStroke copy$default(BorderStroke borderStroke, int i11, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = borderStroke.width;
        }
        if ((i12 & 2) != 0) {
            j11 = borderStroke.color;
        }
        return borderStroke.copy(i11, j11);
    }

    public final int component1() {
        return this.width;
    }

    public final long component2() {
        return this.color;
    }

    @NotNull
    public final BorderStroke copy(int i11, long j11) {
        return new BorderStroke(i11, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        return this.width == borderStroke.width && this.color == borderStroke.color;
    }

    public final long getColor() {
        return this.color;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + a.a(this.color);
    }

    @NotNull
    public String toString() {
        int i11 = this.width;
        long j11 = this.color;
        return "BorderStroke(width=" + i11 + ", color=" + j11 + ")";
    }
}
