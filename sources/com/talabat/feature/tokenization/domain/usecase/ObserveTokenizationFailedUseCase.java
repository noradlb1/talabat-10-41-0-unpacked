package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.tokenization.domain.exception.TokenizationTokenGenerationException;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObserveTokenizationFailedUseCase {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String ERROR_CODES_ATTRIBUTE = "errorCodes";
    @NotNull
    @Deprecated
    private static final String ERROR_TYPE_ATTRIBUTE = "errorType";
    @NotNull
    @Deprecated
    private static final String EVENT_NAME = "token_generation_failed";
    @NotNull
    @Deprecated
    private static final String EVENT_TYPE = "new_checkout_sdk_tokenization";
    @NotNull
    @Deprecated
    private static final String REQUEST_ID_ATTRIBUTE = "requestId";
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationFailedUseCase$Companion;", "", "()V", "ERROR_CODES_ATTRIBUTE", "", "ERROR_TYPE_ATTRIBUTE", "EVENT_NAME", "EVENT_TYPE", "REQUEST_ID_ATTRIBUTE", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ObserveTokenizationFailedUseCase(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    public final void invoke(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        if (exc instanceof TokenizationTokenGenerationException) {
            TokenizationTokenGenerationException tokenizationTokenGenerationException = (TokenizationTokenGenerationException) exc;
            this.observabilityManager.trackEvent(EVENT_NAME, EVENT_TYPE, (Map<String, String>) MapsKt__MapsKt.mapOf(TuplesKt.to("errorType", tokenizationTokenGenerationException.getErrorType()), TuplesKt.to("requestId", tokenizationTokenGenerationException.getRequestId()), TuplesKt.to("errorCodes", ArraysKt___ArraysKt.joinToString$default((Object[]) tokenizationTokenGenerationException.getErrorCodes(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null))));
            return;
        }
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        IObservabilityManager.DefaultImpls.trackUnExpectedScenario$default(iObservabilityManager, message, (Map) null, 2, (Object) null);
    }
}
