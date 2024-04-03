package com.checkout.threedsecure.model;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BL\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012%\u0010\b\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J(\u0010\u001d\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fHÆ\u0003JZ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052'\b\u0002\u0010\b\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R0\u0010\b\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006%"}, d2 = {"Lcom/checkout/threedsecure/model/ThreeDSRequest;", "", "container", "Landroid/view/ViewGroup;", "challengeUrl", "", "successUrl", "failureUrl", "resultHandler", "Lkotlin/Function1;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/checkout/threedsecure/model/ThreeDSResultHandler;", "(Landroid/view/ViewGroup;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getChallengeUrl", "()Ljava/lang/String;", "getContainer", "()Landroid/view/ViewGroup;", "getFailureUrl", "getResultHandler", "()Lkotlin/jvm/functions/Function1;", "getSuccessUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ThreeDSRequest {
    @NotNull
    private final String challengeUrl;
    @NotNull
    private final ViewGroup container;
    @NotNull
    private final String failureUrl;
    @NotNull
    private final Function1<ThreeDSResult, Unit> resultHandler;
    @NotNull
    private final String successUrl;

    public ThreeDSRequest(@NotNull ViewGroup viewGroup, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function1<? super ThreeDSResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(str, "challengeUrl");
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "failureUrl");
        Intrinsics.checkNotNullParameter(function1, "resultHandler");
        this.container = viewGroup;
        this.challengeUrl = str;
        this.successUrl = str2;
        this.failureUrl = str3;
        this.resultHandler = function1;
    }

    public static /* synthetic */ ThreeDSRequest copy$default(ThreeDSRequest threeDSRequest, ViewGroup viewGroup, String str, String str2, String str3, Function1<ThreeDSResult, Unit> function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            viewGroup = threeDSRequest.container;
        }
        if ((i11 & 2) != 0) {
            str = threeDSRequest.challengeUrl;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = threeDSRequest.successUrl;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = threeDSRequest.failureUrl;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            function1 = threeDSRequest.resultHandler;
        }
        return threeDSRequest.copy(viewGroup, str4, str5, str6, function1);
    }

    @NotNull
    public final ViewGroup component1() {
        return this.container;
    }

    @NotNull
    public final String component2() {
        return this.challengeUrl;
    }

    @NotNull
    public final String component3() {
        return this.successUrl;
    }

    @NotNull
    public final String component4() {
        return this.failureUrl;
    }

    @NotNull
    public final Function1<ThreeDSResult, Unit> component5() {
        return this.resultHandler;
    }

    @NotNull
    public final ThreeDSRequest copy(@NotNull ViewGroup viewGroup, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function1<? super ThreeDSResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(str, "challengeUrl");
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "failureUrl");
        Intrinsics.checkNotNullParameter(function1, "resultHandler");
        return new ThreeDSRequest(viewGroup, str, str2, str3, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreeDSRequest)) {
            return false;
        }
        ThreeDSRequest threeDSRequest = (ThreeDSRequest) obj;
        return Intrinsics.areEqual((Object) this.container, (Object) threeDSRequest.container) && Intrinsics.areEqual((Object) this.challengeUrl, (Object) threeDSRequest.challengeUrl) && Intrinsics.areEqual((Object) this.successUrl, (Object) threeDSRequest.successUrl) && Intrinsics.areEqual((Object) this.failureUrl, (Object) threeDSRequest.failureUrl) && Intrinsics.areEqual((Object) this.resultHandler, (Object) threeDSRequest.resultHandler);
    }

    @NotNull
    public final String getChallengeUrl() {
        return this.challengeUrl;
    }

    @NotNull
    public final ViewGroup getContainer() {
        return this.container;
    }

    @NotNull
    public final String getFailureUrl() {
        return this.failureUrl;
    }

    @NotNull
    public final Function1<ThreeDSResult, Unit> getResultHandler() {
        return this.resultHandler;
    }

    @NotNull
    public final String getSuccessUrl() {
        return this.successUrl;
    }

    public int hashCode() {
        return (((((((this.container.hashCode() * 31) + this.challengeUrl.hashCode()) * 31) + this.successUrl.hashCode()) * 31) + this.failureUrl.hashCode()) * 31) + this.resultHandler.hashCode();
    }

    @NotNull
    public String toString() {
        ViewGroup viewGroup = this.container;
        String str = this.challengeUrl;
        String str2 = this.successUrl;
        String str3 = this.failureUrl;
        Function1<ThreeDSResult, Unit> function1 = this.resultHandler;
        return "ThreeDSRequest(container=" + viewGroup + ", challengeUrl=" + str + ", successUrl=" + str2 + ", failureUrl=" + str3 + ", resultHandler=" + function1 + ")";
    }
}
