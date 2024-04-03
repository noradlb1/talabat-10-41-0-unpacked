package com.talabat.darkstores.data.tracking.sort.tracker;

import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;", "", "onSortButtonClicked", "", "screenType", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenType;", "screenName", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$ScreenName;", "eventOrigin", "Lcom/talabat/feature/darkstores/domain/tracking/ScreenTrackingProvider$EventOrigin;", "onSortOptionApplied", "shopSortingSelected", "", "onSortOptionClicked", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SortAndFilterOptionTracker {
    void onSortButtonClicked(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin);

    void onSortOptionApplied(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @NotNull String str);

    void onSortOptionClicked(@NotNull ScreenTrackingProvider.ScreenType screenType, @NotNull ScreenTrackingProvider.ScreenName screenName, @NotNull ScreenTrackingProvider.EventOrigin eventOrigin, @NotNull String str);
}
