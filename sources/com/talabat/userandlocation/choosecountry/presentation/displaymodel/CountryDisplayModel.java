package com.talabat.userandlocation.choosecountry.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/displaymodel/CountryDisplayModel;", "", "id", "", "name", "", "imageRes", "isSelected", "", "(ILjava/lang/String;IZ)V", "getId", "()I", "getImageRes", "()Z", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryDisplayModel {

    /* renamed from: id  reason: collision with root package name */
    private final int f12243id;
    private final int imageRes;
    private final boolean isSelected;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f12244name;

    public CountryDisplayModel(int i11, @NotNull String str, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f12243id = i11;
        this.f12244name = str;
        this.imageRes = i12;
        this.isSelected = z11;
    }

    public static /* synthetic */ CountryDisplayModel copy$default(CountryDisplayModel countryDisplayModel, int i11, String str, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = countryDisplayModel.f12243id;
        }
        if ((i13 & 2) != 0) {
            str = countryDisplayModel.f12244name;
        }
        if ((i13 & 4) != 0) {
            i12 = countryDisplayModel.imageRes;
        }
        if ((i13 & 8) != 0) {
            z11 = countryDisplayModel.isSelected;
        }
        return countryDisplayModel.copy(i11, str, i12, z11);
    }

    public final int component1() {
        return this.f12243id;
    }

    @NotNull
    public final String component2() {
        return this.f12244name;
    }

    public final int component3() {
        return this.imageRes;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final CountryDisplayModel copy(int i11, @NotNull String str, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new CountryDisplayModel(i11, str, i12, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryDisplayModel)) {
            return false;
        }
        CountryDisplayModel countryDisplayModel = (CountryDisplayModel) obj;
        return this.f12243id == countryDisplayModel.f12243id && Intrinsics.areEqual((Object) this.f12244name, (Object) countryDisplayModel.f12244name) && this.imageRes == countryDisplayModel.imageRes && this.isSelected == countryDisplayModel.isSelected;
    }

    public final int getId() {
        return this.f12243id;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    @NotNull
    public final String getName() {
        return this.f12244name;
    }

    public int hashCode() {
        int hashCode = ((((this.f12243id * 31) + this.f12244name.hashCode()) * 31) + this.imageRes) * 31;
        boolean z11 = this.isSelected;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public String toString() {
        int i11 = this.f12243id;
        String str = this.f12244name;
        int i12 = this.imageRes;
        boolean z11 = this.isSelected;
        return "CountryDisplayModel(id=" + i11 + ", name=" + str + ", imageRes=" + i12 + ", isSelected=" + z11 + ")";
    }
}
