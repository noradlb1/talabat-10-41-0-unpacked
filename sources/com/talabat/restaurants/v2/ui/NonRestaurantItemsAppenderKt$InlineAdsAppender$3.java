package com.talabat.restaurants.v2.ui;

import datamodels.Restaurant;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ldatamodels/RestaurantListItemModel;", "it", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt$InlineAdsAppender$3 extends Lambda implements Function1<AdsWrapper, RestaurantListItemModel> {
    public static final NonRestaurantItemsAppenderKt$InlineAdsAppender$3 INSTANCE = new NonRestaurantItemsAppenderKt$InlineAdsAppender$3();

    public NonRestaurantItemsAppenderKt$InlineAdsAppender$3() {
        super(1);
    }

    @NotNull
    public final RestaurantListItemModel invoke(@NotNull AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "it");
        return new RestaurantListItemModel(7, (Restaurant) null, adsWrapper);
    }
}
