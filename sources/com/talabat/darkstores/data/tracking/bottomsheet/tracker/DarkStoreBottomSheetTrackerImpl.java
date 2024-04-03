package com.talabat.darkstores.data.tracking.bottomsheet.tracker;

import android.os.Bundle;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.bottomsheet.events.DarkStoreBottomSheetClickedEvent;
import com.talabat.darkstores.data.tracking.bottomsheet.events.DarkStoreBottomSheetLoadedEvent;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013*\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTrackerImpl;", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;)V", "trackDarkStoreBottomSheetClickedEvent", "", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "bottomSheetIcon", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/BottomSheetClickOriginIconType;", "bottomSheetName", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoresBottomSheetName;", "trackDarkStoreBottomSheetLoadedEvent", "deliveryFeeFlowType", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DeliveryFeeFlowType;", "toMap", "", "", "", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreBottomSheetTrackerImpl implements DarkStoreBottomSheetTracker {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KEY_BOTTOM_SHEET_ICON = "bottomSheetIcon";
    @NotNull
    private static final String KEY_BOTTOM_SHEET_NAME = "bottomSheetName";
    @NotNull
    private static final String KEY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String KEY_MOV_VALUE = "movValue";
    @NotNull
    private static final String KEY_POPUP_BUTTON = "popupButton";
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTrackerImpl$Companion;", "", "()V", "KEY_BOTTOM_SHEET_ICON", "", "KEY_BOTTOM_SHEET_NAME", "KEY_EVENT_ORIGIN", "KEY_MOV_VALUE", "KEY_POPUP_BUTTON", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public DarkStoreBottomSheetTrackerImpl(@NotNull TalabatTracker talabatTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        this.talabatTracker = talabatTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
    }

    private final Map<String, Object> toMap(Bundle bundle) {
        HashMap hashMap = new HashMap(bundle.size());
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(next, "key");
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public void trackDarkStoreBottomSheetClickedEvent(@NotNull EventOriginType eventOriginType, @NotNull BottomSheetClickOriginIconType bottomSheetClickOriginIconType, @NotNull DarkStoresBottomSheetName darkStoresBottomSheetName) {
        Intrinsics.checkNotNullParameter(eventOriginType, "eventOriginType");
        Intrinsics.checkNotNullParameter(bottomSheetClickOriginIconType, KEY_BOTTOM_SHEET_ICON);
        Intrinsics.checkNotNullParameter(darkStoresBottomSheetName, KEY_BOTTOM_SHEET_NAME);
        this.talabatTracker.track(new DarkStoreBottomSheetClickedEvent(toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), MapsKt__MapsKt.mapOf(TuplesKt.to(KEY_BOTTOM_SHEET_NAME, darkStoresBottomSheetName.getBottomSheetName()), TuplesKt.to("eventOrigin", eventOriginType.getTrackingName()), TuplesKt.to(KEY_BOTTOM_SHEET_ICON, bottomSheetClickOriginIconType.getClickOriginIconType()))));
    }

    public void trackDarkStoreBottomSheetLoadedEvent(@NotNull DarkStoresBottomSheetName darkStoresBottomSheetName, @NotNull DeliveryFeeFlowType deliveryFeeFlowType) {
        Intrinsics.checkNotNullParameter(darkStoresBottomSheetName, KEY_BOTTOM_SHEET_NAME);
        Intrinsics.checkNotNullParameter(deliveryFeeFlowType, "deliveryFeeFlowType");
        this.talabatTracker.track(new DarkStoreBottomSheetLoadedEvent(toMap(this.storeInfoTrackingProvider.getStoreInfoParams()), MapsKt__MapsKt.mapOf(TuplesKt.to(KEY_BOTTOM_SHEET_NAME, darkStoresBottomSheetName.getBottomSheetName()), TuplesKt.to(KEY_MOV_VALUE, String.valueOf(deliveryFeeFlowType.getDeliveryFeeFlowValue())))));
    }
}
