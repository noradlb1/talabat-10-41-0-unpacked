package com.talabat.darkstores.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/model/SubCategory;", "Landroid/os/Parcelable;", "name", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class SubCategory implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<SubCategory> CREATOR = new Creator();
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f56638id;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f56639name;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubCategory> {
        @NotNull
        public final SubCategory createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubCategory(parcel.readString(), parcel.readString());
        }

        @NotNull
        public final SubCategory[] newArray(int i11) {
            return new SubCategory[i11];
        }
    }

    public SubCategory(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        this.f56639name = str;
        this.f56638id = str2;
    }

    public static /* synthetic */ SubCategory copy$default(SubCategory subCategory, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subCategory.f56639name;
        }
        if ((i11 & 2) != 0) {
            str2 = subCategory.f56638id;
        }
        return subCategory.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f56639name;
    }

    @NotNull
    public final String component2() {
        return this.f56638id;
    }

    @NotNull
    public final SubCategory copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "id");
        return new SubCategory(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubCategory)) {
            return false;
        }
        SubCategory subCategory = (SubCategory) obj;
        return Intrinsics.areEqual((Object) this.f56639name, (Object) subCategory.f56639name) && Intrinsics.areEqual((Object) this.f56638id, (Object) subCategory.f56638id);
    }

    @NotNull
    public final String getId() {
        return this.f56638id;
    }

    @NotNull
    public final String getName() {
        return this.f56639name;
    }

    public int hashCode() {
        return (this.f56639name.hashCode() * 31) + this.f56638id.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f56639name;
        String str2 = this.f56638id;
        return "SubCategory(name=" + str + ", id=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.f56639name);
        parcel.writeString(this.f56638id);
    }
}
