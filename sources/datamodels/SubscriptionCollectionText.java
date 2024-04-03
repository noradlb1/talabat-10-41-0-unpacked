package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u001c"}, d2 = {"Ldatamodels/SubscriptionCollectionText;", "Landroid/os/Parcelable;", "main", "", "color", "secondary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getMain", "getSecondary", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubscriptionCollectionText implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubscriptionCollectionText> CREATOR = new Creator();
    @Nullable
    private final String color;
    @Nullable
    private final String main;
    @Nullable
    private final String secondary;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubscriptionCollectionText> {
        @NotNull
        public final SubscriptionCollectionText createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubscriptionCollectionText(parcel.readString(), parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SubscriptionCollectionText[] newArray(int i11) {
            return new SubscriptionCollectionText[i11];
        }
    }

    public SubscriptionCollectionText(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.main = str;
        this.color = str2;
        this.secondary = str3;
    }

    public static /* synthetic */ SubscriptionCollectionText copy$default(SubscriptionCollectionText subscriptionCollectionText, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionCollectionText.main;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionCollectionText.color;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionCollectionText.secondary;
        }
        return subscriptionCollectionText.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.main;
    }

    @Nullable
    public final String component2() {
        return this.color;
    }

    @Nullable
    public final String component3() {
        return this.secondary;
    }

    @NotNull
    public final SubscriptionCollectionText copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new SubscriptionCollectionText(str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionCollectionText)) {
            return false;
        }
        SubscriptionCollectionText subscriptionCollectionText = (SubscriptionCollectionText) obj;
        return Intrinsics.areEqual((Object) this.main, (Object) subscriptionCollectionText.main) && Intrinsics.areEqual((Object) this.color, (Object) subscriptionCollectionText.color) && Intrinsics.areEqual((Object) this.secondary, (Object) subscriptionCollectionText.secondary);
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getMain() {
        return this.main;
    }

    @Nullable
    public final String getSecondary() {
        return this.secondary;
    }

    public int hashCode() {
        String str = this.main;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.color;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.secondary;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.main;
        String str2 = this.color;
        String str3 = this.secondary;
        return "SubscriptionCollectionText(main=" + str + ", color=" + str2 + ", secondary=" + str3 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.main);
        parcel.writeString(this.color);
        parcel.writeString(this.secondary);
    }
}
