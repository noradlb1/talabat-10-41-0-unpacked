package com.talabat.authentication.usecase;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.AuthenticationStatus;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/authentication/usecase/RegistrationObservabilityUseCase;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "commonAttributes", "", "", "onRequestError", "", "localizedMessage", "registrationType", "onRequestSuccess", "silentLoginFirstRequestFailure", "result", "silentLoginFirstRequestSuccess", "silentLoginRequestParamFailure", "silentLoginSecondRequestFailure", "silentLoginSecondRequestSuccess", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RegistrationObservabilityUseCase {
    @NotNull
    public static final String API_RESPONSE = "apiResponse";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ERROR_DETAIL = "errorDetail";
    @NotNull
    public static final String OWIN = "owin";
    @NotNull
    public static final String REGISTRATION = "registration";
    @NotNull
    public static final String RETRY_COUNT = "retryCount";
    @NotNull
    public static final String SILENT_LOGIN_AFTER_REGISTRATION = "silent_login_after_registration";
    @NotNull
    public static final String STATE = "state";
    @NotNull
    public static final String STATE_TYPE = "stateType";
    @NotNull
    public static final String TOKEN_TYPE = "tokenType";
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/authentication/usecase/RegistrationObservabilityUseCase$Companion;", "", "()V", "API_RESPONSE", "", "ERROR_DETAIL", "OWIN", "REGISTRATION", "RETRY_COUNT", "SILENT_LOGIN_AFTER_REGISTRATION", "STATE", "STATE_TYPE", "TOKEN_TYPE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public RegistrationObservabilityUseCase(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    private final Map<? extends String, String> commonAttributes() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tokenType", "owin"));
    }

    public final void onRequestError(@Nullable String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str2, "registrationType");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("apiResponse", authenticationStatus.toString());
        if (str == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("errorDetail", str);
        pairArr[2] = TuplesKt.to("stateType", str2);
        pairArr[3] = TuplesKt.to("state", REGISTRATION);
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, REGISTRATION, mutableMapOf);
    }

    public final void onRequestSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "registrationType");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Success;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("state", REGISTRATION), TuplesKt.to("stateType", str));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, REGISTRATION, mutableMapOf);
    }

    public final void silentLoginFirstRequestFailure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", "1"), TuplesKt.to("state", SILENT_LOGIN_AFTER_REGISTRATION));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, SILENT_LOGIN_AFTER_REGISTRATION, mutableMapOf);
    }

    public final void silentLoginFirstRequestSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Success;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", "1"), TuplesKt.to("state", SILENT_LOGIN_AFTER_REGISTRATION));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, SILENT_LOGIN_AFTER_REGISTRATION, mutableMapOf);
    }

    public final void silentLoginRequestParamFailure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("state", SILENT_LOGIN_AFTER_REGISTRATION));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, SILENT_LOGIN_AFTER_REGISTRATION, mutableMapOf);
    }

    public final void silentLoginSecondRequestFailure(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Failure;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to("state", SILENT_LOGIN_AFTER_REGISTRATION));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, SILENT_LOGIN_AFTER_REGISTRATION, mutableMapOf);
    }

    public final void silentLoginSecondRequestSuccess(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        AuthenticationStatus authenticationStatus = AuthenticationStatus.Success;
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("apiResponse", authenticationStatus.toString()), TuplesKt.to("errorDetail", str), TuplesKt.to("retryCount", ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to("state", SILENT_LOGIN_AFTER_REGISTRATION));
        mutableMapOf.putAll(commonAttributes());
        Unit unit = Unit.INSTANCE;
        iObservabilityManager.trackAuthenticationEvents(authenticationStatus, SILENT_LOGIN_AFTER_REGISTRATION, mutableMapOf);
    }
}
