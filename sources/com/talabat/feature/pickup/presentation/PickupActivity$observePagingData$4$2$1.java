package com.talabat.feature.pickup.presentation;

import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "vendor", "Ldatamodels/Restaurant;", "swimlaneTracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$observePagingData$4$2$1 extends Lambda implements Function2<Restaurant, SwimlanesTracking, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58650g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$observePagingData$4$2$1(PickupActivity pickupActivity) {
        super(2);
        this.f58650g = pickupActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Restaurant) obj, (SwimlanesTracking) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Restaurant restaurant, @NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        Intrinsics.checkNotNullParameter(swimlanesTracking, "swimlaneTracking");
        this.f58650g.selectRestaurant(restaurant, swimlanesTracking);
    }
}
