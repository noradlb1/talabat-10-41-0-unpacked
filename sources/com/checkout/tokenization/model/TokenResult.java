package com.checkout.tokenization.model;

import com.checkout.base.error.CheckoutError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/checkout/tokenization/model/TokenResult;", "S", "", "()V", "Failure", "Success", "Lcom/checkout/tokenization/model/TokenResult$Failure;", "Lcom/checkout/tokenization/model/TokenResult$Success;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class TokenResult<S> {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/checkout/tokenization/model/TokenResult$Failure;", "Lcom/checkout/tokenization/model/TokenResult;", "", "error", "Lcom/checkout/base/error/CheckoutError;", "(Lcom/checkout/base/error/CheckoutError;)V", "getError", "()Lcom/checkout/base/error/CheckoutError;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Failure extends TokenResult {
        @NotNull
        private final CheckoutError error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(@NotNull CheckoutError checkoutError) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(checkoutError, "error");
            this.error = checkoutError;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, CheckoutError checkoutError, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                checkoutError = failure.error;
            }
            return failure.copy(checkoutError);
        }

        @NotNull
        public final CheckoutError component1() {
            return this.error;
        }

        @NotNull
        public final Failure copy(@NotNull CheckoutError checkoutError) {
            Intrinsics.checkNotNullParameter(checkoutError, "error");
            return new Failure(checkoutError);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.error, (Object) ((Failure) obj).error);
        }

        @NotNull
        public final CheckoutError getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        @NotNull
        public String toString() {
            CheckoutError checkoutError = this.error;
            return "Failure(error=" + checkoutError + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/checkout/tokenization/model/TokenResult$Success;", "R", "", "Lcom/checkout/tokenization/model/TokenResult;", "result", "(Ljava/lang/Object;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/checkout/tokenization/model/TokenResult$Success;", "equals", "", "other", "hashCode", "", "toString", "", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Success<R> extends TokenResult<R> {
        @NotNull
        private final R result;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull R r11) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(r11, "result");
            this.result = r11;
        }

        public static /* synthetic */ Success copy$default(Success success, R r11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                r11 = success.result;
            }
            return success.copy(r11);
        }

        @NotNull
        public final R component1() {
            return this.result;
        }

        @NotNull
        public final Success<R> copy(@NotNull R r11) {
            Intrinsics.checkNotNullParameter(r11, "result");
            return new Success<>(r11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.result, (Object) ((Success) obj).result);
        }

        @NotNull
        public final R getResult() {
            return this.result;
        }

        public int hashCode() {
            return this.result.hashCode();
        }

        @NotNull
        public String toString() {
            R r11 = this.result;
            return "Success(result=" + r11 + ")";
        }
    }

    private TokenResult() {
    }

    public /* synthetic */ TokenResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
