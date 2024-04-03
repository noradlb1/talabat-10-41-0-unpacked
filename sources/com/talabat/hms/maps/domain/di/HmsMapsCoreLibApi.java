package com.talabat.hms.maps.domain.di;

import com.talabat.core.di.Api;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/hms/maps/domain/di/HmsMapsCoreLibApi;", "Lcom/talabat/core/di/Api;", "hmsCameraUpdateFactory", "Lcom/talabat/hms/maps/domain/HmsCameraUpdateFactory;", "getHmsCameraUpdateFactory", "()Lcom/talabat/hms/maps/domain/HmsCameraUpdateFactory;", "hmsLatLngFactory", "Lcom/talabat/hms/maps/domain/HmsLatLngFactory;", "getHmsLatLngFactory", "()Lcom/talabat/hms/maps/domain/HmsLatLngFactory;", "hmsMapsInitializer", "Lcom/talabat/hms/maps/domain/HmsMapsInitializer;", "getHmsMapsInitializer", "()Lcom/talabat/hms/maps/domain/HmsMapsInitializer;", "hmsMapsViewsRepository", "Lcom/talabat/hms/maps/domain/HmsMapsViewsRepository;", "getHmsMapsViewsRepository", "()Lcom/talabat/hms/maps/domain/HmsMapsViewsRepository;", "hmsModelsRepository", "Lcom/talabat/hms/maps/domain/HmsModelsRepository;", "getHmsModelsRepository", "()Lcom/talabat/hms/maps/domain/HmsModelsRepository;", "com_talabat_core_hms_maps_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HmsMapsCoreLibApi extends Api {
    @NotNull
    HmsCameraUpdateFactory getHmsCameraUpdateFactory();

    @NotNull
    HmsLatLngFactory getHmsLatLngFactory();

    @NotNull
    HmsMapsInitializer getHmsMapsInitializer();

    @NotNull
    HmsMapsViewsRepository getHmsMapsViewsRepository();

    @NotNull
    HmsModelsRepository getHmsModelsRepository();
}
