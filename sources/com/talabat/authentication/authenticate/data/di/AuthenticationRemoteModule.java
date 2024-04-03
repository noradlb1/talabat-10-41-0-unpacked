package com.talabat.authentication.authenticate.data.di;

import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource;
import com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/authenticate/data/di/AuthenticationRemoteModule;", "", "authenticationRemoteDataSource", "Lcom/talabat/authentication/authenticate/data/remote/AuthenticationRemoteDataSource;", "impl", "Lcom/talabat/authentication/authenticate/data/remote/impl/AuthenticationRemoteDataSourceImpl;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface AuthenticationRemoteModule {
    @NotNull
    @Binds
    @Reusable
    AuthenticationRemoteDataSource authenticationRemoteDataSource(@NotNull AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl);
}
