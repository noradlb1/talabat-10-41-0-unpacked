package com.talabat.core.network.di;

import com.talabat.core.network.domain.NetworkCoreLibApi;
import com.talabat.core.parser.domain.ParserCoreLibApi;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/core/network/di/NetworkCoreLibComponent;", "Lcom/talabat/core/network/domain/NetworkCoreLibApi;", "Factory", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Component(dependencies = {ParserCoreLibApi.class}, modules = {RestModule.class})
public interface NetworkCoreLibComponent extends NetworkCoreLibApi {

    @Component.Factory
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/core/network/di/NetworkCoreLibComponent$Factory;", "", "create", "Lcom/talabat/core/network/di/NetworkCoreLibComponent;", "parserCoreLibApi", "Lcom/talabat/core/parser/domain/ParserCoreLibApi;", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        @NotNull
        NetworkCoreLibComponent create(@NotNull ParserCoreLibApi parserCoreLibApi);
    }
}
