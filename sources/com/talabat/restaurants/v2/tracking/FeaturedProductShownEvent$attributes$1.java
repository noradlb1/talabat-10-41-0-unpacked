package com.talabat.restaurants.v2.tracking;

import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeaturedProductShownEvent$attributes$1 extends Lambda implements Function1<FeatureProductDisplayModel, CharSequence> {
    public static final FeaturedProductShownEvent$attributes$1 INSTANCE = new FeaturedProductShownEvent$attributes$1();

    public FeaturedProductShownEvent$attributes$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull FeatureProductDisplayModel featureProductDisplayModel) {
        Intrinsics.checkNotNullParameter(featureProductDisplayModel, "it");
        return String.valueOf(featureProductDisplayModel.getItemId());
    }
}
