package com.checkout.tokenization.logging;

import com.checkout.network.response.ErrorResponse;
import com.checkout.tokenization.response.TokenDetailsResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&JA\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013"}, d2 = {"Lcom/checkout/tokenization/logging/TokenizationLogger;", "", "logErrorOnTokenRequestedEvent", "", "tokenType", "", "publicKey", "error", "", "logTokenRequestEvent", "logTokenResponseEvent", "tokenDetails", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "code", "", "errorResponse", "Lcom/checkout/network/response/ErrorResponse;", "(Ljava/lang/String;Ljava/lang/String;Lcom/checkout/tokenization/response/TokenDetailsResponse;Ljava/lang/Integer;Lcom/checkout/network/response/ErrorResponse;)V", "resetSession", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TokenizationLogger {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void logErrorOnTokenRequestedEvent$default(TokenizationLogger tokenizationLogger, String str, String str2, Throwable th2, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    th2 = null;
                }
                tokenizationLogger.logErrorOnTokenRequestedEvent(str, str2, th2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logErrorOnTokenRequestedEvent");
        }

        public static /* synthetic */ void logTokenResponseEvent$default(TokenizationLogger tokenizationLogger, String str, String str2, TokenDetailsResponse tokenDetailsResponse, Integer num, ErrorResponse errorResponse, int i11, Object obj) {
            if (obj == null) {
                tokenizationLogger.logTokenResponseEvent(str, str2, (i11 & 4) != 0 ? null : tokenDetailsResponse, (i11 & 8) != 0 ? null : num, (i11 & 16) != 0 ? null : errorResponse);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logTokenResponseEvent");
        }
    }

    void logErrorOnTokenRequestedEvent(@NotNull String str, @NotNull String str2, @Nullable Throwable th2);

    void logTokenRequestEvent(@NotNull String str, @NotNull String str2);

    void logTokenResponseEvent(@NotNull String str, @NotNull String str2, @Nullable TokenDetailsResponse tokenDetailsResponse, @Nullable Integer num, @Nullable ErrorResponse errorResponse);

    void resetSession();
}
