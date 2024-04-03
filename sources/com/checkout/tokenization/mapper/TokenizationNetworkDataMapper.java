package com.checkout.tokenization.mapper;

import com.checkout.base.error.CheckoutError;
import com.checkout.network.error.NetworkError;
import com.checkout.network.response.ErrorResponse;
import com.checkout.network.response.NetworkApiResponse;
import com.checkout.tokenization.error.TokenizationError;
import com.checkout.tokenization.model.TokenResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001f\u0010\r\u001a\u00028\u0000\"\b\b\u0001\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u0002H\u000eH$¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0001\u0010\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u0002H\u000eH\u0002¢\u0006\u0002\u0010\u0018J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0001\u0010\u000e*\u00020\u00022\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d*\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¨\u0006\u001f"}, d2 = {"Lcom/checkout/tokenization/mapper/TokenizationNetworkDataMapper;", "S", "", "()V", "createExceptionErrorResult", "Lcom/checkout/tokenization/model/TokenResult;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "createInternalErrorResult", "Lcom/checkout/tokenization/model/TokenResult$Failure;", "internalError", "Lcom/checkout/network/response/NetworkApiResponse$InternalError;", "createMappedResult", "T", "resultBody", "(Ljava/lang/Object;)Ljava/lang/Object;", "createNetworkErrorResult", "networkError", "Lcom/checkout/network/response/NetworkApiResponse$NetworkError;", "createServerErrorResult", "serverError", "Lcom/checkout/network/response/NetworkApiResponse$ServerError;", "createSuccessResult", "(Ljava/lang/Object;)Lcom/checkout/tokenization/model/TokenResult;", "toTokenResult", "result", "Lcom/checkout/network/response/NetworkApiResponse;", "toErrorMessage", "", "errorMessage", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TokenizationNetworkDataMapper<S> {
    private final TokenResult<S> createExceptionErrorResult(Exception exc) {
        CheckoutError checkoutError;
        if (exc instanceof CheckoutError) {
            checkoutError = (CheckoutError) exc;
        } else {
            checkoutError = new CheckoutError(TokenizationError.TOKENIZATION_API_RESPONSE_PROCESSING_ERROR, exc.getMessage(), exc);
        }
        return new TokenResult.Failure(checkoutError);
    }

    private final TokenResult.Failure createInternalErrorResult(NetworkApiResponse.InternalError internalError) {
        CheckoutError checkoutError;
        if (internalError.getThrowable() instanceof CheckoutError) {
            checkoutError = (CheckoutError) internalError.getThrowable();
        } else {
            checkoutError = new TokenizationError(TokenizationError.GOOGLE_PAY_REQUEST_PARSING_ERROR, internalError.getThrowable().getMessage(), internalError.getThrowable());
        }
        return new TokenResult.Failure(checkoutError);
    }

    private final TokenResult.Failure createNetworkErrorResult(NetworkApiResponse.NetworkError networkError) {
        CheckoutError checkoutError;
        if (networkError.getThrowable() instanceof CheckoutError) {
            checkoutError = (CheckoutError) networkError.getThrowable();
        } else {
            checkoutError = new NetworkError(NetworkError.CONNECTION_FAILED_ERROR, networkError.getThrowable().getMessage(), networkError.getThrowable());
        }
        return new TokenResult.Failure(checkoutError);
    }

    private final TokenResult<S> createServerErrorResult(NetworkApiResponse.ServerError serverError) {
        TokenizationError tokenizationError;
        if (serverError.getCode() == 401) {
            tokenizationError = new TokenizationError(TokenizationError.INVALID_KEY, toErrorMessage(serverError, "Invalid key"), (Throwable) null, 4, (DefaultConstructorMarker) null);
        } else {
            tokenizationError = new TokenizationError(TokenizationError.INVALID_TOKEN_REQUEST, toErrorMessage(serverError, "Token request failed"), (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
        return new TokenResult.Failure(tokenizationError);
    }

    private final <T> TokenResult<S> createSuccessResult(T t11) {
        return new TokenResult.Success(createMappedResult(t11));
    }

    private final String toErrorMessage(NetworkApiResponse.ServerError serverError, String str) {
        String errorType;
        ErrorResponse body = serverError.getBody();
        if (!(body == null || (errorType = body.getErrorType()) == null)) {
            String str2 = str + " - " + errorType + " (HttpStatus: " + serverError.getCode() + ")";
            if (str2 != null) {
                return str2;
            }
        }
        return str + " - (HttpStatus: " + serverError.getCode() + ")";
    }

    @NotNull
    public abstract <T> S createMappedResult(@NotNull T t11);

    @NotNull
    public final <T> TokenResult<S> toTokenResult(@NotNull NetworkApiResponse<? extends T> networkApiResponse) {
        Intrinsics.checkNotNullParameter(networkApiResponse, "result");
        try {
            if (networkApiResponse instanceof NetworkApiResponse.Success) {
                return createSuccessResult(((NetworkApiResponse.Success) networkApiResponse).getBody());
            }
            if (networkApiResponse instanceof NetworkApiResponse.ServerError) {
                return createServerErrorResult((NetworkApiResponse.ServerError) networkApiResponse);
            }
            if (networkApiResponse instanceof NetworkApiResponse.NetworkError) {
                return createNetworkErrorResult((NetworkApiResponse.NetworkError) networkApiResponse);
            }
            if (networkApiResponse instanceof NetworkApiResponse.InternalError) {
                return createInternalErrorResult((NetworkApiResponse.InternalError) networkApiResponse);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e11) {
            return createExceptionErrorResult(e11);
        }
    }
}
