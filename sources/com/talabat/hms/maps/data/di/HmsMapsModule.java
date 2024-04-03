package com.talabat.hms.maps.data.di;

import com.talabat.hms.maps.data.DefaultHmsCameraUpdateFactory;
import com.talabat.hms.maps.data.DefaultHmsLatLngFactory;
import com.talabat.hms.maps.data.DefaultHmsMapsInitializer;
import com.talabat.hms.maps.data.DefaultHmsMapsViewsRepository;
import com.talabat.hms.maps.data.DefaultHmsModelsRepository;
import com.talabat.hms.maps.data.DefaultHmsSupportMapFragment;
import com.talabat.hms.maps.data.model.HmsBitmapDescriptorFactory;
import com.talabat.hms.maps.data.model.HmsCameraPositionBuilder;
import com.talabat.hms.maps.data.model.HmsCircleOptionsWrapper;
import com.talabat.hms.maps.data.model.HmsLatLngBoundsBuilder;
import com.talabat.hms.maps.data.model.HmsMarkerOptionsWrapper;
import com.talabat.hms.maps.domain.HmsCameraUpdateFactory;
import com.talabat.hms.maps.domain.HmsLatLngFactory;
import com.talabat.hms.maps.domain.HmsMapsInitializer;
import com.talabat.hms.maps.domain.HmsMapsViewsRepository;
import com.talabat.hms.maps.domain.HmsModelsRepository;
import com.talabat.maps.domain.model.BitmapDescriptorFactory;
import com.talabat.maps.domain.model.CameraPosition;
import com.talabat.maps.domain.model.CircleOptions;
import com.talabat.maps.domain.model.LatLngBounds;
import com.talabat.maps.domain.model.MarkerOptions;
import com.talabat.maps.domain.ui.MapFragment;
import com.talabat.secrets.Secrets;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u0000 !2\u00020\u0001:\u0001!J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0014H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0017H'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u001aH'J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u001dH'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020 H'¨\u0006\""}, d2 = {"Lcom/talabat/hms/maps/data/di/HmsMapsModule;", "", "bitmapDescriptorFactory", "Lcom/talabat/maps/domain/model/BitmapDescriptorFactory;", "real", "Lcom/talabat/hms/maps/data/model/HmsBitmapDescriptorFactory;", "cameraPositionBuilder", "Lcom/talabat/maps/domain/model/CameraPosition$Builder;", "Lcom/talabat/hms/maps/data/model/HmsCameraPositionBuilder;", "circleOptionsWrapper", "Lcom/talabat/maps/domain/model/CircleOptions;", "Lcom/talabat/hms/maps/data/model/HmsCircleOptionsWrapper;", "hmsCameraUpdateFactory", "Lcom/talabat/hms/maps/domain/HmsCameraUpdateFactory;", "Lcom/talabat/hms/maps/data/DefaultHmsCameraUpdateFactory;", "hmsMapsViewsRepository", "Lcom/talabat/hms/maps/domain/HmsMapsViewsRepository;", "Lcom/talabat/hms/maps/data/DefaultHmsMapsViewsRepository;", "hmsModelsRepository", "Lcom/talabat/hms/maps/domain/HmsModelsRepository;", "Lcom/talabat/hms/maps/data/DefaultHmsModelsRepository;", "latLngBoundsBuilder", "Lcom/talabat/maps/domain/model/LatLngBounds$Builder;", "Lcom/talabat/hms/maps/data/model/HmsLatLngBoundsBuilder;", "latLngFactory", "Lcom/talabat/hms/maps/domain/HmsLatLngFactory;", "Lcom/talabat/hms/maps/data/DefaultHmsLatLngFactory;", "mapsInitializer", "Lcom/talabat/hms/maps/domain/HmsMapsInitializer;", "Lcom/talabat/hms/maps/data/DefaultHmsMapsInitializer;", "markerOptionsWrapper", "Lcom/talabat/maps/domain/model/MarkerOptions;", "Lcom/talabat/hms/maps/data/model/HmsMarkerOptionsWrapper;", "Companion", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface HmsMapsModule {
    @NotNull
    public static final Companion Companion = Companion.f60864a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/talabat/hms/maps/data/di/HmsMapsModule$Companion;", "", "()V", "secrets", "Lcom/talabat/secrets/Secrets;", "supportMapFragment", "Lcom/talabat/maps/domain/ui/MapFragment;", "com_talabat_core_hms_maps_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f60864a = new Companion();

        private Companion() {
        }

        @NotNull
        @Reusable
        @Provides
        public final Secrets secrets() {
            return new Secrets();
        }

        @NotNull
        @Provides
        public final MapFragment supportMapFragment() {
            return new DefaultHmsSupportMapFragment();
        }
    }

    @NotNull
    @Binds
    @Reusable
    BitmapDescriptorFactory bitmapDescriptorFactory(@NotNull HmsBitmapDescriptorFactory hmsBitmapDescriptorFactory);

    @NotNull
    @Binds
    CameraPosition.Builder cameraPositionBuilder(@NotNull HmsCameraPositionBuilder hmsCameraPositionBuilder);

    @NotNull
    @Binds
    @Reusable
    CircleOptions circleOptionsWrapper(@NotNull HmsCircleOptionsWrapper hmsCircleOptionsWrapper);

    @NotNull
    @Binds
    @Reusable
    HmsCameraUpdateFactory hmsCameraUpdateFactory(@NotNull DefaultHmsCameraUpdateFactory defaultHmsCameraUpdateFactory);

    @NotNull
    @Binds
    @Reusable
    HmsMapsViewsRepository hmsMapsViewsRepository(@NotNull DefaultHmsMapsViewsRepository defaultHmsMapsViewsRepository);

    @NotNull
    @Binds
    @Reusable
    HmsModelsRepository hmsModelsRepository(@NotNull DefaultHmsModelsRepository defaultHmsModelsRepository);

    @NotNull
    @Binds
    LatLngBounds.Builder latLngBoundsBuilder(@NotNull HmsLatLngBoundsBuilder hmsLatLngBoundsBuilder);

    @NotNull
    @Binds
    @Reusable
    HmsLatLngFactory latLngFactory(@NotNull DefaultHmsLatLngFactory defaultHmsLatLngFactory);

    @NotNull
    @Binds
    @Reusable
    HmsMapsInitializer mapsInitializer(@NotNull DefaultHmsMapsInitializer defaultHmsMapsInitializer);

    @NotNull
    @Binds
    @Reusable
    MarkerOptions markerOptionsWrapper(@NotNull HmsMarkerOptionsWrapper hmsMarkerOptionsWrapper);
}
