package com.adyen.checkout.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CheckoutException extends Exception {
    /* access modifiers changed from: private */
    public boolean mFatal;
    /* access modifiers changed from: private */
    public String mPayload;

    public static final class Builder {
        private CheckoutException mCheckoutException;

        public Builder(@NonNull String str, @Nullable Throwable th2) {
            this.mCheckoutException = new CheckoutException(str, th2);
        }

        @NonNull
        public CheckoutException build() {
            return this.mCheckoutException;
        }

        @NonNull
        public Builder setFatal(boolean z11) {
            boolean unused = this.mCheckoutException.mFatal = z11;
            return this;
        }

        @NonNull
        public Builder setPayload(@Nullable String str) {
            String unused = this.mCheckoutException.mPayload = str;
            return this;
        }
    }

    @Nullable
    public String getPayload() {
        return this.mPayload;
    }

    public boolean isFatal() {
        return this.mFatal;
    }

    private CheckoutException(@NonNull String str, @Nullable Throwable th2) {
        super(str, th2);
    }
}
