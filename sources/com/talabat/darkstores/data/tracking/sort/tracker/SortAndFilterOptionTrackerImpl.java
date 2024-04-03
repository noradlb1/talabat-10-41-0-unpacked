package com.talabat.darkstores.data.tracking.sort.tracker;

import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.darkstores.data.tracking.LocationTrackingProvider;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.data.tracking.TrackingUtilKt;
import com.talabat.darkstores.data.tracking.sort.events.SortAndFilterAppliedEvent;
import com.talabat.darkstores.data.tracking.sort.events.SortAndFilterOptionClickedEvent;
import com.talabat.darkstores.data.tracking.sort.events.SortAndFiltersClickedEvent;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTrackerImpl;", "Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;)V", "onSortButtonClicked", "", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "onSortOptionApplied", "shopSortingSelected", "", "onSortOptionClicked", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortAndFilterOptionTrackerImpl implements SortAndFilterOptionTracker {
    @NotNull
    private final LocationTrackingProvider locationTrackingProvider;
    @NotNull
    private final StoreInfoTrackingProvider storeInfoTrackingProvider;
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public SortAndFilterOptionTrackerImpl(@NotNull TalabatTracker talabatTracker2, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider2, @NotNull LocationTrackingProvider locationTrackingProvider2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider2, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider2, "locationTrackingProvider");
        this.talabatTracker = talabatTracker2;
        this.storeInfoTrackingProvider = storeInfoTrackingProvider2;
        this.locationTrackingProvider = locationTrackingProvider2;
    }

    public void onSortButtonClicked(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin) {
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", screenType.getTrackingName()), TuplesKt.to("screenName", screenName.getTrackingName()), TuplesKt.to("eventOrigin", eventOrigin.getTrackingName()));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.locationTrackingProvider.getLocationParams()));
        this.talabatTracker.track(new SortAndFiltersClickedEvent(mutableMapOf));
    }

    public void onSortOptionApplied(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(str, "shopSortingSelected");
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", screenType.getTrackingName()), TuplesKt.to("screenName", screenName.getTrackingName()), TuplesKt.to("eventOrigin", eventOrigin.getTrackingName()), TuplesKt.to("shopSortingSelected", str), TuplesKt.to("shopFilteringSelected", "N/A"));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.locationTrackingProvider.getLocationParams()));
        this.talabatTracker.track(new SortAndFilterAppliedEvent(mutableMapOf));
    }

    public void onSortOptionClicked(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @NotNull String str) {
        Intrinsics.checkNotNullParameter(screenType, "screenType");
        Intrinsics.checkNotNullParameter(screenName, "screenName");
        Intrinsics.checkNotNullParameter(eventOrigin, "eventOrigin");
        Intrinsics.checkNotNullParameter(str, "shopSortingSelected");
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("screenType", screenType.getTrackingName()), TuplesKt.to("screenName", screenName.getTrackingName()), TuplesKt.to("eventOrigin", eventOrigin.getTrackingName()), TuplesKt.to("shopSortingSelected", str), TuplesKt.to("shopFilteringSelected", "N/A"));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.storeInfoTrackingProvider.getStoreInfoParams()));
        mutableMapOf.putAll(TrackingUtilKt.toMapOfStrings(this.locationTrackingProvider.getLocationParams()));
        this.talabatTracker.track(new SortAndFilterOptionClickedEvent(mutableMapOf));
    }
}
