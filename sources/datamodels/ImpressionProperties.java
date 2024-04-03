package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BI\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001J\b\u0010 \u001a\u00020\u0006H\u0016J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010¨\u0006+"}, d2 = {"Ldatamodels/ImpressionProperties;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "position", "", "id", "", "name", "brand", "list", "category", "variant", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getCategory", "getId", "getList", "getName", "getPosition", "()I", "getVariant", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImpressionProperties implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    @SerializedName("item_brand")
    @Nullable
    private final String brand;
    @SerializedName("item_category")
    @Nullable
    private final String category;
    @SerializedName("item_id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f13856id;
    @SerializedName("item_list")
    @Nullable
    private final String list;
    @SerializedName("item_name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f13857name;
    @SerializedName("index")
    private final int position;
    @SerializedName("item_variant")
    @Nullable
    private final String variant;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Ldatamodels/ImpressionProperties$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ldatamodels/ImpressionProperties;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ldatamodels/ImpressionProperties;", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ImpressionProperties> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public ImpressionProperties createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImpressionProperties(parcel);
        }

        @NotNull
        public ImpressionProperties[] newArray(int i11) {
            return new ImpressionProperties[i11];
        }
    }

    public ImpressionProperties(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.position = i11;
        this.f13856id = str;
        this.f13857name = str2;
        this.brand = str3;
        this.list = str4;
        this.category = str5;
        this.variant = str6;
    }

    public static /* synthetic */ ImpressionProperties copy$default(ImpressionProperties impressionProperties, int i11, String str, String str2, String str3, String str4, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = impressionProperties.position;
        }
        if ((i12 & 2) != 0) {
            str = impressionProperties.f13856id;
        }
        String str7 = str;
        if ((i12 & 4) != 0) {
            str2 = impressionProperties.f13857name;
        }
        String str8 = str2;
        if ((i12 & 8) != 0) {
            str3 = impressionProperties.brand;
        }
        String str9 = str3;
        if ((i12 & 16) != 0) {
            str4 = impressionProperties.list;
        }
        String str10 = str4;
        if ((i12 & 32) != 0) {
            str5 = impressionProperties.category;
        }
        String str11 = str5;
        if ((i12 & 64) != 0) {
            str6 = impressionProperties.variant;
        }
        return impressionProperties.copy(i11, str7, str8, str9, str10, str11, str6);
    }

    public final int component1() {
        return this.position;
    }

    @Nullable
    public final String component2() {
        return this.f13856id;
    }

    @Nullable
    public final String component3() {
        return this.f13857name;
    }

    @Nullable
    public final String component4() {
        return this.brand;
    }

    @Nullable
    public final String component5() {
        return this.list;
    }

    @Nullable
    public final String component6() {
        return this.category;
    }

    @Nullable
    public final String component7() {
        return this.variant;
    }

    @NotNull
    public final ImpressionProperties copy(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new ImpressionProperties(i11, str, str2, str3, str4, str5, str6);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImpressionProperties)) {
            return false;
        }
        ImpressionProperties impressionProperties = (ImpressionProperties) obj;
        return this.position == impressionProperties.position && Intrinsics.areEqual((Object) this.f13856id, (Object) impressionProperties.f13856id) && Intrinsics.areEqual((Object) this.f13857name, (Object) impressionProperties.f13857name) && Intrinsics.areEqual((Object) this.brand, (Object) impressionProperties.brand) && Intrinsics.areEqual((Object) this.list, (Object) impressionProperties.list) && Intrinsics.areEqual((Object) this.category, (Object) impressionProperties.category) && Intrinsics.areEqual((Object) this.variant, (Object) impressionProperties.variant);
    }

    @Nullable
    public final String getBrand() {
        return this.brand;
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final String getId() {
        return this.f13856id;
    }

    @Nullable
    public final String getList() {
        return this.list;
    }

    @Nullable
    public final String getName() {
        return this.f13857name;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final String getVariant() {
        return this.variant;
    }

    public int hashCode() {
        int i11 = this.position * 31;
        String str = this.f13856id;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f13857name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.brand;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.list;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.category;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.variant;
        if (str6 != null) {
            i12 = str6.hashCode();
        }
        return hashCode5 + i12;
    }

    @NotNull
    public String toString() {
        int i11 = this.position;
        String str = this.f13856id;
        String str2 = this.f13857name;
        String str3 = this.brand;
        String str4 = this.list;
        String str5 = this.category;
        String str6 = this.variant;
        return "ImpressionProperties(position=" + i11 + ", id=" + str + ", name=" + str2 + ", brand=" + str3 + ", list=" + str4 + ", category=" + str5 + ", variant=" + str6 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.position);
        parcel.writeString(this.f13856id);
        parcel.writeString(this.f13857name);
        parcel.writeString(this.brand);
        parcel.writeString(this.list);
        parcel.writeString(this.category);
        parcel.writeString(this.variant);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImpressionProperties(@NotNull Parcel parcel) {
        this(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
