package androidx.compose.ui.text.android.animation;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.InternalPlatformTextApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/android/animation/Segment;", "", "startOffset", "", "endOffset", "left", "top", "right", "bottom", "(IIIIII)V", "getBottom", "()I", "getEndOffset", "getLeft", "getRight", "getStartOffset", "getTop", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@InternalPlatformTextApi
public final class Segment {
    public static final int $stable = 0;
    private final int bottom;
    private final int endOffset;
    private final int left;
    private final int right;
    private final int startOffset;
    private final int top;

    public Segment(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.startOffset = i11;
        this.endOffset = i12;
        this.left = i13;
        this.top = i14;
        this.right = i15;
        this.bottom = i16;
    }

    public static /* synthetic */ Segment copy$default(Segment segment, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i11 = segment.startOffset;
        }
        if ((i17 & 2) != 0) {
            i12 = segment.endOffset;
        }
        int i18 = i12;
        if ((i17 & 4) != 0) {
            i13 = segment.left;
        }
        int i19 = i13;
        if ((i17 & 8) != 0) {
            i14 = segment.top;
        }
        int i21 = i14;
        if ((i17 & 16) != 0) {
            i15 = segment.right;
        }
        int i22 = i15;
        if ((i17 & 32) != 0) {
            i16 = segment.bottom;
        }
        return segment.copy(i11, i18, i19, i21, i22, i16);
    }

    public final int component1() {
        return this.startOffset;
    }

    public final int component2() {
        return this.endOffset;
    }

    public final int component3() {
        return this.left;
    }

    public final int component4() {
        return this.top;
    }

    public final int component5() {
        return this.right;
    }

    public final int component6() {
        return this.bottom;
    }

    @NotNull
    public final Segment copy(int i11, int i12, int i13, int i14, int i15, int i16) {
        return new Segment(i11, i12, i13, i14, i15, i16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Segment)) {
            return false;
        }
        Segment segment = (Segment) obj;
        return this.startOffset == segment.startOffset && this.endOffset == segment.endOffset && this.left == segment.left && this.top == segment.top && this.right == segment.right && this.bottom == segment.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getEndOffset() {
        return this.endOffset;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getStartOffset() {
        return this.startOffset;
    }

    public final int getTop() {
        return this.top;
    }

    public int hashCode() {
        return (((((((((this.startOffset * 31) + this.endOffset) * 31) + this.left) * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    @NotNull
    public String toString() {
        return "Segment(startOffset=" + this.startOffset + ", endOffset=" + this.endOffset + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ')';
    }
}
