package com.talabat.restaurants.v2.ui;

import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "invoke", "(Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt$FeatureProductsAppender$1 extends Lambda implements Function1<FeatureProductListDisplayModel, Boolean> {
    public static final NonRestaurantItemsAppenderKt$FeatureProductsAppender$1 INSTANCE = new NonRestaurantItemsAppenderKt$FeatureProductsAppender$1();

    public NonRestaurantItemsAppenderKt$FeatureProductsAppender$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductListDisplayModel, "$this$$receiver");
        Collection featureProductDisplayModels = featureProductListDisplayModel.getFeatureProductDisplayModels();
        return Boolean.valueOf(!(featureProductDisplayModels == null || featureProductDisplayModels.isEmpty()));
    }
}
