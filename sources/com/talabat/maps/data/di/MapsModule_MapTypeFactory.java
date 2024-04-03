package com.talabat.maps.data.di;

import com.talabat.maps.domain.MapType;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata("dagger.Reusable")
@DaggerGenerated
@QualifierMetadata({"com.talabat.core.gms.base.domain.IsGmsAvailable", "com.talabat.core.hms.base.domain.IsHmsAvailable"})
public final class MapsModule_MapTypeFactory implements Factory<MapType> {
    private final Provider<Boolean> isGmsAvailableProvider;
    private final Provider<Boolean> isHmsAvailableProvider;

    public MapsModule_MapTypeFactory(Provider<Boolean> provider, Provider<Boolean> provider2) {
        this.isGmsAvailableProvider = provider;
        this.isHmsAvailableProvider = provider2;
    }

    public static MapsModule_MapTypeFactory create(Provider<Boolean> provider, Provider<Boolean> provider2) {
        return new MapsModule_MapTypeFactory(provider, provider2);
    }

    public static MapType mapType(boolean z11, boolean z12) {
        return (MapType) Preconditions.checkNotNullFromProvides(MapsModule.INSTANCE.mapType(z11, z12));
    }

    public MapType get() {
        return mapType(this.isGmsAvailableProvider.get().booleanValue(), this.isHmsAvailableProvider.get().booleanValue());
    }
}
