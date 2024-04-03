package com.deliveryhero.chatui.view.chatroom;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "", "()V", "Hidden", "Location", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage$Hidden;", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage$Location;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class LocationMessage {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/LocationMessage$Hidden;", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "()V", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Hidden extends LocationMessage {
        @NotNull
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/LocationMessage$Location;", "Lcom/deliveryhero/chatui/view/chatroom/LocationMessage;", "latitude", "", "longitude", "(DD)V", "getLatitude", "()D", "getLongitude", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Location extends LocationMessage {
        private final double latitude;
        private final double longitude;

        public Location(double d11, double d12) {
            super((DefaultConstructorMarker) null);
            this.latitude = d11;
            this.longitude = d12;
        }

        public static /* synthetic */ Location copy$default(Location location, double d11, double d12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                d11 = location.latitude;
            }
            if ((i11 & 2) != 0) {
                d12 = location.longitude;
            }
            return location.copy(d11, d12);
        }

        public final double component1() {
            return this.latitude;
        }

        public final double component2() {
            return this.longitude;
        }

        @NotNull
        public final Location copy(double d11, double d12) {
            return new Location(d11, d12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Location)) {
                return false;
            }
            Location location = (Location) obj;
            return Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(location.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(location.longitude));
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public int hashCode() {
            return (Double.doubleToLongBits(this.latitude) * 31) + Double.doubleToLongBits(this.longitude);
        }

        @NotNull
        public String toString() {
            return "Location(latitude=" + this.latitude + ", longitude=" + this.longitude + ')';
        }
    }

    private LocationMessage() {
    }

    public /* synthetic */ LocationMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
