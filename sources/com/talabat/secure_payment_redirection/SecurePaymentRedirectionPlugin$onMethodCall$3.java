package com.talabat.secure_payment_redirection;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SecurePaymentRedirectionPlugin$onMethodCall$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f61355g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecurePaymentRedirectionPlugin$onMethodCall$3(MethodChannel.Result result) {
        super(0);
        this.f61355g = result;
    }

    public final void invoke() {
        try {
            this.f61355g.error("closeByUserInteraction", "User canceled payment authorization", (Object) null);
        } catch (Exception unused) {
        }
    }
}
