package com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetRestaurantUseCase$executeRequest$1 extends Lambda implements Function1<RestaurantListResponsePaginated, RestaurantListResponsePaginated> {
    public static final GetRestaurantUseCase$executeRequest$1 INSTANCE = new GetRestaurantUseCase$executeRequest$1();

    public GetRestaurantUseCase$executeRequest$1() {
        super(1);
    }

    @NotNull
    public final RestaurantListResponsePaginated invoke(@NotNull RestaurantListResponsePaginated restaurantListResponsePaginated) {
        Intrinsics.checkNotNullParameter(restaurantListResponsePaginated, "it");
        return restaurantListResponsePaginated;
    }
}
