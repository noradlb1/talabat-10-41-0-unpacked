package ri;

import androidx.lifecycle.Observer;
import com.talabat.darkstores.feature.cart.CartListAdapter;
import java.util.List;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartListAdapter f57316a;

    public /* synthetic */ k(CartListAdapter cartListAdapter) {
        this.f57316a = cartListAdapter;
    }

    public final void onChanged(Object obj) {
        this.f57316a.submitList((List) obj);
    }
}
