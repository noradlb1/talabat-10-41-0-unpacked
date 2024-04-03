package com.talabat.darkstores.data.discovery.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/SortOption;", "Landroid/os/Parcelable;", "displayName", "", "isApplied", "", "key", "(Ljava/lang/String;ZLjava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "()Z", "getKey", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SortOption implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SortOption> CREATOR = new Creator();
    @NotNull
    private final String displayName;
    private final boolean isApplied;
    @NotNull
    private final String key;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SortOption> {
        @NotNull
        public final SortOption createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SortOption(parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        @NotNull
        public final SortOption[] newArray(int i11) {
            return new SortOption[i11];
        }
    }

    public SortOption(@NotNull String str, boolean z11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Profile.DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str2, "key");
        this.displayName = str;
        this.isApplied = z11;
        this.key = str2;
    }

    public static /* synthetic */ SortOption copy$default(SortOption sortOption, String str, boolean z11, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sortOption.displayName;
        }
        if ((i11 & 2) != 0) {
            z11 = sortOption.isApplied;
        }
        if ((i11 & 4) != 0) {
            str2 = sortOption.key;
        }
        return sortOption.copy(str, z11, str2);
    }

    @NotNull
    public final String component1() {
        return this.displayName;
    }

    public final boolean component2() {
        return this.isApplied;
    }

    @NotNull
    public final String component3() {
        return this.key;
    }

    @NotNull
    public final SortOption copy(@NotNull String str, boolean z11, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Profile.DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(str2, "key");
        return new SortOption(str, z11, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SortOption)) {
            return false;
        }
        SortOption sortOption = (SortOption) obj;
        return Intrinsics.areEqual((Object) this.displayName, (Object) sortOption.displayName) && this.isApplied == sortOption.isApplied && Intrinsics.areEqual((Object) this.key, (Object) sortOption.key);
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        int hashCode = this.displayName.hashCode() * 31;
        boolean z11 = this.isApplied;
        if (z11) {
            z11 = true;
        }
        return ((hashCode + (z11 ? 1 : 0)) * 31) + this.key.hashCode();
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    @NotNull
    public String toString() {
        String str = this.displayName;
        boolean z11 = this.isApplied;
        String str2 = this.key;
        return "SortOption(displayName=" + str + ", isApplied=" + z11 + ", key=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.displayName);
        parcel.writeInt(this.isApplied ? 1 : 0);
        parcel.writeString(this.key);
    }
}
