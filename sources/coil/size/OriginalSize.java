package coil.size;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004HÖ\u0001¨\u0006\f"}, d2 = {"Lcoil/size/OriginalSize;", "Lcoil/size/Size;", "()V", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Parcelize
public final class OriginalSize extends Size {
    @NotNull
    public static final Parcelable.Creator<OriginalSize> CREATOR = new Creator();
    @NotNull
    public static final OriginalSize INSTANCE = new OriginalSize();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OriginalSize> {
        @NotNull
        public final OriginalSize createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.readInt();
            return OriginalSize.INSTANCE;
        }

        @NotNull
        public final OriginalSize[] newArray(int i11) {
            return new OriginalSize[i11];
        }
    }

    private OriginalSize() {
        super((DefaultConstructorMarker) null);
    }

    public int describeContents() {
        return 0;
    }

    @NotNull
    public String toString() {
        return "coil.size.OriginalSize";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(1);
    }
}
