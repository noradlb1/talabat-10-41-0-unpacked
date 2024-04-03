package com.talabat.secure_payment_redirection;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\n"}, d2 = {"com/talabat/secure_payment_redirection/SecurePaymentRedirectionWebViewActivity$initWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "shouldOverrideUrlLoading", "", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SecurePaymentRedirectionWebViewActivity$initWebView$1 extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurePaymentRedirectionWebViewActivity f61357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressBar f61358b;

    public SecurePaymentRedirectionWebViewActivity$initWebView$1(SecurePaymentRedirectionWebViewActivity securePaymentRedirectionWebViewActivity, ProgressBar progressBar) {
        this.f61357a = securePaymentRedirectionWebViewActivity;
        this.f61358b = progressBar;
    }

    public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
        super.onPageFinished(webView, str);
        ProgressBar progressBar = this.f61358b;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
        progressBar.setVisibility(8);
    }

    public boolean shouldOverrideUrlLoading(@NotNull WebView webView, @Nullable String str) {
        boolean z11;
        boolean z12;
        Intrinsics.checkNotNullParameter(webView, "view");
        if (str == null || !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) "THANKYOU", true)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Function0<Unit> onSuccess = SecurePaymentRedirectionCallback.Companion.getInstance().getOnSuccess();
            if (onSuccess != null) {
                onSuccess.invoke();
            }
            this.f61357a.finish();
            return true;
        }
        if (str == null || !StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) Param.ERROR, true)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            return false;
        }
        Function0<Unit> onFailure = SecurePaymentRedirectionCallback.Companion.getInstance().getOnFailure();
        if (onFailure != null) {
            onFailure.invoke();
        }
        this.f61357a.finish();
        return true;
    }
}
