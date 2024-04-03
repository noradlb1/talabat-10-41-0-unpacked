package com.talabat.splash.presentation.infrastructure.device.currentlocation;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.location.domain.LocationRepository;
import com.talabat.splash.domain.model.location.CurrentLocationWrapper;
import com.talabat.splash.presentation.infrastructure.thirdparty.Tracking;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Singleton
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastructureImpl;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/CLInfrastrcture;", "context", "Landroid/content/Context;", "tracking", "Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;", "locationRepository", "Lcom/talabat/location/domain/LocationRepository;", "(Landroid/content/Context;Lcom/talabat/splash/presentation/infrastructure/thirdparty/Tracking;Lcom/talabat/location/domain/LocationRepository;)V", "getFetchCurrentLocation", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "params", "", "getGpsStatus", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/GpsStatus;", "getLocationPermissionStatus", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/splash/presentation/infrastructure/device/currentlocation/PermissionStatus;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CLInfrastructureImpl implements CLInfrastrcture {
    @NotNull
    private final Context context;
    @NotNull
    private final LocationRepository locationRepository;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final Tracking f61499tracking;

    @Inject
    public CLInfrastructureImpl(@NotNull Context context2, @NotNull Tracking tracking2, @NotNull LocationRepository locationRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tracking2, "tracking");
        Intrinsics.checkNotNullParameter(locationRepository2, "locationRepository");
        this.context = context2;
        this.f61499tracking = tracking2;
        this.locationRepository = locationRepository2;
    }

    @NotNull
    public MutableLiveData<CurrentLocationWrapper> getFetchCurrentLocation(int i11) {
        return new LocationLiveData(this.locationRepository, i11, this.f61499tracking);
    }

    @NotNull
    public MutableLiveData<GpsStatus> getGpsStatus() {
        return new GpsStatusInfrastrctureListener(this.context, this.locationRepository);
    }

    @NotNull
    public LiveData<PermissionStatus> getLocationPermissionStatus() {
        return new PermissionStatusInfrastrctureListener(this.context);
    }
}
