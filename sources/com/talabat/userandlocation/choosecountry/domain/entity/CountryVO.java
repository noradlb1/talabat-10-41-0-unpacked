package com.talabat.userandlocation.choosecountry.domain.entity;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "", "id", "", "name", "", "imageUrl", "currencySymbol", "numberOfDecimalPlaces", "isSelected", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V", "getCurrencySymbol", "()Ljava/lang/String;", "getId", "()I", "getImageUrl", "()Z", "getName", "getNumberOfDecimalPlaces", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryVO {
    @NotNull
    private final String currencySymbol;

    /* renamed from: id  reason: collision with root package name */
    private final int f12216id;
    @NotNull
    private final String imageUrl;
    private final boolean isSelected;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f12217name;
    private final int numberOfDecimalPlaces;

    public CountryVO(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, "currencySymbol");
        this.f12216id = i11;
        this.f12217name = str;
        this.imageUrl = str2;
        this.currencySymbol = str3;
        this.numberOfDecimalPlaces = i12;
        this.isSelected = z11;
    }

    public static /* synthetic */ CountryVO copy$default(CountryVO countryVO, int i11, String str, String str2, String str3, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = countryVO.f12216id;
        }
        if ((i13 & 2) != 0) {
            str = countryVO.f12217name;
        }
        String str4 = str;
        if ((i13 & 4) != 0) {
            str2 = countryVO.imageUrl;
        }
        String str5 = str2;
        if ((i13 & 8) != 0) {
            str3 = countryVO.currencySymbol;
        }
        String str6 = str3;
        if ((i13 & 16) != 0) {
            i12 = countryVO.numberOfDecimalPlaces;
        }
        int i14 = i12;
        if ((i13 & 32) != 0) {
            z11 = countryVO.isSelected;
        }
        return countryVO.copy(i11, str4, str5, str6, i14, z11);
    }

    public final int component1() {
        return this.f12216id;
    }

    @NotNull
    public final String component2() {
        return this.f12217name;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final String component4() {
        return this.currencySymbol;
    }

    public final int component5() {
        return this.numberOfDecimalPlaces;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    @NotNull
    public final CountryVO copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, int i12, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, "currencySymbol");
        return new CountryVO(i11, str, str2, str3, i12, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryVO)) {
            return false;
        }
        CountryVO countryVO = (CountryVO) obj;
        return this.f12216id == countryVO.f12216id && Intrinsics.areEqual((Object) this.f12217name, (Object) countryVO.f12217name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) countryVO.imageUrl) && Intrinsics.areEqual((Object) this.currencySymbol, (Object) countryVO.currencySymbol) && this.numberOfDecimalPlaces == countryVO.numberOfDecimalPlaces && this.isSelected == countryVO.isSelected;
    }

    @NotNull
    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public final int getId() {
        return this.f12216id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f12217name;
    }

    public final int getNumberOfDecimalPlaces() {
        return this.numberOfDecimalPlaces;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f12216id * 31) + this.f12217name.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.currencySymbol.hashCode()) * 31) + this.numberOfDecimalPlaces) * 31;
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
        int i11 = this.f12216id;
        String str = this.f12217name;
        String str2 = this.imageUrl;
        String str3 = this.currencySymbol;
        int i12 = this.numberOfDecimalPlaces;
        boolean z11 = this.isSelected;
        return "CountryVO(id=" + i11 + ", name=" + str + ", imageUrl=" + str2 + ", currencySymbol=" + str3 + ", numberOfDecimalPlaces=" + i12 + ", isSelected=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountryVO(int i11, String str, String str2, String str3, int i12, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, str, str2, str3, i12, (i13 & 32) != 0 ? false : z11);
    }
}
