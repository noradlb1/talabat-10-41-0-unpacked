package com.talabat.offering.domain.usecases.business.impl;

import JsonModels.PolygonEvents;
import com.facebook.internal.security.CertificateUtil;
import com.talabat.feature.rating.presentation.ui.RatingReasonFragmentKt;
import com.talabat.offering.data.RestaurantListUpdatedEvent;
import com.talabat.offering.domain.OfferCollectionTracker;
import com.talabat.offering.domain.usecases.business.TrackShopListUpdatedUseCase;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.ShopClickedEvent;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0014\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJE\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/impl/TrackShopListUpdatedUseCaseImpl;", "Lcom/talabat/offering/domain/usecases/business/TrackShopListUpdatedUseCase;", "offerCollectionTracker", "Lcom/talabat/offering/domain/OfferCollectionTracker;", "(Lcom/talabat/offering/domain/OfferCollectionTracker;)V", "getChannelIndex", "", "quickFilter", "Ldatamodels/QuickFilter;", "getRecommendedQuantity", "", "restaurantListModel", "Ldatamodels/RestaurantListModel;", "getShopIds", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "trackShopListUpdated", "", "polygonEventsData", "LJsonModels/PolygonEvents;", "filter", "eventOriginSource", "Ltracking/ShopClickedEvent$EventOriginSource;", "telcoVerified", "", "telcoExpired", "(Ldatamodels/RestaurantListModel;LJsonModels/PolygonEvents;Ldatamodels/QuickFilter;Ltracking/ShopClickedEvent$EventOriginSource;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackShopListUpdatedUseCaseImpl implements TrackShopListUpdatedUseCase {
    @NotNull
    private final OfferCollectionTracker offerCollectionTracker;

    public TrackShopListUpdatedUseCaseImpl(@NotNull OfferCollectionTracker offerCollectionTracker2) {
        Intrinsics.checkNotNullParameter(offerCollectionTracker2, "offerCollectionTracker");
        this.offerCollectionTracker = offerCollectionTracker2;
    }

    @NotNull
    public final String getChannelIndex(@Nullable QuickFilter quickFilter) {
        if (quickFilter == null) {
            return "";
        }
        String slug = quickFilter.getSlug();
        Integer id2 = quickFilter.getId();
        return slug + CertificateUtil.DELIMITER + id2;
    }

    public final int getRecommendedQuantity(@Nullable RestaurantListModel restaurantListModel) {
        if (restaurantListModel == null) {
            return 0;
        }
        return restaurantListModel.getOpenNowRestaurants().size();
    }

    @NotNull
    public final StringBuilder getShopIds(@Nullable RestaurantListModel restaurantListModel) {
        boolean z11;
        StringBuilder sb2 = new StringBuilder();
        if (!(restaurantListModel == null || restaurantListModel.getOpenNowRestaurants() == null)) {
            Iterator<Restaurant> it = restaurantListModel.getOpenNowRestaurants().iterator();
            while (it.hasNext()) {
                Restaurant next = it.next();
                if (sb2.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    sb2.append(next.getId());
                } else {
                    sb2.append(",");
                    sb2.append(next.getId());
                }
            }
        }
        return sb2;
    }

    public void trackShopListUpdated(@NotNull RestaurantListModel restaurantListModel, @Nullable PolygonEvents polygonEvents, @Nullable QuickFilter quickFilter, @NotNull ShopClickedEvent.EventOriginSource eventOriginSource, @Nullable Boolean bool, @Nullable Boolean bool2) {
        String str;
        QuickFilter quickFilter2 = quickFilter;
        Intrinsics.checkNotNullParameter(restaurantListModel, "restaurantListModel");
        Intrinsics.checkNotNullParameter(eventOriginSource, "eventOriginSource");
        ArrayList<Restaurant> allRestaurants = restaurantListModel.getAllRestaurants();
        String channelIndex = getChannelIndex(quickFilter2);
        if (quickFilter2 != null) {
            str = quickFilter.getSlug();
        } else {
            str = null;
        }
        this.offerCollectionTracker.trackShopListUpdated(new RestaurantListUpdatedEvent(allRestaurants, RatingReasonFragmentKt.ARGUMENT_NAME_FOOD, channelIndex, str, "channel", false, 0, getRecommendedQuantity(restaurantListModel), true, getShopIds(restaurantListModel).toString(), polygonEvents, "list_view", (HashMap<String, String>) null, eventOriginSource, "", bool, bool2));
    }
}
