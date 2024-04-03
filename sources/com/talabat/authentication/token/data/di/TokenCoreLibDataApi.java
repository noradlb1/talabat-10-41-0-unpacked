package com.talabat.authentication.token.data.di;

import com.talabat.authentication.token.data.flutter.TokenFlutterMapper;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.TokenCoreLibApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/authentication/token/data/di/TokenCoreLibDataApi;", "Lcom/talabat/authentication/token/domain/TokenCoreLibApi;", "legacyTokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "getLegacyTokenLocalDataSource", "()Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "legacyTokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "getLegacyTokenRemoteDataSource", "()Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "tokenFlutterMapper", "Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "getTokenFlutterMapper", "()Lcom/talabat/authentication/token/data/flutter/TokenFlutterMapper;", "tokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "getTokenLocalDataSource", "()Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "tokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "getTokenRemoteDataSource", "()Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "getTokenResponseMapper", "()Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenCoreLibDataApi extends TokenCoreLibApi {
    @NotNull
    LegacyTokenLocalDataSource getLegacyTokenLocalDataSource();

    @NotNull
    LegacyTokenRemoteDataSource getLegacyTokenRemoteDataSource();

    @NotNull
    TokenFlutterMapper getTokenFlutterMapper();

    @NotNull
    TokenLocalDataSource getTokenLocalDataSource();

    @NotNull
    TokenRemoteDataSource getTokenRemoteDataSource();

    @NotNull
    TokenResponseMapper getTokenResponseMapper();
}
