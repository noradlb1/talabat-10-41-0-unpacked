package library.talabat.mvp.paymenterror;

import buisnessmodels.TalabatFormatter;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import datamodels.PaymentError;

public class PaymentErrorPresenter implements IPaymentErrorPresenter, PaymentErrorListener {
    private IPaymentErrorInteractor iPaymentErrorInteractor;
    private boolean isFromVisaCheckout;
    private boolean isGateWayError;
    private PaymentErrorView paymentErrorView;
    private int paymentMethod = 1;
    private String transactionId;
    private String url;

    public PaymentErrorPresenter(AppVersionProvider appVersionProvider, PaymentErrorView paymentErrorView2) {
        this.paymentErrorView = paymentErrorView2;
        this.iPaymentErrorInteractor = new PaymentErrorInteractor(appVersionProvider, this);
    }

    public void onDataError() {
        this.paymentErrorView.onDataError();
        this.paymentErrorView.dismissProgressLayout();
    }

    public void onDestroy() {
        this.paymentErrorView = null;
        IPaymentErrorInteractor iPaymentErrorInteractor2 = this.iPaymentErrorInteractor;
        if (iPaymentErrorInteractor2 != null) {
            iPaymentErrorInteractor2.unregister();
        }
        this.iPaymentErrorInteractor = null;
    }

    public void onNetworkError() {
        this.paymentErrorView.onNetworkError();
        this.paymentErrorView.dismissProgressLayout();
    }

    public void onPaymentDetailsReceived(PaymentError paymentError) {
        this.paymentErrorView.dismissProgressLayout();
        this.paymentErrorView.setPaymentErrorDescription(this.isGateWayError, paymentError.result);
        if (this.isGateWayError) {
            this.paymentErrorView.setDetailsVisibility(false);
            return;
        }
        this.paymentErrorView.setDetailsVisibility(true);
        this.paymentErrorView.setTransactionAmount(TalabatFormatter.getInstance().getFormattedCurrency(paymentError.amt));
        this.paymentErrorView.setTransactionAuthID(paymentError.authId);
        this.paymentErrorView.setTransactionDate(paymentError.transdate);
        this.paymentErrorView.setTransactionID(paymentError.transactionId);
        this.paymentErrorView.setTransactionPaymentID(paymentError.paymentId);
        this.paymentErrorView.setTransactionReferenceID(paymentError.referenceId);
        this.paymentErrorView.setTransactionResult(paymentError.result);
        this.paymentErrorView.setTransactionTrackID(paymentError.trackId);
    }

    public void onPaymentGateDownException(boolean z11) {
        this.paymentErrorView.dismissProgressLayout();
        this.paymentErrorView.setPaymentErrorDescription(z11, "");
        this.paymentErrorView.setDetailsVisibility(false);
    }

    public void onServerError(VolleyError volleyError) {
        this.paymentErrorView.onServerError(volleyError);
        this.paymentErrorView.dismissProgressLayout();
    }

    public void setUpViews(String str, String str2, boolean z11, boolean z12, String str3, boolean z13) {
        this.transactionId = str3;
        this.isFromVisaCheckout = z13;
        if (z12) {
            this.paymentErrorView.setPaymentErrorDescription(z11, "");
            this.paymentErrorView.setDetailsVisibility(true);
            this.iPaymentErrorInteractor.loadTransactionDetails(str3 + "/0");
            this.paymentErrorView.dismissProgressLayout();
        } else if (z13) {
            this.paymentErrorView.setPaymentErrorDescription(z11, "");
            this.paymentErrorView.setDetailsVisibility(true);
            this.iPaymentErrorInteractor.loadTransactionDetails(str3 + "/0");
            this.paymentErrorView.dismissProgressLayout();
        } else {
            this.url = str;
            this.iPaymentErrorInteractor.loadTransactionDetails(str2);
            this.isGateWayError = z11;
        }
    }
}
