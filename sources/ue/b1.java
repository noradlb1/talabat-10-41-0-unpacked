package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;

public final /* synthetic */ class b1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57443a;

    public /* synthetic */ b1(CartScreen cartScreen) {
        this.f57443a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57443a.handleFeesDescriptions((FeesDescriptionsDisplayModel) obj);
    }
}
