package com.talabat.maps.data.di;

import com.huawei.hms.flutter.map.constants.Param;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.hms.base.domain.IsHmsAvailable;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapType;
import com.talabat.maps.domain.MapViewsRepository;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0007J\u001c\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0007J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0007J \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006&"}, d2 = {"Lcom/talabat/maps/data/di/MapsModule;", "", "()V", "cameraUpdateFactory", "Lcom/talabat/maps/domain/CameraUpdateFactory;", "gmsCameraUpdateFactory", "Lcom/talabat/gms/maps/domain/GmsCameraUpdateFactory;", "hmsCameraUpdateFactory", "Lcom/talabat/hms/maps/domain/HmsCameraUpdateFactory;", "mapType", "Lcom/talabat/maps/domain/MapType;", "latLngFactory", "Lcom/talabat/maps/domain/LatLngFactory;", "gmsLatLngFactory", "Lcom/talabat/gms/maps/domain/GmsLatLngFactory;", "hmsLatLngFactory", "Lcom/talabat/hms/maps/domain/HmsLatLngFactory;", "isGmsAvailable", "", "isHmsAvailable", "mapViewsRepository", "Lcom/talabat/maps/domain/MapViewsRepository;", "gmsMapsViewsRepository", "Lcom/talabat/gms/maps/domain/GmsMapsViewsRepository;", "hmsMapsViewsRepository", "Lcom/talabat/hms/maps/domain/HmsMapsViewsRepository;", "mapsInitializer", "Lcom/talabat/maps/domain/MapsInitializer;", "gmsMapsInitializer", "Lcom/talabat/gms/maps/domain/GmsMapsInitializer;", "hmsMapsInitializer", "Lcom/talabat/hms/maps/domain/HmsMapsInitializer;", "modelsRepository", "Lcom/talabat/maps/domain/ModelsRepository;", "gmsModelsRepository", "Lcom/talabat/gms/maps/domain/GmsModelsRepository;", "hmsModelsRepository", "Lcom/talabat/hms/maps/domain/HmsModelsRepository;", "com_talabat_core_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class MapsModule {
    @NotNull
    public static final MapsModule INSTANCE = new MapsModule();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MapType.values().length];
            iArr[MapType.HUAWEI.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MapsModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final CameraUpdateFactory cameraUpdateFactory(@NotNull GmsCameraUpdateFactory gmsCameraUpdateFactory, @NotNull HmsCameraUpdateFactory hmsCameraUpdateFactory, @NotNull MapType mapType) {
        Intrinsics.checkNotNullParameter(gmsCameraUpdateFactory, "gmsCameraUpdateFactory");
        Intrinsics.checkNotNullParameter(hmsCameraUpdateFactory, "hmsCameraUpdateFactory");
        Intrinsics.checkNotNullParameter(mapType, Param.MAP_TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            return hmsCameraUpdateFactory;
        }
        return gmsCameraUpdateFactory;
    }

    @NotNull
    @Reusable
    @Provides
    public final LatLngFactory latLngFactory(@NotNull GmsLatLngFactory gmsLatLngFactory, @NotNull HmsLatLngFactory hmsLatLngFactory, @NotNull MapType mapType) {
        Intrinsics.checkNotNullParameter(gmsLatLngFactory, "gmsLatLngFactory");
        Intrinsics.checkNotNullParameter(hmsLatLngFactory, "hmsLatLngFactory");
        Intrinsics.checkNotNullParameter(mapType, Param.MAP_TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            return hmsLatLngFactory;
        }
        return gmsLatLngFactory;
    }

    @NotNull
    @Reusable
    @Provides
    public final MapType mapType(@IsGmsAvailable boolean z11, @IsHmsAvailable boolean z12) {
        if (z11 || !z12) {
            return MapType.DEFAULT;
        }
        return MapType.HUAWEI;
    }

    @NotNull
    @Reusable
    @Provides
    public final MapViewsRepository mapViewsRepository(@NotNull GmsMapsViewsRepository gmsMapsViewsRepository, @NotNull HmsMapsViewsRepository hmsMapsViewsRepository, @NotNull MapType mapType) {
        Intrinsics.checkNotNullParameter(gmsMapsViewsRepository, "gmsMapsViewsRepository");
        Intrinsics.checkNotNullParameter(hmsMapsViewsRepository, "hmsMapsViewsRepository");
        Intrinsics.checkNotNullParameter(mapType, Param.MAP_TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            return hmsMapsViewsRepository;
        }
        return gmsMapsViewsRepository;
    }

    @NotNull
    @Reusable
    @Provides
    public final MapsInitializer mapsInitializer(@NotNull GmsMapsInitializer gmsMapsInitializer, @NotNull HmsMapsInitializer hmsMapsInitializer, @NotNull MapType mapType) {
        Intrinsics.checkNotNullParameter(gmsMapsInitializer, "gmsMapsInitializer");
        Intrinsics.checkNotNullParameter(hmsMapsInitializer, "hmsMapsInitializer");
        Intrinsics.checkNotNullParameter(mapType, Param.MAP_TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            return hmsMapsInitializer;
        }
        return gmsMapsInitializer;
    }

    @NotNull
    @Reusable
    @Provides
    public final ModelsRepository modelsRepository(@NotNull GmsModelsRepository gmsModelsRepository, @NotNull HmsModelsRepository hmsModelsRepository, @NotNull MapType mapType) {
        Intrinsics.checkNotNullParameter(gmsModelsRepository, "gmsModelsRepository");
        Intrinsics.checkNotNullParameter(hmsModelsRepository, "hmsModelsRepository");
        Intrinsics.checkNotNullParameter(mapType, Param.MAP_TYPE);
        if (WhenMappings.$EnumSwitchMapping$0[mapType.ordinal()] == 1) {
            return hmsModelsRepository;
        }
        return gmsModelsRepository;
    }
}
