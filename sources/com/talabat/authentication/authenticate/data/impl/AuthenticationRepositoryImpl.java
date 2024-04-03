package com.talabat.authentication.authenticate.data.impl;

import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.talabat.authentication.AuthenticationIntegrator;
import com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource;
import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import com.talabat.authentication.authenticate.domain.usecase.UserLoggedIn;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.model.SwapTokenData;
import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.data.remote.LegacyTokenRemoteDataSource;
import com.talabat.authentication.token.domain.model.LegacyToken;
import com.talabat.authentication.token.domain.model.Token;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.observability.ObservabilityManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p005if.a;
import p005if.b;
import p005if.c;
import p005if.d;
import p005if.e;
import p005if.f;
import p005if.g;
import p005if.h;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J)\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0011\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u001e2\u0006\u0010(\u001a\u00020'H\u0002J\f\u0010)\u001a\u00020\u0011*\u00020\u0016H\u0002J\f\u0010*\u001a\u00020+*\u00020,H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/talabat/authentication/authenticate/data/impl/AuthenticationRepositoryImpl;", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "authenticationRemoteDataSource", "Lcom/talabat/authentication/authenticate/data/remote/AuthenticationRemoteDataSource;", "legacyTokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "legacyTokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "userLoggedIn", "Lcom/talabat/authentication/authenticate/domain/usecase/UserLoggedIn;", "(Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/authentication/authenticate/data/remote/AuthenticationRemoteDataSource;Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;Lcom/talabat/authentication/authenticate/domain/usecase/UserLoggedIn;)V", "authenticateWithPassword", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithSocialLogin", "platform", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository$Platform;", "socialToken", "(Ljava/lang/String;Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository$Platform;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearTokenAndDeviceId", "", "isUserLoggedIn", "", "logout", "Lio/reactivex/Single;", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutResponse;", "migrationExchangeToken", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeError", "throwable", "", "swapWithLegacyToken", "Lcom/talabat/authentication/token/data/model/TokenData;", "tokenData", "asString", "toLegacyToken", "Lcom/talabat/authentication/token/domain/model/LegacyToken;", "Lcom/talabat/authentication/token/data/model/SwapTokenData;", "toPasswordAuthenticationError", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication$Error;", "Lcom/talabat/authentication/token/data/model/TokenData$Error;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthenticationRepositoryImpl implements AuthenticationRepository, SocialAuthenticationRepository {
    @NotNull
    private final AuthenticationRemoteDataSource authenticationRemoteDataSource;
    @NotNull
    private final LegacyTokenLocalDataSource legacyTokenLocalDataSource;
    @NotNull
    private final LegacyTokenRemoteDataSource legacyTokenRemoteDataSource;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenRepository tokenRepository;
    @NotNull
    private final UserLoggedIn userLoggedIn;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SocialAuthenticationRepository.Platform.values().length];
            iArr[SocialAuthenticationRepository.Platform.FACEBOOK.ordinal()] = 1;
            iArr[SocialAuthenticationRepository.Platform.GOOGLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public AuthenticationRepositoryImpl(@NotNull TokenRepository tokenRepository2, @NotNull AuthenticationRemoteDataSource authenticationRemoteDataSource2, @NotNull LegacyTokenRemoteDataSource legacyTokenRemoteDataSource2, @NotNull LegacyTokenLocalDataSource legacyTokenLocalDataSource2, @NotNull UserLoggedIn userLoggedIn2) {
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSource2, "authenticationRemoteDataSource");
        Intrinsics.checkNotNullParameter(legacyTokenRemoteDataSource2, "legacyTokenRemoteDataSource");
        Intrinsics.checkNotNullParameter(legacyTokenLocalDataSource2, "legacyTokenLocalDataSource");
        Intrinsics.checkNotNullParameter(userLoggedIn2, "userLoggedIn");
        this.tokenRepository = tokenRepository2;
        this.authenticationRemoteDataSource = authenticationRemoteDataSource2;
        this.legacyTokenRemoteDataSource = legacyTokenRemoteDataSource2;
        this.legacyTokenLocalDataSource = legacyTokenLocalDataSource2;
        this.userLoggedIn = userLoggedIn2;
    }

    private final String asString(SocialAuthenticationRepository.Platform platform) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[platform.ordinal()];
        if (i11 == 1) {
            return AccessToken.DEFAULT_GRAPH_DOMAIN;
        }
        if (i11 == 2) {
            return Constants.REFERRER_API_GOOGLE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void clearTokenAndDeviceId() {
        this.tokenRepository.clearToken();
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-3  reason: not valid java name */
    public static final void m9508logout$lambda3(AuthenticationRepositoryImpl authenticationRepositoryImpl, Throwable th2) {
        Intrinsics.checkNotNullParameter(authenticationRepositoryImpl, "this$0");
        authenticationRepositoryImpl.clearTokenAndDeviceId();
    }

    /* access modifiers changed from: private */
    /* renamed from: logout$lambda-4  reason: not valid java name */
    public static final void m9509logout$lambda4(AuthenticationRepositoryImpl authenticationRepositoryImpl, LogoutResponse logoutResponse) {
        Intrinsics.checkNotNullParameter(authenticationRepositoryImpl, "this$0");
        authenticationRepositoryImpl.clearTokenAndDeviceId();
    }

    /* access modifiers changed from: private */
    public final void observeError(Throwable th2) {
        ObservabilityManager.trackUnExpectedScenario("AuthenticationRepositoryImplErrors", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorMessage", String.valueOf(th2.getMessage()))));
    }

    private final Single<TokenData> swapWithLegacyToken(TokenData tokenData) {
        Single<TokenData> create = Single.create(new a(tokenData, this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …        }\n        }\n    }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: swapWithLegacyToken$lambda-9  reason: not valid java name */
    public static final void m9510swapWithLegacyToken$lambda9(TokenData tokenData, AuthenticationRepositoryImpl authenticationRepositoryImpl, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(tokenData, "$tokenData");
        Intrinsics.checkNotNullParameter(authenticationRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        if (tokenData instanceof TokenData.Error) {
            singleEmitter.onSuccess(tokenData);
        } else if (tokenData instanceof TokenData.Valid) {
            TokenData.Valid valid = (TokenData.Valid) tokenData;
            singleEmitter.setDisposable(authenticationRepositoryImpl.legacyTokenRemoteDataSource.swapToLegacyToken(valid.getToken().getTokenType(), valid.getToken().getAccessToken()).doOnSuccess(new c(authenticationRepositoryImpl)).map(new d(tokenData)).subscribe(new e(singleEmitter), new f(singleEmitter)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: swapWithLegacyToken$lambda-9$lambda-7  reason: not valid java name */
    public static final void m9511swapWithLegacyToken$lambda9$lambda7(AuthenticationRepositoryImpl authenticationRepositoryImpl, SwapTokenData swapTokenData) {
        Intrinsics.checkNotNullParameter(authenticationRepositoryImpl, "this$0");
        authenticationRepositoryImpl.legacyTokenLocalDataSource.setSwapTokenData(swapTokenData);
        Function1<LegacyToken, Unit> onLegacyTokenReceived = AuthenticationIntegrator.INSTANCE.getOnLegacyTokenReceived();
        Intrinsics.checkNotNullExpressionValue(swapTokenData, "it");
        onLegacyTokenReceived.invoke(authenticationRepositoryImpl.toLegacyToken(swapTokenData));
    }

    /* access modifiers changed from: private */
    /* renamed from: swapWithLegacyToken$lambda-9$lambda-8  reason: not valid java name */
    public static final TokenData.Valid m9512swapWithLegacyToken$lambda9$lambda8(TokenData tokenData, SwapTokenData swapTokenData) {
        Intrinsics.checkNotNullParameter(tokenData, "$tokenData");
        Intrinsics.checkNotNullParameter(swapTokenData, "it");
        return TokenData.Valid.copy$default((TokenData.Valid) tokenData, (Token) null, (String) null, 3, (Object) null);
    }

    private final LegacyToken toLegacyToken(SwapTokenData swapTokenData) {
        return new LegacyToken(swapTokenData.getAccess_token(), swapTokenData.getExpires_in(), swapTokenData.getToken_type());
    }

    /* access modifiers changed from: private */
    public final PasswordAuthentication.Error toPasswordAuthenticationError(TokenData.Error error) {
        PasswordAuthentication.Error.Type type;
        String exceptionMessage = error.getExceptionMessage();
        String exceptionType = error.getExceptionType();
        if (Intrinsics.areEqual((Object) exceptionType, (Object) TokenData.Error.ExceptionType.OAUTH_FAILED_EXCEPTION.name())) {
            type = PasswordAuthentication.Error.Type.INVALID_CREDENTIALS;
        } else if (Intrinsics.areEqual((Object) exceptionType, (Object) TokenData.Error.ExceptionType.INVALID_EMAIL.name())) {
            type = PasswordAuthentication.Error.Type.INVALID_CREDENTIALS;
        } else if (Intrinsics.areEqual((Object) exceptionType, (Object) TokenData.Error.ExceptionType.SOCIAL_LOGIN_USER_NOT_FOUND.name())) {
            type = PasswordAuthentication.Error.Type.SOCIAL_LOGIN_USER_NOT_FOUND;
        } else {
            type = null;
        }
        return new PasswordAuthentication.Error(exceptionMessage, type);
    }

    @Nullable
    public Object authenticateWithPassword(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super PasswordAuthentication> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.authenticationRemoteDataSource.authenticateWithPassword(str, str2).doOnSuccess(new AuthenticationRepositoryImpl$authenticateWithPassword$2$1(this)).map(new AuthenticationRepositoryImpl$authenticateWithPassword$2$2(this)).doOnError(new b(this)).onErrorResumeNext(AuthenticationRepositoryImpl$authenticateWithPassword$2$4.INSTANCE).subscribe(new AuthenticationRepositoryImpl$authenticateWithPassword$2$5(safeContinuation), new AuthenticationRepositoryImpl$authenticateWithPassword$2$6(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticateWithSocialLogin(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository.Platform r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.authentication.authenticate.domain.model.PasswordAuthentication> r8) throws com.talabat.authentication.authenticate.domain.repository.PasswordAuthenticationException {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$authenticateWithSocialLogin$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$authenticateWithSocialLogin$1 r0 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$authenticateWithSocialLogin$1) r0
            int r1 = r0.f55411l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55411l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$authenticateWithSocialLogin$1 r0 = new com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$authenticateWithSocialLogin$1
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f55409j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55411l
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r5 = r0.f55408i
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl r5 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl) r5
            java.lang.Object r6 = r0.f55407h
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl r6 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl) r6
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0066
        L_0x0031:
            r5 = move-exception
            goto L_0x00a0
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x009e }
            com.talabat.authentication.token.domain.repository.TokenRepository r8 = r4.tokenRepository     // Catch:{ all -> 0x009e }
            com.talabat.authentication.token.domain.model.Token r8 = r8.getTokenOrNull()     // Catch:{ all -> 0x009e }
            if (r8 != 0) goto L_0x0051
            com.talabat.authentication.token.domain.repository.TokenRepository r8 = r4.tokenRepository     // Catch:{ all -> 0x009e }
            io.reactivex.Single r8 = r8.loginClient()     // Catch:{ all -> 0x009e }
            r8.blockingGet()     // Catch:{ all -> 0x009e }
        L_0x0051:
            com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource r8 = r4.authenticationRemoteDataSource     // Catch:{ all -> 0x009e }
            java.lang.String r6 = r4.asString(r6)     // Catch:{ all -> 0x009e }
            r0.f55407h = r4     // Catch:{ all -> 0x009e }
            r0.f55408i = r4     // Catch:{ all -> 0x009e }
            r0.f55411l = r3     // Catch:{ all -> 0x009e }
            java.lang.Object r8 = r8.authenticateWithSocialLogin(r5, r6, r7, r0)     // Catch:{ all -> 0x009e }
            if (r8 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r5 = r4
            r6 = r5
        L_0x0066:
            com.talabat.authentication.token.data.model.TokenData r8 = (com.talabat.authentication.token.data.model.TokenData) r8     // Catch:{ all -> 0x0031 }
            boolean r7 = r8 instanceof com.talabat.authentication.token.data.model.TokenData.Error     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x0073
            com.talabat.authentication.token.data.model.TokenData$Error r8 = (com.talabat.authentication.token.data.model.TokenData.Error) r8     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Error r5 = r5.toPasswordAuthenticationError(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0093
        L_0x0073:
            boolean r7 = r8 instanceof com.talabat.authentication.token.data.model.TokenData.Valid     // Catch:{ all -> 0x0031 }
            if (r7 == 0) goto L_0x0098
            com.talabat.authentication.token.domain.repository.TokenRepository r7 = r5.tokenRepository     // Catch:{ all -> 0x0031 }
            r0 = r8
            com.talabat.authentication.token.data.model.TokenData$Valid r0 = (com.talabat.authentication.token.data.model.TokenData.Valid) r0     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.token.domain.model.Token r0 = r0.getToken()     // Catch:{ all -> 0x0031 }
            r1 = r8
            com.talabat.authentication.token.data.model.TokenData$Valid r1 = (com.talabat.authentication.token.data.model.TokenData.Valid) r1     // Catch:{ all -> 0x0031 }
            java.lang.String r1 = r1.getDeviceToken()     // Catch:{ all -> 0x0031 }
            r7.saveToken(r0, r1)     // Catch:{ all -> 0x0031 }
            io.reactivex.Single r5 = r5.swapWithLegacyToken(r8)     // Catch:{ all -> 0x0031 }
            r5.blockingGet()     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.authenticate.domain.model.PasswordAuthentication$Success r5 = com.talabat.authentication.authenticate.domain.model.PasswordAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0031 }
        L_0x0093:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0031 }
            goto L_0x00aa
        L_0x0098:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0031 }
            r5.<init>()     // Catch:{ all -> 0x0031 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x009e:
            r5 = move-exception
            r6 = r4
        L_0x00a0:
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x00aa:
            java.lang.Throwable r7 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r7 != 0) goto L_0x00b1
            return r5
        L_0x00b1:
            r6.observeError(r7)
            com.talabat.authentication.authenticate.domain.repository.PasswordAuthenticationException r5 = new com.talabat.authentication.authenticate.domain.repository.PasswordAuthenticationException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl.authenticateWithSocialLogin(java.lang.String, com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository$Platform, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean isUserLoggedIn() {
        return this.userLoggedIn.invoke();
    }

    @NotNull
    public Single<LogoutResponse> logout() {
        Single<LogoutResponse> doOnSuccess = this.authenticationRemoteDataSource.logout().doOnError(new g(this)).doOnSuccess(new h(this));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "authenticationRemoteData…clearTokenAndDeviceId() }");
        return doOnSuccess;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object migrationExchangeToken(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication> r5) throws com.talabat.authentication.authenticate.domain.repository.MigrationExchangeTokenAuthenticationException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$migrationExchangeToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$migrationExchangeToken$1 r0 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$migrationExchangeToken$1) r0
            int r1 = r0.f55416l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55416l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$migrationExchangeToken$1 r0 = new com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl$migrationExchangeToken$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f55414j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55416l
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r1 = r0.f55413i
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl r1 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl) r1
            java.lang.Object r0 = r0.f55412h
            com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl r0 = (com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0031 }
            goto L_0x0051
        L_0x0031:
            r5 = move-exception
            goto L_0x0097
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0095 }
            com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSource r5 = r4.authenticationRemoteDataSource     // Catch:{ all -> 0x0095 }
            r0.f55412h = r4     // Catch:{ all -> 0x0095 }
            r0.f55413i = r4     // Catch:{ all -> 0x0095 }
            r0.f55416l = r3     // Catch:{ all -> 0x0095 }
            java.lang.Object r5 = r5.migrationExchangeToken(r0)     // Catch:{ all -> 0x0095 }
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
            r1 = r0
        L_0x0051:
            com.talabat.authentication.token.data.model.TokenData r5 = (com.talabat.authentication.token.data.model.TokenData) r5     // Catch:{ all -> 0x0031 }
            boolean r2 = r5 instanceof com.talabat.authentication.token.data.model.TokenData.Error     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x0072
            r1 = r5
            com.talabat.authentication.token.data.model.TokenData$Error r1 = (com.talabat.authentication.token.data.model.TokenData.Error) r1     // Catch:{ all -> 0x0031 }
            int r1 = r1.getStatusCode()     // Catch:{ all -> 0x0031 }
            r2 = 404(0x194, float:5.66E-43)
            if (r1 != r2) goto L_0x0065
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error404 r5 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Error404.INSTANCE     // Catch:{ all -> 0x0031 }
            goto L_0x008a
        L_0x0065:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error r1 = new com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.token.data.model.TokenData$Error r5 = (com.talabat.authentication.token.data.model.TokenData.Error) r5     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.getExceptionMessage()     // Catch:{ all -> 0x0031 }
            r1.<init>(r5)     // Catch:{ all -> 0x0031 }
            r5 = r1
            goto L_0x008a
        L_0x0072:
            boolean r2 = r5 instanceof com.talabat.authentication.token.data.model.TokenData.Valid     // Catch:{ all -> 0x0031 }
            if (r2 == 0) goto L_0x008f
            com.talabat.authentication.token.domain.repository.TokenRepository r1 = r1.tokenRepository     // Catch:{ all -> 0x0031 }
            r2 = r5
            com.talabat.authentication.token.data.model.TokenData$Valid r2 = (com.talabat.authentication.token.data.model.TokenData.Valid) r2     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.token.domain.model.Token r2 = r2.getToken()     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.token.data.model.TokenData$Valid r5 = (com.talabat.authentication.token.data.model.TokenData.Valid) r5     // Catch:{ all -> 0x0031 }
            java.lang.String r5 = r5.getDeviceToken()     // Catch:{ all -> 0x0031 }
            r1.saveToken(r2, r5)     // Catch:{ all -> 0x0031 }
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r5 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE     // Catch:{ all -> 0x0031 }
        L_0x008a:
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0031 }
            goto L_0x00a1
        L_0x008f:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0031 }
            r5.<init>()     // Catch:{ all -> 0x0031 }
            throw r5     // Catch:{ all -> 0x0031 }
        L_0x0095:
            r5 = move-exception
            r0 = r4
        L_0x0097:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x00a1:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r1 != 0) goto L_0x00a8
            return r5
        L_0x00a8:
            r0.observeError(r1)
            com.talabat.authentication.authenticate.domain.repository.MigrationExchangeTokenAuthenticationException r5 = new com.talabat.authentication.authenticate.domain.repository.MigrationExchangeTokenAuthenticationException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl.migrationExchangeToken(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
