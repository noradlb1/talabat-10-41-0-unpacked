package com.designsystem.ds_input_field.country;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.tekartik.sqflite.Constant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JN\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006("}, d2 = {"Lcom/designsystem/ds_input_field/country/DSCountryModel;", "Landroid/os/Parcelable;", "prefix", "", "image", "", "name", "code", "nameTranslations", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getCode", "()Ljava/lang/String;", "getImage$marshmallow_release", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getNameTranslations", "()Ljava/util/Map;", "getPrefix", "component1", "component2", "component2$marshmallow_release", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/designsystem/ds_input_field/country/DSCountryModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Parcelize
public final class DSCountryModel implements Parcelable {
    public static final int $stable = 8;
    @NotNull
    public static final Parcelable.Creator<DSCountryModel> CREATOR = new Creator();
    @NotNull
    private final String code;
    @Nullable
    private final Integer image;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f31937name;
    @NotNull
    private final Map<String, String> nameTranslations;
    @NotNull
    private final String prefix;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DSCountryModel> {
        @NotNull
        public final DSCountryModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new DSCountryModel(readString, valueOf, readString2, readString3, linkedHashMap);
        }

        @NotNull
        public final DSCountryModel[] newArray(int i11) {
            return new DSCountryModel[i11];
        }
    }

    public DSCountryModel(@NotNull String str, @Nullable @DrawableRes Integer num, @NotNull String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(map, "nameTranslations");
        this.prefix = str;
        this.image = num;
        this.f31937name = str2;
        this.code = str3;
        this.nameTranslations = map;
    }

    public static /* synthetic */ DSCountryModel copy$default(DSCountryModel dSCountryModel, String str, Integer num, String str2, String str3, Map<String, String> map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dSCountryModel.prefix;
        }
        if ((i11 & 2) != 0) {
            num = dSCountryModel.image;
        }
        Integer num2 = num;
        if ((i11 & 4) != 0) {
            str2 = dSCountryModel.f31937name;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            str3 = dSCountryModel.code;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            map = dSCountryModel.nameTranslations;
        }
        return dSCountryModel.copy(str, num2, str4, str5, map);
    }

    @NotNull
    public final String component1() {
        return this.prefix;
    }

    @Nullable
    public final Integer component2$marshmallow_release() {
        return this.image;
    }

    @NotNull
    public final String component3() {
        return this.f31937name;
    }

    @NotNull
    public final String component4() {
        return this.code;
    }

    @NotNull
    public final Map<String, String> component5() {
        return this.nameTranslations;
    }

    @NotNull
    public final DSCountryModel copy(@NotNull String str, @Nullable @DrawableRes Integer num, @NotNull String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(map, "nameTranslations");
        return new DSCountryModel(str, num, str2, str3, map);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSCountryModel)) {
            return false;
        }
        DSCountryModel dSCountryModel = (DSCountryModel) obj;
        return Intrinsics.areEqual((Object) this.prefix, (Object) dSCountryModel.prefix) && Intrinsics.areEqual((Object) this.image, (Object) dSCountryModel.image) && Intrinsics.areEqual((Object) this.f31937name, (Object) dSCountryModel.f31937name) && Intrinsics.areEqual((Object) this.code, (Object) dSCountryModel.code) && Intrinsics.areEqual((Object) this.nameTranslations, (Object) dSCountryModel.nameTranslations);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final Integer getImage$marshmallow_release() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.f31937name;
    }

    @NotNull
    public final Map<String, String> getNameTranslations() {
        return this.nameTranslations;
    }

    @NotNull
    public final String getPrefix() {
        return this.prefix;
    }

    public int hashCode() {
        int hashCode = this.prefix.hashCode() * 31;
        Integer num = this.image;
        return ((((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + this.f31937name.hashCode()) * 31) + this.code.hashCode()) * 31) + this.nameTranslations.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSCountryModel(prefix=" + this.prefix + ", image=" + this.image + ", name=" + this.f31937name + ", code=" + this.code + ", nameTranslations=" + this.nameTranslations + ')';
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.prefix);
        Integer num = this.image;
        if (num == null) {
            i12 = 0;
        } else {
            parcel.writeInt(1);
            i12 = num.intValue();
        }
        parcel.writeInt(i12);
        parcel.writeString(this.f31937name);
        parcel.writeString(this.code);
        Map<String, String> map = this.nameTranslations;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSCountryModel(String str, Integer num, String str2, String str3, Map map, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num, str2, str3, map);
    }
}
