package com.talabat.collectiondetails.components;

import android.view.View;
import com.talabat.collectiondetails.R;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.cuisines.navigation.CollectionsCuisineView;
import datamodels.QuickFilter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0002¨\u0006\u0006"}, d2 = {"bindCollectionsCuisineView", "", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsActivity;", "activity", "isVisible", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CollectionsCuisineBinderKt {
    /* access modifiers changed from: private */
    public static final void bindCollectionsCuisineView(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity, QuickFilterRestaurantsActivity quickFilterRestaurantsActivity2) {
        View findViewById = quickFilterRestaurantsActivity2.findViewById(R.id.collectionsCuisineViewLayout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(R.…ectionsCuisineViewLayout)");
        ((CollectionsCuisineView) findViewById).invoke(new CollectionsCuisineBinderKt$bindCollectionsCuisineView$1(quickFilterRestaurantsActivity));
    }

    /* access modifiers changed from: private */
    public static final int isVisible(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity) {
        QuickFilter quickFilter = quickFilterRestaurantsActivity.filter;
        return quickFilter != null ? Intrinsics.areEqual((Object) quickFilter.isCuisine(), (Object) Boolean.FALSE) : false ? 0 : 8;
    }
}
