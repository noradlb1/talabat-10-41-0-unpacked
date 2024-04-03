package com.talabat.authentication.natives;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.authentication.JwtTokenManager;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed;
import com.talabat.authentication.natives.model.AuthRemoteConfig;
import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.authentication.token.domain.model.Token;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.IsTokenExpiredUseCase;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.registration.RegistrationInteractor;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\u0018\u0000 _2\u00020\u0001:\u0001_B\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f¢\u0006\u0002\u0010 J\b\u00104\u001a\u00020\u001eH\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\u0011\u00107\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u00108J\u0011\u00109\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u00108J\u0011\u0010:\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u00108J\b\u0010;\u001a\u00020\u001eH\u0002J\b\u0010<\u001a\u00020\u001eH\u0002J\b\u0010=\u001a\u00020\u001eH\u0002J\u0019\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0011\u0010B\u001a\u00020CH@ø\u0001\u0000¢\u0006\u0002\u00108J\n\u0010D\u001a\u0004\u0018\u00010?H\u0002J6\u0010E\u001a\u0002012$\u0010F\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0004\u0012\u0002010/0G2\u0006\u0010H\u001a\u00020\u001cH\u0002J\n\u0010I\u001a\u0004\u0018\u00010\u001cH\u0002J\u001b\u0010J\u001a\u0004\u0018\u00010\u001c2\u0006\u0010@\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010AJ6\u0010K\u001a\u00020C2$\u0010F\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0004\u0012\u0002010/0G2\u0006\u0010H\u001a\u00020\u001cH\u0002J\u0010\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0010\u0010N\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001cH\u0002J\u0010\u0010O\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001cH\u0002J,\u0010P\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010TH\u0002J$\u0010P\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020R2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010TH\u0002J\u0010\u0010V\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0019\u0010W\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010AJ\b\u0010X\u001a\u00020CH\u0002J\b\u0010Y\u001a\u00020CH\u0002J\b\u0010Z\u001a\u00020CH\u0002J\b\u0010[\u001a\u00020CH\u0002J!\u0010\\\u001a\u00020C2\u0006\u0010@\u001a\u00020\u001c2\u0006\u0010]\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010^R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R,\u0010-\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0004\u0012\u0002010/0.X\u0004¢\u0006\u0002\n\u0000R,\u00102\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0004\u0012\u0002010/0.X\u0004¢\u0006\u0002\n\u0000R,\u00103\u001a \u0012\u0004\u0012\u00020\u001c\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c00\u0012\u0004\u0012\u0002010/0.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, d2 = {"Lcom/talabat/authentication/natives/JwtTokenManagerImpl;", "Lcom/talabat/authentication/JwtTokenManager;", "aaaApi", "Lcom/talabat/authentication/aaa/AaaApi;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "exchangeAllowed", "Lcom/talabat/authentication/authenticate/domain/usecase/TokenExchangeAllowed;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "remoteConfigProvider", "Lkotlin/Function0;", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "tokenExchangeRetriesRepository", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "isTokenExpiredUseCase", "Lcom/talabat/authentication/usecase/IsTokenExpiredUseCase;", "deviceIdProvider", "", "logoutWithOwinTokenProvider", "", "owinTokenProvider", "(Lcom/talabat/authentication/aaa/AaaApi;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/authentication/authenticate/domain/usecase/TokenExchangeAllowed;Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lkotlin/jvm/functions/Function0;Lcom/talabat/authentication/aaa/secrets/SecretProvider;Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/authentication/usecase/IsTokenExpiredUseCase;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cachedRemoteConfig", "Lcom/talabat/authentication/natives/model/AuthRemoteConfig;", "exchangeIsRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "exchangeTokenObservability", "Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "getExchangeTokenObservability", "()Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "exchangeTokenObservability$delegate", "Lkotlin/Lazy;", "refreshIsRunning", "remoteConfigIsRunning", "suspendedCoroutinesForExchange", "", "Lkotlin/Pair;", "Lkotlin/coroutines/Continuation;", "", "suspendedCoroutinesForRefresh", "suspendedCoroutinesForRemoteConfig", "afterExchange", "afterRefresh", "afterRemoteConfig", "barrierExchange", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "barrierRefresh", "barrierRemoteConfig", "beforeExchange", "beforeRefresh", "beforeRemoteConfig", "doRefreshToken", "Lcom/talabat/authentication/token/domain/model/Token;", "path", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "exchangeTokenWithOneRetry", "", "getAvailableJwtToken", "getMinSuspendedAt", "map", "", "key", "getOwinToken", "getValidToken", "isAlreadyTimedOut", "observabilityForceSignedOut", "tokenType", "observabilityJwtTokenAlreadyRefreshed", "observabilityJwtTokenExchangeFailedAllRetries", "observabilityJwtTokenRefresh", "statusCode", "", "throwable", "", "cause", "observabilitySignedOutOnExchange404", "refreshToken", "shouldCallLogout", "shouldClearOwinTokenOnExchange404", "shouldEnableRefreshToken", "shouldStopUseOwinToken", "shouldUseJwtToken", "variation", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JwtTokenManagerImpl implements JwtTokenManager {
    @NotNull
    public static final String CLIENT_ID_KEY = "client_id";
    @NotNull
    public static final String CLIENT_ID_VALUE = "android";
    @NotNull
    public static final String CLIENT_SECRET_KEY = "client_secret";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String DEVICE_TOKEN = "X-Device";
    @NotNull
    public static final String EXP_USER_AUTHENTICATION_API_MIGRATION_CONTROL = "Control";
    @NotNull
    public static final String EXP_USER_AUTHENTICATION_API_MIGRATION_DEFAULT = "Variation2";
    @NotNull
    public static final String GRANT_TYPE_KEY = "grant_type";
    @NotNull
    public static final String GRANT_TYPE_VALUE = "refresh_token";
    @NotNull
    private static final String OBSER_TOKEN_TYPE_JWT = "jwt";
    @NotNull
    private static final String OBSER_TOKEN_TYPE_OWIN = "owin";
    @NotNull
    public static final String REFRESH_TOKEN_HINT = "refresh_token";
    private static final long REQUEST_TIMEOUT = 60000;
    @NotNull
    public static final String TOKEN_TYPE_HINT = "access_token";
    @NotNull
    private static final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @NotNull
    private final AaaApi aaaApi;
    @Nullable
    private volatile AuthRemoteConfig cachedRemoteConfig;
    @NotNull
    private final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final Function0<String> deviceIdProvider;
    @NotNull
    private final TokenExchangeAllowed exchangeAllowed;
    @NotNull
    private final AtomicBoolean exchangeIsRunning;
    @NotNull
    private final Lazy exchangeTokenObservability$delegate;
    @NotNull
    private final ITalabatExperiment experiment;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final IsTokenExpiredUseCase isTokenExpiredUseCase;
    @NotNull
    private final Function0<Unit> logoutWithOwinTokenProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final IObservabilityManager observabilityManager;
    @NotNull
    private final Function0<String> owinTokenProvider;
    @NotNull
    private final AtomicBoolean refreshIsRunning;
    @NotNull
    private final AtomicBoolean remoteConfigIsRunning;
    @NotNull
    private final Function0<IRemoteConfigurationDataSource> remoteConfigProvider;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final Map<String, Pair<Continuation<String>, Long>> suspendedCoroutinesForExchange;
    @NotNull
    private final Map<String, Pair<Continuation<String>, Long>> suspendedCoroutinesForRefresh;
    @NotNull
    private final Map<String, Pair<Continuation<String>, Long>> suspendedCoroutinesForRemoteConfig;
    @NotNull
    private final TokenExchangeRetriesRepository tokenExchangeRetriesRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenRepository tokenRepository;
    @NotNull
    private final TokenResponseMapper tokenResponseMapper;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/natives/JwtTokenManagerImpl$Companion;", "", "()V", "CLIENT_ID_KEY", "", "CLIENT_ID_VALUE", "CLIENT_SECRET_KEY", "DEVICE_TOKEN", "EXP_USER_AUTHENTICATION_API_MIGRATION_CONTROL", "EXP_USER_AUTHENTICATION_API_MIGRATION_DEFAULT", "GRANT_TYPE_KEY", "GRANT_TYPE_VALUE", "OBSER_TOKEN_TYPE_JWT", "OBSER_TOKEN_TYPE_OWIN", "REFRESH_TOKEN_HINT", "REQUEST_TIMEOUT", "", "TOKEN_TYPE_HINT", "letters", "randomKey", "length", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String randomKey(int i11) {
            char c11;
            StringBuilder sb2 = new StringBuilder();
            for (int i12 = 0; i12 < i11; i12++) {
                int nextInt = Random.Default.nextInt(0, 62);
                if (nextInt < 0 || nextInt > StringsKt__StringsKt.getLastIndex(JwtTokenManagerImpl.letters)) {
                    c11 = TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH;
                } else {
                    c11 = JwtTokenManagerImpl.letters.charAt(nextInt);
                }
                sb2.append(c11);
            }
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "builder.toString()");
            return sb3;
        }
    }

    @Inject
    public JwtTokenManagerImpl(@NotNull AaaApi aaaApi2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull TokenExchangeAllowed tokenExchangeAllowed, @NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager, @NotNull Function0<? extends IRemoteConfigurationDataSource> function0, @NotNull SecretProvider secretProvider2, @NotNull TokenExchangeRetriesRepository tokenExchangeRetriesRepository2, @NotNull TokenResponseMapper tokenResponseMapper2, @NotNull TokenRepository tokenRepository2, @NotNull IsTokenExpiredUseCase isTokenExpiredUseCase2, @NotNull Function0<String> function02, @NotNull Function0<Unit> function03, @NotNull Function0<String> function04) {
        AaaApi aaaApi3 = aaaApi2;
        CoroutineDispatchersFactory coroutineDispatchersFactory3 = coroutineDispatchersFactory2;
        TokenExchangeAllowed tokenExchangeAllowed2 = tokenExchangeAllowed;
        ITalabatExperiment iTalabatExperiment2 = iTalabatExperiment;
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        IObservabilityManager iObservabilityManager2 = iObservabilityManager;
        Function0<? extends IRemoteConfigurationDataSource> function05 = function0;
        SecretProvider secretProvider3 = secretProvider2;
        TokenExchangeRetriesRepository tokenExchangeRetriesRepository3 = tokenExchangeRetriesRepository2;
        TokenResponseMapper tokenResponseMapper3 = tokenResponseMapper2;
        TokenRepository tokenRepository3 = tokenRepository2;
        IsTokenExpiredUseCase isTokenExpiredUseCase3 = isTokenExpiredUseCase2;
        Function0<String> function06 = function02;
        Function0<Unit> function07 = function03;
        Function0<String> function08 = function04;
        Intrinsics.checkNotNullParameter(aaaApi3, "aaaApi");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory3, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(tokenExchangeAllowed2, "exchangeAllowed");
        Intrinsics.checkNotNullParameter(iTalabatExperiment2, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag2, "featureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
        Intrinsics.checkNotNullParameter(function05, "remoteConfigProvider");
        Intrinsics.checkNotNullParameter(secretProvider3, "secretProvider");
        Intrinsics.checkNotNullParameter(tokenExchangeRetriesRepository3, "tokenExchangeRetriesRepository");
        Intrinsics.checkNotNullParameter(tokenResponseMapper3, "tokenResponseMapper");
        Intrinsics.checkNotNullParameter(tokenRepository3, "tokenRepository");
        Intrinsics.checkNotNullParameter(isTokenExpiredUseCase3, "isTokenExpiredUseCase");
        Intrinsics.checkNotNullParameter(function06, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(function07, "logoutWithOwinTokenProvider");
        Intrinsics.checkNotNullParameter(function08, "owinTokenProvider");
        this.aaaApi = aaaApi3;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory3;
        this.exchangeAllowed = tokenExchangeAllowed2;
        this.experiment = iTalabatExperiment2;
        this.featureFlag = iTalabatFeatureFlag2;
        this.observabilityManager = iObservabilityManager2;
        this.remoteConfigProvider = function05;
        this.secretProvider = secretProvider3;
        this.tokenExchangeRetriesRepository = tokenExchangeRetriesRepository3;
        this.tokenResponseMapper = tokenResponseMapper3;
        this.tokenRepository = tokenRepository3;
        this.isTokenExpiredUseCase = isTokenExpiredUseCase3;
        this.deviceIdProvider = function06;
        this.logoutWithOwinTokenProvider = function07;
        this.owinTokenProvider = function08;
        this.suspendedCoroutinesForExchange = new LinkedHashMap();
        this.suspendedCoroutinesForRefresh = new LinkedHashMap();
        this.suspendedCoroutinesForRemoteConfig = new LinkedHashMap();
        this.exchangeIsRunning = new AtomicBoolean(false);
        this.refreshIsRunning = new AtomicBoolean(false);
        this.remoteConfigIsRunning = new AtomicBoolean(false);
        this.exchangeTokenObservability$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new JwtTokenManagerImpl$exchangeTokenObservability$2(this));
    }

    public static /* synthetic */ void a(JwtTokenManagerImpl jwtTokenManagerImpl, String str, int i11, Throwable th2, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            th2 = null;
        }
        jwtTokenManagerImpl.observabilityJwtTokenRefresh(str, i11, th2);
    }

    private final void afterExchange() {
        this.exchangeIsRunning.set(false);
        for (Map.Entry next : this.suspendedCoroutinesForExchange.entrySet()) {
            ((Continuation) ((Pair) next.getValue()).getFirst()).resumeWith(Result.m6329constructorimpl((String) next.getKey()));
        }
    }

    private final void afterRefresh() {
        this.refreshIsRunning.set(false);
        for (Map.Entry next : this.suspendedCoroutinesForRefresh.entrySet()) {
            ((Continuation) ((Pair) next.getValue()).getFirst()).resumeWith(Result.m6329constructorimpl((String) next.getKey()));
        }
    }

    private final void afterRemoteConfig() {
        this.remoteConfigIsRunning.set(false);
        for (Map.Entry next : this.suspendedCoroutinesForRemoteConfig.entrySet()) {
            ((Continuation) ((Pair) next.getValue()).getFirst()).resumeWith(Result.m6329constructorimpl((String) next.getKey()));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        if (barrierExchange$isAlreadyTimedOut(r2, r9) == false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object barrierExchange(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$barrierExchange$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierExchange$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$barrierExchange$1) r0
            int r1 = r0.f55449k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55449k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierExchange$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$barrierExchange$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f55447i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55449k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r2 = r0.f55446h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008f
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r8
        L_0x0039:
            java.util.concurrent.atomic.AtomicBoolean r9 = r2.exchangeIsRunning
            boolean r9 = r9.get()
            if (r9 == 0) goto L_0x009c
            r0.f55446h = r2
            r0.f55449k = r3
            kotlin.coroutines.SafeContinuation r9 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r9.<init>(r4)
            int r4 = r9.hashCode()
            com.talabat.authentication.natives.JwtTokenManagerImpl$Companion r5 = Companion
            r6 = 8
            java.lang.String r5 = r5.randomKey(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = "_"
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r5 = r2.suspendedCoroutinesForExchange
            long r6 = barrierExchange$getMinSuspendedAt(r2, r4)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r9, r6)
            r5.put(r4, r6)
            java.lang.Object r9 = r9.getOrThrow()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r4) goto L_0x008c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x008c:
            if (r9 != r1) goto L_0x008f
            return r1
        L_0x008f:
            java.lang.String r9 = (java.lang.String) r9
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r4 = r2.suspendedCoroutinesForExchange
            r4.remove(r9)
            boolean r9 = barrierExchange$isAlreadyTimedOut(r2, r9)
            if (r9 == 0) goto L_0x0039
        L_0x009c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.barrierExchange(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final long barrierExchange$getMinSuspendedAt(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.getMinSuspendedAt(jwtTokenManagerImpl.suspendedCoroutinesForExchange, str);
    }

    private static final boolean barrierExchange$isAlreadyTimedOut(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.isAlreadyTimedOut(jwtTokenManagerImpl.suspendedCoroutinesForExchange, str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        if (m9517barrierRefresh$isAlreadyTimedOut34(r2, r9) == false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object barrierRefresh(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRefresh$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRefresh$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRefresh$1) r0
            int r1 = r0.f55453k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55453k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRefresh$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRefresh$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f55451i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55453k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r2 = r0.f55450h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008f
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r8
        L_0x0039:
            java.util.concurrent.atomic.AtomicBoolean r9 = r2.refreshIsRunning
            boolean r9 = r9.get()
            if (r9 == 0) goto L_0x009c
            r0.f55450h = r2
            r0.f55453k = r3
            kotlin.coroutines.SafeContinuation r9 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r9.<init>(r4)
            int r4 = r9.hashCode()
            com.talabat.authentication.natives.JwtTokenManagerImpl$Companion r5 = Companion
            r6 = 8
            java.lang.String r5 = r5.randomKey(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = "_"
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r5 = r2.suspendedCoroutinesForRefresh
            long r6 = m9516barrierRefresh$getMinSuspendedAt33(r2, r4)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r9, r6)
            r5.put(r4, r6)
            java.lang.Object r9 = r9.getOrThrow()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r4) goto L_0x008c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x008c:
            if (r9 != r1) goto L_0x008f
            return r1
        L_0x008f:
            java.lang.String r9 = (java.lang.String) r9
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r4 = r2.suspendedCoroutinesForRefresh
            r4.remove(r9)
            boolean r9 = m9517barrierRefresh$isAlreadyTimedOut34(r2, r9)
            if (r9 == 0) goto L_0x0039
        L_0x009c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.barrierRefresh(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: barrierRefresh$getMinSuspendedAt-33  reason: not valid java name */
    private static final long m9516barrierRefresh$getMinSuspendedAt33(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.getMinSuspendedAt(jwtTokenManagerImpl.suspendedCoroutinesForRefresh, str);
    }

    /* renamed from: barrierRefresh$isAlreadyTimedOut-34  reason: not valid java name */
    private static final boolean m9517barrierRefresh$isAlreadyTimedOut34(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.isAlreadyTimedOut(jwtTokenManagerImpl.suspendedCoroutinesForRefresh, str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009a, code lost:
        if (m9519barrierRemoteConfig$isAlreadyTimedOut37(r2, r9) == false) goto L_0x0039;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object barrierRemoteConfig(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRemoteConfig$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRemoteConfig$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRemoteConfig$1) r0
            int r1 = r0.f55457k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55457k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRemoteConfig$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$barrierRemoteConfig$1
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f55455i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55457k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r2 = r0.f55454h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x008f
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r8
        L_0x0039:
            java.util.concurrent.atomic.AtomicBoolean r9 = r2.remoteConfigIsRunning
            boolean r9 = r9.get()
            if (r9 == 0) goto L_0x009c
            r0.f55454h = r2
            r0.f55457k = r3
            kotlin.coroutines.SafeContinuation r9 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r9.<init>(r4)
            int r4 = r9.hashCode()
            com.talabat.authentication.natives.JwtTokenManagerImpl$Companion r5 = Companion
            r6 = 8
            java.lang.String r5 = r5.randomKey(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            java.lang.String r4 = "_"
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r5 = r2.suspendedCoroutinesForRemoteConfig
            long r6 = m9518barrierRemoteConfig$getMinSuspendedAt36(r2, r4)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            kotlin.Pair r6 = kotlin.TuplesKt.to(r9, r6)
            r5.put(r4, r6)
            java.lang.Object r9 = r9.getOrThrow()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r9 != r4) goto L_0x008c
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x008c:
            if (r9 != r1) goto L_0x008f
            return r1
        L_0x008f:
            java.lang.String r9 = (java.lang.String) r9
            java.util.Map<java.lang.String, kotlin.Pair<kotlin.coroutines.Continuation<java.lang.String>, java.lang.Long>> r4 = r2.suspendedCoroutinesForRemoteConfig
            r4.remove(r9)
            boolean r9 = m9519barrierRemoteConfig$isAlreadyTimedOut37(r2, r9)
            if (r9 == 0) goto L_0x0039
        L_0x009c:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.barrierRemoteConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: barrierRemoteConfig$getMinSuspendedAt-36  reason: not valid java name */
    private static final long m9518barrierRemoteConfig$getMinSuspendedAt36(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.getMinSuspendedAt(jwtTokenManagerImpl.suspendedCoroutinesForRemoteConfig, str);
    }

    /* renamed from: barrierRemoteConfig$isAlreadyTimedOut-37  reason: not valid java name */
    private static final boolean m9519barrierRemoteConfig$isAlreadyTimedOut37(JwtTokenManagerImpl jwtTokenManagerImpl, String str) {
        return jwtTokenManagerImpl.isAlreadyTimedOut(jwtTokenManagerImpl.suspendedCoroutinesForRemoteConfig, str);
    }

    private final void beforeExchange() {
        this.exchangeIsRunning.set(true);
        TokenExchangeRetriesRepository.DefaultImpls.updateRetriesCount$default(this.tokenExchangeRetriesRepository, 0, 1, (Object) null);
    }

    private final void beforeRefresh() {
        this.refreshIsRunning.set(true);
    }

    private final void beforeRemoteConfig() {
        this.remoteConfigIsRunning.set(true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: com.talabat.authentication.token.domain.model.Token} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: com.talabat.authentication.token.domain.model.Token} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: com.talabat.authentication.token.data.model.TokenData$Error} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r0v13, types: [com.talabat.authentication.token.data.model.TokenData] */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0203 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A[SYNTHETIC, Splitter:B:47:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doRefreshToken(java.lang.String r16, kotlin.coroutines.Continuation<? super com.talabat.authentication.token.domain.model.Token> r17) {
        /*
            r15 = this;
            r1 = r15
            r0 = r17
            boolean r2 = r0 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$1
            if (r2 == 0) goto L_0x0016
            r2 = r0
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$1 r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$1) r2
            int r3 = r2.f55463m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f55463m = r3
            goto L_0x001b
        L_0x0016:
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$1 r2 = new com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$1
            r2.<init>(r15, r0)
        L_0x001b:
            java.lang.Object r0 = r2.f55461k
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f55463m
            r5 = 2
            r6 = 1
            r7 = 3
            r8 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 == r6) goto L_0x005d
            if (r4 == r5) goto L_0x0049
            if (r4 != r7) goto L_0x0041
            java.lang.Object r3 = r2.f55459i
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            java.lang.Object r2 = r2.f55458h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Result r0 = (kotlin.Result) r0
            r0.m6338unboximpl()
            goto L_0x018a
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0049:
            java.lang.Object r4 = r2.f55460j
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r5 = r2.f55459i
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.f55458h
            com.talabat.authentication.natives.JwtTokenManagerImpl r6 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r6
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005a }
            goto L_0x00eb
        L_0x005a:
            r0 = move-exception
            goto L_0x00f8
        L_0x005d:
            java.lang.Object r4 = r2.f55459i
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.f55458h
            com.talabat.authentication.natives.JwtTokenManagerImpl r6 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r6
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x007d
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r0)
            r2.f55458h = r1
            r0 = r16
            r2.f55459i = r0
            r2.f55463m = r6
            java.lang.Object r4 = r15.barrierRefresh(r2)
            if (r4 != r3) goto L_0x007b
            return r3
        L_0x007b:
            r4 = r0
            r6 = r1
        L_0x007d:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x008a }
            com.talabat.authentication.token.domain.repository.TokenRepository r0 = r6.tokenRepository     // Catch:{ all -> 0x008a }
            com.talabat.authentication.token.domain.model.Token r0 = r0.getToken()     // Catch:{ all -> 0x008a }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x008a }
            goto L_0x0095
        L_0x008a:
            r0 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x0095:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r9 != 0) goto L_0x009c
            goto L_0x009d
        L_0x009c:
            r0 = r9
        L_0x009d:
            boolean r9 = r0 instanceof java.lang.Throwable
            r10 = r9 ^ 1
            if (r10 == 0) goto L_0x00a6
            r10 = r0
            goto L_0x00a7
        L_0x00a6:
            r10 = r8
        L_0x00a7:
            if (r10 == 0) goto L_0x00b0
            boolean r11 = r10 instanceof com.talabat.authentication.token.domain.model.Token
            if (r11 == 0) goto L_0x00b0
            com.talabat.authentication.token.domain.model.Token r10 = (com.talabat.authentication.token.domain.model.Token) r10
            goto L_0x00b1
        L_0x00b0:
            r10 = r8
        L_0x00b1:
            if (r9 == 0) goto L_0x00b7
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r9 = r0
            goto L_0x00b8
        L_0x00b7:
            r9 = r8
        L_0x00b8:
            if (r10 == 0) goto L_0x00c6
            com.talabat.authentication.usecase.IsTokenExpiredUseCase r0 = r6.isTokenExpiredUseCase
            boolean r0 = r0.invoke(r10)
            if (r0 != 0) goto L_0x00c6
            r6.observabilityJwtTokenAlreadyRefreshed(r4)
            return r10
        L_0x00c6:
            r6.beforeRefresh()     // Catch:{ all -> 0x0100 }
            com.talabat.authentication.natives.Backoff$Linear r0 = new com.talabat.authentication.natives.Backoff$Linear     // Catch:{ all -> 0x00f5 }
            r11 = 150(0x96, double:7.4E-322)
            r0.<init>(r11)     // Catch:{ all -> 0x00f5 }
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$1 r11 = new com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$1     // Catch:{ all -> 0x00f5 }
            r11.<init>(r8)     // Catch:{ all -> 0x00f5 }
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$2 r12 = new com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$tokenData$1$2     // Catch:{ all -> 0x00f5 }
            r12.<init>(r10, r9, r6, r8)     // Catch:{ all -> 0x00f5 }
            r2.f55458h = r6     // Catch:{ all -> 0x00f5 }
            r2.f55459i = r4     // Catch:{ all -> 0x00f5 }
            r2.f55460j = r9     // Catch:{ all -> 0x00f5 }
            r2.f55463m = r5     // Catch:{ all -> 0x00f5 }
            java.lang.Object r0 = com.talabat.authentication.natives.UtilsKt.retryIf(r7, r0, r11, r12, r2)     // Catch:{ all -> 0x00f5 }
            if (r0 != r3) goto L_0x00e9
            return r3
        L_0x00e9:
            r5 = r4
            r4 = r9
        L_0x00eb:
            com.talabat.authentication.token.data.model.TokenData$Valid r0 = (com.talabat.authentication.token.data.model.TokenData.Valid) r0     // Catch:{ all -> 0x005a }
            r6.afterRefresh()     // Catch:{ all -> 0x00fc }
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00fc }
            goto L_0x010d
        L_0x00f5:
            r0 = move-exception
            r5 = r4
            r4 = r9
        L_0x00f8:
            r6.afterRefresh()     // Catch:{ all -> 0x00fc }
            throw r0     // Catch:{ all -> 0x00fc }
        L_0x00fc:
            r0 = move-exception
            r9 = r4
            r4 = r5
            goto L_0x0101
        L_0x0100:
            r0 = move-exception
        L_0x0101:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
            r5 = r4
            r4 = r9
        L_0x010d:
            boolean r9 = kotlin.Result.m6336isSuccessimpl(r0)
            if (r9 == 0) goto L_0x0120
            r9 = r0
            com.talabat.authentication.token.data.model.TokenData$Valid r9 = (com.talabat.authentication.token.data.model.TokenData.Valid) r9
            r11 = 200(0xc8, float:2.8E-43)
            r12 = 0
            r13 = 4
            r14 = 0
            r9 = r6
            r10 = r5
            a(r9, r10, r11, r12, r13, r14)
        L_0x0120:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            r10 = -1
            if (r9 == 0) goto L_0x0138
            boolean r11 = r9 instanceof retrofit2.HttpException
            if (r11 == 0) goto L_0x0135
            retrofit2.HttpException r9 = (retrofit2.HttpException) r9
            int r9 = r9.code()
            r6.observabilityJwtTokenRefresh(r5, r9, r4)
            goto L_0x0138
        L_0x0135:
            r6.observabilityJwtTokenRefresh(r5, r10, r9, r4)
        L_0x0138:
            java.lang.Throwable r9 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r9 != 0) goto L_0x0140
            goto L_0x01f2
        L_0x0140:
            boolean r0 = r9 instanceof retrofit2.HttpException
            if (r0 == 0) goto L_0x01bc
            r0 = r9
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0
            int r0 = r0.code()
            switch(r0) {
                case 400: goto L_0x0166;
                case 401: goto L_0x0166;
                case 402: goto L_0x014e;
                case 403: goto L_0x0152;
                case 404: goto L_0x0166;
                default: goto L_0x014e;
            }
        L_0x014e:
            doRefreshToken$defaultErrorHandler(r6, r9)
            goto L_0x01bf
        L_0x0152:
            boolean r0 = r6.shouldStopUseOwinToken()
            if (r0 == 0) goto L_0x015e
            com.talabat.authentication.natives.JwtTokenNetworkErrorForbiddenException r0 = new com.talabat.authentication.natives.JwtTokenNetworkErrorForbiddenException
            r0.<init>(r8, r8, r7, r8)
            throw r0
        L_0x015e:
            com.talabat.authentication.natives.JwtTokenFlowException r0 = new com.talabat.authentication.natives.JwtTokenFlowException
            java.lang.String r2 = "JWT client forbidden, fallback to use OWIN token"
            r0.<init>(r2, r9)
            throw r0
        L_0x0166:
            com.talabat.authentication.token.domain.model.Token r0 = r6.getAvailableJwtToken()
            if (r0 == 0) goto L_0x018c
            java.lang.String r0 = r0.getAccessToken()
            doRefreshToken$clearTokenAndDeviceId(r6)
            boolean r4 = r6.shouldCallLogout()
            if (r4 == 0) goto L_0x018c
            r2.f55458h = r6
            r2.f55459i = r9
            r2.f55460j = r8
            r2.f55463m = r7
            java.lang.Object r0 = doRefreshToken$logout(r6, r0, r2)
            if (r0 != r3) goto L_0x0188
            return r3
        L_0x0188:
            r2 = r6
            r3 = r9
        L_0x018a:
            r6 = r2
            r9 = r3
        L_0x018c:
            boolean r0 = r6.shouldStopUseOwinToken()
            if (r0 == 0) goto L_0x01b4
            java.lang.String r0 = "owin"
            r6.observabilityForceSignedOut(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x01a4 }
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r6.logoutWithOwinTokenProvider     // Catch:{ all -> 0x01a4 }
            r0.invoke()     // Catch:{ all -> 0x01a4 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01a4 }
            kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x01a4 }
            goto L_0x01ae
        L_0x01a4:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m6329constructorimpl(r0)
        L_0x01ae:
            com.talabat.authentication.natives.JwtTokenLoggedOutException r0 = new com.talabat.authentication.natives.JwtTokenLoggedOutException
            r0.<init>(r8, r8, r7, r8)
            throw r0
        L_0x01b4:
            com.talabat.authentication.natives.JwtTokenFlowException r0 = new com.talabat.authentication.natives.JwtTokenFlowException
            java.lang.String r2 = "JWT client network error, fallback to use OWIN token"
            r0.<init>(r2, r9)
            throw r0
        L_0x01bc:
            doRefreshToken$defaultErrorHandler(r6, r9)
        L_0x01bf:
            com.talabat.authentication.token.data.model.TokenData$Error r0 = new com.talabat.authentication.token.data.model.TokenData$Error
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cause: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.Throwable r3 = r9.getCause()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "Unreachable state :: "
            r7.append(r11)
            r7.append(r9)
            java.lang.String r9 = " :: "
            r7.append(r9)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r0.<init>(r10, r2, r3)
        L_0x01f2:
            com.talabat.authentication.token.data.model.TokenData r0 = (com.talabat.authentication.token.data.model.TokenData) r0
            boolean r2 = r0 instanceof com.talabat.authentication.token.data.model.TokenData.Valid
            if (r2 == 0) goto L_0x01fb
            r8 = r0
            com.talabat.authentication.token.data.model.TokenData$Valid r8 = (com.talabat.authentication.token.data.model.TokenData.Valid) r8
        L_0x01fb:
            if (r8 == 0) goto L_0x0204
            com.talabat.authentication.token.domain.model.Token r0 = r8.getToken()
            if (r0 == 0) goto L_0x0204
            return r0
        L_0x0204:
            com.talabat.authentication.natives.JwtTokenFlowException r0 = new com.talabat.authentication.natives.JwtTokenFlowException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[Unreachable] JWT invalid data error, fallback to use OWIN token :: "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2, r4)
            r6.observabilityJwtTokenRefresh(r5, r10, r0, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.doRefreshToken(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void doRefreshToken$clearTokenAndDeviceId(JwtTokenManagerImpl jwtTokenManagerImpl) {
        jwtTokenManagerImpl.tokenRepository.clearToken();
        jwtTokenManagerImpl.tokenExchangeRetriesRepository.clear();
    }

    private static final void doRefreshToken$defaultErrorHandler(JwtTokenManagerImpl jwtTokenManagerImpl, Throwable th2) {
        if (jwtTokenManagerImpl.shouldStopUseOwinToken()) {
            throw new JwtTokenFlowTerminatedException((String) null, (Throwable) null, 3, (DefaultConstructorMarker) null);
        }
        throw new JwtTokenFlowException("JWT other error, fallback to use OWIN token", th2);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object doRefreshToken$logout(com.talabat.authentication.natives.JwtTokenManagerImpl r8, java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Result<com.talabat.authentication.authenticate.data.remote.model.LogoutResponse>> r10) {
        /*
            boolean r0 = r10 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$logout$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$logout$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$logout$1) r0
            int r1 = r0.f55465i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55465i = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$logout$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$logout$1
            r0.<init>(r10)
        L_0x0018:
            r5 = r0
            java.lang.Object r10 = r5.f55464h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f55465i
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0062 }
            goto L_0x005b
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x0062 }
            java.lang.String r10 = "jwt"
            r8.observabilityForceSignedOut(r10)     // Catch:{ all -> 0x0062 }
            com.talabat.authentication.aaa.AaaApi r1 = r8.aaaApi     // Catch:{ all -> 0x0062 }
            com.talabat.authentication.authenticate.data.remote.model.LogoutRequest r10 = new com.talabat.authentication.authenticate.data.remote.model.LogoutRequest     // Catch:{ all -> 0x0062 }
            java.lang.String r3 = "access_token"
            r10.<init>(r9, r3)     // Catch:{ all -> 0x0062 }
            kotlin.jvm.functions.Function0<java.lang.String> r8 = r8.deviceIdProvider     // Catch:{ all -> 0x0062 }
            java.lang.Object r8 = r8.invoke()     // Catch:{ all -> 0x0062 }
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0062 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.f55465i = r2     // Catch:{ all -> 0x0062 }
            r2 = r10
            java.lang.Object r10 = com.talabat.authentication.aaa.AaaApi.DefaultImpls.revoke$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0062 }
            if (r10 != r0) goto L_0x005b
            return r0
        L_0x005b:
            com.talabat.authentication.authenticate.data.remote.model.LogoutResponse r10 = (com.talabat.authentication.authenticate.data.remote.model.LogoutResponse) r10     // Catch:{ all -> 0x0062 }
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r10)     // Catch:{ all -> 0x0062 }
            goto L_0x006d
        L_0x0062:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m6329constructorimpl(r8)
        L_0x006d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.doRefreshToken$logout(com.talabat.authentication.natives.JwtTokenManagerImpl, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object doRefreshToken$refreshTokenRemote(com.talabat.authentication.natives.JwtTokenManagerImpl r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.talabat.authentication.token.data.model.TokenData.Valid> r10) {
        /*
            boolean r0 = r10 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1) r0
            int r1 = r0.f55468j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55468j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1
            r0.<init>(r10)
        L_0x0018:
            r5 = r0
            java.lang.Object r10 = r5.f55467i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f55468j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r8 = r5.f55466h
            com.talabat.authentication.natives.JwtTokenManagerImpl r8 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0085
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.authentication.aaa.AaaApi r1 = r8.aaaApi
            r10 = 4
            kotlin.Pair[] r10 = new kotlin.Pair[r10]
            java.lang.String r3 = "grant_type"
            java.lang.String r4 = "refresh_token"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r6 = 0
            r10[r6] = r3
            java.lang.String r3 = "client_id"
            java.lang.String r6 = "android"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r6)
            r10[r2] = r3
            com.talabat.authentication.aaa.secrets.SecretProvider r3 = r8.secretProvider
            java.lang.String r3 = r3.getClientSecret()
            java.lang.String r6 = "client_secret"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r6, r3)
            r6 = 2
            r10[r6] = r3
            r3 = 3
            kotlin.Pair r9 = kotlin.TuplesKt.to(r4, r9)
            r10[r3] = r9
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.mapOf(r10)
            kotlin.jvm.functions.Function0<java.lang.String> r10 = r8.deviceIdProvider
            java.lang.Object r10 = r10.invoke()
            r3 = r10
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            r6 = 4
            r7 = 0
            r5.f55466h = r8
            r5.f55468j = r2
            r2 = r9
            java.lang.Object r10 = com.talabat.authentication.aaa.AaaApi.DefaultImpls.token$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x0085
            return r0
        L_0x0085:
            com.talabat.authentication.aaa.TokenResponse r10 = (com.talabat.authentication.aaa.TokenResponse) r10
            com.talabat.authentication.token.data.remote.TokenResponseMapper r9 = r8.tokenResponseMapper
            com.talabat.authentication.token.domain.model.Token r9 = r9.map(r10)
            kotlin.jvm.functions.Function0<java.lang.String> r8 = r8.deviceIdProvider
            java.lang.Object r8 = r8.invoke()
            java.lang.String r8 = (java.lang.String) r8
            com.talabat.authentication.token.data.model.TokenData$Valid r10 = new com.talabat.authentication.token.data.model.TokenData$Valid
            r10.<init>(r9, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.doRefreshToken$refreshTokenRemote(com.talabat.authentication.natives.JwtTokenManagerImpl, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ae A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ba A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d2 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object exchangeTokenWithOneRetry(kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$1) r0
            int r1 = r0.f55479k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55479k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$1
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55477i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55479k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r0 = r0.f55476h
            com.talabat.authentication.natives.JwtTokenManagerImpl r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0034 }
            goto L_0x00a4
        L_0x0034:
            r7 = move-exception
            goto L_0x00fa
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003f:
            java.lang.Object r2 = r0.f55476h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0047 }
            goto L_0x007b
        L_0x0047:
            r7 = move-exception
            r0 = r2
            goto L_0x00fa
        L_0x004b:
            java.lang.Object r2 = r0.f55476h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0062
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f55476h = r6
            r0.f55479k = r5
            java.lang.Object r7 = r6.barrierExchange(r0)
            if (r7 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r2 = r6
        L_0x0062:
            com.talabat.authentication.token.domain.model.Token r7 = r2.getAvailableJwtToken()
            if (r7 == 0) goto L_0x006d
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r7
        L_0x006d:
            r2.beforeExchange()
            r0.f55476h = r2     // Catch:{ all -> 0x0047 }
            r0.f55479k = r4     // Catch:{ all -> 0x0047 }
            java.lang.Object r7 = exchangeTokenWithOneRetry$exchangeToken(r2, r0)     // Catch:{ all -> 0x0047 }
            if (r7 != r1) goto L_0x007b
            return r1
        L_0x007b:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication r7 = (com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication) r7     // Catch:{ all -> 0x0047 }
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r4 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0047 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x00d2
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r4 = r2.getExchangeTokenObservability()     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0047 }
            r4.onFirstCallFailure(r5)     // Catch:{ all -> 0x0047 }
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error404 r4 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Error404.INSTANCE     // Catch:{ all -> 0x0047 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r4)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x00c7
            r0.f55476h = r2     // Catch:{ all -> 0x0047 }
            r0.f55479k = r3     // Catch:{ all -> 0x0047 }
            java.lang.Object r7 = exchangeTokenWithOneRetry$exchangeToken(r2, r0)     // Catch:{ all -> 0x0047 }
            if (r7 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            r0 = r2
        L_0x00a4:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication r7 = (com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication) r7     // Catch:{ all -> 0x0034 }
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r1 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0034 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r1)     // Catch:{ all -> 0x0034 }
            if (r1 != 0) goto L_0x00ba
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r1 = r0.getExchangeTokenObservability()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0034 }
            r1.onSecondCallFailure(r2)     // Catch:{ all -> 0x0034 }
            goto L_0x00df
        L_0x00ba:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r1 = r0.getExchangeTokenObservability()     // Catch:{ all -> 0x0034 }
            r1.onSecondCallSuccess()     // Catch:{ all -> 0x0034 }
            com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository r1 = r0.tokenExchangeRetriesRepository     // Catch:{ all -> 0x0034 }
            r1.clear()     // Catch:{ all -> 0x0034 }
            goto L_0x00df
        L_0x00c7:
            java.lang.String r0 = "owin"
            r2.observabilitySignedOutOnExchange404(r0)     // Catch:{ all -> 0x0047 }
            com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository r0 = r2.tokenExchangeRetriesRepository     // Catch:{ all -> 0x0047 }
            r0.clear()     // Catch:{ all -> 0x0047 }
            goto L_0x00de
        L_0x00d2:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r0 = r2.getExchangeTokenObservability()     // Catch:{ all -> 0x0047 }
            r0.onFirstCallSuccess()     // Catch:{ all -> 0x0047 }
            com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository r0 = r2.tokenExchangeRetriesRepository     // Catch:{ all -> 0x0047 }
            r0.clear()     // Catch:{ all -> 0x0047 }
        L_0x00de:
            r0 = r2
        L_0x00df:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r1 = r0.getExchangeTokenObservability()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "interceptor"
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r3 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0034 }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)     // Catch:{ all -> 0x0034 }
            r1.onExchangeDone(r2, r4)     // Catch:{ all -> 0x0034 }
            r0.afterExchange()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r3)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r7
        L_0x00fa:
            r0.afterExchange()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.exchangeTokenWithOneRetry(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final TokenData.Error exchangeTokenWithOneRetry$errorMigrationExchangeToken(String str) {
        return new TokenData.Error(200, RegistrationInteractor.AUTH_EVENT, str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object exchangeTokenWithOneRetry$exchangeToken(com.talabat.authentication.natives.JwtTokenManagerImpl r4, kotlin.coroutines.Continuation<? super com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication> r5) {
        /*
            boolean r0 = r5 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1) r0
            int r1 = r0.f55482j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55482j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.f55481i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55482j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.f55480h
            com.talabat.authentication.natives.JwtTokenManagerImpl r4 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r4
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0088 }
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0088 }
            r0.f55480h = r4     // Catch:{ all -> 0x0088 }
            r0.f55482j = r3     // Catch:{ all -> 0x0088 }
            java.lang.Object r5 = exchangeTokenWithOneRetry$migrationExchangeToken(r4, r0)     // Catch:{ all -> 0x0088 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            com.talabat.authentication.token.data.model.TokenData r5 = (com.talabat.authentication.token.data.model.TokenData) r5     // Catch:{ all -> 0x0088 }
            boolean r0 = r5 instanceof com.talabat.authentication.token.data.model.TokenData.Error     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0065
            r4 = r5
            com.talabat.authentication.token.data.model.TokenData$Error r4 = (com.talabat.authentication.token.data.model.TokenData.Error) r4     // Catch:{ all -> 0x0088 }
            int r4 = r4.getStatusCode()     // Catch:{ all -> 0x0088 }
            r0 = 404(0x194, float:5.66E-43)
            if (r4 != r0) goto L_0x0059
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error404 r4 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Error404.INSTANCE     // Catch:{ all -> 0x0088 }
            goto L_0x007d
        L_0x0059:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error r4 = new com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error     // Catch:{ all -> 0x0088 }
            com.talabat.authentication.token.data.model.TokenData$Error r5 = (com.talabat.authentication.token.data.model.TokenData.Error) r5     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = r5.getExceptionMessage()     // Catch:{ all -> 0x0088 }
            r4.<init>(r5)     // Catch:{ all -> 0x0088 }
            goto L_0x007d
        L_0x0065:
            boolean r0 = r5 instanceof com.talabat.authentication.token.data.model.TokenData.Valid     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x0082
            com.talabat.authentication.token.domain.repository.TokenRepository r4 = r4.tokenRepository     // Catch:{ all -> 0x0088 }
            r0 = r5
            com.talabat.authentication.token.data.model.TokenData$Valid r0 = (com.talabat.authentication.token.data.model.TokenData.Valid) r0     // Catch:{ all -> 0x0088 }
            com.talabat.authentication.token.domain.model.Token r0 = r0.getToken()     // Catch:{ all -> 0x0088 }
            com.talabat.authentication.token.data.model.TokenData$Valid r5 = (com.talabat.authentication.token.data.model.TokenData.Valid) r5     // Catch:{ all -> 0x0088 }
            java.lang.String r5 = r5.getDeviceToken()     // Catch:{ all -> 0x0088 }
            r4.saveToken(r0, r5)     // Catch:{ all -> 0x0088 }
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r4 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0088 }
        L_0x007d:
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)     // Catch:{ all -> 0x0088 }
            goto L_0x0093
        L_0x0082:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0088 }
            r4.<init>()     // Catch:{ all -> 0x0088 }
            throw r4     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)
        L_0x0093:
            java.lang.Throwable r5 = kotlin.Result.m6332exceptionOrNullimpl(r4)
            if (r5 != 0) goto L_0x009a
            goto L_0x00a7
        L_0x009a:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error r4 = new com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error
            java.lang.String r5 = r5.getMessage()
            if (r5 != 0) goto L_0x00a4
            java.lang.String r5 = ""
        L_0x00a4:
            r4.<init>(r5)
        L_0x00a7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.exchangeTokenWithOneRetry$exchangeToken(com.talabat.authentication.natives.JwtTokenManagerImpl, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object exchangeTokenWithOneRetry$migrationExchangeToken(com.talabat.authentication.natives.JwtTokenManagerImpl r8, kotlin.coroutines.Continuation<? super com.talabat.authentication.token.data.model.TokenData> r9) {
        /*
            boolean r0 = r9 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1) r0
            int r1 = r0.f55485j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55485j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1
            r0.<init>(r9)
        L_0x0018:
            r5 = r0
            java.lang.Object r9 = r5.f55484i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f55485j
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r8 = r5.f55483h
            com.talabat.authentication.natives.JwtTokenManagerImpl r8 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x007b }
            goto L_0x0074
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x007b }
            com.talabat.authentication.aaa.AaaApi r1 = r8.aaaApi     // Catch:{ all -> 0x007b }
            r9 = 2
            kotlin.Pair[] r9 = new kotlin.Pair[r9]     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "client_id"
            java.lang.String r4 = "android"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)     // Catch:{ all -> 0x007b }
            r4 = 0
            r9[r4] = r3     // Catch:{ all -> 0x007b }
            java.lang.String r3 = "client_secret"
            com.talabat.authentication.aaa.secrets.SecretProvider r4 = r8.secretProvider     // Catch:{ all -> 0x007b }
            java.lang.String r4 = r4.getClientSecret()     // Catch:{ all -> 0x007b }
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)     // Catch:{ all -> 0x007b }
            r9[r2] = r3     // Catch:{ all -> 0x007b }
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.mapOf(r9)     // Catch:{ all -> 0x007b }
            kotlin.jvm.functions.Function0<java.lang.String> r3 = r8.deviceIdProvider     // Catch:{ all -> 0x007b }
            java.lang.Object r3 = r3.invoke()     // Catch:{ all -> 0x007b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x007b }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.f55483h = r8     // Catch:{ all -> 0x007b }
            r5.f55485j = r2     // Catch:{ all -> 0x007b }
            r2 = r9
            java.lang.Object r9 = com.talabat.authentication.aaa.AaaApi.DefaultImpls.migrationExchangeToken$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x007b }
            if (r9 != r0) goto L_0x0074
            return r0
        L_0x0074:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch:{ all -> 0x007b }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x007b }
            goto L_0x0086
        L_0x007b:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0086:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            java.lang.String r1 = "owin"
            r2 = 404(0x194, float:5.66E-43)
            if (r0 != 0) goto L_0x00f4
            retrofit2.Response r9 = (retrofit2.Response) r9
            int r0 = r9.code()
            if (r0 != r2) goto L_0x00c5
            boolean r0 = r8.shouldClearOwinTokenOnExchange404()
            if (r0 == 0) goto L_0x00c5
            r8.observabilityForceSignedOut(r1)
            kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r8.logoutWithOwinTokenProvider     // Catch:{ all -> 0x00ac }
            r8.invoke()     // Catch:{ all -> 0x00ac }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00ac }
            kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x00ac }
            goto L_0x00b6
        L_0x00ac:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            kotlin.Result.m6329constructorimpl(r8)
        L_0x00b6:
            com.talabat.authentication.token.data.model.TokenData$Error r8 = new com.talabat.authentication.token.data.model.TokenData$Error
            com.talabat.authentication.token.data.model.TokenData$Error$ExceptionType r9 = com.talabat.authentication.token.data.model.TokenData.Error.ExceptionType.OAUTH_FAILED_EXCEPTION
            java.lang.String r9 = r9.name()
            java.lang.String r0 = "Exchange failed with 404 - interceptor - Clean OWIN"
            r8.<init>(r2, r9, r0)
            goto L_0x0145
        L_0x00c5:
            okhttp3.Headers r0 = r9.headers()
            java.lang.String r1 = "X-Device"
            java.lang.String r0 = r0.get(r1)
            java.lang.Object r9 = r9.body()
            com.talabat.authentication.aaa.TokenResponse r9 = (com.talabat.authentication.aaa.TokenResponse) r9
            if (r9 != 0) goto L_0x00de
            java.lang.String r8 = "Token not returned"
            com.talabat.authentication.token.data.model.TokenData$Error r8 = exchangeTokenWithOneRetry$errorMigrationExchangeToken(r8)
            goto L_0x0145
        L_0x00de:
            if (r0 != 0) goto L_0x00e7
            java.lang.String r8 = "Device token not returned"
            com.talabat.authentication.token.data.model.TokenData$Error r8 = exchangeTokenWithOneRetry$errorMigrationExchangeToken(r8)
            goto L_0x0145
        L_0x00e7:
            com.talabat.authentication.token.data.remote.TokenResponseMapper r8 = r8.tokenResponseMapper
            com.talabat.authentication.token.domain.model.Token r8 = r8.map(r9)
            com.talabat.authentication.token.data.model.TokenData$Valid r9 = new com.talabat.authentication.token.data.model.TokenData$Valid
            r9.<init>(r8, r0)
            r8 = r9
            goto L_0x0145
        L_0x00f4:
            boolean r9 = r0 instanceof retrofit2.HttpException
            if (r9 == 0) goto L_0x0138
            r9 = r0
            retrofit2.HttpException r9 = (retrofit2.HttpException) r9
            int r3 = r9.code()
            if (r3 != r2) goto L_0x0138
            boolean r2 = r8.shouldClearOwinTokenOnExchange404()
            if (r2 == 0) goto L_0x0138
            r8.observabilityForceSignedOut(r1)
            kotlin.jvm.functions.Function0<kotlin.Unit> r8 = r8.logoutWithOwinTokenProvider     // Catch:{ all -> 0x0115 }
            r8.invoke()     // Catch:{ all -> 0x0115 }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0115 }
            kotlin.Result.m6329constructorimpl(r8)     // Catch:{ all -> 0x0115 }
            goto L_0x011f
        L_0x0115:
            r8 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            kotlin.Result.m6329constructorimpl(r8)
        L_0x011f:
            com.talabat.authentication.token.data.model.TokenData$Error r8 = new com.talabat.authentication.token.data.model.TokenData$Error
            int r0 = r9.code()
            com.talabat.authentication.token.data.model.TokenData$Error$ExceptionType r1 = com.talabat.authentication.token.data.model.TokenData.Error.ExceptionType.OAUTH_FAILED_EXCEPTION
            java.lang.String r1 = r1.name()
            java.lang.String r9 = r9.message()
            java.lang.String r2 = "e.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            r8.<init>(r0, r1, r9)
            goto L_0x0145
        L_0x0138:
            com.google.gson.Gson r8 = new com.google.gson.Gson
            r8.<init>()
            com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody r8 = com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseMigrationExchangeTokenErrorBodyOrThrow((java.lang.Throwable) r0, (com.google.gson.Gson) r8)
            com.talabat.authentication.token.data.model.TokenData$Error r8 = com.talabat.authentication.token.data.model.TokenDataExtensionsKt.toMigrationExchangeTokenDataError(r8)
        L_0x0145:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.exchangeTokenWithOneRetry$migrationExchangeToken(com.talabat.authentication.natives.JwtTokenManagerImpl, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Token getAvailableJwtToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.tokenRepository.getToken());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (Token) obj;
    }

    private final MigrationExchangeObservabilityUseCase getExchangeTokenObservability() {
        return (MigrationExchangeObservabilityUseCase) this.exchangeTokenObservability$delegate.getValue();
    }

    private final long getMinSuspendedAt(Map<String, ? extends Pair<? extends Continuation<? super String>, Long>> map, String str) {
        long j11;
        long currentTimeMillis = System.currentTimeMillis();
        Pair pair = (Pair) map.get(str);
        if (pair != null) {
            j11 = ((Number) pair.getSecond()).longValue();
        } else {
            j11 = Long.MAX_VALUE;
        }
        return Math.min(j11, currentTimeMillis);
    }

    private final String getOwinToken() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(this.owinTokenProvider.invoke());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        return (String) obj;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getValidToken$getJwtToken(com.talabat.authentication.natives.JwtTokenManagerImpl r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            boolean r0 = r7 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$getJwtToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$getJwtToken$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$getJwtToken$1) r0
            int r1 = r0.f55494k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55494k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$getJwtToken$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$getJwtToken$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55493j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55494k
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r5 = r0.f55492i
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r0.f55491h
            com.talabat.authentication.natives.JwtTokenManagerImpl r5 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x008c
        L_0x0035:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005b
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            com.talabat.authentication.token.domain.model.Token r7 = r5.getAvailableJwtToken()
            if (r7 == 0) goto L_0x0067
            com.talabat.authentication.usecase.IsTokenExpiredUseCase r2 = r5.isTokenExpiredUseCase
            boolean r2 = r2.invoke(r7)
            if (r2 == 0) goto L_0x0062
            r0.f55494k = r4
            java.lang.Object r7 = r5.refreshToken(r6, r0)
            if (r7 != r1) goto L_0x005b
            return r1
        L_0x005b:
            com.talabat.authentication.token.domain.model.Token r7 = (com.talabat.authentication.token.domain.model.Token) r7
            java.lang.String r5 = r7.getAccessToken()
            goto L_0x00a3
        L_0x0062:
            java.lang.String r5 = r7.getAccessToken()
            goto L_0x00a3
        L_0x0067:
            java.lang.String r7 = r5.getOwinToken()
            if (r7 == 0) goto L_0x0075
            boolean r7 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r7)
            if (r7 == 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            if (r4 != 0) goto L_0x0097
            com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed r7 = r5.exchangeAllowed
            boolean r7 = r7.invoke()
            if (r7 == 0) goto L_0x0097
            r0.f55491h = r5
            r0.f55492i = r6
            r0.f55494k = r3
            java.lang.Object r7 = r5.exchangeTokenWithOneRetry(r0)
            if (r7 != r1) goto L_0x008c
            return r1
        L_0x008c:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0097
            r5.observabilityJwtTokenExchangeFailedAllRetries(r6)
        L_0x0097:
            com.talabat.authentication.token.domain.model.Token r5 = r5.getAvailableJwtToken()
            if (r5 == 0) goto L_0x00a2
            java.lang.String r5 = r5.getAccessToken()
            goto L_0x00a3
        L_0x00a2:
            r5 = 0
        L_0x00a3:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.getValidToken$getJwtToken(com.talabat.authentication.natives.JwtTokenManagerImpl, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isAlreadyTimedOut(Map<String, ? extends Pair<? extends Continuation<? super String>, Long>> map, String str) {
        long j11;
        long currentTimeMillis = System.currentTimeMillis();
        Pair pair = (Pair) map.get(str);
        if (pair != null) {
            j11 = ((Number) pair.getSecond()).longValue();
        } else {
            j11 = currentTimeMillis;
        }
        if (Math.abs(currentTimeMillis - j11) >= 60000) {
            return true;
        }
        return false;
    }

    private final void observabilityForceSignedOut(String str) {
        this.observabilityManager.trackEvent("user_force_signed_out", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android"), TuplesKt.to("tokenType", str)));
    }

    private final void observabilityJwtTokenAlreadyRefreshed(String str) {
        this.observabilityManager.trackEvent("refresh_token_already", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("apiPath", str), TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android")));
    }

    private final void observabilityJwtTokenExchangeFailedAllRetries(String str) {
        this.observabilityManager.trackEvent("jwt_exchange_failed", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("apiPath", str), TuplesKt.to("source", "android")));
    }

    private final void observabilityJwtTokenRefresh(String str, int i11, Throwable th2) {
        StackTraceElement[] stackTrace;
        Throwable cause;
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = TuplesKt.to("apiPath", str);
        pairArr[1] = TuplesKt.to("source", "android");
        pairArr[2] = TuplesKt.to("stateType", "Android");
        pairArr[3] = TuplesKt.to("status", String.valueOf(i11));
        String str2 = null;
        String message = th2 != null ? th2.getMessage() : null;
        String str3 = "";
        if (message == null) {
            message = str3;
        }
        pairArr[4] = TuplesKt.to("errorCause", message);
        String message2 = (th2 == null || (cause = th2.getCause()) == null) ? null : cause.getMessage();
        if (message2 == null) {
            message2 = str3;
        }
        pairArr[5] = TuplesKt.to("errorCauseCause", message2);
        if (!(th2 == null || (stackTrace = th2.getStackTrace()) == null)) {
            str2 = ArraysKt___ArraysKt.joinToString$default((Object[]) stackTrace, (CharSequence) StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (str2 != null) {
            str3 = str2;
        }
        pairArr[6] = TuplesKt.to("errorCauseTrace", str3);
        iObservabilityManager.trackEvent("refresh_token", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
    }

    private final void observabilitySignedOutOnExchange404(String str) {
        this.observabilityManager.trackEvent("user_force_signed_out_exchange_404", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android"), TuplesKt.to("tokenType", str)));
    }

    private final boolean shouldCallLogout() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_AUTHENTICATION_AAA_LOGOUT_API, true);
    }

    private final boolean shouldClearOwinTokenOnExchange404() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_CLEAR_OWIN_ON_EXCHANGE_404_ERROR, true);
    }

    private final boolean shouldEnableRefreshToken() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_REFRESH_API_CALL_IN_NATIVE, true);
    }

    private final boolean shouldStopUseOwinToken() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object shouldUseJwtToken(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$1) r0
            int r1 = r0.f55498k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55498k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f55496i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55498k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f55495h
            com.talabat.authentication.natives.JwtTokenManagerImpl r5 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f55495h = r4
            r0.f55498k = r3
            java.lang.Object r7 = shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig(r6, r4, r5, r0)
            if (r7 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r5 = r4
        L_0x0044:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L_0x0061
            java.lang.String r5 = r5.getOwinToken()
            r6 = 0
            if (r5 == 0) goto L_0x005c
            boolean r5 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r5)
            if (r5 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r5 = r6
            goto L_0x005d
        L_0x005c:
            r5 = r3
        L_0x005d:
            if (r5 == 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r3 = r6
        L_0x0061:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.shouldUseJwtToken(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: com.talabat.authentication.natives.JwtTokenManagerImpl} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ee A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0118 A[EDGE_INSN: B:65:0x0118->B:56:0x0118 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig(java.lang.String r11, com.talabat.authentication.natives.JwtTokenManagerImpl r12, java.lang.String r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r14) {
        /*
            boolean r0 = r14 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1) r0
            int r1 = r0.f55503l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55503l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1
            r0.<init>(r14)
        L_0x0018:
            r6 = r0
            java.lang.Object r14 = r6.f55502k
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f55503l
            r7 = 0
            r2 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0058
            if (r1 == r8) goto L_0x0046
            if (r1 != r2) goto L_0x003e
            java.lang.Object r11 = r6.f55501j
            com.talabat.authentication.natives.JwtTokenManagerImpl r11 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r11
            java.lang.Object r12 = r6.f55500i
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r6.f55499h
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x003b }
            goto L_0x00b6
        L_0x003b:
            r12 = move-exception
            goto L_0x00c7
        L_0x003e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0046:
            java.lang.Object r11 = r6.f55501j
            r13 = r11
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r11 = r6.f55500i
            r12 = r11
            com.talabat.authentication.natives.JwtTokenManagerImpl r12 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r12
            java.lang.Object r11 = r6.f55499h
            java.lang.String r11 = (java.lang.String) r11
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0077
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.String r14 = "Control"
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r14)
            if (r14 == 0) goto L_0x0068
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            return r11
        L_0x0068:
            r6.f55499h = r11
            r6.f55500i = r12
            r6.f55501j = r13
            r6.f55503l = r8
            java.lang.Object r14 = r12.barrierRemoteConfig(r6)
            if (r14 != r0) goto L_0x0077
            return r0
        L_0x0077:
            com.talabat.authentication.natives.model.AuthRemoteConfig r14 = r12.cachedRemoteConfig
            if (r14 != 0) goto L_0x00cb
            r12.beforeRemoteConfig()
            kotlin.jvm.functions.Function0<com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource> r14 = r12.remoteConfigProvider     // Catch:{ all -> 0x00c3 }
            java.lang.Object r14 = r14.invoke()     // Catch:{ all -> 0x00c3 }
            r1 = r14
            com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource r1 = (com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource) r1     // Catch:{ all -> 0x00c3 }
            com.talabat.core.fwfprojectskeys.domain.projects.user.UserRemoteConfigurationsKeys r14 = com.talabat.core.fwfprojectskeys.domain.projects.user.UserRemoteConfigurationsKeys.RC_USER_AUTHENTICATION_API_MIGRATION     // Catch:{ all -> 0x00c3 }
            com.talabat.authentication.natives.model.AuthRemoteConfig r3 = new com.talabat.authentication.natives.model.AuthRemoteConfig     // Catch:{ all -> 0x00c3 }
            com.talabat.authentication.natives.model.AuthRemoteConfig$Variation r4 = new com.talabat.authentication.natives.model.AuthRemoteConfig$Variation     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = ".*"
            java.util.List r5 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.String r9 = "Variation2"
            r4.<init>(r5, r9)     // Catch:{ all -> 0x00c3 }
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r4)     // Catch:{ all -> 0x00c3 }
            r3.<init>(r4)     // Catch:{ all -> 0x00c3 }
            r4 = 0
            java.lang.Class<com.talabat.authentication.natives.model.AuthRemoteConfig> r5 = com.talabat.authentication.natives.model.AuthRemoteConfig.class
            r6.f55499h = r11     // Catch:{ all -> 0x00c3 }
            r6.f55500i = r13     // Catch:{ all -> 0x00c3 }
            r6.f55501j = r12     // Catch:{ all -> 0x00c3 }
            r6.f55503l = r2     // Catch:{ all -> 0x00c3 }
            r2 = r14
            java.lang.Object r14 = r1.getRemoteConfiguration((com.talabat.core.fwfprojectskeys.domain.FWFKey) r2, r3, (boolean) r4, r5, r6)     // Catch:{ all -> 0x00c3 }
            if (r14 != r0) goto L_0x00b2
            return r0
        L_0x00b2:
            r10 = r13
            r13 = r11
            r11 = r12
            r12 = r10
        L_0x00b6:
            r0 = r14
            com.talabat.authentication.natives.model.AuthRemoteConfig r0 = (com.talabat.authentication.natives.model.AuthRemoteConfig) r0     // Catch:{ all -> 0x003b }
            r11.cachedRemoteConfig = r0     // Catch:{ all -> 0x003b }
            com.talabat.authentication.natives.model.AuthRemoteConfig r14 = (com.talabat.authentication.natives.model.AuthRemoteConfig) r14     // Catch:{ all -> 0x003b }
            r11.afterRemoteConfig()
            r11 = r13
            r13 = r12
            goto L_0x00cb
        L_0x00c3:
            r11 = move-exception
            r10 = r12
            r12 = r11
            r11 = r10
        L_0x00c7:
            r11.afterRemoteConfig()
            throw r12
        L_0x00cb:
            java.util.List r12 = r14.getVariations()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x00d5:
            boolean r14 = r12.hasNext()
            r0 = 0
            if (r14 == 0) goto L_0x00ee
            java.lang.Object r14 = r12.next()
            r1 = r14
            com.talabat.authentication.natives.model.AuthRemoteConfig$Variation r1 = (com.talabat.authentication.natives.model.AuthRemoteConfig.Variation) r1
            java.lang.String r1 = r1.getName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r11)
            if (r1 == 0) goto L_0x00d5
            goto L_0x00ef
        L_0x00ee:
            r14 = r0
        L_0x00ef:
            com.talabat.authentication.natives.model.AuthRemoteConfig$Variation r14 = (com.talabat.authentication.natives.model.AuthRemoteConfig.Variation) r14
            if (r14 == 0) goto L_0x011a
            java.util.List r11 = r14.getLinks()
            if (r11 == 0) goto L_0x011a
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L_0x00ff:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x0118
            java.lang.Object r12 = r11.next()
            r14 = r12
            java.lang.String r14 = (java.lang.String) r14
            kotlin.text.Regex r1 = new kotlin.text.Regex
            r1.<init>((java.lang.String) r14)
            boolean r14 = r1.matches(r13)
            if (r14 == 0) goto L_0x00ff
            r0 = r12
        L_0x0118:
            java.lang.String r0 = (java.lang.String) r0
        L_0x011a:
            if (r0 == 0) goto L_0x0122
            boolean r11 = kotlin.text.StringsKt__StringsJVMKt.isBlank(r0)
            if (r11 == 0) goto L_0x0123
        L_0x0122:
            r7 = r8
        L_0x0123:
            r11 = r7 ^ 1
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig(java.lang.String, com.talabat.authentication.natives.JwtTokenManagerImpl, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[SYNTHETIC, Splitter:B:23:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValidToken(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$1 r0 = (com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$1) r0
            int r1 = r0.f55490l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55490l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$1 r0 = new com.talabat.authentication.natives.JwtTokenManagerImpl$getValidToken$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f55488j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55490l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.f55486h
            com.talabat.authentication.natives.JwtTokenManagerImpl r9 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0030 }
            goto L_0x0081
        L_0x0030:
            r10 = move-exception
            goto L_0x0088
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            java.lang.Object r9 = r0.f55487i
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.f55486h
            com.talabat.authentication.natives.JwtTokenManagerImpl r2 = (com.talabat.authentication.natives.JwtTokenManagerImpl) r2
            kotlin.ResultKt.throwOnFailure(r10)
            r7 = r10
            r10 = r9
            r9 = r2
            r2 = r7
            goto L_0x0069
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.core.experiment.domain.ITalabatExperiment r10 = r8.experiment
            com.talabat.core.fwfprojectskeys.domain.projects.user.UserExperimentsKeys r2 = com.talabat.core.fwfprojectskeys.domain.projects.user.UserExperimentsKeys.EXP_USER_AUTHENTICATION_API_MIGRATION
            java.lang.String r5 = "Variation2"
            com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy r6 = com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy.FWF
            java.lang.String r10 = r10.getStringVariant(r2, r5, r6)
            r0.f55486h = r8
            r0.f55487i = r9
            r0.f55490l = r4
            java.lang.Object r10 = r8.shouldUseJwtToken(r9, r10, r0)
            if (r10 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r10
            r10 = r9
            r9 = r8
        L_0x0069:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x00ab
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0030 }
            r0.f55486h = r9     // Catch:{ all -> 0x0030 }
            r2 = 0
            r0.f55487i = r2     // Catch:{ all -> 0x0030 }
            r0.f55490l = r3     // Catch:{ all -> 0x0030 }
            java.lang.Object r10 = getValidToken$getJwtToken(r9, r10, r0)     // Catch:{ all -> 0x0030 }
            if (r10 != r1) goto L_0x0081
            return r1
        L_0x0081:
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0030 }
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)     // Catch:{ all -> 0x0030 }
            goto L_0x0092
        L_0x0088:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x0092:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r10)
            if (r0 != 0) goto L_0x0099
            goto L_0x00a1
        L_0x0099:
            boolean r10 = r0 instanceof com.talabat.authentication.natives.JwtTokenFlowTerminalException
            if (r10 != 0) goto L_0x00aa
            java.lang.String r10 = r9.getOwinToken()
        L_0x00a1:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x00af
            java.lang.String r10 = r9.getOwinToken()
            goto L_0x00af
        L_0x00aa:
            throw r0
        L_0x00ab:
            java.lang.String r10 = r9.getOwinToken()
        L_0x00af:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.getValidToken(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object refreshToken(@NotNull String str, @NotNull Continuation<? super Token> continuation) {
        if (shouldEnableRefreshToken()) {
            return doRefreshToken(str, continuation);
        }
        String owinToken = getOwinToken();
        if (owinToken == null) {
            owinToken = "";
        }
        return new Token((String) null, owinToken, 2556129599000L, "bearer", "", 0);
    }

    private final void observabilityJwtTokenRefresh(String str, int i11, Throwable th2, Throwable th3) {
        StackTraceElement[] stackTrace;
        Throwable cause;
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[9];
        pairArr[0] = TuplesKt.to("apiPath", str);
        pairArr[1] = TuplesKt.to("source", "android");
        pairArr[2] = TuplesKt.to("stateType", "Android");
        pairArr[3] = TuplesKt.to("status", String.valueOf(i11));
        String message = th2.getMessage();
        String str2 = "";
        if (message == null) {
            message = str2;
        }
        pairArr[4] = TuplesKt.to("errorTitle", message);
        StackTraceElement[] stackTrace2 = th2.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace2, "throwable.stackTrace");
        pairArr[5] = TuplesKt.to("errorDetail", ArraysKt___ArraysKt.joinToString$default((Object[]) stackTrace2, (CharSequence) StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        String str3 = null;
        String message2 = th3 != null ? th3.getMessage() : null;
        if (message2 == null) {
            message2 = str2;
        }
        pairArr[6] = TuplesKt.to("errorCause", message2);
        String message3 = (th3 == null || (cause = th3.getCause()) == null) ? null : cause.getMessage();
        if (message3 == null) {
            message3 = str2;
        }
        pairArr[7] = TuplesKt.to("errorCauseCause", message3);
        if (!(th3 == null || (stackTrace = th3.getStackTrace()) == null)) {
            str3 = ArraysKt___ArraysKt.joinToString$default((Object[]) stackTrace, (CharSequence) StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (str3 != null) {
            str2 = str3;
        }
        pairArr[8] = TuplesKt.to("errorCauseTrace", str2);
        iObservabilityManager.trackEvent("refresh_token", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(pairArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JwtTokenManagerImpl(com.talabat.authentication.aaa.AaaApi r19, com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory r20, com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed r21, com.talabat.core.experiment.domain.ITalabatExperiment r22, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r23, com.talabat.core.observabilityNew.domain.IObservabilityManager r24, kotlin.jvm.functions.Function0 r25, com.talabat.authentication.aaa.secrets.SecretProvider r26, com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository r27, com.talabat.authentication.token.data.remote.TokenResponseMapper r28, com.talabat.authentication.token.domain.repository.TokenRepository r29, com.talabat.authentication.usecase.IsTokenExpiredUseCase r30, kotlin.jvm.functions.Function0 r31, kotlin.jvm.functions.Function0 r32, kotlin.jvm.functions.Function0 r33, int r34, kotlin.jvm.internal.DefaultConstructorMarker r35) {
        /*
            r18 = this;
            r0 = r34
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x000a
            com.talabat.authentication.natives.JwtTokenManagerImpl$1 r1 = com.talabat.authentication.natives.JwtTokenManagerImpl.AnonymousClass1.INSTANCE
            r15 = r1
            goto L_0x000c
        L_0x000a:
            r15 = r31
        L_0x000c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0015
            com.talabat.authentication.natives.JwtTokenManagerImpl$2 r1 = com.talabat.authentication.natives.JwtTokenManagerImpl.AnonymousClass2.INSTANCE
            r16 = r1
            goto L_0x0017
        L_0x0015:
            r16 = r32
        L_0x0017:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0020
            com.talabat.authentication.natives.JwtTokenManagerImpl$3 r0 = com.talabat.authentication.natives.JwtTokenManagerImpl.AnonymousClass3.INSTANCE
            r17 = r0
            goto L_0x0022
        L_0x0020:
            r17 = r33
        L_0x0022:
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r25
            r10 = r26
            r11 = r27
            r12 = r28
            r13 = r29
            r14 = r30
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.natives.JwtTokenManagerImpl.<init>(com.talabat.authentication.aaa.AaaApi, com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory, com.talabat.authentication.authenticate.domain.usecase.TokenExchangeAllowed, com.talabat.core.experiment.domain.ITalabatExperiment, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.core.observabilityNew.domain.IObservabilityManager, kotlin.jvm.functions.Function0, com.talabat.authentication.aaa.secrets.SecretProvider, com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository, com.talabat.authentication.token.data.remote.TokenResponseMapper, com.talabat.authentication.token.domain.repository.TokenRepository, com.talabat.authentication.usecase.IsTokenExpiredUseCase, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
