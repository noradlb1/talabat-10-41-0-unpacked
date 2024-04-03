package com.talabat.splash.domain.model.location;

import android.location.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/domain/model/location/LocationRequestWrapper;", "", "()V", "LocationRequestDeny", "LocationRequestSuccess", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestDeny;", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestSuccess;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LocationRequestWrapper {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestDeny;", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper;", "locationRequestStatus", "", "DenyType", "", "(ZI)V", "getDenyType", "()I", "getLocationRequestStatus", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationRequestDeny extends LocationRequestWrapper {
        private final int DenyType;
        private final boolean locationRequestStatus;

        public LocationRequestDeny(boolean z11, int i11) {
            super((DefaultConstructorMarker) null);
            this.locationRequestStatus = z11;
            this.DenyType = i11;
        }

        public static /* synthetic */ LocationRequestDeny copy$default(LocationRequestDeny locationRequestDeny, boolean z11, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                z11 = locationRequestDeny.locationRequestStatus;
            }
            if ((i12 & 2) != 0) {
                i11 = locationRequestDeny.DenyType;
            }
            return locationRequestDeny.copy(z11, i11);
        }

        public final boolean component1() {
            return this.locationRequestStatus;
        }

        public final int component2() {
            return this.DenyType;
        }

        @NotNull
        public final LocationRequestDeny copy(boolean z11, int i11) {
            return new LocationRequestDeny(z11, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationRequestDeny)) {
                return false;
            }
            LocationRequestDeny locationRequestDeny = (LocationRequestDeny) obj;
            return this.locationRequestStatus == locationRequestDeny.locationRequestStatus && this.DenyType == locationRequestDeny.DenyType;
        }

        public final int getDenyType() {
            return this.DenyType;
        }

        public final boolean getLocationRequestStatus() {
            return this.locationRequestStatus;
        }

        public int hashCode() {
            boolean z11 = this.locationRequestStatus;
            if (z11) {
                z11 = true;
            }
            return ((z11 ? 1 : 0) * true) + this.DenyType;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.locationRequestStatus;
            int i11 = this.DenyType;
            return "LocationRequestDeny(locationRequestStatus=" + z11 + ", DenyType=" + i11 + ")";
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestSuccess;", "Lcom/talabat/splash/domain/model/location/LocationRequestWrapper;", "locationRequestStatus", "", "locationAccuracy", "", "location", "Landroid/location/Location;", "(ZLjava/lang/Float;Landroid/location/Location;)V", "getLocation", "()Landroid/location/Location;", "getLocationAccuracy", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLocationRequestStatus", "()Z", "component1", "component2", "component3", "copy", "(ZLjava/lang/Float;Landroid/location/Location;)Lcom/talabat/splash/domain/model/location/LocationRequestWrapper$LocationRequestSuccess;", "equals", "other", "", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LocationRequestSuccess extends LocationRequestWrapper {
        @Nullable
        private final Location location;
        @Nullable
        private final Float locationAccuracy;
        private final boolean locationRequestStatus;

        public LocationRequestSuccess(boolean z11, @Nullable Float f11, @Nullable Location location2) {
            super((DefaultConstructorMarker) null);
            this.locationRequestStatus = z11;
            this.locationAccuracy = f11;
            this.location = location2;
        }

        public static /* synthetic */ LocationRequestSuccess copy$default(LocationRequestSuccess locationRequestSuccess, boolean z11, Float f11, Location location2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = locationRequestSuccess.locationRequestStatus;
            }
            if ((i11 & 2) != 0) {
                f11 = locationRequestSuccess.locationAccuracy;
            }
            if ((i11 & 4) != 0) {
                location2 = locationRequestSuccess.location;
            }
            return locationRequestSuccess.copy(z11, f11, location2);
        }

        public final boolean component1() {
            return this.locationRequestStatus;
        }

        @Nullable
        public final Float component2() {
            return this.locationAccuracy;
        }

        @Nullable
        public final Location component3() {
            return this.location;
        }

        @NotNull
        public final LocationRequestSuccess copy(boolean z11, @Nullable Float f11, @Nullable Location location2) {
            return new LocationRequestSuccess(z11, f11, location2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationRequestSuccess)) {
                return false;
            }
            LocationRequestSuccess locationRequestSuccess = (LocationRequestSuccess) obj;
            return this.locationRequestStatus == locationRequestSuccess.locationRequestStatus && Intrinsics.areEqual((Object) this.locationAccuracy, (Object) locationRequestSuccess.locationAccuracy) && Intrinsics.areEqual((Object) this.location, (Object) locationRequestSuccess.location);
        }

        @Nullable
        public final Location getLocation() {
            return this.location;
        }

        @Nullable
        public final Float getLocationAccuracy() {
            return this.locationAccuracy;
        }

        public final boolean getLocationRequestStatus() {
            return this.locationRequestStatus;
        }

        public int hashCode() {
            boolean z11 = this.locationRequestStatus;
            if (z11) {
                z11 = true;
            }
            int i11 = (z11 ? 1 : 0) * true;
            Float f11 = this.locationAccuracy;
            int i12 = 0;
            int hashCode = (i11 + (f11 == null ? 0 : f11.hashCode())) * 31;
            Location location2 = this.location;
            if (location2 != null) {
                i12 = location2.hashCode();
            }
            return hashCode + i12;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.locationRequestStatus;
            Float f11 = this.locationAccuracy;
            Location location2 = this.location;
            return "LocationRequestSuccess(locationRequestStatus=" + z11 + ", locationAccuracy=" + f11 + ", location=" + location2 + ")";
        }
    }

    private LocationRequestWrapper() {
    }

    public /* synthetic */ LocationRequestWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
