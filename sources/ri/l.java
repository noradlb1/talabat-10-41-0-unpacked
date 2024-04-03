package ri;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.cart.CartFragment;

public final /* synthetic */ class l implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartFragment f57319a;

    public /* synthetic */ l(CartFragment cartFragment) {
        this.f57319a = cartFragment;
    }

    public final void onChanged(Object obj) {
        CartFragment.m9777onViewCreated$lambda2(this.f57319a, (Result) obj);
    }
}
