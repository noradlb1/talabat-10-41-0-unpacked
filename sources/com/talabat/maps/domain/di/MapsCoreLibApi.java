package com.talabat.maps.domain.di;

import com.talabat.core.di.Api;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.MapViewsRepository;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "Lcom/talabat/core/di/Api;", "cameraUpdateFactory", "Lcom/talabat/maps/domain/CameraUpdateFactory;", "getCameraUpdateFactory", "()Lcom/talabat/maps/domain/CameraUpdateFactory;", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "getLatLngFactory", "()Lcom/talabat/maps/domain/LatLngFactory;", "mapViewsRepository", "Lcom/talabat/maps/domain/MapViewsRepository;", "getMapViewsRepository", "()Lcom/talabat/maps/domain/MapViewsRepository;", "mapsInitializer", "Lcom/talabat/maps/domain/MapsInitializer;", "getMapsInitializer", "()Lcom/talabat/maps/domain/MapsInitializer;", "modelsRepository", "Lcom/talabat/maps/domain/ModelsRepository;", "getModelsRepository", "()Lcom/talabat/maps/domain/ModelsRepository;", "usingMapType", "Lcom/talabat/maps/domain/MapType;", "getUsingMapType", "()Lcom/talabat/maps/domain/MapType;", "com_talabat_core_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MapsCoreLibApi extends Api {
    @NotNull
    CameraUpdateFactory getCameraUpdateFactory();

    @NotNull
    LatLngFactory getLatLngFactory();

    @NotNull
    MapViewsRepository getMapViewsRepository();

    @NotNull
    MapsInitializer getMapsInitializer();

    @NotNull
    ModelsRepository getModelsRepository();

    @NotNull
    MapType getUsingMapType();
}
