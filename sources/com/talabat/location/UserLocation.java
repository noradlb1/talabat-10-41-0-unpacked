package com.talabat.location;

import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/location/UserLocation;", "", "()V", "WithAddress", "WithoutAddress", "Lcom/talabat/location/UserLocation$WithAddress;", "Lcom/talabat/location/UserLocation$WithoutAddress;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class UserLocation {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/location/UserLocation$WithAddress;", "Lcom/talabat/location/UserLocation;", "address", "Lcom/talabat/domain/address/Address;", "(Lcom/talabat/domain/address/Address;)V", "getAddress", "()Lcom/talabat/domain/address/Address;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithAddress extends UserLocation {
        @NotNull
        private final Address address;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithAddress(@NotNull Address address2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(address2, "address");
            this.address = address2;
        }

        public static /* synthetic */ WithAddress copy$default(WithAddress withAddress, Address address2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                address2 = withAddress.address;
            }
            return withAddress.copy(address2);
        }

        @NotNull
        public final Address component1() {
            return this.address;
        }

        @NotNull
        public final WithAddress copy(@NotNull Address address2) {
            Intrinsics.checkNotNullParameter(address2, "address");
            return new WithAddress(address2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WithAddress) && Intrinsics.areEqual((Object) this.address, (Object) ((WithAddress) obj).address);
        }

        @NotNull
        public final Address getAddress() {
            return this.address;
        }

        public int hashCode() {
            return this.address.hashCode();
        }

        @NotNull
        public String toString() {
            Address address2 = this.address;
            return "WithAddress(address=" + address2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/talabat/location/UserLocation$WithoutAddress;", "Lcom/talabat/location/UserLocation;", "areaId", "", "areaName", "", "latitude", "", "longitude", "cityId", "(ILjava/lang/String;DDI)V", "getAreaId", "()I", "getAreaName", "()Ljava/lang/String;", "getCityId", "getLatitude", "()D", "getLongitude", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WithoutAddress extends UserLocation {
        private final int areaId;
        @NotNull
        private final String areaName;
        private final int cityId;
        private final double latitude;
        private final double longitude;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WithoutAddress(int i11, @NotNull String str, double d11, double d12, int i12) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "areaName");
            this.areaId = i11;
            this.areaName = str;
            this.latitude = d11;
            this.longitude = d12;
            this.cityId = i12;
        }

        public static /* synthetic */ WithoutAddress copy$default(WithoutAddress withoutAddress, int i11, String str, double d11, double d12, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = withoutAddress.areaId;
            }
            if ((i13 & 2) != 0) {
                str = withoutAddress.areaName;
            }
            String str2 = str;
            if ((i13 & 4) != 0) {
                d11 = withoutAddress.latitude;
            }
            double d13 = d11;
            if ((i13 & 8) != 0) {
                d12 = withoutAddress.longitude;
            }
            double d14 = d12;
            if ((i13 & 16) != 0) {
                i12 = withoutAddress.cityId;
            }
            return withoutAddress.copy(i11, str2, d13, d14, i12);
        }

        public final int component1() {
            return this.areaId;
        }

        @NotNull
        public final String component2() {
            return this.areaName;
        }

        public final double component3() {
            return this.latitude;
        }

        public final double component4() {
            return this.longitude;
        }

        public final int component5() {
            return this.cityId;
        }

        @NotNull
        public final WithoutAddress copy(int i11, @NotNull String str, double d11, double d12, int i12) {
            Intrinsics.checkNotNullParameter(str, "areaName");
            return new WithoutAddress(i11, str, d11, d12, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WithoutAddress)) {
                return false;
            }
            WithoutAddress withoutAddress = (WithoutAddress) obj;
            return this.areaId == withoutAddress.areaId && Intrinsics.areEqual((Object) this.areaName, (Object) withoutAddress.areaName) && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(withoutAddress.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(withoutAddress.longitude)) && this.cityId == withoutAddress.cityId;
        }

        public final int getAreaId() {
            return this.areaId;
        }

        @NotNull
        public final String getAreaName() {
            return this.areaName;
        }

        public final int getCityId() {
            return this.cityId;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            return (((((((this.areaId * 31) + this.areaName.hashCode()) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.cityId;
        }

        @NotNull
        public String toString() {
            int i11 = this.areaId;
            String str = this.areaName;
            double d11 = this.latitude;
            double d12 = this.longitude;
            int i12 = this.cityId;
            return "WithoutAddress(areaId=" + i11 + ", areaName=" + str + ", latitude=" + d11 + ", longitude=" + d12 + ", cityId=" + i12 + ")";
        }
    }

    private UserLocation() {
    }

    public /* synthetic */ UserLocation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
