package com.talabat.darkstores.feature.categories.subcategories.sort;

import androidx.lifecycle.ViewModel;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import com.talabat.feature.darkstores.domain.tracking.ScreenTrackingProvider;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortOptionBottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "sortAndFilterOptionTracker", "Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;", "(Lcom/talabat/darkstores/data/tracking/sort/tracker/SortAndFilterOptionTracker;)V", "onSortOptionApplied", "", "appliedSortOption", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "onSortOptionClicked", "sortOption", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortOptionBottomSheetViewModel extends ViewModel {
    @NotNull
    private final SortAndFilterOptionTracker sortAndFilterOptionTracker;

    @Inject
    public SortOptionBottomSheetViewModel(@NotNull SortAndFilterOptionTracker sortAndFilterOptionTracker2) {
        Intrinsics.checkNotNullParameter(sortAndFilterOptionTracker2, "sortAndFilterOptionTracker");
        this.sortAndFilterOptionTracker = sortAndFilterOptionTracker2;
    }

    public final void onSortOptionApplied(@NotNull SortOption sortOption) {
        Intrinsics.checkNotNullParameter(sortOption, "appliedSortOption");
        this.sortAndFilterOptionTracker.onSortOptionApplied(ScreenTrackingProvider.ScreenType.CATEGORY, ScreenTrackingProvider.ScreenName.CATEGORY, ScreenTrackingProvider.EventOrigin.CATEGORY_DETAILS_SORT, sortOption.getKey());
    }

    public final void onSortOptionClicked(@NotNull SortOption sortOption) {
        Intrinsics.checkNotNullParameter(sortOption, "sortOption");
        this.sortAndFilterOptionTracker.onSortOptionClicked(ScreenTrackingProvider.ScreenType.CATEGORY, ScreenTrackingProvider.ScreenName.CATEGORY, ScreenTrackingProvider.EventOrigin.CATEGORY_DETAILS_SORT, sortOption.getKey());
    }
}
