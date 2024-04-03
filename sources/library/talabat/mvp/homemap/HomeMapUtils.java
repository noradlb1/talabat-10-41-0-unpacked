package library.talabat.mvp.homemap;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.helpers.GlobalDataModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ&\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¨\u0006\u001c"}, d2 = {"Llibrary/talabat/mvp/homemap/HomeMapUtils;", "", "()V", "areaCenterLatLg", "Lcom/google/android/gms/maps/model/LatLng;", "userSelectedAreaId", "", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "countryLatLngBounds", "Lcom/google/android/gms/maps/model/LatLngBounds;", "defaultCountryLatLang", "deg2rad", "", "deg", "distanceBetween", "", "firstLatitude", "firstLongitude", "secondLatitude", "secondLongitude", "distanceBetweenTwoCordinatesbet", "lat1", "lon1", "lat2", "lon2", "rad2deg", "rad", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapUtils {
    @NotNull
    public static final HomeMapUtils INSTANCE = new HomeMapUtils();

    private HomeMapUtils() {
    }

    private final double deg2rad(double d11) {
        return (d11 * 3.141592653589793d) / 180.0d;
    }

    private final double rad2deg(double d11) {
        return (d11 * 180.0d) / 3.141592653589793d;
    }

    @Nullable
    public final LatLng areaCenterLatLg(int i11, @NotNull LocationConfigurationRepository locationConfigurationRepository) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository, "locationConfigurationRepository");
        int i12 = GlobalDataModel.SelectedAreaId;
        LatLng latLng = null;
        if (i12 > 0 || i11 > 0) {
            if (i11 <= 0) {
                i11 = i12;
            }
            List<Area> areas = locationConfigurationRepository.areas();
            if (!areas.isEmpty()) {
                for (Area next : areas) {
                    if (next.getId() == i11) {
                        latLng = new LatLng(next.getAreaCenterPointCoordinates().getLatitude(), next.getAreaCenterPointCoordinates().getLongitude());
                    }
                }
            }
        }
        return latLng;
    }

    @Nullable
    public final LatLngBounds countryLatLngBounds() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return new LatLngBounds(new LatLng(28.408312587374258d, 46.395263671875d), new LatLng(30.261439550638762d, 48.85345458984374d));
        }
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return new LatLngBounds(new LatLng(5.834616165610059d, 25.3125d), new LatLng(46.31658418182218d, 66.26953125d));
        }
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return new LatLngBounds(new LatLng(25.611809521055477d, 50.07019042968749d), new LatLng(26.745610382199022d, 50.8282470703125d));
        }
        if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            return new LatLngBounds(new LatLng(23.96115620034201d, 50.548095703125d), new LatLng(26.61799672211676d, 51.6961669921875d));
        }
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            return new LatLngBounds(new LatLng(14.370833973406821d, 48.09814453125d), new LatLng(28.671310915880834d, 62.314453125d));
        }
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            return new LatLngBounds(new LatLng(18.239134d, 47.746582d), new LatLng(29.806987d, 58.590088d));
        }
        return null;
    }

    @Nullable
    public final LatLng defaultCountryLatLang() {
        if (GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId()) {
            return new LatLng(29.375859d, 47.977405d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId()) {
            return new LatLng(24.671666d, 46.702881d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId()) {
            return new LatLng(26.228516d, 50.58605d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId()) {
            return new LatLng(25.285447d, 51.53104d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId()) {
            return new LatLng(23.58589d, 58.405923d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            return new LatLng(25.204849d, 55.270783d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId()) {
            return new LatLng(31.945367d, 35.928372d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
            return new LatLng(30.044422d, 31.235712d);
        }
        if (GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
            return new LatLng(36.190236d, 44.008696d);
        }
        return new LatLng(29.375859d, 47.977405d);
    }

    public final float distanceBetween(double d11, double d12, double d13, double d14) {
        Location location = new Location("firstLocation");
        location.setLatitude(d11);
        location.setLongitude(d12);
        Location location2 = new Location("secondLocation");
        location2.setLatitude(d13);
        location2.setLongitude(d14);
        return location.distanceTo(location2);
    }

    public final double distanceBetweenTwoCordinatesbet(double d11, double d12, double d13, double d14) {
        return rad2deg(Math.acos((Math.sin(deg2rad(d11)) * Math.sin(deg2rad(d13))) + (Math.cos(deg2rad(d11)) * Math.cos(deg2rad(d13)) * Math.cos(deg2rad(d12 - d14))))) * 60.0d * 1.1515d * ((double) 1000);
    }
}
