package com.tracking;

import android.content.Context;
import com.talabat.helpers.GlobalDataModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/tracking/Tracker;", "", "createParameters", "", "", "screenName", "screenType", "sendEvent", "", "eventName", "params", "", "com_talabat_NewArchi_TalabatIntegration_TalabatIntegration"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Tracker {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Map<String, Object> createParameters(@NotNull Tracker tracker, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenType");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            TrackerKt.addParameter(linkedHashMap, "screenName", str);
            TrackerKt.addParameter(linkedHashMap, "screenType", str2);
            TalabatGTM.Companion companion = TalabatGTM.Companion;
            TrackerKt.addParameter(linkedHashMap, "locationLat", companion.getLocationLatitude());
            TrackerKt.addParameter(linkedHashMap, "locationLon", companion.getLocationLongitude());
            String str3 = GlobalDataModel.SelectedCityName;
            if (str3 == null) {
                str3 = "N/A";
            } else {
                Intrinsics.checkNotNullExpressionValue(str3, "GlobalDataModel.SelectedCityName ?: \"N/A\"");
            }
            TrackerKt.addParameter(linkedHashMap, "locationCity", str3);
            TrackerKt.addParameter(linkedHashMap, "locationArea", String.valueOf(GlobalDataModel.SelectedAreaId));
            String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
            Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
            TrackerKt.addParameter(linkedHashMap, "locationCountry", selectedCountryIso);
            String userId = companion.getUserId();
            if (userId == null) {
                userId = "";
            }
            TrackerKt.addParameter(linkedHashMap, "userId", userId);
            TrackerKt.addParameter(linkedHashMap, "userTimeStamp", companion.getCurrentTime());
            TrackerKt.addParameter(linkedHashMap, "locationAddress", TalabatGTM.Companion.getLocationAddress$default(companion, (Context) null, 1, (Object) null));
            return linkedHashMap;
        }

        public static /* synthetic */ Map createParameters$default(Tracker tracker, String str, String str2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 2) != 0) {
                    str2 = "";
                }
                return tracker.createParameters(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createParameters");
        }
    }

    @NotNull
    Map<String, Object> createParameters(@NotNull String str, @NotNull String str2);

    void sendEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map);
}
