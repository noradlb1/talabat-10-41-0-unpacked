package com.checkout.tokenization.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005\u0012!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J$\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J$\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J]\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00052#\b\u0002\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R,\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR,\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/checkout/tokenization/model/GooglePayTokenRequest;", "", "tokenJsonPayload", "", "onSuccess", "Lkotlin/Function1;", "Lcom/checkout/tokenization/model/TokenDetails;", "Lkotlin/ParameterName;", "name", "tokenDetails", "", "onFailure", "errorMessage", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnFailure", "()Lkotlin/jvm/functions/Function1;", "getOnSuccess", "getTokenJsonPayload", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GooglePayTokenRequest {
    @NotNull
    private final Function1<String, Unit> onFailure;
    @NotNull
    private final Function1<TokenDetails, Unit> onSuccess;
    @NotNull
    private final String tokenJsonPayload;

    public GooglePayTokenRequest(@NotNull String str, @NotNull Function1<? super TokenDetails, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "tokenJsonPayload");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        this.tokenJsonPayload = str;
        this.onSuccess = function1;
        this.onFailure = function12;
    }

    public static /* synthetic */ GooglePayTokenRequest copy$default(GooglePayTokenRequest googlePayTokenRequest, String str, Function1<TokenDetails, Unit> function1, Function1<String, Unit> function12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = googlePayTokenRequest.tokenJsonPayload;
        }
        if ((i11 & 2) != 0) {
            function1 = googlePayTokenRequest.onSuccess;
        }
        if ((i11 & 4) != 0) {
            function12 = googlePayTokenRequest.onFailure;
        }
        return googlePayTokenRequest.copy(str, function1, function12);
    }

    @NotNull
    public final String component1() {
        return this.tokenJsonPayload;
    }

    @NotNull
    public final Function1<TokenDetails, Unit> component2() {
        return this.onSuccess;
    }

    @NotNull
    public final Function1<String, Unit> component3() {
        return this.onFailure;
    }

    @NotNull
    public final GooglePayTokenRequest copy(@NotNull String str, @NotNull Function1<? super TokenDetails, Unit> function1, @NotNull Function1<? super String, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "tokenJsonPayload");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        return new GooglePayTokenRequest(str, function1, function12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayTokenRequest)) {
            return false;
        }
        GooglePayTokenRequest googlePayTokenRequest = (GooglePayTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.tokenJsonPayload, (Object) googlePayTokenRequest.tokenJsonPayload) && Intrinsics.areEqual((Object) this.onSuccess, (Object) googlePayTokenRequest.onSuccess) && Intrinsics.areEqual((Object) this.onFailure, (Object) googlePayTokenRequest.onFailure);
    }

    @NotNull
    public final Function1<String, Unit> getOnFailure() {
        return this.onFailure;
    }

    @NotNull
    public final Function1<TokenDetails, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    @NotNull
    public final String getTokenJsonPayload() {
        return this.tokenJsonPayload;
    }

    public int hashCode() {
        return (((this.tokenJsonPayload.hashCode() * 31) + this.onSuccess.hashCode()) * 31) + this.onFailure.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.tokenJsonPayload;
        Function1<TokenDetails, Unit> function1 = this.onSuccess;
        Function1<String, Unit> function12 = this.onFailure;
        return "GooglePayTokenRequest(tokenJsonPayload=" + str + ", onSuccess=" + function1 + ", onFailure=" + function12 + ")";
    }
}
