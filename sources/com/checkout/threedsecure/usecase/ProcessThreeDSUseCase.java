package com.checkout.threedsecure.usecase;

import android.net.Uri;
import androidx.annotation.RestrictTo;
import com.checkout.base.usecase.UseCase;
import com.checkout.threedsecure.error.ThreeDSError;
import com.checkout.threedsecure.model.ProcessThreeDSRequest;
import com.checkout.threedsecure.model.ThreeDSResult;
import com.checkout.threedsecure.utils.UriExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000f"}, d2 = {"Lcom/checkout/threedsecure/usecase/ProcessThreeDSUseCase;", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/threedsecure/model/ProcessThreeDSRequest;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "()V", "execute", "data", "provideError", "Lcom/checkout/threedsecure/model/ThreeDSResult$Error;", "errorCode", "", "message", "provideToken", "redirectUrl", "Companion", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ProcessThreeDSUseCase implements UseCase<ProcessThreeDSRequest, ThreeDSResult> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY_PAYMENT_TOKEN = "cko-payment-token";
    @NotNull
    @Deprecated
    public static final String KEY_SESSION_ID = "cko-session-id";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/checkout/threedsecure/usecase/ProcessThreeDSUseCase$Companion;", "", "()V", "KEY_PAYMENT_TOKEN", "", "KEY_SESSION_ID", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final ThreeDSResult.Error provideError(String str, String str2) {
        return new ThreeDSResult.Error(new ThreeDSError(str, str2));
    }

    private final String provideToken(String str) {
        if (str == null) {
            return null;
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(it)");
        String queryParameter = parse.getQueryParameter(KEY_PAYMENT_TOKEN);
        if (queryParameter == null) {
            return parse.getQueryParameter(KEY_SESSION_ID);
        }
        return queryParameter;
    }

    @Nullable
    public ThreeDSResult execute(@NotNull ProcessThreeDSRequest processThreeDSRequest) {
        Intrinsics.checkNotNullParameter(processThreeDSRequest, "data");
        Uri parse = Uri.parse(processThreeDSRequest.getRedirectUrl());
        if (UriExtensionKt.matches(Uri.parse(processThreeDSRequest.getSuccessUrl()), parse)) {
            String provideToken = provideToken(processThreeDSRequest.getRedirectUrl());
            if (provideToken == null) {
                return provideError(ThreeDSError.COULD_NOT_EXTRACT_TOKEN, "Url can't be null.");
            }
            return new ThreeDSResult.Success(provideToken);
        } else if (UriExtensionKt.matches(Uri.parse(processThreeDSRequest.getFailureUrl()), parse)) {
            return ThreeDSResult.Failure.INSTANCE;
        } else {
            return null;
        }
    }
}
