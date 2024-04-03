package com.talabat.talabatlife.ui.cuisine;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\""}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "Landroid/os/Parcelable;", "id", "", "name", "", "slug", "isSelected", "", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getId", "()I", "()Z", "setSelected", "(Z)V", "getName", "()Ljava/lang/String;", "getSlug", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CuisineDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CuisineDisplayModel> CREATOR = new Creator();

    /* renamed from: id  reason: collision with root package name */
    private final int f12060id;
    private boolean isSelected;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f12061name;
    @NotNull
    private final String slug;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CuisineDisplayModel> {
        @NotNull
        public final CuisineDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CuisineDisplayModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final CuisineDisplayModel[] newArray(int i11) {
            return new CuisineDisplayModel[i11];
        }
    }

    public CuisineDisplayModel(int i11, @NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        this.f12060id = i11;
        this.f12061name = str;
        this.slug = str2;
        this.isSelected = z11;
    }

    public static /* synthetic */ CuisineDisplayModel copy$default(CuisineDisplayModel cuisineDisplayModel, int i11, String str, String str2, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = cuisineDisplayModel.f12060id;
        }
        if ((i12 & 2) != 0) {
            str = cuisineDisplayModel.f12061name;
        }
        if ((i12 & 4) != 0) {
            str2 = cuisineDisplayModel.slug;
        }
        if ((i12 & 8) != 0) {
            z11 = cuisineDisplayModel.isSelected;
        }
        return cuisineDisplayModel.copy(i11, str, str2, z11);
    }

    public final int component1() {
        return this.f12060id;
    }

    @NotNull
    public final String component2() {
        return this.f12061name;
    }

    @NotNull
    public final String component3() {
        return this.slug;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final CuisineDisplayModel copy(int i11, @NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "slug");
        return new CuisineDisplayModel(i11, str, str2, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CuisineDisplayModel)) {
            return false;
        }
        CuisineDisplayModel cuisineDisplayModel = (CuisineDisplayModel) obj;
        return this.f12060id == cuisineDisplayModel.f12060id && Intrinsics.areEqual((Object) this.f12061name, (Object) cuisineDisplayModel.f12061name) && Intrinsics.areEqual((Object) this.slug, (Object) cuisineDisplayModel.slug) && this.isSelected == cuisineDisplayModel.isSelected;
    }

    public final int getId() {
        return this.f12060id;
    }

    @NotNull
    public final String getName() {
        return this.f12061name;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    public int hashCode() {
        int hashCode = ((((this.f12060id * 31) + this.f12061name.hashCode()) * 31) + this.slug.hashCode()) * 31;
        boolean z11 = this.isSelected;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f12060id;
        String str = this.f12061name;
        String str2 = this.slug;
        boolean z11 = this.isSelected;
        return "CuisineDisplayModel(id=" + i11 + ", name=" + str + ", slug=" + str2 + ", isSelected=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.f12060id);
        parcel.writeString(this.f12061name);
        parcel.writeString(this.slug);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }
}
