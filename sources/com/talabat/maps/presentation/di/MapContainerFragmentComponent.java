package com.talabat.maps.presentation.di;

import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.presentation.MapContainerFragment;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/maps/presentation/di/MapContainerFragmentComponent;", "", "inject", "", "target", "Lcom/talabat/maps/presentation/MapContainerFragment;", "Factory", "com_talabat_core_maps_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {MapsCoreLibApi.class})
public interface MapContainerFragmentComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/maps/presentation/di/MapContainerFragmentComponent$Factory;", "", "create", "Lcom/talabat/maps/presentation/di/MapContainerFragmentComponent;", "mapsCoreLibApi", "Lcom/talabat/maps/domain/di/MapsCoreLibApi;", "com_talabat_core_maps_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        MapContainerFragmentComponent create(@NotNull MapsCoreLibApi mapsCoreLibApi);
    }

    void inject(@NotNull MapContainerFragment mapContainerFragment);
}
