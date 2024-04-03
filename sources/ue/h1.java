package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;

public final /* synthetic */ class h1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57551a;

    public /* synthetic */ h1(CartScreen cartScreen) {
        this.f57551a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57551a.lambda$observeVoucherStackingError$8((Boolean) obj);
    }
}
