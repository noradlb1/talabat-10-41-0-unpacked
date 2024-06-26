package com.talabat.restaurants.v2.ui;

import datamodels.Swimlane;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Ldatamodels/Swimlane;", "invoke", "(Ldatamodels/Swimlane;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class NonRestaurantItemsAppenderKt$SwimlanesAppender$2 extends Lambda implements Function1<Swimlane, Integer> {
    public static final NonRestaurantItemsAppenderKt$SwimlanesAppender$2 INSTANCE = new NonRestaurantItemsAppenderKt$SwimlanesAppender$2();

    public NonRestaurantItemsAppenderKt$SwimlanesAppender$2() {
        super(1);
    }

    @NotNull
    public final Integer invoke(@NotNull Swimlane swimlane) {
        Intrinsics.checkNotNullParameter(swimlane, "$this$$receiver");
        return Integer.valueOf(swimlane.getPosition());
    }
}
