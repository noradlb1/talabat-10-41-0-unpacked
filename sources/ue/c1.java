package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;
import com.talabat.feature.fees.presentation.displaymodel.DisclaimerBannerDisplayModel;

public final /* synthetic */ class c1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57459a;

    public /* synthetic */ c1(CartScreen cartScreen) {
        this.f57459a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57459a.handleDisclaimerBannerInfo((DisclaimerBannerDisplayModel) obj);
    }
}
