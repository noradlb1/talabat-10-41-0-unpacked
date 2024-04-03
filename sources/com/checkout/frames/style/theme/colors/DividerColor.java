package com.checkout.frames.style.theme.colors;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/style/theme/colors/DividerColor;", "", "color", "", "(J)V", "getColor", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DividerColor {
    public static final int $stable = 0;
    private final long color;

    public DividerColor(long j11) {
        this.color = j11;
    }

    public static /* synthetic */ DividerColor copy$default(DividerColor dividerColor, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = dividerColor.color;
        }
        return dividerColor.copy(j11);
    }

    public final long component1() {
        return this.color;
    }

    @NotNull
    public final DividerColor copy(long j11) {
        return new DividerColor(j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DividerColor) && this.color == ((DividerColor) obj).color;
    }

    public final long getColor() {
        return this.color;
    }

    public int hashCode() {
        return a.a(this.color);
    }

    @NotNull
    public String toString() {
        long j11 = this.color;
        return "DividerColor(color=" + j11 + ")";
    }
}
