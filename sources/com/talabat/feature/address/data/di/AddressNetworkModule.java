package com.talabat.feature.address.data.di;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.feature.address.data.remote.api.AddressApi;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/address/data/di/AddressNetworkModule;", "", "()V", "fallbackRest", "Lcom/talabat/feature/address/data/remote/api/AddressApi;", "rest", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class AddressNetworkModule {
    @NotNull
    public static final AddressNetworkModule INSTANCE = new AddressNetworkModule();

    private AddressNetworkModule() {
    }

    @FallbackApi
    @NotNull
    @Provides
    public final AddressApi fallbackRest() {
        return (AddressApi) new TalabatAPIBuilder().createApi(AddressApi.class);
    }

    @NotNull
    @Provides
    public final AddressApi rest() {
        return (AddressApi) new TalabatAPIBuilder().createApi("https://userlocation.talabat.com/api/", AddressApi.class);
    }
}
