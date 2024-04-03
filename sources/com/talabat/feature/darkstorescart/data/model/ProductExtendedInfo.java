package com.talabat.feature.darkstorescart.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@JsonClass(generateAdapter = true)
@Parcelize
@Instrumented
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001:\u0006/01234BG\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\u0010\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010%J\t\u0010'\u001a\u00020\u001fHÖ\u0001J\u0006\u0010(\u001a\u00020!J\t\u0010)\u001a\u00020%HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00065"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo;", "Landroid/os/Parcelable;", "tags", "", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "contentUnit", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ContentUnit;", "storedAt", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "country", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Country;", "shelfLife", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ShelfLife;", "(Ljava/util/List;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ContentUnit;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Country;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ShelfLife;)V", "getContentUnit", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ContentUnit;", "getCountry", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Country;", "getShelfLife", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ShelfLife;", "getStoredAt", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "getTrackingData", "", "productDescription", "hashCode", "isInValidProductExtendedInfo", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ColorResource", "ContentUnit", "Country", "ShelfLife", "StoredAt", "Tag", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductExtendedInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<ProductExtendedInfo> CREATOR = new Creator();
    @Nullable
    private final ContentUnit contentUnit;
    @Nullable
    private final Country country;
    @Nullable
    private final ShelfLife shelfLife;
    @Nullable
    private final StoredAt storedAt;
    @Nullable
    private final List<Tag> tags;

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;", "Landroid/os/Parcelable;", "marshmallowToken", "", "hex", "(Ljava/lang/String;Ljava/lang/String;)V", "getHex", "()Ljava/lang/String;", "getMarshmallowToken", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ColorResource implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<ColorResource> CREATOR = new Creator();
        @Nullable
        private final String hex;
        @Nullable
        private final String marshmallowToken;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ColorResource> {
            @NotNull
            public final ColorResource createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ColorResource(parcel.readString(), parcel.readString());
            }

            @NotNull
            public final ColorResource[] newArray(int i11) {
                return new ColorResource[i11];
            }
        }

        public ColorResource(@Nullable @Json(name = "marshmallow_token") String str, @Nullable @Json(name = "hex") String str2) {
            this.marshmallowToken = str;
            this.hex = str2;
        }

        public static /* synthetic */ ColorResource copy$default(ColorResource colorResource, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = colorResource.marshmallowToken;
            }
            if ((i11 & 2) != 0) {
                str2 = colorResource.hex;
            }
            return colorResource.copy(str, str2);
        }

        @Nullable
        public final String component1() {
            return this.marshmallowToken;
        }

        @Nullable
        public final String component2() {
            return this.hex;
        }

        @NotNull
        public final ColorResource copy(@Nullable @Json(name = "marshmallow_token") String str, @Nullable @Json(name = "hex") String str2) {
            return new ColorResource(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ColorResource)) {
                return false;
            }
            ColorResource colorResource = (ColorResource) obj;
            return Intrinsics.areEqual((Object) this.marshmallowToken, (Object) colorResource.marshmallowToken) && Intrinsics.areEqual((Object) this.hex, (Object) colorResource.hex);
        }

        @Nullable
        public final String getHex() {
            return this.hex;
        }

        @Nullable
        public final String getMarshmallowToken() {
            return this.marshmallowToken;
        }

        public int hashCode() {
            String str = this.marshmallowToken;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.hex;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode + i11;
        }

        @NotNull
        public String toString() {
            String str = this.marshmallowToken;
            String str2 = this.hex;
            return "ColorResource(marshmallowToken=" + str + ", hex=" + str2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.marshmallowToken);
            parcel.writeString(this.hex);
        }
    }

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ContentUnit;", "Landroid/os/Parcelable;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContentUnit implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<ContentUnit> CREATOR = new Creator();
        @Nullable
        private final String text;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ContentUnit> {
            @NotNull
            public final ContentUnit createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ContentUnit(parcel.readString());
            }

            @NotNull
            public final ContentUnit[] newArray(int i11) {
                return new ContentUnit[i11];
            }
        }

        public ContentUnit(@Nullable @Json(name = "text") String str) {
            this.text = str;
        }

        public static /* synthetic */ ContentUnit copy$default(ContentUnit contentUnit, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = contentUnit.text;
            }
            return contentUnit.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final ContentUnit copy(@Nullable @Json(name = "text") String str) {
            return new ContentUnit(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContentUnit) && Intrinsics.areEqual((Object) this.text, (Object) ((ContentUnit) obj).text);
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.text;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.text;
            return "ContentUnit(text=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.text);
        }
    }

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Country;", "Landroid/os/Parcelable;", "code", "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Country implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<Country> CREATOR = new Creator();
        @Nullable
        private final String code;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Country> {
            @NotNull
            public final Country createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Country(parcel.readString());
            }

            @NotNull
            public final Country[] newArray(int i11) {
                return new Country[i11];
            }
        }

        public Country(@Nullable @Json(name = "code") String str) {
            this.code = str;
        }

        public static /* synthetic */ Country copy$default(Country country, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = country.code;
            }
            return country.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.code;
        }

        @NotNull
        public final Country copy(@Nullable @Json(name = "code") String str) {
            return new Country(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Country) && Intrinsics.areEqual((Object) this.code, (Object) ((Country) obj).code);
        }

        @Nullable
        public final String getCode() {
            return this.code;
        }

        public int hashCode() {
            String str = this.code;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.code;
            return "Country(code=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.code);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProductExtendedInfo> {
        @NotNull
        public final ProductExtendedInfo createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            ShelfLife shelfLife = null;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(Tag.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            ContentUnit createFromParcel = parcel.readInt() == 0 ? null : ContentUnit.CREATOR.createFromParcel(parcel);
            StoredAt createFromParcel2 = parcel.readInt() == 0 ? null : StoredAt.CREATOR.createFromParcel(parcel);
            Country createFromParcel3 = parcel.readInt() == 0 ? null : Country.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                shelfLife = ShelfLife.CREATOR.createFromParcel(parcel);
            }
            return new ProductExtendedInfo(arrayList, createFromParcel, createFromParcel2, createFromParcel3, shelfLife);
        }

        @NotNull
        public final ProductExtendedInfo[] newArray(int i11) {
            return new ProductExtendedInfo[i11];
        }
    }

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ShelfLife;", "Landroid/os/Parcelable;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShelfLife implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<ShelfLife> CREATOR = new Creator();
        @Nullable
        private final String text;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<ShelfLife> {
            @NotNull
            public final ShelfLife createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ShelfLife(parcel.readString());
            }

            @NotNull
            public final ShelfLife[] newArray(int i11) {
                return new ShelfLife[i11];
            }
        }

        public ShelfLife(@Nullable @Json(name = "text") String str) {
            this.text = str;
        }

        public static /* synthetic */ ShelfLife copy$default(ShelfLife shelfLife, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = shelfLife.text;
            }
            return shelfLife.copy(str);
        }

        @Nullable
        public final String component1() {
            return this.text;
        }

        @NotNull
        public final ShelfLife copy(@Nullable @Json(name = "text") String str) {
            return new ShelfLife(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShelfLife) && Intrinsics.areEqual((Object) this.text, (Object) ((ShelfLife) obj).text);
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.text;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.text;
            return "ShelfLife(text=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.text);
        }
    }

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "Landroid/os/Parcelable;", "text", "", "icon", "color", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getDescription", "getIcon", "getText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class StoredAt implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<StoredAt> CREATOR = new Creator();
        @Nullable
        private final String color;
        @Nullable
        private final String description;
        @Nullable
        private final String icon;
        @Nullable
        private final String text;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<StoredAt> {
            @NotNull
            public final StoredAt createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StoredAt(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @NotNull
            public final StoredAt[] newArray(int i11) {
                return new StoredAt[i11];
            }
        }

        public StoredAt(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "icon") String str2, @Nullable @Json(name = "color") String str3, @Nullable @Json(name = "description") String str4) {
            this.text = str;
            this.icon = str2;
            this.color = str3;
            this.description = str4;
        }

        public static /* synthetic */ StoredAt copy$default(StoredAt storedAt, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = storedAt.text;
            }
            if ((i11 & 2) != 0) {
                str2 = storedAt.icon;
            }
            if ((i11 & 4) != 0) {
                str3 = storedAt.color;
            }
            if ((i11 & 8) != 0) {
                str4 = storedAt.description;
            }
            return storedAt.copy(str, str2, str3, str4);
        }

        @Nullable
        public final String component1() {
            return this.text;
        }

        @Nullable
        public final String component2() {
            return this.icon;
        }

        @Nullable
        public final String component3() {
            return this.color;
        }

        @Nullable
        public final String component4() {
            return this.description;
        }

        @NotNull
        public final StoredAt copy(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "icon") String str2, @Nullable @Json(name = "color") String str3, @Nullable @Json(name = "description") String str4) {
            return new StoredAt(str, str2, str3, str4);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StoredAt)) {
                return false;
            }
            StoredAt storedAt = (StoredAt) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) storedAt.text) && Intrinsics.areEqual((Object) this.icon, (Object) storedAt.icon) && Intrinsics.areEqual((Object) this.color, (Object) storedAt.color) && Intrinsics.areEqual((Object) this.description, (Object) storedAt.description);
        }

        @Nullable
        public final String getColor() {
            return this.color;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        public int hashCode() {
            String str = this.text;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.icon;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.color;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.description;
            if (str4 != null) {
                i11 = str4.hashCode();
            }
            return hashCode3 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.text;
            String str2 = this.icon;
            String str3 = this.color;
            String str4 = this.description;
            return "StoredAt(text=" + str + ", icon=" + str2 + ", color=" + str3 + ", description=" + str4 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.text);
            parcel.writeString(this.icon);
            parcel.writeString(this.color);
            parcel.writeString(this.description);
        }
    }

    @JsonClass(generateAdapter = true)
    @Parcelize
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006!"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$Tag;", "Landroid/os/Parcelable;", "text", "", "icon", "backgroundColor", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;", "textColor", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;)V", "getBackgroundColor", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$ColorResource;", "getIcon", "()Ljava/lang/String;", "getText", "getTextColor", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Tag implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<Tag> CREATOR = new Creator();
        @Nullable
        private final ColorResource backgroundColor;
        @Nullable
        private final String icon;
        @Nullable
        private final String text;
        @Nullable
        private final ColorResource textColor;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Tag> {
            @NotNull
            public final Tag createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                ColorResource colorResource = null;
                ColorResource createFromParcel = parcel.readInt() == 0 ? null : ColorResource.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    colorResource = ColorResource.CREATOR.createFromParcel(parcel);
                }
                return new Tag(readString, readString2, createFromParcel, colorResource);
            }

            @NotNull
            public final Tag[] newArray(int i11) {
                return new Tag[i11];
            }
        }

        public Tag(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "icon") String str2, @Nullable @Json(name = "background_color") ColorResource colorResource, @Nullable @Json(name = "text_color") ColorResource colorResource2) {
            this.text = str;
            this.icon = str2;
            this.backgroundColor = colorResource;
            this.textColor = colorResource2;
        }

        public static /* synthetic */ Tag copy$default(Tag tag, String str, String str2, ColorResource colorResource, ColorResource colorResource2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = tag.text;
            }
            if ((i11 & 2) != 0) {
                str2 = tag.icon;
            }
            if ((i11 & 4) != 0) {
                colorResource = tag.backgroundColor;
            }
            if ((i11 & 8) != 0) {
                colorResource2 = tag.textColor;
            }
            return tag.copy(str, str2, colorResource, colorResource2);
        }

        @Nullable
        public final String component1() {
            return this.text;
        }

        @Nullable
        public final String component2() {
            return this.icon;
        }

        @Nullable
        public final ColorResource component3() {
            return this.backgroundColor;
        }

        @Nullable
        public final ColorResource component4() {
            return this.textColor;
        }

        @NotNull
        public final Tag copy(@Nullable @Json(name = "text") String str, @Nullable @Json(name = "icon") String str2, @Nullable @Json(name = "background_color") ColorResource colorResource, @Nullable @Json(name = "text_color") ColorResource colorResource2) {
            return new Tag(str, str2, colorResource, colorResource2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tag)) {
                return false;
            }
            Tag tag = (Tag) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) tag.text) && Intrinsics.areEqual((Object) this.icon, (Object) tag.icon) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) tag.backgroundColor) && Intrinsics.areEqual((Object) this.textColor, (Object) tag.textColor);
        }

        @Nullable
        public final ColorResource getBackgroundColor() {
            return this.backgroundColor;
        }

        @Nullable
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        public final String getText() {
            return this.text;
        }

        @Nullable
        public final ColorResource getTextColor() {
            return this.textColor;
        }

        public int hashCode() {
            String str = this.text;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.icon;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ColorResource colorResource = this.backgroundColor;
            int hashCode3 = (hashCode2 + (colorResource == null ? 0 : colorResource.hashCode())) * 31;
            ColorResource colorResource2 = this.textColor;
            if (colorResource2 != null) {
                i11 = colorResource2.hashCode();
            }
            return hashCode3 + i11;
        }

        @NotNull
        public String toString() {
            String str = this.text;
            String str2 = this.icon;
            ColorResource colorResource = this.backgroundColor;
            ColorResource colorResource2 = this.textColor;
            return "Tag(text=" + str + ", icon=" + str2 + ", backgroundColor=" + colorResource + ", textColor=" + colorResource2 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.text);
            parcel.writeString(this.icon);
            ColorResource colorResource = this.backgroundColor;
            if (colorResource == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                colorResource.writeToParcel(parcel, i11);
            }
            ColorResource colorResource2 = this.textColor;
            if (colorResource2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            colorResource2.writeToParcel(parcel, i11);
        }
    }

    public ProductExtendedInfo(@Nullable @Json(name = "tags") List<Tag> list, @Nullable @Json(name = "content_unit") ContentUnit contentUnit2, @Nullable @Json(name = "stored_at") StoredAt storedAt2, @Nullable @Json(name = "country") Country country2, @Nullable @Json(name = "shelf_life") ShelfLife shelfLife2) {
        this.tags = list;
        this.contentUnit = contentUnit2;
        this.storedAt = storedAt2;
        this.country = country2;
        this.shelfLife = shelfLife2;
    }

    public static /* synthetic */ ProductExtendedInfo copy$default(ProductExtendedInfo productExtendedInfo, List<Tag> list, ContentUnit contentUnit2, StoredAt storedAt2, Country country2, ShelfLife shelfLife2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = productExtendedInfo.tags;
        }
        if ((i11 & 2) != 0) {
            contentUnit2 = productExtendedInfo.contentUnit;
        }
        ContentUnit contentUnit3 = contentUnit2;
        if ((i11 & 4) != 0) {
            storedAt2 = productExtendedInfo.storedAt;
        }
        StoredAt storedAt3 = storedAt2;
        if ((i11 & 8) != 0) {
            country2 = productExtendedInfo.country;
        }
        Country country3 = country2;
        if ((i11 & 16) != 0) {
            shelfLife2 = productExtendedInfo.shelfLife;
        }
        return productExtendedInfo.copy(list, contentUnit3, storedAt3, country3, shelfLife2);
    }

    @Nullable
    public final List<Tag> component1() {
        return this.tags;
    }

    @Nullable
    public final ContentUnit component2() {
        return this.contentUnit;
    }

    @Nullable
    public final StoredAt component3() {
        return this.storedAt;
    }

    @Nullable
    public final Country component4() {
        return this.country;
    }

    @Nullable
    public final ShelfLife component5() {
        return this.shelfLife;
    }

    @NotNull
    public final ProductExtendedInfo copy(@Nullable @Json(name = "tags") List<Tag> list, @Nullable @Json(name = "content_unit") ContentUnit contentUnit2, @Nullable @Json(name = "stored_at") StoredAt storedAt2, @Nullable @Json(name = "country") Country country2, @Nullable @Json(name = "shelf_life") ShelfLife shelfLife2) {
        return new ProductExtendedInfo(list, contentUnit2, storedAt2, country2, shelfLife2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductExtendedInfo)) {
            return false;
        }
        ProductExtendedInfo productExtendedInfo = (ProductExtendedInfo) obj;
        return Intrinsics.areEqual((Object) this.tags, (Object) productExtendedInfo.tags) && Intrinsics.areEqual((Object) this.contentUnit, (Object) productExtendedInfo.contentUnit) && Intrinsics.areEqual((Object) this.storedAt, (Object) productExtendedInfo.storedAt) && Intrinsics.areEqual((Object) this.country, (Object) productExtendedInfo.country) && Intrinsics.areEqual((Object) this.shelfLife, (Object) productExtendedInfo.shelfLife);
    }

    @Nullable
    public final ContentUnit getContentUnit() {
        return this.contentUnit;
    }

    @Nullable
    public final Country getCountry() {
        return this.country;
    }

    @Nullable
    public final ShelfLife getShelfLife() {
        return this.shelfLife;
    }

    @Nullable
    public final StoredAt getStoredAt() {
        return this.storedAt;
    }

    @Nullable
    public final List<Tag> getTags() {
        return this.tags;
    }

    @NotNull
    public final String getTrackingData(@Nullable String str) {
        String str2;
        int i11;
        String str3;
        int i12;
        String str4;
        int i13;
        String str5;
        int i14;
        int i15;
        String text;
        Tag tag;
        String text2;
        String text3;
        String text4;
        String code;
        JSONObject jSONObject = new JSONObject();
        Country country2 = this.country;
        String str6 = null;
        if (country2 == null || (code = country2.getCode()) == null) {
            str2 = null;
        } else {
            str2 = StringsKt__StringsKt.trim((CharSequence) code).toString();
        }
        int i16 = 0;
        if (str2 == null || str2.length() == 0) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        jSONObject.put("country", i11 ^ 1);
        ContentUnit contentUnit2 = this.contentUnit;
        if (contentUnit2 == null || (text4 = contentUnit2.getText()) == null) {
            str3 = null;
        } else {
            str3 = StringsKt__StringsKt.trim((CharSequence) text4).toString();
        }
        if (str3 == null || str3.length() == 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        jSONObject.put("weight", i12 ^ 1);
        StoredAt storedAt2 = this.storedAt;
        if (storedAt2 == null || (text3 = storedAt2.getText()) == null) {
            str4 = null;
        } else {
            str4 = StringsKt__StringsKt.trim((CharSequence) text3).toString();
        }
        if (str4 == null || str4.length() == 0) {
            i13 = 1;
        } else {
            i13 = 0;
        }
        jSONObject.put("temp", i13 ^ 1);
        List<Tag> list = this.tags;
        if (list == null || (tag = (Tag) CollectionsKt___CollectionsKt.getOrNull(list, 0)) == null || (text2 = tag.getText()) == null) {
            str5 = null;
        } else {
            str5 = StringsKt__StringsKt.trim((CharSequence) text2).toString();
        }
        if (str5 == null || str5.length() == 0) {
            i14 = 1;
        } else {
            i14 = 0;
        }
        jSONObject.put("tag", i14 ^ 1);
        ShelfLife shelfLife2 = this.shelfLife;
        if (!(shelfLife2 == null || (text = shelfLife2.getText()) == null)) {
            str6 = StringsKt__StringsKt.trim((CharSequence) text).toString();
        }
        if (str6 == null || str6.length() == 0) {
            i15 = 1;
        } else {
            i15 = 0;
        }
        jSONObject.put("shelf_life", i15 ^ 1);
        if (str == null || str.length() == 0) {
            i16 = 1;
        }
        jSONObject.put("desc", i16 ^ 1);
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObjectInstrumentation, "JSONObject().apply {\n   …e 1)\n        }.toString()");
        return jSONObjectInstrumentation;
    }

    public int hashCode() {
        List<Tag> list = this.tags;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ContentUnit contentUnit2 = this.contentUnit;
        int hashCode2 = (hashCode + (contentUnit2 == null ? 0 : contentUnit2.hashCode())) * 31;
        StoredAt storedAt2 = this.storedAt;
        int hashCode3 = (hashCode2 + (storedAt2 == null ? 0 : storedAt2.hashCode())) * 31;
        Country country2 = this.country;
        int hashCode4 = (hashCode3 + (country2 == null ? 0 : country2.hashCode())) * 31;
        ShelfLife shelfLife2 = this.shelfLife;
        if (shelfLife2 != null) {
            i11 = shelfLife2.hashCode();
        }
        return hashCode4 + i11;
    }

    public final boolean isInValidProductExtendedInfo() {
        String str;
        boolean z11;
        String str2;
        boolean z12;
        String str3;
        boolean z13;
        boolean z14;
        String text;
        String code;
        String text2;
        String text3;
        ContentUnit contentUnit2 = this.contentUnit;
        String str4 = null;
        if (contentUnit2 == null || (text3 = contentUnit2.getText()) == null) {
            str = null;
        } else {
            str = StringsKt__StringsKt.trim((CharSequence) text3).toString();
        }
        if (str == null || str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        StoredAt storedAt2 = this.storedAt;
        if (storedAt2 == null || (text2 = storedAt2.getText()) == null) {
            str2 = null;
        } else {
            str2 = StringsKt__StringsKt.trim((CharSequence) text2).toString();
        }
        if (str2 == null || str2.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        Country country2 = this.country;
        if (country2 == null || (code = country2.getCode()) == null) {
            str3 = null;
        } else {
            str3 = StringsKt__StringsKt.trim((CharSequence) code).toString();
        }
        if (str3 == null || str3.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            return false;
        }
        ShelfLife shelfLife2 = this.shelfLife;
        if (!(shelfLife2 == null || (text = shelfLife2.getText()) == null)) {
            str4 = StringsKt__StringsKt.trim((CharSequence) text).toString();
        }
        if (str4 == null || str4.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        List<Tag> list = this.tags;
        ContentUnit contentUnit2 = this.contentUnit;
        StoredAt storedAt2 = this.storedAt;
        Country country2 = this.country;
        ShelfLife shelfLife2 = this.shelfLife;
        return "ProductExtendedInfo(tags=" + list + ", contentUnit=" + contentUnit2 + ", storedAt=" + storedAt2 + ", country=" + country2 + ", shelfLife=" + shelfLife2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<Tag> list = this.tags;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Tag writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i11);
            }
        }
        ContentUnit contentUnit2 = this.contentUnit;
        if (contentUnit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            contentUnit2.writeToParcel(parcel, i11);
        }
        StoredAt storedAt2 = this.storedAt;
        if (storedAt2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            storedAt2.writeToParcel(parcel, i11);
        }
        Country country2 = this.country;
        if (country2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            country2.writeToParcel(parcel, i11);
        }
        ShelfLife shelfLife2 = this.shelfLife;
        if (shelfLife2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        shelfLife2.writeToParcel(parcel, i11);
    }
}
