package u10;

import JsonModels.Response.TransactionDetailsRM;
import com.android.volley.Response;
import library.talabat.mvp.orderconfirmation.OrderConfirmationInteractor;

public final /* synthetic */ class a implements Response.Listener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderConfirmationInteractor f28209b;

    public /* synthetic */ a(OrderConfirmationInteractor orderConfirmationInteractor) {
        this.f28209b = orderConfirmationInteractor;
    }

    public final void onResponse(Object obj) {
        OrderConfirmationInteractor.m7911onThankYouResultRecieved$lambda0(this.f28209b, (TransactionDetailsRM) obj);
    }
}
