package com.checkout.network.error;

import com.checkout.base.error.CheckoutError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/checkout/network/error/NetworkError;", "Lcom/checkout/base/error/CheckoutError;", "errorCode", "", "message", "cause", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NetworkError extends CheckoutError {
    @NotNull
    public static final String CONNECTION_FAILED_ERROR = "NetworkError:2001";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String RESPONSE_PARSING_ERROR = "NetworkError:2007";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/checkout/network/error/NetworkError$Companion;", "", "()V", "CONNECTION_FAILED_ERROR", "", "RESPONSE_PARSING_ERROR", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkError(String str, String str2, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : th2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkError(@NotNull String str, @Nullable String str2, @Nullable Throwable th2) {
        super(str, str2, th2);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }
}
