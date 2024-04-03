package com.checkout.logging.utils;

import com.checkout.base.error.CheckoutError;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"putErrorAttributes", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "error", "", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HashMapExtensionKt {
    public static final void putErrorAttributes(@NotNull HashMap<String, Object> hashMap, @NotNull Throwable th2) {
        CheckoutError checkoutError;
        String errorCode;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Intrinsics.checkNotNullParameter(th2, "error");
        if (th2 instanceof CheckoutError) {
            checkoutError = (CheckoutError) th2;
        } else {
            checkoutError = null;
        }
        if (!(checkoutError == null || (errorCode = checkoutError.getErrorCode()) == null)) {
            hashMap.put(LoggingAttributesKt.ERROR_CODES, errorCode);
        }
        String message = th2.getMessage();
        if (message != null) {
            hashMap.put("message", message);
        }
        hashMap.put("exception", ExceptionsKt__ExceptionsKt.stackTraceToString(th2));
    }
}
