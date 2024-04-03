package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.location.Location;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "location", "Landroid/location/Location;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class LocationLiveData$onActive$1 extends Lambda implements Function1<Location, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LocationLiveData f61504g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationLiveData$onActive$1(LocationLiveData locationLiveData) {
        super(1);
        this.f61504g = locationLiveData;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Location) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Location location) {
        if (location != null) {
            this.f61504g.setCurrentLocation(location);
        }
    }
}
