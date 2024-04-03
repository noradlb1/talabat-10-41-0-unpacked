package library.talabat.mvp.checkout.checkoutrefactor;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Llibrary/talabat/mvp/checkout/checkoutrefactor/PayProxyManagerListener;", "", "onContinueWithAdyenPayment", "", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "onContinueWithCheckoutDotCom", "onSendCVVToProxy", "paymentMethod", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PayProxyManagerListener {
    void onContinueWithAdyenPayment(@NotNull RecurringPurchaseRequest recurringPurchaseRequest);

    void onContinueWithCheckoutDotCom(@NotNull RecurringPurchaseRequest recurringPurchaseRequest);

    void onSendCVVToProxy(@NotNull RecurringPurchaseRequest recurringPurchaseRequest, int i11);
}
