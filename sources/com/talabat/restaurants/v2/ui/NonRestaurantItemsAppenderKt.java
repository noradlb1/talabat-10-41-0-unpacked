package com.talabat.restaurants.v2.ui;

import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import datamodels.Swimlane;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\b\u001a\u00020\u000bH\u0007\u001a\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\r0\tH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"BEFORE_RESTAURANTS_INDEX", "", "INDEX_NOT_FOUND", "NEXT_INDEX_VALUE", "NO_POSITION", "FeatureProductsAppender", "Lcom/talabat/restaurants/v2/ui/NonRestaurantItemsAppender;", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "itemsRetriever", "", "InlineAdsAppender", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "SwimlanesAppender", "Ldatamodels/Swimlane;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt {
    private static final int BEFORE_RESTAURANTS_INDEX = 0;
    private static final int INDEX_NOT_FOUND = -1;
    private static final int NEXT_INDEX_VALUE = 1;
    private static final int NO_POSITION = 0;

    @NotNull
    @JvmOverloads
    public static final NonRestaurantItemsAppender<FeatureProductListDisplayModel> FeatureProductsAppender(@NotNull List<FeatureProductListDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "itemsRetriever");
        return new NonRestaurantItemsAppender<>(list, NonRestaurantItemsAppenderKt$FeatureProductsAppender$1.INSTANCE, NonRestaurantItemsAppenderKt$FeatureProductsAppender$2.INSTANCE, NonRestaurantItemsAppenderKt$FeatureProductsAppender$3.INSTANCE);
    }

    @NotNull
    @JvmOverloads
    public static final NonRestaurantItemsAppender<AdsWrapper> InlineAdsAppender(@NotNull AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "itemsRetriever");
        return new NonRestaurantItemsAppender<>(CollectionsKt__CollectionsJVMKt.listOf(adsWrapper), NonRestaurantItemsAppenderKt$InlineAdsAppender$1.INSTANCE, NonRestaurantItemsAppenderKt$InlineAdsAppender$2.INSTANCE, NonRestaurantItemsAppenderKt$InlineAdsAppender$3.INSTANCE);
    }

    @NotNull
    @JvmOverloads
    public static final NonRestaurantItemsAppender<Swimlane> SwimlanesAppender(@NotNull List<Swimlane> list) {
        Intrinsics.checkNotNullParameter(list, "itemsRetriever");
        return new NonRestaurantItemsAppender<>(list, NonRestaurantItemsAppenderKt$SwimlanesAppender$1.INSTANCE, NonRestaurantItemsAppenderKt$SwimlanesAppender$2.INSTANCE, NonRestaurantItemsAppenderKt$SwimlanesAppender$3.INSTANCE);
    }
}
