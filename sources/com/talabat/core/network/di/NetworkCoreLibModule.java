package com.talabat.core.network.di;

import com.talabat.core.network.data.endpoint.DefaultBaseUrlFactory;
import com.talabat.core.network.domain.endpoint.BaseUrlFactory;
import com.talabat.core.network.network.OKHttpBuilder;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.List;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/di/NetworkCoreLibModule;", "", "()V", "okHttpClient", "Lokhttp3/OkHttpClient;", "Declarations", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Declarations.class})
public final class NetworkCoreLibModule {
    @NotNull
    public static final NetworkCoreLibModule INSTANCE = new NetworkCoreLibModule();

    @Module
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/di/NetworkCoreLibModule$Declarations;", "", "baseUrlFactory", "Lcom/talabat/core/network/domain/endpoint/BaseUrlFactory;", "impl", "Lcom/talabat/core/network/data/endpoint/DefaultBaseUrlFactory;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Declarations {
        @NotNull
        @Binds
        @Reusable
        BaseUrlFactory baseUrlFactory(@NotNull DefaultBaseUrlFactory defaultBaseUrlFactory);
    }

    private NetworkCoreLibModule() {
    }

    @NotNull
    @Reusable
    @Provides
    public final OkHttpClient okHttpClient() {
        return OKHttpBuilder.getDefaultHttpClient$default(OKHttpBuilder.INSTANCE, (List) null, 0, 3, (Object) null);
    }
}
