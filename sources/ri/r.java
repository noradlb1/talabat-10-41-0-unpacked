package ri;

import android.view.View;
import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.cart.CartFragment;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartFragment f57347b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Result f57348c;

    public /* synthetic */ r(CartFragment cartFragment, Result result) {
        this.f57347b = cartFragment;
        this.f57348c = result;
    }

    public final void onClick(View view) {
        CartFragment.m9778onViewCreated$lambda2$lambda1(this.f57347b, this.f57348c, view);
    }
}
