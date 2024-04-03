package com.checkout.threedsecure.utils;

import android.webkit.WebResourceError;
import android.webkit.WebResourceResponse;
import com.checkout.threedsecure.error.ThreeDSError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toThreeDSError", "Lcom/checkout/threedsecure/error/ThreeDSError;", "Landroid/webkit/WebResourceError;", "Landroid/webkit/WebResourceResponse;", "checkout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WebResourcesExtensionKt {
    @NotNull
    public static final ThreeDSError toThreeDSError(@NotNull WebResourceResponse webResourceResponse) {
        Intrinsics.checkNotNullParameter(webResourceResponse, "<this>");
        return new ThreeDSError(String.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getReasonPhrase());
    }

    @Nullable
    public static final ThreeDSError toThreeDSError(@NotNull WebResourceError webResourceError) {
        Intrinsics.checkNotNullParameter(webResourceError, "<this>");
        return new ThreeDSError(String.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription().toString());
    }
}
