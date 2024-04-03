package com.talabat.adapters.restaurantslist;

import datamodels.Restaurant;
import library.talabat.inlineadsengine.AdsWrapper;

public interface OnRestaurantClick {
    void onInlineAdsAppeared(String str, int i11);

    void onInlineAdsClick(String str, int i11);

    void onInlineAdsClick(AdsWrapper adsWrapper);

    void onRestaurantClick(Restaurant restaurant, int i11);
}
