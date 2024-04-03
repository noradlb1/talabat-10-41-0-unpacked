package com.talabat.authentication.usecase;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.AuthenticationStatus;
import com.talabat.core.observabilityNew.domain.common.EventType;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\tJ\u0016\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "commonAttributes", "", "", "onExchangeDone", "", "flowName", "succeed", "", "onFirstCallFailure", "result", "onFirstCallSuccess", "onOwinCleared", "onSecondCallFailure", "onSecondCallSuccess", "onSignedOutOnExchange404", "trackOwinStillAwailable", "jwtTokenAvailable", "clearOwinFlagEnabled", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MigrationExchangeObservabilityUseCase {
    @NotNull
    public static final String API_RESPONSE = "apiResponse";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ERROR_DETAIL = "errorDetail";
    @NotNull
    public static final String EXCHANGE_TOKEN_OWIN_TO_AAA = "exchange_token_owin_to_aaa";
    @NotNull
    public static final String ON_EXCHANGE_TOKEN_OWIN_JWT = "on_exchange_token_owin_jwt";
    @NotNull
    public static final String OWIN = "owin";
    @NotNull
    public static final String RETRY_COUNT = "retryCount";
    @NotNull
    public static final String STATE_TYPE = "stateType";
    @NotNull
    private static final String STATE_TYPE_EXCHANGE = "exchange_token";
    @NotNull
    public static final String TOKEN_TYPE = "tokenType";
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/authentication/usecase/MigrationExchangeObservabilityUseCase$Companion;", "", "()V", "API_RESPONSE", "", "ERROR_DETAIL", "EXCHANGE_TOKEN_OWIN_TO_AAA", "ON_EXCHANGE_TOKEN_OWIN_JWT", "OWIN", "RETRY_COUNT", "STATE_TYPE", "STATE_TYPE_EXCHANGE", "TOKEN_TYPE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public MigrationExchangeObservabilityUseCase(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    private final Map<? extends String, String> commonAttributes() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tokenType", "owin"));
    }

    public final void onExchangeDone(@NotNull String str, boolean z11) {
        AuthenticationStatus authenticationStatus;
        Intrinsics.checkNotNullParameter(str, "flowName");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (z11) {
            authenticationStatus = AuthenticationStatus.Success;
        } else {
            authenticationStatus = AuthenticationStatus.Failure;
        }
        AuthenticationStatus authenticationStatus2 = authenticationStatus;
        IObservabilityManager.DefaultImpls.trackAuthenticationEvents$default(iObservabilityManager, authenticationStatus2, "exchange_token_owin_to_aaa_" + str, (Map) null, 4, (Object) null);
    }

    public final void onFirstCallFailure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", "1"), TuplesKt.to("stateType", ON_EXCHANGE_TOKEN_OWIN_JWT));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, ON_EXCHANGE_TOKEN_OWIN_JWT, mutableMapOf);
    }

    public final void onFirstCallSuccess() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Success;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("retryCount", "1"), TuplesKt.to("stateType", ON_EXCHANGE_TOKEN_OWIN_JWT));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, ON_EXCHANGE_TOKEN_OWIN_JWT, mutableMapOf);
    }

    public final void onOwinCleared() {
        this.observabilityManager.trackEvent("clear_owin", EventType.AuthEvent.name(), (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("stateType", STATE_TYPE_EXCHANGE)));
    }

    public final void onSecondCallFailure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to("stateType", ON_EXCHANGE_TOKEN_OWIN_JWT));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, ON_EXCHANGE_TOKEN_OWIN_JWT, mutableMapOf);
    }

    public final void onSecondCallSuccess() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Success;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("retryCount", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to("stateType", ON_EXCHANGE_TOKEN_OWIN_JWT));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, ON_EXCHANGE_TOKEN_OWIN_JWT, mutableMapOf);
    }

    public final void onSignedOutOnExchange404() {
        this.observabilityManager.trackEvent("user_force_signed_out_exchange_404", EventType.AuthEvent.name(), (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("source", "android"), TuplesKt.to("stateType", "Android"), TuplesKt.to("tokenType", "owin")));
    }

    public final void trackOwinStillAwailable(boolean z11, boolean z12) {
        this.observabilityManager.trackEvent("owin_available", EventType.AuthEvent.name(), (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("isJwtExist", String.valueOf(z11)), TuplesKt.to("stopUsingOwin", String.valueOf(z12))));
    }
}
