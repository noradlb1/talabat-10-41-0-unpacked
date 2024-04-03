package com.talabat.collectiondetails.components;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import datamodels.filters.Selectables;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "Ldatamodels/filters/Selectables;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CollectionsFiltersBinder$accept$1$1 extends Lambda implements Function1<StartForResultCallbacks<Selectables>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsActivity f55645g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionsFiltersBinder$accept$1$1(QuickFilterRestaurantsActivity quickFilterRestaurantsActivity) {
        super(1);
        this.f55645g = quickFilterRestaurantsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartForResultCallbacks<Selectables>) (StartForResultCallbacks) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartForResultCallbacks<Selectables> startForResultCallbacks) {
        Intrinsics.checkNotNullParameter(startForResultCallbacks, "$this$invoke");
        startForResultCallbacks.getOn().start(new Function0<Unit>(this.f55645g) {
            public final void invoke() {
                ((QuickFilterRestaurantsActivity) this.receiver).updateCollectionsCuisinesFromRestaurants();
            }
        });
        StartForResultCallbacks<Selectables> on2 = startForResultCallbacks.getOn();
        final QuickFilterRestaurantsActivity quickFilterRestaurantsActivity = this.f55645g;
        on2.success(new Function1<Selectables, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Selectables) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Selectables selectables) {
                ShopClickedEvent shopClickedEvent = ShopClickedEvent.INSTANCE;
                ShopClickedEvent.EventOriginSource eventOriginSource = quickFilterRestaurantsActivity.shopClickedOriginSource;
                Intrinsics.checkNotNullExpressionValue(eventOriginSource, "shopClickedOriginSource");
                shopClickedEvent.updateFilterId(eventOriginSource, selectables);
                ShopClickedEvent.EventOriginSource eventOriginSource2 = quickFilterRestaurantsActivity.shopClickedOriginSource;
                Intrinsics.checkNotNullExpressionValue(eventOriginSource2, "shopClickedOriginSource");
                shopClickedEvent.updateSortType(eventOriginSource2, selectables);
                quickFilterRestaurantsActivity.handleCollectionsFilterSelection(selectables != null ? selectables.getSelectablePopularFilters() : null);
            }
        });
        startForResultCallbacks.getOn().cancelled(new Function0<Unit>(this.f55645g) {
            public final void invoke() {
                ((QuickFilterRestaurantsActivity) this.receiver).handleCollectionsFilterCancelled();
            }
        });
    }
}
