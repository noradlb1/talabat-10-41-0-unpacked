package library.talabat.mvp.paymenterror;

import com.talabat.helpers.Talabat;

public interface PaymentErrorView extends Talabat {
    void dismissProgressLayout();

    void onRedirectToPaymentScreen(String str, int i11);

    void setDetailsVisibility(boolean z11);

    void setPaymentErrorDescription(boolean z11, String str);

    void setTransactionAmount(String str);

    void setTransactionAuthID(String str);

    void setTransactionDate(String str);

    void setTransactionID(String str);

    void setTransactionPaymentID(String str);

    void setTransactionReferenceID(String str);

    void setTransactionResult(String str);

    void setTransactionTrackID(String str);
}
