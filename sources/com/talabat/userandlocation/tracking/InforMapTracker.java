package com.talabat.userandlocation.tracking;

import JsonModels.Request.InforMapRequest;
import com.android.volley.VolleyError;
import com.talabat.observability.ObservabilityManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/tracking/InforMapTracker;", "", "()V", "trackInformapStoreApiError", "", "screenName", "", "inforMapRequest", "LJsonModels/Request/InforMapRequest;", "error", "Lcom/android/volley/VolleyError;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InforMapTracker {
    @NotNull
    public static final InforMapTracker INSTANCE = new InforMapTracker();

    private InforMapTracker() {
    }

    @JvmStatic
    public static final void trackInformapStoreApiError(@NotNull String str, @NotNull InforMapRequest inforMapRequest, @NotNull VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(inforMapRequest, "inforMapRequest");
        Intrinsics.checkNotNullParameter(volleyError, "error");
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", str);
        String str2 = inforMapRequest.latitude;
        Intrinsics.checkNotNullExpressionValue(str2, "inforMapRequest.latitude");
        hashMap.put("latitude", str2);
        String str3 = inforMapRequest.longitude;
        Intrinsics.checkNotNullExpressionValue(str3, "inforMapRequest.longitude");
        hashMap.put("longitude", str3);
        hashMap.put("restaurantId", String.valueOf(inforMapRequest.restaurantId));
        hashMap.put("countryId", String.valueOf(inforMapRequest.countryId));
        hashMap.put("areaId", String.valueOf(inforMapRequest.areaid));
        String str4 = inforMapRequest.addressElementsStr;
        Intrinsics.checkNotNullExpressionValue(str4, "inforMapRequest.addressElementsStr");
        hashMap.put("addressElementsStr", str4);
        String message = volleyError.getMessage();
        if (message == null) {
            message = "";
        }
        hashMap.put("errorMessage", message);
        int i11 = volleyError.networkResponse.statusCode;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        hashMap.put("statusCode", sb2.toString());
        ObservabilityManager.trackUnExpectedScenario("InformapStoresApiError", hashMap);
    }
}
