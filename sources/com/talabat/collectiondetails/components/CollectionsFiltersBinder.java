package com.talabat.collectiondetails.components;

import com.talabat.collectiondetails.R;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.filters.navigation.CollectionsFiltersView;
import com.talabat.filters.navigation.FiltersViewKt;
import io.reactivex.functions.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/collectiondetails/components/CollectionsFiltersBinder;", "Lio/reactivex/functions/BiConsumer;", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsActivity;", "", "()V", "accept", "", "activity", "id", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsFiltersBinder implements BiConsumer<QuickFilterRestaurantsActivity, Integer> {
    public /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) {
        accept((QuickFilterRestaurantsActivity) obj, ((Number) obj2).intValue());
    }

    public void accept(@NotNull QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, int i11) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsActivity, "activity");
        int i12 = R.id.collectionsFiltersView;
        ((CollectionsFiltersView) quickFilterRestaurantsActivity.findViewById(i12)).setVisibility(0);
        CollectionsFiltersView collectionsFiltersView = (CollectionsFiltersView) quickFilterRestaurantsActivity.findViewById(i12);
        Intrinsics.checkNotNullExpressionValue(collectionsFiltersView, "collectionsFiltersView");
        FiltersViewKt.invoke$default(collectionsFiltersView, i11, (Function1) null, new CollectionsFiltersBinder$accept$1$1(quickFilterRestaurantsActivity), 2, (Object) null);
    }
}
