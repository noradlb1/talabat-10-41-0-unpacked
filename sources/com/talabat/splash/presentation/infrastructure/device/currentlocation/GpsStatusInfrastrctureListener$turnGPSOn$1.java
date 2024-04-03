package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import com.talabat.location.domain.LocationSettingsResponse;
import com.talabat.splash.presentation.infrastructure.device.currentlocation.GpsStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/location/domain/LocationSettingsResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GpsStatusInfrastrctureListener$turnGPSOn$1 extends Lambda implements Function1<LocationSettingsResponse, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GpsStatusInfrastrctureListener f61500g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GpsStatusInfrastrctureListener$turnGPSOn$1(GpsStatusInfrastrctureListener gpsStatusInfrastrctureListener) {
        super(1);
        this.f61500g = gpsStatusInfrastrctureListener;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LocationSettingsResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LocationSettingsResponse locationSettingsResponse) {
        Intrinsics.checkNotNullParameter(locationSettingsResponse, "it");
        this.f61500g.postValue(new GpsStatus.Enabled(true));
    }
}
