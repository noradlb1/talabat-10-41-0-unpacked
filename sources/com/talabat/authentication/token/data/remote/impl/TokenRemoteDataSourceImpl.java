package com.talabat.authentication.token.data.remote.impl;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.GenericErrorBody;
import com.talabat.authentication.aaa.HttpExceptionExtensionsKt;
import com.talabat.authentication.aaa.TokenResponse;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.data.model.TokenDataExtensionsKt;
import com.talabat.authentication.token.data.remote.FetchClientTokenDataException;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import com.talabat.observability.ObservabilityManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import of.f;
import of.g;
import of.h;
import of.i;
import org.jetbrains.annotations.NotNull;
import p005if.e;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/token/data/remote/impl/TokenRemoteDataSourceImpl;", "Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "aaaApi", "Lcom/talabat/authentication/aaa/AaaApi;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "gson", "Lcom/google/gson/Gson;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "(Lcom/talabat/authentication/aaa/AaaApi;Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;Lcom/google/gson/Gson;Lcom/talabat/authentication/aaa/secrets/SecretProvider;)V", "fetchClientTokenData", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/TokenData;", "handleError", "", "throwable", "", "emitter", "Lio/reactivex/SingleEmitter;", "observe", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenRemoteDataSourceImpl implements TokenRemoteDataSource {
    @NotNull
    @Deprecated
    public static final String CLIENT_ID_KEY = "client_id";
    @NotNull
    @Deprecated
    public static final String CLIENT_ID_VALUE = "android";
    @NotNull
    @Deprecated
    public static final String CLIENT_SECRET_KEY = "client_secret";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String GRANT_TYPE_KEY = "grant_type";
    @NotNull
    @Deprecated
    public static final String GRANT_TYPE_VALUE = "client_credentials";
    @NotNull
    private final AaaApi aaaApi;
    @NotNull
    private final Gson gson;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final TokenResponseMapper tokenResponseMapper;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/authentication/token/data/remote/impl/TokenRemoteDataSourceImpl$Companion;", "", "()V", "CLIENT_ID_KEY", "", "CLIENT_ID_VALUE", "CLIENT_SECRET_KEY", "GRANT_TYPE_KEY", "GRANT_TYPE_VALUE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public TokenRemoteDataSourceImpl(@NotNull AaaApi aaaApi2, @NotNull TokenResponseMapper tokenResponseMapper2, @NotNull Gson gson2, @NotNull SecretProvider secretProvider2) {
        Intrinsics.checkNotNullParameter(aaaApi2, "aaaApi");
        Intrinsics.checkNotNullParameter(tokenResponseMapper2, "tokenResponseMapper");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        this.aaaApi = aaaApi2;
        this.tokenResponseMapper = tokenResponseMapper2;
        this.gson = gson2;
        this.secretProvider = secretProvider2;
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchClientTokenData$lambda-2  reason: not valid java name */
    public static final void m9529fetchClientTokenData$lambda2(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(tokenRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        singleEmitter.setDisposable(AaaApi.DefaultImpls.loginClient$default(tokenRemoteDataSourceImpl.aaaApi, MapsKt__MapsKt.mapOf(TuplesKt.to("grant_type", GRANT_TYPE_VALUE), TuplesKt.to("client_id", "android"), TuplesKt.to("client_secret", tokenRemoteDataSourceImpl.secretProvider.getClientSecret())), TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.getGetDeviceToken().invoke(), (String) null, 4, (Object) null).map(new f(tokenRemoteDataSourceImpl)).doOnError(new g(tokenRemoteDataSourceImpl)).subscribe(new e(singleEmitter), new h(tokenRemoteDataSourceImpl, singleEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchClientTokenData$lambda-2$lambda-0  reason: not valid java name */
    public static final TokenData.Valid m9530fetchClientTokenData$lambda2$lambda0(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl, TokenResponse tokenResponse) {
        Intrinsics.checkNotNullParameter(tokenRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(tokenResponse, "it");
        return new TokenData.Valid(tokenRemoteDataSourceImpl.tokenResponseMapper.map(tokenResponse), "");
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchClientTokenData$lambda-2$lambda-1  reason: not valid java name */
    public static final void m9531fetchClientTokenData$lambda2$lambda1(TokenRemoteDataSourceImpl tokenRemoteDataSourceImpl, SingleEmitter singleEmitter, Throwable th2) {
        Intrinsics.checkNotNullParameter(tokenRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        tokenRemoteDataSourceImpl.handleError(th2, singleEmitter);
    }

    private final void handleError(Throwable th2, SingleEmitter<TokenData> singleEmitter) {
        Object obj;
        if (th2 instanceof HttpException) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(HttpExceptionExtensionsKt.tryParseGenericErrorBodyOrThrow((HttpException) th2, this.gson));
            } catch (Throwable th3) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th3));
            }
            if (Result.m6336isSuccessimpl(obj)) {
                singleEmitter.onSuccess(TokenDataExtensionsKt.toTokenDataError((GenericErrorBody) obj));
            }
            Throwable r32 = Result.m6332exceptionOrNullimpl(obj);
            if (r32 != null) {
                singleEmitter.onError(new FetchClientTokenDataException("An error occurred while trying to fetch token data", r32));
                return;
            }
            return;
        }
        singleEmitter.onError(new FetchClientTokenDataException("An error occurred while trying to fetch token data", th2));
    }

    /* access modifiers changed from: private */
    public final void observe(Throwable th2) {
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        ObservabilityManager.trackUnExpectedScenario("TokenRemoteDataSourceImplErrors", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    @NotNull
    public Single<TokenData> fetchClientTokenData() {
        Single<TokenData> create = Single.create(new i(this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …ter::setDisposable)\n    }");
        return create;
    }
}
