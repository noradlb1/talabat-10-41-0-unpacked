package com.talabat.offering.domain.usecases.business;

import JsonModels.PolygonEvents;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/TrackShopClickedUseCase;", "", "trackShopClicked", "", "selectedRestaurant", "Ldatamodels/Restaurant;", "polygonEventsData", "LJsonModels/PolygonEvents;", "filter", "Ldatamodels/QuickFilter;", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackShopClickedUseCase {
    void trackShopClicked(@NotNull Restaurant restaurant, @Nullable PolygonEvents polygonEvents, @Nullable QuickFilter quickFilter, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource);
}
