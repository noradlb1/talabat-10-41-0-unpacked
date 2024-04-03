package com.talabat.authentication.natives.di;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.JwtTokenRepository;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import com.talabat.authentication.natives.JwtTokenManagerImpl;
import com.talabat.authentication.natives.JwtTokenRepositoryImpl;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.IsTokenExpiredUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/authentication/natives/di/JwtTokenCoreLibModule;", "", "jwtTokenRepository", "Lcom/talabat/authentication/JwtTokenRepository;", "impl", "Lcom/talabat/authentication/natives/JwtTokenRepositoryImpl;", "Ext", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Ext.class})
public interface JwtTokenCoreLibModule {

    @Module
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jh\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007¨\u0006\u001d"}, d2 = {"Lcom/talabat/authentication/natives/di/JwtTokenCoreLibModule$Ext;", "", "()V", "jwtTokenManager", "Lcom/talabat/authentication/JwtTokenManager;", "aaaApi", "Lcom/talabat/authentication/aaa/AaaApi;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "exchangeAllowed", "Lcom/talabat/authentication/authenticate/domain/usecase/TokenExchangeAllowed;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "remoteConfig", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "tokenExchangeRetriesRepository", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "isTokenExpiredUseCase", "Lcom/talabat/authentication/usecase/IsTokenExpiredUseCase;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Ext {
        @NotNull
        public static final Ext INSTANCE = new Ext();

        private Ext() {
        }

        @NotNull
        @Reusable
        @Provides
        public final JwtTokenManager jwtTokenManager(@NotNull AaaApi aaaApi, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull TokenExchangeAllowed tokenExchangeAllowed, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IRemoteConfigurationDataSource iRemoteConfigurationDataSource, @NotNull SecretProvider secretProvider, @NotNull TokenExchangeRetriesRepository tokenExchangeRetriesRepository, @NotNull TokenResponseMapper tokenResponseMapper, @NotNull TokenRepository tokenRepository, @NotNull IsTokenExpiredUseCase isTokenExpiredUseCase, @NotNull IObservabilityManager iObservabilityManager) {
            IObservabilityManager iObservabilityManager2 = iObservabilityManager;
            Intrinsics.checkNotNullParameter(aaaApi, "aaaApi");
            Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "coroutineDispatchersFactory");
            Intrinsics.checkNotNullParameter(tokenExchangeAllowed, "exchangeAllowed");
            Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
            Intrinsics.checkNotNullParameter(iRemoteConfigurationDataSource, "remoteConfig");
            Intrinsics.checkNotNullParameter(secretProvider, "secretProvider");
            Intrinsics.checkNotNullParameter(tokenExchangeRetriesRepository, "tokenExchangeRetriesRepository");
            Intrinsics.checkNotNullParameter(tokenResponseMapper, "tokenResponseMapper");
            Intrinsics.checkNotNullParameter(tokenRepository, "tokenRepository");
            Intrinsics.checkNotNullParameter(isTokenExpiredUseCase, "isTokenExpiredUseCase");
            Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
            return new JwtTokenManagerImpl(aaaApi, coroutineDispatchersFactory, tokenExchangeAllowed, iTalabatExperiment, iTalabatFeatureFlag, iObservabilityManager2, JwtTokenCoreLibModule$Ext$jwtTokenManager$1.INSTANCE, secretProvider, tokenExchangeRetriesRepository, tokenResponseMapper, tokenRepository, isTokenExpiredUseCase, (Function0) null, (Function0) null, (Function0) null, 28672, (DefaultConstructorMarker) null);
        }
    }

    @NotNull
    @Binds
    @Reusable
    JwtTokenRepository jwtTokenRepository(@NotNull JwtTokenRepositoryImpl jwtTokenRepositoryImpl);
}
