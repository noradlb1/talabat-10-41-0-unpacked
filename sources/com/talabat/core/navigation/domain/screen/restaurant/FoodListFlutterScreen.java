package com.talabat.core.navigation.domain.screen.restaurant;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/restaurant/FoodListFlutterScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/restaurant/FoodListFlutterScreen$FoodListFlutterData;", "data", "(Lcom/talabat/core/navigation/domain/screen/restaurant/FoodListFlutterScreen$FoodListFlutterData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/restaurant/FoodListFlutterScreen$FoodListFlutterData;", "link", "", "getLink", "()Ljava/lang/String;", "FoodListFlutterData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoodListFlutterScreen implements Screen<FoodListFlutterData> {
    @NotNull
    private final FoodListFlutterData data;
    @NotNull
    private final String link = "com.talabat.FoodListFlutterActivity";

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\tHÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006("}, d2 = {"Lcom/talabat/core/navigation/domain/screen/restaurant/FoodListFlutterScreen$FoodListFlutterData;", "Landroid/os/Parcelable;", "latitude", "", "longitude", "areaId", "", "cityId", "countryId", "", "areaName", "(DDLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAreaId", "()Ljava/lang/String;", "getAreaName", "getCityId", "getCountryId", "()I", "getLatitude", "()D", "getLongitude", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class FoodListFlutterData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<FoodListFlutterData> CREATOR = new Creator();
        @NotNull
        private final String areaId;
        @NotNull
        private final String areaName;
        @NotNull
        private final String cityId;
        private final int countryId;
        private final double latitude;
        private final double longitude;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<FoodListFlutterData> {
            @NotNull
            public final FoodListFlutterData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FoodListFlutterData(parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
            }

            @NotNull
            public final FoodListFlutterData[] newArray(int i11) {
                return new FoodListFlutterData[i11];
            }
        }

        public FoodListFlutterData(double d11, double d12, @NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "areaId");
            Intrinsics.checkNotNullParameter(str2, "cityId");
            Intrinsics.checkNotNullParameter(str3, "areaName");
            this.latitude = d11;
            this.longitude = d12;
            this.areaId = str;
            this.cityId = str2;
            this.countryId = i11;
            this.areaName = str3;
        }

        public static /* synthetic */ FoodListFlutterData copy$default(FoodListFlutterData foodListFlutterData, double d11, double d12, String str, String str2, int i11, String str3, int i12, Object obj) {
            FoodListFlutterData foodListFlutterData2 = foodListFlutterData;
            return foodListFlutterData.copy((i12 & 1) != 0 ? foodListFlutterData2.latitude : d11, (i12 & 2) != 0 ? foodListFlutterData2.longitude : d12, (i12 & 4) != 0 ? foodListFlutterData2.areaId : str, (i12 & 8) != 0 ? foodListFlutterData2.cityId : str2, (i12 & 16) != 0 ? foodListFlutterData2.countryId : i11, (i12 & 32) != 0 ? foodListFlutterData2.areaName : str3);
        }

        public final double component1() {
            return this.latitude;
        }

        public final double component2() {
            return this.longitude;
        }

        @NotNull
        public final String component3() {
            return this.areaId;
        }

        @NotNull
        public final String component4() {
            return this.cityId;
        }

        public final int component5() {
            return this.countryId;
        }

        @NotNull
        public final String component6() {
            return this.areaName;
        }

        @NotNull
        public final FoodListFlutterData copy(double d11, double d12, @NotNull String str, @NotNull String str2, int i11, @NotNull String str3) {
            Intrinsics.checkNotNullParameter(str, "areaId");
            String str4 = str2;
            Intrinsics.checkNotNullParameter(str4, "cityId");
            String str5 = str3;
            Intrinsics.checkNotNullParameter(str5, "areaName");
            return new FoodListFlutterData(d11, d12, str, str4, i11, str5);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FoodListFlutterData)) {
                return false;
            }
            FoodListFlutterData foodListFlutterData = (FoodListFlutterData) obj;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(foodListFlutterData.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(foodListFlutterData.longitude)) && Intrinsics.areEqual((Object) this.areaId, (Object) foodListFlutterData.areaId) && Intrinsics.areEqual((Object) this.cityId, (Object) foodListFlutterData.cityId) && this.countryId == foodListFlutterData.countryId && Intrinsics.areEqual((Object) this.areaName, (Object) foodListFlutterData.areaName);
        }

        @NotNull
        public final String getAreaId() {
            return this.areaId;
        }

        @NotNull
        public final String getAreaName() {
            return this.areaName;
        }

        @NotNull
        public final String getCityId() {
            return this.cityId;
        }

        public final int getCountryId() {
            return this.countryId;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            return (((((((((Double.doubleToLongBits(this.latitude) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.areaId.hashCode()) * 31) + this.cityId.hashCode()) * 31) + this.countryId) * 31) + this.areaName.hashCode();
        }

        @NotNull
        public String toString() {
            double d11 = this.latitude;
            double d12 = this.longitude;
            String str = this.areaId;
            String str2 = this.cityId;
            int i11 = this.countryId;
            String str3 = this.areaName;
            return "FoodListFlutterData(latitude=" + d11 + ", longitude=" + d12 + ", areaId=" + str + ", cityId=" + str2 + ", countryId=" + i11 + ", areaName=" + str3 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeDouble(this.latitude);
            parcel.writeDouble(this.longitude);
            parcel.writeString(this.areaId);
            parcel.writeString(this.cityId);
            parcel.writeInt(this.countryId);
            parcel.writeString(this.areaName);
        }
    }

    public FoodListFlutterScreen(@NotNull FoodListFlutterData foodListFlutterData) {
        Intrinsics.checkNotNullParameter(foodListFlutterData, "data");
        this.data = foodListFlutterData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public FoodListFlutterData getData() {
        return this.data;
    }
}
