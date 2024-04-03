package com.talabat.designhelpers.UnifiedTracking;

import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator;", "", "interpolate", "Lcom/talabat/maps/domain/model/LatLng;", "fraction", "", "a", "b", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "Linear", "Spherical", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LatLngInterpolator {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator$Linear;", "Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator;", "()V", "interpolate", "Lcom/talabat/maps/domain/model/LatLng;", "fraction", "", "a", "b", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Linear implements LatLngInterpolator {
        @NotNull
        public LatLng interpolate(float f11, @NotNull LatLng latLng, @NotNull LatLng latLng2, @NotNull LatLngFactory latLngFactory) {
            Intrinsics.checkNotNullParameter(latLng, "a");
            Intrinsics.checkNotNullParameter(latLng2, "b");
            Intrinsics.checkNotNullParameter(latLngFactory, "latLngFactory");
            double d11 = (double) f11;
            return latLngFactory.createLatLng(((latLng2.getLatitude() - latLng.getLatitude()) * d11) + latLng.getLatitude(), ((latLng2.getLongitude() - latLng.getLongitude()) * d11) + latLng.getLongitude());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator$Spherical;", "Lcom/talabat/designhelpers/UnifiedTracking/LatLngInterpolator;", "()V", "computeAngleBetween", "", "fromLat", "fromLng", "toLat", "toLng", "interpolate", "Lcom/talabat/maps/domain/model/LatLng;", "fraction", "", "from", "to", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Spherical implements LatLngInterpolator {
        private final double computeAngleBetween(double d11, double d12, double d13, double d14) {
            double d15 = d12 - d14;
            double d16 = (double) 2;
            return d16 * Math.asin(Math.sqrt(Math.pow(Math.sin((d11 - d13) / d16), 2.0d) + (Math.cos(d11) * Math.cos(d13) * Math.pow(Math.sin(d15 / d16), 2.0d))));
        }

        @NotNull
        public LatLng interpolate(float f11, @NotNull LatLng latLng, @NotNull LatLng latLng2, @NotNull LatLngFactory latLngFactory) {
            float f12 = f11;
            LatLng latLng3 = latLng;
            LatLngFactory latLngFactory2 = latLngFactory;
            Intrinsics.checkNotNullParameter(latLng3, "from");
            Intrinsics.checkNotNullParameter(latLng2, "to");
            Intrinsics.checkNotNullParameter(latLngFactory2, "latLngFactory");
            double radians = Math.toRadians(latLng.getLatitude());
            double radians2 = Math.toRadians(latLng.getLongitude());
            double radians3 = Math.toRadians(latLng2.getLatitude());
            double radians4 = Math.toRadians(latLng2.getLongitude());
            double cos = Math.cos(radians);
            double cos2 = Math.cos(radians3);
            double computeAngleBetween = computeAngleBetween(radians, radians2, radians3, radians4);
            double sin = Math.sin(computeAngleBetween);
            if (sin < 1.0E-6d) {
                return latLng3;
            }
            double sin2 = Math.sin(((double) (((float) 1) - f12)) * computeAngleBetween) / sin;
            double sin3 = Math.sin(((double) f12) * computeAngleBetween) / sin;
            double d11 = cos * sin2;
            double d12 = cos2 * sin3;
            double cos3 = (Math.cos(radians2) * d11) + (Math.cos(radians4) * d12);
            double sin4 = (d11 * Math.sin(radians2)) + (d12 * Math.sin(radians4));
            return latLngFactory2.createLatLng(Math.toDegrees(Math.atan2((sin2 * Math.sin(radians)) + (sin3 * Math.sin(radians3)), Math.sqrt((cos3 * cos3) + (sin4 * sin4)))), Math.toDegrees(Math.atan2(sin4, cos3)));
        }
    }

    @NotNull
    LatLng interpolate(float f11, @NotNull LatLng latLng, @NotNull LatLng latLng2, @NotNull LatLngFactory latLngFactory);
}
