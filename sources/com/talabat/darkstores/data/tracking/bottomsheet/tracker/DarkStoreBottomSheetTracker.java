package com.talabat.darkstores.data.tracking.bottomsheet.tracker;

import com.talabat.darkstores.feature.tracking.EventOriginType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoreBottomSheetTracker;", "", "trackDarkStoreBottomSheetClickedEvent", "", "eventOriginType", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "bottomSheetIcon", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/BottomSheetClickOriginIconType;", "bottomSheetName", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DarkStoresBottomSheetName;", "trackDarkStoreBottomSheetLoadedEvent", "deliveryFeeFlowType", "Lcom/talabat/darkstores/data/tracking/bottomsheet/tracker/DeliveryFeeFlowType;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkStoreBottomSheetTracker {
    void trackDarkStoreBottomSheetClickedEvent(@NotNull EventOriginType eventOriginType, @NotNull BottomSheetClickOriginIconType bottomSheetClickOriginIconType, @NotNull DarkStoresBottomSheetName darkStoresBottomSheetName);

    void trackDarkStoreBottomSheetLoadedEvent(@NotNull DarkStoresBottomSheetName darkStoresBottomSheetName, @NotNull DeliveryFeeFlowType deliveryFeeFlowType);
}
