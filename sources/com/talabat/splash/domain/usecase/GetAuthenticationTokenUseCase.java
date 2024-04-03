package com.talabat.splash.domain.usecase;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.authentication.authenticate.domain.repository.AuthenticationRepository;
import com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.authentication.usecase.MigrationExchangeObservabilityUseCase;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import com.talabat.helpers.GlobalDataModel;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0011\u0010\u001b\u001a\u00020\u001cHBø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/talabat/splash/domain/usecase/GetAuthenticationTokenUseCase;", "", "context", "Landroid/content/Context;", "customer", "Lbuisnessmodels/Customer;", "clearOwinUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "dispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "authenticationRepository", "Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "migrationExchangeObservabilityUseCase", "Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "(Landroid/content/Context;Lbuisnessmodels/Customer;Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;Lcom/talabat/authentication/token/domain/repository/TokenRepository;)V", "exchangeOwinTokenToAAATokenUseCase", "Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase;", "getExchangeOwinTokenToAAATokenUseCase", "()Lcom/talabat/authentication/authenticate/domain/repository/ExchangeOwinTokenToAAATokenUseCase;", "exchangeOwinTokenToAAATokenUseCase$delegate", "Lkotlin/Lazy;", "clearOwin", "", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jwtTokenNotPresent", "owinTokenPresent", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetAuthenticationTokenUseCase {
    /* access modifiers changed from: private */
    @NotNull
    public final AuthenticationRepository authenticationRepository;
    @NotNull
    private final ClearOwinUseCase clearOwinUseCase;
    @NotNull
    private final Context context;
    @NotNull
    private final Customer customer;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatchersFactory dispatchersFactory;
    @NotNull
    private final Lazy exchangeOwinTokenToAAATokenUseCase$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new GetAuthenticationTokenUseCase$exchangeOwinTokenToAAATokenUseCase$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final ITalabatFeatureFlag featureFlag;
    /* access modifiers changed from: private */
    @NotNull
    public final MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenRepository tokenRepository;

    @Inject
    public GetAuthenticationTokenUseCase(@NotNull Context context2, @NotNull Customer customer2, @NotNull ClearOwinUseCase clearOwinUseCase2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull AuthenticationRepository authenticationRepository2, @NotNull MigrationExchangeObservabilityUseCase migrationExchangeObservabilityUseCase2, @NotNull TokenRepository tokenRepository2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        Intrinsics.checkNotNullParameter(clearOwinUseCase2, "clearOwinUseCase");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory, "dispatchersFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        Intrinsics.checkNotNullParameter(authenticationRepository2, "authenticationRepository");
        Intrinsics.checkNotNullParameter(migrationExchangeObservabilityUseCase2, "migrationExchangeObservabilityUseCase");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        this.context = context2;
        this.customer = customer2;
        this.clearOwinUseCase = clearOwinUseCase2;
        this.dispatchersFactory = coroutineDispatchersFactory;
        this.featureFlag = iTalabatFeatureFlag;
        this.authenticationRepository = authenticationRepository2;
        this.migrationExchangeObservabilityUseCase = migrationExchangeObservabilityUseCase2;
        this.tokenRepository = tokenRepository2;
    }

    private final void clearOwin() {
        boolean z11;
        boolean booleanValue = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.isTokenAvailable().invoke().booleanValue();
        if (GlobalDataModel.token != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(UserFeatureFlagsKeys.FF_USER_STOP_USING_OWIN_TOKEN, false);
        if (!booleanValue || !z11 || !featureFlag2) {
            this.migrationExchangeObservabilityUseCase.trackOwinStillAwailable(booleanValue, featureFlag2);
        } else {
            ClearOwinUseCase.DefaultImpls.invoke$default(this.clearOwinUseCase, false, 1, (Object) null);
        }
    }

    private final ExchangeOwinTokenToAAATokenUseCase getExchangeOwinTokenToAAATokenUseCase() {
        return (ExchangeOwinTokenToAAATokenUseCase) this.exchangeOwinTokenToAAATokenUseCase$delegate.getValue();
    }

    private final boolean jwtTokenNotPresent() {
        return !TalabatNetworkModuleJWTTokenIntegrator.INSTANCE.isTokenAvailable().invoke().booleanValue();
    }

    private final boolean owinTokenPresent() {
        return this.customer.isLoggedIn(this.context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase$invoke$1 r0 = (com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase$invoke$1) r0
            int r1 = r0.f61492k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61492k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase$invoke$1 r0 = new com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase$invoke$1
            r0.<init>(r7, r8)
        L_0x0018:
            r4 = r0
            java.lang.Object r8 = r4.f61490i
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f61492k
            r2 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            java.lang.Object r0 = r4.f61489h
            com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase r0 = (com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005b
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r7.owinTokenPresent()
            if (r8 == 0) goto L_0x0064
            boolean r8 = r7.jwtTokenNotPresent()
            if (r8 == 0) goto L_0x0064
            com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase r1 = r7.getExchangeOwinTokenToAAATokenUseCase()
            java.lang.String r8 = "login_app_launch"
            r3 = 0
            r5 = 2
            r6 = 0
            r4.f61489h = r7
            r4.f61492k = r2
            r2 = r8
            java.lang.Object r8 = com.talabat.authentication.authenticate.domain.repository.ExchangeOwinTokenToAAATokenUseCase.invoke$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x005a
            return r0
        L_0x005a:
            r0 = r7
        L_0x005b:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r2 = r8.booleanValue()
            r0.clearOwin()
        L_0x0064:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
