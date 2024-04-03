package library.talabat.mvp.paymenterror;

import datamodels.PaymentError;
import library.talabat.mvp.IGlobalListener;

public interface PaymentErrorListener extends IGlobalListener {
    void onPaymentDetailsReceived(PaymentError paymentError);

    void onPaymentGateDownException(boolean z11);
}
