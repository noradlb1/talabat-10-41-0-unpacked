package com.talabat.darkstores.data;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/data/TalabatVendorInfo;", "Landroid/os/Parcelable;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class TalabatVendorInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<TalabatVendorInfo> CREATOR = new Creator();
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56184name;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TalabatVendorInfo> {
        @NotNull
        public final TalabatVendorInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TalabatVendorInfo(parcel.readString());
        }

        @NotNull
        public final TalabatVendorInfo[] newArray(int i11) {
            return new TalabatVendorInfo[i11];
        }
    }

    public TalabatVendorInfo(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f56184name = str;
    }

    public static /* synthetic */ TalabatVendorInfo copy$default(TalabatVendorInfo talabatVendorInfo, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = talabatVendorInfo.f56184name;
        }
        return talabatVendorInfo.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.f56184name;
    }

    @NotNull
    public final TalabatVendorInfo copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new TalabatVendorInfo(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TalabatVendorInfo) && Intrinsics.areEqual((Object) this.f56184name, (Object) ((TalabatVendorInfo) obj).f56184name);
    }

    @NotNull
    public final String getName() {
        return this.f56184name;
    }

    public int hashCode() {
        return this.f56184name.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56184name;
        return "TalabatVendorInfo(name=" + str + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f56184name);
    }
}
