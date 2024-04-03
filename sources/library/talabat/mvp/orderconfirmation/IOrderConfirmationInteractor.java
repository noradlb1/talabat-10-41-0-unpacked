package library.talabat.mvp.orderconfirmation;

import kotlin.Metadata;
import library.talabat.mvp.IGlobalInteractor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Llibrary/talabat/mvp/orderconfirmation/IOrderConfirmationInteractor;", "Llibrary/talabat/mvp/IGlobalInteractor;", "getTransactionDetails", "", "transactionId", "", "setOrderConfirmationListener", "listener", "Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationListener;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOrderConfirmationInteractor extends IGlobalInteractor {
    void getTransactionDetails(@Nullable String str);

    void setOrderConfirmationListener(@NotNull OrderConfirmationListener orderConfirmationListener);
}
