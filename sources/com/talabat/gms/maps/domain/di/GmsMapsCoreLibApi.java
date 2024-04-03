package com.talabat.gms.maps.domain.di;

import com.talabat.core.di.Api;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/gms/maps/domain/di/GmsMapsCoreLibApi;", "Lcom/talabat/core/di/Api;", "gmsCameraUpdateFactory", "Lcom/talabat/gms/maps/domain/GmsCameraUpdateFactory;", "getGmsCameraUpdateFactory", "()Lcom/talabat/gms/maps/domain/GmsCameraUpdateFactory;", "gmsLatLngFactory", "Lcom/talabat/gms/maps/domain/GmsLatLngFactory;", "getGmsLatLngFactory", "()Lcom/talabat/gms/maps/domain/GmsLatLngFactory;", "gmsMapsInitializer", "Lcom/talabat/gms/maps/domain/GmsMapsInitializer;", "getGmsMapsInitializer", "()Lcom/talabat/gms/maps/domain/GmsMapsInitializer;", "gmsMapsViewsRepository", "Lcom/talabat/gms/maps/domain/GmsMapsViewsRepository;", "getGmsMapsViewsRepository", "()Lcom/talabat/gms/maps/domain/GmsMapsViewsRepository;", "gmsModelsRepository", "Lcom/talabat/gms/maps/domain/GmsModelsRepository;", "getGmsModelsRepository", "()Lcom/talabat/gms/maps/domain/GmsModelsRepository;", "com_talabat_core_gms_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GmsMapsCoreLibApi extends Api {
    @NotNull
    GmsCameraUpdateFactory getGmsCameraUpdateFactory();

    @NotNull
    GmsLatLngFactory getGmsLatLngFactory();

    @NotNull
    GmsMapsInitializer getGmsMapsInitializer();

    @NotNull
    GmsMapsViewsRepository getGmsMapsViewsRepository();

    @NotNull
    GmsModelsRepository getGmsModelsRepository();
}
