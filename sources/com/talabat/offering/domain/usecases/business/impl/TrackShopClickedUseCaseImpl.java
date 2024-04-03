package com.talabat.offering.domain.usecases.business.impl;

import JsonModels.PolygonEvents;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.offering.data.RestaurantShopClickedEvent;
import com.talabat.offering.domain.OfferCollectionTracker;
import com.talabat.offering.domain.usecases.business.TrackShopClickedUseCase;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;
import xq.b;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/impl/TrackShopClickedUseCaseImpl;", "Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;", "offerCollectionTracker", "Lcom/talabat/offering/domain/OfferCollectionTracker;", "(Lcom/talabat/offering/domain/OfferCollectionTracker;)V", "trackShopClicked", "", "selectedRestaurant", "Ldatamodels/Restaurant;", "polygonEventsData", "LJsonModels/PolygonEvents;", "filter", "Ldatamodels/QuickFilter;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackShopClickedUseCaseImpl implements TrackShopClickedUseCase {
    @NotNull
    private final OfferCollectionTracker offerCollectionTracker;

    public TrackShopClickedUseCaseImpl(@NotNull OfferCollectionTracker offerCollectionTracker2) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker2, "offerCollectionTracker");
        this.offerCollectionTracker = offerCollectionTracker2;
    }

    public void trackShopClicked(@NotNull Restaurant restaurant, @Nullable PolygonEvents polygonEvents, @Nullable QuickFilter quickFilter, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource) {
        String str;
        Restaurant restaurant2 = restaurant;
        Intrinsics.checkNotNullParameter(restaurant, "selectedRestaurant");
        Intrinsics.checkNotNullParameter(eventOriginSource, "eventOriginSource");
        GlobalDataModel.ShopClickOrigin = "channel";
        if (quickFilter != null) {
            str = quickFilter.getSlug();
        } else {
            str = null;
        }
        this.offerCollectionTracker.trackShopClicked(new RestaurantShopClickedEvent(restaurant, "", "", "", str, "", "", polygonEvents, "list_view", (HashMap<String, String>) null, eventOriginSource, b.l(GlobalDataModel.SELECTED.restaurant.f13872id)));
    }
}
