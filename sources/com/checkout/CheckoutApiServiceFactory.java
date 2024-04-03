package com.checkout;

import android.content.Context;
import com.checkout.api.CheckoutApiClient;
import com.checkout.api.CheckoutApiService;
import com.checkout.base.model.Environment;
import com.checkout.logging.EventLoggerProvider;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.network.OkHttpProvider;
import com.checkout.threedsecure.Executor;
import com.checkout.threedsecure.ThreeDSExecutor;
import com.checkout.threedsecure.logging.ThreeDSEventLogger;
import com.checkout.threedsecure.model.ThreeDSRequest;
import com.checkout.threedsecure.usecase.ProcessThreeDSUseCase;
import com.checkout.tokenization.TokenNetworkApiClient;
import com.checkout.tokenization.logging.TokenizationEventLogger;
import com.checkout.tokenization.mapper.request.AddressToAddressValidationRequestDataMapper;
import com.checkout.tokenization.mapper.request.CardToTokenRequestMapper;
import com.checkout.tokenization.mapper.response.CardTokenizationNetworkDataMapper;
import com.checkout.tokenization.repository.TokenRepository;
import com.checkout.tokenization.repository.TokenRepositoryImpl;
import com.checkout.tokenization.usecase.ValidateTokenizationDataUseCase;
import com.checkout.validation.validator.AddressValidator;
import com.checkout.validation.validator.PhoneValidator;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0016"}, d2 = {"Lcom/checkout/CheckoutApiServiceFactory;", "", "()V", "create", "Lcom/checkout/api/CheckoutApiService;", "publicKey", "", "environment", "Lcom/checkout/base/model/Environment;", "context", "Landroid/content/Context;", "provideNetworkApiClient", "Lcom/checkout/tokenization/TokenNetworkApiClient;", "url", "provideThreeDSExecutor", "Lcom/checkout/threedsecure/Executor;", "Lcom/checkout/threedsecure/model/ThreeDSRequest;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "provideTokenRepository", "Lcom/checkout/tokenization/repository/TokenRepository;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CheckoutApiServiceFactory {
    @NotNull
    public static final CheckoutApiServiceFactory INSTANCE = new CheckoutApiServiceFactory();

    private CheckoutApiServiceFactory() {
    }

    @JvmStatic
    @NotNull
    public static final CheckoutApiService create(@NotNull String str, @NotNull Environment environment, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(str, "publicKey");
        Intrinsics.checkNotNullParameter(environment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(context, "context");
        Logger<LoggingEvent> provide = EventLoggerProvider.INSTANCE.provide();
        Logger.DefaultImpls.setup$default(provide, context, environment, (String) null, (String) null, 12, (Object) null);
        CheckoutApiServiceFactory checkoutApiServiceFactory = INSTANCE;
        return new CheckoutApiClient(checkoutApiServiceFactory.provideTokenRepository(str, environment), checkoutApiServiceFactory.provideThreeDSExecutor(provide));
    }

    private final TokenNetworkApiClient provideNetworkApiClient(String str, String str2) {
        OkHttpClient createOkHttpClient = OkHttpProvider.INSTANCE.createOkHttpClient(str);
        Moshi build = new Moshi.Builder().addLast((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().addLast(Kotlin…AdapterFactory()).build()");
        return new TokenNetworkApiClient(str2, createOkHttpClient, build);
    }

    private final Executor<ThreeDSRequest> provideThreeDSExecutor(Logger<LoggingEvent> logger) {
        return new ThreeDSExecutor(new ProcessThreeDSUseCase(), new ThreeDSEventLogger(logger));
    }

    private final TokenRepository provideTokenRepository(String str, Environment environment) {
        return new TokenRepositoryImpl(provideNetworkApiClient(str, environment.getUrl()), new CardToTokenRequestMapper(), new CardTokenizationNetworkDataMapper(), new ValidateTokenizationDataUseCase(CardValidatorFactory.INSTANCE.createInternal$checkout_release(), new AddressValidator(), new PhoneValidator(), new AddressToAddressValidationRequestDataMapper()), new TokenizationEventLogger(EventLoggerProvider.INSTANCE.provide()), str);
    }
}
