package com.talabat.gms.maps.data;

import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.maps.domain.ui.MapFragment;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/gms/maps/data/DefaultGmsMapsViewsRepository;", "Lcom/talabat/gms/maps/domain/GmsMapsViewsRepository;", "supportFragmentProvider", "Ljavax/inject/Provider;", "Lcom/talabat/maps/domain/ui/MapFragment;", "(Ljavax/inject/Provider;)V", "supportMapFragment", "getSupportMapFragment", "()Lcom/talabat/maps/domain/ui/MapFragment;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultGmsMapsViewsRepository implements GmsMapsViewsRepository {
    @NotNull
    private final Provider<MapFragment> supportFragmentProvider;

    @Inject
    public DefaultGmsMapsViewsRepository(@NotNull Provider<MapFragment> provider) {
        Intrinsics.checkNotNullParameter(provider, "supportFragmentProvider");
        this.supportFragmentProvider = provider;
    }

    @NotNull
    public MapFragment getSupportMapFragment() {
        MapFragment mapFragment = this.supportFragmentProvider.get();
        Intrinsics.checkNotNullExpressionValue(mapFragment, "supportFragmentProvider.get()");
        return mapFragment;
    }
}
