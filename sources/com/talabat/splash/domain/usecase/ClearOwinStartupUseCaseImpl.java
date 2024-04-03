package com.talabat.splash.domain.usecase;

import com.talabat.authentication.token.domain.repository.ClearOwinStartupUseCase;
import com.talabat.authentication.token.domain.repository.ClearOwinUseCase;
import com.talabat.authentication.token.domain.repository.TokenRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.EventType;
import com.talabat.helpers.GlobalDataModel;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/splash/domain/usecase/ClearOwinStartupUseCaseImpl;", "Lcom/talabat/authentication/token/domain/repository/ClearOwinStartupUseCase;", "clearOwinUseCase", "Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;", "tokenRepository", "Lcom/talabat/authentication/token/domain/repository/TokenRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/authentication/token/domain/repository/ClearOwinUseCase;Lcom/talabat/authentication/token/domain/repository/TokenRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClearOwinStartupUseCaseImpl implements ClearOwinStartupUseCase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String STATE_TYPE_LOGIN = "app_launch";
    @NotNull
    private final ClearOwinUseCase clearOwinUseCase;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final TokenRepository tokenRepository;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/splash/domain/usecase/ClearOwinStartupUseCaseImpl$Companion;", "", "()V", "STATE_TYPE_LOGIN", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ClearOwinStartupUseCaseImpl(@NotNull ClearOwinUseCase clearOwinUseCase2, @NotNull TokenRepository tokenRepository2, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(clearOwinUseCase2, "clearOwinUseCase");
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.clearOwinUseCase = clearOwinUseCase2;
        this.tokenRepository = tokenRepository2;
        this.observabilityManager = iObservabilityManager;
    }

    public boolean invoke() {
        if (GlobalDataModel.token == null || this.tokenRepository.getTokenOrNull() == null) {
            return false;
        }
        boolean invoke$default = ClearOwinUseCase.DefaultImpls.invoke$default(this.clearOwinUseCase, false, 1, (Object) null);
        if (invoke$default) {
            this.observabilityManager.trackEvent("clear_owin", EventType.AuthEvent.name(), (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to("stateType", "app_launch")));
        }
        return invoke$default;
    }
}
