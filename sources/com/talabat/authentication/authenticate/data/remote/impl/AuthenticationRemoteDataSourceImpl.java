package com.talabat.authentication.authenticate.data.remote.impl;

import com.google.gson.Gson;
import com.talabat.authentication.aaa.AaaApi;
import com.talabat.authentication.aaa.GenericErrorBody;
import com.talabat.authentication.aaa.HttpExceptionExtensionsKt;
import com.talabat.authentication.aaa.TokenResponse;
import com.talabat.authentication.aaa.secrets.SecretProvider;
import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource;
import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException;
import com.talabat.authentication.authenticate.data.remote.model.LogoutRequest;
import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.authenticate.data.remote.model.SilentLoginRequest;
import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.data.model.TokenDataExtensionsKt;
import com.talabat.authentication.token.data.remote.TokenResponseMapper;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.registration.RegistrationInteractor;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import java.util.Map;
import javax.inject.Inject;
import jf.a;
import jf.b;
import jf.c;
import jf.d;
import jf.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;
import retrofit2.Response;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J)\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002J \u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00160&H\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0015H\u0016J\u0011\u0010)\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0010\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/talabat/authentication/authenticate/data/remote/impl/AuthenticationRemoteDataSourceImpl;", "Lcom/talabat/authentication/authenticate/data/remote/AuthenticationRemoteDataSource;", "aaaApi", "Lcom/talabat/authentication/aaa/AaaApi;", "gson", "Lcom/google/gson/Gson;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "secretProvider", "Lcom/talabat/authentication/aaa/secrets/SecretProvider;", "tokenResponseMapper", "Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/authentication/aaa/AaaApi;Lcom/google/gson/Gson;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/authentication/aaa/secrets/SecretProvider;Lcom/talabat/authentication/token/data/remote/TokenResponseMapper;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "secretBody", "", "", "getSecretBody", "()Ljava/util/Map;", "authenticateWithPassword", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/TokenData;", "email", "password", "authenticateWithSocialLogin", "platform", "socialToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "errorAuthenticateWithPassword", "Lcom/talabat/authentication/token/data/model/TokenData$Error;", "exceptionMessage", "errorMigrationExchangeToken", "handleError", "", "throwable", "", "emitter", "Lio/reactivex/SingleEmitter;", "logout", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutResponse;", "migrationExchangeToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observabilityForceSignedOut", "tokenType", "observe", "shouldClearOwinTokenOnExchange404", "", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationRemoteDataSourceImpl implements AuthenticationRemoteDataSource {
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
    public static final String DEVICE_TOKEN = "X-Device";
    @NotNull
    @Deprecated
    public static final String EVENT_NAME_LOGOUT = "user_signed_out_intentionally";
    @NotNull
    @Deprecated
    public static final String GRANT_TYPE_KEY = "grant_type";
    @NotNull
    @Deprecated
    public static final String GRANT_TYPE_VALUE = "password";
    @Deprecated
    public static final int STATUS_OK = 200;
    @NotNull
    @Deprecated
    public static final String TOKEN_TYPE_HINT = "access_token";
    @NotNull
    private final AaaApi aaaApi;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final Gson gson;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final SecretProvider secretProvider;
    @NotNull
    private final TokenResponseMapper tokenResponseMapper;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/authentication/authenticate/data/remote/impl/AuthenticationRemoteDataSourceImpl$Companion;", "", "()V", "CLIENT_ID_KEY", "", "CLIENT_ID_VALUE", "CLIENT_SECRET_KEY", "DEVICE_TOKEN", "EVENT_NAME_LOGOUT", "GRANT_TYPE_KEY", "GRANT_TYPE_VALUE", "STATUS_OK", "", "TOKEN_TYPE_HINT", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AuthenticationRemoteDataSourceImpl(@NotNull AaaApi aaaApi2, @NotNull Gson gson2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull SecretProvider secretProvider2, @NotNull TokenResponseMapper tokenResponseMapper2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(aaaApi2, "aaaApi");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(secretProvider2, "secretProvider");
        Intrinsics.checkNotNullParameter(tokenResponseMapper2, "tokenResponseMapper");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.aaaApi = aaaApi2;
        this.gson = gson2;
        this.featureFlag = iTalabatFeatureFlag;
        this.secretProvider = secretProvider2;
        this.tokenResponseMapper = tokenResponseMapper2;
        this.observabilityManager = iObservabilityManager;
    }

    /* access modifiers changed from: private */
    /* renamed from: authenticateWithPassword$lambda-8  reason: not valid java name */
    public static final void m9513authenticateWithPassword$lambda8(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, String str, String str2, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(str, "$email");
        Intrinsics.checkNotNullParameter(str2, "$password");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        singleEmitter.setDisposable(AaaApi.DefaultImpls.authenticateWithPassword$default(authenticationRemoteDataSourceImpl.aaaApi, new SilentLoginRequest("password", "android", authenticationRemoteDataSourceImpl.secretProvider.getClientSecret(), str, str2), TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.getGetDeviceToken().invoke(), (String) null, 4, (Object) null).map(new b(authenticationRemoteDataSourceImpl)).doOnError(new c(authenticationRemoteDataSourceImpl)).subscribe(new d(singleEmitter), new e(authenticationRemoteDataSourceImpl, singleEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: authenticateWithPassword$lambda-8$lambda-6  reason: not valid java name */
    public static final TokenData m9514authenticateWithPassword$lambda8$lambda6(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, Response response) {
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(response, "response");
        String str = response.headers().get("X-Device");
        TokenResponse tokenResponse = (TokenResponse) response.body();
        if (tokenResponse == null) {
            return authenticationRemoteDataSourceImpl.errorAuthenticateWithPassword("Token not returned");
        }
        if (str == null) {
            return authenticationRemoteDataSourceImpl.errorAuthenticateWithPassword("Device token not returned");
        }
        return new TokenData.Valid(authenticationRemoteDataSourceImpl.tokenResponseMapper.map(tokenResponse), str);
    }

    /* access modifiers changed from: private */
    /* renamed from: authenticateWithPassword$lambda-8$lambda-7  reason: not valid java name */
    public static final void m9515authenticateWithPassword$lambda8$lambda7(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, SingleEmitter singleEmitter, Throwable th2) {
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSourceImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "$emitter");
        authenticationRemoteDataSourceImpl.handleError(th2, singleEmitter);
    }

    private final TokenData.Error errorAuthenticateWithPassword(String str) {
        observe(new Throwable("AuthenticationRemoteDataSourceImpl.errorAuthenticateWithPassword(): " + str));
        return new TokenData.Error(200, "AuthenticationRemoteDataSourceImpl.errorAuthenticateWithPassword()", str);
    }

    private final TokenData.Error errorMigrationExchangeToken(String str) {
        observe(new Throwable("AuthenticationRemoteDataSourceImpl.migrationExchangeToken(): " + str));
        return new TokenData.Error(200, "AuthenticationRemoteDataSourceImpl.migrationExchangeToken()", str);
    }

    private final Map<String, String> getSecretBody() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("client_id", "android"), TuplesKt.to("client_secret", this.secretProvider.getClientSecret()));
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
                singleEmitter.onError(new AuthenticationRemoteDataSourceException("An error occurred while trying to fetch token data", r32));
                return;
            }
            return;
        }
        singleEmitter.onError(new AuthenticationRemoteDataSourceException("An error occurred while trying to fetch token data", th2));
    }

    private final void observabilityForceSignedOut(String str) {
        this.observabilityManager.trackEvent("user_force_signed_out", RegistrationInteractor.AUTH_EVENT, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android"), TuplesKt.to("tokenType", str)));
    }

    /* access modifiers changed from: private */
    public final void observe(Throwable th2) {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        iObservabilityManager.trackUnExpectedScenario("AuthenticationRemoteDataSourceImplErrors", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", message)));
    }

    private final boolean shouldClearOwinTokenOnExchange404() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_CLEAR_OWIN_ON_EXCHANGE_404_ERROR, true);
    }

    @NotNull
    public Single<TokenData> authenticateWithPassword(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "email");
        Intrinsics.checkNotNullParameter(str2, "password");
        Single<TokenData> create = Single.create(new a(this, str, str2));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …ter::setDisposable)\n    }");
        return create;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticateWithSocialLogin(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull java.lang.String r10, @org.jetbrains.annotations.NotNull java.lang.String r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.authentication.token.data.model.TokenData> r12) throws com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$authenticateWithSocialLogin$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$authenticateWithSocialLogin$1 r0 = (com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$authenticateWithSocialLogin$1) r0
            int r1 = r0.f55420k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55420k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$authenticateWithSocialLogin$1 r0 = new com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$authenticateWithSocialLogin$1
            r0.<init>(r8, r12)
        L_0x0018:
            r5 = r0
            java.lang.Object r12 = r5.f55418i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f55420k
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r9 = r5.f55417h
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl r9 = (com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl) r9
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x002e }
            goto L_0x0061
        L_0x002e:
            r10 = move-exception
            goto L_0x006a
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x0068 }
            com.talabat.authentication.aaa.AaaApi r1 = r8.aaaApi     // Catch:{ all -> 0x0068 }
            com.talabat.authentication.aaa.AuthenticateWithSocialConnectRequestBody r12 = new com.talabat.authentication.aaa.AuthenticateWithSocialConnectRequestBody     // Catch:{ all -> 0x0068 }
            r12.<init>(r9, r10, r11)     // Catch:{ all -> 0x0068 }
            com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator r9 = com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator.INSTANCE     // Catch:{ all -> 0x0068 }
            kotlin.jvm.functions.Function0 r9 = r9.getGetDeviceToken()     // Catch:{ all -> 0x0068 }
            java.lang.Object r9 = r9.invoke()     // Catch:{ all -> 0x0068 }
            r3 = r9
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0068 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.f55417h = r8     // Catch:{ all -> 0x0068 }
            r5.f55420k = r2     // Catch:{ all -> 0x0068 }
            r2 = r12
            java.lang.Object r12 = com.talabat.authentication.aaa.AaaApi.DefaultImpls.authenticateWithSocialConnect$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0068 }
            if (r12 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r9 = r8
        L_0x0061:
            com.talabat.authentication.aaa.TokenResponse r12 = (com.talabat.authentication.aaa.TokenResponse) r12     // Catch:{ all -> 0x002e }
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r12)     // Catch:{ all -> 0x002e }
            goto L_0x0074
        L_0x0068:
            r10 = move-exception
            r9 = r8
        L_0x006a:
            kotlin.Result$Companion r11 = kotlin.Result.Companion
            java.lang.Object r10 = kotlin.ResultKt.createFailure(r10)
            java.lang.Object r10 = kotlin.Result.m6329constructorimpl(r10)
        L_0x0074:
            java.lang.Throwable r11 = kotlin.Result.m6332exceptionOrNullimpl(r10)
            if (r11 != 0) goto L_0x008a
            com.talabat.authentication.aaa.TokenResponse r10 = (com.talabat.authentication.aaa.TokenResponse) r10
            com.talabat.authentication.token.data.remote.TokenResponseMapper r9 = r9.tokenResponseMapper
            com.talabat.authentication.token.domain.model.Token r9 = r9.map(r10)
            com.talabat.authentication.token.data.model.TokenData$Valid r10 = new com.talabat.authentication.token.data.model.TokenData$Valid
            java.lang.String r11 = ""
            r10.<init>(r9, r11)
            goto L_0x0094
        L_0x008a:
            com.google.gson.Gson r9 = r9.gson
            com.talabat.authentication.aaa.GenericErrorBody r9 = com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseGenericErrorBodyOrThrow((java.lang.Throwable) r11, (com.google.gson.Gson) r9)
            com.talabat.authentication.token.data.model.TokenData$Error r10 = com.talabat.authentication.token.data.model.TokenDataExtensionsKt.toTokenDataError(r9)
        L_0x0094:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl.authenticateWithSocialLogin(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public Single<LogoutResponse> logout() {
        TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
        if (!talabatNetworkModuleJWTTokenIntegrator.isTokenAvailable().invoke().booleanValue()) {
            Single<LogoutResponse> error = Single.error((Throwable) new IllegalStateException("JWT token not available"));
            Intrinsics.checkNotNullExpressionValue(error, "{\n            Single.err…ot available\"))\n        }");
            return error;
        }
        IObservabilityManager.DefaultImpls.trackEvent$default(this.observabilityManager, EVENT_NAME_LOGOUT, EventType.AuthEvent.name(), (Map) null, 4, (Object) null);
        return AaaApi.DefaultImpls.logout$default(this.aaaApi, new LogoutRequest(talabatNetworkModuleJWTTokenIntegrator.getGetAccessToken().invoke(), "access_token"), talabatNetworkModuleJWTTokenIntegrator.getGetDeviceToken().invoke(), (String) null, 4, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object migrationExchangeToken(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.authentication.token.data.model.TokenData> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1 r0 = (com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1) r0
            int r1 = r0.f55424k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55424k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1 r0 = new com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1
            r0.<init>(r8, r9)
        L_0x0018:
            r5 = r0
            java.lang.Object r9 = r5.f55422i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f55424k
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 != r2) goto L_0x0030
            java.lang.Object r0 = r5.f55421h
            com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl r0 = (com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x002e }
            goto L_0x005f
        L_0x002e:
            r9 = move-exception
            goto L_0x0068
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x0066 }
            com.talabat.authentication.aaa.AaaApi r1 = r8.aaaApi     // Catch:{ all -> 0x0066 }
            java.util.Map r9 = r8.getSecretBody()     // Catch:{ all -> 0x0066 }
            com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator r3 = com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator.INSTANCE     // Catch:{ all -> 0x0066 }
            kotlin.jvm.functions.Function0 r3 = r3.getGetDeviceToken()     // Catch:{ all -> 0x0066 }
            java.lang.Object r3 = r3.invoke()     // Catch:{ all -> 0x0066 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0066 }
            r4 = 0
            r6 = 4
            r7 = 0
            r5.f55421h = r8     // Catch:{ all -> 0x0066 }
            r5.f55424k = r2     // Catch:{ all -> 0x0066 }
            r2 = r9
            java.lang.Object r9 = com.talabat.authentication.aaa.AaaApi.DefaultImpls.migrationExchangeToken$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0066 }
            if (r9 != r0) goto L_0x005e
            return r0
        L_0x005e:
            r0 = r8
        L_0x005f:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch:{ all -> 0x002e }
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x002e }
            goto L_0x0072
        L_0x0066:
            r9 = move-exception
            r0 = r8
        L_0x0068:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0072:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            java.lang.String r2 = "owin"
            r3 = 404(0x194, float:5.66E-43)
            if (r1 != 0) goto L_0x00ca
            retrofit2.Response r9 = (retrofit2.Response) r9
            int r1 = r9.code()
            if (r1 != r3) goto L_0x009b
            boolean r1 = r0.shouldClearOwinTokenOnExchange404()
            if (r1 == 0) goto L_0x009b
            r0.observabilityForceSignedOut(r2)
            com.talabat.authentication.token.data.model.TokenData$Error r9 = new com.talabat.authentication.token.data.model.TokenData$Error
            com.talabat.authentication.token.data.model.TokenData$Error$ExceptionType r0 = com.talabat.authentication.token.data.model.TokenData.Error.ExceptionType.OAUTH_FAILED_EXCEPTION
            java.lang.String r0 = r0.name()
            java.lang.String r1 = "Exchange failed with 404 - login - Clean OWIN"
            r9.<init>(r3, r0, r1)
            goto L_0x0103
        L_0x009b:
            okhttp3.Headers r1 = r9.headers()
            java.lang.String r2 = "X-Device"
            java.lang.String r1 = r1.get(r2)
            java.lang.Object r9 = r9.body()
            com.talabat.authentication.aaa.TokenResponse r9 = (com.talabat.authentication.aaa.TokenResponse) r9
            if (r9 != 0) goto L_0x00b4
            java.lang.String r9 = "Token not returned"
            com.talabat.authentication.token.data.model.TokenData$Error r9 = r0.errorMigrationExchangeToken(r9)
            goto L_0x0103
        L_0x00b4:
            if (r1 != 0) goto L_0x00bd
            java.lang.String r9 = "Device token not returned"
            com.talabat.authentication.token.data.model.TokenData$Error r9 = r0.errorMigrationExchangeToken(r9)
            goto L_0x0103
        L_0x00bd:
            com.talabat.authentication.token.data.remote.TokenResponseMapper r0 = r0.tokenResponseMapper
            com.talabat.authentication.token.domain.model.Token r9 = r0.map(r9)
            com.talabat.authentication.token.data.model.TokenData$Valid r0 = new com.talabat.authentication.token.data.model.TokenData$Valid
            r0.<init>(r9, r1)
        L_0x00c8:
            r9 = r0
            goto L_0x0103
        L_0x00ca:
            boolean r9 = r1 instanceof retrofit2.HttpException
            if (r9 == 0) goto L_0x00f9
            r9 = r1
            retrofit2.HttpException r9 = (retrofit2.HttpException) r9
            int r4 = r9.code()
            if (r4 != r3) goto L_0x00f9
            boolean r3 = r0.shouldClearOwinTokenOnExchange404()
            if (r3 == 0) goto L_0x00f9
            r0.observabilityForceSignedOut(r2)
            com.talabat.authentication.token.data.model.TokenData$Error r0 = new com.talabat.authentication.token.data.model.TokenData$Error
            int r1 = r9.code()
            com.talabat.authentication.token.data.model.TokenData$Error$ExceptionType r2 = com.talabat.authentication.token.data.model.TokenData.Error.ExceptionType.OAUTH_FAILED_EXCEPTION
            java.lang.String r2 = r2.name()
            java.lang.String r9 = r9.message()
            java.lang.String r3 = "e.message()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
            r0.<init>(r1, r2, r9)
            goto L_0x00c8
        L_0x00f9:
            com.google.gson.Gson r9 = r0.gson
            com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody r9 = com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseMigrationExchangeTokenErrorBodyOrThrow((java.lang.Throwable) r1, (com.google.gson.Gson) r9)
            com.talabat.authentication.token.data.model.TokenData$Error r9 = com.talabat.authentication.token.data.model.TokenDataExtensionsKt.toMigrationExchangeTokenDataError(r9)
        L_0x0103:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl.migrationExchangeToken(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
