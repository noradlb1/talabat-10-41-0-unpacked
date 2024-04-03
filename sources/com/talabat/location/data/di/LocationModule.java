package com.talabat.location.data.di;

import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.gms.location.domain.GmsLocationRepository;
import com.talabat.core.hms.base.domain.IsHmsAvailable;
import com.talabat.core.hms.location.domain.HmsLocationRepository;
import com.talabat.location.domain.LocationRepository;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/location/data/di/LocationModule;", "", "()V", "locationRepository", "Lcom/talabat/location/domain/LocationRepository;", "isGmsAvailable", "", "isHmsAvailable", "gmsLocationRepository", "Lcom/talabat/core/gms/location/domain/GmsLocationRepository;", "hmsLocationRepository", "Lcom/talabat/core/hms/location/domain/HmsLocationRepository;", "com_talabat_core_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class LocationModule {
    @NotNull
    public static final LocationModule INSTANCE = new LocationModule();

    private LocationModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final LocationRepository locationRepository(@IsGmsAvailable boolean z11, @IsHmsAvailable boolean z12, @NotNull GmsLocationRepository gmsLocationRepository, @NotNull HmsLocationRepository hmsLocationRepository) {
        Intrinsics.checkNotNullParameter(gmsLocationRepository, "gmsLocationRepository");
        Intrinsics.checkNotNullParameter(hmsLocationRepository, "hmsLocationRepository");
        return (z11 || !z12) ? gmsLocationRepository : hmsLocationRepository;
    }
}
