package com.checkout.api;

import com.checkout.api.logging.ApiClientEventType;
import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.logging.EventLoggerProvider;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.threedsecure.Executor;
import com.checkout.threedsecure.model.ThreeDSRequest;
import com.checkout.tokenization.model.CardTokenRequest;
import com.checkout.tokenization.model.GooglePayTokenRequest;
import com.checkout.tokenization.repository.TokenRepository;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/checkout/api/CheckoutApiClient;", "Lcom/checkout/api/CheckoutApiService;", "tokenRepository", "Lcom/checkout/tokenization/repository/TokenRepository;", "threeDSExecutor", "Lcom/checkout/threedsecure/Executor;", "Lcom/checkout/threedsecure/model/ThreeDSRequest;", "(Lcom/checkout/tokenization/repository/TokenRepository;Lcom/checkout/threedsecure/Executor;)V", "createToken", "", "request", "Lcom/checkout/tokenization/model/CardTokenRequest;", "Lcom/checkout/tokenization/model/GooglePayTokenRequest;", "handleThreeDS", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckoutApiClient implements CheckoutApiService {
    @NotNull
    private final Executor<ThreeDSRequest> threeDSExecutor;
    @NotNull
    private final TokenRepository tokenRepository;

    public CheckoutApiClient(@NotNull TokenRepository tokenRepository2, @NotNull Executor<ThreeDSRequest> executor) {
        Intrinsics.checkNotNullParameter(tokenRepository2, "tokenRepository");
        Intrinsics.checkNotNullParameter(executor, "threeDSExecutor");
        this.tokenRepository = tokenRepository2;
        this.threeDSExecutor = executor;
        EventLoggerProvider.INSTANCE.provide().log(new LoggingEvent(ApiClientEventType.INITIALIZE, (MonitoringLevel) null, (Map) null, 6, (DefaultConstructorMarker) null));
    }

    public void createToken(@NotNull CardTokenRequest cardTokenRequest) {
        Intrinsics.checkNotNullParameter(cardTokenRequest, "request");
        this.tokenRepository.sendCardTokenRequest(cardTokenRequest);
    }

    public void handleThreeDS(@NotNull ThreeDSRequest threeDSRequest) {
        Intrinsics.checkNotNullParameter(threeDSRequest, "request");
        this.threeDSExecutor.execute(threeDSRequest);
    }

    public void createToken(@NotNull GooglePayTokenRequest googlePayTokenRequest) {
        Intrinsics.checkNotNullParameter(googlePayTokenRequest, "request");
        this.tokenRepository.sendGooglePayTokenRequest(googlePayTokenRequest);
    }
}
