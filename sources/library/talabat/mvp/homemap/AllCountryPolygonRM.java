package library.talabat.mvp.homemap;

import com.google.android.gms.maps.model.LatLng;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Llibrary/talabat/mvp/homemap/AllCountryPolygonRM;", "", "points", "Ljava/util/ArrayList;", "Lcom/google/android/gms/maps/model/LatLng;", "cName", "", "(Ljava/util/ArrayList;Ljava/lang/String;)V", "getCName", "()Ljava/lang/String;", "setCName", "(Ljava/lang/String;)V", "countryName", "getCountryName", "setCountryName", "countyPoints", "getCountyPoints", "()Ljava/util/ArrayList;", "setCountyPoints", "(Ljava/util/ArrayList;)V", "getPoints", "setPoints", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AllCountryPolygonRM {
    @NotNull
    private String cName;
    @Nullable
    private String countryName;
    @Nullable
    private ArrayList<LatLng> countyPoints;
    @NotNull
    private ArrayList<LatLng> points;

    public AllCountryPolygonRM(@NotNull ArrayList<LatLng> arrayList, @NotNull String str) {
        Intrinsics.checkNotNullParameter(arrayList, Param.POINTS);
        Intrinsics.checkNotNullParameter(str, "cName");
        this.points = arrayList;
        this.cName = str;
        this.countyPoints = arrayList;
        this.countryName = str;
    }

    @NotNull
    public final String getCName() {
        return this.cName;
    }

    @Nullable
    public final String getCountryName() {
        return this.countryName;
    }

    @Nullable
    public final ArrayList<LatLng> getCountyPoints() {
        return this.countyPoints;
    }

    @NotNull
    public final ArrayList<LatLng> getPoints() {
        return this.points;
    }

    public final void setCName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cName = str;
    }

    public final void setCountryName(@Nullable String str) {
        this.countryName = str;
    }

    public final void setCountyPoints(@Nullable ArrayList<LatLng> arrayList) {
        this.countyPoints = arrayList;
    }

    public final void setPoints(@NotNull ArrayList<LatLng> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.points = arrayList;
    }
}
