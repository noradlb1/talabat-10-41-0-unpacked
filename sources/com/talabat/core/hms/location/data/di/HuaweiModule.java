package com.talabat.core.hms.location.data.di;

import android.content.Context;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.SettingsClient;
import com.talabat.core.context.domain.ApplicationContext;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/core/hms/location/data/di/HuaweiModule;", "", "()V", "fusedLocationProviderClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "context", "Landroid/content/Context;", "huaweiLocationRequest", "Lcom/huawei/hms/location/LocationRequest;", "locationSettingsRequestBuilder", "Lcom/huawei/hms/location/LocationSettingsRequest$Builder;", "settingsClient", "Lcom/huawei/hms/location/SettingsClient;", "com_talabat_core_hms_location_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class HuaweiModule {
    @NotNull
    public static final HuaweiModule INSTANCE = new HuaweiModule();

    private HuaweiModule() {
    }

    @NotNull
    @Provides
    public final FusedLocationProviderClient fusedLocationProviderClient(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FusedLocationProviderClient(context);
    }

    @NotNull
    @Provides
    public final LocationRequest huaweiLocationRequest() {
        return new LocationRequest();
    }

    @NotNull
    @Provides
    public final LocationSettingsRequest.Builder locationSettingsRequestBuilder() {
        return new LocationSettingsRequest.Builder();
    }

    @NotNull
    @Provides
    public final SettingsClient settingsClient(@NotNull @ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new SettingsClient(context);
    }
}
