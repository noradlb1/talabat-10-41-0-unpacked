package com.talabat.offering.domain.usecases.business;

import JsonModels.PolygonEvents;
import datamodels.QuickFilter;
import datamodels.RestaurantListModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JE\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;", "", "trackShopListUpdated", "", "restaurantListModel", "Ldatamodels/RestaurantListModel;", "polygonEventsData", "LJsonModels/PolygonEvents;", "filter", "Ldatamodels/QuickFilter;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "telcoVerified", "", "telcoExpired", "(Ldatamodels/RestaurantListModel;LJsonModels/PolygonEvents;Ldatamodels/QuickFilter;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackShopListUpdatedUseCase {
    void trackShopListUpdated(@NotNull RestaurantListModel restaurantListModel, @Nullable PolygonEvents polygonEvents, @Nullable QuickFilter quickFilter, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource, @Nullable Boolean bool, @Nullable Boolean bool2);
}
