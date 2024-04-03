package coil.size;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Px;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcoil/size/PixelSize;", "Lcoil/size/Size;", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Parcelize
public final class PixelSize extends Size {
    @NotNull
    public static final Parcelable.Creator<PixelSize> CREATOR = new Creator();
    private final int height;
    private final int width;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PixelSize> {
        @NotNull
        public final PixelSize createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PixelSize(parcel.readInt(), parcel.readInt());
        }

        @NotNull
        public final PixelSize[] newArray(int i11) {
            return new PixelSize[i11];
        }
    }

    public PixelSize(@Px int i11, @Px int i12) {
        super((DefaultConstructorMarker) null);
        boolean z11;
        this.width = i11;
        this.height = i12;
        if (i11 <= 0 || i12 <= 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException("width and height must be > 0.".toString());
        }
    }

    public static /* synthetic */ PixelSize copy$default(PixelSize pixelSize, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = pixelSize.width;
        }
        if ((i13 & 2) != 0) {
            i12 = pixelSize.height;
        }
        return pixelSize.copy(i11, i12);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final PixelSize copy(@Px int i11, @Px int i12) {
        return new PixelSize(i11, i12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PixelSize)) {
            return false;
        }
        PixelSize pixelSize = (PixelSize) obj;
        return this.width == pixelSize.width && this.height == pixelSize.height;
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
        return "PixelSize(width=" + this.width + ", height=" + this.height + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }
}
