package com.talabat.restaurants.v2.tracking;

import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import datamodels.FeaturedProductItem;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"unitSalePrice", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ShopImpressionLoadedEventKt {
    /* access modifiers changed from: private */
    public static final String unitSalePrice(FeatureProductDisplayModel featureProductDisplayModel) {
        FeaturedProductItem item = featureProductDisplayModel.getItem();
        return (item != null ? item.getOldPrice() : 0.0d) > 0.0d ? featureProductDisplayModel.getOldPrice() : featureProductDisplayModel.getPrice();
    }
}
