package library.talabat.mvp.checkout.checkoutrefactor;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/checkout/checkoutrefactor/ICheckoutRefactorPresenter;", "", "onDebitPaymentMethodUrlUpdated", "", "onDebitPaymentShown", "", "paymentUrl", "onSelectingDebitCardPaymentMethod", "onSettingDebitCardPaymentMethodLabel", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICheckoutRefactorPresenter {
    @NotNull
    String onDebitPaymentMethodUrlUpdated();

    void onDebitPaymentShown(@NotNull String str);

    void onSelectingDebitCardPaymentMethod();

    void onSettingDebitCardPaymentMethodLabel();
}
