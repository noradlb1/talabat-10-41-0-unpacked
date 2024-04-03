package com.talabat.components;

import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Ldatamodels/Restaurant;", "invoke", "(Ldatamodels/Restaurant;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PopularFilterFactoryKt$noMinimumOrderFilter$1 extends Lambda implements Function1<Restaurant, Boolean> {
    public static final PopularFilterFactoryKt$noMinimumOrderFilter$1 INSTANCE = new PopularFilterFactoryKt$noMinimumOrderFilter$1();

    public PopularFilterFactoryKt$noMinimumOrderFilter$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "it");
        return Boolean.valueOf(restaurant.minimumAmount <= 0.0f);
    }
}
