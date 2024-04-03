package com.talabat.secure_payment_redirection;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionCallback;", "", "()V", "onClosed", "Lkotlin/Function0;", "", "getOnClosed", "()Lkotlin/jvm/functions/Function0;", "setOnClosed", "(Lkotlin/jvm/functions/Function0;)V", "onFailure", "getOnFailure", "setOnFailure", "onSuccess", "getOnSuccess", "setOnSuccess", "Companion", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SecurePaymentRedirectionCallback {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<SecurePaymentRedirectionCallback> instance$delegate = LazyKt__LazyJVMKt.lazy(SecurePaymentRedirectionCallback$Companion$instance$2.INSTANCE);
    @Nullable
    private Function0<Unit> onClosed;
    @Nullable
    private Function0<Unit> onFailure;
    @Nullable
    private Function0<Unit> onSuccess;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionCallback$Companion;", "", "()V", "instance", "Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionCallback;", "getInstance$annotations", "getInstance", "()Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionCallback;", "instance$delegate", "Lkotlin/Lazy;", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final SecurePaymentRedirectionCallback getInstance() {
            return (SecurePaymentRedirectionCallback) SecurePaymentRedirectionCallback.instance$delegate.getValue();
        }
    }

    @NotNull
    public static final SecurePaymentRedirectionCallback getInstance() {
        return Companion.getInstance();
    }

    @Nullable
    public final Function0<Unit> getOnClosed() {
        return this.onClosed;
    }

    @Nullable
    public final Function0<Unit> getOnFailure() {
        return this.onFailure;
    }

    @Nullable
    public final Function0<Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final void setOnClosed(@Nullable Function0<Unit> function0) {
        this.onClosed = function0;
    }

    public final void setOnFailure(@Nullable Function0<Unit> function0) {
        this.onFailure = function0;
    }

    public final void setOnSuccess(@Nullable Function0<Unit> function0) {
        this.onSuccess = function0;
    }
}
