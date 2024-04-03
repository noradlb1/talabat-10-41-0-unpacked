package com.talabat.location.data.di;

import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.location.domain.GmsLocationCoreLibApi;
import com.talabat.core.hms.base.domain.HmsBaseCoreLibApi;
import com.talabat.core.hms.location.domain.HmsLocationCoreLibApi;
import com.talabat.location.domain.di.LocationCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/location/data/di/LocationCoreLibComponent;", "Lcom/talabat/location/domain/di/LocationCoreLibApi;", "Factory", "com_talabat_core_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {GmsBaseCoreLibApi.class, GmsLocationCoreLibApi.class, HmsBaseCoreLibApi.class, HmsLocationCoreLibApi.class}, modules = {LocationModule.class})
public interface LocationCoreLibComponent extends LocationCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/location/data/di/LocationCoreLibComponent$Factory;", "", "create", "Lcom/talabat/location/data/di/LocationCoreLibComponent;", "gmsBaseCoreLibApi", "Lcom/talabat/core/gms/base/domain/GmsBaseCoreLibApi;", "gmsLocationCoreLibApi", "Lcom/talabat/core/gms/location/domain/GmsLocationCoreLibApi;", "hmsBaseCoreLibApi", "Lcom/talabat/core/hms/base/domain/HmsBaseCoreLibApi;", "hmsLocationCoreLibApi", "Lcom/talabat/core/hms/location/domain/HmsLocationCoreLibApi;", "com_talabat_core_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        LocationCoreLibComponent create(@NotNull GmsBaseCoreLibApi gmsBaseCoreLibApi, @NotNull GmsLocationCoreLibApi gmsLocationCoreLibApi, @NotNull HmsBaseCoreLibApi hmsBaseCoreLibApi, @NotNull HmsLocationCoreLibApi hmsLocationCoreLibApi);
    }
}
