package com.checkout.frames.model.request;

import com.checkout.tokenization.model.Card;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/model/request/InternalCardTokenRequest;", "", "card", "Lcom/checkout/tokenization/model/Card;", "onSuccess", "Lkotlin/Function0;", "", "onFailure", "(Lcom/checkout/tokenization/model/Card;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getCard", "()Lcom/checkout/tokenization/model/Card;", "getOnFailure", "()Lkotlin/jvm/functions/Function0;", "getOnSuccess", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InternalCardTokenRequest {
    @NotNull
    private final Card card;
    @NotNull
    private final Function0<Unit> onFailure;
    @NotNull
    private final Function0<Unit> onSuccess;

    public InternalCardTokenRequest(@NotNull Card card2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(card2, "card");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function02, "onFailure");
        this.card = card2;
        this.onSuccess = function0;
        this.onFailure = function02;
    }

    public static /* synthetic */ InternalCardTokenRequest copy$default(InternalCardTokenRequest internalCardTokenRequest, Card card2, Function0<Unit> function0, Function0<Unit> function02, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            card2 = internalCardTokenRequest.card;
        }
        if ((i11 & 2) != 0) {
            function0 = internalCardTokenRequest.onSuccess;
        }
        if ((i11 & 4) != 0) {
            function02 = internalCardTokenRequest.onFailure;
        }
        return internalCardTokenRequest.copy(card2, function0, function02);
    }

    @NotNull
    public final Card component1() {
        return this.card;
    }

    @NotNull
    public final Function0<Unit> component2() {
        return this.onSuccess;
    }

    @NotNull
    public final Function0<Unit> component3() {
        return this.onFailure;
    }

    @NotNull
    public final InternalCardTokenRequest copy(@NotNull Card card2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(card2, "card");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function02, "onFailure");
        return new InternalCardTokenRequest(card2, function0, function02);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InternalCardTokenRequest)) {
            return false;
        }
        InternalCardTokenRequest internalCardTokenRequest = (InternalCardTokenRequest) obj;
        return Intrinsics.areEqual((Object) this.card, (Object) internalCardTokenRequest.card) && Intrinsics.areEqual((Object) this.onSuccess, (Object) internalCardTokenRequest.onSuccess) && Intrinsics.areEqual((Object) this.onFailure, (Object) internalCardTokenRequest.onFailure);
    }

    @NotNull
    public final Card getCard() {
        return this.card;
    }

    @NotNull
    public final Function0<Unit> getOnFailure() {
        return this.onFailure;
    }

    @NotNull
    public final Function0<Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public int hashCode() {
        return (((this.card.hashCode() * 31) + this.onSuccess.hashCode()) * 31) + this.onFailure.hashCode();
    }

    @NotNull
    public String toString() {
        Card card2 = this.card;
        Function0<Unit> function0 = this.onSuccess;
        Function0<Unit> function02 = this.onFailure;
        return "InternalCardTokenRequest(card=" + card2 + ", onSuccess=" + function0 + ", onFailure=" + function02 + ")";
    }
}
