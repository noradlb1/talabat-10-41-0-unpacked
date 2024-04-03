package com.checkout.threedsecure;

import android.content.Context;
import android.webkit.WebView;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.checkout.base.usecase.UseCase;
import com.checkout.threedsecure.error.ThreeDSError;
import com.checkout.threedsecure.logging.ThreeDSLogger;
import com.checkout.threedsecure.model.ProcessThreeDSRequest;
import com.checkout.threedsecure.model.ThreeDSRequest;
import com.checkout.threedsecure.model.ThreeDSResult;
import com.checkout.threedsecure.webview.ThreeDSWebView;
import com.checkout.threedsecure.webview.ThreeDSWebViewClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J7\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0011j\u0002`\u0015H\u0007JI\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0011j\u0002`\u0015H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0002H\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/checkout/threedsecure/ThreeDSExecutor;", "Lcom/checkout/threedsecure/Executor;", "Lcom/checkout/threedsecure/model/ThreeDSRequest;", "processResultUseCase", "Lcom/checkout/base/usecase/UseCase;", "Lcom/checkout/threedsecure/model/ProcessThreeDSRequest;", "Lcom/checkout/threedsecure/model/ThreeDSResult;", "logger", "Lcom/checkout/threedsecure/logging/ThreeDSLogger;", "(Lcom/checkout/base/usecase/UseCase;Lcom/checkout/threedsecure/logging/ThreeDSLogger;)V", "execute", "", "request", "handleError", "error", "Lcom/checkout/threedsecure/error/ThreeDSError;", "resultHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/checkout/threedsecure/model/ThreeDSResultHandler;", "handleResult", "", "url", "", "successUrl", "failureUrl", "provideWebView", "Landroid/webkit/WebView;", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThreeDSExecutor implements Executor<ThreeDSRequest> {
    @NotNull
    private final ThreeDSLogger logger;
    @NotNull
    private final UseCase<ProcessThreeDSRequest, ThreeDSResult> processResultUseCase;

    public ThreeDSExecutor(@NotNull UseCase<ProcessThreeDSRequest, ThreeDSResult> useCase, @NotNull ThreeDSLogger threeDSLogger) {
        Intrinsics.checkNotNullParameter(useCase, "processResultUseCase");
        Intrinsics.checkNotNullParameter(threeDSLogger, "logger");
        this.processResultUseCase = useCase;
        this.logger = threeDSLogger;
    }

    @VisibleForTesting
    public final void handleError(@NotNull ThreeDSError threeDSError, @NotNull Function1<? super ThreeDSResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(threeDSError, "error");
        Intrinsics.checkNotNullParameter(function1, "resultHandler");
        this.logger.logLoadedEvent(false, threeDSError);
        function1.invoke(new ThreeDSResult.Error(threeDSError));
    }

    @VisibleForTesting
    public final boolean handleResult(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Function1<? super ThreeDSResult, Unit> function1) {
        ThreeDSResult.Success success;
        String str4;
        ThreeDSResult.Error error;
        Intrinsics.checkNotNullParameter(str2, "successUrl");
        Intrinsics.checkNotNullParameter(str3, "failureUrl");
        Intrinsics.checkNotNullParameter(function1, "resultHandler");
        ThreeDSResult execute = this.processResultUseCase.execute(new ProcessThreeDSRequest(str, str2, str3));
        if (execute == null) {
            return false;
        }
        ThreeDSLogger threeDSLogger = this.logger;
        boolean z11 = execute instanceof ThreeDSResult.Success;
        ThreeDSError threeDSError = null;
        if (z11) {
            success = (ThreeDSResult.Success) execute;
        } else {
            success = null;
        }
        if (success != null) {
            str4 = success.getToken();
        } else {
            str4 = null;
        }
        if (execute instanceof ThreeDSResult.Error) {
            error = (ThreeDSResult.Error) execute;
        } else {
            error = null;
        }
        if (error != null) {
            threeDSError = error.getError();
        }
        threeDSLogger.logCompletedEvent(z11, str4, threeDSError);
        function1.invoke(execute);
        return true;
    }

    @NotNull
    @VisibleForTesting
    public final WebView provideWebView(@NotNull ThreeDSRequest threeDSRequest) {
        Intrinsics.checkNotNullParameter(threeDSRequest, "request");
        Context context = threeDSRequest.getContainer().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        ThreeDSWebView threeDSWebView = new ThreeDSWebView(context);
        threeDSWebView.setWebViewClient(new ThreeDSWebViewClient(new ThreeDSExecutor$provideWebView$1$1$1(this, threeDSRequest), new ThreeDSExecutor$provideWebView$1$1$2(this, threeDSRequest), this.logger));
        threeDSWebView.loadUrl(threeDSRequest.getChallengeUrl());
        return threeDSWebView;
    }

    public void execute(@NotNull ThreeDSRequest threeDSRequest) {
        Intrinsics.checkNotNullParameter(threeDSRequest, "request");
        threeDSRequest.getContainer().addView(provideWebView(threeDSRequest));
    }
}
