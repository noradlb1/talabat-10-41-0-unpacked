package com.talabat.restaurants.v2;

import buisnessmodels.FilterEngine;
import datamodels.Filter;
import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import io.reactivex.functions.BiConsumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/restaurants/v2/ShopClickOriginUpdater;", "Lio/reactivex/functions/BiConsumer;", "Ltracking/ShopClickedEvent$EventOriginSource;", "Lbuisnessmodels/FilterEngine;", "()V", "accept", "", "source", "filterEngine", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShopClickOriginUpdater implements BiConsumer<ShopClickedEvent.EventOriginSource, FilterEngine> {
    public void accept(@NotNull ShopClickedEvent.EventOriginSource eventOriginSource, @Nullable FilterEngine filterEngine) {
        SortType sortType;
        Intrinsics.checkNotNullParameter(eventOriginSource, "source");
        if (filterEngine != null) {
            ShopClickedEvent.INSTANCE.updateCuisineId(eventOriginSource, CollectionsKt__CollectionsJVMKt.listOf(filterEngine.getDeeplinkCuisine()));
            int deepLinkSort = filterEngine.getDeepLinkSort();
            if (deepLinkSort == -100) {
                sortType = SortType.RECOMMENDATION;
            } else if (deepLinkSort == 3) {
                sortType = SortType.MIN_ORDER;
            } else if (deepLinkSort == 5) {
                sortType = SortType.FASTEST_DELIVERY;
            } else if (deepLinkSort == 0) {
                sortType = SortType.ALPHABETIC;
            } else if (deepLinkSort != 1) {
                sortType = SortType.RECOMMENDATION;
            } else {
                sortType = SortType.RATING;
            }
            eventOriginSource.setSelectedSort(CollectionsKt__CollectionsJVMKt.listOf(new SelectableSortType(sortType, true, (String) null, 4, (DefaultConstructorMarker) null)));
            List<Filter> selectedFiltersList = filterEngine.getSelectedFiltersList();
            Intrinsics.checkNotNullExpressionValue(selectedFiltersList, "filterEngine\n            .selectedFiltersList");
            ArrayList arrayList = new ArrayList();
            for (Filter filter : selectedFiltersList) {
                Intrinsics.checkNotNullExpressionValue(filter, "it");
                arrayList.add(new SelectableFilter(filter, true));
            }
            eventOriginSource.setSelectedFilters(arrayList);
        }
    }
}
