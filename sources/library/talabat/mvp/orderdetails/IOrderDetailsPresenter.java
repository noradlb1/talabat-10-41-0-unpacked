package library.talabat.mvp.orderdetails;

import datamodels.OrderDetails;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalPresenter;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Llibrary/talabat/mvp/orderdetails/IOrderDetailsPresenter;", "Llibrary/talabat/mvp/IGlobalPresenter;", "onAttach", "", "orderDetails", "Ldatamodels/OrderDetails;", "encryptedOrderId", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IOrderDetailsPresenter extends IGlobalPresenter {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onAttach$default(IOrderDetailsPresenter iOrderDetailsPresenter, OrderDetails orderDetails, String str, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    orderDetails = null;
                }
                if ((i11 & 2) != 0) {
                    str = null;
                }
                iOrderDetailsPresenter.onAttach(orderDetails, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttach");
        }
    }

    void onAttach(@Nullable OrderDetails orderDetails, @Nullable String str);
}
