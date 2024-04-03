package com.talabat.feature.address.data.di;

import com.talabat.feature.address.data.remote.AddressRemoteDataSource;
import com.talabat.feature.address.data.remote.impl.AddressRemoteDataSourceImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/address/data/di/AddressRemoteModule;", "", "remoteDataSource", "Lcom/talabat/feature/address/data/remote/AddressRemoteDataSource;", "impl", "Lcom/talabat/feature/address/data/remote/impl/AddressRemoteDataSourceImpl;", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {AddressNetworkModule.class})
public interface AddressRemoteModule {
    @NotNull
    @Binds
    AddressRemoteDataSource remoteDataSource(@NotNull AddressRemoteDataSourceImpl addressRemoteDataSourceImpl);
}
