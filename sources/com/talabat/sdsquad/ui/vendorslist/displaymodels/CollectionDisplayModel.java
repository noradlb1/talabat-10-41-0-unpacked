package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003Jm\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u001a\u0010\r\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018¨\u00067"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/CollectionDisplayModel;", "Landroid/os/Parcelable;", "id", "", "image", "", "name", "colorCode", "description", "showCardView", "", "collectionImage", "baseUrl", "isCuisine", "hasTerms", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZ)V", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "getCollectionImage", "getColorCode", "getDescription", "getHasTerms", "()Z", "setHasTerms", "(Z)V", "getId", "()I", "getImage", "setCuisine", "getName", "getShowCardView", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CollectionDisplayModel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CollectionDisplayModel> CREATOR = new Creator();
    @NotNull
    private String baseUrl;
    @NotNull
    private final String collectionImage;
    @NotNull
    private final String colorCode;
    @NotNull
    private final String description;
    private boolean hasTerms;

    /* renamed from: id  reason: collision with root package name */
    private final int f61348id;
    @NotNull
    private final String image;
    private boolean isCuisine;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f61349name;
    private final boolean showCardView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CollectionDisplayModel> {
        @NotNull
        public final CollectionDisplayModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CollectionDisplayModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0);
        }

        @NotNull
        public final CollectionDisplayModel[] newArray(int i11) {
            return new CollectionDisplayModel[i11];
        }
    }

    public CollectionDisplayModel(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(str, "image");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "colorCode");
        Intrinsics.checkNotNullParameter(str4, "description");
        Intrinsics.checkNotNullParameter(str5, "collectionImage");
        Intrinsics.checkNotNullParameter(str6, "baseUrl");
        this.f61348id = i11;
        this.image = str;
        this.f61349name = str2;
        this.colorCode = str3;
        this.description = str4;
        this.showCardView = z11;
        this.collectionImage = str5;
        this.baseUrl = str6;
        this.isCuisine = z12;
        this.hasTerms = z13;
    }

    public static /* synthetic */ CollectionDisplayModel copy$default(CollectionDisplayModel collectionDisplayModel, int i11, String str, String str2, String str3, String str4, boolean z11, String str5, String str6, boolean z12, boolean z13, int i12, Object obj) {
        CollectionDisplayModel collectionDisplayModel2 = collectionDisplayModel;
        int i13 = i12;
        return collectionDisplayModel.copy((i13 & 1) != 0 ? collectionDisplayModel2.f61348id : i11, (i13 & 2) != 0 ? collectionDisplayModel2.image : str, (i13 & 4) != 0 ? collectionDisplayModel2.f61349name : str2, (i13 & 8) != 0 ? collectionDisplayModel2.colorCode : str3, (i13 & 16) != 0 ? collectionDisplayModel2.description : str4, (i13 & 32) != 0 ? collectionDisplayModel2.showCardView : z11, (i13 & 64) != 0 ? collectionDisplayModel2.collectionImage : str5, (i13 & 128) != 0 ? collectionDisplayModel2.baseUrl : str6, (i13 & 256) != 0 ? collectionDisplayModel2.isCuisine : z12, (i13 & 512) != 0 ? collectionDisplayModel2.hasTerms : z13);
    }

    public final int component1() {
        return this.f61348id;
    }

    public final boolean component10() {
        return this.hasTerms;
    }

    @NotNull
    public final String component2() {
        return this.image;
    }

    @NotNull
    public final String component3() {
        return this.f61349name;
    }

    @NotNull
    public final String component4() {
        return this.colorCode;
    }

    @NotNull
    public final String component5() {
        return this.description;
    }

    public final boolean component6() {
        return this.showCardView;
    }

    @NotNull
    public final String component7() {
        return this.collectionImage;
    }

    @NotNull
    public final String component8() {
        return this.baseUrl;
    }

    public final boolean component9() {
        return this.isCuisine;
    }

    @NotNull
    public final CollectionDisplayModel copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, boolean z12, boolean z13) {
        Intrinsics.checkNotNullParameter(str, "image");
        Intrinsics.checkNotNullParameter(str2, "name");
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "colorCode");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "description");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "collectionImage");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "baseUrl");
        return new CollectionDisplayModel(i11, str, str2, str7, str8, z11, str9, str10, z12, z13);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionDisplayModel)) {
            return false;
        }
        CollectionDisplayModel collectionDisplayModel = (CollectionDisplayModel) obj;
        return this.f61348id == collectionDisplayModel.f61348id && Intrinsics.areEqual((Object) this.image, (Object) collectionDisplayModel.image) && Intrinsics.areEqual((Object) this.f61349name, (Object) collectionDisplayModel.f61349name) && Intrinsics.areEqual((Object) this.colorCode, (Object) collectionDisplayModel.colorCode) && Intrinsics.areEqual((Object) this.description, (Object) collectionDisplayModel.description) && this.showCardView == collectionDisplayModel.showCardView && Intrinsics.areEqual((Object) this.collectionImage, (Object) collectionDisplayModel.collectionImage) && Intrinsics.areEqual((Object) this.baseUrl, (Object) collectionDisplayModel.baseUrl) && this.isCuisine == collectionDisplayModel.isCuisine && this.hasTerms == collectionDisplayModel.hasTerms;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final String getCollectionImage() {
        return this.collectionImage;
    }

    @NotNull
    public final String getColorCode() {
        return this.colorCode;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    public final boolean getHasTerms() {
        return this.hasTerms;
    }

    public final int getId() {
        return this.f61348id;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.f61349name;
    }

    public final boolean getShowCardView() {
        return this.showCardView;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f61348id * 31) + this.image.hashCode()) * 31) + this.f61349name.hashCode()) * 31) + this.colorCode.hashCode()) * 31) + this.description.hashCode()) * 31;
        boolean z11 = this.showCardView;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode2 = (((((hashCode + (z11 ? 1 : 0)) * 31) + this.collectionImage.hashCode()) * 31) + this.baseUrl.hashCode()) * 31;
        boolean z13 = this.isCuisine;
        if (z13) {
            z13 = true;
        }
        int i11 = (hashCode2 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.hasTerms;
        if (!z14) {
            z12 = z14;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isCuisine() {
        return this.isCuisine;
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setCuisine(boolean z11) {
        this.isCuisine = z11;
    }

    public final void setHasTerms(boolean z11) {
        this.hasTerms = z11;
    }

    @NotNull
    public String toString() {
        int i11 = this.f61348id;
        String str = this.image;
        String str2 = this.f61349name;
        String str3 = this.colorCode;
        String str4 = this.description;
        boolean z11 = this.showCardView;
        String str5 = this.collectionImage;
        String str6 = this.baseUrl;
        boolean z12 = this.isCuisine;
        boolean z13 = this.hasTerms;
        return "CollectionDisplayModel(id=" + i11 + ", image=" + str + ", name=" + str2 + ", colorCode=" + str3 + ", description=" + str4 + ", showCardView=" + z11 + ", collectionImage=" + str5 + ", baseUrl=" + str6 + ", isCuisine=" + z12 + ", hasTerms=" + z13 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.f61348id);
        parcel.writeString(this.image);
        parcel.writeString(this.f61349name);
        parcel.writeString(this.colorCode);
        parcel.writeString(this.description);
        parcel.writeInt(this.showCardView ? 1 : 0);
        parcel.writeString(this.collectionImage);
        parcel.writeString(this.baseUrl);
        parcel.writeInt(this.isCuisine ? 1 : 0);
        parcel.writeInt(this.hasTerms ? 1 : 0);
    }
}
