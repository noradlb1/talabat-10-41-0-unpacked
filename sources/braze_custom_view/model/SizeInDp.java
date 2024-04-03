package braze_custom_view.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lbraze_custom_view/model/SizeInDp;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SizeInDp {
    private final int height;
    private final int width;

    public SizeInDp(int i11, int i12) {
        this.width = i11;
        this.height = i12;
    }

    public static /* synthetic */ SizeInDp copy$default(SizeInDp sizeInDp, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = sizeInDp.width;
        }
        if ((i13 & 2) != 0) {
            i12 = sizeInDp.height;
        }
        return sizeInDp.copy(i11, i12);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final SizeInDp copy(int i11, int i12) {
        return new SizeInDp(i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeInDp)) {
            return false;
        }
        SizeInDp sizeInDp = (SizeInDp) obj;
        return this.width == sizeInDp.width && this.height == sizeInDp.height;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    @NotNull
    public String toString() {
        int i11 = this.width;
        int i12 = this.height;
        return "SizeInDp(width=" + i11 + ", height=" + i12 + ")";
    }
}
