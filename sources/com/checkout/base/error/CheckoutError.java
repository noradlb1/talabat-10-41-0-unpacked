package com.checkout.base.error;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/checkout/base/error/CheckoutError;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "message", "throwable", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()Ljava/lang/String;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CheckoutError extends Exception {
    @NotNull
    private final String errorCode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutError(@NotNull String str) {
        this(str, (String) null, (Throwable) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutError(@NotNull String str, @Nullable String str2) {
        this(str, str2, (Throwable) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "errorCode");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckoutError(String str, String str2, Throwable th2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : th2);
    }

    @NotNull
    public String getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CheckoutError(@NotNull String str, @Nullable String str2, @Nullable Throwable th2) {
        super(str2, th2);
        Intrinsics.checkNotNullParameter(str, "errorCode");
        this.errorCode = str;
    }
}
