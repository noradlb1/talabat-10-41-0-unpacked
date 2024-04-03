package library.talabat.mvp.orderconfirmation;

import JsonModels.TransactionDetailsResponse;
import com.android.volley.VolleyError;
import datamodels.TTransactionResponse;
import kotlin.Metadata;
import library.talabat.mvp.IGlobalListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Llibrary/talabat/mvp/orderconfirmation/OrderConfirmationListener;", "Llibrary/talabat/mvp/IGlobalListener;", "onDataError", "", "onNetworkError", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "onThankYouPageDetailsLoaded", "transactionResponse", "Ldatamodels/TTransactionResponse;", "transactionDetailsResponse", "LJsonModels/TransactionDetailsResponse;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OrderConfirmationListener extends IGlobalListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onDataError(@NotNull OrderConfirmationListener orderConfirmationListener) {
        }

        public static void onNetworkError(@NotNull OrderConfirmationListener orderConfirmationListener) {
        }

        public static void onServerError(@NotNull OrderConfirmationListener orderConfirmationListener, @Nullable VolleyError volleyError) {
        }
    }

    void onDataError();

    void onNetworkError();

    void onServerError(@Nullable VolleyError volleyError);

    void onThankYouPageDetailsLoaded(@Nullable TTransactionResponse tTransactionResponse, @NotNull TransactionDetailsResponse transactionDetailsResponse);
}
