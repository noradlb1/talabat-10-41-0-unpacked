package com.talabat.restaurants.v2.ui;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "invoke", "(Llibrary/talabat/inlineadsengine/AdsWrapper;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt$InlineAdsAppender$2 extends Lambda implements Function1<AdsWrapper, Integer> {
    public static final NonRestaurantItemsAppenderKt$InlineAdsAppender$2 INSTANCE = new NonRestaurantItemsAppenderKt$InlineAdsAppender$2();

    public NonRestaurantItemsAppenderKt$InlineAdsAppender$2() {
        super(1);
    }

    @NotNull
    public final Integer invoke(@NotNull AdsWrapper adsWrapper) {
        Intrinsics.checkNotNullParameter(adsWrapper, "$this$$receiver");
        return Integer.valueOf(adsWrapper.getAdsPosition());
    }
}
