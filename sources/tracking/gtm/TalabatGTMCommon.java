package tracking.gtm;

import com.talabat.helpers.GlobalDataModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltracking/gtm/TalabatGTMCommon;", "", "()V", "LOCATIONAREA", "", "LOCATIONCITY", "LOCATIONCOUNTRY", "LOCATIONLATTITUDE", "LOCATIONLONGITUDE", "addLocationProperties", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatGTMCommon {
    @NotNull
    public static final TalabatGTMCommon INSTANCE = new TalabatGTMCommon();
    @NotNull
    private static final String LOCATIONAREA = "locationArea";
    @NotNull
    private static final String LOCATIONCITY = "locationCity";
    @NotNull
    private static final String LOCATIONCOUNTRY = "locationCountry";
    @NotNull
    private static final String LOCATIONLATTITUDE = "locationLat";
    @NotNull
    private static final String LOCATIONLONGITUDE = "locationLon";

    private TalabatGTMCommon() {
    }

    @NotNull
    public final Map<String, String> addLocationProperties() {
        String str = LOCATIONLATTITUDE;
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        return MapsKt__MapsKt.mapOf(TuplesKt.to(LOCATIONCITY, String.valueOf(GlobalDataModel.SelectedCityId)), TuplesKt.to(LOCATIONAREA, String.valueOf(GlobalDataModel.SelectedAreaId)), TuplesKt.to(LOCATIONCOUNTRY, TalabatAdjust.getSelectedCountryIso()), TuplesKt.to(str, companion.getLocationLatitude()), TuplesKt.to(LOCATIONLONGITUDE, companion.getLocationLongitude()));
    }
}
