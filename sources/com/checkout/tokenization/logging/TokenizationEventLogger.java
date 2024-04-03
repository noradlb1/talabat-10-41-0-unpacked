package com.checkout.tokenization.logging;

import com.checkout.eventlogger.domain.model.MonitoringLevel;
import com.checkout.logging.Logger;
import com.checkout.logging.model.LoggingEvent;
import com.checkout.logging.utils.HashMapExtensionKt;
import com.checkout.logging.utils.LoggingAttributesKt;
import com.checkout.network.response.ErrorResponse;
import com.checkout.tokenization.response.TokenDetailsResponse;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016JU\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J;\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0019JM\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/checkout/tokenization/logging/TokenizationEventLogger;", "Lcom/checkout/tokenization/logging/TokenizationLogger;", "logger", "Lcom/checkout/logging/Logger;", "Lcom/checkout/logging/model/LoggingEvent;", "(Lcom/checkout/logging/Logger;)V", "logErrorOnTokenRequestedEvent", "", "tokenType", "", "publicKey", "error", "", "logEvent", "tokenizationEventType", "Lcom/checkout/tokenization/logging/TokenizationEventType;", "tokenDetails", "Lcom/checkout/tokenization/response/TokenDetailsResponse;", "code", "", "errorResponse", "Lcom/checkout/network/response/ErrorResponse;", "(Lcom/checkout/tokenization/logging/TokenizationEventType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lcom/checkout/tokenization/response/TokenDetailsResponse;Ljava/lang/Integer;Lcom/checkout/network/response/ErrorResponse;)V", "logTokenRequestEvent", "logTokenResponseEvent", "(Ljava/lang/String;Ljava/lang/String;Lcom/checkout/tokenization/response/TokenDetailsResponse;Ljava/lang/Integer;Lcom/checkout/network/response/ErrorResponse;)V", "provideLoggingEvent", "(Lcom/checkout/tokenization/logging/TokenizationEventType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lcom/checkout/tokenization/response/TokenDetailsResponse;Ljava/lang/Integer;Lcom/checkout/network/response/ErrorResponse;)Lcom/checkout/logging/model/LoggingEvent;", "resetSession", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TokenizationEventLogger implements TokenizationLogger {
    @NotNull
    private final Logger<LoggingEvent> logger;

    public TokenizationEventLogger(@NotNull Logger<LoggingEvent> logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
    }

    private final void logEvent(TokenizationEventType tokenizationEventType, String str, String str2, Throwable th2, TokenDetailsResponse tokenDetailsResponse, Integer num, ErrorResponse errorResponse) {
        this.logger.log(provideLoggingEvent(tokenizationEventType, str, str2, th2, tokenDetailsResponse, num, errorResponse));
    }

    public static /* synthetic */ void logEvent$default(TokenizationEventLogger tokenizationEventLogger, TokenizationEventType tokenizationEventType, String str, String str2, Throwable th2, TokenDetailsResponse tokenDetailsResponse, Integer num, ErrorResponse errorResponse, int i11, Object obj) {
        tokenizationEventLogger.logEvent(tokenizationEventType, str, str2, (i11 & 8) != 0 ? null : th2, (i11 & 16) != 0 ? null : tokenDetailsResponse, (i11 & 32) != 0 ? null : num, (i11 & 64) != 0 ? null : errorResponse);
    }

    private final LoggingEvent provideLoggingEvent(TokenizationEventType tokenizationEventType, String str, String str2, Throwable th2, TokenDetailsResponse tokenDetailsResponse, Integer num, ErrorResponse errorResponse) {
        MonitoringLevel monitoringLevel;
        HashMap hashMap = new HashMap();
        hashMap.put("tokenType", str);
        hashMap.put("publicKey", str2);
        if (th2 != null) {
            HashMapExtensionKt.putErrorAttributes(hashMap, th2);
        }
        if (tokenDetailsResponse != null) {
            hashMap.put(LoggingAttributesKt.TOKEN_ID, tokenDetailsResponse.getToken());
            String scheme = tokenDetailsResponse.getScheme();
            if (scheme == null) {
                scheme = "";
            }
            hashMap.put(LoggingAttributesKt.SCHEME, scheme);
        }
        if (num != null) {
            hashMap.put(LoggingAttributesKt.HTTP_STATUS_CODE, Integer.valueOf(num.intValue()));
        }
        if (errorResponse != null) {
            hashMap.put(LoggingAttributesKt.SERVER_ERROR, MapsKt__MapsKt.mapOf(TuplesKt.to(LoggingAttributesKt.REQUEST_ID, errorResponse.getRequestId()), TuplesKt.to("errorType", errorResponse.getErrorType()), TuplesKt.to(LoggingAttributesKt.ERROR_CODES, errorResponse.getErrorCodes())));
        }
        if (th2 == null) {
            monitoringLevel = MonitoringLevel.INFO;
        } else {
            monitoringLevel = MonitoringLevel.ERROR;
        }
        return new LoggingEvent(tokenizationEventType, monitoringLevel, hashMap);
    }

    public void logErrorOnTokenRequestedEvent(@NotNull String str, @NotNull String str2, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tokenType");
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        logEvent$default(this, TokenizationEventType.TOKEN_REQUESTED, str, str2, th2, (TokenDetailsResponse) null, (Integer) null, (ErrorResponse) null, 112, (Object) null);
    }

    public void logTokenRequestEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "tokenType");
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        logEvent$default(this, TokenizationEventType.TOKEN_REQUESTED, str, str2, (Throwable) null, (TokenDetailsResponse) null, (Integer) null, (ErrorResponse) null, 120, (Object) null);
    }

    public void logTokenResponseEvent(@NotNull String str, @NotNull String str2, @Nullable TokenDetailsResponse tokenDetailsResponse, @Nullable Integer num, @Nullable ErrorResponse errorResponse) {
        Intrinsics.checkNotNullParameter(str, "tokenType");
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        logEvent(TokenizationEventType.TOKEN_RESPONSE, str, str2, (Throwable) null, tokenDetailsResponse, num, errorResponse);
    }

    public void resetSession() {
        this.logger.resetSession();
    }
}
