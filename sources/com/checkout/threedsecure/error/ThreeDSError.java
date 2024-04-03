package com.checkout.threedsecure.error;

import com.checkout.base.error.CheckoutError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/checkout/threedsecure/error/ThreeDSError;", "Lcom/checkout/base/error/CheckoutError;", "errorCode", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreeDSError extends CheckoutError {
    @NotNull
    public static final String COULD_NOT_EXTRACT_TOKEN = "ThreeDSError:3000";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String RECEIVED_FAILURE_URL = "ThreeDSError:3001";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/checkout/threedsecure/error/ThreeDSError$Companion;", "", "()V", "COULD_NOT_EXTRACT_TOKEN", "", "RECEIVED_FAILURE_URL", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThreeDSError(@NotNull String str, @Nullable String str2) {
        super(str, str2, (Throwable) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }
}
