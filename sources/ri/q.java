package ri;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.talabat.darkstores.feature.cart.CartFragment;

public final /* synthetic */ class q implements ActivityResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CartFragment f57341a;

    public /* synthetic */ q(CartFragment cartFragment) {
        this.f57341a = cartFragment;
    }

    public final void onActivityResult(Object obj) {
        CartFragment.m9783startForResult$lambda17(this.f57341a, (ActivityResult) obj);
    }
}
