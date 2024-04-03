package com.talabat.darkstores.feature.categories.subcategories.sort;

import com.talabat.darkstores.data.tracking.sort.tracker.SortAndFilterOptionTracker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class SortOptionBottomSheetViewModel_Factory implements Factory<SortOptionBottomSheetViewModel> {
    private final Provider<SortAndFilterOptionTracker> sortAndFilterOptionTrackerProvider;

    public SortOptionBottomSheetViewModel_Factory(Provider<SortAndFilterOptionTracker> provider) {
        this.sortAndFilterOptionTrackerProvider = provider;
    }

    public static SortOptionBottomSheetViewModel_Factory create(Provider<SortAndFilterOptionTracker> provider) {
        return new SortOptionBottomSheetViewModel_Factory(provider);
    }

    public static SortOptionBottomSheetViewModel newInstance(SortAndFilterOptionTracker sortAndFilterOptionTracker) {
        return new SortOptionBottomSheetViewModel(sortAndFilterOptionTracker);
    }

    public SortOptionBottomSheetViewModel get() {
        return newInstance(this.sortAndFilterOptionTrackerProvider.get());
    }
}
