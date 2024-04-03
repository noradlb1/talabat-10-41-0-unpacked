package sf;

import androidx.lifecycle.Observer;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutTokenScreen f57389a;

    public /* synthetic */ a(CheckoutTokenScreen checkoutTokenScreen) {
        this.f57389a = checkoutTokenScreen;
    }

    public final void onChanged(Object obj) {
        this.f57389a.updateBenefitBinVerificationView((DebitCardBinVerificationDisplayModel) obj);
    }
}
