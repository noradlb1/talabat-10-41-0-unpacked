package com.checkout.tokenization.repository;

import androidx.annotation.VisibleForTesting;
import com.checkout.BuildConfig;
import com.checkout.base.mapper.Mapper;
import com.checkout.base.usecase.UseCase;
import com.checkout.network.response.ErrorResponse;
import com.checkout.network.response.NetworkApiResponse;
import com.checkout.tokenization.NetworkApiClient;
import com.checkout.tokenization.entity.GooglePayEntity;
import com.checkout.tokenization.logging.TokenizationLogger;
import com.checkout.tokenization.mapper.TokenizationNetworkDataMapper;
import com.checkout.tokenization.model.Card;
import com.checkout.tokenization.model.CardTokenRequest;
import com.checkout.tokenization.model.GooglePayTokenRequest;
import com.checkout.tokenization.model.TokenDetails;
import com.checkout.tokenization.model.TokenResult;
import com.checkout.tokenization.request.TokenRequest;
import com.checkout.tokenization.response.TokenDetailsResponse;
import com.checkout.validation.model.ValidationResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0007J\\\u0010\u001f\u001a\u00020\u000e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000e0#2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u000e0#H\u0002J\u001e\u0010)\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u000203H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/checkout/tokenization/repository/TokenRepositoryImpl;", "Lcom/checkout/tokenization/repository/TokenRepository;", "networkApiClient", "Lcom/checkout/tokenization/NetworkApiClient;", "cardToTokenRequestMapper", "Lcom/checkout/base/mapper/Mapper;", "Lcom/checkout/tokenization/model/Card;", "Lcom/checkout/tokenization/request/TokenRequest;", "cardTokenizationNetworkDataMapper", "Lcom/checkout/tokenization/mapper/TokenizationNetworkDataMapper;", "Lcom/checkout/tokenization/model/TokenDetails;", "validateTokenizationDataUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/validation/model/ValidationResult;", "", "logger", "Lcom/checkout/tokenization/logging/TokenizationLogger;", "publicKey", "", "(Lcom/checkout/tokenization/NetworkApiClient;Lcom/checkout/base/mapper/Mapper;Lcom/checkout/tokenization/mapper/TokenizationNetworkDataMapper;Lcom/checkout/base/usecase/UseCase;Lcom/checkout/tokenization/logging/TokenizationLogger;Ljava/lang/String;)V", "networkCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNetworkCoroutineScope$annotations", "()V", "getNetworkCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setNetworkCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "creatingTokenData", "Lcom/checkout/tokenization/entity/GooglePayEntity;", "tokenJsonPayload", "handleResponse", "tokenResult", "Lcom/checkout/tokenization/model/TokenResult;", "success", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "tokenDetails", "failure", "errorMessage", "logResponse", "response", "Lcom/checkout/network/response/NetworkApiResponse;", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "tokenType", "sendCardTokenRequest", "cardTokenRequest", "Lcom/checkout/tokenization/model/CardTokenRequest;", "sendGooglePayTokenRequest", "googlePayTokenRequest", "Lcom/checkout/tokenization/model/GooglePayTokenRequest;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenRepositoryImpl implements TokenRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final Mapper<Card, TokenRequest> cardToTokenRequestMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenizationNetworkDataMapper<TokenDetails> cardTokenizationNetworkDataMapper;
    /* access modifiers changed from: private */
    @NotNull
    public final TokenizationLogger logger;
    /* access modifiers changed from: private */
    @NotNull
    public final NetworkApiClient networkApiClient;
    @NotNull
    private CoroutineScope networkCoroutineScope = CoroutineScopeKt.CoroutineScope(new CoroutineName(BuildConfig.PRODUCT_IDENTIFIER).plus(Dispatchers.getIO()).plus(NonCancellable.INSTANCE));
    /* access modifiers changed from: private */
    @NotNull
    public final String publicKey;
    /* access modifiers changed from: private */
    @NotNull
    public final UseCase<Card, ValidationResult<Unit>> validateTokenizationDataUseCase;

    public TokenRepositoryImpl(@NotNull NetworkApiClient networkApiClient2, @NotNull Mapper<Card, TokenRequest> mapper, @NotNull TokenizationNetworkDataMapper<TokenDetails> tokenizationNetworkDataMapper, @NotNull UseCase<Card, ValidationResult<Unit>> useCase, @NotNull TokenizationLogger tokenizationLogger, @NotNull String str) {
        Intrinsics.checkNotNullParameter(networkApiClient2, "networkApiClient");
        Intrinsics.checkNotNullParameter(mapper, "cardToTokenRequestMapper");
        Intrinsics.checkNotNullParameter(tokenizationNetworkDataMapper, "cardTokenizationNetworkDataMapper");
        Intrinsics.checkNotNullParameter(useCase, "validateTokenizationDataUseCase");
        Intrinsics.checkNotNullParameter(tokenizationLogger, "logger");
        Intrinsics.checkNotNullParameter(str, "publicKey");
        this.networkApiClient = networkApiClient2;
        this.cardToTokenRequestMapper = mapper;
        this.cardTokenizationNetworkDataMapper = tokenizationNetworkDataMapper;
        this.validateTokenizationDataUseCase = useCase;
        this.logger = tokenizationLogger;
        this.publicKey = str;
    }

    @VisibleForTesting
    public static /* synthetic */ void getNetworkCoroutineScope$annotations() {
    }

    /* access modifiers changed from: private */
    public final void handleResponse(TokenResult<TokenDetails> tokenResult, Function1<? super TokenDetails, Unit> function1, Function1<? super String, Unit> function12) {
        String message;
        if (tokenResult instanceof TokenResult.Success) {
            function1.invoke(((TokenResult.Success) tokenResult).getResult());
        } else if ((tokenResult instanceof TokenResult.Failure) && (message = ((TokenResult.Failure) tokenResult).getError().getMessage()) != null) {
            function12.invoke(message);
        }
    }

    /* access modifiers changed from: private */
    public final void logResponse(NetworkApiResponse<TokenDetailsResponse> networkApiResponse, String str) {
        if (networkApiResponse instanceof NetworkApiResponse.ServerError) {
            NetworkApiResponse.ServerError serverError = (NetworkApiResponse.ServerError) networkApiResponse;
            this.logger.logTokenResponseEvent(str, this.publicKey, (TokenDetailsResponse) null, Integer.valueOf(serverError.getCode()), serverError.getBody());
        } else if (networkApiResponse instanceof NetworkApiResponse.Success) {
            TokenizationLogger.DefaultImpls.logTokenResponseEvent$default(this.logger, str, this.publicKey, (TokenDetailsResponse) ((NetworkApiResponse.Success) networkApiResponse).getBody(), (Integer) null, (ErrorResponse) null, 24, (Object) null);
        }
    }

    @NotNull
    @VisibleForTesting
    public final GooglePayEntity creatingTokenData(@NotNull String str) throws JSONException {
        Intrinsics.checkNotNullParameter(str, "tokenJsonPayload");
        JSONObject jSONObject = new JSONObject(str);
        return new GooglePayEntity(jSONObject.getString("signature"), jSONObject.getString("protocolVersion"), jSONObject.getString("signedMessage"));
    }

    @NotNull
    public final CoroutineScope getNetworkCoroutineScope() {
        return this.networkCoroutineScope;
    }

    public void sendCardTokenRequest(@NotNull CardTokenRequest cardTokenRequest) {
        Intrinsics.checkNotNullParameter(cardTokenRequest, "cardTokenRequest");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.networkCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TokenRepositoryImpl$sendCardTokenRequest$1(this, cardTokenRequest, new Ref.ObjectRef(), (Continuation<? super TokenRepositoryImpl$sendCardTokenRequest$1>) null), 3, (Object) null);
    }

    public void sendGooglePayTokenRequest(@NotNull GooglePayTokenRequest googlePayTokenRequest) {
        Intrinsics.checkNotNullParameter(googlePayTokenRequest, "googlePayTokenRequest");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.networkCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TokenRepositoryImpl$sendGooglePayTokenRequest$1(this, googlePayTokenRequest, new Ref.ObjectRef(), (Continuation<? super TokenRepositoryImpl$sendGooglePayTokenRequest$1>) null), 3, (Object) null);
    }

    public final void setNetworkCoroutineScope(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.networkCoroutineScope = coroutineScope;
    }
}
