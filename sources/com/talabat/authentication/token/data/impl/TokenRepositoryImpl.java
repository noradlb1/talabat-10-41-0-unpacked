package com.talabat.authentication.token.data.impl;

import com.talabat.authentication.authenticate.domain.repository.TokenExchangeRetriesRepository;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.local.TokenLocalDataSource;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.authentication.token.data.model.SwapTokenData;
import com.talabat.authentication.token.data.model.TokenData;
import com.talabat.authentication.token.data.remote.TokenRemoteDataSource;
import com.talabat.authentication.token.domain.DeviceTokenNotFoundException;
import com.talabat.authentication.token.domain.LegacyTokenNotFoundException;
import com.talabat.authentication.token.domain.LoginClientException;
import com.talabat.authentication.token.domain.TokenNotFoundException;
import com.talabat.authentication.token.domain.model.LegacyToken;
import com.talabat.authentication.token.domain.model.Token;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nf.a;
import nf.b;
import nf.c;
import nf.d;
import nf.e;
import nf.f;
import nf.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010 \u001a\u0004\u0018\u00010\u0012H\u0002J\n\u0010!\u001a\u0004\u0018\u00010\u0016H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160$H\u0016J\u001c\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002J\u0018\u0010)\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/talabat/authentication/token/data/impl/TokenRepositoryImpl;", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "legacyTokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "tokenRemoteDataSource", "Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "tokenLocalDataSource", "Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;", "tokenExchangeRetriesRepository", "Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;Lcom/talabat/authentication/token/data/local/TokenLocalDataSource;Lcom/talabat/authentication/authenticate/domain/repository/TokenExchangeRetriesRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "deviceToken", "", "getDeviceToken", "()Ljava/lang/String;", "legacyToken", "Lcom/talabat/authentication/token/domain/model/LegacyToken;", "getLegacyToken", "()Lcom/talabat/authentication/token/domain/model/LegacyToken;", "token", "Lcom/talabat/authentication/token/domain/model/Token;", "getToken", "()Lcom/talabat/authentication/token/domain/model/Token;", "cleanLegacyToken", "", "cleanToken", "clearLegacyToken", "clearToken", "clearTokens", "getDeviceTokenLocally", "getLegacyTokenStoredLocally", "getTokenOrNull", "getTokenStoredLocally", "loginClient", "Lio/reactivex/Single;", "observeError", "throwable", "", "extraError", "saveToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenRepositoryImpl implements TokenRepository {
    @NotNull
    private final LegacyTokenLocalDataSource legacyTokenLocalDataSource;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final TokenExchangeRetriesRepository tokenExchangeRetriesRepository;
    @NotNull
    private final TokenLocalDataSource tokenLocalDataSource;
    @NotNull
    private final TokenRemoteDataSource tokenRemoteDataSource;

    @Inject
    public TokenRepositoryImpl(@NotNull LegacyTokenLocalDataSource legacyTokenLocalDataSource2, @NotNull TokenRemoteDataSource tokenRemoteDataSource2, @NotNull TokenLocalDataSource tokenLocalDataSource2, @NotNull TokenExchangeRetriesRepository tokenExchangeRetriesRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(legacyTokenLocalDataSource2, "legacyTokenLocalDataSource");
        Intrinsics.checkNotNullParameter(tokenRemoteDataSource2, "tokenRemoteDataSource");
        Intrinsics.checkNotNullParameter(tokenLocalDataSource2, "tokenLocalDataSource");
        Intrinsics.checkNotNullParameter(tokenExchangeRetriesRepository2, "tokenExchangeRetriesRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.legacyTokenLocalDataSource = legacyTokenLocalDataSource2;
        this.tokenRemoteDataSource = tokenRemoteDataSource2;
        this.tokenLocalDataSource = tokenLocalDataSource2;
        this.tokenExchangeRetriesRepository = tokenExchangeRetriesRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    private final void cleanLegacyToken() {
        this.legacyTokenLocalDataSource.setSwapTokenData((SwapTokenData) null);
    }

    private final void cleanToken() {
        this.tokenLocalDataSource.clearToken();
    }

    public static /* synthetic */ void g(TokenRepositoryImpl tokenRepositoryImpl, Throwable th2, Throwable th3, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th3 = null;
        }
        tokenRepositoryImpl.observeError(th2, th3);
    }

    private final String getDeviceTokenLocally() {
        return this.tokenLocalDataSource.getDeviceToken();
    }

    private final LegacyToken getLegacyTokenStoredLocally() {
        SwapTokenData swapTokenData = this.legacyTokenLocalDataSource.getSwapTokenData();
        if (swapTokenData != null) {
            return new LegacyToken(swapTokenData.getAccess_token(), swapTokenData.getExpires_in(), swapTokenData.getToken_type());
        }
        return null;
    }

    private final Token getTokenStoredLocally() {
        return this.tokenLocalDataSource.getToken();
    }

    /* access modifiers changed from: private */
    /* renamed from: loginClient$lambda-16  reason: not valid java name */
    public static final void m9520loginClient$lambda16(TokenRepositoryImpl tokenRepositoryImpl, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(tokenRepositoryImpl, "this$0");
        Intrinsics.checkNotNullParameter(singleEmitter, "emitter");
        singleEmitter.setDisposable(tokenRepositoryImpl.tokenRemoteDataSource.fetchClientTokenData().doOnSuccess(new a(tokenRepositoryImpl)).map(new b()).doOnSubscribe(new c(tokenRepositoryImpl)).doOnError(new d(tokenRepositoryImpl)).onErrorResumeNext(new e()).subscribe(new f(singleEmitter), new p005if.f(singleEmitter)));
    }

    /* access modifiers changed from: private */
    /* renamed from: loginClient$lambda-16$lambda-12  reason: not valid java name */
    public static final void m9521loginClient$lambda16$lambda12(TokenRepositoryImpl tokenRepositoryImpl, TokenData tokenData) {
        Intrinsics.checkNotNullParameter(tokenRepositoryImpl, "this$0");
        if (tokenData instanceof TokenData.Valid) {
            TokenData.Valid valid = (TokenData.Valid) tokenData;
            tokenRepositoryImpl.saveToken(valid.getToken(), valid.getDeviceToken());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loginClient$lambda-16$lambda-13  reason: not valid java name */
    public static final Token m9522loginClient$lambda16$lambda13(TokenData tokenData) {
        Intrinsics.checkNotNullParameter(tokenData, "it");
        if (tokenData instanceof TokenData.Error) {
            throw new LoginClientException(((TokenData.Error) tokenData).getExceptionMessage(), (Throwable) null, 2, (DefaultConstructorMarker) null);
        } else if (tokenData instanceof TokenData.Valid) {
            return ((TokenData.Valid) tokenData).getToken();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: loginClient$lambda-16$lambda-14  reason: not valid java name */
    public static final void m9523loginClient$lambda16$lambda14(TokenRepositoryImpl tokenRepositoryImpl, Disposable disposable) {
        Intrinsics.checkNotNullParameter(tokenRepositoryImpl, "this$0");
        tokenRepositoryImpl.cleanToken();
    }

    /* access modifiers changed from: private */
    /* renamed from: loginClient$lambda-16$lambda-15  reason: not valid java name */
    public static final SingleSource m9524loginClient$lambda16$lambda15(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.error((Throwable) new LoginClientException((String) null, th2, 1, (DefaultConstructorMarker) null));
    }

    private final void observeError(Throwable th2, Throwable th3) {
        String str;
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        Pair[] pairArr = new Pair[3];
        String message = th2.getMessage();
        String str2 = "";
        if (message == null) {
            message = str2;
        }
        pairArr[0] = TuplesKt.to("errorMessage", message);
        String str3 = null;
        if (th3 != null) {
            str = th3.getClass().getCanonicalName();
        } else {
            str = null;
        }
        if (str == null) {
            str = str2;
        }
        pairArr[1] = TuplesKt.to("extraErrorType", str);
        if (th3 != null) {
            str3 = th3.getMessage();
        }
        if (str3 != null) {
            str2 = str3;
        }
        pairArr[2] = TuplesKt.to("extraErrorMessage", str2);
        iObservabilityManager.trackUnExpectedScenario("TokenRepositoryImplErrors", MapsKt__MapsKt.mapOf(pairArr));
    }

    public void clearLegacyToken() {
        cleanLegacyToken();
    }

    public void clearToken() {
        cleanToken();
    }

    public void clearTokens() {
        cleanToken();
        cleanLegacyToken();
        this.tokenExchangeRetriesRepository.clear();
    }

    @NotNull
    public String getDeviceToken() throws DeviceTokenNotFoundException {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(getDeviceTokenLocally());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 == null) {
            String str = (String) obj;
            if (str != null) {
                return str;
            }
            DeviceTokenNotFoundException deviceTokenNotFoundException = new DeviceTokenNotFoundException("DeviceToken not found, should be new device", (Throwable) null, 2, (DefaultConstructorMarker) null);
            g(this, deviceTokenNotFoundException, (Throwable) null, 2, (Object) null);
            throw deviceTokenNotFoundException;
        }
        DeviceTokenNotFoundException deviceTokenNotFoundException2 = new DeviceTokenNotFoundException("DeviceToken not found, should be new device :: " + r12, r12);
        observeError(deviceTokenNotFoundException2, r12);
        throw deviceTokenNotFoundException2;
    }

    @NotNull
    public LegacyToken getLegacyToken() throws LegacyTokenNotFoundException {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(getLegacyTokenStoredLocally());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 == null) {
            LegacyToken legacyToken = (LegacyToken) obj;
            if (legacyToken != null) {
                return legacyToken;
            }
            LegacyTokenNotFoundException legacyTokenNotFoundException = new LegacyTokenNotFoundException("Legacy token not available locally", (Throwable) null, 2, (DefaultConstructorMarker) null);
            g(this, legacyTokenNotFoundException, (Throwable) null, 2, (Object) null);
            throw legacyTokenNotFoundException;
        }
        LegacyTokenNotFoundException legacyTokenNotFoundException2 = new LegacyTokenNotFoundException("Legacy token not available locally :: " + r12, r12);
        observeError(legacyTokenNotFoundException2, r12);
        throw legacyTokenNotFoundException2;
    }

    @NotNull
    public Token getToken() throws TokenNotFoundException {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(getTokenStoredLocally());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (r12 == null) {
            Token token = (Token) obj;
            if (token != null) {
                return token;
            }
            TokenNotFoundException tokenNotFoundException = new TokenNotFoundException("Token not available locally", (Throwable) null, 2, (DefaultConstructorMarker) null);
            g(this, tokenNotFoundException, (Throwable) null, 2, (Object) null);
            throw tokenNotFoundException;
        }
        TokenNotFoundException tokenNotFoundException2 = new TokenNotFoundException("Token not available locally :: " + r12, r12);
        observeError(tokenNotFoundException2, r12);
        throw tokenNotFoundException2;
    }

    @Nullable
    public Token getTokenOrNull() {
        return getTokenStoredLocally();
    }

    @NotNull
    public Single<Token> loginClient() {
        Single<Token> create = Single.create(new g(this));
        Intrinsics.checkNotNullExpressionValue(create, "create { emitter ->\n    …ter::setDisposable)\n    }");
        return create;
    }

    public void saveToken(@NotNull Token token, @NotNull String str) {
        Intrinsics.checkNotNullParameter(token, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str, "deviceToken");
        this.tokenLocalDataSource.setToken(token, str);
    }
}
