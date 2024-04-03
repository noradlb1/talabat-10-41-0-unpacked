package com.talabat.restaurants.v2.ui;

import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import datamodels.RestaurantListItemModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ldatamodels/RestaurantListItemModel;", "it", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt$FeatureProductsAppender$3 extends Lambda implements Function1<FeatureProductListDisplayModel, RestaurantListItemModel> {
    public static final NonRestaurantItemsAppenderKt$FeatureProductsAppender$3 INSTANCE = new NonRestaurantItemsAppenderKt$FeatureProductsAppender$3();

    public NonRestaurantItemsAppenderKt$FeatureProductsAppender$3() {
        super(1);
    }

    @NotNull
    public final RestaurantListItemModel invoke(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "it");
        return new RestaurantListItemModel(14, featureProductListDisplayModel);
    }
}
