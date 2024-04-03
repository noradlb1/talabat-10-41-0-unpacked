package com.talabat.talabatcommon.tracking;

import com.talabat.helpers.GlobalDataModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.TalabatAdjust;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/tracking/UserSettingsTracker;", "", "addressRetriever", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "addLocationInfo", "", "addUserId", "addUserSettings", "Ljava/util/HashMap;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserSettingsTracker {
    @NotNull
    private final Function0<String> addressRetriever;

    public UserSettingsTracker() {
        this((Function0) null, 1, (DefaultConstructorMarker) null);
    }

    public UserSettingsTracker(@NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "addressRetriever");
        this.addressRetriever = function0;
    }

    private final Map<String, String> addLocationInfo() {
        String str;
        HashMap hashMap = new HashMap();
        int i11 = GlobalDataModel.SelectedCityId;
        if (i11 == 0) {
            str = "N/A";
        } else {
            str = String.valueOf(i11);
        }
        hashMap.put("locationCity", str);
        TalabatGTM.Companion companion = TalabatGTM.Companion;
        hashMap.put("locationLat", companion.getLocationLatitude());
        hashMap.put("locationLon", companion.getLocationLongitude());
        hashMap.put("locationArea", String.valueOf(GlobalDataModel.SelectedAreaId));
        String selectedCountryIso = TalabatAdjust.getSelectedCountryIso();
        Intrinsics.checkNotNullExpressionValue(selectedCountryIso, "getSelectedCountryIso()");
        hashMap.put("locationCountry", selectedCountryIso);
        hashMap.put("locationAddress", this.addressRetriever.invoke());
        return hashMap;
    }

    private final Map<String, String> addUserId() {
        HashMap hashMap = new HashMap();
        String userId = TalabatGTM.Companion.getUserId();
        if (userId == null) {
            userId = "N/A";
        }
        hashMap.put("userId", userId);
        return hashMap;
    }

    @NotNull
    public final HashMap<String, String> addUserSettings() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(addUserId());
        hashMap.putAll(addLocationInfo());
        return hashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserSettingsTracker(Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
