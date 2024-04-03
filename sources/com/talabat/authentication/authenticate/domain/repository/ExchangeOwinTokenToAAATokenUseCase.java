package com.talabat.authentication.authenticate.domain.repository;

import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0003%&'BK\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J\u0019\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J%\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HBø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase;", "", "clearOwinUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "migrationExchangeObservabilityUseCase", "Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "enableFeatureFlag", "Lcom/talabat/core/fwfprojectskeys/domain/projects/user/UserFeatureFlagsKeys;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "isGdmTokenAvailable", "Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$IsGdmOwinAvailable;", "(Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;Lcom/talabat/core/fwfprojectskeys/domain/projects/user/UserFeatureFlagsKeys;Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$IsGdmOwinAvailable;)V", "call", "", "flowName", "", "jwtExchangeCallback", "Lcom/talabat/authentication/authenticate/domain/repository/JwtExchangeCallback;", "clearOwin", "forceClean", "", "exchange", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "featureFlagEnable", "invoke", "(Ljava/lang/String;Lcom/talabat/authentication/authenticate/domain/repository/JwtExchangeCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrationExchangeToken", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldClearOwinTokenOnExchange404", "Companion", "IsGdmOwinAvailable", "TokenExchangeException", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExchangeOwinTokenToAAATokenUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EXCHANGE_FLOW_APP_LAUNCH = "login_app_launch";
    @NotNull
    public static final String EXCHANGE_FLOW_LOGIN_EMAIL = "email_login";
    @NotNull
    public static final String EXCHANGE_FLOW_LOGIN_MOBILE = "mobile_login";
    @NotNull
    public static final String EXCHANGE_FLOW_LOGIN_SOCIAL = "social_login";
    @NotNull
    public static final String EXCHANGE_FLOW_REGISTRATION_EMAIL = "email_registration";
    @NotNull
    public static final String EXCHANGE_FLOW_REGISTRATION_MOBILE = "mobile_registration";
    @NotNull
    private final AuthenticationRepository authenticationRepository;
    @Nullable
    private final ClearOwinUseCase clearOwinUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatchersFactory dispatchersFactory;
    @NotNull
    private final UserFeatureFlagsKeys enableFeatureFlag;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;
    @NotNull
    private final IsGdmOwinAvailable isGdmTokenAvailable;
    @NotNull
    private final MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase;
    @NotNull
    private final TokenRepository tokenRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$Companion;", "", "()V", "EXCHANGE_FLOW_APP_LAUNCH", "", "EXCHANGE_FLOW_LOGIN_EMAIL", "EXCHANGE_FLOW_LOGIN_MOBILE", "EXCHANGE_FLOW_LOGIN_SOCIAL", "EXCHANGE_FLOW_REGISTRATION_EMAIL", "EXCHANGE_FLOW_REGISTRATION_MOBILE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$IsGdmOwinAvailable;", "", "isGdmOwinAvailable", "", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IsGdmOwinAvailable {
        boolean isGdmOwinAvailable();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase$TokenExchangeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "s", "", "(Ljava/lang/String;)V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TokenExchangeException extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TokenExchangeException(@NotNull String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "s");
        }
    }

    @Inject
    public ExchangeOwinTokenToAAATokenUseCase(@Nullable ClearOwinUseCase clearOwinUseCase2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull AuthenticationRepository authenticationRepository2, @NotNull MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase2, @NotNull UserFeatureFlagsKeys userFeatureFlagsKeys, @NotNull TokenRepository tokenRepository2, @NotNull IsGdmOwinAvailable isGdmOwinAvailable) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(authenticationRepository2, "authenticationRepository");
        Intrinsics.checkNotNullParameter(migrationExchangeObservabilityUseCase2, "migrationExchangeObservabilityUseCase");
        Intrinsics.checkNotNullParameter(userFeatureFlagsKeys, "enableFeatureFlag");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(isGdmOwinAvailable, "isGdmTokenAvailable");
        this.clearOwinUseCase = clearOwinUseCase2;
        this.dispatchersFactory = coroutineDispatchersFactory;
        this.featureFlag = iTalabatFeatureFlag;
        this.authenticationRepository = authenticationRepository2;
        this.migrationExchangeObservabilityUseCase = migrationExchangeObservabilityUseCase2;
        this.enableFeatureFlag = userFeatureFlagsKeys;
        this.tokenRepository = tokenRepository2;
        this.isGdmTokenAvailable = isGdmOwinAvailable;
    }

    private final void clearOwin(boolean z11) throws TokenExchangeException {
        boolean z12;
        ClearOwinUseCase clearOwinUseCase2 = this.clearOwinUseCase;
        if (clearOwinUseCase2 != null) {
            z12 = clearOwinUseCase2.invoke(z11);
        } else {
            z12 = false;
        }
        if (z12) {
            this.migrationExchangeObservabilityUseCase.onOwinCleared();
            if (this.tokenRepository.getTokenOrNull() == null) {
                throw new TokenExchangeException("No tokens left");
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object exchange(java.lang.String r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase.TokenExchangeException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$exchange$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$exchange$1 r0 = (com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$exchange$1) r0
            int r1 = r0.f55433l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55433l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$exchange$1 r0 = new com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$exchange$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f55431j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55433l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r8 = r0.f55430i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r0.f55429h
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r0 = (com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0090
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            java.lang.Object r8 = r0.f55430i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f55429h
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r2 = (com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$IsGdmOwinAvailable r9 = r7.isGdmTokenAvailable
            boolean r9 = r9.isGdmOwinAvailable()
            if (r9 == 0) goto L_0x00dc
            boolean r9 = r7.featureFlagEnable()
            if (r9 == 0) goto L_0x00dc
            r0.f55429h = r7
            r0.f55430i = r8
            r0.f55433l = r4
            java.lang.Object r9 = r7.migrationExchangeToken(r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r7
        L_0x0067:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication r9 = (com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication) r9
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r5 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x00b1
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r5 = r2.migrationExchangeObservabilityUseCase
            java.lang.String r6 = r9.toString()
            r5.onFirstCallFailure(r6)
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error404 r5 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Error404.INSTANCE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x00ab
            r0.f55429h = r2
            r0.f55430i = r8
            r0.f55433l = r3
            java.lang.Object r9 = r2.migrationExchangeToken(r0)
            if (r9 != r1) goto L_0x008f
            return r1
        L_0x008f:
            r0 = r2
        L_0x0090:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication r9 = (com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication) r9
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r1 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x00a4
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r1 = r0.migrationExchangeObservabilityUseCase
            java.lang.String r2 = r9.toString()
            r1.onSecondCallFailure(r2)
            goto L_0x00a9
        L_0x00a4:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r1 = r0.migrationExchangeObservabilityUseCase
            r1.onSecondCallSuccess()
        L_0x00a9:
            r2 = r0
            goto L_0x00b6
        L_0x00ab:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r0 = r2.migrationExchangeObservabilityUseCase
            r0.onSignedOutOnExchange404()
            goto L_0x00b6
        L_0x00b1:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r0 = r2.migrationExchangeObservabilityUseCase
            r0.onFirstCallSuccess()
        L_0x00b6:
            com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase r0 = r2.migrationExchangeObservabilityUseCase
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Success r1 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Success.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r1)
            r0.onExchangeDone(r8, r1)
            boolean r0 = r2.shouldClearOwinTokenOnExchange404()
            if (r0 == 0) goto L_0x00d8
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error404 r0 = com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication.Error404.INSTANCE
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r0)
            if (r9 == 0) goto L_0x00d8
            java.lang.String r9 = "login_app_launch"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r4 = 0
        L_0x00d9:
            r2.clearOwin(r4)
        L_0x00dc:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase.exchange(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean featureFlagEnable() {
        return this.featureFlag.getFeatureFlag(this.enableFeatureFlag, false);
    }

    public static /* synthetic */ Object invoke$default(ExchangeOwinTokenToAAATokenUseCase exchangeOwinTokenToAAATokenUseCase, String str, JwtExchangeCallback jwtExchangeCallback, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            jwtExchangeCallback = null;
        }
        return exchangeOwinTokenToAAATokenUseCase.invoke(str, jwtExchangeCallback, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object migrationExchangeToken(kotlin.coroutines.Continuation<? super com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1 r0 = (com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1) r0
            int r1 = r0.f55445j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f55445j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1 r0 = new com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase$migrationExchangeToken$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f55443h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f55445j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0041
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0048 }
            com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository r5 = r4.authenticationRepository     // Catch:{ all -> 0x0048 }
            r0.f55445j = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = r5.migrationExchangeToken(r0)     // Catch:{ all -> 0x0048 }
            if (r5 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication r5 = (com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication) r5     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)     // Catch:{ all -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m6329constructorimpl(r5)
        L_0x0053:
            java.lang.Throwable r0 = kotlin.Result.m6332exceptionOrNullimpl(r5)
            if (r0 != 0) goto L_0x005a
            goto L_0x0067
        L_0x005a:
            com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error r5 = new com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication$Error
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0064
            java.lang.String r0 = ""
        L_0x0064:
            r5.<init>(r0)
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase.migrationExchangeToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean shouldClearOwinTokenOnExchange404() {
        return this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_CLEAR_OWIN_ON_EXCHANGE_404_ERROR, true);
    }

    public final void call(@NotNull String str, @NotNull JwtExchangeCallback jwtExchangeCallback) {
        Intrinsics.checkNotNullParameter(str, "flowName");
        Intrinsics.checkNotNullParameter(jwtExchangeCallback, "jwtExchangeCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new ExchangeOwinTokenToAAATokenUseCase$call$1(this, str, jwtExchangeCallback, (Continuation<? super ExchangeOwinTokenToAAATokenUseCase$call$1>) null), 3, (Object) null);
    }

    @Nullable
    public final Object invoke(@NotNull String str, @Nullable JwtExchangeCallback jwtExchangeCallback, @NotNull Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatchersFactory.io(), new ExchangeOwinTokenToAAATokenUseCase$invoke$2(this, str, jwtExchangeCallback, (Continuation<? super ExchangeOwinTokenToAAATokenUseCase$invoke$2>) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExchangeOwinTokenToAAATokenUseCase(ClearOwinUseCase clearOwinUseCase2, CoroutineDispatchersFactory coroutineDispatchersFactory, ITalabatFeatureFlag iTalabatFeatureFlag, AuthenticationRepository authenticationRepository2, MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase2, UserFeatureFlagsKeys userFeatureFlagsKeys, TokenRepository tokenRepository2, IsGdmOwinAvailable isGdmOwinAvailable, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : clearOwinUseCase2, coroutineDispatchersFactory, iTalabatFeatureFlag, authenticationRepository2, migrationExchangeObservabilityUseCase2, userFeatureFlagsKeys, tokenRepository2, isGdmOwinAvailable);
    }
}
