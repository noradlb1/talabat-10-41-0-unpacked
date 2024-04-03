package com.talabat.gms.maps.data.di;

import com.talabat.gms.maps.data.DefaultGmsCameraUpdateFactory;
import com.talabat.gms.maps.data.DefaultGmsLatLngFactory;
import com.talabat.gms.maps.data.DefaultGmsMapsInitializer;
import com.talabat.gms.maps.data.DefaultGmsMapsViewsRepository;
import com.talabat.gms.maps.data.DefaultGmsModelsRepository;
import com.talabat.gms.maps.data.DefaultSupportMapFragment;
import com.talabat.gms.maps.data.model.GmsBitmapDescriptorFactory;
import com.talabat.gms.maps.data.model.GmsCameraPositionBuilder;
import com.talabat.gms.maps.data.model.GmsCircleOptionsWrapper;
import com.talabat.gms.maps.data.model.GmsLatLngBoundsBuilder;
import com.talabat.gms.maps.data.model.GmsMarkerOptionsWrapper;
import com.talabat.gms.maps.domain.GmsCameraUpdateFactory;
import com.talabat.gms.maps.domain.GmsLatLngFactory;
import com.talabat.gms.maps.domain.GmsMapsInitializer;
import com.talabat.gms.maps.domain.GmsMapsViewsRepository;
import com.talabat.gms.maps.domain.GmsModelsRepository;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.ui.MapFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 !2\u00020\u0001:\u0001!J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020 H'¨\u0006\""}, d2 = {"Lcom/talabat/gms/maps/data/di/GmsMapsModule;", "", "bitmapDescriptorFactory", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "real", "Lcom/talabat/gms/maps/data/model/GmsBitmapDescriptorFactory;", "cameraPositionBuilder", "Lcom/talabat/maps/domain/model/CameraPosition$Builder;", "Lcom/talabat/gms/maps/data/model/GmsCameraPositionBuilder;", "circleOptionsWrapper", "Lcom/talabat/maps/domain/model/CircleOptions;", "Lcom/talabat/gms/maps/data/model/GmsCircleOptionsWrapper;", "gmsCameraUpdateFactory", "Lcom/talabat/gms/maps/domain/GmsCameraUpdateFactory;", "Lcom/talabat/gms/maps/data/DefaultGmsCameraUpdateFactory;", "gmsMapsViewsRepository", "Lcom/talabat/gms/maps/domain/GmsMapsViewsRepository;", "Lcom/talabat/gms/maps/data/DefaultGmsMapsViewsRepository;", "gmsModelsRepository", "Lcom/talabat/gms/maps/domain/GmsModelsRepository;", "Lcom/talabat/gms/maps/data/DefaultGmsModelsRepository;", "latLngBoundsBuilder", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "Lcom/talabat/gms/maps/data/model/GmsLatLngBoundsBuilder;", "latLngFactory", "Lcom/talabat/gms/maps/domain/GmsLatLngFactory;", "Lcom/talabat/gms/maps/data/DefaultGmsLatLngFactory;", "mapsInitializer", "Lcom/talabat/gms/maps/domain/GmsMapsInitializer;", "Lcom/talabat/gms/maps/data/DefaultGmsMapsInitializer;", "markerOptionsWrapper", "Lcom/talabat/maps/domain/model/MarkerOptions;", "Lcom/talabat/gms/maps/data/model/GmsMarkerOptionsWrapper;", "Companion", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface GmsMapsModule {
    @NotNull
    public static final Companion Companion = Companion.f60559a;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/talabat/gms/maps/data/di/GmsMapsModule$Companion;", "", "()V", "supportMapFragment", "Lcom/talabat/maps/domain/ui/MapFragment;", "com_talabat_core_gms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f60559a = new Companion();

        private Companion() {
        }

        @NotNull
        @Provides
        public final MapFragment supportMapFragment() {
            return new DefaultSupportMapFragment();
        }
    }

    @NotNull
    @Binds
    @Reusable
    BitmapDescriptorFactory bitmapDescriptorFactory(@NotNull GmsBitmapDescriptorFactory gmsBitmapDescriptorFactory);

    @NotNull
    @Binds
    CameraPosition.Builder cameraPositionBuilder(@NotNull GmsCameraPositionBuilder gmsCameraPositionBuilder);

    @NotNull
    @Binds
    @Reusable
    CircleOptions circleOptionsWrapper(@NotNull GmsCircleOptionsWrapper gmsCircleOptionsWrapper);

    @NotNull
    @Binds
    @Reusable
    GmsCameraUpdateFactory gmsCameraUpdateFactory(@NotNull DefaultGmsCameraUpdateFactory defaultGmsCameraUpdateFactory);

    @NotNull
    @Binds
    @Reusable
    GmsMapsViewsRepository gmsMapsViewsRepository(@NotNull DefaultGmsMapsViewsRepository defaultGmsMapsViewsRepository);

    @NotNull
    @Binds
    @Reusable
    GmsModelsRepository gmsModelsRepository(@NotNull DefaultGmsModelsRepository defaultGmsModelsRepository);

    @NotNull
    @Binds
    LatLngBounds.Builder latLngBoundsBuilder(@NotNull GmsLatLngBoundsBuilder gmsLatLngBoundsBuilder);

    @NotNull
    @Binds
    @Reusable
    GmsLatLngFactory latLngFactory(@NotNull DefaultGmsLatLngFactory defaultGmsLatLngFactory);

    @NotNull
    @Binds
    @Reusable
    GmsMapsInitializer mapsInitializer(@NotNull DefaultGmsMapsInitializer defaultGmsMapsInitializer);

    @NotNull
    @Binds
    @Reusable
    MarkerOptions markerOptionsWrapper(@NotNull GmsMarkerOptionsWrapper gmsMarkerOptionsWrapper);
}
