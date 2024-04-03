package com.talabat.collectiondetails.ui.restaurantlist;

import datamodels.Restaurant;

public interface OnRestaurantClick {
    void onInlineAdsAppeared(String str, int i11);

    void onInlineAdsClick(String str, int i11);

    void onRestaurantClick(Restaurant restaurant, int i11);
}
