package com.talabat.secure_payment_redirection;

import androidx.activity.OnBackPressedCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/talabat/secure_payment_redirection/SecurePaymentRedirectionWebViewActivity$initBackPressCallback$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SecurePaymentRedirectionWebViewActivity$initBackPressCallback$1 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurePaymentRedirectionWebViewActivity f61356a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecurePaymentRedirectionWebViewActivity$initBackPressCallback$1(SecurePaymentRedirectionWebViewActivity securePaymentRedirectionWebViewActivity) {
        super(true);
        this.f61356a = securePaymentRedirectionWebViewActivity;
    }

    public void handleOnBackPressed() {
        Function0<Unit> onClosed = SecurePaymentRedirectionCallback.Companion.getInstance().getOnClosed();
        if (onClosed != null) {
            onClosed.invoke();
        }
        this.f61356a.finish();
    }
}
