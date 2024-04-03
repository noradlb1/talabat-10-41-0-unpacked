package com.talabat.feature.pickup.presentation;

import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "restaurant", "Ldatamodels/Restaurant;", "<anonymous parameter 1>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity$pickupAdapter$1 extends Lambda implements Function2<Restaurant, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupActivity f58651g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupActivity$pickupAdapter$1(PickupActivity pickupActivity) {
        super(2);
        this.f58651g = pickupActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Restaurant) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Restaurant restaurant, int i11) {
        if (restaurant != null) {
            PickupActivity.m(this.f58651g, restaurant, (SwimlanesTracking) null, 2, (Object) null);
        }
    }
}
