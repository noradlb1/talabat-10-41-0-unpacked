package ue;

import androidx.lifecycle.Observer;
import com.talabat.CartScreen;

public final /* synthetic */ class g1 implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartScreen f57536a;

    public /* synthetic */ g1(CartScreen cartScreen) {
        this.f57536a = cartScreen;
    }

    public final void onChanged(Object obj) {
        this.f57536a.lambda$observeApiResponses$9((Boolean) obj);
    }
}
