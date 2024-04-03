package library.talabat.mvp.checkout.checkoutrefactor;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.observability.ObservabilityManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Llibrary/talabat/mvp/checkout/checkoutrefactor/PayProxyManagerPresenter;", "Llibrary/talabat/mvp/checkout/checkoutrefactor/IPayProxyManagerPresenter;", "()V", "payProxyManagerListener", "Llibrary/talabat/mvp/checkout/checkoutrefactor/PayProxyManagerListener;", "checkCVVRequirement", "", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "paymentMethod", "", "setListener", "listener", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyManagerPresenter implements IPayProxyManagerPresenter {
    @Nullable
    private PayProxyManagerListener payProxyManagerListener;

    public void checkCVVRequirement(@NotNull RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        Intrinsics.checkNotNullParameter(recurringPurchaseRequest, "recurringPurchaseRequest");
        String str = recurringPurchaseRequest.cvv;
        Intrinsics.checkNotNullExpressionValue(str, "recurringPurchaseRequest.cvv");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            PayProxyManagerListener payProxyManagerListener2 = this.payProxyManagerListener;
            if (payProxyManagerListener2 != null) {
                payProxyManagerListener2.onSendCVVToProxy(recurringPurchaseRequest, i11);
            }
        } else if (i11 == 4) {
            recurringPurchaseRequest.setIsCVCRequired(Boolean.FALSE);
            PayProxyManagerListener payProxyManagerListener3 = this.payProxyManagerListener;
            if (payProxyManagerListener3 != null) {
                payProxyManagerListener3.onContinueWithAdyenPayment(recurringPurchaseRequest);
            }
        } else if (i11 == 2) {
            recurringPurchaseRequest.setIsCVCRequired(Boolean.FALSE);
            PayProxyManagerListener payProxyManagerListener4 = this.payProxyManagerListener;
            if (payProxyManagerListener4 != null) {
                payProxyManagerListener4.onContinueWithCheckoutDotCom(recurringPurchaseRequest);
            }
        } else {
            ObservabilityManager.trackUnExpectedScenario$default("unexpected payment type", (Map) null, 2, (Object) null);
        }
    }

    public void setListener(@NotNull PayProxyManagerListener payProxyManagerListener2) {
        Intrinsics.checkNotNullParameter(payProxyManagerListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.payProxyManagerListener = payProxyManagerListener2;
    }
}
